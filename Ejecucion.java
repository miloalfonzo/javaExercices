import java.util.Scanner;

public class Ejecucion {

	public static void main(String[] args) {
		String [] destino = {"Roma","Glasgow","Berlin"};
		String [] pago = {"efectivo", "credito"};
		float [] precio = {2000, 3000, 2500};
		float [] recPaquete = new float[3];
		float [] recPaqueteA = new float[3];
		int [] posPaqueteM = new int [3];
		int maxPaquetePosi=0;

		Carga(precio,recPaquete);
		maxPaquetePosi=PaqueteMax(recPaquete);
		OrdenamientoRecaudacion(recPaquete,recPaqueteA,posPaqueteM);	
		
		Impresion(recPaquete,posPaqueteM,destino,pago,maxPaquetePosi);
		
	}
	public static void Carga(float [] precio,float [] recPaquete){
		int tipoPaquete=0;
		int cantidad=0;
		int pago=0;
	
		Scanner sc=new Scanner(System.in);	
		System.out.println("Ingrese paquete(1. Roma, 2. Glasgow, 3. Berlin): ");
		tipoPaquete = sc.nextInt();
		
		while(tipoPaquete!=0){
		
			System.out.println("Ingrese pasajes a adquirir: ");
			cantidad = sc.nextInt();
	
			System.out.println("Ingrese forma pago(1. Efectivo, 2. Credito): ");
			pago=sc.nextInt();
			
			if(tipoPaquete==1){
				recPaquete[tipoPaquete-1]+=precio[tipoPaquete-1]*cantidad*(float)0.85;
			}
			else{
				recPaquete[tipoPaquete-1]+=precio[tipoPaquete-1]*cantidad;
			}
			if(pago==1){
				recPaquete[pago-1]+=precio[tipoPaquete-1]+cantidad*(float)0.05;
			}
			else{
				recPaquete[tipoPaquete-1]+=precio[tipoPaquete-1]*cantidad;
			}
			
			System.out.println("Ingrese paquete(1. Roma, 2. Glasgow, 3. Berlin): ");
			tipoPaquete = sc.nextInt();
		}
		
	}
	
	public static int PaqueteMax(float [] recPaquete){
		float maxPaquete=0;
		int maxPaquetePosi=0;
		
		for(int i=0;i<recPaquete.length;i++){
			if(recPaquete[i]>maxPaquete){
				maxPaquete=recPaquete[i];
				maxPaquetePosi=i;
			}
		}
		return maxPaquetePosi;
	}

	public static void OrdenamientoRecaudacion(float [] recPaquete,float [] recPaqueteA,int [] posPaqueteM){
		int i,j;
		float a;
			
		for(i=0;i<recPaquete.length;i++){
			recPaqueteA[i]=recPaquete[i];
		}

		for(i=1;i<recPaqueteA.length;i++)
	    {
	        for(j=0;j<recPaqueteA.length-i;j++)
	        {
	            if(recPaqueteA[j]<recPaqueteA[j+1])
	            {
					a=recPaqueteA[j+1]; 
					recPaqueteA[j+1]=recPaqueteA[j]; 
					recPaqueteA[j]=a;
				}
	        }
	    }	

		for(i=0;i<recPaquete.length;i++){
			for(j=0;j<recPaqueteA.length;j++){
				if(recPaquete[i]==recPaqueteA[j]){
					posPaqueteM[i]=j;
				}
			}
		}		
	}
	
	public static void Impresion(float []recPaquete,int [] posPaqueteM,String []destino,String [] pago,int maxPaquetePosi){

		System.out.println("Recaudacion descendente: ");
		for(int i=0;i<recPaquete.length;i++){
			System.out.println(destino[posPaqueteM[i]]+"  : " + recPaquete[posPaqueteM[i]]);
		}
		
		System.out.println("Recaudacion: ");
		for(int i=0;i<recPaquete.length;i++){
			System.out.println(destino[i]+" : " + recPaquete[i]);
		}
		System.out.println("Destino con más recaudación: "+destino[maxPaquetePosi]+" : "+recPaquete[maxPaquetePosi]);		
	
	}
	
}