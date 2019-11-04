package com.autodesk.www.dao;

import com.autodesk.www.model.Post;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PostDao {
        void save(Post post);

        void delete(Long postId);

        void update(Post post);

        Post find(Long postId);

        List<Post> findAll();
}

