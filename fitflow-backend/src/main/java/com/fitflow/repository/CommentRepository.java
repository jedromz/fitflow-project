package com.fitflow.repository;


import com.fitflow.model.report.Comment;
import com.fitflow.model.projection.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<CommentResponse> findAllByReport_Id(Long id);
}
