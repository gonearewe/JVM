package main

class CLI private constructor(
        val helpFlag: Boolean = false,
        val versionFlag: Boolean = false,
        val cpOption: String,
        val class_: String,
        val args: List<String>?
) {
    companion object {
        fun parse(args: Array<String>): CLI {
            val index = args.indexOf("-classpath")
            val cp = if (index != -1) args[index + 1] else ""
            val remainings = args.filterIndexed { i, arg -> !(i == index || i == index + 1 || arg.startsWith("-")) }
            return CLI(
                    "-h" in args,
                    "-v" in args,
                    cp,
                    if (remainings.isNotEmpty()) remainings[0] else "",
                    if (remainings.size > 1) remainings.subList(1, remainings.size) else null
            )
        }
    }
}