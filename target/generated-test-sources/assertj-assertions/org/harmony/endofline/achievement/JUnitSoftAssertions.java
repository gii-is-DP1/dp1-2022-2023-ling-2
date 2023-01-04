package org.harmony.endofline.achievement;

/**
 * Like {@link SoftAssertions} but as a junit rule that takes care of calling
 * {@link SoftAssertions#assertAll() assertAll()} at the end of each test.
 * <p>
 * Example:
 * <pre><code class='java'> public class SoftlyTest {
 *
 *     &#064;Rule
 *     public final JUnitBDDSoftAssertions softly = new JUnitBDDSoftAssertions();
 *
 *     &#064;Test
 *     public void soft_bdd_assertions() throws Exception {
 *       softly.assertThat(1).isEqualTo(2);
 *       softly.assertThat(Lists.newArrayList(1, 2)).containsOnly(1, 2);
 *       // no need to call assertAll(), this is done automatically.
 *     }
 *  }</code></pre>
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public class JUnitSoftAssertions extends org.assertj.core.api.JUnitSoftAssertions {

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.achievement.AchievementAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.achievement.AchievementAssert assertThat(org.harmony.endofline.achievement.Achievement actual) {
    return proxy(org.harmony.endofline.achievement.AchievementAssert.class, org.harmony.endofline.achievement.Achievement.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.achievement.AchievementconditsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.achievement.AchievementconditsAssert assertThat(org.harmony.endofline.achievement.Achievement.condits actual) {
    return proxy(org.harmony.endofline.achievement.AchievementconditsAssert.class, org.harmony.endofline.achievement.Achievement.condits.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.achievement.AchievementControllerAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.achievement.AchievementControllerAssert assertThat(org.harmony.endofline.achievement.AchievementController actual) {
    return proxy(org.harmony.endofline.achievement.AchievementControllerAssert.class, org.harmony.endofline.achievement.AchievementController.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.achievement.AchievementControllerTestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.achievement.AchievementControllerTestAssert assertThat(org.harmony.endofline.achievement.AchievementControllerTest actual) {
    return proxy(org.harmony.endofline.achievement.AchievementControllerTestAssert.class, org.harmony.endofline.achievement.AchievementControllerTest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.achievement.AchievementRepositoryAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.achievement.AchievementRepositoryAssert assertThat(org.harmony.endofline.achievement.AchievementRepository actual) {
    return proxy(org.harmony.endofline.achievement.AchievementRepositoryAssert.class, org.harmony.endofline.achievement.AchievementRepository.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.achievement.AchievementServiceAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.achievement.AchievementServiceAssert assertThat(org.harmony.endofline.achievement.AchievementService actual) {
    return proxy(org.harmony.endofline.achievement.AchievementServiceAssert.class, org.harmony.endofline.achievement.AchievementService.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.achievement.AchievementServiceTestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.achievement.AchievementServiceTestAssert assertThat(org.harmony.endofline.achievement.AchievementServiceTest actual) {
    return proxy(org.harmony.endofline.achievement.AchievementServiceTestAssert.class, org.harmony.endofline.achievement.AchievementServiceTest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.achievement.InvalidAchievementNameExeptionAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.achievement.InvalidAchievementNameExeptionAssert assertThat(org.harmony.endofline.achievement.InvalidAchievementNameExeption actual) {
    return proxy(org.harmony.endofline.achievement.InvalidAchievementNameExeptionAssert.class, org.harmony.endofline.achievement.InvalidAchievementNameExeption.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.friendRequest.RequestFriendRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.friendRequest.RequestFriendRequestAssert assertThat(org.harmony.endofline.friendRequest.FriendRequest actual) {
    return proxy(org.harmony.endofline.friendRequest.RequestFriendRequestAssert.class, org.harmony.endofline.friendRequest.FriendRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.friendRequest.RequestFriendRequestControllerAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.friendRequest.RequestFriendRequestControllerAssert assertThat(org.harmony.endofline.friendRequest.FriendRequestController actual) {
    return proxy(org.harmony.endofline.friendRequest.RequestFriendRequestControllerAssert.class, org.harmony.endofline.friendRequest.FriendRequestController.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.friendRequest.RequestFriendRequestRepositoryAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.friendRequest.RequestFriendRequestRepositoryAssert assertThat(org.harmony.endofline.friendRequest.FriendRequestRepository actual) {
    return proxy(org.harmony.endofline.friendRequest.RequestFriendRequestRepositoryAssert.class, org.harmony.endofline.friendRequest.FriendRequestRepository.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.harmony.endofline.friendRequest.RequestFriendRequestServiceAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public org.harmony.endofline.friendRequest.RequestFriendRequestServiceAssert assertThat(org.harmony.endofline.friendRequest.FriendRequestService actual) {
    return proxy(org.harmony.endofline.friendRequest.RequestFriendRequestServiceAssert.class, org.harmony.endofline.friendRequest.FriendRequestService.class, actual);
  }

}
