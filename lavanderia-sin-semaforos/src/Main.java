import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner miScanner=new Scanner(System.in);
        System.out.println("ingrese el nuemero de lavadoras");
        int labadoras=miScanner.nextInt();
        System.out.println("ingrse el numero de clientes");
        int clientes=miScanner.nextInt();
        ArrayList<Cliente>misClientes=new ArrayList<>();
        Buffer miBuffer=new Buffer(labadoras);
        GeneradorCliente miGenerador=new GeneradorCliente(clientes,misClientes,miBuffer);
        miGenerador.start();
    }
}
