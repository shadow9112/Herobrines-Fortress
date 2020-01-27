package net.mcreator.herobrines_fortress;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorHomeblockEntityWalksOnTheBlock extends Elementsherobrines_fortress.ModElement {
	public MCreatorHomeblockEntityWalksOnTheBlock(Elementsherobrines_fortress instance) {
		super(instance, 130);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorHomeblockEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorHomeblockEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorHomeblockEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorHomeblockEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorHomeblockEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((herobrines_fortressVariables.MapVariables.get(world).Home_item_give) == 0)) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, (y + 2), z, new ItemStack(MCreatorTeleporttear.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
			herobrines_fortressVariables.MapVariables.get(world).Home_item_give = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		}
		herobrines_fortressVariables.MapVariables.get(world).Home_x = (double) (entity.posX);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		herobrines_fortressVariables.MapVariables.get(world).Home_y = (double) (entity.posY);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		herobrines_fortressVariables.MapVariables.get(world).Home_z = (double) (entity.posZ);
		herobrines_fortressVariables.MapVariables.get(world).syncData(world);
	}
}
