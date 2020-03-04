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

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSpawnsicknessvillageStructure2BlockAdded extends Elementsherobrines_fortress.ModElement {
	public MCreatorSpawnsicknessvillageStructure2BlockAdded(Elementsherobrines_fortress instance) {
		super(instance, 165);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorSpawnsicknessvillageStructure2BlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorSpawnsicknessvillageStructure2BlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorSpawnsicknessvillageStructure2BlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorSpawnsicknessvillageStructure2BlockAdded!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
					.getTemplateDefaulted(new ResourceLocation("herobrines_fortress", "_structure_2b"));
			if (template != null) {
				template.addBlocksToWorldChunk(world, new BlockPos((int) (x + 2), (int) (y + 1), (int) (z - 1)),
						new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
			}
		}
	}
}
