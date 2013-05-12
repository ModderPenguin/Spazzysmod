package Spazzysmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMoonDirtBlock extends Block {

	public BlockMoonDirtBlock(int id, Material par2Material) {
		super(id, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock).setHardness(1.2F).setResistance(5.0F);

	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
		this.blockIcon = par1IconRegister.registerIcon(Spazzysmod.modid + ":" + this.getUnlocalizedName2());
	}

}
