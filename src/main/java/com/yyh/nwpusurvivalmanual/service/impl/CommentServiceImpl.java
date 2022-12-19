package com.yyh.nwpusurvivalmanual.service.impl;

import com.yyh.nwpusurvivalmanual.entity.CommentManager;
import com.yyh.nwpusurvivalmanual.entity.CommentUser;
import com.yyh.nwpusurvivalmanual.mapper.CommentMapper;
import com.yyh.nwpusurvivalmanual.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.yyh.nwpusurvivalmanual.model.comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentMapper commentMapper;


    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper){
        this.commentMapper = commentMapper;
    }

    @Override
    public List<comment> selectAll(){return this.commentMapper.selectAll();}

    @Override
    public List<CommentUser> selectAllUser(){return this.commentMapper.selectAllUser();}

    @Override
    public List<CommentManager> selectAllManager(){return this.commentMapper.selectAllManager();}

    @Override
    public List<comment> selectAllRegional(int start, int offset){return this.commentMapper.selectAllRegional(start, offset);}

    @Override
    public List<CommentUser> selectAllUserRegional(int start, int offset){return this.commentMapper.selectAllUserRegional(start, offset);}

    @Override
    public List<CommentManager> selectAllManagerRegional(int start, int offset){return this.commentMapper.selectAllManagerRegional(start, offset);}

    @Override
    public int selectCommentNum(){
        return this.commentMapper.selectCommentNum();
    }
    @Override
    public int insertComment(comment comment){
        return this.commentMapper.insertComment(comment);
    }
    @Override
    public int deleteByKey(String cno, int cid){
        return this.commentMapper.deleteByKey(cno, cid);
    }

    @Override
    public int getCommentNumByCno(String cno){
        return this.commentMapper.getCommentNumByCno(cno);
    }

    @Override
    public int passComment(String cno, int cid){
        return this.commentMapper.passComment(cno, cid);
    }
}
