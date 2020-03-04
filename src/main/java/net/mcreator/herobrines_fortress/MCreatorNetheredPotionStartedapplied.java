package net.mcreator.herobrines_fortress;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorNetheredPotionStartedapplied extends Elementsherobrines_fortress.ModElement {
	public MCreatorNetheredPotionStartedapplied(Elementsherobrines_fortress instance) {
		super(instance, 52);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorNetheredPotionStartedapplied!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorNetheredPotionStartedapplied!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorNetheredPotionStartedapplied!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorNetheredPotionStartedapplied!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && world.getServer() != null) {
			world.getServer()
					.getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(), "effect @p minecraft:nausea 10 2");
		}
		if (!world.isRemote && world.getServer() != null) {
			world.getServer()
					.getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(), "effect @p minecraft:wither 10 2");
		}
	}
}
