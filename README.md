# Brick-Breaker

This is a simple game in Java. Brick breaker, as you might know, is a game where a paddle bounces a ball towards bricks. When colliding, it removes the brick and awards a certain amount of points. This game is a work in progress and not yet complete.

## [Main file](V2/Main.java):

This file creates the window (as an instance). More functionality can be added here later, but for now, it's just a place to start from. **Only need to compile this file and run it to launch the game.**

<!--This file creates the window (as an instance). More functionality can be added here later, but for now, it's just a place to start from. **Only need to compile this file and run it to launch the game.**-->

## MyFrame:

This file handles the window creation primarily using AWT and some of its sublibraries. All aspects regarding the windows, such as rendering and events, are handled here. Then, the other logic classes, such as movement, collision, etc., are called here to be rendered. Methods like `getHeight()` are used to ensure that different-sized windows don't interfere with the game's logic.

## Ball:

This class creates a ball and keeps track of its current position, velocity, and size.

## Bricks:

This section deals with the creation of the paddle that moves and the bricks that the ball can collide with. Collision with bricks is also handled here. The simple idea is to check if the x position at the top of the ball is the same as a brick's. Then, determine in which y range it is located and remove the corresponding brick. The creation involves starting at a position and moving positively in the x direction until the next brick is outside the screen. Then, restart the x position and move some y direction down the screen (here it's positive because the top left corner is point (0,0)).

## Collision:

This class handles the collision for the ball and the paddle. The reason brick collision is not done here is that all the brick data is located in the `Bricks` class and doesn't need to be used as arguments for the collision class. The focus here is on the paddle, ensuring it stops at the edges of the screen. The ball's position needs to be updated if there is a collision, with a change in velocity in either or both directions by *(-1). This is done both with the walls and the paddle. It all comes down to constantly checking the positions of everything.

