package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.ServerBossInfo;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
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
public class MCreatorFiredragon extends Elementsherobrines_fortress.ModElement {
	public static EntityType entity = null;
	@ObjectHolder("herobrines_fortress:entitybulletfiredragon")
	public static final EntityType arrow = null;

	public MCreatorFiredragon(Elementsherobrines_fortress instance) {
		super(instance, 75);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity> create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(CustomEntity::new).immuneToFire().size(3f, 2f)).build("firedragon")
				.setRegistryName("firedragon");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -39373, -65536, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("firedragon"));
		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity> create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new).size(
				0.5f, 0.5f)).build("entitybulletfiredragon").setRegistryName("entitybulletfiredragon"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelmobgeo(), 4f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("herobrines_fortress:textures/dragons.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(ArrowCustomEntity.class, renderManager -> {
			return new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer());
		});
	}

	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		protected void registerGoals() {
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, true));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(4, new Goal() {
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
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.8));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("herobrines_fortress:Firey"));
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
		public void onStruckByLightning(LightningBoltEntity entityLightningBolt) {
			super.onStruckByLightning(entityLightningBolt);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorTnTBowBulletHitsBlock.executeProcedure($_dependencies);
			}
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorFiredragonranged.executeProcedure($_dependencies);
			}
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorFiredragonEntityDies.executeProcedure($_dependencies);
			}
		}

		@Override
		public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata,
				CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MCreatorFiredragonspawn.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity entity) {
			super.onCollideWithPlayer(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				MCreatorFireDragonCloseRange.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30);
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
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.NOTCHED_10);

		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
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
			return new ItemStack(Items.FIRE_CHARGE, (int) (1));
		}

		@Override
		protected ItemStack getArrowStack() {
			return new ItemStack(Items.FIRE_CHARGE, (int) (1));
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelmobgeo extends EntityModel<Entity> {
		private final RendererModel bone;
		private final RendererModel bone2;
		private final RendererModel bone3;
		private final RendererModel bone18;
		private final RendererModel bone20;
		private final RendererModel bone4;
		private final RendererModel bone6;
		private final RendererModel bone8;
		private final RendererModel bone10;
		private final RendererModel bone5;
		private final RendererModel bone7;
		private final RendererModel bone9;
		private final RendererModel bone11;
		private final RendererModel bone12;
		private final RendererModel bone13;
		private final RendererModel bone14;
		private final RendererModel bone15;
		private final RendererModel bone16;
		private final RendererModel bone17;
		private final RendererModel bone19;
		private final RendererModel bone21;
		private final RendererModel bone22;
		private final RendererModel bone23;
		private final RendererModel bone24;
		private final RendererModel bone25;
		private final RendererModel bone26;

		public Modelmobgeo() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new RendererModel(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone, 0.5236F, 0.0F, 0.0F);
			bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -10.0F, 2.0F, 5, 11, 5, 0.0F, false));
			bone2 = new RendererModel(this);
			bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone2, 0.5236F, 0.0F, 0.0F);
			bone2.cubeList.add(new ModelBox(bone2, 0, 0, -8.0F, -10.0F, 2.0F, 5, 11, 5, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 0, 0, -8.0F, -19.0F, -16.0F, 5, 11, 5, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 0, 0, 3.0F, -19.0F, -16.0F, 5, 11, 5, 0.0F, false));
			bone3 = new RendererModel(this);
			bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -13.0F, 0.0F, 4, 4, 18, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 12, 38, -2.0F, -13.0F, -45.0F, 4, 4, 22, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 30, 0, -4.0F, -16.0F, -54.0F, 8, 7, 11, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -13.0F, 19.0F, 4, 4, 18, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 14, 33, -1.0F, -12.0F, 30.0F, 2, 2, 12, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -12.0F, 11.0F, 4, 4, 15, 0.0F, false));
			bone18 = new RendererModel(this);
			bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(bone18, 0.0F, 0.1745F, 0.0F);
			bone3.addChild(bone18);
			bone18.cubeList.add(new ModelBox(bone18, 0, 25, -29.0F, -14.0F, -25.0F, 29, 3, 3, 0.0F, false));
			bone20 = new RendererModel(this);
			bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(bone20, 0.0F, 0.1745F, 0.0F);
			bone3.addChild(bone20);
			bone20.cubeList.add(new ModelBox(bone20, 0, 25, -50.0F, -14.0F, -24.0F, 29, 3, 3, 0.0F, false));
			bone4 = new RendererModel(this);
			bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -15.0F, 3.0F, 1, 2, 3, 0.0F, false));
			bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -16.0F, 4.0F, 1, 1, 2, 0.0F, false));
			bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -17.0F, 4.0F, 1, 1, 1, 0.0F, false));
			bone6 = new RendererModel(this);
			bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -14.0F, 14.0F, 1, 2, 3, 0.0F, false));
			bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -15.0F, 15.0F, 1, 1, 2, 0.0F, false));
			bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -16.0F, 15.0F, 1, 1, 1, 0.0F, false));
			bone8 = new RendererModel(this);
			bone8.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -15.0F, 25.0F, 1, 2, 3, 0.0F, false));
			bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -16.0F, 26.0F, 1, 1, 2, 0.0F, false));
			bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -17.0F, 26.0F, 1, 1, 1, 0.0F, false));
			bone10 = new RendererModel(this);
			bone10.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone10.cubeList.add(new ModelBox(bone10, 0, 21, -0.5F, -13.0F, 31.0F, 1, 1, 2, 0.0F, false));
			bone10.cubeList.add(new ModelBox(bone10, 0, 0, -0.5F, -14.0F, 31.0F, 1, 1, 1, 0.0F, false));
			bone5 = new RendererModel(this);
			bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone5.cubeList.add(new ModelBox(bone5, 0, 33, -5.0F, -14.0F, -27.0F, 10, 6, 27, 0.0F, false));
			bone7 = new RendererModel(this);
			bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -16.0F, -4.0F, 1, 2, 3, 0.0F, false));
			bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -17.0F, -3.0F, 1, 1, 2, 0.0F, false));
			bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -18.0F, -3.0F, 1, 1, 1, 0.0F, false));
			bone9 = new RendererModel(this);
			bone9.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -16.0F, -12.0F, 1, 2, 3, 0.0F, false));
			bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -17.0F, -11.0F, 1, 1, 2, 0.0F, false));
			bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -18.0F, -11.0F, 1, 1, 1, 0.0F, false));
			bone11 = new RendererModel(this);
			bone11.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -16.0F, -20.0F, 1, 2, 3, 0.0F, false));
			bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -17.0F, -19.0F, 1, 1, 2, 0.0F, false));
			bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -18.0F, -19.0F, 1, 1, 1, 0.0F, false));
			bone12 = new RendererModel(this);
			bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -16.0F, -27.0F, 1, 2, 3, 0.0F, false));
			bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -17.0F, -26.0F, 1, 1, 2, 0.0F, false));
			bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -18.0F, -26.0F, 1, 1, 1, 0.0F, false));
			bone13 = new RendererModel(this);
			bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone13, -0.0349F, 0.0F, 0.0F);
			bone13.cubeList.add(new ModelBox(bone13, 0, 44, -3.0F, -11.5812F, -59.9927F, 6, 2, 6, 0.0F, false));
			bone14 = new RendererModel(this);
			bone14.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone14, 0.0175F, 0.0F, 0.0F);
			bone14.cubeList.add(new ModelBox(bone14, 0, 52, -3.0F, -12.2094F, -58.9982F, 6, 2, 6, 0.0F, false));
			bone15 = new RendererModel(this);
			bone15.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -15.0F, -34.0F, 1, 2, 3, 0.0F, false));
			bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -16.0F, -33.0F, 1, 1, 2, 0.0F, false));
			bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -17.0F, -33.0F, 1, 1, 1, 0.0F, false));
			bone16 = new RendererModel(this);
			bone16.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -15.0F, -42.0F, 1, 2, 3, 0.0F, false));
			bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -16.0F, -41.0F, 1, 1, 2, 0.0F, false));
			bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -17.0F, -41.0F, 1, 1, 1, 0.0F, false));
			bone17 = new RendererModel(this);
			bone17.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -18.0F, -51.0F, 1, 2, 3, 0.0F, false));
			bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -19.0F, -50.0F, 1, 1, 2, 0.0F, false));
			bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -20.0F, -50.0F, 1, 1, 1, 0.0F, false));
			bone19 = new RendererModel(this);
			bone19.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone19, 0.0F, -0.1745F, 0.0F);
			bone19.cubeList.add(new ModelBox(bone19, 0, 25, 0.0F, -14.0F, -25.0F, 29, 3, 3, 0.0F, true));
			bone19.cubeList.add(new ModelBox(bone19, 0, 25, 20.0F, -14.0F, -24.0F, 29, 3, 3, 0.0F, true));
			bone21 = new RendererModel(this);
			bone21.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone21.cubeList.add(new ModelBox(bone21, 0, 33, -24.0F, -13.0F, -21.0F, 19, 1, 20, 0.0F, false));
			bone21.cubeList.add(new ModelBox(bone21, 0, 33, -43.0F, -13.0F, -17.0F, 19, 1, 16, 0.0F, false));
			bone21.cubeList.add(new ModelBox(bone21, 0, 33, -50.0F, -13.0F, -15.0F, 19, 1, 14, 0.0F, false));
			bone22 = new RendererModel(this);
			bone22.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone22.cubeList.add(new ModelBox(bone22, 0, 33, 5.0F, -13.0F, -21.0F, 19, 1, 20, 0.0F, true));
			bone22.cubeList.add(new ModelBox(bone22, 0, 33, 24.0F, -13.0F, -17.0F, 19, 1, 16, 0.0F, true));
			bone22.cubeList.add(new ModelBox(bone22, 0, 33, 31.0F, -13.0F, -15.0F, 19, 1, 14, 0.0F, true));
			bone23 = new RendererModel(this);
			bone23.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone23, 0.0F, -0.8727F, 0.0F);
			bone23.cubeList.add(new ModelBox(bone23, 0, 25, -13.0F, -14.0F, -19.0F, 29, 3, 3, 0.0F, true));
			bone24 = new RendererModel(this);
			bone24.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone24, 0.0F, -0.5236F, 0.0F);
			bone24.cubeList.add(new ModelBox(bone24, 0, 25, -4.0F, -14.0F, -25.0F, 43, 3, 3, 0.0F, true));
			bone25 = new RendererModel(this);
			bone25.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone25, 0.0F, 0.8727F, 0.0F);
			bone25.cubeList.add(new ModelBox(bone25, 0, 25, -16.0F, -14.0F, -20.0F, 29, 3, 3, 0.0F, false));
			bone26 = new RendererModel(this);
			bone26.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone26, 0.0F, 0.5236F, 0.0F);
			bone26.cubeList.add(new ModelBox(bone26, 0, 25, -41.0F, -14.0F, -25.0F, 43, 3, 3, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bone.render(f5);
			bone2.render(f5);
			bone3.render(f5);
			bone4.render(f5);
			bone6.render(f5);
			bone8.render(f5);
			bone10.render(f5);
			bone5.render(f5);
			bone7.render(f5);
			bone9.render(f5);
			bone11.render(f5);
			bone12.render(f5);
			bone13.render(f5);
			bone14.render(f5);
			bone15.render(f5);
			bone16.render(f5);
			bone17.render(f5);
			bone19.render(f5);
			bone21.render(f5);
			bone22.render(f5);
			bone23.render(f5);
			bone24.render(f5);
			bone25.render(f5);
			bone26.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
		}
	}
}
