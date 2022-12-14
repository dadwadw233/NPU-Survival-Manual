package com.yyh.nwpusurvivalmanual.service;

import com.yyh.nwpusurvivalmanual.model.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员进行数据操作的接口
 *
 * @author Yuanhong Yu
 * @version 1.0
 */
@Repository
public interface ManagerService {
    List<Manager> selectAll();
}
