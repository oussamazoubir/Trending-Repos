Idea of the App
Implement a small app that will list the most starred Github repos that were created in the last 30 days.
Fetching the sorted JSON data directly from the Github API 

How to get the data from Github
To get the most starred Github repos created in the last 30 days (relative to 2017-11-22), call the following endpoint :
https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc
To get the 2nd page, you add &page=2 to the end of your API request :
https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&page=2

Description of the JSON : 
Following is the sample JSON that we are going to parse in this project : 
{
    "total_count": 5425763,
    "incomplete_results": false,
    "items": [
        {
            "id": 112507086,
            "name": "30-seconds-of-code",
            "full_name": "Chalarangelo/30-seconds-of-code",
            "owner": {
                "login": "Chalarangelo",
                "id": 8281875,
                "avatar_url": "https://avatars2.githubusercontent.com/u/8281875?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/Chalarangelo",
                "html_url": "https://github.com/Chalarangelo",
                "followers_url": "https://api.github.com/users/Chalarangelo/followers",
                "following_url": "https://api.github.com/users/Chalarangelo/following{/other_user}",
                "gists_url": "https://api.github.com/users/Chalarangelo/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/Chalarangelo/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/Chalarangelo/subscriptions",
                "organizations_url": "https://api.github.com/users/Chalarangelo/orgs",
                "repos_url": "https://api.github.com/users/Chalarangelo/repos",
                "events_url": "https://api.github.com/users/Chalarangelo/events{/privacy}",
                "received_events_url": "https://api.github.com/users/Chalarangelo/received_events",
                "type": "User",
                "site_admin": false
            },
            "private": false,
            "html_url": "https://github.com/Chalarangelo/30-seconds-of-code",
            "description": "Curated collection of useful Javascript snippets that you can understand in 30 seconds or less.",
            "fork": false,
            "url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code",
            "forks_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/forks",
            "keys_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/teams",
            "hooks_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/hooks",
            "issue_events_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/issues/events{/number}",
            "events_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/events",
            "assignees_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/assignees{/user}",
            "branches_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/branches{/branch}",
            "tags_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/tags",
            "blobs_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/languages",
            "stargazers_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/stargazers",
            "contributors_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/contributors",
            "subscribers_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/subscribers",
            "subscription_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/subscription",
            "commits_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/contents/{+path}",
            "compare_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/merges",
            "archive_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/downloads",
            "issues_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/issues{/number}",
            "pulls_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/labels{/name}",
            "releases_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/releases{/id}",
            "deployments_url": "https://api.github.com/repos/Chalarangelo/30-seconds-of-code/deployments",
            "created_at": "2017-11-29T17:35:03Z",
            "updated_at": "2018-02-21T14:37:38Z",
            "pushed_at": "2018-02-20T20:25:45Z",
            "git_url": "git://github.com/Chalarangelo/30-seconds-of-code.git",
            "ssh_url": "git@github.com:Chalarangelo/30-seconds-of-code.git",
            "clone_url": "https://github.com/Chalarangelo/30-seconds-of-code.git",
            "svn_url": "https://github.com/Chalarangelo/30-seconds-of-code",
            "homepage": "https://30secondsofcode.org/",
            "size": 6466,
            "stargazers_count": 17662,
            "watchers_count": 17662,
            "language": "JavaScript",
            "has_issues": true,
            "has_projects": true,
            "has_downloads": true,
            "has_wiki": true,
            "has_pages": true,
            "forks_count": 1709,
            "mirror_url": null,
            "archived": false,
            "open_issues_count": 6,
            "license": {
                "key": "cc0-1.0",
                "name": "Creative Commons Zero v1.0 Universal",
                "spdx_id": "CC0-1.0",
                "url": "https://api.github.com/licenses/cc0-1.0"
            },
            "forks": 1709,
            "open_issues": 6,
            "watchers": 17662,
            "default_branch": "master",
            "score": 1
        },
        {
            "id": 113752225,
            "name": "github-profile-summary",
            "full_name": "tipsy/github-profile-summary",
            "owner": {
                "login": "tipsy",
                "id": 1521451,
                "avatar_url": "https://avatars3.githubusercontent.com/u/1521451?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/tipsy",
                "html_url": "https://github.com/tipsy",
                "followers_url": "https://api.github.com/users/tipsy/followers",
                "following_url": "https://api.github.com/users/tipsy/following{/other_user}",
                "gists_url": "https://api.github.com/users/tipsy/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/tipsy/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/tipsy/subscriptions",
                "organizations_url": "https://api.github.com/users/tipsy/orgs",
                "repos_url": "https://api.github.com/users/tipsy/repos",
                "events_url": "https://api.github.com/users/tipsy/events{/privacy}",
                "received_events_url": "https://api.github.com/users/tipsy/received_events",
                "type": "User",
                "site_admin": false
            },
            "private": false,
            "html_url": "https://github.com/tipsy/github-profile-summary",
            "description": "Tool for visualizing GitHub profiles",
            "fork": false,
            "url": "https://api.github.com/repos/tipsy/github-profile-summary",
            "forks_url": "https://api.github.com/repos/tipsy/github-profile-summary/forks",
            "keys_url": "https://api.github.com/repos/tipsy/github-profile-summary/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/tipsy/github-profile-summary/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/tipsy/github-profile-summary/teams",
            "hooks_url": "https://api.github.com/repos/tipsy/github-profile-summary/hooks",
            "issue_events_url": "https://api.github.com/repos/tipsy/github-profile-summary/issues/events{/number}",
            "events_url": "https://api.github.com/repos/tipsy/github-profile-summary/events",
            "assignees_url": "https://api.github.com/repos/tipsy/github-profile-summary/assignees{/user}",
            "branches_url": "https://api.github.com/repos/tipsy/github-profile-summary/branches{/branch}",
            "tags_url": "https://api.github.com/repos/tipsy/github-profile-summary/tags",
            "blobs_url": "https://api.github.com/repos/tipsy/github-profile-summary/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/tipsy/github-profile-summary/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/tipsy/github-profile-summary/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/tipsy/github-profile-summary/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/tipsy/github-profile-summary/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/tipsy/github-profile-summary/languages",
            "stargazers_url": "https://api.github.com/repos/tipsy/github-profile-summary/stargazers",
            "contributors_url": "https://api.github.com/repos/tipsy/github-profile-summary/contributors",
            "subscribers_url": "https://api.github.com/repos/tipsy/github-profile-summary/subscribers",
            "subscription_url": "https://api.github.com/repos/tipsy/github-profile-summary/subscription",
            "commits_url": "https://api.github.com/repos/tipsy/github-profile-summary/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/tipsy/github-profile-summary/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/tipsy/github-profile-summary/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/tipsy/github-profile-summary/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/tipsy/github-profile-summary/contents/{+path}",
            "compare_url": "https://api.github.com/repos/tipsy/github-profile-summary/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/tipsy/github-profile-summary/merges",
            "archive_url": "https://api.github.com/repos/tipsy/github-profile-summary/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/tipsy/github-profile-summary/downloads",
            "issues_url": "https://api.github.com/repos/tipsy/github-profile-summary/issues{/number}",
            "pulls_url": "https://api.github.com/repos/tipsy/github-profile-summary/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/tipsy/github-profile-summary/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/tipsy/github-profile-summary/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/tipsy/github-profile-summary/labels{/name}",
            "releases_url": "https://api.github.com/repos/tipsy/github-profile-summary/releases{/id}",
            "deployments_url": "https://api.github.com/repos/tipsy/github-profile-summary/deployments",
            "created_at": "2017-12-10T13:29:15Z",
            "updated_at": "2018-02-21T14:31:37Z",
            "pushed_at": "2018-02-04T13:31:47Z",
            "git_url": "git://github.com/tipsy/github-profile-summary.git",
            "ssh_url": "git@github.com:tipsy/github-profile-summary.git",
            "clone_url": "https://github.com/tipsy/github-profile-summary.git",
            "svn_url": "https://github.com/tipsy/github-profile-summary",
            "homepage": "https://github-profile-summary.com/",
            "size": 3162,
            "stargazers_count": 17332,
            "watchers_count": 17332,
            "language": "Kotlin",
            "has_issues": true,
            "has_projects": true,
            "has_downloads": true,
            "has_wiki": true,
            "has_pages": false,
            "forks_count": 304,
            "mirror_url": null,
            "archived": false,
            "open_issues_count": 9,
            "license": {
                "key": "apache-2.0",
                "name": "Apache License 2.0",
                "spdx_id": "Apache-2.0",
                "url": "https://api.github.com/licenses/apache-2.0"
            },
            "forks": 304,
            "open_issues": 9,
            "watchers": 17332,
            "default_branch": "master",
            "score": 1
        }, ......................
		
		Coding
		1.Creating New Project
		
		start by creating a new android project. We’ll build a simple app which fetches the json from url, parses it and displays the contacts in a list view. Here we’ll use import java.net libraries (which are natively supported in android) to make the http call and fetch the json from url.
		As we are fetching the JSON by making HTTP calls, we need to add INTERNET permission in AndroidManifest.xml file.
		
		2.Create HttpHandler
		
		Create a class named HttpHandler.java to make http call to particular url and fetche the response. In our case, we use this to get the raw json from the url.
		
		3.Adding the views
		
		we'll add a list view first in our view and another layout file named list_item.xml which will be used to render single list item view.
		
		4. Open MainActivity.java to declare the necessary variables for the list view.
		
		5. As we are getting the JSON by making HTTP call, we add an Async class GetItems to make http calls on background thread. 
		In onPreExecute() method progress dialog is shown before making the http call.

		In doInBackground() method, makeServiceCall() is called to get the json from url. Once the json is fetched, it is parsed and each item is added to array list.

		In onPostExecute() method the progress dialog is dismissed and the array list data is displayed in list view using an adapter.

		getJSONArray() or getJSONObject() method depend on the type of data.
		
		6. Button More
		
		Accessing an url which will give paged XML by taking page number.