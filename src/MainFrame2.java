import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame2 extends JFrame{
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 400,frmH = 300,screenW,screenH;
    private JTextField jtx = new JTextField();
    private JButton jbtn[] = new JButton[9];
    private JPanel jpn = new JPanel(new GridLayout(3,3,1,1));
    private Container cp;
    private MainFrame mf;
    public MainFrame2(MainFrame mframe){
        mf = mframe;
        init();
    }
    private void init(){
        screenW = dim.width;
        screenH = dim.height;
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mf.setVisible(true);
                dispose();
            }
        });
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jtx,BorderLayout.NORTH);
        cp.add(jpn,BorderLayout.CENTER);
        jtx.setEditable(false);
        for(int i = 0;i<9;i++){
            jbtn[i] = new JButton();
            jpn.add(jbtn[i]);
            jbtn[i].setText(Integer.toString(i));
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmp = (JButton) e.getSource();
                    jtx.setText(jtx.getText()+tmp.getText());

                }
            });
        }
    }
}
