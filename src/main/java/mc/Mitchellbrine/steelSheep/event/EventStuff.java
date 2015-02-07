package mc.Mitchellbrine.steelSheep.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import mc.Mitchellbrine.steelSheep.entity.EntitySteelSheep;
import mc.Mitchellbrine.steelSheep.item.ItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

/**
 * Created by Mitchellbrine on 2015.
 */
public class EventStuff {

    @SubscribeEvent
    public void attack(LivingAttackEvent event) {
        if (event.entityLiving instanceof EntityPlayer && event.source == EntitySteelSheep.tetanus) {
            event.setCanceled(false);
            event.setResult(Event.Result.ALLOW);
        }
    }

}
