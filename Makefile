all: compile compileTest

Simple: compileTest runCov calCov showCov

compile:
	mkdir -p bin
	javac src/Deposit.java src/Acount.java -d bin

compileTest:
	mkdir -p bin
	javac -cp .:/usr/share/java/junit4.jar:/usr/share/java/mockito-core.jar src/Deposit.java src/Acount.java \
	testcase/TestDeposit.java testcase/TestRunner.java -d bin

test:
	cd bin ; java -cp .:/usr/share/java/junit4.jar:/usr/share/java/mockito-core.jar TestRunner

runCov:
	rm bin/*.exec 2> /dev/null || true
	cd bin ; java -javaagent:../lib/jacocoagent.jar -cp .:/usr/share/java/junit4.jar:/usr/share/java/mockito-core.jar TestRunner

calCov:
	cd bin ; java -jar ../lib/jacococli.jar report jacoco.exec --classfiles ../bin \
	--sourcefiles ../src --sourcefiles ../testcase --xml ../jacoco.xml --html reportDir

showCov:
	RED="\033[0;31m" ; NC='\033[0m' ; printf "$${RED}http://" ; curl -s https://api.ipify.org/ ; printf ":8000/$${NC}\n"
	cd bin/reportDir ; python3 -m http.server 8000

kill:
	killall python3

clean:
	rm -r bin/*.class bin/*.exec jacoco.xml bin/reportDir || true
