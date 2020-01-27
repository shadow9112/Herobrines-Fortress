package net.mcreator.herobrines_fortress;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFireDragonCloseRange extends Elementsherobrines_fortress.ModElement {
	public MCreatorFireDragonCloseRange(Elementsherobrines_fortress instance) {
		super(instance, 78);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFireDragonCloseRange!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
	}
}
