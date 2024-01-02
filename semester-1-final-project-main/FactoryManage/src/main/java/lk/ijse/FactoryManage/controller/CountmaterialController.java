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
import lk.ijse.FactoryManage.Regex.Regex;
import lk.ijse.FactoryManage.bo.BoFactory;
import lk.ijse.FactoryManage.bo.custom.CountmaterialBO;
import lk.ijse.FactoryManage.bo.custom.MaterialBO;
import lk.ijse.FactoryManage.bo.custom.ProductBO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.MaterialDto;
import lk.ijse.FactoryManage.dto.ProductDto;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
//import java.util.List;import lk.ijse.FactoryManage.model.CountmaterialModel;
//import lk.ijse.FactoryManage.model.MaterialModel;
//import lk.ijse.FactoryManage.model.ProductModel;

public class CountmaterialController {
    public AnchorPane root;
    public ComboBox<String> combMaterialId;
    public ComboBox<String> combProductId;
    public TextField txtAmountUsed;
    public TableColumn colMaterialId;
    public TableColumn colamountUsed;
    public TableColumn colProductId;
    public TableView tblCountmaterial;

    CountmaterialBO countmaterialBO= (CountmaterialBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.COUNTMATERIAL);
    MaterialBO materialBO= (MaterialBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.MATERIAL);
    ProductBO productBO= (ProductBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.PRODUCT);

    public void initialize() throws Exception {
        loadCmb();
        setCellValueFactory();
        loardAllMaterials();
    }

    private void setCellValueFactory() {
        colMaterialId.setCellValueFactory(new PropertyValueFactory<>("materialId"));
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colamountUsed.setCellValueFactory(new PropertyValueFactory<>("ammountuse"));
    }

    private void loardAllMaterials() {
        // CountmaterialBO model = new CountmaterialModel();
         try {
             ObservableList<CountmaterialDto> obList = FXCollections.observableArrayList();
             //List<CountmaterialDto> dtoList = model.getAllCountmaterial();
             List<CountmaterialDto> dtoList = countmaterialBO.getAllCountmaterial();
             for (CountmaterialDto dto : dtoList) {
                 obList.add(new CountmaterialDto(dto.getMaterialId(), dto.getProductId(), dto.getAmmountuse() ));
             }
             tblCountmaterial.setItems(obList);
        } catch (Exception e) {
             throw new RuntimeException(e);
         }


    }

    private void loadCmb() throws Exception {

        combMaterialId.getItems().clear();
        List<MaterialDto> alMaterialDtoList  = materialBO.getAllMaterial();
        for (MaterialDto materialDto:alMaterialDtoList) {
            combMaterialId.getItems().add(materialDto.getMaterialId());

        }
        combProductId.getItems().clear();
        List<ProductDto> allProductIds  = productBO.getAllProduct();
        for (ProductDto productId:allProductIds) {
            combProductId.getItems().add(productId.getProductId());

        }
    }

    public void saveOnAction(ActionEvent event) throws Exception {
            String matirialId = combMaterialId.getValue();
            String productId = combProductId.getValue();
            String ammountuse = txtAmountUsed.getText();

            CountmaterialDto countmaterialDto = new CountmaterialDto(matirialId, productId, ammountuse);

        if (countmaterialBO.saveCountmaterial(countmaterialDto)){
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            loardAllMaterials();

        }
    }

    public void searchOnAction(ActionEvent event)  {
    String matirialId = combMaterialId.getValue();
    try {
        CountmaterialDto countmaterialDto = countmaterialBO.searchCountmaterial(matirialId);
        if (countmaterialDto != null) {
            combMaterialId.setValue(countmaterialDto.getMaterialId());
            combProductId.setValue(countmaterialDto.getProductId());
            txtAmountUsed.setText(countmaterialDto.getAmmountuse());
        }else {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        }
    }catch (Exception e){
        new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
    }


    }

    public void updateOnAction(ActionEvent event) throws Exception {
        String matirialId = combMaterialId.getValue();
        String productId = combProductId.getValue();
        String ammountuse = txtAmountUsed.getText();
        CountmaterialDto countmaterialDto = new CountmaterialDto(matirialId, productId, ammountuse);
        if (countmaterialBO.updateCountmaterial(countmaterialDto)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
            loardAllMaterials();
        }
    }

    public void deleteOnAction(ActionEvent event) throws Exception{
        String materialId = combMaterialId.getValue();
        if (countmaterialBO.deleteCountmaterial(materialId)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted"+materialId).show();
        }
    }

    public void clearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        combMaterialId.getSelectionModel().clearSelection();
        combProductId.getSelectionModel().clearSelection();
        txtAmountUsed.clear();
    }

    public void materialOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/material_form.fxml"));
        Scene scene=new Scene(anchorPane);
        Stage stage=(Stage)root.getScene().getWindow();
        stage.setScene(scene);

        Stage.getWindows();
        stage.centerOnScreen();
    }

    public void productOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/product_form.fxml"));
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

    public void cmbMaterialOnAction(ActionEvent event) throws Exception {
//        URL resource = getClass().getResource("/view/dashboard2_form.fxml");
//        assert resource != null;
//        try {
//            Parent load = FXMLLoader.load(resource);
//            root.getChildren().clear();
//            root.getChildren().add(load);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }


    public void lblBackOnAction(MouseEvent mouseEvent) {
    }
}
