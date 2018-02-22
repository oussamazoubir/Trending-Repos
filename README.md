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
            "owner": {
                "login": "Chalarangelo",
                "id": 8281875
            },
            "description": "Curated collection of useful Javascript snippets that you can understand in 30 seconds or less.",
            "stargazers_count": 17662
        },
        {
            "id": 113752225,
            "name": "github-profile-summary",
            "owner": {
                "login": "tipsy",
                "id": 1521451
            },
            "description": "Tool for visualizing GitHub profiles",      
            "stargazers_count": 17332,
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
		
		7. Design Pattern used : Abstract Factory
		
		we used the abstract factory as creational pattern to create a view for each data raw, meaning for each data object that we retreive from the Json response. 