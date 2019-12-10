# Critique

Please read the instructions, requirements and task descriptions carefully and submit the answers
as instructed.

## About Assignment

There are three tasks in this assignment. The tasks should be completed in order, which means first
task need to be completed first, then the second task and finally the third task.

### Deadline
The first task has a deadline. You can take at most 45 minutes for the first task. For the second and
third task we recommend to use 2 - 3 hours.

### Submission Instructions
Please submit the first task by sending an email to us. The second and third task should be submitted by creating a git project to view.

### Requirements
* The code should be maintainable and scalable.
* We encourage you to use Java to solve the problem.

### Please Note That
* The JSON response from the REST API server is always static.
* Our purpose is to understand your skill sets and how you write clean/readable & maintainable code.

## Tasks

### Task 1: Code Review [max 45 min, submit by email]

Please study the code and find out what kind of issues are slowing down the performance of this application.
Please explain what should be fixed, how, and why? All factors that affect performance will be appreciated,
even if they only affect older devices. Any other improvement suggestions to the app are considered a plus.

At a quick glance, it is possible to identify at least 5-10 problems that affect performance.
You can reply with just an email that points to the locations in the code where the problems are,
or attach the relevant source code files where you have point out the problems as comments.


### Task 2: Modify the Application [submit by creating a pull request against the `master` branch]

Modify the application, so that instead of using the photos from `res/drawable`, the application will fetch
photos from a remote server and display into the list view randomly.
The application should have the capability of displaying `N` number of images in the list, which means there can be repetition of photos/text in the list.

To get the image URLs, we have prepared a *Fake* REST API server with one API end point.

This API end point returns a JSON response having the information about the sample image URLs.
You have to generate the URLs from the JSON response and fetch the images using that generated URLs.

### Task 3: Adding Animation [submit by creating a pull request against the `master` branch]

Animate each list item when user scrolls the image-list according to the following animation:

![](sample/animation.gif)

Note: You may choose different animation than the suggested, if you find the suugested one difficult to implement.
