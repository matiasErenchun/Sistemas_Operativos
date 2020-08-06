import java.util.ArrayList;

public class MemoriaPrincipal
{
    private String [] memoria;
    private int memoriaLibre;
    private TraductoDeDirecciones diccioario;
    private int firsFreeBlock;//es

    public MemoriaPrincipal(int tamaño, TraductoDeDirecciones diccioario)
    {
        this.memoria = new String[tamaño];
        this.memoriaLibre=tamaño;
        this.diccioario=diccioario;
        this.firsFreeBlock =0;
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

    public void setcontenido(String key, String instruccion )
    {
        //la llave  se crear al concatenar el id del programa con el indice de la instruccion
        this.memoria[this.firsFreeBlock]=instruccion;//agregamos el contenido en direccion de bloke libre
        this.diccioario.SetDireccion(key,this.firsFreeBlock);//almacenamos al direccion donde se guardo
        this.firsFreeBlock++;
        this.memoriaLibre--;
    }

    // esta funsion muestra la informacion de la memoria principal
     public void print()
     {
         System.out.print("{");
         for (int i = 0; i < this.memoria.length ; i++) {
             System.out.print("["+i+":"+this.memoria[i]+"]");
         }
         System.out.print("}");
         System.out.println(" ");
         System.out.println("memoria libre: "+this.getMemoriaLibre());
         System.out.println("ultimo bloke libre: "+this.getFirsFreeblock());
     }


}
