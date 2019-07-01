package com.we.weblog.service;

import com.we.weblog.domain.result.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tangwei
 * @date 2018/12/9 19:49
 */
public interface AttachmentService {
    /**
     * 查询所有附件，分页
     *
     * @return Page
     */
    Result findAllAttachments(int currentPage);

    /**
     * 根据Id查找附件
     *
     * @return Page
     */
    Result findByAttachId(int attachId);

    /**
     * 根据Id删除附件
     * @param id
     */
    Result removeByAttachId(int id);

    /**
     * 上传附件
     * @param file
     * @return
     */
    Result uploadAttachment(MultipartFile file);


}
