package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.Random;

public class Asteroid extends Entity {

    int size;
    Random rand = new Random();
    private int[] random_values;
    public Asteroid(int size){
        this.size=size;
        super.setColor(new float[]{0.7f,0.5f,0.3f,1});
        super.setRadius((float)size-(size/5));
        
        random_values = new int[]{rand.nextInt((int) Math.floor(size/2),size),
                rand.nextInt((int) Math.floor(size/2),size),
                rand.nextInt((int) Math.floor(size/2),size),
                rand.nextInt((int) Math.floor(size/2),size)};
    }
    public int[] get_random_values(){
        return random_values;
    }

    public int getSize(){return size;}
}
