package jsh.tftguide;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/tft-guide")
    public String main() {
        return "main";
    }
}
