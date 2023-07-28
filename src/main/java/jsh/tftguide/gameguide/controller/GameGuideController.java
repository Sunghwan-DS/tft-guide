package jsh.tftguide.gameguide.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GameGuideController {

    @GetMapping("/guide")
    public GameGuideResponse getGameGuide(GameGuideRequest request) {

        return new GameGuideResponse();
    }

}
