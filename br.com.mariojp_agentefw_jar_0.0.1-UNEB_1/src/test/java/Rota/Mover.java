package Rota;

import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.ai.agent.IState;
/**
*
* @author uoston
*/
public class Mover extends AbstractAction{
  	List<double[]> d = Mapa.distanciaReal;
    public List<IState> execute(IState estacao) throws ImpossibleActionException {
        List<IState> novasEstacoes = new ArrayList<IState>();
        Estacao original = (Estacao) estacao;
    //    Funcoes funcoes = new Funcoes();
        
        original.estacaoAnterior = original.getEstacao();
        // novo Estacao ele vai ter estaÃƒÂ§ÃƒÂ£o atural e horÃƒÂ¡rio...
        //novoEstacao.setEstacaoAtual(3); // numero qualquer
        //novoEstacao.setHoraAtual(12.00); // horario qualquer
        
        double[] dist;
        dist = Mapa.distanciaReal.get(original.estacaoAnterior-1);
      
        for(int i=0;i < dist.length;i++){
            Estacao novaEstacao = (Estacao) original.clone();
            novaEstacao.setEstacao((int) dist[i]);
            novasEstacoes.add(novaEstacao);
            i++;
        }
        for(int i=0;i<novasEstacoes.size();i++){
            Estacao est = (Estacao) novasEstacoes.get(i);
        }
        return novasEstacoes;
    } 
}
