package com.stackroute.service;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
    Add annotation to define cache configuration
*/
@CacheConfig(cacheNames = "blog")
/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    public BlogServiceImpl() {
    }

    @Autowired
    public void setBlogRepository(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    /*
        Add annotation to update the value of the cache
    */
    @CacheEvict(allEntries = true)
    /**
     * Implementation of saveBlog method
     */
    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }


    /*
        Add annotation to cache the result of this method
    */
    @Cacheable()
    /**
     * Implementation of getAllBlogs method
     */
    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    /*
        Add annotation to cache the result of this method
    */
    @Cacheable()
    /**
     * Implementation of getBlogById method
     */
    @Override
    public Blog getBlogById(int blogId) {
        Blog retrievedBlog = null;
        retrievedBlog = blogRepository.findById(blogId).get();
        return retrievedBlog;
    }

    /*
        Add annotation to remove data from from the cache
    */
    @CacheEvict(allEntries = true)
    /**
     * Implementation of deleteBlogById method
     */
    @Override
    public Blog deleteBlogById(int blogId) {
        Blog blog = null;
        Optional optional = blogRepository.findById(blogId);
        if (optional.isPresent()) {
            blog = blogRepository.findById(blogId).get();
            blogRepository.deleteById(blogId);
        }
        return blog;
    }

    /*
        Add annotation to update the cache with the result of the method execution
    */
    @CachePut()
    /**
     * Implementation of updateBlog method
     */
    @Override
    public Blog updateBlog(Blog blog) {
        Blog updatedBlog = null;
        Optional optional = blogRepository.findById(blog.getBlogId());
        if (optional.isPresent()) {
            Blog getBlog = blogRepository.findById(blog.getBlogId()).get();
            getBlog.setBlogContent(blog.getBlogContent());
            updatedBlog = saveBlog(getBlog);
        }
        return updatedBlog;

    }

}
