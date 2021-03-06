package com.we.weblog.service;

import com.we.weblog.domain.Comment;
import com.we.weblog.domain.result.Result;

/**
 * @author Clay
 * @date 2018/10/23 19:23
 */
public interface CommentService {
    /**
     * 查询所有的评论，用于后台管理
     *
     * @return Page
     */
    Result findAllComments();


    /**
     * 查询所有的评论，用于后台管理
     *
     * @return Page
     */
    Result findAllCommentsByStatus(int status);

    /**
     * 查询评论byId
     * @param id
     * @return
     */
    Result findCommentById(Integer id);

    /**
     * 删除评论
     * @param cid
     * @return
     */
    Result removeByCommentId(Integer cid);

    /**
     * 新增评论
     *
     * @param comment comment
     */
    Result saveByComment(Comment comment);


    /**
     * 获取文章数量
     * @return
     */
    Integer getCommentCount();

    /**
     * 根据文章id获取评论
     * @return
     */
    Result findCommentByUid(int uid);

    /**
     * 回复评论
     * @param messgae
     * @param cid
     * @param reply
     */
    Result replyComment(String messgae, Integer cid, Comment reply);

    /**
     * 更改评论的状态
     *
     * @param commentId commentId
     * @param status    status
     * @return Comment
     */
    Result updateCommentStatus(Integer commentId, Integer status);
}
