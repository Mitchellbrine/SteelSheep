package mc.Mitchellbrine.steelSheep.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

/**
 * Created by Mitchellbrine on 2015.
 */
public class EntitySteelSheep extends EntityAgeable implements SSheepEntity {

    public EntitySteelSheep(World world) {
        super(world);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entity) {
        return null;
    }

    @Override
    public String getEntityName() {
        return "steelSheep";
    }

    @Override
    public int[] getEggColors() {
        return new int[]{0xFFFFFF,0xFF0000};
    }
}
