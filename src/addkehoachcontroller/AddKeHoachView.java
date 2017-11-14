
package addkehoachcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import mainview.FunKeHoachPanel;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class AddKeHoachView {

    private MainView mainView;
    private JPanel tablePanel;
    private JButton btnAdd;
    private KeHoachView keHoachView;
    private JPanel smallPanel ;
    private FunKeHoachPanel funKeHoachPanel;
    public AddKeHoachView(MainView mainView) {
        this.mainView = mainView ;
        tablePanel = mainView .getTablePanel();
        btnAdd = mainView.getChoiceView().getBtnKeHoach();
        keHoachView = mainView.getKeHoachView();
        smallPanel = mainView.getSmallPanel();
        funKeHoachPanel = mainView.getFunKeHoachPanel();
        setEvent();
    }
    
    public void setEvent(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.removeAll();
                tablePanel.add(keHoachView);
                tablePanel.validate();
                tablePanel.repaint();
                
                
                smallPanel.removeAll();
                smallPanel.add(funKeHoachPanel);
                smallPanel.validate();
                smallPanel.repaint();
                
            }
        });
    }
}
