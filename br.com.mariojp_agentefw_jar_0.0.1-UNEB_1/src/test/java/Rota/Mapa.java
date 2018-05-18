package Rota;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Mapa {
	//matriz com o dado da distancia direta entre estacoes[linha][coluna] ou  int distancia = estacoes[linha][coluna] 
	public static Integer[][] mapaDireto = new Integer[42][42];
	// array de estações [[estacao,distancia],....]
    public static List<double[]> distanciaReal = new ArrayList();
    //array que contem um array com as linhas de cada estação
    public static List<Integer[]> Linhas = new ArrayList();
	/**
	 * @param args
	 * @throws IOException
	 */
	public static final int LINHA_AMARELA = 1;
    public static final int lINHA_LILAS = 2;    
    public static final int LINHA_AZUL = 3;
    public static final int LINHA_VERMELHA = 4;
    public int[] velocidade = new int[]{40,60,80,80};
	
	public Integer[][] getMapaDireto(){
		return this.mapaDireto;	
	}
	public List getMapaReal(){
		return this.distanciaReal;		
	}
	public List getLinhas(){
		return this.Linhas;		
	}
	public static void gerarLinhas() throws IOException{

		BufferedReader arquivoMapaLinha = new BufferedReader(new FileReader("src\\test\\java\\Rota\\Linhas.txt"));
		Integer[] linhas = new Integer[42];
		//Integer[] l = new Integer[4];
		Integer[] l = new Integer[4];
		for(int valorLinha = 0; valorLinha < linhas.length; valorLinha++ ){
			String linha = arquivoMapaLinha.readLine(); 
			String[] stringLinha = linha.split(";");
			for(int x = 0; x < stringLinha.length; x++ ){
				stringLinha[x] = stringLinha[x].trim();
			//	System.out.println(stringLinha[x]);
				l[x] = Integer.parseInt(stringLinha[x]);
			}
			Linhas.add(valorLinha, l);
		}
		arquivoMapaLinha.close();	
	}
	public static void gerarMapaReal() throws IOException{
		BufferedReader arquivoMapa = new BufferedReader(new FileReader("src\\test\\java\\Rota\\DistanciaReal.txt"));
		double [] estacoes = new double[2];
		Integer[] arrayMapa = new Integer[42];
		for(int valorLinha = 0; valorLinha < arrayMapa.length; valorLinha++ ){
			Double[] c = new Double[42];
			String linha = arquivoMapa.readLine(); 
			String[] stringLinha = linha.split(";");
			for(int x = 0; x < stringLinha.length; x++ ){
				stringLinha[x] = stringLinha[x].trim();
				String[] stringEstacao = stringLinha[x].split(",");
				for(int z = 0; z < stringEstacao.length; z++ ){
					stringEstacao[z] = stringEstacao[z].trim();
					estacoes[z]  = Double.parseDouble(stringEstacao[z]);
			//		System.out.println(stringEstacao[z]);
				}
				distanciaReal.add(estacoes);
			}
		//	System.out.println();
		}
		arquivoMapa.close();		
	}
	public static void gerarMapaDireto() throws IOException{
		BufferedReader arquivoMapa = new BufferedReader(new FileReader("src\\test\\java\\Rota\\Mapa.txt"));
		
		Integer[] arrayMapa = new Integer[42];
		for(int valorLinha = 0; valorLinha < arrayMapa.length; valorLinha++ ){
			Integer[] c = new Integer[42];
			String linha = arquivoMapa.readLine(); 
			String[] n = linha.split(",");		
			for(int x = 0; x < n.length; x++ ){
				n[x] = n[x].trim();
			    c[x] = Integer.parseInt(n[x]);	
			    //System.out.print(n[x]+",");
			}
			mapaDireto[valorLinha] = c;
		}
		arquivoMapa.close();
	}
	public void escrever() throws IOException{
		BufferedWriter m = new BufferedWriter(new FileWriter("src\\test\\java\\Rota\\Mapa2.txt"));		
	};
	public static void main(String[] args) throws IOException{
		gerarMapaDireto();
		gerarMapaReal();
		gerarLinhas();
	}
}

