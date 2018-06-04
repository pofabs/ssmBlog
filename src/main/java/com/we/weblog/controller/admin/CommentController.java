package com.we.weblog.controller.admin;


import com.vue.adminlte4j.model.TableData;
import com.vue.adminlte4j.model.UIModel;
import com.we.weblog.controller.BaseController;
import com.we.weblog.domain.Comment;
import com.we.weblog.service.CommentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 *  评论管理页面
 */
@Controller
@RequestMapping("/admin/comments")
public class CommentController extends BaseController {




    private CommentSerivce commentSerivce;


    @Autowired
    public CommentController(CommentSerivce commentSerivce){
        this.commentSerivce = commentSerivce;
    }



    /**
     * 前端 评论信息
     */
    @GetMapping("/table")
    @ResponseBody
    Map<String,Object> getAllComments() {

        UIModel uiModel = new UIModel() ;
        TableData tableData = new TableData() ;

        tableData.configDisplayColumn(TableData.createColumn("cid" , "评论id" ));
        tableData.configDisplayColumn(TableData.createColumn("content" , "评论内容" ));
        tableData.configDisplayColumn(TableData.createColumn("author" , "评论人") );
        tableData.configDisplayColumn(TableData.createColumn("time" , "评论时间" ));
        tableData.configDisplayColumn(TableData.createColumn("email" , "评论人邮箱" ));


        //遍历查询数据库
        List<Comment> comments=commentSerivce.getComments();

        for(Comment comment : comments){
            tableData.addData(comment);
        }

       tableData.setTotalSize(commentSerivce.getCounts());
        tableData.setTotalSize(10);
        uiModel.tableData(tableData);
        return uiModel ;
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public  UIModel deleteCommnets(@PathVariable("id") Integer commentId){

        if(commentId <= 0 )
            return UIModel.fail().setMsg("删除id非法");

        int result  = commentSerivce.deleteComment(commentId);

        if(result > 0){
            return UIModel.success().setMsg("删除成功");
        }
        return UIModel.fail().setMsg("删除失败");

    }



}
