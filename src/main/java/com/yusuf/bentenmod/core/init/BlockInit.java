package com.yusuf.bentenmod.core.init;

import com.yusuf.bentenmod.Main;
import com.yusuf.bentenmod.block.OmnitrixOre;
import com.yusuf.bentenmod.block.TableBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Main.MOD_ID);

	//blocks
	public static final RegistryObject<Block> LEGENDARY_BLOCK = BLOCKS
			.register("legendary_block",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));

	public static final RegistryObject<Block> OMNITRIX_BLOCK = BLOCKS
			.register("omnitrix_block",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));

	public static final RegistryObject<Block> BLACK_DIAMOND_BLOCK = BLOCKS
			.register("black_diamond_block",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));

	public static final RegistryObject<Block> INFINITUM_BLOCK = BLOCKS
			.register("infinitum_block",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));

	public static final RegistryObject<Block> FIRE_BLOCK = BLOCKS
			.register("fire_block",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));
	
	public static final RegistryObject<Block> SPEED_BLOCK = BLOCKS
			.register("speed_block",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));

	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS
			.register("ruby_block",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));

	public static final RegistryObject<Block> IMPERIUM_BLOCK = BLOCKS
			.register("imperium_block",
					() -> new Block(RedstoneOreBlock.Properties.copy(Blocks.IRON_BLOCK)));
	/* ores */

	public static final RegistryObject<Block> LEGENDARY_ORE_BLOCK = BLOCKS
			.register("legendary_ore_block",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS
			.register("ruby_ore",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));

	public static final RegistryObject<RotatedPillarBlock> INFINITUM_ORE = BLOCKS
			.register("infinitum_ore",
					() -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));

	public static final RegistryObject<Block> IMPERIUM_ORE = BLOCKS
			.register("imperium_ore",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE)));


	public static final RegistryObject<Block> BLACK_DIAMOND_ORE = BLOCKS
			.register("black_diamond_ore",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));
	
	public static final RegistryObject<Block> FIRE_ORE = BLOCKS
			.register("fire_ore",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));
	
	public static final RegistryObject<Block> SPEED_ORE = BLOCKS
			.register("speed_ore",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));




	/* deepslate ores */

	public static final RegistryObject<Block> DEEPSLATE_LEGENDARY_ORE_BLOCK = BLOCKS
			.register("deepslate_legendary_ore_block",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK)));
	public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = BLOCKS
			.register("deepslate_ruby_ore",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));


	public static final RegistryObject<Block> DEEPSLATE_BLACK_DIAMOND_ORE = BLOCKS
			.register("deepslate_black_diamond_ore",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));

	public static final RegistryObject<Block> DEEPSLATE_IMPERIUM_ORE = BLOCKS
			.register("deepslate_imperium_ore",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE)));


	public static final RegistryObject<Block> DEEPSLATE_SPEED_ORE = BLOCKS
			.register("deepslate_speed_ore",
					() -> new Block(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));

		public static final RegistryObject<Block> DEEPSLATE_OMNITRIX_ORE = BLOCKS
				.register("deepslate_omnitrix_ore",
						() -> new Block(AbstractBlock.Properties.copy(Blocks.ANCIENT_DEBRIS)));
	/* other blocks */
	




	public static final RegistryObject<Block> OMNITRIX_ORE = BLOCKS
			.register("omnitrix_ore",
					() -> new Block(OmnitrixOre.Properties.copy(Blocks.ANCIENT_DEBRIS)));




	public static final RegistryObject<TableBlock> TABLE_BLOCK;


	static {
		TABLE_BLOCK = registerSpecial("table_block", TableBlock::new);
	}


	private static <T extends Block> RegistryObject<T> registerSpecial(String name, Supplier<T> blockSupplier) {
		RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(16).setNoRepair()));
		return block;
	}

}
