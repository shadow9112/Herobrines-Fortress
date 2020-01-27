package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorPlaybattlefield5themesongCommandExecuted extends Elementsherobrines_fortress.ModElement {
	public MCreatorPlaybattlefield5themesongCommandExecuted(Elementsherobrines_fortress instance) {
		super(instance, 92);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorPlaybattlefield5themesongCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorPlaybattlefield5themesongCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorPlaybattlefield5themesongCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorPlaybattlefield5themesongCommandExecuted!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.playSound((EntityPlayer) null, x, y, z, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
				.getObject(new ResourceLocation("herobrines_fortress:Battlefield")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
	}
}
