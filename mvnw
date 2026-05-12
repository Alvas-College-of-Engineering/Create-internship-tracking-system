#!/usr/bin/env sh
# ----------------------------------------------------------------------------
# Maven Wrapper
# ----------------------------------------------------------------------------

if [ -n "$MAVEN_WRAPPER_DEBUG" ]; then
  set -x
fi

PRG="$0"

# resolve symlinks
while [ -h "$PRG" ]; do
  ls=$(ls -ld "$PRG")
  link=$(expr "$ls" : '.*-> \(.*\)$')
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=$(dirname "$PRG")/"$link"
  fi
done

PRGDIR=$(dirname "$PRG")

EXECUTABLE_JAR="$PRGDIR/.mvn/wrapper/maven-wrapper.jar"
JAVA_CMD="${JAVA_HOME:-}/bin/java"
if [ ! -x "$JAVA_CMD" ]; then
  JAVA_CMD=java
fi

exec "$JAVA_CMD" -Dmaven.multiModuleProjectDirectory="${PRGDIR}" -classpath "$EXECUTABLE_JAR" org.apache.maven.wrapper.MavenWrapperMain "$@"
