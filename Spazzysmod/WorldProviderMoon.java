package Spazzysmod;

import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMoon extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Spazzysmod.moonBiome, 1.0F, 0.0F);
		this.isHellWorld = false;
        this.hasNoSky = true;
        this.dimensionId = Spazzysmod.moonDimensionID;
    }
	
	/*
	public String getSunTexture() {
		return "/path/to/your/sun/texture.png";
	}

	public String getMoonTexture() {
		return "/path/to/your/moon/texture.png";
	}
	*/
 	 
   public IChunkProvider createChunkGenerator()
   {
	   return new ChunkManagerMoon(this.worldObj, this.worldObj.getSeed(), hasNoSky);
   }
    
   public boolean isSurfaceWorld()
   {
	   return false;
   }
    
   @Override
   public float calculateCelestialAngle(long par1, float par3)
   {
	   int var4 = (int)(par1 % 24000L);
	   float var5 = ((float)var4 + par3) / 24000.0F - 0.25F;
	   
	   if (var5 < 0.0F)
	   {
		   ++var5;
	   }
	   
	   if (var5 > 1.0F)
	   {
		   --var5;
	   }

	   float var6 = var5;
	   var5 = 1.0F - (float)((Math.cos((double)var5 * Math.PI) + 1.0D) / 2.0D);
	   var5 = var6 + (var5 - var6) / 3.0F;
	   return var5;
   }
   
   @Override
   public boolean canRespawnHere()
   {
	   return true;
   }
   
   @Override
   public boolean doesXZShowFog(int par1, int par2)
   {
	   return false;
   }
    
   @Override
   public boolean isSkyColored()
   {
	   return true;
   }
    
   @Override
   public Vec3 drawClouds(float partialTicks)
   {
	   return worldObj.drawCloudsBody(partialTicks);
   }
    
   @Override
   public String getDimensionName()
   {
	   return "Moon";
   }
    
   @Override
   public String getWelcomeMessage()
   {
	   return "Flying to the Moon...";
   }	 
}