# Team Project
Pigs and Bulls

Description
-----------
This project is for the game: Pigs and Bulls. This game stems from a code breaking game usually played on paper and pencil between two players. In this game the user attempts to decypher an isogram[^1] with a limited number of turns.

In a console, the players each write a 5 character secret word. The characters must all be different. Then, in turn, the players attempt to guess their opponent's word and the program gives the number of matches until the word is found or the player runs out of turns.
1. A correctly guessed letter of the secret word is a Pig.
2. A Correctly guessed letter of the secret word that is also correctly positioned is a Bull.
The player wins when the guessed letters are all bulls: the guess matches the secret.

Source: [Wikipedia](https://en.wikipedia.org/wiki/Bulls_and_Cows)

Status
------
This project is currently in-progress. 
Next steps can be found under our task management page: [Product Backlog](https://github.com/users/ElihuJones/projects/1)

Pseudocode 
----------

Open console/Run Program 
Instructions page: 
User can see Instructions: 
* Play Game or How to Play, options 
  * How to Play will show an Instructions screen: 
    * No duplicate letters, 5 letter UPPERCASE word. 
User can choose 1 player or 2 player game.  

If 1 player is chosen: 

* Computer generates word with no characters repeating, 5 characters long. 
    * **Play Order**: 
      * Player inputs guesses until turns run out (currently 5, the length of the word)
          * Input word checked for valid input, if invalid, output invalid input and state input requirements to the user.  
          * Program compares guess to secret: 
              * A correctly guessed letter of the word is a Pig. 
              * A correctly guessed and positioned letter is a Bull. 
              * Player sees their count of Pigs and Bulls. 
              * If the user guess matches the secret 
                  * the user sees a congratulations message and their turn count upon matching. 
              * If user fails to match by max count 
                  * they see a score screen, and what the word was. 
  * User can choose to play again or exit console. 
            
If 2 players are chosen: 
* Player 1  inputs 5 letter word 
    * Input word checked for valid input, if invalid, output invalid input and state input requirements to the user.  
* Player 2 inputs 5 letter word 
    * Input word checked for valid input, if invalid, output invalid input and state input requirements to the user.  
* Player 1 goes first: 
    * Follows **Play Order** for 1 player 
* Player 2 goes second: 
    * Follows **Play Order** for 1 player 
* Game Victory Conditions for multiplayer 
    * If only 1 player guesses right, that player wins, Victory Message with player # 
    * If both players guess right on the same turn count, TIE Message 
    * If no player guesses correctly, compare scores: 
        * Highest number of bulls between players wins ang gets Message 
            * If bulls is tied, highest number of cows win 
                * If that is tied, they tied. 
* Users can choose to play again or exit console. 

Concerns/Increased Scope Ideas: 
-------------------------------

1. Formatted strings for user's ease in a console environment between windows & mac:  
    * Correctly positioned letter in word is a pig and underlined. 
    * Correctly positioned letter in correct position in word is a bull and is boldened. 

2. Computer generated word: 
    * Choose library/dictionary to retrieve the word from. 
    * Filtering that word for duplicated letters and word size. 

3. Invalid input: 
    * If person is having a hard time selecting a word, programs generate a word. 
    * Generates a list of 3-5 words for the user to select from.  
    * User selects one by typing: <1>, <2>, <3>, <4>, <5> into console 

4. Add a timer: 
    * And a timer that tracks user time elapsed and outputs at the end of the game. 
    * Perhaps a time limit per guess? 

5. See a 26 letter alphabet to help: 
    * Shows updatable alphabet to help, crosses out letters already used 

6. Players can enter their name at the start of the game, stored in an array, and outputted on victory/defeat screen. 

7. For 2 player game, add RNG/Coin Flip for who goes first. 

8. In a 2 player game, If playing again, switch starting player 

9. Users can choose the word size for the computer to generate word from 

[^1]: A word or phrase in which each letter occurs the same number of times
