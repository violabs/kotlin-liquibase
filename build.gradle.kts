import java.util.Properties

plugins {
	kotlin("jvm") version "2.1.20"
	id("org.jetbrains.dokka") version "1.9.20"
	id("com.google.devtools.ksp") version "2.1.20-1.0.32"
	id("org.jetbrains.kotlinx.kover") version "0.9.1"
	id("io.violabs.plugins.open.publishing.maven-generated-artifacts") version "0.0.13"
	id("io.violabs.plugins.open.publishing.digital-ocean-spaces") version "0.0.9"
	id("io.violabs.plugins.open.secrets.gradle-loader") version "0.0.3"
}

group = "io.violabs"
version = "0.0.1"
description = "Liquibase DSL for generating changesets"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://www.jetbrains.com/intellij-repository/releases") }
	maven {
		url = uri("https://open-reliquary.nyc3.digitaloceanspaces.com")
	}
}

val dslVersion = "0.0.8"
val metaDslVersion = "0.0.8"

dependencies {
//	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-json:2.19.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.19.0")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.19.0")

	ksp("io.violabs.konstellation:dsl:$dslVersion")
	implementation("io.violabs.konstellation:meta-dsl:$metaDslVersion")

	testImplementation(kotlin("test"))
	testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.0-M1")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("com.fasterxml.jackson.core:jackson-core:2.19.0")
	testImplementation("com.fasterxml.jackson.core:jackson-databind:2.19.0")
	testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.19.0")

	//implementation("io.github.microutils:kotlin-logging:4.0.0-beta-2")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

secretsLoader {}

digitalOceanSpacesPublishing {
	bucket = "open-reliquary"
	
	val secretsFile = file("secret.properties")
	val props = Properties()
	if (secretsFile.exists()) {
		secretsFile.inputStream().use { props.load(it) }
	}
	
	accessKey = props.getProperty("spaces.key") ?: System.getenv("DO_SPACES_API_KEY") ?: ""
	secretKey = props.getProperty("spaces.secret") ?: System.getenv("DO_SPACES_SECRET") ?: ""
	publishedVersion = version.toString()
	dryRun = false
}

mavenGeneratedArtifacts {
	publicationName = "digitalOceanSpaces"
	name = "Kotlin Liquibase"
	description = """
            Liquibase JSON DSL with Kotlin. Use Kotlin to generate Liquibase changesets in JSON format.
        """
	websiteUrl = "https://github.com/violabs/kotlin-liquibase/tree/main"

	licenses {
		license {
			name = "MIT License"
			url = "https://opensource.org/license/mit/"
		}
	}

	developers {
		developer {
			id = "violabs"
			name = "Violabs Team"
			email = "support@violabs.io"
			organization = "Violabs Software"
		}
	}

	scm {
		connection = "https://github.com/violabs/kotlin-liquibase.git"
	}
}


ksp {
	arg("projectRootClasspath", "io.violabs.kotlinliquibase")
	arg("dslBuilderClasspath", "io.violabs.kotlinliquibase.common")
	arg("dslMarkerClass", "io.violabs.kotlinliquibase.common.KotlinLiquibaseDsl")
}