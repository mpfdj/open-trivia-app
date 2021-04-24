package api.trivia.open.model.api;

import lombok.Data;

@Data
public class IsAnswerOkRequest {
    private String id;
    private String answer;

}
