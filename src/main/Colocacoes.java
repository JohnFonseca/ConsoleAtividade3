package main;

import java.util.ArrayList;

public class Colocacoes {
    private volatile static Colocacoes instance;
    ArrayList<String> col;
    int timeVencedor;
   public Colocacoes(){
	   col = new ArrayList<String>();
   }
     

    public static Colocacoes getInstance() {
        if (instance == null) {
       // 	System.out.println("eu existo 1 ----" + instance);
            synchronized (Colocacoes.class) {
                if (instance == null) instance = new Colocacoes();
        	//instance = new Colocacoes();
            }
        }
      //  System.out.println("eu existo 2 ----" + instance);
        return instance;
    }
    
    public void AdicionarPosicoes(String nome, int i)
    {
    	//System.out.println("tentando entrar aqui  ----" + nome);
    	col.add(nome);
    	System.out.println( nome + " ficou na posicao " + col.size());
    	if(col.size()<2)
    	{
    		timeVencedor = i;
    	}
    }
    public int Vencedor()
    {
    	return timeVencedor;
    }
}