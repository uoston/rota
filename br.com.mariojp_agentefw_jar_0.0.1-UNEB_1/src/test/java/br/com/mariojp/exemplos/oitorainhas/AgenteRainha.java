/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mariojp.exemplos.oitorainhas;

import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;

/**
 *
 * @author Victor
 */
public class AgenteRainha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        //
        for (int i = 0; i < 100; i++) {
            System.out.println("________________________________________________");
            System.out.println((i+1)+"º Execução:");                        
            //
            new AgenteRainha().execute();
        }
        //

    }

    public void execute() {
        Estado inicio = new Estado(1);
        Estado objetivo = new Estado(Estado.TAMANHO + 1);
        //
        //
        AgentModel model = new AgentModel();
        model.setInitState(inicio);
        model.addObjective(objetivo);
        model.setFunctions(new Funcoes());
        model.addAction("Adicionar", new Adicionar());
        model.setType(IAgent.BEAM_SEARCH);
        //
        IAgent agente = AgentFactory.createAgent(model);
        //        
        INode nofinal = null;
        try {
            nofinal = agente.function();
        } catch (EmptyBorderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //        
        System.out.println(agente);
        System.out.println(nofinal);
    }

}
