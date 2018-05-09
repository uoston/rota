/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mariojp.exemplos.oitorainhas;

import br.com.mariojp.ai.agent.IState;
import br.com.mariojp.ai.agent.action.AbstractAction;
import br.com.mariojp.ai.agent.exception.ImpossibleActionException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Adicionar extends AbstractAction {

    @Override
    public List<IState> execute(IState state) throws ImpossibleActionException {
        List<IState> eNovos = new ArrayList<IState>();
        Estado n = (Estado) state;
        Estado est = (Estado) n.clone();
        int tamanho = est.TAMANHO;
        int limite = est.getValue(tamanho);

        for (int linha = limite-1; linha < limite; linha++) {       //Linhas
            for (int coluna = 1; coluna < tamanho+1; coluna++) {    //Colunas
                if (est.colEmpty(coluna) && est.dgnalEmpty(linha, coluna))  {
                    Estado novo = (Estado) est.clone();
                    int lm = novo.getValue(tamanho);
                    //
                    novo.setValue(coluna, linha);                    
                    novo.setValue(lm+1,tamanho);                    
                    //
                    eNovos.add(novo);
                }
            }
        }

        return eNovos;
    }
}
