package com.box.android.requests;

import java.util.Locale;

/* JADX INFO: loaded from: classes12.dex */
public class BoxInternalApi {
    public static final String FEATURES_URI = "https://api.box.com/2.0/internal_users/me/features";
    private static final String INVITES_URL = "/internal_folders/%s/invitees";

    public static String getInvitesUri(String str, String str2) {
        return String.format(Locale.ENGLISH, str + INVITES_URL, str2);
    }
}
