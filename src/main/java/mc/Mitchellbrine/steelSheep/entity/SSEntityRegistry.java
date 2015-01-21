package mc.Mitchellbrine.steelSheep.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import mc.Mitchellbrine.steelSheep.SteelSheep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.passive.EntitySheep;

import java.util.ArrayList;

/**
 * Created by Mitchellbrine on 2015.
 */
public class SSEntityRegistry {

    public static ArrayList<Entity> entities = new ArrayList<Entity>();

    private static int startID = 400;

    public static void registerEntity (Entity entity){
        if (!(entity instanceof SSheepEntity)) { SteelSheep.logger.error("The entity specified (" + entity + ") did not include any of the required fields"); return; }

        EntityRegistry.registerModEntity(entity.getClass(),((SSheepEntity)entity).getEntityName(),getUniqueId(),SteelSheep.instance,80,3,false);

        SteelSheep.logger.info("Registered the entity " + entity + " successfully! (Name: " + ((SSheepEntity) entity).getEntityName() + ")");

    }

    private static int getUniqueId() {
        do
        {
            ++startID;
        }
        while (EntityList.getStringFromID(startID) != null);

        return startID;
    }

    static {
        registerEntity(new EntitySteelSheep(null));
    }

}
