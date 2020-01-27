package net.mcreator.herobrines_fortress;

import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorDimension0CommandExecuted extends Elementsherobrines_fortress.ModElement {
	public MCreatorDimension0CommandExecuted(Elementsherobrines_fortress instance) {
		super(instance, 127);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorDimension0CommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
	}
}
