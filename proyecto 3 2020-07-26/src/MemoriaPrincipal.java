import java.util.ArrayList;

public class MemoriaPrincipal
{
    private ArrayList<String> memoria;
    private int memoriaLibre;
    private TraductoDeDirecciones diccioario;
    private int flagLastIndex;

    public MemoriaPrincipal(int tamaño, TraductoDeDirecciones diccioario)
    {
        this.memoria = new ArrayList<>(tamaño);
        this.memoriaLibre=tamaño;
        this.diccioario=diccioario;
        this.flagLastIndex=0;
    }

    public int getMemoriaLibre()
    {
        return memoriaLibre;
    }

    public void setFlagLastIndex(int flagLastIndex)
    {
        this.flagLastIndex = flagLastIndex;
    }

    public int getFlagLastIndex()
    {
        return flagLastIndex;
    }

    public void setMemoriaLibre(int memoriaLibre)
    {
        this.memoriaLibre = memoriaLibre;
    }

    public void setcontenido(int index, String instruccion )
    {

    }


}
