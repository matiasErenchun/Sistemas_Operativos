public class Programa
{
    private int id;
    private int largo;
    private int prioridad;
    private int pc;
    private int time;

    public Programa(int id, int largo, int prioridad)
    {
        this.id = id;
        this.largo=largo;
        this.prioridad=prioridad;
        this.pc=0;
        this.time = largo;
    }

    public int getId()
    {
        return this.id;
    }

    public int getLargo()
    {
        return this.largo;
    }

    public int getPrioridad()
    {
        return this.prioridad;
    }

    public int getPc()
    {
        return pc;
    }

    public void setPc(int pc)
    {
        this.pc = pc;
    }

    public int getTime()
    {
        return time;
    }

    public void decrementarTime()
    {
        this.time--;
    }

    public void printProgram()
    {
        System.out.println("id:"+this.getId()+" prioridad:"+this.getPrioridad()+" largo:"+this.largo);
    }

    public void incrementarPC()
    {
        this.pc++;
    }
}
