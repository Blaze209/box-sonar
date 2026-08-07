package com.box.android.base.presentation.utilities.imagemanager;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.box.android.common.utilities.ApplicationProvider;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class StaticImageManager {
    private static final ConcurrentHashMap<Integer, Drawable> STATIC_DRAWABLE_MAP = new ConcurrentHashMap<>();

    private StaticImageManager() {
    }

    public static Drawable getDrawable(int i) {
        return STATIC_DRAWABLE_MAP.get(Integer.valueOf(i));
    }

    public static Drawable addDrawable(Resources resources, int i) {
        Drawable drawable = resources.getDrawable(i);
        STATIC_DRAWABLE_MAP.put(Integer.valueOf(i), drawable);
        return drawable;
    }

    public static Drawable getOrAddDrawable(int i) {
        if (i == 0 || i == -1) {
            return null;
        }
        Drawable drawable = getDrawable(i);
        return drawable != null ? drawable : addDrawable(ApplicationProvider.application.getResources(), i);
    }
}
