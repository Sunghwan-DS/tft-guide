package jsh.tftguide.item.domain;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class Item {

    @CsvBindByPosition(position = 0)
    private long id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private ItemType itemType;
}
