public class SegmentoVirtual
{
    private int pID; //Program id
    private int sID; //Segment id
    private int IntruccionDeInicio;
    private int InstruccionFinal;

    public SegmentoVirtual(int pID, int sID, int intruccionDeInicio, int instruccionFinal)
    {
        this.pID = pID;
        this.sID = sID;
        IntruccionDeInicio = intruccionDeInicio;
        InstruccionFinal = instruccionFinal;
    }

    public int getpID()
    {
        return pID;
    }

    public void setpID(int pID)
    {
        this.pID = pID;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID)
    {
        this.sID = sID;
    }

    public int getIntruccionDeInicio()
    {
        return IntruccionDeInicio;
    }

    public void setIntruccionDeInicio(int intruccionDeInicio)
    {
        IntruccionDeInicio = intruccionDeInicio;
    }

    public int getInstruccionFinal()
    {
        return InstruccionFinal;
    }

    public void setInstruccionFinal(int instruccionFinal)
    {
        InstruccionFinal = instruccionFinal;
    }

    public void print()
    {
        System.out.println("{ SVid:"+this.getpID()+" svID:"+this.getsID()+" inicio:"+this.getIntruccionDeInicio()+" fin:"+this.getInstruccionFinal()+" }");
    }
}
