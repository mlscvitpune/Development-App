### 1. Fork this Repository
You can star and fork this repository on GitHub by navigating at the top of this repository.

<!-- ![Fork this repository](https://camo.githubusercontent.com/b22b37874052e69f2e83743b5763440aec7af332e6ea51df6b86652a343d8b6e/68747470733a2f2f68656c702e6769746875622e636f6d2f6173736574732f696d616765732f68656c702f7265706f7369746f72792f666f726b5f627574746f6e2e6a7067) -->

<!-- After forking, you will see two repositories with the same name 'dsc-hacktoberfest-2021'. 
  - dscvitpune/dsc-hacktoberfest-2021
  - your-username/dsc-hacktoberfest-2021

You can make changes directly to **your** repository i.e. `your-username/dsc-hacktoberfest-2021` but you cannot make changes to **this** repository directly. You can contribute here by submitting your chnages as `pull requests`. -->


### 3. Clone the Repository

To make a local copy of the forked repository, let’s first open up a terminal window.

We’ll use the `git clone`  command along with the URL that points to your fork of the repository.

This URL will consist of your username and it will end with `.git`. The URL will look like this: ```https://github.com/your-username/repo-name.git```

You can copy the ```https``` url from the ```Code``` Button on the right side of the repo

<img width="355"  margin-left="0"  alt="image" src="https://user-images.githubusercontent.com/73652194/193419313-e44cacc8-6f95-4e4b-ad79-002925f35a60.png">

Once we have the URL, we’re ready to clone the repository. To do this, we’ll combine the git clone command with the repository URL from the command line in a terminal window:

````bash
$ git clone https://github.com/your-name/Development-App.git
````


### 4. Create a New Branch

To create your branch, from your terminal window, change your directory so that you are working in the directory of the repository. Be sure to use the actual name of the repository to switch into that directory.

````bash
$ cd Repo-name/
````

Now, we’ll create new branch with the git branch command. Make sure you name it descriptively so that others working on the project understand what you are working on.
````bash
$ git branch new-branch
````


Now that our new branch is created, we will switch over to it using the git checkout command:
````bash
$ git checkout new-branch
Switched to branch 'new-branch'
````

At this point, you can now modify existing files or add new files to the project on your own branch.

#### Make Changes Locally

Once you have modified existing files or added new files to the project, you can add them to your local repository, which you can do with the git add command. 

````bash
$ git add . 
````

Next, we’ll want to record the changes that we made to the repository with the git commit command.

*The commit message is an important aspect of your code contribution; it helps the other contributors fully understand the change you have made, why you made it, and how significant it is. Additionally, commit messages provide a historical record of the changes for the project at large, helping future contributors along the way.*


If you have a very short message, you can record that with the -m flag and the message in quotes:

Example:
````bash
$ git commit -m "Updated Readme.md"
[main (root-commit) e024518] Updated Readme.md
1 file changed, 1 insertion(+)...
````

###### At this point you can use the git push command to push the changes to the current branch of your forked repository:
Example:
````bash
$ git push --set-upstream origin new-branch
````   

