package com.vantutran2k1.todoapp.api.repositories;

import com.vantutran2k1.todoapp.api.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t where t.user.id = :userId")
    List<Task> findByUserId(@Param("userId") Long userId);
}
