package jsh.tftguide.item.domain;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class Item {

    @CsvBindByPosition(position = 0)
    private final long id;
    @CsvBindByPosition(position = 1)
    private final String name;
    @CsvBindByPosition(position = 2)
    private final ItemType itemType;
}
