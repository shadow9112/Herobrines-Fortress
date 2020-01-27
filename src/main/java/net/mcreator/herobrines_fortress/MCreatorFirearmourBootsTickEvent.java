package net.mcreator.herobrines_fortress;

import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFirearmourBootsTickEvent extends Elementsherobrines_fortress.ModElement {
	public MCreatorFirearmourBootsTickEvent(Elementsherobrines_fortress instance) {
		super(instance, 74);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFirearmourBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.isBurning())) {
			entity.extinguish();
		}
	}
}
