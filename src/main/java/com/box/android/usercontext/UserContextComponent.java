package com.box.android.usercontext;

import com.box.android.domain.identity.IUserContextComponent;

/* JADX INFO: loaded from: classes13.dex */
public abstract class UserContextComponent implements IUserContextComponent {
    private String mContextId;

    public void setContextId(String str) {
        this.mContextId = str;
    }

    @Override // com.box.android.domain.identity.IUserContextComponent
    public String getContextId() {
        return this.mContextId;
    }

    @Override // com.box.android.domain.identity.IUserContextComponent
    public void onCreate(String str) throws IUserContextComponent.UserContextComponentCreationException {
        this.mContextId = str;
    }

    @Override // com.box.android.domain.identity.IUserContextComponent
    public void onSoftDestroy() {
        this.mContextId = "-1";
    }

    @Override // com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
        this.mContextId = "-1";
    }
}
