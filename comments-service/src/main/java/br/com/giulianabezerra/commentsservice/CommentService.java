package br.com.giulianabezerra.commentsservice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CommentService {

  private final CommentRepository commentRepository;
  private final CommentOutboxRepository commentOutboxRepository;

  public CommentService(CommentRepository commentRepository,
      CommentOutboxRepository outBoxEventRepository) {
    this.commentRepository = commentRepository;
    this.commentOutboxRepository = outBoxEventRepository;
  }

  @Transactional
  public Comment createComment(Comment comment) throws JsonProcessingException {
    var newComment = commentRepository.save(comment);
    var commentOutbox = new CommentOutbox()
        .fromComment(newComment);
    commentOutboxRepository.save(commentOutbox);

    return newComment;
  }

  public List<Comment> findAll() {
    return commentRepository.findAll();
  }
}
