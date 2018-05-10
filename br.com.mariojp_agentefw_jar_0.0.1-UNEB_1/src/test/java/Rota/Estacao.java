/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rota;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.mariojp.ai.agent.AbstractState;
/**
*
* @author uoston
*/


public class Estacao extends AbstractState {
	public static int estacaoAnterior;
	private int Estacao;		
	SimpleDateFormat sdf = null;
	Integer[] Linhas = new Integer[4];
	double[] EstacoesFilhas;

	public Estacao(int idEstacao){
		Linhas = Mapa.Linhas.get(idEstacao);
		EstacoesFilhas = Mapa.distanciaReal.get(idEstacao);
	}
	public int getEstacao() {
		return Estacao;
	}
	public void setEstacao(int estacao) {
		this.Estacao = estacao;
	}
	public void setLinhas(int estacao) {
		Linhas = Mapa.Linhas.get(estacao);
	}
	public void setDistenciaReal(int estacao) {
		EstacoesFilhas = Mapa.distanciaReal.get(estacao);
	}
	   public Object clone() {
	       Object copia = null;
	       try {
				copia = super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
	       return copia;
	   }
	
	   /**
	    * Compara estados para verificar se s�o iguais
	    * @param arg0 Object
	    * @return boolean
	    */
	   public boolean equals(Object arg0) {
	       Estacao outro = (Estacao) arg0;
	       boolean igual = false;
	       return igual;
	   }

		@Override
		public String toString() {
			// TODO Auto-generated method stub		
			return null;
		}
}


