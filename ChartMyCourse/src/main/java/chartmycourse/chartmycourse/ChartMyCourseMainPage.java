package chartmycourse.chartmycourse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

//Main UI class.
public class ChartMyCourseMainPage extends JFrame {

	//These are the required buttons, labels, and other swing elements.
	private JLabel chartmycoursewatermark;
    private JLabel curUserHeading;
    private JLabel curUserLabel;
    private JTextField emailField;
    private JLabel emailLabel;
    private JLabel emailLabelSignup;
    private JButton forgotPasswordButton;
    private JButton homeButton;
    private JPanel homePanel;
    private JButton loginButton;
    private JDialog loginDialog;
    private JLabel loginLabel;
    private JButton loginRequestButton;
    private JButton loginReturnButton;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JPasswordField passwordField;
    private JPasswordField passwordField1;
    private JLabel passwordLabel;
    private JLabel passwordLabelSignup;
    private JButton planningButton;
    private JLabel planningHeading;
    private JPanel planningPanel;
    private JButton postReplyButton;
    private JButton qAndAButton;
    private JPanel qAndAPanel;
    private JTable qAndATable;
    private JScrollPane qAndATableScrollPane;
    private JButton recommendedCoursesButton;
    private JButton recommendedProfessorsButton;
    private JButton registerButton;
    private JButton reviewsButton;
    private JLabel reviewsHeader;
    private JPanel reviewsPanel;
    private JTable reviewsTable;
    private JScrollPane reviewsTableScrollPane;
    private JLabel searchLabel;
    private JTextField searchText;
    private JButton selectFilterButton;
    private JButton selectProfButton;
    private JButton signupButton;
    private JDialog signupDialog;
    private JButton signupFormButton;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JTextArea welcomeSplashTextArea;
    private JScrollPane welcomeSplashTextPane;
    private String curUser = "not logged in";
    //This array holds the list of reviews.
    private ArrayList<Review> reviewArray = new ArrayList<Review>();
    //This array holds the list of users.
    private ArrayList<User> userArray = new ArrayList<User>();
    //This array holds the list of posts.
    private ArrayList<Post> postsArray = new ArrayList<Post>();
    
    //Constructor function, makes declaration of instance display.
    public ChartMyCourseMainPage() {
    	
        createInteractables();
        
        initialize();
    }

	//This function initializes all of the interactable objects.
    private void createInteractables() {

        loginDialog = new JDialog();
        loginLabel = new JLabel();
        passwordField = new JPasswordField();
        usernameField = new JTextField();
        loginButton = new JButton();
        emailLabel = new JLabel();
        passwordLabel = new JLabel();
        forgotPasswordButton = new JButton();
        signupFormButton = new JButton();
        signupDialog = new JDialog();
        emailLabelSignup = new JLabel();
        passwordLabelSignup = new JLabel();
        passwordField1 = new JPasswordField();
        emailField = new JTextField();
        usernameLabel = new JLabel();
        nameLabel = new JLabel();
        usernameTextField = new JTextField();
        nameTextField = new JTextField();
        loginReturnButton = new JButton();
        registerButton = new JButton();
        homePanel = new JPanel();
        welcomeSplashTextPane = new JScrollPane();
        welcomeSplashTextArea = new JTextArea();
        curUserHeading = new JLabel();
        curUserLabel = new JLabel();
        chartmycoursewatermark = new JLabel();
        homeButton = new JButton();
        reviewsButton = new JButton();
        qAndAButton = new JButton();
        planningButton = new JButton();
        loginRequestButton = new JButton();
        signupButton = new JButton();
        reviewsPanel = new JPanel();
        selectProfButton = new JButton();
        selectFilterButton = new JButton();
        reviewsHeader = new JLabel();
        reviewsTableScrollPane = new JScrollPane();
        reviewsTable = new JTable();
        planningPanel = new JPanel();
        planningHeading = new JLabel();
        recommendedCoursesButton = new JButton();
        recommendedProfessorsButton = new JButton();
        qAndAPanel = new JPanel();
        searchLabel = new JLabel();
        searchText = new JTextField();
        qAndATableScrollPane = new JScrollPane();
        qAndATable = new JTable();
        postReplyButton = new JButton();

        
        loginDialog.setTitle("login");
        loginDialog.setBackground(new Color(0, 88, 5));
        loginDialog.setForeground(new Color(40, 151, 21));
        loginDialog.setSize(new Dimension(400, 300));

        loginLabel.setText("login");

        //The text in this field is not visible, so it doesn't matter.
        passwordField.setText("password");
        
        //Default username is the following
        usernameField.setText("tomas_cerny@baylor.edu");

        //Set the text of the login button.
        loginButton.setText("login");
        
        //Create listener to actually log in.
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                //Call the function for when the button is pressed.
            	loginButtonActionPerformed(eventHappens);
            }
        });

        
        //Set text of label for login field.
        emailLabel.setText("email:");

        //Set text of label for password field.
        passwordLabel.setText("password:");

        //setFont is needed in order to reduce the size of the font.
        forgotPasswordButton.setFont(new Font("sansserif", 0, 8));
        //Create the text for the forgot my password button
        forgotPasswordButton.setText("forgot my password");
        
        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                forgotPasswordButtonActionPerformed(eventHappens);
            }
        });

        signupFormButton.setFont(new Font("sansserif", 0, 8));
        signupFormButton.setText("sign up");
        signupFormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                signupFormButtonActionPerformed(eventHappens);
            }
        });

        GroupLayout loginDialogLayout = new GroupLayout(loginDialog.getContentPane());
        loginDialog.getContentPane().setLayout(loginDialogLayout);
        loginDialogLayout.setHorizontalGroup(
            loginDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, loginDialogLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(loginLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(184, 184, 184))
            .addGroup(loginDialogLayout.createSequentialGroup()
                .addGroup(loginDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(loginDialogLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(loginDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(loginDialogLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(signupFormButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(forgotPasswordButton))
                            .addGroup(loginDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameField)
                                .addComponent(passwordField))))
                    .addGroup(loginDialogLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(loginButton)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginDialogLayout.setVerticalGroup(
            loginDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(loginDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel)
                .addGap(75, 75, 75)
                .addGroup(loginDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(26, 26, 26)
                .addComponent(forgotPasswordButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signupFormButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addGap(67, 67, 67))
        );

        signupDialog.setSize(new Dimension(400, 300));

        emailLabelSignup.setText("email:");

        passwordLabelSignup.setText("password:");

        passwordField1.setText("jPasswordField1");

        emailField.setText("tomas_cerny@baylor.edu");

        usernameLabel.setText("username:");

        nameLabel.setText("name:");

        usernameTextField.setText("BuffTommyC");

        nameTextField.setText("Tomas Cerny");
        nameTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                nameTextFieldActionPerformed(eventHappens);
            }
        });

        loginReturnButton.setText("return to login");
        loginReturnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                loginReturnButtonActionPerformed(eventHappens);
            }
        });

        registerButton.setText("register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                registerButtonActionPerformed(eventHappens);
            }
        });

        GroupLayout signupDialogLayout = new GroupLayout(signupDialog.getContentPane());
        signupDialog.getContentPane().setLayout(signupDialogLayout);
        signupDialogLayout.setHorizontalGroup(
            signupDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(signupDialogLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(signupDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(signupDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailLabelSignup, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordLabelSignup, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                    .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupDialogLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(passwordField1, GroupLayout.Alignment.LEADING)
                    .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(nameTextField)
                    .addComponent(usernameTextField, GroupLayout.Alignment.LEADING))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, signupDialogLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(signupDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginReturnButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(144, 144, 144))
        );
        signupDialogLayout.setVerticalGroup(
            signupDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(signupDialogLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(signupDialogLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabelSignup))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabelSignup))
                .addGap(18, 18, 18)
                .addComponent(loginReturnButton)
                .addGap(18, 18, 18)
                .addComponent(registerButton)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(21, 71, 52));

        homePanel.setPreferredSize(new Dimension(589, 332));

        welcomeSplashTextArea.setColumns(20);
        welcomeSplashTextArea.setRows(5);
        welcomeSplashTextArea.setText("Welcome to ChartMyCourse!\nUse the buttons above to switch tabs\nto your desired functionality.");
        welcomeSplashTextPane.setViewportView(welcomeSplashTextArea);

        curUserHeading.setText("Current User: ");

        curUserLabel.setText(curUser);

        GroupLayout homePanelLayout = new GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(welcomeSplashTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(curUserLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(curUserHeading, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curUserHeading)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(curUserLabel)
                .addGap(62, 62, 62)
                .addComponent(welcomeSplashTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        chartmycoursewatermark.setFont(new Font("Cloister Black", 0, 24));
        chartmycoursewatermark.setText("chartmycourse");

        homeButton.setFont(new Font("sansserif", 0, 8));
        homeButton.setText("home");
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                homeButtonActionPerformed(eventHappens);
            }
        });

        reviewsButton.setFont(new Font("sansserif", 0, 8));
        reviewsButton.setText("reviews");
        reviewsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                reviewsButtonActionPerformed(eventHappens);
            }
        });

        qAndAButton.setFont(new Font("sansserif", 0, 8));
        qAndAButton.setText("Q&A");
        qAndAButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                qAndAButtonActionPerformed(eventHappens);
            }
        });

        planningButton.setFont(new Font("sansserif", 0, 8));
        planningButton.setText("planning");
        planningButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                planningButtonActionPerformed(eventHappens);
            }
        });

        loginRequestButton.setFont(new Font("sansserif", 0, 8));
        loginRequestButton.setText("login");
        loginRequestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                loginRequestButtonActionPerformed(eventHappens);
            }
        });

        signupButton.setFont(new Font("sansserif", 0, 8));
        signupButton.setText("signup");
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                signupButtonActionPerformed(eventHappens);
            }
        });

        reviewsPanel.setPreferredSize(new Dimension(589, 332));

        selectProfButton.setText("Select Professor");
        selectProfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                selectProfButtonActionPerformed(eventHappens);
            }
        });

        selectFilterButton.setText("Select Filter");
        selectFilterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                selectFilterButtonActionPerformed(eventHappens);
            }
        });

        reviewsHeader.setFont(new Font("sansserif", 0, 24));
        reviewsHeader.setText("Reviews");

        reviewsTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Review Author", "CRN", "Course", "Professor", "Review Score/10", "View Review"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, Integer.class, Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        reviewsTable.setColumnSelectionAllowed(true);
        reviewsTable.getTableHeader().setReorderingAllowed(false);
        reviewsTableScrollPane.setViewportView(reviewsTable);
        reviewsTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (reviewsTable.getColumnModel().getColumnCount() > 0) {
            reviewsTable.getColumnModel().getColumn(1).setMinWidth(50);
            reviewsTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            reviewsTable.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        GroupLayout reviewsPanelLayout = new GroupLayout(reviewsPanel);
        reviewsPanel.setLayout(reviewsPanelLayout);
        reviewsPanelLayout.setHorizontalGroup(
            reviewsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(reviewsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(reviewsHeader, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectProfButton)
                    .addComponent(selectFilterButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(reviewsTableScrollPane, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
        );
        reviewsPanelLayout.setVerticalGroup(
            reviewsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(reviewsPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(reviewsHeader)
                .addGap(12, 12, 12)
                .addComponent(selectProfButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectFilterButton)
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, reviewsPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(reviewsTableScrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        );

        planningPanel.setPreferredSize(new Dimension(589, 332));
        planningPanel.setVisible(false);

        planningHeading.setFont(new Font("sansserif", 0, 36));
        planningHeading.setText("Planning");

        recommendedCoursesButton.setText("Recommended Courses");
        recommendedCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                recommendedCoursesButtonActionPerformed(eventHappens);
            }
        });

        recommendedProfessorsButton.setText("Recommended Professors");

        GroupLayout planningPanelLayout = new GroupLayout(planningPanel);
        planningPanel.setLayout(planningPanelLayout);
        planningPanelLayout.setHorizontalGroup(
            planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(planningPanelLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(recommendedCoursesButton)
                .addGap(70, 70, 70)
                .addComponent(recommendedProfessorsButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(planningPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(planningHeading, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
        );
        planningPanelLayout.setVerticalGroup(
            planningPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, planningPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(planningHeading)
                .addGap(18, 18, 18)
                .addGroup(planningPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(recommendedCoursesButton)
                    .addComponent(recommendedProfessorsButton))
                .addGap(239, 239, 239))
        );

        qAndAPanel.setPreferredSize(new Dimension(589, 332));

        searchLabel.setFont(new Font("sansserif", 0, 24));
        searchLabel.setText("Search:");

        searchText.setText("search text");
        searchText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eventHappens) {
                searchTextActionPerformed(eventHappens);
            }
        });

        qAndATable.setAutoCreateRowSorter(true);
        qAndATable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author", "Replies", "Upvotes", "View Post"
            }
        ) {
            Class[] types = new Class [] {
                String.class, Integer.class, Integer.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        qAndATableScrollPane.setViewportView(qAndATable);

        postReplyButton.setFont(new Font("Segoe UI", 0, 8));
        postReplyButton.setText("Post New Discussion");

        GroupLayout qAndAPanelLayout = new GroupLayout(qAndAPanel);
        qAndAPanel.setLayout(qAndAPanelLayout);
        qAndAPanelLayout.setHorizontalGroup(
            qAndAPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, qAndAPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(qAndAPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(qAndAPanelLayout.createSequentialGroup()
                        .addComponent(searchLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchText, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postReplyButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(qAndATableScrollPane, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );
        qAndAPanelLayout.setVerticalGroup(
            qAndAPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(qAndAPanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(qAndAPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchText)
                    .addComponent(postReplyButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qAndATableScrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chartmycoursewatermark, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reviewsButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qAndAButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planningButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(loginRequestButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signupButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(planningPanel, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(reviewsPanel, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(homePanel, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addComponent(qAndAPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton)
                    .addComponent(reviewsButton)
                    .addComponent(qAndAButton)
                    .addComponent(planningButton)
                    .addComponent(chartmycoursewatermark)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(signupButton)
                            .addComponent(loginRequestButton))))
                .addGap(50, 50, 50)
                .addComponent(planningPanel, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(reviewsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(homePanel, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(67, Short.MAX_VALUE)
                    .addComponent(qAndAPanel, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );

        reviewsPanel.setVisible(false);
        planningPanel.setVisible(false);

        pack();
    }

    //This switches to the home tab
    private void homeButtonActionPerformed(ActionEvent eventHappens) {
        hideAll();
        homePanel.setVisible(true);
    }

    //This is the forgot password listener
    private void forgotPasswordButtonActionPerformed(ActionEvent eventHappens) {
        // TODO add forgot password functionality
    }

    //This is the login button at the top right
    private void loginRequestButtonActionPerformed(ActionEvent eventHappens) {
        loginDialog.setVisible(true);
    }

    //This is the login button within the login dialog
    private void loginButtonActionPerformed(ActionEvent eventHappens) {
        User inputUser = new User();
        inputUser.setEmail(usernameField.getText());
        inputUser.setUserName(usernameField.getText());
        inputUser.setPassword(new String(passwordField.getPassword()));
        
        boolean userFound = false;
        
        for (User iterUser : userArray) {
        	if (iterUser.compare(inputUser)) {
        		userFound = true;
        		inputUser.setRealName(iterUser.getRealName());
        		break;
        	}
        }
        
        if (userFound) {
        	loginDialog.setVisible(false);
            curUser = inputUser.getRealName();
            curUserLabel.setText(curUser);
        }
        else {
        	JOptionPane.showMessageDialog(null, "Account information not found.");
        }
    	
        
    }

    //This is the recommended courses button, on the 
    private void recommendedCoursesButtonActionPerformed(ActionEvent eventHappens) {
    	//TODO add recommended courses button functionality
    }

    private void planningButtonActionPerformed(ActionEvent eventHappens) {
        hideAll();
        planningPanel.setVisible(true);
    }

    private void selectProfButtonActionPerformed(ActionEvent eventHappens) {
        // TODO add professor filter
    }

    private void selectFilterButtonActionPerformed(ActionEvent eventHappens) {
        // TODO add filter functionality
    }

    private void reviewsButtonActionPerformed(ActionEvent eventHappens) {
        hideAll();
        reviewsPanel.setVisible(true);
        
    }

    private void nameTextFieldActionPerformed(ActionEvent eventHappens) {
        // TODO add name text field functionality
    }

    private void loginReturnButtonActionPerformed(ActionEvent eventHappens) {
        signupDialog.setVisible(false);
        loginDialog.setVisible(true);
        
    }

    private void signupButtonActionPerformed(ActionEvent eventHappens) {
        signupDialog.setVisible(true);
    }

    private void signupFormButtonActionPerformed(ActionEvent eventHappens) {
        loginDialog.setVisible(false);
        signupDialog.setVisible(true);

    }

    private void searchTextActionPerformed(ActionEvent eventHappens) {
        // TODO Add search functionality
    }

    private void qAndAButtonActionPerformed(ActionEvent eventHappens) {
       hideAll();
        qAndAPanel.setVisible(true);
    }

    //This is the event for when the register button is pressed
    private void registerButtonActionPerformed(ActionEvent eventHappens) {
    	
    	//Initialize variables to hold the values of the text fields.
    	String readRealName, readUserName, readEmail, readPassword;
    	
    	//We set the values of the variables to what is in the corresponding fields.
        readRealName = nameTextField.getText();
        readUserName = usernameTextField.getText();
        readEmail = emailField.getText();
        readPassword = (new String(passwordField1.getPassword()));
        
        //If any of them are empty, the user is alerted that they cannot continue.
        if (readRealName.isEmpty() || readUserName.isEmpty() || readEmail.isEmpty() || readPassword.isEmpty()) {
        	JOptionPane.showMessageDialog(null, "Error: no fields can be blank");
        }
        
        //If everything is populated, create a new user.
        else {
        	
        	//Create new User with given fields
        	User userToRegister = new User(readRealName, readUserName, readEmail, readPassword);
        	
        	//We start by assuming the user is unique.
        	boolean isUniqueUser = true;
        	
        	//Iterate through the known users, making sure we don't already have this user
        	//registered.
        	for (User iterUser : userArray) {
        		//If we find it, it must not be a unique user. Tell the user this.
        		if (iterUser.equals(userToRegister)) {
                	JOptionPane.showMessageDialog(null, "Error: user already exists!");
                	isUniqueUser = false;
                	break;
        		}
        	}
        	//If it is indeed unique, add it to the user array.
        	//NOTE: this does not add the user to the users.txt file!
        	//TODO: add user persistence
        	if (isUniqueUser) {
        		userArray.add(userToRegister);
            	JOptionPane.showMessageDialog(null, "User created successfully!");
                signupDialog.setVisible(false);
                loginDialog.setVisible(true);
        	}
        	
        	
        }
    }
    
   
    //This is the initialization function that populates internal "databases".
    //We also set the frame as visible here, and display the login dialog.
    //TODO: enforce user login (make sure they can't close the window until they are logged in)
    public void initialize() {
        this.setVisible(true);
        loginDialog.setVisible(true);
        initTestReviews();
        initTestUsers();
        initTestPosts();
    }
    
    //In order to understand this function, you need to understand how
    //our frame is rendered. The frame is essentially modeled after an HTML canvas
    // - all the tabs (planning, reviews, etc.) are already created, we just choose 
    //which one we want the user to see. They are all layered on top of each other.
    //This means when we want to show a "tab", we just hide all the JPanels with this
    //function, then explicitly set the panel we want as visible.
    //All this function does is set all tabs to be not visible.
    //We leave the setting of visible to the function that called this one.
    public void hideAll() {
        homePanel.setVisible(false);
        reviewsPanel.setVisible(false);
        planningPanel.setVisible(false);
        qAndAPanel.setVisible(false);
    }
    
    //This function loads reviews from the reviews.txt file. 
    
    //TODO: add "make a review" functionality
    public void initTestReviews() {
    	//Open the reviews file and a scanner for it.
    	File reviewFile = new File("reviews.txt");
    	Scanner reviewScanner;
		try {
			reviewScanner = new Scanner(reviewFile);
			while (reviewScanner.hasNextLine()) {
	    		//call createReviewFromLine on read line, which does exactly as it says
	    		reviewArray.add(createReviewFromLine(reviewScanner.nextLine()));
	    	}
	    	//Call table creation function
	    	initReviewTable();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //This function creates our tablemodel from our review array.
    public void initReviewTable() {
    	DefaultTableModel model = (DefaultTableModel) reviewsTable.getModel();
    	
    	//Iterate through review array, and create a row in our table for each
    	for (Review iterReview : reviewArray) {
    		model.insertRow(reviewsTable.getRowCount(), new Object[] {iterReview.getAuthor(), iterReview.getCRN(), iterReview.getCourse(), iterReview.getProfessor(), iterReview.getRating(),iterReview.getReviewBody()});
    	}
    	//Make sure and tell the table we changed things
    	model.fireTableDataChanged();
    	
    }
    
    //This function takes a line of input, and makes a review object from it.
    //The format is as follows: 
    //NAME,CLASS,CRN,PROF,RATING,DESCRIPTION
    public Review createReviewFromLine(String line) {
    	Review readReview = new Review();
    	//Split the line by commas, then use the array to create the user
    	List<String> result = Arrays.asList(line.split(","));
    	readReview.setAuthor(result.get(0));
    	readReview.setCourse(result.get(1));
    	readReview.setCRN(result.get(2));
    	readReview.setProfessor(result.get(3));
    	readReview.setRating(Integer.parseInt(result.get(4)));
    	readReview.setReviewBody(result.get(5));
    	
    	return readReview;
    }
    
    //This is just like the initTestReviews function, for users.
    public void initTestUsers() {
    	File userFile = new File("users.txt");
    	Scanner userScanner;
		try {
			userScanner = new Scanner(userFile);
			while (userScanner.hasNextLine()) {
	    		
	    		userArray.add(createUserFromLine(userScanner.nextLine()));
	    	}
	    	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    //This function creates a user from a line.
    public User createUserFromLine(String line) {
    	User readUser = new User();
    	List<String> result = Arrays.asList(line.split(","));
    	readUser.setRealName(result.get(0));
    	readUser.setUserName(result.get(1));
    	readUser.setEmail(result.get(2));
    	readUser.setPassword(result.get(3));

    	return readUser;
    }
    
    //See other init() functions
    public void initTestPosts() {
    	File postsFile = new File("posts.txt");
    	Scanner postScanner;
		try {
			postScanner = new Scanner(postsFile);
			while (postScanner.hasNextLine()) {
	    		
	    		postsArray.add(createPostFromLine(postScanner.nextLine()));
	    	}
			
			initQAndATable();
	    	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    //See other init() functions
    public void initQAndATable() {
    	DefaultTableModel model = (DefaultTableModel) qAndATable.getModel();
    	
    	for (Post iterPost : postsArray) {
    		model.insertRow(qAndATable.getRowCount(), new Object[] {iterPost.getAuthor(), iterPost.getReplies(), iterPost.getUpvotes(), iterPost.getPostContents()});
    	}
    	model.fireTableDataChanged();
    	
    }
    
    //See createUserFromLine or createReviewFromLine
    public Post createPostFromLine(String line) {
    	Post readPost = new Post();
    	List<String> result = Arrays.asList(line.split(","));
    	readPost.setAuthor(result.get(0));
    	readPost.setReplies(Integer.parseInt(result.get(1)));
    	readPost.setUpvotes(Integer.parseInt(result.get(2)));
    	readPost.setPostContents(result.get(3));

    	return readPost;
    }
   

}
