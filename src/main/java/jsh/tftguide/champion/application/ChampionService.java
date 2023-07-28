package jsh.tftguide.champion.application;

import jsh.tftguide.champion.domain.Champion;

import java.util.List;

public interface ChampionService {
    List<Champion> getChampionsByChampionNos(String championNos);
}
