package api.trivia.open.services;

import api.trivia.open.configurations.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class OpenTriviaDelegateTest {

    @Autowired
    private OpenTriviaDelegate openTriviaDelegate;

    @Test
    public void testIsAnswerOk() {
        // Question(id=20928, category=music, question=Which song from the musical The Music Man is performed by an ensemble?, type=multiple-choice, answer=Iowa Stubborn, choices=[Till There Was You, Iowa Stubborn, Marian the Librarian, My White Knight])
        boolean result = openTriviaDelegate.isAnswerOk("20928", "Iowa Stubborn");
        System.out.println(result);

    }

}