package test;

import model.Message;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class for message class. Tests messages with valid and invalide mentions, topics, and urls.
 * Also tests example messages with multiple mentions, topics, and urls in one.
 *
 * Created by aksharkumar on 1/29/16.
 */
public class MessageTest {

    private Message message;

    //mention tests
    @Test
    public void testContainsMention(){
        message = new Message("@akshar @kumar");
        assertEquals(2, message.numMentions());
        assertTrue(message.containsMention("akshar"));
        assertTrue(message.containsMention("kumar"));
    }
    @Test
    public void testInvalidMentions(){
        message = new Message("@skdjeudsoytishtdsyssssssssssssss @$%^&*! @alphanumeric_1");
        assertEquals(1, message.numMentions());
        assertTrue(message.containsMention("alphanumeric_1"));
    }

    //topic tests
    @Test
    public void testContainsTopic(){
        message = new Message("#werock");
        assertEquals(1, message.numTopics());
        assertTrue(message.containsTopic("werock"));
    }

    @Test
    public void testInvalidTopics(){
        message = new Message("#onetwothree #!$%^&*+. #123 #@$!#4342 #jumpman23");
        assertEquals(2, message.numTopics());
        assertTrue(message.containsTopic("onetwothree"));
        assertTrue(message.containsTopic("jumpman23"));
    }

    //url tests
    @Test
    public void testContainsURL(){
        message = new Message("http://www.twitter.com");
        assertEquals(1, message.numURLS());
        assertTrue(message.containsURL("http://www.twitter.com"));
    }
    @Test
    public void testInvalidURL(){
        message = new Message("htt:/www.message http://123456789 http://www.paypal.com");
        assertEquals(1, message.numURLS());
        assertTrue(message.containsURL("http://www.paypal.com"));
    }

    //examples
    @Test
    public void testExampleMessage(){
        message = new Message("@peter check out this new joke I saw #cantstoplaughing");
        assertEquals(1, message.numMentions());
        assertEquals(1, message.numTopics());
        assertTrue(message.containsMention("peter"));
        assertTrue(message.containsTopic("cantstoplaughing"));
        assertFalse(message.containsTopic("jokesfordays"));
    }

    @Test
    public void testExampleMessage2(){
        message = new Message("What a game @michaeljordan - replay of your #game-winner http://www.youtube.com");
        assertEquals(1, message.numMentions());
        assertEquals(1, message.numTopics());
        assertEquals(1, message.numURLS());
        assertTrue(message.containsMention("michaeljordan"));
        assertTrue(message.containsTopic("game-winner"));
        assertTrue(message.containsURL("http://www.youtube.com"));
    }

    @Test
    public void testExampleMessageMultiple(){
        message = new Message("@akshar @kumar @michaeljordan #chicago #best http://www.twitter.com https://www.amazon.com");
        assertEquals(3, message.numMentions());
        assertEquals(2, message.numTopics());
        assertEquals(2, message.numURLS());
        assertTrue(message.containsMention("akshar"));
        assertTrue(message.containsMention("kumar"));
        assertTrue(message.containsMention("michaeljordan"));
        assertTrue(message.containsTopic("chicago"));
        assertTrue(message.containsTopic("best"));
        assertTrue(message.containsURL("http://www.twitter.com"));
        assertTrue(message.containsURL("https://www.amazon.com"));
    }
    @Test
    public void testExampleMixInvalidValid(){
        message = new Message("@supercalifragilisticexpialidocious @harold @kumar go to #whitecastle #123456 http:www.youtube.com/falsejourney http://www.youtube.com/realjourney");
        assertEquals(2, message.numMentions());
        assertEquals(1, message.numTopics());
        assertEquals(1, message.numURLS());
        assertFalse(message.containsMention("supercalifragilisticexpialidocious"));
        assertTrue(message.containsMention("harold"));
        assertTrue(message.containsMention("kumar"));
        assertTrue(message.containsTopic("whitecastle"));
        assertFalse(message.containsTopic("123456"));
        assertFalse(message.containsURL("http:www.youtube.com/falsejourney"));
        assertTrue(message.containsURL("http://www.youtube.com/realjourney"));
    }
}