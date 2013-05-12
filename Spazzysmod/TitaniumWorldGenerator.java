package Spazzysmod;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class TitaniumWorldGenerator implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
				
		
		}

	}

	private void generateEnd(World world, Random random, int i, int j) {
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		for (int k = 0; k < 6; k++){
			int Xcoord = i + random.nextInt(16);
			int Ycoord = random.nextInt(16);
			int Zcoord = j + random.nextInt(16);
			
			(new WorldGenMinable(Spazzysmod.titaniumBlock.blockID, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {
			
	}

}
