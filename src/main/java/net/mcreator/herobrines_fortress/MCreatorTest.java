package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import io.netty.buffer.Unpooled;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorTest extends Elementsherobrines_fortress.ModElement {
	public MCreatorTest(Elementsherobrines_fortress instance) {
		super(instance, 140);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTest!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorTest!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorTest!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorTest!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTest!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double NEIN_hail_hitler = 0;
		if (((herobrines_fortressVariables.MapVariables.get(world).Password_entered) == 0)) {
			if (entity instanceof ServerPlayerEntity)
				NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("Vaultpassword");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new MCreatorVaultpassword.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer())
								.writeBlockPos(new BlockPos(x, y, z)));
					}
				}, new BlockPos(x, y, z));
			herobrines_fortressVariables.MapVariables.get(world).Password_entered = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		}
	}
}
