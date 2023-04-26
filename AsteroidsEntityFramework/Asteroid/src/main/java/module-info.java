//module-info.java
module Asteroid {
    exports dk.sdu.mmmi.cbse.asteroidsystem;

    requires Common;

    provides dk.sdu.mmmi.cbse.common.services.IGamePluginService with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidPlugin;
    provides dk.sdu.mmmi.cbse.common.services.IEntityProcessingService with dk.sdu.mmmi.cbse.asteroidsystem.AsteroidControlSystem;
}