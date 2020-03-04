package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;

import java.util.HashMap;
import java.util.Arrays;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.arguments.StringArgumentType;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiredungeon2 extends Elementsherobrines_fortress.ModElement {
	public MCreatorFiredungeon2(Elementsherobrines_fortress instance) {
		super(instance, 89);
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
		event.getCommandDispatcher().register(customCommand());
	}

	private static LiteralArgumentBuilder<CommandSource> customCommand() {
		return LiteralArgumentBuilder.<CommandSource> literal("F2")
				.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(MCreatorFiredungeon2::execute))
				.executes(MCreatorFiredungeon2::execute);
	}

	private static int execute(CommandContext<CommandSource> ctx) {
		Entity entity = ctx.getSource().getEntity();
		if (entity != null) {
			int x = entity.getPosition().getX();
			int y = entity.getPosition().getY();
			int z = entity.getPosition().getZ();
			World world = entity.world;
			HashMap<String, String> cmdparams = new HashMap<>();
			int[] index = {0};
			Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
				cmdparams.put(Integer.toString(index[0]), param);
				index[0]++;
			});
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorSummonfiredungeon2CommandExecuted.executeProcedure($_dependencies);
			}
		}
		return 0;
	}
}
