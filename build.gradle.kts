plugins {
  java
}

repositories {
    maven { url = uri("https://repo.gradle.org/gradle/libs-releases") }
}

configurations {
  create("tooling") {
    isCanBeResolved = true
    isCanBeConsumed = false
  }
}

dependencies {
  implementation("org.gradle:gradle-tooling-api:7.4")
  runtimeOnly("org.slf4j:slf4j-simple:1.7.10")
}


tasks.register<JavaExec>("testKotlinModel") {
  classpath = configurations.get("tooling").asFileTree
  mainClass.set("RunTool")
}
