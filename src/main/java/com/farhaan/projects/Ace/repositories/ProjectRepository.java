package com.farhaan.projects.Ace.repositories;

import com.farhaan.projects.Ace.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            AND p.owner.id = :userId
            ORDER BY p.updatedAt DESC"""
    )
    List<Project> findAllAccessibleByUser(@Param("userId") long userId);


    @Query("""
    SELECT p FROM Project p
    LEFT JOIN FETCH p.owner
    WHERE p.id = :projectId
    AND p.deletedAt IS NULL
    AND p.owner.id = :userId
    
""")
    Optional<Project> findAccessibleProjectById(@Param("projectId") Long projectId,
                                                @Param("userId") long userId);
}
