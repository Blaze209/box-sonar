package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a10 {
    public final Drawable a;
    public final Drawable b;
    public final float c;
    public final float d;
    public final String e;
    public final String f;
    public final ColorStateList g;
    public final boolean h;

    public a10(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(R.styleable.pspdf__SettingsDialog);
        typedArrayObtainStyledAttributes.getClass();
        this.a = typedArrayObtainStyledAttributes.getDrawable(R.styleable.pspdf__SettingsDialog_pspdf__settings_preset_still_image_horizontal);
        this.b = typedArrayObtainStyledAttributes.getDrawable(R.styleable.pspdf__SettingsDialog_pspdf__settings_preset_still_image_vertical);
        this.c = typedArrayObtainStyledAttributes.getDimension(R.styleable.pspdf__SettingsDialog_pspdf__settings_preset_selected_border_width, 3.0f);
        this.d = typedArrayObtainStyledAttributes.getDimension(R.styleable.pspdf__SettingsDialog_pspdf__settings_preset_unselected_border_width, 1.0f);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.pspdf__SettingsDialog_pspdf__settings_preset_animation_url_vertical);
        this.e = string == null ? "https://appassets.androidplatform.net/assets/nutrient/settings-animations/vertical-single-scroll-light.html" : string;
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.pspdf__SettingsDialog_pspdf__settings_preset_animation_url_horizontal);
        this.f = string2 == null ? "https://appassets.androidplatform.net/assets/nutrient/settings-animations/horizontal-single-scroll-light.html" : string2;
        TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__SettingsModePickerItem, R.attr.pspdf__settingsModePickerItemStyle, R.style.PSPDFKit_SettingsModePickerItem);
        typedArrayObtainStyledAttributes2.getClass();
        ColorStateList colorStateList = typedArrayObtainStyledAttributes2.getColorStateList(R.styleable.pspdf__SettingsModePickerItem_pspdf__itemTint);
        this.g = colorStateList == null ? ContextCompat.getColorStateList(context, R.color.pspdf__settings_mode_picker_item) : colorStateList;
        this.h = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.pspdf__SettingsModePickerItem_pspdf__ignoreTint, false);
    }
}
