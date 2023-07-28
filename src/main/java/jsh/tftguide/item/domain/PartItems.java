package jsh.tftguide.item.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PartItems {

    public static final Map<Long, PartItem> partItemMap;

    static {
        partItemMap = new HashMap<>();
    }
}
