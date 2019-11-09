package com.autodesk.www.controller;

import com.autodesk.www.model.Post;
import com.autodesk.www.services.PostService;
import com.autodesk.www.utils.JsonWrapResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public JsonWrapResult addEmployee(@RequestBody Post post) throws Exception {
        this.postService.createPost(post);
        return JsonWrapResult.ok(this.postService.findAllPosts());
    }

    @RequestMapping(value = "/delete/{postId}", method = RequestMethod.DELETE)
    public JsonWrapResult deletePost(@PathVariable("postId") Long postId) {
        this.postService.deletePost(postId);
        return JsonWrapResult.ok("Delete Successful.");
    }

    @PostMapping(path= "/update", consumes = "application/json", produces = "application/json")
    public JsonWrapResult updateEmployee(@RequestBody Post post) throws Exception {
        this.postService.updatePost(post);
        return JsonWrapResult.ok(this.postService.findAllPosts());
    }

    @RequestMapping("/query/{id}")
    public JsonWrapResult testQuery(@PathVariable Long id) {
        return JsonWrapResult.ok(postService.findPost(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public JsonWrapResult listAllPosts() {
        List<Post> allPosts = this.postService.findAllPosts();
        logger.info("QUERY ALL POST: JUST TEST LOGGER.");
       return JsonWrapResult.ok(allPosts);
    }







}