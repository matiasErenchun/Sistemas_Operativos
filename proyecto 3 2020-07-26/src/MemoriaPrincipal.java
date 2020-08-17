import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MemoriaPrincipal
{
    private String [] memoria;
    private int memoriaLibre;
    private TablaSegmentosEnMemoria tablaSegmentosEnMemoria;
    private int firsFreeBlock;//es
    private HashMap<Integer,ArrayList<Segmento>> segmentos;

    public MemoriaPrincipal(int tamaño, TablaSegmentosEnMemoria tablaSegmentosEnMemoria)
    {
        this.memoria = new String[tamaño];
        this.memoriaLibre=tamaño;
        this.tablaSegmentosEnMemoria=tablaSegmentosEnMemoria;
        this.firsFreeBlock =0;
        this.segmentos= new HashMap<>();
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
        //La key se crea al concadenar el ID del programa con el índice de la instrucción
        this.memoria[this.firsFreeBlock]=instruccion;//Agregamos el contenido en dirección al Bloque Libre
        this.firsFreeBlock++;
        this.memoriaLibre--;
    }

    public void addSegmento(int pID, Segmento segmento)
    {
        if(this.segmentos.containsKey(pID))
        {
            ArrayList<Segmento> segmentos1 = this.segmentos.get(pID);
            segmentos1.add(segmento);
            this.segmentos.put(pID,segmentos1);
            this.tablaSegmentosEnMemoria.agregarSegmento(pID,segmento);
        }
        else
        {
            ArrayList<Segmento> segmentos1 = new ArrayList<>();
            segmentos1.add(segmento);
            this.segmentos.put(pID,segmentos1);
            this.tablaSegmentosEnMemoria.agregarSegmento(pID,segmento);
        }
    }

    public void borrarTablaSegementosMemoria()
    {
        this.tablaSegmentosEnMemoria.borrar();
    }

    public void borrarSegmentos()
    {
        this.segmentos.clear();
    }



    //Acá se muestra la información de la Memoria Principal
     public void print()
     {
         System.out.println(" ");
         System.out.print("{");
         for (int i = 0; i < this.memoria.length ; i++) {
             System.out.print("["+i+":"+this.memoria[i]+"]");
         }
         System.out.println("}");

         System.out.println("\n*****INFORMACIÓN*****\nBloques de Memoria Libres: "+this.getMemoriaLibre());
         System.out.println("Último Bloque Libre: "+this.getFirsFreeblock());
     }

     public String getIndex(int index)
     {
         return this.memoria[index];
     }

     /*
     Retorna un Arreglo con todos los Program ID correspondientes
     a los segmentos cargados en memoria
     */
     public ArrayList<Segmento> getSegmentos()
     {
         ArrayList<Segmento> segmentos=new ArrayList<>();
         Collection<ArrayList<Segmento>> segmentosAux=this.segmentos.values();
         for (ArrayList<Segmento> segmentoss: segmentosAux)
         {
             for (Segmento segg: segmentoss)
             {
                 segmentos.add(segg);
             }
         }
         return segmentos;
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
