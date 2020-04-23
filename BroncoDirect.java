package BroncoDirect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

public class BroncoDirect extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /**STICKY HEADER**/
        //Basic website and student information
        Label Oracle = new Label("Oracle"); //Temporary "Oracle"
        Label studentName = new Label("Ben Steichen"); //Student name
        Label sC = new Label("Student Center");

        //Navigation buttons
        Button home = new Button("Home");
        Button studentCenter = new Button("Student Center");
        Button scheNav = new Button("Schedule");
        Button finNav = new Button("Finances");
        Button persNav = new Button("Personal Information");
        Button favorites = new Button("Favorites"); //opens out additional options
        Button signOut = new Button("Sign Out"); //right align
        HBox nav = new HBox(10, home, studentCenter, scheNav, finNav, persNav, favorites); //navigation links
        HBox sO = new HBox(signOut);
        sO.setAlignment(Pos.CENTER_RIGHT);
        HBox rightAlignment = new HBox(400, nav, sO);

        //Top bar containers
        HBox basicInfo = new HBox(50, Oracle, studentName, sC);
        HBox links = new HBox(rightAlignment); //navigation links
        VBox stickyHeader = new VBox(10, basicInfo, links); //MAIN STICKY HEADER HOLDER

        /**MAIN BODY**/
        /*ACADEMICS*/
        Label acaTitle = new Label("Academics");
        Button searchClasses = new Button("Search Classes");
        Button weeklySche = new Button("Weekly Schedule");
        Button plan = new Button("Plan");
        Button enroll = new Button("Enroll");
        Button myAca = new Button("My Academics");
        Button builder = new Button("Schedule Builder");
        ComboBox otherAca = new ComboBox(); //Other Academics Combobox
        otherAca.getItems().addAll(
                "Academic Planner",
                "Apply for Graduation",
                "Class Schedule",
                "Course History",
                "Degree Progress Report",
                "Enrollment: Add",
                "Enrollment: Drop",
                "Enrollment: Edit",
                "Enrollment: Swap",
                "Grades",
                "Transcript: View Unofficial",
                "Transfer Credit: Report",
                "What-if Report"
        );
        otherAca.setValue("Other Academics"); //default value
        Button acaConfirm = new Button(">"); //button to confirm selection
        HBox oA = new HBox(otherAca, acaConfirm); //puts combobox and button together

        //Academics navigation
        VBox acaLinks = new VBox(searchClasses, weeklySche, plan, enroll, myAca, builder, oA);

        //Schedule
        Label scheLabel = new Label("Spring 2020 Schedule"); //Schedule header
        Label placeHolder1 = new Label("[]"); //schedule placeholder
        Label placeHolder2 = new Label("[]"); //deadline icon placeholder
        Label academicCalDL = new Label("Academic Calender Deadline"); //Academic Calender Deadline
        HBox dLCal = new HBox(placeHolder1, academicCalDL);
        CheckBox disProf = new CheckBox("Display Professor"); //Display professor name
        CheckBox disClass = new CheckBox("Display Class Name"); //Display full class name
        HBox schOptions = new HBox(disProf, disClass);
        VBox schedule = new VBox(scheLabel, placeHolder2, dLCal, schOptions); //SCHEDULE section
        HBox acaInfo = new HBox(acaLinks, schedule); //puts together the links and schedule into 1 section
        VBox academics = new VBox(acaTitle, acaInfo); //ENTIRE academics portion

        /*FINANCES*/
        Label finLabel = new Label("Finances");
        //MY ACCOUNT PORTION
        Label myAccLabel = new Label("My Account");
        Button accountInq = new Button("Account Inquiry");
        Button directDep = new Button("Direct Deposit");
        ComboBox otherFin = new ComboBox(); //Other Finances
        otherFin.getItems().addAll(
                "Account Activity",
                "Charges Due",
                "Payments",
                "View 1098-T",
                "View Student Permissions"
        );
        otherFin.setValue("Other Finances"); //default value
        Button finConfirm = new Button(">"); //button to confirm selection
        HBox oF = new HBox(otherFin, finConfirm); //puts combobox and button together
        VBox myAccount = new VBox(myAccLabel, accountInq, directDep, oF);
        //FINANCIAL AID PORTION
        Label fALabel = new Label ("Financial Aid");
        Button viewFA = new Button("View Financial Aid");
        Button accDec = new Button("Accept/Decline Awards");
        Button pending = new Button("Pending Financial Aid");
        VBox financialAid = new VBox(fALabel, viewFA, accDec, pending);
        VBox finLinks = new VBox(myAccLabel, myAccount, fALabel, financialAid); //ALL left-side links
        //PENDING CHARGES
        Label chargeAmt = new Label("You have no outstanding charges at this time"); //current charges
        Label popup = new Label("Please turn off your popoff blocker"); //in RED
        Button payment = new Button("Make a Payment");
        Label disclaimer = new Label("*Important Student Fee Information");
        VBox charges = new VBox(chargeAmt, popup, payment, disclaimer); //holds entire right-side portion
        HBox finBody = new HBox(finLinks, charges); //holds everything under financial title
        VBox finances = new VBox(finLabel, finBody); //ENTIRE financial portion

        VBox left = new VBox(academics, finances); //MAIN BODY of BroncoDirect

        BorderPane container = new BorderPane(); //ENTIRE WEBSITE
        container.setTop(stickyHeader); //sticky header
        container.setLeft(left); //main body

        /*DISPLAY*/
        Scene scene = new Scene(container, 1024, 768); //set scene with container
        primaryStage.setScene(scene); //add scene to stage
        primaryStage.setTitle("BroncoDirect - Student Center"); //set stage title
        primaryStage.show(); //show the window
    }
}
