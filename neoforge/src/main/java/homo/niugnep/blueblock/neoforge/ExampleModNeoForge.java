package homo.niugnep.blueblock.neoforge;

import net.neoforged.fml.common.Mod;

import homo.niugnep.blueblock.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
