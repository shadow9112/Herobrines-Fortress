package net.mcreator.herobrines_fortress;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import com.google.common.collect.Multimap;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorKnockbackstick extends Elementsherobrines_fortress.ModElement {
	@ObjectHolder("herobrines_fortress:knockbackstick")
	public static final Item block = null;

	public MCreatorKnockbackstick(Elementsherobrines_fortress instance) {
		super(instance, 152);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity entity2) {
				boolean retval = super.hitEntity(itemstack, entity, entity2);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				World world = entity.world;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					MCreatorKnockbackstickItemIsCraftedsmelted.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("knockbackstick"));
	}

	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			super(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(130));
		}

		@Override
		public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
			return 0;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
			stack.damageItem(1, entityLiving, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			stack.damageItem(2, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 3;
		}

		@Override
		public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EquipmentSlotType.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 1f,
						AttributeModifier.Operation.ADDITION));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -2,
						AttributeModifier.Operation.ADDITION));
			}
			return multimap;
		}
	}
}
