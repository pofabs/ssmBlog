package com.we.weblog.controller.admin;

import com.vue.adminlte4j.model.UIModel;
import com.we.weblog.domain.Comment;
import com.we.weblog.domain.Log;
import com.we.weblog.domain.Post;
import com.we.weblog.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * <pre>
 *     * 后端主要管理页面  日志清理和index显示内容

 * </pre>
 *
 * @author Clay
 * @date 2018/11/5 19:57
 */
@Controller
@RequestMapping("/admin")

public class IndexAdminController {

    private static final Logger LOG = LoggerFactory.getLogger(IndexAdminController.class);

    @Resource
    private LogsService logsService;
    @Resource
    private PostService postService;
    @Resource
    private CommentService commentSerivce;

    /**
     *  前端仪表盘
     * @return
     */
    @GetMapping("/index/data")
    @ResponseBody
    public Map<String,Object> index(){
        //获得最新的20条日志  获得最新的文章  后台统计对象
        Map<String,Object> map = new HashMap<>();
        //文章总数 TODO 其实Long会更好
        int commentCount = 0;
        List<Comment> comments = new ArrayList<>();
        List<Log> logs = new ArrayList<>();
        List<Post> contexts = new ArrayList<>();
        int countBlog = 0;
        try {
            //todo 这些计数应该在内部去处理
            countBlog = (int) postService.findPostCount().getData();
            commentCount = commentSerivce.getCommentCount();
            contexts = (List<Post>) postService.findHotPosts(5).getData();
            comments = (List<Comment>) commentSerivce.findAllComments().getData();
            logs = logsService.findLastestTenLogs(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // todo 这些逻辑最好在Service里面处理

        map.put("contexts", contexts);
        map.put("blogNumber", countBlog);
        map.put("comments", comments);
        map.put("commentNumber", commentCount);
        map.put("logs", logs);

        return map;
    }

    /**
     * 清除所有日志
     *
     * @return
     */
    @GetMapping(value = "/logs/clear")
    public UIModel logsClear() {
        try {
            logsService.removeAllLogs();
        } catch (Exception e) {
            LOG.error("清除日志失败：{}" + e.getMessage());
            return UIModel.fail().msg("日志清理成功");
        }
        return UIModel.success().msg("日志清理成功");
    }
}
