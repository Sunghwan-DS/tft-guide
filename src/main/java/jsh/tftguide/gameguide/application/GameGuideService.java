package jsh.tftguide.gameguide.application;

import jsh.tftguide.gameguide.controller.GameGuideRequest;
import jsh.tftguide.gameguide.controller.GameGuideResponse;

public interface GameGuideService {

    GameGuideResponse getGameGuide(GameGuideRequest request);
}
