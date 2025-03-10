@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.kotlin.jvm.get().pluginId)
  alias(libs.plugins.arrowGradleConfig.kotlin)
  alias(libs.plugins.arrowGradleConfig.publish)
  alias(libs.plugins.arrowGradleConfig.versioning)
  alias(libs.plugins.animalsniffer)
  `java-library`
}

animalsniffer {
  sourceSets = sourceSets.find { it.name == "main" }?.let(::listOf).orEmpty() // Ignore tests
  ignore = listOf("java.lang.*")
}

dependencies {
  compileOnly(libs.animalsniffer.annotation)
  signature("net.sf.androidscents.signature:android-api-level-21:5.0.1_r2@signature")
  implementation(libs.arrowCore)
  implementation(libs.jacksonModuleKotlin)
  testImplementation(libs.arrowCoreTest)
  testImplementation(libs.kotest.property)
  testImplementation(libs.kotest.runnerJUnit5)
}
