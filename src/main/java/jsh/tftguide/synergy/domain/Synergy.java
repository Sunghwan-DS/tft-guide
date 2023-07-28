package jsh.tftguide.synergy.domain;

import com.opencsv.bean.CsvBindByPosition;
import jsh.tftguide.champion.domain.Champion;
import lombok.Data;

import java.util.List;

@Data
public class Synergy {

    @CsvBindByPosition(position = 0)
    private long id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private long count;
    @CsvBindByPosition(position = 3)
    private long value;
    private List<Champion> champions;
}
