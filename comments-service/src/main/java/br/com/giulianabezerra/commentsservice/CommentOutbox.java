package br.com.giulianabezerra.commentsservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "comment_outbox")
public class CommentOutbox {
  @Id
  private Long id;
  private String text;
  private Long postId;

  public CommentOutbox fromComment(Comment comment) {
    this.id = comment.getId();
    this.text = comment.getText();
    this.postId = comment.getPostId();
    return this;
  }
}
