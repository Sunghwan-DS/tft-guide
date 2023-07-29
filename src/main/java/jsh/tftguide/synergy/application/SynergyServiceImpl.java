package jsh.tftguide.synergy.application;

import jsh.tftguide.synergy.domain.Synergy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static jsh.tftguide.champion.domain.Champions.CHAMPION_MAP;
import static jsh.tftguide.synergy.domain.Synergies.SYNERGY_MAP;

@Service
public class SynergyServiceImpl implements SynergyService {

    @Override
    public long calculateTier(Map<String, Long> synergyResultMap) {

        return synergyResultMap.entrySet()
                        .stream()
                        .mapToLong(e -> findMaxTier(e.getKey(), e.getValue()))
                        .sum();
    }

    private long findMaxTier(String synergyName, long count) {

        return SYNERGY_MAP.values()
                          .stream()
                          .filter(synergy -> synergy.getName().equals(synergyName))
                          .filter(synergy -> synergy.getCount() <= count)
                          .mapToLong(synergy -> synergy.getTier())
                          .max()
                          .orElse(0L);
    }

    @Override
    public Set<Synergy> getSynergySetByChampionIdSet(Set<Long> useChampionIdSet) {
        Map<String, Integer> synergyCountMap = new HashMap<>();

        for (Long championId : useChampionIdSet) {
            var synergyNames = CHAMPION_MAP.get(championId).getSynergyNames();

            for (String synergyName : synergyNames) {
                if (synergyCountMap.containsKey(synergyName)) {
                    synergyCountMap.put(synergyName, synergyCountMap.get(synergyName) + 1);
                } else {
                    synergyCountMap.put(synergyName, 1);
                }
            }
        }
        Set<Synergy> synergySet = SYNERGY_MAP.values()
                                             .stream()
                                             .filter(synergy -> synergyCountMap.containsKey(synergy.getName()) && synergyCountMap.get(synergy.getName()) >= synergy.getCount())
                                             .collect(Collectors.toSet());

        return synergySet;
    }
}
