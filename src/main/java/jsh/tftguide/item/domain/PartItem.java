package jsh.tftguide.item.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PartItem {

    private long id;
    private String name;
    private ItemType itemType;
}
