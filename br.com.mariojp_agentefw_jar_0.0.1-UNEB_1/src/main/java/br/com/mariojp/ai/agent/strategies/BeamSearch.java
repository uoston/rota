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
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Victor
 */
public class BeamSearch extends Agent implements Comparator<INode> {

    public BeamSearch(AgentModel agent) {
        super(agent);
    }

    private int kStates = 64;

    public int getkStates() {
        return kStates;
    }

    public void setkStates(int k) {
        this.kStates = k;
    }

    @Override
    public INode function() throws EmptyBorderException {
        this.border.add(this.firstNode);
        List<INode> k = new LinkedList<INode>();
        INode iNode = null;
        boolean completed = false;        
        //
        //
        ///Primeira vez - Gera os k Estados randomicamente...
        if (this.border.isEmpty()) {
            throw new EmptyBorderException();
        } else {
            iNode = (INode) this.border.remove(0);
            if (this.isGoal(iNode)) {
                completed = true;
                return iNode;
            } else {
                List<INode> list = this.actionCommand.executeActions(iNode);
                int size = list.size() > getkStates() ? getkStates() : list.size();
                for (int i = 0; i < size; i++) {                    
                    int st = new Random().nextInt(size);
                    border.add(list.get(st));
                }                
            }
        }        
        //
        while (!completed) {
            if (this.border.isEmpty()) {
                throw new EmptyBorderException();
            } else {
                //Gera todos os sucessores dos k estados
                while (!this.border.isEmpty()) {
                    INode no = (INode) this.border.remove(0);
                    k.addAll(this.actionCommand.executeActions(no));
                }                
                //                
                //Verifica a solução de cada um...
                for (int i = 0; i < k.size(); i++) {
                    iNode = (INode) k.get(i);
                    if (this.isGoal(iNode)){
                        completed = true;                        
                    }
                }                
                //Senão encontrou, seleciona os k melhores...
                if (!completed) {                    
                    int size = k.size() > getkStates() ? getkStates() : k.size();
                    Collections.sort(k, this);
                    border.addAll(k.subList(0, size));                    
                    k.clear();
                    //System.out.println(size);
                }                
                //
                //
            }
        }
        this.end = new Date();
        return iNode;
        //     
    }

    public int compare(INode o1, INode o2) {
        int res = 0;
        if (o1.getHeuristic() > o2.getHeuristic()) {
            res = 1;
        } else if (o1.getHeuristic() < o2.getHeuristic()) {
            res = -1;
        }
        return res;
    }

}
