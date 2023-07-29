package jsh.tftguide.gameguide.application;

import jsh.tftguide.champion.application.ChampionService;
import jsh.tftguide.champion.domain.ChampionCard;
import jsh.tftguide.gameguide.controller.GameGuideRequest;
import jsh.tftguide.gameguide.controller.GameGuideResponse;
import jsh.tftguide.recommend.application.RecommendService;
import jsh.tftguide.recommend.domain.RecommendRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameGuideServiceImpl implements GameGuideService {

    private final ChampionService championService;
    private final RecommendService recommendService;

    @Override
    public GameGuideResponse getChampionsGuide(GameGuideRequest request) {

        var recommendRequest = RecommendRequest.convert(request, championService.getChampionsByChampionNos(request.getChampionNos()));
        var result = recommendService.getBestChampions(recommendRequest);

        return GameGuideResponse.convert(result, recommendRequest.getChampions()
                                                                 .stream()
                                                                 .map(champion -> ChampionCard.convert(champion))
                                                                 .toList());
    }
}
