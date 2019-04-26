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
            this.miBarberia.aumentarClientesQueLegaron();
            if(this.miBarberia.isBarberoDormido())
            {
                try{
                    this.miBarberia.despertarBarbero();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
            this.miBarberia.sentarse(this.id);

            try
            {
                int aux=this.miBarberia.sentarseSillaBarbero(this.id);
                sleep(aux);

                this.miBarberia.pararseSillaBarber(this.id);
            }
            catch (Exception e)
            {
                 e.printStackTrace();
            }



        }


    }


}
