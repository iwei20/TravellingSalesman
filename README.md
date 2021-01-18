# TravellingSalesman
Travelling Salesman solution, Mr. K 2021

# Minutes:
## During class:
- Initially, during class, we discussed methods that involved more fancy algorithms such as Depth-First or Breadth-First search to solve this without recursion.
- However, Mr. K came into our breakout room, and after we told him about our proposed methods, we were told that he wanted us to use brute force.
- We also discussed how to store the distances: Mr. K eventually gave the answer in #live-instruction, which was to use an adjacency matrix where adj[city1][city2] = dist_1,2

## After class:
- Ivan thought up a solution involving storing all incomplete paths/permutations in a list and extending them with all possibilites until they are full length.
- Ivan made a repo containing some of the code for his solution and invited the rest of the group as collaborators.
- We later on created a Facebook group chat.
- After some discussion, we agreed to have a Zoom meeting, Sunday at 4:20 PM.

## The Zoom meeting:
- Ivan started off by screen sharing and explaining what he had thought up previously.
- Jason had also done some thinking, and proposed a solution involving Linked Lists and swaps.
- Jerry noted that something could come out of an observation that given an optimal path, the path between the start city and the city before the end city on the path is also optimal.
- The whole group worked together to take apart each of our solutions, asking questions and analyzing time complexity. 
- We decided to go through Ivan's solution, since he had already coded most of it.
- We discussed how to correctly parse the data given by Mr. K.  We ended up doing two loops, the first to store the number and names of cities, the second to fill an adjacency matrix.
- After that, we got our solution to the sample input Mr. K gave: 207.
- Ivan also implemented a way to get the path in the form of the a list of indices of `cityNames`.
- We tried to verify that the solution was correct, but we didn't know how - online TSP calculators seemed to produce paths that had greater cost.
- We tried to look at the time complexity of the solution, but we couldn't figure it out because it was hard to factor in generation of incomplete paths and what happened when the path went over cities it already contained.  
- However, it ran near instantly on Ivan's machine.

## After the Zoom meeting:
- Jason continued to work on his solution that involved LinkedList and sublist reversals on his own branch
- He coming up with a working implementation, getting the same solution as Ivan, 207
- After Jason made optimizations, he compared the time it took to run both solutions
- Ivan's took an astounding 0.048 sec on his computer, and Jason's took 0.014 sec
- Jason typed too fast in excitement and managed to break his code without noticing, pushing his broken code to github

TODO
# Explanation of our solution:
## Parsing
## Solving
## Why a custom Path object?
## Time complexity
