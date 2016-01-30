package test;

import model.Message;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by aksharkumar on 1/29/16.
 */
public class MessageTest {

    private Message message;

    @Before
    public void setUp() throws Exception {
        message = new Message("Test Message");
    }

    @After
    public void tearDown() throws Exception {
        message = null;
    }

    @Test
    public void testContainsMention(){
        assertFalse(message.containsMention());
    }


}