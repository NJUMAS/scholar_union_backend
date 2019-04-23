package com.nju.edu.multiagent;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        try {
            Runtime rt = Runtime.instance();
            rt.setCloseVM(true);
            Profile pMain = new ProfileImpl(null, 8888, null);
            System.out.println("Launching a whole in-process platform..." + pMain);
            AgentContainer mc = rt.createMainContainer(pMain);
            // set now the default Profile to start a container
            ProfileImpl pContainer = new ProfileImpl(null, 8888, null);
            System.out.println("Launching the Agent container ..." + pContainer);

            ArrayList<String> researchFields = new ArrayList<>();
            researchFields.add("filed1");
//            researchFields.add("filed2");
//            researchFields.add("filed3");
            ArrayList<Integer> requestedNum = new ArrayList<>();
            requestedNum.add(3);
            ArrayList<Double> payment = new ArrayList<>();
            payment.add(210.9);
            AgentController custom = mc.createNewAgent("custom", "com.nju.edu.multiagent.agent.ControllerAgent", new Object[]{123, 1, researchFields, requestedNum, payment});
            custom.start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

