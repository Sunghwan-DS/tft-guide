package jsh.tftguide.recommend.domain;

import jsh.tftguide.champion.domain.Champion;
import jsh.tftguide.gameguide.controller.GameGuideRequest;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class RecommendRequest {

    int level;
    boolean hasAdItem;
    boolean hasApItem;
    boolean hasDefItem;
    List<Champion> champions;

    public static RecommendRequest convert(GameGuideRequest request, List<Champion> champions) {
        return RecommendRequest.builder()
                               .level(request.getLevel())
                               .hasAdItem("Y".equals(request.getAdItemYn()))
                               .hasApItem("Y".equals(request.getApItemYn()))
                               .hasDefItem("Y".equals(request.getDefItemYn()))
                               .champions(champions)
                               .build();
    }


}
