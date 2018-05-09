/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mariojp.exemplos.oitorainhas;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.IState;

/**
 *
 * @author Victor
 */
public class Funcoes extends Functions{

    public Funcoes() {
        super();
    }

    @Override
    public double h(INode node) {
        Estado st = ((Estado) node.getState());
        int tamanho = st.TAMANHO;
        return st.getValue(tamanho)-(tamanho+1);
    }

    
    @Override
    public boolean objectiveFunction(IState node) {
        Estado st = ((Estado) node);
        int tamanho = st.TAMANHO;
        
        return st.getValue(tamanho) == tamanho+1;
    }
    
    
}
