package com.microsoft.intune.mam.client.identity;

import android.content.Context;
import android.os.AsyncTask;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private Context mContext;
    private MAMIdentity mIdentity;
    private MAMPolicyManagerBehavior mPolicyManagerBehavior = (MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class);

    protected abstract Result doInBackgroundMAM(Params... paramsArr);

    public MAMAsyncTask(Context context) {
        this.mContext = context;
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        Context context;
        MAMIdentity currentThreadMAMIdentity = this.mPolicyManagerBehavior.getCurrentThreadMAMIdentity();
        this.mIdentity = currentThreadMAMIdentity;
        if (currentThreadMAMIdentity == null && (context = this.mContext) != null) {
            this.mIdentity = this.mPolicyManagerBehavior.getUIPolicyMAMIdentity(context);
        }
        this.mContext = null;
        onPreExecuteMAM();
    }

    @Override // android.os.AsyncTask
    protected final Result doInBackground(Params... paramsArr) {
        this.mPolicyManagerBehavior.setCurrentThreadMAMIdentity(this.mIdentity);
        try {
            return doInBackgroundMAM(paramsArr);
        } finally {
            this.mPolicyManagerBehavior.setCurrentThreadMAMIdentity(null);
        }
    }

    protected void onPreExecuteMAM() {
        super.onPreExecute();
    }
}
