package ra.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ra.model.dto.BlogDto;
import ra.model.entity.Blog;
import ra.model.repository.BlogRepository;
import ra.model.service.IBlogService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        Optional<Blog> optionalBlog = blogRepository.findById(id);
        if (optionalBlog.isPresent()) {
            return optionalBlog.get();
        }
        return null;
    }

    @Override
    public void save(Blog blog) {

    }

    private String pathUpload = "C:\\Users\\Admin\\IdeaProjects\\ss2-JPA-BT\\src\\main\\webapp\\WEB-INF\\upload\\";

    @Override
    public void save(BlogDto b) {
        String imagUrl = null;
        if (!(b.getImage().isEmpty())) {
            imagUrl = b.getImage().getOriginalFilename();
            try {
                FileCopyUtils.copy(b.getImage().getBytes(), new File(pathUpload + imagUrl));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Blog blog = new Blog(b.getId(), b.getTitle(), b.getContent(), imagUrl, b.getCateName(), b.getCreateDate());
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(String title, int page, int size, String sort, String by) {
        Sort s = null;
        if (by.equals("desc")) {
            s = Sort.by(sort).descending();
        } else {
            s = Sort.by(sort).ascending();
        }
        return blogRepository.findAllByTitleContains(title, PageRequest.of(page, size, s));
    }
}
