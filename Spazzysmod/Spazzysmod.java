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

@Mod(modid = Spazzysmod.modid, name = "Spazzy's Mod", version = "V 0.4")
public class Spazzysmod {

    public static final String modid = "Spazzy_Spazzysmod";

    public static Block cheeseBlock;
    public static Block moonPortal;
    public static Block moonDirt;
    public static Block moonStone;
    public static Block titaniumBlock;
    
    static int cheeseBlockID;
    static int moonPortalID;
    static int moonDirtID;
    static int moonStoneID;
    static int titaniumBlockID;
    
    public static Item titaniumIngot;
    public static Item titaniumSword;
    
    static int titaniumIngotID;
    static int titaniumSwordID;

    public static Item titaniumHelmet;
    public static Item titaniumChestplate;
    public static Item titaniumLeggings;
    public static Item titaniumBoots;
    
    static int titaniumHelmetID;
    static int titaniumChestplateID;
    static int titaniumLeggingsID;
    static int titaniumBootsID;

    public static int moonDimensionID = 10;

    public static BiomeGenBase moonBiome = new BiomeMoonBiome(40).setColor(
            0xFFD800).setMinMaxHeight(0.1F, 1.5F);

    static EnumArmorMaterial TITANIUMARMOR = EnumHelper.addArmorMaterial(
            "TITANIUMARMOR", 33, new int[] { 3, 8, 6, 3 }, 25);
    public static final EnumToolMaterial TITANIUM = EnumHelper.addToolMaterial(
            "TITANIUM", 2, 20000, 10.0F, 7, 10);
    

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(
                event.getSuggestedConfigurationFile());
        config.load();

        // blocks
        cheeseBlockID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
                "Cheese Block ID", 250, "CheeseBlockID").getInt();
        moonPortalID = config.get(Configuration.CATEGORY_BLOCK,
                "Moon Portal ID", 500).getInt();
        moonDirtID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
                "Moon Dirt ID", 255, "MoonDirtID").getInt();
        moonStoneID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
                "Moon Stone ID", 254, "MoonStoneID").getInt();
        titaniumBlockID = config.get(Configuration.CATEGORY_BLOCK,
                "Titanium Block ID", 501).getInt();
        // items
        titaniumIngotID = config.get(Configuration.CATEGORY_ITEM,
                "Titanium Ingot ID", 5000).getInt();
        titaniumSwordID = config.get(Configuration.CATEGORY_ITEM,
                "Titanium Sword ID", 5001).getInt();
        titaniumHelmetID = config.get(Configuration.CATEGORY_ITEM,
                "Titanium Helmet ID", 5002).getInt();
        titaniumChestplateID = config.get(Configuration.CATEGORY_ITEM,
                "Titanium Chestplate ID", 5003).getInt();
        titaniumLeggingsID = config.get(Configuration.CATEGORY_ITEM,
                "Titanium Leggings ID", 5004).getInt();
        titaniumBootsID = config.get(Configuration.CATEGORY_ITEM,
                "Titanium Boots ID", 5005).getInt();

        config.save();
    }
    
    @Init
    @SuppressWarnings("deprecation")
    public void init(FMLInitializationEvent event) {
        registerEntities();

        cheeseBlock = new BlockCheeseBlock(cheeseBlockID, Material.rock)
                .setUnlocalizedName("cheeseBlock");
        moonPortal = new BlockMoonPortal(moonPortalID)
                .setUnlocalizedName("portal");

        GameRegistry.registerBlock(cheeseBlock);
        GameRegistry.registerBlock(moonPortal);

        EntityRegistry.addSpawn(EntityGopher.class, 20, 2, 4,
                EnumCreatureType.creature, Spazzysmod.moonBiome,
                BiomeGenBase.forest, BiomeGenBase.desert,
                BiomeGenBase.desertHills, BiomeGenBase.forestHills,
                BiomeGenBase.beach, BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge, BiomeGenBase.plains);
        LanguageRegistry.instance().addStringLocalization("entity.Gopher.name",
                "en_US", "Gopher");

        moonDirt = new BlockMoonDirtBlock(moonDirtID, Material.rock)
                .setUnlocalizedName("moonDirt");
        GameRegistry.registerBlock(moonDirt,
                modid + moonDirt.getUnlocalizedName2());
        LanguageRegistry.addName(moonDirt, "Moon Dirt");

        moonStone = new BlockMoonStoneBlock(moonStoneID, Material.rock)
                .setUnlocalizedName("moonStone");
        GameRegistry.registerBlock(moonStone);
        LanguageRegistry.addName(moonStone, "Moon Stone");

        titaniumBlock = new BlockTitaniumBlock(titaniumBlockID, Material.rock)
                .setUnlocalizedName("titaniumBlock");
        GameRegistry.registerBlock(titaniumBlock);
        LanguageRegistry.addName(titaniumBlock, "Titanium Ore");
        GameRegistry.registerWorldGenerator(new TitaniumWorldGenerator());

        titaniumIngot = new ItemTitaniumIngot(titaniumIngotID)
                .setUnlocalizedName("titaniumIngot");
        LanguageRegistry.addName(titaniumIngot, "Titanium Ingot");
        GameRegistry.registerItem(titaniumIngot, "Titanium Ingot");

        GameRegistry.addSmelting(titaniumBlock.blockID, new ItemStack(
                titaniumIngot, 1), 1F);

        titaniumHelmet = new TitaniumArmor(titaniumHelmetID, TITANIUMARMOR,
                ModLoader.addArmor("TitaniumArmor"), 0).setUnlocalizedName(
                "titaniumHelmet").setCreativeTab(CreativeTabs.tabCombat);
        LanguageRegistry.addName(titaniumHelmet, "Titanium Helmet");
        GameRegistry.registerItem(titaniumHelmet, "Titanium Helmet");
        GameRegistry.addRecipe(new ItemStack(titaniumHelmet), new Object[] {
                "   ", "XXX", "X X", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        titaniumChestplate = new TitaniumArmor(titaniumChestplateID, TITANIUMARMOR,
                ModLoader.addArmor("TitaniumArmor"), 1).setUnlocalizedName(
                "titaniumChestPlate").setCreativeTab(CreativeTabs.tabCombat);
        LanguageRegistry.addName(titaniumChestplate, "Titanium Chestplate");
        GameRegistry.registerItem(titaniumChestplate, "Titanium Chestplate");
        GameRegistry.addRecipe(new ItemStack(titaniumChestplate), new Object[] {
                "X X", "XXX", "XXX", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        titaniumLeggings = new TitaniumArmor(titaniumLeggingsID, TITANIUMARMOR,
                ModLoader.addArmor("TitaniumArmor"), 2).setUnlocalizedName(
                "titaniumLeggings").setCreativeTab(CreativeTabs.tabCombat);
        LanguageRegistry.addName(titaniumLeggings, "Titanium Leggings");
        GameRegistry.registerItem(titaniumLeggings, "Titanium Leggings");
        GameRegistry.addRecipe(new ItemStack(titaniumLeggings), new Object[] {
                "XXX", "X X", "X X", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        titaniumBoots = new TitaniumArmor(titaniumBootsID, TITANIUMARMOR,
                ModLoader.addArmor("TitaniumArmor"), 3).setUnlocalizedName(
                "titaniumBoots").setCreativeTab(CreativeTabs.tabCombat);
        LanguageRegistry.addName(titaniumBoots, "Titanium Boots");
        GameRegistry.registerItem(titaniumBoots, "Titanium Boots");
        GameRegistry.addRecipe(new ItemStack(titaniumBoots), new Object[] {
                "   ", "X X", "X X", 'X', Spazzysmod.titaniumIngot, 'Y',
                Item.diamond

        });

        titaniumSword = new ItemTitaniumSword(titaniumSwordID, TITANIUM)
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

    public void registerEntities() {
        EntityRegistry.registerGlobalEntityID(EntityGopher.class, "Gopher",
                EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
        RenderingRegistry.registerEntityRenderingHandler(EntityGopher.class,
                new RenderGopher());
    }
}
