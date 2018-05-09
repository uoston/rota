/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mariojp.exemplos.oitorainhas;

import br.com.mariojp.ai.agent.AbstractState;

/**
 *
 * @author Victor
 */
public class Estado extends AbstractState {

    public static int TAMANHO = 8;
    private int[] local = new int[TAMANHO + 1]; //Cada indice representa uma linha
    //Cada valor representa uma coluna
    //i = linha e [i] = coluna
    //    

    public boolean lineEmpty(int ln) {
        return local[ln] == 0;
    }

    public boolean colEmpty(int cl) {
        boolean result = true;
        for (int i = 0; i < local[TAMANHO]-1; i++) {
            if (local[i] == cl) {
                result = false;
            }
        }
        return result;
    }

    public boolean dgnalEmpty(int ln, int cl) {
        boolean result = true;
        int mod = TAMANHO+1;
        for (int i = 0; i < local[TAMANHO]-1; i++) {
            int x = Math.abs(ln-i);
            int y = Math.abs(cl-local[i]);
            if ((x%mod) == (y%mod)) {                
                result = false;
            }
        }
        return result;
    }

    public Estado(int lastVal) {
        local[TAMANHO] = lastVal;
    }

    public int[] getLocal() {
        return local;
    }

    public void setLocal(int[] local) {
        this.local = local;
    }

    public void setValue(int coluna, int linha) {
        local[linha] = coluna;
    }

    public int getValue(int idx) {
        return local[idx];
    }

    public Object clone() {
        Object copia = null;
        try {
            copia = super.clone();
            ((Estado) copia).setLocal(this.copia());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copia;
    }

    private int[] copia() {
        int limite = local[TAMANHO];        
        //
        int[] novo = new int[TAMANHO + 1];        
        for (int i = 0; i < limite; i++) {
            novo[i] = local[i];            
        }
        //
        novo[TAMANHO] = limite;
        //
        return novo;
    }

    public boolean equals(Object obj) {
        Estado oth = (Estado) obj;
        boolean igual = false;
        if (local == oth.getLocal()) {
            igual = true;
        }
        return igual;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int l = 0; l < TAMANHO; l++) {
            for (int c = 1; c < TAMANHO+1; c++) {
                if(local[l]==c)
                    sb.append(1);
                else
                    sb.append(0);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}
