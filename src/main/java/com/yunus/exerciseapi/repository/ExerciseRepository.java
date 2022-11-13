package com.yunus.exerciseapi.repository;

import com.yunus.exerciseapi.entity.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, String> {
}
