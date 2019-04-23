package com.nju.edu.multiagent.agent;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nju.edu.domain.User;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.SimpleAchieveREResponder;

public class RequesteeAgent extends Agent {

    private User requestee;
    private String requesterName;


    class InvitationResponder extends SimpleAchieveREResponder {  //准备答复

        private static final long serialVersionUID = 1L;

        public InvitationResponder(Agent a, MessageTemplate mt) {
            super(a, mt);
        }


        @Override
        protected ACLMessage prepareResponse(ACLMessage request) {
            ACLMessage responder = request.createReply();

            System.out.println("receiving");
//                    doWait(2000); // 为什么要wait呢？暂时不懂，先注释掉
            String contentStr = request.getContent();
            if (request.getSender().getLocalName().equals(requesterName) && contentStr != null) {
                System.out.println("[ " + request.getSender().getLocalName() + " ] 发送的消息到达 [ " + getLocalName() + " ]");
                //解析信息
                JsonObject object = new JsonParser().parse(contentStr).getAsJsonObject();
                String domain = object.get("domain").getAsString();
                double payment = object.get("payment").getAsDouble();
                boolean agreed = consider(domain, payment);
                if (agreed) {
                    responder.setPerformative(ACLMessage.AGREE);
                } else {
                    responder.setPerformative(ACLMessage.REFUSE);
                }
                myAgent.doDelete();
            } else {
                responder.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                System.out.println("不理解来自它的信息：" + request.getSender().getLocalName());
            }
            return responder;
        }

// 由于受邀者除了同意和拒绝，现项目阶段没有什么需要完成的额外工作，所有先注释掉
     /*   @Override
        protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage response) {
            ACLMessage message = request.createReply();
            message.setPerformative(ACLMessage.INFORM);
            message.setContent("已完成要求");
            return message;
        }*/

        private boolean consider(String domain, double payment) {
//            ArrayList<String> skilledFields = requestee.getSkilledFields();
            //从User对象得到擅长领域和兴趣领域并与domain作比较，同时考虑payment
            return true; // todo
        }

    }

    @Override
    protected void setup() {
        super.setup();
// 初始化
        Object[] args = getArguments();
        requestee = (User) args[0];
        requesterName = (String) args[1];
        addBehaviour(new InvitationResponder(this, MessageTemplate.MatchSender(new AID(requesterName, AID.ISLOCALNAME))));

    }


}
