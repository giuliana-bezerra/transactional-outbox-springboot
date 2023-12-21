package br.com.giulianabezerra.commentsservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentOutboxRepository extends JpaRepository<CommentOutbox, Long> {

}
