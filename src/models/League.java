package models;

public class League {
    private int league_id;
    private String name;
    private String category;
    private String league_start_date;
    private String league_end_date;

    public League(int league_id, String name, String category, String league_start_date, String league_end_date) {
        this.league_id = league_id;
        this.name = name;
        this.category = category;
        this.league_start_date = league_start_date;
        this.league_end_date = league_end_date;
    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLeague_start_date() {
        return league_start_date;
    }

    public void setLeague_start_date(String league_start_date) {
        this.league_start_date = league_start_date;
    }

    public String getLeague_end_date() {
        return league_end_date;
    }

    public void setLeague_end_date(String league_end_date) {
        this.league_end_date = league_end_date;
    }
}
