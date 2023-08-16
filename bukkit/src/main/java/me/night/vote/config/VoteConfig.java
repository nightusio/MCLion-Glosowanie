package me.night.vote.config;

import cc.dreamcode.notice.minecraft.MinecraftNoticeType;
import cc.dreamcode.notice.minecraft.bukkit.BukkitNotice;
import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Header;
import eu.okaeri.configs.annotation.Headers;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;

import java.util.ArrayList;
import java.util.List;

@Configuration(
        child = "vote.yml"
)
@Headers({
        @Header("## MCLion-Glosowanie (Vote-Config) ##"),
        @Header("Jesli nie wiesz co robisz to nie ruszaj")
})
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class VoteConfig extends OkaeriConfig {

    public List<String> itemOneVotes = new ArrayList<>();
    public List<String> itemTwoList = new ArrayList<>();
}
