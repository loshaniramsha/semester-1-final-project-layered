package lk.ijse.FactoryManage.bo;

import lk.ijse.FactoryManage.bo.impl.*;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {

    }

    public static BoFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTypes {
        COUNTMATERIAL, EMPLOYEE, EXPORTABLE, MADEPRODUCT, MATERIAL, PRODUCT, SCHEDULE, SUPPLIER, TARGET, USER, USERLOGIN,
    }

    public SuperBO getBO(BoTypes boTypes) {
        switch (boTypes) {
            case COUNTMATERIAL:
                return new CountmaterialBOimpl();
            case EMPLOYEE:
                return new EmployeeBOimpl();
            case EXPORTABLE:
                return new ExportableproducBOimpl();
            case MADEPRODUCT:
                return new MadeproductBOimpl();
            case MATERIAL:
                return new MaterialBOimpl();
            case PRODUCT:
                return new ProductBOimpl();
            case SCHEDULE:
                return new ScheduleBOimpl();
            case SUPPLIER:
                return new SupplierBOimpl();
            case TARGET:
                return new TargetBOimpl();
            case USER:
                return new UserBOimpl();
            case USERLOGIN:
                return new UserloginBOimpl();
            default:
                return null;
        }
    }
}