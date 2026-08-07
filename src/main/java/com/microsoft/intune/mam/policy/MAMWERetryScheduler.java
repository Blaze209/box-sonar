package com.microsoft.intune.mam.policy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.format.DateFormat;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.policy.cache.MAMServiceUrlCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMWERetryScheduler {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final long DEFAULT_RETRY_INTERVAL_MS = 86400000;
    public static final long DEFAULT_UNLICENSED_RETRY_INTERVAL_MS = 43200000;
    private static final long HOURS_PER_DAY = 24;
    private static final long MAX_FREQUENT_RETRY_INTERVAL_MS = 3600000;
    private static final long MAX_SLEEP_MS = 86400000;
    private static final Long MINIMAL_DELAY_MS = 20L;
    private static final long MINS_PER_HOUR = 60;
    private static final long MIN_FREQUENT_RETRY_INTERVAL_MS = 5000;
    private static final long MIN_NO_TOKEN_RETRY_INTERVAL_MS = 10000;
    private static final long ONE_HOUR_MS = 3600000;
    private static final long ONE_MINUTE_MS = 60000;
    private static final long TWENTY_FOUR_HOURS_MS = 86400000;
    private final MAMWEEnroller mEnroller;
    private final MAMIdentityManager mIdentityManager;
    boolean mIsOnline;
    private final MAMLogPIIFactory mLogScrubber;
    private final RetryTimerRecords mRetryTimerRecords;
    private final Map<String, RetryTask> mScheduledTasks = new HashMap();
    private final MAMWETaskQueue mTaskQueue = new MAMWETaskQueue();
    private final Thread mTaskThread;
    private final MAMServiceUrlCache mUrlCache;

    protected abstract MAMLogger logger();

    class RetryTask implements MAMWETaskQueue.Task {
        final long mDelay;
        final long mDue;
        final MAMIdentity mIdentity;

        public RetryTask(MAMIdentity mAMIdentity, long j, long j2) {
            this.mIdentity = mAMIdentity;
            this.mDue = j;
            this.mDelay = j2;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            MAMWERetryScheduler.this.logger().info("Executing scheduled enrollment retry task for {0}", MAMWERetryScheduler.this.mLogScrubber.getPIIUPN(this.mIdentity));
            try {
                MAMWERetryScheduler.this.removeTasksForAccount(this.mIdentity);
                MAMWERetryScheduler.this.mEnroller.attemptMamEnrollment(this.mIdentity);
            } catch (Exception e) {
                MAMWERetryScheduler.this.logger().error(MAMInterfaceError.ENROLLMENT_RETRY_FAILURE, "Enrollment retry task failed for {0}", e, MAMWERetryScheduler.this.mLogScrubber.getPIIUPN(this.mIdentity));
                MAMWERetryScheduler.this.scheduleEnrollmentRetry(this.mIdentity, this.mDelay);
            }
        }

        @Override // com.microsoft.intune.mam.policy.MAMWETaskQueue.Task
        public long dueAt() {
            return this.mDue;
        }
    }

    private class TaskRunner implements Runnable {
        private TaskRunner() {
        }

        /* synthetic */ TaskRunner(MAMWERetryScheduler mAMWERetryScheduler, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                MAMWERetryScheduler.this.logger().info("task thread waiting for tasks.", new Object[0]);
                List<MAMWETaskQueue.Task> dueTasks = MAMWERetryScheduler.this.mTaskQueue.getDueTasks(86400000L);
                MAMWERetryScheduler.this.logger().info("task thread got {0} task(s) to execute.", Integer.valueOf(dueTasks.size()));
                executeTasks(dueTasks);
            }
        }

        private void executeTasks(List<MAMWETaskQueue.Task> list) {
            Iterator<MAMWETaskQueue.Task> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public MAMWERetryScheduler(MAMWEEnroller mAMWEEnroller, MAMIdentityManager mAMIdentityManager, MAMLogPIIFactory mAMLogPIIFactory, Context context, MAMServiceUrlCache mAMServiceUrlCache, boolean z) {
        this.mEnroller = mAMWEEnroller;
        this.mIdentityManager = mAMIdentityManager;
        this.mLogScrubber = mAMLogPIIFactory;
        Thread thread = new Thread(new TaskRunner(this, null));
        this.mTaskThread = thread;
        thread.setName("Intune MAM enrollment retry");
        thread.start();
        this.mRetryTimerRecords = new RetryTimerRecords(context);
        this.mUrlCache = mAMServiceUrlCache;
        this.mIsOnline = z;
    }

    public void scheduleEnrollmentRetriesAtStartup(List<MAMWEAccountRegistry.AccountInfo> list, MAMIdentity mAMIdentity) throws Throwable {
        logger().info("scheduling any necessary enrollment retries at startup; online: " + String.valueOf(this.mIsOnline), new Object[0]);
        for (MAMWEAccountRegistry.AccountInfo accountInfo : list) {
            Long lEvaluateRetryAtStartup = evaluateRetryAtStartup(accountInfo, mAMIdentity);
            if (lEvaluateRetryAtStartup != null) {
                MAMIdentity mAMIdentityInsertOrUpdate = this.mIdentityManager.insertOrUpdate(accountInfo.mAadId, accountInfo.mUpn, accountInfo.mTenantId, accountInfo.mAuthority, false);
                if (mAMIdentityInsertOrUpdate != null) {
                    logger().info("scheduling MAM-WE enrollment retry in {0} for {1} with status {2} triggered by app startup.", formatIntervalForLog(lEvaluateRetryAtStartup.longValue()), this.mLogScrubber.getPIIUPN(accountInfo.mUpn, accountInfo.mAadId), accountInfo.mStatus);
                    scheduleEnrollmentRetry(mAMIdentityInsertOrUpdate, lEvaluateRetryAtStartup.longValue());
                } else {
                    logger().warning("unable to load identity for MAM-WE enrollment retry for {0} with status {1}", this.mLogScrubber.getPIIUPN(accountInfo.mUpn, accountInfo.mAadId), accountInfo.mStatus);
                }
            } else {
                logger().info("no MAM-WE enrollment retry necessary for {0}", this.mLogScrubber.getPIIUPN(accountInfo.mUpn, accountInfo.mAadId));
            }
        }
    }

    public void scheduleEnrollmentRetry(MAMWEAccountRegistry.AccountInfo accountInfo) throws Throwable {
        if (shouldRetryLater(accountInfo)) {
            MAMIdentity mAMIdentityCreate = this.mIdentityManager.create(accountInfo.mUpn, accountInfo.mAadId);
            if (mAMIdentityCreate != null) {
                long retryInterval = getRetryInterval(accountInfo);
                logger().info("scheduling MAM-WE enrollment retry in {0} for {1} with status {2}", formatIntervalForLog(retryInterval), this.mLogScrubber.getPIIUPN(mAMIdentityCreate), accountInfo.mStatus);
                scheduleEnrollmentRetry(mAMIdentityCreate, retryInterval);
                return;
            }
            logger().warning("unable to load identity to schedule MAM-WE enrollment retry for {0} with status {1}", this.mLogScrubber.getPIIUPN(accountInfo.mUpn, accountInfo.mAadId), accountInfo.mStatus);
        }
    }

    private long getRetryInterval(MAMWEAccountRegistry.AccountInfo accountInfo) {
        long jMin;
        if (accountInfo.mError == MAMWEError.NETWORK_ERROR || accountInfo.mError == MAMWEError.APP_DID_NOT_PROVIDE_TOKEN) {
            jMin = Math.min(Math.max(this.mRetryTimerRecords.getLastRetryInterval(accountInfo.mAadId) * 2, accountInfo.mError == MAMWEError.APP_DID_NOT_PROVIDE_TOKEN ? 10000L : 5000L), 3600000L);
            logger().info("For MAMWE error " + accountInfo.mError + " using retry interval " + jMin, new Object[0]);
        } else if (accountInfo.mStatus == MAMEnrollmentManager.Result.NOT_LICENSED) {
            MAMIdentity mAMIdentityCreate = this.mIdentityManager.create(accountInfo.mUpn, accountInfo.mAadId);
            jMin = (this.mIsOnline || !this.mUrlCache.getUrls(mAMIdentityCreate).isEmpty()) ? DEFAULT_UNLICENSED_RETRY_INTERVAL_MS : this.mUrlCache.getUnlicensedRetryInterval(mAMIdentityCreate);
            logger().info("For NOT_LICENSED MAM-WE account " + this.mLogScrubber.getPIIUPN(accountInfo.mUpn, accountInfo.mAadId) + " using retry interval " + formatIntervalForLog(jMin), new Object[0]);
        } else {
            logger().info("Using default MAM-WE retry interval of {0} for account {1} with status {2}", formatIntervalForLog(86400000L), this.mLogScrubber.getPIIUPN(accountInfo.mUpn, accountInfo.mAadId), accountInfo.mStatus);
            jMin = 86400000;
        }
        this.mRetryTimerRecords.setLastRetryInterval(accountInfo.mAadId, jMin);
        return jMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleEnrollmentRetry(MAMIdentity mAMIdentity, long j) throws Throwable {
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() + j;
                logger().info("scheduling enrollment retry task for {0} due at {1}.", this.mLogScrubber.getPIIUPN(mAMIdentity), formatDate(jCurrentTimeMillis));
                RetryTask retryTask = new RetryTask(mAMIdentity, jCurrentTimeMillis, j);
                this.mTaskQueue.add(retryTask);
                this.mScheduledTasks.put(mAMIdentity.aadId(), retryTask);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String formatDate(long j) {
        return String.valueOf(DateFormat.format("yyyy-MM-dd HH:mm:ss", j));
    }

    static String formatIntervalForLog(long j) {
        if (j < TimeUnit.MINUTES.toMillis(1L)) {
            return j + " ms";
        }
        long j2 = j / 86400000;
        long j3 = (j / 3600000) % HOURS_PER_DAY;
        long j4 = (j / 60000) % 60;
        StringBuilder sb = new StringBuilder();
        if (j2 > 0) {
            sb.append(String.format(Locale.US, " %s days", String.valueOf(j2)));
        }
        if (j3 > 0) {
            sb.append(String.format(Locale.US, " %s hours", String.valueOf(j3)));
        }
        if (j4 > 0) {
            sb.append(String.format(Locale.US, " %s mins", String.valueOf(j4)));
        }
        return String.format(Locale.US, "%d ms (%s)", Long.valueOf(j), sb.toString().trim());
    }

    public synchronized void removeTasksForAccount(MAMIdentity mAMIdentity) {
        logger().info("removing any remaining scheduled tasks for {0}", this.mLogScrubber.getPIIUPN(mAMIdentity));
        RetryTask retryTaskRemove = this.mScheduledTasks.remove(mAMIdentity.aadId());
        if (retryTaskRemove != null) {
            this.mTaskQueue.remove(retryTaskRemove);
        }
    }

    public synchronized void removeAccount(MAMIdentity mAMIdentity) {
        removeTasksForAccount(mAMIdentity);
        this.mRetryTimerRecords.removeLastRetryInterval(mAMIdentity.aadId());
    }

    public void primaryUserRemoved(List<MAMWEAccountRegistry.AccountInfo> list, MAMIdentity mAMIdentity) throws Throwable {
        logger().info("Primary user {0} removed. Retrying any registered users that received WRONG_USER", this.mLogScrubber.getPIIUPN(mAMIdentity));
        for (MAMWEAccountRegistry.AccountInfo accountInfo : list) {
            MAMIdentity mAMIdentityCreate = this.mIdentityManager.create(accountInfo.mUpn, accountInfo.mAadId);
            if (!mAMIdentity.equals(mAMIdentityCreate) && accountInfo.mStatus == MAMEnrollmentManager.Result.WRONG_USER) {
                scheduleEnrollmentRetry(mAMIdentityCreate, MINIMAL_DELAY_MS.longValue());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0044  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    private Long evaluateRetryAtStartup(MAMWEAccountRegistry.AccountInfo accountInfo, MAMIdentity mAMIdentity) {
        long retryInterval;
        long lastRetryInterval;
        long jCurrentTimeMillis;
        Long l;
        if (accountInfo.mStatus == null) {
            return MINIMAL_DELAY_MS;
        }
        switch (AnonymousClass1.$SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[accountInfo.mStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return null;
            case 4:
                if (this.mIsOnline) {
                    return MINIMAL_DELAY_MS;
                }
                return null;
            case 5:
                return MINIMAL_DELAY_MS;
            case 6:
                if (this.mIsOnline && shouldRetryWrongUserImmediately(accountInfo, mAMIdentity)) {
                    return MINIMAL_DELAY_MS;
                }
                retryInterval = 86400000;
                lastRetryInterval = this.mRetryTimerRecords.getLastRetryInterval(accountInfo.mAadId);
                if (lastRetryInterval > 0) {
                    retryInterval = lastRetryInterval;
                }
                jCurrentTimeMillis = (accountInfo.mTimestamp + retryInterval) - System.currentTimeMillis();
                l = MINIMAL_DELAY_MS;
                if (jCurrentTimeMillis < l.longValue()) {
                    jCurrentTimeMillis = l.longValue();
                }
                return Long.valueOf(jCurrentTimeMillis);
            case 7:
                retryInterval = getRetryInterval(accountInfo);
                lastRetryInterval = this.mRetryTimerRecords.getLastRetryInterval(accountInfo.mAadId);
                if (lastRetryInterval > 0) {
                    retryInterval = lastRetryInterval;
                }
                jCurrentTimeMillis = (accountInfo.mTimestamp + retryInterval) - System.currentTimeMillis();
                l = MINIMAL_DELAY_MS;
                if (jCurrentTimeMillis < l.longValue()) {
                    jCurrentTimeMillis = l.longValue();
                }
                return Long.valueOf(jCurrentTimeMillis);
            default:
                retryInterval = 86400000;
                lastRetryInterval = this.mRetryTimerRecords.getLastRetryInterval(accountInfo.mAadId);
                if (lastRetryInterval > 0) {
                    retryInterval = lastRetryInterval;
                }
                jCurrentTimeMillis = (accountInfo.mTimestamp + retryInterval) - System.currentTimeMillis();
                l = MINIMAL_DELAY_MS;
                if (jCurrentTimeMillis < l.longValue()) {
                    jCurrentTimeMillis = l.longValue();
                }
                return Long.valueOf(jCurrentTimeMillis);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.intune.mam.policy.MAMWERetryScheduler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result;

        static {
            int[] iArr = new int[MAMEnrollmentManager.Result.values().length];
            $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result = iArr;
            try {
                iArr[MAMEnrollmentManager.Result.ENROLLMENT_SUCCEEDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.UNENROLLMENT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.UNENROLLMENT_SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.PENDING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.WRONG_USER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.NOT_LICENSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.AUTHORIZATION_NEEDED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.ENROLLMENT_FAILED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private boolean shouldRetryWrongUserImmediately(MAMWEAccountRegistry.AccountInfo accountInfo, MAMIdentity mAMIdentity) {
        if (MAMInfo.isMMAEnabled() || MAMIdentity.isNullOrEmpty(mAMIdentity)) {
            return true;
        }
        return mAMIdentity.equals(this.mIdentityManager.create(accountInfo.mUpn, accountInfo.mAadId));
    }

    private boolean shouldRetryLater(MAMWEAccountRegistry.AccountInfo accountInfo) {
        if (accountInfo != null && accountInfo.mStatus != null) {
            switch (AnonymousClass1.$SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[accountInfo.mStatus.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                    return true;
                default:
                    logger().warning("shouldRetryLater found unknown status, won't retry: " + accountInfo.mStatus.toString(), new Object[0]);
                    return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class RetryTimerRecords extends BaseSharedPrefs {
        private static final String KEY_RETRY_INTERVAL_PREFIX = "retryinterval:";
        private static final String PREF_NAME = "com.microsoft.intune.mam.RetryTimers";

        public RetryTimerRecords(Context context) {
            super(context, "com.microsoft.intune.mam.RetryTimers", true);
        }

        public long getLastRetryInterval(final String str) {
            return ((Long) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.policy.MAMWERetryScheduler$RetryTimerRecords$$ExternalSyntheticLambda0
                @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
                public final Object execute(SharedPreferences sharedPreferences) {
                    return this.f$0.m13875x5ba6547f(str, sharedPreferences);
                }
            })).longValue();
        }

        /* JADX INFO: renamed from: lambda$getLastRetryInterval$0$com-microsoft-intune-mam-policy-MAMWERetryScheduler$RetryTimerRecords, reason: not valid java name */
        /* synthetic */ Long m13875x5ba6547f(String str, SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(makeKey(str), -1L));
        }

        /* JADX INFO: renamed from: lambda$setLastRetryInterval$1$com-microsoft-intune-mam-policy-MAMWERetryScheduler$RetryTimerRecords, reason: not valid java name */
        /* synthetic */ void m13877x34a0c034(String str, long j, SharedPreferences.Editor editor) {
            editor.putLong(makeKey(str), j);
        }

        public void setLastRetryInterval(final String str, final long j) {
            setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.policy.MAMWERetryScheduler$RetryTimerRecords$$ExternalSyntheticLambda1
                @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
                public final void execute(SharedPreferences.Editor editor) {
                    this.f$0.m13877x34a0c034(str, j, editor);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$removeLastRetryInterval$2$com-microsoft-intune-mam-policy-MAMWERetryScheduler$RetryTimerRecords, reason: not valid java name */
        /* synthetic */ void m13876x4ccdfcf9(String str, SharedPreferences.Editor editor) {
            editor.remove(makeKey(str));
        }

        public void removeLastRetryInterval(final String str) {
            setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.policy.MAMWERetryScheduler$RetryTimerRecords$$ExternalSyntheticLambda2
                @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
                public final void execute(SharedPreferences.Editor editor) {
                    this.f$0.m13876x4ccdfcf9(str, editor);
                }
            });
        }

        private String makeKey(String str) {
            return KEY_RETRY_INTERVAL_PREFIX + str;
        }
    }
}
