public class Productor extends Thread
{
    private Buffer miBuffer;
    private int aProducir;
    private int producidos;

    public Productor(Buffer miBuffer, int aProducir)
    {
        this.miBuffer = miBuffer;
        this.aProducir = aProducir;
        this.producidos=0;
    }

    @Override
    public void run()
    {
        while (this.aProducir>=this.producidos)
        {
            this.miBuffer.setPermitirEntrarProductor(true);
            this.miBuffer.setPermisoActual(1);
            while(this.miBuffer.isPermitirEntrarConsumidor()&& this.miBuffer.getPermisoActual()==1)
            {

            }
            this.miBuffer.agegar();
            this.producidos++;
            this.miBuffer.setPermitirEntrarProductor(false);
        }
    }
}
