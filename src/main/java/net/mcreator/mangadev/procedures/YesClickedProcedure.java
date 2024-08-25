package net.mcreator.mangadev.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.mangadev.world.inventory.MangaGUIMenu;
import net.mcreator.mangadev.network.MangadevModVariables;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class YesClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "").isEmpty()) {
			if (guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected()
					&& !(guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
							|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected())) {
				{
					String _setval = "Action";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaGenre = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaName = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("MangaGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected()
					&& (guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
							|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected())) {
				{
					String _setval = "Horror";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaGenre = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaName = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("MangaGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
					&& !(guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected()
							|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected())) {
				{
					String _setval = "Slice Of Life";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaGenre = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaName = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("MangaGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected()
					&& !(guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
							|| guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected() || guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected())) {
				{
					String _setval = "Romance";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaGenre = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaName = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("MangaGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected()
					&& !(guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
							|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected())) {
				{
					String _setval = "Comedy";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaGenre = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangaName = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("MangaGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected()
					&& (guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
							|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected())) {
				entity.getPersistentData().putDouble("genretimer", 20);
			} else {
				entity.getPersistentData().putDouble("genretimer", 20);
			}
		} else {
			entity.getPersistentData().putDouble("manganametimer", 20);
		}
	}
}
