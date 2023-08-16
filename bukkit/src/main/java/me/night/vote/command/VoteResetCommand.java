package me.night.vote.command;

import cc.dreamcode.command.annotations.RequiredPermission;
import cc.dreamcode.command.bukkit.BukkitCommand;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import me.night.vote.config.MessageConfig;
import me.night.vote.config.VoteConfig;
import org.bukkit.command.CommandSender;

import java.util.List;

@RequiredPermission(permission = "vote.reset")
public class VoteResetCommand extends BukkitCommand {

    @Inject
    private VoteConfig voteConfig;

    @Inject
    private MessageConfig messageConfig;

    public VoteResetCommand() {
        super("votereset");
    }

    @Override
    public void content(@NonNull CommandSender sender, @NonNull String[] args) {
        this.voteConfig.itemOneVotes.clear();
        this.voteConfig.itemTwoList.clear();
        this.messageConfig.successfullyRemovedVotes.send(sender);
    }

    @Override
    public List<String> tab(@NonNull CommandSender sender, @NonNull String[] args) {
        return null;
    }
}
