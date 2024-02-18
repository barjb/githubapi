package com.github.barjb.githubapi.infrastructure;

import com.github.barjb.githubapi.configuration.GithubClientConfig;
import com.github.barjb.githubapi.consumer.dto.BranchDTO;
import com.github.barjb.githubapi.consumer.dto.RepoDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    value = "githubclient",
    url = "https://api.github.com",
    configuration = GithubClientConfig.class)
public interface GitHubService {
  @GetMapping("/users/{user}/repos")
  List<RepoDTO> getRepos(@PathVariable String user);

  @GetMapping("/repos/{user}/{repo}/branches")
  List<BranchDTO> getBranches(@PathVariable String user, @PathVariable String repo);
}
