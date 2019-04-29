import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<Cliente>misClientes=new ArrayList<>();
        Buffer miBuffer=new Buffer(4);
        GeneradorCliente miGenerador=new GeneradorCliente(10,misClientes,miBuffer);
        miGenerador.start();
    }
}
