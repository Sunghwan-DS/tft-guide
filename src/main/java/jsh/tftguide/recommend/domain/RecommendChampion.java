package jsh.tftguide.recommend.domain;

import jsh.tftguide.champion.domain.Champion;
import jsh.tftguide.champion.domain.ChampionCard;
import jsh.tftguide.synergy.domain.Synergy;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class RecommendChampion {

    List<ChampionCard> recommendChampions;
    List<Synergy> additionalSynergies;
    Champion aceChampion;
    String imgFilePath;
}
