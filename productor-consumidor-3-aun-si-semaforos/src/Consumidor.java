public class Consumidor extends Thread
{
    private Buffer miBuffer;
    private int aConsumir;
    private int consumidos;

    public Consumidor(Buffer miBuffer, int aConsumir) {
        this.miBuffer = miBuffer;
        this.aConsumir = aConsumir;
        this.consumidos=0;
    }

    @Override
    public void run()
    {
        while (this.aConsumir>=this.consumidos)
        {
            this.miBuffer.setPermitirEntrarConsumidor(true);
            this.miBuffer.setPermisoActual(0);
            while(this.miBuffer.isPermitirEntrarProductor()&& this.miBuffer.getPermisoActual()==0 || !this.miBuffer.puedoSacar())
            {

            }
            this.miBuffer.sacar();
            this.consumidos++;
            this.miBuffer.setPermitirEntrarConsumidor(false);
        }
    }
}
