@echo off
setlocal
echo Swing Example

echo Starting...
cd book_manager/bookInterface
javac -cp ../../;/book_manager/bookInterface *.java
echo compiled bookInterface
cd ../buttonsUtil
javac -cp ../../;/book_manager/buttonsUtil *.java
echo compiled buttonsUtil
cd ../../
javac -cp .;Recommend.jar InterestButtonAction.java
javac -cp .;Recommend.jar PopularityButtonAction.java

javac -cp .;Recommend.jar GUITest.java
java -cp .;Recommend.jar GUITest.java



:end
