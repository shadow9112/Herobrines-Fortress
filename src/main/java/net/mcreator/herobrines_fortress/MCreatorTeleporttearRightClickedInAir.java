package net.mcreator.herobrines_fortress;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorTeleporttearRightClickedInAir extends Elementsherobrines_fortress.ModElement {
	public MCreatorTeleporttearRightClickedInAir(Elementsherobrines_fortress instance) {
		super(instance, 132);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTeleporttearRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorTeleporttearRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorTeleporttearRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorTeleporttearRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTeleporttearRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double Continue_on = 0;
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.DRAGON_BREATH, x, y, z, (int) 50, 3, 3, 3, 1, new int[0]);
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).setPositionAndUpdate((herobrines_fortressVariables.MapVariables.get(world).Home_x),
					(herobrines_fortressVariables.MapVariables.get(world).Home_y), (herobrines_fortressVariables.MapVariables.get(world).Home_z));
	}
}
