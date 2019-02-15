package com.nju.edu.multiAgent.agent;

import com.nju.edu.multiAgent.Message;

import java.util.ArrayList;
import java.util.Stack;

abstract public class Agent {

    private double point; //个人积分
    private ArrayList<String> researchAreas; //研究领域
    private ArrayList<String> interestAreads; //兴趣领域


    void sendMessage(Message message, Agent agent) {
        agent.receiveMessage(message);
    }

    abstract void receiveMessage(Message message);

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public ArrayList<String> getResearchAreas() {
        return researchAreas;
    }

    public void setResearchAreas(ArrayList<String> researchAreas) {
        this.researchAreas = researchAreas;
    }

    public ArrayList<String> getInterestAreads() {
        return interestAreads;
    }

    public void setInterestAreads(ArrayList<String> interestAreads) {
        this.interestAreads = interestAreads;
    }
}
