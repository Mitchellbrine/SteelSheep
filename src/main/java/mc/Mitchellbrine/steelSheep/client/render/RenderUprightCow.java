package mc.Mitchellbrine.steelSheep.client.render;

import mc.Mitchellbrine.steelSheep.client.model.ModelUprightCow;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mitchellbrine on 2015.
 */
public class RenderUprightCow extends RenderLiving {

	private static final ResourceLocation cowTextures = new ResourceLocation("textures/entity/cow/cow.png");

	private static ModelUprightCow cowModel;
	private static ModelCow regularModel;

	public RenderUprightCow(ModelUprightCow p_i1262_1_, ModelCow cow, float p_i1262_2_) {
		super(cow, p_i1262_2_);
		cowModel = p_i1262_1_;
		regularModel = cow;
	}

	@Override
	protected void renderModel(EntityLivingBase entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (entity.worldObj.getClosestPlayerToEntity(entity, 10) == null) {
			this.mainModel = cowModel;
		} else {
			this.mainModel = regularModel;
		}
		super.renderModel(entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public void doRender(EntityLivingBase entity, double x, double y, double z, float yaw, float particleTick) {
		renderCow(entity, x, y, z, yaw, particleTick);
	}

	public void renderCow(EntityLivingBase entity, double x, double y, double z, float yaw, float particleTick) {
		super.doRender(entity, x, y, z, yaw, particleTick);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return cowTextures;
	}
}
