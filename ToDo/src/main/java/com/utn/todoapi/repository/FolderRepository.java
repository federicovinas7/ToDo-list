package com.utn.todoapi.repository;

import com.utn.todoapi.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Integer> {
}
