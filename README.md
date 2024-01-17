# KWIC implementation  using Pipes and Filters

### Authors:

Christina Zektser

Caleb Harisson

## Description:

Pipes and filters is a Data Flow style

This style is reusable and modifiable

What are Filters?

* Filters are independent entities and do not share state
* Filters can't communicate directly with each other.
* Filters transform data

What are pipes?

* Filters communicate using pipes.

How to build the project:
1. mvn clean install
3. java -jar target/kwic-1.0-SNAPSHOT.jar ./words



