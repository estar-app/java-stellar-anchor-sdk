// The alias call in plugins scope produces IntelliJ false error which is suppressed here.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  `java-library`
  alias(libs.plugins.spring.boot)
  alias(libs.plugins.spring.dependency.management)
  alias(libs.plugins.kotlin.jvm)
}

dependencies {
  implementation("org.springframework.boot:spring-boot")
  implementation("org.springframework.boot:spring-boot-autoconfigure")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation(
      libs.snakeyaml) // used to force the version of snakeyaml (used by springboot) to a safer one.
  implementation("org.springframework.boot:spring-boot-starter-web")

  implementation(libs.commons.cli)
  implementation(libs.dotenv)
  implementation(libs.java.stellar.sdk)
  implementation(libs.google.gson)
  implementation(libs.okhttp3)
  implementation(libs.log4j2.api)
  implementation(libs.log4j2.core)
  implementation(libs.log4j2.slf4j)
  implementation(libs.docker.compose.rule)
  implementation(libs.stellar.wallet.sdk)
  implementation(libs.ktor.client.core)
  implementation(libs.ktor.client.okhttp)

  // project dependencies
  implementation(project(":api-schema"))
  implementation(project(":core"))
  implementation(project(":platform"))
  implementation(project(":anchor-reference-server"))
  implementation(project(":kotlin-reference-server"))
  implementation(project(":service-runner"))

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

  testImplementation(libs.okhttp3.mockserver)
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation(libs.docker.compose.rule)
  testImplementation(libs.dotenv)
}

tasks { bootJar { enabled = false } }
