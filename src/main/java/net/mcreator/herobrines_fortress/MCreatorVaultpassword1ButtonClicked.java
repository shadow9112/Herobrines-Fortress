package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;

@Elementsherobrines_fortress.ModElement.Tag
public class MCreatorVaultpassword1ButtonClicked extends Elementsherobrines_fortress.ModElement {
	public MCreatorVaultpassword1ButtonClicked(Elementsherobrines_fortress instance) {
		super(instance, 135);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorVaultpassword1ButtonClicked!");
			return;
		}
		World world = (World) dependencies.get("world");
		if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_1) == 0)) {
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_1 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number1 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		} else if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_2) == 0)) {
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_2 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number2 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		} else if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_3) == 0)) {
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_3 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number3 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		} else if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_4) == 0)) {
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_4 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number_4 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
		} else if (((herobrines_fortressVariables.MapVariables.get(world).Vault_password_5) == 0)) {
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_number5 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_5 = (double) 1;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_1 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_2 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_3 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_4 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			herobrines_fortressVariables.MapVariables.get(world).Vault_password_5 = (double) 0;
			herobrines_fortressVariables.MapVariables.get(world).syncData(world);
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Password Maximum Number reached"));
			}
		}
	}
}
