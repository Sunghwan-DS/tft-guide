package jsh.tftguide.gameguide.controller;

import jsh.tftguide.gameguide.application.GameGuideService;
import jsh.tftguide.recommend.domain.RecommendRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/guide")
@RequiredArgsConstructor
@RestController
public class GameGuideController {

    @Autowired
    GameGuideService gameGuideService;

    @GetMapping("/champions")
    public GameGuideResponse getChampionsGuide(GameGuideRequest request) {

        return gameGuideService.getChampionsGuide(request);
    }

}
