package codersafterdark.compatskills.common.compats.tinkersconstruct;

import codersafterdark.compatskills.common.compats.tinkersconstruct.commands.MaterialDumpCommand;
import codersafterdark.compatskills.common.compats.tinkersconstruct.commands.ModifierDumpCommand;
import codersafterdark.compatskills.common.compats.tinkersconstruct.materiallocks.MaterialLockKey;
import codersafterdark.compatskills.common.compats.tinkersconstruct.modifierlocks.ModifierLockKey;
import codersafterdark.reskillable.api.data.LockKey;
import codersafterdark.reskillable.api.data.RequirementHolder;
import codersafterdark.reskillable.base.LevelLockHandler;
import crafttweaker.mc1120.commands.CTChatCommand;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.IToolMod;

public class TinkersCompatHandler {
    private static boolean anyRegistered;

    public static void setup() {
        //Nothing here at the moment
    }

    public static void setupServerStart() {
        CTChatCommand.registerCommand(new MaterialDumpCommand());
        CTChatCommand.registerCommand(new ModifierDumpCommand());
    }

    public static void addTinkersLock(LockKey key, RequirementHolder holder) {
        if (!anyRegistered) {
            LevelLockHandler.registerLockKey(Material.class, MaterialLockKey.class);
            LevelLockHandler.registerLockKey(IToolMod.class, ModifierLockKey.class);
            LevelLockHandler.registerLockKey(ItemStack.class, ToolWrapperLockKey.class);
            MinecraftForge.EVENT_BUS.register(new TinkerLockHandler());
            anyRegistered = true;
        }
        LevelLockHandler.addLockByKey(key, holder);
    }
}