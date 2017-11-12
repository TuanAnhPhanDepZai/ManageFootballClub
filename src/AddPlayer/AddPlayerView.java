/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import mainview.MainView;
import mainview.PanelImage;

public class AddPlayerView {

    private JButton addView;
    private JPanel view;
    private MainView mainView;
    private JPanel tablePanel;
    private PanelImage panelImage;
    
    public AddPlayerView(MainView mainView) {
        this.mainView = mainView;
        tablePanel = mainView.getTablePanel();
        addView = mainView.getChoiceView().getBtnPlayer();
        view = mainView.getTableEmployeePanel();
        panelImage = mainView.getPanelImage();
        setEvent();
    }
    
    private void setEvent() {
        addView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                mainView.getFuncEmployeePanel().setVisible(true);
                tablePanel.removeAll();
                tablePanel.add(view);
                tablePanel.validate();
                tablePanel.repaint();
            }
        });
    }
}
