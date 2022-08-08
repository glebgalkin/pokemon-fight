# Pokemon Fight
## Introduction
Pokemon fight is a challenge game made by Bell Media developers for potential employees. The goal of this challenge is to test new developers' technical skills and knowledge of **Spring Boot** Java framework. The game involves two players who can pick pokemons and battle each other. Under the hood the backend makes an api call to [PokeAPI](https://pokeapi.co/), gets the list of pokemons, assembles them in a proper format for the game and displays the list of characters who are ready for battle. Afterwards, a client HTTP request is sent with players' choices as a JSON object in the body. Backend receives the request, validates the data, assembles the game with provided choices and calls the **game engine that starts the show**. When battle between two characters comes to an end backend generates the collection containing all events (an event report) and sends the report back to client. 

*Tools used: Java, Spring Boot, MYSQL.*

## Game Rules
Two players join the fight. Each of them can select a pokemon from the list. The list must present the following attributes of each available character: name, height and weight. As of beginning of the game and each round every character has **twenty health points** (HP) by default. Once characters are chosen, the automatic battle between them begins. *The first who wins two battle rounds is considered the winner*. There are two possible attacks: **normal** and **special**. *Normal attack* has a *damage between one to ten health points* while *special attacks take 2 turns and executes from 5 to 15 points of damage*. When match ends a winner must be displayed. Both players must be able to restart the battle with the same characters or switch to new pokemons. 

## Demo
### Get list of Pokemons:
The giph below describe how client first sends the GET request to a server and recieves the collection of available pokemons.
![](https://github.com/glebgalkin/pokemon-fight/blob/master/media/getPokemons.gif)

### Start the game and generate the report:
Client creates a POST request and provides players' choices in the body. 
As a response it receives the report of a whole battle, step-by-step. 
![alt-text](https://github.com/glebgalkin/pokemon-fight/blob/master/media/game.gif)

### Bonus
As seen in the second request, it is possible to change the characters after every battle or keep them the same. The initial list of pokemons is saved in **MySQL** database, therefore,as long as the client puts the proper choices in the body of a POST request the game will be generated. In case of improper request body the server returns a **Bad Request (400)** response.

## Testing
JUnit testing framework is used to test the functionality of RESTful API and game engine:
![alt text](https://github.com/glebgalkin/pokemon-fight/blob/master/media/tests.png)

## Conclusion
Pokemon fight game is a great creative way to demonstrate Spring Boot experience for employees wishing to become a part of Bell Media. I would like to geniunly thank Bell Media for an opportunity to demonstrate my knowledge. Along with positive outcome there is always a room for growth and improvements that could be planned developed and implemented in the future. 

## Future Improvements
### Scalability 
Higher amount of requests sent to PokeAPI will cause a significant increase of a wait time for a client. There must be an optimal solution to run portions of calls simultaneously. Perhaps, splitting amount of required calls into multiple threads might show the decrease of a wait time, however the more research and knowledge required from my end. 
### Better design approach
The game engine class seems to have a lot of functionality. It is worth of mentioning that some of the functions could be decomposed into separate components. However, in a time and deadline that was given to me the current implementation was the best of my ability. 

