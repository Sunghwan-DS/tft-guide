package jsh.tftguide.recommend.application;

import jsh.tftguide.recommend.domain.RecommendChampion;
import jsh.tftguide.recommend.domain.RecommendRequest;

import java.util.List;

public interface RecommendService {
    List<RecommendChampion> getBestChampions(RecommendRequest request);
}
