package net.mcreator.herobrines_fortress;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.effect.LightningBoltEntity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorLightningwaterMobplayerCollidesBlock extends Elementsherobrines_fortress.ModElement {
	public MCreatorLightningwaterMobplayerCollidesBlock(Elementsherobrines_fortress instance) {
		super(instance, 177);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorLightningwaterMobplayerCollidesBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorLightningwaterMobplayerCollidesBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorLightningwaterMobplayerCollidesBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorLightningwaterMobplayerCollidesBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (world instanceof ServerWorld)
			((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world, (int) x, (int) y, (int) z, false));
	}
}
