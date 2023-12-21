package br.com.giulianabezerra.postsservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class KafkaConsumerOutbox {
  private final PostRepository postRepository;
  private final ObjectMapper objectMapper;

  public KafkaConsumerOutbox(
      PostRepository postRepository,
      ObjectMapper objectMapper) {
    this.postRepository = postRepository;
    this.objectMapper = objectMapper;
  }

  @Transactional
  @KafkaListener(topics = "mysql.comments_db.comment_outbox", groupId = "posts-service")
  public void consumeMessage(GenericMessage message) throws JsonMappingException, JsonProcessingException {
    var dto = objectMapper
        .readValue(message.getPayload(), CommentDTO.class);
    var comment = new Comment();
    comment.setId(dto.id());
    comment.setText(dto.text());

    postRepository.findById(dto.postId())
        .ifPresent(post -> {
          comment.setPost(post);
          post.getComments().add(comment);
          postRepository.save(post);
        });
  }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class GenericMessage {
  private String payload;
}