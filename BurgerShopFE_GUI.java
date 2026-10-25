package hw6;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class BurgerShopFE_GUI
{
  private static BurgerShop burgerShop = new BurgerShop();
  private static JTextArea displayArea;
  private static JTextField fundsField, quantityField;
  private static JComboBox<String> burgerComboBox;
  private static JCheckBox confirmationCheckBox;
  private static JLabel statusLabel, fontSizeLabel;
  private static JSlider textSizeSlider;
  private static JRadioButton plainRadioButton, boldRadioButton;

  public static void main(String[] args)
  {
      //Creates the main application window
      JFrame frame = new JFrame("Burger Shop");
      frame.setSize(760, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);

      //Creates the File and Help menus for the application
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenu helpMenu = new JMenu("Help");
      
      JMenuItem clearFieldsMenuItem = new JMenuItem("Clear Fields");
      JMenuItem exitMenuItem = new JMenuItem("Exit");
      JMenuItem aboutMenuItem = new JMenuItem("About");

      fileMenu.add(clearFieldsMenuItem);
      fileMenu.add(exitMenuItem);
      helpMenu.add(aboutMenuItem);
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
      frame.setJMenuBar(menuBar);

      //Organizes the customer order information
      JPanel orderPanel = new JPanel();
      orderPanel.setBounds(20, 20, 340, 150);
      orderPanel.setLayout(null);
      orderPanel.setBorder(new TitledBorder("Order Information"));
      frame.add(orderPanel);

      JLabel fundsLabel = new JLabel("Funds Amount:");
      fundsLabel.setBounds(15, 25, 100, 25);
      orderPanel.add(fundsLabel);

      fundsField = new JTextField();
      fundsField.setBounds(120, 25, 180, 25);
      orderPanel.add(fundsField);

      JLabel burgerLabel = new JLabel("Burger:");
      burgerLabel.setBounds(15, 60, 100, 25);
      orderPanel.add(burgerLabel);

      burgerComboBox = new JComboBox<String>(burgerShop.getBurgerNames());
      burgerComboBox.setBounds(120, 60, 180, 25);
      orderPanel.add(burgerComboBox);

      JLabel quantityLabel = new JLabel("Quantity:");
      quantityLabel.setBounds(15, 95, 100, 25);
      orderPanel.add(quantityLabel);

      quantityField = new JTextField();
      quantityField.setBounds(120, 95, 180, 25);
      orderPanel.add(quantityField);

      //Contains all Burger Shop operation buttons
      JPanel actionsPanel = new JPanel();
      actionsPanel.setBounds(380, 20, 340, 150);
      actionsPanel.setLayout(null);
      actionsPanel.setBorder(new TitledBorder("Actions"));
      frame.add(actionsPanel);

      JButton addFundsButton = new JButton("Add Funds");
      addFundsButton.setBounds(15, 25, 95, 30);
      actionsPanel.add(addFundsButton);

      JButton placeOrderButton = new JButton("Place Order");
      placeOrderButton.setBounds(115, 25, 105, 30);
      actionsPanel.add(placeOrderButton);

      JButton viewMenuButton = new JButton("View Menu");
      viewMenuButton.setBounds(225, 25, 95, 30);
      actionsPanel.add(viewMenuButton);

      JButton checkBalanceButton = new JButton("Check Balance");
      checkBalanceButton.setBounds(15, 70, 120, 30);
      actionsPanel.add(checkBalanceButton);

      JButton orderHistoryButton = new JButton("Order History");
      orderHistoryButton.setBounds(145, 70, 115, 30);
      actionsPanel.add(orderHistoryButton);

      JButton clearFieldsButton = new JButton("Clear Fields");
      clearFieldsButton.setBounds(15, 110, 115, 30);
      actionsPanel.add(clearFieldsButton);

      //Contains controls that change how text is displayed
      JPanel displaySettingsPanel = new JPanel();
      displaySettingsPanel.setBounds(20, 185, 340, 300);
      displaySettingsPanel.setLayout(null);
      displaySettingsPanel.setBorder(new TitledBorder("Display Settings"));
      frame.add(displaySettingsPanel);

      JLabel textSizeLabel = new JLabel("Text Size:");
      textSizeLabel.setBounds(15, 25, 70, 25);
      displaySettingsPanel.add(textSizeLabel);

      textSizeSlider = new JSlider(10, 24, 14);
      textSizeSlider.setBounds(80, 20, 230, 60);
      textSizeSlider.setMajorTickSpacing(2);
      textSizeSlider.setMinorTickSpacing(1);
      textSizeSlider.setPaintTicks(true);
      textSizeSlider.setPaintLabels(true);
      displaySettingsPanel.add(textSizeSlider);

      fontSizeLabel = new JLabel("Current Size: 14");
      fontSizeLabel.setBounds(15, 85, 150, 25);
      displaySettingsPanel.add(fontSizeLabel);

      JLabel textStyleLabel = new JLabel("Text Style:");
      textStyleLabel.setBounds(15, 120, 80, 25);
      displaySettingsPanel.add(textStyleLabel);

      plainRadioButton = new JRadioButton("Plain");
      plainRadioButton.setBounds(90, 120, 70, 25);
      plainRadioButton.setSelected(true);
      displaySettingsPanel.add(plainRadioButton);


      boldRadioButton = new JRadioButton("Bold");
      boldRadioButton.setBounds(170, 120, 70, 25);
      displaySettingsPanel.add(boldRadioButton);

      ButtonGroup textStyleGroup = new ButtonGroup();
      textStyleGroup.add(plainRadioButton);
      textStyleGroup.add(boldRadioButton);

      confirmationCheckBox = new JCheckBox("Show confirmation messages");
      confirmationCheckBox.setBounds(15, 165, 220, 25);
      confirmationCheckBox.setSelected(true);
      displaySettingsPanel.add(confirmationCheckBox);

      //Displays messages returned by the BurgerShop back end
      JPanel informationPanel = new JPanel();
      informationPanel.setBounds(380, 185, 340, 300);
      informationPanel.setLayout(null);
      informationPanel.setBorder(new TitledBorder("Burger Shop Information"));
      frame.add(informationPanel);

      displayArea = new JTextArea();
      displayArea.setEditable(false);
      displayArea.setLineWrap(true);
      displayArea.setWrapStyleWord(true);

      JScrollPane scrollPane = new JScrollPane(displayArea);
      scrollPane.setBounds(15, 25, 310, 220);
      informationPanel.add(scrollPane);

      statusLabel = new JLabel("Status: Ready");
      statusLabel.setBounds(15, 255, 300, 25);
      informationPanel.add(statusLabel);

      //Connects each button to its Burger Shop operation
      addFundsButton.addActionListener(e -> addFunds());
      placeOrderButton.addActionListener(e -> placeOrder());
      viewMenuButton.addActionListener(e -> viewMenu());
      checkBalanceButton.addActionListener(e -> checkBalance());
      orderHistoryButton.addActionListener(e -> viewOrderHistory());
      clearFieldsButton.addActionListener(e -> clearFields());

      //Updates the display whenever the slider or text style changes
      textSizeSlider.addChangeListener(e -> updateDisplayFont());
      plainRadioButton.addActionListener(e -> updateDisplayFont());
      boldRadioButton.addActionListener(e -> updateDisplayFont());

      //Connects the menu items to their required operations
      clearFieldsMenuItem.addActionListener(e -> clearFields());
      exitMenuItem.addActionListener(e -> System.exit(0));
      aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Burger Shop\nHomework 06\nEric Vu", "About", JOptionPane.INFORMATION_MESSAGE));


      updateDisplayFont();

      frame.setVisible(true);
  }


  //Adds funds using the amount entered by the user
  private static void addFunds()
  {
      double amount = Double.parseDouble(fundsField.getText());

      String message = burgerShop.addFunds(amount);
      displayArea.setText(message);
      statusLabel.setText("Status: Funds operation completed");

      if(confirmationCheckBox.isSelected())
      {
          JOptionPane.showMessageDialog(displayArea, message, "Add Funds", JOptionPane.INFORMATION_MESSAGE);
      }
  }


  //Places an order using the selected burger and quantity
  private static void placeOrder()
  {
      String burgerName = (String)burgerComboBox.getSelectedItem();
      int quantity = Integer.parseInt(quantityField.getText());
      String message = burgerShop.placeOrder(burgerName, quantity);

      displayArea.setText(message);
      statusLabel.setText("Status: Order processed");

      if(confirmationCheckBox.isSelected())
      {
          JOptionPane.showMessageDialog(displayArea, message, "Place Order", JOptionPane.INFORMATION_MESSAGE);
      }
  }


  //Displays the complete burger menu
  private static void viewMenu()
  {
      displayArea.setText(burgerShop.getMenuText());
      statusLabel.setText("Status: Menu displayed");
  }


  //Displays the customer's current account balance
  private static void checkBalance()
  {
      displayArea.setText(burgerShop.getBalanceText());
      statusLabel.setText("Status: Balance displayed");
  }


  //Displays all successful orders
  private static void viewOrderHistory()
  {
      displayArea.setText(burgerShop.getOrderHistory());
      statusLabel.setText("Status: Order history displayed");
  }


  //Clears only the current input controls
  private static void clearFields()
  {
      fundsField.setText("");
      quantityField.setText("");
      burgerComboBox.setSelectedIndex(0);
      statusLabel.setText("Status: Input fields cleared");
  }


  //Changes the JTextArea font size and style
  private static void updateDisplayFont()
  {
      int fontSize = textSizeSlider.getValue();
      int fontStyle = Font.PLAIN;

      if(boldRadioButton.isSelected())
      {
          fontStyle = Font.BOLD;
      }

      displayArea.setFont(new Font(displayArea.getFont().getName(), fontStyle, fontSize));
      fontSizeLabel.setText("Current Size: " + fontSize);
  }
}
