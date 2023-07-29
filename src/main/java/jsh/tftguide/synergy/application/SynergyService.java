package jsh.tftguide.synergy.application;

import jsh.tftguide.synergy.domain.Synergy;

import java.util.Map;
import java.util.Set;

public interface SynergyService {
    long calculateTier(Map<String, Long> synergyResultMap);

    Set<Synergy> getSynergySetByChampionIdSet(Set<Long> useChampionIdSet);
}
