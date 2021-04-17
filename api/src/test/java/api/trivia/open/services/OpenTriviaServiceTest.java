package api.trivia.open.services;

import api.trivia.open.configurations.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class OpenTriviaServiceTest {

    @Autowired
    private OpenTriviaService openTriviaService;

    @Test
    public void getCategories() throws IOException {
        List<String> categories = openTriviaService.getCategories();
        System.out.println(categories);
    }
}