public class Cliente extends Thread
{
    private int iD;
    private Barberia miBarberia;

    public Cliente(int iD, Barberia miBarberia)
    {
        this.iD = iD;
        this.miBarberia = miBarberia;
    }

    @Override
    public synchronized void run()
    {
        try {
            this.entrar();
        }catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }
    public void entrar()throws InterruptedException
    {
        System.out.println("sillas libres = "+this.miBarberia.getSillasLibres());
        if(this.miBarberia.getSillasLibres()==0)
        {
            System.out.println("no quedan sillas libres, el cliente "+this.getiD()+" se va enojado");
        }
        else
        {
           if(this.miBarberia.barberoDormido())
           {
               notifyAll();
           }

               this.miBarberia.aumentarClientesEsperando();
               while(this.miBarberia.barberoOcupado())
               {

                   wait();
               }
               this.miBarberia.Atender(this.getiD());
               this.miBarberia.levantarseYSalir(this.getiD());
               notify();

        }
    }

    public int getiD()
    {
        return this.iD;
    }

}
