package com.nju.edu.multiagent.agent;

import com.nju.edu.domain.User;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.util.ArrayList;

public class ControllerAgent extends Agent {
    private String identifier;
    private String requesterId;
    private ArrayList<String> researchFields;
    private ArrayList<Integer> requestedNum;
    private ArrayList<Double> payment;


    @Override
    protected void setup() {
        super.setup();
        Object[] args = getArguments(); //传入的关于项目信息的参数列表
//    0:项目的唯一标识，建立项目后，存储到数据库时分配的项目唯一标识。
//    1:项目发起人的id，用来作为requesterAgent的nickname
//    2:研究领域名集合
//    3:每个领域对应所需要的人数
//    4:每个领域的总报酬
        identifier = args[0].toString();
        requesterId = args[1].toString();
        researchFields = (ArrayList<String>) args[2];
        requestedNum = (ArrayList<Integer>) args[3];
        payment = (ArrayList<Double>) args[4];

        User requester = null; //todo  从后端根据requesterId获得该发起者的User对象

        Behaviour createAgents = new SimpleBehaviour() {
            private boolean finished = false;

            @Override
            public void action() {
                AgentContainer agentContainer = getContainerController();

                AgentController agentController;

//创建候选人agent
                ArrayList<ArrayList<String>> candidateNames = new ArrayList<>();
                for (int i = 0; i < researchFields.size(); i++) {
                    candidateNames.add(new ArrayList<>());
                }
                ArrayList<ArrayList<User>> candidates = new ArrayList<>(); // TODO: 2019-02-12   从后端模块获得
                ArrayList<User> usersTemp = new ArrayList<>();
                usersTemp.add(new User(1));
                usersTemp.add(new User(2));
                usersTemp.add(new User(3));
                candidates.add(usersTemp);

                try {
                    for (int i = 0; i < candidates.size(); i++) {
                        ArrayList<User> filedCandidates = candidates.get(i);
                        for (User candidate : filedCandidates) {

                            String nickname = identifier + "@" + candidate.getUserId(); //将项目唯一标识与用户id拼接作为受邀者代理的nickname
                            agentController = agentContainer.createNewAgent(nickname, "com.nju.edu.multiagent.agent.RequesteeAgent", new Object[]{candidate, identifier + "@Requester"});
                            agentController.start();
                            candidateNames.get(i).add(nickname);
                            System.out.println("Agent: [" + nickname + "]  启动");
                        }
                    }
                } catch (StaleProxyException e) {
                    e.printStackTrace();
                }

// 创建项目发起人agent
                try {
                    agentController = agentContainer.createNewAgent(identifier + "@Requester", "com.nju.edu.multiagent.agent.RequesterAgent", new Object[]{requester, candidateNames, researchFields, requestedNum, payment});
                    agentController.start();
                    System.out.println("Agent: [" + agentContainer.getName() + "]  启动");
                } catch (StaleProxyException e) {
                    e.printStackTrace();
                }

                finished = true;
            }


            @Override
            public boolean done() {
                return finished;
            }
        };
        addBehaviour(createAgents);
    }


}
