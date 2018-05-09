/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mariojp.ai.agent.strategies;

import br.com.mariojp.ai.agent.Agent;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Victor
 */
public class SimulatedAnnealingSearch extends Agent implements Comparator<INode>{

    private static int temperature = 25000;     //in milleseconds (milleseconds/1000 = seconds)

    public static int getTemperature() {
        return temperature;
    }

    public static void setTemperature(int temperature) {
        SimulatedAnnealingSearch.temperature = temperature;
    }

    public SimulatedAnnealingSearch(AgentModel agent) {
        super(agent);
    }

    @Override
    public INode function() throws EmptyBorderException {
        this.border.add(this.firstNode);
        INode iNode = null;
        boolean completed = false;
        while (!completed) {
            if (this.border.isEmpty()) {
                throw new EmptyBorderException();
            } else {
                int index = new Random().nextInt(this.border.size());
                iNode = (INode) this.border.remove(index);
                if (this.isGoal(iNode)) {
                    completed = true;
                }else {                    
                    List<INode> list = this.actionCommand.executeActions(iNode);
                    border.addAll(list);
                    //
                    Collections.sort(border.getList(),this);
                    setTemperature(getTemperature()-(1/2));
                    //                    
                }
            }                        
        }
        this.end = new Date();
        return iNode;
    }
    
    //    
    //
    public int compare(INode n1, INode n2) {
        double h1 = n1.getHeuristic();
        double h2 = n2.getHeuristic();
        //
        if (h2<h1)
            return 1;
        else {
            double delta = n1.getHeuristic() - n2.getHeuristic();
            double prob = Math.exp(-delta / this.temperature);
            
            if (prob > new Random().nextDouble()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    
}
