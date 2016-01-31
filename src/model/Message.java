package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.regex.*;

/**
 * Created by aksharkumar on 1/28/16.
 */
public class Message {

    private String message;
    private HashMap<String, Integer> mentions= new HashMap<String, Integer>();
    private HashMap<String, Integer> URLs = new HashMap<String, Integer>(); //maybe store in a map for multiple mentions
    private HashMap<String, Integer> topics = new HashMap<String, Integer>();  //store in map for multiple topics

    /**
     * For mentions, look for @ char, and word after that is a mention
     * for URL, https
     * for topic #
     *
     * Implement simple then move to edge cases.
     */
    public Message(String message){
        this.message = message;
    }

    public void parseMessage(){
        final String mentionRegex = "[@]+([A-Za-z0-9-_]+)"; //looks for mention symbol followed by letters and numbers
        final String hashtagRegex = "[#] + ([A-Za-z0-9-_]+)";
        final String urlRegex = "";

        String result = "";

        Pattern mentionPattern = Pattern.compile(mentionRegex);
        Pattern hashtagPattern = Pattern.compile(hashtagRegex);

        Matcher mentionMatcher = mentionPattern.matcher(message);
        Matcher hashtagMatcher = hashtagPattern.matcher(message);

       if (mentionMatcher.find()){
           result = mentionMatcher.group();
           result = result.replace("@", "");
           mentions.put(result, 1);
       }
    }
    public Boolean containsMention(){
        if(!mentions.isEmpty()) return true;
        return false;
    }
    public Boolean containsTopic(){
        if(!topics.isEmpty()) return true;
        return false;
    }
    public Boolean containsURL(){
        if(!URLs.isEmpty()) return true;
        return false;
    }

}
