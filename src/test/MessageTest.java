package test;

import model.Message;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by aksharkumar on 1/29/16.
 */
public class MessageTest {

    private Message message;

    @Test
    public void testContainsMention(){
        message = new Message("@akshar @kumar");
        message.parseMessage();
        assertTrue(message.containsMention());
    }

    @Test
    public void testContainsTopic(){
        message = new Message("#werock");
        message.parseMessage();
        assertTrue(message.containsTopic());
    }


}