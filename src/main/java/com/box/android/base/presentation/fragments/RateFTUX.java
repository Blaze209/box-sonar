package com.box.android.base.presentation.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.base.R;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;

/* JADX INFO: loaded from: classes9.dex */
public class RateFTUX extends BaseFTUX {
    public static final String SHARED_PREF_KEY_SHOW_RATE_FTUX_AFTER_DAYS = "sharedPrefKeyShowRateUsFtuxAfterDays";
    private static final int WAIT_PERIOD_IN_DAYS = 5;

    public RateFTUX(IUserContextManager iUserContextManager) {
        super(iUserContextManager, BaseFTUX.FTUXType.RATE, ApplicationProvider.application.getString(R.string.rate_ftux_initial_title), ApplicationProvider.application.getString(R.string.rate_ftux_initial_description));
        setPositiveBtnString(ApplicationProvider.application.getString(R.string.yes));
        setNegativeBtnString(ApplicationProvider.application.getString(R.string.no));
    }

    @Override // com.box.android.base.presentation.fragments.BaseFTUX
    public boolean shouldShow() {
        if (ApplicationProvider.application.getPackageName().equals("com.box.android")) {
            return !isComplete(this.mUserContextManager, getType()) && isWaitPeriodSinceFirstLoginElapsed() && hasWaitTimeElapsed(this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX).getInt(SHARED_PREF_KEY_SHOW_RATE_FTUX_AFTER_DAYS, 0));
        }
        return false;
    }

    private boolean isWaitPeriodSinceFirstLoginElapsed() {
        SharedPreferences userSharedPrefs = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX);
        long j = userSharedPrefs.getLong(BoxCommonConstants.SHARED_PREF_FIRST_LOGIN_TIMESTAMP, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j == 0) {
            userSharedPrefs.edit().putLong(BoxCommonConstants.SHARED_PREF_FIRST_LOGIN_TIMESTAMP, jCurrentTimeMillis).apply();
            j = jCurrentTimeMillis;
        }
        return BoxDateUtils.getDifferenceInDays(j, jCurrentTimeMillis) > 5;
    }

    @Override // com.box.android.base.presentation.fragments.BaseFTUX
    public void onPositiveBtnClicked() {
        setComplete();
        Intent intent = new Intent();
        intent.setAction(BaseFTUX.EXTRA_ACTION_POSITIVE_CLICK);
        intent.putExtra(BaseFTUX.EXTRA_FTUX_TYPE_NAME, getType().name());
        LocalBroadcastManager.getInstance(ApplicationProvider.application).sendBroadcast(intent);
    }

    @Override // com.box.android.base.presentation.fragments.BaseFTUX
    public void onNegativeBtnClicked() {
        this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX).edit().putInt(SHARED_PREF_KEY_SHOW_RATE_FTUX_AFTER_DAYS, 14).apply();
    }

    @Override // com.box.android.base.presentation.fragments.BaseFTUX, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        setComplete();
    }
}
