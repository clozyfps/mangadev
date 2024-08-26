package net.mcreator.mangadev.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.mangadev.MangadevMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MangadevModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MangadevMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Chapters = original.Chapters;
			clone.CharacterAmount = original.CharacterAmount;
			clone.Characters = original.Characters;
			clone.DeadCharacters = original.DeadCharacters;
			clone.DiscoveryRate = original.DiscoveryRate;
			clone.Fans = original.Fans;
			clone.FifthLetterRandomizer = original.FifthLetterRandomizer;
			clone.FocusedCharacter = original.FocusedCharacter;
			clone.FourthLetterRandomizer = original.FourthLetterRandomizer;
			clone.HeroCharacters = original.HeroCharacters;
			clone.MainEvent = original.MainEvent;
			clone.MangaGenre = original.MangaGenre;
			clone.MangaName = original.MangaName;
			clone.ThirdLetterRandomizer = original.ThirdLetterRandomizer;
			clone.NeutralCharacters = original.NeutralCharacters;
			clone.PopularityAuto = original.PopularityAuto;
			clone.PopularityGeneration = original.PopularityGeneration;
			clone.RandomUser = original.RandomUser;
			clone.RecentChapter = original.RecentChapter;
			clone.RecentChapterFans = original.RecentChapterFans;
			clone.RecentChapterViews = original.RecentChapterViews;
			clone.RecentRating = original.RecentRating;
			clone.RecentTweet = original.RecentTweet;
			clone.ShortMangaName = original.ShortMangaName;
			clone.SideCharacter = original.SideCharacter;
			clone.SixthLetterRandomizer = original.SixthLetterRandomizer;
			clone.StarterLetterRandomizer = original.StarterLetterRandomizer;
			clone.VillainCharacters = original.VillainCharacters;
			clone.Yen = original.Yen;
			clone.SecondLetterRandomizer = original.SecondLetterRandomizer;
			if (!event.isWasDeath()) {
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("mangadev", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Chapters = 0;
		public double CharacterAmount = 0;
		public String Characters = "";
		public String DeadCharacters = "";
		public double DiscoveryRate = 0;
		public double Fans = 0;
		public String FifthLetterRandomizer = "";
		public String FocusedCharacter = "";
		public String FourthLetterRandomizer = "";
		public String HeroCharacters = "";
		public String MainEvent = "";
		public String MangaGenre = "";
		public String MangaName = "";
		public String ThirdLetterRandomizer = "";
		public String NeutralCharacters = "";
		public double PopularityAuto = 0;
		public double PopularityGeneration = 0;
		public String RandomUser = "";
		public String RecentChapter = "";
		public double RecentChapterFans = 0;
		public double RecentChapterViews = 0;
		public double RecentRating = 0;
		public String RecentTweet = "";
		public String ShortMangaName = "";
		public String SideCharacter = "0";
		public String SixthLetterRandomizer = "0";
		public String StarterLetterRandomizer = "";
		public String VillainCharacters = "";
		public double Yen = 0;
		public String SecondLetterRandomizer = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				MangadevMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Chapters", Chapters);
			nbt.putDouble("CharacterAmount", CharacterAmount);
			nbt.putString("Characters", Characters);
			nbt.putString("DeadCharacters", DeadCharacters);
			nbt.putDouble("DiscoveryRate", DiscoveryRate);
			nbt.putDouble("Fans", Fans);
			nbt.putString("FifthLetterRandomizer", FifthLetterRandomizer);
			nbt.putString("FocusedCharacter", FocusedCharacter);
			nbt.putString("FourthLetterRandomizer", FourthLetterRandomizer);
			nbt.putString("HeroCharacters", HeroCharacters);
			nbt.putString("MainEvent", MainEvent);
			nbt.putString("MangaGenre", MangaGenre);
			nbt.putString("MangaName", MangaName);
			nbt.putString("ThirdLetterRandomizer", ThirdLetterRandomizer);
			nbt.putString("NeutralCharacters", NeutralCharacters);
			nbt.putDouble("PopularityAuto", PopularityAuto);
			nbt.putDouble("PopularityGeneration", PopularityGeneration);
			nbt.putString("RandomUser", RandomUser);
			nbt.putString("RecentChapter", RecentChapter);
			nbt.putDouble("RecentChapterFans", RecentChapterFans);
			nbt.putDouble("RecentChapterViews", RecentChapterViews);
			nbt.putDouble("RecentRating", RecentRating);
			nbt.putString("RecentTweet", RecentTweet);
			nbt.putString("ShortMangaName", ShortMangaName);
			nbt.putString("SideCharacter", SideCharacter);
			nbt.putString("SixthLetterRandomizer", SixthLetterRandomizer);
			nbt.putString("StarterLetterRandomizer", StarterLetterRandomizer);
			nbt.putString("VillainCharacters", VillainCharacters);
			nbt.putDouble("Yen", Yen);
			nbt.putString("SecondLetterRandomizer", SecondLetterRandomizer);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Chapters = nbt.getDouble("Chapters");
			CharacterAmount = nbt.getDouble("CharacterAmount");
			Characters = nbt.getString("Characters");
			DeadCharacters = nbt.getString("DeadCharacters");
			DiscoveryRate = nbt.getDouble("DiscoveryRate");
			Fans = nbt.getDouble("Fans");
			FifthLetterRandomizer = nbt.getString("FifthLetterRandomizer");
			FocusedCharacter = nbt.getString("FocusedCharacter");
			FourthLetterRandomizer = nbt.getString("FourthLetterRandomizer");
			HeroCharacters = nbt.getString("HeroCharacters");
			MainEvent = nbt.getString("MainEvent");
			MangaGenre = nbt.getString("MangaGenre");
			MangaName = nbt.getString("MangaName");
			ThirdLetterRandomizer = nbt.getString("ThirdLetterRandomizer");
			NeutralCharacters = nbt.getString("NeutralCharacters");
			PopularityAuto = nbt.getDouble("PopularityAuto");
			PopularityGeneration = nbt.getDouble("PopularityGeneration");
			RandomUser = nbt.getString("RandomUser");
			RecentChapter = nbt.getString("RecentChapter");
			RecentChapterFans = nbt.getDouble("RecentChapterFans");
			RecentChapterViews = nbt.getDouble("RecentChapterViews");
			RecentRating = nbt.getDouble("RecentRating");
			RecentTweet = nbt.getString("RecentTweet");
			ShortMangaName = nbt.getString("ShortMangaName");
			SideCharacter = nbt.getString("SideCharacter");
			SixthLetterRandomizer = nbt.getString("SixthLetterRandomizer");
			StarterLetterRandomizer = nbt.getString("StarterLetterRandomizer");
			VillainCharacters = nbt.getString("VillainCharacters");
			Yen = nbt.getDouble("Yen");
			SecondLetterRandomizer = nbt.getString("SecondLetterRandomizer");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MangadevMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Chapters = message.data.Chapters;
					variables.CharacterAmount = message.data.CharacterAmount;
					variables.Characters = message.data.Characters;
					variables.DeadCharacters = message.data.DeadCharacters;
					variables.DiscoveryRate = message.data.DiscoveryRate;
					variables.Fans = message.data.Fans;
					variables.FifthLetterRandomizer = message.data.FifthLetterRandomizer;
					variables.FocusedCharacter = message.data.FocusedCharacter;
					variables.FourthLetterRandomizer = message.data.FourthLetterRandomizer;
					variables.HeroCharacters = message.data.HeroCharacters;
					variables.MainEvent = message.data.MainEvent;
					variables.MangaGenre = message.data.MangaGenre;
					variables.MangaName = message.data.MangaName;
					variables.ThirdLetterRandomizer = message.data.ThirdLetterRandomizer;
					variables.NeutralCharacters = message.data.NeutralCharacters;
					variables.PopularityAuto = message.data.PopularityAuto;
					variables.PopularityGeneration = message.data.PopularityGeneration;
					variables.RandomUser = message.data.RandomUser;
					variables.RecentChapter = message.data.RecentChapter;
					variables.RecentChapterFans = message.data.RecentChapterFans;
					variables.RecentChapterViews = message.data.RecentChapterViews;
					variables.RecentRating = message.data.RecentRating;
					variables.RecentTweet = message.data.RecentTweet;
					variables.ShortMangaName = message.data.ShortMangaName;
					variables.SideCharacter = message.data.SideCharacter;
					variables.SixthLetterRandomizer = message.data.SixthLetterRandomizer;
					variables.StarterLetterRandomizer = message.data.StarterLetterRandomizer;
					variables.VillainCharacters = message.data.VillainCharacters;
					variables.Yen = message.data.Yen;
					variables.SecondLetterRandomizer = message.data.SecondLetterRandomizer;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
