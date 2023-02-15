package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Operation: process(GameData, World)
 * process() is called after time the game updates. Game logic, physics and inputhandling should be performed in this method
 * Do not use process to animate
 *Parameters: GameData and World
 * GameData and World must be provided in order for the program to update an Object in the world
 * Preconditions: A world must have been created, and the game must be running
 * Postconditions: The game has not ended
 * @author jcs
 */
public interface IPostEntityProcessingService  {
        void process(GameData gameData, World world);
}
