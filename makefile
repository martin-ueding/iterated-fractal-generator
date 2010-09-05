.PHONY: IteratedFractalGenerator.jar
IteratedFractalGenerator.jar:
	javac IteriertesFunktionssystem.java
	jar cfm IteratedFractalGenerator.jar manifest.txt *.class *.java
