package GUI;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Cursor;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.beans.property.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.text.Font;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.util.Duration;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import model.characters.Character;
import model.characters.Direction;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;

//import static java.util.concurrent.CompletableFuture.Delayer.delay;

public class main extends Application implements EventHandler{

    Button startGame;
    Button Miller ;
    Button Williams;
    Button Tess;
    Button Riley;
    Button Tommy;
    Button Bill;
    Button David;
    Button Henry;
    Button Millermenubutton ;
    Button Williamsmenubutton;
    Button Tessmenubutton;
    Button Rileymenubutton;
    Button Tommymenubutton;
    Button Billmenubutton;
    Button Davidmenubutton;
    Button Henrymenubutton;
    Button up;
    Button down;
    Button left;
    Button right;
    Button attack;
    Button usespecial;
    Button usevaccine;
    Button zombietarget;
    Button Endturn;
    //SCENES
    Scene scene;
    Scene map;
    Scene select;
    Stage stage;
    Button[][] maparray;

    GridPane mapgrid;
    BorderPane mainmap;
    VBox herohud;
    VBox hphud;

    VBox Hudcontainer;
    VBox heromenu;
    HBox Millerbox;
    VBox Millerdetails;
    HBox Williambox;
    VBox Williamdetails;
    HBox Tessbox;
    VBox Tessdetails;
    HBox Rileybox;
    VBox Rileydetails;
    HBox Tommybox;
    VBox Tommydetails;
    HBox Billbox;
    VBox Billdetails;
    HBox Davidbox;
    VBox Daviddetails;
    HBox Henrybox;
    VBox Henrydetails;
    HBox Millermenubox;
    VBox Millermenudetails;
    HBox Williammenubox;
    VBox Williammenudetails;
    HBox Tessmenubox;
    VBox Tessmenudetails;
    HBox Rileymenubox;
    VBox Rileymenudetails;
    HBox Tommymenubox;
    VBox Tommymenudetails;
    HBox Billmenubox;
    VBox Billmenudetails;
    HBox Davidmenubox;
    VBox Davidmenudetails;
    HBox Henrymenubox;
    VBox Henrymenudetails;
    //Miller info
    Label miller = new Label("Name: Joel Miller");
    Label millerType = new Label("Type: Fighter");
    Label millermaxHp = new Label("Maximum HP: 140");
    Label millerattackdmg = new Label("Attack Damage: 30");
    Label millermaxactions= new Label("Max Actions: 5");
    Label milleractionsav;
    Label millerhp;
    Label millersupply;
    Label millervaccine;
    //Williams info
    Label williams = new Label("Name: Ellie Williams");
    Label williamType = new Label("Type: Medic");
    Label williammaxHp = new Label("Maximum HP: 110");
    Label williamattackdmg = new Label("Attack Damage: 15");
    Label williammaxactions= new Label("Max Actions: 6");
    Label williamhp;
    Label williamsactionsav;
    Label williamsupply;
    Label williamvaccine;
    //tess info
    Label tess = new Label("Name: Tess");
    Label tessType = new Label("Type: Explorer");
    Label tessmaxHp = new Label("Maximum HP: 80");
    Label tessattackdmg = new Label("Attack Damage: 20");
    Label tessmaxactions= new Label("Max Actions: 6");
    Label tesshp;
    Label tessactionsav;
    Label tesssupply;
    Label tessvaccine;
    //Riley info
    Label riley = new Label("Name: Riley Abel");
    Label rileyType = new Label("Type: Explorer");
    Label rileymaxHp = new Label("Maximum HP: 90");
    Label rileyattackdmg = new Label("Attack Damage: 25");
    Label rileymaxactions= new Label("Max Actions: 5");
    Label rileyhp;
    Label rileyactionsav;
    Label rileysupply;
    Label rileyvaccine;
    //Tommy info
    Label tommy = new Label("Name: Tommy Miller");
    Label tommyType = new Label("Type: Explorer");
    Label tommymaxHp = new Label("Maximum HP: 95");
    Label tommyattackdmg = new Label("Attack Damage: 25");
    Label tommymaxactions= new Label("Max Actions: 5");
    Label tommyhp;
    Label tommyactionsav;
    Label tommysupply;
    Label tommyvaccine;
    //Bill info
    Label bill = new Label("Name: Bill");
    Label billType = new Label("Type: Medic");
    Label billermaxHp = new Label("Maximum HP: 100");
    Label billattackdmg = new Label("Attack Damage: 10");
    Label billmaxactions= new Label("Max Actions: 7");
    Label billhp;
    Label billactionsav;
    Label billsupply;
    Label billvaccine;
    //David info
    Label david = new Label("Name: David");
    Label davidType = new Label("Type: Fighter");
    Label davidmaxHp = new Label("Maximum HP: 150");
    Label davidattackdmg = new Label("Attack Damage: 35");
    Label davidmaxactions= new Label("Max Actions: 4");
    Label davidhp;
    Label davidactionsav;
    Label davidsupply;
    Label davidvaccine;
    //Henry info
    Label henry = new Label("Name: Henry Burell");
    Label henryType = new Label("Type: Medic");
    Label henrymaxHp = new Label("Maximum HP: 105");
    Label henryattackdmg = new Label("Attack Damage: 15");
    Label henrymaxactions= new Label("Max Actions: 6");
    Label henryhp;
    Label henryactionsav;
    Label henrysupply;
    Label henryvaccine;

    Label millernewhp;
    Label williamnewhp;
    Label tessnewhp;
    Label rileynewhp;
    Label tommynewhp;
    Label billnewhp;
    Label davidnewhp;
    Label henrynewhp;
    //Side menu labels

    Label millermenu = new Label("Name: Joel Miller");
    Label millerTypemenu = new Label("Type: Fighter");
    Label millermaxHpmenu = new Label("Maximum HP: 140");
    Label millerattackdmgmenu = new Label("Attack Damage: 30");
    Label millermaxactionsmenu= new Label("Max Actions: 5");
    Label milleractionsavmenu;
    Label millerhpmenu;
    Label millersupplymenu;
    Label millervaccinemenu;
    //Williams info
    Label williamsmenu = new Label("Name: Ellie Williams");
    Label williamTypemenu = new Label("Type: Medic");
    Label williammaxHpmenu = new Label("Maximum HP: 110");
    Label williamattackdmgmenu = new Label("Attack Damage: 15");
    Label williammaxactionsmenu= new Label("Max Actions: 6");
    Label williamhpmenu;
    Label williamsactionsavmenu;
    Label williamsupplymenu;
    Label williamvaccinemenu;
    //tess info
    Label tessmenu = new Label("Name: Tess");
    Label tessTypemenu = new Label("Type: Explorer");
    Label tessmaxHpmenu = new Label("Maximum HP: 80");
    Label tessattackdmgmenu = new Label("Attack Damage: 20");
    Label tessmaxactionsmenu= new Label("Max Actions: 6");
    Label tesshpmenu;
    Label tessactionsavmenu;
    Label tesssupplymenu;
    Label tessvaccinemenu;
    //Riley info
    Label rileymenu = new Label("Name: Riley Abel");
    Label rileyTypemenu = new Label("Type: Explorer");
    Label rileymaxHpmenu = new Label("Maximum HP: 90");
    Label rileyattackdmgmenu = new Label("Attack Damage: 25");
    Label rileymaxactionsmenu= new Label("Max Actions: 5");
    Label rileyhpmenu;
    Label rileyactionsavmenu;
    Label rileysupplymenu;
    Label rileyvaccinemenu;
    //Tommy info
    Label tommymenu = new Label("Name: Tommy Miller");
    Label tommyTypemenu = new Label("Type: Explorer");
    Label tommymaxHpmenu = new Label("Maximum HP: 95");
    Label tommyattackdmgmenu = new Label("Attack Damage: 25");
    Label tommymaxactionsmenu= new Label("Max Actions: 5");
    Label tommyhpmenu;
    Label tommyactionsavmenu;
    Label tommysupplymenu;
    Label tommyvaccinemenu;
    //Bill info
    Label billmenu = new Label("Name: Bill");
    Label billTypemenu = new Label("Type: Medic");
    Label billermaxHpmenu = new Label("Maximum HP: 100");
    Label billattackdmgmenu = new Label("Attack Damage: 10");
    Label billmaxactionsmenu= new Label("Max Actions: 7");
    Label billhpmenu;
    Label billactionsavmenu;
    Label billsupplymenu;
    Label billvaccinemenu;
    //David info
    Label davidmenu = new Label("Name: David");
    Label davidTypemenu = new Label("Type: Fighter");
    Label davidmaxHpmenu = new Label("Maximum HP: 150");
    Label davidattackdmgmenu = new Label("Attack Damage: 35");
    Label davidmaxactionsmenu= new Label("Max Actions: 4");
    Label davidhpmenu;
    Label davidactionsavmenu;
    Label davidsupplymenu;
    Label davidvaccinemenu;
    //Henry info
    Label henrymenu = new Label("Name: Henry Burell");
    Label henryTypemenu = new Label("Type: Medic");
    Label henrymaxHpmenu = new Label("Maximum HP: 105");
    Label henryattackdmgmenu = new Label("Attack Damage: 15");
    Label henrymaxactionsmenu= new Label("Max Actions: 6");
    Label henryhpmenu;
    Label henryactionsavmenu;
    Label henrysupplymenu;
    Label henryvaccinemenu;

    //END OF SIDE MENU LABELS
    HBox notifications;
    Label notification;
    //Controlles
    HBox control;
    //Alerts
    Alert alertnoheroes;
    Alert gamewin;
    Alert gameover;
    //Flag for dead heroes
    boolean millerisdead;
    boolean williamisdead;
    boolean tessisdead;
    boolean rileyisdead;
    boolean tommyisdead;
    boolean billisdead;
    boolean davidisdead;
    boolean henryisdead;
    // ROOT
    VBox root;
    boolean notificationflag;
//selecting heroes menu bar
VBox selectingheroesscene;
HBox heroes;
    Button selectherotest;
    VBox selectedmillerbox;
    VBox selectedherocontainer;
    VBox selectedmillerdetails;
    Label selectedmillername;
    Label selectedmillerType;
    Label selectedmillermaxHp;
    Label selectedmillerattackdmg;
    Label selectedmillermaxactions;
    Button selectedmillerbutton;
    Scene gameoverscene;
    Scene gamewinscene;
    DoubleProperty healthpercentage;
    ProgressBar hpbar;
    @Override
    public void start(Stage Mainstage) throws IOException {

        stage = Mainstage;
        stage.setTitle("The Last of us Legacy");
        stage.setWidth(1400);
        stage.setHeight(1060);
        stage.setMinWidth(1400);
        stage.setMinHeight(1060);
        //stage.setResizable(false);
        //stage.setFullScreen(true);
        root = new VBox(); //column,row
        selectherotest = new Button("Select your Hero");
        //selectherotest.setPrefSize(200,100);
        selectherotest.setId("selecthero");
        //Main scene
        startGame = new Button("Start Game"); //Button to start new game(use start game method)
        Button startexit = new Button("Exit");
        startexit.setStyle("-fx-font-size: 50");
        startexit.setOnAction(e->{
            stage.close();
        });
        Button navigation = new Button();
        navigation.setId("navigation");
        navigation.setPrefSize(100,100);
        Button back = new Button("Back");
        back.setOnAction(e->{
            stage.setScene(scene);
        });
        Button back2 = new Button("Back");
        back2.setOnAction(e->{
            stage.setScene(scene);
        });
        back2.setId("startgame");
        GridPane rulesgrid = new GridPane();
        VBox rulesbox = new VBox();
        rulesbox.setId("controlscenebox");
        rulesgrid.setAlignment(Pos.CENTER);
        rulesgrid.add(rulesbox,0,0);
        rulesgrid.add(back2,0,1);
        Label instructions = new Label("\n" +
                "Intro:\n \n" +
                "The Last of Us: Legacy is a single player survival game set in a zombie apocalyptic world.\n \n" +
                "The game is conducted in a turn based manner, in which each player character receives a specific\n \n" +
                "number of action points per turn, which they can use to move, attack or cure zombies, or use\n \n" +
                "special actions.\n \n" +
                "The player starts the game controlling only one hero, but can gain additional heroes by curing\n \n" +
                "zombies. The objective of the game for the player is to survive as long as it takes in order to\n \n" +
                "cure a sufficient number of zombies enough to build a community to survive the apocalypse.\n \n" +
                "\n \n" + "Rules:\n \n" +
                "The player starts off in a 15x15 grid map with just one hero and 10 zombies. The player can\n \n" +
                "only see the directly adjacent cells next to their pool of heroes. The player then keeps taking\n \n" +
                "his turn trying to collect vaccines, and cure or kill zombies. The game ends when the player\n \n" +
                "has collected and used all vaccines or when all heroes have been overwhelmed and defeated by\n \n" +
                "the zombies.\n \n" +
                "The player only wins if he has successfully collected and used all vaccines and has 5 or more\n \n" +
                "heroes alive.");
        instructions.setId("attckk");
        rulesbox.getChildren().addAll(instructions);

        Scene rules = new Scene(rulesgrid);
        rules.getStylesheets().add("Styling.css");
        Button rulesbutton= new Button("Rules and Info");
        rulesbutton.setId("startgame");
        rulesbutton.setOnAction(e->{
            stage.setScene(rules);
        });
        back.setId("startgame");
        Button Control = new Button("Controls");
        Control.setId("startgame");
        GridPane controlscenemain = new GridPane();
        controlscenemain.setAlignment(Pos.CENTER);
        VBox controlscenebox = new VBox();
        controlscenebox.setSpacing(10);
        controlscenebox.setId("controlscenebox");
        controlscenebox.setAlignment(Pos.CENTER);
        controlscenebox.setPrefWidth(500);
        HBox controlattack = new HBox();
        HBox controlvaccine = new HBox();
        HBox controlspecial = new HBox();
        HBox controlendturn = new HBox();
        HBox controlnavigation = new HBox();
        Label navigationbuttons = new Label(" :You can use the OnScreen navigation controls \n \n Or you can use your keyboard Arrow_Keys.");
        navigationbuttons.setId("vacinn");
        Button endturnn = new Button("End Turn");
        endturnn.setId("endturn");
        endturnn.setPrefSize(100,100);
        Label endrun = new Label(" :Use this button to end the current turn and start a new one.");
        endrun.setId("vacinn");
        Button attck=new Button();
        attck.setId("attack");
        attck.setPrefSize(100,100);
        Button vaccin = new Button();
        vaccin.setId("usevaccine");
        vaccin.setPrefSize(100,100);
        Button speciall=new Button();
        speciall.setPrefSize(100,100);
        speciall.setId("usespecial");
        Label attckk = new Label(" :Use this button to attack zombies.\n \nOr you can use Space_Bar");
        attckk.setId("vacinn");
        Label vacinn = new Label(" :Use this button to use your vaccines.\n \nOr you can use Enter_Key");
        vacinn.setId("vacinn");
        Label specil = new Label(" :Use this button to use your special action.\n \nOr you can use Control_Key");
        specil.setId("vacinn");
        controlnavigation.getChildren().addAll(navigation,navigationbuttons);
        controlendturn.getChildren().addAll(endturnn,endrun);
        controlattack.getChildren().addAll(attck,attckk);
        controlspecial.getChildren().addAll(speciall,specil);
        controlvaccine.getChildren().addAll(vaccin,vacinn);
        controlscenebox.getChildren().addAll(controlattack,controlspecial,controlvaccine,controlendturn,controlnavigation);
        controlscenemain.add(controlscenebox,0,0);
        controlscenemain.add(back,0,1);
        Scene instructionscene = new Scene(controlscenemain);
        instructionscene.getStylesheets().add("Styling.css");
        Control.setOnAction(e->{
            stage.setScene(instructionscene);
        });
        startexit.setId("startgame");
        startGame.setId("startgame");
        startGame.setOnAction(this);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(startGame,rulesbutton,Control,startexit);
        //selecting heroes scene
        heroes = new HBox();
        Game.loadHeroes("D:\\team127 milestone3\\src\\main\\resources\\Heros.csv");
        //ALERTS
        //GAMEOVER ALL HEROES DIER ALERT
        alertnoheroes = new Alert(Alert.AlertType.INFORMATION);
        alertnoheroes.setTitle(null);
        alertnoheroes.setHeaderText("Game Over!");
        alertnoheroes.setContentText("All your heros died");
        //Game WIN ALERT
        gamewin=new Alert(Alert.AlertType.INFORMATION);
        gamewin.setTitle(null);
        gamewin.setHeaderText("Bravo!");
        gamewin.setContentText("You cured the maximum number of heroes possible!\n you can now close the game.");
        //GAMEOVER ALERT ALL VACCINES PICKED UP
        gameover = new Alert(Alert.AlertType.INFORMATION);
        gameover.setTitle(null);
        gameover.setHeaderText("Game Over!");
        gameover.setContentText("Not enough heroes survived! \n you can now close the game.");
        //Buttons to select heroes
        Miller = new Button();
        Miller.setOnAction(this);
        Miller.setId("Miller");
        Miller.setPrefSize(100,100);
        Millerdetails = new VBox();
        Millerdetails.setId("Startmenudetails");
        Millerbox = new HBox();
        miller.setId("HerohudLabels");
        millerType.setId("HerohudInfoStyle");
        millermaxactions.setId("HerohudInfoStyle");
        millerattackdmg.setId("HerohudInfoStyle");
        millermaxHp.setId("HerohudInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Millerdetails.getChildren().addAll(miller,millerType,millermaxHp,millerattackdmg,millermaxactions);
        Millerbox.getChildren().addAll(Miller,Millerdetails);
        Williams = new Button();
        Williams.setOnAction(this);
        Williams.setId("Williams");
        Williams.setPrefSize(100,100);
        Williambox = new HBox();
        Williamdetails=new VBox();
        Williamdetails.setId("Startmenudetails");
        williams.setId("HerohudLabels");
        williamType.setId("HerohudInfoStyle");
        williammaxactions.setId("HerohudInfoStyle");
        williamattackdmg.setId("HerohudInfoStyle");
        williammaxHp.setId("HerohudInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Williamdetails.getChildren().addAll(williams,williamType,williammaxHp,williamattackdmg,williammaxactions);
        Williambox.getChildren().addAll(Williams,Williamdetails);
        Tess = new Button();
        Tess.setOnAction(this);
        Tess.setId("Tess");
        Tess.setPrefSize(100,100);
        Tessbox = new HBox();
        Tessdetails=new VBox();
        Tessdetails.setId("Startmenudetails");
        tess.setId("HerohudLabels");
        tessType.setId("HerohudInfoStyle");
        tessmaxactions.setId("HerohudInfoStyle");
        tessattackdmg.setId("HerohudInfoStyle");
        tessmaxHp.setId("HerohudInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Tessdetails.getChildren().addAll(tess,tessType,tessmaxHp,tessattackdmg,tessmaxactions);
        Tessbox.getChildren().addAll(Tess,Tessdetails);
        Riley = new Button();
        Riley.setOnAction(this);
        Riley.setId("Riley");
        Riley.setPrefSize(100,100);
        Rileybox = new HBox();
        Rileydetails=new VBox();
        Rileydetails.setId("Startmenudetails");
        riley.setId("HerohudLabels");
        rileyType.setId("HerohudInfoStyle");
        rileyattackdmg.setId("HerohudInfoStyle");
        rileymaxactions.setId("HerohudInfoStyle");
        rileymaxHp.setId("HerohudInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Rileydetails.getChildren().addAll(riley,rileyType,rileymaxHp,rileyattackdmg,rileymaxactions);
        Rileybox.getChildren().addAll(Riley,Rileydetails);
        Tommy = new Button();
        Tommy.setOnAction(this);
        Tommy.setId("Tommy");
        Tommy.setPrefSize(100,100);
        Tommybox = new HBox();
        Tommydetails=new VBox();
        Tommydetails.setId("Startmenudetails");
        tommy.setId("HerohudLabels");
        tommyType.setId("HerohudInfoStyle");
        tommymaxHp.setId("HerohudInfoStyle");
        tommymaxactions.setId("HerohudInfoStyle");
        tommyattackdmg.setId("HerohudInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Tommydetails.getChildren().addAll(tommy,tommyType,tommymaxHp,tommyattackdmg,tommymaxactions);
        Tommybox.getChildren().addAll(Tommy,Tommydetails);
        Bill = new Button();
        Bill.setOnAction(this);
        Bill.setId("Bill");
        Bill.setPrefSize(100,100);
        Billbox = new HBox();
        Billdetails=new VBox();
        Billdetails.setId("Startmenudetails");
        bill.setId("HerohudLabels");
        billType.setId("HerohudInfoStyle");
        billattackdmg.setId("HerohudInfoStyle");
        billmaxactions.setId("HerohudInfoStyle");
        billermaxHp.setId("HerohudInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Billdetails.getChildren().addAll(bill,billType,billermaxHp,billattackdmg,billmaxactions);
        Billbox.getChildren().addAll(Bill,Billdetails);
        David = new Button();
        David.setOnAction(this);
        David.setId("David");
        David.setPrefSize(100,100);
        Davidbox = new HBox();
        Daviddetails=new VBox();
        Daviddetails.setId("Startmenudetails");
        david.setId("HerohudLabels");
        davidType.setId("HerohudInfoStyle");
        davidmaxactions.setId("HerohudInfoStyle");
        davidattackdmg.setId("HerohudInfoStyle");
        davidmaxHp.setId("HerohudInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Daviddetails.getChildren().addAll(david,davidType,davidmaxHp,davidattackdmg,davidmaxactions);
        Davidbox.getChildren().addAll(David,Daviddetails);
        Henry = new Button();
        Henry.setOnAction(this);
        Henry.setId("Henry");
        Henry.setPrefSize(100,100);
        Henrybox = new HBox();
        Henrydetails=new VBox();
        Henrydetails.setId("Startmenudetails");
        henry.setId("HerohudLabels");
        henryType.setId("HerohudInfoStyle");
        henrymaxactions.setId("HerohudInfoStyle");
        henryattackdmg.setId("HerohudInfoStyle");
        henrymaxHp.setId("HerohudInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Henrydetails.getChildren().addAll(henry,henryType,henrymaxHp,henryattackdmg,henrymaxactions);
        Henrybox.getChildren().addAll(Henry,Henrydetails);
        //SIDE MENU HERO ICONS
        Millermenubutton = new Button();
        millernewhp=new Label("Currenthp: "+Game.availableHeroes.get(0).getCurrentHp());
        millernewhp.setId("Herohplabel");
        //Millermenubutton.setOnAction(this);
        Millermenubutton.setId("Miller");
        Millermenubutton.setPrefSize(100,100);
        Millermenubox = new HBox();
        Millermenudetails=new VBox();
        Millermenudetails.setSpacing(4);
        millermenu.setId("HeroLabels");
        millerTypemenu.setId("HeroInfoStyle");
        millermaxactionsmenu.setId("HeroInfoStyle");
        millerattackdmgmenu.setId("HeroInfoStyle");
        millermaxHpmenu.setId("HeroInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Millermenudetails.getChildren().addAll(millermenu,millerTypemenu,millernewhp,millerattackdmgmenu,millermaxactionsmenu);
        Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
        Millermenubox.getStylesheets().add("Styling.css");
        Millermenubox.setId("herosmenubox");
        Williamsmenubutton = new Button();
        williamnewhp=new Label("Currenthp: "+Game.availableHeroes.get(1).getCurrentHp());
        williamnewhp.setId("Herohplabel");
        //Williams.setOnAction(this);
        Williamsmenubutton.setId("Williams");
        Williamsmenubutton.setPrefSize(100,100);
        Williammenubox = new HBox();
        Williammenudetails=new VBox();
        Williammenudetails.setSpacing(4);
        williamsmenu.setId("HeroLabels");
        williamTypemenu.setId("HeroInfoStyle");
        williammaxactionsmenu.setId("HeroInfoStyle");
        williamattackdmgmenu.setId("HeroInfoStyle");
        williammaxHpmenu.setId("HeroInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Williammenudetails.getChildren().addAll(williamsmenu,williamTypemenu,williamnewhp,williamattackdmgmenu,williammaxactionsmenu);
        Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
        Williammenubox.getStylesheets().add("Styling.css");
        Williammenubox.setId("herosmenubox");
        Tessmenubutton = new Button();
        tessnewhp=new Label("Currenthp: "+Game.availableHeroes.get(2).getCurrentHp());
        tessnewhp.setId("Herohplabel");
        //Tessmenubutton.setOnAction(this);
        Tessmenubutton.setId("Tess");
        Tessmenubutton.setPrefSize(100,100);
        Tessmenubox = new HBox();
        Tessmenudetails=new VBox();
        Tessmenudetails.setSpacing(4);
        tessmenu.setId("HeroLabels");
        tessTypemenu.setId("HeroInfoStyle");
        tessmaxactionsmenu.setId("HeroInfoStyle");
        tessattackdmgmenu.setId("HeroInfoStyle");
        tessmaxHpmenu.setId("HeroInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Tessmenudetails.getChildren().addAll(tessmenu,tessTypemenu,tessnewhp,tessattackdmgmenu,tessmaxactionsmenu);
        Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
        Tessmenubox.getStylesheets().add("Styling.css");
        Tessmenubox.setId("herosmenubox");
        Rileymenubutton = new Button();
        rileynewhp=new Label("Currenthp: "+Game.availableHeroes.get(3).getCurrentHp());
        rileynewhp.setId("Herohplabel");
        //Rileymenubutton.setOnAction(this);
        Rileymenubutton.setId("Riley");
        Rileymenubutton.setPrefSize(100,100);
        Rileymenubox = new HBox();
        Rileymenudetails=new VBox();
        Rileymenudetails.setSpacing(4);
        rileymenu.setId("HeroLabels");
        rileyTypemenu.setId("HeroInfoStyle");
        rileyattackdmgmenu.setId("HeroInfoStyle");
        rileymaxactionsmenu.setId("HeroInfoStyle");
        rileymaxHpmenu.setId("HeroInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Rileymenudetails.getChildren().addAll(rileymenu,rileyTypemenu,rileynewhp,rileyattackdmgmenu,rileymaxactionsmenu);
        Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
        Rileymenubox.getStylesheets().add("Styling.css");
        Rileymenubox.setId("herosmenubox");
        Tommymenubutton = new Button();
        tommynewhp=new Label("Currenthp: "+Game.availableHeroes.get(4).getCurrentHp());
        tommynewhp.setId("Herohplabel");
        //Tommymenubutton.setOnAction(this);
        Tommymenubutton.setId("Tommy");
        Tommymenubutton.setPrefSize(100,100);
        Tommymenubox = new HBox();
        Tommymenudetails=new VBox();
        Tommymenudetails.setSpacing(4);
        tommymenu.setId("HeroLabels");
        tommyTypemenu.setId("HeroInfoStyle");
        tommymaxHpmenu.setId("HeroInfoStyle");
        tommymaxactionsmenu.setId("HeroInfoStyle");
        tommyattackdmgmenu.setId("HeroInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Tommymenudetails.getChildren().addAll(tommymenu,tommyTypemenu,tommynewhp,tommyattackdmgmenu,tommymaxactionsmenu);
        Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
        Tommymenubox.getStylesheets().add("Styling.css");
        Tommymenubox.setId("herosmenubox");
        Billmenubutton = new Button();
        billnewhp=new Label("Currenthp: "+Game.availableHeroes.get(5).getCurrentHp());
        billnewhp.setId("Herohplabel");
        //Billmenubutton.setOnAction(this);
        Billmenubutton.setId("Bill");
        Billmenubutton.setPrefSize(100,100);
        Billmenubox = new HBox();
        Billmenudetails=new VBox();
        Billmenudetails.setSpacing(4);
        billmenu.setId("HeroLabels");
        billTypemenu.setId("HeroInfoStyle");
        billattackdmgmenu.setId("HeroInfoStyle");
        billmaxactionsmenu.setId("HeroInfoStyle");
        billermaxHpmenu.setId("HeroInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Billmenudetails.getChildren().addAll(billmenu,billTypemenu,billnewhp,billattackdmgmenu,billmaxactionsmenu);
        Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
        Billmenubox.getStylesheets().add("Styling.css");
        Billmenubox.setId("herosmenubox");
        Davidmenubutton = new Button();
        davidnewhp=new Label("Currenthp: "+Game.availableHeroes.get(6).getCurrentHp());
        davidnewhp.setId("Herohplabel");
        //Davidmenubutton.setOnAction(this);
        Davidmenubutton.setId("David");
        Davidmenubutton.setPrefSize(100,100);
        Davidmenubox = new HBox();
        Davidmenudetails=new VBox();
        Davidmenudetails.setSpacing(4);
        davidmenu.setId("HeroLabels");
        davidTypemenu.setId("HeroInfoStyle");
        davidmaxactionsmenu.setId("HeroInfoStyle");
        davidattackdmgmenu.setId("HeroInfoStyle");
        davidmaxHpmenu.setId("HeroInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Davidmenudetails.getChildren().addAll(davidmenu,davidTypemenu,davidnewhp,davidattackdmgmenu,davidmaxactionsmenu);
        Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
        Davidmenubox.getStylesheets().add("Styling.css");
        Davidmenubox.setId("herosmenubox");
        Henrymenubutton = new Button();
        henrynewhp=new Label("Currenthp: "+Game.availableHeroes.get(7).getCurrentHp());
        henrynewhp.setId("Herohplabel");
        //Henrymenubutton.setOnAction(this);
        Henrymenubutton.setId("Henry");
        Henrymenubutton.setPrefSize(100,100);
        Henrymenubox = new HBox();
        Henrymenudetails=new VBox();
        Henrymenudetails.setSpacing(4);
        henrymenu.setId("HeroLabels");
        henryTypemenu.setId("HeroInfoStyle");
        henrymaxactionsmenu.setId("HeroInfoStyle");
        henryattackdmgmenu.setId("HeroInfoStyle");
        henrymaxHpmenu.setId("HeroInfoStyle");
        //VBOX FOR THE BUTTON AND THE DETAILS
        Henrymenudetails.getChildren().addAll(henrymenu,henryTypemenu,henrynewhp,henryattackdmgmenu,henrymaxactionsmenu);
        Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
        Henrymenubox.getStylesheets().add("Styling.css");
        Henrymenubox.setId("herosmenubox");

        //END OF THE SIDE MENU
        selectingheroesscene = new VBox();
        selectingheroesscene.setSpacing(10);
        select = new Scene(selectingheroesscene);
        //Miller only test
        //WILLIAMS TEST
        selectedmillerbutton=new Button();
        selectedmillerbox = new VBox();
        Button play = new Button("Play");
        play.setPrefSize(200,100);
        play.setId("playbutton");
        play.setStyle("-fx-font-size:60");
        Label selectedmillername= new Label("Name: Joel Miller");
        selectedmillername.setId("selectedheroname");
        Label selectedmillerType = new Label("Type: Fighter");
        selectedmillerType.setId("selectedherodetails");
        Label selectedmillermaxHp = new Label("Maximum HP: 140");
        selectedmillermaxHp.setId("selectedherodetails");
        Label selectedmillerattackdmg = new Label("Attack Damage: 30");
        selectedmillerattackdmg.setId("selectedherodetails");
        Label selectedmillermaxactions= new Label("Max Actions: 5");
        selectedmillermaxactions.setId("selectedherodetails");
        Button selectedmillermainbutton = new Button();
        selectedmillermainbutton.setPrefSize(100,100);
        selectedmillermainbutton.setOnAction(e->{
            selectedmillerbox.getChildren().clear();
            selectedmillername.setText("Name: Joel Miller");
            selectedmillerbutton.setId("Miller");
            selectedmillerType.setText("Type: Fighter");
            selectedmillermaxHp.setText("Maximum HP: 140");
            selectedmillerattackdmg.setText("Attack Damage: 30");
            selectedmillermaxactions.setText("Max Actions: 5");
            selectedmillerbox.getChildren().addAll(selectedmillername,Miller,selectedmillerdetails);
            buttonfire(play,"Miller");
        });
        selectedmillermainbutton.setId("Miller");
        Button selectedwilliambutton = new Button();
        selectedwilliambutton.setId("Williams");
        selectedwilliambutton.setPrefSize(100,100);
        selectedwilliambutton.setOnAction(e->{
            selectedmillerbox.getChildren().clear();
            selectedmillername.setText("Name: Ellie Williams");
            selectedmillerbutton.setId("Williams");
            //selectedmillerbutton = Williams;
            selectedmillerType.setText("Type: Medic");
            selectedmillermaxHp.setText("Maximum HP: 110");
            selectedmillerattackdmg.setText("Attack Damage: 15");
            selectedmillermaxactions.setText("Max Actions: 6");
            selectedmillerbox.getChildren().addAll(selectedmillername,Williams,selectedmillerdetails);
            buttonfire(play,"Williams");
        });
        Button selectedtessbutton = new Button();
        selectedtessbutton.setPrefSize(100,100);
        selectedtessbutton.setId("Tess");
        selectedtessbutton.setOnAction(e->{
            selectedmillerbox.getChildren().clear();
            selectedmillername.setText("Name: Tess");
            selectedmillerbutton.setId("Tess");
            //selectedmillerbutton = Tess;
            selectedmillerType.setText("Type: Explorer");
            selectedmillermaxHp.setText("Maximum HP: 80");
            selectedmillerattackdmg.setText("Attack Damage: 20");
            selectedmillermaxactions.setText("Max Actions: 6");
            selectedmillerbox.getChildren().addAll(selectedmillername,Tess,selectedmillerdetails);
            buttonfire(play,"Tess");
        });
        Button selectedrileybutton = new Button();
        selectedrileybutton.setPrefSize(100,100);
        selectedrileybutton.setId("Riley");
        selectedrileybutton.setOnAction(e->{
            selectedmillerbox.getChildren().clear();
            selectedmillername.setText("Name: Riley Abel");
            selectedmillerbutton.setId("Riley");
            //selectedmillerbutton = Riley;
            selectedmillerType.setText("Type: Explorer");
            selectedmillermaxHp.setText("Maximum HP: 90");
            selectedmillerattackdmg.setText("Attack Damage: 25");
            selectedmillermaxactions.setText("Max Actions: 5");
            selectedmillerbox.getChildren().addAll(selectedmillername,Riley,selectedmillerdetails);
            buttonfire(play,"Riley");
        });
        Button selectedtommybutton = new Button();
        selectedtommybutton.setPrefSize(100,100);
        selectedtommybutton.setId("Tommy");
        selectedtommybutton.setOnAction(e->{
            selectedmillerbox.getChildren().clear();
            selectedmillername.setText("Name: Tommy MIller");
            selectedmillerbutton.setId("Tommy");
            selectedmillerType.setText("Type: Explorer");
            selectedmillermaxHp.setText("Maximum HP: 95");
            selectedmillerattackdmg.setText("Attack Damage: 25");
            selectedmillermaxactions.setText("Max Actions: 5");
            selectedmillerbox.getChildren().addAll(selectedmillername,Tommy,selectedmillerdetails);
            buttonfire(play,"Tommy");
        });
        Button selectedbillbutton = new Button();
        selectedbillbutton.setPrefSize(100,100);
        selectedbillbutton.setId("Bill");
        selectedbillbutton.setOnAction(e->{
            selectedmillerbox.getChildren().clear();
            selectedmillername.setText("Name: Bill");
            selectedmillerbutton.setId("Bill");
            //selectedmillerbutton = Bill;
            selectedmillerType.setText("Type: Medic");
            selectedmillermaxHp.setText("Maximum HP: 100");
            selectedmillerattackdmg.setText("Attack Damage: 10");
            selectedmillermaxactions.setText("Max Actions: 7");
            selectedmillerbox.getChildren().addAll(selectedmillername,Bill,selectedmillerdetails);
            buttonfire(play,"Bill");
        });
        Button selecteddavidbutton = new Button();
        selecteddavidbutton.setPrefSize(100,100);
        selecteddavidbutton.setId("David");
        selecteddavidbutton.setOnAction(e->{
            selectedmillerbox.getChildren().clear();
            selectedmillername.setText("Name: David");
            selectedmillerbutton.setId("David");
            //selectedmillerbutton = David;
            selectedmillerType.setText("Type: Fighter");
            selectedmillermaxHp.setText("Maximum HP: 150");
            selectedmillerattackdmg.setText("Attack Damage: 35");
            selectedmillermaxactions.setText("Max Actions: 4");
            selectedmillerbox.getChildren().addAll(selectedmillername,David,selectedmillerdetails);
            buttonfire(play,"David");
        });
        Button selectedhenrybutton = new Button();
        selectedhenrybutton.setPrefSize(100,100);
        selectedhenrybutton.setId("Henry");
        selectedhenrybutton.setOnAction(e->{
            selectedmillerbox.getChildren().clear();
            selectedmillername.setText("Name: Henry");
            selectedmillerbutton.setId("Henry");
            //selectedmillerbutton = Henry;
            selectedmillerType.setText("Type: Medic");
            selectedmillermaxHp.setText("Maximum HP: 105");
            selectedmillerattackdmg.setText("Attack Damage: 15");
            selectedmillermaxactions.setText("Max Actions: 6");
            selectedmillerbox.getChildren().addAll(selectedmillername,Henry,selectedmillerdetails);
            buttonfire(play,"Henry");
        });
        //END OF WILLIAMS TEST
        selectedmillerbox.setSpacing(5);

        selectedmillerbutton.setPrefSize(150 ,150);
        selectedmillerdetails = new VBox();
        selectedmillerdetails.setSpacing(10);
        selectedmillerdetails.getChildren().addAll(selectedmillerType,selectedmillermaxHp,selectedmillerattackdmg,selectedmillermaxactions);
        selectedmillerdetails.setAlignment(Pos.CENTER);
        selectedmillerbox.setAlignment(Pos.CENTER);
        selectedherocontainer = new VBox();
        //END OF MILLER TEST
        selectedherocontainer.getChildren().add(selectedmillerbox);
        heroes.setMaxWidth(800);
        heroes.getChildren().addAll(selectedmillermainbutton,selectedwilliambutton,selectedtessbutton,selectedrileybutton,selectedtommybutton,selectedbillbutton,selecteddavidbutton,selectedhenrybutton);
        heroes.setId("startgameherobar");
        selectingheroesscene.setAlignment(Pos.CENTER);
        selectingheroesscene.getChildren().addAll(selectherotest,selectedherocontainer,heroes,play);
        heroes.setAlignment(Pos.CENTER);
        heroes.setSpacing(15);
        scene = new Scene(root);
        scene.getStylesheets().add("Styling.css");
        stage.setScene(scene);
        selectingheroesscene.getStylesheets().add("Styling.css");
        selectingheroesscene.setId("selectscene");
//        ImageView img = new ImageView("selectingheroes_EDIT2.png");
//        selectingheroesscene.getChildren().add(img);



        //root.getChildren().addAll(label1,label2);
        //MAP SCENE
        //Gameover
        VBox gameoverbox = new VBox();
        //gameoverbox.setMinSize(1920,1080);
        gameoverbox.setId("gameoverbox");
        gameoverbox.setAlignment(Pos.CENTER);
        gameoverbox.setSpacing(40);
        gameoverbox.setStyle("-fx-background-color: black");
        //Image test = new Image("gameover.jpg");
        //ImageView gameoverimg = new ImageView(test);
        Label gameovertext = new Label("Game Over");
        Button exitgame = new Button("Exit");
        exitgame.setOnAction(e->{
            stage.close();
        });
        exitgame.setStyle("-fx-font-size: 80");
        exitgame.setId("exitgamebutton");
        gameovertext.setId("gameovertext");
        gameoverbox.getChildren().addAll(gameovertext);
        gameoverbox.getChildren().add(exitgame);
        //gameoverimg.setFitWidth(1920);
        //gameoverimg.setFitHeight(1080);
        gameoverscene=new Scene(gameoverbox);
        gameoverscene.getStylesheets().add("StyleSelect.css");
        //End of game over
        mainmap=new BorderPane();
        mainmap.setId("mainmap");
        mainmap.getStylesheets().add("Styling.css");
        mapgrid = new GridPane();
        mapgrid.getStylesheets().add("Styling.css");
        mapgrid.setId("mapgrid");
        mapgrid.setAlignment(Pos.CENTER);
        mainmap.setCenter(mapgrid);
        map = new Scene(mainmap);
        herohud = new VBox();
        herohud.setSpacing(10);
        herohud.setId("herohud");
        hphud=new VBox();
        hphud.setAlignment(Pos.CENTER);
        hphud.setId("hphud");
//        Button emptyhudbutton = new Button();
//        hphud.getChildren().add(emptyhudbutton);
        Hudcontainer = new VBox();
        Hudcontainer.getStylesheets().add("Styling.css");
        Hudcontainer.setId("hudcontainer");
        Hudcontainer.getChildren().addAll(herohud,hphud);
        Hudcontainer.setSpacing(5);
        //map.setCursor(Cursor.CROSSHAIR);
        //scene.setCursor(Cursor.HAND);
        //select.setCursor(Cursor.HAND);
        mainmap.setRight(Hudcontainer);
        //mainmap.setBottom(Hudcontainer);
        //Sound effects

        //END OF SOUND EFFECTS
        //CONTROLS
        control = new HBox();
        GridPane testarrows=new GridPane();
        up = new Button("up");
        up.setId("up");
        up.setPrefSize(50,50);
        right = new Button("right");
        right.setId("right");
        right.setPrefSize(50,50);
        down = new Button("down");
        down.setId("down");
        down.setPrefSize(50,50);
        left = new Button("left");
        left.setId("left");
        left.setPrefSize(50,50);
        //Notifications
        //sound effects
//        String musicFile = "C:\\Users\\khale\\OneDrive\\Desktop\\milestone3finalintellij\\src\\main\\resources\\gunshot.mp3";
//        Media sound = new Media(new File(musicFile).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        //endofsoundeffects
        map.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode keyCode = keyEvent.getCode();
                switch (keyCode) {
                    case UP: up.fire();
                    break;
                    case DOWN: down.fire();
                    break;
                    case RIGHT: right.fire();
                    break;
                    case LEFT:left.fire();
                    break;
                    case SPACE: attack.fire();
                    break;
                    case CONTROL: usespecial.fire();
                    break;
                    case ENTER: usevaccine.fire();
                    break;
                    case E: Endturn.fire();
                    break;
                }
            }
        });
        notification=new Label();
        notifications=new HBox();
        notifications.setId("notificationsbar");
        notifications.getChildren().addAll(notification);
        notifications.setPrefHeight(70);
        notifications.setAlignment(Pos.CENTER);
        notification.setId("notificationmessage");
        notification.setAlignment(Pos.CENTER);
        mainmap.setTop(notifications);
        //Movement Actions
        right.setOnAction(e->{
            try {
            Hero currhero = Game.heroes.get(0);
            if(Game.heroes.get(0).getLocation().x+1<15) {
                if (Game.map[Game.heroes.get(0).getLocation().x + 1][Game.heroes.get(0).getLocation().y] instanceof TrapCell) {
                    String musicFile = "D:\\team127 milestone3\\src\\main\\resources\\trap.mp3";
                    Media sound = new Media(new File(musicFile).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                    notification.setText("You hit a trap!");
                    ft = new FadeTransition(Duration.millis(3000), notification);
                    //ft.setFromValue(0.0);
                    //ft.setToValue(1.0);
                    //ft.play();
                    ft.setFromValue(1.0);
                    ft.setToValue(0.0);
                    FadeTransition finalFt = ft;
                    //delay(3000, () -> finalFt.play());
                    finalFt.play();
                }
            }
            Game.heroes.get(0).move(Direction.UP);
                if(!Game.heroes.contains(currhero)){
                    //notification.setText(currhero.getName() + " Died!");
                    if(!Game.heroes.isEmpty()) {
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 15; j++) {
                                if (Game.map[i][j] instanceof CharacterCell) {
                                    if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                                        newherosetter(i,j);
                                        Hero newhero = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                                        FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                                        //Auto picking a new hero
                                        switch (newhero.getName()){
                                            case "Joel Miller":
                                                notificationflag=true;
                                                Millermenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                FadeTransition finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case "Ellie Williams":
                                                notificationflag=true;
                                                Williamsmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tess":
                                                notificationflag=true;
                                                Tessmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Riley Abel":
                                                notificationflag=true;
                                                Rileymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tommy Miller":
                                                notificationflag=true;
                                                Tommymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Bill":
                                                notificationflag=true;
                                                Billmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"David":
                                                notificationflag=true;
                                                Davidmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Henry Burell":
                                                notificationflag=true;
                                                Henrymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                        }
                                        //Removing dead hero from the menu
                                        switch (currhero.getName()){
                                            case "Joel Miller":
                                                Millermenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                millerisdead=true;
                                                break;
                                            case "Ellie Williams":
                                                Williammenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                williamisdead=true;
                                                break;
                                            case"Tess":
                                                Tessmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tessisdead=true;
                                                break;
                                            case"Riley Abel":
                                                Rileymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                rileyisdead=true;
                                                break;
                                            case"Tommy Miller":
                                                Tommymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tommyisdead=true;
                                                break;
                                            case"Bill":
                                                Billmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                billisdead=true;
                                                break;
                                            case"David":
                                                Davidmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                davidisdead=true;
                                                break;
                                            case"Henry Burell":
                                                Henrymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                henryisdead=true;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        maparray[currhero.getLocation().x][currhero.getLocation().y].setId("CharacterCell");
                        stage.setScene(gameoverscene);
                        exitgame.setVisible(false);
                        FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                        FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                        ft.setFromValue(0.0);
                        ft.setToValue(1.0);
                        ft2.setFromValue(0.0);
                        ft2.setToValue(1.0);
                        ft.play();
                        delay(2000, () -> ft2.play());
                        delay(2000, () -> exitgame.setVisible(true));
                        ft2.play();
                    }
                    //delay(3000, () -> notification.setText(null));
                }
                maparray[Game.heroes.get(0).getLocation().x-1][Game.heroes.get(0).getLocation().y].setId("CharacterCell");
                maparray[Game.heroes.get(0).getLocation().x-1][Game.heroes.get(0).getLocation().y].setOnAction(null);
                //newherosetter(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y);
                Hero medic = (Hero) Game.heroes.get(0);
                medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                for(int i=0;i<15;i++){
                    for(int j=0;j<15;j++){
                        if(Game.map[i][j].isVisible()){
                            maparray[i][j].setVisible(true);
                        }
                    }
                }
            } catch (MovementException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            }
            switch(Game.heroes.get(0).getName()){
                case "Joel Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    millernewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    milleractionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    millerhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    millersupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    millervaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Miller");
                    break;
                case "Ellie Williams":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    williamnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    williamsactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    williamhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    williamsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    williamvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Williams");
                    break;
                case"Tess":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tessnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    tessactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tesshp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tesssupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tessvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Tess");
                    break;
                case"Riley Abel":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    rileynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    rileyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    rileyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    rileysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    rileyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Riley");
                    break;
                case"Tommy Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tommynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    tommyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tommyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tommysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tommyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Tommy");
                    break;
                case"Bill":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    billnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    billactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    billhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    billsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    billvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Bill");
                    break;
                case"David":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    davidnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    davidactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    davidhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    davidsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    davidvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("David");
                    break;
                case"Henry Burell":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    henrynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    henryactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    henryhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    henrysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    henryvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Henry");
                    break;
            }
            updater();
            if(Game.checkGameOver()){
                stage.setScene(gameoverscene);
                exitgame.setVisible(false);
                FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft2.setFromValue(0.0);
                ft2.setToValue(1.0);
                ft.play();
                delay(2000, () -> ft2.play());
                delay(2000, () -> exitgame.setVisible(true));
                ft2.play();
            }

        });
        left.setOnAction(e->{
            try {
                Hero currhero = Game.heroes.get(0);
                if(Game.heroes.get(0).getLocation().x-1>0) {
                    if (Game.map[Game.heroes.get(0).getLocation().x - 1][Game.heroes.get(0).getLocation().y] instanceof TrapCell) {
                        String musicFile = "D:\\team127 milestone3\\src\\main\\resources\\trap.mp3";
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                        FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                        notification.setText("You hit a trap!");
                        ft = new FadeTransition(Duration.millis(3000), notification);
                        //ft.setFromValue(0.0);
                        //ft.setToValue(1.0);
                        //ft.play();
                        ft.setFromValue(1.0);
                        ft.setToValue(0.0);
                        FadeTransition finalFt = ft;
                        //delay(3000, () -> finalFt.play());
                        finalFt.play();
                    }
                }
                Game.heroes.get(0).move(Direction.DOWN);
                if(!Game.heroes.contains(currhero)){
                    //notification.setText(currhero.getName() + " Died!");
                    if(!Game.heroes.isEmpty()) {
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 15; j++) {
                                if (Game.map[i][j] instanceof CharacterCell) {
                                    if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                                        newherosetter(i,j);
                                        Hero newhero = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                                        FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                                        //Auto picking a new hero
                                        switch (newhero.getName()){
                                            case "Joel Miller":
                                                notificationflag=true;
                                                Millermenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                FadeTransition finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case "Ellie Williams":
                                                notificationflag=true;
                                                Williamsmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tess":
                                                notificationflag=true;
                                                Tessmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Riley Abel":
                                                notificationflag=true;
                                                Rileymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tommy Miller":
                                                notificationflag=true;
                                                Tommymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Bill":
                                                notificationflag=true;
                                                Billmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"David":
                                                notificationflag=true;
                                                Davidmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Henry Burell":
                                                notificationflag=true;
                                                Henrymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                        }
                                        //Removing dead hero from the menu
                                        switch (currhero.getName()){
                                            case "Joel Miller":
                                                Millermenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                millerisdead=true;
                                                break;
                                            case "Ellie Williams":
                                                Williammenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                williamisdead=true;
                                                break;
                                            case"Tess":
                                                Tessmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tessisdead=true;
                                                break;
                                            case"Riley Abel":
                                                Rileymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                rileyisdead=true;
                                                break;
                                            case"Tommy Miller":
                                                Tommymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tommyisdead=true;
                                                break;
                                            case"Bill":
                                                Billmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                billisdead=true;
                                                break;
                                            case"David":
                                                Davidmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                davidisdead=true;
                                                break;
                                            case"Henry Burell":
                                                Henrymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                henryisdead=true;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        maparray[currhero.getLocation().x][currhero.getLocation().y].setId("CharacterCell");
                        stage.setScene(gameoverscene);
                        exitgame.setVisible(false);
                        FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                        FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                        ft.setFromValue(0.0);
                        ft.setToValue(1.0);
                        ft2.setFromValue(0.0);
                        ft2.setToValue(1.0);
                        ft.play();
                        delay(2000, () -> ft2.play());
                        delay(2000, () -> exitgame.setVisible(true));
                        ft2.play();
                    }
                    //delay(3000, () -> notification.setText(null));
                }
                maparray[Game.heroes.get(0).getLocation().x+1][Game.heroes.get(0).getLocation().y].setId("CharacterCell");
                maparray[Game.heroes.get(0).getLocation().x+1][Game.heroes.get(0).getLocation().y].setOnAction(null);
                //newherosetter(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y);
                Hero medic = (Hero) Game.heroes.get(0);
                medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                for(int i=0;i<15;i++){
                    for(int j=0;j<15;j++){
                        if(Game.map[i][j].isVisible()){
                            maparray[i][j].setVisible(true);
                        }
                    }
                }
            } catch (MovementException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            }
            switch(Game.heroes.get(0).getName()){
                case "Joel Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    milleractionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    millerhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    millersupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    millervaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Miller");
                    break;
                case "Ellie Williams":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    williamsactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    williamhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    williamsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    williamvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Williams");
                    break;
                case"Tess":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tessactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tesshp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tesssupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tessvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Tess");
                    break;
                case"Riley Abel":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    rileyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    rileyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    rileysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    rileyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Riley");
                    break;
                case"Tommy Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tommyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tommyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tommysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tommyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Tommy");
                    break;
                case"Bill":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    billactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    billhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    billsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    billvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Bill");
                    break;
                case"David":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    davidactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    davidhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    davidsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    davidvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("David");
                    break;
                case"Henry Burell":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    henryactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    henryhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    henrysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    henryvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Henry");
                    break;
            }
            updater();
            if(Game.checkGameOver()){
                stage.setScene(gameoverscene);
                exitgame.setVisible(false);
                FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft2.setFromValue(0.0);
                ft2.setToValue(1.0);
                ft.play();
                delay(2000, () -> ft2.play());
                delay(2000, () -> exitgame.setVisible(true));
                ft2.play();
            }

        });
        up.setOnAction(e->{
            try {
                Hero currhero = Game.heroes.get(0);
                if(Game.heroes.get(0).getLocation().y-1>0) {
                    if (Game.map[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y - 1] instanceof TrapCell) {
                        String musicFile = "D:\\team127 milestone3\\src\\main\\resources\\trap.mp3";
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                        FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                        notification.setText("You hit a trap!");
                        ft = new FadeTransition(Duration.millis(3000), notification);
                        //ft.setFromValue(0.0);
                        //ft.setToValue(1.0);
                        //ft.play();
                        ft.setFromValue(1.0);
                        ft.setToValue(0.0);
                        FadeTransition finalFt = ft;
                        //delay(3000, () -> finalFt.play());
                        finalFt.play();
                    }
                }
                Game.heroes.get(0).move(Direction.LEFT);
                if(!Game.heroes.contains(currhero)){
                    //notification.setText(currhero.getName() + " Died!");
                    if(!Game.heroes.isEmpty()) {
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 15; j++) {
                                if (Game.map[i][j] instanceof CharacterCell) {
                                    if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                                        newherosetter(i,j);
                                        Hero newhero = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                                        FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                                        //Auto picking a new hero
                                        switch (newhero.getName()){
                                            case "Joel Miller":
                                                notificationflag=true;
                                                Millermenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                FadeTransition finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case "Ellie Williams":
                                                notificationflag=true;
                                                Williamsmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tess":
                                                notificationflag=true;
                                                Tessmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Riley Abel":
                                                notificationflag=true;
                                                Rileymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tommy Miller":
                                                notificationflag=true;
                                                Tommymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Bill":
                                                notificationflag=true;
                                                Billmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"David":
                                                notificationflag=true;
                                                Davidmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Henry Burell":
                                                notificationflag=true;
                                                Henrymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                        }
                                        //Removing dead hero from the menu
                                        switch (currhero.getName()){
                                            case "Joel Miller":
                                                Millermenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                millerisdead=true;
                                                break;
                                            case "Ellie Williams":
                                                Williammenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                williamisdead=true;
                                                break;
                                            case"Tess":
                                                Tessmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tessisdead=true;
                                                break;
                                            case"Riley Abel":
                                                Rileymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                rileyisdead=true;
                                                break;
                                            case"Tommy Miller":
                                                Tommymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tommyisdead=true;
                                                break;
                                            case"Bill":
                                                Billmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                billisdead=true;
                                                break;
                                            case"David":
                                                Davidmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                davidisdead=true;
                                                break;
                                            case"Henry Burell":
                                                Henrymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                henryisdead=true;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        maparray[currhero.getLocation().x][currhero.getLocation().y].setId("CharacterCell");
                        stage.setScene(gameoverscene);
                        exitgame.setVisible(false);
                        FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                        FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                        ft.setFromValue(0.0);
                        ft.setToValue(1.0);
                        ft2.setFromValue(0.0);
                        ft2.setToValue(1.0);
                        ft.play();
                        delay(2000, () -> ft2.play());
                        delay(2000, () -> exitgame.setVisible(true));
                        ft2.play();
                    }
                    //delay(3000, () -> notification.setText(null));
                }
                maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y+1].setId("CharacterCell");
                maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y+1].setOnAction(null);
                //newherosetter(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y);
                Hero medic = (Hero) Game.heroes.get(0);
                medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                for(int i=0;i<15;i++){
                    for(int j=0;j<15;j++){
                        if(Game.map[i][j].isVisible()){
                            maparray[i][j].setVisible(true);
                        }
                    }
                }
            } catch (MovementException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            }
            switch(Game.heroes.get(0).getName()){
                case "Joel Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    milleractionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    millerhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    millersupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    millervaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Miller");
                    break;
                case "Ellie Williams":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    williamsactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    williamhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    williamsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    williamvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Williams");
                    break;
                case"Tess":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tessactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tesshp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tesssupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tessvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Tess");
                    break;
                case"Riley Abel":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    rileyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    rileyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    rileysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    rileyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Riley");
                    break;
                case"Tommy Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tommyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tommyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tommysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tommyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Tommy");
                    break;
                case"Bill":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    billactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    billhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    billsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    billvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Bill");
                    break;
                case"David":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    davidactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    davidhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    davidsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    davidvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("David");
                    break;
                case"Henry Burell":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    henryactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    henryhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    henrysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    henryvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Henry");
                    break;
            }
            updater();
            if(Game.checkGameOver()){
                stage.setScene(gameoverscene);
                exitgame.setVisible(false);
                FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft2.setFromValue(0.0);
                ft2.setToValue(1.0);
                ft.play();
                delay(2000, () -> ft2.play());
                delay(2000, () -> exitgame.setVisible(true));
                ft2.play();
            }

        });
        down.setOnAction(e->{
            try {
                Hero currhero = Game.heroes.get(0);
                if(Game.heroes.get(0).getLocation().y+1<15) {
                    if (Game.map[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y + 1] instanceof TrapCell) {
                        String musicFile = "D:\\team127 milestone3\\src\\main\\resources\\trap.mp3";
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                        FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                        notification.setText("You hit a trap!");
                        ft = new FadeTransition(Duration.millis(3000), notification);
                        //ft.setFromValue(0.0);
                        //ft.setToValue(1.0);
                        //ft.play();
                        ft.setFromValue(1.0);
                        ft.setToValue(0.0);
                        FadeTransition finalFt = ft;
                        //delay(3000, () -> finalFt.play());
                        finalFt.play();
                    }
                }
                Game.heroes.get(0).move(Direction.RIGHT);
                if(!Game.heroes.contains(currhero)){
                    //notification.setText(currhero.getName() + " Died!");
                    if(!Game.heroes.isEmpty()) {
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 15; j++) {
                                if (Game.map[i][j] instanceof CharacterCell) {
                                    if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                                        newherosetter(i,j);
                                        Hero newhero = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                                        FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                                        //Auto picking a new hero
                                        switch (newhero.getName()){
                                            case "Joel Miller":
                                                notificationflag=true;
                                                Millermenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                FadeTransition finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case "Ellie Williams":
                                                notificationflag=true;
                                                Williamsmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tess":
                                                notificationflag=true;
                                                Tessmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Riley Abel":
                                                notificationflag=true;
                                                Rileymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tommy Miller":
                                                notificationflag=true;
                                                Tommymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Bill":
                                                notificationflag=true;
                                                Billmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"David":
                                                notificationflag=true;
                                                Davidmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Henry Burell":
                                                notificationflag=true;
                                                Henrymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                        }
                                        //Removing dead hero from the menu
                                        switch (currhero.getName()){
                                            case "Joel Miller":
                                                Millermenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                millerisdead=true;
                                                break;
                                            case "Ellie Williams":
                                                Williammenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                williamisdead=true;
                                                break;
                                            case"Tess":
                                                Tessmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tessisdead=true;
                                                break;
                                            case"Riley Abel":
                                                Rileymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                rileyisdead=true;
                                                break;
                                            case"Tommy Miller":
                                                Tommymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tommyisdead=true;
                                                break;
                                            case"Bill":
                                                Billmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                billisdead=true;
                                                break;
                                            case"David":
                                                Davidmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                davidisdead=true;
                                                break;
                                            case"Henry Burell":
                                                Henrymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                henryisdead=true;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        maparray[currhero.getLocation().x][currhero.getLocation().y].setId("CharacterCell");
                        stage.setScene(gameoverscene);
                        exitgame.setVisible(false);
                        FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                        FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                        ft.setFromValue(0.0);
                        ft.setToValue(1.0);
                        ft2.setFromValue(0.0);
                        ft2.setToValue(1.0);
                        ft.play();
                        delay(2000, () -> ft2.play());
                        delay(2000, () -> exitgame.setVisible(true));
                        ft2.play();
                    }
                    //delay(3000, () -> notification.setText(null));
                }
                maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y-1].setId("CharacterCell");
                maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y-1].setOnAction(null);
                //newherosetter(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y);
                    Hero medic = (Hero) Game.heroes.get(0);
                    medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                for(int i=0;i<15;i++){
                    for(int j=0;j<15;j++){
                        if(Game.map[i][j].isVisible()){
                            maparray[i][j].setVisible(true);
                        }
                    }
                }
            } catch (MovementException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            }
            switch(Game.heroes.get(0).getName()){
                case "Joel Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    milleractionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    millerhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    millersupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    millervaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Miller");
                    break;
                case "Ellie Williams":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    williamsactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    williamhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    williamsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    williamvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Williams");
                    break;
                case"Tess":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tessactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tesshp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tesssupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tessvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Tess");
                    break;
                case"Riley Abel":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    rileyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    rileyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    rileysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    rileyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Riley");
                    break;
                case"Tommy Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tommyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tommyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tommysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tommyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Tommy");
                    break;
                case"Bill":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    billactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    billhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    billsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    billvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Bill");
                    break;
                case"David":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    davidactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    davidhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    davidsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    davidvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("David");
                    break;
                case"Henry Burell":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    henryactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    henryhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    henrysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    henryvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());
                    maparray[Game.heroes.get(0).getLocation().x][Game.heroes.get(0).getLocation().y].setId("Henry");
                    break;
            }
            updater();
            if(Game.checkGameOver()){
                stage.setScene(gameoverscene);
                exitgame.setVisible(false);
                FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft2.setFromValue(0.0);
                ft2.setToValue(1.0);
                ft.play();
                delay(2000, () -> ft2.play());
                delay(2000, () -> exitgame.setVisible(true));
                ft2.play();
            }

        });
        attack=new Button();
        attack.setId("attack");
        attack.setPrefSize(150,150);
        usespecial = new Button();
        usespecial.setId("usespecial");
        usespecial.setPrefSize(150,150);
        usevaccine = new Button();
        usevaccine.setId("usevaccine");
        usevaccine.setPrefSize(150,150);
        Endturn = new Button("End Turn");
        Endturn.setPrefSize(150, 150);
        Endturn.setId("endturn");
        //gameoverbox.getChildren().add(gameoverimg);
        attack.setOnAction(e ->{
            try {
                if(Game.heroes.get(0).getTarget() instanceof Hero){

                }
                String musicFile = "D:\\team127 milestone3\\src\\main\\resources\\gunshot.mp3";
                Media sound = new Media(new File(musicFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                Hero currhero = Game.heroes.get(0);
                Game.heroes.get(0).attack();
                if(!Game.heroes.contains(currhero)){
                    //notification.setText(currhero.getName() + " Died!");
                    if(!Game.heroes.isEmpty()) {
                        for (int i = 0; i < 15; i++) {
                            for (int j = 0; j < 15; j++) {
                                if (Game.map[i][j] instanceof CharacterCell) {
                                    if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                                        newherosetter(i,j);
                                        Hero newhero = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                                        FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                                        //Auto picking a new hero
                                        switch (newhero.getName()){
                                            case "Joel Miller":
                                                notificationflag=true;
                                                Millermenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                FadeTransition finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case "Ellie Williams":
                                                notificationflag=true;
                                                Williamsmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tess":
                                                notificationflag=true;
                                                Tessmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Riley Abel":
                                                notificationflag=true;
                                                Rileymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Tommy Miller":
                                                notificationflag=true;
                                                Tommymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Bill":
                                                notificationflag=true;
                                                Billmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"David":
                                                notificationflag=true;
                                                Davidmenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                            case"Henry Burell":
                                                notificationflag=true;
                                                Henrymenubutton.fire();
                                                notification.setText(currhero.getName() + " Died!");
                                                ft = new FadeTransition(Duration.millis(1000), notification);
                                                ft.setFromValue(0.0);
                                                ft.setToValue(1.0);
                                                ft.play();
                                                ft.setFromValue(1.0);
                                                ft.setToValue(0.0);
                                                finalFt = ft;
                                                delay(3000, () -> finalFt.play());
                                                break;
                                        }
                                        //Removing dead hero from the menu
                                        switch (currhero.getName()){
                                            case "Joel Miller":
                                                Millermenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                millerisdead=true;
                                                break;
                                            case "Ellie Williams":
                                                Williammenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                williamisdead=true;
                                                break;
                                            case"Tess":
                                                Tessmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tessisdead=true;
                                                break;
                                            case"Riley Abel":
                                                Rileymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                rileyisdead=true;
                                                break;
                                            case"Tommy Miller":
                                                Tommymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                tommyisdead=true;
                                                break;
                                            case"Bill":
                                                Billmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                billisdead=true;
                                                break;
                                            case"David":
                                                Davidmenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                davidisdead=true;
                                                break;
                                            case"Henry Burell":
                                                Henrymenubox.getChildren().clear();
                                                mainmap.setLeft(heromenu);
                                                henryisdead=true;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        maparray[currhero.getLocation().x][currhero.getLocation().y].setId("CharacterCell");
                        //game over scene
                        //add transition
                        stage.setScene(gameoverscene);
                        exitgame.setVisible(false);
                        FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                        FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                        ft.setFromValue(0.0);
                        ft.setToValue(1.0);
                        ft2.setFromValue(0.0);
                        ft2.setToValue(1.0);
                        ft.play();
                        delay(2000, () -> ft2.play());
                        delay(2000, () -> exitgame.setVisible(true));
                        ft2.play();
                        //end of game over scene
                        //alertnoheroes.showAndWait();
                        //stage.close();
                        return;
                    }
                    //delay(3000, () -> notification.setText(null));
                }
            } catch (InvalidTargetException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            }
            switch(Game.heroes.get(0).getName()){
                case "Joel Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    millernewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    milleractionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    millerhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    millersupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case "Ellie Williams":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    williamnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    williamsactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    williamhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    williamsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Tess":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tessnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    tessactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tesshp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tesssupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Riley Abel":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    rileynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    rileyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    rileyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    rileysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Tommy Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tommynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    tommyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tommyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tommysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Bill":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    billnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    billactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    billhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    billsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"David":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    davidnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    davidactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    davidhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    davidsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Henry Burell":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    henrynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                    henryactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    henryhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    henrysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
            }
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter()==null){
                            maparray[i][j].setId("CharacterCell");
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                        } {

                        }
                    }
                }
            }
            updater();
            if(Game.heroes.get(0).getTarget()!=null) {
                if (Game.heroes.get(0).getTarget().getCurrentHp() == 0) {
                    String musicFile = "D:\\team127 milestone3\\src\\main\\resources\\zombiedie.wav";
                    Media sound = new Media(new File(musicFile).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    Game.heroes.get(0).setTarget(null);
                }
            }
        });
        usespecial.setOnAction(e ->{
            try {
                Game.heroes.get(0).useSpecial();
            } catch (NoAvailableResourcesException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            } catch (InvalidTargetException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            }
            switch(Game.heroes.get(0).getName()){
                case "Joel Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    milleractionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    millerhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    millersupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case "Ellie Williams":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    williamsactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    williamhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    williamsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Tess":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tessactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tesshp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tesssupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    for(int i=0;i<15;i++){
                        for(int j=0;j<15;j++){
                            if(Game.map[i][j].isVisible()){
                                maparray[i][j].setVisible(true);
                            }
                        }
                    }
                    break;
                case"Riley Abel":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    rileyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    rileyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    rileysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    for(int i=0;i<15;i++){
                        for(int j=0;j<15;j++){
                            if(Game.map[i][j].isVisible()){
                                maparray[i][j].setVisible(true);
                            }
                        }
                    }
                    break;
                case"Tommy Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tommyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tommyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tommysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    for(int i=0;i<15;i++){
                        for(int j=0;j<15;j++){
                            if(Game.map[i][j].isVisible()){
                                maparray[i][j].setVisible(true);
                            }
                        }
                    }
                    break;
                case"Bill":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    billactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    billhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    billsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"David":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    davidactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    davidhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    davidsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Henry Burell":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    henryactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    henryhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    henrysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
            }
        });
        usevaccine.setOnAction(e ->{
            try {
                String musicFile = "D:\\team127 milestone3\\src\\main\\resources\\vaccine.mp3";
                Media sound = new Media(new File(musicFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                Game.heroes.get(0).cure();
                CharacterCell x = (CharacterCell)Game.map[Game.heroes.get(0).getTarget().getLocation().x][Game.heroes.get(0).getTarget().getLocation().y];
                setterfix(maparray[Game.heroes.get(0).getTarget().getLocation().x][Game.heroes.get(0).getTarget().getLocation().y],Game.heroes.get(0).getTarget().getLocation().x,Game.heroes.get(0).getTarget().getLocation().y);
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(x.getCharacter().getName() + " is cured!");
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                for(int i=0;i<15;i++){
                    for(int j=0;j<15;j++){
                        if(Game.map[i][j] instanceof CharacterCell){
                            if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero){
                                newherosetter(i,j);
                            }
                        }
                    }
                }
                Game.heroes.get(0).setTarget(null);
            } catch (InvalidTargetException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            } catch (NoAvailableResourcesException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                FadeTransition ft = new FadeTransition(Duration.millis(1000), notification);
                notification.setText(ex.getMessage());
                ft = new FadeTransition(Duration.millis(3000), notification);
                //ft.setFromValue(0.0);
                //ft.setToValue(1.0);
                //ft.play();
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                FadeTransition finalFt = ft;
                //delay(3000, () -> finalFt.play());
                finalFt.play();
                throw new RuntimeException(ex);
            }
            updater();
            switch(Game.heroes.get(0).getName()){
                case "Joel Miller":
                    milleractionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    millerhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    millersupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    millervaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());

                    break;
                case "Ellie Williams":
                    williamsactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    williamhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    williamsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    williamvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());

                    break;
                case"Tess":
                    tessactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tesshp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tesssupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tessvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());

                    break;
                case"Riley Abel":
                    rileyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    rileyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    rileysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    rileyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());

                    break;
                case"Tommy Miller":
                    tommyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tommyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tommysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    tommyvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());

                    break;
                case"Bill":
                    billactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    billhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    billsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    billvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());

                    break;
                case"David":
                    davidactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    davidhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    davidsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    davidvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());

                    break;
                case"Henry Burell":
                    henryactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    henryhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    henrysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    henryvaccine.setText("Vaccines Carried: "+Game.heroes.get(0).getVaccineInventory().size());

                    break;
            }
            if(Game.checkWin()){
                stage.setScene(gameoverscene);
                exitgame.setVisible(false);
                gameovertext.setText("You Won!");
                FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft2.setFromValue(0.0);
                ft2.setToValue(1.0);
                ft.play();
                delay(2000, () -> ft2.play());
                delay(2000, () -> exitgame.setVisible(true));
                ft2.play();

            }
            if(Game.checkGameOver()){
                stage.setScene(gameoverscene);
                exitgame.setVisible(false);
                FadeTransition ft = new FadeTransition(Duration.millis(2000), gameovertext);
                FadeTransition ft2 = new FadeTransition(Duration.millis(1000), exitgame);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft2.setFromValue(0.0);
                ft2.setToValue(1.0);
                ft.play();
                delay(2000, () -> ft2.play());
                delay(2000, () -> exitgame.setVisible(true));
                ft2.play();
            }


        });
        Endturn.setOnAction(e->{
            try {
                Hero currhero = Game.heroes.get(0);
                Game.endTurn();
                for(int i=0;i<15;i++){
                    for(int j=0;j<15;j++){
                        if(Game.map[i][j].isVisible()){
                            maparray[i][j].setVisible(true);
                        }
                    }
                }
            } catch (NotEnoughActionsException ex) {
                throw new RuntimeException(ex);
            } catch (InvalidTargetException ex) {
                throw new RuntimeException(ex);
            }
            switch(Game.heroes.get(0).getName()){
                case "Joel Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    milleractionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    millerhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    millersupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case "Ellie Williams":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    williamsactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    williamhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    williamsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Tess":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tessactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tesshp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tesssupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Riley Abel":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    rileyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    rileyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    rileysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Tommy Miller":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    tommyactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    tommyhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    tommysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Bill":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    billactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    billhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    billsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"David":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    davidactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    davidhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    davidsupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
                case"Henry Burell":
                    hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                    henryactionsav.setText("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                    henryhp.setText("Curren Health: "+Game.heroes.get(0).getCurrentHp());
                    henrysupply.setText("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                    break;
            }
            updater();
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                }
            }
//            for(int i=0;i<15;i++){
//                for(int j=0;j<15;j++){
//                    if(Game.map[i][j] instanceof CharacterCell){
//                        if(((CharacterCell) Game.map[i][j]).getCharacter()==null){
//                            maparray[i][j].setId("CharacterCell");
//                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
//                            maparray[i][j].setId("Zombie");
//                        } {
//
//                        }
//                    }
//                }
//            }
        });
        Endturn.setStyle("-fx-font-size:20");
        Button emptybtn=new Button();
        Button testmove = new Button("test");
        emptybtn.setVisible(false);
        emptybtn.setPrefSize(400,150);
        testarrows.add(left,0,1);
        testarrows.add(down,1,1);
        testarrows.add(right,2,1);
        testarrows.add(up,1,0);
        control.setSpacing(2);
        control.getChildren().addAll(Endturn,attack,usespecial,usevaccine, testarrows);
        control.getStylesheets().add("Styling.css");
        control.setId("controlhud");
        //control.setMaxWidth(800);
        control.setAlignment(Pos.CENTER);
        mainmap.setBottom(control);
        //Hero Menu
        heromenu =new VBox();
        heromenu.getStylesheets().add("Styling.css");
        heromenu.setId("heromenuhud");
        heromenu.setSpacing(7);
        mainmap.setLeft(heromenu);
//        BackgroundImage myBI= new BackgroundImage(new Image("blackimage.jpg",32,32,false,true),
//                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//                BackgroundSize.DEFAULT);
//        mainmap.setBackground(new Background(myBI));
        stage.show();

    }

    private void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }
    private void animateUsingTimeline(Label heart) {
        DoubleProperty scale = new SimpleDoubleProperty(1);
        heart.scaleXProperty().bind(scale);
        heart.scaleYProperty().bind(scale);

        Timeline beat = new Timeline(
                new KeyFrame(Duration.ZERO,         event -> scale.setValue(1)),
                new KeyFrame(Duration.seconds(0.5), event -> scale.setValue(1.1))
        );
        beat.setAutoReverse(true);
        beat.setCycleCount(Timeline.INDEFINITE);
        beat.play();
    }

    private void animateUsingScaleTransition(Label heart) {
        ScaleTransition scaleTransition = new ScaleTransition(
                Duration.seconds(1), heart
        );
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setFromZ(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setToZ(1.1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.play();
    }
public void setterfix(Button x,int i,int j){
        //if(Game.map[i][j] instanceof CharacterCell) {
            Hero amr = (Hero)((CharacterCell) Game.map[i][j]).getCharacter();
        //}
        x.setOnAction(e->{
            Game.heroes.get(0).setTarget(amr);
        });
    }
    public void buttonfire(Button s,String name){
        s.setOnAction(e->{       switch(name){
            case"Miller":Miller.fire();
                break;
            case"Williams":Williams.fire();
                break;
            case"Tess":Tess.fire();
                break;
            case"Riley":Riley.fire();
                break;
            case"Tommy":Tommy.fire();
                break;
            case"Bill":Bill.fire();
            break;
            case"David":David.fire();
            break;
            case"Henry":Henry.fire();
            break;
        }});

    }
    @Override
    public void handle(Event event) {
        if(event.getSource()==Miller){
            Game.startGame(Game.availableHeroes.get(0));

//            FadeTransition ft = new FadeTransition(Duration.millis(4000), mapgrid);
//            ft.setFromValue(0.0);
//            ft.setToValue(1.0);
            stage.setScene(map);
            hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setId("hpbar");
            //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setPrefSize(250,30);
            millernewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
//            ft.play();
//            Rectangle healthbar = new Rectangle(200.0, 50.0, Color.RED);
//            DoubleProperty healthpercentage;
//            healthpercentage= new SimpleDoubleProperty(Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
//            DoubleBinding b1 = healthbar.widthProperty().multiply(healthpercentage);
//            healthbar.widthProperty().bind(b1);
            millerhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
            milleractionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
            millerhp.setId("HudCurrHP");
            milleractionsav.setId("HerohudInfoStyle");
            millersupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
            millersupply.setId("HerohudInfoStyle");
            millervaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
            millervaccine.setId("HerohudInfoStyle");
            heromenu.getChildren().addAll(Williammenubox,Tessmenubox,Rileymenubox,Tommymenubox,Billmenubox,Davidmenubox,Henrymenubox);
            VBox millerhudicon = new VBox();
            millerhudicon.getChildren().addAll(miller,Millermenubutton);
            millerhudicon.setAlignment(Pos.CENTER);
            millerhudicon.setSpacing(5);
            herohud.getChildren().addAll(millerhudicon,millerType,millerattackdmg,milleractionsav,millersupply,millervaccine,hpbar);
            herohud.setAlignment(Pos.CENTER);
            //hphud.getChildren().addAll(hpbar);
            maparray =new Button[15][15];
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    maparray[i][j]=new Button();
                    maparray[i][j].setPrefSize(50,50);
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                            Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                            maparray[i][j].setOnAction(e ->{
                                Game.heroes.get(0).setTarget(zombie);
                            });
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                            Hero medic = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                            medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                            maparray[i][j].setId("Miller");
                        }
                        else{
                            maparray[i][j].setId("CharacterCell");
                        }
                    }
                    if(Game.map[i][j] instanceof TrapCell){
                        maparray[i][j].setId("TrapCell");
                    }
                    if(Game.map[i][j] instanceof CollectibleCell){
                        if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
                            maparray[i][j].setId("Supply");
                        } else if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
                            maparray[i][j].setId("Vaccine");
                        }
                    }
                    mapgrid.add(maparray[i][j],i,j);

                }
            }
            CharacterCell x = (CharacterCell) Game.map[0][0];
            Hero heroamr=(Hero)x.getCharacter();
            newherosetter(0,0);
        }
        if(event.getSource()==Williams){
            Game.startGame(Game.availableHeroes.get(1));
            williamnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
            stage.setScene(map);
            hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setId("hpbar");
            //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setPrefSize(250,30);
            williamhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
            williamhp.setId("HudCurrHP");
            williamsactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
            williamsupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
            williamsactionsav.setId("HerohudInfoStyle");
            williamsupply.setId("HerohudInfoStyle");
            williamvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
            williamvaccine.setId("HerohudInfoStyle");
            heromenu.getChildren().addAll(Millermenubox,Tessmenubox,Rileymenubox,Tommymenubox,Billmenubox,Davidmenubox,Henrymenubox);
            VBox williamhudicon = new VBox();
            williamhudicon.setAlignment(Pos.CENTER);
            williamhudicon.getChildren().addAll(williams,Williamsmenubutton);
            williamhudicon.setSpacing(5);
            herohud.getChildren().addAll(williamhudicon,williamType,williamattackdmg,williamsactionsav,williamsupply,williamvaccine,hpbar);
            herohud.setAlignment(Pos.CENTER);
            //hphud.getChildren().addAll(hpbar);
            maparray =new Button[15][15];
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    maparray[i][j]=new Button();
                    maparray[i][j].setPrefSize(50,50);
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                            Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                            maparray[i][j].setOnAction(e ->{
                                Game.heroes.get(0).setTarget(zombie);
                            });
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                                Hero medic = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                                medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                            newherosetter(i,j);
                            maparray[i][j].setId("Williams");
                        }
                        else{
                            maparray[i][j].setId("CharacterCell");
                        }
                    }
                    if(Game.map[i][j] instanceof TrapCell){
                        maparray[i][j].setId("TrapCell");
                    }
                    if(Game.map[i][j] instanceof CollectibleCell){
                        if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
                            maparray[i][j].setId("Supply");
                        } else if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
                            maparray[i][j].setId("Vaccine");
                        }
                    }
                    mapgrid.add(maparray[i][j],i,j);

                }
            }
            newherosetter(0,0);
        }
        if(event.getSource()==Tess){
            Game.startGame(Game.availableHeroes.get(2));
            tessnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
            hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setId("hpbar");
            //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setPrefSize(250,30);
            stage.setScene(map);
            tesshp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
            tesssupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
            tessactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
            tesshp.setId("HudCurrHP");
            tessactionsav.setId("HerohudInfoStyle");
            tesssupply.setId("HerohudInfoStyle");
            tessvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
            tessvaccine.setId("HerohudInfoStyle");
            heromenu.getChildren().addAll(Millermenubox,Williammenubox,Rileymenubox,Tommymenubox,Billmenubox,Davidmenubox,Henrymenubox);
            VBox tesshudicon = new VBox();
            tesshudicon.setAlignment(Pos.CENTER);
            tesshudicon.getChildren().addAll(tess,Tessmenubutton);
            tesshudicon.setSpacing(5);
            herohud.getChildren().addAll(tesshudicon,tessType,tessattackdmg,tessactionsav,tesssupply,tessvaccine,hpbar);
            herohud.setAlignment(Pos.CENTER);
            //hphud.getChildren().addAll(hpbar);
            maparray =new Button[15][15];
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    maparray[i][j]=new Button();
                    maparray[i][j].setPrefSize(50,50);
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                            Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                            maparray[i][j].setOnAction(e ->{
                                Game.heroes.get(0).setTarget(zombie);
                            });
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                            Hero medic = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                            medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                            maparray[i][j].setId("Tess");
                            newherosetter(i,j);
                        }
                        else{
                            maparray[i][j].setId("CharacterCell");
                        }
                    }
                    if(Game.map[i][j] instanceof TrapCell){
                        maparray[i][j].setId("TrapCell");
                    }
                    if(Game.map[i][j] instanceof CollectibleCell){
                        if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
                            maparray[i][j].setId("Supply");
                        } else if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
                            maparray[i][j].setId("Vaccine");
                        }
                    }
                    mapgrid.add(maparray[i][j],i,j);

                }
            }
            newherosetter(0,0);
        }
        if(event.getSource()==Riley){
            Game.startGame(Game.availableHeroes.get(3));
            rileynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
            hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setPrefSize(250,30);
            hpbar.setId("hpbar");
            stage.setScene(map);
            rileyhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
            rileyactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
            rileyhp.setId("HudCurrHP");
            rileyactionsav.setId("HerohudInfoStyle");
            rileysupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
            rileysupply.setId("HerohudInfoStyle");
            rileyvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
            rileyvaccine.setId("HerohudInfoStyle");
            heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Tommymenubox,Billmenubox,Davidmenubox,Henrymenubox);
            VBox rileyhudicon = new VBox();
            rileyhudicon.setAlignment(Pos.CENTER);
            rileyhudicon.getChildren().addAll(riley,Rileymenubutton);
            rileyhudicon.setSpacing(5);
            herohud.getChildren().addAll(rileyhudicon,rileyType,rileyattackdmg,rileyactionsav,rileysupply,rileyvaccine,hpbar);
            herohud.setAlignment(Pos.CENTER);
            //hphud.getChildren().addAll(hpbar);
            maparray =new Button[15][15];
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    maparray[i][j]=new Button();
                    maparray[i][j].setPrefSize(50,50);
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                            Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                            maparray[i][j].setOnAction(e ->{
                                Game.heroes.get(0).setTarget(zombie);
                            });
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                            Hero medic = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                            medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                            maparray[i][j].setId("Riley");
                            newherosetter(i,j);
                        }
                        else{
                            maparray[i][j].setId("CharacterCell");
                        }
                    }
                    if(Game.map[i][j] instanceof TrapCell){
                        maparray[i][j].setId("TrapCell");
                    }
                    if(Game.map[i][j] instanceof CollectibleCell){
                        if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
                            maparray[i][j].setId("Supply");
                        } else if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
                            maparray[i][j].setId("Vaccine");
                        }
                    }
                    mapgrid.add(maparray[i][j],i,j);

                }
            }
            newherosetter(0,0);
        }
        if(event.getSource()==Tommy){
            Game.startGame(Game.availableHeroes.get(4));
            tommynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
            hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setId("hpbar");
            //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setPrefSize(250,30);
            stage.setScene(map);
            tommyhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
            tommyactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
            tommyhp.setId("HudCurrHP");
            tommyactionsav.setId("HerohudInfoStyle");
            tommysupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
            tommysupply.setId("HerohudInfoStyle");
            tommyvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
            tommyvaccine.setId("HerohudInfoStyle");
            heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Rileymenubox,Billmenubox,Davidmenubox,Henrymenubox);
            VBox tommyhudicon = new VBox();
            tommyhudicon.setAlignment(Pos.CENTER);
            tommyhudicon.getChildren().addAll(tommy,Tommymenubutton);
            tommyhudicon.setSpacing(5);
            herohud.getChildren().addAll(tommyhudicon,tommyType,tommyattackdmg,tommyactionsav,tommysupply,tommyvaccine,hpbar);
            herohud.setAlignment(Pos.CENTER);
            //hphud.getChildren().addAll(hpbar);
            maparray =new Button[15][15];
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    maparray[i][j]=new Button();
                    maparray[i][j].setPrefSize(50,50);
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                            Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                            maparray[i][j].setOnAction(e ->{
                                Game.heroes.get(0).setTarget(zombie);
                            });
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                            Hero medic = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                            medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                            maparray[i][j].setId("Tommy");
                            newherosetter(i,j);
                        }
                        else{
                            maparray[i][j].setId("CharacterCell");
                        }
                    }
                    if(Game.map[i][j] instanceof TrapCell){
                        maparray[i][j].setId("TrapCell");
                    }
                    if(Game.map[i][j] instanceof CollectibleCell){
                        if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
                            maparray[i][j].setId("Supply");
                        } else if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
                            maparray[i][j].setId("Vaccine");
                        }
                    }
                    mapgrid.add(maparray[i][j],i,j);

                }
            }
            newherosetter(0,0);
        }
        if(event.getSource()==Bill){
            Game.startGame(Game.availableHeroes.get(5));
            billnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
            hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setId("hpbar");
            //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setPrefSize(250,30);
            stage.setScene(map);
            billhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
            billactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
            billhp.setId("HudCurrHP");
            billactionsav.setId("HerohudInfoStyle");
            billsupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
            billsupply.setId("HerohudInfoStyle");
            billvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
            billvaccine.setId("HerohudInfoStyle");
            heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Rileymenubox,Tommymenubox,Davidmenubox,Henrymenubox);
            VBox billhudicon = new VBox();
            billhudicon.setAlignment(Pos.CENTER);
            billhudicon.getChildren().addAll(bill,Billmenubutton);
            billhudicon.setSpacing(5);
            herohud.getChildren().addAll(billhudicon,billType,billattackdmg,billactionsav,billsupply,billvaccine,hpbar);
            herohud.setAlignment(Pos.CENTER);
            //hphud.getChildren().addAll(hpbar);
            maparray =new Button[15][15];
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    maparray[i][j]=new Button();
                    maparray[i][j].setPrefSize(50,50);
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                            Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                            maparray[i][j].setOnAction(e ->{
                                Game.heroes.get(0).setTarget(zombie);
                            });
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                            Hero medic = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                            medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                            maparray[i][j].setId("Bill");
                            newherosetter(i,j);
                        }
                        else{
                            maparray[i][j].setId("CharacterCell");
                        }
                    }
                    if(Game.map[i][j] instanceof TrapCell){
                        maparray[i][j].setId("TrapCell");
                    }
                    if(Game.map[i][j] instanceof CollectibleCell){
                        if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
                            maparray[i][j].setId("Supply");
                        } else if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
                            maparray[i][j].setId("Vaccine");
                        }
                    }
                    mapgrid.add(maparray[i][j],i,j);

                }
            }
            newherosetter(0,0);
        }
        if(event.getSource()==David){
            Game.startGame(Game.availableHeroes.get(6));
            davidnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
            hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setId("hpbar");
            //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setPrefSize(250,30);
            stage.setScene(map);
            davidhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
            davidactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
            davidhp.setId("HudCurrHP");
            davidactionsav.setId("HerohudInfoStyle");
            davidsupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
            davidsupply.setId("HerohudInfoStyle");
            davidvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
            davidvaccine.setId("HerohudInfoStyle");
            heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Rileymenubox,Tommymenubox,Billmenubox,Henrymenubox);
            VBox davidhudicon = new VBox();
            davidhudicon.setAlignment(Pos.CENTER);
            davidhudicon.getChildren().addAll(david,Davidmenubutton);
            davidhudicon.setSpacing(5);
            herohud.getChildren().addAll(davidhudicon,davidType,davidattackdmg,davidactionsav,davidsupply,davidvaccine,hpbar);
            herohud.setAlignment(Pos.CENTER);
            //hphud.getChildren().addAll(hpbar);
            maparray =new Button[15][15];
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    maparray[i][j]=new Button();
                    maparray[i][j].setPrefSize(50,50);
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                            Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                            maparray[i][j].setOnAction(e ->{
                                Game.heroes.get(0).setTarget(zombie);
                            });
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                            Hero medic = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                            medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                            maparray[i][j].setId("David");
                            newherosetter(i,j);
                        }
                        else{
                            maparray[i][j].setId("CharacterCell");
                        }
                    }
                    if(Game.map[i][j] instanceof TrapCell){
                        maparray[i][j].setId("TrapCell");
                    }
                    if(Game.map[i][j] instanceof CollectibleCell){
                        if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
                            maparray[i][j].setId("Supply");
                        } else if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
                            maparray[i][j].setId("Vaccine");
                        }
                    }
                    mapgrid.add(maparray[i][j],i,j);

                }
            }
            newherosetter(0,0);
        }
        if(event.getSource()==Henry){
            Game.startGame(Game.availableHeroes.get(7));
            henrynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
            hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
            hpbar.setPrefSize(250,30);
            hpbar.setId("hpbar");
            stage.setScene(map);
            henryhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
            henryactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
            henryhp.setId("HudCurrHP");
            henryactionsav.setId("HerohudInfoStyle");
            henrysupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
            henrysupply.setId("HerohudInfoStyle");
            henryvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
            henryvaccine.setId("HerohudInfoStyle");
            heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Rileymenubox,Tommymenubox,Billmenubox,Davidmenubox);
            VBox henryhudicon = new VBox();
            henryhudicon.setAlignment(Pos.CENTER);
            henryhudicon.getChildren().addAll(henry,Henrymenubutton);
            henryhudicon.setSpacing(5);
            herohud.getChildren().addAll(henryhudicon,henryType,henryattackdmg,henryactionsav,henrysupply,henryvaccine,hpbar);
            herohud.setAlignment(Pos.CENTER);
            //hphud.getChildren().addAll(hpbar);
            maparray =new Button[15][15];
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    maparray[i][j]=new Button();
                    maparray[i][j].setPrefSize(50,50);
                    if(!Game.map[i][j].isVisible()){
                        maparray[i][j].setVisible(false);
                    }
                    if(Game.map[i][j] instanceof CharacterCell){
                        if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                            maparray[i][j].setId("Zombie");
                            Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                            maparray[i][j].setOnAction(e ->{
                                Game.heroes.get(0).setTarget(zombie);
                            });
                        } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
                            Hero medic = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
                            medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                            maparray[i][j].setId("Henry");
                            newherosetter(i,j);
                        }
                        else{
                            maparray[i][j].setId("CharacterCell");
                        }
                    }
                    if(Game.map[i][j] instanceof TrapCell){
                        maparray[i][j].setId("TrapCell");
                    }
                    if(Game.map[i][j] instanceof CollectibleCell){
                        if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
                            maparray[i][j].setId("Supply");
                        } else if(((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
                            maparray[i][j].setId("Vaccine");
                        }
                    }
                    mapgrid.add(maparray[i][j],i,j);

                }
            }
            newherosetter(0,0);
        }
        if(event.getSource()==startGame){
            FadeTransition ft = new FadeTransition(Duration.millis(1000), heroes);
            FadeTransition ft2 = new FadeTransition(Duration.millis(1000), selectherotest);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft2.setFromValue(0.0);
            ft2.setToValue(1.0);
            stage.setScene(select);
            ft.play();
            ft2.play();
            //stage.setFullScreen(true);
        }
    }
    public void updater(){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                if(Game.map[i][j] instanceof CharacterCell){
                    if(((CharacterCell) Game.map[i][j]).getCharacter()==null){
                        maparray[i][j].setId("CharacterCell");
                    } else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
                        Zombie zombie = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
                        maparray[i][j].setId("Zombie");
                        maparray[i][j].setOnAction(e -> {
                               Game.heroes.get(0).setTarget(zombie);
                          });
                    } else{
                            switch(((CharacterCell) Game.map[i][j]).getCharacter().getName()){
                                case "Joel Miller":
                                    maparray[i][j].setId("Miller");
                                    break;
                                case "Ellie Williams":
                                    maparray[i][j].setId("Williams");
                                    break;
                                case"Tess":
                                    maparray[i][j].setId("Tess");
                                    break;
                                case"Riley Abel":
                                    maparray[i][j].setId("Riley");
                                    break;
                                case"Tommy Miller":
                                    maparray[i][j].setId("Tommy");
                                    break;
                                case"Bill":
                                    maparray[i][j].setId("Bill");
                                    break;
                                case"David":
                                    maparray[i][j].setId("David");
                                    break;
                                case"Henry Burell":
                                    maparray[i][j].setId("Henry");
                                    break;
                            }
                    }
                }
            }
        }
    }
    public void medictarget(int i,int j,Hero medic){
        maparray[i][j].setOnAction(e -> {
            Game.heroes.get(0).setTarget(medic);
        });
    }
    public void newherosetter(int i,int j){//takes cured target location
        //System.out.println("herocured");
        if(Game.map[i][j] instanceof CharacterCell){
            Hero amr = (Hero)((CharacterCell) Game.map[i][j]).getCharacter();
            switch(amr.getName()){
                case "Joel Miller":

                    Millermenubutton.setOnAction(e->{
                        Millermenubox.getChildren().clear();
                        Williammenubox.getChildren().clear();
                        Tessmenubox.getChildren().clear();
                        Rileymenubox.getChildren().clear();
                        Tommymenubox.getChildren().clear();
                        Billmenubox.getChildren().clear();
                        Davidmenubox.getChildren().clear();
                        Henrymenubox.getChildren().clear();
                        if(!millerisdead)
                            Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
                        if(!williamisdead)
                            Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
                        if(!tessisdead)
                            Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
                        if(!rileyisdead)
                            Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
                        if(!tommyisdead)
                            Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
                        if(!billisdead)
                            Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
                        if(!davidisdead)
                            Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
                        if(!henryisdead)
                            Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
                    Game.heroes.remove(amr);
                    Game.heroes.add(0,amr);
                        herohud.getChildren().clear();
                        hphud.getChildren().clear();
                        heromenu.getChildren().clear();
                        hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setId("hpbar");
                        //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setPrefSize(250,30);
                        millernewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
//            ft.play();
//            Rectangle healthbar = new Rectangle(200.0, 50.0, Color.RED);
//            DoubleProperty healthpercentage;
//            healthpercentage= new SimpleDoubleProperty(Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
//            DoubleBinding b1 = healthbar.widthProperty().multiply(healthpercentage);
//            healthbar.widthProperty().bind(b1);
                        millerhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
                        milleractionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                        millerhp.setId("HudCurrHP");
                        milleractionsav.setId("HerohudInfoStyle");
                        millersupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                        millersupply.setId("HerohudInfoStyle");
                        millervaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
                        millervaccine.setId("HerohudInfoStyle");
                        heromenu.getChildren().addAll(Williammenubox,Tessmenubox,Rileymenubox,Tommymenubox,Billmenubox,Davidmenubox,Henrymenubox);
                        VBox millerhudicon = new VBox();
                        millerhudicon.getChildren().addAll(miller,Millermenubutton);
                        millerhudicon.setAlignment(Pos.CENTER);
                        millerhudicon.setSpacing(5);
                        herohud.getChildren().addAll(millerhudicon,millerType,millerattackdmg,milleractionsav,millersupply,millervaccine,hpbar);
                        herohud.setAlignment(Pos.CENTER);
                        //hphud.getChildren().addAll(hpbar);
                });
                    break;
                case "Ellie Williams":
                    Williamsmenubutton.setOnAction(e->{
                        Millermenubox.getChildren().clear();
                        Williammenubox.getChildren().clear();
                        Tessmenubox.getChildren().clear();
                        Rileymenubox.getChildren().clear();
                        Tommymenubox.getChildren().clear();
                        Billmenubox.getChildren().clear();
                        Davidmenubox.getChildren().clear();
                        Henrymenubox.getChildren().clear();
                        if(!millerisdead)
                            Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
                        if(!williamisdead)
                            Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
                        if(!tessisdead)
                            Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
                        if(!rileyisdead)
                            Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
                        if(!tommyisdead)
                            Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
                        if(!billisdead)
                            Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
                        if(!davidisdead)
                            Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
                        if(!henryisdead)
                            Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
                        Game.heroes.remove(amr);
                        Game.heroes.add(0,amr);
                        heromenu.getChildren().clear();
                        herohud.getChildren().clear();
                        hphud.getChildren().clear();
                        williamnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                        stage.setScene(map);
                        hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setId("hpbar");
                        //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setPrefSize(250,30);
                        williamhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
                        williamhp.setId("HudCurrHP");
                        williamsactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                        williamsupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                        williamsactionsav.setId("HerohudInfoStyle");
                        williamsupply.setId("HerohudInfoStyle");
                        williamvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
                        williamvaccine.setId("HerohudInfoStyle");
                        heromenu.getChildren().addAll(Millermenubox,Tessmenubox,Rileymenubox,Tommymenubox,Billmenubox,Davidmenubox,Henrymenubox);
                        VBox williamhudicon = new VBox();
                        williamhudicon.setAlignment(Pos.CENTER);
                        williamhudicon.getChildren().addAll(williams,Williamsmenubutton);
                        williamhudicon.setSpacing(5);
                        herohud.getChildren().addAll(williamhudicon,williamType,williamattackdmg,williamsactionsav,williamsupply,williamvaccine,hpbar);
                        herohud.setAlignment(Pos.CENTER);
                        //hphud.getChildren().addAll(hpbar);
                        Medic medic = (Medic) ((CharacterCell) Game.map[i][j]).getCharacter();
                        medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                    });
                        break;
                case"Tess":
                    Tessmenubutton.setOnAction(e->{
                        Millermenubox.getChildren().clear();
                        Williammenubox.getChildren().clear();
                        Tessmenubox.getChildren().clear();
                        Rileymenubox.getChildren().clear();
                        Tommymenubox.getChildren().clear();
                        Billmenubox.getChildren().clear();
                        Davidmenubox.getChildren().clear();
                        Henrymenubox.getChildren().clear();
                        if(!millerisdead)
                            Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
                        if(!williamisdead)
                            Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
                        if(!tessisdead)
                            Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
                        if(!rileyisdead)
                            Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
                        if(!tommyisdead)
                            Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
                        if(!billisdead)
                            Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
                        if(!davidisdead)
                            Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
                        if(!henryisdead)
                            Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
                        Game.heroes.remove(amr);
                        Game.heroes.add(0,amr);
                        heromenu.getChildren().clear();
                        herohud.getChildren().clear();
                        hphud.getChildren().clear();
                        tessnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                        hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setId("hpbar");
                        //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setPrefSize(250,30);
                        stage.setScene(map);
                        tesshp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
                        tesssupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                        tessactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                        tesshp.setId("HudCurrHP");
                        tessactionsav.setId("HerohudInfoStyle");
                        tesssupply.setId("HerohudInfoStyle");
                        tessvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
                        tessvaccine.setId("HerohudInfoStyle");
                        heromenu.getChildren().addAll(Millermenubox,Williammenubox,Rileymenubox,Tommymenubox,Billmenubox,Davidmenubox,Henrymenubox);
                        VBox tesshudicon = new VBox();
                        tesshudicon.setAlignment(Pos.CENTER);
                        tesshudicon.getChildren().addAll(tess,Tessmenubutton);
                        tesshudicon.setSpacing(5);
                        herohud.getChildren().addAll(tesshudicon,tessType,tessattackdmg,tessactionsav,tesssupply,tessvaccine,hpbar);
                        herohud.setAlignment(Pos.CENTER);
                        //hphud.getChildren().addAll(hpbar);
                    });
                    break;
                case "Riley Abel":
                    Rileymenubutton.setOnAction(e->{
                        Millermenubox.getChildren().clear();
                        Williammenubox.getChildren().clear();
                        Tessmenubox.getChildren().clear();
                        Rileymenubox.getChildren().clear();
                        Tommymenubox.getChildren().clear();
                        Billmenubox.getChildren().clear();
                        Davidmenubox.getChildren().clear();
                        Henrymenubox.getChildren().clear();
                        if(!millerisdead)
                            Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
                        if(!williamisdead)
                            Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
                        if(!tessisdead)
                            Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
                        if(!rileyisdead)
                            Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
                        if(!tommyisdead)
                            Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
                        if(!billisdead)
                            Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
                        if(!davidisdead)
                            Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
                        if(!henryisdead)
                            Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
                        Game.heroes.remove(amr);
                        Game.heroes.add(0,amr);
                        heromenu.getChildren().clear();
                        herohud.getChildren().clear();
                        hphud.getChildren().clear();
                        rileynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                        hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setPrefSize(250,30);
                        hpbar.setId("hpbar");
                        stage.setScene(map);
                        rileyhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
                        rileyactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                        rileyhp.setId("HudCurrHP");
                        rileyactionsav.setId("HerohudInfoStyle");
                        rileysupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                        rileysupply.setId("HerohudInfoStyle");
                        rileyvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
                        rileyvaccine.setId("HerohudInfoStyle");
                        heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Tommymenubox,Billmenubox,Davidmenubox,Henrymenubox);
                        VBox rileyhudicon = new VBox();
                        rileyhudicon.setAlignment(Pos.CENTER);
                        rileyhudicon.getChildren().addAll(riley,Rileymenubutton);
                        rileyhudicon.setSpacing(5);
                        herohud.getChildren().addAll(rileyhudicon,rileyType,rileyattackdmg,rileyactionsav,rileysupply,rileyvaccine,hpbar);
                        herohud.setAlignment(Pos.CENTER);
                        //hphud.getChildren().addAll(hpbar);
                    });
                    break;
                case "Tommy Miller":
                    Tommymenubutton.setOnAction(e->{
                        Millermenubox.getChildren().clear();
                        Williammenubox.getChildren().clear();
                        Tessmenubox.getChildren().clear();
                        Rileymenubox.getChildren().clear();
                        Tommymenubox.getChildren().clear();
                        Billmenubox.getChildren().clear();
                        Davidmenubox.getChildren().clear();
                        Henrymenubox.getChildren().clear();
                        if(!millerisdead)
                            Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
                        if(!williamisdead)
                            Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
                        if(!tessisdead)
                            Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
                        if(!rileyisdead)
                            Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
                        if(!tommyisdead)
                            Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
                        if(!billisdead)
                            Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
                        if(!davidisdead)
                            Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
                        if(!henryisdead)
                            Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
                        Game.heroes.remove(amr);
                        Game.heroes.add(0,amr);
                        heromenu.getChildren().clear();
                        herohud.getChildren().clear();
                        hphud.getChildren().clear();
                        tommynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                        hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setId("hpbar");
                        //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setPrefSize(250,30);
                        stage.setScene(map);
                        tommyhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
                        tommyactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                        tommyhp.setId("HudCurrHP");
                        tommyactionsav.setId("HerohudInfoStyle");
                        tommysupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                        tommysupply.setId("HerohudInfoStyle");
                        tommyvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
                        tommyvaccine.setId("HerohudInfoStyle");
                        heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Rileymenubox,Billmenubox,Davidmenubox,Henrymenubox);
                        VBox tommyhudicon = new VBox();
                        tommyhudicon.setAlignment(Pos.CENTER);
                        tommyhudicon.getChildren().addAll(tommy,Tommymenubutton);
                        tommyhudicon.setSpacing(5);
                        herohud.getChildren().addAll(tommyhudicon,tommyType,tommyattackdmg,tommyactionsav,tommysupply,tommyvaccine,hpbar);
                        herohud.setAlignment(Pos.CENTER);
                        //hphud.getChildren().addAll(hpbar);
                    });
                    break;
                case "Bill":
                    Billmenubutton.setOnAction(e->{
                        Millermenubox.getChildren().clear();
                        Williammenubox.getChildren().clear();
                        Tessmenubox.getChildren().clear();
                        Rileymenubox.getChildren().clear();
                        Tommymenubox.getChildren().clear();
                        Billmenubox.getChildren().clear();
                        Davidmenubox.getChildren().clear();
                        Henrymenubox.getChildren().clear();
                        if(!millerisdead)
                            Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
                        if(!williamisdead)
                            Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
                        if(!tessisdead)
                            Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
                        if(!rileyisdead)
                            Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
                        if(!tommyisdead)
                            Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
                        if(!billisdead)
                            Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
                        if(!davidisdead)
                            Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
                        if(!henryisdead)
                            Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
                        Game.heroes.remove(amr);
                        Game.heroes.add(0,amr);
                        heromenu.getChildren().clear();
                        herohud.getChildren().clear();
                        hphud.getChildren().clear();
                        billnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                        hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setId("hpbar");
                        //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setPrefSize(250,30);
                        stage.setScene(map);
                        billhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
                        billactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                        billhp.setId("HudCurrHP");
                        billactionsav.setId("HerohudInfoStyle");
                        billsupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                        billsupply.setId("HerohudInfoStyle");
                        billvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
                        billvaccine.setId("HerohudInfoStyle");
                        heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Rileymenubox,Tommymenubox,Davidmenubox,Henrymenubox);
                        VBox billhudicon = new VBox();
                        billhudicon.setAlignment(Pos.CENTER);
                        billhudicon.getChildren().addAll(bill,Billmenubutton);
                        billhudicon.setSpacing(5);
                        herohud.getChildren().addAll(billhudicon,billType,billattackdmg,billactionsav,billsupply,billvaccine,hpbar);
                        herohud.setAlignment(Pos.CENTER);
                        //hphud.getChildren().addAll(hpbar);
                        Medic medic = (Medic) ((CharacterCell) Game.map[i][j]).getCharacter();
                        medictarget(Game.heroes.get(0).getLocation().x,Game.heroes.get(0).getLocation().y,medic);
                    });
                    break;
                case"David":
                    Davidmenubutton.setOnAction(e->{
                        Millermenubox.getChildren().clear();
                        Williammenubox.getChildren().clear();
                        Tessmenubox.getChildren().clear();
                        Rileymenubox.getChildren().clear();
                        Tommymenubox.getChildren().clear();
                        Billmenubox.getChildren().clear();
                        Davidmenubox.getChildren().clear();
                        Henrymenubox.getChildren().clear();
                        if(!millerisdead)
                            Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
                        if(!williamisdead)
                            Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
                        if(!tessisdead)
                            Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
                        if(!rileyisdead)
                            Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
                        if(!tommyisdead)
                            Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
                        if(!billisdead)
                            Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
                        if(!davidisdead)
                            Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
                        if(!henryisdead)
                            Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
                        Game.heroes.remove(amr);
                        Game.heroes.add(0,amr);
                        heromenu.getChildren().clear();
                        herohud.getChildren().clear();
                        hphud.getChildren().clear();
                        davidnewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                        hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setId("hpbar");
                        //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setPrefSize(250,30);
                        stage.setScene(map);
                        davidhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
                        davidactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                        davidhp.setId("HudCurrHP");
                        davidactionsav.setId("HerohudInfoStyle");
                        davidsupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                        davidsupply.setId("HerohudInfoStyle");
                        davidvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
                        davidvaccine.setId("HerohudInfoStyle");
                        heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Rileymenubox,Tommymenubox,Billmenubox,Henrymenubox);
                        VBox davidhudicon = new VBox();
                        davidhudicon.setAlignment(Pos.CENTER);
                        davidhudicon.getChildren().addAll(david,Davidmenubutton);
                        davidhudicon.setSpacing(5);
                        herohud.getChildren().addAll(davidhudicon,davidType,davidattackdmg,davidactionsav,davidsupply,davidvaccine,hpbar);
                        herohud.setAlignment(Pos.CENTER);
                        //hphud.getChildren().addAll(hpbar);
                    });
                    break;
                case"Henry Burell":
                    Henrymenubutton.setOnAction(e->{
                        Millermenubox.getChildren().clear();
                        Williammenubox.getChildren().clear();
                        Tessmenubox.getChildren().clear();
                        Rileymenubox.getChildren().clear();
                        Tommymenubox.getChildren().clear();
                        Billmenubox.getChildren().clear();
                        Davidmenubox.getChildren().clear();
                        Henrymenubox.getChildren().clear();
                        if(!millerisdead)
                            Millermenubox.getChildren().addAll(Millermenubutton,Millermenudetails);
                        if(!williamisdead)
                            Williammenubox.getChildren().addAll(Williamsmenubutton,Williammenudetails);
                        if(!tessisdead)
                            Tessmenubox.getChildren().addAll(Tessmenubutton,Tessmenudetails);
                        if(!rileyisdead)
                            Rileymenubox.getChildren().addAll(Rileymenubutton,Rileymenudetails);
                        if(!tommyisdead)
                            Tommymenubox.getChildren().addAll(Tommymenubutton,Tommymenudetails);
                        if(!billisdead)
                            Billmenubox.getChildren().addAll(Billmenubutton,Billmenudetails);
                        if(!davidisdead)
                            Davidmenubox.getChildren().addAll(Davidmenubutton,Davidmenudetails);
                        if(!henryisdead)
                            Henrymenubox.getChildren().addAll(Henrymenubutton,Henrymenudetails);
                        Game.heroes.remove(amr);
                        Game.heroes.add(0,amr);
                        heromenu.getChildren().clear();
                        herohud.getChildren().clear();
                        hphud.getChildren().clear();
                        henrynewhp.setText("Currenthp: "+Game.heroes.get(0).getCurrentHp());
                        hpbar = new ProgressBar((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        //hpbar.setProgress((double)Game.heroes.get(0).getCurrentHp()/Game.heroes.get(0).getMaxHp());
                        hpbar.setPrefSize(250,30);
                        hpbar.setId("hpbar");
                        stage.setScene(map);
                        henryhp = new Label("Current Health: "+Game.heroes.get(0).getCurrentHp());
                        henryactionsav = new Label("Actions available: "+Game.heroes.get(0).getActionsAvailable());
                        henryhp.setId("HudCurrHP");
                        henryactionsav.setId("HerohudInfoStyle");
                        henrysupply=new Label("Supplies Carried: "+Game.heroes.get(0).getSupplyInventory().size());
                        henrysupply.setId("HerohudInfoStyle");
                        henryvaccine=new Label("Vaccines Carried: "+ Game.heroes.get(0).getVaccineInventory().size());
                        henryvaccine.setId("HerohudInfoStyle");
                        heromenu.getChildren().addAll(Millermenubox,Williammenubox,Tessmenubox,Rileymenubox,Tommymenubox,Billmenubox,Davidmenubox);
                        VBox henryhudicon = new VBox();
                        henryhudicon.setAlignment(Pos.CENTER);
                        henryhudicon.getChildren().addAll(henry,Henrymenubutton);
                        henryhudicon.setSpacing(5);
                        herohud.getChildren().addAll(henryhudicon,henryType,henryattackdmg,henryactionsav,henrysupply,henryvaccine,hpbar);
                        herohud.setAlignment(Pos.CENTER);
                        //hphud.getChildren().addAll(hpbar);
                    });
                    break;
            }
        }

    }
    public static void main(String[] args) {
        launch();
    }

}