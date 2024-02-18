# GithubApiApplication

## Endpoints
```text

Request
  URI: /users/{user}/repos
  HTTP Verb: GET
  Body: None

Response:
HTTP Status:
200 OK if provided github user exists
400 BAD REQUEST if github api returns 4xx for given github user
500 INTERNAL SERVER EXCEPTION if github api returns 5xx for given github user 
    or if there is network error with reading response from the github api
Response Body Type: JSON
Example Response Body:
[
    {
        "repoName": "Repository",
        "ownerLogin": "user",
        "branches": [
            {
                "name": "master",
                "sha": "8aad193c5831153fb67dd5c9e22102e7c644d3ef"
            }
        ]
    }
]
```

## application.properties
```text
Github token is generated through Developer settings on github.com.
The amount of allowed requests per hour without a token is very limited.
Using endpoint without a token or with token with insufficient permissions results in 404 Not Found or 403 Forbidden.
Authenticating with invalid credentials results in 401 Unauthorized.
```
Example of application.properties file:
```text
githubToken=...
```