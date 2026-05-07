package com.back.domain.post.post.repository

import com.back.domain.post.post.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired

class PostRepositoryTest {

    @Autowired
    private lateinit var postRepository: PostRepository

    @Test
    @DisplayName("findQPagedByKw")
    fun t5() {
        val postPage = postRepository.findQPagedByKw(
            PostSearchKeywordType.AUTHOR_NICKNAME,
            "유저",
            PageRequest.of(
                0,
                10,
                PostSearchSortType.ID.sortBy
            ),
        )

        val content = postPage.content

        assertThat(content).isNotEmpty
    }
}