#/bin/bash -ex
# checking java version, should be at least 9
"$JAVA_HOME/bin/java" -version
# cleanup
rm -rf build dist dist-10
# compiling java files
"$JAVA_HOME/bin/javac" -d build/classes src/chapterEleven/*.java src/module-info.java
# adding FXML files 
cp src/chapterEleven/SecondStage.fxml build/classes/chapterEleven/
# building jar
"$JAVA_HOME/bin/javapackager" -createjar -appclass chapterEleven.SimpleApp -outdir dist -outfile SimpleApp.jar -srcdir build/classes
# building stand-alone app
"$JAVA_HOME/bin/jlink" --module-path "dist;$JAVA_HOME/jmods" --add-modules chapterEleven --output dist-10 --strip-debug --compress 2 --verbose --no-header-files --no-man-pages --launcher chapterEleven=chapterEleven/chapterEleven.SimpleApp
# run stand-alone app
./dist-10/bin/chapterEleven