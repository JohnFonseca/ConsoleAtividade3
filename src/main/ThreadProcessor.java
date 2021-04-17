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
	int times;
	public ThreadProcessor(String nome,int tamanhoPulo,int distanciaMaxima,int tamanhoMaximoPulo,int start, int end, int times) {
		this.nome = nome;
		this.distanciaMaxima = distanciaMaxima;
		this.tamanhoPulo = tamanhoPulo;
		this.distancia += tamanhoPulo ;
		this.start = start;
		this.end = end;
		this.tamanhoMaximoPulo = tamanhoMaximoPulo;
		this.times = times;
		vencedor = false;
	}
	
	public int TerminadoPulos()
    {
        return pulos;
    }
    public int TerminadoDistancia()
    {
        return distancia;
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
		Colocacoes.getInstance().AdicionarPosicoes(nome, times);
		
	}
	
	try {
        Thread.sleep((int)(Math.random() * 500));
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	
	//System.out.println("fim");
}

	
		
			//C[i] = A[i] + B[i];		
	}
}
