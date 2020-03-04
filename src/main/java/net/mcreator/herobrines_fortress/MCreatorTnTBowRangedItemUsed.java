package net.mcreator.herobrines_fortress;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorTnTBowRangedItemUsed extends Elementsherobrines_fortress.ModElement {
	public MCreatorTnTBowRangedItemUsed(Elementsherobrines_fortress instance) {
		super(instance, 45);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTnTBowRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel(-((int) 5));
	}
}
