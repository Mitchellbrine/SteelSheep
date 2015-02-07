package mc.Mitchellbrine.steelSheep.item;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import mc.Mitchellbrine.steelSheep.SteelSheep;
import mc.Mitchellbrine.steelSheep.util.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;

/**
 * Created by Mitchellbrine on 2015.
 */
public class ItemRegistry {

    public static ArrayList<Item> items = new ArrayList<Item>();

    public static ItemArmor.ArmorMaterial steelWoolArmor = EnumHelper.addArmorMaterial("steelWool",10,new int[]{1,5,3,1},12);

    public static Item steelIngot;
    public static Item steelWool;
    public static Item steelWoolBoots;
    public static Item steelWoolLeggings;
    public static Item steelWoolChest;
    public static Item steelWoolHelmet;

    public static void init() {

        if (Loader.isModLoaded("RailCraft") || Loader.isModLoaded("Metallurgy") || Loader.isModLoaded("Artifice") || Loader.isModLoaded("TConstruct") || Loader.isModLoaded("Mekanism")) {
            steelIngot = new SSheepItem().setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("SSheepSteelIngot").setTextureName(References.MODID.toLowerCase() + ":steelIngot");
        }

        steelWool = new SSheepItem().setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("SteelWoolItem").setTextureName(References.MODID.toLowerCase() + ":steelWool");

        steelWoolBoots = new SteelWoolArmor(steelWoolArmor, SteelSheep.proxy.addArmorPrefix("STEELWOOL"),3).setUnlocalizedName("steelWoolBoots").setTextureName(References.MODID.toLowerCase() + ":steelwool_boots");
        steelWoolLeggings = new SteelWoolArmor(steelWoolArmor,SteelSheep.proxy.addArmorPrefix("STEELWOOL"),2).setUnlocalizedName("steelWoolLegs").setTextureName(References.MODID.toLowerCase() + ":steelwool_legs");
        steelWoolChest = new SteelWoolArmor(steelWoolArmor,SteelSheep.proxy.addArmorPrefix("STEELWOOL"),1).setUnlocalizedName("steelWoolChest").setTextureName(References.MODID.toLowerCase() + ":steelwool_chest");
        steelWoolHelmet = new SteelWoolArmor(steelWoolArmor,SteelSheep.proxy.addArmorPrefix("STEELWOOL"),0).setUnlocalizedName("steelWoolHelmet").setTextureName(References.MODID.toLowerCase() + ":steelwool_helmet");

        // You are now done adding items

        for (Item item : items) {
            GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        }

    }

}
