import java.util.ArrayList;

public class Disco
{
    private ArrayList<String>Disco;
    private ArrayList<Segmento> segmentos;
    private int espacioLibre;
    private int indexFlag;

    public Disco(int espacioLibre)
    {
        this.Disco = new ArrayList<>();
        this.espacioLibre = espacioLibre;
        this.indexFlag=0;
        this.segmentos =new ArrayList<>();
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


    /*
    esta funcion carga un programa en el disco duro creando los segmentos,
    ademas de copiar las instrucciones( en este caso soloe s id  del programa al que pertenese)
     */
    public void cargarPrograma(Programa programa)//cargamos el programa al disco desde el generador
    {
        int head = this.indexFlag;
        int end = this.indexFlag+programa.getLargo()-1;
        this.espacioLibre-=programa.getLargo();
        Segmento segmento = new Segmento(programa.getId(),head,end);
        this.agregarSegmento(segmento);

        int count = this.indexFlag;
        String contenido=Integer.toString(programa.getId());
        while (count<=end)
        {
            this.Disco.set(count,contenido);
            count++;
        }
        this.indexFlag=count;
        System.out.println(" ");
        System.out.println("cargando el progrma:"+contenido);
        this.mostrarDisco();
    }


    /*
    se agrega uns egmentoo ya creado a lista de segmento
     */
    public void agregarSegmento(Segmento segmento)
    {
        this.segmentos.add(segmento);
    }

    /*
    busca un segmento segun un int correspodniente al program id
    si encuentra uan coincidencia retorna el segmento correspondiente,
    de otra manera retorna un segmento de error (valores -1 en sus campos)
     */
    public Segmento getSegmentoPID(int pid)
    {
        for (Segmento segmento: this.segmentos)
        {
            if(segmento.getpID()==pid)
            {
                return segmento;
            }

        }
        Segmento error = new Segmento(-1,-1,-1);
        return error;
    }

    public void mostrarDisco()
    {
        System.out.print("{");
        for (int j = 0; j < this.Disco.size(); j++)
        {
            System.out.print("["+j+":"+this.Disco.get(j)+"]");
        }

        System.out.println("}");
        for (Segmento segmento:this.segmentos)
        {
            segmento.print();
        }

        System.out.println("Espacio libre: "+this.espacioLibre);
    }

    public int getIndexFlag()
    {
        return this.indexFlag;
    }


    public int getEspacioLibre()
    {
        return this.espacioLibre;
    }

}
