package com.nju.edu.multiAgent;

import java.util.ArrayList;

public class Message {
    private String senderId;
    private String receiver;
    private String performative;
    private ArrayList<String> content; //ArrayList<String> content ? // TODO: 2019-02-05

    private static final int REQUIRE_INFORMATION=1;


    public Message(String senderId, String receiver, String performative, ArrayList<String> content) {
        this.senderId = senderId;
        this.receiver = receiver;
        this.performative = performative;
        this.content = content;
    }

    public Message createReply(){
        return new Message(receiver, senderId, performative, content);
    }



    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPerformative() {
        return performative;
    }

    public void setPerformative(String performative) {
        this.performative = performative;
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }

}
