package com.box.android.notes.navigationmodernization;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: compiled from: NotesAnalytics.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesAnalytics;", "", "<init>", "()V", "notesScreenViewed", "", "recentsTabScreenViewed", "favoritesTabScreenViewed", "noteListItemTapped", "noteCreateTapped", "noteFavoriteToggled", "isFavorite", "", "settingsClicked", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesAnalytics {
    public static final int $stable = 0;

    @Inject
    public NotesAnalytics() {
    }

    public final void notesScreenViewed() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_NOTES_SCREEN_VIEWED);
    }

    public final void recentsTabScreenViewed() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_NOTES_RECENTS_VIEWED);
    }

    public final void favoritesTabScreenViewed() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_NOTES_FAVORITES_VIEWED);
    }

    public final void noteListItemTapped() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_NOTE_LIST_ITEM_TAPPED);
    }

    public final void noteCreateTapped() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_NOTE_CREATE_TAPPED);
    }

    public final void noteFavoriteToggled(boolean isFavorite) {
        BoxAmplitudeAnalytics.createEventBuilder().setIsFavorite(isFavorite).logEvent(BoxAnalyticsParams.EVENT_NOTE_FAVORITE_TOGGLED);
    }

    public final void settingsClicked() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_SETTINGS).logEvent(BoxAnalyticsParams.EVENT_SETTINGS_CLICKED);
    }
}
