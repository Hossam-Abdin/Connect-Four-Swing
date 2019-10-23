package connect_four;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Grid {
    protected JFrame frame;
    protected JPanel players;
    protected JPanel downButtonsPanel;
    protected JPanel gameGrid;
    protected ArrayList<JButton> downButtonsArrays;
    protected ArrayList<ArrayList <JLabel> > Matrix;
    protected String currentPlayer; 
    
    public Grid(int x, int y){
        currentPlayer = "X";
        frame = new JFrame("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        downButtonsPanel = new JPanel();
        gameGrid = new JPanel();
        gameGrid.setLayout(new GridLayout(y,x));
        downButtonsArrays = new ArrayList();
        for (int i = 0; i < x; i++){
            downButtonsArrays.add(new JButton((new Integer(i+1)).toString()));
            downButtonsArrays.get(i).setPreferredSize(new Dimension(55,55));
            downButtonsPanel.add(downButtonsArrays.get(i));
        }
        Matrix = new ArrayList();
        for(int i = 0; i < y; i++){
            Matrix.add(new ArrayList());
            for (int j = 0; j < x; j++){
                Matrix.get(i).add(new JLabel(""/*+((new Integer(i+1)).toString())+((new Integer(j+1)).toString()),*/,SwingConstants.CENTER));
                Matrix.get(i).get(j).setPreferredSize(new Dimension(55,55));
                Matrix.get(i).get(j).setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                gameGrid.add(Matrix.get(i).get(j),BorderLayout.CENTER);
            }
        }
    frame.getContentPane().add(BorderLayout.NORTH, downButtonsPanel);
    frame.getContentPane().add(BorderLayout.SOUTH, gameGrid);
    frame.add(downButtonsPanel);
    frame.pack();
    frame.setVisible(true);
    frame.setSize(x*100,y*100);
    
    
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu sizeMenu = new JMenu("Size");
        menuBar.add(sizeMenu);
        JMenuItem size8x5 = new JMenuItem("8 x 5");
        JMenuItem size10x6 = new JMenuItem("10 x 6");
        JMenuItem size12x7 = new JMenuItem("12 x 7");

        sizeMenu.add(size8x5);
        sizeMenu.add(size10x6);
        sizeMenu.add(size12x7);
        size8x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new Grid(8,5);
            }
        });
        size10x6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new Grid(10,6);
            }
        });

        size12x7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new Grid(12,7);
            }
        });
        
   
        
        for (int i = 0; i < x; i++){
            downButtonsArrays.get(i).addActionListener(new DownButtonListener(i, y, x));
                    
                    }
        }
    
    public class DownButtonListener implements ActionListener{
    
    final private int i;
    final private int y;
    final private int x;

    DownButtonListener(int i, int y, int x) {
        this.i = i;
        this.y = y;
        this.x = x;
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        int j;
        for (j = y-1; j >= 0; j--){
               if(Matrix.get(j).get(i).getText().equals("")){
                   Matrix.get(j).get(i).setText(currentPlayer);
                   System.out.println(Matrix.get(j).get(i).getText());
                   break;
               }
        }
       if(currentPlayer.equals("X")){
            currentPlayer = "O";
        }else{
            currentPlayer = "X";
        }
    /*boolean isThereWin1 = (i+3 < x) && Matrix.get(j).get(i).getText().equals(Matrix.get(j).get(i+1).getText()) && Matrix.get(j).get(i).getText().equals(Matrix.get(j).get(i+2).getText()) && Matrix.get(j).get(i).getText().equals(Matrix.get(j).get(i+3).getText());    
    boolean isThereWin2 = ((j - 3) >= 0) && Matrix.get(j).get(i).getText().equals(Matrix.get(j-1).get(i).getText()) && Matrix.get(j).get(i).getText().equals(Matrix.get(j-2).get(i).getText()) && Matrix.get(j).get(i).getText().equals(Matrix.get(j-3).get(i).getText());
    boolean isThereWin3 = ((i + 3) < x) && ((j - 3) >=0) && Matrix.get(j).get(i).getText().equals(Matrix.get(j-1).get(i+1).getText()) && Matrix.get(j).get(i).getText().equals(Matrix.get(j-2).get(i+2).getText()) && Matrix.get(j).get(i).getText().equals(Matrix.get(j-3).get(i+3).getText());
    boolean isThereWin = isThereWin1 || isThereWin2 || isThereWin3;
    if(isThereWin){
        System.out.println("HOSSAM!");
    }*/
} 
    }
    
    
    
}

