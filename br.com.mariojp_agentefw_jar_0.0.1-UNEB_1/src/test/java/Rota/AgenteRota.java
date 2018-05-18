package Rota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
/**
*
* @author uoston
*/


class AgenteRota {

    public static void main(String args[]) throws IOException {
    	Mapa mapa = new Mapa();
    	Mapa.gerarMapaDireto();
    	Mapa.gerarMapaReal();
    	Mapa.gerarLinhas();
    	
    	executaArquivos();
	
    }     
    public static void executaArquivos() throws IOException{
    	BufferedReader arquivoFonte = new BufferedReader(new FileReader("src\\test\\java\\Rota\\fonte.txt"));
		BufferedWriter Resultado = new BufferedWriter(new FileWriter("src\\test\\java\\Rota\\resultado.txt"));
		//array com a quantidade de linhas no arquivo de inicialização
		Integer[] linhas = new Integer[6];
		
		for(int valorLinha = 0; valorLinha < linhas.length; valorLinha++ ){		
		String percurso = arquivoFonte.readLine(); 
		String[] est = percurso.split(";");

		Integer estacaoOrigem = Integer.parseInt(est[0]);
		Integer estacaodestino = Integer.parseInt(est[1]);

    	AgentModel ab = new AgentModel();
		
		Estacao inicial = new Estacao(estacaoOrigem);
		
		ab.setInitState(inicial);
	
		Estacao objetivo = new Estacao(estacaodestino);
		ab.setInitState(objetivo); 
	
		ab.setType(IAgent.BREADTH_FIRST_SEARCH);
		
		IAgent agente = AgentFactory.createAgent(ab);
			
		INode nofinal = null;
	/*	try {
			nofinal = agente.function();
		} catch (EmptyBorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*///List cam = agente.obterCaminho(nofinal);
		//agente.exibirGrafico(null);
		System.out.println(agente);
		//System.out.println(nofinal);
		}
    	
    }
}

