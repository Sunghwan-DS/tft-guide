package jsh.tftguide.gameguide.controller;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class GameGuideRequest {

    int level;
    String adItemYn;
    String apItemYn;
    String defItemYn;
    String championNos;
}
