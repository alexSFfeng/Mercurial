package mercurial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
public class LeftUI {

  // left portion of the UI
  private JPanel leftPanel,leftPanelTop,leftPanelBot,leftPanelBotTop;
  private JScrollPane leftScroll;
  private JLabel myProductivity;
  private JToolBar addRemoveBar;
  private JButton addButtonLP, removeButtonLP, selectButton;
  private JMenu sortLP;

  // List of priority goals
  /*
   * private JList priorityList; private DefaultListModel<boxTextArea> model;
   * private DefaultListSelectionModel selectModel;
   */

  // appearance constants
  private static final int BORDER_STROKE = 3;
  private static final int LEFT_GRAYSCALE = 91;
  private static final int BORDER_PADDING = 10;
  
  @SuppressWarnings("unchecked")
  public LeftUI (Mercurial frame){
    
    // left panel initializations
    leftPanel = new JPanel(new BorderLayout());
    leftPanelTop = new JPanel();
    leftPanelBot = new JPanel(new BorderLayout());
    leftPanelBotTop = new JPanel();
    leftPanelBotTop.setLayout(new BoxLayout(leftPanelBotTop, BoxLayout.Y_AXIS));
    // model = new DefaultListModel<boxTextArea>();
    // selectModel = new DefaultListSelectionModel();
    // priorityList = new JList<boxTextArea>(model);
    leftScroll = new JScrollPane(leftPanelBotTop);
    myProductivity = new JLabel("Priority Tasks/Reminders: ");
    frame.setHeaderFont(myProductivity);
    
    // scroll pane modifications
    leftScroll
        .setBorder(BorderFactory.createLineBorder(Color.BLACK, BORDER_STROKE));

    // List appearances
    /*
     * priorityList.setCellRenderer(new boxTextCellRender());
     * priorityList.setFixedCellWidth(SLOT_WIDTH);
     * priorityList.setFixedCellHeight(SLOT_HEIGHT);
     * 
     * // List selection settings priorityList.setSelectionModel(selectModel);
     * selectModel.addListSelectionListener(new ListSelectionListener() {
     * 
     * @Override public void valueChanged(ListSelectionEvent e) { int
     * selectedIndex = priorityList.getSelectedIndex();
     * 
     * model.getElementAt(selectedIndex).setSelected(true);
     * model.getElementAt(selectedIndex).getFocus();
     * 
     * }
     * 
     * });
     */

    // components for left bottom panel
    addRemoveBar = new JToolBar();
    addButtonLP = new JButton("+");
    removeButtonLP = new JButton("-");
    selectButton = new JButton("Select All");
    sortLP = new JMenu("SORT");
    
    // adding components to frame
    frame.addToolBars(leftPanelBot, addButtonLP, removeButtonLP, selectButton,
        sortLP, addRemoveBar);
    leftPanelBot.add(leftScroll);
    
    leftPanelTop.add(myProductivity);
    leftPanel.add(leftPanelTop,BorderLayout.NORTH);
    leftPanel.add(leftPanelBot);
    
    // color settings
    leftPanel.setBorder(new EmptyBorder(BORDER_PADDING,BORDER_PADDING,
                                        BORDER_PADDING,BORDER_PADDING));
    
    frame.setComponentColor(leftPanel, LEFT_GRAYSCALE);
    frame.setComponentColor(leftPanelBot, LEFT_GRAYSCALE);
    frame.setComponentColor(leftPanelBotTop, LEFT_GRAYSCALE);
    frame.setComponentColor(addRemoveBar, LEFT_GRAYSCALE);
    
    frame.add(leftPanel,BorderLayout.WEST);
    
    // listen to button actions
    addButtonLP.addActionListener(new AddButton());
    removeButtonLP.addActionListener(new RemoveButton());
    selectButton.addActionListener(new SelectButton());

  }

  private class AddButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("HI");
      new boxTextArea(leftPanelBotTop);
      leftPanelBotTop.revalidate();
    }
  }

  private class RemoveButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      // remove all the selected boxes
      for (int i = 0; i < leftPanelBotTop.getComponentCount(); i++) {

      }

    }

  }

  private class SelectButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {



    }
    
  }

}
