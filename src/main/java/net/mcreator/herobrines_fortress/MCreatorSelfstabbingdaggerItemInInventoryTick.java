package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSelfstabbingdaggerItemInInventoryTick extends Elementsherobrines_fortress.ModElement {
	public MCreatorSelfstabbingdaggerItemInInventoryTick(Elementsherobrines_fortress instance) {
		super(instance, 82);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorSelfstabbingdaggerItemInInventoryTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorSelfstabbingdaggerItemInInventoryTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorSelfstabbingdaggerItemInInventoryTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorSelfstabbingdaggerItemInInventoryTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorSelfstabbingdaggerItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
		}
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 5);
		entity.setFire((int) 3);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(
					p -> new ItemStack(MCreatorSelfstabbingdagger.block, (int) (1)).getItem() == p.getItem(), (int) 1);
	}
}
