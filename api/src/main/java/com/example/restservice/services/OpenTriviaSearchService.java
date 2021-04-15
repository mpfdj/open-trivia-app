package com.example.restservice.services;

import com.example.restservice.model.es.Question;
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
public class OpenTriviaSearchService {

    private static final String ES_INDEX = "open-trivia";

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    public Question testESGetADoc() {
        String query = new JsonBuilder(new GsonAdapter())
                .object("query_string")
                .object("query", "3")
                .object("fields").array(new String[]{"_id"})
                .build().toString();

        Query searchQuery = new StringQuery(query);

        SearchHits<Question> questions = elasticsearchOperations.search(
                searchQuery,
                Question.class,
                IndexCoordinates.of(ES_INDEX));

        return questions.getSearchHit(0).getContent();
    }


}
