package lk.ijse.FactoryManage.dao;

import lk.ijse.FactoryManage.dao.impl.*;

//Object creational logic hide
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        COUNTMATERIAL, EMPLOYEE, EXPORTABLE, MADEPRODUCT, MATERIAL, PRODUCT, SCHEDULE, SUPPLIER, TARGET, USER, USERLOGIN,
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case COUNTMATERIAL:
                return new CountmaterialDAOimpl();
            case EMPLOYEE:
                return new EmployeeDAOimpl();
            case EXPORTABLE:
                return new ExportableproducDAOimpl();
            case MADEPRODUCT:
                return new MadeproductDAOimpl();
            case MATERIAL:
                return new MaterialDAOimpl();
            case PRODUCT:
                return new ProductDAOimpl();
            case SCHEDULE:
                return new ScheduleDAOimpl();
            case SUPPLIER:
                return new SupplierDAOimpl();
            case TARGET:
                return new TargetDAOimpl();
            case USER:
                return new UserDAOimpl();
            case USERLOGIN:
                return new UserloginDAOimpl();
            default:
                return null;
        }
    }
}