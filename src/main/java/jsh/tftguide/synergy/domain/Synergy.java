package jsh.tftguide.synergy.domain;

import jsh.tftguide.champion.domain.Champion;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Synergy {

    private final long id;
    private final String name;
    private final List<Champion> champions;
    private final long value;
}
