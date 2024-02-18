package com.github.barjb.githubapi.consumer;

import com.github.barjb.githubapi.consumer.dto.BranchSimple;
import com.github.barjb.githubapi.consumer.dto.UserDataView;
import com.github.barjb.githubapi.infrastructure.GitHubService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GithubAPIService {
  private final GitHubService gitHubService;

  public GithubAPIService(GitHubService gitHubService) {
    this.gitHubService = gitHubService;
  }

  public List<UserDataView> getRepos(String user) {

    var repoDTO = gitHubService.getRepos(user);
    return repoDTO.stream()
        .filter(repo -> !repo.fork())
        .map(
            repo -> {
              var branchesAssignedToRepo =
                  gitHubService.getBranches(user, repo.name()).stream()
                      .map(branch -> new BranchSimple(branch.name(), branch.commit().sha()))
                      .toList();
              return new UserDataView(repo.name(), repo.owner().login(), branchesAssignedToRepo);
            })
        .toList();
  }
}
