package api.trivia.open.services;

import api.trivia.open.model.es.Question;
import api.trivia.open.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.jsonbuilder.JsonBuilder;
import org.jsonbuilder.implementations.gson.GsonAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    private static final String ES_INDEX = "open-trivia";

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    public Question test() {
        String query = new JsonBuilder(new GsonAdapter())
                .object("query_string")
                .object("query", "3")
                .object("fields").array(new String[]{"_id"})
                .build().toString();

        log.info(Util.toPrettyFormat(query));

        Query searchQuery = new StringQuery(query);

        SearchHits<Question> questions = elasticsearchOperations.search(searchQuery, Question.class, IndexCoordinates.of(ES_INDEX));

        Question question = questions.getSearchHit(0).getContent();

        log.info(question.toString());

        return question;
    }


}
