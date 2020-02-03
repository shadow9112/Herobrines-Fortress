package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.server.MinecraftServer;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorTesting_projectile_code extends Elementsherobrines_fortress.ModElement {
	public MCreatorTesting_projectile_code(Elementsherobrines_fortress instance) {
		super(instance, 152);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTesting_projectile_code!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorTesting_projectile_code!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorTesting_projectile_code!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorTesting_projectile_code!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTesting_projectile_code!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity.getHorizontalFacing()) == EnumFacing.NORTH)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.GOLD_ORE.getDefaultState(), 3);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("North"));
			}
		} else if (((entity.getHorizontalFacing()) == EnumFacing.EAST)) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 2), (int) z), MCreatorTestingprojectile.block.getDefaultState(), 3);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("East"));
			}
		} else if (((entity.getHorizontalFacing()) == EnumFacing.SOUTH)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.DIAMOND_ORE.getDefaultState(), 3);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("South"));
			}
		} else if (((entity.getHorizontalFacing()) == EnumFacing.WEST)) {
			world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), MCreatorProjectilenegativex.block.getDefaultState(), 3);
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new TextComponentString("West"));
			}
		}
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new TextComponentString("Repeat"));
		}
	}
}
