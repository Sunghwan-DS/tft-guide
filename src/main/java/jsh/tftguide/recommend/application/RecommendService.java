package jsh.tftguide.recommend.application;

import jsh.tftguide.champion.domain.Champion;

import java.util.List;

public interface RecommendService {
    List<Champion> getBestChampions(List<Champion> champions, long level);
}
