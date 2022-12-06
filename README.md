# LMP Compat

Adding specialized compatibility between LMP and various mods.

## Compatibility Chart

| Mod    | Support | Notes             |
|--------|:-------:|-------------------|
| Create |    ✅    | Added in `v0.1.0` |

✅: Support Completed<br>
🚧: Support In Progress<br>
🔲: Support Planned<br>
⁇: Maybe Support Eventually<br>
❌: Not Supported<br>

## Including In Your Mod

You can use LMP Compat in your mod by adding Kneelawk's maven repository:
```groovy
repositories {
    maven {
        name "Kneelawk"
        url "https://kneelawk.com/maven/"
    }
}
```

and adding and including an LMPCompat dependency:
```groovy
dependencies {
    modImplementation "com.kneelawk:lmp-compat:$lmpCompatVersion"
    include "com.kneelawk:lmp-compat:$lmpCompatVersion"
}
```
