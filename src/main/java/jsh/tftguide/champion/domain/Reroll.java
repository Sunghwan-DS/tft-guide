package jsh.tftguide.champion.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Reroll {

    ONE(1, 1, 0, 0, 0, 0, 2),
    TWO(2, 1, 0, 0, 0, 0, 2),
    THREE(3, 0.75, 0.25, 0, 0, 0, 3),
    FOUR(4, 0.55, 0.30, 0.15, 0, 0, 4),
    FIVE(5, 0.45, 0.33, 0.20, 0.02, 0, 4),
    SIX(6, 0.25, 0.40, 0.30, 0.05, 0, 4),
    SEVEN(7, 0.19, 0.30, 0.35, 0.15, 0.01, 5),
    EIGHT(8, 0.16, 0.20, 0.35, 0.25, 0.04, 5),
    NINE(9, 0.9, 0.15, 0.30, 0.30, 0.16, 5),
    TEN(10, 0.05, 0.10, 0.20, 0.40, 0.25, 5),
    ELEVEN(11, 0.01, 0.02, 0.12, 0.50, 0.30, 5);

    private final int level;
    private final double costOneRate;
    private final double costTwoRate;
    private final double costThreeRate;
    private final double costFourRate;
    private final double costFiveTate;
    private final int recommendValidationCost;

    public static final Map<Integer, Reroll> REROLL_MAP = Stream.of(values()).collect(Collectors.toMap(Reroll::getLevel, e -> e));;

    public static Reroll levelOf(int level) {
        return REROLL_MAP.get(level);
    }
}
