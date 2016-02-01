package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.regex.*;

/**
 *
 * For mentions, look for @ char, and word after that is a mention
 * for URL, https
 * for topic #
 *
 * username rules:
 * Only alphanumeric characters and underscores
 * Your username cannot be longer than 15 characters.
 *
 * hashtag rules:
 *
 *
 *
 * Created by aksharkumar on 1/28/16.
 */
public class Message {

    private String message;
    private HashMap<String, Integer> mentions= new HashMap<String, Integer>();
    private HashMap<String, Integer> URLs = new HashMap<String, Integer>(); //maybe store in a map for multiple mentions
    private HashMap<String, Integer> topics = new HashMap<String, Integer>();  //store in map for multiple topics


    public Message(String message){
        this.message = message;
    }

    public void parseMessage(){
        final String mentionRegex = "[@]+([A-Za-z0-9-_]+)"; //looks for mention symbol followed by letters and numbers
        final String hashtagRegex = "[#]+([A-Za-z]+[A-Za-z0-9-_]*)";
        final String urlRegex = "\"^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]\"";

        String result = "";

        Pattern mentionPattern = Pattern.compile(mentionRegex);
        Pattern hashtagPattern = Pattern.compile(hashtagRegex);
        Pattern urlPattern = Pattern.compile(urlRegex);

        Matcher mentionMatcher = mentionPattern.matcher(message);
        Matcher hashtagMatcher = hashtagPattern.matcher(message);
        Matcher urlMatcher = urlPattern.matcher(message);
        //finds mentions
       while(mentionMatcher.find()){
           result = mentionMatcher.group();
           result = result.replace("@", "");
           if(result.length()<=15) mentions.put(result, 1);
       }
        //finds topics
        while(hashtagMatcher.find()){
            result = hashtagMatcher.group();
            result = result.replace("#", "");
            topics.put(result,1);
        }
        //need to implement finding URLs
        while(urlMatcher.find()){
            result = urlMatcher.group();
            URLs.put(result, 1);
        }
    }

    public int numMentions(){
        return mentions.size();
    }
    public int numTopics(){
        return topics.size();
    }
    public int numURLS(){
        return URLs.size();
    }

    public Boolean containsMention(final String mention){
        if(mentions.containsKey(mention)) return true;
        return false;
    }
    public Boolean containsTopic(final String topic){
        if(topics.containsKey(topic)) return true;
        return false;
    }
    public Boolean containsURL(final String URL){
        if(URLs.containsKey(URL)) return true;
        return false;
    }

}
