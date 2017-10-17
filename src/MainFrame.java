import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH = 150,screenW,screenH;
    private JLabel jlabelID = new JLabel("ID : ");
    private JLabel jlabelPW = new JLabel("Password : ");
    private JTextField jtxID = new JTextField();
    private JPasswordField jpPW = new JPasswordField();
    private JButton jbtnExit = new JButton("Exit");
    private JButton jbtnLogin = new JButton("Login");
    private Container cp;
    private String Name = "h304";
    private String Password = "23323456";
    public MainFrame(){
        init();
    }
    private void init(){
        screenW = dim.width;
        screenH = dim.height;
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,1,1));
        jlabelID.setHorizontalAlignment(SwingConstants.RIGHT);
        jlabelPW.setHorizontalAlignment(SwingConstants.RIGHT);
        jpPW.setEchoChar('@');
        cp.add(jlabelID);
        cp.add(jtxID);
        cp.add(jlabelPW);
        cp.add(jpPW);
        cp.add(jbtnLogin);
        cp.add(jbtnExit);

        //control
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jbtnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtxID.getText().equals(Name) && (new String (jpPW.getPassword())).equals(Password)){
                    MainFrame2 mf2 = new MainFrame2(MainFrame.this);
                    mf2.setVisible(true);
                    MainFrame.this.setVisible(false);
                    jtxID.setText("");
                    jpPW.setText("");
                    //dispose();
                }else{
                    if(!jtxID.getText().equals(Name)){
                        JOptionPane.showMessageDialog(MainFrame.this,"ID is wrong!!!!!");
                    }else if(!(new String (jpPW.getPassword())).equals(Password)){
                        JOptionPane.showMessageDialog(MainFrame.this,"Password is wrong !!");
                    }

                }
            }
        });

    }
}
