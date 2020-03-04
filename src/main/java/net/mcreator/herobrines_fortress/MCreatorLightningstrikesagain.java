package net.mcreator.herobrines_fortress;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.effect.LightningBoltEntity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorLightningstrikesagain extends Elementsherobrines_fortress.ModElement {
	public MCreatorLightningstrikesagain(Elementsherobrines_fortress instance) {
		super(instance, 72);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorLightningstrikesagain!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorLightningstrikesagain!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorLightningstrikesagain!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorLightningstrikesagain!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((herobrines_fortressVariables.MapVariables.get(world).Lightnings) == 5)) {
			if (world instanceof ServerWorld)
				((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world, (int) x, (int) y, (int) z, false));
		}
	}
}
