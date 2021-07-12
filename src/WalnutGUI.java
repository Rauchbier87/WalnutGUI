import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class WalnutGUI extends JFrame {
    static JTextArea area;
    private static ArrayList<String> cups = new ArrayList<>();
    Icon c = new ImageIcon(getClass().getResource("/resources/cup.jpeg"));
    Icon w = new ImageIcon(getClass().getResource("/resources/walnut.jpeg"));

    public WalnutGUI(){
        init();
    }

    public final void init(){
        JPanel p = new JPanel();
        setLayout(new FlowLayout());
        p.setEnabled(true);
        setEnabled(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("The Walnut Game");
        setLocationRelativeTo(null);
        setSize(600,150);
        setVisible(true);
        add(p);

        p.add(Box.createRigidArea(new Dimension(0, 50)));
        area = new JTextArea();
        area.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        area.setText("");
        area.setBackground(Color.LIGHT_GRAY);
        area.setVisible(true);
        area.setSize(20,10);
        area.setAlignmentX(0.5f);
        p.add(area);

        p.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton b1 = new JButton(c);
        b1.setSize(c.getIconWidth(), c.getIconHeight());
        b1.setAlignmentX(0.5f);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               reveal(0);
               if (cups.get(0).equals("Walnut")){b1.setIcon(w);}
               cups.clear();
               revalidate();
            }
        });
        p.add(b1);

        p.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton b2 = new JButton(c);
        b2.setSize(c.getIconWidth(), c.getIconHeight());
        b2.setAlignmentX(0.5f);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               reveal(1);
                if (cups.get(1).equals("Walnut")){b2.setIcon(w);}
                cups.clear();
                revalidate();
            }
        });
        p.add(b2);

        p.add(Box.createRigidArea(new Dimension(0,10)));
        JButton b3 = new JButton(c);
        b3.setSize(c.getIconWidth(), c.getIconHeight());
        b3.setAlignmentX(0.5f);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reveal(2);
                if (cups.get(2).equals("Walnut")){b3.setIcon(w);}
                cups.clear();
                revalidate();
            }
        });
        p.add(b3);

        p.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton b4 = new JButton("Play/Reset");
        b4.setAlignmentX(0.5f);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCups();
                cupSwitch();
                b1.setIcon(c);
                b2.setIcon(c);
                b3.setIcon(c);
                area.setText("Set up cups.\n");
                pause();
                area.append("Which one is the walnut under?");
                revalidate();
            }
        });
        p.add(b4);

        setCups();
        cupSwitch();
        revalidate();
        runIntro();
    }

    private static void setCups(){
        cups.add("Walnut");
        cups.add("Empty");
        cups.add("Empty");
    }

    private static void cupSwitch(){
        Collections.shuffle(cups);
    }

    public static void runIntro(){
        area.setText("Welcome to the walnut game!\n");
        pause();
        area.append("Press play to start \nor reset between matches");
        pause();
        area.append("\nEnjoy!");
    }

    public static void pause(){
        try{Thread.sleep(1000);}catch(Exception e){}
    }

    public static void reveal(Integer cup){
        if (cups.get(cup).equals("Walnut")){
            area.setText("\n"+cups.get(cup)+": lucky guess!");
        }else {
            area.setText("\n"+cups.get(cup)+": better luck next time!");
        }
    }

    public static void main(String[] args){
        new WalnutGUI();
    }
}
