package jsh.tftguide.item.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum ItemType {

    AD("01"),
    AP("02"),
    DEF("03");

    private final String code;
    public static final Map<String, ItemType> itemTypeMap;

    static {
        itemTypeMap = new HashMap<>();
    }
}
