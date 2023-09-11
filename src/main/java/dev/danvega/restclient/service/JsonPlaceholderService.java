package dev.danvega.restclient.service;

import dev.danvega.restclient.post.Post;
import dev.danvega.restclient.service.PostService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@Primary
public interface JsonPlaceholderService extends PostService {

    @Override
    @GetExchange("/posts")
    List<Post> findAll();

    @Override
    @GetExchange("/posts/{id}")
    Post findById(Integer id);

    @Override
    @PostExchange("/posts")
    Post create(Post post);

    @Override
    @PutExchange("/posts/{id}")
    Post update(@PathVariable Integer id, Post post);

    @Override
    @DeleteMapping("/posts/{id}")
    void delete(@PathVariable Integer id);

}
