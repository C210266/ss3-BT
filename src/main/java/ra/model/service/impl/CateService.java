package ra.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dto.BlogDto;
import ra.model.entity.Blog;
import ra.model.entity.Category;
import ra.model.repository.CateRepository;
import ra.model.service.ICateService;
import ra.model.service.IGenericService;

import java.util.List;
import java.util.Optional;

@Service
public class CateService implements ICateService {
    @Autowired
    private CateRepository cateRepository;

    @Override
    public List<Category> findAll() {
        return cateRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optionalBlog = cateRepository.findById(id);
        if (optionalBlog.isPresent()) {
            return optionalBlog.get();
        }
        return null;
    }

    @Override
    public void save(Category category) {
        cateRepository.save(category);
    }

    @Override
    public void delete(Long aLong) {
        cateRepository.deleteById(aLong);
    }
}
