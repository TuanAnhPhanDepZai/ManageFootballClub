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
import AddThanhTichController.DeleteThanhTich;
import ShowDataBanLanhDao.ShowAllDataBanLanhDao;
import ShowDataBanLanhDao.ShowDatabanLanhDaoController;
import addBanLanhDaoController.AddDataBanLanhDao;
import addBanLanhDaoController.DeleteBanLanhDaoController;
import addBanLanhDaoController.FindDataBanLanhDaoController;
import addBanLanhDaoController.UpdateBanLanhDaoController;
import addkehoachcontroller.AddKeHoachController;
import addkehoachcontroller.AddKeHoachView;
import addkehoachcontroller.DeleteKeHoachController;
import addkehoachcontroller.FindKeHoachController;
import addkehoachcontroller.KeHoachController;
import addkehoachcontroller.ShowDataKeHoachController;
import client.Client;
import client.ClientThread;
import cosovachatcontroller.AddCosovatchatView;
import cosovachatcontroller.AddFacilityController;
import cosovachatcontroller.DeleteFacilityController;
import cosovachatcontroller.FindFacility;
import cosovachatcontroller.ShowCosoVatChatController;
import cosovachatcontroller.ShowdataFacility;
import deleteplayercontroller.DeletePlayer;
import jfreechat.ShowDataThongKeController;
import jfreechat.ShowViewThongKeContrlloer;
import mainview.MainView;
import playercontroller.ShowPlayerController;


public class Run {
    private MainView mainView ;
    private Client client ;
    public Run(MainView mainView, Client client){
        this.mainView = mainView ;
        this.client = client ;
        AddBanLanhDaoView addBanLanhDaoView = new AddBanLanhDaoView(mainView);
        AddPlayerView addPlayerView = new AddPlayerView(mainView);
        AddThanhTichPanel addThanhTichPanel = new AddThanhTichPanel(mainView);
        AddPlayerController addPlayerController = new AddPlayerController(mainView, client);
        AddKeHoachView addKeHoachView = new AddKeHoachView(mainView);
        AddCosovatchatView addCosovatchatView = new AddCosovatchatView(mainView);
        AddKeHoachController addKeHoachController = new AddKeHoachController(client, mainView);
        AddDataBanLanhDao addDataBanLanhDao = new AddDataBanLanhDao(client, mainView);
        AddFacilityController addFacilityController = new AddFacilityController(client, mainView);
        
        
        ShowPlayerController showPlayerController = new ShowPlayerController(mainView, client);
        ShowDatabanLanhDaoController showDatabanLanhDaoController = new ShowDatabanLanhDaoController(mainView, client);
        ShowDataThanhTichCOntroller showDataThanhTichCOntroller = new ShowDataThanhTichCOntroller(mainView, client);
        ShowDataKeHoachController showDataKeHoachController = new ShowDataKeHoachController(mainView, client);
        ShowCosoVatChatController showCosoVatChatController = new ShowCosoVatChatController(mainView, client);
        ShowAllDataBanLanhDao showAllDataBanLanhDao = new ShowAllDataBanLanhDao(client, mainView);
        ShowAllThanhTich showAllThanhTich = new ShowAllThanhTich(mainView, client);
        ShowViewThongKeContrlloer showViewThongKeContrlloer = new ShowViewThongKeContrlloer(mainView);
        ShowDataThongKeController showDataThongKeController = new ShowDataThongKeController(mainView, client);
        
        
        KeHoachController keHoachController = new KeHoachController(mainView, client);
        ShowdataFacility showdataFacility = new ShowdataFacility(mainView,client);
        
        
        DeletePlayer deletePlayer = new DeletePlayer(mainView, client);
        DeleteBanLanhDaoController deleteBanLanhDaoController = new DeleteBanLanhDaoController(client, mainView);
        DeleteThanhTich deleteThanhTich = new DeleteThanhTich(client, mainView);
        DeleteKeHoachController deleteKeHoachController = new DeleteKeHoachController(mainView, client);
        DeleteFacilityController deleteFacilityController = new DeleteFacilityController(mainView, client);
        
        UpdatePlayer updatePlayer = new UpdatePlayer(mainView, client);
        UpdateBanLanhDaoController updateBanLanhDaoController = new UpdateBanLanhDaoController(mainView, client) ;
        
        FindPlayerController findPlayerController = new FindPlayerController(mainView, client);
        FindDataBanLanhDaoController findDataBanLanhDaoController = new FindDataBanLanhDaoController(client, mainView);
        FindThanhTichController findThanhTichController = new FindThanhTichController(mainView, client);
        FindKeHoachController findKeHoachController = new FindKeHoachController(client, mainView);
        FindFacility findFacility = new FindFacility(client, mainView);
        
        
    }
    
}
