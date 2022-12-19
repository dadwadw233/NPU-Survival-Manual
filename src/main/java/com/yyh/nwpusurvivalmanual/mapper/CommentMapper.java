package com.yyh.nwpusurvivalmanual.mapper;

import com.yyh.nwpusurvivalmanual.entity.CommentManager;
import com.yyh.nwpusurvivalmanual.entity.CommentUser;
import com.yyh.nwpusurvivalmanual.model.Course;
import com.yyh.nwpusurvivalmanual.model.comment;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT * FROM comment limit #{start},#{offset}")
    List<comment>selectAllRegional(@Param("start")int start, @Param("offset")int offset);

    @Select("SELECT * FROM comment_user limit #{start},#{offset}")
    List<CommentUser>selectAllUserRegional(@Param("start")int start, @Param("offset")int offset);

    @Select("SELECT * FROM comment_manager limit #{start},#{offset}")
    List<CommentManager>selectAllManagerRegional(@Param("start")int start, @Param("offset")int offset);

    @Select("SELECT COUNT(*) FROM comment")
    int selectCommentNum();

    @Insert("INSERT INTO comment VALUES(#{cno},#{cid},#{sno},#{time},#{detail},#{isselect},#{sscore}," +
            "#{visible})")
    int insertComment(comment comment);

    @Delete("DELETE FROM comment WHERE cno=#{cno} and cid=#{cid}")
    int deleteByKey(@Param("cno")String cno, @Param("cid")int cid);

    @Select("SELECT COUNT(*) FROM comment WHERE cno=#{cno}")
    int getCommentNumByCno(@Param("cno")String cno);


    @Update("UPDATE comment SET visible=1 WHERE cno=#{cno} and cid=#{cid}")
    int passComment(@Param("cno")String cno, @Param("cid")int cid);
}
