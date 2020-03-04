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
public class MCreatorVaultpasswordenterButtonClickedOnButtonClicked extends Elementsherobrines_fortress.ModElement {
	public MCreatorVaultpasswordenterButtonClickedOnButtonClicked(Elementsherobrines_fortress instance) {
		super(instance, 136);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorVaultpasswordenterButtonClickedOnButtonClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorVaultpasswordenterButtonClickedOnButtonClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorVaultpasswordenterButtonClickedOnButtonClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorVaultpasswordenterButtonClickedOnButtonClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorVaultpasswordenterButtonClickedOnButtonClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double Vault_password_1 = 0;
		double Vault_password_2 = 0;
		double Vault_password_3 = 0;
		double Vault_password_4 = 0;
		double Vault_password_5 = 0;
		double Set_vault_password = 0;
		if (((herobrines_fortressVariables.MapVariables.get(world).Set_vault_password) == 0)) {
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_1_password = (double) (herobrines_fortressVariables.MapVariables
					.get(world).Vault_password_number1);
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_2_password = (double) (herobrines_fortressVariables.MapVariables
					.get(world).Vault_password_number3);
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_3_password = (double) (herobrines_fortressVariables.MapVariables
					.get(world).Vault_password_number3);
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_4_password = (double) (herobrines_fortressVariables.MapVariables
					.get(world).Vault_password_number_4);
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_5_password = (double) (herobrines_fortressVariables.MapVariables
					.get(world).Vault_password_number5);
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Set_vault_password = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number1 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number2 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number3 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number_4 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number5 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof ServerPlayerEntity)
				NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("Safeinventory");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new MCreatorSafeinventory.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer())
								.writeBlockPos(new BlockPos(x, y, z)));
					}
				}, new BlockPos(x, y, z));
		} else if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_number1) == (herobrines_fortressVariables.MapVariables
				.get(world).Vault_password_1_password))) {
			if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_number2) == (herobrines_fortressVariables.MapVariables
					.get(world).Vault_password_2_password))) {
				if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_number3) == (herobrines_fortressVariables.MapVariables
						.get(world).Vault_password_3_password))) {
					if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_number_4) == (herobrines_fortressVariables.MapVariables
							.get(world).Vault_password_4_password))) {
						if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_number5) == (herobrines_fortressVariables.MapVariables
								.get(world).Vault_password_5_password))) {
							if (entity instanceof ServerPlayerEntity)
								NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
									@Override
									public ITextComponent getDisplayName() {
										return new StringTextComponent("Safeinventory");
									}

									@Override
									public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
										return new MCreatorSafeinventory.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer())
												.writeBlockPos(new BlockPos(x, y, z)));
									}
								}, new BlockPos(x, y, z));
						}
					}
				}
			}
		}
	}
}
