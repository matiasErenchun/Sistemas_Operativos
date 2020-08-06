import java.util.HashMap;

//esta clase es la que implementa el hash para redireccionar a la memoria

public class TraductoDeDirecciones
{
    private HashMap<String,Integer> tablaMemoria;

    public TraductoDeDirecciones()
    {
        this.tablaMemoria = new HashMap<>();
    }

    public Integer getDireccion(String s)
    {
        Integer i=this.tablaMemoria.get(s);
        return i;
    }

    public void SetDireccion(String s, Integer i)
    {
        this.tablaMemoria.putIfAbsent(s,i);//faltan validaciones
    }


    public void print()
    {
        System.out.println(this.tablaMemoria.toString());
    }
}
