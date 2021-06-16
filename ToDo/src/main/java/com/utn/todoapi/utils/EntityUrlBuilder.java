package com.utn.todoapi.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class EntityUrlBuilder {

    public static String buildURL(String entity, String id){
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(("{entity}/{id}"))
                .buildAndExpand(entity,id)
                .toUriString();
    }
}
