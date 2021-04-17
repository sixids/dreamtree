package com.dreamtree.webservice.dto.posts;

import com.dreamtree.webservice.domain.posts.Posts;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class PostsMainResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;

    public PostsMainResponseDto(Posts entity){
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
