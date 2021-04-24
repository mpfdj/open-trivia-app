package api.trivia.open.model.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetQuestionResponse {
    private String id;
    private String category;
    private String question;
    private String type;
    private List<String> choices;
}
