load("@rules_kotlin//kotlin:core.bzl", "kt_ksp_plugin")
load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library", "kt_jvm_binary")

kt_ksp_plugin(
    name = "moshi-kotlin-codegen",
    processor_class = "com.squareup.moshi.kotlin.codegen.ksp.JsonClassSymbolProcessorProvider",
    deps = [
        "@maven//:com_squareup_moshi_moshi",
        "@maven//:com_squareup_moshi_moshi_kotlin",
        "@maven//:com_squareup_moshi_moshi_kotlin_codegen",
    ],
)

kt_jvm_binary(
    name = "moshi_example",
    srcs = glob(["src/moshi/*.kt"]),
    plugins = [":moshi-kotlin-codegen"],
    main_class = "src.moshi.Main",
    deps = [
        "@maven//:com_squareup_moshi_moshi",
        "@maven//:com_squareup_moshi_moshi_kotlin",
    ],
)

kt_ksp_plugin(
    name = "kopykat_plugin",
    processor_class = "at.kopyk.KopyKatProvider",
    deps = [
        "@maven//:at_kopyk_kopykat_ksp",
    ],
)

# This is redundant actually, but just to separate generated files by kopykat from the others.
kt_jvm_library(
    name = "kopykat_generated_lib",
    srcs = glob(["src/kopykat/*.kt"]),
    plugins = [":kopykat_plugin"],
    deps = ["@maven//:at_kopyk_kopykat_ksp"],
)

kt_jvm_binary(
    name = "kopykat_example",
    srcs = glob(["src/kopykat/*.kt"]),
    plugins = [":kopykat_plugin"],
    main_class = "src.kopykat.Main",
    deps = [
        "@maven//:at_kopyk_kopykat_ksp",
        ":kopykat_generated_lib",
    ],
)

kt_ksp_plugin(
    name = "arrow_optics_plugin",
    processor_class = "arrow.optics.plugin.OpticsProcessorProvider",
    deps = [
        "@maven//:io_arrow_kt_arrow_core",
        "@maven//:io_arrow_kt_arrow_optics",
        "@maven//:io_arrow_kt_arrow_optics_ksp_plugin",
    ],
)

kt_jvm_library(
    name = "arrow_optics_generated_lib",
    srcs = glob(["src/arrow_optics/*.kt"]),
    plugins = [":arrow_optics_plugin"],
    deps = [
        "@maven//:io_arrow_kt_arrow_core",
        "@maven//:io_arrow_kt_arrow_optics",
    ],
)

kt_jvm_binary(
    name = "arrow_optics_example",
    srcs = glob(["src/arrow_optics/*.kt"]),
    plugins = [":arrow_optics_plugin"],
    main_class = "src.arrow_optics.Main",
    deps = [
        "@maven//:io_arrow_kt_arrow_core",
        "@maven//:io_arrow_kt_arrow_optics",
        ":arrow_optics_generated_lib",
    ],
)
