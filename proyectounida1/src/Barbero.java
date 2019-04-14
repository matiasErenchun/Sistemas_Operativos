public class Barbero extends Thread
{
    public boolean ocupado;
    public boolean dormido;

    public Barbero()
    {
        this.ocupado = false;
        this.dormido = true;
    }

    public boolean isOcupado()
    {
        return ocupado;
    }

    public void setOcupado(boolean ocupado)
    {
        this.ocupado = ocupado;
    }

    public boolean isDormido()
    {
        return dormido;
    }

    public void setDormido(boolean dormido)
    {
        this.dormido = dormido;
    }

    public synchronized void domir() throws InterruptedException
    {
        while(dormido)
        {
            wait();
        }
    }
    public void run()
    {

    }

    public void atender(int id)
    {
        this.setOcupado(true);
        try {
            sleep(100);
        }catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }


}
