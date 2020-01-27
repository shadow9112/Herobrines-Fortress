package net.mcreator.herobrines_fortress;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorKnockbackstickItemIsCraftedsmelted extends Elementsherobrines_fortress.ModElement {
	public MCreatorKnockbackstickItemIsCraftedsmelted(Elementsherobrines_fortress instance) {
		super(instance, 152);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure MCreatorKnockbackstickItemIsCraftedsmelted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.addEnchantment(Enchantments.KNOCKBACK, (int) 10);
	}
}
