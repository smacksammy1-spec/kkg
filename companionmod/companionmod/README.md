# Companion Mod (Forge 1.20.1 + GeckoLib 4)

Right-click a Companion to tame it. Right-click a tamed Companion to open a
command screen (Follow / Stay / Dismiss). The spawn egg is in the Spawn Eggs creative tab.

## Build
Requires JDK 17 and internet access (to fetch Forge + GeckoLib).

1. Copy `gradlew`, `gradlew.bat` and the `gradle/` folder from the official
   Forge 1.20.1 MDK into this folder (or run `gradle wrapper --gradle-version 8.1.1`).
2. `./gradlew build`
3. The jar is at `build/libs/companionmod-1.0.0.jar`. Put it in `mods/` with
   Forge 47.2.0+ and GeckoLib 4.4.x for 1.20.1.

Dev client: `./gradlew runClient`

## Swapping in your own art
Replace these (keep the filenames, or change the paths in `CompanionModel`):
- `assets/companionmod/geo/companion.geo.json` - model (Blockbench, GeckoLib format)
- `assets/companionmod/animations/companion.animation.json` - must contain `idle`, `walk`, `sit`
- `assets/companionmod/textures/entity/companion.png`
