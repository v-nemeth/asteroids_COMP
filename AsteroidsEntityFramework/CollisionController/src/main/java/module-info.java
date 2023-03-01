module CollisionController {
    exports dk.sdu.mmmi.cbse.collisionsystem;

    requires Common;
    requires CommonAsteroid;
    requires CommonPlayer;
    requires CommonBullet;

    provides dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionController;

}