package net.mcreator.herobrines_fortress;

import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFireswordMobIsHitWithTool extends Elementsherobrines_fortress.ModElement {
	public MCreatorFireswordMobIsHitWithTool(Elementsherobrines_fortress instance) {
		super(instance, 111);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFireswordMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 10);
	}
}
