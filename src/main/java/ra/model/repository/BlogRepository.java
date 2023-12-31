package ra.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAllByTitleContains(String title, Pageable pageable);
}
