package jsh.tftguide;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static jsh.tftguide.champion.domain.Champions.CHAMPION_MAP;

@Controller
public class PageController {

    @GetMapping("/tft-guide")
    public String main() {
        return "main";
    }

    @GetMapping("/board")
    public String board(Model model) {

        model.addAttribute("champions", CHAMPION_MAP.values().stream().toList());


        return "board";
    }
}
