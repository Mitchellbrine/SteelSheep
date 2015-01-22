package mc.Mitchellbrine.steelSheep.client.render;

import mc.Mitchellbrine.steelSheep.entity.EntitySteelSheep;
import mc.Mitchellbrine.steelSheep.util.References;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mitchellbrine on 2015.
 */
public class RenderSteelSheep extends RenderLiving {

    private static final ResourceLocation unsheared = new ResourceLocation(References.MODID.toLowerCase(),"textures/entity/sheep/unsheared.png");
    private static final ResourceLocation sheared = new ResourceLocation(References.MODID.toLowerCase(),"textures/entity/sheep/sheared.png");

    public RenderSteelSheep(ModelBase originalLayer,ModelBase unshearedLayer, float rotationValue) {
        super(originalLayer,rotationValue);
        this.setRenderPassModel(unshearedLayer);
    }

    public int shouldRenderSheared(EntitySteelSheep sheep, int pass, float rotationValue) {
        if (pass == 0 && !sheep.isSheared()) {
            this.bindTexture(unsheared);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entity, int pass, float rotationValue) {
        return this.shouldRenderSheared((EntitySteelSheep)entity,pass,rotationValue);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return sheared;
    }
}
