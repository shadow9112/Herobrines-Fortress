package net.mcreator.herobrines_fortress;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

import java.util.Random;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiredungeonlarge extends Elementsherobrines_fortress.ModElement {
	public MCreatorFiredungeonlarge(Elementsherobrines_fortress instance) {
		super(instance, 85);
	}

	@Override
	public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		boolean isNetherType = false;
		if (dimID == MCreatorFirey.DIMID) {
			dimensionCriteria = true;
			isNetherType = MCreatorFirey.NETHER_TYPE;
		}
		if (!dimensionCriteria)
			return;
		if ((random.nextInt(1000000) + 1) <= 0) {
			int i = i2 + random.nextInt(16) + 8;
			int k = k2 + random.nextInt(16) + 8;
			int height = 255;
			if (isNetherType) {
				boolean notpassed = true;
				while (height > 0) {
					if (notpassed
							&& (world.isAirBlock(new BlockPos(i, height, k)) || !world.getBlockState(new BlockPos(i, height, k)).getBlock()
									.getMaterial(world.getBlockState(new BlockPos(i, height, k))).blocksMovement()))
						notpassed = false;
					else if (!notpassed
							&& !world.isAirBlock(new BlockPos(i, height, k))
							&& world.getBlockState(new BlockPos(i, height, k)).getBlock()
									.getMaterial(world.getBlockState(new BlockPos(i, height, k))).blocksMovement())
						break;
					height--;
				}
			} else {
				while (height > 0) {
					if (!world.isAirBlock(new BlockPos(i, height, k))
							&& world.getBlockState(new BlockPos(i, height, k)).getBlock()
									.getMaterial(world.getBlockState(new BlockPos(i, height, k))).blocksMovement())
						break;
					height--;
				}
			}
			int j = Math.abs(random.nextInt(Math.max(1, height)) - 24);
			if (world.isRemote)
				return;
			Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
					new ResourceLocation("herobrines_fortress", "fire_dungeon"));
			if (template == null)
				return;
			Rotation rotation = Rotation.values()[random.nextInt(3)];
			Mirror mirror = Mirror.values()[random.nextInt(2)];
			BlockPos spawnTo = new BlockPos(i, j + -10, k);
			IBlockState iblockstate = world.getBlockState(spawnTo);
			world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
			template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(rotation).setMirror(mirror).setChunk((ChunkPos) null)
					.setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
		}
	}
}
