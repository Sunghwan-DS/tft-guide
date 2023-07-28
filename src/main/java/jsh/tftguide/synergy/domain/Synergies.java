package jsh.tftguide.synergy.domain;

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
public class Synergies {

    private static final String PATH = "static/csv/synergies.csv";
    public static Map<Long, Synergy> SYNERGY_MAP;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SneakyThrows
    public static List<Synergy> readCSV() {
        try {
            return
                new CsvToBeanBuilder(
                    new InputStreamReader(
                        new ClassPathResource(PATH).getInputStream()))
                    .withType(Synergy.class)
                    .withSkipLines(1)
                    .build()
                    .parse();
        } catch (Exception e) {
            log.error("{}", e.toString());
        }
        return List.of();
    }

    public static void loadSyergiesInfo() {
        var csv = readCSV();
        SYNERGY_MAP = csv.stream()
                         .collect(Collectors.toMap(i1 -> i1.getId(),
                                                   i2 -> i2)
                         );
    }

    @EventListener(ApplicationReadyEvent.class)
    public void generateSynergiesInfo() {
        loadSyergiesInfo();
    }
}
