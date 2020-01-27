package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorLightningstrikesagainEntityWalksOnTheBlock extends Elementsherobrines_fortress.ModElement {
	public MCreatorLightningstrikesagainEntityWalksOnTheBlock(Elementsherobrines_fortress instance) {
		super(instance, 71);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorLightningstrikesagainEntityWalksOnTheBlock!");
			return;
		}
		World world = (World) dependencies.get("world");
		herobrines_fortressVariables.MapVariables.get(world).Lightnings = (double) ((herobrines_fortressVariables.MapVariables.get(world).Lightnings) + 1);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
	}
}
