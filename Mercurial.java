package mercurial;

import java.util.*;
import java.lang.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Application for self Organization, scheduling, goals,
 * planning, and internship finding. (Keep track of productivity)
 * 
 * @author Shanfeng Feng
 * @version 0.1
 * @since 2017-03-30
 */

// TODO need to implement actionListener for button action
public class Mercurial extends JFrame implements ActionListener{

  // default frame status
  //private JFrame mainFrame;
  private static final int FRAME_WIDTH = 1000;
  private static final int FRAME_HEIGHT = 700;
  private static final int HEADER_FONT_SIZE = 16;
  
  // left portion of the UI
  private JPanel leftPanel,leftPanelTop,leftPanelBot,leftPanelBotTop;
  private JScrollPane leftScroll;
  private JLabel myProductivity;
  private JToolBar addRemoveBar;
  private JButton addButtonLP, removeButtonLP;
  private JMenu sortLP;
  private static final int LEFT_GRAYSCALE = 91;
  private static final int BORDER_PADDING = 10;
  
  /**
   * display the user interface
   */
  public void displayUI(){
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
    this.setSize(this.getPreferredSize());
    this.setTitle("Mercurial");
    this.getContentPane().setBackground(Color.DARK_GRAY);
    this.setTopUI();
    this.setLeftUI();
    
    this.setVisible(true);
  }
  
  /**
   * TODO add toolbars for check box functionality
   * Set up the top panel user interface
   */
  private void setTopUI(){
    
    TopUI topUI = new TopUI(this);
    
  }
  
  /**
   * TODO toolbar for check box functionality and productivity gauge
   * set up the left user interface
   */
  private void setLeftUI(){
    
    // left panel initializations
    leftPanel = new JPanel(new BorderLayout());
    leftPanelTop = new JPanel();
    leftPanelBot = new JPanel(new BorderLayout());
    leftPanelBotTop = new JPanel();
    leftScroll = new JScrollPane(leftPanelBotTop);
    myProductivity = new JLabel("Priority Tasks/Remainders: ");
    this.setHeaderFont(myProductivity);
    
    // components for left bottom panel
    addRemoveBar = new JToolBar();
    addButtonLP = new JButton("+");
    removeButtonLP = new JButton("-");
    sortLP = new JMenu("sort");
    
    this.addToolBars(leftPanelBot, addButtonLP, removeButtonLP, sortLP, addRemoveBar);
    leftPanelBot.add(leftPanelBotTop);
    
    leftPanelTop.add(myProductivity);
    leftPanel.add(leftPanelTop,BorderLayout.NORTH);
    leftPanel.add(leftPanelBot);
    
    // color settings
    leftPanel.setBorder(new EmptyBorder(BORDER_PADDING,BORDER_PADDING,
                                        BORDER_PADDING,BORDER_PADDING));
    
    this.setComponentColor(leftPanel, LEFT_GRAYSCALE);
    this.setComponentColor(leftPanelBot, LEFT_GRAYSCALE);
    this.setComponentColor(addRemoveBar, LEFT_GRAYSCALE);
    
    this.add(leftPanel,BorderLayout.WEST);
  }
  
  /**
   * add a toolbar to a Jpanel (such toolbar is for add/remove tasks)
   * 
   * @param panel: the panel that contains the toolbar
   * @param addB: the add button
   * @param removeB: the remove button
   * @param sort: the sort menu
   * @param toolbar: the toolbar containing the buttons and menu
   */
  public void addToolBars(JPanel panel, JButton addB, JButton removeB, JMenu sort,
                          JToolBar toolbar){
    
    // adding buttons and menus to toolbar
    toolbar.add(addB);
    toolbar.add(removeB);
    toolbar.add(sort);
    toolbar.setFloatable(false);
    panel.add(toolbar,BorderLayout.SOUTH);
    
    // set JButtons background
    Font buttonFont = new Font(addB.getFont().getFontName(),
                               Font.BOLD,12);
    addB.setOpaque(true);
    addB.setBorderPainted(false);
    addB.setFont(buttonFont);
    removeB.setOpaque(true);
    removeB.setBorderPainted(false);
  
  }
  
  public JFrame mainFrame(){
    return this;
  }
  
  /**
   * set the components of a container to the same color as the container
   * @param container: the container that holds all the component
   * @param grayscale: the color to be set
   */
  public void setComponentColor(Container container, int grayscale){
    
    container.setBackground(new Color(grayscale, grayscale, grayscale));
    
    for(Component c : container.getComponents()){
      
      c.setBackground(new Color(grayscale, grayscale, grayscale));

    }
    
  }
  /**
   * set the header label to be in bold font and header size
   * @param label: the JLabel to be set bold
   */
  public void setHeaderFont(JLabel label){
    
    Font labelFont = label.getFont();
    Font boldFont = new Font(labelFont.getFontName(),
                             Font.BOLD,HEADER_FONT_SIZE);
    label.setFont(boldFont);
  }

  /**
   * runs the program in default
   * @param args: command line arguments
   */
  public static void main(String [] args){
    
    Mercurial myApp = new Mercurial();
    myApp.displayUI();
    
  }

  /**
   * Button actions
   */
  public void actionPerformed(ActionEvent e) {
   
    
  }
  
}
