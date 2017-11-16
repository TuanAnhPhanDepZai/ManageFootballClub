package mainview;

import AddThanhTichView.ThanhTichPanel;
import BanLanhDaoView.BanLanhDaoView;
import addkehoachcontroller.KeHoachView;
import cosovachatcontroller.CosoVatChatPanel;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MainView extends JFrame {

	
	private ChoiceView choiceView ;
	private FuncPlayerPanel funcEmployeePanel;
	private TablePlayerPanel tableEmployeePanel ;
	private JPanel mainPanel;
	private JPanel tablePanel;
        private BanLanhDaoView banLanhDaoView;
	private ThanhTichPanel thanhTichPanel;
        private KeHoachView keHoachView;
        private CosoVatChatPanel cosoVatChatPanel;
        private PanelImage panelImage ;
        private JPanel smallPanel ;
        private boolean isDisplayImage = false ;
        private FuncBanLanhDaoPanel funcBanLanhDaoPanel;
        private FunThanhTichPanel funThanhTichPanel ;
        private FunKeHoachPanel funKeHoachPanel;
        private FunCosoVatchatPanel funCosoVatchatPanel ;
        
	public MainView() {
                this.setLayout(new BorderLayout());
                
                choiceView = new ChoiceView();
                
                
		funcEmployeePanel = new  FuncPlayerPanel();
                funcBanLanhDaoPanel = new FuncBanLanhDaoPanel();
                funThanhTichPanel = new FunThanhTichPanel();
                funKeHoachPanel = new FunKeHoachPanel();
                funCosoVatchatPanel = new FunCosoVatchatPanel();
                
                tableEmployeePanel = new TablePlayerPanel();
                                
                banLanhDaoView = new BanLanhDaoView();
                thanhTichPanel = new ThanhTichPanel();
                keHoachView = new KeHoachView();
                cosoVatChatPanel = new CosoVatChatPanel();
                panelImage = new PanelImage();
                smallPanel = new JPanel();
               
                
		add(choiceView,BorderLayout.WEST);
               // add(funcEmployeePanel,BorderLayout.NORTH);
                add(createMainPanel(),BorderLayout.CENTER);
                
                
		setTitle("Quan li doi bong");
		setLocation(200, 0);
		setResizable(true);
		setSize(1000, 700);
		      
		       //   setVisible(true);
        }

        private JPanel createMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(20,20));
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(tableEmployeePanel);
		
		smallPanel = new JPanel();
		smallPanel.setLayout(new BorderLayout());
		smallPanel.add(funcEmployeePanel, BorderLayout.CENTER);
		
                
		mainPanel.add(tablePanel,BorderLayout.CENTER);
		mainPanel.add(smallPanel,BorderLayout.NORTH);
		
		return mainPanel;
	}
        
        private JPanel createSmallPanel(){
            smallPanel.add(funcEmployeePanel);
            return smallPanel;
        }
    public ChoiceView getChoiceView() {
        return choiceView;
    }

    public void setChoiceView(ChoiceView choiceView) {
        this.choiceView = choiceView;
    }

    public FuncPlayerPanel getFuncEmployeePanel() {
        return funcEmployeePanel;
    }

    public void setFuncEmployeePanel(FuncPlayerPanel funcEmployeePanel) {
        this.funcEmployeePanel = funcEmployeePanel;
    }

    public TablePlayerPanel getTableEmployeePanel() {
        return tableEmployeePanel;
    }

    public void setTableEmployeePanel(TablePlayerPanel tableEmployeePanel) {
        this.tableEmployeePanel = tableEmployeePanel;
    }

    public JPanel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JPanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    public BanLanhDaoView getBanLanhDaoView() {
        return banLanhDaoView;
    }

    public void setBanLanhDaoView(BanLanhDaoView banLanhDaoView) {
        this.banLanhDaoView = banLanhDaoView;
    }

    public ThanhTichPanel getThanhTichPanel() {
        return thanhTichPanel;
    }

    public void setThanhTichPanel(ThanhTichPanel thanhTichPanel) {
        this.thanhTichPanel = thanhTichPanel;
    }

    public KeHoachView getKeHoachView() {
        return keHoachView;
    }

    public void setKeHoachView(KeHoachView keHoachView) {
        this.keHoachView = keHoachView;
    }
        
    
     public static void main(String[] args) {
        new MainView();
    }

    public CosoVatChatPanel getCosoVatChatPanel() {
        return cosoVatChatPanel;
    }

    public void setCosoVatChatPanel(CosoVatChatPanel cosoVatChatPanel) {
        this.cosoVatChatPanel = cosoVatChatPanel;
    }

    public PanelImage getPanelImage() {
        return panelImage;
    }

    public void setPanelImage(PanelImage panelImage) {
        this.panelImage = panelImage;
    }

    public boolean isIsDisplayImage() {
        return isDisplayImage;
    }

    public void setIsDisplayImage(boolean isDisplayImage) {
        this.isDisplayImage = isDisplayImage;
    }

    public JPanel getSmallPanel() {
        return smallPanel;
    }

    public void setSmallPanel(JPanel smallPanel) {
        this.smallPanel = smallPanel;
    }

    public FuncBanLanhDaoPanel getFuncBanLanhDaoPanel() {
        return funcBanLanhDaoPanel;
    }

    public void setFuncBanLanhDaoPanel(FuncBanLanhDaoPanel funcBanLanhDaoPanel) {
        this.funcBanLanhDaoPanel = funcBanLanhDaoPanel;
    }

    public FunThanhTichPanel getFunThanhTichPanel() {
        return funThanhTichPanel;
    }

    public void setFunThanhTichPanel(FunThanhTichPanel funThanhTichPanel) {
        this.funThanhTichPanel = funThanhTichPanel;
    }

    public void setFunKeHoachPanel(FunKeHoachPanel funKeHoachPanel) {
        this.funKeHoachPanel = funKeHoachPanel;
    }

    public FunKeHoachPanel getFunKeHoachPanel() {
        return funKeHoachPanel;
    }

    public FunCosoVatchatPanel getFunCosoVatchatPanel() {
        return funCosoVatchatPanel;
    }

    public void setFunCosoVatchatPanel(FunCosoVatchatPanel funCosoVatchatPanel) {
        this.funCosoVatchatPanel = funCosoVatchatPanel;
    }
     
     
	
                
}


	


	

	


	

	

	
	


	

	
	