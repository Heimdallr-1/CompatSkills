package codersafterdark.compatskills.common.compats.immersiveengineering;

import blusunrize.immersiveengineering.api.MultiblockHandler;
import codersafterdark.compatskills.utils.multiblock.MultiBlockCommand;
import codersafterdark.compatskills.utils.multiblock.MultiBlockGate;
import codersafterdark.reskillable.api.data.RequirementHolder;
import codersafterdark.reskillable.base.LevelLockHandler;
import crafttweaker.mc1120.commands.CTChatCommand;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;
import java.util.stream.Collectors;

public class IECompatHandler {
    private static boolean registered;

    public static void setup() {
        CTChatCommand.registerCommand(new MultiBlockCommand("ie") {
            @Override
            public List<String> getMultiBlockNames() {
                return MultiblockHandler.getMultiblocks().stream().map(MultiblockHandler.IMultiblock::getUniqueName).collect(Collectors.toList());
            }
        });
    }

    public static void addIELock(MultiBlockGate key, RequirementHolder holder) {
        if (!registered) {
            MinecraftForge.EVENT_BUS.register(new IEMultiBlockHandler());
            registered = true;
        }
        LevelLockHandler.addLockByKey(key, holder);
    }
}