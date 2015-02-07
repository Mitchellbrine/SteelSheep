package mc.Mitchellbrine.steelSheep.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import mc.Mitchellbrine.steelSheep.SteelSheep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;

/**
 * Created by Mitchellbrine on 2015.
 */
public class SSEntityRegistry {

    private static int startID = 400;

    @SuppressWarnings("unchecked")
    public static void registerEntity (Entity entity){
        if (!(entity instanceof SSheepEntity)) { SteelSheep.logger.error("The entity specified (" + entity + ") did not include any of the required fields"); return; }

        int newId = getUniqueId();

        EntityRegistry.registerModEntity(entity.getClass(),((SSheepEntity)entity).getEntityName(),newId,SteelSheep.instance,80,3,false);
        EntityList.IDtoClassMapping.put(newId,entity.getClass());
        EntityList.entityEggs.put(newId,new EntityList.EntityEggInfo(newId,((SSheepEntity) entity).getEggColors()[0],((SSheepEntity) entity).getEggColors()[1]));

        if (entity instanceof EntityLiving) {
            EntityRegistry.addSpawn(((EntityLiving)entity).getClass(), 80, 2, 4, EnumCreatureType.ambient, ((SSheepEntity) entity).getBiomeList());
        }

        SteelSheep.logger.info("Registered the entity " + entity + " successfully! (Name: " + EntityList.stringToClassMapping.get(entity.getClass()) + ")");

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
