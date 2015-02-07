package mc.Mitchellbrine.steelSheep.item;

import mc.Mitchellbrine.steelSheep.SteelSheep;
import net.minecraft.item.Item;

/**
 * Created by Mitchellbrine on 2015.
 */
public class SSheepItem extends Item {

    public SSheepItem() {
        this.setCreativeTab(SteelSheep.steelSheepTab);
        ItemRegistry.items.add(this);
    }

}
