import java.util.ArrayList;
import java.util.Random;

public class GeneradorCliente extends Thread
{
    private Random miRandom;
    private ArrayList<Cliente>misClientes;
    private int ClientesAgenerar;
    private int ClientesGenerados;
    private Buffer miBuffer;

    public GeneradorCliente(int clientesAgenerar,ArrayList<Cliente>misClientes,Buffer buffer)
    {
        this.miRandom = new Random(System.currentTimeMillis());
        this.misClientes=misClientes;
        this.ClientesAgenerar=clientesAgenerar;
        this.ClientesGenerados=0;
        this.miBuffer=buffer;
    }

    @Override
    public void run()
    {
        while (this.ClientesAgenerar>this.ClientesGenerados)
        {
            try
            {
                sleep(this.miRandom.nextInt(100));
                Cliente nuevoCliente=new Cliente(this.miBuffer,this.ClientesGenerados);
                this.misClientes.add(nuevoCliente);
                this.ClientesGenerados++;
                nuevoCliente.start();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}
