package br.com.giulianabezerra.postsservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CommentDTO(
    Long id,
    String text,
    @JsonProperty("post_id") Long postId) {

}
