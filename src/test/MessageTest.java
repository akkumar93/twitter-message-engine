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



}