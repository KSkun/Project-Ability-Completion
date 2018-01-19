package moe.ksmeow.pacmod;

import cn.lambdalib.annoreg.core.Registrant;
import cn.lambdalib.annoreg.core.RegistrationManager;
import cn.lambdalib.annoreg.core.RegistrationMod;
import cn.lambdalib.util.version.VersionUpdateUrl;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "pacmod", name = "Project Ability Completion", version = PACMod.VERSION,
        dependencies = "required-after:academy-craft@1.0.6")
@RegistrationMod(pkg = "moe.ksmeow.pacmod.", res = "pacmod", prefix = "pac_")
@Registrant
@VersionUpdateUrl(repoUrl="github.com/KSkun/Project-Ability-Completion")
public class PACMod {

    @Instance("pacmod")
    public static PACMod INSTANCE;

    public static final String VERSION = "1.0";

    public static final Logger log = LogManager.getLogger("PACMod");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        log.info("Starting PACMod");
        log.info("Copyright (c) KSkun, 2018");
        log.info("https://ksmeow.moe/");

        RegistrationManager.INSTANCE.registerAll(this, "PreInit");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        RegistrationManager.INSTANCE.registerAll(this, "Init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RegistrationManager.INSTANCE.registerAll(this, "PostInit");

        PACConfig.init();
    }

}
