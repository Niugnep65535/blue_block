// 試圖舉一反三
package homo.niugnep.blueblock;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.food.FoodProperties;

public final class ExampleMod {
    public static final String MOD_ID = "blue_block";

    // 方塊註冊
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(MOD_ID, Registries.BLOCK);

    // 物品註冊
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(MOD_ID, Registries.ITEM);

    // 自訂創造模式分頁註冊
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);

    // 測試方塊
    public static final RegistrySupplier<Block> BLUE_BLOCK =
            BLOCKS.register("blue_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.STONE)
                                    .strength(1.5F, 6.0F)
                    )
            );

    // Blue Block 創造模式分頁
    public static final RegistrySupplier<CreativeModeTab> BLUE_BLOCK_TAB =
            TABS.register("blue_block_tab", () ->
                    CreativeTabRegistry.create(
                            Component.translatable("itemGroup.blue_block.main"),
                            () -> new ItemStack(BLUE_BLOCK.get())
                    )
            );

    // 測試方塊物品
    public static final RegistrySupplier<Item> BLUE_BLOCK_ITEM =
            ITEMS.register("blue_block", () ->
                    new BlockItem(
                            BLUE_BLOCK.get(),
                            new Item.Properties().arch$tab(BLUE_BLOCK_TAB)
                    )
            );

    public static final RegistrySupplier<Block> GREEN_BLOCK =
            BLOCKS.register("green_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.STONE)
                                    .strength(1.5F, 6.0F)
                    )
            );

    // 測試方塊物品
    public static final RegistrySupplier<Item> GREEN_BLOCK_ITEM =
            ITEMS.register("green_block", () ->
                    new BlockItem(
                            GREEN_BLOCK.get(),
                            new Item.Properties().arch$tab(BLUE_BLOCK_TAB)
                    )
            );

    // Blue Apple 食物
    public static final RegistrySupplier<Item> SENPAI_APPLE =
            ITEMS.register("senpai_apple", () ->
                    new Item(
                            new Item.Properties()
                                    .food(
                                            new FoodProperties.Builder()
                                                    .nutrition(20)
                                                    .saturationModifier(1F)
                                                    .build()
                                    )
                                    .arch$tab(BLUE_BLOCK_TAB)
                    )
            );


    public static void init() {
        BLOCKS.register();
        ITEMS.register();
        TABS.register();
    }
}
