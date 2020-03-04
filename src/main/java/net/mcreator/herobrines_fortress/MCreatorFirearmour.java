package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFirearmour extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:firearmourhelmet")
	public static final Item helmet = null;
	@ObjectHolder("herobrines_fortress:firearmourbody")
	public static final Item body = null;
	@ObjectHolder("herobrines_fortress:firearmourlegs")
	public static final Item legs = null;
	@ObjectHolder("herobrines_fortress:firearmourboots")
	public static final Item boots = null;

	public MCreatorFirearmour(Elementsherobrines_fortress instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 40;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{3, 4, 8, 8}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 100;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return null;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "firearmour";
			}

			public float getToughness() {
				return 4f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(MCreatorCustomelements.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedHead = new Modelfirehelmet().helmet;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "herobrines_fortress:textures/firehelmet_test.png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MCreatorFirearmourBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("firearmourhelmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(MCreatorCustomelements.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "herobrines_fortress:textures/models/armor/h_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MCreatorFirearmourBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("firearmourbody"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(MCreatorCustomelements.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "herobrines_fortress:textures/models/armor/h_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MCreatorFirearmourBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("firearmourlegs"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(MCreatorCustomelements.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "herobrines_fortress:textures/models/armor/h_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MCreatorFirearmourBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("firearmourboots"));
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelfirehelmet extends EntityModel<Entity> {
		private final RendererModel helmet;
		private final RendererModel left_horn;
		private final RendererModel right_horn;

		public Modelfirehelmet() {
			textureWidth = 128;
			textureHeight = 128;
			helmet = new RendererModel(this);
			helmet.setRotationPoint(0.0F, 24.0F, 0.0F);
			helmet.cubeList.add(new ModelBox(helmet, 0, 123, -4.0F, -6.0F, 2.0F, 8, 6, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 118, -5.0F, -6.0F, -6.0F, 1, 6, 8, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 118, 4.0F, -6.0F, -6.0F, 1, 6, 8, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 121, -4.0F, -7.0F, -7.0F, 1, 1, 9, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 122, -3.0F, -8.0F, -7.0F, 1, 1, 8, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 122, -2.0F, -9.0F, -6.0F, 1, 1, 6, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 122, 1.0F, -9.0F, -6.0F, 1, 1, 6, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 122, 2.0F, -8.0F, -7.0F, 1, 1, 8, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 118, 3.0F, -7.0F, -7.0F, 1, 1, 9, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 126, -3.0F, -7.0F, 1.0F, 6, 1, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 126, -2.0F, -8.0F, 0.0F, 4, 1, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 0, 122, -1.0F, -9.0F, -6.0F, 2, 1, 6, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 118, 0, -2.0F, -8.0F, -7.0F, 4, 1, 1, 0.0F, false));
			helmet.cubeList.add(new ModelBox(helmet, 118, 0, -3.0F, -7.0F, -8.0F, 6, 1, 1, 0.0F, false));
			left_horn = new RendererModel(this);
			left_horn.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(left_horn, 0.3491F, 0.0F, 0.0F);
			left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -3.0F, -12.0F, -3.0F, 1, 3, 1, 0.0F, false));
			left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -3.0F, -17.0F, -3.0F, 1, 4, 1, 0.0F, false));
			left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -4.0F, -15.0F, -3.0F, 1, 4, 1, 0.0F, false));
			left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -4.0F, -12.0F, -4.0F, 1, 1, 1, 0.0F, false));
			left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -3.0F, -14.0F, -2.0F, 1, 1, 1, 0.0F, false));
			left_horn.cubeList.add(new ModelBox(left_horn, 0, 0, -3.0F, -15.0F, -4.0F, 1, 1, 1, 0.0F, false));
			right_horn = new RendererModel(this);
			right_horn.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(right_horn, 0.3491F, 0.0F, 0.0F);
			right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 2.0F, -12.0F, -3.0F, 1, 3, 1, 0.0F, true));
			right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 2.0F, -17.0F, -3.0F, 1, 4, 1, 0.0F, true));
			right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 3.0F, -15.0F, -3.0F, 1, 4, 1, 0.0F, true));
			right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 3.0F, -12.0F, -4.0F, 1, 1, 1, 0.0F, true));
			right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 2.0F, -14.0F, -2.0F, 1, 1, 1, 0.0F, true));
			right_horn.cubeList.add(new ModelBox(right_horn, 0, 0, 2.0F, -15.0F, -4.0F, 1, 1, 1, 0.0F, true));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			helmet.render(f5);
			left_horn.render(f5);
			right_horn.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
