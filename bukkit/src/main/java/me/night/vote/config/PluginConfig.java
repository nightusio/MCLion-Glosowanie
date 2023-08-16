package me.night.vote.config;

import cc.dreamcode.menu.bukkit.BukkitMenuBuilder;
import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import cc.dreamcode.utilities.builder.MapBuilder;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import com.cryptomorin.xseries.XMaterial;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.Header;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;
import org.bukkit.inventory.ItemStack;

@Configuration(
        child = "config.yml"
)
@Header("## MCLion-Glosowanie (Main-Config) ##")
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class PluginConfig extends OkaeriConfig {
    @Comment("Debug pokazuje dodatkowe informacje do konsoli. Lepiej wylaczyc. :P")
    public boolean debug = true;

    @Comment("Item 1")
    public ItemStack itemOne = ItemBuilder.of(XMaterial.GOLD_BLOCK.parseMaterial())
            .setName("&aPierwszy itemek")
            .setLore("&2Opis przedmiotu")
            .toItemStack();


    @Comment("Item 2")
    public ItemStack itemTwo = ItemBuilder.of(XMaterial.DIAMOND_BLOCK.parseMaterial())
            .setName("&aDrugi itemek")
            .setLore("&2Opis przedmiotu")
            .toItemStack();

    public int itemOneSlot = 13;
    public int itemTwoSlot = 15;

    @Comment("Menu glosowania")
    public BukkitMenuBuilder voteMenu = new BukkitMenuBuilder("&2Glosowanie",
            3,
            new MapBuilder<Integer, ItemStack>()
                    .put(11, new ItemBuilder(XMaterial.APPLE.parseItem())
                            .setName("&c&fajny itemek")
                            .setLore("&exaries wypusc mnie z piwnicy prosze")
                            .toItemStack())
                    .build());
}
