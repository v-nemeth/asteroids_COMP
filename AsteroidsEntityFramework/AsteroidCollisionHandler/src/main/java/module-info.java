module AsteroidCollisionHandler {
    requires Common;

    provides dk.sdu.mmmi.cbse.common.services.IEventListener with  dk.sdu.mmmi.cbse.asteroid.collisionhandler.AsteroidCollisionEventListener;
}