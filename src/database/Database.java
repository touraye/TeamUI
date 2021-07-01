package database;

import java.sql.*;

public class Database {
    private Statement statement;
    private Connection connect;
    public Database(){
        try{
            connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/league","root","touraye7");
            this.statement = connect.createStatement();
            System.out.println("DB connected");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            //Terminate connection on failure
            System.exit(0);
        }
    }

    //Create League
    public void createLeague(String name, String category, String start_date, String end_date){
        try{
            String insertQuery = "INSERT INTO league(name, category, league_start_date, league_end_date) values('"+name+"', '"+category+"', '"+start_date+"', '"+end_date+"')";
            this.statement.execute(insertQuery);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    //Create Team
    public void createTeam(String name, String team_create_date, int trophy, String win_year){
        try{
        //TODO insert into team(team_area, team_found_year, team_trophy, trophy_year) values('Adokou F.C','2018-07-22', 1, '2020-02-29');
            String executeQuery = "INSERT INTO team(team_area, team_found_year, team_trophy, trophy_year) values('"+name+"','"+team_create_date+"','"+trophy+"','"+win_year+"'";
            this.statement.execute(executeQuery);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    //select all teams
    public void listTeam(){
        try{
            String queryTeam = "SELECT * FROM team";
            ResultSet result = this.statement.executeQuery(queryTeam);
            while(result.next()){
                int id = result.getInt("team_id");
                String name = result.getString("team_area");
                String date = result.getString("team_found_year");
                int trophy = result.getInt("team_trophy");
                String win_year = result.getString("trophy_year");
                System.out.println("id |" +id+ "| name | " +name+ " | date | " +date+ " | trophy | " +trophy+ " | year | " +win_year);
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    //Modify Team
//    public void modifyTeam(int id){
//    //TODO update team set team_area = 'Adokuo United', team_found_year = '2016-09-12',
//        //Todo team_trophy = 3, trophy_year = '2121-03-15'  where team_id = 8;
//        // in an update method the id should be a combo box
//        try{
//            String updateStatement = "UPDATE team SET "
//        } catch (SQLException ex){
//            System.out.println(ex.getMessage());
//        }
//
//    }

    public static void main(String args[]){
        Database con = new Database();

//        con.listTeam();
    }

}
