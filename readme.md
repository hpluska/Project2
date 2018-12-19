## Project 2: Project PlayList

* Author: Carson Wright
* Class: APCSA Period 2
* Semester: Winter 2018

## Overview
This program takes input from the user and outputs a playlist ordered by length, the song closest to four minutes, and the average playtime.

## Compliling and Using
To compile, execute sudo chmmod 777 grader.sh
Then execute ./grader.sh while in the P2Test folder 
The inputted values by the grader will then be printed in playlist 
format with the average play time and the song closest to four minutes.

## Discussion
My goal in this project was to take x number of songs, order them by playtime, find the song closest to four minutes, find the average playtime, and display them all in a formatted table.
To convert the time inputed (mm:ss) into plain seconds, I used an array and split the String based on the ":", then I used parseInt to convert it to an integer.
To sort the songs by play time I used a for loop to cycle through the array and an if statement to determine whether the song was larger than the current largest. If it was larger I put it in the 0 position of a second array and moved every other item in the array back.
To find the average play time I used a for loop to cycle through the songs and add their playtimes, then I divded the total play times by the number of songs.
To find the song closest to four minutes I used a for loop to compare each song. If the song was the current closest I saved it as an object.

## Sources Used
I used Minjun's method for converting the (mm:ss) string to an int.
