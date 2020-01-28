package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorTestingprojectileRandomTickUpdateEvent extends Elementsherobrines_fortress.ModElement {
	public MCreatorTestingprojectileRandomTickUpdateEvent(Elementsherobrines_fortress instance) {
		super(instance, 153);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorTestingprojectileRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorTestingprojectileRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorTestingprojectileRandomTickUpdateEvent!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTestingprojectileRandomTickUpdateEvent!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((herobrines_fortressVariables.MapVariables.get(world).Projectile_Movement) == 5)) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
			herobrines_fortressVariables.MapVariables.get(world).Projectile_Movement = (double) ((herobrines_fortressVariables.MapVariables
					.get(world).Projectile_Movement) + 1);
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		}
	}
}
