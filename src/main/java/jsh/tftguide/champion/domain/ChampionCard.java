package jsh.tftguide.champion.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class ChampionCard {

    private static final String IMG_FILE_PATH = "img/champion/";

    private long championId;
    private String championName;
    private int cost;
    private List<String> synergies;
    private String imgUrl;

    public static ChampionCard convert(Champion champion) {
        return ChampionCard.builder()
                           .championId(champion.getId())
                           .championName(champion.getName())
                           .cost(champion.getCost())
                           .synergies(champion.getSynergyNames())
                           .imgUrl(IMG_FILE_PATH + champion.getImageFileName() + ".png")
                           .build();
    }
}
