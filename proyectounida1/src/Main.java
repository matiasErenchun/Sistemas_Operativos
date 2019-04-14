import java.util.ArrayList;

public class Main
{
    private static GeneradorCliente miGenerador;
    private static Lector miLector;
    private static ArrayList<Cliente> misClientes;
    public static void main(String[] args)
    {
        misClientes=new ArrayList<>();
        miLector=new Lector();
        miGenerador=new GeneradorCliente();
        miGenerador.generarClientes(miLector.leerEntero("ingres un numero"),misClientes);
        for (Cliente c:misClientes)
        {
            c.print();
        }
    }
}
