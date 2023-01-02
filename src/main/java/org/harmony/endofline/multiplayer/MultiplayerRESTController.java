package org.harmony.endofline.multiplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/multiplayerREST")
public class MultiplayerRESTController {
    private final MultiplayerService multiplayerService;

    @Autowired
    public MultiplayerRESTController(MultiplayerService multiplayerService) {
        this.multiplayerService = multiplayerService;
    }

    @GetMapping("queueStatus")
    public Boolean checkPublicGameIsReady(){
        return true;
    }
}
