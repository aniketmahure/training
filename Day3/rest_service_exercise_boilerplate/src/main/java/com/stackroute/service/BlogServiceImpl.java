package com.stackroute.service;

import com.stackroute.domain.Blog;

import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    /**
     * Constructor based Dependency injection to inject BlogRepository here
     */
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * save a new blog
     */
    public Blog saveBlog(Blog blog) {
        Optional<Blog> blogObj = blogRepository.findById(blog.getBlogId());
        if (blogObj.isPresent()) {
            System.out.println("Id already exist");
        }
        else {
            blogRepository.save(blog);
        }
        return blog;
    }
    /**
     * retrieve all blogs
     */
    public List<Blog> getAllBlogs(){
        return (List<Blog>) blogRepository.findAll();
    }

    /**
     * retrieve blog by id
     */
    public Blog getBlogById(int id){
        return blogRepository.findById(id).get();
    }

    /**
     * delete blog by id
     */
    public Blog deleteBlog(int id){
        Optional<Blog> blogBbj = blogRepository.findById(id);
        if (blogBbj.isPresent())
        {
            blogRepository.deleteById(id);
            return blogBbj.get();
        }
        return null;
    }

    /**
     * update blog
     */
    public Blog updateBlog(Blog blog) {
        Optional<Blog> blogObj =blogRepository.findById(blog.getBlogId());
        if (blogObj.isPresent())
        {
            blogRepository.save(blog);
            return blog;
        }
        else
            return null;
    }
}