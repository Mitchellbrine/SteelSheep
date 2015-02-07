package mc.Mitchellbrine.steelSheep.util;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import mc.Mitchellbrine.steelSheep.block.BlockRegistry;
import mc.Mitchellbrine.steelSheep.item.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Mitchellbrine on 2015.
 */
public class RecipeHelper {

    public static void init() {
        if (Loader.instance().getActiveModList().size() == 4 && !Loader.isModLoaded("RailCraft") && !Loader.isModLoaded("Metallurgy") && !Loader.isModLoaded("Artifice") && !Loader.isModLoaded("TConstruct") && !Loader.isModLoaded("Mekanism")) {
            GameRegistry.addSmelting(BlockRegistry.steelWool, new ItemStack(Items.iron_ingot, 1), 0.3F);
        } else {
            GameRegistry.addSmelting(BlockRegistry.steelWool, new ItemStack(ItemRegistry.steelIngot, 1), 0.3F);
        }

        GameRegistry.addRecipe(new ItemStack(BlockRegistry.steelWool),"XX","XX",'X',ItemRegistry.steelWool);

    }

}
