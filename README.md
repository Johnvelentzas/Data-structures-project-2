# Data-structures-project-2
This repository was created as a student project for the course Data structures from the Athens University of economics and business.
The project goal is to create and compare two algorithms that store incoming filders into disks.
The less disks an algorithm uses the more efficient it is.
Each disk can store 1.000.000 MB which for simplicity will be equal to 1 TB of data.
Each folder can have a size of 0 excluded to 1.000.000 included MB.
A folder must be stored in only one disk.
The algorithms can create as many disks as they need to store all the folders.

Greedy algorithm.
The first algorithm puts each incoming folder into the disk with the most available space.

Greedy Decreasing algorithm.
The secont algorithm sorts all the incoming disks from biggest to smallest then executes the first algorithm.

The second algorithm is somewhat slower than the first especially when sorting a lot of folders.

The second algorithm is up to 16% more effective at storing disks.
Its effectiveness is a logarithmic curve begging from 0 with a noticeable limit at 16%.
This means that it can use up to 16% less disks at hight folder numbers.
