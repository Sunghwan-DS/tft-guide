package jsh.tftguide.gameguide;

import jsh.tftguide.champion.domain.Champions;
import jsh.tftguide.champion.domain.Reroll;
import jsh.tftguide.gameguide.application.GameGuideService;
import jsh.tftguide.gameguide.controller.GameGuideRequest;
import jsh.tftguide.synergy.domain.Synergies;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Tag("integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class GameGuideControllerTest {

    @Autowired
    GameGuideService gameGuideService;

    @BeforeAll
    public void setup() {
        Champions.loadChampionsInfo();
        Synergies.loadSyergiesInfo();
    }

    @Test
    @DisplayName("GameGuideController getChampionGuide Test")
    public void getChampionsGuideTest() {

        var request = GameGuideRequest.builder()
                                      .level(5)
                                      .adItemYn("N")
                                      .apItemYn("N")
                                      .defItemYn("N")
                                      .championNos("43,38,37,18")
                                      .build();

        var response = gameGuideService.getChampionsGuide(request);
        System.out.println(response);

    }
}
