public class Segmento
{
    private int pID;
    private int sID;
    private int head;
    private int end;

    public Segmento(int pID,int sID, int head, int end)
    {
        this.pID = pID;
        this.sID = sID;
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

    public int getsID()
    {
        return sID;
    }

    public void setsID(int sID)
    {
        this.sID = sID;
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
        System.out.println("{ pid:"+this.getpID()+" sID:"+this.getsID()+" head:"+this.head+" end:"+this.end+" }");
    }
}
