package mc.Mitchellbrine.steelSheep.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;

import java.util.ArrayList;

/**
 * Created by Mitchellbrine on 2015.
 */
public class BlockRegistry {

    public static ArrayList<Block> blocks = new ArrayList<Block>();

    public static void init() {

        // Now you're done with all the blocks

        for (Block block : blocks) {
            GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));

            if (block instanceof ITileEntityProvider) {
                GameRegistry.registerTileEntity(((ITileEntityProvider)block).createNewTileEntity(null,0).getClass(),block.getUnlocalizedName().substring(5) + "TE");
            }
        }

    }
}
