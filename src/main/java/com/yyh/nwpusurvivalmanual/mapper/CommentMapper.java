package com.yyh.nwpusurvivalmanual.mapper;

import com.yyh.nwpusurvivalmanual.entity.CommentManager;
import com.yyh.nwpusurvivalmanual.entity.CommentUser;
import com.yyh.nwpusurvivalmanual.model.Course;
import com.yyh.nwpusurvivalmanual.model.comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 实现数据库中comment表与comment类的映射
 *
 * @author Yuanhong YU
 * @see comment
 * @version 1.0
 */

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM comment")

    List<comment>selectAll();

    @Select("SELECT * FROM comment_user")
    List<CommentUser>selectAllUser();

    @Select("SELECT * FROM comment_manager")
    List<CommentManager>selectAllManager();

    @Select("SELECT * FROM comment")
    List<comment>selectAllRegional(@Param("start")int start, @Param("offset")int offset);

    @Select("SELECT * FROM comment_user")
    List<CommentUser>selectAllUserRegional(@Param("start")int start, @Param("offset")int offset);

    @Select("SELECT * FROM comment_manager")
    List<CommentManager>selectAllManagerRegional(@Param("start")int start, @Param("offset")int offset);

}
