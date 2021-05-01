package com.dreamtree.webservice.service;

import com.dreamtree.webservice.domain.posts.Posts;
import com.dreamtree.webservice.domain.posts.PostsRepository;
import com.dreamtree.webservice.dto.posts.PostsMainResponseDto;
import com.dreamtree.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup () {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장 () {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("테스트 타이틀")
                .content("테스트 본문")
                .author("zeekgwang@gmail.com")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getTitle()).isEqualTo("테스트 타이틀");
        assertThat(posts.getContent()).isEqualTo("테스트 본문");
        assertThat(posts.getAuthor()).isEqualTo("zeekgwang@gmail.com");
    }
}
