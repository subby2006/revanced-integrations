package app.revanced.integrations.patches;

import app.revanced.integrations.settings.SettingsEnum;

public class DisableStartupShortsPlayerPatch {
    //Used by app.revanced.patches.youtube.layout.startupshortsreset.patch.DisableShortsOnStartupPatch
    public static boolean disableStartupShortsPlayer() {
        return !SettingsEnum.STARTUP_SHORTS_PLAYER.getBoolean();
    }
}
