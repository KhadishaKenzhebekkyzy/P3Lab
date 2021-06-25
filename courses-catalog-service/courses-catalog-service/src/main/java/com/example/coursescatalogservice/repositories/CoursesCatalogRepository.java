package com.example.coursescatalogservice.repositories;

import com.example.coursescatalogservice.models.CoursesCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesCatalogRepository extends JpaRepository<CoursesCatalog, Long> {
}
