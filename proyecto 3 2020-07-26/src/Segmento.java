public class Segmento
{
    private int pID;
    private int head;
    private int end;

    public Segmento(int pID, int head, int end)
    {
        this.pID = pID;
        this.head = head;
        this.end = end;
    }

    public int getpID()
    {
        return pID;
    }

    public void setpID(int pID)
    {
        this.pID = pID;
    }

    public int getHead()
    {
        return head;
    }

    public void setHead(int head)
    {
        this.head = head;
    }

    public int getEnd()
    {
        return end;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    public void print()
    {
        System.out.println("{ pid:"+this.getpID()+" head:"+this.head+" end:"+this.end+"}");
    }
}
