package mc.Mitchellbrine.steelSheep.block;

import cpw.mods.fml.common.registry.GameRegistry;
import mc.Mitchellbrine.steelSheep.util.References;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;

/**
 * Created by Mitchellbrine on 2015.
 */
public class BlockRegistry {

    public static ArrayList<Block> blocks = new ArrayList<Block>();

    public static Block steelWool;
    public static Block steelBlock;

    public static void init() {

        steelWool = new BlockSteelWool(Material.cloth).setHardness(0.8F).setStepSound(Block.soundTypeCloth).setBlockName("steelWool").setBlockTextureName(References.MODID.toLowerCase() + ":steelWool");
        steelBlock = new SSheepBlock(Material.iron).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setBlockName("SSheepSteelBlock").setBlockTextureName(References.MODID.toLowerCase() + ":steelBlock");

        // Now you're done with all the blocks

        for (Block block : blocks) {
            GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));

            if (block instanceof ITileEntityProvider) {
                GameRegistry.registerTileEntity(((ITileEntityProvider)block).createNewTileEntity(null,0).getClass(),block.getUnlocalizedName().substring(5) + "TE");
            }
        }

    }
}
