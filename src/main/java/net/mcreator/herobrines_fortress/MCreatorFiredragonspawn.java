package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.world.Explosion;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiredragonspawn extends Elementsherobrines_fortress.ModElement {
	public MCreatorFiredragonspawn(Elementsherobrines_fortress instance) {
		super(instance, 76);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorFiredragonspawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorFiredragonspawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorFiredragonspawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorFiredragonspawn!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
		}
	}
}
