package api.trivia.open.services;

import api.trivia.open.model.es.EmptyPage;
import api.trivia.open.model.es.Question;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.search.aggregations.AggregationBuilders.terms;

@Service
public class OpenTriviaService {

// https://www.baeldung.com/spring-data-elasticsearch-queries
// https://www.baeldung.com/elasticsearch-java
// https://docs.spring.io/spring-data/elasticsearch/docs/4.1.5/reference/html/#reference
// https://github.com/spring-projects/spring-data-elasticsearch
// http://www.yiidian.com/sources/java_source/org.elasticsearch.search.aggregations.BucketOrder.html
// https://stackoverflow.com/questions/63413269/elasticsearch-spring-boot
// https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-query-builders.html

    private static final String ES_INDEX = "open-trivia";

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    public List<String> getCategories() {
        List<String> result = new ArrayList<>();

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .addAggregation(terms("categories").field("category").order(BucketOrder.key(true)))
                .withPageable(EmptyPage.INSTANCE)
                .build();

        SearchHits<Question> searchHits = elasticsearchOperations.search(searchQuery, Question.class, IndexCoordinates.of(ES_INDEX));

        ParsedStringTerms categories = searchHits.getAggregations().get("categories");

        List<? extends Terms.Bucket> buckets = categories.getBuckets();

        buckets.forEach(bucket -> result.add((String) bucket.getKey()));

        // We do a sort in the ES query
        // Collections.sort(result);

        return result;
    }


    public Question getQuestionByCategory(String category) {

        MatchQueryBuilder matchQuery = matchQuery("category", category);
        PageRequest pageRequest = PageRequest.of(1,1);

        FunctionScoreQueryBuilder functionScore = QueryBuilders.functionScoreQuery(matchQuery, ScoreFunctionBuilders.randomFunction());

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(functionScore)
                .withPageable(pageRequest)
                .build();

        SearchHits<Question> searchHits = elasticsearchOperations.search(searchQuery, Question.class, IndexCoordinates.of(ES_INDEX));

        return searchHits.getSearchHits().get(0).getContent();
    }


    public Question getQuestionById(String id) {

        MatchQueryBuilder matchQuery = matchQuery("_id", id);

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery)
                .build();

        SearchHits<Question> searchHits = elasticsearchOperations.search(searchQuery, Question.class, IndexCoordinates.of(ES_INDEX));

        return searchHits.getSearchHits().get(0).getContent();

    }


}
