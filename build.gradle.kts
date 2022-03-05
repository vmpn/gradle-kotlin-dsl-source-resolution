plugins {
  java
}

repositories {
    maven { url = uri("https://repo.gradle.org/gradle/libs-releases") }
    mavenCentral()
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
  dependsOn("build")
  classpath = configurations.runtimeClasspath.asFileTree + project.the<SourceSetContainer>()["main"].output
  mainClass.set("RunTool")
  args(
    listOf
    (
        project.projectDir
    )
  )
}


tasks.register<JavaExec>("downloadDependencies") {
  dependsOn("build")
  classpath = configurations.runtimeClasspath.asFileTree + project.the<SourceSetContainer>()["main"].output
  mainClass.set("NoOp")
}
