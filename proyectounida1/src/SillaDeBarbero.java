public class SillaDeBarbero
{
    private boolean libre;

    public SillaDeBarbero()
    {
        this.libre=true;
    }

    public synchronized void sentarse(String id) throws InterruptedException
    {
        while (!this.getLibre())
        {
            wait();
        }
        if(id.equalsIgnoreCase("Barbero"))
        {
            System.out.println("el barbero se sento");
        }
        else
        {
            System.out.println("el cliente: "+id+" esta en la silla de Barbero");
        }
        this.libre=false;
    }

    public synchronized void pararse(String id)
    {
        this.setLibre(true);
        if(id.equalsIgnoreCase("Barbero"))
        {
            System.out.println("el barbero se levanto");
        }
        else
        {
            System.out.println("el cliente: "+id+" se levanto de la silla de barbero");
        }
        notify();
    }

    public boolean getLibre() {
        return this.libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
}
