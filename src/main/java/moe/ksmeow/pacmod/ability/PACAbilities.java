package moe.ksmeow.pacmod.ability;

import cn.academy.ability.api.registry.CategoryRegistration.RegCategory;
import cn.lambdalib.annoreg.core.Registrant;
import moe.ksmeow.pacmod.ability.imagbreaker.CatImagBreaker;

@Registrant
public class PACAbilities {

    @RegCategory
    public static final CatImagBreaker imagBreaker = new CatImagBreaker();

}
