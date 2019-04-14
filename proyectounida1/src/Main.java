import java.util.ArrayList;

public class Main
{
    private static GeneradorCliente miGenerador;
    private static Lector miLector;
    private static ArrayList<Cliente> misClientes;
    private static Barberia miBarberia;

    public static void main(String[] args)
    {

        misClientes=new ArrayList<>();
        miLector=new Lector();
        miGenerador=new GeneradorCliente();
        int sillas=miLector.leerEntero("ingrese el numero de sillas");
        miBarberia=new Barberia(sillas);
        int clientes=miLector.leerEntero("ingrese el numero de clientes");
        miGenerador.start();
        miGenerador.run(clientes,misClientes,miBarberia);


        for (Cliente c:misClientes)
        {
            c.start();
        }


    }
}
