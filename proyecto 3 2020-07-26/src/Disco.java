import java.util.ArrayList;

public class Disco
{
    private ArrayList<String>Disco;
    private int espacioLibre;
    private int indexFlag;

    public Disco(int espacioLibre)
    {
        this.Disco = new ArrayList<>();
        this.espacioLibre = espacioLibre;
        this.indexFlag=0;
        for (int j = 0; j < espacioLibre; j++)
        {
            this.Disco.add(j,"0");
        }
    }

    public String getIndex(int indix)
    {
        return this.Disco.get(indix);
    }

    public void setIndex(int index, String text)
    {
        this.Disco.set(index,text);
    }

    public void cargarPrograma(Programa programa)//cargamos el programa al disco desde el generador
    {
        programa.setHead(this.indexFlag);
        int count = this.indexFlag;
        programa.setEnd((this.indexFlag+programa.getLargo())-1);
        String contenido=Integer.toString(programa.getId());
        while (count<=programa.getEnd())
        {
            this.Disco.set(count,contenido);
            count++;
        }
        this.indexFlag=count;

        System.out.println(" ");
        System.out.println("cargando el progrma:"+contenido);
        for (int j = 0; j < this.Disco.size(); j++)
        {
            System.out.println("["+j+":"+this.Disco.get(j)+"]");
        }
    }

}
