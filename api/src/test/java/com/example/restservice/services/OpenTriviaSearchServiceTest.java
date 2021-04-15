package com.example.restservice.services;


import com.example.restservice.configurations.RestServiceApplication;
import com.example.restservice.model.es.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestServiceApplication.class)
public class OpenTriviaSearchServiceTest {

    @Autowired
    private OpenTriviaSearchService openTriviaSearchService;

    @Test
    public void testESGetADoc() {
        Question question = openTriviaSearchService.testESGetADoc();
        System.out.println(question);
    }

}
