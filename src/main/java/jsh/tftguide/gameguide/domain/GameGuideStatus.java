package jsh.tftguide.gameguide.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GameGuideStatus {

    SUCCESS(200, "성공", ""),
    NOT_FOUND(404, "조회 실패", "추천할 챔피언이 없습니다");

    private final int code;
    private final String message;
    private final String detailMessage;
}
