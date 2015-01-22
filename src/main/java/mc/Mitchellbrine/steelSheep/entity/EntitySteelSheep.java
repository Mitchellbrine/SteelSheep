package mc.Mitchellbrine.steelSheep.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mitchellbrine on 2015.
 */
public class EntitySteelSheep extends EntityAnimal implements SSheepEntity, IShearable{

    public static DamageSource tetanus = new DamageSource("tetanus").setDifficultyScaled().setDamageIsAbsolute();

    public EntitySteelSheep(World world) {
        super(world);
        this.setSize(1.0F,1.0F);
    }

    protected void entityInit() {
        super.entityInit();

        this.getDataWatcher().addObject(16,1);
    }

    @Override
    public EntitySteelSheep createChild(EntityAgeable entity) {
        return new EntitySteelSheep(entity.worldObj);
    }

    @Override
    public String getEntityName() {
        return "steelSheep";
    }

    @Override
    public int[] getEggColors() {
        return new int[]{0xFFFFFF,0xFF0000};
    }

    public void collideWithEntity(Entity entity) {
        if (entity instanceof EntitySteelSheep) return;
        //else

        entity.attackEntityFrom(tetanus,0.5F);

    }

    public boolean isSheared() {
        return this.getDataWatcher().getWatchableObjectInt(16) == 0;
    }


    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return /*!isSheared()*/item.getItem() instanceof ItemShears && item.getItemDamage() < (item.getMaxDamage() - 3);
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> wool = new ArrayList<ItemStack>();
        int woolNumber = new Random(worldObj.getTotalWorldTime()).nextInt(3) * fortune;
        wool.add(new ItemStack(Blocks.wool,woolNumber,0));
        this.dataWatcher.updateObject(16,0);
        return wool;
    }



}
