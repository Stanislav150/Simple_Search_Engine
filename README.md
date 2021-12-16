# Simple_Search_Engine
Project Simple Search Engine

The project consists of six stages. As you progress through the stages, the tasks and structure of the project change. At the final stage, you need to implement the following functionality.

Read the contents of the file and save it in a suitable structure. The contents of the file must be specialized, it can describe:

1.  a person, represented by a first name, last name, and an optional email;

2.  an address of a building, represented by country, city, state, street, and zip code;

3.  information about a book, represented by ISBN, title, author/authors, publisher, and so on.

I am analyzing a file with personal data.

Display the menu as:

=== Menu ===

1. Find a person

2. Print all persons

0. Exit

If you select 1, the following menu is displayed, which allows you to choose from three options for displaying information: ALL, ANY or NONE.

• If the strategy is ALL, the program should print lines containing all the words from the query.

Query:

Harrington Erick

Result:

Erick Harrington harrington@gmail.com

• If the strategy is ANY, the program should print the lines containing at least one word from the query.

Query:

Erick Dwight webb@gmail.com

Result:

Erick Harrington harrington@gmail.com

Erick Burgess

Dwight Joseph djo@gmail.com

Rene Webb webb@gmail.com

• If the strategy is NONE, the program should print lines that do not contain words from the query at all:

Query:

djo@gmail.com ERICK

Result:

Katie Jacobs

Myrtle Medina

Rene Webb <webb@gmail.com>

All listed operations are implemented in the inverted index. The results should not contain duplicates.

Example

The lines that start with > represent the user input. Note that these symbols are not part of the input.

=== Menu ===

1. Find a person

2. Print all persons

0. Exit

> 1

Select a matching strategy: ALL, ANY, NONE

> ANY

Enter a name or email to search all suitable people.

> Katie Erick QQQ

3 persons found:

Katie Jacobs

Erick Harrington harrington@gmail.com

Erick Burgess




