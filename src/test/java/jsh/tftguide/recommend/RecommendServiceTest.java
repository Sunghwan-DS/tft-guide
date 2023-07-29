package jsh.tftguide.recommend;

import jsh.tftguide.champion.domain.Champion;
import jsh.tftguide.champion.domain.Champions;
import jsh.tftguide.champion.domain.Reroll;
import jsh.tftguide.recommend.application.RecommendService;
import jsh.tftguide.recommend.domain.RecommendRequest;
import jsh.tftguide.synergy.domain.Synergies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static jsh.tftguide.champion.domain.Champions.CHAMPION_MAP;
import static jsh.tftguide.champion.domain.Champions.CHAMPION_NAME_MAP;

@Tag("integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class RecommendServiceTest {

    @Autowired
    RecommendService recommendService ;

    @BeforeAll
    public void setup() {
        Champions.loadChampionsInfo();
        Synergies.loadSyergiesInfo();
        Reroll.loadRerollInfo();
    }

    @Test
    @DisplayName("getBestChampions Test")
    public void getBestChampionsTest() {

        List<Champion> useChampions = List.of(CHAMPION_NAME_MAP.get("사미라"), CHAMPION_NAME_MAP.get("진"), CHAMPION_NAME_MAP.get("이렐리아"), CHAMPION_NAME_MAP.get("워윅"));
        var recommendRequest = RecommendRequest.builder().level(5).champions(useChampions).build();
        var recommendChampionList = recommendService.getBestChampions(recommendRequest);
        System.out.println(recommendChampionList.toString());
        Assertions.assertEquals(recommendChampionList.get(0).getRecommendChampions().get(0).getName(), "세트");
    }
}
