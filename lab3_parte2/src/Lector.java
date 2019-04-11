import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lector
{
    private BufferedReader miBuffer;
    private FileReader miFile;

    public Lector(String direccionArchivo) throws FileNotFoundException
    {
        try
        {
            this.miFile = new FileReader(direccionArchivo);
            this.miBuffer=new BufferedReader(this.miFile);
        }catch (FileNotFoundException e)
        {
            System.out.println("error al leer o encontrar el archivo");
        }
    }

   public ArrayList<Proceso> leerProcesos()throws IOException
   {
       ArrayList<Proceso> miArray = new ArrayList<>();
       String texto=this.miBuffer.readLine();
       while(texto!=null)
       {
           StringTokenizer tokenizer = new StringTokenizer(texto);
           String[] s=new String[3];
           int i=0;
           while(tokenizer.hasMoreTokens())
           {
               s[i]=tokenizer.nextToken();
               i++;
           }
           Proceso nuevoProceso=new Proceso(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));

           miArray.add(nuevoProceso);
           texto=this.miBuffer.readLine();
       }
        return miArray;
   }
}
