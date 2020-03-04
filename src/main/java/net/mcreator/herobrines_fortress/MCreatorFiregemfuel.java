package net.mcreator.herobrines_fortress;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorFiregemfuel extends Elementsherobrines_fortress.ModElement {
	public MCreatorFiregemfuel(Elementsherobrines_fortress instance) {
		super(instance, 97);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(MCreatorFiregem.block, (int) (1)).getItem())
			event.setBurnTime(5000);
	}
}
