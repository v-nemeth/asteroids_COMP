package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;



/**
 * Hello
* Operation: start(GameData gameData, World world)
 * The start() method is called when a Plugin should be instantiated in the world
 * This is where all the attributes should be set and initial methods should be called
* Parameters: GameData and World
 * GameData and World must be provided in order for the program to add an Object to the world
* Preconditions: A world must have been created, and the game must be running
* Postconditions: ???
 * ----------------------------------------------------------------------------------------------
* Operation: stop(GameData gameData, World world)
 * The stop() method is called when a Plugin should be removed from the world
 * This is where teardown methods should be called
* Parameters: GameData and World
 * GameData and World must be provided in order for the program to remove an Object from the world
* Preconditions: A world must have been created, and the game must be running
* Postconditions: The game has not ended
 **/
public interface IGamePluginService {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
