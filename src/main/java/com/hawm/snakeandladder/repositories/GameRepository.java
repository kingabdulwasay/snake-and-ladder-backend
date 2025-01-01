package com.hawm.snakeandladder.repositories;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
@Repository
public class GameRepository {

    public Boolean addHistory(String playername) {

        try {
            String sql = "INSERT INTO matches(name) VALUES (?)";
            PreparedStatement pstmt = DatabaseConnection.connectDB().prepareStatement(sql);
            pstmt.setString(1, playername);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Invalid Entry");
        }
        return false;
    }

    public ArrayList<String> showHistory() {
        ArrayList<String> history = new ArrayList<>();
        try {
            Statement stat = DatabaseConnection.connectDB().createStatement();
            String sql = "select * from matches";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                String match = ("Winner of match " + rs.getInt("id") + " is "+ rs.getString("name"));
                history.add(match);
            }
            return history;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
