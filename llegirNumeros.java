import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class llegirNumeros {
    public static void main(String[] args)throws IOException, FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        File numeros = new File("C:\\Users\\Eric\\Documents\\programacio\\llegirFitxers\\primers-to-100k.txt");
        int[] primos=tablaPrimers2(numeros);
        int num = entrada.nextInt(); 
        while (num!=-1) {
            boolean s=false;
            for(int i=0;i<primos.length;i++){
                if (primos[i]==num) {
                    s=true;;
                }
            }
            System.out.println(s);
            num = entrada.nextInt();
        }
        entrada.close();
    }

    public static int comptaNumerosPrimers(File numeros) throws IOException{
        BufferedReader input = new BufferedReader(new FileReader(numeros));
        int cont=0;
        String num;
        while ((num=input.readLine())!=null) {
            int cont2=0;
            int num2=Integer.parseInt(num);
            for(int i=2;i<num2;i++){
                if(num2%i==0){cont2++;}
            }
            if(cont2==0){cont++;}
        }
        input.close();
        return cont;
    }

    public static boolean[] tablaPrimers(File numeros)throws IOException, FileNotFoundException{
        long inici = System.currentTimeMillis();
        boolean[] primers = new boolean[100001];
        BufferedReader input = new BufferedReader(new FileReader(numeros));
        String num;
        while((num=input.readLine())!=null){
            int num2=Integer.parseInt(num);
            primers[num2]=true;
        }
        input.close();
        long temps = System.currentTimeMillis();
        System.out.println("Temps de carrega: "+(temps-inici)+"ms");
        return primers;
    }

    public static int[] tablaPrimers2(File numeros) throws IOException, FileNotFoundException{
        long inici = System.currentTimeMillis();
        int[] primers = new int[comptaNumerosPrimers(numeros)];
        BufferedReader input = new BufferedReader(new FileReader(numeros));
        String num;
        int cont=0;
        while ((num=input.readLine())!=null) {
            int num2=Integer.parseInt(num);
            primers[cont]=num2;
            cont++;
        }
        input.close();
        long temps = System.currentTimeMillis();
        System.out.println("Temps de carrega: "+(temps-inici)+"ms");
        return primers;
    }
}
