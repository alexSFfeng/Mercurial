package mercurial;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

/**
 * Left side UI configurations for Mercurial
 * 
 * @author Shanfeng Feng
 * @version 0.1
 * @since 2017-04-10
 *
 */
public class LeftUI implements ActionListener{

  // left portion of the UI
  private JPanel leftPanel,leftPanelTop,leftPanelBot,leftPanelBotTop;
  private JScrollPane leftScroll;
  private JLabel myProductivity;
  private JToolBar addRemoveBar;
  private JButton addButtonLP, removeButtonLP;
  private JMenu sortLP;
  private static final int LEFT_GRAYSCALE = 91;
  private static final int BORDER_PADDING = 10;
  
  public LeftUI (Mercurial frame){
    
    // left panel initializations
    leftPanel = new JPanel(new BorderLayout());
    leftPanelTop = new JPanel();
    leftPanelBot = new JPanel(new BorderLayout());
    leftPanelBotTop = new JPanel();
    leftScroll = new JScrollPane(leftPanelBotTop);
    myProductivity = new JLabel("Priority Tasks/Remainders: ");
    frame.setHeaderFont(myProductivity);
    
    // components for left bottom panel
    addRemoveBar = new JToolBar();
    addButtonLP = new JButton("+");
    removeButtonLP = new JButton("-");
    sortLP = new JMenu("sort");
    
    frame.addToolBars(leftPanelBot, addButtonLP, removeButtonLP, sortLP, addRemoveBar);
    leftPanelBot.add(leftPanelBotTop);
    
    leftPanelTop.add(myProductivity);
    leftPanel.add(leftPanelTop,BorderLayout.NORTH);
    leftPanel.add(leftPanelBot);
    
    // color settings
    leftPanel.setBorder(new EmptyBorder(BORDER_PADDING,BORDER_PADDING,
                                        BORDER_PADDING,BORDER_PADDING));
    
    frame.setComponentColor(leftPanel, LEFT_GRAYSCALE);
    frame.setComponentColor(leftPanelBot, LEFT_GRAYSCALE);
    frame.setComponentColor(addRemoveBar, LEFT_GRAYSCALE);
    
    frame.add(leftPanel,BorderLayout.WEST);
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    
  }
}
