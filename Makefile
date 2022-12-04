parser :
	java -jar ./lib/antlr-4.9.2-complete.jar ./TigerLexer.g4 ./TigerParser.g4 -no-listener -visitor -o ./src/parser

compile :
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin

run :
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main $(target)

all : 
	java -jar ./lib/antlr-4.9.2-complete.jar ./TigerLexer.g4 ./TigerParser.g4 -no-listener -visitor -o ./src/parser
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main $(target)
	