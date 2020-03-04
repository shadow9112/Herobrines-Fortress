package net.mcreator.herobrines_fortress;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiredragonOnEntityTickUpdate extends Elementsherobrines_fortress.ModElement {
	public MCreatorFiredragonOnEntityTickUpdate(Elementsherobrines_fortress instance) {
		super(instance, 126);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFiredragonOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Not_again = 0;
		if (((Not_again) == 0)) {
			if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld)) ? ((ServerPlayerEntity) entity)
					.getAdvancements()
					.getProgress(
							((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager().getAdvancement(
									new ResourceLocation("minecraft:end/kill_dragon"))).isDone() : false)) {
				if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld)) ? ((ServerPlayerEntity) entity)
						.getAdvancements()
						.getProgress(
								((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager().getAdvancement(
										new ResourceLocation("herobrines_fortress:@registryname"))).isDone() : false)) {
					if (entity instanceof PlayerEntity)
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), new ItemStack(MCreatorTnTBow.block, (int) (1)));
					Not_again = (double) 1;
				}
			}
		}
	}
}
