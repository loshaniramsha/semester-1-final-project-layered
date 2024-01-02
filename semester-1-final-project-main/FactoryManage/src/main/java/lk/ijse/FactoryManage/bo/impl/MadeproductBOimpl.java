package lk.ijse.FactoryManage.bo.impl;

import lk.ijse.FactoryManage.Entity.Madeproduct;
import lk.ijse.FactoryManage.bo.custom.MadeproductBO;
import lk.ijse.FactoryManage.dao.DAOFactory;
import lk.ijse.FactoryManage.dao.custom.MadeproductDAO;
import lk.ijse.FactoryManage.dto.Madeproductdto;

import java.util.ArrayList;
import java.util.List;

public class MadeproductBOimpl implements MadeproductBO {
    MadeproductDAO madeproductDAO= (MadeproductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MADEPRODUCT);

    @Override
    public boolean saveMadeproduct(Madeproductdto dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteMadeproduct(String productId) throws Exception {
        return false;
    }

    @Override
    public boolean updateMadeproduct(Madeproductdto dto) throws Exception {
        return false;
    }

    @Override
    public Madeproductdto searchMadeproduct(String productId) throws Exception {
        return null;
    }

    @Override
    public List<Madeproductdto> getAllMadeproduct() throws Exception {
        return null;
    }

    @Override
    public boolean saveMadeProduct(Madeproductdto dto) throws Exception {
        return false;
    }

    public  boolean deleteMadeProduct(String productId) throws Exception{
        return madeproductDAO.delete(productId);
    }

    @Override
    public boolean updateMadeProduct(Madeproductdto dto) throws Exception {
        return false;
    }

       public Madeproductdto searchMadeProduct(String productId) throws Exception{
        Madeproduct madeproduct=madeproductDAO.search(productId);
        return new Madeproductdto(madeproduct.getProductId(),madeproduct.getTargetAmount(),madeproduct.getEmployeeId(),madeproduct.getCompleteAmount());
    }


    public List<Madeproductdto> getAllMadeProduct()throws Exception {
        List<Madeproduct> list = madeproductDAO.getAll();
        List<Madeproductdto> madeproductdtos = new ArrayList<>();
        for (Madeproduct madeproduct : list) {
            madeproductdtos.add(new Madeproductdto(madeproduct.getProductId(), madeproduct.getTargetAmount(), madeproduct.getEmployeeId(), madeproduct.getCompleteAmount()));
        }

        return madeproductdtos;
    }
}
