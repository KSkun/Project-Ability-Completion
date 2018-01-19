package moe.ksmeow.pacmod.ability.imagbreaker.skill;

import cn.academy.ability.SkillDamageSource;
import cn.academy.ability.api.Skill;
import cn.academy.ability.api.context.*;
import cn.academy.core.config.ACConfig;
import cn.lambdalib.annoreg.core.Registrant;
import cn.lambdalib.particle.Particle;
import cn.lambdalib.s11n.network.NetworkMessage.Listener;
import cn.lambdalib.util.mc.WorldUtils;
import com.google.common.base.Preconditions;
import com.typesafe.config.Config;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import scala.runtime.AbstractFunction1;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ImagBreaker extends Skill {

    public static final ImagBreaker INSTANCE = new ImagBreaker();

    public ImagBreaker() {
        super("imag_breaker", 0);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void activate(ClientRuntime rt, int keyid) {
        activateSingleKey(rt, keyid, new AbstractFunction1<EntityPlayer, Context>() {
            @Override
            public Context apply(EntityPlayer v1) {
                return new IBContext(v1);
            }
        });
    }

    @SubscribeEvent
    public void onPlayerAttacked(LivingHurtEvent evt) {
        if(evt.entityLiving instanceof EntityPlayer) {
            Optional<IBContext> context = ContextManager.instance.find(IBContext.class);
            if(context.isPresent() && context.get().player == evt.entityLiving && evt.source instanceof SkillDamageSource) {
                evt.setCanceled(true);
            }
        }
    }

}

class IBContext extends Context {

    public IBContext(EntityPlayer p) {
        super(p, ImagBreaker.INSTANCE);
    }

}

@Registrant
@SideOnly(Side.CLIENT)
@RegClientContext(IBContextC.class)
class IBContextC extends ClientContext {

    public IBContextC(Context par) {
        super(par);
    }

    @Listener(channel = MSG_TICK, side = Side.CLIENT)
    private void c_update() {
        List<Entity> entity = WorldUtils.getEntities(ctx.player, 3, new Predicate<Entity>() {
            @Override
            public boolean test(Entity entity) {
                return entity instanceof Particle;
            }
        });
        for(Entity ent : entity) {
            ent.setDead();
        }
    }

}
