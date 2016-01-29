package main;

/**
 * Created by aksharkumar on 1/28/16.
 */
public class Message {
    private String message;
    private String mention; //maybe store in a list for multiple mentions
    private String URL;    //maybe store in list for multiple URLs
    private String topic;  //store in list for multiple topics

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

    private Boolean containsMention(){}
    private Boolean containsTopic(){}
    private Boolean containsURL(){}

}
