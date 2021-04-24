package api.trivia.open.services;

import api.trivia.open.model.es.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenTriviaDelegate {

    @Autowired
    private OpenTriviaService openTriviaService;
    
    public boolean isAnswerOk(String id, String answerFromUser) {
        Question question = openTriviaService.getQuestionById(id);

        String answer = question.getAnswer();

        return answer.equals(answerFromUser);
    }

}
