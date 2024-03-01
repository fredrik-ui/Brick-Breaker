Get-ChildItem -Path $directory -Filter *.class | Remove-Item -Force
javac Main.java
java Main