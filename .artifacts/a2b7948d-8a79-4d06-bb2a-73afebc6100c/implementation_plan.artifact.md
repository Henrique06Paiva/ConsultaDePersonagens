# Implementation Plan - Fix Kotlin Version Incompatibility

The project is experiencing a build error because `kotlin-stdlib` version 2.4.0 is being used (brought in by `coil:3.5.0`), but the Kotlin compiler is configured to version 2.2.10. Kotlin 2.2.10 cannot read metadata from Kotlin 2.4.0.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/ProjetosAndroid/gradle/libs.versions.toml)
- Upgrade `kotlin` version from `2.2.10` to `2.4.10`.
- Add the `kotlin-android` plugin definition.

#### [MODIFY] [build.gradle.kts (root)](file:///C:/ProjetosAndroid/build.gradle.kts)
- Add the `kotlin-android` plugin to the top-level plugins block (without applying it).

#### [MODIFY] [build.gradle.kts (app)](file:///C:/ProjetosAndroid/app/build.gradle.kts)
- Apply the `kotlin-android` plugin.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:assembleDebug` to verify the project compiles successfully.
- Run `./gradlew :app:compileDebugKotlin` specifically to ensure the Kotlin compiler works as expected.

### Manual Verification
- Verify that the IDE no longer shows the "incompatible version" error in `MainActivity.kt`.
