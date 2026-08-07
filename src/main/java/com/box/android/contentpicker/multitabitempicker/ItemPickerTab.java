package com.box.android.contentpicker.multitabitempicker;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.browse.R;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.search.SearchMode;
import com.box.androidsdk.content.models.BoxItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MultiTabItemPickerScreenContent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000e"}, d2 = {"Lcom/box/android/contentpicker/multitabitempicker/ItemPickerTab;", "", "<init>", "(Ljava/lang/String;I)V", "RECENTS", "FILES", "COLLECTIONS", "HUBS", "getTitle", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "toSearchMode", "Lcom/box/android/domain/models/search/SearchMode;", "toScreenName", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ItemPickerTab {
    RECENTS,
    FILES,
    COLLECTIONS,
    HUBS;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: compiled from: MultiTabItemPickerScreenContent.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemPickerTab.values().length];
            try {
                iArr[ItemPickerTab.RECENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemPickerTab.FILES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemPickerTab.COLLECTIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ItemPickerTab.HUBS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<ItemPickerTab> getEntries() {
        return $ENTRIES;
    }

    public final String getTitle(Composer composer, int i) {
        String strStringResource;
        ComposerKt.sourceInformationMarkerStart(composer, 1232946394, "C(getTitle):MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1232946394, i, -1, "com.box.android.contentpicker.multitabitempicker.ItemPickerTab.getTitle (MultiTabItemPickerScreenContent.kt:363)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            composer.startReplaceGroup(-549487151);
            ComposerKt.sourceInformation(composer, "364@15980L55");
            strStringResource = StringResources_androidKt.stringResource(R.string.recents, composer, 0);
            composer.endReplaceGroup();
        } else if (i2 == 2) {
            composer.startReplaceGroup(-549484840);
            ComposerKt.sourceInformation(composer, "365@16053L30");
            strStringResource = StringResources_androidKt.stringResource(com.box.android.contentpicker.R.string.files, composer, 0);
            composer.endReplaceGroup();
        } else if (i2 == 3) {
            composer.startReplaceGroup(-549483106);
            ComposerKt.sourceInformation(composer, "366@16107L36");
            strStringResource = StringResources_androidKt.stringResource(com.box.android.contentpicker.R.string.Collections, composer, 0);
            composer.endReplaceGroup();
        } else {
            if (i2 != 4) {
                composer.startReplaceGroup(-549488014);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(-549481417);
            ComposerKt.sourceInformation(composer, "367@16160L29");
            strStringResource = StringResources_androidKt.stringResource(com.box.android.contentpicker.R.string.hubs, composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SearchMode toSearchMode() {
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] == 4) {
            return SearchMode.Hubs.INSTANCE;
        }
        return new SearchMode.Files(null, 1, 0 == true ? 1 : 0);
    }

    public final String toScreenName() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return BoxAnalyticsParams.ACTION_RECENTS;
        }
        if (i == 2) {
            return "files";
        }
        if (i == 3) {
            return BoxItem.FIELD_COLLECTIONS;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return "hubs";
    }
}
