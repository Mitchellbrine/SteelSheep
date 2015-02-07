package mc.Mitchellbrine.steelSheep.item;

import mc.Mitchellbrine.steelSheep.SteelSheep;
import mc.Mitchellbrine.steelSheep.entity.EntitySteelSheep;
import mc.Mitchellbrine.steelSheep.util.References;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by Mitchellbrine on 2015.
 */
public class SteelWoolArmor extends ItemArmor {

	public SteelWoolArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
		this.setCreativeTab(SteelSheep.steelSheepTab);
		ItemRegistry.items.add(this);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		String layer = "1";
		if(slot == 2) {
			layer="" + slot;
		}
		return References.MODID + ":textures/models/armor/SteelWool_layer_"+layer+".png";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if ((player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() == ItemRegistry.steelWoolBoots) || (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem() == ItemRegistry.steelWoolLeggings) || (player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem() == ItemRegistry.steelWoolChest) || (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem() == ItemRegistry.steelWoolHelmet)) {
			if (player.isSprinting()) {
				if (player.getRNG().nextInt(100) < 66) {
					player.attackEntityFrom(EntitySteelSheep.tetanus, 0.5F);
				}
			}


			if (!world.isRemote) {
				if (world.getBlock(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY) + 1, MathHelper.floor_double(player.posZ)) == Blocks.lava || world.getBlock(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY) + 1, MathHelper.floor_double(player.posZ)) == Blocks.flowing_lava) {
					if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem() == ItemRegistry.steelWoolHelmet) {
						if (player.getRNG().nextInt(5000) < 33) {
							int damage = player.getCurrentArmor(3).getItemDamage();
							NBTTagCompound compound = player.getCurrentArmor(3).getTagCompound();
							ItemStack newStack = new ItemStack(Items.chainmail_helmet, 1, damage);
							newStack.setTagCompound(compound);
							player.setCurrentItemOrArmor(4, newStack);
							if (!player.worldObj.isRemote) {
								player.worldObj.playSoundAtEntity(player,"random.fizz",5.0F,1.0F);
							}
						}
					}
					if (player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem() == ItemRegistry.steelWoolChest) {
						if (player.getRNG().nextInt(5000) < 33) {
							int damage = player.getCurrentArmor(2).getItemDamage();
							NBTTagCompound compound = player.getCurrentArmor(2).getTagCompound();
							ItemStack newStack = new ItemStack(Items.chainmail_chestplate, 1, damage);
							newStack.setTagCompound(compound);
							player.setCurrentItemOrArmor(3, newStack);
							if (!player.worldObj.isRemote) {
								player.worldObj.playSoundAtEntity(player,"random.fizz",5.0F,1.0F);
							}
						}
					}
				}

				if (world.getBlock(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) == Blocks.lava || world.getBlock(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) == Blocks.flowing_lava) {
					if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem() == ItemRegistry.steelWoolLeggings) {
						if (player.getRNG().nextInt(5000) < 33) {
							int damage = player.getCurrentArmor(1).getItemDamage();
							NBTTagCompound compound = player.getCurrentArmor(1).getTagCompound();
							ItemStack newStack = new ItemStack(Items.chainmail_leggings, 1, damage);
							newStack.setTagCompound(compound);
							player.setCurrentItemOrArmor(2, newStack);
							if (!player.worldObj.isRemote) {
								player.worldObj.playSoundAtEntity(player,"random.fizz",5.0F,1.0F);
							}
						}
					}
					if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem() == ItemRegistry.steelWoolBoots) {
						if (player.getRNG().nextInt(5000) < 33) {
							int damage = player.getCurrentArmor(0).getItemDamage();
							NBTTagCompound compound = player.getCurrentArmor(0).getTagCompound();
							ItemStack newStack = new ItemStack(Items.chainmail_boots, 1, damage);
							newStack.setTagCompound(compound);
							player.setCurrentItemOrArmor(1, newStack);
							if (!player.worldObj.isRemote) {
								player.worldObj.playSoundAtEntity(player,"random.fizz",5.0F,1.0F);
							}
						}
					}
				}
			}

		}
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean par5) {
		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}

		boolean hasThorns = false;

		if (stack.stackTagCompound.getTag("ench") != null) {
			NBTTagList enchants = (NBTTagList) stack.stackTagCompound.getTag("ench");

			for (int i = 0; i < enchants.tagCount(); i++) {
				NBTTagCompound enchant = ((NBTTagList) enchants).getCompoundTagAt(i);
				if (enchant.getInteger("id") == 7) {
					hasThorns = true;
					break;
				}
			}
		}

		if (!hasThorns) {
			stack.addEnchantment(Enchantment.thorns,1);
		}
	}
}
