package com.box.android.coreservices.jobmanager;

import android.text.TextUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.requests.BoxRequestGetInbox;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public abstract class JobItem extends JobItemJsonEntity implements ProgressReporter {
    public static final String ERROR_TYPE = "error_type";
    protected ErrorType mErrorType;
    protected final transient ArrayList<WeakReference<ProgressReporter.ProgressListener>> mListeners;

    public interface BoxItemJobItem {
        String getItemId();
    }

    public abstract void cancel();

    public abstract JobItemState getCurrentState();

    public abstract String getErrorText();

    public abstract String getTitle();

    public abstract boolean hasError();

    public abstract boolean pause();

    protected void reportSessionStarted(BoxUploadSession boxUploadSession) {
    }

    public abstract boolean restart(boolean z);

    public enum JobItemState {
        QUEUED("queued"),
        EXECUTING("executing"),
        COMPLETED(BoxRequestGetInbox.STATUS_COMPLETED),
        PAUSED("paused"),
        CANCELLED("cancelled");

        private final String mValue;

        JobItemState(String str) {
            this.mValue = str;
        }

        public static JobItemState fromString(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (JobItemState jobItemState : values()) {
                    if (str.equalsIgnoreCase(jobItemState.toString())) {
                        return jobItemState;
                    }
                }
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "No enum with text %s found", str));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mValue;
        }
    }

    public enum ErrorType {
        IO(R.string.job_item_error_type_io),
        PERMISSION(R.string.job_item_error_type_permission),
        OS_PERMISSION(R.string.job_item_error_type_os_permission),
        DISK_FULL(R.string.job_item_error_type_disk_full),
        WIFI_REQUIRED(R.string.job_item_error_type_wifi_required),
        DUPLICATE(R.string.job_item_error_type_duplicate),
        EXCEEDS_USER_UPLOAD_LIMIT(R.string.job_item_error_type_exceeds_upload_limit),
        LOST_CONNECTION(R.string.job_item_error_type_lost_connection),
        CONFLICTS_WITH_EXISTING(R.string.job_item_error_type_conflicts_with_existing_item),
        GENERIC_EXCEPTION(R.string.job_item_error_type_generic_exception),
        TIMED_OUT_EXCEPTION(R.string.job_item_error_type_timed_out),
        UNABLE_TO_LOAD_FOLDER(R.string.LS_Unable_to_load_),
        PREVIEW_NOT_AVAILABLE(R.string.Preview_not_available),
        ITEM_NOT_FOUND(R.string.This_item_does_not_exist),
        BAD_DIGEST(R.string.job_item_error_corrupted),
        SOURCE_OR_DESTINATION_NOT_FOUND(R.string.The_source_or_destination_does_not_exist),
        STORAGE_LIMIT_EXCEEDED(R.string.Box_account_storage_limit_exceeded),
        OPERATION_NOT_ALLOWED_BY_ENTERPRISE(R.string.Operation_not_allowed_by_enterprise);

        private String mHumanReadableString;

        ErrorType(int i) {
            this.mHumanReadableString = CommonBoxUtil.LS(i);
        }

        public String getMessage() {
            return this.mHumanReadableString;
        }
    }

    protected JobItem() {
        this.mListeners = new ArrayList<WeakReference<ProgressReporter.ProgressListener>>() { // from class: com.box.android.coreservices.jobmanager.JobItem.1
            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(WeakReference<ProgressReporter.ProgressListener> weakReference) {
                if (weakReference == null) {
                    BoxLogUtils.logException("JobItem", "null being added", new RuntimeException("null being added to mListeners"));
                    return false;
                }
                return super.add(weakReference);
            }
        };
    }

    protected JobItem(String str, String str2) {
        super(str, str2);
        this.mListeners = new ArrayList<WeakReference<ProgressReporter.ProgressListener>>() { // from class: com.box.android.coreservices.jobmanager.JobItem.1
            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(WeakReference<ProgressReporter.ProgressListener> weakReference) {
                if (weakReference == null) {
                    BoxLogUtils.logException("JobItem", "null being added", new RuntimeException("null being added to mListeners"));
                    return false;
                }
                return super.add(weakReference);
            }
        };
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public void addProgressListener(ProgressReporter.ProgressListener progressListener) {
        this.mListeners.add(new WeakReference<>(progressListener));
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public void removeProgressListener(ProgressReporter.ProgressListener progressListener) {
        ArrayList<WeakReference<ProgressReporter.ProgressListener>> arrayList = this.mListeners;
        if (arrayList == null) {
            BoxLogUtils.logException("JobItem", "mListeners null", new RuntimeException("null list of refs"));
            return;
        }
        for (WeakReference<ProgressReporter.ProgressListener> weakReference : arrayList) {
            if (weakReference == null) {
                BoxLogUtils.logException("JobItem", " Weak Reference null in Array", new RuntimeException("ref has become null"));
            } else if (weakReference.get() == progressListener) {
                this.mListeners.remove(weakReference);
            }
        }
    }

    protected void reportStarted(ProgressReporter progressReporter) {
        ArrayList<WeakReference<ProgressReporter.ProgressListener>> arrayList = this.mListeners;
        if (arrayList == null) {
            BoxLogUtils.logException("JobItem", "mListeners null", new RuntimeException("null list of refs"));
            return;
        }
        for (WeakReference<ProgressReporter.ProgressListener> weakReference : arrayList) {
            if (weakReference == null) {
                BoxLogUtils.logException("JobItem", " Weak Reference null in Array", new RuntimeException("ref has become null"));
            } else {
                ProgressReporter.ProgressListener progressListener = weakReference.get();
                if (progressListener != null) {
                    progressListener.onStarted(this);
                }
            }
        }
    }

    protected void reportProgressUpdated(ProgressReporter progressReporter, ProgressReporter.ProgressType progressType, long j, long j2) {
        ArrayList<WeakReference<ProgressReporter.ProgressListener>> arrayList = this.mListeners;
        if (arrayList == null) {
            BoxLogUtils.logException("JobItem", "mListeners null", new RuntimeException("null list of refs"));
            return;
        }
        for (WeakReference<ProgressReporter.ProgressListener> weakReference : arrayList) {
            if (weakReference == null) {
                BoxLogUtils.logException("JobItem", " Weak Reference null in Array", new RuntimeException("ref has become null"));
            } else {
                ProgressReporter.ProgressListener progressListener = weakReference.get();
                JobItem jobItem = this;
                ProgressReporter.ProgressType progressType2 = progressType;
                long j3 = j;
                long j4 = j2;
                if (progressListener != null) {
                    progressListener.onProgressUpdated(jobItem, progressType2, j3, j4);
                }
                this = jobItem;
                progressType = progressType2;
                j = j3;
                j2 = j4;
            }
        }
    }

    protected void reportPaused(ProgressReporter progressReporter) {
        ArrayList<WeakReference<ProgressReporter.ProgressListener>> arrayList = this.mListeners;
        if (arrayList == null) {
            BoxLogUtils.logException("JobItem", "mListeners null", new RuntimeException("null list of refs"));
            return;
        }
        for (WeakReference<ProgressReporter.ProgressListener> weakReference : arrayList) {
            if (weakReference == null) {
                BoxLogUtils.logException("JobItem", " Weak Reference null in Array", new RuntimeException("ref has become null"));
            } else {
                ProgressReporter.ProgressListener progressListener = weakReference.get();
                if (progressListener != null) {
                    progressListener.onPaused(this);
                }
            }
        }
    }

    protected void reportCompleted(ProgressReporter progressReporter) {
        ArrayList<WeakReference<ProgressReporter.ProgressListener>> arrayList = this.mListeners;
        if (arrayList == null) {
            BoxLogUtils.logException("JobItem", "mListeners null", new RuntimeException("null list of refs"));
            return;
        }
        for (WeakReference<ProgressReporter.ProgressListener> weakReference : arrayList) {
            if (weakReference == null) {
                BoxLogUtils.logException("JobItem", " Weak Reference null in Array", new RuntimeException("ref has become null"));
            } else {
                ProgressReporter.ProgressListener progressListener = weakReference.get();
                if (progressListener != null) {
                    progressListener.onCompleted(this);
                }
            }
        }
    }

    protected void reportTaskAdded(BoxTask boxTask) {
        ArrayList<WeakReference<ProgressReporter.ProgressListener>> arrayList = this.mListeners;
        if (arrayList == null) {
            BoxLogUtils.logException("JobItem", "mListeners null", new RuntimeException("null list of refs"));
            return;
        }
        for (WeakReference<ProgressReporter.ProgressListener> weakReference : arrayList) {
            if (weakReference == null) {
                BoxLogUtils.logException("JobItem", " Weak Reference null in Array", new RuntimeException("ref has become null"));
            } else {
                ProgressReporter.ProgressListener progressListener = weakReference.get();
                if (progressListener != null && (progressListener instanceof ProgressReporter.JobProgressListener)) {
                    ((ProgressReporter.JobProgressListener) progressListener).onTaskAdded(boxTask);
                }
            }
        }
    }

    protected void reportError(ProgressReporter progressReporter, Exception exc) {
        ArrayList<WeakReference<ProgressReporter.ProgressListener>> arrayList = this.mListeners;
        if (arrayList == null) {
            BoxLogUtils.logException("JobItem", "mListeners null", new RuntimeException("null list of refs"));
            return;
        }
        for (WeakReference<ProgressReporter.ProgressListener> weakReference : arrayList) {
            if (weakReference == null) {
                BoxLogUtils.logException("JobItem", " Weak Reference null in Array", new RuntimeException("ref has become null"));
            } else {
                ProgressReporter.ProgressListener progressListener = weakReference.get();
                if (progressListener != null) {
                    progressListener.onError(this, exc);
                }
            }
        }
    }

    public ErrorType getErrorType() {
        return this.mErrorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.mErrorType = errorType;
        if (errorType == null) {
            this.mProperties.remove(ERROR_TYPE);
        } else {
            this.mProperties.put(ERROR_TYPE, Integer.valueOf(errorType.ordinal()));
        }
    }

    public boolean isSuccessfullyCompleted() {
        return getCurrentState() == JobItemState.COMPLETED && !hasError();
    }

    @Override // com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(ERROR_TYPE)) {
            setErrorType(ErrorType.values()[value.asInt()]);
        } else {
            super.parseJSONMember(member);
        }
    }
}
