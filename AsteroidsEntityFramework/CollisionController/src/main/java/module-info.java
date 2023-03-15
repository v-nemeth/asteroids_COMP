module CollisionController {
    exports dk.sdu.mmmi.cbse.collisionsystem;

    requires Common;

    provides dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionController;

}