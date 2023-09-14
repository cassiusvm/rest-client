package dev.danvega.restclient.service;

import dev.danvega.restclient.post.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface JsonPlaceholderService extends PostService {

    @Override
    @GetExchange("/posts")
    List<Post> findAll();

    @Override
    @GetExchange("/posts/{id}")
    Post findById(@PathVariable("id") Integer id);

    @Override
    @PostExchange("/posts")
    Post create(@RequestBody Post post);

    @Override
    @PutExchange("/posts/{id}")
    Post update(@PathVariable Integer id, @RequestBody Post post);

    @Override
    @DeleteExchange("/posts/{id}")
    void delete(@PathVariable Integer id);

}
