package com.github.barjb.githubapi.consumer.dto;

import java.util.List;

public record UserDataView(String repoName, String ownerLogin, List<BranchSimple> branches) {}
