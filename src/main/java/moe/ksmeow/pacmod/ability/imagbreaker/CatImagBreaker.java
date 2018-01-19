package moe.ksmeow.pacmod.ability.imagbreaker;

import cn.academy.ability.api.Category;
import cn.academy.ability.api.Skill;
import moe.ksmeow.pacmod.ability.imagbreaker.skill.ImagBreaker;
import net.minecraft.util.StatCollector;

public class CatImagBreaker extends Category {

    public static final Skill imagBreaker = ImagBreaker.INSTANCE;

    public CatImagBreaker() {
        super("imagbreaker");
        colorStyle.setColor4i(240, 240, 240, 100);

        addSkill(imagBreaker);
    }

    @Override
    public String getDisplayName() {
        return StatCollector.translateToLocal("pac.ability." + getName() + ".name");
    }

}
