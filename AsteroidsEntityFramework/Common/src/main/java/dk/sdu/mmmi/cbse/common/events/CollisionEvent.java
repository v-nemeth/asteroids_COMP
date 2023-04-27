package dk.sdu.mmmi.cbse.common.events;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.Event;
import dk.sdu.mmmi.cbse.common.data.EventType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollisionEvent extends Event {
    private String source;
    private String target;

    public CollisionEvent(String entity1ID, String entity2ID) {
        this.eventType = EventType.COLLISION;
        this.source = entity1ID;
        this.target = entity2ID;
    }

    public String getEntityID() {
        return source;
    }

    public String getTargetID(){
        return target;
    }
}
