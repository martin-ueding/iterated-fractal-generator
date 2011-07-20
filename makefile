# Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>

.PHONY: IteratedFractalGenerator.jar
IteratedFractalGenerator.jar:
	javac IteriertesFunktionssystem.java
	jar cfm $@ manifest.txt *.class *.java

clean:
	$(RM) *.class *.jar
