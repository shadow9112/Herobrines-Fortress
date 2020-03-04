package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.block.BlockState;

import java.util.Random;
import java.util.EnumSet;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSilence extends Elementsherobrines_fortress.ModElement {
	public static EntityType entity = null;
	@ObjectHolder("herobrines_fortress:entitybulletsilence")
	public static final EntityType arrow = null;

	public MCreatorSilence(Elementsherobrines_fortress instance) {
		super(instance, 48);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity> create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(CustomEntity::new).immuneToFire().size(1f, 3f)).build("silence")
				.setRegistryName("silence");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -10027162, -52429, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("silence"));
		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity> create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new).size(
				0.5f, 0.5f)).build("entitybulletsilence").setRegistryName("entitybulletsilence"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("herobrines_fortress:sickness")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 1000, 1, 3));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::func_223315_a);
		DungeonHooks.addDungeonMob(entity, 180);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelsilence(), 1f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("herobrines_fortress:textures/flyghts.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(ArrowCustomEntity.class, renderManager -> {
			return new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer());
		});
	}

	public static class CustomEntity extends BlazeEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 10;
			setNoAI(false);
		}

		@Override
		protected void registerGoals() {
			this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(3, new Goal() {
				{
					this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
				}

				@Override
				public boolean shouldExecute() {
					MovementController movecontroller = CustomEntity.this.getMoveHelper();
					if (!movecontroller.isUpdating()) {
						return true;
					} else {
						double dx = movecontroller.getX() - CustomEntity.this.posX;
						double dy = movecontroller.getY() - CustomEntity.this.posY;
						double dz = movecontroller.getZ() - CustomEntity.this.posZ;
						double d = dx * dx + dy * dy + dz * dz;
						return d < 1 || d > 3600;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return false;
				}

				@Override
				public void startExecuting() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.posX + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.posY + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.posZ + ((random.nextFloat() * 2 - 1) * 16);
					CustomEntity.this.getMoveHelper().setMoveTo(dir_x, dir_y, dir_z, 1);
				}
			});
			this.moveController = new MovementController(this) {
				private int patchChangeTimer;

				@Override
				public void tick() {
					if (this.action == MovementController.Action.MOVE_TO) {
						double dx = this.posX - CustomEntity.this.posX;
						double dy = this.posY - CustomEntity.this.posY;
						double dz = this.posZ - CustomEntity.this.posZ;
						double d = dx * dx + dy * dy + dz * dz;
						if (this.patchChangeTimer-- <= 0) {
							this.patchChangeTimer += CustomEntity.this.getRNG().nextInt(5) + 2;
							d = (double) MathHelper.sqrt(d);
							if (this.checkCollision(this.posX, this.posY, this.posZ, d)) {
								CustomEntity.this.moveRelative(1, new Vec3d(dx / d * 0.1, dy / d * 0.1, dz / d * 0.1));
							} else {
								this.action = MovementController.Action.WAIT;
							}
						}
					}
				}

				private boolean checkCollision(double x, double y, double z, double par) {
					double dx = (x - CustomEntity.this.posX) / par;
					double dy = (y - CustomEntity.this.posY) / par;
					double dz = (z - CustomEntity.this.posZ) / par;
					AxisAlignedBB axisalignedbb = CustomEntity.this.getBoundingBox();
					for (int i = 1; (double) i < par; ++i) {
						axisalignedbb = axisalignedbb.offset(dx, dy, dz);
						if (!CustomEntity.this.world.getEntitiesWithinAABBExcludingEntity(CustomEntity.this, axisalignedbb).isEmpty())
							return false;
					}
					return true;
				}
			};
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
			this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.8));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, this, this.world);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d3 = target.posZ - this.posZ;
			entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			world.addEntity(entityarrow);
		}

		@Override
		public void travel(Vec3d dir) {
			if (this.isInWater()) {
				this.moveRelative(0.02f, dir);
				this.move(MoverType.SELF, this.getMotion());
				this.setMotion(this.getMotion().scale((double) 0.8f));
				return;
			}
			if (this.isInLava()) {
				this.moveRelative(0.02f, dir);
				this.move(MoverType.SELF, this.getMotion());
				this.setMotion(this.getMotion().scale((double) 0.5f));
				return;
			}
			BlockPos ground = new BlockPos(this.posX, this.getBoundingBox().minY - 1, this.posZ);
			float f = 0.91f;
			if (this.onGround)
				f = this.world.getBlockState(ground).getSlipperiness(world, ground, this) * 0.91f;
			float f1 = 0.16f / (f * f * f);
			f = 0.91f;
			if (this.onGround)
				f = this.world.getBlockState(ground).getSlipperiness(world, ground, this) * 0.91f;
			this.moveRelative(this.onGround ? 0.1f * f1 : 0.02f, dir);
			this.move(MoverType.SELF, this.getMotion());
			this.setMotion(this.getMotion().scale((double) f));
			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d1 = this.posX - this.prevPosX;
			double d0 = this.posZ - this.prevPosZ;
			float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
			if (f2 > 1)
				f2 = 1;
			this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		public void livingTick() {
			super.livingTick();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 1; ++l) {
					double d0 = (i + random.nextFloat());
					double d1 = (j + random.nextFloat());
					double d2 = (k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.addParticle(ParticleTypes.EXPLOSION, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return new ItemStack(MCreatorTnTBow.block, (int) (1));
		}

		@Override
		protected ItemStack getArrowStack() {
			return new ItemStack(MCreatorTnTBow.block, (int) (1));
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelsilence extends EntityModel<Entity> {
		private final RendererModel bone;

		public Modelsilence() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new RendererModel(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.cubeList.add(new ModelBox(bone, 0, 8, -5.0F, -6.0F, 0.0F, 2, 6, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 8, -2.0F, -6.0F, 0.0F, 2, 6, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 2, 2, -5.0F, -13.0F, 0.0F, 5, 7, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 4, -4.0F, -16.0F, -1.0F, 3, 3, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 8, 12, -3.0F, -17.0F, -1.0F, 1, 1, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -13.0F, 1.0F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -13.0F, 1.0F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 1.0F, -14.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 2.0F, -14.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -14.0F, 1.0F, 2, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -15.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -14.0F, -15.0F, 1.0F, 6, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 4.0F, -15.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -14.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 3.0F, -14.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -14.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 5.0F, -14.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 6.0F, -14.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 6.0F, -13.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 5.0F, -13.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -13.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 3.0F, -13.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 2.0F, -13.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 1.0F, -13.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 1.0F, -12.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 2.0F, -12.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 3.0F, -12.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -12.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 5.0F, -12.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 5.0F, -11.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -11.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 4.0F, -10.0F, 2.0F, 1, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 1.0F, -7.0F, 2.0F, 2, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, -8.0F, -7.0F, 2.0F, 2, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 0.0F, -11.0F, 2.0F, 4, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 0.0F, -10.0F, 2.0F, 4, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 0.0F, -9.0F, 2.0F, 4, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, 0.0F, -8.0F, 2.0F, 4, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, -9.0F, -8.0F, 2.0F, 4, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, -9.0F, -9.0F, 2.0F, 4, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, -11.0F, -12.0F, 2.0F, 5, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, -12.0F, -14.0F, 2.0F, 5, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, -12.0F, -13.0F, 2.0F, 6, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, -10.0F, -10.0F, 2.0F, 5, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 0, -11.0F, -11.0F, 2.0F, 6, 1, 0, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 5.0F, -15.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 6.0F, -15.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -15.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 8.0F, -15.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -14.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -13.0F, -14.0F, 1.0F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -12.0F, -12.0F, 1.0F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -10.0F, -9.0F, 1.0F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -11.0F, -10.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -9.0F, -7.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 7.0F, -13.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 6.0F, -12.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 6.0F, -11.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 5.0F, -10.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 4.0F, -9.0F, 1.0F, 1, 2, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -7.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 0.0F, -7.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -7.0F, 1.0F, 1, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -6.0F, 1.0F, 2, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, 1.0F, -6.0F, 1.0F, 2, 1, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bone.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
