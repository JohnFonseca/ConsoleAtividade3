package main;
public class ThreadProcessor extends Thread {
	
	String nome;
	int pulos;
	int tamanhoPulo;
	int distancia;
	int distanciaMaxima;
	int start, end;
	boolean vencedor;
	int tamanhoMaximoPulo;
	public ThreadProcessor(String nome,int tamanhoPulo,int distanciaMaxima,int tamanhoMaximoPulo,int start, int end) {
		this.nome = nome;
		this.distanciaMaxima = distanciaMaxima;
		this.tamanhoPulo = tamanhoPulo;
		this.distancia += tamanhoPulo ;
		this.start = start;
		this.end = end;
		this.tamanhoMaximoPulo = tamanhoMaximoPulo;
		vencedor = false;
	}
	
	public void run() {
while(vencedor==false)
{
	tamanhoPulo = (int)(Math.random() *tamanhoMaximoPulo);
	if(distancia <distanciaMaxima && vencedor == false)
	{
		this.distancia += tamanhoPulo;
		this.pulos++;
		if(distancia>distanciaMaxima)
		{
			distancia = distanciaMaxima;
		}
		for (int i = start; i < end; i++)
		{
			
			System.out.println(nome + " pulou " + tamanhoPulo + "cm e ja percorreu " + distancia +"cm com " +pulos + " pulos");
			
		}
	}
	else if(distancia>=distanciaMaxima && vencedor==false)
	{
		
		System.out.println(nome + " percorreu "+distanciaMaxima + " e alcançou a linha de chegada "+" com " +pulos + " pulos");
		vencedor = true;
		
	}
	
	//System.out.println("fim");
}

	
		
			//C[i] = A[i] + B[i];		
	}
}
