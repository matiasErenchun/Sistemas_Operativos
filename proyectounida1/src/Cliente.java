public class Cliente extends Thread
{
    private Barberia miBarberia;
    private int id;
    public Cliente(int id, Barberia barberia)
    {
        this.miBarberia=barberia;
        this.id=id;
    }

    @Override
    public  void run() {
        int i=0;
        if(this.miBarberia.getSillasLibres()<=0)
        {
            this.miBarberia.aumentarClientesQueLegaron();
            System.out.println("se fue indignado:"+this.id);
        }
        else
        {
            this.miBarberia.sentarse();
            this.miBarberia.aumentarClientesQueLegaron();
            System.out.println("se sento "+this.id+" y quedan "+this.miBarberia.getSillasLibres()+" sillas");
            while (this.miBarberia.isBarberoOcupado())
            {
                try
                {
                    this.wait();
                }
                catch (Exception e)
                {
                    //e.printStackTrace();
                }

                i++;
            }
            this.miBarberia.pararse();
            this.miBarberia.sentarseSillaBarbero();
            System.out.println("se sento en la silla del barbero "+this.id+" quedan "+this.miBarberia.getSillasLibres()+" sillas libres");
            int dormir=this.miBarberia.getTiempoAtension();
            try
            {
                sleep(dormir);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            this.miBarberia.pararseSillaBarber();
            System.out.println("se fue feliz " + this.id);

        }
    }
}
