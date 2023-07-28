package jsh.tftguide.recommend.domain;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class AddChampionResult {

    private Set<Long> addChampionIdSet;
    private long value;
    private long tier;

    public static AddChampionResult emptyOf() {
        return AddChampionResult.builder()
                                .addChampionIdSet(new HashSet<>())
                                .value(0L)
                                .tier(0L)
                                .build();
    }

    public static AddChampionResult deepCopy(AddChampionResult result) {
        return AddChampionResult.builder()
                                .addChampionIdSet(Set.copyOf(result.getAddChampionIdSet()))
                                .value(result.getValue())
                                .tier(result.getTier())
                                .build();
    }
}
