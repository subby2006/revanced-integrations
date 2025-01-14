package app.revanced.integrations.settings;

import app.revanced.integrations.sponsorblock.StringRef;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.revanced.integrations.utils.LogHelper;
import app.revanced.integrations.utils.ReVancedUtils;
import app.revanced.integrations.utils.SharedPrefHelper;

public enum SettingsEnum {
    //Whitelist Settings
    //ToDo: Not used atm, Patch missing
    ENABLE_WHITELIST("revanced_whitelist_ads_enabled", false, ReturnType.BOOLEAN),

    //Ad settings
    HOME_ADS_REMOVAL("revanced_home_ads_removal", true, ReturnType.BOOLEAN, true),
    VIDEO_ADS_REMOVAL("revanced_video_ads_removal", true, ReturnType.BOOLEAN, true),
    ADREMOVER_GENERAL_ADS_REMOVAL("revanced_adremover_ad_removal", true, ReturnType.BOOLEAN, true),
    ADREMOVER_MERCHANDISE_REMOVAL("revanced_adremover_merchandise", true, ReturnType.BOOLEAN),
    ADREMOVER_COMMUNITY_POSTS_REMOVAL("revanced_adremover_community_posts_removal", false, ReturnType.BOOLEAN),
    ADREMOVER_COMPACT_BANNER_REMOVAL("revanced_adremover_compact_banner_removal", true, ReturnType.BOOLEAN),
    ADREMOVER_MOVIE_REMOVAL("revanced_adremover_movie", false, ReturnType.BOOLEAN),
    ADREMOVER_FEED_SURVEY_REMOVAL("revanced_adremover_feed_survey", true, ReturnType.BOOLEAN),
    ADREMOVER_IMAGE_SHELF_REMOVAL("revanced_adremover_image_shelf", true, ReturnType.BOOLEAN),
    ADREMOVER_COMMUNITY_GUIDELINES_REMOVAL("revanced_adremover_community_guidelines", true, ReturnType.BOOLEAN),
    ADREMOVER_EMERGENCY_BOX_REMOVAL("revanced_adremover_emergency_box_removal", true, ReturnType.BOOLEAN),
    ADREMOVER_INFO_PANEL_REMOVAL("revanced_adremover_info_panel", true, ReturnType.BOOLEAN),
    ADREMOVER_MEDICAL_PANEL_REMOVAL("revanced_adremover_medical_panel", true, ReturnType.BOOLEAN),
    ADREMOVER_PAID_CONTECT_REMOVAL("revanced_adremover_paid_content", false, ReturnType.BOOLEAN, true),
    ADREMOVER_SUGGESTIONS_REMOVAL("revanced_adremover_hide_suggestions", true, ReturnType.BOOLEAN),
    ADREMOVER_HIDE_LATEST_POSTS("revanced_adremover_hide_latest_posts", true, ReturnType.BOOLEAN),
    ADREMOVER_HIDE_CHANNEL_GUIDELINES("revanced_adremover_hide_channel_guidelines", true, ReturnType.BOOLEAN),
    ADREMOVER_SELF_SPONSOR_REMOVAL("revanced_adremover_self_sponsor", true, ReturnType.BOOLEAN),
    ADREMOVER_CHAPTER_TEASER_REMOVAL("revanced_adremover_chapter_teaser", true, ReturnType.BOOLEAN),

    //Layout settings
    OLD_STYLE_QUALITY_SETTINGS("revanced_use_old_style_quality_settings", true, ReturnType.BOOLEAN),
    REEL_BUTTON_SHOWN("revanced_reel_button_enabled", false, ReturnType.BOOLEAN, true),
    INFO_CARDS_SHOWN("revanced_info_cards_enabled", true, ReturnType.BOOLEAN, true),
    ENDSCREEN_CARDS_SHOWN("revanced_endscreen_cards_enabled", true, ReturnType.BOOLEAN, true),
    BRANDING_SHOWN("revanced_branding_watermark_enabled", false, ReturnType.BOOLEAN),
    CAST_BUTTON_SHOWN("revanced_cast_button_enabled", false, ReturnType.BOOLEAN, true),
    AUTOPLAY_BUTTON_SHOWN("revanced_autoplay_button_enabled", false, ReturnType.BOOLEAN, true),
    CAPTIONS_BUTTON_SHOWN("revanced_captions_button_enabled", true, ReturnType.BOOLEAN),
    CREATE_BUTTON_ENABLED("revanced_create_button_enabled", false, ReturnType.BOOLEAN, true),
    WIDE_SEARCHBAR("revanced_wide_searchbar", false, ReturnType.BOOLEAN, true),
    USE_TABLET_MINIPLAYER("revanced_tablet_miniplayer", false, ReturnType.BOOLEAN, true),
    CAPTIONS_ENABLED("revanced_autocaptions_enabled", false, ReturnType.BOOLEAN, true),
    PLAYER_POPUP_PANELS("revanced_player_popup_panels_enabled", false, ReturnType.BOOLEAN, true),
    HIDE_TIME_AND_SEEKBAR("revanced_hide_time_and_seekbar", true, ReturnType.BOOLEAN),
    HIDE_EMAIL_ADDRESS("revanced_hide_email_address", false, ReturnType.BOOLEAN, true),
    HIDE_MIX_PLAYLISTS("revanced_mix_playlists_hidden", true, ReturnType.BOOLEAN, true),
    HIDE_CROWDFUNDING_BOX("revanced_crowdfunding_box", false, ReturnType.BOOLEAN, true),
    HIDE_OFFICIAL_CARDS("revanced_official_card_in_search", true, ReturnType.BOOLEAN, true),
    HIDE_ALBUM_CARDS("revanced_album_card_in_search", true, ReturnType.BOOLEAN),
    HIDE_WATCH_IN_VR("revanced_hide_watch_in_vr", true, ReturnType.BOOLEAN, true),

    //Button Container
    FULLSCREEN_BUTTON_CONTAINER_SHOWN("revanced_fullscreen_button_container", false, ReturnType.BOOLEAN, true),
    HIDE_LIKE_BUTTON("revanced_hide_like_button", false, ReturnType.BOOLEAN),
    HIDE_DISLIKE_BUTTON("revanced_hide_dislike_button", false, ReturnType.BOOLEAN),
    HIDE_SHARE_BUTTON("revanced_hide_share_button", false, ReturnType.BOOLEAN),
    HIDE_LIVE_CHAT_BUTTON("revanced_hide_live_chat_button", false, ReturnType.BOOLEAN),
    HIDE_REPORT_BUTTON("revanced_hide_report_button", false, ReturnType.BOOLEAN),
    HIDE_CREATE_SHORT_BUTTON("revanced_hide_create_short_button", false, ReturnType.BOOLEAN),
    HIDE_THANKS_BUTTON("revanced_hide_thanks_button", false, ReturnType.BOOLEAN),
    HIDE_CREATE_CLIP_BUTTON("revanced_hide_create_clip_button", false, ReturnType.BOOLEAN),
    HIDE_DOWNLOAD_BUTTON("revanced_hide_download_button", false, ReturnType.BOOLEAN),
    HIDE_PLAYLIST_BUTTON("revanced_hide_playlist_button", false, ReturnType.BOOLEAN),

    //Button Container
    HIDE_COMMENTS_SECTION("revanced_hide_comments_section", false, ReturnType.BOOLEAN),
    HIDE_PREVIEW_COMMENT("revanced_hide_preview_comment", false, ReturnType.BOOLEAN),

    //Misc Settings
    USE_HDR_AUTO_BRIGHTNESS("revanced_pref_hdr_autobrightness", false, ReturnType.BOOLEAN),
    TAP_SEEKING_ENABLED("revanced_enable_tap_seeking", true, ReturnType.BOOLEAN),
    ENABLE_MINIMIZED_PLAYBACK("revanced_enable_minimized_playback", true, ReturnType.BOOLEAN),

    //Video Settings
    PREFERRED_VIDEO_SPEED("revanced_pref_video_speed", -2.0f, ReturnType.FLOAT),
    PREFERRED_VIDEO_QUALITY_WIFI("revanced_pref_video_quality_wifi", -2, ReturnType.INTEGER),
    PREFERRED_VIDEO_QUALITY_MOBILE("revanced_pref_video_quality_mobile", -2, ReturnType.INTEGER),
    CUSTOM_PLAYBACK_SPEED_ENABLED("revanced_pref_custom_playback_speed", false, ReturnType.BOOLEAN, true),
    SAVE_VIDEO_QUALITY("revanced_pref_save_video_quality", false, ReturnType.BOOLEAN),

    //Overlaybutton Settings
    PREFERRED_COPY_BUTTON("revanced_pref_copy_video_url_button", false, ReturnType.BOOLEAN),
    PREFERRED_COPY_WITH_TIMESTAMP_BUTTON("revanced_pref_copy_video_url_timestamp_button", false, ReturnType.BOOLEAN),
    PREFERRED_AUTO_REPEAT_BUTTON("revanced_pref_auto_repeat_button", false, ReturnType.BOOLEAN),
    PREFERRED_AUTO_REPEAT("revanced_pref_auto_repeat", false, ReturnType.BOOLEAN, true),
    //Download Settings
    // TODO: DOWNLOAD_PATH("revanced_download_path", Environment.getExternalStorageDirectory().getPath() + "/Download", ReturnType.STRING),
    DOWNLOADS_BUTTON_SHOWN("revanced_downloads", true, ReturnType.BOOLEAN, true),
    DOWNLOADS_PACKAGE_NAME("revanced_downloads_package_name", StringRef.str("revanced_default_downloader"), ReturnType.STRING),

    //Shorts component
    SHORTS_BUTTON("revanced_shorts_button", false, ReturnType.BOOLEAN, true),
    SHORTS_SHELF("revanced_shorts_shelf", false, ReturnType.BOOLEAN),
    STARTUP_SHORTS_PLAYER("revanced_disable_startup_shorts_player", false, ReturnType.BOOLEAN),
    SHORTS_COMMENTS_BUTTON("revanced_shorts_player_comments_button", true, ReturnType.BOOLEAN),
    SHORTS_REMIX_BUTTON("revanced_shorts_player_remix_button", true, ReturnType.BOOLEAN),
    SHORTS_PLAYER_THANKS("revanced_shorts_player_thanks", true, ReturnType.BOOLEAN),
    SHORTS_PLAYER_SUBSCRIPTIONS("revanced_shorts_player_subscriptions", true, ReturnType.BOOLEAN),

    //Extended
    INAPP_BROWSER("revanced_inapp_browser", false, ReturnType.BOOLEAN, true),
    URI_REDIRECT("revanced_uri_redirect", true, ReturnType.BOOLEAN, true),
    WEB_SEARCH_PANELS("revanced_web_search_panels", true, ReturnType.BOOLEAN, true),
    BREAKING_NEWS_PANELS("revanced_breaking_news_panels", false, ReturnType.BOOLEAN, true),
    SUGGESTED_ACTION("revanced_suggested_actions", true, ReturnType.BOOLEAN, true),
    TIMED_REACTIONS("revanced_timed_reactions", false, ReturnType.BOOLEAN, true),
    VIEW_PRODUCTS("revanced_view_products", true, ReturnType.BOOLEAN, true),
    CUTOUT_GLITCH("revanced_cutout_glitch", true, ReturnType.BOOLEAN, true),
    PALYER_OVERLAY_BACKGROUND("revanced_player_overlay_background", false, ReturnType.BOOLEAN, true),
    ENDSCREEN_OVERLAY("revanced_endscreen_overlay", false, ReturnType.BOOLEAN, true),
    PREMIUM_HEADER("revanced_override_premium_header", false, ReturnType.BOOLEAN, true),

    //Experimental Flags
    EXPERIMENTAL_FLAG("experimental_flags_init", false, ReturnType.BOOLEAN, true, "pref_refresh_config"),
    DISABLE_NEWLAYOUT("revanced_disable_new_layout", false, ReturnType.BOOLEAN, true, "pref_refresh_config"),
    FULLSCREEN_ROTATION("revanced_fullscreen_rotation", true, ReturnType.BOOLEAN, true, "revanced_reboot_warning_fullscreen"),
    FIX_PLAYBACK("revanced_fix_playback", false, ReturnType.BOOLEAN, true, "revanced_reboot_warning_playback"),
    TABLET_LAYOUT("revanced_tablet_layout", false, ReturnType.BOOLEAN, true, "revanced_reboot_warning_tablet"),
    PHONE_LAYOUT("revanced_phone_layout", false, ReturnType.BOOLEAN, true, "revanced_reboot_warning_phone"),

    //Swipe controls
    ENABLE_SWIPE_AUTO_BRIGHTNESS("revanced_enable_swipe_auto_brightness", false, ReturnType.BOOLEAN),
    ENABLE_SWIPE_BRIGHTNESS("revanced_enable_swipe_brightness", true, ReturnType.BOOLEAN),
    ENABLE_SWIPE_VOLUME("revanced_enable_swipe_volume", true, ReturnType.BOOLEAN),
    ENABLE_PRESS_TO_SWIPE("revanced_enable_press_to_swipe", false, ReturnType.BOOLEAN),
    ENABLE_SWIPE_HAPTIC_FEEDBACK("revanced_enable_swipe_haptic_feedback", true, ReturnType.BOOLEAN),
    SWIPE_OVERLAY_TIMEOUT("revanced_swipe_overlay_timeout", 500L, ReturnType.LONG),
    SWIPE_OVERLAY_TEXT_SIZE("revanced_swipe_overlay_text_size", 27f, ReturnType.FLOAT),
    SWIPE_OVERLAY_BACKGROUND_ALPHA("revanced_swipe_overlay_background_alpha", 127, ReturnType.INTEGER),
    SWIPE_MAGNITUDE_THRESHOLD("revanced_swipe_magnitude_threshold", 0f, ReturnType.FLOAT),

    //Buffer Settings
    MAX_BUFFER("revanced_pref_max_buffer_ms", 120000, ReturnType.INTEGER),
    PLAYBACK_MAX_BUFFER("revanced_pref_buffer_for_playback_ms", 2500, ReturnType.INTEGER),
    MAX_PLAYBACK_BUFFER_AFTER_REBUFFER("revanced_pref_buffer_for_playback_after_rebuffer_ms", 5000, ReturnType.INTEGER),

    //ReVanced General Settings
    DEBUG("revanced_debug_enabled", false, ReturnType.BOOLEAN, true),
    USE_DARK_THEME("app_theme_dark", false, ReturnType.BOOLEAN),

    //RYD Settings
    RYD_USER_ID("ryd_userId", null, SharedPrefHelper.SharedPrefNames.RYD, ReturnType.STRING),
    RYD_ENABLED("ryd_enabled", true, SharedPrefHelper.SharedPrefNames.RYD, ReturnType.BOOLEAN),

    //SponsorBlock Settings
    SB_ENABLED("sb-enabled", true, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_SHOW_TOAST_WHEN_SKIP("show-toast", true, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_COUNT_SKIPS("count-skips", true, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_UUID("uuid", null, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.STRING),
    SB_ADJUST_NEW_SEGMENT_STEP("new-segment-step-accuracy", 150, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.INTEGER),
    SB_MIN_DURATION("sb-min-duration", 0F, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.FLOAT),
    SB_SEEN_GUIDELINES("sb-seen-gl", false, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_NEW_SEGMENT_ENABLED("sb-new-segment-enabled", false, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_VOTING_ENABLED("sb-voting-enabled", false, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_SKIPPED_SEGMENTS("sb-skipped-segments", 0, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.INTEGER),
    SB_SKIPPED_SEGMENTS_TIME("sb-skipped-segments-time", 0L, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.LONG),
    SB_SHOW_TIME_WITHOUT_SEGMENTS("sb-length-without-segments", true, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_IS_VIP("sb-is-vip", false, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_LAST_VIP_CHECK("sb-last-vip-check", 0L, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.LONG),
    SB_SHOW_BROWSER_BUTTON("sb-browser-button", false, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    SB_API_URL("sb-api-url", "https://sponsor.ajay.app/api/", SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.STRING),
    //SB_ENABLED_SHORTS("sb-enabled-shorts", false, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    //SB_SEEN_EXPERIMENTAL_HINT("sb-seen-experimental-gl", false, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN),
    REVANCED_EXTENDED_HINT_SHOWN("rvx_hint_shown", false, SharedPrefHelper.SharedPrefNames.SPONSOR_BLOCK, ReturnType.BOOLEAN);    

    private final String path;
    private final Object defaultValue;
    private final SharedPrefHelper.SharedPrefNames sharedPref;
    private final ReturnType returnType;
    private final boolean rebootApp;
    private final String rebootApp_Warning;

    private Object value = null;

    SettingsEnum(String path, Object defaultValue, ReturnType returnType) {
        this.path = path;
        this.defaultValue = defaultValue;
        this.sharedPref = SharedPrefHelper.SharedPrefNames.YOUTUBE;
        this.returnType = returnType;
        this.rebootApp = false;
        this.rebootApp_Warning = "";
    }

    SettingsEnum(String path, Object defaultValue, SharedPrefHelper.SharedPrefNames prefName, ReturnType returnType) {
        this.path = path;
        this.defaultValue = defaultValue;
        this.sharedPref = prefName;
        this.returnType = returnType;
        this.rebootApp = false;
        this.rebootApp_Warning = "";
    }

    SettingsEnum(String path, Object defaultValue, ReturnType returnType, Boolean rebootApp) {
        this.path = path;
        this.defaultValue = defaultValue;
        this.sharedPref = SharedPrefHelper.SharedPrefNames.YOUTUBE;
        this.returnType = returnType;
        this.rebootApp = rebootApp;
        this.rebootApp_Warning = "";
    }

    SettingsEnum(String path, Object defaultValue, ReturnType returnType, Boolean rebootApp, String rebootApp_Warning) {
        this.path = path;
        this.defaultValue = defaultValue;
        this.sharedPref = SharedPrefHelper.SharedPrefNames.YOUTUBE;
        this.returnType = returnType;
        this.rebootApp = rebootApp;
        this.rebootApp_Warning = rebootApp_Warning;
    }

    static {
        load();
    }

    private static void load() {
        Context context = ReVancedUtils.getContext();
        if (context == null) {
            Log.e("revanced: SettingsEnum", "Context returned null! Setings NOT initialized");
        } else {
            try {
                for (SettingsEnum setting : values()) {
                    Object value = setting.getDefaultValue();

                    //LogHelper is not initialized here
                    Log.d("revanced: SettingsEnum", "Loading Setting: " + setting.name());

                    switch (setting.getReturnType()) {
                        case FLOAT:
                            value = SharedPrefHelper.getFloat(context, setting.sharedPref, setting.getPath(), (float) setting.getDefaultValue());
                            break;
                        case LONG:
                            value = SharedPrefHelper.getLong(context, setting.sharedPref, setting.getPath(), (long) setting.getDefaultValue());
                            break;
                        case BOOLEAN:
                            value = SharedPrefHelper.getBoolean(context, setting.sharedPref, setting.getPath(), (boolean) setting.getDefaultValue());
                            break;
                        case INTEGER:
                            value = SharedPrefHelper.getInt(context, setting.sharedPref, setting.getPath(), (int) setting.getDefaultValue());
                            break;
                        case STRING:
                            value = SharedPrefHelper.getString(context, setting.sharedPref, setting.getPath(), (String) setting.getDefaultValue());
                            break;
                        default:
                            LogHelper.printException(SettingsEnum.class, "Setting does not have a valid Type. Name is: " + setting.name());
                            break;
                    }
                    setting.setValue(value);

                    //LogHelper is not initialized here
                    Log.d("revanced: SettingsEnum", "Loaded Setting: " + setting.name() + " Value: " + value);
                }
            } catch (Throwable th) {
                LogHelper.printException(SettingsEnum.class, "Error during load()!", th);
            }
        }
    }

    public static List<SettingsEnum> getAdRemovalSettings() {
        List<SettingsEnum> list = new ArrayList<>();
        for (SettingsEnum var : SettingsEnum.values()) {
            if (var.toString().startsWith("ADREMOVER")) {
                list.add(var);
            }
        }
        return list;
    }

    public void setValue(Object newValue) {
        this.value = newValue;
    }

    public void saveValue(Object newValue) {
        Context context = ReVancedUtils.getContext();
        if (context != null) {
            if (returnType == ReturnType.BOOLEAN) {
                SharedPrefHelper.saveBoolean(context, sharedPref, path, (Boolean) newValue);
            } else {
                SharedPrefHelper.saveString(context, sharedPref, path, newValue + "");
            }
            value = newValue;
        } else {
            LogHelper.printException(SettingsEnum.class, "Context on SaveValue is null!");
        }
    }

    public int getInt() {
        return (int) value;
    }

    public String getString() {
        return (String) value;
    }

    public boolean getBoolean() {
        return (Boolean) value;
    }

    public Long getLong() {
        return (Long) value;
    }

    public Float getFloat() {
        return (Float) value;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public String getPath() {
        return path;
    }

    public ReturnType getReturnType() {
        return returnType;
    }

    public boolean shouldRebootOnChange() {
        return rebootApp;
    }

    public String shouldWarningOnChange() {
        return rebootApp_Warning;
    }

}
