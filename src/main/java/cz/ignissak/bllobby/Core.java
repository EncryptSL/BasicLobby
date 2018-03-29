package cz.ignissak.bllobby;

import com.zaxxer.hikari.HikariDataSource;
import cz.ignissak.bllobby.commands.*;
import cz.ignissak.bllobby.gui.Help;
import cz.ignissak.bllobby.listeners.*;
import cz.ignissak.bllobby.utils.TPSChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.UUID;

public final class Core extends JavaPlugin {

    private static Core instance;
    public static HikariDataSource hikari;
    public ArrayList<String> smenarnaCooldown = new ArrayList<>();

    @Override
    public void onEnable() {
        SQLManager sql = new SQLManager();
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "BungeeCord channel registrovan.");
        saveDefaultConfig();
        instance = this;
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new TPSChecker(), 100L, 1L);
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "TPSChecker aktivovan.");

        setupHikari();
        if (sql.getSmenarnaPenize() == 0 && sql.getSmenarnaTransakce() == 0) {
            sql.createTableSmenarna();
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Tabulka v MySQL na smenarnu vytvorena.");
        }
        sql.createTableCooldownyDailyRewards();

        registerCommands();
        registerEvents();
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Listeners a commandy registrovany.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "-----------------------------");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "   ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "BasicLobby zapnuto! v" + getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "-----------------------------");
    }
    public void setupHikari() {
        hikari = new HikariDataSource();
        hikari.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        hikari.addDataSourceProperty("serverName", getConfig().getString("mysql.host"));
        hikari.addDataSourceProperty("port", getConfig().getInt("mysql.port"));
        hikari.addDataSourceProperty("databaseName", getConfig().getString("mysql.database"));
        hikari.addDataSourceProperty("user", getConfig().getString("mysql.user"));
        hikari.addDataSourceProperty("password", getConfig().getString("mysql.password"));
        hikari.setConnectionTimeout(getConfig().getInt("mysql.timeout"));
        hikari.setMaximumPoolSize(getConfig().getInt("mysql.maximumConnections"));

    }
    public static Core getInstance(){
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return hikari.getConnection();
    }

    public HikariDataSource getHikari(){
        return hikari;
    }

    @Override
    public void onDisable() {
        if (hikari != null) {
            hikari.close();
        }
    }

    public void registerCommands() {
        getCommand("profil").setExecutor(new ProfilCmd());
        getCommand("basiclobby").setExecutor(new BasicLobbyCmd());
        getCommand("odmeny").setExecutor(new OdmenyCmd());
        getCommand("help").setExecutor(new HelpCmd());
        getCommand("smenarna").setExecutor(new SmenarnaCmd());
        getCommand("penize").setExecutor(new PenizeCmd());
        getCommand("vip").setExecutor(new VipCmd());
        getCommand("velikonocnihlavy").setExecutor(new VelikonocniHlavyCmd());
        //getCommand("token").setExecutor(new TokenCmd());
    }

    public void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Help(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new WeatherChange(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DoubleJump(), this);
        //Bukkit.getServer().getPluginManager().registerEvents(new PlayerChat(), this);
    }

    public void sendToServer(Player player, String section) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(section);
        } catch (Exception e) {
            e.printStackTrace();
        }
            player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
    }


    /*ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();

        Objective o = b.registerNewObjective("Gold", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName("iGniSsio server");

        Score gold = o.getScore("Test: jup?");
        gold.setScore(1);

        player.setScoreboard(b);*/
}
