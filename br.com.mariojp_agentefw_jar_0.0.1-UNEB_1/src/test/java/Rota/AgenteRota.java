package Rota;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import br.com.mariojp.ai.agent.AgentFactory;
import br.com.mariojp.ai.agent.AgentModel;
import br.com.mariojp.ai.agent.IAgent;
import br.com.mariojp.ai.agent.INode;
import br.com.mariojp.ai.agent.exception.EmptyBorderException;
import br.com.mariojp.exemplos.metroSsa.Estacao;



class AgenteRota {

    public static void main(String args[]) throws IOException {
    	Mapa mapa = new Mapa();
    	Mapa.gerarMapaDireto();
    	Mapa.gerarMapaReal();
    	
    //	ArrayList<String> estacoes = new ArrayList();
    /*	
    	Map<String, Integer> estacoes = new HashMap<String,Integer>();
    	Map<String, Integer> estacoes1 = new HashMap<String,Integer>();
    	estacoes.put("E1",10);
    	estacoes.put("E2",6);
    	estacoes.put("E3",10);
    	
    	estacoes1.put("E4",20);
    	estacoes1.put("E5",26);
    	estacoes1.put("E6",20);
    		
    	ArrayList<Map> estacaoPai = new ArrayList();
    	
    	estacaoPai.add(estacoes);
    	estacaoPai.add(estacoes1);
    	Iterator<Map> est = estacaoPai.iterator();
    	Map<String, Integer> estacao = new HashMap<String,Integer>();
    	
    	while(est.hasNext()){
    		estacao = est.next();
	        for (String key : estacao.keySet()) {
	        	 Integer i =  estacao.get(key);
	        	 String value = i.toString();
	             System.out.println(key + " = " + value);
	        }
    	}
    	*/
    /*	
     	Iterator<String> est = estacaoPai.iterator();
    
    	
    	while(est.hasNext()){
    		String estacao = est.next();
    		System.out.println(estacao);
    	}
      */  
		AgentModel ab = new AgentModel();
			
		Estacao inicial = new Estacao(1);
		ab.setInitState(inicial);
	
		Estacao objetivo = new Estacao(5);
		ab.setInitState(objetivo); 
	
		ab.setType(IAgent.BREADTH_FIRST_SEARCH);
		
		IAgent agente = AgentFactory.createAgent(ab);
			
		INode nofinal = null;
		try {
			nofinal = agente.function();
		} catch (EmptyBorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//List cam = agente.obterCaminho(nofinal);
		//agente.exibirGrafico(null);
		System.out.println(agente);
		System.out.println(nofinal);
	
    }     
}

