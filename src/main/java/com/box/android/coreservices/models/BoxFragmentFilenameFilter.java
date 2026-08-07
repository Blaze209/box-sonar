package com.box.android.coreservices.models;

/* JADX INFO: loaded from: classes9.dex */
public interface BoxFragmentFilenameFilter {

    public enum FILTER_TYPE {
        VISUAL_MEDIA,
        AUDIO_MEDIA
    }

    boolean accept(String str);

    FILTER_TYPE getFilterType();
}
