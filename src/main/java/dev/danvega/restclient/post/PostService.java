package dev.danvega.restclient.post;

import java.util.List;

public interface PostService {

    Post create(Post post);

    Post update(Integer id, Post post);

    Post findById(int id);

    List<Post> findAll();

    void delete(Integer id);

}
