package jsh.tftguide.synergy.application;

import org.springframework.stereotype.Service;

import java.util.Map;

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
}
