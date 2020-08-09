import java.util.ArrayList;

public class MemoriaPrincipal
{
    private String [] memoria;
    private int memoriaLibre;
    private TraductoDeDirecciones diccioario;
    private int firsFreeBlock;//es
    private ArrayList<Segmento> segmentos;

    public MemoriaPrincipal(int tamaño, TraductoDeDirecciones diccioario)
    {
        this.memoria = new String[tamaño];
        this.memoriaLibre=tamaño;
        this.diccioario=diccioario;
        this.firsFreeBlock =0;
        this.segmentos=new ArrayList<>();
        for (int i = 0; i < tamaño; i++)
        {
            this.memoria[i]="0";
        }
    }

    public int getMemoriaLibre()
    {
        return memoriaLibre;
    }

    public void setFirsFreeblock(int firsFreeblock)
    {
        this.firsFreeBlock = firsFreeblock;
    }

    public int getFirsFreeblock()
    {
        return firsFreeBlock;
    }

    public void setMemoriaLibre(int memoriaLibre)
    {
        this.memoriaLibre = memoriaLibre;
    }

    public void setcontenido( String instruccion )
    {
        //la llave  se crear al concatenar el id del programa con el indice de la instruccion
        this.memoria[this.firsFreeBlock]=instruccion;//agregamos el contenido en direccion de bloke libre
        this.firsFreeBlock++;
        this.memoriaLibre--;
    }

    public void addSegmento(Segmento segmento)
    {
        this.segmentos.add(segmento);
        this.diccioario.SetDireccion(segmento.getpID(), segmento.getHead());
    }

    public void borrarTraductor()
    {
        this.diccioario.borarr();
    }

    public void borrarSegmentos()
    {
        this.segmentos.clear();
    }

    public int  buscarpID(int indexM)
    {
        int head;
        int end;

        for (Segmento semento:this.segmentos)
        {
            head =semento.getHead();
            end = semento.getEnd();
            if( indexM>=head && indexM<=end)
            {
                return semento.getpID();
            }
        }
        return -1;
    }

    public int ExistePID(int pID)
    {
        for (Segmento segmento:this.segmentos)
        {
            if(segmento.getpID()==pID)
            {
                return 1;
            }
        }
        return -1;
    }

    public Segmento getSegmentoPID(int pID)
    {
        for (Segmento segmento: this.segmentos)
        {
            if(segmento.getpID()==pID)
            {
                return segmento;
            }

        }
        Segmento error = new Segmento(-1,-1,-1);
        return error;
    }

    // esta funsion muestra la informacion de la memoria principal
     public void print()
     {
         System.out.print("{");
         for (int i = 0; i < this.memoria.length ; i++) {
             System.out.print("["+i+":"+this.memoria[i]+"]");
         }
         System.out.println("}");

         for (Segmento segmento:this.segmentos)
         {
             segmento.print();
         }

         System.out.println("memoria libre: "+this.getMemoriaLibre());
         System.out.println("ultimo bloke libre: "+this.getFirsFreeblock());
     }

     public String getIndex(int index)
     {
         return this.memoria[index];
     }

     public ArrayList<Integer> getPids()
     {
         ArrayList<Integer> listaAux= new ArrayList<>();
         for (Segmento segemento :this.segmentos)
         {
             listaAux.add(segemento.getpID());
         }

         return listaAux;
     }

     public void resetParametros()
     {
         this.setFirsFreeblock(0);
         this.setMemoriaLibre(this.memoria.length);
         for (int i = 0; i < this.memoria.length ; i++)
         {
             this.memoria[i]="0";
         }
     }


}
