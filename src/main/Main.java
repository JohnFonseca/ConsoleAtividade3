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
		ThreadProcessor threads[];// = new ThreadProcessor[grilosNaPartida];
		
		int times;
		times = grilosNaPartida/3;
		if (grilosNaPartida%3 > 0 || times == 0)
		{
			times++; 
		}
		
		threads= new ThreadTimes[times];
		
		for (int i = 0; i < nThreads; i++) {
			int start = i * elemThread;
			int end = start + elemThread;
			threads[i] = new ThreadTimes(i, 3, distancia, tamanhoMaximoPulo, elemThread, times);
			threads[i].start();
		}
		
			for (int i = 0; i < nThreads; i++) {
				try {
					threads[i].join();
				}
				
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			System.out.println("----------");
			
			for (int i = 0; i < nThreads; i++) {
				//System.out.println("O time " + i + " Total de pulos: " + threads[i].RetornaPulosTotais);
			}
	}
	
}
