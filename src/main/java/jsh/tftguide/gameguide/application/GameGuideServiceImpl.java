package jsh.tftguide.gameguide.application;

import jsh.tftguide.champion.application.ChampionService;
import jsh.tftguide.gameguide.controller.GameGuideRequest;
import jsh.tftguide.gameguide.controller.GameGuideResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameGuideServiceImpl implements GameGuideService {

    private final ChampionService championService;

    @Override
    public GameGuideResponse getGameGuide(GameGuideRequest request) {

        return new GameGuideResponse();
    }
}
