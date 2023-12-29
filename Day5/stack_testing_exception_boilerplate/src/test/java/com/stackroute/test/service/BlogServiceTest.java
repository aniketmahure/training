package com.stackroute.test.service;

import com.stackroute.domain.Blog;

import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;
import com.stackroute.service.BlogServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {
    // Mock BlogRepository
    @Mock
    private BlogRepository blogRepository;
    // Inject Mocks to BlogServiceImpl
    @InjectMocks
    private BlogServiceImpl blogService;
    private Blog blog, blog1;
    private List<Blog> blogList;
    private Optional optional;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        blog = new Blog(1, "SampleBlog", "Imneet", "SampleBlogforTesting");
        blog1 = new Blog(2, "Blog 1", "John", "Sample Blog 1 for Testing");
        optional = Optional.of(blog);
    }

    @AfterEach
    public void tearDown() {
        blog = null;
    }

    /*
    * write test case for saveBlog() method, by mocking the repository
    * */
    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() {
        when(blogRepository.save(any())).thenReturn(blog);
        assertEquals(blog,blogService.saveBlog(blog));
        verify(blogRepository, times(1)).save(any());
    }

    /*
    * write test case for asserting RuntimeException when saveBlog() method is called, by mocking the repository
     */
    @Test
    public void givenBlogToSaveThenShouldNotReturnSavedBlog() {
        when(blogRepository.save(blog)).thenThrow(new BlogAlreadyExistsException("Already exist"));
        Assertions.assertThrows(BlogAlreadyExistsException.class,() -> {
            blogService.saveBlog(blog);
        });
        verify(blogRepository, times(1)).save(any());
    }

    /*
    * write test case for getAllBlogs() method, by mocking the repository
     */
    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() {
        blogRepository.save(blog);
        //stubbing the mock to return specific data
        when(blogRepository.findAll()).thenReturn(blogList);
        List<Blog> blogList1 = blogService.getAllBlogs();
        assertEquals(blogList, blogList1);
        verify(blogRepository, times(1)).save(blog);
        verify(blogRepository, times(1)).findAll();
    }

    /*
    * write test case for getBlogById() method, by mocking the repository
     */
    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() {
        when(blogRepository.findById(anyInt())).thenReturn(Optional.of(blog));
        Blog retrievedBlog = blogService.getBlogById(blog.getBlogId());
        verify(blogRepository, times(1)).findById(anyInt());
    }

    /*
    * write test case for deleteBlog() method, by mocking the repository
     */
    @Test
    void givenBlogIdToDeleteThenShouldReturnDeletedBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(optional);
        Blog deletedBlog = blogService.deleteBlog(1);
        assertEquals(1, deletedBlog.getBlogId());

        verify(blogRepository, atMost(2)).findById(blog.getBlogId());
        verify(blogRepository, times(1)).deleteById(blog.getBlogId());
    }

    /*
    * write test case for asserting BlogNotFoundException when deleteBlog() method is called, by mocking the repository
     */
    @Test
    void givenBlogIdToDeleteThenShouldNotReturnDeletedBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(Optional.empty());
        Assertions.assertThrows(BlogNotFoundException.class,() -> {
            Blog deletedBlog = blogService.deleteBlog(1);
        });
        verify(blogRepository, times(1)).findById(blog.getBlogId());
    }

    /*
    * write test case for updateBlog() method, by mocking the repository
     */
    @Test
    public void givenBlogToUpdateThenShouldReturnUpdatedBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(optional);
        when(blogRepository.save(blog)).thenReturn(blog);
        blog.setBlogContent("SampleBlogforTesting");
        Blog blog1 = blogService.updateBlog(blog);
        assertEquals(blog1.getBlogContent(), "SampleBlogforTesting");
        verify(blogRepository, times(1)).save(blog);
        verify(blogRepository, atMost(2)).findById(blog.getBlogId());
    }

    /*
    * write test case for asserting BlogNotFoundException when updateBlog() method is called, by mocking the repository
     */
    @Test
    public void givenBlogToUpdateThenShouldNotReturnUpdatedBlog() {
        when(blogRepository.findById(any())).thenThrow(BlogNotFoundException.class);
        Assertions.assertThrows(BlogNotFoundException.class,() -> {
            blogService.getBlogById(-1);
        });
    }


    /*
    * write test case for asserting BlogNotFoundException when getBlogById() method is called, by mocking the repository
     */
    @Test
    public void givenNonExistentBlogIdThenShouldThrowBlogNotFoundException() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(Optional.empty());
        Assertions.assertThrows(BlogNotFoundException.class,() -> {
            blogService.getBlogById(blog.getBlogId());
        });
    }

    /*
    * write test case for asserting BlogNotFoundException when updateBlog() method is called, by mocking the repository
     */
    @Test
    public void givenUpdateNonExistentBlogThenShouldThrowBlogNotFoundException() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(Optional.empty());
        Assertions.assertThrows(BlogNotFoundException.class,() -> {
            blogService.updateBlog(blog);
        });
    }
}