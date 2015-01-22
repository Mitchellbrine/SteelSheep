package mc.Mitchellbrine.steelSheep.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import mc.Mitchellbrine.steelSheep.client.render.ModelSSheep1;
import mc.Mitchellbrine.steelSheep.client.render.ModelSSheep2;
import mc.Mitchellbrine.steelSheep.client.render.RenderSteelSheep;
import mc.Mitchellbrine.steelSheep.entity.EntitySteelSheep;

/**
 * Created by Mitchellbrine on 2015.
 */
public class ClientProxy extends CommonProxy {

    public void renderStuff() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySteelSheep.class,new RenderSteelSheep(new ModelSSheep1(),new ModelSSheep2(),0.3F));
    }

}
