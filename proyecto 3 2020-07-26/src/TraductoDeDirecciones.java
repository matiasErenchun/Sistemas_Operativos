//esta clase es la que implementa el hash para redireccionar a la memoria

public class TraductoDeDirecciones
{
    private TablaSegmentosEnMemoria tablaSegmentosEnMemoria;
    private TablaDeSegmentosViruales tablaDeSegmentosViruales;
    private PlanificadorMemoria planificadorMemoria;

    public TraductoDeDirecciones(TablaSegmentosEnMemoria tablaSegmentosEnMemoria, TablaDeSegmentosViruales tablaDeSegmentosViruales, PlanificadorMemoria planificadorMemoria) {
        this.tablaSegmentosEnMemoria = tablaSegmentosEnMemoria;
        this.tablaDeSegmentosViruales = tablaDeSegmentosViruales;
        this.planificadorMemoria = planificadorMemoria;
    }

    public Integer getDireccion(int pID, int instruccion)
    {
        SegmentoVirtual segmentoV=this.tablaDeSegmentosViruales.getSegmentoVirtual(pID,instruccion);
        boolean existe=tablaSegmentosEnMemoria.existeSegmentoEnMemoria(pID,segmentoV.getsID());
        System.out.println("existe:"+existe);
        if(!existe)
        {
            this.planificadorMemoria.cargarSegmentoDesdeDisco(pID, segmentoV.getsID());
            this.tablaSegmentosEnMemoria.mostrarSegmentosEnMemoria();

        }
        Segmento segmentoM=this.tablaSegmentosEnMemoria.getSegmentoMemoria(pID,segmentoV.getsID());
        int desplazamiento = instruccion-segmentoV.getIntruccionDeInicio();
        int direccion =segmentoM.getHead()+desplazamiento;
        return direccion;

    }
}
