package br.com.giulianabezerra.commentsservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("comments")
public class CommentController {
  private final CommentService service;

  public CommentController(CommentService service) {
    this.service = service;
  }

  @PostMapping
  public Comment createComment(@RequestBody Comment comment) throws JsonProcessingException {
    return service.createComment(comment);
  }

  @GetMapping
  public List<Comment> getComments() {
    return service.findAll();
  }
}
