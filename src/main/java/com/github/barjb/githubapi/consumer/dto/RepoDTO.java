package com.github.barjb.githubapi.consumer.dto;


public record RepoDTO(int id, String name, boolean fork, OwnerDTO owner) {}
