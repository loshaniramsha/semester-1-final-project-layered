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
import lk.ijse.FactoryManage.bo.custom.ExportableproductBO;
import lk.ijse.FactoryManage.bo.custom.ProductBO;
import lk.ijse.FactoryManage.bo.custom.TargetBO;
import lk.ijse.FactoryManage.dto.ExportableDto;
import lk.ijse.FactoryManage.dto.ProductDto;
import lk.ijse.FactoryManage.dto.SupplierDto;
import lk.ijse.FactoryManage.dto.TargetDto;
//import lk.ijse.FactoryManage.model.ExportableproductModel;
//import lk.ijse.FactoryManage.model.ProductModel;
//import lk.ijse.FactoryManage.model.SupplierModel;
//import lk.ijse.FactoryManage.model.TargetModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class ExportableproductController {
    public AnchorPane root;
    public TextField txtTargetId;
    public TextField txtProductId;
    public TextField txtStates;
    public TextField txtExportQty;
    public TextField txtAmountExport;
    public TableView tblExportProduct;
    public TableColumn colTargetId;
    public TableColumn colProductId;
    public TableColumn colStates;
    public TableColumn colExportQty;
    public TableColumn colAmountExport;
    public ComboBox cmbTargetId;
    public ComboBox cmbProductId;
    public ComboBox cmbExportqty;
    ExportableproductBO exportableproductBO= (ExportableproductBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.EXPORTABLE);
    TargetBO targetBO= (TargetBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.TARGET);
    ProductBO productBO= (ProductBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.PRODUCT);

    public void initialize() throws Exception {
        loadCmb();
        setCellValueFactory();
        loadAllExportProduct();
    }

    private void loadAllExportProduct() throws Exception {
      //  var model = new ExportableproductModel();
        ObservableList<ExportableDto> obList = FXCollections.observableArrayList();
        List<ExportableDto> dtoList = exportableproductBO.getAllExportable();
        for (ExportableDto dto : dtoList) {
            obList.add(new ExportableDto(dto.getTargetId(), dto.getProductId(), dto.getStatus(), dto.getExportableqty(), dto.getAmountexport()));
        }
        tblExportProduct.setItems(obList);

    }





    private void setCellValueFactory() {
        colTargetId.setCellValueFactory(new PropertyValueFactory<>("targetId"));
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colStates.setCellValueFactory(new PropertyValueFactory<>("status"));
        colExportQty.setCellValueFactory(new PropertyValueFactory<>("Exportableqty"));
        colAmountExport.setCellValueFactory(new PropertyValueFactory<>("amountexport"));

    }

    private void loadCmb() throws Exception {
        cmbTargetId.getItems().clear();
        List<TargetDto> dtoList=targetBO.getAllTarget();
        for (TargetDto dto:dtoList) {
            cmbTargetId.getItems().add(dto.getTargetId());
        }
        cmbProductId.getItems().clear();
        List<ProductDto> dtoList1= productBO.getAllProduct();
        for (ProductDto dto:dtoList1) {
            cmbProductId.getItems().add(dto.getProductId());
        }
        cmbExportqty.getItems().clear();;
        List<TargetDto> dtoList2=targetBO.getAllTarget();
        for (TargetDto dto:dtoList2) {
            cmbExportqty.getItems().add(dto.getTargetAmount());
        }

    }


    public void saveOnAction(ActionEvent event) throws Exception {
        String targetId = (String) cmbTargetId.getValue();
        String productId = (String) cmbProductId.getValue();
        String states = txtStates.getText();
        String exportQty = (String) cmbExportqty.getValue();
        String amountExport = txtAmountExport.getText();// 2431

       /* if (!Pattern.matches("[0-9]",amountExport)){ // regex only numbers
            new Alert(Alert.AlertType.ERROR,"Invalid amount").show();
            return;
        }*/

        try{
            int intExportQty = Integer.parseInt(exportQty);
            int intAmountExport = Integer.parseInt(amountExport);
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Invalid amount").show();
            return;
        }


        // end all validation
        ExportableDto exportableDto = new ExportableDto(targetId,productId,states,exportQty,amountExport);

        boolean isSaved = exportableproductBO.saveExportable(exportableDto);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            clearField();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }




    }

    private void clearField() {
        cmbTargetId.getItems().clear();
        cmbTargetId.getItems().clear();
        txtStates.clear();
        cmbExportqty.getItems().clear();
        txtAmountExport.clear();
    }

    public void deleteOnAction(ActionEvent event) throws Exception {
        String targetId=(String)cmbTargetId.getValue();
      try {
          boolean isDeleted =  exportableproductBO.deleteExportable(targetId);
          if (isDeleted) {
              new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
          } else {
              new Alert(Alert.AlertType.WARNING, "Try Again").show();
          }
      }catch (SQLException | ClassNotFoundException e){
          new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
      }
    }

    public void updateOnAction(ActionEvent event) throws Exception {
        String targetId = (String) cmbTargetId.getValue();
        String productId = (String) cmbProductId.getValue();
        String states = txtStates.getText();
        String exportQty = (String) cmbExportqty.getValue();
        String amountExport = txtAmountExport.getText();
        var Dto=new ExportableDto(targetId,productId,states,exportQty,amountExport);
        boolean isSaved =  exportableproductBO.updateExportable(Dto);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
            clearField();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
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

    public void targetOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/target_form.fxml"));
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

    public void searchOnAction(ActionEvent event) {
        String targetId=cmbTargetId.getValue().toString();
        System.out.println(targetId);
        try {
           ExportableDto exportableDto =  exportableproductBO.searchExportable(targetId);
           if (exportableDto != null) {
               cmbProductId.setValue(exportableDto.getProductId());
               txtStates.setText(exportableDto.getStatus());
               cmbExportqty.setValue(exportableDto.getExportableqty());
               txtAmountExport.setText(exportableDto.getAmountexport());
           } else {
               new Alert(Alert.AlertType.WARNING, "Empty").show();
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

    }

    public void clearOnAction(ActionEvent event) {
        clearField();
    }

    public void confirmOnAction(ActionEvent event) {

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

