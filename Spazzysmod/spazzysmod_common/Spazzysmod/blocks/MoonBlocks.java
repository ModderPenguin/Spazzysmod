package Spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import Spazzysmod.config.SpazzysConfig;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MoonBlocks {

    public static Block cheeseBlock;
    public static Block moonPortal;
    public static Block moonDirt;
    public static Block moonStone;

    @SuppressWarnings("deprecation")
    public static void initBlocks() {
        cheeseBlock = new BlockCheeseBlock(SpazzysConfig.cheeseBlockID,
                Material.rock).setUnlocalizedName("cheeseBlock");
        GameRegistry.registerBlock(cheeseBlock);
        LanguageRegistry.addName(cheeseBlock, "Block of Cheese");

        moonPortal = new BlockMoonPortal(SpazzysConfig.moonPortalID)
                .setUnlocalizedName("portal");
        GameRegistry.registerBlock(moonPortal);
        LanguageRegistry.addName(moonPortal, "Moon Portal");

        moonDirt = new BlockMoonDirtBlock(SpazzysConfig.moonDirtID,
                Material.rock).setUnlocalizedName("moonDirt");
        GameRegistry.registerBlock(moonDirt);
        LanguageRegistry.addName(moonDirt, "Moon Dirt");

        moonStone = new BlockMoonStoneBlock(SpazzysConfig.moonStoneID,
                Material.rock).setUnlocalizedName("moonStone");
        GameRegistry.registerBlock(moonStone);
        LanguageRegistry.addName(moonStone, "Moon Stone");
    }
}
