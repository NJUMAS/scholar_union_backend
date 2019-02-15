package com.nju.edu.multiAgent.agent;

import com.nju.edu.domain.User;
import com.nju.edu.multiAgent.Message;

import java.util.ArrayList;

public class RequesterAgent extends Agent {
    private ArrayList<RequesteeAgent> requesteeAgents;
    private User requester;
    private String requestedTime;
    private ArrayList<String> researchAreas;
    private ArrayList<Integer> requestedNum;
    private double totalCompensation;
    private ArrayList<Double> compensation;

    public RequesterAgent(User requester, String requestedTime, ArrayList<String> researchAreas, ArrayList<Integer> requestedNum, Double totalCompensation, ArrayList<Double> compensation) {
        this.requester = requester;
        this.requestedTime = requestedTime;
        this.researchAreas = researchAreas;
        this.requestedNum = requestedNum;
        this.totalCompensation=totalCompensation;
        this.compensation = compensation;
    }


    @Override
    void receiveMessage(Message message) {
        // TODO: 2019-02-05
    }

    public ArrayList<User> recommendPartner() {

        return null; // TODO: 2019-02-12  
    }

    public ArrayList<RequesteeAgent> getRequesteeAgents() {
        return requesteeAgents;
    }

    public void setRequesteeAgents(ArrayList<RequesteeAgent> requesteeAgents) {
        this.requesteeAgents = requesteeAgents;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public String getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(String requestedTime) {
        this.requestedTime = requestedTime;
    }

    @Override
    public ArrayList<String> getResearchAreas() {
        return researchAreas;
    }

    @Override
    public void setResearchAreas(ArrayList<String> researchAreas) {
        this.researchAreas = researchAreas;
    }

    public ArrayList<Integer> getRequestedNum() {
        return requestedNum;
    }

    public void setRequestedNum(ArrayList<Integer> requestedNum) {
        this.requestedNum = requestedNum;
    }

    public double getTotalCompensation() {
        return totalCompensation;
    }

    public void setTotalCompensation(double totalCompensation) {
        this.totalCompensation = totalCompensation;
    }

    public ArrayList<Double> getCompensation() {
        return compensation;
    }

    public void setCompensation(ArrayList<Double> compensation) {
        this.compensation = compensation;
    }
}
