package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.IEntityLivingData;
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
import java.util.Iterator;
import java.util.ArrayList;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiredragon extends Elementsherobrines_fortress.ModElement {
	public static final int ENTITYID = 4;
	public static final int ENTITYID_RANGED = 5;

	public MCreatorFiredragon(Elementsherobrines_fortress instance) {
		super(instance, 75);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("herobrines_fortress", "firedragon"), ENTITYID).name("firedragon").tracker(64, 1, true).egg(-39373, -65536)
				.build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("herobrines_fortress", "entitybulletfiredragon"), ENTITYID_RANGED).name("entitybulletfiredragon")
				.tracker(64, 1, true).build());
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelmobgeo(), 4f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("herobrines_fortress:textures/dragons.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball<EntityArrowCustom>(renderManager, null, Minecraft.getMinecraft().getRenderItem()) {
				public ItemStack getStackToRender(EntityArrowCustom entity) {
					return new ItemStack(Items.FIRE_CHARGE, (int) (1));
				}
			};
		});
	}

	public static class EntityCustom extends EntityMob implements IRangedAttackMob {
		public EntityCustom(World world) {
			super(world);
			setSize(3f, 2f);
			experienceValue = 5;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, true));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(4, new EntityAIBase() {
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
			this.tasks.addTask(5, new EntityAILookIdle(this));
			this.tasks.addTask(6, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("herobrines_fortress:Firey"));
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
		public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
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
		public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
			IEntityLivingData retval = super.onInitialSpawn(difficulty, livingdata);
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
		public void onCollideWithPlayer(EntityPlayer entity) {
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
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30D);
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
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.NOTCHED_10);

		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
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
	public static class Modelmobgeo extends ModelBase {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer bone18;
		private final ModelRenderer bone20;
		private final ModelRenderer bone4;
		private final ModelRenderer bone6;
		private final ModelRenderer bone8;
		private final ModelRenderer bone10;
		private final ModelRenderer bone5;
		private final ModelRenderer bone7;
		private final ModelRenderer bone9;
		private final ModelRenderer bone11;
		private final ModelRenderer bone12;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		private final ModelRenderer bone15;
		private final ModelRenderer bone16;
		private final ModelRenderer bone17;
		private final ModelRenderer bone19;
		private final ModelRenderer bone21;
		private final ModelRenderer bone22;
		private final ModelRenderer bone23;
		private final ModelRenderer bone24;
		private final ModelRenderer bone25;
		private final ModelRenderer bone26;

		public Modelmobgeo() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone, 0.5236F, 0.0F, 0.0F);
			bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -10.0F, 2.0F, 5, 11, 5, 0.0F, false));
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone2, 0.5236F, 0.0F, 0.0F);
			bone2.cubeList.add(new ModelBox(bone2, 0, 0, -8.0F, -10.0F, 2.0F, 5, 11, 5, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 0, 0, -8.0F, -19.0F, -16.0F, 5, 11, 5, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 0, 0, 3.0F, -19.0F, -16.0F, 5, 11, 5, 0.0F, false));
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -13.0F, 0.0F, 4, 4, 18, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 12, 38, -2.0F, -13.0F, -45.0F, 4, 4, 22, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 30, 0, -4.0F, -16.0F, -54.0F, 8, 7, 11, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -13.0F, 19.0F, 4, 4, 18, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 14, 33, -1.0F, -12.0F, 30.0F, 2, 2, 12, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 14, 33, -2.0F, -12.0F, 11.0F, 4, 4, 15, 0.0F, false));
			bone18 = new ModelRenderer(this);
			bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(bone18, 0.0F, 0.1745F, 0.0F);
			bone3.addChild(bone18);
			bone18.cubeList.add(new ModelBox(bone18, 0, 25, -29.0F, -14.0F, -25.0F, 29, 3, 3, 0.0F, false));
			bone20 = new ModelRenderer(this);
			bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(bone20, 0.0F, 0.1745F, 0.0F);
			bone3.addChild(bone20);
			bone20.cubeList.add(new ModelBox(bone20, 0, 25, -50.0F, -14.0F, -24.0F, 29, 3, 3, 0.0F, false));
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -15.0F, 3.0F, 1, 2, 3, 0.0F, false));
			bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -16.0F, 4.0F, 1, 1, 2, 0.0F, false));
			bone4.cubeList.add(new ModelBox(bone4, 0, 16, -0.5F, -17.0F, 4.0F, 1, 1, 1, 0.0F, false));
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -14.0F, 14.0F, 1, 2, 3, 0.0F, false));
			bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -15.0F, 15.0F, 1, 1, 2, 0.0F, false));
			bone6.cubeList.add(new ModelBox(bone6, 0, 16, -0.5F, -16.0F, 15.0F, 1, 1, 1, 0.0F, false));
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -15.0F, 25.0F, 1, 2, 3, 0.0F, false));
			bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -16.0F, 26.0F, 1, 1, 2, 0.0F, false));
			bone8.cubeList.add(new ModelBox(bone8, 0, 16, -0.5F, -17.0F, 26.0F, 1, 1, 1, 0.0F, false));
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone10.cubeList.add(new ModelBox(bone10, 0, 21, -0.5F, -13.0F, 31.0F, 1, 1, 2, 0.0F, false));
			bone10.cubeList.add(new ModelBox(bone10, 0, 0, -0.5F, -14.0F, 31.0F, 1, 1, 1, 0.0F, false));
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone5.cubeList.add(new ModelBox(bone5, 0, 33, -5.0F, -14.0F, -27.0F, 10, 6, 27, 0.0F, false));
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -16.0F, -4.0F, 1, 2, 3, 0.0F, false));
			bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -17.0F, -3.0F, 1, 1, 2, 0.0F, false));
			bone7.cubeList.add(new ModelBox(bone7, 0, 16, -0.5F, -18.0F, -3.0F, 1, 1, 1, 0.0F, false));
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -16.0F, -12.0F, 1, 2, 3, 0.0F, false));
			bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -17.0F, -11.0F, 1, 1, 2, 0.0F, false));
			bone9.cubeList.add(new ModelBox(bone9, 0, 16, -0.5F, -18.0F, -11.0F, 1, 1, 1, 0.0F, false));
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -16.0F, -20.0F, 1, 2, 3, 0.0F, false));
			bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -17.0F, -19.0F, 1, 1, 2, 0.0F, false));
			bone11.cubeList.add(new ModelBox(bone11, 0, 16, -0.5F, -18.0F, -19.0F, 1, 1, 1, 0.0F, false));
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -16.0F, -27.0F, 1, 2, 3, 0.0F, false));
			bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -17.0F, -26.0F, 1, 1, 2, 0.0F, false));
			bone12.cubeList.add(new ModelBox(bone12, 0, 16, -0.5F, -18.0F, -26.0F, 1, 1, 1, 0.0F, false));
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone13, -0.0349F, 0.0F, 0.0F);
			bone13.cubeList.add(new ModelBox(bone13, 0, 44, -3.0F, -11.5812F, -59.9927F, 6, 2, 6, 0.0F, false));
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone14, 0.0175F, 0.0F, 0.0F);
			bone14.cubeList.add(new ModelBox(bone14, 0, 52, -3.0F, -12.2094F, -58.9982F, 6, 2, 6, 0.0F, false));
			bone15 = new ModelRenderer(this);
			bone15.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -15.0F, -34.0F, 1, 2, 3, 0.0F, false));
			bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -16.0F, -33.0F, 1, 1, 2, 0.0F, false));
			bone15.cubeList.add(new ModelBox(bone15, 0, 16, -0.5F, -17.0F, -33.0F, 1, 1, 1, 0.0F, false));
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -15.0F, -42.0F, 1, 2, 3, 0.0F, false));
			bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -16.0F, -41.0F, 1, 1, 2, 0.0F, false));
			bone16.cubeList.add(new ModelBox(bone16, 0, 16, -0.5F, -17.0F, -41.0F, 1, 1, 1, 0.0F, false));
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -18.0F, -51.0F, 1, 2, 3, 0.0F, false));
			bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -19.0F, -50.0F, 1, 1, 2, 0.0F, false));
			bone17.cubeList.add(new ModelBox(bone17, 0, 16, -0.5F, -20.0F, -50.0F, 1, 1, 1, 0.0F, false));
			bone19 = new ModelRenderer(this);
			bone19.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone19, 0.0F, -0.1745F, 0.0F);
			bone19.cubeList.add(new ModelBox(bone19, 0, 25, 0.0F, -14.0F, -25.0F, 29, 3, 3, 0.0F, true));
			bone19.cubeList.add(new ModelBox(bone19, 0, 25, 20.0F, -14.0F, -24.0F, 29, 3, 3, 0.0F, true));
			bone21 = new ModelRenderer(this);
			bone21.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone21.cubeList.add(new ModelBox(bone21, 0, 33, -24.0F, -13.0F, -21.0F, 19, 1, 20, 0.0F, false));
			bone21.cubeList.add(new ModelBox(bone21, 0, 33, -43.0F, -13.0F, -17.0F, 19, 1, 16, 0.0F, false));
			bone21.cubeList.add(new ModelBox(bone21, 0, 33, -50.0F, -13.0F, -15.0F, 19, 1, 14, 0.0F, false));
			bone22 = new ModelRenderer(this);
			bone22.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone22.cubeList.add(new ModelBox(bone22, 0, 33, 5.0F, -13.0F, -21.0F, 19, 1, 20, 0.0F, true));
			bone22.cubeList.add(new ModelBox(bone22, 0, 33, 24.0F, -13.0F, -17.0F, 19, 1, 16, 0.0F, true));
			bone22.cubeList.add(new ModelBox(bone22, 0, 33, 31.0F, -13.0F, -15.0F, 19, 1, 14, 0.0F, true));
			bone23 = new ModelRenderer(this);
			bone23.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone23, 0.0F, -0.8727F, 0.0F);
			bone23.cubeList.add(new ModelBox(bone23, 0, 25, -13.0F, -14.0F, -19.0F, 29, 3, 3, 0.0F, true));
			bone24 = new ModelRenderer(this);
			bone24.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone24, 0.0F, -0.5236F, 0.0F);
			bone24.cubeList.add(new ModelBox(bone24, 0, 25, -4.0F, -14.0F, -25.0F, 43, 3, 3, 0.0F, true));
			bone25 = new ModelRenderer(this);
			bone25.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone25, 0.0F, 0.8727F, 0.0F);
			bone25.cubeList.add(new ModelBox(bone25, 0, 25, -16.0F, -14.0F, -20.0F, 29, 3, 3, 0.0F, false));
			bone26 = new ModelRenderer(this);
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

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		}
	}
}
