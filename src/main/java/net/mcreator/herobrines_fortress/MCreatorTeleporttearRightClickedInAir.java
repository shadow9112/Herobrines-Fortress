package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
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
		for (int _ct = 0; _ct < 50; _ct++) {
			world.addOptionalParticle(ParticleTypes.DRAGON_BREATH, x, y, z, 3, 3, 3);
		}
		if (!entity.world.isRemote && entity instanceof ServerPlayerEntity) {
			DimensionType destinationType = DimensionType.OVERWORLD;
			ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) entity, true, "field_184851_cj");
			ServerWorld nextWorld = entity.getServer().getWorld(destinationType);
			((ServerPlayerEntity) entity).connection.sendPacket(new SChangeGameStatePacket(4, 0));
			((ServerPlayerEntity) entity).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1, nextWorld
					.getSpawnPoint().getZ(), entity.rotationYaw, entity.rotationPitch);
			((ServerPlayerEntity) entity).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) entity).abilities));
			for (EffectInstance effectinstance : ((ServerPlayerEntity) entity).getActivePotionEffects()) {
				((ServerPlayerEntity) entity).connection.sendPacket(new SPlayEntityEffectPacket(entity.getEntityId(), effectinstance));
			}
			((ServerPlayerEntity) entity).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setPositionAndUpdate((herobrines_fortressVariables.MapVariables.get(world).Home_x),
					(herobrines_fortressVariables.MapVariables.get(world).Home_y), (herobrines_fortressVariables.MapVariables.get(world).Home_z));
	}
}
