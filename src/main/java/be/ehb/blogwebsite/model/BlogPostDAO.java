package be.ehb.blogwebsite.model;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostDAO extends CrudRepository<BlogPost, Integer> {
    // This interface will automatically provide CRUD operations for BlogPost entities
    // The Spring Data JPA will generate the implementation at runtime
    // No need to write any code here


}
