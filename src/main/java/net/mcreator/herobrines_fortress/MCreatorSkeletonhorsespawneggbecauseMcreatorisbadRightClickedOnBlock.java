package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSkeletonhorsespawneggbecauseMcreatorisbadRightClickedOnBlock extends Elementsherobrines_fortress.ModElement {
	public MCreatorSkeletonhorsespawneggbecauseMcreatorisbadRightClickedOnBlock(Elementsherobrines_fortress instance) {
		super(instance, 120);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorSkeletonhorsespawneggbecauseMcreatorisbadRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorSkeletonhorsespawneggbecauseMcreatorisbadRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorSkeletonhorsespawneggbecauseMcreatorisbadRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorSkeletonhorsespawneggbecauseMcreatorisbadRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new SkeletonHorseEntity(EntityType.SKELETON_HORSE, world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
	}
}
