package com.yunus.exerciseapi.repository;

import com.yunus.exerciseapi.entity.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, String> {

    Optional<Exercise> findByCode(String code);
}
