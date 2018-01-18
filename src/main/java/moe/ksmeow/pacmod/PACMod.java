package moe.ksmeow.pacmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = PACMod.MODID, version = PACMod.VERSION)
public class PACMod
{
    public static final String MODID = "pacmod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
