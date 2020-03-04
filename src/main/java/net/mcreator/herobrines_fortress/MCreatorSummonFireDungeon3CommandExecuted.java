package net.mcreator.herobrines_fortress;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSummonFireDungeon3CommandExecuted extends Elementsherobrines_fortress.ModElement {
	public MCreatorSummonFireDungeon3CommandExecuted(Elementsherobrines_fortress instance) {
		super(instance, 90);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorSummonFireDungeon3CommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorSummonFireDungeon3CommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorSummonFireDungeon3CommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorSummonFireDungeon3CommandExecuted!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
					.getTemplateDefaulted(new ResourceLocation("herobrines_fortress", "fire_dungeon3"));
			if (template != null) {
				template.addBlocksToWorldChunk(world, new BlockPos((int) x, (int) y, (int) z), new PlacementSettings().setRotation(Rotation.NONE)
						.setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
			}
		}
		if (!world.isRemote) {
			Entity entityToSpawn = new MCreatorFiredragon.CustomEntity(MCreatorFiredragon.entity, world);
			entityToSpawn.setLocationAndAngles((x + 3), (y + 3), (z + 3), world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
	}
}
