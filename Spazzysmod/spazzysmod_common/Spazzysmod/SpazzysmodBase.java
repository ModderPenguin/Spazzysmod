package Spazzysmod;

import net.minecraftforge.common.Configuration;
import Spazzysmod.blocks.SpazzysBlocks;
import Spazzysmod.config.SpazzysConfig;
import Spazzysmod.creativetab.SpazzysTabs;
import Spazzysmod.entity.SpazzysEntitys;
import Spazzysmod.item.SpazzysItems;
import Spazzysmod.world.SpazzysDimensions;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SpazzysmodBase.modid, name = "Spazzy's Mod", version = "V 0.4")
public class SpazzysmodBase {

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
