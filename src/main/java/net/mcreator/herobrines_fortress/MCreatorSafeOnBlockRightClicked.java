package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSafeOnBlockRightClicked extends Elementsherobrines_fortress.ModElement {
	public MCreatorSafeOnBlockRightClicked(Elementsherobrines_fortress instance) {
		super(instance, 137);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorSafeOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorSafeOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorSafeOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorSafeOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorSafeOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		herobrines_fortressVariables.MapVariables.get(world).Password_entered = (double) 0;
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(herobrines_fortress.instance, MCreatorSafeinventory.GUIID, world, x, y, z);
	}
}
