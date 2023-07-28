package jsh.tftguide.synergy.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Synergies {

    public static final Map<Long, Synergy> synergiesMap;

    static {
        synergiesMap = new HashMap<>();
    }
}
