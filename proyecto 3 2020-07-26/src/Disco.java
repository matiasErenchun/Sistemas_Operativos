import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Disco
{
    private ArrayList<String>Disco;
    private HashMap<Integer,ArrayList<Segmento>> hSegmentos;
    private TablaDeSegmentosViruales segmentosViruales;
    private int espacioLibre;
    private int indexFlag;

    public Disco(int espacioLibre,TablaDeSegmentosViruales tablaDeSegmentosViruales)
    {
        this.segmentosViruales=tablaDeSegmentosViruales;
        this.Disco = new ArrayList<>();
        this.espacioLibre = espacioLibre;
        this.indexFlag=0;
        this.hSegmentos =new HashMap<>();
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
    
    Acá se realiza la carga de un programa al Disco Duro creando los segmentos
    además de copiar sus instrucciones 
    
    (Para efectos de simulación el contenido de las instrucciones es el ID del programa)
    
    */
    public void cargarPrograma(Programa programa)//Se realiza la carga al Disco desde el Generador
    {
        System.out.println("largo programa:"+programa.getLargo());
        Random random =new Random(System.currentTimeMillis());
        int segmentID=0;
        int largoTotal=0;
        int head;
        int end;
        int largoSegmento;
        while(largoTotal< programa.getLargo())
        {
            largoSegmento=random.nextInt(programa.getLargo()-largoTotal)+1;
            System.out.println("largo:"+largoSegmento);
            head=this.getIndexFlag();
            end=head+largoSegmento-1;
            Segmento nuevoSegmento= new Segmento(programa.getId(),segmentID,head,end);
            SegmentoVirtual nuevoSegemenVirtual= new SegmentoVirtual(programa.getId(), segmentID,largoTotal,(largoTotal+largoSegmento)-1);
            for (int i = head; i <=end ; i++)
            {
                StringBuilder stringBuilder = new StringBuilder("");
                stringBuilder.append(Integer.toString(programa.getId()));
                stringBuilder.append(Integer.toString(segmentID));
                stringBuilder.append(Integer.toString(i-head));
                this.Disco.set(i,stringBuilder.toString());
            }
            segmentID++;
            this.indexFlag=end+1;
            this.espacioLibre-=largoSegmento;
            this.agregarSegmento(programa.getId(),nuevoSegmento);
            this.segmentosViruales.agregarSegmentoVirtual(programa.getId(), nuevoSegemenVirtual);
            largoTotal+=largoSegmento;
            random.setSeed(System.currentTimeMillis());
        }
        this.mostrarDisco();
        this.mostrarSegmentos(programa.getId());
        this.segmentosViruales.mostrar(programa.getId());



    }


    /*
    Se agrega un segmento ya creado a la lista de segmentos
    */
    public void agregarSegmento(Integer pID,Segmento segmento)
    {
        if(this.hSegmentos.containsKey(pID))
        {
            ArrayList<Segmento> segmentos = hSegmentos.get(pID);
            segmentos.add(segmento);
            this.hSegmentos.put(pID,segmentos);
        }
        else
        {
            ArrayList<Segmento> segmentos = new ArrayList<>();
            segmentos.add(segmento);
            this.hSegmentos.put(pID,segmentos);
        }
    }

    /*
    Busca un segmento basándose en un int que corresponde al program id,
    si se encuentra una coincidencia retorna el segmento correspondiente,
    caso contrario, retorna un segmento de error (Valor -1 en sus campos)
    */
    public Segmento getSegmento(int pid, int sID)
    {
        ArrayList<Segmento>segmentos = this.hSegmentos.get(pid);
        for (Segmento segmento: segmentos)
        {
            if(segmento.getsID()==sID)
            {
                return segmento;
            }

        }
        Segmento error = new Segmento(-1,-1,-1,-1);
        return error;
    }

    public void mostrarDisco()
    {
        System.out.println("disco");
        for (int i = 0; i < this.Disco.size(); i++) {
            System.out.print("["+i+":"+this.Disco.get(i)+"]");
        }
        System.out.println(" ");
    }

    public void mostrarSegmentos(int pID)
    {
        ArrayList<Segmento>secccmentos=this.hSegmentos.get(pID);
        for (Segmento seg: secccmentos)
        {
            seg.print();
        }
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
