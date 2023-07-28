package jsh.tftguide.champion.domain;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private List<String> synergies;

    public List<String> getSynergyNames() {
        return Arrays.asList(synergiesStr.split("\\|"));
    }
}
