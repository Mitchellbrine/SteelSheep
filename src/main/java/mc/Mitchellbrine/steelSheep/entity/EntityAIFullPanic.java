package mc.Mitchellbrine.steelSheep.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

/**
 * Created by Mitchellbrine on 2015.
 */
public class EntityAIFullPanic extends EntityAIBase {

	private EntityCreature theEntityCreature;
	private double speed;
	private double randPosX;
	private double randPosY;
	private double randPosZ;

	public EntityAIFullPanic(EntityCreature p_i1645_1_, double p_i1645_2_) {
		this.theEntityCreature = p_i1645_1_;
		this.speed = p_i1645_2_;
		this.setMutexBits(1);
	}


	public void startExecuting()
	{
		this.theEntityCreature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
	}

	public boolean shouldExecute() {
		if (theEntityCreature.worldObj.getTotalWorldTime() % 40 == 0) {
			Vec3 vec3 = RandomPositionGenerator.findRandomTarget(theEntityCreature, 5, 4);

			if (vec3 == null) {
				return false;
			} else {
				this.randPosX = vec3.xCoord;
				this.randPosY = vec3.yCoord;
				this.randPosZ = vec3.zCoord;
				return true;
			}
		}
		return false;
	}

	public boolean continueExecuting()
	{
		return !this.theEntityCreature.getNavigator().noPath();
	}

}
