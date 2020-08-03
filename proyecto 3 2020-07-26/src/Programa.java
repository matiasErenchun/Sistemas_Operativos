public class Programa
{
    private int id;
    private int head;
    private int end;
    private int largo;
    private int prioridad;

    public Programa(int id, int largo, int prioridad)
    {
        this.id = id;
        this.head = -1;
        this.end = -1;
        this.largo=largo;
        this.prioridad=prioridad;
    }

    public int getId()
    {
        return this.id;
    }

    public int getHead()
    {
        return this.head;
    }

    public int getEnd()
    {
        return this.end;
    }

    public int getLargo()
    {
        return this.largo;
    }

    public int getPrioridad()
    {
        return this.prioridad;
    }

    public void setHead(int head)
    {
        this.head = head;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    public void printProgram()
    {
        System.out.println("id:"+this.getId()+" prioridad:"+this.getPrioridad()+" direccion head:"+this.getHead()+" end:"+this.getEnd());
    }
}
