package model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by aksharkumar on 1/28/16.
 */
public class Message {

    private String message;
    private List<String> mentions= new ArrayList<String>();
    private List<String> URLs = new ArrayList<String>(); //maybe store in a list for multiple mentions
    private List<String> topics = new ArrayList<String>();  //store in list for multiple topics

    /**
     * For mentions, look for @ char, and word after that is a mention
     * for URL, https
     * for topic #
     *
     * Implement simple then move to edge cases.
     */
    private Message(String message){
        this.message = message;
    }

    private Boolean containsMention(){
        return false;
    }
    private Boolean containsTopic(){
        return false;
    }
    private Boolean containsURL(){
        return false;
    }

}
