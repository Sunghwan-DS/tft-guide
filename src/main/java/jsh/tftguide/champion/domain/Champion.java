package jsh.tftguide.champion.domain;

import com.opencsv.bean.CsvBindByPosition;
import jsh.tftguide.synergy.domain.Synergy;
import lombok.Data;

import java.util.List;

@Data
public class Champion {

    @CsvBindByPosition(position = 0)
    private long id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private long cost;
    @CsvBindByPosition(position = 3)
    private String synergiesStr;
    @CsvBindByPosition(position = 4)
    private long value;
    private List<Synergy> synergies;
}
