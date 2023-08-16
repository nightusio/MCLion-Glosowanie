package me.night.vote.menu;

import cc.dreamcode.menu.bukkit.BukkitMenuBuilder;
import cc.dreamcode.menu.bukkit.base.BukkitMenu;
import cc.dreamcode.menu.bukkit.setup.BukkitMenuPlayerSetup;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import me.night.vote.config.MessageConfig;
import me.night.vote.config.PluginConfig;
import me.night.vote.config.VoteConfig;
import org.bukkit.entity.HumanEntity;

public class VoteMenu implements BukkitMenuPlayerSetup {

    private @Inject
    PluginConfig pluginConfig;

    @Inject
    private MessageConfig messageConfig;

    @Inject
    private VoteConfig voteConfig;

    @Override
    public BukkitMenu build(@NonNull HumanEntity humanEntity) {
        BukkitMenuBuilder bukkitMenuBuilder = this.pluginConfig.voteMenu;
        final BukkitMenu bukkitMenu = bukkitMenuBuilder.buildWithItems();

        bukkitMenu.setItem(this.pluginConfig.itemOneSlot, this.pluginConfig.itemOne, event ->{
            if (this.voteConfig.itemTwoList.contains(humanEntity.getName()) || this.voteConfig.itemOneVotes.contains(humanEntity.getName()) ) {
                this.messageConfig.alreadyVoted.send(humanEntity);
                return;
            }

            this.messageConfig.successfullyVoted.send(humanEntity);
            this.voteConfig.itemOneVotes.add(humanEntity.getName());
            this.voteConfig.save();

            humanEntity.closeInventory();
        });

        bukkitMenu.setItem(this.pluginConfig.itemTwoSlot, this.pluginConfig.itemTwo, event ->{
            if (this.voteConfig.itemTwoList.contains(humanEntity.getName()) || this.voteConfig.itemOneVotes.contains(humanEntity.getName()) ) {
                this.messageConfig.alreadyVoted.send(humanEntity);
                return;
            }

            this.messageConfig.successfullyVoted.send(humanEntity);
            this.voteConfig.itemTwoList.add(humanEntity.getName());
            this.voteConfig.save();

            humanEntity.closeInventory();
        });

        return bukkitMenu;
    }
}