package jsh.tftguide.champion.domain;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Champion {

    @CsvBindByPosition(position = 0)
    private long id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private int cost;
    @CsvBindByPosition(position = 3)
    private String synergiesStr;
    @CsvBindByPosition(position = 4)
    private long value;
    @CsvBindByPosition(position = 5)
    private String imageFileName;
    private String imageFilePath = "img/champion/";

    public List<String> getSynergyNames() {
        return Arrays.asList(synergiesStr.split("\\|"));
    }
}
