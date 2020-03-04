package net.mcreator.herobrines_fortress;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorDragonheartedmusicdiskRightClickedOnBlock extends Elementsherobrines_fortress.ModElement {
	public MCreatorDragonheartedmusicdiskRightClickedOnBlock(Elementsherobrines_fortress instance) {
		super(instance, 141);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorDragonheartedmusicdiskRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorDragonheartedmusicdiskRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorDragonheartedmusicdiskRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorDragonheartedmusicdiskRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorDragonheartedmusicdiskRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.JUKEBOX.getDefaultState().getBlock())) {
			herobrines_fortressVariables.MapVariables.get(world).Dragon_hearted_Variable = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			if (!world.isRemote && world.getServer() != null) {
				world.getServer()
						.getCommandManager()
						.handleCommand(
								new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
								"playsound herobrines_fortress:Dragon_hearted master @p");
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(
						p -> new ItemStack(MCreatorDragonheartedmusicdisk.block, (int) (1)).getItem() == p.getItem(), (int) 1);
		}
	}
}
