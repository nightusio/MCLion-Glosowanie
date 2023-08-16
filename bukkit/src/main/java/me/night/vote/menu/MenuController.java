package me.night.vote.menu;

import cc.dreamcode.menu.bukkit.base.BukkitMenu;
import eu.okaeri.injector.annotation.Inject;
import me.night.vote.VotePlugin;
import org.bukkit.entity.HumanEntity;

public class MenuController {

    @Inject
    private VotePlugin votePlugin;
    private BukkitMenu bukkitMenu;

    public void updateMenu(HumanEntity entity) {
        VoteMenu userTopMenu = this.votePlugin.createInstance(VoteMenu.class);
        this.bukkitMenu = userTopMenu.build(entity);
    }

    public void openMenu(HumanEntity entity) {
        if (this.bukkitMenu == null) {
            this.updateMenu(entity);
        }

        this.bukkitMenu.open(entity);
    }

}