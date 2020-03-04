package net.mcreator.herobrines_fortress;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiredragonrangedRightClickedOnEntity extends Elementsherobrines_fortress.ModElement {
	public MCreatorFiredragonrangedRightClickedOnEntity(Elementsherobrines_fortress instance) {
		super(instance, 80);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFiredragonrangedRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setPositionAndUpdate(Math.random(), Math.random(), Math.random());
	}
}
