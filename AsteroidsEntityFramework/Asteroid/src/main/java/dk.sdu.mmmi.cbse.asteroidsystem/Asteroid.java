package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.Random;

public class Asteroid extends Entity {

    Random rand = new Random();
    private int[] random_values;
    public Asteroid(){
        super.setColor(new float[]{0.7f,0.5f,0.3f,1});
        random_values = new int[]{rand.nextInt(16,32),rand.nextInt(16,32),rand.nextInt(16,32),rand.nextInt(16,32)};
    }
    public int[] get_random_values(){
        return random_values;
    }
}
