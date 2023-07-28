package jsh.tftguide.synergy;

import jsh.tftguide.synergy.domain.Synergies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static jsh.tftguide.synergy.domain.Synergies.SYNERGY_MAP;

@Tag("integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SynergyServiceTest {

    @BeforeAll
    public void setup() {
        Synergies.loadSyergiesInfo();
    }

    @Test
    @DisplayName("Read synergies.csv")
    void readChampionsTest() {
        Assertions.assertEquals(SYNERGY_MAP.get(1L).getName(), "공허");
    }
}
