package com.stackroute.controller;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */

/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RestController
@RequestMapping("/api/v1/")
public class BlogController {

    private BlogService blogService;
    //private BlogServiceImpl blogServiceImpl;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * save a new blog
     */
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.saveBlog(blog),HttpStatus.CREATED);
    }

    /**
     * retrieve all blogs
     */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return new ResponseEntity<>(blogService.getAllBlogs(),HttpStatus.OK);
    }

    /**
     * retrieve blog by id
     */
    @GetMapping("blog/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") int blogId) {
        return new ResponseEntity<>(blogService.getBlogById(blogId),HttpStatus.OK);

    }

    /**
     * delete blog by id
     */
    @DeleteMapping("blog/{blogId}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable("blogId") int blogId) {
        return new ResponseEntity<>(blogService.deleteBlog(blogId),HttpStatus.OK);
    }


    /**
     * update blog
     */
    @PutMapping("/blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.updateBlog(blog),HttpStatus.OK);
    }
}