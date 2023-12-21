package br.com.giulianabezerra.postsservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostController {
  private final PostRepository repository;

  public PostController(PostRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Post createPost(@RequestBody Post post) {
    return repository.save(post);
  }

  @GetMapping
  public List<Post> getPostsWithComments() {
    return repository.findAll();
  }
}
