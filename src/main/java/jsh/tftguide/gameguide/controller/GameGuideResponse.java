package jsh.tftguide.gameguide.controller;

import jsh.tftguide.champion.domain.ChampionCard;
import jsh.tftguide.gameguide.domain.GameGuideStatus;
import jsh.tftguide.recommend.domain.RecommendChampion;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class GameGuideResponse {

    GameGuideStatus status;
    List<ChampionCard> useChampions;
    List<RecommendChampion> recommendChampions;

    public static GameGuideResponse convert(List<RecommendChampion> result, List<ChampionCard> champions) {
        return GameGuideResponse.builder()
                                .status(result.size() > 0 ? GameGuideStatus.SUCCESS : GameGuideStatus.NOT_FOUND)
                                .useChampions(champions)
                                .recommendChampions(result).build();
    }
}
