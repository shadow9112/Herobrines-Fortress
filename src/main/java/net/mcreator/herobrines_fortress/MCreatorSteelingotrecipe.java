package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorSteelingotrecipe extends Elementsherobrines_fortress.ModElement {
	public MCreatorSteelingotrecipe(Elementsherobrines_fortress instance) {
		super(instance, 143);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorSteeloreblock.block, (int) (1)), new ItemStack(MCreatorSteelingot.block, (int) (1)), 1F);
	}
}
