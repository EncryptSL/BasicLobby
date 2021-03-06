package cz.ignissak.bllobby.utils;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cz.ignissak.bllobby.Core;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BungeeFactory implements PluginMessageListener {

    public static HashMap<String, Integer> servers = new HashMap<>();
    public static HashMap<String, String> kdeJe = new HashMap<>();

    public static void sendToServer(Player player, String section) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(section);
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(Core.getInstance(), "BungeeCord", b.toByteArray());
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();

        if (subchannel.equals("GetServer")) {
            String server = in.readUTF();

            kdeJe.put(player.getName(), server);
        }

    }


    public static void getServerName(Player player) {

        /*NOTE
                If you want to get the total amount of player's on the entire Bungee Network simply use
        "ALL" as the String server*/

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("GetServer");

        player.sendPluginMessage(Core.getInstance(), "BungeeCord", out.toByteArray());

        return;
    }



}
