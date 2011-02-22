# Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>

.PHONY: IteratedFractalGenerator.jar
IteratedFractalGenerator.jar:
	javac IteriertesFunktionssystem.java
	jar cfm IteratedFractalGenerator.jar manifest.txt *.class *.java
