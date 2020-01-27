package net.mcreator.herobrines_fortress;

import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFirethrowingdaggerBulletHitsPlayer extends Elementsherobrines_fortress.ModElement {
	public MCreatorFirethrowingdaggerBulletHitsPlayer(Elementsherobrines_fortress instance) {
		super(instance, 114);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFirethrowingdaggerBulletHitsPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 15);
	}
}
