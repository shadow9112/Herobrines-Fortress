package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFirearmour extends Elementsherobrines_fortress.ModElement {
	@GameRegistry.ObjectHolder("herobrines_fortress:firearmourhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("herobrines_fortress:firearmourbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("herobrines_fortress:firearmourlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("herobrines_fortress:firearmourboots")
	public static final Item boots = null;

	public MCreatorFirearmour(Elementsherobrines_fortress instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("FIREARMOUR", "herobrines_fortress:h", 40, new int[]{3, 4, 8, 8}, 100, null, 4f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MCreatorFirearmourBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("firearmourhelmet").setRegistryName("firearmourhelmet").setCreativeTab(MCreatorCustomelements.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MCreatorFirearmourBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("firearmourbody").setRegistryName("firearmourbody").setCreativeTab(MCreatorCustomelements.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MCreatorFirearmourBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("firearmourlegs").setRegistryName("firearmourlegs").setCreativeTab(MCreatorCustomelements.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MCreatorFirearmourBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("firearmourboots").setRegistryName("firearmourboots").setCreativeTab(MCreatorCustomelements.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("herobrines_fortress:firearmourhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("herobrines_fortress:firearmourbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("herobrines_fortress:firearmourlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("herobrines_fortress:firearmourboots", "inventory"));
	}
}
