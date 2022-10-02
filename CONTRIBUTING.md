### 1. Fork this Repository
By using the links at the top of this repository, you can fork and star it on GitHub.

### 2. Clone the Repository

To make a local copy of the forked repository, let’s first open up a terminal window.

The URL pointing to your fork of the repository will be used together with the 'git clone' command.

This URL will consist of your username and it will end with `.git`. The URL will look like this: ```https://github.com/your-username/repo-name.git```

You can copy the ```https``` url from the ```Code``` Button on the right side of the repo

<img width="355"  margin-left="0"  alt="image" src="https://user-images.githubusercontent.com/73652194/193419313-e44cacc8-6f95-4e4b-ad79-002925f35a60.png">

Once we have the URL, we’re ready to clone the repository. To do this, we’ll combine the git clone command with the repository URL from the command line in a terminal window:

````bash
$ git clone https://github.com/your-name/Development-App.git
````


### 3. Create a New Branch

Change your directory in your terminal window so that you are working in the repository's directory before creating your branch. Switch into that directory by using the following Command.

````bash
$ cd Development-App/
````

Using the git branch command, we'll now create a new branch. To ensure that other project participants understand what you are working on, give it a name that is descriptive to your issue.
````bash
$ git branch new-branch
````


Now that our new branch is created, we will switch over to it using the git checkout command:
````bash
$ git checkout new-branch
Switched to branch 'new-branch'
````
### 4. Make changes on your Machine
Now make the required changes as you think.

Once you have modified existing files or added new files to the project, you can add them to your local repository, which you can do with the git add command. 

````bash
$ git add . 
````
Now that we have staged our changes, It's time to commit our changes.

You can use the following Command to commit as taught in the Seminar.

Example:
````bash
$ git commit -m "Updated Readme.md"
[main (root-commit) e024518] Updated Readme.md
1 file changed, 1 insertion(+)...
````

At this point you can use the git push command to push the changes to the current branch of your forked repository:
Example:
````bash
$ git push --set-upstream origin new-branch
````   
You have created a new Branch on your forked repository, It should look like the this.

<img width="923"  margin-left="0"  alt="image" src="https://user-images.githubusercontent.com/73652194/193456344-c97163ad-5cbd-4a4b-b35a-aea225438a69.png">

Now simply create a pull request by Clicking ```Compare and pull request```

<img width="914" alt="image" src="https://user-images.githubusercontent.com/73652194/193456638-80e578a6-5e66-4a15-88ea-4c360236bb19.png">

Now Click on ```Create pull request``` and Viola! You have Issued your First Pull Request!


