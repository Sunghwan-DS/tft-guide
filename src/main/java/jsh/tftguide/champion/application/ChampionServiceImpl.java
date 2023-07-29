package jsh.tftguide.champion.application;

import jsh.tftguide.champion.domain.Champion;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static jsh.tftguide.champion.domain.Champions.CHAMPION_MAP;

@Slf4j
@Service
public class ChampionServiceImpl implements ChampionService {

    @Override
    public List<Champion> getChampionsByChampionNos(String championNos) {

        try {

            if (championNos.isEmpty()) {
                return List.of();
            }

            return Arrays.stream(championNos.split(","))
                         .map(str -> CHAMPION_MAP.get(Long.parseLong(str))).toList();
        } catch (Exception e) {
            log.error("getChampionsByChampionNos error : {}", ExceptionUtils.getStackTrace(e));
        }
        return List.of();
    }
}
