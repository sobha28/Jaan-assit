package com.localgov.eligibilitychecker.repository;

import com.localgov.eligibilitychecker.model.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SchemeRepository extends JpaRepository<Scheme, Long> {
    List<Scheme> findByCategoryIgnoreCase(String category);
}
