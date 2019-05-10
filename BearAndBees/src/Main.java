import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Thread
{
    public static Scanner miScanner;
    public static void main(String[] args)
    {
        miScanner=new Scanner(System.in);
        System.out.println("ingrege la capacidad del tarro");
        int cTarro=miScanner.nextInt();
        System.out.println("ingrege la cantidad de abejas");
        int cAbejas=miScanner.nextInt();

        Tarro miTarro=new Tarro(cTarro);
        Oso miOSo=new Oso(miTarro);
        miOSo.start();
        ArrayList<Abeja>misAbejas=new ArrayList<>();
        for (int i = 0; i < cAbejas; i++)
        {
            Abeja auxAbeja=new Abeja(i,miTarro);
            auxAbeja.start();
            misAbejas.add(auxAbeja);
        }


    }

}
