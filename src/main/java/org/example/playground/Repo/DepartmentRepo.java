package org.example.playground.Repo;

import org.example.playground.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, UUID> {
}
