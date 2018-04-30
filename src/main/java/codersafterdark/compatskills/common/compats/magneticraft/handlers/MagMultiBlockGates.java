package codersafterdark.compatskills.common.compats.magneticraft.handlers;

import codersafterdark.compatskills.utils.CheckMethods;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("magneticraft")
@ZenClass("mods.compatskills.MagMultiBlockGates")
@ZenRegister
public class MagMultiBlockGates {
    @ZenMethod
    public static void addGate(String multiBlockName, String failureMessage, String... defaultRequirements) {
        if (CheckMethods.checkValidMultiblockNameMag(multiBlockName) & CheckMethods.checkString(failureMessage) & CheckMethods.checkStringArray(defaultRequirements)) {
            CraftTweakerAPI.apply(new ActionAddMagMultiBlockGate(multiBlockName, failureMessage, defaultRequirements));
        }
    }
}
