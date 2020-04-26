package BroncoDirect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

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
        Label mdash = new Label("-");
        Label sC = new Label("Student Center");

        //Navigation buttons
        Button home = new Button("Home");
        Button studentCenter = new Button("Student Center");
        Button scheNav = new Button("Schedule");
        Button finNav = new Button("Finances");
        Button persNav = new Button("Personal Information");
        Button favorites = new Button("Favorites"); //opens out additional options
        Button signOut = new Button("Sign Out"); //right align

        signOut.setOnAction(e -> primaryStage.close()); //signOut closes the Stage when clicked on
        HBox nav = new HBox(10, home, studentCenter, scheNav, finNav, persNav, favorites); //navigation links

        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinWidth(385);
        HBox rightAlignment = new HBox(nav, spacer, signOut);

        //Top bar containers
        HBox basicInfo = new HBox(10, Oracle, studentName, mdash, sC);
        HBox links = new HBox(rightAlignment); //navigation links
        VBox stickyHeader = new VBox(10, basicInfo, links); //MAIN STICKY HEADER HOLDER

        /**MAIN BODY**/
        /*ACADEMICS*/
        Label acaLabel = new Label("Academics");
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
        otherAca.setValue("Other Academics..."); //default value
        Button acaConfirm = new Button(">"); //button to confirm selection
        HBox oA = new HBox(5, otherAca, acaConfirm); //puts combobox and button together

        //Academics navigation
        VBox acaLinks = new VBox(5, searchClasses, weeklySche, plan, enroll, myAca, builder, oA);

        //Schedule
        Label scheLabel = new Label("Spring 2020 Schedule"); //Schedule header
        Label placeHolder1 = new Label("[]"); //schedule placeholder
        Label placeHolder2 = new Label("[]"); //deadline icon placeholder
        Label academicCalDL = new Label("Academic Calender Deadline"); //Academic Calender Deadline
        HBox dLCal = new HBox(placeHolder1, academicCalDL);
        CheckBox disProf = new CheckBox("Display Professor"); //Display professor name
        CheckBox disClass = new CheckBox("Display Class Name"); //Display full class name
        HBox schOptions = new HBox(10, disProf, disClass);
        VBox schedule = new VBox(10, scheLabel, placeHolder2, dLCal, schOptions); //SCHEDULE section

        HBox acaBody = new HBox(40, acaLinks, schedule); //puts together the links and schedule into 1 section
        VBox academics = new VBox(20, acaLabel, acaBody); //ENTIRE academics portion

        /*FINANCES*/
        Label finLabel = new Label("Finances");

        //MY ACCOUNT NAVIGATION
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
        otherFin.setValue("Other Finances..."); //default value
        Button finConfirm = new Button(">"); //button to confirm selection
        HBox oF = new HBox(5, otherFin, finConfirm); //puts combobox and button together
        VBox myAccount = new VBox(5, myAccLabel, accountInq, directDep, oF);

        //FINANCIAL AID NAVIGATION
        Label fALabel = new Label ("Financial Aid");
        Button viewFA = new Button("View Financial Aid");
        Button accDec = new Button("Accept/Decline Awards");
        Button pending = new Button("Pending Financial Aid");
        VBox financialAid = new VBox(5, fALabel, viewFA, accDec, pending);
        VBox finLinks = new VBox(5, myAccLabel, myAccount, fALabel, financialAid); //ALL left-side links

        //PENDING CHARGES
        Label chargeAmt = new Label("You have no outstanding charges at this time"); //current charges
        Label popup = new Label("Please turn off your popoff blocker"); //in RED
        Button payment = new Button("Make a Payment");
        Label disclaimer = new Label("*Important Student Fee Information"); //this is a link
        VBox charges = new VBox(5, chargeAmt, popup, payment, disclaimer); //holds entire right-side portion

        HBox finBody = new HBox(40, finLinks, charges); //holds everything under financial title
        VBox finances = new VBox(20, finLabel, finBody); //ENTIRE financial portion

        /*PERSONAL INFORMATION*/
        Label persInfoLabel = new Label ("Personal Information");
        Button emeContact = new Button ("Emergency Contact");
        ComboBox otherPer = new ComboBox(); //Other Personal
        otherPer.setValue("Other Personal...");
        otherPer.getItems().addAll("Addresses",
                "Email Addresses",
                "Honor and Awards",
                "Phone Numbers",
                "Pronouns"
        );
        Button perConfirm = new Button(">");
        HBox oP = new HBox (5, otherPer, perConfirm);
        VBox personal = new VBox(5, emeContact, oP);

        //Contact/Personal info section
        Label contactInfo = new Label("Contact Information"); //"Contact Information" title
        Label mailAdd = new Label("Mailing Address"); //this is a link
        Label mailInfo = new Label("XXXX Street Name\nCity, CA, XXXXX");
        Label mainPhone = new Label("Main Phone"); //this is a link
        Label phoneInfo = new Label ("XXX/XXX-XXXX");
        Label homeAddr = new Label("Home Address"); //this is a link
        Label homeInfo = new Label("XXXX Street Name\nCity, CA, XXXXX");
        Label campEm = new Label("Campus Email"); //this is a link
        Label campInfo = new Label("bsteichen@cpp.edu");
        VBox mailing = new VBox(mailAdd, mailInfo);
        VBox phone = new VBox(mainPhone, phoneInfo);
        VBox addr = new VBox(homeAddr, homeInfo);
        VBox email = new VBox(campEm, campInfo);
        GridPane contactBody = new GridPane(); //contact information box
        contactBody.add(mailing, 0, 0);
        contactBody.add(phone, 0, 1);
        contactBody.add(addr, 1, 0);
        contactBody.add(email, 1, 1);
        contactBody.setHgap(10);
        contactBody.setVgap(10);

        VBox contactHold = new VBox(contactInfo, contactBody);
        HBox persInfoBody = new HBox(40, personal, contactHold);
        VBox persInfo = new VBox(20, persInfoLabel, persInfoBody);

        /*ADMISSIONS*/
        Label admiLabel = new Label("Admissions");
        Button apply = new Button("Apply For Admission");
        Label pndMsg = new Label("You do not have any pending applications at this time.");
        HBox pendingApps = new HBox(pndMsg);
        HBox admiBody = new HBox(40, apply, pendingApps);
        VBox admissions = new VBox(20, admiLabel, admiBody);

        /**SIDEBAR**/
        /*HOLDS*/
        Label holdLabel = new Label("Holds");
        Label holdInfo = new Label("No holds.");
        VBox holdBox = new VBox(holdLabel, holdInfo);

        /*TO DO*/
        Label toDoLabel = new Label("To Do Lists");
        Label toDoInfo = new Label("No To Do's.");
        VBox toDoList = new VBox(toDoLabel, toDoInfo);

        /*ENROLLMENT*/
        Label enrollLabel = new Label("Enrollment Details");
        Label appointLabel = new Label("Enrollment Appointment(s)"); //this is a link
        Label fallLabel = new Label("\nFall Semester 2020 Term"); //bold if possible
        Label regularLabel = new Label("Regular Academic Session");
        Label enrollDateLabel1 = new Label("   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm"); //blockquote
        Label enrollDateLabel2 = new Label("   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm"); //blockquote
        Label summerLabel = new Label("\nSummer Semester 2020 Term"); //bold if possible

        //expandable & collapsable labels
        Button summerButton = new Button("Expand Dates");
        Label summerDates = new Label(""); //label will be changed when button is clicked
        summerButton.setOnAction(e -> {
            if (summerDates.getText().equals("")) {
                summerButton.setText("Collapse Dates");
                summerDates.setText("Regular Academic Session\n"
                        + "   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n" //blockquote
                        + "   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n" //blockquote
                        + "Open University Session\n"
                        + "   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n" //blockquote
                        + "   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n" //blockquote
                        + "Open University 1st 5 week\n"
                        + "   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n" //blockquote
                        + "   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n" //blockquote
                        + "Open University 2nd 5 week\n"
                        + "   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n" //blockquote
                        + "   XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm"); //blockquote
            } //end if
            else {
                summerButton.setText("Expand Dates");
                summerDates.setText("");
            } //end else
        }); //end of summerDates event handler
        VBox enrollBody = new VBox(appointLabel, fallLabel, regularLabel, enrollDateLabel1,
                enrollDateLabel2, summerLabel, summerButton, summerDates);
        VBox enrollBox = new VBox(enrollLabel, enrollBody);

        /*ADVISOR*/
        Label advisorLabel = new Label("Advisor");
        Label CSadvising = new Label("CS Advising");

        //CS ADVISORS
        //to be indented/in a blockquote
        Label advisor1 = new Label("XXXXX");
        Label advEmail1 = new Label("XXXXX@XXX.XXX"); //this is a link
        Label advisor2 = new Label("XXXXX");
        Label advEmail2 = new Label("XXXXX@XXX.XXX"); //this is a link

        //PROGRAM ADVISOR
        Label programAdv = new Label("Program Advisor");
        Label pAdvNone = new Label ("None Assigned");
        VBox advisorList = new VBox(advisor1, advEmail1, advisor2, advEmail2); //for the blockquote of advisor contacts
        VBox advisorBody = new VBox(CSadvising, advisorList, programAdv, pAdvNone);
        VBox advisorBox = new VBox(advisorLabel, advisorBody);

        /*EXTERNAL LINKS*/
        Label exLinksLabel = new Label ("Cal Poly Pomona External Links");

        Label bookstore = new Label("Bookstore-Get/View textbooks"); //this is a link
        Label broncoCompass = new Label("BroncoCompass-Advising"); //this is a link
        Label eHelp = new Label("e-help - On-line assistance"); //this is a link
        Label cashier = new Label("Student Accounting/Cashiering"); //this is a link
        Label financialAidExt = new Label("Financial Aid"); //this is a link
        Label cssa = new Label("CSSA- Stdnt Involve & Rep Fee"); //this is a link
        Label blackboard = new Label("BlackBoard"); //this is a link
        Label campusEm = new Label("Campus Email - MS Outlook Live"); //this is a link
        Label voteReg = new Label("Voter Registration"); //this is a link
        Label calFresh = new Label("CalFresh"); //this is a link

        VBox exLinkBody = new VBox(5, bookstore,broncoCompass, eHelp, cashier, financialAidExt,
                cssa, blackboard, campusEm, voteReg, calFresh);
        VBox exlink = new VBox (exLinksLabel, exLinkBody);

        /**CONTAINERS**/
        VBox left = new VBox(50, academics, finances, persInfo, admissions); //MAIN BODY of BroncoDirect
        VBox right = new VBox(25, holdBox, toDoList, enrollBox, advisorBox, exlink); //SIDEBAR of BroncoDirect
        BorderPane container = new BorderPane(); //ENTIRE WEBSITE
        container.setTop(stickyHeader); //sticky header
        container.setLeft(left); //main body
        container.setRight(right); //sidebar
        /*SCROLLBAR*/
        ScrollPane sp = new ScrollPane(container); //allows entire screen to scroll when it is too long
        sp.setFitToWidth(true); //disables horizontal scroll

        /**COSMETICS**/
        BorderPane.setMargin(stickyHeader, new Insets(0, 0, 20, 0));
        container.setPadding(new Insets(25));
        container.getStyleClass().add("container");

        /*ALL CSS*/
        //Top Navigation Links
        stickyHeader.setId("stickyHeader");
        basicInfo.setId("basicInfo");
        studentName.setId("studentName");
        home.getStyleClass().add("nav");
        studentCenter.getStyleClass().add("nav");
        scheNav.getStyleClass().add("nav");
        finNav.getStyleClass().add("nav");
        persNav.getStyleClass().add("nav");
        favorites.getStyleClass().add("nav");
        signOut.getStyleClass().add("nav");

        //Academics
        acaLabel.getStyleClass().add("sectionTitle"); //"Academics"
        acaBody.getStyleClass().add("helpAlign"); //shifts contents to the right 7 pixels
        searchClasses.getStyleClass().add("sideButton"); //start academics side buttons
        weeklySche.getStyleClass().add("sideButton");
        plan.getStyleClass().add("sideButton");
        enroll.getStyleClass().add("sideButton");
        enroll.getStyleClass().add("sideButton");
        myAca.getStyleClass().add("sideButton");
        builder.getStyleClass().add("sideButton");
        otherAca.getStyleClass().add("other"); //other Academics combobox
        acaConfirm.getStyleClass().add("confirm"); // > button
        scheLabel.getStyleClass().add("subtitle"); //"Spring 2020 Schedule"

        //Finances
        finLabel.getStyleClass().add("sectionTitle"); //"Finances"
        finBody.getStyleClass().add("helpAlign"); //shifts contents to the right 7 pixels
        viewFA.getStyleClass().add("sideButton"); //start finance side buttons
        myAccLabel.getStyleClass().add("subtitle"); //"My Account"
        accountInq.getStyleClass().add("sideButton"); //start my account buttons
        directDep.getStyleClass().add("sideButton");
        fALabel.getStyleClass().add("subtitle"); //"Financial Aid"
        accDec.getStyleClass().add("sideButton"); //start financial aid buttons
        pending.getStyleClass().add("sideButton");
        otherFin.getStyleClass().add("other"); //other Finances combobox
        finConfirm.getStyleClass().add("confirm"); // > button
        chargeAmt.getStyleClass().add("infobox"); //outstanding charges box
        payment.getStyleClass().add("payment");
        disclaimer.getStyleClass().add("link"); //charges information
        popup.setId("popup"); //turn off popup block

        //Personal Information
        persInfoLabel.getStyleClass().add("sectionTitle"); //"Personal Information"
        persInfoBody.getStyleClass().add("helpAlign"); //shifts contents to the right 7 pixels
        emeContact.getStyleClass().add("sideButton"); //admission side button
        otherPer.getStyleClass().add("other"); //other Personal Info combobox
        perConfirm.getStyleClass().add("confirm"); // > button
        contactInfo.getStyleClass().add("subtitle"); //"Contact Info"
        mailAdd.getStyleClass().add("link");
        mainPhone.getStyleClass().add("link");
        homeAddr.getStyleClass().add("link");
        campEm.getStyleClass().add("link");
        appointLabel.getStyleClass().add("link");

        //Admissions
        admiLabel.getStyleClass().add("sectionTitle"); //"Admissions"
        admiBody.getStyleClass().add("helpAlign"); //shifts contents to the right 7 pixels
        apply.getStyleClass().add("sideButton"); //admissions side button
        pndMsg.getStyleClass().add("infobox");

        //Sidebar
        holdLabel.getStyleClass().add("sideBarTitle"); //hold list
        holdInfo.getStyleClass().add("sideBarBody");

        toDoLabel.getStyleClass().add("sideBarTitle"); //to do list
        toDoInfo.getStyleClass().add("sideBarBody");

        enrollLabel.getStyleClass().add("sideBarTitle"); //enrolment dates
        enrollBody.getStyleClass().add("sideBarBody");
        summerButton.getStyleClass().add("expandButton");
        fallLabel.getStyleClass().add("boldText");
        summerLabel.getStyleClass().add("boldText");

        advisorLabel.getStyleClass().add("sideBarTitle"); //Advisor information
        advisorBody.getStyleClass().add("sideBarBody");
        advisorList.getStyleClass().add("blockquote");
        CSadvising.getStyleClass().add("boldText");
        programAdv.getStyleClass().add("boldText");
        advEmail1.getStyleClass().add("link"); //start emails
        advEmail2.getStyleClass().add("link");

        exLinksLabel.getStyleClass().add("sideBarTitle"); //External links
        exLinkBody.getStyleClass().add("sideBarBody");
        bookstore.getStyleClass().add("link");
        broncoCompass.getStyleClass().add("link");
        eHelp.getStyleClass().add("link");
        cashier.getStyleClass().add("link");
        financialAidExt.getStyleClass().add("link");
        cssa.getStyleClass().add("link");
        blackboard.getStyleClass().add("link");
        campusEm.getStyleClass().add("link");
        voteReg.getStyleClass().add("link");
        calFresh.getStyleClass().add("link");

        /**DISPLAY**/
        Scene scene = new Scene(sp, 1024, 769); //set scene with container
        scene.getStylesheets().add("BroncoDirect/StylishBD.CSS");

        primaryStage.setScene(scene); //add scene to stage
        primaryStage.setTitle("BroncoDirect - Student Center"); //set stage title
        primaryStage.show(); //show the window
    }
}
