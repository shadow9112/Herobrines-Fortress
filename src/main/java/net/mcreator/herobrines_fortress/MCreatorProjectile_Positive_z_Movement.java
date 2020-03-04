package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorProjectile_Positive_z_Movement extends Elementsherobrines_fortress.ModElement {
	public MCreatorProjectile_Positive_z_Movement(Elementsherobrines_fortress instance) {
		super(instance, 180);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorProjectile_Positive_z_Movement!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorProjectile_Positive_z_Movement!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorProjectile_Positive_z_Movement!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorProjectile_Positive_z_Movement!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			if (((herobrines_fortressVariables.MapVariables.get(world).Projectile_Movement) == 5)) {
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), MCreatorProjectile_Positive_z.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					herobrines_fortressVariables.MapVariables.get(world).Projectile_Movement = (double) 0;
					herobrines_fortressVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), MCreatorProjectile_Positive_z.block.getDefaultState(), 3);
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
