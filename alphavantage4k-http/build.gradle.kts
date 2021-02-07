
dependencies {
    implementation(project(":alphavantage4k-data"))
    implementation(Libraries.http4kCore)
    implementation(Libraries.http4kJackson)
    testImplementation(Libraries.kotestRunner)
    testImplementation(Libraries.kotestAssertions)
}
