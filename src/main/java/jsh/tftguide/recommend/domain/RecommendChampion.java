package jsh.tftguide.recommend.domain;

import jsh.tftguide.champion.domain.Champion;
import jsh.tftguide.synergy.domain.Synergy;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class RecommendChampion {

    List<Champion> recommendChampions;
    List<Synergy> additionalSynergies;
    Champion aceChampion;
}
