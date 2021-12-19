package com.mystudy.firstproject.repository.board;

import com.mystudy.firstproject.domain.entity.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {

    List<Board> findByTitle(String title);

    List<Board> findByTitleOrContent(String title, String content);

    Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
