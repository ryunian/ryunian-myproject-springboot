package com.springboot.myproject.domain.posts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT x from Posts x ORDER BY x.id DESC")
    List<Posts> findAllDesc();

    @Query("SELECT x FROM Posts x")
    List<Posts> findDesc(Pageable pageable);

    @Query("SELECT count(*) from Posts")
    Long totalCount();
}
