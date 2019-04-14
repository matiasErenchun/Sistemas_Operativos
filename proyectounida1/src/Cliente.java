public class Cliente
{
    private String iD;
    private boolean feliz;


    public Cliente(String id)
    {
        this.iD = id;
        this.feliz=false;

    }

    public String getID()
    {
        return this.iD;
    }

    public void setId(String id)
    {
        this.iD = id;
    }

    public boolean getFeliz()
    {
        return feliz;
    }

    public void setFeliz(boolean feliz)
    {
        this.feliz = feliz;
    }

    public void print()
    {
        System.out.println("cliente numero: "+this.getID()+" esta feliz="+this.getFeliz());
    }
}
