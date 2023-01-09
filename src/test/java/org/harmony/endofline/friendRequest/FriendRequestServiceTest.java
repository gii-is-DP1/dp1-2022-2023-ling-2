package org.harmony.endofline.friendRequest;

import org.harmony.endofline.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class FriendRequestServiceTest {
    @Autowired
    FriendRequestService friendRequestService;
    @Autowired
    FriendRequestRepository friendRequestRepository;
    @Autowired
    UserService userService;

    @Test
    public void findByIdWorks() throws InvalidFriendRequestException {
        FriendRequest fr = new FriendRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        fr = friendRequestRepository.save(fr);
        assertThat(friendRequestService.findById(fr.getId()))
            .isEqualTo(fr);
    }

    @Test
    public void findByUsersWorks() {
        FriendRequest fr = new FriendRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        friendRequestRepository.save(fr);
        assertThat(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")))
                .isEqualTo(fr);
    }

    @Test
    public void isReceiverOfRequestWorks() throws InvalidFriendRequestException {
        FriendRequest fr = new FriendRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        friendRequestRepository.save(fr);
        assertThrows(InvalidFriendRequestException.class, () -> friendRequestService.isReceiverOfRequest(userService.findByUsername("admin"), fr));
    }

    @Test
    public void sendToNonFriend() throws InvalidFriendRequestException {
        friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        assertThat(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user"))).isNotNull();
    }

    @Test
    public void sendToNonFriendIsPending() throws InvalidFriendRequestException {
        friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        assertThat(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")).getState()).isEqualTo(FriendRequestState.PENDING);
    }

    @Test
    public void sendToOneself() {
        InvalidFriendRequestException exception = assertThrows(InvalidFriendRequestException.class, () -> {
            friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("admin"));
        });
        assertEquals("Cannot send a friend request to yourself", exception.getMessage());
    }

    @Test
    public void sendToFriend() throws InvalidFriendRequestException {
        friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        friendRequestService.acceptRequest(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")));
        InvalidFriendRequestException exception = assertThrows(InvalidFriendRequestException.class, () -> {
            friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        });
        assertEquals("You are already friends with this user", exception.getMessage());
    }

    @Test
    public void sendToFriendIsPending() throws InvalidFriendRequestException {
        friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        assertThat(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")).getState()).isEqualTo(FriendRequestState.PENDING);
        InvalidFriendRequestException exception = assertThrows(InvalidFriendRequestException.class, () -> {
            friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        });
        assertEquals("Ongoing friend request with this user", exception.getMessage());
    }

    @Test
    public void acceptRequest() throws InvalidFriendRequestException {
        friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        friendRequestService.acceptRequest(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")));
        assertThat(userService.findByUsername("admin").getFriends()).contains(userService.findByUsername("user"));
    }

    @Test
    public void acceptRequestIsAccepted() throws InvalidFriendRequestException {
        friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        friendRequestService.acceptRequest(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")));
        assertThat(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")).getState()).isEqualTo(FriendRequestState.ACCEPTED);
    }

    @Test
    public void rejectRequest() throws InvalidFriendRequestException {
        friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        friendRequestService.rejectRequest(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")));
        assertThat(userService.findByUsername("admin").getFriends()).doesNotContain(userService.findByUsername("user"));
    }

    @Test
    public void rejectRequestIsRejected() throws InvalidFriendRequestException {
        friendRequestService.newRequest(userService.findByUsername("admin"), userService.findByUsername("user"));
        friendRequestService.rejectRequest(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")));
        assertThat(friendRequestService.findByUsers(userService.findByUsername("admin"), userService.findByUsername("user")).getState()).isEqualTo(FriendRequestState.REJECTED);
    }
}
