package jsh.tftguide.item.domain;

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
public class Items {

    private static final String PATH = "csv/items.csv";
    public static Map<Long, Item> items;

    static {
        items = readCSV().stream()
                         .collect(Collectors.toMap(i1 -> i1.getId(),
                                                   i2 -> i2)
                         );
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SneakyThrows
    public static List<Item> readCSV() {
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
