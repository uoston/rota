package br.com.mariojp.exemplos.metroSsa;

import java.util.Date;
import java.util.List;

import Rota.Mapa;
import br.com.mariojp.ai.agent.AbstractState;



public class Estacao extends AbstractState {
	public static int estacaoAnterior;
	private int Estacao;
	private int hora;
	private int minuto;
	Integer[] Linhas = new Integer[4];
	double[] EstacoesFilhas;

	public Estacao(int idEstacao){
	//	Linhas = Mapa.Linhas.get(idEstacao);
		EstacoesFilhas = Mapa.distanciaReal.get(idEstacao);
	}
	
	public int getEstacao() {
		return Estacao;
	}
	public void setEstacao(int estacao) {
		this.Estacao = estacao;
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
	    * Compara estados para verificar se são iguais
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


