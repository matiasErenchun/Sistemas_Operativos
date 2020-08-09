import java.util.HashMap;

//esta clase es la que implementa el hash para redireccionar a la memoria

public class TraductoDeDirecciones
{
    private HashMap<Integer,Integer> tablaMemoria;

    public TraductoDeDirecciones()
    {
        this.tablaMemoria = new HashMap<>();
    }

    public Integer getDireccion(Integer pID)
    {
        Integer i=this.tablaMemoria.get(pID);
        return i;
    }

    public void SetDireccion(Integer pID, Integer indexHeadM)
    {
        this.tablaMemoria.putIfAbsent( pID,indexHeadM);//faltan validaciones
    }

    public void borarr()
    {
        this.tablaMemoria.clear();
    }

    public void print()
    {
        System.out.println(this.tablaMemoria.toString());
    }
}
