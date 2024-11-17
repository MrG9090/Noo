// tag::plugins[]
plugins {   // <1>
    id("application")
}
// end::plugins[]

// tag::repo[]
repositories {  // <2>
    mavenCentral()
}
// end::repo[]

// tag::dep[]
dependencies {  // <3>
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.google.guava:guava:32.1.1-jre")
}
// end::dep[]

// tag::app[]
application {   // <4>
    mainClass = "com.example.Main"
}
// end::app[]

// tag::test[]
tasks.named<Test>("test") { // <5>
    useJUnitPlatform()
}
// end::test[]

// tag::task[]
tasks.register<Zip>("zip-reports") {
    from("Reports/")
    include("*")
    archiveFileName.set("Reports.zip")
    destinationDirectory.set(file("/dir"))
}
// end::task[]