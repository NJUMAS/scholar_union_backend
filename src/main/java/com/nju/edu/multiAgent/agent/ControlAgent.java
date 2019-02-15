package com.nju.edu.multiAgent.agent;

import com.nju.edu.domain.User;

import java.util.ArrayList;

public class ControlAgent {
    private static RequesterAgent requesterAgent;
    private static ArrayList<RequesteeAgent> requesteeAgents;


    public ArrayList<User> recommondPartner(User requester, String requestedTime, ArrayList<String> researchAreas, ArrayList<Integer> requestedNum, Double totalCompensation, ArrayList<Double> compensationPer) {
        requesterAgent = new RequesterAgent(requester, requestedTime, researchAreas, requestedNum, totalCompensation, compensationPer);
        requesteeAgents = new ArrayList<>();

        ArrayList<User> users = null; // TODO: 2019-02-12   从后端模块获得
        for (User usert : users) {
            RequesteeAgent requesteeAgent = new RequesteeAgent(usert);
            requesteeAgent.setRequesterAgent(requesterAgent);
            requesteeAgents.add(requesteeAgent);
        }
        requesterAgent.setRequesteeAgents(requesteeAgents);
        return requesterAgent.recommendPartner();
    }


}
