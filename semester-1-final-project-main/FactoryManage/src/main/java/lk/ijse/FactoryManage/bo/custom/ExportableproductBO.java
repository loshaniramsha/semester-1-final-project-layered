package lk.ijse.FactoryManage.bo.custom;

import lk.ijse.FactoryManage.Entity.Exportable;
import lk.ijse.FactoryManage.bo.SuperBO;
import lk.ijse.FactoryManage.dao.CrudDAO;
import lk.ijse.FactoryManage.dto.CountmaterialDto;
import lk.ijse.FactoryManage.dto.ExportableDto;

import java.util.List;

public interface ExportableproductBO extends SuperBO {
    boolean saveExportable(ExportableDto dto) throws Exception ;
    boolean deleteExportable(String exportableId) throws Exception  ;
    boolean updateExportable(ExportableDto dto) throws Exception ;
    ExportableDto searchExportable(String targetId)  throws Exception;
    List<ExportableDto> getAllExportable() throws Exception;
}
