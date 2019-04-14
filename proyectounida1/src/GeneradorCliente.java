import java.util.ArrayList;

public class GeneradorCliente extends Thread
{
    private static int clientesGenerados;
    public  GeneradorCliente()
    {
        clientesGenerados=0;
    }

    public void run(int nClientes, ArrayList<Cliente> clientes,Barberia barberia)
    {
        while(clientesGenerados<nClientes)
        {
            Cliente miCliente=new Cliente(clientesGenerados,barberia);
            clientes.add(miCliente);
            clientesGenerados++;
        }
        System.out.println("se generaron: "+clientesGenerados);
    }
}
