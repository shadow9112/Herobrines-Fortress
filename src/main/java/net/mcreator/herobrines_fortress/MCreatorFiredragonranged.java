package net.mcreator.herobrines_fortress;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiredragonranged extends Elementsherobrines_fortress.ModElement {
	public MCreatorFiredragonranged(Elementsherobrines_fortress instance) {
		super(instance, 77);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorFiredragonranged!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorFiredragonranged!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorFiredragonranged!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorFiredragonranged!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorFiredragonranged!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 100)) {
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 4, Explosion.Mode.BREAK);
			}
		}
		if ((Math.random() >= Math.max(0, 0.5))) {
			for (int index0 = 0; index0 < (int) (20); index0++) {
				if (!world.isRemote && entity instanceof LivingEntity) {
					ArrowEntity entityToSpawn = new ArrowEntity(world, (LivingEntity) entity);
					entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, ((float) 10) * 2.0F, 0);
					entityToSpawn.setDamage(((float) 20) * 2.0F);
					entityToSpawn.setKnockbackStrength((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() > Math.max(0.6, 0.8))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 2, (int) 10, (false), (false)));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) 2);
		} else if ((Math.random() == Math.max(0.85, 0.9))) {
			if (entity instanceof PlayerEntity)
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), new ItemStack(MCreatorSelfstabbingdagger.block, (int) (1)));
		} else if ((Math.random() == 1)) {
			entity.setMotionMultiplier(null, new Vec3d(0.25D, (double) 0.05F, 0.25D));
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
		}
	}
}
