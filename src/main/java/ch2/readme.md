### Finding the first non-repeated character

Write a program that returns the first non-repeated character from a given string

#### Note:

* Accept a `String` parameter
* Return `Char`

#### Initial Idea:

* Assume all characters fall within the **ASCII** table. thus a value from 0-255
* Create a Map of Character and Integer
* Loop over the given String
* Check if a key value exists
* If no key exists, add its char number has the key, and 0 has the value.
* If key exists, change key value to -1
* After Loop ends get first key with value

#### Initial Idea Outcome:

* The Solution failed because the order of input in the HashMap is not maintained.
* I should I have used a `LinkedHashMap`, with a `LinkedHashMap` the test passes.

#### Suggested Solution:
