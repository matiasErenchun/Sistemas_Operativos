public class Main {

    public static void main(String[] args)
    {
        Mesa miMesa = new Mesa();
        Diler miDiler= new Diler(miMesa);
        Fumador fumador1= new Fumador(0,0,1,1,miMesa);
        Fumador fumador2= new Fumador(0,1,0,2,miMesa);
        Fumador fumador3=new Fumador(1,0,0,3,miMesa);
        miDiler.start();
        fumador1.start();
        fumador2.start();
        fumador3.start();
    }
}
