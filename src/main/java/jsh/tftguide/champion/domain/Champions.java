package jsh.tftguide.champion.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Champions {

    public static final Map<Long, Champion> championMap;

    static {
        championMap = new HashMap<>();
    }
}
