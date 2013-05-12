package Spazzysmod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ItemTitaniumHelmet extends ItemArmor{

	public ItemTitaniumHelmet(int par1,
			EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
		this.itemIcon = par1IconRegister.registerIcon(Spazzysmod.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
