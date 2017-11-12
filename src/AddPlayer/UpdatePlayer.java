package AddPlayer;

import client.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainview.MainView;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author phant
 */
public class UpdatePlayer {

    private MainView mainView;
    private JButton btnUpdatePlayer;
    private JTable table;
    private Client client;
    private UpdatePlayerDialog updatePlayerDialog;

    public UpdatePlayer(MainView mainView, Client client) {
        this.mainView = mainView;
        this.client = client;
        btnUpdatePlayer = mainView.getFuncEmployeePanel().getBtnSua();
        table = mainView.getTableEmployeePanel().getTable();
        setEvent();
    }

    public void setEvent() {
        btnUpdatePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null, "Ban chua chon dong de cap nhat", "Loi cap nhat", JOptionPane.WARNING_MESSAGE);
                } else {
                    String ID = String.valueOf(table.getValueAt(row, 0));
                    String name = String.valueOf(table.getValueAt(row, 1));
                    String position = String.valueOf(table.getValueAt(row, 2));
                    String adress = String.valueOf(table.getValueAt(row, 3));
                    String tuoi = String.valueOf(table.getValueAt(row, 4));
                    String luong = String.valueOf(table.getValueAt(row, 5));

                    System.out.println(ID + name + position + adress + tuoi + luong);
                    updatePlayerDialog = new UpdatePlayerDialog(ID, name, position, adress, tuoi, luong, client);
                    updatePlayerDialog.setVisible(true);

                }
            }
        });
    }
}
