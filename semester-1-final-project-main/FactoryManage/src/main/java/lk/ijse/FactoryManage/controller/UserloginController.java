package lk.ijse.FactoryManage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.FactoryManage.Mail.Mail;
import lk.ijse.FactoryManage.bo.BoFactory;
import lk.ijse.FactoryManage.bo.custom.UserBO;
import lk.ijse.FactoryManage.bo.custom.UserloginBO;
import lk.ijse.FactoryManage.dto.UserDto;
import lk.ijse.FactoryManage.dto.UserloginDto;
//import lk.ijse.FactoryManage.model.UserModel;
//import lk.ijse.FactoryManage.model.UserloginModel;

import java.io.IOException;

public class UserloginController {
    public AnchorPane root;
    public TextField textUserName;
    public TextField textPassWord;
    public AnchorPane ancCreateAcount;

    @FXML
    private TextField txtCreateUserBranch;

    @FXML
    private TextField txtCreateUserName;

    @FXML
    private TextField txtCreateUserPassword;

    @FXML
    private TextField txtCreateUserPost;
    UserBO userBO= (UserBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.USER);
    UserloginBO userloginBO= (UserloginBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.USERLOGIN);

    public void initialize() {
        ancCreateAcount.setVisible(false);
    }


    public void loginOnAction(ActionEvent event) throws Exception {

//        String password=dto.getPassword();
//        dto.getUserName();

        String usr = textUserName.getText();
        String pw = textPassWord.getText();
        UserloginDto dto = new UserloginDto(usr,pw);

        if(!usr.isEmpty() || !pw.isEmpty()){
        if (userloginBO.verifyUser(dto)) {
//new Alert(Alert.AlertType.CONFIRMATION, "Login").show();

            AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
            Scene scene=new Scene(anchorPane);
            Stage stage=(Stage)root.getScene().getWindow();
            stage.setScene(scene);

            Stage.getWindows();
            stage.centerOnScreen();


            //mail send

            Mail mail = new Mail();
            mail.setMsg("Login successful..!");
            mail.setTo(usr);
            mail.setSubject("Factory Manage");


            Thread thread = new Thread(mail);
            thread.start();

        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid User").show();}
        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid User").show();
        }
    }


    public void backOnAction(ActionEvent event) throws IOException {
        System.exit(0);

    }

    public void lblCreateNewAccount(MouseEvent mouseEvent) {
        ancCreateAcount.setVisible(true);
    }

    public void createAccountOnAction(ActionEvent event) throws Exception {
        String userName = txtCreateUserName.getText();
        String post = txtCreateUserPost.getText();
        String branch = txtCreateUserBranch.getText();
        String password = txtCreateUserPassword.getText();

        // validate fields

        if (userName == null){
            new Alert(Alert.AlertType.ERROR,"username can't empty").show();
            return;
        }

        String userId = userBO.generateNextUserId();

        UserDto userDto = new UserDto(
                userId,
                post,
                userName,
                branch,
                password
        );

        if (userBO.saveUser(userDto)){
            new Alert(Alert.AlertType.INFORMATION,"User Account created..!").show();
            txtCreateUserBranch.setText(null);
            txtCreateUserPassword.setText(null);
            txtCreateUserName.setText(null);
            txtCreateUserPost.setText(null);
        }else {
            new Alert(Alert.AlertType.WARNING,"User Account creation fail..!").show();
        }
    }

    public void ExitOnAction(ActionEvent event) {
        ancCreateAcount.setVisible(false);
        root.setVisible(true);
    }
}
