package com.springboot.myproject.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Modifying
    @Query(value = "INSERT INTO Comment(author,content,grp) VALUES (?1,?2,(SELECT IFNULL(MAX(id)+1,1) FROM Comment c))", nativeQuery = true)
    void write(String author, String content);

    @Modifying
    @Query(value = "INSERT INTO Comment(author,content,grp,step,indent) VALUES (?1, ?2, ?3 ,?4 ,?5)", nativeQuery = true)
    void reply(String author, String content, int grp, int step, int indent);

    @Modifying
    @Query(value = "UPDATE Comment set step = step+1 where grp = ?1 and step > ?2", nativeQuery = true)
    void stepModify(int grp, int step);

    @Query(value = "SELECT * FROM Comment ORDER BY grp DESC, step ASC", nativeQuery = true)
    List<Comment> list();
}

