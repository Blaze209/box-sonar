package com.pspdfkit.ui.settings;

import io.nutrient.ui.settings.SettingsOptions;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/settings/SettingsDialogListener;", "", "onSettingsClose", "", "onSettingsSave", "changedOptions", "Lio/nutrient/ui/settings/SettingsOptions;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SettingsDialogListener {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onSettingsClose(SettingsDialogListener settingsDialogListener) {
            SettingsDialogListener.super.onSettingsClose();
        }
    }

    default void onSettingsClose() {
    }

    void onSettingsSave(SettingsOptions changedOptions);
}
