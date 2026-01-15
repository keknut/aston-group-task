#!/bin/bash
javac -d out \
  -cp "src:src/test/java:lib/*" \
  src/test/java/src/CarTest.java
java -cp "out:src:lib/*" \
  org.junit.platform.console.ConsoleLauncher --scan-classpath out
