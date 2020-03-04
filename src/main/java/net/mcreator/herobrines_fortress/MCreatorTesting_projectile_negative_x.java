package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorTesting_projectile_negative_x extends Elementsherobrines_fortress.ModElement {
	public MCreatorTesting_projectile_negative_x(Elementsherobrines_fortress instance) {
		super(instance, 155);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorTesting_projectile_negative_x!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorTesting_projectile_negative_x!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorTesting_projectile_negative_x!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTesting_projectile_negative_x!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			if (((herobrines_fortressVariables.MapVariables.get(world).Projectile_Movement) == 5)) {
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), MCreatorProjectilenegativex.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					herobrines_fortressVariables.MapVariables.get(world).Projectile_Movement = (double) 0;
					herobrines_fortressVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), MCreatorProjectilenegativex.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				herobrines_fortressVariables.MapVariables.get(world).Projectile_Movement = (double) ((herobrines_fortressVariables.MapVariables
						.get(world).Projectile_Movement) + 1);
				herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
