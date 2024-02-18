package com.github.barjb.githubapi.consumer;

import com.github.barjb.githubapi.consumer.dto.UserDataView;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubAPIController {
  private static final Logger log = LoggerFactory.getLogger(GithubAPIController.class);
  private final GithubAPIService githubAPIService;

  public GithubAPIController(GithubAPIService githubAPIService) {
    this.githubAPIService = githubAPIService;
  }

  @GetMapping(path = "/users/{user}/repos")
  public List<UserDataView> getRepos(@PathVariable String user) {
    log.info("Get repos for user={}", user);
    return githubAPIService.getRepos(user);
  }
}
