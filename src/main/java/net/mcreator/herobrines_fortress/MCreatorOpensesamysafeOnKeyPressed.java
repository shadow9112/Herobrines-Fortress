package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorOpensesamysafeOnKeyPressed extends Elementsherobrines_fortress.ModElement {
	public MCreatorOpensesamysafeOnKeyPressed(Elementsherobrines_fortress instance) {
		super(instance, 147);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorOpensesamysafeOnKeyPressed!");
			return;
		}
		World world = (World) dependencies.get("world");
		world.setDayTime((int) 13000);
	}
}
