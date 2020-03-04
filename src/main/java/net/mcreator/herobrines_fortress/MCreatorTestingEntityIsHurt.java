package net.mcreator.herobrines_fortress;

import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorTestingEntityIsHurt extends Elementsherobrines_fortress.ModElement {
	public MCreatorTestingEntityIsHurt(Elementsherobrines_fortress instance) {
		super(instance, 123);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTestingEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).swingArm(Hand.MAIN_HAND);
		}
	}
}
