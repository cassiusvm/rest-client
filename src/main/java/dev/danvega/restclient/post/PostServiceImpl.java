package dev.danvega.restclient.post;

import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@Primary
public class PostServiceImpl implements PostService {

    private final RestClient restClient;

    public PostServiceImpl() {
        restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    @Override
    public List<Post> findAll() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    @Override
    public Post findById(int id) {
        return restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(Post.class);
    }

    @Override
    public Post create(Post post) {
        return restClient.post()
                .uri("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }


    @Override
    public Post update(Integer id, Post post) {
        return restClient.put()
                .uri("/posts/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }


    @Override
    public void delete(Integer id) {
        restClient.delete()
                .uri("/posts/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }

}
