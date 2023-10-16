# assignment 3

This is a project to implement KWIC (Key World In Context) in architectural design (ADT)(Given below are instructions on how to use it.

## Setting up in Windows Laptop


1. Download the codes from :https://github.com/TIC3001/tic3001-ay2122s2-15.git
2. Extract the zip file downloaded.

3. Copy & paste the text files in the same directory as 'README.md'

4.Note that, you will need to key in 3 file name to generate the output file:
	a) Input text file name with Extension(.txt) or 			Extension(.in)
	b) Ignored text file name with Extension(.txt)
	c) Required text file name with Extension(.txt)

5. After copy, right click mouse and click "Open in Windows Terminal" in the same directory of 'READ.md'.
Alternatively, you can open Windows Terminal anywhere and open the correct directory.

6.Copy and paste the command line below to run program:
	6.1. Search list of items with ignore and required filters
	Java -jar kwic.jar <Search keyword> <Input> <Ignored> <Required>
	<Search keyword> = search / Search
	<Input> = XXX.in
	<Ignored> = XXX.txt
	<Required> = XXX.txt
	
	6.2 Search list of items without ignore and required filters
	Java -jar kwic.jar <Search keyword> <Input>
	<Search keyword> = search / Search
	<Input> = XXX.in

7.Once program run, you can search the keyword. 
