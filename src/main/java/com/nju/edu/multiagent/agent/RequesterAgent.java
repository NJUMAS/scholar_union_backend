package com.nju.edu.multiagent.agent;

import com.google.gson.JsonObject;
import com.nju.edu.domain.User;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.SimpleAchieveREInitiator;

import java.util.ArrayList;

public class RequesterAgent extends Agent {
    private User requester;
    private ArrayList<ArrayList<String>> requesteeAIds;
    private ArrayList<String> researchFields;
    private ArrayList<Integer> requestedNum;
    private ArrayList<Double> payment;
    private ArrayList<String> agreedUserId = new ArrayList<>();


    class InviteProposer extends SimpleAchieveREInitiator {
        protected InviteProposer(Agent Agent, ACLMessage msg) {
            super(Agent, msg);
        }

        @Override
        protected void handleAgree(ACLMessage msg) {
            System.out.println(myAgent.getLocalName() + " : [" + msg.getSender().getLocalName() + " ]同意");
            agreedUserId.add(msg.getSender().getLocalName().split("@")[1]);
        }

        @Override
        protected void handleRefuse(ACLMessage msg) {
            System.out.println(myAgent.getLocalName() + " : [" + msg.getSender().getLocalName() + "]拒绝");
        }

//暂时不需要这个
        /*@Override
        protected void handleInform(ACLMessage msg) {
            System.out.println(myAgent.getLocalName() + " said :"
                    + msg.getSender().getLocalName() + " has informed me of the status of my request."
                    + "They said : " + msg.getContent());
        }*/

        @Override
        protected void handleNotUnderstood(ACLMessage msg) {
            System.out.println(myAgent.getLocalName() + " : [" + msg.getSender().getLocalName()
                    + "]不理解我发给他的信息.");
        }

        @Override
        protected void handleOutOfSequence(ACLMessage msg) {
            System.out.println(myAgent.getLocalName() + " : [" + msg.getSender().getLocalName()
                    + "]返回了异常回答");
        }
    }

    @Override
    protected void setup() {
        super.setup();
// 初始化
        Object[] args = getArguments();
        requester = (User) args[0];
        requesteeAIds = (ArrayList<ArrayList<String>>) args[1];
        researchFields = (ArrayList<String>) args[2];
        requestedNum = (ArrayList<Integer>) args[3];
        payment = (ArrayList<Double>) args[4];


// 向所有候选者发送邀请信息
        System.out.println(getLocalName() + ": 准备向候选人发送邀请");
//        doWait(3000); // wait for candidates to be started. todo 运行之后观察requesteeAgent初始化是否即时，如果不及时，这里需要执行此操作，否则不需要
        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
        AID receiver = new AID();
        for (int i = 0; i < requesteeAIds.size(); i++) {
            String domain = researchFields.get(i);
            double paymentPerPerson = payment.get(i) / requesteeAIds.get(i).size();
            for (String agentId : requesteeAIds.get(i)) {
                receiver.setLocalName(agentId);
                message.setSender(getAID());
                message.addReceiver(receiver);

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("domain", domain);
                jsonObject.addProperty("payment", paymentPerPerson);
                message.setContent(jsonObject.toString());
                message.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
            }
        }
        addBehaviour(new InviteProposer(this, message));
    }


}
