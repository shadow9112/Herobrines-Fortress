package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorKnockbacklashMobIsHitWithTool extends Elementsherobrines_fortress.ModElement {
	public MCreatorKnockbacklashMobIsHitWithTool(Elementsherobrines_fortress instance) {
		super(instance, 81);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorKnockbacklashMobIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorKnockbacklashMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && entity instanceof EntityLivingBase) {
			EntityTippedArrow entityToSpawn = new EntityTippedArrow(world, (EntityLivingBase) entity);
			entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, ((float) 100) * 2.0F, 0);
			entityToSpawn.setDamage(((float) 2) * 2.0F);
			entityToSpawn.setKnockbackStrength((int) 1e+36);
			world.spawnEntity(entityToSpawn);
		}
	}
}
