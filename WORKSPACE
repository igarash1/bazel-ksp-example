load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

rules_kotlin_version = "1.9.5"
rules_kotlin_sha = "5766f1e599acf551aa56f49dab9ab9108269b03c557496c54acaf41f98e2b8d6"
http_archive(
    name = "rules_kotlin",
    sha256 = "34e8c0351764b71d78f76c8746e98063979ce08dcf1a91666f3f3bc2949a533d",
    url = "https://github.com/bazelbuild/rules_kotlin/releases/download/v1.9.5/rules_kotlin-v1.9.5.tar.gz",
)

load("@rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")
kotlin_repositories() # if you want the default. Otherwise see custom kotlinc distribution below

load("@rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
kt_register_toolchains() # to use the default toolchain, otherwise see toolchains below

load("@rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories", "versions")

http_archive(
    name = "rules_jvm_external",
    sha256 = versions.RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % versions.RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (
        versions.RULES_JVM_EXTERNAL_TAG,
        versions.RULES_JVM_EXTERNAL_TAG,
    ),
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.squareup.moshi:moshi-kotlin-codegen:1.15.1",
        "com.squareup.moshi:moshi-kotlin:1.15.1",
        "com.squareup.moshi:moshi:1.15.1",
        "at.kopyk:kopykat-ksp:1.0.4",
        "io.arrow-kt:arrow-core:1.2.4",
        "io.arrow-kt:arrow-optics:1.2.4",
        "io.arrow-kt:arrow-optics-ksp-plugin:1.2.4",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
