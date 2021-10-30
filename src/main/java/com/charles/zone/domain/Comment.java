package com.charles.zone.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;
    private String uuid;
    private String postUuid;
    private String content;
    private Integer isRoot;
    private Integer rootCommentId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    private Post post;
    private List<Comment> children;
    private Comment rootComment;
    private FrontUser author;
    private FrontUser replyToAuthor;
}
