package api.trivia.open.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetQuestionResponse {
    private String id;
    private String category;
    private String question;
    private String type;
    private List<String> choices;
    private String answer;
}
