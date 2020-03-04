package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorHi extends Elementsherobrines_fortress.ModElement {
	public MCreatorHi(Elementsherobrines_fortress instance) {
		super(instance, 149);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorHi!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorHi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && entity instanceof LivingEntity) {
			ArrowEntity entityToSpawn = new ArrowEntity(world, (LivingEntity) entity);
			entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, ((float) 0.01) * 2.0F, 0);
			entityToSpawn.setDamage(((float) 5) * 2.0F);
			entityToSpawn.setKnockbackStrength((int) 5);
			world.addEntity(entityToSpawn);
		}
	}
}
