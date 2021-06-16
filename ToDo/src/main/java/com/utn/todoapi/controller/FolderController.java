package com.utn.todoapi.controller;

import com.utn.todoapi.model.Folder;
import com.utn.todoapi.model.PostResponse;
import com.utn.todoapi.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folder")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @GetMapping
    public List<Folder> getAll(){
        return this.folderService.getAll();
    }

    @GetMapping("{idFolder}")
    public Folder getById(@PathVariable Integer idFolder){
        return this.folderService.getById(idFolder);
    }

    @PostMapping
    public PostResponse add(@RequestBody Folder newFolder){
        return this.folderService.add(newFolder);
    }

    @DeleteMapping("{idFolder}")
    public void delete(@PathVariable Integer idFolder){
        this.folderService.delete(idFolder);
    }

    @PutMapping
    public PostResponse update(@RequestBody Folder toUpdate){
        return this.folderService.update(toUpdate);
    }

    @PutMapping("{idFolder}/task/{idTask}")
    public PostResponse addToFolder(@PathVariable Integer idFolder, @PathVariable Integer idTask){
        return this.folderService.addToList(idFolder,idTask);
    }
}
