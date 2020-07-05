import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

//import com.toedter.calendar.JDateChooser;

public class AZBS {
	
	JFrame jframe;
	JPanel homePanel, LoginPanel, mainHeaderPanel, mainFooterPanel;
	
	// homePanel contents
	JLabel AZBSLabel, officeAddressHeadingLabel, officeAttentdentLabel, officeAddressLabel;
	
	// loginFromPanels
	JPanel adminLoginPanel, memberLoginPanel;
		// adminLoginPanel
		JLabel adminLoginPanelLabel;
		// memberLoginPanel
		JLabel memberLoginPanelLabel;
	
	// loginPanle contents
	JLabel LoginHeading, usernameLabel, passwordLabel;
	JTextField usernameField;
	JPasswordField passwordField;
	JButton loginButton;
	String loginFrom = "";
	
	// adminPanel
	JPanel adminPanel;
		// TabPanels
		JPanel addMemberTabPanel, sortMembersTabPanel, otherTabPanel2, otherTabPanel3, settingsTabPanel, addFieldTabPanel;
			// addMemberTabPanel
			JLabel addMemberTabLabel;
			// otherTabPanel1
			JLabel sortMembersTabLabel;
			// otherTabPanel2
			JLabel otherTabLabel2;
			// otherTabPanel3
			JLabel otherTabLabel3;
			// settingsTabPanel
			JLabel settingsTabLabel;
			// addFieldTabPanel
			JLabel addFieldTabLabel;

		// mainHeaderPanel contents
		JLabel mainPanelLabel;
		
		// mainFooterPanel contents
		TitledBorder border;
		JPanel addMemberPanel, sortMembersPanel, addFieldsPanel;
		
			// addMemberPanel
			JScrollPane addMemberPanelScrollPane;
			JPanel mainPersonDetailsPanel, currentAddressPanel, rootDetailsPanel, contactDetailsPanel, familyDetailsPanel, otherDetailsPanel, formReceiptPanel;
				// formReceiptPanel
				JLabel formNumberLabel, formNumberAlertLabel, receiptNumberLabel, donationLabel, referencebyLabel, donationAlertLabel, totalFormNumber, receiptNumberAlertLabel;
				JTextField formNumberField, receiptNumberField, donationField;
				JButton submitFormNumber, submitFormButton, resetFormButton, resetFormWithFormNumberButton;//TODO
				JComboBox referencebyField;

				// mainPersonDetailsPanel
				JLabel mainPersonSurnameLabel, mainPersonNameLabel, mainPersonFatherNameLabel;
				JTextField mainPersonNameField, mainPersonFatherNameField;
				JComboBox mainPersonSurnameField;
				
				// currentAddressPanel
				JLabel currentAddressLine1Label, currentAddressLine2Label, currentCityLabel, currentStateLabel, currentDistrictLabel, currentCountryLabel;
				JTextField currentAddressLine1Field, currentAddressLine2Field;
				JComboBox currentStateField, currentCountryField, currentDistrictField, currentCityField;
				
				// rootDetailsPanel
				JLabel rootCityLabel, rootStateLabel, rootCountryLabel, rootGotraLabel, rootKulDeviLabel, occupationLabel, rootKulLabel, rootMoshalSurnameLabel, rootTalGolLabel, rootExpertiseOrAwardsLabel, rootDistrictLabel;
				JTextField rootExpertiseOrAwardsField;
				JComboBox rootGotraField, rootKulDeviField, rootKulField, rootMoshalSurnameField, rootTalGolField, rootStateField, rootCountryField, businessField, serviceField, rootDistrictField, rootCityField;
				JRadioButton businessRadioButton, serviceRadioButton;
				ButtonGroup occupationButtonGroup;
				
				// contactDetailsPanel
				JLabel phoneNumberLabel, mobileNumberLabel, emailLabel, phoneNumberAlertLabel, mobileNumberAlertLabel;
				JTextField phoneNumberField, mobileNumberField, emailField;
		
				// familyDetailsPanel
				JPanel familyMemberPanel[], familyMemberEducationPanel[];
				JLabel familyMemberSurnameLabel[], familyMemberNameLabel[], familyMemberFatherNameLabel[], familyMemberRelationLabel[], familyMemberBirthDateLabel[], familyMemberQualificationLabel[][], familyMemberMaritualStatusLabel[], numberOfFamilyMembersLabel, familyMemberNumber[], familyMemberGenderLabel[], whatsappNumberLabel[], whatsappNumberAlertLabel[], familyMemberMainPersonNoticeLabel, numberOfEducationQualificationLabel[], familyMemberStreamLabel[][], familyMemberDegreeLabel[][];
				JTextField familyMemberNameField[], familyMemberFatherNameField[], whatsappNumberField[];
				JComboBox familyMemberSurnameField[], familyMemberRelationField[], numberOfFamilyMembersField, numberOfEducationQualificationField[], familyMemberQualificationField[][], familyMemberStreamField[][], familyMemberDegreeField[][];
				JRadioButton familyMemberMarriedRadioButton[], familyMemberUnmarriedRadioButton[], familyMemberGenderMaleRadioButton[], familyMemberGenderFemaleRadioButton[];
				ButtonGroup familyMemberMaritualStatusGroup[], familyMemberGenderGroup[];
//				JDateChooser familyMemberBirthDateField[];
				JButton addFamilyMembers, resetFamilyPanelButton, addEducationQualification[];
				
				// otherDetailsPanel
				JLabel livingInJointFamilyLabel, haveOwnHouseLabel, intrestedInSocialActivityLabel;
				JRadioButton livingInJointFamilyYesRadioButton, livingInJointFamilyNoRadioButton, haveOwnHouseYesRadioButton, haveOwnHouseNoRadioButton, intrestedInSocialActivityYesRadioButton, intrestedInSocialActivityNoRadioButton;
				ButtonGroup livingInJointFamilyGroup, haveOwnHouseGroup, intrestedInSocialActivityGroup;
			
			
			// sortMembersPanel
			JScrollPane sortMembersPanelScrollPane;
			JPanel firstNamePanel;
			JTextField firstNameField;
				

			// addFieldsPanel
			JScrollPane addFieldsPanelScrollPane;
			JPanel initialDetailsFieldsPanel, addressDetailsFieldsPanel, rootDetailsFieldsPanel, familyDetailsFieldsPanel, educationQualificationDetailsFieldsPanel;
			JPanel addSurnamePanel, addReferencebyPanel, addCountryPanel, addStatePanel, addDistrictPanel, addCityPanel, addGotraPanel, addKulDeviPanel, addBusinessPanel, addServicePanel, addKulPanel, addMoshalSurnamePanel, addTalGolPanel, addRelationPanel, addQualificationPanel, addStreamPanel, addDegreePanel;
				// addSurnamePanel
				JTextField addSurnameField;
				JButton addSurnameButton;
				
				// addReferencebyPanel
				JTextField addReferencebyField;
				JButton addReferencebyButton;
				
				// addCountryPanel
				JTextField addCountryField;
				JButton addCountryButton;
				
				// addStatePanel
				JTextField addStateField;
				JComboBox stateSelectCountryField;
				JButton addStateButton;
				
				// addDistrictPanel
				JTextField addDistrictField;
				JComboBox districtSelectCountryField, districtSelectStateField;
				JButton addDistrictButton;
				
				// addCityPanel
				JTextField addCityField;
				JComboBox citySelectCountryField, citySelectStateField, citySelectDistrictField;
				JButton addCityButton;
				
				// addGotraPanel
				JTextField addGotraField;
				JButton addGotraButton;
				
				// addKulDeviPanel
				JTextField addKulDeviField;
				JButton addKulDeviButton;
				
				// addBusinessPanel
				JTextField addBusinessField;
				JButton addBusinessButton;
				
				// addServicePanel
				JTextField addServiceField;
				JButton addServiceButton;
				
				// addKulPanel
				JTextField addKulField;
				JButton addKulButton;
				
				// addMoshalSurnamePanel
				JTextField addMoshalSurnameField;
				JButton addMoshalSurnameButton;
				
				// addTalGolPanel
				JTextField addTalGolField;
				JButton addTalGolButton;
				
				// addRelationPanel
				JTextField addRelationField;
				JButton addRelationButton;
				
				// addQualificationPanel
				JTextField addQualificationField;
				JButton addQualificationButton;
				
				// addStreamPanel
				JTextField addStreamField;
				JComboBox streamSelectQualificationField;
				JButton addStreamButton;
				
				// addDegreePanel
				JTextField addDegreeField;
				JComboBox degreeSelectQualificationField, degreeSelectStreamField;
				JButton addDegreeButton;
				
				
	// sizeMeserments of panels
		final int mainFooterPanelWidth;
		final int mainFooterPanelHeight;
		
		// addMemberPanel sizeMeserments
			final int mainPersonDetailsPanelWidth;
			
			final int currentAddressPanelWidth;
			
			final int contactDetailsPanelWidth;
			
			final int rootDetailsPanelWidth;
			
			final int familyDetailsPanelWidth;
			final int familyDetailsPanelHeight;
			
			final int familyMemberEducationPanelWidth;
			
			final int otherDetailsPanelWidth;
			final int otherDetailsPanelHeight;
			
		// addFieldsPanel sizeMeserments
			final int initialDetailsFieldsPanelWidth;
				final int addSurnamePanelWidth;
				final int addReferencebyPanelWidth;

			final int addressDetailsFieldsPanelWidth;
				final int addCountryPanelWidth;
				final int addStatePanelWidth;
				final int addDistrictPanelWidth;
				final int addCityPanelWidth;
			
			final int rootDetailsFieldsPanelWidth;
				final int addGotraPanelWidth;
				final int addKulDeviPanelWidth;
				final int addBusinessPanelWidth;
				final int addServicePanelWidth;
				final int addKulPanelWidth;
				final int addMoshalSurnamePanelWidth;
				final int addTalGolPanelWidth;
				
			final int familyDetailsFieldsPanelWidth;
				final int addRelationPanelWidth;
			
			final int educationQualificationDetailsFieldsPanelWidth;
				final int addQualificationPanelWidth;
				final int addStreamPanelWidth;
				final int addDegreePanelWidth;
			
	// other parameters
		int increasedHeight;
		
	AZBS()
	{
	//	Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	//	int winSizeWidth = winSize.width;
	//	int winSizeHeight = winSize.height;
		
		
		
		jframe = new JFrame();
		jframe.setVisible(true);
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.getContentPane().setLayout(null);
		jframe.getContentPane().setBackground(Color.GRAY);
		
		Dimension jframeSize = jframe.getSize();
		int jframeWidth = (int)jframeSize.getWidth();
		int jframeHeight = (int)jframeSize.getHeight();
		
		mainFooterPanelWidth = jframeWidth-185;
		mainFooterPanelHeight = jframeHeight-110;
		
		// sizeMeserments of addMemberPanel
			mainPersonDetailsPanelWidth = mainFooterPanelWidth-80;
			
			currentAddressPanelWidth = mainFooterPanelWidth-80;
			
			contactDetailsPanelWidth = mainFooterPanelWidth-80;
			
			rootDetailsPanelWidth = mainFooterPanelWidth-80;
			
			familyDetailsPanelWidth = mainFooterPanelWidth-80;
			familyDetailsPanelHeight = 75;
			
			familyMemberEducationPanelWidth = familyDetailsPanelWidth-60;
			
			otherDetailsPanelWidth = mainFooterPanelWidth-80;
			otherDetailsPanelHeight = 75;
		
		// sizeMeserments of addFieldsPanel
			initialDetailsFieldsPanelWidth = mainFooterPanelWidth-80;
				addSurnamePanelWidth = (initialDetailsFieldsPanelWidth/2)-45;
				addReferencebyPanelWidth = (initialDetailsFieldsPanelWidth/2)-45;
			
			addressDetailsFieldsPanelWidth = mainFooterPanelWidth-80;
				addCountryPanelWidth = (addressDetailsFieldsPanelWidth/2)-45;
				addStatePanelWidth = (addressDetailsFieldsPanelWidth/2)-45;
				addDistrictPanelWidth = addressDetailsFieldsPanelWidth-60;
				addCityPanelWidth = addressDetailsFieldsPanelWidth-60;
			
			rootDetailsFieldsPanelWidth = mainFooterPanelWidth-80;
				addGotraPanelWidth = (rootDetailsFieldsPanelWidth/2)-45;
				addKulDeviPanelWidth = (rootDetailsFieldsPanelWidth/2)-45;
				addBusinessPanelWidth = (rootDetailsFieldsPanelWidth/2)-45;
				addServicePanelWidth = (rootDetailsFieldsPanelWidth/2)-45;
				addKulPanelWidth = (rootDetailsFieldsPanelWidth/2)-45;
				addMoshalSurnamePanelWidth = (rootDetailsFieldsPanelWidth/2)-45;
				addTalGolPanelWidth = (rootDetailsFieldsPanelWidth/2)-45;
			
			familyDetailsFieldsPanelWidth = mainFooterPanelWidth-80;
				addRelationPanelWidth = (rootDetailsFieldsPanelWidth/2)-45;
				
			educationQualificationDetailsFieldsPanelWidth = mainFooterPanelWidth-80;
				addQualificationPanelWidth = (educationQualificationDetailsFieldsPanelWidth/2)-45;
				addStreamPanelWidth = (educationQualificationDetailsFieldsPanelWidth/2)-45;
				addDegreePanelWidth = educationQualificationDetailsFieldsPanelWidth-60;
			
	// adminPanel
		adminPanel = new JPanel();
		jframe.getContentPane().add(adminPanel);
		adminPanel.setLayout(null);
		adminPanel.setVisible(true); // TODO false
		adminPanel.setBackground(Color.GRAY);
		adminPanel.setBounds(0, 0, jframeWidth, jframeHeight);

		
		// mainHeaderPanel
			mainHeaderPanel = new JPanel();
			adminPanel.add(mainHeaderPanel);
			mainHeaderPanel.setLayout(null);
			mainHeaderPanel.setVisible(true);
			mainHeaderPanel.setBounds(160, 10, jframeWidth-185, 50);
			mainHeaderPanel.setBackground(Color.LIGHT_GRAY);
			mainHeaderPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			
			mainPanelLabel = new JLabel("ADD MEMBER", SwingConstants.CENTER);
			mainPanelLabel.setForeground(Color.DARK_GRAY);
			mainPanelLabel.setFont(new Font("Constantia", Font.PLAIN, 20));
			mainPanelLabel.setBounds(((jframeWidth-185)/2)-80, 15, 160, 20);
			mainPanelLabel.setFocusable(false);
			
			mainHeaderPanel.add(mainPanelLabel);

			
		// mainFooterPanel
			mainFooterPanel = new JPanel();
			mainFooterPanel.setLayout(null);
			mainFooterPanel.setVisible(true);
			mainFooterPanel.setBounds(160, 60, mainFooterPanelWidth, mainFooterPanelHeight);
			mainFooterPanel.setBackground(Color.LIGHT_GRAY);

			final Font font = new Font("Cambria", Font.PLAIN, 17);
			
			// addMemberPanel
				addMemberPanel = new JPanel();
				addMemberPanel.setLayout(null);
				addMemberPanel.setVisible(true);
				
				addMemberPanel.setPreferredSize(new Dimension(mainFooterPanelWidth-20, 895));
				addMemberPanel.setBackground(Color.LIGHT_GRAY);
				
				addMemberPanelScrollPane = new JScrollPane(addMemberPanel);
				addMemberPanelScrollPane.setBounds(160, 60, mainFooterPanelWidth, mainFooterPanelHeight);
				adminPanel.add(addMemberPanelScrollPane);
				
				// formReceiptPanel
					formReceiptPanel = new JPanel();
					formReceiptPanel.setLayout(null);
					formReceiptPanel.setVisible(true);
					formReceiptPanel.setBounds(40, 10, mainFooterPanelWidth-80, 60);
					formReceiptPanel.setBackground(Color.LIGHT_GRAY);
					
					addMemberPanel.add(formReceiptPanel);
					
					formNumberLabel = new JLabel("Form Number : ", SwingConstants.RIGHT);
					formNumberLabel.setFont(font);
					formNumberLabel.setForeground(Color.DARK_GRAY);
					formNumberLabel.setBounds(10, 20, 114, 20);//(mainFooterPanelWidth/6)-119
					formNumberLabel.setFocusable(false);
					
					formNumberField = new JTextField();
					formNumberField.setFont(font);
					formNumberField.setForeground(Color.DARK_GRAY);
					formNumberField.setBackground(Color.WHITE);
					formNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
					formNumberField.setBounds(129, 20, (mainFooterPanelWidth/12)-30, 24);
					formNumberField.setFocusable(true);
					formNumberField.setDocument(new JTextFieldLimit(4));
					
					formNumberAlertLabel = new JLabel();
					formNumberAlertLabel.setFont(new Font("Cambria", Font.PLAIN, 13));
					formNumberAlertLabel.setForeground(Color.RED);
					formNumberAlertLabel.setBounds(129, 40, 267, 24);
					formNumberAlertLabel.setFocusable(false);
					formNumberAlertLabel.setVisible(false);

					submitFormNumber = new JButton("Submit");
					submitFormNumber.setBackground(Color.DARK_GRAY);
					submitFormNumber.setForeground(Color.LIGHT_GRAY);
					submitFormNumber.setBounds(129 + (mainFooterPanelWidth/12), 20, 100, 24);
					submitFormNumber.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							String formNumberString = formNumberField.getText();
							try
							{
								int formNumberInt = Integer.parseInt(formNumberString);
								
								if(!(formNumberInt >= 0 && formNumberInt <= 2000))
								{
									System.out.println(formNumberInt);
									if(formNumberInt < 0)
										formNumberAlertLabel.setText("Form number can not be less then 0");
									else
										formNumberAlertLabel.setText("Form number can not be greather than 2500");
									formNumberAlertLabel.setVisible(true);
									
									setEnableOnFormNumber(false);
								}
								else
								{
									try
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql = "SELECT COUNT(`form_number`) FROM `main_form` WHERE `form_number`='" + formNumberInt + "'";
										
										ResultSet rs = stmt.executeQuery(sql);
										
										rs.next();
										int formCount = rs.getInt(1);
										if(formCount==0)
										{
											setEnableOnFormNumber(true);//TODO bug
											refreshFieldData("SubmitFormNumberButton");
											formNumberField.setEnabled(false);
										}
										else
										{
											setEnableOnFormNumber(false);
											
											String msg = "Form number " + formNumberInt + " is already entered...";
											JOptionPane.showMessageDialog(null, msg, "Form already exist", JOptionPane.PLAIN_MESSAGE);
										}
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
									
									formNumberAlertLabel.setVisible(false);
								}
							}
							catch(Exception exc)
							{
								formNumberAlertLabel.setText("Form number can only be in numerical numbers");
								formNumberAlertLabel.setVisible(true);
							}
						}
					});
					
					receiptNumberLabel = new JLabel("Receipt Number* : ");
					receiptNumberLabel.setFont(font);
					receiptNumberLabel.setForeground(Color.DARK_GRAY);
					receiptNumberLabel.setBounds((3 * (mainFooterPanelWidth/12))+63, 20, 137, 20);//123
					receiptNumberLabel.setFocusable(false);
					
					receiptNumberField = new JTextField();
					receiptNumberField.setFont(font);
					receiptNumberField.setForeground(Color.DARK_GRAY);
					receiptNumberField.setBackground(Color.LIGHT_GRAY);
					receiptNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
					receiptNumberField.setBounds((3 * (mainFooterPanelWidth/12))+205, 20, (mainFooterPanelWidth/12)-30, 24);//265
					receiptNumberField.setFocusable(true);
					receiptNumberField.setDocument(new JTextFieldLimit(4));
					receiptNumberField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(receiptNumberField.getText().compareTo("")==0)
								receiptNumberField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								receiptNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
							
							try
							{
								Class.forName("com.mysql.jdbc.Driver");
								
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
								Statement stmt = con.createStatement();
								
								String sql = "SELECT COUNT(`form_number`) FROM `main_form` WHERE `receipt_number`='" + receiptNumberField.getText() + "'";
								ResultSet rs = stmt.executeQuery(sql);
								rs.next();
								
								if(rs.getInt(1)==1)
								{
									System.out.println(rs.getInt(1)+" Show");
									receiptNumberAlertLabel.setVisible(true);
								}
								else
								{
									System.out.println(rs.getInt(1)+" notShow");
									receiptNumberAlertLabel.setVisible(false);
								}
							}
							catch(Exception exc)
							{
								JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					});
					
					receiptNumberAlertLabel = new JLabel("Duplicate receipt number");
					receiptNumberAlertLabel.setFont(new Font("Cambria", Font.PLAIN, 13));
					receiptNumberAlertLabel.setForeground(Color.RED);
					receiptNumberAlertLabel.setBounds((3 * (mainFooterPanelWidth/12))+205, 40, 150, 24);
					receiptNumberAlertLabel.setFocusable(false);
					receiptNumberAlertLabel.setVisible(false);
					
					donationLabel = new JLabel("Donation Received* : ", SwingConstants.RIGHT);
					donationLabel.setFont(font);
					donationLabel.setForeground(Color.DARK_GRAY);
					donationLabel.setBounds((3 * (mainFooterPanelWidth/12))+205+(mainFooterPanelWidth/12), 20, 155, 20);
					donationLabel.setFocusable(false);
					
					donationField = new JTextField();
					donationField.setFont(font);
					donationField.setForeground(Color.DARK_GRAY);
					donationField.setBackground(Color.LIGHT_GRAY);
					donationField.setBorder(BorderFactory.createLoweredBevelBorder());
					donationField.setBounds((3 * (mainFooterPanelWidth/12))+205+(mainFooterPanelWidth/12)+160, 20, (mainFooterPanelWidth/12)-30, 24);
					donationField.setFocusable(true);
					donationField.setDocument(new JTextFieldLimit(3));
					donationField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(donationField.getText().compareTo("")==0)
								donationField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								donationField.setBorder(BorderFactory.createLoweredBevelBorder());
							
							String number = donationField.getText();
							
							donationAlertLabel.setVisible(false);

							for(int i=0 ; i<number.length() ; i++)
							{
								if(number.codePointAt(i) < 48 || number.codePointAt(i) > 57)
								{
									donationAlertLabel.setVisible(true);
									break;
								}
								else
									donationAlertLabel.setVisible(false);
							}
							
							if(donationField.getText().compareTo("0")==0)
							{
								donationAlertLabel.setVisible(true);
							}
						}
					});
					
					donationAlertLabel = new JLabel("Please enter a valid Number");
					donationAlertLabel.setFont(new Font("Cambria", Font.PLAIN, 13));
					donationAlertLabel.setForeground(Color.RED);
					donationAlertLabel.setBounds((3 * (mainFooterPanelWidth/12))+205+(mainFooterPanelWidth/12)+160, 40, 180, 24);
					donationAlertLabel.setFocusable(false);
					donationAlertLabel.setVisible(false);
					
					totalFormNumber = new JLabel("Total Exsisting Forms : ");
					totalFormNumber.setFont(font);
					totalFormNumber.setEnabled(false);
					totalFormNumber.setForeground(Color.DARK_GRAY);
					totalFormNumber.setBackground(Color.GRAY);
					totalFormNumber.setBounds((3 * (mainFooterPanelWidth/12))+205+(mainFooterPanelWidth/12)+160+(mainFooterPanelWidth/12), 20, 200, 24);
					totalFormNumber.setFocusable(false);
					totalFormNumber.setVisible(true);
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
						Statement stmt = con.createStatement();
						
						String sql = "SELECT COUNT(`form_number`) FROM `main_form`";
						
						ResultSet rs = stmt.executeQuery(sql);
						rs.next();
						totalFormNumber.setText(totalFormNumber.getText() + rs.getInt(1));
					}
					catch(Exception exc)
					{
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					formReceiptPanel.add(formNumberLabel);
					formReceiptPanel.add(formNumberField);
					formReceiptPanel.add(formNumberAlertLabel);
					formReceiptPanel.add(submitFormNumber);
					formReceiptPanel.add(receiptNumberLabel);
					formReceiptPanel.add(receiptNumberField);
					formReceiptPanel.add(receiptNumberAlertLabel);
					formReceiptPanel.add(donationLabel);
					formReceiptPanel.add(donationField);
					formReceiptPanel.add(donationAlertLabel);
					formReceiptPanel.add(totalFormNumber);
					
					referencebyLabel = new JLabel("Reference by : ");
					referencebyLabel.setFont(font);
					referencebyLabel.setForeground(Color.DARK_GRAY);
			//		referencebyLabel.setBounds((3 * (mainFooterPanelWidth/12))+265 + (mainFooterPanelWidth/12)+154+(mainFooterPanelWidth/12), 20, 110, 24);
					referencebyLabel.setBounds(50, 845, 110, 24);
					referencebyLabel.setFocusable(false);
					
					referencebyField = new JComboBox();
					referencebyField.setFont(font);
					referencebyField.setForeground(Color.DARK_GRAY);
					referencebyField.setBackground(Color.LIGHT_GRAY);
					referencebyField.setBorder(BorderFactory.createLoweredBevelBorder());
			//		referencebyField.setBounds((3 * (mainFooterPanelWidth/12)) + 265 + (mainFooterPanelWidth/12) + (mainFooterPanelWidth/12) + 110, 20, (mainFooterPanelWidth/6), 24);
					referencebyField.setBounds(165, 845, (mainFooterPanelWidth/6), 24);
					referencebyField.setFocusable(true);
					referencebyField.addItem("");
					referencebyField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(referencebyField.getSelectedIndex()==0)
								referencebyField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								referencebyField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					addMemberPanel.add(referencebyLabel);
					addMemberPanel.add(referencebyField);
				
				
				// mainPersonDetailsPanel
					border = new TitledBorder(border,"Main Person Of The Family",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					mainPersonDetailsPanel = new JPanel();
					mainPersonDetailsPanel.setLayout(null);
					mainPersonDetailsPanel.setVisible(true);
					mainPersonDetailsPanel.setBounds(40, 75, mainFooterPanelWidth-80, 75);
					mainPersonDetailsPanel.setBackground(Color.LIGHT_GRAY);
					mainPersonDetailsPanel.setBorder(border);
					
					addMemberPanel.add(mainPersonDetailsPanel);
					
					mainPersonSurnameLabel = new JLabel("Surname* : ", SwingConstants.RIGHT);
					mainPersonSurnameLabel.setFont(font);
					mainPersonSurnameLabel.setForeground(Color.DARK_GRAY);
					mainPersonSurnameLabel.setBounds((mainPersonDetailsPanelWidth/6)-87, 30, 82, 20);
					mainPersonSurnameLabel.setFocusable(false);
			
					mainPersonSurnameField = new JComboBox();
					mainPersonSurnameField.setFont(font);
					mainPersonSurnameField.setForeground(Color.DARK_GRAY);
					mainPersonSurnameField.setBackground(Color.LIGHT_GRAY);
					mainPersonSurnameField.setBorder(BorderFactory.createLoweredBevelBorder());
					mainPersonSurnameField.setBounds((mainPersonDetailsPanelWidth/6), 30, (mainPersonDetailsPanelWidth/6)-30, 24);
					mainPersonSurnameField.setFocusable(true);
					mainPersonSurnameField.addItem("");
					mainPersonSurnameField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(mainPersonSurnameField.getSelectedIndex() == 0)
								mainPersonSurnameField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								mainPersonSurnameField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					mainPersonNameLabel = new JLabel("Name* : ", SwingConstants.RIGHT);
					mainPersonNameLabel.setFont(font);
					mainPersonNameLabel.setForeground(Color.DARK_GRAY);
					mainPersonNameLabel.setBounds((3 * (mainPersonDetailsPanelWidth/6))-66, 30, 61, 20);
					mainPersonNameLabel.setFocusable(false);
			
					mainPersonNameField = new JTextField();
					mainPersonNameField.setFont(font);
					mainPersonNameField.setForeground(Color.DARK_GRAY);
					mainPersonNameField.setBackground(Color.LIGHT_GRAY);
					mainPersonNameField.setBorder(BorderFactory.createLoweredBevelBorder());
					mainPersonNameField.setBounds((3 * (mainPersonDetailsPanelWidth/6)), 30, (mainPersonDetailsPanelWidth/6)-30, 24);
					mainPersonNameField.setFocusable(true);
					mainPersonNameField.setDocument(new JTextFieldLimit(15));
					mainPersonNameField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(mainPersonNameField.getText().compareTo("")==0)
								mainPersonNameField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								mainPersonNameField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
			
					mainPersonFatherNameLabel = new JLabel("Father's Name* : ", SwingConstants.RIGHT);
					mainPersonFatherNameLabel.setFont(font);
					mainPersonFatherNameLabel.setForeground(Color.DARK_GRAY);
					mainPersonFatherNameLabel.setBounds((5 * mainPersonDetailsPanelWidth/6)-128, 30, 123, 20);
					mainPersonFatherNameLabel.setFocusable(false);
			
					mainPersonFatherNameField = new JTextField();
					mainPersonFatherNameField.setFont(font);
					mainPersonFatherNameField.setForeground(Color.DARK_GRAY);
					mainPersonFatherNameField.setBackground(Color.LIGHT_GRAY);
					mainPersonFatherNameField.setBorder(BorderFactory.createLoweredBevelBorder());
					mainPersonFatherNameField.setBounds((5 * (mainPersonDetailsPanelWidth/6)), 30, (mainPersonDetailsPanelWidth/6)-30, 24);
					mainPersonFatherNameField.setFocusable(true);
					mainPersonFatherNameField.setDocument(new JTextFieldLimit(15));
					mainPersonFatherNameField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(mainPersonFatherNameField.getText().compareTo("")==0)
								mainPersonFatherNameField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								mainPersonFatherNameField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					mainPersonDetailsPanel.add(mainPersonSurnameLabel);
					mainPersonDetailsPanel.add(mainPersonSurnameField);
					mainPersonDetailsPanel.add(mainPersonNameLabel);
					mainPersonDetailsPanel.add(mainPersonNameField);
					mainPersonDetailsPanel.add(mainPersonFatherNameLabel);
					mainPersonDetailsPanel.add(mainPersonFatherNameField);
			
					
				// currentAddressPanel
					border = new TitledBorder(border,"Current Address",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					currentAddressPanel = new JPanel();
					currentAddressPanel.setLayout(null);
					currentAddressPanel.setVisible(true);
					currentAddressPanel.setBounds(40, 180, mainFooterPanelWidth-80, 105);
					currentAddressPanel.setBackground(Color.LIGHT_GRAY);
					currentAddressPanel.setBorder(border);
					
					addMemberPanel.add(currentAddressPanel);
					
					currentAddressLine1Label = new JLabel("Address Line 1* : ", SwingConstants.RIGHT);
					currentAddressLine1Label.setFont(font);
					currentAddressLine1Label.setForeground(Color.DARK_GRAY);
					currentAddressLine1Label.setBounds((currentAddressPanelWidth/6)-130, 30, 125, 20);
					currentAddressLine1Label.setFocusable(false);
					
					currentAddressLine1Field = new JTextField();
					currentAddressLine1Field.setFont(font);
					currentAddressLine1Field.setForeground(Color.DARK_GRAY);
					currentAddressLine1Field.setBackground(Color.LIGHT_GRAY);
					currentAddressLine1Field.setBorder(BorderFactory.createLoweredBevelBorder());
					currentAddressLine1Field.setBounds((currentAddressPanelWidth/6), 30, (2 * (currentAddressPanelWidth/6))-30, 24);
					currentAddressLine1Field.setFocusable(true);
					currentAddressLine1Field.setDocument(new JTextFieldLimit(150));
					currentAddressLine1Field.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(currentAddressLine1Field.getText().compareTo("")==0)
								currentAddressLine1Field.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								currentAddressLine1Field.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					currentAddressLine2Label = new JLabel("Address Line 2 : ", SwingConstants.RIGHT);
					currentAddressLine2Label.setFont(font);
					currentAddressLine2Label.setForeground(Color.DARK_GRAY);
					currentAddressLine2Label.setBounds((4 * (currentAddressPanelWidth/6))-123, 30, 118, 20);
					currentAddressLine2Label.setFocusable(false);
					
					currentAddressLine2Field = new JTextField();
					currentAddressLine2Field.setFont(font);
					currentAddressLine2Field.setForeground(Color.DARK_GRAY);
					currentAddressLine2Field.setBackground(Color.LIGHT_GRAY);
					currentAddressLine2Field.setBorder(BorderFactory.createLoweredBevelBorder());
					currentAddressLine2Field.setBounds((4 * (currentAddressPanelWidth/6)), 30, (2 * (currentAddressPanelWidth/6))-30, 24);
					currentAddressLine2Field.setFocusable(true);
					currentAddressLine2Field.setDocument(new JTextFieldLimit(150));
					
					currentCountryLabel = new JLabel("Country* : ", SwingConstants.RIGHT);
					currentCountryLabel.setFont(font);
					currentCountryLabel.setForeground(Color.DARK_GRAY);
					currentCountryLabel.setBounds((currentAddressPanelWidth/8)-83, 60, 78, 20);
					currentCountryLabel.setFocusable(false);
					
					currentCountryField = new JComboBox();
					currentCountryField.setFont(font);
					currentCountryField.setForeground(Color.DARK_GRAY);
					currentCountryField.setBackground(Color.LIGHT_GRAY);
					currentCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
					currentCountryField.setBounds((currentAddressPanelWidth/8), 60, (currentAddressPanelWidth/8)-30, 24);
					currentCountryField.setFocusable(true);
					currentCountryField.addItem("");
					currentCountryField.setSelectedIndex(-1);
					currentCountryField.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent e)
						{
//							System.out.println(e.getItem() + " " + e.getStateChange());
							
							if(e.getStateChange()==1)
							{
								System.out.println("error at country field");
								int totalItemsState = currentStateField.getItemCount();
								boolean firstTimeState = false;
								
								if(totalItemsState==0)
									firstTimeState=true;
								
								currentStateField.removeKeyListener(null);
								
								if(!firstTimeState)
									currentStateField.setSelectedIndex(0);
								
								for(int k=totalItemsState-1 ; k>0 ; k--)
								{
			//						System.out.println("-> " + k);
									currentStateField.removeItemAt(k);
			//						System.out.println("-> " + k);
								}

								System.out.println("845");
								
								if(currentCountryField.getSelectedIndex()!=0)
								{
									System.out.println("I'm executed");
									
									currentStateField.addItem("");
									
									try
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
									
										String sql;
										ResultSet rs1;
										
										sql = "SELECT `country_id` FROM `country_field` WHERE `country_name`='" + (String)currentCountryField.getSelectedItem() + "'";
										rs1 = stmt.executeQuery(sql);
										rs1.next();
										String countryId = rs1.getString(1);
										
										System.out.println("868");
										
										sql = "SELECT `state_name` FROM `state_field` WHERE `country_id`='" + countryId + "'";
										rs1 = stmt.executeQuery(sql);
										
										System.out.println("873");
										
										while(rs1.next())
										{
											currentStateField.addItem(rs1.getString(1));
										}
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
									
									if(!firstTimeState)
										currentStateField.removeItemAt(0);
									
									currentStateField.addItemListener(new ItemListener()
									{
										public void itemStateChanged(ItemEvent e)
										{
											if(e.getStateChange()==1)
											{
												System.out.println("error at state field");
												int totalItemsDistrict = currentDistrictField.getItemCount();
												boolean firstTimeDistrict = false;
												
												if(totalItemsDistrict==0)
													firstTimeDistrict=true;
												
												currentDistrictField.removeKeyListener(null);
												
												if(!firstTimeDistrict)
													currentDistrictField.setSelectedIndex(0);
												
												for(int k=totalItemsDistrict-1 ; k>0 ; k--)
												{
							//						System.out.println("-> " + k);
													currentDistrictField.removeItemAt(k);
							//						System.out.println("-> " + k);
												}

												if(currentStateField.getSelectedIndex()!=0)
												{
							//						System.out.println("I'm executed");
													
													currentDistrictField.addItem("");
													
													try
													{
														Class.forName("com.mysql.jdbc.Driver");
														
														Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
														Statement stmt1 = con1.createStatement();
				
														String sql1 = "SELECT `state_id` FROM `state_field` WHERE `state_name`='" + (String)currentStateField.getSelectedItem() + "'";
														ResultSet rs1 = stmt1.executeQuery(sql1);
														rs1.next();
														String stateId = rs1.getString(1);
														
														String sql2 = "SELECT `district_name` FROM `district_field` WHERE `state_id`='" + stateId + "'";
														ResultSet rs2 = stmt1.executeQuery(sql2);
														
														while(rs2.next())
															currentDistrictField.addItem(rs2.getString(1));
														
														currentDistrictField.setEnabled(true);
													}
													catch(Exception exc)
													{
														JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
													}
													
													if(!firstTimeDistrict)
														currentDistrictField.removeItemAt(0);
													//it's here
												
													currentDistrictField.addActionListener(new ActionListener()
													{
														public void actionPerformed(ActionEvent e)
														{
															System.out.println("error at district field");
															
															currentCityField.removeAllItems();
															
															currentCityField.addItem("");
															
															if(currentDistrictField.getSelectedIndex()!=0)
															{
																try
																{
																	Class.forName("com.mysql.jdbc.Driver");
																	
																	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
																	Statement stmt1 = con1.createStatement();
							
																	String sql1 = "SELECT `district_id` FROM `district_field` WHERE `district_name`='" + (String)currentDistrictField.getSelectedItem() + "'";
																	ResultSet rs1 = stmt1.executeQuery(sql1);
																	rs1.next();
																	System.out.println("district id : " + rs1.getString(1));
																	String districtId = rs1.getString(1);
																	
																	String sql2 = "SELECT `city_name` FROM `city_field` WHERE `district_id`='" + districtId + "'";
																	ResultSet rs2 = stmt1.executeQuery(sql2);
																	
																	while(rs2.next())
																	{
																		System.out.println("city : " + rs2.getString(1));
																		currentCityField.addItem(rs2.getString(1));
																	}
																	
																	currentCityField.setEnabled(true);
																}
																catch(Exception exc)
																{
																	JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
																}
															}
														}
													});
												}
											}
										}
									});
								}
							}
						}
					});
					currentCountryField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(currentCountryField.getSelectedIndex()==0)
								currentCountryField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								currentCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					currentStateLabel = new JLabel("State* : ", SwingConstants.RIGHT);
					currentStateLabel.setFont(font);
					currentStateLabel.setForeground(Color.DARK_GRAY);
					currentStateLabel.setBounds((3 * (currentAddressPanelWidth/8))-60, 60, 55, 20);
					currentStateLabel.setFocusable(false);
					
					currentStateField = new JComboBox();
					currentStateField.setFont(font);
					currentStateField.setForeground(Color.DARK_GRAY);
					currentStateField.setBackground(Color.LIGHT_GRAY);
					currentStateField.setBorder(BorderFactory.createLoweredBevelBorder());
					currentStateField.setBounds((3 * (currentAddressPanelWidth/8)), 60, (currentAddressPanelWidth/8)-30, 24);
					currentStateField.setFocusable(true);
					currentStateField.addItem("");
					currentStateField.setSelectedIndex(-1);
					currentStateField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(currentStateField.getSelectedIndex()==0)
								currentStateField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								currentStateField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					currentDistrictLabel = new JLabel("District* : ", SwingConstants.RIGHT);
					currentDistrictLabel.setFont(font);
					currentDistrictLabel.setForeground(Color.DARK_GRAY);
					currentDistrictLabel.setBounds((5 * (currentAddressPanelWidth/8))-82, 60, 77, 20);
					currentDistrictLabel.setFocusable(false);
					
					currentDistrictField = new JComboBox();
					currentDistrictField.setFont(font);
					currentDistrictField.setForeground(Color.DARK_GRAY);
					currentDistrictField.setBackground(Color.LIGHT_GRAY);
					currentDistrictField.setBorder(BorderFactory.createLoweredBevelBorder());
					currentDistrictField.setBounds((5 * (currentAddressPanelWidth/8)), 60, (currentAddressPanelWidth/8)-30, 24);
					currentDistrictField.setFocusable(true);
					currentDistrictField.addItem("");
					currentDistrictField.setSelectedIndex(-1);
					currentDistrictField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(currentDistrictField.getSelectedIndex()==0)
								currentDistrictField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								currentDistrictField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					currentCityLabel = new JLabel("City* : ", SwingConstants.RIGHT);
					currentCityLabel.setFont(font);
					currentCityLabel.setForeground(Color.DARK_GRAY);
					currentCityLabel.setBounds((7 * (currentAddressPanelWidth/8))-54, 60, 49, 20);
					currentCityLabel.setFocusable(false);
					
					currentCityField = new JComboBox();
					currentCityField.setFont(font);
					currentCityField.setForeground(Color.DARK_GRAY);
					currentCityField.setBackground(Color.LIGHT_GRAY);
					currentCityField.setBorder(BorderFactory.createLoweredBevelBorder());
					currentCityField.setBounds((7 * (currentAddressPanelWidth/8)), 60, (currentAddressPanelWidth/8)-30, 24);
					currentCityField.setFocusable(true);
					currentCityField.addItem("");
					currentCityField.setSelectedIndex(-1);
					currentCityField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(currentCityField.getSelectedIndex()==0)
								currentCityField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								currentCityField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					currentAddressPanel.add(currentAddressLine1Label);
					currentAddressPanel.add(currentAddressLine1Field);
					currentAddressPanel.add(currentAddressLine2Label);
					currentAddressPanel.add(currentAddressLine2Field);
					currentAddressPanel.add(currentCityLabel);
					currentAddressPanel.add(currentCityField);
					currentAddressPanel.add(currentStateLabel);
					currentAddressPanel.add(currentStateField);
					currentAddressPanel.add(currentDistrictLabel);
					currentAddressPanel.add(currentDistrictField);
					currentAddressPanel.add(currentCountryLabel);
					currentAddressPanel.add(currentCountryField);
				
					
				// contactDetailsPanel
					border = new TitledBorder(border,"Contact Details",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					contactDetailsPanel = new JPanel();
					contactDetailsPanel.setLayout(null);
					contactDetailsPanel.setVisible(true);
					contactDetailsPanel.setBounds(40, 315, mainFooterPanelWidth-80, 75);
					contactDetailsPanel.setBackground(Color.LIGHT_GRAY);
					contactDetailsPanel.setBorder(border);
					
					addMemberPanel.add(contactDetailsPanel);
					
					phoneNumberLabel = new JLabel("Phone number : ", SwingConstants.RIGHT);
					phoneNumberLabel.setFont(font);
					phoneNumberLabel.setForeground(Color.DARK_GRAY);
					phoneNumberLabel.setBounds((contactDetailsPanelWidth/6)-122, 30, 117, 20);
					phoneNumberLabel.setFocusable(false);
					
					phoneNumberField = new JTextField();
					phoneNumberField.setFont(font);
					phoneNumberField.setForeground(Color.DARK_GRAY);
					phoneNumberField.setBackground(Color.LIGHT_GRAY);
					phoneNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
					phoneNumberField.setBounds((contactDetailsPanelWidth/6), 30, (contactDetailsPanelWidth/6)-30, 24);
					phoneNumberField.setDocument(new JTextFieldLimit(11));
					phoneNumberField.setFocusable(true);
					phoneNumberField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							String number = phoneNumberField.getText();
							
							if(number.length() == 11 || number.length() == 0)
							{
								phoneNumberAlertLabel.setVisible(false);

								for(int i=0 ; i<number.length() ; i++)
								{
									if(number.codePointAt(i) < 48 || number.codePointAt(i) > 57)
									{
										phoneNumberAlertLabel.setVisible(true);
										break;
									}
									else
										phoneNumberAlertLabel.setVisible(false);
								}
							}
							else
							{
								phoneNumberAlertLabel.setVisible(true);
							}
						}
					});
					
					phoneNumberAlertLabel = new JLabel("Please enter a valid Phone Number");
					phoneNumberAlertLabel.setFont(new Font("Cambria", Font.PLAIN, 13));
					phoneNumberAlertLabel.setForeground(Color.RED);
					phoneNumberAlertLabel.setBounds((contactDetailsPanelWidth/6), 50, 200, 24);
					phoneNumberAlertLabel.setFocusable(false);
					phoneNumberAlertLabel.setVisible(false);
					
					mobileNumberLabel = new JLabel("Mobile number* : ", SwingConstants.RIGHT);
					mobileNumberLabel.setFont(font);
					mobileNumberLabel.setForeground(Color.DARK_GRAY);
					mobileNumberLabel.setBounds((3 * (contactDetailsPanelWidth/6))-134, 30, 129, 20);
					mobileNumberLabel.setFocusable(false);
					
					mobileNumberField = new JTextField();
					mobileNumberField.setFont(font);
					mobileNumberField.setForeground(Color.DARK_GRAY);
					mobileNumberField.setBackground(Color.LIGHT_GRAY);
					mobileNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
					mobileNumberField.setBounds((3 * (contactDetailsPanelWidth/6)), 30, (contactDetailsPanelWidth/6)-30, 24);
					mobileNumberField.setDocument(new JTextFieldLimit(10));
					mobileNumberField.setFocusable(true);
					mobileNumberField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(mobileNumberField.getText().compareTo("")==0)
								mobileNumberField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								mobileNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
							
							String number = mobileNumberField.getText();
							
							if(number.length() == 10 || number.length() == 0)
							{
								mobileNumberAlertLabel.setVisible(false);

								for(int i=0 ; i<number.length() ; i++)
								{
									if(number.codePointAt(i) < 48 || number.codePointAt(i) > 57)
									{
										mobileNumberAlertLabel.setVisible(true);
										break;
									}
									else
										mobileNumberAlertLabel.setVisible(false);
								}
							}
							else
							{
								mobileNumberAlertLabel.setVisible(true);
							}
						}
					});
					
					mobileNumberAlertLabel = new JLabel("Please enter a valid Mobile Number");
					mobileNumberAlertLabel.setFont(new Font("Cambria", Font.PLAIN, 13));
					mobileNumberAlertLabel.setForeground(Color.RED);
					mobileNumberAlertLabel.setBounds((3 * (contactDetailsPanelWidth/6)), 50, 207, 24);
					mobileNumberAlertLabel.setFocusable(false);
					mobileNumberAlertLabel.setVisible(false);
					
					emailLabel = new JLabel("Email : ", SwingConstants.RIGHT);
					emailLabel.setFont(font);
					emailLabel.setForeground(Color.DARK_GRAY);
					emailLabel.setBounds(((5 * mainPersonDetailsPanelWidth)/6)-59, 30, 54, 20);
					emailLabel.setFocusable(false);
					
					emailField = new JTextField();
					emailField.setFont(font);
					emailField.setForeground(Color.DARK_GRAY);
					emailField.setBackground(Color.LIGHT_GRAY);
					emailField.setBorder(BorderFactory.createLoweredBevelBorder());
					emailField.setBounds(((5 * mainPersonDetailsPanelWidth/6)), 30, (mainPersonDetailsPanelWidth/6)-30, 24);
					emailField.setFocusable(true);
					emailField.setDocument(new JTextFieldLimit(50));
			
					contactDetailsPanel.add(phoneNumberLabel);
					contactDetailsPanel.add(phoneNumberField);
					contactDetailsPanel.add(phoneNumberAlertLabel);
					contactDetailsPanel.add(mobileNumberLabel);
					contactDetailsPanel.add(mobileNumberField);
					contactDetailsPanel.add(mobileNumberAlertLabel);
					contactDetailsPanel.add(emailLabel);
					contactDetailsPanel.add(emailField);
				
					
				// rootDetailsPanel
					border = new TitledBorder(border,"Root Details",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					rootDetailsPanel = new JPanel();
					rootDetailsPanel.setLayout(null);
					rootDetailsPanel.setVisible(true);
					rootDetailsPanel.setBounds(40, 420, mainFooterPanelWidth-80, 195);
					rootDetailsPanel.setBackground(Color.LIGHT_GRAY);
					rootDetailsPanel.setBorder(border);
					
					addMemberPanel.add(rootDetailsPanel);
					
					rootCountryLabel = new JLabel("Country* : ", SwingConstants.RIGHT);
					rootCountryLabel.setFont(font);
					rootCountryLabel.setForeground(Color.DARK_GRAY);
					rootCountryLabel.setBounds((rootDetailsPanelWidth/8)-83, 30, 78, 20);
					rootCountryLabel.setFocusable(false);
					
					rootCountryField = new JComboBox();
					rootCountryField.setFont(font);
					rootCountryField.setForeground(Color.DARK_GRAY);
					rootCountryField.setBackground(Color.LIGHT_GRAY);
					rootCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootCountryField.setBounds((rootDetailsPanelWidth/8), 30, (rootDetailsPanelWidth/8)-30, 24);
					rootCountryField.setFocusable(true);
					rootCountryField.addItem("");
					rootCountryField.setSelectedIndex(-1);
					rootCountryField.addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent e)
						{
//							System.out.println(e.getItem() + " " + e.getStateChange());
							
							if(e.getStateChange()==1)
							{
								System.out.println("error at country field");
								int totalItemsState = rootStateField.getItemCount();
								boolean firstTimeState = false;
								
								if(totalItemsState==0)
									firstTimeState=true;
								
								rootStateField.removeKeyListener(null);
								
								if(!firstTimeState)
									rootStateField.setSelectedIndex(0);
								
								for(int k=totalItemsState-1 ; k>0 ; k--)
								{
			//						System.out.println("-> " + k);
									rootStateField.removeItemAt(k);
			//						System.out.println("-> " + k);
								}

								System.out.println("845");
								
								if(rootCountryField.getSelectedIndex()!=0)
								{
									System.out.println("I'm executed");
									
									rootStateField.addItem("");
									
									try
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
									
										String sql;
										ResultSet rs1;
										
										sql = "SELECT `country_id` FROM `country_field` WHERE `country_name`='" + (String)rootCountryField.getSelectedItem() + "'";
										rs1 = stmt.executeQuery(sql);
										rs1.next();
										String countryId = rs1.getString(1);
										
										System.out.println("868");
										
										sql = "SELECT `state_name` FROM `state_field` WHERE `country_id`='" + countryId + "'";
										rs1 = stmt.executeQuery(sql);
										
										System.out.println("873");
										
										while(rs1.next())
										{
											rootStateField.addItem(rs1.getString(1));
										}
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
									
									if(!firstTimeState)
										rootStateField.removeItemAt(0);
									
									rootStateField.addItemListener(new ItemListener()
									{
										public void itemStateChanged(ItemEvent e)
										{
											if(e.getStateChange()==1)
											{
												System.out.println("error at state field");
												int totalItemsDistrict = rootDistrictField.getItemCount();
												boolean firstTimeDistrict = false;
												
												if(totalItemsDistrict==0)
													firstTimeDistrict=true;
												
												rootDistrictField.removeKeyListener(null);
												
												if(!firstTimeDistrict)
													rootDistrictField.setSelectedIndex(0);
												
												for(int k=totalItemsDistrict-1 ; k>0 ; k--)
												{
							//						System.out.println("-> " + k);
													rootDistrictField.removeItemAt(k);
							//						System.out.println("-> " + k);
												}

												if(rootStateField.getSelectedIndex()!=0)
												{
							//						System.out.println("I'm executed");
													
													rootDistrictField.addItem("");
													
													try
													{
														Class.forName("com.mysql.jdbc.Driver");
														
														Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
														Statement stmt1 = con1.createStatement();
				
														String sql1 = "SELECT `state_id` FROM `state_field` WHERE `state_name`='" + (String)rootStateField.getSelectedItem() + "'";
														ResultSet rs1 = stmt1.executeQuery(sql1);
														rs1.next();
														String stateId = rs1.getString(1);
														
														String sql2 = "SELECT `district_name` FROM `district_field` WHERE `state_id`='" + stateId + "'";
														ResultSet rs2 = stmt1.executeQuery(sql2);
														
														while(rs2.next())
															rootDistrictField.addItem(rs2.getString(1));
														
														rootDistrictField.setEnabled(true);
													}
													catch(Exception exc)
													{
														JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
													}
													
													if(!firstTimeDistrict)
														rootDistrictField.removeItemAt(0);
													//it's here
												
													rootDistrictField.addActionListener(new ActionListener()
													{
														public void actionPerformed(ActionEvent e)
														{
															System.out.println("error at district field");
															
															rootCityField.removeAllItems();
															
															rootCityField.addItem("");
															
															if(rootDistrictField.getSelectedIndex()!=0)
															{
																try
																{
																	Class.forName("com.mysql.jdbc.Driver");
																	
																	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
																	Statement stmt1 = con1.createStatement();
							
																	String sql1 = "SELECT `district_id` FROM `district_field` WHERE `district_name`='" + (String)rootDistrictField.getSelectedItem() + "'";
																	ResultSet rs1 = stmt1.executeQuery(sql1);
																	rs1.next();
																	System.out.println("district id : " + rs1.getString(1));
																	String districtId = rs1.getString(1);
																	
																	String sql2 = "SELECT `city_name` FROM `city_field` WHERE `district_id`='" + districtId + "'";
																	ResultSet rs2 = stmt1.executeQuery(sql2);
																	
																	while(rs2.next())
																	{
																		System.out.println("city : " + rs2.getString(1));
																		rootCityField.addItem(rs2.getString(1));
																	}
																	
																	rootCityField.setEnabled(true);
																}
																catch(Exception exc)
																{
																	JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
																}
															}
														}
													});
												}
											}
										}
									});
								}
							}
						}
					});
					rootCountryField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(rootCountryField.getSelectedIndex()==0)
								rootCountryField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								rootCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
			//		rootCountryField.setSelectedIndex(1);
					
					rootStateLabel = new JLabel("State* : ", SwingConstants.RIGHT);
					rootStateLabel.setFont(font);
					rootStateLabel.setForeground(Color.DARK_GRAY);
					rootStateLabel.setBounds((3 * (rootDetailsPanelWidth/8))-60, 30, 55, 20);
					rootStateLabel.setFocusable(false);
					
					rootStateField = new JComboBox();
					rootStateField.setFont(font);
					rootStateField.setForeground(Color.DARK_GRAY);
					rootStateField.setBackground(Color.LIGHT_GRAY);
					rootStateField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootStateField.setBounds((3 * (rootDetailsPanelWidth/8)), 30, (rootDetailsPanelWidth/8)-30, 24);
					rootStateField.setFocusable(true);
					rootStateField.addItem("");
					rootStateField.setSelectedIndex(-1);
					rootStateField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(rootStateField.getSelectedIndex()==0)
								rootStateField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								rootStateField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
			//		rootStateField.setSelectedIndex(1);
					
					rootDistrictLabel = new JLabel("District* : ", SwingConstants.RIGHT);
					rootDistrictLabel.setFont(font);
					rootDistrictLabel.setForeground(Color.DARK_GRAY);
					rootDistrictLabel.setBounds((5 * (rootDetailsPanelWidth/8))-82, 30, 77, 20);
					rootDistrictLabel.setFocusable(false);
					
					rootDistrictField = new JComboBox();
					rootDistrictField.setFont(font);
					rootDistrictField.setForeground(Color.DARK_GRAY);
					rootDistrictField.setBackground(Color.LIGHT_GRAY);
					rootDistrictField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootDistrictField.setBounds((5 *(rootDetailsPanelWidth/8)), 30, (rootDetailsPanelWidth/8)-30, 24);
					rootDistrictField.setFocusable(true);
					rootDistrictField.addItem("");
					rootDistrictField.setSelectedIndex(-1);
					rootDistrictField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(rootDistrictField.getSelectedIndex()==0)
								rootDistrictField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								rootDistrictField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					rootCityLabel = new JLabel("City* : ", SwingConstants.RIGHT);
					rootCityLabel.setFont(font);
					rootCityLabel.setForeground(Color.DARK_GRAY);
					rootCityLabel.setBounds((7 * (rootDetailsPanelWidth/8))-54, 30, 49, 20);
					rootCityLabel.setFocusable(false);
					
					rootCityField = new JComboBox();
					rootCityField.setFont(font);
					rootCityField.setForeground(Color.DARK_GRAY);
					rootCityField.setBackground(Color.LIGHT_GRAY);
					rootCityField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootCityField.setBounds((7 *(rootDetailsPanelWidth/8)), 30, (rootDetailsPanelWidth/8)-30, 24);
					rootCityField.setFocusable(true);
					rootCityField.addItem("");
					rootCityField.setSelectedIndex(-1);
					rootCityField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(rootCityField.getSelectedIndex()==0)
								rootCityField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								rootCityField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
			//		rootCityField.setSelectedIndex(1);
					
					rootGotraLabel = new JLabel("Gotra* : ", SwingConstants.RIGHT);
					rootGotraLabel.setFont(font);
					rootGotraLabel.setForeground(Color.DARK_GRAY);
					rootGotraLabel.setBounds((rootDetailsPanelWidth/6)-64, 60, 59, 20);
					rootGotraLabel.setFocusable(false);
					
					rootGotraField = new JComboBox();
					rootGotraField.setFont(font);
					rootGotraField.setForeground(Color.DARK_GRAY);
					rootGotraField.setBackground(Color.LIGHT_GRAY);
					rootGotraField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootGotraField.setBounds((rootDetailsPanelWidth/6), 60, (2 * (rootDetailsPanelWidth/6))-30, 24);
					rootGotraField.setFocusable(true);
					rootGotraField.addItem("");
					rootGotraField.setSelectedIndex(0);
					
			/*		try
					{
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
						Statement stmt = con.createStatement();
					
						String sql = "SELECT `gotra_name` FROM `gotra_field`";
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next())
							rootGotraField.addItem(rs.getString(1));
					}
					catch(Exception exc)
					{
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}  */
					
					rootGotraField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(rootGotraField.getSelectedIndex()==0)
								rootGotraField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								rootGotraField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					rootKulDeviLabel = new JLabel("KulDevi* : ", SwingConstants.RIGHT);
					rootKulDeviLabel.setFont(font);
					rootKulDeviLabel.setForeground(Color.DARK_GRAY);
					rootKulDeviLabel.setBounds((4 * (rootDetailsPanelWidth/6))-82, 60, 77, 20);
					rootKulDeviLabel.setFocusable(false);
					
					rootKulDeviField = new JComboBox();
					rootKulDeviField.setFont(font);
					rootKulDeviField.setForeground(Color.DARK_GRAY);
					rootKulDeviField.setBackground(Color.LIGHT_GRAY);
					rootKulDeviField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootKulDeviField.setBounds((4 * (rootDetailsPanelWidth/6)), 60, (2 * (rootDetailsPanelWidth/6))-30, 24);
					rootKulDeviField.setFocusable(true);
					rootKulDeviField.addItem("");
					rootKulDeviField.setSelectedIndex(0);
					
			/*		try
					{
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
						Statement stmt = con.createStatement();
					
						String sql = "SELECT `kuldevi_name` FROM `kuldevi_field`";
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next())
							rootKulDeviField.addItem(rs.getString(1));
					}
					catch(Exception exc)
					{
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}  */
					
					rootKulDeviField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(rootKulDeviField.getSelectedIndex()==0)
								rootKulDeviField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								rootKulDeviField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					occupationLabel = new JLabel("Occupation* : ", SwingConstants.RIGHT);
					occupationLabel.setFont(font);
					occupationLabel.setForeground(Color.DARK_GRAY);
					occupationLabel.setBounds((rootDetailsPanelWidth/6)-112, 90, 107, 20);
					occupationLabel.setFocusable(false);
					
					businessRadioButton = new JRadioButton("Business : ");
					businessRadioButton.setFont(font);
					businessRadioButton.setForeground(Color.DARK_GRAY);
					businessRadioButton.setBackground(Color.LIGHT_GRAY);
					businessRadioButton.setBounds((rootDetailsPanelWidth/6) + ((rootDetailsPanelWidth - (rootDetailsPanelWidth/6))/6) - 99, 90, 99, 20);
					businessRadioButton.setFocusable(true);
					businessRadioButton.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(!(businessRadioButton.isSelected() || serviceRadioButton.isSelected()))
							{
								occupationLabel.setForeground(Color.RED);
								businessRadioButton.setForeground(Color.RED);
								serviceRadioButton.setForeground(Color.RED);
							}
							else
							{
								occupationLabel.setForeground(Color.DARK_GRAY);
								businessRadioButton.setForeground(Color.DARK_GRAY);
								serviceRadioButton.setForeground(Color.DARK_GRAY);
							}
						}
					});
					
					businessField = new JComboBox();
					businessField.setFont(font);
					businessField.setForeground(Color.DARK_GRAY);
					businessField.setBackground(Color.LIGHT_GRAY);
					businessField.setBorder(BorderFactory.createLoweredBevelBorder());
					businessField.setBounds((rootDetailsPanelWidth/6) + ((rootDetailsPanelWidth - (rootDetailsPanelWidth/6))/6), 90, (2 * (rootDetailsPanelWidth - (rootDetailsPanelWidth/6))/6)-30, 24);
					businessField.setFocusable(true);
					businessField.setEnabled(false);
					businessField.addItem("");
					businessRadioButton.addChangeListener(new ChangeListener()
					{
						public void stateChanged(ChangeEvent e)
						{
							if(businessRadioButton.isSelected())
								businessField.setEnabled(true);
							else
								businessField.setEnabled(false);
						}
					});
					
					serviceRadioButton = new JRadioButton("Service : ");
					serviceRadioButton.setFont(font);
					serviceRadioButton.setForeground(Color.DARK_GRAY);
					serviceRadioButton.setBackground(Color.LIGHT_GRAY);
					serviceRadioButton.setBounds((rootDetailsPanelWidth/6) + (4 * (rootDetailsPanelWidth - (rootDetailsPanelWidth/6))/6) - 90, 90, 90, 20);
					serviceRadioButton.setFocusable(true);
					serviceRadioButton.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(!(businessRadioButton.isSelected() || serviceRadioButton.isSelected()))
							{
								occupationLabel.setForeground(Color.RED);
								businessRadioButton.setForeground(Color.RED);
								serviceRadioButton.setForeground(Color.RED);
							}
							else
							{
								occupationLabel.setForeground(Color.DARK_GRAY);
								businessRadioButton.setForeground(Color.DARK_GRAY);
								serviceRadioButton.setForeground(Color.DARK_GRAY);
							}
						}
					});
					
					serviceField = new JComboBox();
					serviceField.setFont(font);
					serviceField.setForeground(Color.DARK_GRAY);
					serviceField.setBackground(Color.LIGHT_GRAY);
					serviceField.setBorder(BorderFactory.createLoweredBevelBorder());
					serviceField.setBounds((rootDetailsPanelWidth/6) + (4 * (rootDetailsPanelWidth - (rootDetailsPanelWidth/6))/6), 90, (2 * (rootDetailsPanelWidth - (rootDetailsPanelWidth/6))/6)-30, 24);
					serviceField.setFocusable(true);
					serviceField.setEnabled(false);
					serviceField.addItem("");
					serviceRadioButton.addChangeListener(new ChangeListener()
					{
						public void stateChanged(ChangeEvent e)
						{
							if(serviceRadioButton.isSelected())
								serviceField.setEnabled(true);
							else
								serviceField.setEnabled(false);
						}
					});
					
					occupationButtonGroup = new ButtonGroup();
					occupationButtonGroup.add(businessRadioButton);
					occupationButtonGroup.add(serviceRadioButton);
					
					rootKulLabel = new JLabel("Kul : ", SwingConstants.RIGHT);
					rootKulLabel.setFont(font);
					rootKulLabel.setForeground(Color.DARK_GRAY);
					rootKulLabel.setBounds((rootDetailsPanelWidth/6)-42, 120, 37, 20);
					rootKulLabel.setFocusable(false);
					
					rootKulField = new JComboBox();
					rootKulField.setFont(font);
					rootKulField.setForeground(Color.DARK_GRAY);
					rootKulField.setBackground(Color.LIGHT_GRAY);
					rootKulField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootKulField.setBounds((rootDetailsPanelWidth/6), 120, (rootDetailsPanelWidth/6)-30, 24);
					rootKulField.setFocusable(true);
					rootKulField.addItem("");
					rootKulField.setSelectedIndex(0);
					
		/*			try
					{
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
						Statement stmt = con.createStatement();
					
						String sql = "SELECT `kuldevi_name` FROM `kuldevi_field`";
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next())
							rootGotraField.addItem(rs.getString(1));
					}
					catch(Exception exc)
					{
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}  */
					
					rootMoshalSurnameLabel = new JLabel("Mosal's Surname : ", SwingConstants.RIGHT);
					rootMoshalSurnameLabel.setFont(font);
					rootMoshalSurnameLabel.setForeground(Color.DARK_GRAY);
					rootMoshalSurnameLabel.setBounds((3 * (rootDetailsPanelWidth/6))-138, 120, 133, 20);
					rootMoshalSurnameLabel.setFocusable(false);
					
					rootMoshalSurnameField = new JComboBox();
					rootMoshalSurnameField.setFont(font);
					rootMoshalSurnameField.setForeground(Color.DARK_GRAY);
					rootMoshalSurnameField.setBackground(Color.LIGHT_GRAY);
					rootMoshalSurnameField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootMoshalSurnameField.setBounds((3 * (rootDetailsPanelWidth/6)), 120, (rootDetailsPanelWidth/6)-30, 24);
					rootMoshalSurnameField.setFocusable(true);
					rootMoshalSurnameField.addItem("");
					rootMoshalSurnameField.setSelectedIndex(0);
					
					rootTalGolLabel = new JLabel("Tal Gol : ", SwingConstants.RIGHT);
					rootTalGolLabel.setFont(font);
					rootTalGolLabel.setForeground(Color.DARK_GRAY);
					rootTalGolLabel.setBounds((5 * (rootDetailsPanelWidth/6))-68, 120, 63, 20);
					rootTalGolLabel.setFocusable(false);
					
					rootTalGolField = new JComboBox();
					rootTalGolField.setFont(font);
					rootTalGolField.setForeground(Color.DARK_GRAY);
					rootTalGolField.setBackground(Color.LIGHT_GRAY);
					rootTalGolField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootTalGolField.setBounds((5 * (rootDetailsPanelWidth/6)), 120, (rootDetailsPanelWidth/6)-30, 24);
					rootTalGolField.setFocusable(true);
					rootTalGolField.addItem("");
					rootTalGolField.setSelectedIndex(0);
					
					rootExpertiseOrAwardsLabel = new JLabel("Other Expertise or Awards : ", SwingConstants.RIGHT);
					rootExpertiseOrAwardsLabel.setFont(font);
					rootExpertiseOrAwardsLabel.setForeground(Color.DARK_GRAY);
					rootExpertiseOrAwardsLabel.setBounds((2 * (rootDetailsPanelWidth/6))-209, 150, 204, 20);
					rootExpertiseOrAwardsLabel.setFocusable(false);
					
					rootExpertiseOrAwardsField = new JTextField();
					rootExpertiseOrAwardsField.setFont(font);
					rootExpertiseOrAwardsField.setForeground(Color.DARK_GRAY);
					rootExpertiseOrAwardsField.setBackground(Color.LIGHT_GRAY);
					rootExpertiseOrAwardsField.setBorder(BorderFactory.createLoweredBevelBorder());
					rootExpertiseOrAwardsField.setBounds((2 * (rootDetailsPanelWidth/6)), 150, (4 * (rootDetailsPanelWidth/6))-30, 24);
					rootExpertiseOrAwardsField.setFocusable(true);
					rootExpertiseOrAwardsField.setDocument(new JTextFieldLimit(150));
					
					rootDetailsPanel.add(rootCityLabel);
					rootDetailsPanel.add(rootCityField);
					rootDetailsPanel.add(rootDistrictLabel);
					rootDetailsPanel.add(rootDistrictField);
					rootDetailsPanel.add(rootStateLabel);
					rootDetailsPanel.add(rootStateField);
					rootDetailsPanel.add(rootCountryLabel);
					rootDetailsPanel.add(rootCountryField);
					rootDetailsPanel.add(rootGotraLabel);
					rootDetailsPanel.add(rootGotraField);
					rootDetailsPanel.add(rootKulDeviLabel);
					rootDetailsPanel.add(rootKulDeviField);
					rootDetailsPanel.add(occupationLabel);
					rootDetailsPanel.add(businessRadioButton);
					rootDetailsPanel.add(businessField);
					rootDetailsPanel.add(serviceRadioButton);
					rootDetailsPanel.add(serviceField);
					rootDetailsPanel.add(rootKulLabel);
					rootDetailsPanel.add(rootKulField);
					rootDetailsPanel.add(rootMoshalSurnameLabel);
					rootDetailsPanel.add(rootMoshalSurnameField);
					rootDetailsPanel.add(rootTalGolLabel);
					rootDetailsPanel.add(rootTalGolField);
					rootDetailsPanel.add(rootExpertiseOrAwardsLabel);
					rootDetailsPanel.add(rootExpertiseOrAwardsField);
			
				
				// familyDetailsPanel
					border = new TitledBorder(border,"Family Members' Details",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					familyDetailsPanel = new JPanel();
					familyDetailsPanel.setLayout(null);
					familyDetailsPanel.setVisible(true);
					familyDetailsPanel.setBounds(40, 645, familyDetailsPanelWidth, familyDetailsPanelHeight);
					familyDetailsPanel.setBackground(Color.LIGHT_GRAY);
					familyDetailsPanel.setBorder(border);
					
					addMemberPanel.add(familyDetailsPanel);
				
					numberOfFamilyMembersLabel = new JLabel("Total Number of Family Members* : ", SwingConstants.RIGHT);
					numberOfFamilyMembersLabel.setFont(font);
					numberOfFamilyMembersLabel.setForeground(Color.DARK_GRAY);
					numberOfFamilyMembersLabel.setBounds((2 * (familyDetailsPanelWidth/6))-268, 30, 263, 20);
					numberOfFamilyMembersLabel.setFocusable(false);
					
					numberOfFamilyMembersField = new JComboBox();
					numberOfFamilyMembersField.setFont(font);
					numberOfFamilyMembersField.setForeground(Color.DARK_GRAY);
					numberOfFamilyMembersField.setBackground(Color.LIGHT_GRAY);
					numberOfFamilyMembersField.setBorder(BorderFactory.createLoweredBevelBorder());
					numberOfFamilyMembersField.setBounds((2 * (familyDetailsPanelWidth/6)), 30, (familyDetailsPanelWidth/12), 24);
					numberOfFamilyMembersField.setFocusable(true);
					numberOfFamilyMembersField.addItem("");
					numberOfFamilyMembersField.addItem("1");
					numberOfFamilyMembersField.addItem("2");
					numberOfFamilyMembersField.addItem("3");
					numberOfFamilyMembersField.addItem("4");
					numberOfFamilyMembersField.addItem("5");
					numberOfFamilyMembersField.addItem("6");
					numberOfFamilyMembersField.addItem("7");
					numberOfFamilyMembersField.addItem("8");
					numberOfFamilyMembersField.addItem("9");
					numberOfFamilyMembersField.addItem("10");
					numberOfFamilyMembersField.addItem("11");
					numberOfFamilyMembersField.addItem("12");
					numberOfFamilyMembersField.addItem("13");
					numberOfFamilyMembersField.addItem("14");
					numberOfFamilyMembersField.addItem("15");
					numberOfFamilyMembersField.setSelectedIndex(0);
					numberOfFamilyMembersField.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(numberOfFamilyMembersField.getSelectedIndex()==0)
								numberOfFamilyMembersField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
							else
								numberOfFamilyMembersField.setBorder(BorderFactory.createLoweredBevelBorder());
						}
					});
					
					addFamilyMembers = new JButton("Add Family Member");
					addFamilyMembers.setForeground(Color.LIGHT_GRAY);
					addFamilyMembers.setBackground(Color.DARK_GRAY);
					addFamilyMembers.setBounds((2 * (familyDetailsPanelWidth/6)) + (familyDetailsPanelWidth/12) + 30, 30, 150, 24);
					addFamilyMembers.setFocusable(true);
					addFamilyMembers.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							if(addFamilyMembers.isEnabled())
							{
								final int numberOfMembers = numberOfFamilyMembersField.getSelectedIndex();
								
								if(numberOfMembers!=0)
								{
									numberOfFamilyMembersField.setBorder(BorderFactory.createLoweredBevelBorder());
									
									familyDetailsPanel.setBounds(40, 645, familyDetailsPanelWidth, (numberOfMembers * 250)+20+50);
									addMemberPanel.setPreferredSize(new Dimension(mainFooterPanelWidth-20, 645+(numberOfMembers * 250)+20+50+30+75+30+40));
									addMemberPanelScrollPane.repaint();
									otherDetailsPanel.setBounds(40, 645+(numberOfMembers * 250)+20+50+30, otherDetailsPanelWidth, otherDetailsPanelHeight);
									otherDetailsPanel.repaint();
									submitFormButton.setBounds(mainFooterPanelWidth-380, 645+(numberOfMembers * 250)+20+50+30+75+20, 150, 24);
									resetFormButton.setBounds(mainFooterPanelWidth-200, 645+(numberOfMembers * 250)+20+50+30+75+20, 150, 24);
									resetFormWithFormNumberButton.setBounds(mainFooterPanelWidth-380-180-50, 645+(numberOfMembers * 250)+20+50+30+75+20, 200, 24);
									referencebyLabel.setBounds(50, 645+(numberOfMembers * 250)+20+50+30+75+20, 110, 24);
									referencebyField.setBounds(165, 645+(numberOfMembers * 250)+20+50+30+75+20, (mainFooterPanelWidth/6), 24);
									
									familyMemberMainPersonNoticeLabel.setVisible(true);
									resetFamilyPanelButton.setBounds((5 * (familyDetailsPanelWidth/6)), (numberOfMembers * 250)+35, (familyDetailsPanelWidth/6)-30, 24);
									resetFamilyPanelButton.setVisible(true);
									
									numberOfFamilyMembersLabel.setVisible(false);
									numberOfFamilyMembersField.setVisible(false);
									addFamilyMembers.setVisible(false);
									
									for(int i=0 ; i<numberOfMembers ; i++)
									{
										familyMemberPanel[i].setVisible(true);
										
								/*		familyMemberNumber[i].setVisible(true);
										familyMemberSurnameLabel[i].setVisible(true);
										familyMemberSurnameField[i].setVisible(true);
										familyMemberNameLabel[i].setVisible(true);
										familyMemberNameField[i].setVisible(true);
										familyMemberFatherNameLabel[i].setVisible(true);
										familyMemberFatherNameField[i].setVisible(true);
										familyMemberRelationLabel[i].setVisible(true);
										familyMemberRelationField[i].setVisible(true);
										familyMemberBirthDateLabel[i].setVisible(true);
										familyMemberBirthDateField[i].setVisible(true);
										familyMemberMaritualStatusLabel[i].setVisible(true);
										familyMemberMarriedRadioButton[i].setVisible(true);
										familyMemberUnmarriedRadioButton[i].setVisible(true);
										familyMemberGenderLabel[i].setVisible(true);
										familyMemberGenderMaleRadioButton[i].setVisible(true);
										familyMemberGenderFemaleRadioButton[i].setVisible(true);
										whatsappNumberLabel[i].setVisible(true);
										whatsappNumberField[i].setVisible(true);  */
									}
									
									resetFamilyPanelButton.addMouseListener(new MouseAdapter()
									{
										public void mouseClicked(MouseEvent e)
										{
											resetFamilyPanel(numberOfFamilyMembersField.getSelectedIndex());
										}
									});
									
									familyMemberRelationField[0].setSelectedIndex(1);
									familyMemberNameField[0].setText(mainPersonNameField.getText());
									familyMemberFatherNameField[0].setText(mainPersonFatherNameField.getText());
	
									for(int i=0 ; i<numberOfFamilyMembersField.getSelectedIndex() ; i++)
									{
										familyMemberFatherNameField[i].setText(mainPersonFatherNameField.getText());
										familyMemberSurnameField[i].setSelectedIndex(mainPersonSurnameField.getSelectedIndex());
									}
									
					/*				for(int i=0 ; i<numberOfFamilyMembersField.getSelectedIndex() ; i++)
									{
										familyMemberSurnameField[i].setSelectedIndex(mainPersonSurnameField.getSelectedIndex());
									} */
								}
								else
								{
									numberOfFamilyMembersField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
							}
						}
					});

					familyMemberMainPersonNoticeLabel = new JLabel("*Respectly include the details of Main Person of the family in the family member's list", SwingConstants.LEFT);
					familyMemberMainPersonNoticeLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
					familyMemberMainPersonNoticeLabel.setForeground(Color.DARK_GRAY);
					familyMemberMainPersonNoticeLabel.setBounds(familyDetailsPanelWidth-560, 8, 530, 20);
					familyMemberMainPersonNoticeLabel.setFocusable(false);
					familyMemberMainPersonNoticeLabel.setVisible(false);
					
					resetFamilyPanelButton = new JButton("Reset");
					resetFamilyPanelButton.setForeground(Color.LIGHT_GRAY);
					resetFamilyPanelButton.setBackground(Color.DARK_GRAY);
					resetFamilyPanelButton.setFocusable(true);
					resetFamilyPanelButton.setVisible(true);
					resetFamilyPanelButton.setVisible(false);
					
					familyDetailsPanel.add(resetFamilyPanelButton);
					familyDetailsPanel.add(familyMemberMainPersonNoticeLabel);
					
					familyDetailsPanel.add(numberOfFamilyMembersLabel);
					familyDetailsPanel.add(numberOfFamilyMembersField);
					familyDetailsPanel.add(addFamilyMembers);
					
					familyMemberNumber = new JLabel[15];
					familyMemberSurnameLabel = new JLabel[15];
					familyMemberSurnameField = new JComboBox[15];
					familyMemberNameLabel = new JLabel[15];
					familyMemberNameField = new JTextField[15];
					familyMemberFatherNameLabel = new JLabel[15];
					familyMemberFatherNameField = new JTextField[15];
					familyMemberRelationLabel = new JLabel[15];
					familyMemberRelationField = new JComboBox[15];
					familyMemberBirthDateLabel = new JLabel[15];
//					familyMemberBirthDateField = new JDateChooser[15];
					
					familyMemberPanel = new JPanel[15];
					familyMemberEducationPanel = new JPanel[15];
					numberOfEducationQualificationLabel = new JLabel[15];
					numberOfEducationQualificationField = new JComboBox[15];
					addEducationQualification = new JButton[15];
					familyMemberQualificationLabel = new JLabel[15][8];
					familyMemberQualificationField = new JComboBox[15][8];
					familyMemberStreamLabel = new JLabel[15][8];
					familyMemberStreamField = new JComboBox[15][8];
					familyMemberDegreeLabel = new JLabel[15][8];
					familyMemberDegreeField = new JComboBox[15][8];

					familyMemberMaritualStatusLabel = new JLabel[15];
					familyMemberMarriedRadioButton = new JRadioButton[15];
					familyMemberUnmarriedRadioButton = new JRadioButton[15];
					familyMemberMaritualStatusGroup = new ButtonGroup[15];
					familyMemberGenderLabel = new JLabel[15];
					familyMemberGenderMaleRadioButton = new JRadioButton[15];
					familyMemberGenderFemaleRadioButton = new JRadioButton[15];
					familyMemberGenderGroup = new ButtonGroup[15];
					whatsappNumberLabel = new JLabel[15];
					whatsappNumberField = new JTextField[15];
	
					for(int i=0 ; i<15 ; i++)
					{
						final int rowNumber = i;
						
						int firstRowY = 0;
						int secondRowY = 0;
						int thirdRowY = 0;
						int fourthRowY = 0;
						int fifthRowY = 0;
						int sixthRowY = 0;
						
//						if(i == 0)
//						{
							firstRowY = 10;
							secondRowY = 40;
							thirdRowY = 70;
							fourthRowY = 100;
							fifthRowY = 180;
							sixthRowY = 210;
//						}
//						else
//						{
//							firstRowY = (i*250) + 30;
//							secondRowY = (i*250) + 60;
//							thirdRowY = (i*250) + 90;
//							fourthRowY = (i*250) + 120;
//							fifthRowY = (i*250) + 200;
//							sixthRowY = (i*250) + 230;
//						}
						
						String familyMemberNumberString = "Member " + (i + 1) + " : ";
						
						familyMemberPanel[i] = new JPanel();
						familyMemberPanel[i].setLayout(null);
						familyMemberPanel[i].setVisible(false);
						familyMemberPanel[i].setBounds(20, (i * 250)+30, familyDetailsPanelWidth-40, 250);
						familyMemberPanel[i].setBackground(Color.LIGHT_GRAY);
						familyMemberPanel[i].setBorder(BorderFactory.createLoweredBevelBorder());
						
						familyMemberNumber[i] = new JLabel(familyMemberNumberString);
						familyMemberNumber[i].setFont(new Font("Cambria", Font.BOLD, 17));
						familyMemberNumber[i].setForeground(Color.DARK_GRAY);
						familyMemberNumber[i].setBounds(10, firstRowY, 120, 20);
						familyMemberNumber[i].setFocusable(false);
						familyMemberNumber[i].setVisible(true);
						
						familyMemberSurnameLabel[i] = new JLabel("Surname* : ", SwingConstants.RIGHT);
						familyMemberSurnameLabel[i].setFont(font);
						familyMemberSurnameLabel[i].setForeground(Color.DARK_GRAY);
						familyMemberSurnameLabel[i].setBounds((familyDetailsPanelWidth/6)-87-20, secondRowY, 82, 20);
						familyMemberSurnameLabel[i].setFocusable(false);
						familyMemberSurnameLabel[i].setVisible(true);
						
						familyMemberSurnameField[i] = new JComboBox();
						familyMemberSurnameField[i].setFont(font);
						familyMemberSurnameField[i].setForeground(Color.DARK_GRAY);
						familyMemberSurnameField[i].setBackground(Color.LIGHT_GRAY);
						familyMemberSurnameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
						familyMemberSurnameField[i].setBounds((familyDetailsPanelWidth/6)-20, secondRowY, (familyDetailsPanelWidth/6)-30, 24);
						familyMemberSurnameField[i].setFocusable(true);
						familyMemberSurnameField[i].setVisible(true);
						familyMemberSurnameField[i].addItem("");
						familyMemberSurnameField[i].setSelectedIndex(mainPersonSurnameField.getSelectedIndex());
						familyMemberSurnameField[i].addFocusListener(new FocusAdapter()
						{
							public void focusLost(FocusEvent e)
							{
								if(familyMemberSurnameField[rowNumber].getSelectedIndex()==0)
									familyMemberSurnameField[rowNumber].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								else
									familyMemberSurnameField[rowNumber].setBorder(BorderFactory.createLoweredBevelBorder());
							}
						});
						
						familyMemberNameLabel[i] = new JLabel("Name* : ", SwingConstants.RIGHT);
						familyMemberNameLabel[i].setFont(font);
						familyMemberNameLabel[i].setForeground(Color.DARK_GRAY);
						familyMemberNameLabel[i].setBounds((3 * (familyDetailsPanelWidth/6))-66-20, secondRowY, 61, 20);
						familyMemberNameLabel[i].setFocusable(false);
						familyMemberNameLabel[i].setVisible(true);
						
						familyMemberNameField[i] = new JTextField();
						familyMemberNameField[i].setFont(font);
						familyMemberNameField[i].setForeground(Color.DARK_GRAY);
						familyMemberNameField[i].setBackground(Color.LIGHT_GRAY);
						familyMemberNameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
						familyMemberNameField[i].setBounds((3 * (familyDetailsPanelWidth/6))-20, secondRowY, (familyDetailsPanelWidth/6)-30, 24);
						familyMemberNameField[i].setFocusable(true);
						familyMemberNameField[i].setVisible(true);
						familyMemberNameField[i].setDocument(new JTextFieldLimit(15));
						familyMemberNameField[i].addFocusListener(new FocusAdapter()
						{
							public void focusLost(FocusEvent e)
							{
								if(familyMemberNameField[rowNumber].getText().compareTo("")==0)
									familyMemberNameField[rowNumber].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								else
									familyMemberNameField[rowNumber].setBorder(BorderFactory.createLoweredBevelBorder());
							}
						});
						
						familyMemberFatherNameLabel[i] = new JLabel("Father's Name* : ", SwingConstants.RIGHT);
						familyMemberFatherNameLabel[i].setFont(font);
						familyMemberFatherNameLabel[i].setForeground(Color.DARK_GRAY);
						familyMemberFatherNameLabel[i].setBounds((5 * (familyDetailsPanelWidth/6))-128-20, secondRowY, 123, 20);
						familyMemberFatherNameLabel[i].setFocusable(false);
						familyMemberFatherNameLabel[i].setVisible(true);
						
						familyMemberFatherNameField[i] = new JTextField();
						familyMemberFatherNameField[i].setFont(font);
						familyMemberFatherNameField[i].setForeground(Color.DARK_GRAY);
						familyMemberFatherNameField[i].setBackground(Color.LIGHT_GRAY);
						familyMemberFatherNameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
						familyMemberFatherNameField[i].setBounds((5 * (familyDetailsPanelWidth/6))-20, secondRowY, (familyDetailsPanelWidth/6)-30, 24);
						familyMemberFatherNameField[i].setFocusable(true);
						familyMemberFatherNameField[i].setVisible(true);
						familyMemberFatherNameField[i].addFocusListener(new FocusAdapter()
						{
							public void focusLost(FocusEvent e)
							{
								if(familyMemberFatherNameField[rowNumber].getText().compareTo("")==0)
									familyMemberFatherNameField[rowNumber].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								else
									familyMemberFatherNameField[rowNumber].setBorder(BorderFactory.createLoweredBevelBorder());
							}
						});
						
						familyMemberRelationLabel[i] = new JLabel("Relation with the Main Person of the Family* : ", SwingConstants.RIGHT);
						familyMemberRelationLabel[i].setFont(font);
						familyMemberRelationLabel[i].setForeground(Color.DARK_GRAY);
						familyMemberRelationLabel[i].setBounds((3 * (familyDetailsPanelWidth/6))-342-20, thirdRowY, 337, 20);
						familyMemberRelationLabel[i].setFocusable(false);
						familyMemberRelationLabel[i].setVisible(true);
						
						familyMemberRelationField[i] = new JComboBox();
						familyMemberRelationField[i].setFont(font);
						familyMemberRelationField[i].setForeground(Color.DARK_GRAY);
						familyMemberRelationField[i].setBackground(Color.LIGHT_GRAY);
						familyMemberRelationField[i].setBorder(BorderFactory.createLoweredBevelBorder());
						familyMemberRelationField[i].setBounds((3 * (familyDetailsPanelWidth/6))-20, thirdRowY, (familyDetailsPanelWidth/6)-30, 24);
						familyMemberRelationField[i].setFocusable(true);
						familyMemberRelationField[i].addItem("");
						
						familyMemberRelationField[i].setVisible(true);
						familyMemberRelationField[i].addFocusListener(new FocusAdapter()
						{
							public void focusLost(FocusEvent e)
							{
								if(familyMemberRelationField[rowNumber].getSelectedIndex()==0)
									familyMemberRelationField[rowNumber].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								else
									familyMemberRelationField[rowNumber].setBorder(BorderFactory.createLoweredBevelBorder());
							}
						});
						
						familyMemberBirthDateLabel[i] = new JLabel("BirthDate : ", SwingConstants.RIGHT);
						familyMemberBirthDateLabel[i].setFont(font);
						familyMemberBirthDateLabel[i].setForeground(Color.DARK_GRAY);
						familyMemberBirthDateLabel[i].setBounds((5 * (familyDetailsPanelWidth/6))-87-20, thirdRowY, 82, 20);
						familyMemberBirthDateLabel[i].setFocusable(false);
						familyMemberBirthDateLabel[i].setVisible(true);
						
//						familyMemberBirthDateField[i] = new JDateChooser();
//						familyMemberBirthDateField[i].setFont(font);
//						familyMemberBirthDateField[i].setForeground(Color.DARK_GRAY);
//						familyMemberBirthDateField[i].setBackground(Color.LIGHT_GRAY);
//						familyMemberBirthDateField[i].setBorder(BorderFactory.createLoweredBevelBorder());
//						familyMemberBirthDateField[i].setBounds((5 * (familyDetailsPanelWidth/6))-20, thirdRowY, (familyDetailsPanelWidth/6)-30, 24);
//						familyMemberBirthDateField[i].setFocusable(true);
//						familyMemberBirthDateField[i].setVisible(true);
						
						border = new TitledBorder(border,"Education Qualification",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						familyMemberEducationPanel[i] = new JPanel();
						familyMemberEducationPanel[i].setLayout(null);
						familyMemberEducationPanel[i].setVisible(true);
						familyMemberEducationPanel[i].setBounds(10, fourthRowY, familyMemberEducationPanelWidth, 75);
						familyMemberEducationPanel[i].setBackground(Color.LIGHT_GRAY);
						familyMemberEducationPanel[i].setBorder(border);
						
						numberOfEducationQualificationLabel[i] = new JLabel("Total number of Education Qualifications : ", SwingConstants.RIGHT);
						numberOfEducationQualificationLabel[i].setFont(font);
						numberOfEducationQualificationLabel[i].setForeground(Color.DARK_GRAY);
						numberOfEducationQualificationLabel[i].setBounds((2 * (familyMemberEducationPanelWidth/6))-314, 30, 309, 20);
						numberOfEducationQualificationLabel[i].setFocusable(false);
						
						numberOfEducationQualificationField[i] = new JComboBox();
						numberOfEducationQualificationField[i].setFont(font);
						numberOfEducationQualificationField[i].setForeground(Color.DARK_GRAY);
						numberOfEducationQualificationField[i].setBackground(Color.LIGHT_GRAY);
						numberOfEducationQualificationField[i].setBorder(BorderFactory.createLoweredBevelBorder());
						numberOfEducationQualificationField[i].setBounds((2 * (familyMemberEducationPanelWidth/6)), 30, (familyDetailsPanelWidth/12), 24);
						numberOfEducationQualificationField[i].setFocusable(true);
						numberOfEducationQualificationField[i].addItem("");
						numberOfEducationQualificationField[i].addItem("1");
						numberOfEducationQualificationField[i].addItem("2");
						numberOfEducationQualificationField[i].addItem("3");
						numberOfEducationQualificationField[i].addItem("4");
						numberOfEducationQualificationField[i].addItem("5");
						numberOfEducationQualificationField[i].addItem("6");
						numberOfEducationQualificationField[i].addItem("7");
						numberOfEducationQualificationField[i].addItem("8");
						
						addEducationQualification[i] = new JButton("Add Education Qualification");
						addEducationQualification[i].setForeground(Color.LIGHT_GRAY);
						addEducationQualification[i].setBackground(Color.DARK_GRAY);
						addEducationQualification[i].setBounds((2 * (familyMemberEducationPanelWidth/6)) + (familyDetailsPanelWidth/12) + 30, 30, 200, 24);
						addEducationQualification[i].setFocusable(true);
						final int familyMemberEducationPanelHeight = fourthRowY;
						addEducationQualification[i].addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								if(numberOfEducationQualificationField[rowNumber].getSelectedIndex()!=0)
								{
									numberOfEducationQualificationField[rowNumber].setBorder(BorderFactory.createLoweredBevelBorder());
									
									numberOfEducationQualificationLabel[rowNumber].setVisible(false);
									numberOfEducationQualificationField[rowNumber].setVisible(false);
									addEducationQualification[rowNumber].setVisible(false);
									
									for(int j=0 ; j<numberOfEducationQualificationField[rowNumber].getSelectedIndex() ; j++)
									{
										familyMemberQualificationLabel[rowNumber][j].setVisible(true);
										familyMemberQualificationLabel[rowNumber][j].setBounds((familyMemberEducationPanelWidth/6)-142-20, (j*30) + 30, 137, 20);
										
										familyMemberQualificationField[rowNumber][j].setVisible(true);
										familyMemberQualificationField[rowNumber][j].setBounds((familyMemberEducationPanelWidth/6)-20, (j*30) + 30, (familyMemberEducationPanelWidth/6)-30, 24);
										
										familyMemberStreamLabel[rowNumber][j].setVisible(true);
										familyMemberStreamLabel[rowNumber][j].setBounds((3 * (familyMemberEducationPanelWidth/6))-142-20, (j*30) + 30, 137, 20);
										
										familyMemberStreamField[rowNumber][j].setVisible(true);
										familyMemberStreamField[rowNumber][j].setBounds((3 * (familyMemberEducationPanelWidth/6))-20, (j*30) + 30, (familyMemberEducationPanelWidth/6)-30, 24);
										
										familyMemberDegreeLabel[rowNumber][j].setVisible(true);
										familyMemberDegreeLabel[rowNumber][j].setBounds((5 * (familyMemberEducationPanelWidth/6))-142-20, (j*30) + 30, 137, 20);
										
										familyMemberDegreeField[rowNumber][j].setVisible(true);
										familyMemberDegreeField[rowNumber][j].setBounds((5 * (familyMemberEducationPanelWidth/6))-20, (j*30) + 30, (familyMemberEducationPanelWidth/6)-30, 24);
									}
									
									updateEducationQualificationBounds(familyMemberEducationPanelHeight, rowNumber, numberOfEducationQualificationField[rowNumber].getSelectedIndex(), numberOfFamilyMembersField.getSelectedIndex(), true);
								}
								else
								{
									numberOfEducationQualificationField[rowNumber].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
							}
						});
						
						familyMemberEducationPanel[i].add(numberOfEducationQualificationLabel[i]);
						familyMemberEducationPanel[i].add(numberOfEducationQualificationField[i]);
						familyMemberEducationPanel[i].add(addEducationQualification[i]);
						
						for(int j=0 ; j<8 ; j++)
						{
							final int columnNumber = j;
							
							familyMemberQualificationLabel[i][j] = new JLabel("Qualification* : ", SwingConstants.RIGHT);
							familyMemberQualificationLabel[i][j].setFont(font);
							familyMemberQualificationLabel[i][j].setForeground(Color.DARK_GRAY);
							familyMemberQualificationLabel[i][j].setFocusable(false);
							familyMemberQualificationLabel[i][j].setVisible(false);
							
							familyMemberQualificationField[i][j] = new JComboBox();
							familyMemberQualificationField[i][j].setFont(font);
							familyMemberQualificationField[i][j].setForeground(Color.DARK_GRAY);
							familyMemberQualificationField[i][j].setBackground(Color.LIGHT_GRAY);
							familyMemberQualificationField[i][j].setBorder(BorderFactory.createLoweredBevelBorder());
							familyMemberQualificationField[i][j].setFocusable(true);
							familyMemberQualificationField[i][j].setVisible(false);
							familyMemberQualificationField[i][j].addItem("");
							familyMemberQualificationField[i][j].setSelectedIndex(-1);
				/*			familyMemberQualificationField[i][j].addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									if(familyMemberQualificationField[rowNumber][columnNumber].getSelectedIndex()!=-1)
									{
	//									if(familyMemberStreamField[rowNumber][columnNumber].getItemCount()!=0)
	//										familyMemberStreamField[rowNumber][columnNumber].removeAllItems();
										
										familyMemberStreamField[rowNumber][columnNumber].setEnabled(true);
										
										if(familyMemberQualificationField[rowNumber][columnNumber].getSelectedIndex()!=1)
										{
											int diplomaIndex = 4000;
											
											for(int k=0 ; k<familyMemberStreamField[rowNumber][columnNumber].getItemCount() ; k++)
											{
												String item = (String) familyMemberStreamField[rowNumber][columnNumber].getItemAt(k);
												if(item.compareTo("Diploma")==0)
												{
													System.out.println("executed");
													diplomaIndex = k;
													System.out.println(diplomaIndex);
												}
											}
									
											if(diplomaIndex != 4000)
											{
												familyMemberStreamField[rowNumber][columnNumber].remove(diplomaIndex);
												System.out.println(familyMemberStreamField[rowNumber][columnNumber].getItemAt(diplomaIndex));
											}
										}
										familyMemberStreamField[rowNumber][columnNumber].repaint();
										
							//			if(((String)familyMemberQualificationField[rowNumber][columnNumber].getSelectedItem()).compareTo("Graduate")==0)
							//				familyMemberStreamField[rowNumber][columnNumber].remove(familyMemberStreamField[rowNumber][columnNumber].);
									}
								}
							});  */
														
							familyMemberStreamLabel[i][j] = new JLabel("Stream* : ", SwingConstants.RIGHT);
							familyMemberStreamLabel[i][j].setFont(font);
							familyMemberStreamLabel[i][j].setForeground(Color.DARK_GRAY);
							familyMemberStreamLabel[i][j].setFocusable(false);
							familyMemberStreamLabel[i][j].setVisible(false);
							
							familyMemberStreamField[i][j] = new JComboBox();
							familyMemberStreamField[i][j].setFont(font);
							familyMemberStreamField[i][j].setForeground(Color.DARK_GRAY);
							familyMemberStreamField[i][j].setBackground(Color.LIGHT_GRAY);
							familyMemberStreamField[i][j].setBorder(BorderFactory.createLoweredBevelBorder());
							familyMemberStreamField[i][j].setFocusable(true);
							familyMemberStreamField[i][j].setVisible(false);
							familyMemberStreamField[i][j].setEnabled(true);
							familyMemberStreamField[i][j].setSelectedIndex(-1);
							familyMemberQualificationField[i][j].addItemListener(new ItemListener()
							{
								public void itemStateChanged(ItemEvent e)
								{
		//							System.out.println(e.getItem() + " " + e.getStateChange());
									
									if(e.getStateChange()==1)
									{
										int totalItems = familyMemberStreamField[rowNumber][columnNumber].getItemCount();
										boolean firstTime = false;
										
										if(totalItems==0)
											firstTime=true;
										
										familyMemberStreamField[rowNumber][columnNumber].removeKeyListener(null);
										
										if(!firstTime)
											familyMemberStreamField[rowNumber][columnNumber].setSelectedIndex(0);
										
										for(int k=totalItems-1 ; k>0 ; k--)
										{
					//						System.out.println("-> " + k);
											familyMemberStreamField[rowNumber][columnNumber].removeItemAt(k);
					//						System.out.println("-> " + k);
										}

										if(familyMemberQualificationField[rowNumber][columnNumber].getSelectedIndex()!=0)
										{
					//						System.out.println("I'm executed");
											
											familyMemberStreamField[rowNumber][columnNumber].addItem("");
											
											try
											{
												Class.forName("com.mysql.jdbc.Driver");
												
												Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
												Statement stmt = con.createStatement();
												
												Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
												Statement stmt1 = con1.createStatement();
											
												if(familyMemberQualificationField[rowNumber][columnNumber].getSelectedIndex()!=1)
												{
													String sql;
													ResultSet rs;
													
													sql = "SELECT `qualification_id` FROM `qualification_field` WHERE `qualification_name`='" + (String)familyMemberQualificationField[rowNumber][columnNumber].getSelectedItem() + "'";
													rs = stmt.executeQuery(sql);
													rs.next();
													
													sql = "SELECT `stream_id` FROM `qualification_stream` WHERE `qualification_id`='" + rs.getString(1) + "'";
													rs = stmt.executeQuery(sql);
													
													while(rs.next())
													{
														String sql1;
														ResultSet rs1;
														
														sql1 = "SELECT `stream_name` FROM `stream_field` WHERE `stream_id`='" + rs.getString(1) + "'";
														rs1 = stmt1.executeQuery(sql1);
														
														while(rs1.next())
														{
										//					System.out.println("-->> " + rs1.getString(1));
															familyMemberStreamField[rowNumber][columnNumber].addItem(rs1.getString(1));
														}
													}
												}
												else
												{
													String sql = "SELECT `stream_name` FROM `stream_field`";
													ResultSet rs1 = stmt.executeQuery(sql);
													
													while(rs1.next())
													{
														familyMemberStreamField[rowNumber][columnNumber].addItem(rs1.getString(1));
													}
												}
											}
											catch(Exception exc)
											{
												JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
											}
											
											if(!firstTime)
												familyMemberStreamField[rowNumber][columnNumber].removeItemAt(0);
											
											familyMemberStreamField[rowNumber][columnNumber].addActionListener(new ActionListener()
											{
												public void actionPerformed(ActionEvent e)
												{
													familyMemberDegreeField[rowNumber][columnNumber].removeAllItems();
													
													familyMemberDegreeField[rowNumber][columnNumber].addItem("");
													
													if(familyMemberStreamField[rowNumber][columnNumber].getSelectedIndex()!=0)
													{
														try
														{
															Class.forName("com.mysql.jdbc.Driver");
															
															Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
															Statement stmt1 = con1.createStatement();
					
															String sql1 = "SELECT `qualification_id` FROM `qualification_field` WHERE `qualification_name`='" + (String)familyMemberQualificationField[rowNumber][columnNumber].getSelectedItem() + "'";
															ResultSet rs1 = stmt1.executeQuery(sql1);
															rs1.next();
															String qualificationId = rs1.getString(1);
															
															String sql2 = "SELECT `stream_id` FROM `stream_field` WHERE `stream_name`='" + (String)familyMemberStreamField[rowNumber][columnNumber].getSelectedItem() + "'";
															ResultSet rs2 = stmt1.executeQuery(sql2);
															rs2.next();
															String streamId = rs2.getString(1);
															
															String sql3 = "SELECT `degree_name` FROM `degree_field` WHERE `qualification_id`='" + qualificationId + "' AND `stream_id`='" + streamId + "'";
															ResultSet rs3 = stmt1.executeQuery(sql3);
															
															while(rs3.next())
																familyMemberDegreeField[rowNumber][columnNumber].addItem(rs3.getString(1));
															
															familyMemberDegreeField[rowNumber][columnNumber].setEnabled(true);
														}
														catch(Exception exc)
														{
															JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
														}
													}
												}
											});
										}
									}
								}
							});
							
							familyMemberDegreeLabel[i][j] = new JLabel("Degree* : ", SwingConstants.RIGHT);
							familyMemberDegreeLabel[i][j].setFont(font);
							familyMemberDegreeLabel[i][j].setForeground(Color.DARK_GRAY);
							familyMemberDegreeLabel[i][j].setFocusable(false);
							familyMemberDegreeLabel[i][j].setVisible(false);
							
							familyMemberDegreeField[i][j] = new JComboBox();
							familyMemberDegreeField[i][j].setFont(font);
							familyMemberDegreeField[i][j].setForeground(Color.DARK_GRAY);
							familyMemberDegreeField[i][j].setBackground(Color.LIGHT_GRAY);
							familyMemberDegreeField[i][j].setBorder(BorderFactory.createLoweredBevelBorder());
							familyMemberDegreeField[i][j].setFocusable(true);
							familyMemberDegreeField[i][j].setVisible(false);
							familyMemberDegreeField[i][j].addItem("");
							familyMemberDegreeField[i][j].setEnabled(true);
							
							familyMemberEducationPanel[i].add(familyMemberQualificationLabel[i][j]);
							familyMemberEducationPanel[i].add(familyMemberQualificationField[i][j]);
							familyMemberEducationPanel[i].add(familyMemberStreamLabel[i][j]);
							familyMemberEducationPanel[i].add(familyMemberStreamField[i][j]);
							familyMemberEducationPanel[i].add(familyMemberDegreeLabel[i][j]);
							familyMemberEducationPanel[i].add(familyMemberDegreeField[i][j]);
						}
						
						familyMemberMaritualStatusLabel[i] = new JLabel("Maritual Status* : ", SwingConstants.RIGHT);
						familyMemberMaritualStatusLabel[i].setFont(font);
						familyMemberMaritualStatusLabel[i].setForeground(Color.DARK_GRAY);
						familyMemberMaritualStatusLabel[i].setBounds((4 * (familyDetailsPanelWidth/6))-134-20, fifthRowY, 129, 20);
						familyMemberMaritualStatusLabel[i].setFocusable(false);
						familyMemberMaritualStatusLabel[i].setVisible(true);
						
						familyMemberMarriedRadioButton[i] = new JRadioButton("Married");
						familyMemberMarriedRadioButton[i].setFont(font);
						familyMemberMarriedRadioButton[i].setForeground(Color.DARK_GRAY);
						familyMemberMarriedRadioButton[i].setBackground(Color.LIGHT_GRAY);
						familyMemberMarriedRadioButton[i].setBounds((4 * (familyDetailsPanelWidth/6))-20, fifthRowY, 83, 20);
						familyMemberMarriedRadioButton[i].setFocusable(true);
						familyMemberMarriedRadioButton[i].setVisible(true);
						familyMemberMarriedRadioButton[i].addFocusListener(new FocusAdapter()
						{
							public void focusLost(FocusEvent e)
							{
								if(!(familyMemberMarriedRadioButton[rowNumber].isSelected() || familyMemberUnmarriedRadioButton[rowNumber].isSelected()))
								{
									familyMemberMaritualStatusLabel[rowNumber].setForeground(Color.RED);
									familyMemberMarriedRadioButton[rowNumber].setForeground(Color.RED);
									familyMemberUnmarriedRadioButton[rowNumber].setForeground(Color.RED);
								}
								else
								{
									familyMemberMaritualStatusLabel[rowNumber].setForeground(Color.DARK_GRAY);
									familyMemberMarriedRadioButton[rowNumber].setForeground(Color.DARK_GRAY);
									familyMemberUnmarriedRadioButton[rowNumber].setForeground(Color.DARK_GRAY);
								}
							}
						});
						
						familyMemberUnmarriedRadioButton[i] = new JRadioButton("Unmarried");
						familyMemberUnmarriedRadioButton[i].setFont(font);
						familyMemberUnmarriedRadioButton[i].setForeground(Color.DARK_GRAY);
						familyMemberUnmarriedRadioButton[i].setBackground(Color.LIGHT_GRAY);
						familyMemberUnmarriedRadioButton[i].setBounds((5 * (familyDetailsPanelWidth/6))-20, fifthRowY, 103, 20);
						familyMemberUnmarriedRadioButton[i].setFocusable(true);
						familyMemberUnmarriedRadioButton[i].setVisible(true);
						familyMemberUnmarriedRadioButton[i].addFocusListener(new FocusAdapter()
						{
							public void focusLost(FocusEvent e)
							{
								if(!(familyMemberMarriedRadioButton[rowNumber].isSelected() || familyMemberUnmarriedRadioButton[rowNumber].isSelected()))
								{
									familyMemberMaritualStatusLabel[rowNumber].setForeground(Color.RED);
									familyMemberMarriedRadioButton[rowNumber].setForeground(Color.RED);
									familyMemberUnmarriedRadioButton[rowNumber].setForeground(Color.RED);
								}
								else
								{
									familyMemberMaritualStatusLabel[rowNumber].setForeground(Color.DARK_GRAY);
									familyMemberMarriedRadioButton[rowNumber].setForeground(Color.DARK_GRAY);
									familyMemberUnmarriedRadioButton[rowNumber].setForeground(Color.DARK_GRAY);
								}
							}
						});
						
						familyMemberMaritualStatusGroup[i] = new ButtonGroup();
						familyMemberMaritualStatusGroup[i].add(familyMemberMarriedRadioButton[i]);
						familyMemberMaritualStatusGroup[i].add(familyMemberUnmarriedRadioButton[i]);
						
						familyMemberGenderLabel[i] = new JLabel("Gender* : ", SwingConstants.RIGHT);
						familyMemberGenderLabel[i].setFont(font);
						familyMemberGenderLabel[i].setForeground(Color.DARK_GRAY);
						familyMemberGenderLabel[i].setBounds((familyDetailsPanelWidth/6)-75-20, fifthRowY, 70, 20);
						familyMemberGenderLabel[i].setFocusable(false);
						familyMemberGenderLabel[i].setVisible(true);
						
						familyMemberGenderMaleRadioButton[i] = new JRadioButton("Male");
						familyMemberGenderMaleRadioButton[i].setFont(font);
						familyMemberGenderMaleRadioButton[i].setForeground(Color.DARK_GRAY);
						familyMemberGenderMaleRadioButton[i].setBackground(Color.LIGHT_GRAY);
						familyMemberGenderMaleRadioButton[i].setBounds((familyDetailsPanelWidth/6)-20, fifthRowY, 60, 20);
						familyMemberGenderMaleRadioButton[i].setFocusable(true);
						familyMemberGenderMaleRadioButton[i].setVisible(true);
						familyMemberGenderMaleRadioButton[i].addFocusListener(new FocusAdapter()
						{
							public void focusLost(FocusEvent e)
							{
								if(!(familyMemberGenderMaleRadioButton[rowNumber].isSelected() || familyMemberGenderFemaleRadioButton[rowNumber].isSelected()))
								{
									familyMemberGenderLabel[rowNumber].setForeground(Color.RED);
									familyMemberGenderMaleRadioButton[rowNumber].setForeground(Color.RED);
									familyMemberGenderFemaleRadioButton[rowNumber].setForeground(Color.RED);
								}
								else
								{
									familyMemberGenderLabel[rowNumber].setForeground(Color.DARK_GRAY);
									familyMemberGenderMaleRadioButton[rowNumber].setForeground(Color.DARK_GRAY);
									familyMemberGenderFemaleRadioButton[rowNumber].setForeground(Color.DARK_GRAY);
								}
							}
						});
	
						familyMemberGenderFemaleRadioButton[i] = new JRadioButton("Female");
						familyMemberGenderFemaleRadioButton[i].setFont(font);
						familyMemberGenderFemaleRadioButton[i].setForeground(Color.DARK_GRAY);
						familyMemberGenderFemaleRadioButton[i].setBackground(Color.LIGHT_GRAY);
						familyMemberGenderFemaleRadioButton[i].setBounds((2 * (familyDetailsPanelWidth/6))-20, fifthRowY, 77, 20);
						familyMemberGenderFemaleRadioButton[i].setFocusable(true);
						familyMemberGenderFemaleRadioButton[i].setVisible(true);
						familyMemberGenderFemaleRadioButton[i].addFocusListener(new FocusAdapter()
						{
							public void focusLost(FocusEvent e)
							{
								if(!(familyMemberGenderMaleRadioButton[rowNumber].isSelected() || familyMemberGenderFemaleRadioButton[rowNumber].isSelected()))
								{
									familyMemberGenderLabel[rowNumber].setForeground(Color.RED);
									familyMemberGenderMaleRadioButton[rowNumber].setForeground(Color.RED);
									familyMemberGenderFemaleRadioButton[rowNumber].setForeground(Color.RED);
								}
								else
								{
									familyMemberGenderLabel[rowNumber].setForeground(Color.DARK_GRAY);
									familyMemberGenderMaleRadioButton[rowNumber].setForeground(Color.DARK_GRAY);
									familyMemberGenderFemaleRadioButton[rowNumber].setForeground(Color.DARK_GRAY);
								}
							}
						});
						
						familyMemberGenderGroup[i] = new ButtonGroup();
						familyMemberGenderGroup[i].add(familyMemberGenderMaleRadioButton[i]);
						familyMemberGenderGroup[i].add(familyMemberGenderFemaleRadioButton[i]);
						
						whatsappNumberLabel[i] = new JLabel("Whatsapp Number : ", SwingConstants.RIGHT);
						whatsappNumberLabel[i].setFont(font);
						whatsappNumberLabel[i].setForeground(Color.DARK_GRAY);
						whatsappNumberLabel[i].setBounds((4 * (familyDetailsPanelWidth/6))-152-20, sixthRowY, 147, 20);
						whatsappNumberLabel[i].setFocusable(false);
						whatsappNumberLabel[i].setVisible(true);
						
						whatsappNumberField[i] = new JTextField();
						whatsappNumberField[i].setFont(font);
						whatsappNumberField[i].setForeground(Color.DARK_GRAY);
						whatsappNumberField[i].setBackground(Color.LIGHT_GRAY);
						whatsappNumberField[i].setBorder(BorderFactory.createLoweredBevelBorder());
						whatsappNumberField[i].setBounds((4 * (familyDetailsPanelWidth/6))-20, sixthRowY, (familyDetailsPanelWidth/6), 20);
						whatsappNumberField[i].setDocument(new JTextFieldLimit(10));
						whatsappNumberField[i].setFocusable(true);
						whatsappNumberField[i].setVisible(true);
						
						if(i==0)
						{
							familyMemberSurnameField[i].setEnabled(false);
							familyMemberSurnameField[i].setBackground(Color.WHITE);
							familyMemberNameField[i].setEnabled(false);
							familyMemberNameField[i].setBackground(Color.WHITE);
							familyMemberFatherNameField[i].setEnabled(false);
							familyMemberFatherNameField[i].setBackground(Color.WHITE);
						}
						
						familyMemberPanel[i].add(familyMemberNumber[i]);
						familyMemberPanel[i].add(familyMemberSurnameLabel[i]);
						familyMemberPanel[i].add(familyMemberSurnameField[i]);
						familyMemberPanel[i].add(familyMemberNameLabel[i]);
						familyMemberPanel[i].add(familyMemberNameField[i]);
						familyMemberPanel[i].add(familyMemberFatherNameLabel[i]);
						familyMemberPanel[i].add(familyMemberFatherNameField[i]);
						familyMemberPanel[i].add(familyMemberRelationLabel[i]);
						familyMemberPanel[i].add(familyMemberRelationField[i]);
						familyMemberPanel[i].add(familyMemberBirthDateLabel[i]);
//						familyMemberPanel[i].add(familyMemberBirthDateField[i]);
						familyMemberPanel[i].add(familyMemberEducationPanel[i]);
//						familyMemberPanel[i].add(familyMemberQualificationLabel[i]);
//						for(int j=0 ; j<7 ; j++)
//							familyMemberPanel[i].add(familyMemberQualificationField[i][j]);
						familyMemberPanel[i].add(familyMemberMaritualStatusLabel[i]);
						familyMemberPanel[i].add(familyMemberMarriedRadioButton[i]);
						familyMemberPanel[i].add(familyMemberUnmarriedRadioButton[i]);
						familyMemberPanel[i].add(familyMemberGenderLabel[i]);
						familyMemberPanel[i].add(familyMemberGenderMaleRadioButton[i]);
						familyMemberPanel[i].add(familyMemberGenderFemaleRadioButton[i]);
						familyMemberPanel[i].add(whatsappNumberLabel[i]);
						familyMemberPanel[i].add(whatsappNumberField[i]);
						
						familyDetailsPanel.add(familyMemberPanel[i]);
					}
					
				/*	try
					{
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
						Statement stmt = con.createStatement();
					
						String sql = "SELECT `stream_name` FROM `stream_field`";
						ResultSet rs1 = stmt.executeQuery(sql);
						
						while(rs1.next())
						{
							for(int i=0 ; i<15 ; i++)
								for(int j=0 ; j<8 ; j++)
									familyMemberStreamField[i][j].addItem(rs1.getString(1));
						}
					}
					catch(Exception exc)
					{
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}*/
					
					
				// otherDetails
					border = new TitledBorder(border,"Other Details",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					otherDetailsPanel = new JPanel();
					otherDetailsPanel.setLayout(null);
					otherDetailsPanel.setVisible(true);
					otherDetailsPanel.setBounds(40, 750, otherDetailsPanelWidth, otherDetailsPanelHeight);
					otherDetailsPanel.setBackground(Color.LIGHT_GRAY);
					otherDetailsPanel.setBorder(border);
					
					addMemberPanel.add(otherDetailsPanel);
					
					livingInJointFamilyLabel = new JLabel("Living In Joint Family* : ", SwingConstants.RIGHT);
					livingInJointFamilyLabel.setFont(font);
					livingInJointFamilyLabel.setForeground(Color.DARK_GRAY);
					livingInJointFamilyLabel.setBounds((otherDetailsPanelWidth/6)-180, 30, 175, 24);
					livingInJointFamilyLabel.setFocusable(false);
					
					livingInJointFamilyYesRadioButton = new JRadioButton("Yes");
					livingInJointFamilyYesRadioButton.setFont(font);
					livingInJointFamilyYesRadioButton.setForeground(Color.DARK_GRAY);
					livingInJointFamilyYesRadioButton.setBackground(Color.LIGHT_GRAY);
					livingInJointFamilyYesRadioButton.setBounds((2 * (otherDetailsPanelWidth/12)), 30, 50, 24);
					livingInJointFamilyYesRadioButton.setFocusable(true);
					livingInJointFamilyYesRadioButton.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(!(livingInJointFamilyYesRadioButton.isSelected() || livingInJointFamilyNoRadioButton.isSelected()))
							{
								livingInJointFamilyLabel.setForeground(Color.RED);
								livingInJointFamilyYesRadioButton.setForeground(Color.RED);
								livingInJointFamilyNoRadioButton.setForeground(Color.RED);
							}
							else
							{
								livingInJointFamilyLabel.setForeground(Color.DARK_GRAY);
								livingInJointFamilyYesRadioButton.setForeground(Color.DARK_GRAY);
								livingInJointFamilyNoRadioButton.setForeground(Color.DARK_GRAY);
							}
						}
					});
					
					livingInJointFamilyNoRadioButton = new JRadioButton("No");
					livingInJointFamilyNoRadioButton.setFont(font);
					livingInJointFamilyNoRadioButton.setForeground(Color.DARK_GRAY);
					livingInJointFamilyNoRadioButton.setBackground(Color.LIGHT_GRAY);
					livingInJointFamilyNoRadioButton.setBounds((3 * (otherDetailsPanelWidth/12)), 30, 46, 24);
					livingInJointFamilyNoRadioButton.setFocusable(true);
					livingInJointFamilyNoRadioButton.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(!(livingInJointFamilyYesRadioButton.isSelected() || livingInJointFamilyNoRadioButton.isSelected()))
							{
								livingInJointFamilyLabel.setForeground(Color.RED);
								livingInJointFamilyYesRadioButton.setForeground(Color.RED);
								livingInJointFamilyNoRadioButton.setForeground(Color.RED);
							}
							else
							{
								livingInJointFamilyLabel.setForeground(Color.DARK_GRAY);
								livingInJointFamilyYesRadioButton.setForeground(Color.DARK_GRAY);
								livingInJointFamilyNoRadioButton.setForeground(Color.DARK_GRAY);
							}
						}
					});
					
					livingInJointFamilyGroup = new ButtonGroup();
					livingInJointFamilyGroup.add(livingInJointFamilyYesRadioButton);
					livingInJointFamilyGroup.add(livingInJointFamilyNoRadioButton);
					
					haveOwnHouseLabel = new JLabel("Have your own house* : ", SwingConstants.RIGHT);
					haveOwnHouseLabel.setFont(font);
					haveOwnHouseLabel.setForeground(Color.DARK_GRAY);
					haveOwnHouseLabel.setBounds((3 * (otherDetailsPanelWidth/6))-180, 30, 175, 24);
					haveOwnHouseLabel.setFocusable(false);
					
					haveOwnHouseYesRadioButton = new JRadioButton("Yes");
					haveOwnHouseYesRadioButton.setFont(font);
					haveOwnHouseYesRadioButton.setForeground(Color.DARK_GRAY);
					haveOwnHouseYesRadioButton.setBackground(Color.LIGHT_GRAY);
					haveOwnHouseYesRadioButton.setBounds((6 * (otherDetailsPanelWidth/12)), 30, 50, 24);
					haveOwnHouseYesRadioButton.setFocusable(true);
					haveOwnHouseYesRadioButton.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(!(haveOwnHouseYesRadioButton.isSelected() || haveOwnHouseNoRadioButton.isSelected()))
							{
								haveOwnHouseLabel.setForeground(Color.RED);
								haveOwnHouseYesRadioButton.setForeground(Color.RED);
								haveOwnHouseNoRadioButton.setForeground(Color.RED);
							}
							else
							{
								haveOwnHouseLabel.setForeground(Color.DARK_GRAY);
								haveOwnHouseYesRadioButton.setForeground(Color.DARK_GRAY);
								haveOwnHouseNoRadioButton.setForeground(Color.DARK_GRAY);
							}
						}
					});
					
					haveOwnHouseNoRadioButton = new JRadioButton("No");
					haveOwnHouseNoRadioButton.setFont(font);
					haveOwnHouseNoRadioButton.setForeground(Color.DARK_GRAY);
					haveOwnHouseNoRadioButton.setBackground(Color.LIGHT_GRAY);
					haveOwnHouseNoRadioButton.setBounds((7 * (otherDetailsPanelWidth/12)), 30, 46, 24);
					haveOwnHouseNoRadioButton.setFocusable(true);
					haveOwnHouseNoRadioButton.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(!(haveOwnHouseYesRadioButton.isSelected() || haveOwnHouseNoRadioButton.isSelected()))
							{
								haveOwnHouseLabel.setForeground(Color.RED);
								haveOwnHouseYesRadioButton.setForeground(Color.RED);
								haveOwnHouseNoRadioButton.setForeground(Color.RED);
							}
							else
							{
								haveOwnHouseLabel.setForeground(Color.DARK_GRAY);
								haveOwnHouseYesRadioButton.setForeground(Color.DARK_GRAY);
								haveOwnHouseNoRadioButton.setForeground(Color.DARK_GRAY);
							}
						}
					});
					
					haveOwnHouseGroup = new ButtonGroup();
					haveOwnHouseGroup.add(haveOwnHouseYesRadioButton);
					haveOwnHouseGroup.add(haveOwnHouseNoRadioButton);
					
					intrestedInSocialActivityLabel = new JLabel("Intrested in Social Activity* : ", SwingConstants.RIGHT);
					intrestedInSocialActivityLabel.setFont(font);
					intrestedInSocialActivityLabel.setForeground(Color.DARK_GRAY);
					intrestedInSocialActivityLabel.setBounds((5 * (otherDetailsPanelWidth/6))-218, 30, 213, 24);
					intrestedInSocialActivityLabel.setFocusable(false);
					
					intrestedInSocialActivityYesRadioButton = new JRadioButton("Yes");
					intrestedInSocialActivityYesRadioButton.setFont(font);
					intrestedInSocialActivityYesRadioButton.setForeground(Color.DARK_GRAY);
					intrestedInSocialActivityYesRadioButton.setBackground(Color.LIGHT_GRAY);
					intrestedInSocialActivityYesRadioButton.setBounds((10 * (otherDetailsPanelWidth/12)), 30, 50, 24);
					intrestedInSocialActivityYesRadioButton.setFocusable(true);
					intrestedInSocialActivityYesRadioButton.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(!(intrestedInSocialActivityYesRadioButton.isSelected() || intrestedInSocialActivityNoRadioButton.isSelected()))
							{
								intrestedInSocialActivityLabel.setForeground(Color.RED);
								intrestedInSocialActivityYesRadioButton.setForeground(Color.RED);
								intrestedInSocialActivityNoRadioButton.setForeground(Color.RED);
							}
							else
							{
								intrestedInSocialActivityLabel.setForeground(Color.DARK_GRAY);
								intrestedInSocialActivityYesRadioButton.setForeground(Color.DARK_GRAY);
								intrestedInSocialActivityNoRadioButton.setForeground(Color.DARK_GRAY);
							}
						}
					});
					
					intrestedInSocialActivityNoRadioButton = new JRadioButton("No");
					intrestedInSocialActivityNoRadioButton.setFont(font);
					intrestedInSocialActivityNoRadioButton.setForeground(Color.DARK_GRAY);
					intrestedInSocialActivityNoRadioButton.setBackground(Color.LIGHT_GRAY);
					intrestedInSocialActivityNoRadioButton.setBounds((11 * (otherDetailsPanelWidth/12)), 30, 46, 24);
					intrestedInSocialActivityNoRadioButton.setFocusable(true);
					intrestedInSocialActivityNoRadioButton.addFocusListener(new FocusAdapter()
					{
						public void focusLost(FocusEvent e)
						{
							if(!(intrestedInSocialActivityYesRadioButton.isSelected() || intrestedInSocialActivityNoRadioButton.isSelected()))
							{
								intrestedInSocialActivityLabel.setForeground(Color.RED);
								intrestedInSocialActivityYesRadioButton.setForeground(Color.RED);
								intrestedInSocialActivityNoRadioButton.setForeground(Color.RED);
							}
							else
							{
								intrestedInSocialActivityLabel.setForeground(Color.DARK_GRAY);
								intrestedInSocialActivityYesRadioButton.setForeground(Color.DARK_GRAY);
								intrestedInSocialActivityNoRadioButton.setForeground(Color.DARK_GRAY);
							}
						}
					});
					
					intrestedInSocialActivityGroup = new ButtonGroup();
					intrestedInSocialActivityGroup.add(intrestedInSocialActivityYesRadioButton);
					intrestedInSocialActivityGroup.add(intrestedInSocialActivityNoRadioButton);
					
					otherDetailsPanel.add(livingInJointFamilyLabel);
					otherDetailsPanel.add(livingInJointFamilyYesRadioButton);
					otherDetailsPanel.add(livingInJointFamilyNoRadioButton);
					otherDetailsPanel.add(haveOwnHouseLabel);
					otherDetailsPanel.add(haveOwnHouseYesRadioButton);
					otherDetailsPanel.add(haveOwnHouseNoRadioButton);
					otherDetailsPanel.add(intrestedInSocialActivityLabel);
					otherDetailsPanel.add(intrestedInSocialActivityYesRadioButton);
					otherDetailsPanel.add(intrestedInSocialActivityNoRadioButton);

					
				// submitFormButton
					submitFormButton = new JButton("Submit");
					submitFormButton.setForeground(Color.LIGHT_GRAY);
					submitFormButton.setBackground(Color.DARK_GRAY);
					submitFormButton.setBounds(mainFooterPanelWidth-380, 845, 150, 24);
					submitFormButton.setFocusable(true);
					submitFormButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							int countErroredFields = 0;
							if(submitFormButton.isEnabled())
							{
								if(receiptNumberField.getText().compareTo("")==0)
								{
									countErroredFields++;
									receiptNumberField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									receiptNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(donationField.getText().compareTo("")==0)
								{
									countErroredFields++;
									donationField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									donationField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(mainPersonSurnameField.getSelectedIndex()==0)
								{
									countErroredFields++;
									mainPersonSurnameField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									mainPersonSurnameField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(mainPersonNameField.getText().compareTo("")==0)
								{
									countErroredFields++;
									mainPersonNameField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									mainPersonNameField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(mainPersonFatherNameField.getText().compareTo("")==0)
								{
									countErroredFields++;
									mainPersonFatherNameField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									mainPersonFatherNameField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(currentAddressLine1Field.getText().compareTo("")==0)
								{
									countErroredFields++;
									currentAddressLine1Field.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									currentAddressLine1Field.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(currentCountryField.getSelectedIndex()==0)
								{
									countErroredFields++;
									currentCountryField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									currentCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(currentStateField.getSelectedIndex()==0)
								{
									countErroredFields++;
									currentStateField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									currentStateField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(currentCityField.getSelectedIndex()==0)
								{
									countErroredFields++;
									currentCityField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									currentCityField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(mobileNumberField.getText().compareTo("")==0)
								{
									countErroredFields++;
									mobileNumberField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									mobileNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(rootCountryField.getSelectedIndex()==0)
								{
									countErroredFields++;
									rootCountryField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									rootCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(rootStateField.getSelectedIndex()==0)
								{
									countErroredFields++;
									rootStateField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									rootStateField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(rootCityField.getSelectedIndex()==0)
								{
									countErroredFields++;
									rootCityField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									rootCityField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(rootGotraField.getSelectedIndex()==0)
								{
									countErroredFields++;
									rootGotraField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									rootGotraField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(rootKulDeviField.getSelectedIndex()==0)
								{
									countErroredFields++;
									rootKulDeviField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
									rootKulDeviField.setBorder(BorderFactory.createLoweredBevelBorder());
								
								if(occupationButtonGroup.getSelection()==null)
								{
									countErroredFields++;
									occupationLabel.setForeground(Color.RED);
									businessRadioButton.setForeground(Color.RED);
									serviceRadioButton.setForeground(Color.RED);
								}
								else
								{
									occupationLabel.setForeground(Color.DARK_GRAY);
									businessRadioButton.setForeground(Color.DARK_GRAY);
									serviceRadioButton.setForeground(Color.DARK_GRAY);
								}
								
								if(numberOfFamilyMembersField.getSelectedIndex()==0)
								{
									countErroredFields++;
									numberOfFamilyMembersField.setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
								}
								else
								{
									numberOfFamilyMembersField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
								
									for(int i=0 ; i<numberOfFamilyMembersField.getSelectedIndex() ; i++)
									{
										if(familyMemberSurnameField[i].getSelectedIndex()==0)
										{
											countErroredFields++;
											familyMemberSurnameField[i].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
										}
										else
											familyMemberSurnameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
										
										if(familyMemberNameField[i].getText().compareTo("")==0)
										{
											countErroredFields++;
											familyMemberNameField[i].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
										}
										else
											familyMemberNameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
										
										if(familyMemberFatherNameField[i].getText().compareTo("")==0)
										{
											countErroredFields++;
											familyMemberFatherNameField[i].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
										}
										else
											familyMemberFatherNameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
										
										if(familyMemberRelationField[i].getSelectedIndex()==0)
										{
											countErroredFields++;
											familyMemberRelationField[i].setBorder(BorderFactory.createSoftBevelBorder(1, Color.RED, Color.RED));
										}
										else
											familyMemberRelationField[i].setBorder(BorderFactory.createLoweredBevelBorder());
										
										if(familyMemberGenderGroup[i].getSelection()==null)
										{
											countErroredFields++;
											familyMemberGenderLabel[i].setForeground(Color.RED);
											familyMemberGenderMaleRadioButton[i].setForeground(Color.RED);
											familyMemberGenderFemaleRadioButton[i].setForeground(Color.RED);
										}
										else
										{
											familyMemberGenderLabel[i].setForeground(Color.DARK_GRAY);
											familyMemberGenderMaleRadioButton[i].setForeground(Color.DARK_GRAY);
											familyMemberGenderFemaleRadioButton[i].setForeground(Color.DARK_GRAY);
										}
										
										if(familyMemberMaritualStatusGroup[i].getSelection()==null)
										{
											countErroredFields++;
											familyMemberMaritualStatusLabel[i].setForeground(Color.RED);
											familyMemberMarriedRadioButton[i].setForeground(Color.RED);
											familyMemberUnmarriedRadioButton[i].setForeground(Color.RED);
										}
										else
										{
											familyMemberMaritualStatusLabel[i].setForeground(Color.DARK_GRAY);
											familyMemberMarriedRadioButton[i].setForeground(Color.DARK_GRAY);
											familyMemberUnmarriedRadioButton[i].setForeground(Color.DARK_GRAY);
										}
									}
								}
								
								if(livingInJointFamilyGroup.getSelection()==null)
								{
									countErroredFields++;
									livingInJointFamilyLabel.setForeground(Color.RED);
									livingInJointFamilyYesRadioButton.setForeground(Color.RED);
									livingInJointFamilyNoRadioButton.setForeground(Color.RED);
								}
								else
								{
									livingInJointFamilyLabel.setForeground(Color.DARK_GRAY);
									livingInJointFamilyYesRadioButton.setForeground(Color.DARK_GRAY);
									livingInJointFamilyNoRadioButton.setForeground(Color.DARK_GRAY);
								}
								
								if(haveOwnHouseGroup.getSelection()==null)
								{
									haveOwnHouseLabel.setForeground(Color.RED);
									haveOwnHouseYesRadioButton.setForeground(Color.RED);
									haveOwnHouseNoRadioButton.setForeground(Color.RED);
								}
								else
								{
									haveOwnHouseLabel.setForeground(Color.DARK_GRAY);
									haveOwnHouseYesRadioButton.setForeground(Color.DARK_GRAY);
									haveOwnHouseNoRadioButton.setForeground(Color.DARK_GRAY);
								}
								
								if(intrestedInSocialActivityGroup.getSelection()==null)
								{
									intrestedInSocialActivityLabel.setForeground(Color.RED);
									intrestedInSocialActivityYesRadioButton.setForeground(Color.RED);
									intrestedInSocialActivityNoRadioButton.setForeground(Color.RED);
								}
								else
								{
									intrestedInSocialActivityLabel.setForeground(Color.DARK_GRAY);
									intrestedInSocialActivityYesRadioButton.setForeground(Color.DARK_GRAY);
									intrestedInSocialActivityNoRadioButton.setForeground(Color.DARK_GRAY);
								}
								
								if(countErroredFields==0)
								{
									String options[] = {"OK", "Cancel"};
									int submitConfirm = JOptionPane.showOptionDialog(null, "Are you sure you want to submit this form?", "Submit Form", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("Question.png"), options, options[0]);
									
									if(submitConfirm==0)
									{
										try
										{
											Class.forName("com.mysql.jdbc.Driver");
											
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
											Statement stmt = con.createStatement();
											
											String sql1;
											ResultSet rs1;
											
											// fields sql relation conversion
												String kulString = "";
												String moshalSurnameString = "";
												String talGolString = "";
												String referenceString = "";
												String currentCountryString = "";
												String currentStateString = "";
												String currentDistrictString = "";
												String currentCityString = "";
												String rootCountryString = "";
												String rootStateString = "";
												String rootDistrictString = "";
												String rootCityString = "";
												String rootGotraString = "";
												String rootKulDeviString = "";
												int kulId;
												int moshalSurnameId;
												int talGolId;
												int referenceId;
												int currentCountryId;
												int currentStateId;
												int currentDistrictId;
												int currentCityId;
												int rootCountryId;
												int rootStateId;
												int rootDistrictId;
												int rootCityId;
												int rootGotraId;
												int rootKulDeviId;
											
												// rootKulField sql String conversion
													if(rootKulField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `kul_id` FROM `kul_field` WHERE `kul_name`='" + (String)rootKulField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														kulId = rs1.getInt(1);
													}
													else
														kulId = -1;
													
													if(kulId==-1)
														kulString = "null";
													else
														kulString = "'" + kulId + "'";
												
												// root moshalSurnameField sql String conversion
													if(rootMoshalSurnameField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `moshal_surname_id` FROM `moshal_surname_field` WHERE `moshal_surname_name`='" + (String)rootMoshalSurnameField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														moshalSurnameId = rs1.getInt(1);
													}
													else
														moshalSurnameId = -1;
													
													if(moshalSurnameId == -1)
														moshalSurnameString = "null";
													else
														moshalSurnameString = "'" + moshalSurnameId + "'";
												
												// rootTalGolField sql string conversion
													if(rootTalGolField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `tal_gol_id` FROM `tal_gol_field` WHERE `tal_gol_name`='" + (String)rootTalGolField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														talGolId = rs1.getInt(1);
													}
													else
														talGolId = -1;
													
													if(talGolId == -1)
														talGolString = "null";
													else
														talGolString = "'" + talGolId + "'";
											
												// referencebyField
													if(referencebyField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `reference_id` FROM `reference_field` WHERE `reference_name`='" + (String)referencebyField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														referenceId = rs1.getInt(1);
													}
													else
														referenceId = -1;
													
													if(referenceId == -1)
														referenceString = "null";
													else
														referenceString = "'" + referenceId + "'";
												
												// currentCountryField
													if(currentCountryField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `country_id` FROM `country_field` WHERE `country_name`='" + (String)currentCountryField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														currentCountryId = rs1.getInt(1);
													}
													else
														currentCountryId = -1;
													
													if(currentCountryId == -1)
														currentCountryString = "null";
													else
														currentCountryString = "'" + currentCountryId + "'";
													
												// currentStateField
													if(currentStateField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `state_id` FROM `state_field` WHERE `state_name`='" + (String)currentStateField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														currentStateId = rs1.getInt(1);
													}
													else
														currentStateId = -1;
													
													if(currentStateId == -1)
														currentStateString = "null";
													else
														currentStateString = "'" + currentStateId + "'";
													
												// currentDistrictField
													if(currentDistrictField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `district_id` FROM `district_field` WHERE `district_name`='" + (String)currentDistrictField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														currentDistrictId = rs1.getInt(1);
													}
													else
														currentDistrictId = -1;
													
													if(currentDistrictId == -1)
														currentDistrictString = "null";
													else
														currentDistrictString = "'" + currentDistrictId + "'";
													
												// currentCityField
													if(currentCityField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `city_id` FROM `city_field` WHERE `city_name`='" + (String)currentCityField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														currentCityId = rs1.getInt(1);
													}
													else
														currentCityId = -1;
													
													if(currentCityId == -1)
														currentCityString = "null";
													else
														currentCityString = "'" + currentCityId + "'";
													
												// rootCountryField
													if(rootCountryField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `country_id` FROM `country_field` WHERE `country_name`='" + (String)rootCountryField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														rootCountryId = rs1.getInt(1);
													}
													else
														rootCountryId = -1;
													
													if(rootCountryId == -1)
														rootCountryString = "null";
													else
														rootCountryString = "'" + rootCountryId + "'";
													
												// rootStateField
													if(rootStateField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `state_id` FROM `state_field` WHERE `state_name`='" + (String)rootStateField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														rootStateId = rs1.getInt(1);
													}
													else
														rootStateId = -1;
													
													if(rootStateId == -1)
														rootStateString = "null";
													else
														rootStateString = "'" + rootStateId + "'";
													
												// rootDistrictField
													if(rootDistrictField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `district_id` FROM `district_field` WHERE `district_name`='" + (String)rootDistrictField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														rootDistrictId = rs1.getInt(1);
													}
													else
														rootDistrictId = -1;
													
													if(rootDistrictId == -1)
														rootDistrictString = "null";
													else
														rootDistrictString = "'" + rootDistrictId + "'";
													
												// rootCityField
													if(rootCityField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `city_id` FROM `city_field` WHERE `city_name`='" + (String)rootCityField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														rootCityId = rs1.getInt(1);
													}
													else
														rootCityId = -1;
													
													if(rootCityId == -1)
														rootCityString = "null";
													else
														rootCityString = "'" + rootCityId + "'";
													
												// rootGotraField
													if(rootGotraField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `gotra_id` FROM `gotra_field` WHERE `gotra_name`='" + (String)rootGotraField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														rootGotraId = rs1.getInt(1);
													}
													else
														rootGotraId = -1;
													
													if(rootGotraId == -1)
														rootGotraString = "null";
													else
														rootGotraString = "'" + rootGotraId + "'";
													
												// rootKulDeviField
													if(rootKulDeviField.getSelectedIndex()!=0)
													{
														sql1 = "SELECT `kuldevi_id` FROM `kuldevi_field` WHERE `kuldevi_name`='" + (String)rootKulDeviField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														rootKulDeviId = rs1.getInt(1);
													}
													else
														rootKulDeviId = -1;
													
													if(rootKulDeviId == -1)
														rootKulDeviString = "null";
													else
														rootKulDeviString = "'" + rootKulDeviId + "'";
													
											// occupationRadioButton sql string conversion
												String occupation = "";
												String occupationResult = "";
												String occupationFieldName = "";
												
												Enumeration occupationAllButtons = occupationButtonGroup.getElements();
												
												JRadioButton occupationButton = (JRadioButton) occupationAllButtons.nextElement();
												if(occupationButton.isSelected())
													occupation = occupationButton.getText();
		
												occupationButton = (JRadioButton) occupationAllButtons.nextElement();
												if(occupationButton.isSelected())
													occupation = occupationButton.getText();
												
												if(occupation.compareTo("Business : ")==0)
													occupationResult = "true";
												else if(occupation.compareTo("Service : ")==0)
													occupationResult = "false";
												
												if(occupationResult.compareTo("true")==0)
												{
													if(businessField.getSelectedIndex()==-1)
														occupationFieldName = "null";
													else
													{
														sql1 = "SELECT `business_id` FROM `business_field` WHERE `business_name`='" + (String)businessField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														int businessId = rs1.getInt(1);
														
														occupationFieldName = "'" + businessId + "'";
													}
												}
												else if(occupationResult.compareTo("false")==0)
												{
													if(serviceField.getSelectedIndex()==-1)
														occupationFieldName = "null";
													else
													{
														sql1 = "SELECT `service_id` FROM `service_field` WHERE `service_name`='" + (String)serviceField.getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														int serviceId = rs1.getInt(1);
														
														occupationFieldName = "'" + serviceId + "'";
													}
												}
											
											// jointFamilyRadioButton sql string conversion
												String jointFamily = "";
												String jointFamilyResult = "";
												
												Enumeration jointFamilyAllButtons = livingInJointFamilyGroup.getElements();
												JRadioButton jointFamilyButton = (JRadioButton) jointFamilyAllButtons.nextElement();
												if(jointFamilyButton.isSelected())
													jointFamily = jointFamilyButton.getText();
												
												jointFamilyButton = (JRadioButton) jointFamilyAllButtons.nextElement();
												if(jointFamilyButton.isSelected())
													jointFamily = jointFamilyButton.getText();
												
												if(jointFamily.compareTo("Yes")==0)
													jointFamilyResult = "true";
												else if(jointFamily.compareTo("No")==0)
													jointFamilyResult = "false";
												else
													jointFamilyResult = "null";
											
											// ownHouseRadioButton sql string conversion
												String ownHouse = "";
												String ownHouseResult = "";
												
												Enumeration ownHouseAllButtons = haveOwnHouseGroup.getElements();
												JRadioButton ownHouseButton = (JRadioButton) ownHouseAllButtons.nextElement();
												if(ownHouseButton.isSelected())
													ownHouse = ownHouseButton.getText();
												
												ownHouseButton = (JRadioButton) ownHouseAllButtons.nextElement();
												if(ownHouseButton.isSelected())
													ownHouse = ownHouseButton.getText();
												
												if(ownHouse.compareTo("Yes")==0)
													ownHouseResult = "true";
												else if(ownHouse.compareTo("No")==0)
													ownHouseResult = "false";
												else
													ownHouseResult = "null";
											
											// intrestedInOtherActivitiesandAwardsRadioButton sql string conversion
												String intrestedSA = "";
												String intrestedSAResult = "";
												
												Enumeration intrestedSAAllButtons = intrestedInSocialActivityGroup.getElements();
												JRadioButton intrestedSAButton = (JRadioButton) intrestedSAAllButtons.nextElement();
												if(intrestedSAButton.isSelected())
													intrestedSA = intrestedSAButton.getText();
												
												intrestedSAButton = (JRadioButton) intrestedSAAllButtons.nextElement();
												if(intrestedSAButton.isSelected())
													intrestedSA = intrestedSAButton.getText();
												
												if(intrestedSA.compareTo("Yes")==0)
													intrestedSAResult = "true";
												else if(intrestedSA.compareTo("No")==0)
													intrestedSAResult ="false";
												else
													intrestedSAResult = "null";
											
											System.out.println("-> " + occupation + " " + occupationResult + " " + occupationFieldName + " | " + jointFamily + " " + jointFamilyResult + " | " + ownHouse + " " + ownHouseResult + " | " + intrestedSA + " " + intrestedSAResult);
											
											java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
											java.sql.Time currentTime = new java.sql.Time(System.currentTimeMillis());
											
											String addressLine2String;
											String phoneNumberString;
											String emailString;
											String otherExpertiseAwardsString;
											
											if(currentAddressLine2Field.getText().compareTo("")==0)
												addressLine2String = "null";
											else
												addressLine2String = "'" + currentAddressLine2Field.getText() + "'";
											
											if(phoneNumberField.getText().compareTo("")==0)
												phoneNumberString = "null";
											else
												phoneNumberString = "'" + phoneNumberField.getText() + "'";
											
											if(emailField.getText().compareTo("")==0)
												emailString = "null";
											else
												emailString = "'" + emailField.getText() + "'";
											
											if(rootExpertiseOrAwardsField.getText().compareTo("")==0)
												otherExpertiseAwardsString = "null";
											else
												otherExpertiseAwardsString = "'" + rootExpertiseOrAwardsField.getText() + "'";
											
											String sql = "INSERT INTO `main_form`(`form_number`, `receipt_number`, `donation`, `reference`, `phone_number`, `mobile_number`, `email`, `c_address1`, `c_address2`, `c_country`, `c_state`, `c_district`, `c_city`, `r_country`, `r_state`, `r_district`, `r_city`, `r_gotra`, `r_kuldevi`, `r_occupation`, `r_occupation_area`, `r_kul`, `r_mosal_surname`, `r_talgol`, `r_expertise_awards`, `joint_family`, `own_house`, `intrested_sa`,`admin_username`,`c_date`,`c_time`) VALUES ('" + formNumberField.getText() + "','" + receiptNumberField.getText() + "','" + donationField.getText() + "'," + referenceString + "," + phoneNumberString + ",'" + mobileNumberField.getText() + "'," + emailString + ",'" + currentAddressLine1Field.getText() + "'," + addressLine2String + "," + currentCountryString + "," + currentStateString + "," + currentDistrictString + "," + currentCityString + "," + rootCountryString + "," + rootStateString + "," + rootDistrictString + "," + rootCityString + "," + rootGotraString + "," + rootKulDeviString + "," + occupationResult + "," + occupationFieldName + "," + kulString + "," + moshalSurnameString + "," + talGolString + "," + otherExpertiseAwardsString + "," + jointFamilyResult + "," + ownHouseResult + "," + intrestedSAResult + ",'" + "admin" + "','" + currentDate + "','" + currentTime + "')";
											stmt.executeUpdate(sql);
											
											for(int i=0 ; i<numberOfFamilyMembersField.getSelectedIndex() ; i++)
											{
												String memberRelationString = "";
												String memberSurnameString = "";
												int memberRelationId;
												int memberSurnameId;
												
												// memberRelationString
													if(familyMemberRelationField[i].getSelectedIndex()!=0)
													{
														sql1 = "SELECT `relation_id` FROM `relation_field` WHERE `relation_name`='" + (String)familyMemberRelationField[i].getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														memberRelationId = rs1.getInt(1);
													}
													else
														memberRelationId = -1;
													
													if(memberRelationId == -1)
														memberRelationString = "null";
													else
														memberRelationString = "'" + memberRelationId + "'";
													
												// memberSurnameString
													if(familyMemberSurnameField[i].getSelectedIndex()!=0)
													{
														sql1 = "SELECT `surname_id` FROM `surname_field` WHERE `surname_name`='" + (String)familyMemberSurnameField[i].getSelectedItem() + "'";
														rs1 = stmt.executeQuery(sql1);
														rs1.next();
														memberSurnameId = rs1.getInt(1);
													}
													else
														memberSurnameId = -1;
													
													if(memberSurnameId == -1)
														memberSurnameString = "null";
													else
														memberSurnameString = "'" + memberSurnameId + "'";
												
												// familyMemberMaritualStatusRadioButton sql string conversion
													String maritualStatus = "";
													String maritualStatusResult = "";
													
													Enumeration maritualStatusAllButtons = familyMemberMaritualStatusGroup[i].getElements();
													JRadioButton maritualStatusButton = (JRadioButton) maritualStatusAllButtons.nextElement();
													if(maritualStatusButton.isSelected())
														maritualStatus = maritualStatusButton.getText();
													
													maritualStatusButton = (JRadioButton) maritualStatusAllButtons.nextElement();
													if(maritualStatusButton.isSelected())
														maritualStatus = maritualStatusButton.getText();
													
													if(maritualStatus.compareTo("Married")==0)
														maritualStatusResult = "true";
													else if(maritualStatus.compareTo("Unmarried")==0)
														maritualStatusResult = "false";
													else
														maritualStatusResult = "null";
												
												// familyMemberGenderRadioButton sql string conversion
													String gender = "";
													String genderResult = "";
													
													Enumeration genderAllButtons = familyMemberGenderGroup[i].getElements();
													JRadioButton genderButton = (JRadioButton) genderAllButtons.nextElement();
													if(genderButton.isSelected())
														gender = genderButton.getText();
													
													genderButton = (JRadioButton) genderAllButtons.nextElement();
													if(genderButton.isSelected())
														gender = genderButton.getText();
													
													if(gender.compareTo("Male")==0)
														genderResult = "true";
													else if(gender.compareTo("Female")==0)
														genderResult = "false";
													else
														genderResult = "null";

													
//												java.util.Date bd = familyMemberBirthDateField[i].getDate();
												java.util.Date bd = new Date("1965-06-21");
												System.out.println("birthDate : - > " + bd);
												
												String birthDateString;
												String whatsappNumberString;
												
												if(bd==null)
													birthDateString = "null";
												else
												{
													long millis = bd.getTime();
													java.sql.Date birthdateResult = new java.sql.Date(millis);
													System.out.println(birthdateResult);
													
													birthDateString = "'" + birthdateResult + "'";
												}
												
												if(whatsappNumberField[i].getText().compareTo("")==0)
													whatsappNumberString = "null";
												else
													whatsappNumberString = "'" + whatsappNumberField[i].getText() + "'";
												
												String sql2 = "INSERT INTO `family_details`(`form_number`, `relation`, `surname`, `name`, `father_name`, `birthdate`, `maritual_status`, `gender`, `wp_number`) VALUES ('" + formNumberField.getText() + "'," + memberRelationString + "," + memberSurnameString + ",'" + familyMemberNameField[i].getText() + "','" + familyMemberFatherNameField[i].getText() + "'," + birthDateString + "," + maritualStatusResult + "," + genderResult + "," + whatsappNumberString + ")";
												stmt.executeUpdate(sql2);
												
												for(int j=0 ; j<numberOfEducationQualificationField[i].getSelectedIndex() ; j++)
												{
													try
													{
														Class.forName("com.mysql.jdbc.Driver");
														
														Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
														Statement stmt1 = con1.createStatement();
						
														String sql4 = "SELECT `degree_id` FROM `degree_field` WHERE `degree_name`='" + (String)familyMemberDegreeField[i][j].getSelectedItem() + "'";
														ResultSet rs2 = stmt1.executeQuery(sql4);
														rs2.next();
														String degreeId = rs2.getString(1);
														System.out.println("degreeId : " + degreeId);
														
														String sql3 = "SELECT `family_member_id` FROM `family_details` WHERE `form_number`='" + formNumberField.getText() + "' AND `relation`='" + memberRelationId + "' AND `name`='" + familyMemberNameField[i].getText() + "'";
														ResultSet rs = stmt1.executeQuery(sql3);
														
														while(rs.next())
														{
															String familyMemberId = rs.getString(1);
															System.out.println("familyMemberID : " + familyMemberId);
															String sql5 = "INSERT INTO `member_degree`(`family_member_id`, `degree_id`) VALUES ('" + familyMemberId + "','" + degreeId + "')";
															stmt.executeUpdate(sql5);
														}
														
														rs.close();
													}
													catch(Exception exc)
													{
														JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
													}
												}
											}
											
											String options1[] = {"OK"};
											JOptionPane.showOptionDialog(null, "Form was successfully uploded to the database", "", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Successful.png"), options1, options1[0]);
											
											String sql6 = "SELECT COUNT(`form_number`) FROM `main_form`";
											
											ResultSet rs2 = stmt.executeQuery(sql6);
											rs2.next();
											totalFormNumber.setText("Total Exsisting Forms : " + rs2.getInt(1));
											
											resetForm(numberOfFamilyMembersField.getSelectedIndex());
											setEnableOnFormNumber(false);
											
											formNumberField.setText("");
											formNumberField.setEnabled(true);
										}
										catch(Exception exc)
										{
											exc.printStackTrace();
											JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
										}
									}
									else
									{
										String options1[] = {"OK"};
										JOptionPane.showOptionDialog(null, "Form was not uploded to the database because of user's rejection!", "", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Exclamation.png"), options1, options1[0]);
									}
								}
								else
								{
									String option[] = {"OK"};
									JOptionPane.showOptionDialog(null, "Please enter mendatory fields first.", "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"), option, option[0]);
								}
							}
						}
					});
					
					
				// resetFormButton
					resetFormButton = new JButton("Reset");
					resetFormButton.setForeground(Color.LIGHT_GRAY);
					resetFormButton.setBackground(Color.DARK_GRAY);
					resetFormButton.setBounds(mainFooterPanelWidth-200, 845, 150, 24);
					resetFormButton.setFocusable(true);
					resetFormButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							String options[] = {"Yes", "Cancel"};
							int result = JOptionPane.showOptionDialog(null, "All unsaved data will be lost. Are you sure you want to reset this form?", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("Question.png"), options, options[1]);
							if(result==0)
								resetForm(numberOfFamilyMembersField.getSelectedIndex());
						}
					});
					
					addMemberPanel.add(submitFormButton);
					addMemberPanel.add(resetFormButton);
					
					setEnableOnFormNumber(false);
					
					
				// resetFormWithFormNumberButton
					resetFormWithFormNumberButton = new JButton("Reset with Form Number");
					resetFormWithFormNumberButton.setForeground(Color.LIGHT_GRAY);
					resetFormWithFormNumberButton.setBackground(Color.DARK_GRAY);
					resetFormWithFormNumberButton.setBounds(mainFooterPanelWidth-380-180-50, 845, 200, 24);//TODO
					resetFormWithFormNumberButton.setFocusable(true);
					resetFormWithFormNumberButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							String options[] = {"Yes", "Cancel"};
							int result = JOptionPane.showOptionDialog(null, "All unsaved data will be lost. Are you sure you want to reset this form?", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("Question.png"), options, options[1]);
							if(result==0)
								resetFormWithFormNumber(numberOfFamilyMembersField.getSelectedIndex());
						}
					});
					
					addMemberPanel.add(resetFormWithFormNumberButton);
					
			
			// addFieldsPanel
				addFieldsPanel = new JPanel();
				addFieldsPanel.setLayout(null);
				addFieldsPanel.setVisible(false);
				addFieldsPanel.setPreferredSize(new Dimension(mainFooterPanelWidth-20,1435));
				addFieldsPanel.setBackground(Color.LIGHT_GRAY);
				
				addFieldsPanelScrollPane = new JScrollPane(addFieldsPanel);
				addFieldsPanelScrollPane.setVisible(false);
				addFieldsPanelScrollPane.setBounds(160, 60, mainFooterPanelWidth, mainFooterPanelHeight);
				adminPanel.add(addFieldsPanelScrollPane);
				
				// JPanel initialDetailsFieldsPanel, addressDetailsFieldsPanel, rootDetailsFieldsPanel, educationQualificationDetailsFieldsPanel;
				
				// initialDetailsFieldsPanel
					border = new TitledBorder(border,"Initial Details Fields",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					initialDetailsFieldsPanel = new JPanel();
					initialDetailsFieldsPanel.setLayout(null);
					initialDetailsFieldsPanel.setVisible(true);
					initialDetailsFieldsPanel.setBounds(40, 30, initialDetailsFieldsPanelWidth, 125);
					initialDetailsFieldsPanel.setBackground(Color.LIGHT_GRAY);
					initialDetailsFieldsPanel.setBorder(border);
					
					addFieldsPanel.add(initialDetailsFieldsPanel);
				
					// addSurnamePanel
						border = new TitledBorder(border,"Add Surname",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addSurnamePanel = new JPanel();
						addSurnamePanel.setLayout(null);
						addSurnamePanel.setVisible(true);
						addSurnamePanel.setBounds(30, 25, addSurnamePanelWidth, 75);
						addSurnamePanel.setBackground(Color.LIGHT_GRAY);
						addSurnamePanel.setBorder(border);
						
						addSurnameField = new JTextField("anything");
						addSurnameField.setFont(font);
						addSurnameField.setVisible(true);
						addSurnameField.setForeground(Color.DARK_GRAY);
						addSurnameField.setBackground(Color.LIGHT_GRAY);
						addSurnameField.setBorder(BorderFactory.createLoweredBevelBorder());
						addSurnameField.setBounds(20, 30, (addSurnamePanelWidth/2)-30, 24);
						addSurnameField.setFocusable(true);
						addSurnameField.setDocument(new JTextFieldLimit(30));
						
						addSurnameButton = new JButton("Add Surname");
						addSurnameButton.setForeground(Color.LIGHT_GRAY);
						addSurnameButton.setBackground(Color.DARK_GRAY);
						addSurnameButton.setBounds((addSurnamePanelWidth/2)+10, 30, (addSurnamePanelWidth/2)-30, 24);
						addSurnameButton.setFocusable(true);
						addSurnameButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String surnameString = addSurnameField.getText();
									
									if(surnameString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`surname_id`) FROM `surname_field` WHERE `surname_name`='" + surnameString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered surname is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `surname_field`(`surname_name`) VALUES ('" + surnameString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered surname is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addSurnameField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter surname field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addSurnamePanel.add(addSurnameField);
						addSurnamePanel.add(addSurnameButton);
						
						
					// addReferencebyPanel
						border = new TitledBorder(border,"Add Reference",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addReferencebyPanel = new JPanel();
						addReferencebyPanel.setLayout(null);
						addReferencebyPanel.setVisible(true);
						addReferencebyPanel.setBounds((initialDetailsFieldsPanelWidth/2)+15, 25, addReferencebyPanelWidth, 75);
						addReferencebyPanel.setBackground(Color.LIGHT_GRAY);
						addReferencebyPanel.setBorder(border);
						
						addReferencebyField = new JTextField();
						addReferencebyField.setFont(font);
						addReferencebyField.setVisible(true);
						addReferencebyField.setForeground(Color.DARK_GRAY);
						addReferencebyField.setBackground(Color.LIGHT_GRAY);
						addReferencebyField.setBorder(BorderFactory.createLoweredBevelBorder());
						addReferencebyField.setBounds(20, 30, (addReferencebyPanelWidth/2)-30, 24);
						addReferencebyField.setFocusable(true);
						addReferencebyField.setDocument(new JTextFieldLimit(60));
						
						addReferencebyButton = new JButton("Add Reference");
						addReferencebyButton.setForeground(Color.LIGHT_GRAY);
						addReferencebyButton.setBackground(Color.DARK_GRAY);
						addReferencebyButton.setBounds((addReferencebyPanelWidth/2)+10, 30, (addReferencebyPanelWidth/2)-30, 24);
						addReferencebyButton.setFocusable(true);
						addReferencebyButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String referencebyString = addReferencebyField.getText();
									
									if(referencebyString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`reference_id`) FROM `reference_field` WHERE `reference_name`='" + referencebyString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered Reference is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `reference_field`(`reference_name`) VALUES ('" + referencebyString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered Reference is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addReferencebyField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter reference field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addReferencebyPanel.add(addReferencebyField);
						addReferencebyPanel.add(addReferencebyButton);
					
					initialDetailsFieldsPanel.add(addSurnamePanel);
					initialDetailsFieldsPanel.add(addReferencebyPanel);
						
	
				// addressDetailsFieldsPanel
					border = new TitledBorder(border,"Address Details Fields",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					addressDetailsFieldsPanel = new JPanel();
					addressDetailsFieldsPanel.setLayout(null);
					addressDetailsFieldsPanel.setVisible(true);
					addressDetailsFieldsPanel.setBounds(40, 185, addressDetailsFieldsPanelWidth, 335);
					addressDetailsFieldsPanel.setBackground(Color.LIGHT_GRAY);
					addressDetailsFieldsPanel.setBorder(border);
					
					addFieldsPanel.add(addressDetailsFieldsPanel);
					
					// addCountryPanel
						border = new TitledBorder(border,"Add Country",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addCountryPanel = new JPanel();
						addCountryPanel.setLayout(null);
						addCountryPanel.setVisible(true);
						addCountryPanel.setBounds(30, 25, addCountryPanelWidth, 75);
						addCountryPanel.setBackground(Color.LIGHT_GRAY);
						addCountryPanel.setBorder(border);
						
						addCountryField = new JTextField();
						addCountryField.setFont(font);
						addCountryField.setVisible(true);
						addCountryField.setForeground(Color.DARK_GRAY);
						addCountryField.setBackground(Color.LIGHT_GRAY);
						addCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
						addCountryField.setBounds(20, 30, (addCountryPanelWidth/2)-30, 24);
						addCountryField.setFocusable(true);
						addCountryField.setDocument(new JTextFieldLimit(60));
						
						addCountryButton = new JButton("Add Country");
						addCountryButton.setForeground(Color.LIGHT_GRAY);
						addCountryButton.setBackground(Color.DARK_GRAY);
						addCountryButton.setBounds((addCountryPanelWidth/2)+10, 30, (addCountryPanelWidth/2)-30, 24);
						addCountryButton.setFocusable(true);
						addCountryButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String countryString = addCountryField.getText();
									
									if(countryString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`country_id`) FROM `country_field` WHERE `country_name`='" + countryString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered Country is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `country_field`(`country_name`) VALUES ('" + countryString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered Country is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addCountryField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter country field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addCountryPanel.add(addCountryField);
						addCountryPanel.add(addCountryButton);
						
						
					// addStatePanel
						border = new TitledBorder(border,"Add State",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addStatePanel = new JPanel();
						addStatePanel.setLayout(null);
						addStatePanel.setVisible(true);
						addStatePanel.setBounds((addressDetailsFieldsPanelWidth/2)+15, 25, addStatePanelWidth, 75);
						addStatePanel.setBackground(Color.LIGHT_GRAY);
						addStatePanel.setBorder(border);
						
						stateSelectCountryField = new JComboBox();
						stateSelectCountryField.setFont(font);
						stateSelectCountryField.setForeground(Color.DARK_GRAY);
						stateSelectCountryField.setBackground(Color.LIGHT_GRAY);
						stateSelectCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
						stateSelectCountryField.setBounds(20, 30, (addStatePanelWidth/3)-30, 24);
						stateSelectCountryField.setFocusable(true);
						stateSelectCountryField.addItem("--Select Country--");
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
							Statement stmt = con.createStatement();
							
							String sql = "SELECT `country_name` FROM `country_field`";
							ResultSet rs = stmt.executeQuery(sql);
							
							while(rs.next())
								stateSelectCountryField.addItem(rs.getString(1));
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						addStateField = new JTextField();
						addStateField.setFont(font);
						addStateField.setVisible(true);
						addStateField.setForeground(Color.DARK_GRAY);
						addStateField.setBackground(Color.LIGHT_GRAY);
						addStateField.setBorder(BorderFactory.createLoweredBevelBorder());
						addStateField.setBounds((addStatePanelWidth/3)+10, 30, (addStatePanelWidth/3)-20, 24);
						addStateField.setFocusable(true);
						addStateField.setDocument(new JTextFieldLimit(60));
						
						addStateButton = new JButton("Add State");
						addStateButton.setForeground(Color.LIGHT_GRAY);
						addStateButton.setBackground(Color.DARK_GRAY);
						addStateButton.setBounds((2 * addStatePanelWidth/3)+10, 30, (addStatePanelWidth/3)-30, 24);
						addStateButton.setFocusable(true);
						addStateButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								if(stateSelectCountryField.getSelectedIndex()!=0)
								{
									try
									{
										String stateString = addStateField.getText();
										
										if(stateString.compareTo("")!=0)
										{
											Class.forName("com.mysql.jdbc.Driver");
											
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
											Statement stmt = con.createStatement();
											
											String sql;
											ResultSet rs;
											
											sql = "SELECT COUNT(`state_id`) FROM `state_field` WHERE `state_name`='" + stateString + "'";
											rs = stmt.executeQuery(sql);
											rs.next();
											if(rs.getInt(1)!=0)
											{
												JOptionPane.showMessageDialog(null, "Entered State is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
											}
											else
											{
												sql = "SELECT `country_id` FROM `country_field` WHERE `country_name`='" + (String)stateSelectCountryField.getSelectedItem() + "'";
												ResultSet rs1 = stmt.executeQuery(sql);
												rs1.next();
												
												sql = "INSERT INTO `state_field`(`country_id`,`state_name`) VALUES ('" + rs1.getString(1) + "','" + stateString + "')";
												stmt.executeUpdate(sql);
												
												JOptionPane.showMessageDialog(null, "Entered State is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
												
												addStateField.setText("");
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Please enter state field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Please select the country first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
								}
							}
						});
						
						addStatePanel.add(stateSelectCountryField);
						addStatePanel.add(addStateField);
						addStatePanel.add(addStateButton);
						
					
					// addDistrictPanel
						border = new TitledBorder(border,"Add District",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addDistrictPanel = new JPanel();
						addDistrictPanel.setLayout(null);
						addDistrictPanel.setVisible(true);
						addDistrictPanel.setBounds(30, 130, addDistrictPanelWidth, 75);
						addDistrictPanel.setBackground(Color.LIGHT_GRAY);
						addDistrictPanel.setBorder(border);
						
						districtSelectCountryField = new JComboBox();
						districtSelectCountryField.setFont(font);
						districtSelectCountryField.setForeground(Color.DARK_GRAY);
						districtSelectCountryField.setBackground(Color.LIGHT_GRAY);
						districtSelectCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
						districtSelectCountryField.setBounds(20, 30, (addDistrictPanelWidth/4)-30, 24);
						districtSelectCountryField.setFocusable(true);
						districtSelectCountryField.addItem("--Select Country--");
						districtSelectCountryField.addItemListener(new ItemListener()
						{
							public void itemStateChanged(ItemEvent e)
							{
								districtSelectStateField.removeAllItems();
								
								districtSelectStateField.addItem("--Select State--");
								
								if(districtSelectCountryField.getSelectedIndex()!=0)
								{
									try
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt1 = con1.createStatement();
	
										String sql1 = "SELECT `country_id` FROM `country_field` WHERE `country_name`='" + (String)districtSelectCountryField.getSelectedItem() + "'";
										ResultSet rs1 = stmt1.executeQuery(sql1);
										rs1.next();
										System.out.println("country id : " + rs1.getString(1));
										String CountryId = rs1.getString(1);
										
										String sql2 = "SELECT `state_name` FROM `state_field` WHERE `country_id`='" + CountryId + "'";
										ResultSet rs2 = stmt1.executeQuery(sql2);
										
										while(rs2.next())
										{
											System.out.println("state : " + rs2.getString(1));
											districtSelectStateField.addItem(rs2.getString(1));
										}
										
										districtSelectStateField.setEnabled(true);
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						});
						
						districtSelectStateField = new JComboBox();
						districtSelectStateField.setFont(font);
						districtSelectStateField.setForeground(Color.DARK_GRAY);
						districtSelectStateField.setBackground(Color.LIGHT_GRAY);
						districtSelectStateField.setBorder(BorderFactory.createLoweredBevelBorder());
						districtSelectStateField.setBounds((addDistrictPanelWidth/4)+10, 30, (addDistrictPanelWidth/4)-20, 24);
						districtSelectStateField.setFocusable(true);
						districtSelectStateField.addItem("--Select State--");
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
							Statement stmt = con.createStatement();
							
							String sql;
							ResultSet rs;
							
							sql = "SELECT `country_name` FROM `country_field`";
							rs = stmt.executeQuery(sql);
							
							while(rs.next())
								districtSelectCountryField.addItem(rs.getString(1));
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						addDistrictField = new JTextField();
						addDistrictField.setFont(font);
						addDistrictField.setVisible(true);
						addDistrictField.setForeground(Color.DARK_GRAY);
						addDistrictField.setBackground(Color.LIGHT_GRAY);
						addDistrictField.setBorder(BorderFactory.createLoweredBevelBorder());
						addDistrictField.setBounds((2 * addDistrictPanelWidth/4)+10, 30, (addDistrictPanelWidth/4)-20, 24);
						addDistrictField.setFocusable(true);
						addDistrictField.setDocument(new JTextFieldLimit(60));
						
						addDistrictButton = new JButton("Add District");
						addDistrictButton.setForeground(Color.LIGHT_GRAY);
						addDistrictButton.setBackground(Color.DARK_GRAY);
						addDistrictButton.setBounds((3 * addDistrictPanelWidth/4)+10, 30, (addDistrictPanelWidth/4)-30, 24);
						addDistrictButton.setFocusable(true);
						addDistrictButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								if(districtSelectCountryField.getSelectedIndex()!=0 && districtSelectStateField.getSelectedIndex()!=0)
								{
									try
									{
										String districtString = addDistrictField.getText();
										
										if(districtString.compareTo("")!=0)
										{
											Class.forName("com.mysql.jdbc.Driver");
											
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
											Statement stmt = con.createStatement();
											
											String sql;
											ResultSet rs;
											
											sql = "SELECT COUNT(`district_id`) FROM `district_field` WHERE `district_name`='" + districtString + "'";
											rs = stmt.executeQuery(sql);
											rs.next();
											if(rs.getInt(1)!=0)
											{
												JOptionPane.showMessageDialog(null, "Entered District is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
											}
											else
											{
												sql = "SELECT `state_id` FROM `state_field` WHERE `state_name`='" + (String)districtSelectStateField.getSelectedItem() + "'";
												ResultSet rs1 = stmt.executeQuery(sql);
												rs1.next();
												
												sql = "INSERT INTO `district_field`(`state_id`,`district_name`) VALUES ('" + rs1.getInt(1) + "','" + districtString + "')";
												stmt.executeUpdate(sql);
												
												JOptionPane.showMessageDialog(null, "Entered District is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
												
												addDistrictField.setText("");
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Please enter district field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else
								{
									if(districtSelectCountryField.getSelectedIndex()==0)
										JOptionPane.showMessageDialog(null, "Please select the country first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									else if(districtSelectStateField.getSelectedIndex()==0)
										JOptionPane.showMessageDialog(null, "Please select the state first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
								}
							}
						});
						
						addDistrictPanel.add(districtSelectCountryField);
						addDistrictPanel.add(districtSelectStateField);
						addDistrictPanel.add(addDistrictField);
						addDistrictPanel.add(addDistrictButton);
						
						
					// addCityPanel
						border = new TitledBorder(border,"Add City",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addCityPanel = new JPanel();
						addCityPanel.setLayout(null);
						addCityPanel.setVisible(true);
						addCityPanel.setBounds(30, 235, addCityPanelWidth, 75);
						addCityPanel.setBackground(Color.LIGHT_GRAY);
						addCityPanel.setBorder(border);
						
						citySelectCountryField = new JComboBox();
						citySelectCountryField.setFont(font);
						citySelectCountryField.setForeground(Color.DARK_GRAY);
						citySelectCountryField.setBackground(Color.LIGHT_GRAY);
						citySelectCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
						citySelectCountryField.setBounds(20, 30, (addCityPanelWidth/5)-30, 24);
						citySelectCountryField.setFocusable(true);
						citySelectCountryField.addItem("--Select Country--");
						
						citySelectCountryField.addItemListener(new ItemListener()
						{
							public void itemStateChanged(ItemEvent e)
							{
	//							System.out.println(e.getItem() + " " + e.getStateChange());
								
								if(e.getStateChange()==1)
								{
									System.out.println("error at country field");
									int totalItemsState = citySelectStateField.getItemCount();
									boolean firstTimeState = false;
									
									if(totalItemsState==0)
										firstTimeState=true;
									
									citySelectStateField.removeKeyListener(null);
									
									if(!firstTimeState)
										citySelectStateField.setSelectedIndex(0);
									
									for(int k=totalItemsState-1 ; k>0 ; k--)
									{
				//						System.out.println("-> " + k);
										citySelectStateField.removeItemAt(k);
				//						System.out.println("-> " + k);
									}
	
									System.out.println("845");
									
									if(citySelectCountryField.getSelectedIndex()!=0)
									{
										System.out.println("I'm executed");
										
										citySelectStateField.addItem("--Select State--");
										
										try
										{
											Class.forName("com.mysql.jdbc.Driver");
											
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
											Statement stmt = con.createStatement();
										
											String sql;
											ResultSet rs1;
											
											sql = "SELECT `country_id` FROM `country_field` WHERE `country_name`='" + (String)citySelectCountryField.getSelectedItem() + "'";
											rs1 = stmt.executeQuery(sql);
											rs1.next();
											String countryId = rs1.getString(1);
											
											System.out.println("868");
											
											sql = "SELECT `state_name` FROM `state_field` WHERE `country_id`='" + countryId + "'";
											rs1 = stmt.executeQuery(sql);
											
											System.out.println("873");
											
											while(rs1.next())
											{
												citySelectStateField.addItem(rs1.getString(1));
											}
										}
										catch(Exception exc)
										{
											JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
										}
										
										if(!firstTimeState)
											citySelectStateField.removeItemAt(0);
										
										citySelectStateField.addItemListener(new ItemListener()
										{
											public void itemStateChanged(ItemEvent e)
											{
												if(e.getStateChange()==1)
												{
													System.out.println("error at state field");
													int totalItemsDistrict = citySelectDistrictField.getItemCount();
													boolean firstTimeDistrict = false;
													
													if(totalItemsDistrict==0)
														firstTimeDistrict=true;
													
													citySelectDistrictField.removeKeyListener(null);
													
													if(!firstTimeDistrict)
														citySelectDistrictField.setSelectedIndex(0);
													
													for(int k=totalItemsDistrict-1 ; k>0 ; k--)
													{
								//						System.out.println("-> " + k);
														citySelectDistrictField.removeItemAt(k);
								//						System.out.println("-> " + k);
													}
	
													if(citySelectStateField.getSelectedIndex()!=0)
													{
								//						System.out.println("I'm executed");
														
														citySelectDistrictField.addItem("--Select District--");
														
														try
														{
															Class.forName("com.mysql.jdbc.Driver");
															
															Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
															Statement stmt1 = con1.createStatement();
					
															String sql1 = "SELECT `state_id` FROM `state_field` WHERE `state_name`='" + (String)citySelectStateField.getSelectedItem() + "'";
															ResultSet rs1 = stmt1.executeQuery(sql1);
															rs1.next();
															String stateId = rs1.getString(1);
															
															String sql2 = "SELECT `district_name` FROM `district_field` WHERE `state_id`='" + stateId + "'";
															ResultSet rs2 = stmt1.executeQuery(sql2);
															
															while(rs2.next())
																citySelectDistrictField.addItem(rs2.getString(1));
															
															citySelectDistrictField.setEnabled(true);
														}
														catch(Exception exc)
														{
															JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
														}
														
														if(!firstTimeDistrict)
															citySelectDistrictField.removeItemAt(0);
													}
												}
											}
										});
									}
								}
							}
						});
	
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
							Statement stmt = con.createStatement();
							
							String sql;
							ResultSet rs;
							
							sql = "SELECT `country_name` FROM `country_field`";
							rs = stmt.executeQuery(sql);
							
							while(rs.next())
								citySelectCountryField.addItem(rs.getString(1));
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						citySelectStateField = new JComboBox();
						citySelectStateField.setFont(font);
						citySelectStateField.setForeground(Color.DARK_GRAY);
						citySelectStateField.setBackground(Color.LIGHT_GRAY);
						citySelectStateField.setBorder(BorderFactory.createLoweredBevelBorder());
						citySelectStateField.setBounds((addCityPanelWidth/5)+10, 30, (addCityPanelWidth/5)-20, 24);
						citySelectStateField.setFocusable(true);
						citySelectStateField.addItem("--Select State--");
						
						citySelectDistrictField = new JComboBox();
						citySelectDistrictField.setFont(font);
						citySelectDistrictField.setForeground(Color.DARK_GRAY);
						citySelectDistrictField.setBackground(Color.LIGHT_GRAY);
						citySelectDistrictField.setBorder(BorderFactory.createLoweredBevelBorder());
						citySelectDistrictField.setBounds((2 * addCityPanelWidth/5)+10, 30, (addCityPanelWidth/5)-20, 24);
						citySelectDistrictField.setFocusable(true);
						citySelectDistrictField.addItem("--Select District--");
						
						addCityField = new JTextField();
						addCityField.setFont(font);
						addCityField.setVisible(true);
						addCityField.setForeground(Color.DARK_GRAY);
						addCityField.setBackground(Color.LIGHT_GRAY);
						addCityField.setBorder(BorderFactory.createLoweredBevelBorder());
						addCityField.setBounds((3 * addCityPanelWidth/5)+10, 30, (addCityPanelWidth/5)-20, 24);
						addCityField.setFocusable(true);
						addCityField.setDocument(new JTextFieldLimit(60));
						
						addCityButton = new JButton("Add City");
						addCityButton.setForeground(Color.LIGHT_GRAY);
						addCityButton.setBackground(Color.DARK_GRAY);
						addCityButton.setBounds((4 * addCityPanelWidth/5)+10, 30, (addCityPanelWidth/5)-30, 24);
						addCityButton.setFocusable(true);
						addCityButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								if(citySelectCountryField.getSelectedIndex()!=0 && citySelectStateField.getSelectedIndex()!=0 && citySelectDistrictField.getSelectedIndex()!=0)
								{
									try
									{
										String cityString = addCityField.getText();
										
										if(cityString.compareTo("")!=0)
										{
											Class.forName("com.mysql.jdbc.Driver");
											
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
											Statement stmt = con.createStatement();
											
											String sql;
											ResultSet rs;
											
											sql = "SELECT COUNT(`city_id`) FROM `city_field` WHERE `city_name`='" + cityString + "'";
											rs = stmt.executeQuery(sql);
											rs.next();
											if(rs.getInt(1)!=0)
											{
												JOptionPane.showMessageDialog(null, "Entered City is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
											}
											else
											{
												sql = "SELECT `district_id` FROM `district_field` WHERE `district_name`='" + (String)citySelectDistrictField.getSelectedItem() + "'";
												ResultSet rs1 = stmt.executeQuery(sql);
												rs1.next();
												
												sql = "INSERT INTO `city_field`(`district_id`,`city_name`) VALUES ('" + rs1.getInt(1) + "','" + cityString + "')";
												stmt.executeUpdate(sql);
												
												JOptionPane.showMessageDialog(null, "Entered City is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
												
												addCityField.setText("");
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Please enter city field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else
								{
									String errorMessage = "";
									
									if(citySelectCountryField.getSelectedIndex()==0)
										errorMessage = "Please select the country first";
									else if(citySelectStateField.getSelectedIndex()==0)
										errorMessage = "Please select the state first";
									else if(citySelectDistrictField.getSelectedIndex()==0)
										errorMessage = "Please select the district first";
									
									JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
								}
							}
						});
						
						addCityPanel.add(citySelectCountryField);
						addCityPanel.add(citySelectStateField);
						addCityPanel.add(citySelectDistrictField);
						addCityPanel.add(addCityField);
						addCityPanel.add(addCityButton);
					
					addressDetailsFieldsPanel.add(addCountryPanel);
					addressDetailsFieldsPanel.add(addStatePanel);
					addressDetailsFieldsPanel.add(addDistrictPanel);
					addressDetailsFieldsPanel.add(addCityPanel);
						

				// rootDetailsFieldsPanelWidth
					border = new TitledBorder(border,"Root Details Fields",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					rootDetailsFieldsPanel = new JPanel();
					rootDetailsFieldsPanel.setLayout(null);
					rootDetailsFieldsPanel.setVisible(true);
					rootDetailsFieldsPanel.setBounds(40, 550, rootDetailsFieldsPanelWidth, 440);
					rootDetailsFieldsPanel.setBackground(Color.LIGHT_GRAY);
					rootDetailsFieldsPanel.setBorder(border);
					
					addFieldsPanel.add(rootDetailsFieldsPanel);
					
					// addGotraPanel
						border = new TitledBorder(border,"Add Gotra",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addGotraPanel = new JPanel();
						addGotraPanel.setLayout(null);
						addGotraPanel.setVisible(true);
						addGotraPanel.setBounds(30, 25, addGotraPanelWidth, 75);
						addGotraPanel.setBackground(Color.LIGHT_GRAY);
						addGotraPanel.setBorder(border);
						
						addGotraField = new JTextField();
						addGotraField.setFont(font);
						addGotraField.setVisible(true);
						addGotraField.setForeground(Color.DARK_GRAY);
						addGotraField.setBackground(Color.LIGHT_GRAY);
						addGotraField.setBorder(BorderFactory.createLoweredBevelBorder());
						addGotraField.setBounds(20, 30, (addGotraPanelWidth/2)-30, 24);
						addGotraField.setFocusable(true);
						addGotraField.setDocument(new JTextFieldLimit(60));
						
						addGotraButton = new JButton("Add Gotra");
						addGotraButton.setForeground(Color.LIGHT_GRAY);
						addGotraButton.setBackground(Color.DARK_GRAY);
						addGotraButton.setBounds((addGotraPanelWidth/2)+10, 30, (addGotraPanelWidth/2)-30, 24);
						addGotraButton.setFocusable(true);
						addGotraButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String gotraString = addGotraField.getText();
									
									if(gotraString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`gotra_id`) FROM `gotra_field` WHERE `gotra_name`='" + gotraString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered Gotra is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `gotra_field`(`gotra_name`) VALUES ('" + gotraString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered Gotra is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addGotraField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter gotra field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addGotraPanel.add(addGotraField);
						addGotraPanel.add(addGotraButton);
						
					
					// addKulDeviPanel
						border = new TitledBorder(border,"Add KulDevi",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addKulDeviPanel = new JPanel();
						addKulDeviPanel.setLayout(null);
						addKulDeviPanel.setVisible(true);
						addKulDeviPanel.setBounds((rootDetailsFieldsPanelWidth/2)+15, 25, addKulDeviPanelWidth, 75);
						addKulDeviPanel.setBackground(Color.LIGHT_GRAY);
						addKulDeviPanel.setBorder(border);
						
						addKulDeviField = new JTextField();
						addKulDeviField.setFont(font);
						addKulDeviField.setVisible(true);
						addKulDeviField.setForeground(Color.DARK_GRAY);
						addKulDeviField.setBackground(Color.LIGHT_GRAY);
						addKulDeviField.setBorder(BorderFactory.createLoweredBevelBorder());
						addKulDeviField.setBounds(20, 30, (addKulDeviPanelWidth/2)-30, 24);
						addKulDeviField.setFocusable(true);
						addKulDeviField.setDocument(new JTextFieldLimit(60));
						
						addKulDeviButton = new JButton("Add KulDevi");
						addKulDeviButton.setForeground(Color.LIGHT_GRAY);
						addKulDeviButton.setBackground(Color.DARK_GRAY);
						addKulDeviButton.setBounds((addKulDeviPanelWidth/2)+10, 30, (addKulDeviPanelWidth/2)-30, 24);
						addKulDeviButton.setFocusable(true);
						addKulDeviButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String kulDeviString = addKulDeviField.getText();
									
									if(kulDeviString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`kuldevi_id`) FROM `kuldevi_field` WHERE `kuldevi_name`='" + kulDeviString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered KulDevi is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `kuldevi_field`(`kuldevi_name`) VALUES ('" + kulDeviString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered KulDevi is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addKulDeviField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter kuldevi field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addKulDeviPanel.add(addKulDeviField);
						addKulDeviPanel.add(addKulDeviButton);
						
					
					// addBusinessPanel
						border = new TitledBorder(border,"Add Business",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addBusinessPanel = new JPanel();
						addBusinessPanel.setLayout(null);
						addBusinessPanel.setVisible(true);
						addBusinessPanel.setBounds(30, 130, addBusinessPanelWidth, 75);
						addBusinessPanel.setBackground(Color.LIGHT_GRAY);
						addBusinessPanel.setBorder(border);
						
						addBusinessField = new JTextField();
						addBusinessField.setFont(font);
						addBusinessField.setVisible(true);
						addBusinessField.setForeground(Color.DARK_GRAY);
						addBusinessField.setBackground(Color.LIGHT_GRAY);
						addBusinessField.setBorder(BorderFactory.createLoweredBevelBorder());
						addBusinessField.setBounds(20, 30, (addBusinessPanelWidth/2)-30, 24);
						addBusinessField.setFocusable(true);
						addBusinessField.setDocument(new JTextFieldLimit(60));
						
						addBusinessButton = new JButton("Add Business");
						addBusinessButton.setForeground(Color.LIGHT_GRAY);
						addBusinessButton.setBackground(Color.DARK_GRAY);
						addBusinessButton.setBounds((addBusinessPanelWidth/2)+10, 30, (addBusinessPanelWidth/2)-30, 24);
						addBusinessButton.setFocusable(true);
						addBusinessButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String businessString = addBusinessField.getText();
									
									if(businessString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`business_id`) FROM `business_field` WHERE `business_name`='" + businessString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered Business is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `business_field`(`business_name`) VALUES ('" + businessString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered Business is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addBusinessField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter business field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addBusinessPanel.add(addBusinessField);
						addBusinessPanel.add(addBusinessButton);
						
					
					// addServicePanel
						border = new TitledBorder(border,"Add Service",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addServicePanel = new JPanel();
						addServicePanel.setLayout(null);
						addServicePanel.setVisible(true);
						addServicePanel.setBounds((rootDetailsFieldsPanelWidth/2)+15, 130, addServicePanelWidth, 75);
						addServicePanel.setBackground(Color.LIGHT_GRAY);
						addServicePanel.setBorder(border);
						
						addServiceField = new JTextField();
						addServiceField.setFont(font);
						addServiceField.setVisible(true);
						addServiceField.setForeground(Color.DARK_GRAY);
						addServiceField.setBackground(Color.LIGHT_GRAY);
						addServiceField.setBorder(BorderFactory.createLoweredBevelBorder());
						addServiceField.setBounds(20, 30, (addServicePanelWidth/2)-30, 24);
						addServiceField.setFocusable(true);
						addServiceField.setDocument(new JTextFieldLimit(60));
						
						addServiceButton = new JButton("Add Service");
						addServiceButton.setForeground(Color.LIGHT_GRAY);
						addServiceButton.setBackground(Color.DARK_GRAY);
						addServiceButton.setBounds((addServicePanelWidth/2)+10, 30, (addServicePanelWidth/2)-30, 24);
						addServiceButton.setFocusable(true);
						addServiceButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String serviceString = addServiceField.getText();
									
									if(serviceString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`service_id`) FROM `service_field` WHERE `service_name`='" + serviceString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered Service is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `service_field`(`service_name`) VALUES ('" + serviceString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered Service is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addServiceField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter service field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addServicePanel.add(addServiceField);
						addServicePanel.add(addServiceButton);
						
						
					// addKulPanel
						border = new TitledBorder(border,"Add Kul",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addKulPanel = new JPanel();
						addKulPanel.setLayout(null);
						addKulPanel.setVisible(true);
						addKulPanel.setBounds(30, 235, addKulPanelWidth, 75);
						addKulPanel.setBackground(Color.LIGHT_GRAY);
						addKulPanel.setBorder(border);
						
						addKulField = new JTextField();
						addKulField.setFont(font);
						addKulField.setVisible(true);
						addKulField.setForeground(Color.DARK_GRAY);
						addKulField.setBackground(Color.LIGHT_GRAY);
						addKulField.setBorder(BorderFactory.createLoweredBevelBorder());
						addKulField.setBounds(20, 30, (addKulPanelWidth/2)-30, 24);
						addKulField.setFocusable(true);
						addKulField.setDocument(new JTextFieldLimit(60));
						
						addKulButton = new JButton("Add Kul");
						addKulButton.setForeground(Color.LIGHT_GRAY);
						addKulButton.setBackground(Color.DARK_GRAY);
						addKulButton.setBounds((addKulPanelWidth/2)+10, 30, (addKulPanelWidth/2)-30, 24);
						addKulButton.setFocusable(true);
						addKulButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String kulString = addKulField.getText();
									
									if(kulString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`kul_id`) FROM `kul_field` WHERE `kul_name`='" + kulString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered Kul is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `kul_field`(`kul_name`) VALUES ('" + kulString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered Kul is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addKulField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter kul field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addKulPanel.add(addKulField);
						addKulPanel.add(addKulButton);
						
					
					// addMoshalSurnamePanel
						border = new TitledBorder(border,"Add Moshal's Surname",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addMoshalSurnamePanel = new JPanel();
						addMoshalSurnamePanel.setLayout(null);
						addMoshalSurnamePanel.setVisible(true);
						addMoshalSurnamePanel.setBounds((rootDetailsFieldsPanelWidth/2)+15, 235, addMoshalSurnamePanelWidth, 75);
						addMoshalSurnamePanel.setBackground(Color.LIGHT_GRAY);
						addMoshalSurnamePanel.setBorder(border);
						
						addMoshalSurnameField = new JTextField();
						addMoshalSurnameField.setFont(font);
						addMoshalSurnameField.setVisible(true);
						addMoshalSurnameField.setForeground(Color.DARK_GRAY);
						addMoshalSurnameField.setBackground(Color.LIGHT_GRAY);
						addMoshalSurnameField.setBorder(BorderFactory.createLoweredBevelBorder());
						addMoshalSurnameField.setBounds(20, 30, (addMoshalSurnamePanelWidth/2)-30, 24);
						addMoshalSurnameField.setFocusable(true);
						addMoshalSurnameField.setDocument(new JTextFieldLimit(60));
						
						addMoshalSurnameButton = new JButton("Add MoshalSurname");
						addMoshalSurnameButton.setForeground(Color.LIGHT_GRAY);
						addMoshalSurnameButton.setBackground(Color.DARK_GRAY);
						addMoshalSurnameButton.setBounds((addMoshalSurnamePanelWidth/2)+10, 30, (addMoshalSurnamePanelWidth/2)-30, 24);
						addMoshalSurnameButton.setFocusable(true);
						addMoshalSurnameButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String moshalSurnameString = addMoshalSurnameField.getText();
									
									if(moshalSurnameString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`moshal_surname_id`) FROM `moshal_surname_field` WHERE `moshal_surname_name`='" + moshalSurnameString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered MoshalSurname is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `moshal_surname_field`(`moshal_surname_name`) VALUES ('" + moshalSurnameString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered MoshalSurname is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addMoshalSurnameField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter moshal surname field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addMoshalSurnamePanel.add(addMoshalSurnameField);
						addMoshalSurnamePanel.add(addMoshalSurnameButton);
						
					
					// addTalGolPanel
						border = new TitledBorder(border,"Add TalGol",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addTalGolPanel = new JPanel();
						addTalGolPanel.setLayout(null);
						addTalGolPanel.setVisible(true);
						addTalGolPanel.setBounds(30, 340, addTalGolPanelWidth, 75);
						addTalGolPanel.setBackground(Color.LIGHT_GRAY);
						addTalGolPanel.setBorder(border);
						
						addTalGolField = new JTextField();
						addTalGolField.setFont(font);
						addTalGolField.setVisible(true);
						addTalGolField.setForeground(Color.DARK_GRAY);
						addTalGolField.setBackground(Color.LIGHT_GRAY);
						addTalGolField.setBorder(BorderFactory.createLoweredBevelBorder());
						addTalGolField.setBounds(20, 30, (addTalGolPanelWidth/2)-30, 24);
						addTalGolField.setFocusable(true);
						addTalGolField.setDocument(new JTextFieldLimit(60));
						
						addTalGolButton = new JButton("Add TalGol");
						addTalGolButton.setForeground(Color.LIGHT_GRAY);
						addTalGolButton.setBackground(Color.DARK_GRAY);
						addTalGolButton.setBounds((addTalGolPanelWidth/2)+10, 30, (addTalGolPanelWidth/2)-30, 24);
						addTalGolButton.setFocusable(true);
						addTalGolButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String talGolString = addTalGolField.getText();
									
									if(talGolString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`tal_gol_id`) FROM `tal_gol_field` WHERE `tal_gol_name`='" + talGolString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered TalGol is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `tal_gol_field`(`tal_gol_name`) VALUES ('" + talGolString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered TalGol is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addTalGolField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter tal gol field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addTalGolPanel.add(addTalGolField);
						addTalGolPanel.add(addTalGolButton);
						
					rootDetailsFieldsPanel.add(addGotraPanel);
					rootDetailsFieldsPanel.add(addKulDeviPanel);
					rootDetailsFieldsPanel.add(addBusinessPanel);
					rootDetailsFieldsPanel.add(addServicePanel);
					rootDetailsFieldsPanel.add(addKulPanel);
					rootDetailsFieldsPanel.add(addMoshalSurnamePanel);
					rootDetailsFieldsPanel.add(addTalGolPanel);
					
					
				// familyDetailsFieldsPanel
					border = new TitledBorder(border,"Address Details Fields",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					familyDetailsFieldsPanel = new JPanel();
					familyDetailsFieldsPanel.setLayout(null);
					familyDetailsFieldsPanel.setVisible(true);
					familyDetailsFieldsPanel.setBounds(40, 1020, familyDetailsFieldsPanelWidth, 125);
					familyDetailsFieldsPanel.setBackground(Color.LIGHT_GRAY);
					familyDetailsFieldsPanel.setBorder(border);
					
					addFieldsPanel.add(familyDetailsFieldsPanel);
					
					// addRelationPanel
					border = new TitledBorder(border,"Add Relation",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					addRelationPanel = new JPanel();
					addRelationPanel.setLayout(null);
					addRelationPanel.setVisible(true);
					addRelationPanel.setBounds(30, 25, addRelationPanelWidth, 75);
					addRelationPanel.setBackground(Color.LIGHT_GRAY);
					addRelationPanel.setBorder(border);
					
					addRelationField = new JTextField();
					addRelationField.setFont(font);
					addRelationField.setVisible(true);
					addRelationField.setForeground(Color.DARK_GRAY);
					addRelationField.setBackground(Color.LIGHT_GRAY);
					addRelationField.setBorder(BorderFactory.createLoweredBevelBorder());
					addRelationField.setBounds(20, 30, (addRelationPanelWidth/2)-30, 24);
					addRelationField.setFocusable(true);
					addRelationField.setDocument(new JTextFieldLimit(60));
					
					addRelationButton = new JButton("Add Relation");
					addRelationButton.setForeground(Color.LIGHT_GRAY);
					addRelationButton.setBackground(Color.DARK_GRAY);
					addRelationButton.setBounds((addRelationPanelWidth/2)+10, 30, (addRelationPanelWidth/2)-30, 24);
					addRelationButton.setFocusable(true);
					addRelationButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							try
							{
								String relationString = addRelationField.getText();
								
								if(relationString.compareTo("")!=0)
								{
									Class.forName("com.mysql.jdbc.Driver");
									
									Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
									Statement stmt = con.createStatement();
									
									String sql;
									ResultSet rs;
									
									sql = "SELECT COUNT(`relation_id`) FROM `relation_field` WHERE `relation_name`='" + relationString + "'";
									rs = stmt.executeQuery(sql);
									rs.next();
									if(rs.getInt(1)!=0)
									{
										JOptionPane.showMessageDialog(null, "Entered Relation is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
									else
									{
										sql = "INSERT INTO `relation_field`(`relation_name`) VALUES ('" + relationString + "')";
										stmt.executeUpdate(sql);
										
										JOptionPane.showMessageDialog(null, "Entered Relation is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
										
										addRelationField.setText("");
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Please enter relation field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
								}
							}
							catch(Exception exc)
							{
								JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					});
					
					addRelationPanel.add(addRelationField);
					addRelationPanel.add(addRelationButton);
					
				familyDetailsFieldsPanel.add(addRelationPanel);
					
					
				
				// educationQualificationDetailsFieldsPanel
					border = new TitledBorder(border,"Education Qualification Details Fields",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
					border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
					
					educationQualificationDetailsFieldsPanel = new JPanel();
					educationQualificationDetailsFieldsPanel.setLayout(null);
					educationQualificationDetailsFieldsPanel.setVisible(true);
					educationQualificationDetailsFieldsPanel.setBounds(40, 1175, educationQualificationDetailsFieldsPanelWidth, 230);
					educationQualificationDetailsFieldsPanel.setBackground(Color.LIGHT_GRAY);
					educationQualificationDetailsFieldsPanel.setBorder(border);
					
					addFieldsPanel.add(educationQualificationDetailsFieldsPanel);
						
					// addQualificationPanel
						border = new TitledBorder(border,"Add Qualification",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addQualificationPanel = new JPanel();
						addQualificationPanel.setLayout(null);
						addQualificationPanel.setVisible(true);
						addQualificationPanel.setBounds(30, 25, addQualificationPanelWidth, 75);
						addQualificationPanel.setBackground(Color.LIGHT_GRAY);
						addQualificationPanel.setBorder(border);
						
						addQualificationField = new JTextField();
						addQualificationField.setFont(font);
						addQualificationField.setVisible(true);
						addQualificationField.setForeground(Color.DARK_GRAY);
						addQualificationField.setBackground(Color.LIGHT_GRAY);
						addQualificationField.setBorder(BorderFactory.createLoweredBevelBorder());
						addQualificationField.setBounds(20, 30, (addQualificationPanelWidth/2)-30, 24);
						addQualificationField.setFocusable(true);
						addQualificationField.setDocument(new JTextFieldLimit(60));
						
						addQualificationButton = new JButton("Add Qualification");
						addQualificationButton.setForeground(Color.LIGHT_GRAY);
						addQualificationButton.setBackground(Color.DARK_GRAY);
						addQualificationButton.setBounds((addQualificationPanelWidth/2)+10, 30, (addQualificationPanelWidth/2)-30, 24);
						addQualificationButton.setFocusable(true);
						addQualificationButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								try
								{
									String qualificationString = addQualificationField.getText();
									
									if(qualificationString.compareTo("")!=0)
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										String sql;
										ResultSet rs;
										
										sql = "SELECT COUNT(`qualification_id`) FROM `qualification_field` WHERE `qualification_name`='" + qualificationString + "'";
										rs = stmt.executeQuery(sql);
										rs.next();
										if(rs.getInt(1)!=0)
										{
											JOptionPane.showMessageDialog(null, "Entered Qualification is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
										else
										{
											sql = "INSERT INTO `qualification_field`(`qualification_name`) VALUES ('" + qualificationString + "')";
											stmt.executeUpdate(sql);
											
											JOptionPane.showMessageDialog(null, "Entered Qualification is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
											
											addQualificationField.setText("");
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Please enter qualification field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									}
								}
								catch(Exception exc)
								{
									JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						
						addQualificationPanel.add(addQualificationField);
						addQualificationPanel.add(addQualificationButton);
						
						
					// addStreamPanel
						border = new TitledBorder(border,"Add Stream",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addStreamPanel = new JPanel();
						addStreamPanel.setLayout(null);
						addStreamPanel.setVisible(true);
						addStreamPanel.setBounds((addressDetailsFieldsPanelWidth/2)+15, 25, addStreamPanelWidth, 75);
						addStreamPanel.setBackground(Color.LIGHT_GRAY);
						addStreamPanel.setBorder(border);
						
						streamSelectQualificationField = new JComboBox();
						streamSelectQualificationField.setFont(font);
						streamSelectQualificationField.setForeground(Color.DARK_GRAY);
						streamSelectQualificationField.setBackground(Color.LIGHT_GRAY);
						streamSelectQualificationField.setBorder(BorderFactory.createLoweredBevelBorder());
						streamSelectQualificationField.setBounds(20, 30, (addStreamPanelWidth/3)-30, 24);
						streamSelectQualificationField.setFocusable(true);
						streamSelectQualificationField.addItem("--Select Qualification--");
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
							Statement stmt = con.createStatement();
							
							String sql = "SELECT `qualification_name` FROM `qualification_field`";
							ResultSet rs = stmt.executeQuery(sql);
							
							while(rs.next())
								streamSelectQualificationField.addItem(rs.getString(1));
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						addStreamField = new JTextField();
						addStreamField.setFont(font);
						addStreamField.setVisible(true);
						addStreamField.setForeground(Color.DARK_GRAY);
						addStreamField.setBackground(Color.LIGHT_GRAY);
						addStreamField.setBorder(BorderFactory.createLoweredBevelBorder());
						addStreamField.setBounds((addStreamPanelWidth/3)+10, 30, (addStreamPanelWidth/3)-20, 24);
						addStreamField.setFocusable(true);
						addStreamField.setDocument(new JTextFieldLimit(60));
						
						addStreamButton = new JButton("Add Stream");
						addStreamButton.setForeground(Color.LIGHT_GRAY);
						addStreamButton.setBackground(Color.DARK_GRAY);
						addStreamButton.setBounds((2 * addStreamPanelWidth/3)+10, 30, (addStreamPanelWidth/3)-30, 24);
						addStreamButton.setFocusable(true);
						addStreamButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								if(streamSelectQualificationField.getSelectedIndex()!=0)
								{
									try
									{
										String streamString = addStreamField.getText();
										
										if(streamString.compareTo("")!=0)
										{
											Class.forName("com.mysql.jdbc.Driver");
											
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
											Statement stmt = con.createStatement();
											
											String sql;
											ResultSet rs;
											
											sql = "SELECT COUNT(`stream_id`) FROM `stream_field` WHERE `stream_name`='" + streamString + "'";
											rs = stmt.executeQuery(sql);
											rs.next();
											if(rs.getInt(1)!=0)
											{
												JOptionPane.showMessageDialog(null, "Entered Stream is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
											}
											else
											{
												sql = "INSERT INTO `stream_field`(`stream_name`) VALUES ('" + streamString + "')";
												stmt.executeUpdate(sql);
												
												ResultSet rs1;
												
												sql = "SELECT `qualification_id` FROM `qualification_field` WHERE `qualification_name`='" + (String)streamSelectQualificationField.getSelectedItem() + "'";
												rs1 = stmt.executeQuery(sql);
												rs1.next();
												String QualificationId = rs1.getString(1);
												
												sql = "SELECT `stream_id` FROM `stream_field` WHERE `stream_name`='" + streamString + "'";
												rs1 = stmt.executeQuery(sql);
												rs1.next();
												String stream_id = rs1.getString(1);
												
												sql = "INSERT INTO `qualification_stream`(`qualification_id`, `stream_id`) VALUES ('" + QualificationId + "','" + stream_id + "')";
												stmt.executeUpdate(sql);
												
												JOptionPane.showMessageDialog(null, "Entered Stream is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
												
												addStreamField.setText("");
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Please enter stream field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Please select the qualification first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
								}
							}
						});
						
						addStreamPanel.add(addStreamField);
						addStreamPanel.add(streamSelectQualificationField);
						addStreamPanel.add(addStreamButton);
						
						
					// addDegreePanel
						border = new TitledBorder(border,"Add Degree",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Cambria", Font.PLAIN, 16),Color.DARK_GRAY);
						border.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						border.setTitleFont(new Font("Cambria", Font.BOLD, 15));
						
						addDegreePanel = new JPanel();
						addDegreePanel.setLayout(null);
						addDegreePanel.setVisible(true);
						addDegreePanel.setBounds(30, 130, addDegreePanelWidth, 75);
						addDegreePanel.setBackground(Color.LIGHT_GRAY);
						addDegreePanel.setBorder(border);
						
						degreeSelectQualificationField = new JComboBox();
						degreeSelectQualificationField.setFont(font);
						degreeSelectQualificationField.setForeground(Color.DARK_GRAY);
						degreeSelectQualificationField.setBackground(Color.LIGHT_GRAY);
						degreeSelectQualificationField.setBorder(BorderFactory.createLoweredBevelBorder());
						degreeSelectQualificationField.setBounds(20, 30, (addDegreePanelWidth/4)-30, 24);
						degreeSelectQualificationField.setFocusable(true);
						degreeSelectQualificationField.addItem("--Select Qualification--");
						degreeSelectQualificationField.addItemListener(new ItemListener()
						{
							public void itemStateChanged(ItemEvent e)
							{
								degreeSelectStreamField.removeAllItems();
								
								degreeSelectStreamField.addItem("--Select Stream--");
								
								if(degreeSelectQualificationField.getSelectedIndex()!=0)
								{
									try
									{
										Class.forName("com.mysql.jdbc.Driver");
										
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt = con.createStatement();
										
										Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
										Statement stmt1 = con1.createStatement();
	
										String sql1;
										ResultSet rs1;
										
										sql1 = "SELECT `qualification_id` FROM `qualification_field` WHERE `qualification_name`='" + (String)degreeSelectQualificationField.getSelectedItem() + "'";
										rs1 = stmt.executeQuery(sql1);
										rs1.next();
										System.out.println("qualification id : " + rs1.getString(1));
										String QualificationId = rs1.getString(1);
										
										sql1 = "SELECT `stream_id` FROM `qualification_stream` WHERE `qualification_id`='" + QualificationId + "'";
										rs1 = stmt.executeQuery(sql1);
										
										while(rs1.next())
										{
											String sql2;
											ResultSet rs2;
											
											sql2 = "SELECT `stream_name` FROM `stream_field` WHERE `stream_id`='" + rs1.getString(1) + "'";
											rs2 = stmt1.executeQuery(sql2);
											rs2.next();
											
											degreeSelectStreamField.addItem(rs2.getString(1));
										}
										
										degreeSelectStreamField.setEnabled(true);
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						});
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
							Statement stmt = con.createStatement();
							
							String sql;
							ResultSet rs;
							
							sql = "SELECT `qualification_name` FROM `qualification_field`";
							rs = stmt.executeQuery(sql);
							
							while(rs.next())
								degreeSelectQualificationField.addItem(rs.getString(1));
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						degreeSelectStreamField = new JComboBox();
						degreeSelectStreamField.setFont(font);
						degreeSelectStreamField.setForeground(Color.DARK_GRAY);
						degreeSelectStreamField.setBackground(Color.LIGHT_GRAY);
						degreeSelectStreamField.setBorder(BorderFactory.createLoweredBevelBorder());
						degreeSelectStreamField.setBounds((addDegreePanelWidth/4)+10, 30, (addDegreePanelWidth/4)-20, 24);
						degreeSelectStreamField.setFocusable(true);
						degreeSelectStreamField.addItem("--Select Stream--");
						
						addDegreeField = new JTextField();
						addDegreeField.setFont(font);
						addDegreeField.setVisible(true);
						addDegreeField.setForeground(Color.DARK_GRAY);
						addDegreeField.setBackground(Color.LIGHT_GRAY);
						addDegreeField.setBorder(BorderFactory.createLoweredBevelBorder());
						addDegreeField.setBounds((2 * addDegreePanelWidth/4)+10, 30, (addDegreePanelWidth/4)-20, 24);
						addDegreeField.setFocusable(true);
						addDegreeField.setDocument(new JTextFieldLimit(60));
						
						addDegreeButton = new JButton("Add Degree");
						addDegreeButton.setForeground(Color.LIGHT_GRAY);
						addDegreeButton.setBackground(Color.DARK_GRAY);
						addDegreeButton.setBounds((3 * addDegreePanelWidth/4)+10, 30, (addDegreePanelWidth/4)-30, 24);
						addDegreeButton.setFocusable(true);
						addDegreeButton.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								if(degreeSelectQualificationField.getSelectedIndex()!=0 && degreeSelectStreamField.getSelectedIndex()!=0)
								{
									try
									{
										String degreeString = addDegreeField.getText();
										
										if(degreeString.compareTo("")!=0)
										{
											Class.forName("com.mysql.jdbc.Driver");
											
											Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
											Statement stmt = con.createStatement();
											
											String sql;
											ResultSet rs;
											
											sql = "SELECT COUNT(`degree_id`) FROM `degree_field` WHERE `degree_name`='" + degreeString + "'";
											rs = stmt.executeQuery(sql);
											rs.next();
											if(rs.getInt(1)!=0)
											{
												JOptionPane.showMessageDialog(null, "Entered Degree is already defined", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
											}
											else
											{
												ResultSet rs1;
												
												sql = "SELECT `qualification_id` FROM `qualification_field` WHERE `qualification_name`='" + (String)degreeSelectQualificationField.getSelectedItem() + "'";
												rs1 = stmt.executeQuery(sql);
												rs1.next();
												String QualificationId = rs1.getString(1);
												
												sql = "SELECT `stream_id` FROM `stream_field` WHERE `stream_name`='" + (String)degreeSelectStreamField.getSelectedItem() + "'";
												rs1 = stmt.executeQuery(sql);
												rs1.next();
												String StreamId = rs1.getString(1);
												
												sql = "INSERT INTO `degree_field`(`qualification_id`,`stream_id`,`degree_name`) VALUES ('" + QualificationId + "','" + StreamId + "','" + degreeString + "')";
												stmt.executeUpdate(sql);
												
												JOptionPane.showMessageDialog(null, "Entered Degree is successfully updated", "Successful", JOptionPane.PLAIN_MESSAGE, new ImageIcon("Successful.png"));
												
												addDegreeField.setText("");
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Please enter degree field first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
										}
									}
									catch(Exception exc)
									{
										JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								else
								{
									if(degreeSelectQualificationField.getSelectedIndex()==0)
										JOptionPane.showMessageDialog(null, "Please select the qualification first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
									else if(degreeSelectStreamField.getSelectedIndex()==0)
										JOptionPane.showMessageDialog(null, "Please select the stream first", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("Error.png"));
								}
							}
						});
						
						addDegreePanel.add(degreeSelectQualificationField);
						addDegreePanel.add(degreeSelectStreamField);
						addDegreePanel.add(addDegreeField);
						addDegreePanel.add(addDegreeButton);
						
					educationQualificationDetailsFieldsPanel.add(addQualificationPanel);
					educationQualificationDetailsFieldsPanel.add(addStreamPanel);
					educationQualificationDetailsFieldsPanel.add(addDegreePanel);
					
					
		int TabPanelWidth = 150;
		int TabPanelHeight = 50;
		
		
	// AddMemberTabPanel
		addMemberTabPanel = new JPanel();
		addMemberTabPanel.setVisible(true);
		addMemberTabPanel.setLayout(null);
		addMemberTabPanel.setBackground(Color.DARK_GRAY);
		addMemberTabPanel.setBounds(10, 10, TabPanelWidth, TabPanelHeight);
		adminPanel.add(addMemberTabPanel);
		
		addMemberTabLabel = new JLabel("Add Member", SwingConstants.CENTER);
		addMemberTabLabel.setFont(new Font("Constantia", Font.PLAIN, 15));
		addMemberTabLabel.setBounds((TabPanelWidth/2)-44, (TabPanelHeight/2)-10, 88, 20);
		addMemberTabLabel.setForeground(Color.LIGHT_GRAY);
		addMemberTabLabel.setFocusable(false);
		
		addMemberTabPanel.add(addMemberTabLabel);
		
		addMemberTabPanel.setBackground(Color.LIGHT_GRAY);
		addMemberTabLabel.setForeground(Color.DARK_GRAY);
		
		
	// sortMembersTabPanel
		sortMembersTabPanel = new JPanel();
		sortMembersTabPanel.setVisible(true);
		sortMembersTabPanel.setLayout(null);
		sortMembersTabPanel.setBackground(Color.DARK_GRAY);
		sortMembersTabPanel.setBounds(10, 60, TabPanelWidth, TabPanelHeight);
		adminPanel.add(sortMembersTabPanel);
		
		sortMembersTabLabel = new JLabel("Sort Members", SwingConstants.CENTER);
		sortMembersTabLabel.setFont(new Font("Constantia", Font.PLAIN, 15));
		sortMembersTabLabel.setBounds((TabPanelWidth/2)-50, (TabPanelHeight/2)-10, 100, 20);
		sortMembersTabLabel.setForeground(Color.LIGHT_GRAY);
		sortMembersTabLabel.setFocusable(false);
		
		sortMembersTabPanel.add(sortMembersTabLabel);
		
		
	// otherTabPanel2
		otherTabPanel2 = new JPanel();
		otherTabPanel2.setVisible(true);
		otherTabPanel2.setLayout(null);
		otherTabPanel2.setBackground(Color.DARK_GRAY);
		otherTabPanel2.setBounds(10, 110, TabPanelWidth, TabPanelHeight);
		adminPanel.add(otherTabPanel2);
		
		otherTabLabel2 = new JLabel("Other Tab 2");
		otherTabLabel2.setFont(new Font("Constantia", Font.PLAIN, 15));
		otherTabLabel2.setBounds((TabPanelWidth/2)-39, (TabPanelHeight/2)-10, 78, 20);
		otherTabLabel2.setForeground(Color.LIGHT_GRAY);
		otherTabLabel2.setFocusable(false);
		
		otherTabPanel2.add(otherTabLabel2);
		
		
	// otherTabPanel3
		otherTabPanel3 = new JPanel();
		otherTabPanel3.setVisible(true);
		otherTabPanel3.setLayout(null);
		otherTabPanel3.setBackground(Color.DARK_GRAY);
		otherTabPanel3.setBounds(10, 160, TabPanelWidth, TabPanelHeight);
		adminPanel.add(otherTabPanel3);
		
		otherTabLabel3 = new JLabel("Other Tab 3");

		otherTabLabel3.setFont(new Font("Constantia", Font.PLAIN, 15));
		otherTabLabel3.setBounds((TabPanelWidth/2)-39, (TabPanelHeight/2)-10, 78, 20);
		otherTabLabel3.setForeground(Color.LIGHT_GRAY);
		otherTabLabel3.setFocusable(false);
		
		otherTabPanel3.add(otherTabLabel3);
		

	// addFieldTabPanel
		addFieldTabPanel = new JPanel();
		addFieldTabPanel.setVisible(true);
		addFieldTabPanel.setLayout(null);
		addFieldTabPanel.setBackground(Color.DARK_GRAY);
		addFieldTabPanel.setBounds(10, 210, TabPanelWidth, TabPanelHeight);
		adminPanel.add(addFieldTabPanel);
		
		addFieldTabLabel = new JLabel("Add Fields");
		addFieldTabLabel.setFont(new Font("Constantia", Font.PLAIN, 15));
		addFieldTabLabel.setBounds((TabPanelWidth/2)-39, (TabPanelHeight/2)-10, 78, 20);
		addFieldTabLabel.setForeground(Color.LIGHT_GRAY);
		addFieldTabLabel.setFocusable(false);
		
		addFieldTabPanel.add(addFieldTabLabel);
		
		
	// settingsTabPanel
		settingsTabPanel = new JPanel();
		settingsTabPanel.setVisible(true);
		settingsTabPanel.setLayout(null);
		settingsTabPanel.setBackground(Color.DARK_GRAY);
		settingsTabPanel.setBounds(10, 260, TabPanelWidth, TabPanelHeight);
		adminPanel.add(settingsTabPanel);
		
		settingsTabLabel = new JLabel("Settings");
		settingsTabLabel.setFont(new Font("Constantia", Font.PLAIN, 15));
		settingsTabLabel.setBounds((TabPanelWidth/2)-39, (TabPanelHeight/2)-10, 78, 20);
		settingsTabLabel.setForeground(Color.LIGHT_GRAY);
		settingsTabLabel.setFocusable(false);
		
		settingsTabPanel.add(settingsTabLabel);
		
		
	// TabPanelEvents
		addMemberTabPanel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				addMemberTabPanel.setBackground(Color.LIGHT_GRAY);
				addMemberTabLabel.setForeground(Color.DARK_GRAY);
				sortMembersTabPanel.setBackground(Color.DARK_GRAY);
				sortMembersTabLabel.setForeground(Color.LIGHT_GRAY);
				otherTabPanel2.setBackground(Color.DARK_GRAY);
				otherTabLabel2.setForeground(Color.LIGHT_GRAY);
				otherTabPanel3.setBackground(Color.DARK_GRAY);
				otherTabLabel3.setForeground(Color.LIGHT_GRAY);
				settingsTabPanel.setBackground(Color.DARK_GRAY);
				settingsTabLabel.setForeground(Color.LIGHT_GRAY);
				addFieldTabPanel.setBackground(Color.DARK_GRAY);
				addFieldTabLabel.setForeground(Color.LIGHT_GRAY);
				mainPanelLabel.setText("ADD MEMBER");
				
				addMemberPanel.setVisible(true);
				addMemberPanelScrollPane.setVisible(true);
				addFieldsPanel.setVisible(false);
				addFieldsPanelScrollPane.setVisible(false);
				
				refreshFieldData("TabPanelChange");
			}
		});
		
		sortMembersTabPanel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				addMemberTabPanel.setBackground(Color.DARK_GRAY);
				addMemberTabLabel.setForeground(Color.LIGHT_GRAY);
				sortMembersTabPanel.setBackground(Color.LIGHT_GRAY);
				sortMembersTabLabel.setForeground(Color.DARK_GRAY);
				otherTabPanel2.setBackground(Color.DARK_GRAY);
				otherTabLabel2.setForeground(Color.LIGHT_GRAY);
				otherTabPanel3.setBackground(Color.DARK_GRAY);
				otherTabLabel3.setForeground(Color.LIGHT_GRAY);
				settingsTabPanel.setBackground(Color.DARK_GRAY);
				settingsTabLabel.setForeground(Color.LIGHT_GRAY);
				addFieldTabPanel.setBackground(Color.DARK_GRAY);
				addFieldTabLabel.setForeground(Color.LIGHT_GRAY);
				mainPanelLabel.setText("SORT MEMBERS");
				
				addMemberPanel.setVisible(false);
				addMemberPanelScrollPane.setVisible(false);
				addFieldsPanel.setVisible(false);
				addFieldsPanelScrollPane.setVisible(false);
			}
		});
		
		otherTabPanel2.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				addMemberTabPanel.setBackground(Color.DARK_GRAY);
				addMemberTabLabel.setForeground(Color.LIGHT_GRAY);
				sortMembersTabPanel.setBackground(Color.DARK_GRAY);
				sortMembersTabLabel.setForeground(Color.LIGHT_GRAY);
				otherTabPanel2.setBackground(Color.LIGHT_GRAY);
				otherTabLabel2.setForeground(Color.DARK_GRAY);
				otherTabPanel3.setBackground(Color.DARK_GRAY);
				otherTabLabel3.setForeground(Color.LIGHT_GRAY);
				settingsTabPanel.setBackground(Color.DARK_GRAY);
				settingsTabLabel.setForeground(Color.LIGHT_GRAY);
				addFieldTabPanel.setBackground(Color.DARK_GRAY);
				addFieldTabLabel.setForeground(Color.LIGHT_GRAY);
				mainPanelLabel.setText("OTHER TAB 2");
				
				addMemberPanel.setVisible(false);
				addMemberPanelScrollPane.setVisible(false);
				addFieldsPanel.setVisible(false);
				addFieldsPanelScrollPane.setVisible(false);
			}
		});

		otherTabPanel3.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				addMemberTabPanel.setBackground(Color.DARK_GRAY);
				addMemberTabLabel.setForeground(Color.LIGHT_GRAY);
				sortMembersTabPanel.setBackground(Color.DARK_GRAY);
				sortMembersTabLabel.setForeground(Color.LIGHT_GRAY);
				otherTabPanel2.setBackground(Color.DARK_GRAY);
				otherTabLabel2.setForeground(Color.LIGHT_GRAY);
				otherTabPanel3.setBackground(Color.LIGHT_GRAY);
				otherTabLabel3.setForeground(Color.DARK_GRAY);
				settingsTabPanel.setBackground(Color.DARK_GRAY);
				settingsTabLabel.setForeground(Color.LIGHT_GRAY);
				addFieldTabPanel.setBackground(Color.DARK_GRAY);
				addFieldTabLabel.setForeground(Color.LIGHT_GRAY);
				mainPanelLabel.setText("OTHER TAB 3");
				
				addMemberPanel.setVisible(false);
				addMemberPanelScrollPane.setVisible(false);
				addFieldsPanel.setVisible(false);
				addFieldsPanelScrollPane.setVisible(false);
			}
		});
		
		addFieldTabPanel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				addMemberTabPanel.setBackground(Color.DARK_GRAY);
				addMemberTabLabel.setForeground(Color.LIGHT_GRAY);
				sortMembersTabPanel.setBackground(Color.DARK_GRAY);
				sortMembersTabLabel.setForeground(Color.LIGHT_GRAY);
				otherTabPanel2.setBackground(Color.DARK_GRAY);
				otherTabLabel2.setForeground(Color.LIGHT_GRAY);
				otherTabPanel3.setBackground(Color.DARK_GRAY);
				otherTabLabel3.setForeground(Color.LIGHT_GRAY);
				settingsTabPanel.setBackground(Color.DARK_GRAY);
				settingsTabLabel.setForeground(Color.LIGHT_GRAY);
				addFieldTabPanel.setBackground(Color.LIGHT_GRAY);
				addFieldTabLabel.setForeground(Color.DARK_GRAY);
				mainPanelLabel.setText("ADD FIELDS");
				
				addMemberPanel.setVisible(false);
				addMemberPanelScrollPane.setVisible(false);
				addFieldsPanel.setVisible(true);
				addFieldsPanelScrollPane.setVisible(true);
			}
		});
		
		settingsTabPanel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				addMemberTabPanel.setBackground(Color.DARK_GRAY);
				addMemberTabLabel.setForeground(Color.LIGHT_GRAY);
				sortMembersTabPanel.setBackground(Color.DARK_GRAY);
				sortMembersTabLabel.setForeground(Color.LIGHT_GRAY);
				otherTabPanel2.setBackground(Color.DARK_GRAY);
				otherTabLabel2.setForeground(Color.LIGHT_GRAY);
				otherTabPanel3.setBackground(Color.DARK_GRAY);
				otherTabLabel3.setForeground(Color.LIGHT_GRAY);
				settingsTabPanel.setBackground(Color.LIGHT_GRAY);
				settingsTabLabel.setForeground(Color.DARK_GRAY);
				addFieldTabPanel.setBackground(Color.DARK_GRAY);
				addFieldTabLabel.setForeground(Color.LIGHT_GRAY);
				mainPanelLabel.setText("SETTINGS");
				
				addMemberPanel.setVisible(false);
				addMemberPanelScrollPane.setVisible(false);
				addFieldsPanel.setVisible(false);
				addFieldsPanelScrollPane.setVisible(false);
			}
		});

		
	// adminLoginPanel
		int adminLoginPanelWidth = 2 * (jframeWidth/6);
		int adminLoginPanelHeight = 4 * (jframeHeight/6);
		
		adminLoginPanel = new JPanel();
		jframe.getContentPane().add(adminLoginPanel);
		adminLoginPanel.setBounds((jframeWidth/2)-(2 * (jframeWidth/6))-20, (jframeHeight/2)-(2 * (jframeHeight/6))-20, adminLoginPanelWidth, adminLoginPanelHeight);
		adminLoginPanel.setBackground(Color.DARK_GRAY);
		adminLoginPanel.setForeground(Color.LIGHT_GRAY);
		adminLoginPanel.setLayout(null);
		adminLoginPanel.setVisible(false);		
	
		adminLoginPanelLabel = new JLabel("ADMIN", SwingConstants.CENTER);
		adminLoginPanelLabel.setBounds((adminLoginPanelWidth/2)-50, (adminLoginPanelHeight/2)-15, 100, 30);
		adminLoginPanelLabel.setFont(new Font("Cambria", Font.ITALIC, 30));
		adminLoginPanelLabel.setForeground(Color.LIGHT_GRAY);
		adminLoginPanelLabel.setFocusable(false);
		
		adminLoginPanel.add(adminLoginPanelLabel);
		
		adminLoginPanel.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {
				loginFrom = "ADMIN";
				LoginHeading.setText(loginFrom);
				adminLoginPanel.setVisible(false);
				memberLoginPanel.setVisible(false);
				LoginPanel.setVisible(true);
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				adminLoginPanel.setBackground(Color.LIGHT_GRAY);
				adminLoginPanelLabel.setForeground(Color.DARK_GRAY);
			}
			public void mouseExited(MouseEvent e) {
				adminLoginPanel.setBackground(Color.DARK_GRAY);
				adminLoginPanelLabel.setForeground(Color.LIGHT_GRAY);
			}
		});
		
	// memberLoginPanel
		int memberLoginPanelWidth = 2 * (jframeWidth/6);
		int memberLoginPanelHeight = 4 * (jframeHeight/6);
		
		memberLoginPanel = new JPanel();
		jframe.getContentPane().add(memberLoginPanel);
		memberLoginPanel.setBounds((jframeWidth/2)+20, (jframeHeight/2)-(2 * (jframeHeight/6))-20, memberLoginPanelWidth, memberLoginPanelHeight);
		memberLoginPanel.setBackground(Color.DARK_GRAY);
		memberLoginPanel.setForeground(Color.LIGHT_GRAY);
		memberLoginPanel.setLayout(null);
		memberLoginPanel.setVisible(false);
		
		memberLoginPanelLabel = new JLabel("MEMBER", SwingConstants.CENTER);
		memberLoginPanelLabel.setBounds((adminLoginPanelWidth/2)-60, (adminLoginPanelHeight/2)-15, 120, 30);
		memberLoginPanelLabel.setFont(new Font("Cambria", Font.ITALIC, 30));
		memberLoginPanelLabel.setForeground(Color.LIGHT_GRAY);
		memberLoginPanelLabel.setFocusable(false);
		
		memberLoginPanel.add(memberLoginPanelLabel);
		
		memberLoginPanel.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {
				loginFrom = "MEMBER";
				LoginHeading.setText(loginFrom);
				adminLoginPanel.setVisible(false);
				memberLoginPanel.setVisible(false);
				LoginPanel.setVisible(true);
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
				memberLoginPanel.setBackground(Color.LIGHT_GRAY);
				memberLoginPanelLabel.setForeground(Color.DARK_GRAY);
			}
			public void mouseExited(MouseEvent e) {
				memberLoginPanel.setBackground(Color.DARK_GRAY);
				memberLoginPanelLabel.setForeground(Color.LIGHT_GRAY);
			}
		});
		
	// loginPanel
		LoginPanel = new JPanel();
		jframe.getContentPane().add(LoginPanel);
		LoginPanel.setBounds((jframeWidth/2) - 250, (jframeHeight/2) - 170, 500, 340);
		LoginPanel.setLayout(null);
		LoginPanel.setVisible(false);
				
		LoginPanel.setBackground(Color.DARK_GRAY);
		
		Dimension loginSize = LoginPanel.getSize();
		final int loginWidth = (int)loginSize.getWidth();
		
		LoginHeading = new JLabel(loginFrom, SwingConstants.CENTER);
		LoginHeading.setFont(new Font("Cambria", Font.ITALIC, 30));
		LoginHeading.setBounds((loginWidth/2)-75,50,150,30);
		LoginHeading.setForeground(Color.LIGHT_GRAY);
		LoginHeading.setFocusable(false);
		
		usernameLabel = new JLabel("Username : ");
		usernameLabel.setForeground(Color.LIGHT_GRAY);
		usernameLabel.setBounds(100, 100, 100, 20);
		usernameLabel.setFocusable(false);
		
		usernameField = new RoundJTextField(50);
		usernameField.setBounds(100, 130, 300, 30);
		usernameField.setBackground(Color.LIGHT_GRAY);
		usernameField.setForeground(Color.DARK_GRAY);
		usernameField.setBorder(BorderFactory.createCompoundBorder(usernameField.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		usernameField.setFocusable(true);
		
		passwordLabel = new JLabel("Password : ");
		passwordLabel.setForeground(Color.LIGHT_GRAY);
		passwordLabel.setBounds(100, 170, 100, 20);
		passwordLabel.setFocusable(false);
		
		passwordField = new RoundJPasswordField(50);
		passwordField.setBounds(100, 200, 300, 30);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setForeground(Color.DARK_GRAY);
		passwordField.setBorder(BorderFactory.createCompoundBorder(passwordField.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		passwordField.setFocusable(true);

		loginButton = new JButton("LogIn");
		loginButton.setBounds((loginWidth/2)-150, 250, 300, 30);
		loginButton.setBackground(Color.GRAY);
		loginButton.setForeground(Color.DARK_GRAY);
		loginButton.setFocusable(true);
		loginButton.setFont(new Font("Arial", Font.PLAIN, 17));
		loginButton.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent arg0)
			{
				String username = usernameField.getText();
				String password = passwordField.getText();
				
				if(loginFrom == "ADMIN")
				{
					if((username.compareTo("admin")==0) && (password.compareTo("password")==0))
					{
						adminPanel.setVisible(true);
						LoginPanel.setVisible(false);
					}
					else
					{
						String[] options1 = {"OK"};
						JOptionPane.showOptionDialog(null, "Entered Username or Password is incorrect", null, JOptionPane.NO_OPTION, JOptionPane.OK_OPTION, new ImageIcon("Error.png"), options1, null);
					}
					usernameField.setText("");
					passwordField.setText("");
				}
				else if(loginFrom == "MEMBER")
				{
					if((username.compareTo("member")==0) && (password.compareTo("password")==0))
					{
						LoginPanel.setVisible(false);
					}
					else
					{
						String[] options1 = {"OK"};
						JOptionPane.showOptionDialog(null, "Entered Username or Password is incorrect", null, JOptionPane.NO_OPTION, JOptionPane.OK_OPTION, new ImageIcon("Error.png"), options1, null);
					}
					usernameField.setText("");
					passwordField.setText("");
				}
			}
			public void mouseEntered(MouseEvent arg0) {
				loginButton.setBackground(Color.LIGHT_GRAY);
			}
			public void mouseExited(MouseEvent arg0) {
				loginButton.setBackground(Color.GRAY);
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		});

		LoginPanel.add(LoginHeading);
		LoginPanel.add(usernameLabel);
		LoginPanel.add(usernameField);
		LoginPanel.add(passwordLabel);
		LoginPanel.add(passwordField);
		LoginPanel.add(loginButton);
		
	// HomePanel
		homePanel = new JPanel();
		jframe.getContentPane().add(homePanel);
		homePanel.setBackground(Color.DARK_GRAY);
		homePanel.setLayout(null);
		homePanel.setVisible(false);  // TODO true
		homePanel.setBounds(0, 0, jframeWidth, jframeHeight);

		AZBSLabel = new JLabel("AUDICHYA ZALAWADI BRAHM SAMAJ - RAJKOT");
		AZBSLabel.setForeground(Color.WHITE);
		AZBSLabel.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 30));
		AZBSLabel.setBounds((jframeWidth/2)-345, (jframeHeight/2)-15, 690, 30);
		AZBSLabel.setFocusable(false);
//		Map attributes = AZBSLabel.getFont().getAttributes();
//		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//		AZBSLabel.setFont(AZBSLabel.getFont().deriveFont(attributes));

		officeAddressHeadingLabel = new JLabel("OFFICE ADDRESS : ");
		officeAddressHeadingLabel.setForeground(Color.LIGHT_GRAY);
		officeAddressHeadingLabel.setFont(new Font("Cambria", Font.BOLD, 17));
		officeAddressHeadingLabel.setBounds(jframeWidth-600, jframeHeight-150, 200, 30);
		officeAddressHeadingLabel.setFocusable(false);
		
		officeAttentdentLabel = new JLabel("RAJESHBHAI P. JOSHI");
		officeAttentdentLabel.setForeground(Color.LIGHT_GRAY);
		officeAttentdentLabel.setFont(new Font("Cambria", Font.BOLD, 17));
		officeAttentdentLabel.setBounds(jframeWidth-600, jframeHeight-120, 250, 30);
		officeAttentdentLabel.setFocusable(false);
		
		officeAddressLabel = new JLabel("Amrut Menor, Block No. A-101, Jagnath Plot 14/3, Near Gymkhana, Rajkot");
		officeAddressLabel.setForeground(Color.LIGHT_GRAY);
		officeAddressLabel.setFont(new Font("Cambria", Font.PLAIN, 17));
		officeAddressLabel.setBounds(jframeWidth-600, jframeHeight-90, 550, 30);
		officeAddressLabel.setFocusable(false);
		
		homePanel.add(AZBSLabel);
		homePanel.add(officeAddressHeadingLabel);
		homePanel.add(officeAttentdentLabel);
		homePanel.add(officeAddressLabel);
		homePanel.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				adminLoginPanel.setVisible(true);
				memberLoginPanel.setVisible(true);
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		}); 
		
		jframe.setVisible(true);
	}

	public static void main(String args[])
	{
		System.out.println("I'm Started");
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new AZBS();
			}
		});
	}
	
	void setEnableOnFormNumber(boolean state)
	{
		receiptNumberLabel.setEnabled(state);
		receiptNumberField.setEnabled(state);
		referencebyLabel.setEnabled(state);
		referencebyField.setEnabled(state);
		donationLabel.setEnabled(state);
		donationField.setEnabled(state);
		
		Component[] c = mainPersonDetailsPanel.getComponents();
		for(int i=0 ; i<c.length ; i++)
			c[i].setEnabled(state);
		
		c = currentAddressPanel.getComponents();
		for(int i=0 ; i<c.length ; i++)
			c[i].setEnabled(state);
		
		c = contactDetailsPanel.getComponents();
		for(int i=0 ; i<c.length ; i++)
			c[i].setEnabled(state);
		
		c = rootDetailsPanel.getComponents();
		for(int i=0 ; i<c.length ; i++)
			c[i].setEnabled(state);
		
		c =	familyDetailsPanel.getComponents();
		for(int i=0 ; i<c.length ; i++)
			c[i].setEnabled(state);
		
		c = otherDetailsPanel.getComponents();
		for(int i=0 ; i<c.length ; i++)
			c[i].setEnabled(state);
		
		submitFormButton.setEnabled(state);
		resetFormButton.setEnabled(state);
	//	resetFormWithFormNumberButton.setEnabled(state);
		
		if(businessRadioButton.isSelected())
			businessField.setEnabled(true);
		else
			businessField.setEnabled(false);
		
		if(serviceRadioButton.isSelected())
			serviceField.setEnabled(true);
		else
			serviceField.setEnabled(false);
	}
	
	void resetForm(int numberOfFamilyMembers)
	{
		receiptNumberField.setText("");
		donationField.setText("");
		referencebyField.setSelectedIndex(0);
		mainPersonSurnameField.setSelectedIndex(0);
		mainPersonNameField.setText("");
		mainPersonFatherNameField.setText("");
		currentAddressLine1Field.setText("");
		currentAddressLine2Field.setText("");
//		currentCityField.setSelectedIndex(1);
//		currentDistrictField.setSelectedIndex(1);
//		currentStateField.setSelectedIndex(1);
		currentCountryField.setSelectedIndex(1);
		phoneNumberField.setText("");
		mobileNumberField.setText("");
		emailField.setText("");
//		rootCityField.setSelectedIndex(1);
//		rootDistrictField.setSelectedIndex(1);
//		rootStateField.setSelectedIndex(1);
		rootCountryField.setSelectedIndex(1);
		rootGotraField.setSelectedIndex(0);
		rootKulDeviField.setSelectedIndex(0);
		occupationButtonGroup.clearSelection();
		businessField.setSelectedIndex(0);
		serviceField.setSelectedIndex(0);
		rootKulField.setSelectedIndex(0);
		rootMoshalSurnameField.setSelectedIndex(0);
		rootTalGolField.setSelectedIndex(0);
		rootExpertiseOrAwardsField.setText("");
		
		resetFamilyPanel(numberOfFamilyMembers);
		
		numberOfFamilyMembersField.setSelectedIndex(0);
		livingInJointFamilyGroup.clearSelection();
		haveOwnHouseGroup.clearSelection();
		intrestedInSocialActivityGroup.clearSelection();

		receiptNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
		donationField.setBorder(BorderFactory.createLoweredBevelBorder());
		referencebyField.setBorder(BorderFactory.createLoweredBevelBorder());
		mainPersonSurnameField.setBorder(BorderFactory.createLoweredBevelBorder());
		mainPersonNameField.setBorder(BorderFactory.createLoweredBevelBorder());
		mainPersonFatherNameField.setBorder(BorderFactory.createLoweredBevelBorder());
		currentAddressLine1Field.setBorder(BorderFactory.createLoweredBevelBorder());
		currentCityField.setBorder(BorderFactory.createLoweredBevelBorder());
		currentDistrictField.setBorder(BorderFactory.createLoweredBevelBorder());
		currentStateField.setBorder(BorderFactory.createLoweredBevelBorder());
		currentCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
		mobileNumberField.setBorder(BorderFactory.createLoweredBevelBorder());
		rootCityField.setBorder(BorderFactory.createLoweredBevelBorder());
		rootDistrictField.setBorder(BorderFactory.createLoweredBevelBorder());
		rootStateField.setBorder(BorderFactory.createLoweredBevelBorder());
		rootCountryField.setBorder(BorderFactory.createLoweredBevelBorder());
		rootGotraField.setBorder(BorderFactory.createLoweredBevelBorder());
		rootKulDeviField.setBorder(BorderFactory.createLoweredBevelBorder());
		occupationButtonGroup.clearSelection();
		occupationLabel.setForeground(Color.DARK_GRAY);
		businessRadioButton.setForeground(Color.DARK_GRAY);
		serviceRadioButton.setForeground(Color.DARK_GRAY);
		businessField.setForeground(Color.DARK_GRAY);
		serviceField.setForeground(Color.DARK_GRAY);
		numberOfFamilyMembersField.setBorder(BorderFactory.createLoweredBevelBorder());
		livingInJointFamilyLabel.setForeground(Color.DARK_GRAY);
		livingInJointFamilyYesRadioButton.setForeground(Color.DARK_GRAY);
		livingInJointFamilyNoRadioButton.setForeground(Color.DARK_GRAY);
		haveOwnHouseLabel.setForeground(Color.DARK_GRAY);
		haveOwnHouseYesRadioButton.setForeground(Color.DARK_GRAY);
		haveOwnHouseNoRadioButton.setForeground(Color.DARK_GRAY);
		intrestedInSocialActivityLabel.setForeground(Color.DARK_GRAY);
		intrestedInSocialActivityYesRadioButton.setForeground(Color.DARK_GRAY);
		intrestedInSocialActivityNoRadioButton.setForeground(Color.DARK_GRAY);
	}
	
	void resetFormWithFormNumber(int numberOfFamilyMembers)
	{//TODO
		resetForm(numberOfFamilyMembers);
		resetFamilyPanel(numberOfFamilyMembers);
		numberOfFamilyMembersField.setSelectedIndex(0);
		setEnableOnFormNumber(false);
		formNumberField.setEnabled(true);
		formNumberField.setText("");
	}
	
	void resetFamilyPanel(int numberOfFamilyMembers)
	{
		numberOfFamilyMembersLabel.setVisible(true);
		numberOfFamilyMembersField.setVisible(true);
		addFamilyMembers.setVisible(true);
		
		familyDetailsPanel.setBounds(40, 645, familyDetailsPanelWidth, 75);
		addMemberPanel.setPreferredSize(new Dimension(mainFooterPanelWidth-20, 895));
		addMemberPanelScrollPane.repaint();
		otherDetailsPanel.setBounds(40, 750, otherDetailsPanelWidth, otherDetailsPanelHeight);
		otherDetailsPanel.repaint();
		submitFormButton.setBounds(mainFooterPanelWidth-380, 845, 150, 24);
		resetFormButton.setBounds(mainFooterPanelWidth-200, 845, 150, 24);
		resetFormWithFormNumberButton.setBounds(mainFooterPanelWidth-380-180-50, 845, 200, 24);
		referencebyLabel.setBounds(50, 845, 110, 24);
		referencebyField.setBounds(165, 845, (mainFooterPanelWidth/6), 24);
		
		if(!(numberOfFamilyMembers==-1))
		{
			resetFamilyPanelButton.setVisible(false);
			familyMemberMainPersonNoticeLabel.setVisible(false);
			
			for(int i=0 ; i<numberOfFamilyMembers ; i++)
			{
				familyMemberPanel[i].setVisible(false);
				familyMemberPanel[i].setBounds(20, (i * 250)+30, familyDetailsPanelWidth-40, 250);
				
				familyMemberSurnameField[i].setSelectedIndex(0);
				familyMemberNameField[i].setText(null);
				familyMemberFatherNameField[i].setText(null);
				familyMemberRelationField[i].setSelectedIndex(0);
//				familyMemberBirthDateField[i].setDate(null);
				familyMemberGenderGroup[i].clearSelection();
				familyMemberMaritualStatusGroup[i].clearSelection();
				for(int j=0 ; j<8 ; j++)
				{
					familyMemberQualificationField[i][j].setSelectedIndex(0);
//					familyMemberStreamField[i][j].setSelectedIndex(0);
//					familyMemberDegreeField[i][j].setSelectedIndex(0);
					
//					familyMemberQualificationField[i][j].setSelectedIndex(-1);
//					familyMemberQualificationField[i][j].removeAllItems();
//					familyMemberStreamField[i][j].setSelectedIndex(-1);
//					familyMemberStreamField[i][j].removeAllItems();
//					familyMemberDegreeField[i][j].setSelectedIndex(-1);
//					familyMemberDegreeField[i][j].removeAllItems();
				}
				whatsappNumberField[i].setText(null);
				
		/*		familyMemberNumber[i].setVisible(false);
				familyMemberSurnameLabel[i].setVisible(false);
				familyMemberSurnameField[i].setVisible(false);
				familyMemberNameLabel[i].setVisible(false);
				familyMemberNameField[i].setVisible(false);
				familyMemberFatherNameLabel[i].setVisible(false);
				familyMemberFatherNameField[i].setVisible(false);
				familyMemberRelationLabel[i].setVisible(false);
				familyMemberRelationField[i].setVisible(false);
				familyMemberBirthDateLabel[i].setVisible(false);
				familyMemberBirthDateField[i].setVisible(false);  */
				
				int firstRowY = 0;
				int secondRowY = 0;
				int thirdRowY = 0;
				int fourthRowY = 0;
				int fifthRowY = 0;
				int sixthRowY = 0;
				
//				if(i == 0)
//				{
					firstRowY = 10;
					secondRowY = 40;
					thirdRowY = 70;
					fourthRowY = 100;
					fifthRowY = 180;
					sixthRowY = 210;
//				}
//				else
//				{
//					firstRowY = (i*250) + 30;
//					secondRowY = (i*250) + 60;
//					thirdRowY = (i*250) + 90;
//					fourthRowY = (i*250) + 120;
//					fifthRowY = (i*250) + 200;
//					sixthRowY = (i*250) + 230;
//				}
	
				familyMemberNumber[i].setBounds(10, firstRowY, 120, 20);
				familyMemberSurnameLabel[i].setBounds((familyDetailsPanelWidth/6)-87-20, secondRowY, 82, 20);
				familyMemberSurnameField[i].setBounds((familyDetailsPanelWidth/6)-20, secondRowY, (familyDetailsPanelWidth/6)-30, 24);
				familyMemberNameLabel[i].setBounds((3 * (familyDetailsPanelWidth/6))-66-20, secondRowY, 61, 20);
				familyMemberNameField[i].setBounds((3 * (familyDetailsPanelWidth/6))-20, secondRowY, (familyDetailsPanelWidth/6)-30, 24);
				familyMemberFatherNameLabel[i].setBounds((5 * (familyDetailsPanelWidth/6))-128 - 20, secondRowY, 123, 20);
				familyMemberFatherNameField[i].setBounds((5 * (familyDetailsPanelWidth/6))-20, secondRowY, (familyDetailsPanelWidth/6)-30, 24);
				familyMemberRelationLabel[i].setBounds((3 * (familyDetailsPanelWidth/6))-342-20, thirdRowY, 337, 20);
				familyMemberRelationField[i].setBounds((3 * (familyDetailsPanelWidth/6))-20, thirdRowY, (familyDetailsPanelWidth/6)-30, 24);
				familyMemberBirthDateLabel[i].setBounds((5 * (familyDetailsPanelWidth/6))-94-20, thirdRowY, 89, 20);
//				familyMemberBirthDateField[i].setBounds((5 * (familyDetailsPanelWidth/6))-20, thirdRowY, (familyDetailsPanelWidth/6)-30, 24);
				
				familyMemberEducationPanel[i].setBounds(10, fourthRowY, familyMemberEducationPanelWidth, 75);
				
				familyMemberGenderLabel[i].setBounds((familyDetailsPanelWidth/6)-68-20, fifthRowY, 63, 20);
				familyMemberGenderMaleRadioButton[i].setBounds((familyDetailsPanelWidth/6)-20, fifthRowY, 60, 20);
				familyMemberGenderFemaleRadioButton[i].setBounds((2 * (familyDetailsPanelWidth/6))-20, fifthRowY, 77, 20);
				familyMemberMaritualStatusLabel[i].setBounds((4 * (familyDetailsPanelWidth/6))-127-20, fifthRowY, 122, 20);
				familyMemberMarriedRadioButton[i].setBounds((4 * (familyDetailsPanelWidth/6))-20, fifthRowY, 83, 20);
				familyMemberUnmarriedRadioButton[i].setBounds((5 * (familyDetailsPanelWidth/6))-20, fifthRowY, 103, 20);
				whatsappNumberLabel[i].setBounds((4 * (familyDetailsPanelWidth/6))-152-20, sixthRowY, 147, 20);
				whatsappNumberField[i].setBounds((4 * (familyDetailsPanelWidth/6))-20, sixthRowY, (familyDetailsPanelWidth/6), 20);
				
				for(int j=0 ; j<8 ; j++)
				{
					familyMemberQualificationLabel[i][j].setVisible(false);
					familyMemberQualificationField[i][j].setVisible(false);
					familyMemberStreamLabel[i][j].setVisible(false);
					familyMemberStreamField[i][j].setVisible(false);
					familyMemberDegreeLabel[i][j].setVisible(false);
					familyMemberDegreeField[i][j].setVisible(false);
				}
				numberOfEducationQualificationLabel[i].setVisible(true);
				numberOfEducationQualificationField[i].setVisible(true);
				addEducationQualification[i].setVisible(true);
				numberOfEducationQualificationField[i].setSelectedIndex(0);
				
		/*		familyMemberMaritualStatusLabel[i].setVisible(false);
				familyMemberMarriedRadioButton[i].setVisible(false);
				familyMemberUnmarriedRadioButton[i].setVisible(false);
				familyMemberGenderLabel[i].setVisible(false);
				familyMemberGenderMaleRadioButton[i].setVisible(false);
				familyMemberGenderFemaleRadioButton[i].setVisible(false);
				whatsappNumberLabel[i].setVisible(false);
				whatsappNumberField[i].setVisible(false);  */
				
				familyMemberSurnameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
				familyMemberNameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
				familyMemberFatherNameField[i].setBorder(BorderFactory.createLoweredBevelBorder());
				familyMemberRelationField[i].setBorder(BorderFactory.createLoweredBevelBorder());
				familyMemberMaritualStatusLabel[i].setForeground(Color.DARK_GRAY);
				familyMemberMarriedRadioButton[i].setForeground(Color.DARK_GRAY);
				familyMemberUnmarriedRadioButton[i].setForeground(Color.DARK_GRAY);
				familyMemberGenderLabel[i].setForeground(Color.DARK_GRAY);
				familyMemberGenderMaleRadioButton[i].setForeground(Color.DARK_GRAY);
				familyMemberGenderFemaleRadioButton[i].setForeground(Color.DARK_GRAY);
			}
		}
	}
	
	void refreshFieldData(String from)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/azbs_db","root","");
			Statement stmt = con.createStatement();
			
			String sql = "";
			ResultSet rs;
			
		// root and current countryField
			sql = "SELECT `country_name` FROM `country_field`";
			rs = stmt.executeQuery(sql);
			
/*			int currentCountrySelectedIndex = currentCountryField.getSelectedIndex();
			int currentStateSelectedIndex = currentStateField.getSelectedIndex();
			int currentDistrictSelectedIndex = currentDistrictField.getSelectedIndex();
			int currentCitySelectedIndex = currentCityField.getSelectedIndex();
			
			int rootCountrySelectedIndex = rootCountryField.getSelectedIndex();
			int rootStateSelectedIndex = rootStateField.getSelectedIndex();
			int rootDistrictSelectedIndex = rootDistrictField.getSelectedIndex();
			int rootCitySelectedIndex = rootCityField.getSelectedIndex();
			// TODOfsd
			
			currentCountryField.setSelectedIndex(0);
			currentStateField.setSelectedIndex(0);
			currentDistrictField.setSelectedIndex(0);
			currentCityField.setSelectedIndex(0);
			rootCountryField.setSelectedIndex(0);
			rootStateField.setSelectedIndex(0);
			rootDistrictField.setSelectedIndex(0);
			rootCityField.setSelectedIndex(0); */
			
			currentCountryField.removeAllItems();
			currentCountryField.addItem("");
			rootCountryField.removeAllItems();
			rootCountryField.addItem("");
			
			while(rs.next())
			{
				currentCountryField.addItem(rs.getString(1));
				rootCountryField.addItem(rs.getString(1));
			}
			
/*			if(currentCountrySelectedIndex != -1)
				currentCountryField.setSelectedIndex(currentCountrySelectedIndex);
			else
				currentCountryField.setSelectedIndex(1);

			if(currentStateSelectedIndex != -1)
				currentStateField.setSelectedIndex(currentStateSelectedIndex);
			else
				currentStateField.setSelectedIndex(-1);
			
			if(currentDistrictSelectedIndex != -1)
				currentDistrictField.setSelectedIndex(currentDistrictSelectedIndex);
			else
				currentDistrictField.setSelectedIndex(-1);
			
			if(currentCitySelectedIndex != -1)
				currentCityField.setSelectedIndex(currentCitySelectedIndex);
			else
				currentCityField.setSelectedIndex(-1);
			
			if(rootCountrySelectedIndex != -1)
				rootCountryField.setSelectedIndex(rootCountrySelectedIndex);
			else
				rootCountryField.setSelectedIndex(1);
			
			if(rootStateSelectedIndex != -1)
				rootStateField.setSelectedIndex(rootStateSelectedIndex);
			else
				rootStateField.setSelectedIndex(-1);
			
			if(rootDistrictSelectedIndex != -1)
				rootDistrictField.setSelectedIndex(rootDistrictSelectedIndex);
			else
				rootDistrictField.setSelectedIndex(-1);
			
			if(rootCitySelectedIndex != -1)
				rootCityField.setSelectedIndex(rootCitySelectedIndex);
			else
				rootCityField.setSelectedIndex(-1); */
			
		// root and current stateField
/*			sql = "SELECT `state_name` FROM `state_field`";
			rs = stmt.executeQuery(sql);
			
			int currentStateSelectedIndex = currentStateField.getSelectedIndex();
			int rootStateSelectedIndex = rootStateField.getSelectedIndex();
			
			currentStateField.removeAllItems();
			currentStateField.addItem("");
			rootStateField.removeAllItems();
			rootStateField.addItem("");
			
			while(rs.next())
			{
				currentStateField.addItem(rs.getString(1));
				rootStateField.addItem(rs.getString(1));
			}
			
			if(currentStateSelectedIndex != -1)
				currentStateField.setSelectedIndex(currentStateSelectedIndex);
			else
				currentStateField.setSelectedIndex(1);
			
			if(rootStateSelectedIndex != -1)
				rootStateField.setSelectedIndex(rootStateSelectedIndex);
			else
				rootStateField.setSelectedIndex(1);
			
		// root and current cityField
			sql = "SELECT `city_name` FROM `city_field`";
			rs = stmt.executeQuery(sql);
			
			int currentCitySelectedIndex = currentCityField.getSelectedIndex();
			int rootCitySelectedIndex = rootCityField.getSelectedIndex();
			
			currentCityField.removeAllItems();
			currentCityField.addItem("");
			rootCityField.removeAllItems();
			rootCityField.addItem("");
			
			while(rs.next())
			{
				currentCityField.addItem(rs.getString(1));
				rootCityField.addItem(rs.getString(1));
			}
			
			if(currentCitySelectedIndex != -1)
				currentCityField.setSelectedIndex(currentCitySelectedIndex);
			else
				currentCityField.setSelectedIndex(1);
			
			if(rootCitySelectedIndex != -1)
				rootCityField.setSelectedIndex(rootCitySelectedIndex);
			else
				rootCityField.setSelectedIndex(1);  */


		int mainPersonSurnameSelectedIndex;
		int[] familyMemberSurnameSelectedIndex;
		int rootGotraSelectedIndex;
		int rootKulDeviSelectedIndex;
		int businessSelectedIndex;
		int serviceSelectedIndex;
		int rootKulSelectedIndex;
		int rootMoshalSurnameSelectedIndex;
		int rootTalGolSelectedIndex;
		int[] familyMemberRelationSelectedIndex;
		int[][] familyMemberQualificationSelectedIndex;
		int[][] familyMemberStreamSelectedIndex;
		int[][] familyMemberDegreeSelectedIndex;
		int referencebySelectedIndex;
			
System.out.println("6683");
		
		// main and familyMember surnameField
			sql = "SELECT `surname_name` FROM `surname_field`";
			rs = stmt.executeQuery(sql);
		
			mainPersonSurnameSelectedIndex = mainPersonSurnameField.getSelectedIndex();
			familyMemberSurnameSelectedIndex = new int[15];
			for(int i=0 ; i<15 ; i++)
				familyMemberSurnameSelectedIndex[i] = familyMemberSurnameField[i].getSelectedIndex();
			
			mainPersonSurnameField.removeAllItems();
			mainPersonSurnameField.addItem("");
			for(int i=0 ; i<15 ; i++)
			{
				familyMemberSurnameField[i].removeAllItems();
				familyMemberSurnameField[i].addItem("");
			}
			
			while(rs.next())
			{
				mainPersonSurnameField.addItem(rs.getString(1));
				for(int i=0 ; i<15 ; i++)
					familyMemberSurnameField[i].addItem(rs.getString(1));
			}
			
System.out.println("6709");
			
		// rootGotraField
			sql = "SELECT `gotra_name` FROM `gotra_field`";
			rs = stmt.executeQuery(sql);
			
			rootGotraSelectedIndex = rootGotraField.getSelectedIndex();
			
			rootGotraField.removeAllItems();
			rootGotraField.addItem("");
			
			while(rs.next())
				rootGotraField.addItem(rs.getString(1));
			
		// rootKulDeviField
			sql = "SELECT `kuldevi_name` FROM `kuldevi_field`";
			rs = stmt.executeQuery(sql);
			
			rootKulDeviSelectedIndex = rootKulDeviField.getSelectedIndex();
			
			rootKulDeviField.removeAllItems();
			rootKulDeviField.addItem("");
			
			while(rs.next())
				rootKulDeviField.addItem(rs.getString(1));
			
System.out.println("6735");
			
		// businessField
			sql = "SELECT `business_name` FROM `business_field`";
			rs = stmt.executeQuery(sql);
			
			businessSelectedIndex = businessField.getSelectedIndex();
			
			businessField.removeAllItems();
			businessField.addItem("");
			
			while(rs.next())
				businessField.addItem(rs.getString(1));
			
		// serviceField
			sql = "SELECT `service_name` FROM `service_field`";
			rs = stmt.executeQuery(sql);
			
			serviceSelectedIndex = serviceField.getSelectedIndex();
			
			serviceField.removeAllItems();
			serviceField.addItem("");
			
			while(rs.next())
				serviceField.addItem(rs.getString(1));
			
System.out.println("6761");
			
		// kulField
			sql = "SELECT `kul_name` FROM `kul_field`";
			rs = stmt.executeQuery(sql);
			
			rootKulSelectedIndex = rootKulField.getSelectedIndex();
			
			rootKulField.removeAllItems();
			rootKulField.addItem("");
			
			while(rs.next())
				rootKulField.addItem(rs.getString(1));
			
		// moshalSurnameField
			sql = "SELECT `moshal_surname_name` FROM `moshal_surname_field`";
			rs = stmt.executeQuery(sql);
			
			rootMoshalSurnameSelectedIndex = rootMoshalSurnameField.getSelectedIndex();
			
			rootMoshalSurnameField.removeAllItems();
			rootMoshalSurnameField.addItem("");
			
			while(rs.next())
				rootMoshalSurnameField.addItem(rs.getString(1));
			
System.out.println("6787");
			
		// talGolField
			sql = "SELECT `tal_gol_name` FROM `tal_gol_field`";
			rs = stmt.executeQuery(sql);
			
			rootTalGolSelectedIndex = rootTalGolField.getSelectedIndex();
			
			rootTalGolField.removeAllItems();
			rootTalGolField.addItem("");
			
			while(rs.next())
				rootTalGolField.addItem(rs.getString(1));
		
		// relationField
			familyMemberRelationSelectedIndex = new int[15];
			for(int i=0 ; i<15 ; i++)
			{
				sql = "SELECT `relation_name` FROM `relation_field`";
				rs = stmt.executeQuery(sql);
				
				familyMemberRelationSelectedIndex[i] = familyMemberRelationField[i].getSelectedIndex();
				
				familyMemberRelationField[i].removeAllItems();
				familyMemberRelationField[i].addItem("");
				
				while(rs.next())
					familyMemberRelationField[i].addItem(rs.getString(1));
			}
			
System.out.println("6817");
			
		// qualificationField
			sql = "SELECT `qualification_name` FROM `qualification_field`";
			rs = stmt.executeQuery(sql);
			
			familyMemberQualificationSelectedIndex = new int[15][8];
			familyMemberStreamSelectedIndex = new int[15][8];
			familyMemberDegreeSelectedIndex = new int[15][8];
			
			for(int i=0 ; i<15 ; i++)
			{
				for(int j=0 ; j<8 ; j++)
				{
					familyMemberQualificationSelectedIndex[i][j] = familyMemberQualificationField[i][j].getSelectedIndex();
					familyMemberStreamSelectedIndex[i][j] = familyMemberStreamField[i][j].getSelectedIndex();
					familyMemberDegreeSelectedIndex[i][j] = familyMemberDegreeField[i][j].getSelectedIndex();
					
					familyMemberQualificationField[i][j].removeAllItems();
					familyMemberQualificationField[i][j].addItem("");
				}
			}
			
			while(rs.next())
			{
				for(int i=0 ; i<15 ; i++)
				{
					for(int j=0 ; j<8 ; j++)
					{
						familyMemberQualificationField[i][j].addItem(rs.getString(1));
					}
				}
			}
			
		// referenceField
			sql = "SELECT `reference_name` FROM `reference_field`";
			rs = stmt.executeQuery(sql);
	
			referencebySelectedIndex = referencebyField.getSelectedIndex();
			
			referencebyField.removeAllItems();
			referencebyField.addItem("");
			
			while(rs.next())
				referencebyField.addItem(rs.getString(1));
			
System.out.println("6863");
			
		// TabPanelChangeSubmitFormNumberButton
			if(from.compareTo("TabPanelChange")==0)
			{
				mainPersonSurnameField.setSelectedIndex(mainPersonSurnameSelectedIndex);
				rootGotraField.setSelectedIndex(rootGotraSelectedIndex);
				rootKulDeviField.setSelectedIndex(rootKulDeviSelectedIndex);
				businessField.setSelectedIndex(businessSelectedIndex);
				serviceField.setSelectedIndex(serviceSelectedIndex);
				rootKulField.setSelectedIndex(rootKulSelectedIndex);
				rootMoshalSurnameField.setSelectedIndex(rootMoshalSurnameSelectedIndex);
				rootTalGolField.setSelectedIndex(rootTalGolSelectedIndex);
				for(int i=0 ; i<15 ; i++)
				{
					familyMemberSurnameField[i].setSelectedIndex(familyMemberSurnameSelectedIndex[i]);
					familyMemberRelationField[i].setSelectedIndex(familyMemberRelationSelectedIndex[i]);
					for(int j=0 ; j<8 ; j++)
					{
						familyMemberQualificationField[i][j].setSelectedIndex(familyMemberQualificationSelectedIndex[i][j]);
						familyMemberStreamField[i][j].setSelectedIndex(familyMemberStreamSelectedIndex[i][j]);
						familyMemberDegreeField[i][j].setSelectedIndex(familyMemberDegreeSelectedIndex[i][j]);
					}
				}
				referencebyField.setSelectedIndex(referencebySelectedIndex);
			}
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void updateEducationQualificationBounds(int familyMemberEducationPanelY, int numberOfThisMember, int numberOfEducationQualification, int numberOfMembers, boolean state)
	{
		if(numberOfThisMember==1)
		{
			increasedHeight = ((numberOfEducationQualification-1)*30);
//			if(familyMebmerEducationPanel)
		}
	
		if(state == true)
		{
			for(int i=numberOfThisMember ; i<numberOfMembers ; i++)
			{
				int fifthRowY = 0;
				int sixthRowY = 0;
				
				fifthRowY = 180;
				sixthRowY = 210;
				
				if(i != numberOfThisMember)
				{
					int AlignmentY = familyMemberPanel[i].getY();
					int Height = familyMemberPanel[i].getHeight();
		//			System.out.println(familyMemberPanel[i].getY());
		//			familyMemberPanel[i].setBounds(20, (i * 250)+20+((numberOfEducationQualification-1)*30), familyDetailsPanelWidth-40, 250);
					familyMemberPanel[i].setBounds(20, AlignmentY+((numberOfEducationQualification-1)*30), familyDetailsPanelWidth-40, Height);
				}
				else
				{
					int AlignmentY = familyMemberPanel[i].getY();
					int Height = familyMemberPanel[i].getHeight();
		//			familyMemberPanel[i].setBounds(20, (numberOfThisMember * 250)+20, familyDetailsPanelWidth-40, 250+((numberOfEducationQualification-1)*30));
					familyMemberPanel[i].setBounds(20, AlignmentY, familyDetailsPanelWidth-40, Height+((numberOfEducationQualification-1)*30));
					familyMemberGenderLabel[i].setBounds((familyDetailsPanelWidth/6)-75-20, fifthRowY+((numberOfEducationQualification-1)*30), 70, 20);
					familyMemberGenderMaleRadioButton[i].setBounds((familyDetailsPanelWidth/6)-20, fifthRowY+((numberOfEducationQualification-1)*30), 60, 20);
					familyMemberGenderFemaleRadioButton[i].setBounds((2 * (familyDetailsPanelWidth/6))-20, fifthRowY+((numberOfEducationQualification-1)*30), 77, 20);
					familyMemberMaritualStatusLabel[i].setBounds((4 * (familyDetailsPanelWidth/6))-134-20, fifthRowY+((numberOfEducationQualification-1)*30), 129, 20);
					familyMemberMarriedRadioButton[i].setBounds((4 * (familyDetailsPanelWidth/6))-20, fifthRowY+((numberOfEducationQualification-1)*30), 83, 20);
					familyMemberUnmarriedRadioButton[i].setBounds((5 * (familyDetailsPanelWidth/6))-20, fifthRowY+((numberOfEducationQualification-1)*30), 103, 20);
					whatsappNumberLabel[i].setBounds((4 * (familyDetailsPanelWidth/6))-152-20, sixthRowY+((numberOfEducationQualification-1)*30), 147, 20);
					whatsappNumberField[i].setBounds((4 * (familyDetailsPanelWidth/6))-20, sixthRowY+((numberOfEducationQualification-1)*30), (familyDetailsPanelWidth/6), 20);
					
					int AlignmentYfamilyPanel = familyDetailsPanel.getHeight();
					int AlignmentYaddMemberPanel = addMemberPanel.getHeight();
					int AlignmentYOtherDetailsPanel = otherDetailsPanel.getY();
					int AlignmentYSubmitFormButton = submitFormButton.getY();
					int AlignmentYResetFormButton = resetFormButton.getY();
					int AlignmentYResetFormWithFormNumberButton = resetFormWithFormNumberButton.getY();
					int AlignmentYReferencebyLabel = referencebyLabel.getY();
					int AlignmentYReferencebyField = referencebyField.getY();
					int AlignmentYFamilyPanelButton = resetFamilyPanelButton.getY();
					
					familyMemberEducationPanel[i].setBounds(10, familyMemberEducationPanelY, familyDetailsPanelWidth-60, 30+(numberOfEducationQualification*30)+15);
					familyDetailsPanel.setBounds(40, 645, familyDetailsPanelWidth, AlignmentYfamilyPanel+((numberOfEducationQualification-1)*30));
					addMemberPanel.setPreferredSize(new Dimension(mainFooterPanelWidth-20, AlignmentYaddMemberPanel+((numberOfEducationQualification-1)*30)));
					addMemberPanelScrollPane.repaint();
					otherDetailsPanel.setBounds(40, AlignmentYOtherDetailsPanel+((numberOfEducationQualification-1)*30), otherDetailsPanelWidth, otherDetailsPanelHeight);
					otherDetailsPanel.repaint();
					submitFormButton.setBounds(mainFooterPanelWidth-380, AlignmentYSubmitFormButton+((numberOfEducationQualification-1)*30), 150, 24);
					resetFormButton.setBounds(mainFooterPanelWidth-200, AlignmentYResetFormButton+((numberOfEducationQualification-1)*30), 150, 24);
					resetFormWithFormNumberButton.setBounds(mainFooterPanelWidth-380-180-50, AlignmentYResetFormWithFormNumberButton+((numberOfEducationQualification-1)*30), 200, 24);
					referencebyLabel.setBounds(50, AlignmentYReferencebyLabel+((numberOfEducationQualification-1)*30), 110, 24);
					referencebyField.setBounds(165, AlignmentYReferencebyField+((numberOfEducationQualification-1)*30), (mainFooterPanelWidth/6), 24);
					resetFamilyPanelButton.setBounds((5 * (familyDetailsPanelWidth/6)), AlignmentYFamilyPanelButton+((numberOfEducationQualification-1)*30), (familyDetailsPanelWidth/6)-30, 24);
				}
			}
		}
	}
}

class RoundJTextField extends JTextField {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 25, 25);
         }
         return shape.contains(x, y);
    }
}

class RoundJPasswordField extends JPasswordField {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape shape;
    public RoundJPasswordField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 25, 25);
         }
         return shape.contains(x, y);
    }
}

class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}

class JTextFieldLimit extends PlainDocument
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limit;
	JTextFieldLimit(int limit)
	{
		super();
		this.limit = limit;
	}
	
	JTextFieldLimit(int limit, boolean upper)
	{
		super();
		this.limit = limit;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
	{
		if(str == null)
			return;
		
		if((getLength()+str.length()) <= limit)
			super.insertString(offset, str, attr);
	}
}