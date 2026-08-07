package com.box.android.base.presentation;

import android.content.Context;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;

/* JADX INFO: loaded from: classes9.dex */
public interface BoxFragmentInterface {
    public static final int TYPE_ACTIVITY_FEED_FRAGMENT = 27;
    public static final int TYPE_CAPTURE_HISTORY_FRAGMENT = 27;
    public static final int TYPE_COLLECTION_DETAILS_FRAGMENT = 26;
    public static final int TYPE_EVENT_UPDATES = 6;
    public static final int TYPE_FAVORITES_COLLECTIONS_FRAGMENT = 25;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_FILE_INFO = 12;
    public static final int TYPE_FOLDER = 2;
    public static final int TYPE_FOLDER_INFO = 11;
    public static final int TYPE_HUBS = 5;
    public static final int TYPE_JOB_MANAGER = 19;
    public static final int TYPE_MY_COLLECTIONS_FRAGMENT = 24;
    public static final int TYPE_MY_TASKS = 22;
    public static final int TYPE_NOTES = 21;
    public static final int TYPE_OFFLINED_ITEMS = 8;
    public static final int TYPE_RECENTS = 13;
    public static final int TYPE_SEARCH = 4;
    public static final int TYPE_SENT_TASKS = 23;

    String getAmplitudePageName();

    default String getGenericId() {
        return null;
    }

    String getTitle(Context context);

    int getType();

    default boolean isFloatingMenuAvailable() {
        return false;
    }

    default boolean onBackPressed() {
        return false;
    }

    @Deprecated
    default boolean shouldUpdateFragment(BoxMessage<?> boxMessage) {
        return false;
    }

    @Deprecated
    default void updateFragment(BoxMessage<?> boxMessage) {
    }

    default void updateFromRemote() {
    }
}
