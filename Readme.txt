To start the project follow the steps

1.download and import the project in sts
2.Run on terminal any of these command 
and also first "test_project" is "database name" so create first 

mysql -u root -p test_project < example.sql  OR  mysqlimport -u root -ptecmint test_project < example.sql
3.open application.properties under resources and set your database username password after that save and run as spring boot

4. check database and after that check with postman 
Refer final test or controllers for assistance

