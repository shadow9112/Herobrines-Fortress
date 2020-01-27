package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFreindlydragonOnEntityTickUpdate extends Elementsherobrines_fortress.ModElement {
	public MCreatorFreindlydragonOnEntityTickUpdate(Elementsherobrines_fortress instance) {
		super(instance, 146);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFreindlydragonOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorFreindlydragonOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		herobrines_fortressVariables.MapVariables.get(world).flightx = (double) (entity.posX);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		herobrines_fortressVariables.MapVariables.get(world).flighty = (double) ((entity.posY) + 2);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		herobrines_fortressVariables.MapVariables.get(world).Flightz = (double) (entity.posZ);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
	}
}
