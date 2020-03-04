package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.LogicalSide;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class herobrines_fortressVariables {
	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "herobrines_fortress_worldvars";

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				herobrines_fortress.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(1, this));
			} else {
				herobrines_fortress.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world.dimension::getType), new WorldSavedDataSyncMessage(1,
						this));
			}
		}
		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(World world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "herobrines_fortress_mapvars";
		public double Vault_password_5_password = 0;
		public double Lightnings = 0;
		public double Home_x = 0;
		public double Home_y = 0;
		public double Home_z = 0;
		public double Home_item_give = 0;
		public double Teleport_timer = 0;
		public double Vault_password_1 = 0;
		public double Vault_password_2 = 0;
		public double Vault_password_3 = 0;
		public double Vault_password_4 = 0;
		public double Vault_password_5 = 0;
		public double Vault_password_number1 = 0;
		public double Vault_password_number2 = 0;
		public double Vault_password_number3 = 0;
		public double Vault_password_number_4 = 0;
		public double Vault_password_number5 = 0;
		public double Test = 0;
		public double Dragon_hearted_Variable = 0;
		public double Stop_music = 0;
		public double Fire_Dragon_spawn = 0;
		public double Password_entered = 0;
		public double Set_vault_password = 0;
		public double Vault_password_1_password = 0;
		public double Vault_password_2_password = 0;
		public double Vault_password_3_password = 0;
		public double Vault_password_4_password = 0;
		public double flightx = 0;
		public double flighty = 0;
		public double Flightz = 0;
		public double Projectile_Movement = 0;
		public double Player_Collision_x = 0;
		public double Player_collison_y = 0;
		public double Player_collision_z = 0;

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			Vault_password_5_password = nbt.getDouble("Vault_password_5_password");
			Lightnings = nbt.getDouble("Lightnings");
			Home_x = nbt.getDouble("Home_x");
			Home_y = nbt.getDouble("Home_y");
			Home_z = nbt.getDouble("Home_z");
			Home_item_give = nbt.getDouble("Home_item_give");
			Teleport_timer = nbt.getDouble("Teleport_timer");
			Vault_password_1 = nbt.getDouble("Vault_password_1");
			Vault_password_2 = nbt.getDouble("Vault_password_2");
			Vault_password_3 = nbt.getDouble("Vault_password_3");
			Vault_password_4 = nbt.getDouble("Vault_password_4");
			Vault_password_5 = nbt.getDouble("Vault_password_5");
			Vault_password_number1 = nbt.getDouble("Vault_password_number1");
			Vault_password_number2 = nbt.getDouble("Vault_password_number2");
			Vault_password_number3 = nbt.getDouble("Vault_password_number3");
			Vault_password_number_4 = nbt.getDouble("Vault_password_number_4");
			Vault_password_number5 = nbt.getDouble("Vault_password_number5");
			Test = nbt.getDouble("Test");
			Dragon_hearted_Variable = nbt.getDouble("Dragon_hearted_Variable");
			Stop_music = nbt.getDouble("Stop_music");
			Fire_Dragon_spawn = nbt.getDouble("Fire_Dragon_spawn");
			Password_entered = nbt.getDouble("Password_entered");
			Set_vault_password = nbt.getDouble("Set_vault_password");
			Vault_password_1_password = nbt.getDouble("Vault_password_1_password");
			Vault_password_2_password = nbt.getDouble("Vault_password_2_password");
			Vault_password_3_password = nbt.getDouble("Vault_password_3_password");
			Vault_password_4_password = nbt.getDouble("Vault_password_4_password");
			flightx = nbt.getDouble("flightx");
			flighty = nbt.getDouble("flighty");
			Flightz = nbt.getDouble("Flightz");
			Projectile_Movement = nbt.getDouble("Projectile_Movement");
			Player_Collision_x = nbt.getDouble("Player_Collision_x");
			Player_collison_y = nbt.getDouble("Player_collison_y");
			Player_collision_z = nbt.getDouble("Player_collision_z");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("Vault_password_5_password", Vault_password_5_password);
			nbt.putDouble("Lightnings", Lightnings);
			nbt.putDouble("Home_x", Home_x);
			nbt.putDouble("Home_y", Home_y);
			nbt.putDouble("Home_z", Home_z);
			nbt.putDouble("Home_item_give", Home_item_give);
			nbt.putDouble("Teleport_timer", Teleport_timer);
			nbt.putDouble("Vault_password_1", Vault_password_1);
			nbt.putDouble("Vault_password_2", Vault_password_2);
			nbt.putDouble("Vault_password_3", Vault_password_3);
			nbt.putDouble("Vault_password_4", Vault_password_4);
			nbt.putDouble("Vault_password_5", Vault_password_5);
			nbt.putDouble("Vault_password_number1", Vault_password_number1);
			nbt.putDouble("Vault_password_number2", Vault_password_number2);
			nbt.putDouble("Vault_password_number3", Vault_password_number3);
			nbt.putDouble("Vault_password_number_4", Vault_password_number_4);
			nbt.putDouble("Vault_password_number5", Vault_password_number5);
			nbt.putDouble("Test", Test);
			nbt.putDouble("Dragon_hearted_Variable", Dragon_hearted_Variable);
			nbt.putDouble("Stop_music", Stop_music);
			nbt.putDouble("Fire_Dragon_spawn", Fire_Dragon_spawn);
			nbt.putDouble("Password_entered", Password_entered);
			nbt.putDouble("Set_vault_password", Set_vault_password);
			nbt.putDouble("Vault_password_1_password", Vault_password_1_password);
			nbt.putDouble("Vault_password_2_password", Vault_password_2_password);
			nbt.putDouble("Vault_password_3_password", Vault_password_3_password);
			nbt.putDouble("Vault_password_4_password", Vault_password_4_password);
			nbt.putDouble("flightx", flightx);
			nbt.putDouble("flighty", flighty);
			nbt.putDouble("Flightz", Flightz);
			nbt.putDouble("Projectile_Movement", Projectile_Movement);
			nbt.putDouble("Player_Collision_x", Player_Collision_x);
			nbt.putDouble("Player_collison_y", Player_collison_y);
			nbt.putDouble("Player_collision_z", Player_collision_z);
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				herobrines_fortress.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(0, this));
			} else {
				herobrines_fortress.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
			}
		}
		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(World world) {
			if (world instanceof ServerWorld) {
				return world.getServer().getWorld(DimensionType.OVERWORLD).getSavedData().getOrCreate(MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			if (this.type == 0)
				this.data = new MapVariables();
			else
				this.data = new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (context.getDirection().getReceptionSide().isServer())
					syncData(message, context.getDirection().getReceptionSide(), context.getSender().world);
				else
					syncData(message, context.getDirection().getReceptionSide(), Minecraft.getInstance().player.world);
			});
			context.setPacketHandled(true);
		}

		private static void syncData(WorldSavedDataSyncMessage message, LogicalSide side, World world) {
			if (side.isServer()) {
				message.data.markDirty();
				if (message.type == 0) {
					herobrines_fortress.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), message);
					world.getServer().getWorld(DimensionType.OVERWORLD).getSavedData().set(message.data);
				} else {
					herobrines_fortress.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world.dimension::getType), message);
					((ServerWorld) world).getSavedData().set(message.data);
				}
			} else {
				if (message.type == 0) {
					MapVariables.clientSide = (MapVariables) message.data;
				} else {
					WorldVariables.clientSide = (WorldVariables) message.data;
				}
			}
		}
	}
}
