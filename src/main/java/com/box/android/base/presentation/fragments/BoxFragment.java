package com.box.android.base.presentation.fragments;

import android.content.SharedPreferences;
import androidx.fragment.app.Fragment;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxFragment extends Fragment {

    @Inject
    protected IBaseModelController mBaseModelController;

    @Inject
    protected BoxApiUser mBoxApiUser;

    @Inject
    protected IUserContextManager mUserContextManager;

    protected BoxUser getUserInfo() {
        try {
            return (BoxUser) this.mBaseModelController.performLocal(this.mBoxApiUser.getUserInfoRequest(this.mUserContextManager.getCurrentContextId())).get().getResult();
        } catch (Exception e) {
            BoxLogUtils.logException(e);
            if (!(e instanceof InterruptedException)) {
                return null;
            }
            Thread.currentThread().interrupt();
            return null;
        }
    }

    protected SharedPreferences getUserSharedPrefs() {
        return ((ILocalSharedPreferences) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES)).getSharedPreferences();
    }
}
