package spazzysmod;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.client.renderer.entity.RenderGopher;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.entity.passive.EntityGopher;
import spazzysmod.item.SpazzysItems;
import spazzysmod.world.WorldProviderMars;
import spazzysmod.world.WorldProviderMoon;
import spazzysmod.world.biome.BiomeMarsBiome;
import spazzysmod.world.biome.BiomeMoonBiome;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Spazzysmod.modid, name = "Spazzy's Mod", version = "V 0.4")
public class Spazzysmod {

    public static final String modid = "Spazzy_Spazzysmod";

    public static int moonDimensionID = 10;
    public static int marsDimensionID = 12;

    public static BiomeGenBase moonBiome = new BiomeMoonBiome(40).setColor(
            0xFFD800).setMinMaxHeight(0.1F, 1.5F);

    public static BiomeGenBase marsBiome = new BiomeMarsBiome(42).setColor(
            0xFFD800).setMinMaxHeight(0.1F, 1.5F);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        SpazzysConfig.initConfig(new Configuration(event
                .getSuggestedConfigurationFile()));
    }

    @Init
    public void init(FMLInitializationEvent event) {
        registerEntities();
        
        SpazzysTabs.nameTabs();
        
        SpazzysBlocks.initBlocks();
        SpazzysItems.initItems();
        
        entitySpawns();

        DimensionManager.registerProviderType(moonDimensionID,
                WorldProviderMoon.class, false);
        DimensionManager.registerDimension(moonDimensionID, moonDimensionID);
        GameRegistry.addBiome(moonBiome);

        DimensionManager.registerProviderType(marsDimensionID,
                WorldProviderMars.class, false);
        DimensionManager.registerDimension(marsDimensionID, marsDimensionID);
        GameRegistry.addBiome(moonBiome);
    }
    
    public void entitySpawns() {
        EntityRegistry.addSpawn(EntityGopher.class, 20, 2, 4,
                EnumCreatureType.creature, Spazzysmod.moonBiome,
                BiomeGenBase.forest, BiomeGenBase.desert,
                BiomeGenBase.desertHills, BiomeGenBase.forestHills,
                BiomeGenBase.beach, BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains);
        LanguageRegistry.instance().addStringLocalization("entity.Gopher.name",
                "en_US", "Gopher");
    }

    public void registerEntities() {
        EntityRegistry.registerGlobalEntityID(EntityGopher.class, "Gopher",
                EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
        RenderingRegistry.registerEntityRenderingHandler(EntityGopher.class,
                new RenderGopher());
    }
}
