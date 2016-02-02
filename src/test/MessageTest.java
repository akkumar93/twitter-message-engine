package test;

import model.Message;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by aksharkumar on 1/29/16.
 */
public class MessageTest {

    private Message message;

    //mention tests
    @Test
    public void testContainsMention(){
        message = new Message("@akshar @kumar");
        message.parseMessage();
        assertEquals(2, message.numMentions());
        assertTrue(message.containsMention("akshar"));
        assertTrue(message.containsMention("kumar"));
    }
    @Test
    public void testInvalidMentions(){
        message = new Message("@skdjeudsoytishtdsyssssssssssssss @$%^&*! @alphanumeric_1");
        message.parseMessage();
        assertEquals(1, message.numMentions());
    }

    //topic tests
    @Test
    public void testContainsTopic(){
        message = new Message("#werock");
        message.parseMessage();
        assertEquals(1, message.numTopics());
        assertTrue(message.containsTopic("werock"));
    }

    @Test
    public void testInvalidTopics(){
        message = new Message("#onetwothree #!$%^&*+. #123 #@$!#4342 #jumpman23");
        message.parseMessage();
        assertEquals(2, message.numTopics());
    }
    //url tests
    @Test
    public void testContainsURL(){
        message = new Message("http://www.twitter.com");
        message.parseMessage();
        assertEquals(1, message.numURLS());
        assertTrue(message.containsURL("http://www.twitter.com"));
    }
    @Test
    public void testInvalidURL(){
        message = new Message("htt:/www.message http://123456789 http://www.paypal.com");
        message.parseMessage();
        assertEquals(1, message.numURLS());
    }
    //examples
    @Test
    public void testExampleMessage(){
        message = new Message("@peter check out this new joke I saw #cantstoplaughing");
        message.parseMessage();
        assertEquals(1, message.numMentions());
        assertEquals(1, message.numTopics());
        assertTrue(message.containsMention("peter"));
        assertTrue(message.containsTopic("cantstoplaughing"));
        assertFalse(message.containsTopic("jokesfordays"));
    }

    @Test
    public void testExampleMessage2(){
        message = new Message("What a game @michaeljordan - replay of your #game-winner http://www.youtube.com");
        message.parseMessage();
        assertEquals(1, message.numMentions());
        assertEquals(1, message.numTopics());
        assertEquals(1, message.numURLS());
        assertTrue(message.containsMention("michaeljordan"));
        assertTrue(message.containsTopic("game-winner"));
        assertTrue(message.containsURL("http://www.youtube.com"));
    }
}