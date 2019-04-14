import java.util.ArrayList;

public class GeneradorCliente extends Thread
{
    private static int clientesGenerados;
    public  GeneradorCliente()
    {
        clientesGenerados=0;
    }

    public void generarClientes(int nClientes, ArrayList<Cliente> clientes)
    {
        while(clientesGenerados<nClientes)
        {
            Cliente miCliente=new Cliente(Integer.toString(clientesGenerados));
            clientes.add(miCliente);
            clientesGenerados++;
        }
        System.out.println("se generaron: "+clientesGenerados);
    }
}
