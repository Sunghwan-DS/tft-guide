package jsh.tftguide.item.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PartItem {

    private final long id;
    private final String name;
    private final ItemType itemType;
}
