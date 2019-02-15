package com.nju.edu.multiAgent.agent;

import com.nju.edu.domain.User;
import com.nju.edu.multiAgent.Message;

public class RequesteeAgent extends Agent {
    private User requestee;
    private RequesterAgent requesterAgent;


    public RequesteeAgent(User requestee) {
        this.requestee = requestee;
    }
    @Override
    void receiveMessage(Message message) {
        // TODO: 2019-02-05
    }


    public User getRequestee() {
        return requestee;
    }

    public void setRequestee(User requestee) {
        this.requestee = requestee;
    }

    public RequesterAgent getRequesterAgent() {
        return requesterAgent;
    }

    public void setRequesterAgent(RequesterAgent requesterAgent) {
        this.requesterAgent = requesterAgent;
    }
}
