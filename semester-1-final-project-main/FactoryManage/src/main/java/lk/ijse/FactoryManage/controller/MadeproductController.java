package lk.ijse.FactoryManage.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.FactoryManage.bo.BoFactory;
import lk.ijse.FactoryManage.bo.custom.EmployeeBO;
import lk.ijse.FactoryManage.bo.custom.MadeproductBO;
import lk.ijse.FactoryManage.bo.custom.ProductBO;
import lk.ijse.FactoryManage.bo.custom.TargetBO;
import lk.ijse.FactoryManage.dto.EmployeeDto;
import lk.ijse.FactoryManage.dto.Madeproductdto;
import lk.ijse.FactoryManage.dto.ProductDto;
import lk.ijse.FactoryManage.dto.TargetDto;
//import lk.ijse.FactoryManage.model.EmployeeModel;
//import lk.ijse.FactoryManage.model.MadeproductModel;
//import lk.ijse.FactoryManage.model.ProductModel;
//import lk.ijse.FactoryManage.model.TargetModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class MadeproductController {
    public AnchorPane root;
    public TextField txtTargetAmount;
    public TextField txtProductId;
    public TextField txtEmployId;
    public TextField txtCompletAmount;
    public TableView tblMadeProduct;
    public TableColumn colTargetAmount;
    public TableColumn colproductId;
    public TableColumn colEmployeeId;
    public TableColumn colCompleteAmount;
    public TextField texrProductname;
    public TableColumn colProductname;
    public ComboBox cmbTagetamount;
    public ComboBox cmbProductId;
    public ComboBox cmbEmployeeId;

    MadeproductBO madeproductBO= (MadeproductBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.MADEPRODUCT);
    ProductBO productBO= (ProductBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.PRODUCT);
    TargetBO targetBO= (TargetBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.TARGET);
    EmployeeBO employeeBO= (EmployeeBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.EMPLOYEE);

public void initialize() throws Exception {
    loardCmb();
    setCellValueFactory();
    loardAllMadeProduct();
}

    private void loardAllMadeProduct() throws Exception {
       // var model = new MadeproductModel();
        ObservableList<Madeproductdto> obList = FXCollections.observableArrayList();
        List<Madeproductdto> dtoList = madeproductBO.getAllMadeproduct();
        for (Madeproductdto dto : dtoList) {
            obList.add(new Madeproductdto(dto.getTargetAmount(), dto.getProductId(), dto.getEmployeeId(), dto.getCompleteAmount()));
        }
        tblMadeProduct.setItems(obList);
    }

    private void setCellValueFactory() {
    colTargetAmount.setCellValueFactory(new PropertyValueFactory<>("targetAmount"));
    colproductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
    colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
    colCompleteAmount.setCellValueFactory(new PropertyValueFactory<>("completeAmount"));
    //colProductname.setCellValueFactory(new PropertyValueFactory<>("productname"));

    }

    private void loardCmb() throws Exception {
    cmbProductId.getItems().clear();
       // List<ProductDto> allProducts = new ProductModel().getAllProducts();
        List<ProductDto> allProducts = productBO.getAllProduct();
        for (ProductDto productDto : allProducts) {
            cmbProductId.getItems().add(productDto.getProductId());
        }
        cmbTagetamount.getItems().clear();
        List<TargetDto> allProducts1 = targetBO.getAllTarget();
        for (TargetDto targetDto : allProducts1) {
            cmbTagetamount.getItems().add(targetDto.getTargetAmount());
        }

       cmbEmployeeId.getItems().clear();
        List<EmployeeDto> allEmployees = employeeBO.getAllEmployee();
        for (EmployeeDto employeeDto : allEmployees) {
            cmbEmployeeId.getItems().add(employeeDto.getEmployeeId());
        }

    }

    public void saveOnAction(ActionEvent event) throws Exception {
        String targetAmount=cmbTagetamount.getValue().toString();
        String productId=cmbProductId.getValue().toString();
        String employeeId=cmbEmployeeId.getValue().toString();
        String completeAmount=txtCompletAmount.getText();
        Madeproductdto Dto=new Madeproductdto(targetAmount,productId,employeeId,completeAmount);
        boolean isSaved=madeproductBO.saveMadeProduct(Dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
            clearField();
        }
    }

    private void clearField() {
       cmbTagetamount.getItems().clear();
        cmbProductId.getItems().clear();
        cmbEmployeeId.getItems().clear();
        txtCompletAmount.clear();
    }

    public void deleteOnAction(ActionEvent event) throws Exception {
        String productId = cmbProductId.getValue().toString();
       boolean isDeleted = madeproductBO. deleteMadeproduct(productId);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
            clearField();
            clearCollection();
        }
    }

    private void clearCollection() {
    cmbTagetamount.getItems().clear();
        cmbProductId.getItems().clear();
        cmbEmployeeId.getItems().clear();
        txtCompletAmount.clear();
    }

    public void searchOnAction(ActionEvent event)  {
    String productId=cmbProductId.getValue().toString();
    try {
        Madeproductdto Dto=madeproductBO.searchMadeproduct(productId);
        if (Dto!=null){
            cmbTagetamount.getItems().add(Dto.getTargetAmount());
            cmbProductId.getItems().add(Dto.getProductId());
            cmbEmployeeId.getItems().add(Dto.getEmployeeId());
            txtCompletAmount.setText(Dto.getCompleteAmount());
        }else {
            new Alert(Alert.AlertType.WARNING,"Empty").show();
        }
    }catch (Exception e){
        new Alert(Alert.AlertType.WARNING,"Empty").show();
    }
    }

    public void updateOnAction(ActionEvent event) throws Exception {
     String productId=cmbProductId.getValue().toString();
        String targetAmount=cmbTagetamount.getValue().toString();
        String productId1=cmbProductId.getValue().toString();
        String employeeId=cmbEmployeeId.getValue().toString();
        String completeAmount=txtCompletAmount.getText();
        Madeproductdto Dto=new Madeproductdto(targetAmount,productId,employeeId,completeAmount);
        boolean isUpdated=madeproductBO.updateMadeProduct(Dto);
        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
            clearField();
        }
    }

    public void productOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/product_form.fxml"));
        Scene scene=new Scene(anchorPane);
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(scene);

        Stage.getWindows();
        stage.centerOnScreen();
    }


    public void employeeOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/employee_form.fxml"));
        Scene scene=new Scene(anchorPane);
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(scene);

        Stage.getWindows();
        stage.centerOnScreen();
    }

    public void userOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/user_form.fxml"));
        Scene scene=new Scene(anchorPane);
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(scene);

        Stage.getWindows();
        stage.centerOnScreen();
    }


    public void backOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Scene scene=new Scene(anchorPane);
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(scene);

        Stage.getWindows();
        stage.centerOnScreen();
    }

    public void clearOnAction(ActionEvent event) {
    clearField();
    }

    public void lblbackOnAction(MouseEvent mouseEvent) throws Exception {
        URL resource = getClass().getResource("/view/dashboard2_form.fxml");
        assert resource != null;
        try {
            Parent load = FXMLLoader.load(resource);
            root.getChildren().clear();
            root.getChildren().add(load);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    }

