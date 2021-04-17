package main;

import java.util.Random;

public class ThreadTimes extends Thread {
int time;
int pulosTotal;
int distanciaTotal;
ThreadProcessor threads[];// = new ThreadProcessor[grilosNaPartida];
Random rand = new Random();
int nThreads;
	public ThreadTimes(int time, int grilosNaPartida,int distancia,int tamanhoMaximoPulo, int elemThread, int times)
	{
		this.time = time;
		threads = new ThreadProcessor[grilosNaPartida];
		nThreads = times;
		for(int i=0; i<grilosNaPartida;i++)
		{
			int start = i * elemThread;
			int end = start + elemThread;
			int tempTime;//novo
		//	tempTime= rand.nextInt(times+1);//novo
		//	threads[i] = new ThreadProcessor("O Grilo_"+(i+1+(time*3)+ " do time" + time),0,distancia,tamanhoMaximoPulo,start,end,time);
			threads[i].start();
		}
	}
	
	public void run()
	{
		for (int i = 0; i < 3; i++) {
			try {
				threads[i].join();
				//threads[i].Terminado(i);

			}
			
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		//	pulosTotal += threads[i].TerminadoPulos();
		//	distanciaTotal += threads[i].TerminadoDistancia();
		}
		
		//System.out.println("o time " + time + " total de pulos: " + pulosTotal + " percorreu: " + distanciaTotal + "cm");
	}
	
	public int RetornaPulosTotais()
	{
		return pulosTotal;
	}
	public int RetornaDistanciaPercorrida()
	{
		return distanciaTotal;
	}
}