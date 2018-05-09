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

/**
 *
 * @author Victor
 */
public class HillClimbingSearch extends Agent implements Comparator<INode> {

    public HillClimbingSearch(AgentModel agent) {
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
                iNode = (INode) this.border.remove(0);
                if (this.isGoal(iNode)) {
                    completed = true;
                } else {
                    List<INode> list = this.actionCommand.executeActions(iNode);
                    border.addAll(list);
                    Collections.sort(border.getList(),this);
                }
            }
        }
        this.end = new Date();
        return iNode;
    }

    public int compare(INode o1, INode o2) {
        //
        //O método compare() é usado pela função Collection.sort(list) mostrada acima...
        //Quanto menor a Heuristica, menor a distancia para o objetivo e melhor a posição do nó!!!
        //
        //Caso o nó atual (o1), seja menor que o nó comparado (o2)
        //não troca, se for maior retorna troca pelo melhor
        //
        int res = 0;
        if (o1.getHeuristic()> o2.getHeuristic()) {
            res = 1;
        } else if (o1.getHeuristic()< o2.getHeuristic()) {
            res = -1;
        }
        return res;

    }

}
