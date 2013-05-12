package Spazzysmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import Spazzysmod.blocks.BlockCheeseBlock;
import Spazzysmod.blocks.BlockMoonDirtBlock;
import Spazzysmod.blocks.BlockMoonPortal;
import Spazzysmod.blocks.BlockMoonStoneBlock;
import Spazzysmod.blocks.BlockTitaniumBlock;
import Spazzysmod.client.renderer.entity.RenderGopher;
import Spazzysmod.entity.passive.EntityGopher;
import Spazzysmod.item.ItemTitaniumIngot;
import Spazzysmod.item.ItemTitaniumSword;
import Spazzysmod.item.armor.TitaniumArmor;
import Spazzysmod.world.WorldProviderMoon;
import Spazzysmod.world.biome.BiomeMoonBiome;
import Spazzysmod.world.gen.feature.TitaniumWorldGenerator;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Spazzy's mod", name = "Spazzy's Mod", version = "V 0.2")
public class Spazzysmod {

    public static final String modid = "Spazzy_Spazzysmod";

    public static Block cheeseBlock;
    public static Block moonPortal;
    static int moonPortalID;
    static int cheeseBlockID;
    public static Block moonDirt;
    public static Block moonStone;
    public static Block titaniumBlock;
    public static Item titaniumIngot;
    public static Item titaniumSword;

    public static Item titaniumHelmet;
    public static Item titaniumChestPlate;
    public static Item titaniumLeggings;
    public static Item titaniumBoots;

    public static int moonDimensionID = 10;

    public static BiomeGenBase moonBiome = new BiomeMoonBiome(40).setColor(
            0xFFD800).setMinMaxHeight(0.1F, 1.5F);

    static EnumArmorMaterial TITANIUMARMOR = EnumHelper.addArmorMaterial(
            "TITANIUMARMOR", 33, new int[] { 3, 8, 6, 3 }, 25);
    public static final EnumToolMaterial TITANIUM = EnumHelper.addToolMaterial(
            "TITANIUM", 2, 20000, 10.0F, 7, 10);

    @Init
    @SuppressWarnings("deprecation")
    public void init(FMLInitializationEvent event) {
        registerEntities();

        cheeseBlock = new BlockCheeseBlock(cheeseBlockID, Material.rock)
                .setUnlocalizedName("cheeseBlock");
        moonPortal = new BlockMoonPortal(moonPortalID)
                .setUnlocalizedName("portal");

        GameRegistry.registerBlock(cheeseBlock,
                modid + cheeseBlock.getUnlocalizedName2());
        GameRegistry.registerBlock(moonPortal);

        EntityRegistry.addSpawn(EntityGopher.class, 20, 2, 4,
                EnumCreatureType.creature, Spazzysmod.moonBiome,
                BiomeGenBase.forest, BiomeGenBase.desert,
                BiomeGenBase.desertHills, BiomeGenBase.forestHills,
                BiomeGenBase.beach, BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains);
        // EntityRegistry.addSpawn(EntityGopher.class, 5, 2,
        // 3, EnumCreatureType.ambient, BiomeGenBase.forest,
        // BiomeGenBase.desert, BiomeGenBase.desertHills,
        // BiomeGenBase.forestHills, BiomeGenBase.beach,
        // BiomeGenBase.extremeHills,
        // BiomeGenBase.extremeHillsEdge,
        // BiomeGenBase.plains );
        LanguageRegistry.instance().addStringLocalization("entity.Gopher.name",
                "en_US", "Gopher");

        moonDirt = new BlockMoonDirtBlock(255, Material.rock)
                .setUnlocalizedName("moonDirt");
        GameRegistry.registerBlock(moonDirt,
                modid + moonDirt.getUnlocalizedName2());
        LanguageRegistry.addName(moonDirt, "Moon Dirt");

        moonStone = new BlockMoonStoneBlock(254, Material.rock)
                .setUnlocalizedName("moonStone");
        GameRegistry.registerBlock(moonStone,
                modid + moonStone.getUnlocalizedName2());
        LanguageRegistry.addName(moonStone, "Moon Stone");

        titaniumBlock = new BlockTitaniumBlock(501, Material.rock)
                .setUnlocalizedName("titaniumBlock");
        GameRegistry.registerBlock(titaniumBlock,
                modid + titaniumBlock.getUnlocalizedName2());
        LanguageRegistry.addName(titaniumBlock, "Titanium Ore");
        GameRegistry.registerWorldGenerator(new TitaniumWorldGenerator());

        titaniumIngot = new ItemTitaniumIngot(5000)
                .setUnlocalizedName("titaniumIngot");
        LanguageRegistry.addName(titaniumIngot, "Titanium Ingot");
        GameRegistry.registerItem(titaniumIngot, "Titanium Ingot");

        GameRegistry.addSmelting(titaniumBlock.blockID, new ItemStack(
                titaniumIngot, 1), 1F);

        titaniumHelmet = new TitaniumArmor(5002, TITANIUMARMOR,
                ModLoader.addArmor("TITANIUMARMOR"), 0).setUnlocalizedName(
                "titaniumHelmet").setCreativeTab(CreativeTabs.tabCombat);
        LanguageRegistry.addName(titaniumHelmet, "Titanium Helmet");
        GameRegistry.registerItem(titaniumHelmet, "Titanium Helmet");
        GameRegistry.addRecipe(new ItemStack(titaniumHelmet), new Object[] {
                "   ", "XXX", "X X", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        titaniumChestPlate = new TitaniumArmor(5003, TITANIUMARMOR,
                ModLoader.addArmor("TITANIUMARMOR"), 1).setUnlocalizedName(
                "titaniumChestPlate").setCreativeTab(CreativeTabs.tabCombat);
        LanguageRegistry.addName(titaniumChestPlate, "Titanium Chest Plate");
        GameRegistry.registerItem(titaniumChestPlate, "Titanium Chest Plate");
        GameRegistry.addRecipe(new ItemStack(titaniumChestPlate), new Object[] {
                "X X", "XXX", "XXX", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        titaniumLeggings = new TitaniumArmor(5004, TITANIUMARMOR,
                ModLoader.addArmor("TITANIUMARMOR"), 2).setUnlocalizedName(
                "titaniumLeggings").setCreativeTab(CreativeTabs.tabCombat);
        LanguageRegistry.addName(titaniumLeggings, "Titanium Leggings");
        GameRegistry.registerItem(titaniumLeggings, "Titanium Leggings");
        GameRegistry.addRecipe(new ItemStack(titaniumLeggings), new Object[] {
                "XXX", "X X", "X X", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        titaniumBoots = new TitaniumArmor(5005, TITANIUMARMOR,
                ModLoader.addArmor("TITANIUMARMOR"), 3).setUnlocalizedName(
                "titaniumBoots").setCreativeTab(CreativeTabs.tabCombat);
        LanguageRegistry.addName(titaniumBoots, "Titanium Boots");
        GameRegistry.registerItem(titaniumBoots, "Titanium Boots");
        GameRegistry.addRecipe(new ItemStack(titaniumBoots), new Object[] {
                "   ", "X X", "X X", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        titaniumSword = new ItemTitaniumSword(5001, TITANIUM)
                .setUnlocalizedName("titaniumSword");
        LanguageRegistry.addName(titaniumSword, "Titanium Sword");
        GameRegistry.registerItem(titaniumSword, "Titanium Sword");
        GameRegistry.addRecipe(new ItemStack(titaniumSword), new Object[] {
                " X ", " X ", " Y ", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        GameRegistry.addRecipe(new ItemStack(cheeseBlock), new Object[] {
                "   ", " X ", "   ", 'X', Item.bucketMilk

        });

        GameRegistry.addRecipe(new ItemStack(moonPortal), new Object[] { "XXX",
                "XYX", "XXX", 'X', Spazzysmod.cheeseBlock, 'Y',
                Item.flintAndSteel

        });

        LanguageRegistry.addName(cheeseBlock, "Block of Cheese");
        LanguageRegistry.addName(moonPortal, "Moon Portal");

        DimensionManager.registerProviderType(moonDimensionID,
                WorldProviderMoon.class, false);
        DimensionManager.registerDimension(moonDimensionID, moonDimensionID);
        GameRegistry.addBiome(moonBiome);
    }

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(
                event.getSuggestedConfigurationFile());
        config.load();

        moonPortalID = config.get(Configuration.CATEGORY_BLOCK,
                "Moon Portal ID", 500).getInt();
        cheeseBlockID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
                "Cheese Block ID", 250, "CheeseBlockID").getInt();

        config.save();
    }

    public void registerEntities() {
        EntityRegistry.registerGlobalEntityID(EntityGopher.class, "Gopher",
                EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
        RenderingRegistry.registerEntityRenderingHandler(EntityGopher.class,
                new RenderGopher());
    }
}
