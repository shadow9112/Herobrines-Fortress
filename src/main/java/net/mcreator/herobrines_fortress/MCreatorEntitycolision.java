package net.mcreator.herobrines_fortress;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorEntitycolision extends Elementsherobrines_fortress.ModElement {
	public MCreatorEntitycolision(Elementsherobrines_fortress instance) {
		super(instance, 159);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorEntitycolision!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorEntitycolision!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorEntitycolision!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorEntitycolision!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorEntitycolision!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		String finding = "";
		herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x = (double) (entity.posX);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		herobrines_fortressVariables.MapVariables.get(world).Player_collison_y = (double) (entity.posY);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		herobrines_fortressVariables.MapVariables.get(world).Player_collision_z = (double) (entity.posZ);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 1),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collision_z)))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 1),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) (herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1), (int) z))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) x, (int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1), (int) z),
					Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 1),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 1),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 1)))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) x, (int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 1)), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) (herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) x, (int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 1)))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 1)), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collision_z)))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collison_y) + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 1),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collison_y), (int) (herobrines_fortressVariables.MapVariables
						.get(world).Player_collision_z)))).getBlock() == MCreatorProjectilenegativex.block.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(
					new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 1), (int) y, (int) z),
					Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) (herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collison_y), (int) z))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collison_y), (int) ((herobrines_fortressVariables.MapVariables
						.get(world).Player_collision_z) - 2)))).getBlock() == MCreatorProjectilenegativex.block.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2), (int) y,
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 1),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collison_y), (int) ((herobrines_fortressVariables.MapVariables
						.get(world).Player_collision_z) - 2)))).getBlock() == MCreatorProjectilenegativex.block.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 1), (int) y,
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (herobrines_fortressVariables.MapVariables.get(world).Player_collison_y),
				(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 1)))).getBlock() == MCreatorProjectilenegativex.block
				.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(
					new BlockPos((int) x, (int) y, (int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 1)),
					Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) (herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collison_y), (int) ((herobrines_fortressVariables.MapVariables
						.get(world).Player_collision_z) - 2)))).getBlock() == MCreatorProjectilenegativex.block.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(
					new BlockPos((int) x, (int) y, (int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 2)),
					Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collison_y), (int) ((herobrines_fortressVariables.MapVariables
						.get(world).Player_collision_z) - 1)))).getBlock() == MCreatorProjectilenegativex.block.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2), (int) y,
					(int) ((herobrines_fortressVariables.MapVariables.get(world).Player_collision_z) - 1)), Blocks.AIR.getDefaultState(), 3);
		} else if (((world.getBlockState(new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2),
				(int) (herobrines_fortressVariables.MapVariables.get(world).Player_collison_y), (int) (herobrines_fortressVariables.MapVariables
						.get(world).Player_collision_z)))).getBlock() == MCreatorProjectilenegativex.block.getDefaultState().getBlock())) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (int) (x));
				$_dependencies.put("y", (int) (y));
				$_dependencies.put("z", (int) (z));
				MCreatorProjectile_result_colids_with_block.executeProcedure($_dependencies);
			}
			world.setBlockState(
					new BlockPos((int) ((herobrines_fortressVariables.MapVariables.get(world).Player_Collision_x) - 2), (int) y, (int) z),
					Blocks.AIR.getDefaultState(), 3);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
