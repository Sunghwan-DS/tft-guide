package jsh.tftguide.champion.domain;

import com.opencsv.bean.CsvBindByPosition;
import jsh.tftguide.synergy.domain.Synergy;
import lombok.Data;

import java.util.List;

@Data
public class Champion {

    @CsvBindByPosition(position = 0)
    private final long id;
    @CsvBindByPosition(position = 1)
    private final String name;
    @CsvBindByPosition(position = 2)
    private final long cost;
    @CsvBindByPosition(position = 3)
    private final String synergiesStr;
    @CsvBindByPosition(position = 4)
    private final long value;
    private final List<Synergy> synergies;
}
