package main

val VERSION: String = "0.5.0"
fun main(args: Array<String>) {
    val cli = CLI.parse(args)
    if (cli.helpFlag) {
        println("Usage: java [-options] class [args...]")
        return
    }
    if (cli.versionFlag) {
        println("Java Virtual Machine, Version: $VERSION")
        return
    }

    println("Starting JVM with class: ${cli.class_}; classpath: ${cli.cpOption}; args: ${cli.args}")
}
