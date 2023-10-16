# assignment 2

This is a project to implement KWIC (Key World In Context) in 2 architectural designs (ADT & Pipe and Filter)(Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Download the codes from :https://github.com/TIC3001/tic3001-ay2122s2-15.git
2. Extract the zip file downloaded.

3. Copy & paste the input text files in the same directory as 'README.md'

4. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)

5.Open the project into Intellij as follows:
   	a. Click `Open`.
   	b. Search for the correct directory:
	Downloads(if you extract here) ---> tic3001-ay2122s2-15-master --> ---> tic3001-ay2122s2-15-	master and click 	`OK`.
   	c. If there are any further prompts, accept the 	defaults/Trust the project.

6. Go to `Project Strcuture`, Configure the project to use **JDK 17** (not other versions) and choose 'Project language level' to the `17(Preview)` option.

7. There will be a message on bottom right corner (Maven build script found). Click the "Load" button. 

8. Then, follow below steps to run:
	a)Go to (click on the expand arrow) 'src' -> 'main' -> 	'java' -> 	'abstract_data_type'
	b)Locate 'Main' and right-click it, and choose `Run 	Main.main()` 
	
(if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
   Please enter your input text file name with Extension (.txt): 

9. Note that, you will need to key in 3 file name to generate the output file:
	a) Input text file name with Extension(.txt)
	b) Ignored text file name with Extension(.txt)
	c) Required text file name with Extension(.txt)

*Must key in correct Ignored text file name and Required text file name even though the content can be empty.
