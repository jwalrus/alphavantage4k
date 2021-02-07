
dependencies {
//    implementation(Libraries.ktorClientCIO)
//    implementation(Libraries.ktorClientJackson)
    implementation(Libraries.jacksonCore)
    implementation(Libraries.jacksonAnnotations)
    implementation(Libraries.jacksonDataBind)
    implementation(Libraries.jacksonKotlin)
    implementation(Libraries.jacksonJsr310)
    testImplementation(Libraries.kotestRunner)
    testImplementation(Libraries.kotestAssertions)
}
