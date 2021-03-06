package Spazzysmod.entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import Spazzysmod.client.renderer.entity.RenderGopher;
import Spazzysmod.entity.passive.EntityGopher;
import Spazzysmod.world.biome.SpazzysBiomes;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SpazzysEntitys {

    public static void registerEntitySpawns() {
        EntityRegistry.addSpawn(EntityGopher.class, 20, 2, 4,
                EnumCreatureType.creature, SpazzysBiomes.moonBiome,
                BiomeGenBase.forest, BiomeGenBase.desert,
                BiomeGenBase.desertHills, BiomeGenBase.forestHills,
                BiomeGenBase.beach, BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains);
        LanguageRegistry.instance().addStringLocalization("entity.Gopher.name",
                "en_US", "Gopher");
    }

    public static void registerEntities() {
        EntityRegistry.registerGlobalEntityID(EntityGopher.class, "Gopher",
                EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
        RenderingRegistry.registerEntityRenderingHandler(EntityGopher.class,
                new RenderGopher());
    }
}
