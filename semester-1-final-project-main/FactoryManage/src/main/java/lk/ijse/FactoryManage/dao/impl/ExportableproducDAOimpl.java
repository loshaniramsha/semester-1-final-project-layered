package lk.ijse.FactoryManage.dao.impl;

import lk.ijse.FactoryManage.Entity.Employee;
import lk.ijse.FactoryManage.Entity.Exportable;
import lk.ijse.FactoryManage.dao.SQLUtil;
import lk.ijse.FactoryManage.dao.custom.ExportableproductDAO;
import lk.ijse.FactoryManage.db.DbConection;
import lk.ijse.FactoryManage.dto.EmployeeDto;
import lk.ijse.FactoryManage.dto.ExportableDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExportableproducDAOimpl implements ExportableproductDAO {


    public boolean save(Exportable dto) throws Exception {
//
//
//            String sql = "INSERT INTO exportableproduct VALUES(?,?,?,?,?)";
//            PreparedStatement pstm = connection.prepareStatement(sql);
//            pstm.setObject(1, dto.getTargetId());
//            pstm.setObject(2, dto.getProductId());
//            pstm.setObject(3, dto.getStatus());
//            pstm.setObject(4, dto.getExportableqty());
//            pstm.setObject(5, dto.getAmountexport());

            return SQLUtil.execute("INSERT INTO exportableproduct VALUES(?,?,?,?,?)",
                    dto.getTargetId(), dto.getProductId(), dto.getStatus(), dto.getExportableqty(), dto.getAmountexport());

    }

    public boolean delete(String targetId) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "DELETE FROM exportableproduct WHERE targetId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, targetId);
        return SQLUtil.execute("DELETE FROM exportableproduct WHERE targetId=?", targetId);
    }

    public boolean update(Exportable dto) throws Exception {
//        Connection connection = DbConection.getInstance().getConnection();
//        String sql = "UPDATE exportableproduct SET productId=?,status=?,Exportableqty=?,amountexport=? WHERE targetId=?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, dto.getProductId());
//        pstm.setObject(2, dto.getStatus());
//        pstm.setObject(3, dto.getExportableqty());
//        pstm.setObject(4, dto.getAmountexport());
//        pstm.setObject(5, dto.getTargetId());
        return SQLUtil.execute("UPDATE exportableproduct SET productId=?,status=?,Exportableqty=?,amountexport=? WHERE targetId=?", dto.getProductId(),dto.getStatus(),dto.getExportableqty(),dto.getAmountexport(),dto.getTargetId());
    }

    public Exportable search(String targetId) throws Exception{
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM exportableproduct WHERE targetId=?";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//        pstm.setObject(1,targetId);
        ResultSet rst = SQLUtil.execute("SELECT * FROM exportableproduct WHERE targetId=?", targetId);
        if (rst.next()){
           // return new Exportable(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
        }
        return new Exportable(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
    }

    public List<Exportable> getAll() throws Exception {
//        Connection connection= DbConection.getInstance().getConnection();
//        String sql="SELECT * FROM exportableproduct";
//        PreparedStatement pstm=connection.prepareStatement(sql);
      ResultSet rst=SQLUtil.execute("SELECT * FROM exportableproduct");
        List<Exportable> list=new ArrayList<>();
        while (rst.next()){
            Exportable exportable=new Exportable(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
          //  list.add(new Exportable(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return list;
    }

}
