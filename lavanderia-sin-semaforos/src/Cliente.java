public class Cliente extends Thread
{
    private int id;
    private Buffer miBuffer;
    private Lavadora miLabadora;
    private boolean atendido;

    public Cliente(Buffer miBuffer, int id)
    {
        this.miBuffer = miBuffer;
        this.id=id;
        this.atendido=false;
    }

    @Override
    public void run()
    {
        while(this.atendido==false)
        {

            this.miLabadora = this.miBuffer.getLavadora(this.id);
            System.out.println("el cliente " + this.id + " esta usando la lavadora :" + this.miLabadora.getId());
            try {
                sleep(this.miLabadora.tiempoDelabado());
                this.miBuffer.agregarLabadora(this.miLabadora);
                System.out.println("el cliente " + this.id + " dejo de  usar la lavadora :" + this.miLabadora.getId());
                this.atendido=true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
