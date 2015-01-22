package mc.Mitchellbrine.steelSheep.item;

import cpw.mods.fml.common.registry.GameRegistry;
import mc.Mitchellbrine.steelSheep.util.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.ArrayList;

/**
 * Created by Mitchellbrine on 2015.
 */
public class ItemRegistry {

    public static ArrayList<Item> items = new ArrayList<Item>();

    public static Item steelIngot;

    public static void init() {

        steelIngot = new SSheepItem().setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("SSheepSteelIngot").setTextureName(References.MODID.toLowerCase() + ":steelIngot");

        // You are now done adding items

        for (Item item : items) {
            GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        }

    }

}
