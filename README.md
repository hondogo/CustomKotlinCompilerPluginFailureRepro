```
w: file:///home/prj/module2/src/commonMain/kotlin/p2/test.kt:9:5 Detected a @Composable function that overrides an open function compiled with older compiler that is known to crash at runtime. Consider recompiling the dependency with a newer compiler version (>= 2.1.20) to get correct behavior. See https://issuetracker.google.com/165812010 for more details.
```

### to see warning

./gradlew clean build

### to see compose compiler version

./gradlew module1:dependencies module2:dependencies | grep kotlin-compose-compiler-plugin