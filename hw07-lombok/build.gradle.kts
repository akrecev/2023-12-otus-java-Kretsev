plugins {
    id ("io.freefair.lombok")
}

dependencies {
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("ch.qos.logback:logback-classic")

    testImplementation("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
}