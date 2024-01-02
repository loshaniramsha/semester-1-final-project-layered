package lk.ijse.FactoryManage.dao.impl;

//import jdk.internal.platform.CgroupMetrics;
import lk.ijse.FactoryManage.Entity.Exportable;
import lk.ijse.FactoryManage.Entity.Product;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.ProductDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.Madeproductdto;
import lk.ijse.FactoryManage.dto.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOimpl implements ProductDAO {
  //  public List<ProductDto> getAllIds() throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        PreparedStatement pstm=connection.prepareStatement("SELECT productId FROM product");
//        ResultSet rst=SQLUtil.execute("SELECT productId FROM product");
//        List<Product> list=new ArrayList<>();
//        while (rst.next()){
//           // list.add(rst.getString(1));
//            Product product=new Product(rst.getString(1));
//        }
//        return ;
  //  }


    public  boolean save(Product dto) throws Exception{
//        Connection connection=DbConection.getInstance().getConnection();
//        String sql="INSERT INTO product VALUES(?,?,?,?)";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getProductId());
//        pstm.setObject(2,dto.getName());
//        pstm.setObject(3,dto.getBrand());
//        pstm.setObject(4,dto.getQty());
//        boolean isSaved=pstm.executeUpdate()>0;
        return SQLUtil.execute("INSERT INTO product VALUES(?,?,?,?)",dto.getProductId(),dto.getName(),dto.getBrand(),dto.getQty());
    }

    public  boolean delete(String productId) throws Exception{
//        Connection connection=DbConection.getInstance().getConnection();
//        String sql="DELETE FROM product WHERE productId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,productId);
//        boolean isDeleted=pstm.executeUpdate()>0;
        return SQLUtil.execute("DELETE FROM product WHERE productId=?",productId);
    }

    public  boolean update(Product dto) throws Exception {
//        Connection connection=DbConection.getInstance().getConnection();
//        String sql="UPDATE product SET name=?,brand=?,qty=? WHERE productId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,dto.getName());
//        pstm.setObject(2,dto.getBrand());
//        pstm.setObject(3,dto.getQty());
//        pstm.setObject(4,dto.getProductId());
//        boolean isUpdated=pstm.executeUpdate()>0;
        return SQLUtil.execute("UPDATE product SET name=?,brand=?,qty=? WHERE productId=?",dto.getName(),dto.getBrand(),dto.getQty(),dto.getProductId());
    }

    public  Product search(String productId) throws Exception {
//        Connection connection=DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM product WHERE productId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,productId);
        ResultSet rst=SQLUtil.execute("SELECT * FROM product WHERE productId=?",productId);
        if (rst.next()){
            return new Product(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }
        return null;
    }

    public boolean updateQuantity(Exportable dto) throws Exception {
        String productId = dto.getProductId();
        int qty = Integer.parseInt(dto.getAmountexport());

        Connection connection=DbConection.getInstance().getConnection();
        String sql="UPDATE product SET qty = qty-? WHERE productId=?";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,qty);
        pstm.setObject(2,dto.getProductId());
        boolean isUpdated=pstm.executeUpdate()>0;
        return isUpdated;
    }

    public List<Product> getAll() throws Exception {
//        Connection connection=DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM product";
//        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet rst=SQLUtil.execute("SELECT * FROM product");
        ArrayList<Product> DtoList=new ArrayList<>();
        while (rst.next()){
            DtoList.add(new Product(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
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
        return SQLUtil.execute("INSERT INTO madeproduct VALUES(?,?,?,?)",dto.getTargetAmount(),dto.getProductId(),dto.getEmployeeId(),dto.getCompleteAmount());
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
        return SQLUtil.execute("UPDATE madeproduct SET targetAmount=?,completeAmount=? WHERE productId=?",dto.getTargetAmount(),dto.getCompleteAmount(),dto.getProductId());
    }
}


