make sure you have the maven eclipse plugin installed

check out

make sure you have tomcat 6 installed (say in c:\apache-tomcat-6.0.36)
with username 'tomcat' and password 's3cret' with manager role
if you have the install elsewhere or with other credentials, you will
need to create your own environment specific build-YOURMACHINE.properties
in the build directory. If you run 'ant clean' it will tell you the filename
it will look for in the first couple of lines of output.
Copy and existing one and change as neeed.

go to the db directory

run the server.bat

in a command  console or 

ant db-create-tables  (this is a once only task unless you drop the db)
ant db-load-data (optional - tests do this as well)
ant test-all

or if you are brave

ant deploy
