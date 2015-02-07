package mc.Mitchellbrine.steelSheep.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import mc.Mitchellbrine.steelSheep.client.model.ModelUprightCow;
import mc.Mitchellbrine.steelSheep.client.render.ModelSSheep1;
import mc.Mitchellbrine.steelSheep.client.render.ModelSSheep2;
import mc.Mitchellbrine.steelSheep.client.render.RenderSteelSheep;
import mc.Mitchellbrine.steelSheep.client.render.RenderUprightCow;
import mc.Mitchellbrine.steelSheep.entity.EntitySteelSheep;
import net.minecraft.client.model.ModelCow;
import net.minecraft.entity.passive.EntityCow;

/**
 * Created by Mitchellbrine on 2015.
 */
public class ClientProxy extends CommonProxy {

    public void renderStuff() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySteelSheep.class,new RenderSteelSheep(new ModelSSheep1(),new ModelSSheep2(),0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCow.class,new RenderUprightCow(new ModelUprightCow(), new ModelCow(), 0.3F));
    }

    public int addArmorPrefix(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }

}
