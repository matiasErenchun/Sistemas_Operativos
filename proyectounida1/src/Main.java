import java.util.ArrayList;

public class Main
{
    private static GeneradorCliente miGenerador;
    private static Lector miLector;
    private static ArrayList<Cliente> misClientes;
    private static Barberia miBarberia;
    private static Barbero miBarbero;


    public static void main(String[] args)
    {

        misClientes=new ArrayList<>();
        miLector=new Lector();

        int sillas=miLector.leerEntero("ingrese el numero de sillas");
        int clientes=miLector.leerEntero("ingrese el numero de clientes");

        miBarberia=new Barberia(sillas,clientes);
        miBarbero=new Barbero(miBarberia);
        miGenerador=new GeneradorCliente(misClientes,clientes,miBarberia);
        miBarbero.start();
        miGenerador.start();



    }
}
