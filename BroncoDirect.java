package broncodirect;

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
        otherAca.setValue("Other Academics..."); //default value
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
        otherFin.setValue("Other Finances..."); //default value
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

				/*PERSONAL INFORMATION*/
        Label persinfo = new Label ("Personal Information");
      	Button emecontact = new Button ("Emergency Contact");
      
        ComboBox otherper = new ComboBox(); //Other Personal
      	otherper.setValue("Other Personal...");
        otherper.getItems().addAll("Addresses", "Email Addresses", "Honor and Awards",
                                    "Phone Numbers", "Pronouns");
        Button perconfirm = new Button(">");
      	HBox oP = new HBox (otherper, perconfirm);
      	VBox personal = new VBox(emecontact, oP);
      	
      	//right alignment of the person info section
      	Label contactinfo = new Label("Contact Information");
        
        Label mailadd = new Label("Mailing Address"); ////this is a link
      	Label mailinfo = new Label("XXXX Street Name\nCity, CA, XXXXX");	
      	
      	Label mainphone = new Label("Main Phone"); //this is a link
      	Label phoneinfo = new Label ("XXX/XXX-XXXX");
      	
      	Label homeadd = new Label("Home Address"); ////this is a link
      	Label homeinfo = new Label("\nXXXX Street Name\nCity, CA, XXXXX");
      	
      	Label campem = new Label("Campus Email"); ////this is a link
      	Label campinfo = new Label("bsteichen@cpp.edu");
      	
      	HBox mailhome = new HBox(mailadd, homeadd);
      	HBox mailhomeinfo = new HBox (mailinfo, homeinfo);
      	HBox mainphem = new HBox (mainphone, campem);
      	HBox phoneeminfo = new HBox (phoneinfo, campinfo);
      	VBox contactstuff = new VBox(mailhome, mailhomeinfo, mainphem, phoneeminfo);

      	VBox allInfo = new VBox(persinfo, personal);
      	
        HBox rightallInfo = new HBox(allInfo, contactstuff);
          
        /*ADMISSIONS*/
        Label admiLabel = new Label("Admissions");
        Button apply = new Button("Apply For Admission");
      	Label placeholder3 = new Label("[]"); //(i) icon placeholder
      	Label pndMsg = new Label("You do not have any pending applications at this time.");
      	HBox pendingApps = new HBox(placeholder3, pndMsg);
      	HBox admiBody = new HBox(apply, pendingApps);
      	VBox admissions = new VBox(admiLabel, admiBody);

        /**SIDEBAR**/
      	/*HOLDS*/
      	Label holdLabel = new Label("Holds");
      	Label holdInfo = new Label("No holds.");
      	VBox holdBox = new VBox(holdLabel, holdInfo);
      
      	/*TO DO*/
      	Label toDoLabel = new Label("To-Do Lists");
        Label toDoInfo = new Label("No To Do's.");
      	VBox toDoList = new VBox(toDoLabel, toDoInfo);
      
      	/*ENROLLMENT*/
      	Label enrollLabel = new Label("Enrollment Details");
      	Label appointLabel = new Label("Enrollment Appointment(s)");//this is a link
      	Label fallLabel = new Label("Fall Semester 2020 Term"); //bold if possible
      
        Label regularLabel = new Label("Regular Academic Session");
        Label enrollDateLabel1 = new Label("XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm"); //blockquote
        Label enrollDateLabel2 = new Label("XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm"); //blockquote
        Label summerLabel = new Label("Summer Semester 2020 Term"); //bold if possible
      
        /*EXPANDABLE/COLLAPSABLE LABELS*/
        Button summerButton = new Button("Expand/Collapse Dates");
        Label summerDates = new Label(" "); //label will be changed when button is clicked
        summerButton.setOnAction(e ->
        {
          if (summerDates.getText().equals(" ")){
             summerDates.setText("Regular Academic Session\n"
                                 + "XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n"//blockquote
                                 + "XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n"//blockquote
                                 + "Open University Session\n"
                                 + "XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n"//blockquote
                                 + "XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n"//blockquote
                                 + "Open University 1st 5 week\n"
                                 + "XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n"//blockquote
                                 + "XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n"//blockquote
                                 + "Open University 2nd 5 week\n"
                                 + "XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm\n"//blockquote
                                 + "XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm"); //blockquote
          }//end if
          else{
            summerDates.setText(" ");
          }//end else
        });
        VBox enrollBox = new VBox(enrollLabel, appointLabel, fallLabel, regularLabel, 
                                  enrollDateLabel1, enrollDateLabel2, summerLabel,
                                  summerButton, summerDates);
      
      /* old code:
      	Label regularLabel1 = new Label("Regular Academic Session");
        Label openLabel1 = new Label("Open University Session");
        Label enrollDateLabel1 = new Label("XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm");
      	Label openLabel2 = new Label("Open University 1st 5 week");
        Label enrollDateLabel2 = new Label("XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm");
        Label openLabel3 = new Label("Open University 2nd 5 week");
      	Label enrollDateLabel3 = new Label("XX/XX/XX XX:XXam - XX/XX/XX XX:XXpm");
      
      	VBox fallList = new VBox(regularLabel);
      	ComboBox summerList = new ComboBox();
        summerList.getItems().addAll(regularLabel1,enrollDateLabel1,
                                  openLabel1,enrollDateLabel1,
                                  openLabel2,enrollDateLabel2,
                                  openLabel3,enrollDateLabel3);
        VBox enrollBox = new VBox(emrollLabel,appointLabel,
                                  fallLabel,regularLabel,enrollDateLabel,
                                  summerLabel,summerList);
                                  
        */
      	
        /*ADVISOR*/
        Label advisorLabel = new Label("Advisor");
      	Label CSadvising = new Label("CS Advising");
        /*CS ADVISORS*/
        //to be indented/in a blockquote
      	Label advisor1 = new Label("XXXXX");
      	Label advEmail1 = new Label("XXXXX@XXX.XXX"); //this is a link
      	Label advisor2 = new Label("XXXXX");
        Label advEmail2 = new Label("XXXXX@XXX.XXX"); //this is a link
        /*PROGRAM ADVISOR*/
        Label programAdv = new Label("Program Advisor");
      	Label pAdvNone = new Label ("None Assigned");
        VBox advisorList = new VBox(advisor1, advEmail1, advisor2, advEmail2); //for the blockquote of advisor contacts
        VBox advisorBox = new VBox(advisorLabel, CSadvising, advisorList, programAdv, pAdvNone);
        
        /*EXTERNAL LINKS*/
      	Label exlinks=new Label ("Cal Poly Pomona External Links");
      	
      	Label bookstore = new Label("Bookstore-Get/View textbooks");//this is a link
        Label broncoCompass = new Label("BroncoCompass-Advising");//this is a link
        Label ehelp = new Label("e-help - On-line assistance");//this is a link
      	Label cashier = new Label("Student Accounting/Cashiering");//this is a link
        Label finacial = new Label("Financial Aid");//this is a link
        Label cssa = new Label("CSSA- Stdnt Involve & Rep Fee");//this is a link
        Label blackboard = new Label("BlackBoard");//this is a link
        Label campusem = new Label("Campus Email - MS Outlook Live");//this is a link
        Label vote = new Label("Voter Registration");//this is a link
        Label calFresh = new Label("CalFresh");//this is a link
      
      	VBox exlink = new VBox (exlinks, bookstore,broncoCompass, ehelp, cashier, finacial,
                               cssa, blackboard, campusem, vote, calFresh);
      
      
        VBox left = new VBox(academics, finances, rightallInfo, admissions); //MAIN BODY of BroncoDirect
      	VBox right = new VBox(holdBox, toDoList, enrollBox, advisorBox, exlink); //SIDEBAR of BroncoDirect

        BorderPane container = new BorderPane(); //ENTIRE WEBSITE
        container.setTop(stickyHeader); //sticky header
        container.setLeft(left); //main body
      	container.setRight(right); //sidebar
		
        /*DISPLAY*/
        Scene scene = new Scene(container, 1024, 768); //set scene with container
        primaryStage.setScene(scene); //add scene to stage
        primaryStage.setTitle("BroncoDirect - Student Center"); //set stage title
        primaryStage.show(); //show the window
    }
}