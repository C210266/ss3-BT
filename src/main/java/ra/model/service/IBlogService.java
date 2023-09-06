package ra.model.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ra.model.dto.BlogDto;
import ra.model.entity.Blog;



@Service
public interface IBlogService extends IGenericService<Blog, Long> {
    void save(BlogDto b);

    Page<Blog> findAll(String title, int page, int size, String sort, String by);
}
