package Spazzysmod.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import Spazzysmod.Spazzysmod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabMoon extends CreativeTabs {

    public TabMoon(String s) {
        super(s);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {
        return Spazzysmod.moonStone.blockID;
    }

}
