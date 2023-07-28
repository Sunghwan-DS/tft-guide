package jsh.tftguide.recommend;

import jsh.tftguide.champion.domain.Champion;
import jsh.tftguide.champion.domain.Champions;
import jsh.tftguide.recommend.application.RecommendService;
import jsh.tftguide.synergy.domain.Synergies;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static jsh.tftguide.champion.domain.Champions.CHAMPION_MAP;

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
    }

    @Test
    @DisplayName("getBestChampions Test")
    public void getBestChampionsTest() {

        List<Champion> useChampions = List.of(CHAMPION_MAP.get(1L), CHAMPION_MAP.get(7L), CHAMPION_MAP.get(14L), CHAMPION_MAP.get(18L), CHAMPION_MAP.get(30L));
        var recommendChampionList = recommendService.getBestChampions(useChampions, 6);
        System.out.println(recommendChampionList.toString());
    }
}
