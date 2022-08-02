# XXXXXXXXXXXXX This didnt work XXXXXXXXXXXX

Failed at step: where starting node

Udemy link: https://thoughtworks.udemy.com/course/automation-testing-with-selenium-and-java-for-beginners/learn/lecture/11829826#questions

Reference:
https://github.com/in28minutes/automation-testing-with-java-and-selenium

npm install selenium-standalone@latest -g

selenium-standalone install

Start hub 
selenium-standalone start -- -role hub

Hub will be running here
http://localhost:4444/ui/index.html#/

Start node
selenium-standalone start -- -role node -hub http://localhost:4444/grid/register
selenium-standalone start -- -role node -hub http://localhost:4444/grid/register -port 5556