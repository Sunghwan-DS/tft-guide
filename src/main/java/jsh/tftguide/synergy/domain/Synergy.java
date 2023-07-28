package jsh.tftguide.synergy.domain;

import com.opencsv.bean.CsvBindByPosition;
import jsh.tftguide.champion.domain.Champion;
import lombok.Data;

import java.util.List;

@Data
public class Synergy {

    @CsvBindByPosition(position = 0)
    private final long id;
    @CsvBindByPosition(position = 1)
    private final String name;
    @CsvBindByPosition(position = 2)
    private final long count;
    @CsvBindByPosition(position = 3)
    private final long value;
    private final List<Champion> champions;
}
