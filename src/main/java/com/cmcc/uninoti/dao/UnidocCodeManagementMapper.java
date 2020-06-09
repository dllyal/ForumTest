package com.cmcc.uninoti.dao;

import com.cmcc.uninoti.domain.UnidocCodeManagement;
import com.cmcc.uninoti.domain.UnidocCodeManagementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UnidocCodeManagementMapper {
    int countByExample(UnidocCodeManagementExample example);

    int deleteByExample(UnidocCodeManagementExample example);

    int deleteByPrimaryKey(Integer regId);

    int insert(UnidocCodeManagement record);

    int insertSelective(UnidocCodeManagement record);

    List<UnidocCodeManagement> selectByExampleWithRowbounds(UnidocCodeManagementExample example, RowBounds rowBounds);

    List<UnidocCodeManagement> selectByExample(UnidocCodeManagementExample example);

    UnidocCodeManagement selectByPrimaryKey(Integer regId);

    int updateByExampleSelective(@Param("record") UnidocCodeManagement record, @Param("example") UnidocCodeManagementExample example);

    int updateByExample(@Param("record") UnidocCodeManagement record, @Param("example") UnidocCodeManagementExample example);

    int updateByPrimaryKeySelective(UnidocCodeManagement record);

    int updateByPrimaryKey(UnidocCodeManagement record);
}