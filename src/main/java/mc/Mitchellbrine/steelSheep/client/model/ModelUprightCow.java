package mc.Mitchellbrine.steelSheep.client.model;

import net.minecraft.client.model.ModelBase;
	import net.minecraft.client.model.ModelRenderer;
	import net.minecraft.entity.Entity;

/**
 * ModelCow - Either Mojang or a mod author
 * Created using Tabula 4.1.0
 */
public class ModelUprightCow extends ModelBase {
	public ModelRenderer field_78144_f;
	public ModelRenderer field_78148_b0;
	public ModelRenderer field_78148_b1;
	public ModelRenderer field_78149_c;
	public ModelRenderer field_78150_a0;
	public ModelRenderer field_78150_a1;
	public ModelRenderer field_78150_a2;
	public ModelRenderer field_78146_d;
	public ModelRenderer field_78147_e;

	public ModelUprightCow() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.field_78144_f = new ModelRenderer(this, 0, 16);
		this.field_78144_f.setRotationPoint(8.0F, -3.0F, -2.0F);
		this.field_78144_f.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.field_78146_d = new ModelRenderer(this, 0, 16);
		this.field_78146_d.setRotationPoint(4.0F, 12.0F, -1.0F);
		this.field_78146_d.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.field_78148_b0 = new ModelRenderer(this, 18, 4);
		this.field_78148_b0.setRotationPoint(0.0F, 5.0F, 2.0F);
		this.field_78148_b0.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
		this.field_78150_a1 = new ModelRenderer(this, 22, 0);
		this.field_78150_a1.setRotationPoint(0.0F, -5.0F, -4.0F);
		this.field_78150_a1.addBox(-5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
		this.field_78150_a2 = new ModelRenderer(this, 22, 0);
		this.field_78150_a2.setRotationPoint(0.0F, -5.0F, -4.0F);
		this.field_78150_a2.addBox(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
		this.field_78150_a0 = new ModelRenderer(this, 0, 0);
		this.field_78150_a0.setRotationPoint(0.0F, -5.0F, -4.0F);
		this.field_78150_a0.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
		this.field_78147_e = new ModelRenderer(this, 0, 16);
		this.field_78147_e.setRotationPoint(-8.0F, -3.0F, -2.0F);
		this.field_78147_e.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.field_78148_b1 = new ModelRenderer(this, 52, 0);
		this.field_78148_b1.setRotationPoint(0.0F, 5.0F, 2.0F);
		this.field_78148_b1.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
		this.field_78149_c = new ModelRenderer(this, 0, 16);
		this.field_78149_c.setRotationPoint(-4.0F, 12.0F, -1.0F);
		this.field_78149_c.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.field_78144_f.render(f5);
		this.field_78146_d.render(f5);
		this.field_78148_b0.render(f5);
		this.field_78150_a1.render(f5);
		this.field_78150_a2.render(f5);
		this.field_78150_a0.render(f5);
		this.field_78147_e.render(f5);
		this.field_78148_b1.render(f5);
		this.field_78149_c.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}