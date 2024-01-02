package lk.ijse.FactoryManage.bo.impl;

//import jdk.internal.platform.CgroupMetrics;
import lk.ijse.FactoryManage.Entity.Exportable;
import lk.ijse.FactoryManage.Entity.Product;
import lk.ijse.FactoryManage.bo.custom.ProductBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.ProductDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.ExportableDto;
import lk.ijse.FactoryManage.dto.Madeproductdto;
import lk.ijse.FactoryManage.dto.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductBOimpl implements ProductBO {

ProductDAO productDAO= (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);

    public  boolean saveProduct(ProductDto dto) throws Exception{
        return productDAO.save(new Product(dto.getProductId(),dto.getName(),dto.getBrand(),dto.getQty()));
    }

    public  boolean deleteProduct(String productId) throws Exception{

        return productDAO.delete(productId);
    }

    public  boolean updateProduct(ProductDto dto) throws Exception {

        return productDAO.update(new Product(dto.getProductId(),dto.getName(),dto.getBrand(),dto.getQty()));
    }

    public  ProductDto searchProduct(String productId) throws Exception {

         Product product= productDAO.search(productId);
        return new ProductDto(product.getProductId(),product.getName(),product.getBrand(),product.getQty());
    }

    //**************************************************************************
    public boolean updateQuantity(ExportableDto dto) throws Exception {
        Exportable ent = new Exportable(dto.getTargetId(),dto.getProductId(),dto.getStatus(),dto.getExportableqty(),dto.getAmountexport());

        return productDAO.updateQuantity(ent);
    }
//***********************************************************************************************************************
    public List<ProductDto> getAllProduct() throws Exception {
       List<Product> all = productDAO.getAll();
        ArrayList<ProductDto> DtoList=new ArrayList<>();
        for (Product product : all) {
            DtoList.add(new ProductDto(product.getProductId(),product.getName(),product.getBrand(),product.getQty()));
        }
        return DtoList;
    }

    public boolean saveMadeProduct(Madeproductdto dto) throws Exception {
//        Connection connection=DbConection.getInstance().getConnection();
//        String sql="INSERT INTO madeproduct VALUES(?,?,?,?)";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getTargetAmount());
//        pstm.setObject(2,dto.getProductId());
//        pstm.setObject(3,dto.getEmployeeId());
//        pstm.setObject(4,dto.getCompleteAmount());
//        boolean isSaved=pstm.executeUpdate()>0;
        return productDAO.saveMadeProduct(dto)  ;
    }

    public boolean updateMadeProduct(Madeproductdto dto) throws Exception{
//        Connection connection=DbConection.getInstance().getConnection();
//        String sql="UPDATE madeproduct SET targetAmount=?,targetAmount=? WHERE productId=? ";
//      //  String sql="UPDATE madeproduct SET targetAmount=?,completeAmount=? WHERE productId=? AND employeeId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getTargetAmount());
//      //  pstm.setObject(2,dto.getCompleteAmount());
//        pstm.setObject(3,dto.getProductId());
//     //   pstm.setObject(4,dto.getEmployeeId());
//        boolean isUpdated=pstm.executeUpdate()>0;
        return productDAO.updateMadeProduct(dto);
    }
    //    public  List<Product> getAll() throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        PreparedStatement pstm=connection.prepareStatement("SELECT productId FROM product");
//        ResultSet rst=pstm.executeQuery();
//        List<Product> list=new ArrayList<>();
//        while (rst.next()){
//            list.add(rst.getString(1));
//        }
//        return list;
//    }
}


