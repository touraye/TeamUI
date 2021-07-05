package team;

//models
import models.*;

import com.sun.javafx.css.Size;
import database.Database;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.LocalDate;

public class Dashboard {
    public Scene dashboard(){
        BorderPane dashboardLayout = new BorderPane();

        //menu layout
        SplitMenuButton teamMenu = new SplitMenuButton();
        teamMenu.setText("Team Menu");
        //create, edit, remove, view - Team properties
        MenuItem addTeam = new MenuItem("Add Team");
        addTeam.setOnAction(e->{
            dashboardLayout.setCenter(createTeam());
        });
        MenuItem viewTeam = new MenuItem("View Team");
        //Todo implement table view

        MenuItem editTeam = new MenuItem("Edit Team");
        MenuItem  delTeam = new MenuItem("Delete Team");
        MenuItem rankTeam = new MenuItem("Rank Team");

        teamMenu.getItems().addAll(addTeam, viewTeam, editTeam, delTeam, rankTeam);


        //create, edit, remove, view - Player properties
        SplitMenuButton playerMenu = new SplitMenuButton();
        playerMenu.setText("Player Menu");
        MenuItem addPlayer = new MenuItem("Add Player");
        MenuItem viewPlayer = new MenuItem("View Player");
        MenuItem editPlayer = new MenuItem("edit Player");
        MenuItem delPlayer = new MenuItem("Delete Player");
        MenuItem rankPlayer = new MenuItem("Rank Player");

        playerMenu.getItems().addAll(addPlayer, viewPlayer, editPlayer, delPlayer, rankPlayer);

        //create, edit, remove, view - Official properties
        SplitMenuButton officialMenu = new SplitMenuButton();
        officialMenu.setText("Official Menu");
        MenuItem addOfficial = new MenuItem("Add Official");
        MenuItem viewOfficial = new MenuItem("View Official");
        MenuItem editOfficial = new MenuItem("Edit Official");
        MenuItem delOfficial = new MenuItem("Delete Official");
        MenuItem rankOfficial = new MenuItem("Rank Official");

        officialMenu.getItems().addAll(addOfficial, viewOfficial, editOfficial, delOfficial, rankOfficial);


        //create, edit, remove, view - Match properties
        SplitMenuButton matchMenu = new SplitMenuButton();
        matchMenu.setText("Match Menu");
        MenuItem addMatch = new MenuItem("Create Match");
        MenuItem viewMatch = new MenuItem("View Match");
        MenuItem editMatch = new MenuItem("Edit Match");
        MenuItem delMatch = new MenuItem("Delete Match");

        matchMenu.getItems().addAll(addMatch, viewMatch, editMatch, delMatch);


        //create, edit, remove, view - Goal properties
        SplitMenuButton goalMenu = new SplitMenuButton();
        goalMenu.setText("Goal Menu");
        MenuItem addGoal = new MenuItem("Add Goal");
        MenuItem viewGoal = new MenuItem("View Goal");
        MenuItem editGoal = new MenuItem("Edit Goal");
        MenuItem delGoal = new MenuItem("Delete Goal");

        goalMenu.getItems().addAll(addGoal, viewGoal, editGoal, delGoal);

        //create, edit, remove, view - League properties
        SplitMenuButton leagueMenu = new SplitMenuButton();
        leagueMenu.setText("League Menu");
        MenuItem addLeague = new MenuItem("Create League");
        addLeague.setOnAction(e->{
            dashboardLayout.setCenter(createLeague());
        });
        MenuItem viewLeague = new MenuItem("View League");
        viewLeague.setOnAction(e->{
            dashboardLayout.setCenter(viewLeague());
        });
        MenuItem editLeague = new MenuItem("Edit League");
        MenuItem delLeague = new MenuItem("Delete League");

        leagueMenu.getItems().addAll(addLeague, viewLeague, editLeague, delLeague);

        //create, edit, remove, view - Manager properties
        SplitMenuButton managerMenu = new SplitMenuButton();
        managerMenu.setText("Manager Menu");
        MenuItem addManager = new MenuItem("Create Manager");
        MenuItem viewManager = new MenuItem("View Manager");
        MenuItem editManager = new MenuItem("Edit Manager");
        MenuItem delManager = new MenuItem("Delete Manager");

        managerMenu.getItems().addAll(addManager, viewManager, editManager, delManager);

        //create, edit, remove, view - Match Play properties
        SplitMenuButton matchPlayMenu = new SplitMenuButton();
        matchPlayMenu.setText("Matches Menu");
        MenuItem addMatchPlay = new MenuItem("Create Game");
        MenuItem viewMatchPlay = new MenuItem("View Game");
        MenuItem editMatchPlay = new MenuItem("Edit Game");
        MenuItem delMatchPlay = new MenuItem("Delete Game");

        matchPlayMenu.getItems().addAll(addMatchPlay, viewMatchPlay, editMatchPlay, delMatchPlay);

        //create, edit, remove, view - Officiate properties
        SplitMenuButton leagueOfficialMenu = new SplitMenuButton();
        leagueOfficialMenu.setText("League Official Menu");
        MenuItem addLeagueOfficial = new MenuItem("Create League Official");
        MenuItem viewLeagueOfficial = new MenuItem("View League Official");
        MenuItem editLeagueOfficial = new MenuItem("Edit League Official");
        MenuItem delLeagueOfficial = new MenuItem("Delete League Official");

        leagueOfficialMenu.getItems().addAll(addLeagueOfficial, viewLeagueOfficial, editLeagueOfficial, delLeagueOfficial);

        //create, edit, remove, view - Match Play properties
        SplitMenuButton trophyMenu = new SplitMenuButton();
        trophyMenu.setText("Trophy Menu");
        MenuItem addTrophy = new MenuItem("Add Trophy");
        MenuItem viewTrophy = new MenuItem("View Trophy");
        MenuItem editTrophy = new MenuItem("Edit Trophy");
        MenuItem delTrophy = new MenuItem("Delete Trophy");
        addTrophy.setId("addTrophyBtn");
//        Button addTrophy = new Button("Add Trophy");
//        Button viewTrophy = new Button("View Trophy");
//        Button editTrophy = new Button("Edit Trophy");
//        Button delTrophy = new Button("Delete Trophy");
//        Label trophy = new Label("Trophy");
//        ComboBox trophyMenu = new ComboBox();
        trophyMenu.getItems().addAll(addTrophy ,viewTrophy, editTrophy, delTrophy);

        HBox menuLayout = new HBox(10);
        menuLayout.setId("menu");
        menuLayout.getChildren().addAll(teamMenu, playerMenu, leagueMenu, officialMenu, matchMenu, goalMenu, managerMenu,
                matchPlayMenu, leagueOfficialMenu, trophyMenu );

        //main
        Label mainContent = new Label("Welcome To My League App!");
        mainContent.setId("main");


        //footer
        Label sign = new Label("GFA");
        sign.setId("footLbl");
        Label dev = new Label("</> By Pa Ebou");
        dev.setId("footLbl");
        HBox footerContent = new HBox(180);
        footerContent.setId("footer");
        footerContent.getChildren().addAll(sign, dev);
        footerContent.setId("footer");

        //Set contents
        dashboardLayout.setTop(menuLayout);
        dashboardLayout.setCenter(mainContent);
        dashboardLayout.setBottom(footerContent);

        //set scene
        Scene dashboardScene = new Scene(dashboardLayout, 1500,800);

        dashboardScene.getStylesheets().add("style.css");
        //Todo return the scene
        return dashboardScene;
    }

    //Create Team Form
    public VBox createTeam(){
        VBox teamForm = new VBox(30);
        teamForm.setAlignment(Pos.CENTER);

        HBox teamNameLayout = new HBox(30);
        teamNameLayout.setAlignment(Pos.CENTER);
        Label teamNameLbl = new Label("Team Name");
        teamNameLbl.setId("lblBtn");
        TextField teamNameFld = new TextField();
        teamNameFld.setPromptText("jam city f-c");
        teamNameLayout.getChildren().addAll(teamNameLbl, teamNameFld);

        HBox foundYearLayout = new HBox(30);
        foundYearLayout.setAlignment(Pos.CENTER);
        Label foundYearLbl = new Label("Found Year");
        foundYearLbl.setId("lblBtn");
//        TextField foundYearFld = new TextField();
        DatePicker foundYearFld = new DatePicker();
//        foundYearFld.setPromptText("2021-02-22 22:55:05");
        foundYearLayout.getChildren().addAll(foundYearLbl, foundYearFld);

        HBox leagueLayout = new HBox(30);
        leagueLayout.setAlignment(Pos.CENTER);
        Label leagueLbl = new Label("Select League");
        ComboBox leagueSel = new ComboBox();
        leagueLayout.getChildren().addAll(leagueLbl, leagueSel);

        Label msgHandler = new Label();
        Button addTeam = new Button("Add Team");

        teamForm.getChildren().addAll(teamNameLayout, foundYearLayout, leagueLayout, addTeam, msgHandler);
        return teamForm;

    }

    //list Team
    public TableView viewTeam(){
        TableView teamList = new TableView();



        return null;
    }

    //Create League
    public VBox createLeague(){
        VBox createForm = new VBox(30);
        createForm.setAlignment(Pos.CENTER);

        HBox leagueNameLayout = new HBox(30);
        leagueNameLayout.setAlignment(Pos.CENTER);
        Label leagueNameLbl = new Label("League Name");
        TextField leagueNameFld = new TextField();
        leagueNameFld.setPromptText("First Division");
        leagueNameLayout.getChildren().addAll(leagueNameLbl, leagueNameFld);

        HBox leagueCategoryLayout = new HBox(30);
        leagueCategoryLayout.setAlignment(Pos.CENTER);
        Label leagueCategoryLbl = new Label("League Category");
        TextField leagueCategoryFld = new TextField();
        leagueCategoryFld.setPromptText("Division One");
        leagueCategoryLayout.getChildren().addAll(leagueCategoryLbl, leagueCategoryFld);

        HBox leagueStartDateLayout = new HBox(30);
        leagueStartDateLayout.setAlignment(Pos.CENTER);
        Label leagueStartDateLbl = new Label("League Start Date");
//        TextField leagueStartDateFld = new TextField();
        DatePicker leagueStartDateFld = new DatePicker();
//        leagueStartDateFld.setPromptText("2021-06-15 03:00:00");
//        DatePicker leagueEndDateFld = new DatePicker();
        leagueStartDateLayout.getChildren().addAll(leagueStartDateLbl, leagueStartDateFld);

        HBox leagueEndDateLayout = new HBox(30);
        leagueEndDateLayout.setAlignment(Pos.CENTER);
        Label leagueEndDateLbl = new Label("League Start Date");
        DatePicker leagueEndDateFld = new DatePicker();
//        TextField leagueEndDateFld = new TextField();
//        leagueEndDateFld.setPromptText("2021-06-15 03:00:00");
        leagueEndDateLayout.getChildren().addAll(leagueEndDateLbl, leagueEndDateFld);

        Label handleMsg = new Label();
        Button addBtn = new Button("Add League");
        addBtn.setOnAction(e->{
            String name = leagueNameLbl.getText();
            String category = leagueCategoryFld.getText();
            LocalDate startDate = leagueStartDateFld.getValue();
            LocalDate endDate = leagueEndDateFld.getValue();
            //Check for all fields
            if(name.length() != 0 && category.length()  != 0){
                Database newLeague = new Database();
                newLeague.createLeague(leagueNameFld.getText(), leagueCategoryFld.getText(), leagueStartDateFld.getValue(), leagueEndDateFld.getValue());
                leagueNameFld.setText("");
                leagueCategoryFld.setText("");
                leagueStartDateFld.setValue(startDate);
                leagueEndDateFld.setValue(endDate);
                handleMsg.setText("League Created");
            } else {
                handleMsg.setText("All Fields are Required.. Try Adding Again");
            }
        });

        createForm.getChildren().addAll(leagueNameLayout, leagueCategoryLayout, leagueStartDateLayout, leagueEndDateLayout,addBtn, handleMsg);
        return  createForm;

    }

    //List Teams
    public TableView viewLeague(){
        TableView leagueList = new TableView();

        TableColumn<League,Integer> leagueIdCol = new TableColumn();
        TableColumn<League, String> leagueNameCol = new TableColumn<>();
        TableColumn<League, String> leagueCategoryCol = new TableColumn<>();
        TableColumn<League, String> leagueStartCol = new TableColumn<>();
        TableColumn<League, String> leagueEndCol = new TableColumn<>();
        leagueList.getItems().addAll(leagueIdCol, leagueNameCol, leagueCategoryCol, leagueStartCol, leagueEndCol);
        return leagueList;
    }

}
