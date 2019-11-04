package com.autodesk.www.controller;

import com.autodesk.www.model.Post;
import com.autodesk.www.services.PostService;
import com.autodesk.www.utils.JsonWrapResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

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
       return JsonWrapResult.ok(allPosts);
    }







}