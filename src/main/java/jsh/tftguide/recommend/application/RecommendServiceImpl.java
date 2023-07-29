package jsh.tftguide.recommend.application;

import jsh.tftguide.champion.domain.Champion;
import jsh.tftguide.champion.domain.ChampionCard;
import jsh.tftguide.recommend.domain.AddChampionResult;
import jsh.tftguide.recommend.domain.RecommendChampion;
import jsh.tftguide.recommend.domain.RecommendRequest;
import jsh.tftguide.synergy.application.SynergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static jsh.tftguide.champion.domain.Champions.CHAMPION_MAP;
import static jsh.tftguide.champion.domain.Reroll.RerollMap;

@RequiredArgsConstructor
@Service
public class RecommendServiceImpl implements RecommendService {

    public static AddChampionResult bestChampionResult;
    private final SynergyService synergyService;

    @Override
    public List<RecommendChampion> getBestChampions(RecommendRequest request) {

        if (request.getLevel() == request.getChampions().size()) {
            return List.of();
        }

        var useChampionIdSet = request.getChampions().stream()
                                      .map(Champion::getId)
                                      .collect(Collectors.toSet());
        var useSynergySet = synergyService.getSynergySetByChampionIdSet(useChampionIdSet);

        bestChampionResult = AddChampionResult.emptyOf();
        addBestChampion(useChampionIdSet, request.getLevel(), AddChampionResult.emptyOf());

        Set<Long> addChampionIdSet = new HashSet<>();
        addChampionIdSet.addAll(useChampionIdSet);
        addChampionIdSet.addAll(bestChampionResult.getAddChampionIdSet());

        var additionalSynergiesSet = synergyService.getSynergySetByChampionIdSet(addChampionIdSet);
        additionalSynergiesSet.removeAll(useSynergySet);
        var additionalSynergies = additionalSynergiesSet.stream()
                                                        .toList();

        return List.of(RecommendChampion.builder()
                                        .recommendChampions(bestChampionResult.getAddChampionIdSet()
                                                                              .stream()
                                                                              .map(championId -> ChampionCard.convert(CHAMPION_MAP.get(championId)))
                                                                              .toList())
                                        .additionalSynergies(additionalSynergies)
                                        .aceChampion(null)
                                        .build());

//        return bestChampionResult.getAddChampionIdSet()
//                                 .stream()
//                                 .map(championId -> CHAMPION_MAP.get(championId))
//                                 .toList();
    }

    private void addBestChampion(Set<Long> useChampionSet, int level, AddChampionResult result) {
        if (result.getAddChampionIdSet().size() + useChampionSet.size() == level) {
            compareBestSet(useChampionSet, result);
            return;
        }

        CHAMPION_MAP.values()
                    .stream()
                    .filter(champion -> champion.getCost() <= RerollMap.get(level).getRecommendValidationCost())
                    .filter(champion -> !useChampionSet.contains(champion.getId()) && !result.getAddChampionIdSet().contains(champion.getId()))
                    .forEach(champion -> nextStep(useChampionSet, level, result, champion));

    }

    private void nextStep(Set<Long> useChampionSet, int level, AddChampionResult result, Champion champion) {
        result.getAddChampionIdSet().add(champion.getId());
        addBestChampion(useChampionSet, level, result);
        result.getAddChampionIdSet().remove(champion.getId());
    }

    private void compareBestSet(Set<Long> useChampionSet, AddChampionResult result) {

        Map<String, Long> synergyResultMap = new HashMap<>();
        CHAMPION_MAP.values()
                    .stream()
                    .filter(champion -> useChampionSet.contains(champion.getId()) || result.getAddChampionIdSet().contains(champion.getId()))
                    .forEach(champion -> updateSynergyResultMap(synergyResultMap, champion));

        result.setTier(synergyService.calculateTier(synergyResultMap));

        if (bestChampionResult.getTier() < result.getTier()) {
            bestChampionResult = AddChampionResult.deepCopy(result);
        }
    }

    private void updateSynergyResultMap(Map<String, Long> synergyResultMap, Champion champion) {
        var championList = champion.getSynergyNames();

        champion.getSynergyNames().stream().forEach(synergyName -> updateSynergy(synergyResultMap, synergyName));
    }

    private void updateSynergy(Map<String, Long> synergyResultMap, String synergyName) {
        if (synergyResultMap.containsKey(synergyName)) {
            var count = synergyResultMap.get(synergyName);
            synergyResultMap.put(synergyName, count + 1);
        } else {
            synergyResultMap.put(synergyName, 1L);
        }
    }
}
