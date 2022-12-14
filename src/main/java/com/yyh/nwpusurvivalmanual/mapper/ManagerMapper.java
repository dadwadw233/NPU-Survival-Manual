package com.yyh.nwpusurvivalmanual.mapper;

import com.yyh.nwpusurvivalmanual.model.Manager;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
/**
 * 实现数据库中manager表与Manager类的映射
 *
 * @author Yuanhong YU
 */
@Mapper
public interface ManagerMapper {
    @Select("SELECT * FROM manager")
    @Results(id="selectAllManagers",
            value = {
            @Result(property = "id", column = "id"),
            @Result(property = "password", column = "password")
    })
    List<Manager> selectAll();

    @Insert("INSERT INTO manager VALUES(#{manager.id}, #{manager.password})")
    int insert (@Param("manager") Manager manager);
}
