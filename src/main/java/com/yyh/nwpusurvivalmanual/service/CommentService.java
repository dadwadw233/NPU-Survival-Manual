package com.yyh.nwpusurvivalmanual.service;

import com.yyh.nwpusurvivalmanual.entity.CommentManager;
import com.yyh.nwpusurvivalmanual.entity.CommentUser;
import com.yyh.nwpusurvivalmanual.model.comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对评论进行数据操作的接口
 *
 * @author Yuanhong Yu
 * @version 1.0
 */
@Repository
public interface CommentService {

    List<comment> selectAll();

    List<CommentUser>selectAllUser();

    List<CommentManager>selectAllManager();

    List<comment>selectAllRegional(int start, int offset);

    List<CommentUser>selectAllUserRegional(int start, int offset);

    List<CommentManager>selectAllManagerRegional(int start, int offset);
}
