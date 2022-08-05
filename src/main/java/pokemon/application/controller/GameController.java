package pokemon.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GameController {

    @GetMapping("/check")
    public String checkStatus(){
        return "Server works";
    }
}
