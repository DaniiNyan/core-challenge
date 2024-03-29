# Core Challenge

### Summary:
- What is?
- How it works?
- Architecture
- Future features
- About the challenge

## What is?
It's a data analysis system. It's able to read a lot of specific flat files, analyse the data inside it and output a report. 

## How it works?
The system reads all `.dat` files from `/data/in` folder. 
To be read, files must contain data in one of the three following format:
<br>

Salesman data: id 001 <br>
- `001çCPFçNameçSalary`

Customer data: id 002 <br>
- `002çCNPJçNameçBusiness Area`

Sales data: id 003 <br>
- `003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name`

A single file can have one or more data type. All of them are identified by ID. <br>
The system supports almost every delimiter including `ç`. Feel free to test it with another one like `/`, `-` or anyone you prefer.

---
System analyses all data inside `data/in` folder and write a report in `data/out` folder. <br>
Report has the following fields:
- Amount of customers;
- Amount of sellers;
- ID from most expensive sale;
- Name of worst salesman;

To work correctly, the `data_analysis.done.dat` file must already exists in `data/out` folder. 
This file is updated every time a change occurs inside `data/in` folder. 

## Architecture
System has four modules: <br>
- DAO: to read input file and write the output;
- Service: to process data from DAO, analyse and return a result;
- Parser: to help Service parse Strings from DAO to system's objects;
- Domain: to represent and manager system's contents;

`Application` is the Main class. It starts a `Watcher` thread. <br>
`Watcher` is responsible for listen `data/in` folder and call `DataAnalyzer` whenever the folder has a change. <br>
`DataAnalyzer` updates the report inside `data/out`folder.

The system was built using TDD and has 85% test coverage.
<img src="images/TestCoverage.png">

## Future features
- Create report file in runtime;
- Support escaped delimiters;
- Test with a mock framework;

## About the challenge
This was the final challenge from ilegra's Core Engineering 2019.2 trail. <br>
All participants had four days (24 work hours) to do it individually.