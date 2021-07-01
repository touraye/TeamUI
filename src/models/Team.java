package models;

public class Team {
    private int team_id;
    private String team_name;
    private String found_year;
    private int league_id;

    public Team(int team_id, String team_name, String found_year, int league_id) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.found_year = found_year;
        this.league_id = league_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getFound_year() {
        return found_year;
    }

    public void setFound_year(String found_year) {
        this.found_year = found_year;
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }
}
