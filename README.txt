1.Prerequisites :

    1. JDK 1.8
	2. MySQL 8.11
	3. Maven 3.0.4 
	4. Eclipse (Oxygen) or Spring Tool Suite 3.9.3 (STS)
	
2. Environment setup
 
    1. Install jdk and make sure the java.exe in in path
	2. Install mysql ( user name : root password : root01)
	3. Install Spring Tool Suite 
	4. Install maven and set the path to mvn 
	5. Import the project to STS as a maven project
	
3. Building the project 

    Option 1 : build the project in IDE (STS) using a RightClick(project folder) -> Run As ->maven build... -> Goals (clean install)
	
	Option 2 : Using Command prompt : mvn -s settings.xml clean install
	
	Note : settings.xml should refers to maven repository, It should be specific to your environment.
	 
4. Running the Application

   1. create the DB schema using mysql workbench
       release\create-schema.xml
	   
   2. Run Application   
      java -jar release\dimensiondata-assignment-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar
	  
	  Note : use release\server_defination.xml file to load data 
	  
   3. Delete the schema using mysql workbench
       release\drop-schema.sql
