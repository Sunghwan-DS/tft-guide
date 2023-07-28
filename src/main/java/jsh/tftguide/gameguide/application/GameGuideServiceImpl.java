package jsh.tftguide.gameguide.application;

import jsh.tftguide.champion.application.ChampionService;
import jsh.tftguide.gameguide.controller.GameGuideRequest;
import jsh.tftguide.gameguide.controller.GameGuideResponse;
import jsh.tftguide.recommend.application.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameGuideServiceImpl implements GameGuideService {

    private final ChampionService championService;
    private final RecommendService recommendService;

    @Override
    public GameGuideResponse getGameGuide(GameGuideRequest request) {

        var champions = championService.getChampionsByChampionNos(request.getChampionNos());
        var recommendChampions = recommendService.getBestChampions(champions, request.getLevel());

        return new GameGuideResponse();
    }
}
