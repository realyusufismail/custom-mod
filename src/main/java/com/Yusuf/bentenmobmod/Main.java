package com.Yusuf.bentenmobmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Yusuf.bentenmobmod.core.init.BlockInit;
import com.Yusuf.bentenmobmod.core.init.EntityTypesInit;
import com.Yusuf.bentenmobmod.core.init.FeatureInit;
import com.Yusuf.bentenmobmod.core.init.ItemInit;
import com.Yusuf.bentenmobmod.core.itemgroup.MainItemGroup;
import com.Yusuf.bentenmobmod.entity.VilgaxEntity;
import com.Yusuf.bentenmobmod.item.ModSpawnEggItem;

import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

@Mod("bentenmobmod")
@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD)
public class Main {
	// Directly reference a log4j logger.
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "bentenmobmod";

	public Main() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		EntityTypesInit.ENTITY_TYPES.register(bus);
		GeckoLibMod.DISABLE_IN_DEV = false;
		GeckoLib.initialize();
		

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::addOres);
		MinecraftForge.EVENT_BUS.register(this);


	};


	@EventBusSubscriber(modid= Main.MOD_ID, bus=Bus.MOD)
	public class CommonModEvents
	{
	  // SubscribeEvent tells forge to subscribe this method as an event listener
	  @SubscribeEvent
	  // method must be public and static for EBS/SubscribeEvent to work
	  public void onRegisterEntityAttributes(EntityAttributeCreationEvent event)
	  {
	    // use event.put to register attributes
		  
		  event.put(EntityTypesInit.VILGAX_ENTITY.get(), VilgaxEntity.registerAttributes().build());
	  }
	}
	
	

	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.initSpawnEggs();
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(MainItemGroup.MAIN))
					.setRegistryName(block.getRegistryName()));

		});

	}

}
