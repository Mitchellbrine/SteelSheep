package mc.Mitchellbrine.steelSheep.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mc.Mitchellbrine.steelSheep.entity.EntitySteelSheep;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * Created by Mitchellbrine on 2015.
 */
public class BlockSteelWool extends SSheepBlock {

	public BlockSteelWool(Material material) {
		super(material);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		entity.attackEntityFrom(EntitySteelSheep.tetanus, 0.5F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float f = 0.0625F;
		return AxisAlignedBB.getBoundingBox((double)x + f, (double)y, (double)z + f, (double)x + 1 - f, (double)y + 1, (double)z + 1 - f);
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float f = 0.0625F;
		return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)x + 1, (double)y + 1, (double)z + 1);
	}

}
