package api.trivia.open.controllers;

import api.trivia.open.model.es.Question;
import api.trivia.open.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public Question test() {

        return testService.test();
    }

}