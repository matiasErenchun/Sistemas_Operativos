import java.util.Random;

public class Lavadora
{
    private Random miRandom;
    private int id;

    public Lavadora(int id)
    {
        this.id=id;
        this.miRandom = new Random(System.currentTimeMillis());
    }

    public int tiempoDelabado()
    {
        return this.miRandom.nextInt(100);
    }

    public int getId()
    {
        return this.id;
    }

}
