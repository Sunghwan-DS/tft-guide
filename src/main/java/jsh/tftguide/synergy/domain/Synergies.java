package jsh.tftguide.synergy.domain;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class Synergies {

    private static final String PATH = "csv/synergies.csv";
    public static final Map<Long, Synergy> synergiesMap;

    static {
        synergiesMap = readCSV().stream()
                                .collect(Collectors.toMap(i1 -> i1.getId(),
                                                          i2 -> i2)
                                );
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SneakyThrows
    public static List<Synergy> readCSV() {
        try {
            return
                new CsvToBeanBuilder(
                    new InputStreamReader(
                        new ClassPathResource(PATH).getInputStream()))
                    .build().
                    parse();
        } catch (Exception e) {
            log.error("{}", e.toString());
        }
        return List.of();
    }
}
