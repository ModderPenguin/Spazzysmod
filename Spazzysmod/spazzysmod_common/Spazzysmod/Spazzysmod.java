package spazzysmod;

import net.minecraftforge.common.Configuration;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.entity.SpazzysEntitys;
import spazzysmod.item.SpazzysItems;
import spazzysmod.world.SpazzysDimensions;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Spazzysmod.modid, name = "Spazzy's Mod", version = "V 0.4")
public class Spazzysmod {

    public static final String modid = "Spazzy_Spazzysmod";

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        SpazzysConfig.initConfig(new Configuration(event
                .getSuggestedConfigurationFile()));
    }

    @Init
    public void init(FMLInitializationEvent event) {
        SpazzysBlocks.initBlocks();

        SpazzysItems.initItems();

        SpazzysTabs.nameTabs();

        SpazzysDimensions.registerDimensions();

        SpazzysEntitys.registerEntitySpawns();
        SpazzysEntitys.registerEntities();
    }
}
