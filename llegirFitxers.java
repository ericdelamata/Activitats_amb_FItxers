import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

public class llegirFitxers {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        long temps=System.currentTimeMillis();
        File arxiu = new File("C:\\Users\\Eric\\Documents\\programacio\\llegirFitxers\\palabras.txt");
        System.out.println("Numero de linies:");
        System.out.println(comptarLineas(arxiu));
        System.out.println("Numero de 'L' amb file reader:");
        System.out.println(comptarLcaracter(arxiu));
        System.out.println("Numero de 'L' amb Buffered Reader:");
        System.out.println(comptarL(arxiu));
        System.out.println("Numero de paraules:");
        System.out.println(comptarParaules(arxiu));
        System.out.println("Temps de carrega total:");
        System.out.println(System.currentTimeMillis()-temps+"ms");
    }

    public static int comptarLineas(File arxiu)throws IOException{
        int cont=0;
        BufferedReader input = new BufferedReader(new FileReader(arxiu));
        while ((input.readLine())!=null) {
            cont++;
        }
        input.close();
        return cont;
    }

    public static int comptarL(File arxiu) throws IOException{
        int cont=0;
        BufferedReader input = new BufferedReader(new FileReader(arxiu));
        String linea;
        while((linea=input.readLine())!=null){
            for(int i=0;i<linea.length();i++){
                if (linea.charAt(i)=='l'||linea.charAt(i)=='L') {
                    cont++;
                }
            }
        }
        input.close();
        return cont;
    }

    public static int comptarLcaracter(File arxiu) throws IOException{
        int cont=0;
        FileReader inputFileReader = new FileReader(arxiu);
        int caracter;
        while((caracter=inputFileReader.read())!=-1){
            if (caracter=='l'||caracter=='L') {
                cont++;
            }
        }
        inputFileReader.close();
        return cont;
    }

    public static int comptarParaules(File arxiu) throws IOException{
        int cont=0;
        BufferedReader input = new BufferedReader(new FileReader(arxiu));
        String linea;
        while ((linea=input.readLine())!=null) {
            if(linea.length()>1){
                cont++;
            }
        }
        input.close();
        return cont;
    }
}
