import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer
{
    private Lock lock = new ReentrantLock(true);
    private ArrayList<Lavadora>misLabadoras;
    private int cantidadMaximaLabadoras;


    public Buffer(int maxLabadoras)
    {
        this.misLabadoras = new ArrayList<>();
        this.cantidadMaximaLabadoras = maxLabadoras;
        this.agregarLavadoras();

    }

    public void agregarLavadoras()
    {
        int i=0;
        while (this.cantidadMaximaLabadoras>i)
        {
            this.lock.lock();
            try {
                System.out.println("i =" + i);
                Lavadora nuevaLavadora = new Lavadora(i);
                i++;
                this.misLabadoras.add(nuevaLavadora);
            }catch (Exception e)
            {
                e.printStackTrace();
            }finally {
                this.lock.unlock();
            }
        }
    }

    public  boolean isEmpty()
    {
        return this.misLabadoras.isEmpty();
    }

    public  boolean agregarLabadora(Lavadora lavadora)
    {
        if(this.cantidadMaximaLabadoras==this.misLabadoras.size())
        {
            return false;
        }
        else
        {
            this.lock.lock();
            try{
                return this.misLabadoras.add(lavadora);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {
                this.lock.unlock();
            }

        }
        return false;
    }

    public  Lavadora getLavadora()
    {
        while (this.isEmpty())
        {
            this.lock.lock();
            try{
                wait();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {
                this.lock.unlock();
            }

        }
        return this.misLabadoras.remove(0);
    }


}
