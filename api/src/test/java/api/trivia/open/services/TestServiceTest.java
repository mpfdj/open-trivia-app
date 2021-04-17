package api.trivia.open.services;


import api.trivia.open.configurations.Application;
import api.trivia.open.model.es.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        Question question = testService.test();
        System.out.println(question);
    }

}
