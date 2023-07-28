package jsh.tftguide.item.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Items {

    private static final Map<Long, Item> items;

    static {
        items = new HashMap<>();
    }
}
