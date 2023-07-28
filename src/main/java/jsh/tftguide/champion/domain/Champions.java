package jsh.tftguide.champion.domain;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class Champions {

    private static final String PATH = "static/csv/champions.csv";
    public static Map<Long, Champion> CHAMPION_MAP;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SneakyThrows
    public static List<Champion> readCSV() {
        try {
            return
                new CsvToBeanBuilder(
                    new InputStreamReader(
                        new ClassPathResource(PATH).getInputStream()))
                    .withType(Champion.class)
                    .withSkipLines(1)
                    .build().
                    parse();
        } catch (Exception e) {
            log.error("{}", e.toString());
        }
        return List.of();
    }

    public static void loadChampionsInfo() {
        var csv = readCSV();
        CHAMPION_MAP = csv.stream()
                          .collect(Collectors.toMap(i1 -> i1.getId(),
                                                    i2 -> i2)
                          );
    }

    @EventListener(ApplicationReadyEvent.class)
    public void generateChampionsInfo() {
        loadChampionsInfo();
    }
}
