/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rota;

import br.com.mariojp.ai.agent.Functions;
import br.com.mariojp.ai.agent.INode;

/**
 *
 * @author mathoian
 */
public class Funcoes extends Functions{
	
	   /*    double tempo_medio(float distancia,float velocidade){
        float tempoMedio = velocidade / distancia;
        return tempoMedio;
    }

    double g (Estacao estAtual, Estacao estFinal){
    	//Fun��o de custo real
    	int tAtual = tempo_medio(estAtual.getDis)
    	Estado eIni = (Estado)estAtual.getState();
    	Estado eFin = (Estado)estFinal.getState();
    	
    	
    	
    	return
    }
    
    double h (Inode No){
    	//Fun��o heur�stica
    	
    }*/
    public double g(INode no){
        double c = 0;
        double[] custo = Mapa.distanciaReal.get(Estacao.estacaoAnterior-1);
        Estacao estacao = null;
        
        for(int i=0; i<custo.length; i++){
        	estacao = (Estacao) no.getState();
            if(custo[i] == estacao.getEstacao()){
                c = custo[i+1];
     /*           int linha = checarLinhaCusto(Estacao.estacaoAnterior, (int) custo[i]);
                int linhaAvo = linhaAvo(no.getParent());
                int vel = checarVelLinha(linha);
                c = c/vel;
                if(linha != linhaAvo){
                AgentePassageiro.hora_att = AgentePassageiro.hora + custoPai(no.getParent());
                    if(AgentePassageiro.hora_att >= 17 && AgentePassageiro.hora_att <= 19 ){
                    c = c + 0.16;
                }else{
                      c = c + 0.13;  
                    } 
                }
          */  }
            i++;
        }
        return c;
       }

/**
 * h(x) represents heuristic's calculation of node.
 * 
 * @param o
 * @return
 */
    /*   @Override
public double h(INode node){
        Estado est = (Estado) node.getState();
        double h = 0;
        int l = est.getEstacaoAtual();
        int c = AgentePassageiro.destino;
        if(l < c){
            h = (double) Valores.matrizDireta[l-1][c-l-1];
        }else if(l > c){
            h = (double) Valores.matrizDireta[c-1][l-c-1];
        }
        // checar qual estaÃ§Ã£o tem maior numero por causa da matriz
        int[] fatorH = checarLinhaHeuristica(c, l);
        //int vel = checarVelLinha(fatorH[1]);
        h=h/80;
        return h;
}
    public int checarLinhaCusto(int origem, int destino){
        int[] linhasO = Valores.estLinhas.get(origem-1);
        if(linhasO.length == 1){
            return linhasO[0];
        }else {
            int[] linhasD = Valores.estLinhas.get(destino-1);
            if(linhasD.length == 1){
                return linhasD[0];
            }else {
                for(int i=0;i<linhasD.length;i++){
                    for(int j=0;j<linhasO.length;j++){
                        if(linhasD[i] == linhasO[j]){
                            return linhasD[i];
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    public int[] checarLinhaHeuristica(int origem, int destino){
        Integer[] linhaOrigem = Mapa.Linhas.get(origem-1);
        Integer[] linhaDestino = Mapa.Linhas.get(destino-1);
        int[] retorno = new int[2];
        retorno[0] = 1;
        retorno[1] = 0;
        for(int i=0;i<linhaDestino.length;i++){
            if(linhaDestino[i]>retorno[1]){
                retorno[1] = linhaDestino[i];
            }
        }
        for(int j=0;j<linhaOrigem.length;j++){
            if(linhaOrigem[j]>retorno[1]){
                retorno[1] = linhaOrigem[j];
            }
        }
        return retorno;
    }
    
    public int compararLinhaPai(INode no){
        INode noPai = no.getParent();
        Estado estadoNo = (Estado) no.getState();
        Estado estadoPai = (Estado) noPai.getState();
        int[] linhasP = Valores.estLinhas.get(estadoNo.getEstacaoAtual()-1);
        
        if(linhasP.length == 1){
            return linhasP[0];
        }else {
            int[] linhasN = Valores.estLinhas.get(estadoPai.getEstacaoAtual()-1);
            if(linhasN.length == 1){
                return linhasN[0];
            }else {
                for(int i=0;i<linhasN.length;i++){
                    for(int j=0;j<linhasP.length;j++){
                        if(linhasN[i] == linhasP[j]){
                            return linhasN[i];
                        }
                    }
                }
            }
        }
        
       return 0; 
    }
    
    public int checarVelLinha(int linha){
        switch (linha){
            case Valores.BLUE_LINE:
                return 80;
            case Valores.PURPLE_LINE:
                return 60;
            case Valores.RED_LINE:
                return 80;
            case Valores.YELLOW_LINE:
                return 40;
        }
        return 0;
    }
    
    private int linhaAvo(INode pai){
        INode avo = pai.getParent();
        Estado estadoPai = (Estado) pai.getState();
        Estado estadoAvo = null;
        if(avo != null){
            estadoAvo = (Estado) avo.getState();
        }else {
            estadoAvo = estadoPai;
        }
        
        int[] linhasPai = Valores.estLinhas.get(estadoPai.getEstacaoAtual()-1);
        if(linhasPai.length == 1){
            return linhasPai[0];
        }else {
            int[] linhasAvo = Valores.estLinhas.get(estadoAvo.getEstacaoAtual()-1);
            if(linhasAvo.length == 1){
                return linhasPai[0];
            }else {
                for(int i=0;i<linhasPai.length;i++){
                    for(int j=0;j<linhasAvo.length;j++){
                        if(linhasPai[i] == linhasAvo[j]){
                            return linhasPai[i];
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    public double custoPai(INode pai){
        double custoPai = pai.getCost();
        return custoPai;
    }*/
}
