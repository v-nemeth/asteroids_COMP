package dk.sdu.mmmi.cbse.common.data;

import dk.sdu.mmmi.cbse.common.events.Event;
import dk.sdu.mmmi.cbse.common.services.IEventListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Singleton implementation of EventManager
public class EventManager {
    private Queue<Event> eventQueue;
    private List<IEventListener> listeners;

    private static EventManager instance;

    private EventManager() {
        this.eventQueue = new LinkedList<>();
        this.listeners = new LinkedList<>();
    }

    public static EventManager getInstance() {
        if(instance == null){
            instance = new EventManager();
        }
        return instance;
    }

    public void addListeners(List<IEventListener> listeners){
        this.listeners.addAll(listeners);
    }

    public void addEvent(Event event) {
        eventQueue.offer(event);
    }


    public void dispatchEvents(GameData gameData, World world){
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            for (IEventListener listener : listeners) {
                listener.onEvent(event, gameData, world);
            }
        }
    }
}
