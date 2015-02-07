package mc.Mitchellbrine.steelSheep;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import mc.Mitchellbrine.steelSheep.block.BlockRegistry;
import mc.Mitchellbrine.steelSheep.entity.EntitySteelSheep;
import mc.Mitchellbrine.steelSheep.entity.SSEntityRegistry;
import mc.Mitchellbrine.steelSheep.event.EventStuff;
import mc.Mitchellbrine.steelSheep.item.ItemRegistry;
import mc.Mitchellbrine.steelSheep.proxy.CommonProxy;
import mc.Mitchellbrine.steelSheep.util.OreDictionaryHelper;
import mc.Mitchellbrine.steelSheep.util.RecipeHelper;
import mc.Mitchellbrine.steelSheep.util.References;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Mitchellbrine on 2015.
 */
@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION,dependencies = "after:Metallurgy;after:Artifice;after:Mekanism")
public class SteelSheep {

    @SidedProxy(clientSide = "mc.Mitchellbrine.steelSheep.proxy.ClientProxy",serverSide = "mc.Mitchellbrine.steelSheep.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger = LogManager.getLogger(References.NAME);

    @Mod.Instance
    public static SteelSheep instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        BlockRegistry.init();
        ItemRegistry.init();
        EntitySteelSheep.tetanus = new DamageSource("tetanus").setDamageBypassesArmor().setDifficultyScaled();
        new SSEntityRegistry();
        OreDictionaryHelper.init();
        RecipeHelper.init();
        MinecraftForge.EVENT_BUS.register(new EventStuff());
        FMLCommonHandler.instance().bus().register(new EventStuff());

        proxy.renderStuff();

    }

}
