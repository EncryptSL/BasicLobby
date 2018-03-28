package cz.ignissak.bllobby;

import org.bukkit.entity.Player;

import java.sql.*;
import java.util.UUID;

public class SQLManager {

    public void close(Connection conn, PreparedStatement ps, ResultSet res) {
        if (conn != null) try {
            conn.close();
        } catch (SQLException ignored) {
        }
        if (ps != null) try {
            ps.close();
        } catch (SQLException ignored) {
        }
        if (res != null) try {
            res.close();
        } catch (SQLException ignored) {
        }
    }

    public void createTableSmenarna() {
        try (Connection connection = Core.getInstance().getConnection();
             Statement statement = connection.createStatement();){
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Smenarna(TRANSAKCE int, MINUTE_PENIZE int)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableCooldownyDailyRewards() {
        try (Connection connection = Core.getInstance().getConnection();
             Statement statement = connection.createStatement();){
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS BL_dailyRewards(Nick VARCHAR(32), prvaVyhra BIGINT(100), druhaVyhra BIGINT(100), tretiaVyhra BIGINT(100))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DailyRewards
    public boolean hasDWdata(Player player) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT * FROM BL_dailyRewards WHERE Nick = ?;");
            ps.setString(1, player.getName().toString());
            ps.executeQuery();
            return ps.getResultSet().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            close(conn, ps, null);
        }
    }
    public void instertDWdata(Player player) {
        Connection conn = null;
        PreparedStatement ps = null;
        try (Connection connection = Core.hikari.getConnection();
             Statement statement = connection.createStatement();){
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("INSERT INTO BL_dailyRewards (Nick, prvaVyhra, druhaVyhra, tretiaVyhra) VALUES (?, 0, 0, 0);");
            ps.setString(1, player.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
    }
    public void setDWPrvaCooldown(Player player) {
        Connection conn = null;
        PreparedStatement ps = null;
        try (Connection connection = Core.hikari.getConnection();
            Statement statement = connection.createStatement();){
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("UPDATE `BL_dailyRewards` SET `prvaVyhra` = ? WHERE Nick = ?;");
            ps.setLong(1, System.currentTimeMillis() + 86400000);
            ps.setString(2, player.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
    }
    public long getDWPrvaCooldown(Player player) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT prvaVyhra FROM BL_dailyRewards WHERE Nick = ?;");
            ps.setString(1, player.getName());
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getLong("prvaVyhra");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public void setDWDruhaCooldown(Player player) {
        Connection conn = null;
        PreparedStatement ps = null;
        try (Connection connection = Core.hikari.getConnection();
             Statement statement = connection.createStatement();){
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("UPDATE `BL_dailyRewards` SET `druhaVyhra` = ? WHERE Nick = ?;");
            ps.setLong(1, System.currentTimeMillis() + 86400000);
            ps.setString(2, player.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
    }
    public long getDWDruhaCooldown(Player player) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT druhaVyhra FROM BL_dailyRewards WHERE Nick = ?;");
            ps.setString(1, player.getName());
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getLong("druhaVyhra");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }

    //Misc
    public int getAuthId(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT id FROM authme WHERE username ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    //Smenarna
    public int getSmenarnaPenize() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT MINUTE_PENIZE FROM Smenarna");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("MINUTE_PENIZE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getSmenarnaTransakce() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT TRANSAKCE FROM Smenarna");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("TRANSAKCE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public void addSmenarnaTransakce(int amount) {
        Connection conn = null;
        PreparedStatement ps = null;
        try (Connection connection = Core.hikari.getConnection();
             Statement statement = connection.createStatement();){
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("UPDATE `Smenarna` SET `TRANSAKCE` = `TRANSAKCE` + " + amount);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
    }
    public void addSmenarnaPenize(int amount) {
        Connection conn = null;
        PreparedStatement ps = null;
        try (Connection connection = Core.hikari.getConnection();
             Statement statement = connection.createStatement();){
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("UPDATE `Smenarna` SET `MINUTE_PENIZE` = `MINUTE_PENIZE` + " + amount);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
    }

    //Coins
    public int getCoins(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT balance FROM Coins_Data WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getCoins(final Player player) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT balance FROM Coins_Data WHERE nick ='" + player.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }


    //Votes
    public int getTotalVotes(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT AllTimeTotal FROM VotingPlugin_Users WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("AllTimeTotal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getWeeklyVotes(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT WeeklyTotal FROM VotingPlugin_Users WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("WeeklyTotal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getMonthlyVotes(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT MonthTotal FROM VotingPlugin_Users WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("MonthTotal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }

    // Murder
    public int getMurderScore(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT score FROM MurderData WHERE playername ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("score");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getMurderWins(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT wins FROM MurderData WHERE playername ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("wins");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getMurderLoses(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT loses FROM MurderData WHERE playername ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("loses");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getMurderDeaths(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT deaths FROM MurderData WHERE playername ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("deaths");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getMurderKills(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT `kills` FROM `MurderData` WHERE `playername` ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("kills");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    //
    //GetDown
    public int getGTDeaths(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT deaths FROM GetDownPlus WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("deaths");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getGTKills(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT kills FROM GetDownPlus WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("kills");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getGTWins(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT wins FROM GetDownPlus WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("wins");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getGTPvpkills(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT pvpkills FROM GetDownPlus WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("pvpkills");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getGTPvpdeaths(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT pvpdeaths FROM GetDownPlus WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("pvpdeaths");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getGTPvpwins(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT pvpwins FROM GetDownPlus WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("pvpwins");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getGTPlayed(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT played FROM GetDownPlus WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("played");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getGTMostcoins(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT mostcoins FROM GetDownPlus WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("mostcoins");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    //
    //KitPvP
    public int getKBCoins(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT Coins FROM kitbattle_ WHERE player_name ='" + p.getName()+ "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("Coins");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getKBKills(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT Kills FROM kitbattle_ WHERE player_name ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("Kills");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getKBDeaths(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT Deaths FROM kitbattle_ WHERE player_name ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("Deaths");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getKBExp(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT Exp FROM kitbattle_ WHERE player_name ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("Exp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getKBKitunlockers(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT Kitunlockers FROM kitbattle_ WHERE player_name ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("Kitunlockers");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    //
    //Speedbuilders
    public int getSBWins(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT wins FROM speedbuilders WHERE username ='" + p.getName()+ "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("wins");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getSBPbuilds(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT pbuilds FROM speedbuilders WHERE username ='" + p.getName()+ "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("pbuilds");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getSBLosses(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT losses FROM speedbuilders WHERE username ='" + p.getName()+ "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("losses");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    //
    //UHC
    public int getUHCDeaths(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT death FROM UHC WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("death");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getUHCKills(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT kills FROM UHC WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("kills");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getUHCWins(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT win FROM UHC WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("win");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getUHCLosses(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT lose FROM UHC WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("lose");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    public int getUHCGameplayed(final UUID uuid) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT gameplayed FROM UHC WHERE uuid ='" + uuid.toString() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getInt("gameplayed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return 0;
    }
    //
    //SKYWARS
    public String getSWStats(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT stats FROM Skywars WHERE player_name ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString("stats");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return "0";
    }
    public String getSWKits(final Player p) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Core.getInstance().getConnection();
            ps = conn.prepareStatement("SELECT inventory FROM Skywars WHERE player_name ='" + p.getName() + "';");
            ps.executeQuery();
            if (ps.getResultSet().next()) {
                return ps.getResultSet().getString("inventory");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return "0";
    }
}
