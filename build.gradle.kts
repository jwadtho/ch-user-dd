//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//
//plugins {
//	id ("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
//	id("org.springframework.boot") version "2.5.2"
//	id("io.spring.dependency-management") version "1.0.11.RELEASE"
//	id("org.graalvm.buildtools.native") version "0.9.0"
//
//	kotlin("jvm") version "1.5.20"
//	kotlin("plugin.spring") version "1.5.20"
//}
//
//group = "com.tootest.ch"
//version = "0.0.1-SNAPSHOT"
//java.sourceCompatibility = JavaVersion.VERSION_1_8
//
//repositories {
//	mavenCentral()
//	maven { url = uri("https://repo.spring.io/release") }
//	maven { url = uri("https://jitpack.io") }
//}
//
//dependencies {
//	runtimeOnly ("mysql:mysql-connector-java")
//	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation ("com.github.jkcclemens:khttp:0.1.0")
//	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-starter-actuator")
//	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//	implementation("org.jetbrains.kotlin:kotlin-reflect")
//	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//}
//
//allOpen {
//	annotation("javax.persistence.Entity")
//}
//
//
//tasks.withType<KotlinCompile> {
//	kotlinOptions {
//		freeCompilerArgs = listOf("-Xjsr305=strict")
//		jvmTarget = "1.8"
//	}
//}
//
//tasks.withType<Test> {
//	useJUnitPlatform()
//}


//


import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
	kotlin("plugin.jpa") version "1.5.21"
}

group = "com.tootest"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
	maven { url = uri("https://jitpack.io") }
}

dependencies {
	implementation ("com.github.jkcclemens:khttp:0.1.0")
	runtimeOnly ("mysql:mysql-connector-java")
	//	Spring
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}