package dk.sdu.mmmi.cbse.common.data;


public class GameData {

    private float delta;
    private int displayWidth;
    private int displayHeight;

    private int gameTime = 0;
    private final GameKeys keys = new GameKeys();
    public GameKeys getKeys() {
        return keys;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }

    public float getDelta() {
        return delta;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public int getGameTime(){
        return gameTime;
    }
    public void incrementGameTime(){
        gameTime++;
    }

    public EventManager getEventManager(){
        return EventManager.getInstance();
    }
}
