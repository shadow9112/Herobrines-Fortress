package net.mcreator.herobrines_fortress;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.ByteBufUtils;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.client.Minecraft;

public class herobrines_fortressVariables {
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

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void readFromNBT(NBTTagCompound nbt) {
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
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
			nbt.setDouble("Vault_password_5_password", Vault_password_5_password);
			nbt.setDouble("Lightnings", Lightnings);
			nbt.setDouble("Home_x", Home_x);
			nbt.setDouble("Home_y", Home_y);
			nbt.setDouble("Home_z", Home_z);
			nbt.setDouble("Home_item_give", Home_item_give);
			nbt.setDouble("Teleport_timer", Teleport_timer);
			nbt.setDouble("Vault_password_1", Vault_password_1);
			nbt.setDouble("Vault_password_2", Vault_password_2);
			nbt.setDouble("Vault_password_3", Vault_password_3);
			nbt.setDouble("Vault_password_4", Vault_password_4);
			nbt.setDouble("Vault_password_5", Vault_password_5);
			nbt.setDouble("Vault_password_number1", Vault_password_number1);
			nbt.setDouble("Vault_password_number2", Vault_password_number2);
			nbt.setDouble("Vault_password_number3", Vault_password_number3);
			nbt.setDouble("Vault_password_number_4", Vault_password_number_4);
			nbt.setDouble("Vault_password_number5", Vault_password_number5);
			nbt.setDouble("Test", Test);
			nbt.setDouble("Dragon_hearted_Variable", Dragon_hearted_Variable);
			nbt.setDouble("Stop_music", Stop_music);
			nbt.setDouble("Fire_Dragon_spawn", Fire_Dragon_spawn);
			nbt.setDouble("Password_entered", Password_entered);
			nbt.setDouble("Set_vault_password", Set_vault_password);
			nbt.setDouble("Vault_password_1_password", Vault_password_1_password);
			nbt.setDouble("Vault_password_2_password", Vault_password_2_password);
			nbt.setDouble("Vault_password_3_password", Vault_password_3_password);
			nbt.setDouble("Vault_password_4_password", Vault_password_4_password);
			nbt.setDouble("flightx", flightx);
			nbt.setDouble("flighty", flighty);
			nbt.setDouble("Flightz", Flightz);
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				herobrines_fortress.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(0, this));
			} else {
				herobrines_fortress.PACKET_HANDLER.sendToAll(new WorldSavedDataSyncMessage(0, this));
			}
		}

		public static MapVariables get(World world) {
			MapVariables instance = (MapVariables) world.getMapStorage().getOrLoadData(MapVariables.class, DATA_NAME);
			if (instance == null) {
				instance = new MapVariables();
				world.getMapStorage().setData(DATA_NAME, instance);
			}
			return instance;
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "herobrines_fortress_worldvars";

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void readFromNBT(NBTTagCompound nbt) {
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				herobrines_fortress.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(1, this));
			} else {
				herobrines_fortress.PACKET_HANDLER.sendToDimension(new WorldSavedDataSyncMessage(1, this), world.provider.getDimension());
			}
		}

		public static WorldVariables get(World world) {
			WorldVariables instance = (WorldVariables) world.getPerWorldStorage().getOrLoadData(WorldVariables.class, DATA_NAME);
			if (instance == null) {
				instance = new WorldVariables();
				world.getPerWorldStorage().setData(DATA_NAME, instance);
			}
			return instance;
		}
	}

	public static class WorldSavedDataSyncMessageHandler implements IMessageHandler<WorldSavedDataSyncMessage, IMessage> {
		@Override
		public IMessage onMessage(WorldSavedDataSyncMessage message, MessageContext context) {
			if (context.side == Side.SERVER)
				context.getServerHandler().player.getServerWorld().addScheduledTask(
						() -> syncData(message, context, context.getServerHandler().player.world));
			else
				Minecraft.getMinecraft().addScheduledTask(() -> syncData(message, context, Minecraft.getMinecraft().player.world));
			return null;
		}

		private void syncData(WorldSavedDataSyncMessage message, MessageContext context, World world) {
			if (context.side == Side.SERVER) {
				if (message.type == 0)
					herobrines_fortress.PACKET_HANDLER.sendToAll(message);
				else
					herobrines_fortress.PACKET_HANDLER.sendToDimension(message, world.provider.getDimension());
			}
			if (message.type == 0) {
				world.getMapStorage().setData(MapVariables.DATA_NAME, message.data);
			} else {
				world.getPerWorldStorage().setData(WorldVariables.DATA_NAME, message.data);
			}
		}
	}

	public static class WorldSavedDataSyncMessage implements IMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage() {
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(this.type);
			ByteBufUtils.writeTag(buf, this.data.writeToNBT(new NBTTagCompound()));
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			this.type = buf.readInt();
			if (this.type == 0)
				this.data = new MapVariables();
			else
				this.data = new WorldVariables();
			this.data.readFromNBT(ByteBufUtils.readTag(buf));
		}
	}
}
