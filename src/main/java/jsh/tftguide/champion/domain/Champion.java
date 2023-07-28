package jsh.tftguide.champion.domain;

import jsh.tftguide.synergy.domain.Synergy;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Champion {

    private final long id;
    private final String name;
    private final long cost;
    private final List<Synergy> synergies;
    private final long value;
}
