package com.amplitude.api;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class IdentifyInterceptor {
    private static final String TAG = "com.amplitude.api.IdentifyInterceptor";
    private final AmplitudeClient client;
    private final DatabaseHelper dbHelper;
    private String deviceId;
    private long identifyBatchIntervalMillis;
    private long lastIdentifyInterceptorId;
    private final WorkerThread logThread;
    private String userId;
    private final AtomicBoolean transferScheduled = new AtomicBoolean(false);
    private final AtomicBoolean identitySet = new AtomicBoolean(false);

    public IdentifyInterceptor(DatabaseHelper databaseHelper, WorkerThread workerThread, long j, AmplitudeClient amplitudeClient) {
        this.lastIdentifyInterceptorId = -1L;
        this.dbHelper = databaseHelper;
        this.logThread = workerThread;
        this.identifyBatchIntervalMillis = j;
        if (databaseHelper.getIdentifyInterceptorCount() > 0) {
            this.lastIdentifyInterceptorId = databaseHelper.getLastIdentifyInterceptorId();
        }
        this.client = amplitudeClient;
    }

    public JSONObject intercept(String str, JSONObject jSONObject) {
        if (isIdentityUpdated(jSONObject)) {
            transferInterceptedIdentify();
        }
        if (!str.equals(Constants.IDENTIFY_EVENT)) {
            return str.equals(Constants.GROUP_IDENTIFY_EVENT) ? jSONObject : fetchAndMergeToNormalEvent(jSONObject);
        }
        if (isSetOnly(jSONObject) && !isSetGroups(jSONObject)) {
            this.lastIdentifyInterceptorId = saveIdentifyProperties(jSONObject);
            scheduleTransfer();
            return null;
        }
        if (isClearAll(jSONObject)) {
            this.dbHelper.removeIdentifyInterceptors(this.lastIdentifyInterceptorId);
            return jSONObject;
        }
        return fetchAndMergeToIdentifyEvent(jSONObject);
    }

    public void setIdentifyBatchIntervalMillis(long j) {
        this.identifyBatchIntervalMillis = j;
    }

    private JSONObject fetchAndMergeToIdentifyEvent(JSONObject jSONObject) {
        try {
            List<JSONObject> identifyInterceptors = this.dbHelper.getIdentifyInterceptors(this.lastIdentifyInterceptorId, -1L);
            if (identifyInterceptors.isEmpty()) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_properties");
            JSONObject jSONObjectMergeIdentifyInterceptList = mergeIdentifyInterceptList(identifyInterceptors);
            if (jSONObject2.has("$set")) {
                mergeUserProperties(jSONObjectMergeIdentifyInterceptList, jSONObject2.getJSONObject("$set"));
            }
            jSONObject2.put("$set", jSONObjectMergeIdentifyInterceptList);
            jSONObject.put("user_properties", jSONObject2);
            this.dbHelper.removeIdentifyInterceptors(this.lastIdentifyInterceptorId);
            return jSONObject;
        } catch (JSONException e) {
            AmplitudeLog.getLogger().w(TAG, "Identify Merge error: " + e.getMessage());
            return jSONObject;
        }
    }

    private JSONObject getTransferIdentifyEvent() {
        try {
            List<JSONObject> identifyInterceptors = this.dbHelper.getIdentifyInterceptors(this.lastIdentifyInterceptorId, -1L);
            if (identifyInterceptors.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = identifyInterceptors.get(0);
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_properties").getJSONObject("$set");
            mergeUserProperties(jSONObject2, mergeIdentifyInterceptList(identifyInterceptors.subList(1, identifyInterceptors.size())));
            jSONObject.getJSONObject("user_properties").put("$set", jSONObject2);
            this.dbHelper.removeIdentifyInterceptors(this.lastIdentifyInterceptorId);
            return jSONObject;
        } catch (JSONException e) {
            AmplitudeLog.getLogger().w(TAG, "Identify Merge error: " + e.getMessage());
            return null;
        }
    }

    private void scheduleTransfer() {
        if (this.transferScheduled.getAndSet(true)) {
            return;
        }
        this.logThread.postDelayed(new Runnable() { // from class: com.amplitude.api.IdentifyInterceptor.1
            @Override // java.lang.Runnable
            public void run() {
                IdentifyInterceptor.this.transferScheduled.set(false);
                IdentifyInterceptor.this.transferInterceptedIdentify();
            }
        }, this.identifyBatchIntervalMillis);
    }

    public void transferInterceptedIdentify() {
        JSONObject transferIdentifyEvent = getTransferIdentifyEvent();
        if (transferIdentifyEvent == null) {
            return;
        }
        this.client.saveEvent(Constants.IDENTIFY_EVENT, transferIdentifyEvent);
    }

    private JSONObject fetchAndMergeToNormalEvent(JSONObject jSONObject) {
        try {
            List<JSONObject> identifyInterceptors = this.dbHelper.getIdentifyInterceptors(this.lastIdentifyInterceptorId, -1L);
            if (identifyInterceptors.isEmpty()) {
                return jSONObject;
            }
            JSONObject jSONObjectMergeIdentifyInterceptList = mergeIdentifyInterceptList(identifyInterceptors);
            mergeUserProperties(jSONObjectMergeIdentifyInterceptList, jSONObject.getJSONObject("user_properties"));
            jSONObject.put("user_properties", jSONObjectMergeIdentifyInterceptList);
            this.dbHelper.removeIdentifyInterceptors(this.lastIdentifyInterceptorId);
            return jSONObject;
        } catch (JSONException e) {
            AmplitudeLog.getLogger().w(TAG, "Identify Merge error: " + e.getMessage());
            return jSONObject;
        }
    }

    private JSONObject mergeIdentifyInterceptList(List<JSONObject> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Iterator<JSONObject> it = list.iterator();
        while (it.hasNext()) {
            mergeUserProperties(jSONObject, it.next().getJSONObject("user_properties").getJSONObject("$set"));
        }
        return jSONObject;
    }

    private void mergeUserProperties(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.put(next, jSONObject2.get(next));
        }
    }

    private boolean isSetOnly(JSONObject jSONObject) {
        return isActionOnly(jSONObject, "$set");
    }

    private boolean isClearAll(JSONObject jSONObject) {
        return isActionOnly(jSONObject, "$clearAll");
    }

    private boolean isSetGroups(JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject("groups").length() > 0;
        } catch (JSONException unused) {
            return false;
        }
    }

    private boolean isActionOnly(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_properties");
            return jSONObject2.length() == 1 && jSONObject2.has(str);
        } catch (JSONException unused) {
        }
    }

    private long saveIdentifyProperties(JSONObject jSONObject) {
        return this.dbHelper.addIdentifyInterceptor(jSONObject.toString());
    }

    private boolean isIdentityUpdated(JSONObject jSONObject) {
        boolean z;
        try {
            if (!this.identitySet.getAndSet(true)) {
                this.userId = jSONObject.getString(AmplitudeClient.USER_ID_KEY);
                this.deviceId = jSONObject.getString(AmplitudeClient.DEVICE_ID_KEY);
                return true;
            }
            if (isIdUpdated(this.userId, jSONObject.getString(AmplitudeClient.USER_ID_KEY))) {
                this.userId = jSONObject.getString(AmplitudeClient.USER_ID_KEY);
                z = true;
            } else {
                z = false;
            }
            if (!isIdUpdated(this.deviceId, jSONObject.getString(AmplitudeClient.DEVICE_ID_KEY))) {
                return z;
            }
            this.deviceId = jSONObject.getString(AmplitudeClient.DEVICE_ID_KEY);
            return true;
        } catch (JSONException unused) {
            return true;
        }
    }

    private boolean isIdUpdated(String str, String str2) {
        if (str == null && str2 == null) {
            return false;
        }
        if (str == null || str2 == null) {
            return true;
        }
        return true ^ str.equals(str2);
    }
}
