package addkehoachcontroller;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mainview.MainView;

/**
 *
 * @author phant
 */
public class ShowDataKeHoachController {

    private MainView mainView;
    private JButton showData;
    private Client client;

    public ShowDataKeHoachController(MainView mainView, Client client) {
        this.mainView = mainView;
        this.client = client;
        showData = mainView.getChoiceView().getBtnKeHoach();
        setEvent();
    }

    public void setEvent() {
        showData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.getPw().println("show data kehoach");
                client.getPw().flush();
            }
        });
    }
}
