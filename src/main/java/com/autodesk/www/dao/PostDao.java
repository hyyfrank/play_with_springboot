package com.autodesk.www.dao;

import com.autodesk.www.model.Post;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PostDao {
  void save(Post post);

  void delete(Long postId);

  void update(Post post);

  Post find(Long postId);

  List<Post> findAll();
}
