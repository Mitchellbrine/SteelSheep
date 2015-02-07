package mc.Mitchellbrine.steelSheep.entity;

import mc.Mitchellbrine.steelSheep.block.BlockRegistry;
import mc.Mitchellbrine.steelSheep.item.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mitchellbrine on 2015.
 */
public class EntitySteelSheep extends EntityAnimal implements SSheepEntity, IShearable, IAnimals{

    public static DamageSource tetanus;

    public EntitySteelSheep(World world) {
        super(world);
        this.setSize(1.0F, 1.0F);
        //this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.0D, false));
        //this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        //this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityMob.class, 0, true));

        //this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 50, true));

        this.tasks.addTask(2, new EntityAIFullPanic(this,1.0D));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this,0.5F));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 50, true));
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    protected void entityInit() {
        super.entityInit();

        this.getDataWatcher().addObject(16,1);
    }

    @Override
    protected Entity findPlayerToAttack()
    {
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
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

    @Override
    public void collideWithEntity(Entity entity) {
        super.collideWithEntity(entity);
        if (!(entity instanceof EntitySteelSheep)) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase)entity).attackEntityFrom(tetanus,0.5F);
                ((EntityLivingBase)entity).motionY = 0.41999998688697815D;

                if (((EntityLivingBase)entity).isPotionActive(Potion.jump))
                {
                    ((EntityLivingBase)entity).motionY += (double)((float)(((EntityLivingBase)entity).getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
                }

                if (((EntityLivingBase)entity).isSprinting())
                {
                    float f = ((EntityLivingBase)entity).rotationYaw * 0.017453292F;
                    ((EntityLivingBase)entity).motionX -= (double)(MathHelper.sin(f) * 0.2F);
                    ((EntityLivingBase)entity).motionZ += (double)(MathHelper.cos(f) * 0.2F);
                }

                ((EntityLivingBase)entity).isAirBorne = true;
                ForgeHooks.onLivingJump(((EntityLivingBase)entity));
            }
        }
    }

    public boolean isSheared() {
        return this.getDataWatcher().getWatchableObjectInt(16) == 0;
    }


    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return !isSheared() && item.getItem() instanceof ItemShears && item.getItemDamage() < (item.getMaxDamage() - 3) && rand.nextInt(100) > 66;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> wool = new ArrayList<ItemStack>();
        int woolNumber = new Random(worldObj.getTotalWorldTime()).nextInt(3) * fortune + 1;
        wool.add(new ItemStack(ItemRegistry.steelWool,woolNumber,0));
        this.dataWatcher.updateObject(16,0);
        return wool;
    }

}
