import java.util.ArrayList;
import java.util.Random;

public class GeneradorCliente extends Thread
{
    private ArrayList<Cliente> clientesGenerados;
    private int clientesAGenerar;
    private Random miRandom;
    private Barberia miBarberia;

    public GeneradorCliente(ArrayList<Cliente> clientesGenerados, int clientesAGenerar,Barberia barberia)
    {
        this.miBarberia=barberia;
        this.clientesGenerados = clientesGenerados;
        this.clientesAGenerar = clientesAGenerar;
    }

    @Override
    public void run()
    {
        int nClientesGenerados=0;
        while(nClientesGenerados<clientesAGenerar)
        {
            this.miRandom=new Random(System.currentTimeMillis());
            int dormir=this.miRandom.nextInt(50);
            try
            {

                sleep(dormir);
                Cliente nuevoCliente=new Cliente(nClientesGenerados,this.miBarberia);

                nuevoCliente.start();
                this.clientesGenerados.add(nuevoCliente);

                nClientesGenerados++;
            }catch (Exception e)
            {
                e.printStackTrace();
            }


        }

    }
}
