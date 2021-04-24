package api.trivia.open.services;

import api.trivia.open.configurations.Application;
import api.trivia.open.model.es.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class OpenTriviaServiceTest {

    @Autowired
    private OpenTriviaService openTriviaService;

    @Test
    public void testGetCategories() {
        List<String> categories = openTriviaService.getCategories();
        System.out.println(categories);
    }

    @Test
    public void testGetQuestionByCategory() {
        Question question = openTriviaService.getQuestionByCategory("music");
        System.out.println(question);
    }

    @Test
    public void testGetQuestionById() {
        Question question = openTriviaService.getQuestionById("20342");
        System.out.println(question);
    }

}