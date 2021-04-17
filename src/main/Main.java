package main;

import java.util.Random;

public class Main {


	
	public static void main(String args[]) {
		int grilosmin = 2;
		int grilosMax = 10;
		Random rand = new Random();
		int grilosNaPartida = rand.nextInt(grilosMax + 1);
		if(grilosNaPartida<grilosmin)
		{
			grilosNaPartida=grilosmin;
		}
		
		int distancia = 400;
		int tamanhoPulo;
		int tamanhoMaximoPulo = 80;

		int nThreads = grilosNaPartida;
		int elemThread = grilosNaPartida / nThreads;
		
		//System.out.println(grilosNaPartida);
		ThreadProcessor threads[] = new ThreadProcessor[grilosNaPartida];

		for(int i=0; i<grilosNaPartida;i++)
		{
			int start = i * elemThread;
			int end = start + elemThread;
			threads[i] = new ThreadProcessor("O Grilo_"+(i+1),0,distancia,tamanhoMaximoPulo,start,end);
			threads[i].start();
		}
		
		{
			
			
			for (int i = 0; i < nThreads; i++) {
				try {
					threads[i].join();
				}
				
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		//	z++;
		}
	}
	
}
