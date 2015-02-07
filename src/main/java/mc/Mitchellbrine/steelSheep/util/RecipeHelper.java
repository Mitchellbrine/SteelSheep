package mc.Mitchellbrine.steelSheep.util;

import cpw.mods.fml.common.registry.GameRegistry;
import mc.Mitchellbrine.steelSheep.block.BlockRegistry;
import mc.Mitchellbrine.steelSheep.item.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Mitchellbrine on 2015.
 */
public class RecipeHelper {

    public static void init() {
        if (OreDictionary.getOres("ingotSteel").size() == 1) {
            GameRegistry.addSmelting(BlockRegistry.steelWool, new ItemStack(Items.iron_ingot, 1), 0.3F);
        } else {
            GameRegistry.addSmelting(BlockRegistry.steelWool, new ItemStack(ItemRegistry.steelIngot, 1), 0.3F);
        }

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.steelWool),"XX","XX",'X',ItemRegistry.steelWool);

        GameRegistry.addRecipe(new ItemStack(ItemRegistry.steelWoolBoots),"X X","X X",'X',ItemRegistry.steelWool);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.steelWoolLeggings),"XXX","X X","X X",'X',ItemRegistry.steelWool);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.steelWoolChest),"X X","XXX","XXX",'X',ItemRegistry.steelWool);
        GameRegistry.addRecipe(new ItemStack(ItemRegistry.steelWoolHelmet),"XXX","X X",'X',ItemRegistry.steelWool);

    }

}
