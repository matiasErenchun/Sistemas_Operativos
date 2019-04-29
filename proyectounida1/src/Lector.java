import java.util.Scanner;

public class Lector
{
    private Scanner scanner;

    public Lector( )
    {
        this.scanner = new Scanner(System.in);
    }

    public String leerString(String mensaje)
    {
        System.out.println(mensaje);
        return this.scanner.nextLine();
    }

    public int leerEntero(String mensaje)
    {
        System.out.println(mensaje);
        String entrada=this.scanner.nextLine();
        boolean b=entrada.matches("^[0-9]*$");
        while(!b)
        {
            System.out.println("error en la entrada recuerde ingresar solo numeros enteros");
            System.out.println(mensaje);
            entrada=this.scanner.nextLine();
            b=entrada.matches("^[0-9]*$");
        }

        return Integer.parseInt(entrada);
    }
}
