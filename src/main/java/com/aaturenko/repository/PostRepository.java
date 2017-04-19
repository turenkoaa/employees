package com.aaturenko.repository;


import com.aaturenko.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Anastasia on 17.04.2017.
 */
/*@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
}*/
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}