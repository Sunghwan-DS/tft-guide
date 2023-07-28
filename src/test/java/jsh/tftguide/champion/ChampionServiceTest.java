package jsh.tftguide.champion;

import jsh.tftguide.champion.domain.Champions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static jsh.tftguide.champion.domain.Champions.CHAMPION_MAP;

@Tag("integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChampionServiceTest {

    @BeforeAll
    public void setup() {
        Champions.loadChampionsInfo();
    }

    @Test
    @DisplayName("Read champions.csv")
    void readChampionsTest() {
        Assertions.assertEquals(CHAMPION_MAP.get(1L).getName(), "가렌");
    }
}
