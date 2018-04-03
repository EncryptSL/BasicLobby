package cz.ignissak.bllobby.utils;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import cz.ignissak.bllobby.Core;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

public class BungeeFactory {
    public static HashMap<String, Integer> servers = new HashMap<>();

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

    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();

        if (subchannel.equals("PlayerCount")) {
            String server = in.readUTF();
            int playerCount = in.readInt();
            servers.put(server, playerCount);

        }

    }

    public static int getCount(Player player, String server) {

        /*NOTE
                If you want to get the total amount of player's on the entire Bungee Network simply use
        "ALL" as the String server*/

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server.toLowerCase());

        player.sendPluginMessage(Core.getInstance(), "BungeeCord", out.toByteArray());

        if (servers.containsKey(server.toLowerCase())) {
            return servers.get(server.toLowerCase());
        }
        return -1;
    }

}
