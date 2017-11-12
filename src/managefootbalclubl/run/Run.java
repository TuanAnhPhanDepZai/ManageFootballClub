package managefootbalclubl.run;

import AddPlayer.AddPlayerController;
import AddPlayer.AddPlayerView;
import AddPlayer.FindPlayerController;
import AddPlayer.UpdatePlayer;
import AddThanhTichController.*;

import AddThanhTichController.AddThanhTichPanel;
import AddThanhTichController.ShowDataThanhTichCOntroller;
import addBanLanhDaoController.AddBanLanhDaoView;
import ConnectDataBase.ConnectDataBase;
import ShowDataBanLanhDao.ShowDatabanLanhDaoController;
import addkehoachcontroller.AddKeHoachView;
import addkehoachcontroller.ShowDataKeHoachController;
import client.Client;
import client.ClientThread;
import cosovachatcontroller.AddCosovatchatView;
import cosovachatcontroller.ShowCosoVatChatController;
import deleteplayercontroller.DeletePlayer;
import mainview.MainView;
import playercontroller.ShowPlayerController;

public class Run {

    public static void main(String[] args) {
        MainView mainView = new MainView();
        ConnectDataBase connectDataBase = new ConnectDataBase();
        Client client = new Client();
        ClientThread clientThread = new ClientThread(client.getBr(), mainView);

        AddBanLanhDaoView addBanLanhDaoView = new AddBanLanhDaoView(mainView);
        AddPlayerView addPlayerView = new AddPlayerView(mainView);
        AddThanhTichPanel addThanhTichPanel = new AddThanhTichPanel(mainView);
        AddPlayerController addPlayerController = new AddPlayerController(mainView, client);
        AddKeHoachView addKeHoachView = new AddKeHoachView(mainView);
        AddCosovatchatView addCosovatchatView = new AddCosovatchatView(mainView);
        
        ShowPlayerController showPlayerController = new ShowPlayerController(mainView, client);
        ShowDatabanLanhDaoController showDatabanLanhDaoController = new ShowDatabanLanhDaoController(mainView, client);
        ShowDataThanhTichCOntroller showDataThanhTichCOntroller = new ShowDataThanhTichCOntroller(mainView, client);
        ShowDataKeHoachController showDataKeHoachController = new ShowDataKeHoachController(mainView, client);
        ShowCosoVatChatController showCosoVatChatController = new ShowCosoVatChatController(mainView, client);
        
        
        DeletePlayer deletePlayer = new DeletePlayer(mainView, client);

        UpdatePlayer updatePlayer = new UpdatePlayer(mainView, client);
        
        FindPlayerController findPlayerController = new FindPlayerController(mainView, client);
    }
}
