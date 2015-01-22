package mc.Mitchellbrine.steelSheep.util;

import mc.Mitchellbrine.steelSheep.item.ItemRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Mitchellbrine on 2015.
 */
public class OreDictionaryHelper {

    public static void init() {
        OreDictionary.registerOre("ingotSteel", ItemRegistry.steelIngot);
    }

}
