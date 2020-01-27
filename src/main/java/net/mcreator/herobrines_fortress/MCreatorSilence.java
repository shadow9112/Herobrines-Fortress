package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;

import java.util.Random;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSilence extends Elementsherobrines_fortress.ModElement {
	public static final int ENTITYID = 2;
	public static final int ENTITYID_RANGED = 3;

	public MCreatorSilence(Elementsherobrines_fortress instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("herobrines_fortress", "silence"), ENTITYID).name("silence").tracker(64, 1, true).egg(-10027162, -52429)
				.build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("herobrines_fortress", "entitybulletsilence"), ENTITYID_RANGED).name("entitybulletsilence")
				.tracker(64, 1, true).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("herobrines_fortress:sickness")),};
		EntityRegistry.addSpawn(EntityCustom.class, 1000, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
		DungeonHooks.addDungeonMob(new ResourceLocation("herobrines_fortress:silence"), 180);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelHuman(), 1f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("herobrines_fortress:textures/flyghts.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball<EntityArrowCustom>(renderManager, null, Minecraft.getMinecraft().getRenderItem()) {
				public ItemStack getStackToRender(EntityArrowCustom entity) {
					return new ItemStack(MCreatorTnTBow.block, (int) (1));
				}
			};
		});
	}

	public static class EntityCustom extends EntityBlaze implements IRangedAttackMob {
		public EntityCustom(World world) {
			super(world);
			setSize(1f, 3f);
			experienceValue = 10;
			this.isImmuneToFire = true;
			setNoAI(!true);
			this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.tasks.addTask(3, new EntityAIBase() {
				{
					this.setMutexBits(1);
				}

				@Override
				public boolean shouldExecute() {
					EntityMoveHelper entitymovehelper = EntityCustom.this.getMoveHelper();
					if (!entitymovehelper.isUpdating()) {
						return true;
					} else {
						double dx = entitymovehelper.getX() - EntityCustom.this.posX;
						double dy = entitymovehelper.getY() - EntityCustom.this.posY;
						double dz = entitymovehelper.getZ() - EntityCustom.this.posZ;
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
					Random random = EntityCustom.this.getRNG();
					double dir_x = EntityCustom.this.posX + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = EntityCustom.this.posY + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = EntityCustom.this.posZ + ((random.nextFloat() * 2 - 1) * 16);
					EntityCustom.this.getMoveHelper().setMoveTo(dir_x, dir_y, dir_z, 1);
				}
			});
			this.moveHelper = new EntityMoveHelper(this) {
				private int patchChangeTimer;

				@Override
				public void onUpdateMoveHelper() {
					if (this.action == EntityMoveHelper.Action.MOVE_TO) {
						double dx = this.posX - EntityCustom.this.posX;
						double dy = this.posY - EntityCustom.this.posY;
						double dz = this.posZ - EntityCustom.this.posZ;
						double d = dx * dx + dy * dy + dz * dz;
						if (this.patchChangeTimer-- <= 0) {
							this.patchChangeTimer += EntityCustom.this.getRNG().nextInt(5) + 2;
							d = (double) MathHelper.sqrt(d);
							if (this.isNotColliding(this.posX, this.posY, this.posZ, d)) {
								EntityCustom.this.motionX += dx / d * 0.1;
								EntityCustom.this.motionY += dy / d * 0.1;
								EntityCustom.this.motionZ += dz / d * 0.1;
							} else {
								this.action = EntityMoveHelper.Action.WAIT;
							}
						}
					}
				}

				private boolean isNotColliding(double x, double y, double z, double par) {
					double dx = (x - EntityCustom.this.posX) / par;
					double dy = (y - EntityCustom.this.posY) / par;
					double dz = (z - EntityCustom.this.posZ) / par;
					AxisAlignedBB axisalignedbb = EntityCustom.this.getEntityBoundingBox();
					for (int i = 1; (double) i < par; ++i) {
						axisalignedbb = axisalignedbb.offset(dx, dy, dz);
						if (!EntityCustom.this.world.getCollisionBoxes(EntityCustom.this, axisalignedbb).isEmpty())
							return false;
					}
					return true;
				}
			};
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAISwimming(this));
			this.tasks.addTask(6, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("block.furnace.fire_crackle"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
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
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40D);
		}

		@Override
		public void setSwingingArms(boolean swingingArms) {
		}

		public void attackEntityWithRangedAttack(EntityLivingBase target, float flval) {
			EntityArrowCustom entityarrow = new EntityArrowCustom(this.world, this);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d3 = target.posZ - this.posZ;
			entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			this.world.spawnEntity(entityarrow);
		}

		@Override
		public void travel(float ti, float tj, float tk) {
			if (this.isInWater()) {
				this.moveRelative(ti, tj, tk, 0.02f);
				this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
				this.motionX *= 0.8;
				this.motionY *= 0.8;
				this.motionZ *= 0.8;
				return;
			}
			if (this.isInLava()) {
				this.moveRelative(ti, tj, tk, 0.02f);
				this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
				this.motionX *= 0.5;
				this.motionY *= 0.5;
				this.motionZ *= 0.5;
				return;
			}
			float f = 0.91F;
			if (this.onGround) {
				BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1,
						MathHelper.floor(this.posZ));
				IBlockState underState = this.world.getBlockState(underPos);
				f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
			}
			this.moveRelative(ti, tj, tk, this.onGround ? 0.1f * 0.16f / (f * f * f) : 0.02F);
			f = 0.91F;
			if (this.onGround) {
				BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1,
						MathHelper.floor(this.posZ));
				IBlockState underState = this.world.getBlockState(underPos);
				f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
			}
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			this.motionX *= (double) f;
			this.motionY *= (double) f;
			this.motionZ *= (double) f;
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
		protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
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
					world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {
		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelHuman extends ModelBase {
		private final ModelRenderer bone;

		public ModelHuman() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone, 0.9599F, 0.0F, 0.0F);
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

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.bone.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.bone.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
