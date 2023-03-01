//module-info.java
module Bullet {
    exports dk.sdu.mmmi.cbse.bulletsystem;

    requires Common;
    requires CommonBullet;

    provides dk.sdu.mmmi.cbse.common.services.IGamePluginService with dk.sdu.mmmi.cbse.bulletsystem.BulletPlugin;
    provides dk.sdu.mmmi.cbse.common.services.IEntityProcessingService with dk.sdu.mmmi.cbse.bulletsystem.BulletControlSystem;
}