package app.revanced.integrations.sponsorblock.player.ui;

import static app.revanced.integrations.sponsorblock.StringRef.str;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;

import app.revanced.integrations.settings.SettingsEnum;
import app.revanced.integrations.videoplayer.NewVideoInformation;
import app.revanced.integrations.utils.ReVancedUtils;
import app.revanced.integrations.sponsorblock.SponsorBlockUtils;

public class SBBrowserButton extends SlimButton {
    private static final String BROWSER_URL = "https://sb.ltn.fi/video/";

    public SBBrowserButton(Context context, ViewGroup container) {
        super(context, container, SLIM_METADATA_BUTTON_ID,
                SponsorBlockUtils.isSBButtonEnabled(context, SettingsEnum.SB_SHOW_BROWSER_BUTTON.getPath()));

        initialize();
    }

    private void initialize() {
        this.button_icon.setImageResource(ReVancedUtils.getIdentifier("revanced_sb_browser", "drawable"));
        this.button_text.setText(str("action_browser"));
    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse(BROWSER_URL + NewVideoInformation.currentVideoId);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }
}