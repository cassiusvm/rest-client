package dev.danvega.restclient.service;

import dev.danvega.restclient.post.Post;

import java.util.List;

public interface PostService {

    Post create(Post post);

    Post update(Integer id, Post post);

    Post findById(Integer id);

    List<Post> findAll();

    void delete(Integer id);

}
