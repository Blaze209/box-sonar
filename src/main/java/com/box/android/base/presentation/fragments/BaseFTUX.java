package com.box.android.base.presentation.fragments;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseFTUX implements DialogInterface.OnDismissListener {
    public static final int DEFAULT_FTUX_WAIT_PERIOD_IN_DAYS = 14;
    public static final String EXTRA_ACTION_POSITIVE_CLICK = "extraActionPositiveClick";
    public static final String EXTRA_ACTION_SHOW_FTUX = "extraActionShowRecents";
    public static final String EXTRA_FTUX_TYPE_NAME = "extraFtuxTypeName";
    public static final int MINIMUM_PREVIEWS_REQUIRED = 5;
    public static final String SHARED_PREF_KEY_FTUX_COMPLETE = "sharedPrefKey%1$sFTUXComplete";
    public static final String SHARED_PREF_KEY_FTUX_LAST_SHOWN = "sharedPrefKey%1$sFTUXLastShown";
    public static final String SHARED_PREF_KEY_PREVIEW_COUNT = "sharedPrefKeyPreviewCount";
    public static final String SHARED_PREF_KEY_RECENTLY_PREVIEWED_FILEID = "sharedPrefKeyRecentlyPreviewedFileId";
    public static final String SHARED_PREF_KEY_RECENTLY_PREVIEWED_FILENAME = "sharedPrefKeyRecentlyPreviewedFilename";
    public static final String SHARED_PREF_KEY_SHARING_OR_COLLAB_USED = "sharedPrefKeySharingOrCollabFeatureUsed";
    private String description;
    private boolean isCancelable = true;
    protected IUserContextManager mUserContextManager;
    private String negativeBtnString;
    private String positiveBtnString;
    private String title;
    private FTUXType type;

    public enum FTUXType {
        RATE
    }

    public void onNegativeBtnClicked() {
    }

    public abstract void onPositiveBtnClicked();

    public abstract boolean shouldShow();

    public static class FTUXFactory {
        private final IUserContextManager userContextManager;

        @Inject
        public FTUXFactory(IUserContextManager iUserContextManager) {
            this.userContextManager = iUserContextManager;
        }

        public BaseFTUX createFTUX(FTUXType fTUXType) {
            if (AnonymousClass1.$SwitchMap$com$box$android$base$presentation$fragments$BaseFTUX$FTUXType[fTUXType.ordinal()] != 1) {
                throw new IncompatibleClassChangeError();
            }
            return new RateFTUX(this.userContextManager);
        }
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.fragments.BaseFTUX$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$base$presentation$fragments$BaseFTUX$FTUXType;

        static {
            int[] iArr = new int[FTUXType.values().length];
            $SwitchMap$com$box$android$base$presentation$fragments$BaseFTUX$FTUXType = iArr;
            try {
                iArr[FTUXType.RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    protected BaseFTUX(IUserContextManager iUserContextManager, FTUXType fTUXType, String str, String str2) {
        this.mUserContextManager = iUserContextManager;
        this.type = fTUXType;
        this.title = str;
        this.description = str2;
    }

    public FTUXType getType() {
        return this.type;
    }

    public void setType(FTUXType fTUXType) {
        this.type = fTUXType;
    }

    public boolean isCancelable() {
        return this.isCancelable;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getPositiveBtnString() {
        return this.positiveBtnString;
    }

    public void setPositiveBtnString(String str) {
        this.positiveBtnString = str;
    }

    public String getNegativeBtnString() {
        return this.negativeBtnString;
    }

    public void setNegativeBtnString(String str) {
        this.negativeBtnString = str;
    }

    public static boolean isComplete(IUserContextManager iUserContextManager, FTUXType fTUXType) {
        return iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX).getBoolean(String.format(SHARED_PREF_KEY_FTUX_COMPLETE, fTUXType.name().substring(0, 1) + fTUXType.name().substring(1).toLowerCase()), false);
    }

    public void setComplete() {
        setTypeComplete(this.type, this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX));
    }

    public static void setTypeComplete(FTUXType fTUXType, SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean(String.format(SHARED_PREF_KEY_FTUX_COMPLETE, fTUXType.name().substring(0, 1) + fTUXType.name().substring(1).toLowerCase()), true).apply();
    }

    public void recordDisplayTimestamp() {
        this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX).edit().putLong(String.format(SHARED_PREF_KEY_FTUX_LAST_SHOWN, this.type.name().substring(0, 1) + this.type.name().substring(1).toLowerCase()), System.currentTimeMillis()).apply();
    }

    public long getLastShownTimestamp() {
        return this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX).getLong(String.format(SHARED_PREF_KEY_FTUX_LAST_SHOWN, this.type.name().substring(0, 1) + this.type.name().substring(1).toLowerCase()), 0L);
    }

    protected boolean hasWaitTimeElapsed(int i) {
        long lastShownTimestamp = getLastShownTimestamp();
        return lastShownTimestamp == 0 || BoxDateUtils.getDifferenceInDays(lastShownTimestamp, System.currentTimeMillis()) > i;
    }

    public void show(AppCompatActivity appCompatActivity) {
        if (appCompatActivity != null) {
            appCompatActivity.setRequestedOrientation(1);
            FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
            supportFragmentManager.beginTransaction();
            ShowFTUXDialogFragment.newInstance(this).show(supportFragmentManager, ShowFTUXDialogFragment.TAG);
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_AB_TESTING, BoxAnalyticsParams.ACTION_FTUX_DISPLAYED, getType().name());
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        onNegativeBtnClicked();
    }
}
