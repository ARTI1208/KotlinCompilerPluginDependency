Configure
1. Comment `id("dep.plugin") version "1.0-SNAPSHOT"` in repro/build.gradle.kts
2. `./gradlew :common:publishToMavenLocal`
3. `./gradlew :plugins:plugin-gradle:publishToMavenLocal`
4. `./gradlew :plugins:plugin-kotlin:publishToMavenLocal`
5. Return `id("dep.plugin") version "1.0-SNAPSHOT"` in repro/build.gradle.kts

Test
* `./gradlew :repro:compileKotlinJvm` - fine 
* `./gradlew :repro:compileKotlinIosArm64` - e: java.lang.NoClassDefFoundError: dep/Something at com.plugin.dep.kotlin.DepTransformer.<init>(DepTransformer.kt:13)