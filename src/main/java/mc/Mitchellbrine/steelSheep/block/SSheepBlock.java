package mc.Mitchellbrine.steelSheep.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Mitchellbrine on 2015.
 */
public class SSheepBlock extends Block {

    public SSheepBlock(Material material) {
        super(material);
        BlockRegistry.blocks.add(this);
    }

}
