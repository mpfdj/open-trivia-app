package api.trivia.open.controllers;

import api.trivia.open.model.api.GetQuestionResponse;
import api.trivia.open.model.api.IsAnswerOkRequest;
import api.trivia.open.model.es.Question;
import api.trivia.open.services.OpenTriviaDelegate;
import api.trivia.open.services.OpenTriviaService;
import api.trivia.open.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private TestService testService;

    @Autowired
    private OpenTriviaService openTriviaService;

    @Autowired
    private OpenTriviaDelegate openTriviaDelegate;

    @GetMapping("/test")
    public Question test() {
        return testService.test();
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return openTriviaService.getCategories();
    }

    @GetMapping("/get-question")
    public GetQuestionResponse getQuestion(@RequestParam String category) {
        Question question = openTriviaService.getQuestionByCategory(category);

        // Filter out the answer
        GetQuestionResponse getQuestionResponse = GetQuestionResponse.builder()
                .id(question.getId())
                .category(question.getCategory())
                .question(question.getQuestion())
                .type(question.getType())
                .choices(question.getChoices())
                .build();

        return getQuestionResponse;
    }

    @PostMapping("/is-answer-ok")
    public boolean isAnswerOk(@RequestBody IsAnswerOkRequest request) {
        String id = request.getId();
        String answer = request.getAnswer();
        return openTriviaDelegate.isAnswerOk(id, answer);
    }


    @GetMapping("/get-questions")
    public List<GetQuestionResponse> getQuestions(@RequestParam String category, @RequestParam int amount){
        List<GetQuestionResponse> response = new ArrayList<>();

        List<Question> questions = openTriviaService.getQuestionsByCategory(category, amount);

        questions.forEach(q ->{
            GetQuestionResponse result = GetQuestionResponse.builder()
                    .id(q.getId())
                    .category(q.getCategory())
                    .question(q.getQuestion())
                    .type(q.getType())
                    .choices(q.getChoices())
                    .answer(q.getAnswer())
                    .build();
            response.add(result);
        });

        return response;
    }




}