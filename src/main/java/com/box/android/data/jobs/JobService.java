package com.box.android.data.jobs;

import android.content.Context;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.hubs.HubAssetRemoteDataSource;
import com.box.android.data.datasource.jobs.JobsDataSource;
import com.box.android.data.persistence.jobs.JobEntity;
import com.box.android.data.persistence.jobs.JobIdToWorkIdRelation;
import com.box.android.data.persistence.jobs.JobStatus;
import com.box.android.data.service.impl.DomainErrorMapper;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.jobs.JobRequest;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.metrics.Gen204JobServiceHelper;
import com.box.android.domain.models.DisplayableJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ErrorRecoveryType;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.MetricsInfoProvider;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.analytics.Analytics;
import dagger.Lazy;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: JobService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ®\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002®\u0001BU\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,2\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001702H\u0096@¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020-H\u0086@¢\u0006\u0002\u00105J\u0016\u0010+\u001a\u00020-2\u0006\u00106\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u00107J8\u00108\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,2\u0006\u0010/\u001a\u0002002\u0006\u00109\u001a\u00020\u00172\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001702H\u0096@¢\u0006\u0002\u0010;J\u001e\u0010<\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>H\u0096@¢\u0006\u0002\u0010?J\"\u0010@\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u00107J\u0018\u0010A\u001a\u0004\u0018\u00010\u001e2\u0006\u00106\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u00107J\"\u0010B\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020.0,2\u0006\u0010D\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u00107J\"\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u00107J.\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020\u00172\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0086@¢\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010MJ \u0010N\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180O\u0012\u0004\u0012\u00020.0,H\u0096@¢\u0006\u0002\u00105J\u000e\u0010P\u001a\u00020-H\u0096@¢\u0006\u0002\u00105J\u0016\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020SH\u0096@¢\u0006\u0002\u0010TJ\u000e\u0010U\u001a\u00020-H\u0096@¢\u0006\u0002\u00105J.\u0010V\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180O\u0012\u0004\u0012\u00020.0,2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\"0OH\u0096@¢\u0006\u0002\u0010XJ \u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180O\u0012\u0004\u0012\u00020.0,H\u0096@¢\u0006\u0002\u00105J\u001e\u0010Y\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020[H\u0086@¢\u0006\u0002\u0010\\J\u000e\u0010]\u001a\u00020-H\u0086@¢\u0006\u0002\u00105J8\u0010^\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020_0,2\u001c\u0010`\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0b\u0012\u0006\u0012\u0004\u0018\u00010c0aH\u0086@¢\u0006\u0002\u0010dJ\u0010\u0010e\u001a\u00020-2\u0006\u0010f\u001a\u00020gH\u0007J\u000e\u0010h\u001a\u00020-2\u0006\u00106\u001a\u00020\u0017J\u0016\u0010i\u001a\u00020-2\u0006\u00106\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u00107J\"\u0010j\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020_0,2\u0006\u00106\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u00107J(\u0010k\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170O\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u00107J\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\u0017022\u0006\u00106\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u00107J*\u0010m\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020\u00172\u0006\u0010n\u001a\u00020KH\u0096@¢\u0006\u0002\u0010oJ\"\u0010p\u001a\u00020H2\u0006\u0010/\u001a\u0002002\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0017H\u0087@¢\u0006\u0002\u0010qJ(\u0010r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0O\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u00107J$\u0010s\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010>\u0012\u0004\u0012\u00020.0,2\u0006\u00106\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u00107J,\u0010t\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,2\b\u0010u\u001a\u0004\u0018\u00010>2\u0006\u00106\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010vJ\u000e\u0010w\u001a\u00020-H\u0096@¢\u0006\u0002\u00105J\u0016\u0010x\u001a\u00020-2\u0006\u00106\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u00107J\u0010\u0010y\u001a\u00020\"2\u0006\u0010z\u001a\u00020\"H\u0002J\u0016\u0010{\u001a\u00020-2\u0006\u0010G\u001a\u00020HH\u0096@¢\u0006\u0002\u0010|J\u0016\u0010}\u001a\u00020-2\u0006\u00106\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u00107J\u001e\u0010~\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\u0006\u0010\u007f\u001a\u00020KH\u0096@¢\u0006\u0002\u0010oJ,\u0010\u0080\u0001\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\"2\u0007\u0010\u0082\u0001\u001a\u00020.H\u0096@¢\u0006\u0003\u0010\u0083\u0001J=\u0010\u0084\u0001\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\"2\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010.2\t\b\u0002\u0010\u0086\u0001\u001a\u00020KH\u0087@¢\u0006\u0003\u0010\u0087\u0001J:\u0010\u0088\u0001\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020_0,2\u0006\u00106\u001a\u00020\u00172\u0014\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020c0\u008a\u0001H\u0086@¢\u0006\u0003\u0010\u008b\u0001J$\u0010\u008c\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u008d\u0001\u0012\u0004\u0012\u00020_0,2\u0006\u00106\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u00107J\"\u0010\u008e\u0001\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0096@¢\u0006\u0003\u0010\u0091\u0001J,\u0010\u0092\u0001\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\b\u0010\u0093\u0001\u001a\u00030\u0090\u00012\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0096@¢\u0006\u0003\u0010\u0094\u0001J\u0017\u0010\u0095\u0001\u001a\u00020\u00182\u0006\u0010G\u001a\u00020HH\u0082@¢\u0006\u0002\u0010|J\u001a\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0006\u00106\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u00107J\u0017\u0010\u0098\u0001\u001a\u00020-2\u0006\u00106\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u00107J!\u0010\u0099\u0001\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\u0007\u0010\u0085\u0001\u001a\u00020.H\u0082@¢\u0006\u0003\u0010\u009a\u0001J\u0019\u0010\u009c\u0001\u001a\u00020\"2\u0006\u00106\u001a\u00020\u00172\u0006\u0010z\u001a\u00020\"H\u0002J\u0019\u0010\u009d\u0001\u001a\u00020#2\u0007\u0010\u009e\u0001\u001a\u00020\"H\u0082@¢\u0006\u0003\u0010\u009f\u0001J\u001e\u0010 \u0001\u001a\u00020-*\u00020\u00182\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0082@¢\u0006\u0003\u0010£\u0001J\u000b\u0010©\u0001\u001a\u0004\u0018\u00010\"H\u0016J\u0014\u0010ª\u0001\u001a\u00020-2\t\u0010«\u0001\u001a\u0004\u0018\u00010\"H\u0016J\t\u0010¬\u0001\u001a\u00020-H\u0016J\t\u0010\u00ad\u0001\u001a\u00020-H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001e0\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001cR\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000f\u0010\u009b\u0001\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010¤\u0001\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001¨\u0006¯\u0001"}, d2 = {"Lcom/box/android/data/jobs/JobService;", "Lcom/box/android/domain/services/IJobService;", "Lcom/box/android/data/jobs/IJobEventObserver;", "Lcom/box/android/domain/identity/IUserContextComponent;", "appContext", "Landroid/content/Context;", "jobsDataSource", "Lcom/box/android/data/datasource/jobs/JobsDataSource;", "jobFactory", "Lcom/box/android/data/jobs/JobFactory;", "gen204JobServiceHelper", "Ldagger/Lazy;", "Lcom/box/android/domain/metrics/Gen204JobServiceHelper;", "rumService", "Lcom/box/android/domain/services/RumService;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroid/content/Context;Lcom/box/android/data/datasource/jobs/JobsDataSource;Lcom/box/android/data/jobs/JobFactory;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lkotlinx/coroutines/CoroutineDispatcher;)V", "allJobInfos", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/box/android/domain/jobs/JobId;", "Lcom/box/android/domain/models/JobInfo;", "getAllJobInfos$annotations", "()V", "getAllJobInfos", "()Ljava/util/concurrent/ConcurrentHashMap;", "allJobs", "Lcom/box/android/data/jobs/Job;", "getAllJobs$annotations", "getAllJobs", "mutexMap", "", "Lkotlinx/coroutines/sync/Mutex;", "_jobEnqueuedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/box/android/domain/services/IJobService$JobEnqueuedEvent;", "jobEnqueuedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getJobEnqueuedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "enqueue", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "jobRequest", "Lcom/box/android/domain/jobs/JobRequest;", "dependingOn", "", "(Lcom/box/android/domain/jobs/JobRequest;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pauseAllRunningJobs", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", JobWorker.JOB_ID_PARAM, "(Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueChildJob", "parentID", "predecessors", "(Lcom/box/android/domain/jobs/JobRequest;Lcom/box/android/domain/jobs/JobId;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyParent", BoxRepresentation.FIELD_INFO, "", "(Lcom/box/android/domain/jobs/JobId;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryJob", "getJob", "getParentJob", "Lcom/box/android/data/jobs/ParentJob;", "childJobId", "getParentJobID", "getJobInfo", "jobEntity", "Lcom/box/android/data/persistence/jobs/JobEntity;", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/data/persistence/jobs/JobEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellableAutoUploadJob", "", "jobInfo", "(Lcom/box/android/domain/models/JobInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnqueuedAutoUploadJobs", "", "cancelEnqueuedAutoUploadJobs", "cancelMarkForOfflineJob", "remoteItemId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelAllMarkForOfflineJobs", "getJobInfos", "tags", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addWorkIdToJob", "workId", "Ljava/util/UUID;", "(Lcom/box/android/domain/jobs/JobId;Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runNextJob", "withTransaction", "Lcom/box/android/data/datasource/CacheError;", Analytics.Data.ACTION, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addJobTriggerWork", "earliestStartDate", "Ljava/util/Date;", "cancelWorker", "cleanupJobAndChildren", "removeFromDb", "getChildJobs", "getAllNestedChildJobs", "dequeue", "deleteDependents", "(Lcom/box/android/domain/jobs/JobId;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobEntity", "(Lcom/box/android/domain/jobs/JobRequest;Lcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTags", "getRunningInfo", "updateRunningInfo", "runningInfo", "([BLcom/box/android/domain/jobs/JobId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "jobSucceeded", "getValue", "tag", "jobSubmitted", "(Lcom/box/android/data/persistence/jobs/JobEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForChildren", "jobRunning", "updateStartTime", "jobFailed", "jobType", "error", "(Lcom/box/android/domain/jobs/JobId;Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logGen204Metrics", "domainError", "isAutoRetrying", "(Lcom/box/android/domain/jobs/JobId;Ljava/lang/String;Lcom/box/android/domain/models/DomainError;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLogData", "additionalInfos", "", "(Lcom/box/android/domain/jobs/JobId;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogData", "Landroidx/work/Data;", "networkTaskStarting", "estimatedWork", "", "(Lcom/box/android/domain/jobs/JobId;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "taskProgress", "currentProgress", "(Lcom/box/android/domain/jobs/JobId;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createJobInfo", "getJobAmplitudeLogger", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$JobEventPropertyBuilder;", "reportJobSuccessToAnalytics", "reportJobFailedToAnalytics", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutexMapMutex", "getMutexMapKey", "getMutex", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatus", "updatedStatus", "Lcom/box/android/domain/models/JobInfo$Status;", "(Lcom/box/android/domain/models/JobInfo;Lcom/box/android/domain/models/JobInfo$Status;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lastKnowContextId", "getLastKnowContextId", "()Ljava/lang/String;", "setLastKnowContextId", "(Ljava/lang/String;)V", "getContextId", "onCreate", "contextId", "onSoftDestroy", "onHardDestroy", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobService implements IJobService, IJobEventObserver, IUserContextComponent {
    public static final String JOB_TRIGGER_WORK = "triggerWork";
    public static final int MAX_AUTOMATIC_RETRIES = 8;
    public static final int MAX_NUM_OF_EXECUTING_JOBS_ALLOWED = 5;
    private final MutableSharedFlow<IJobService.JobEnqueuedEvent> _jobEnqueuedFlow;
    private final ConcurrentHashMap<JobId, JobInfo> allJobInfos;
    private final ConcurrentHashMap<JobId, Job> allJobs;
    private final Context appContext;
    private final CoroutineDispatcher dispatcher;
    private final Lazy<FeatureFlips> featureFlips;
    private final Lazy<Gen204JobServiceHelper> gen204JobServiceHelper;
    private final SharedFlow<IJobService.JobEnqueuedEvent> jobEnqueuedFlow;
    private final JobFactory jobFactory;
    private final JobsDataSource jobsDataSource;
    private String lastKnowContextId;
    private final ConcurrentHashMap<String, Mutex> mutexMap;
    private final Mutex mutexMapMutex;
    private final Lazy<RumService> rumService;

    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JobStatus.values().length];
            try {
                iArr[JobStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JobStatus.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JobStatus.ENQUEUED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[JobStatus.WAITING_FOR_CHILDREN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[JobStatus.CANCELLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[JobStatus.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[JobStatus.SUCCEEDED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$cancelAllMarkForOfflineJobs$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {307, 314}, m = "cancelAllMarkForOfflineJobs", n = {"$this$onSuccess$iv", "allJobInfos", "$this$forEach$iv", "element$iv", "parentJobInfo", "markForOfflineJobs", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$cancelAllMarkForOfflineJobs$2", "$i$f$forEach", "$i$a$-forEach-JobService$cancelAllMarkForOfflineJobs$2$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.cancelAllMarkForOfflineJobs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$cancelEnqueuedAutoUploadJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {287, 290, 291}, m = "cancelEnqueuedAutoUploadJobs", n = {"$this$onSuccess$iv", "jobInfos", "$this$forEach$iv", "element$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$cancelEnqueuedAutoUploadJobs$2", "$i$f$forEach", "$i$a$-forEach-JobService$cancelEnqueuedAutoUploadJobs$2$1", "$this$onSuccess$iv", "jobInfos", "$this$forEach$iv", "element$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$cancelEnqueuedAutoUploadJobs$2", "$i$f$forEach", "$i$a$-forEach-JobService$cancelEnqueuedAutoUploadJobs$2$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12611 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C12611(Continuation<? super C12611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.cancelEnqueuedAutoUploadJobs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$cancelMarkForOfflineJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {BoxCommonConstants.REQUEST_RETRY_SHARED_LINK, 301}, m = "cancelMarkForOfflineJob", n = {"remoteItemId", "remoteItemId", "$this$onSuccess$iv", "jobInfos", "$this$forEach$iv", "element$iv", "jobInfo", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$cancelMarkForOfflineJob$2", "$i$f$forEach", "$i$a$-forEach-JobService$cancelMarkForOfflineJob$2$2"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12621 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C12621(Continuation<? super C12621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.cancelMarkForOfflineJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$cleanup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {1, 1, 1, 1, 1}, l = {557, 558}, m = "cleanup", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-JobService$cleanup$3"}, s = {"L$0", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C12631 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C12631(Continuation<? super C12631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.cleanup(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$cleanupJobAndChildren$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6, 6}, l = {409, 409, 413, 416, 416, 421, 423}, m = "cleanupJobAndChildren", n = {JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, "allNestedChildren", "$this$forEach$iv", "element$iv", "childJobId", "$i$f$forEach", "$i$a$-forEach-JobService$cleanupJobAndChildren$2", JobWorker.JOB_ID_PARAM, "allNestedChildren", "$this$forEach$iv", "element$iv", "childJobId", "$i$f$forEach", "$i$a$-forEach-JobService$cleanupJobAndChildren$2", JobWorker.JOB_ID_PARAM, "allNestedChildren", JobWorker.JOB_ID_PARAM, "allNestedChildren", "$this$forEach$iv", "element$iv", "childJobId", "$i$f$forEach", "$i$a$-forEach-JobService$cleanupJobAndChildren$3"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C12641 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C12641(Continuation<? super C12641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.cleanupJobAndChildren(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$createJobInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0}, l = {TypedValues.TransitionType.TYPE_AUTO_TRANSITION}, m = "createJobInfo", n = {"jobEntity"}, s = {"L$0"}, v = 1)
    static final class C12651 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12651(Continuation<? super C12651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.createJobInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$dequeue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {474, 475, 475, 481}, m = "dequeue", n = {JobWorker.JOB_ID_PARAM, "deleteDependents", JobWorker.JOB_ID_PARAM, "jobAmplitudeLogger", "deleteDependents", JobWorker.JOB_ID_PARAM, "jobAmplitudeLogger", "deleteDependents", JobWorker.JOB_ID_PARAM, "jobAmplitudeLogger", "deleteDependents"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"}, v = 1)
    static final class C12661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C12661(Continuation<? super C12661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.dequeue(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$enqueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5}, l = {107, 108, 114, 118, 130, Token.TARGET}, m = "enqueue", n = {"jobRequest", "dependingOn", "jobRequest", "dependingOn", "jobEntity", "jobRequest", "dependingOn", "jobEntity", "$this$map$iv", "it", "$i$f$map", "$i$a$-map-JobService$enqueue$2", "jobRequest", "dependingOn", "jobEntity", "$this$map$iv", "it", "$i$f$map", "$i$a$-map-JobService$enqueue$2", "jobRequest", "dependingOn", "jobEntity", "$this$map$iv", "it", "$i$f$map", "$i$a$-map-JobService$enqueue$2", "jobRequest", "dependingOn", "jobEntity", "$this$map$iv", "it", "$i$f$map", "$i$a$-map-JobService$enqueue$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C12671 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12671(Continuation<? super C12671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.enqueue(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$enqueue$4, reason: invalid class name */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 1, 1, 1, 1}, l = {Token.SETCONSTVAR, Token.ARRAYCOMP}, m = "enqueue", n = {JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$enqueue$5"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass4 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.enqueue(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$enqueueChildJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {Token.METHOD, Token.GENEXPR, 168}, m = "enqueueChildJob", n = {"jobRequest", "parentID", "predecessors", "jobRequest", "parentID", "predecessors", "jobRequest", "parentID", "predecessors", "$this$map$iv", "it", "$i$f$map", "$i$a$-map-JobService$enqueueChildJob$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C12681 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12681(Continuation<? super C12681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.enqueueChildJob(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getAllJobInfos$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {327, 328}, m = "getAllJobInfos", n = {"$this$flatMap$iv", "jobEntities", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-JobService$getAllJobInfos$2", "$i$f$map", "$i$f$mapTo", "$i$a$-map-JobService$getAllJobInfos$2$jobInfos$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C12691 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C12691(Continuation<? super C12691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getAllJobInfos(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getAllNestedChildJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 0, 0}, l = {452}, m = "getAllNestedChildJobs", n = {JobWorker.JOB_ID_PARAM, "allChildren", "toProcess", "currentJobId"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C12701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C12701(Continuation<? super C12701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getAllNestedChildJobs(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getChildJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0}, l = {441}, m = "getChildJobs", n = {JobWorker.JOB_ID_PARAM}, s = {"L$0"}, v = 1)
    static final class C12711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12711(Continuation<? super C12711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getChildJobs(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getEnqueuedAutoUploadJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {280, 282}, m = "getEnqueuedAutoUploadJobs", n = {"$this$map$iv", "it", "$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "jobInfo", "$i$f$map", "$i$a$-map-JobService$getEnqueuedAutoUploadJobs$2", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-JobService$getEnqueuedAutoUploadJobs$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C12721 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C12721(Continuation<? super C12721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getEnqueuedAutoUploadJobs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {205, 866, BoxCommonConstants.REQUEST_OPTIONS}, m = "getJob", n = {JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, "$this$withLock_u24default$iv", "$i$f$withLock", JobWorker.JOB_ID_PARAM, "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$getJob$2"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C12731 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12731(Continuation<? super C12731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getJobAmplitudeLogger$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {744, 746, 753}, m = "getJobAmplitudeLogger", n = {JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, "it", "jobType", "$i$a$-let-JobService$getJobAmplitudeLogger$2", JobWorker.JOB_ID_PARAM, "it", "jobType", "tags", "jobEventBuilder", "$i$a$-let-JobService$getJobAmplitudeLogger$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class C12741 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C12741(Continuation<? super C12741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getJobAmplitudeLogger(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getJobEntity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 0, 0}, l = {527}, m = "getJobEntity", n = {"jobRequest", "parentID", "it", "$i$a$-let-JobService$getJobEntity$parentJob$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C12751 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12751(Continuation<? super C12751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getJobEntity(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getJobInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {259, 866, 265, 266, 267}, m = "getJobInfo", n = {JobWorker.JOB_ID_PARAM, "jobEntity", JobWorker.JOB_ID_PARAM, "jobEntity", "$this$withLock_u24default$iv", "$i$f$withLock", JobWorker.JOB_ID_PARAM, "jobEntity", "$this$withLock_u24default$iv", "jobInfo", "it", "$i$f$withLock", "$i$a$-withLock$default-JobService$getJobInfo$2", "$i$a$-let-JobService$getJobInfo$2$1", JobWorker.JOB_ID_PARAM, "jobEntity", "$this$withLock_u24default$iv", "jobInfo", "$i$f$withLock", "$i$a$-withLock$default-JobService$getJobInfo$2", JobWorker.JOB_ID_PARAM, "jobEntity", "$this$withLock_u24default$iv", "jobInfo", "$this$flatMap$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-JobService$getJobInfo$2", "$i$f$flatMap", "$i$a$-flatMap-JobService$getJobInfo$2$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C12761 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C12761(Continuation<? super C12761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getJobInfo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getJobInfos$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {BoxRequestsFile.DownloadThumbnail.SIZE_320, 321}, m = "getJobInfos", n = {"tags", "tags", "$this$flatMap$iv", "jobEntities", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-JobService$getJobInfos$2", "$i$f$map", "$i$f$mapTo", "$i$a$-map-JobService$getJobInfos$2$jobInfos$1"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C12771 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C12771(Continuation<? super C12771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getJobInfos(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getMutex$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 0}, l = {866}, m = "getMutex", n = {"key", "$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C12781 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12781(Continuation<? super C12781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getMutex(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getParentJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 1, 1, 1, 1}, l = {229, 231}, m = "getParentJob", n = {"childJobId", "childJobId", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-JobService$getParentJob$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C12791 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12791(Continuation<? super C12791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getParentJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getParentJobID$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0}, l = {241}, m = "getParentJobID", n = {JobWorker.JOB_ID_PARAM}, s = {"L$0"}, v = 1)
    static final class C12801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12801(Continuation<? super C12801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getParentJobID(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0}, l = {549}, m = "getRunningInfo", n = {JobWorker.JOB_ID_PARAM}, s = {"L$0"}, v = 1)
    static final class C12811 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12811(Continuation<? super C12811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getRunningInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$getTags$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0}, l = {545}, m = "getTags", n = {JobWorker.JOB_ID_PARAM}, s = {"L$0"}, v = 1)
    static final class C12821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12821(Continuation<? super C12821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.getTags(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$isCancellableAutoUploadJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0}, l = {275}, m = "isCancellableAutoUploadJob", n = {"jobInfo"}, s = {"L$0"}, v = 1)
    static final class C12831 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12831(Continuation<? super C12831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.isCancellableAutoUploadJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$jobFailed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18}, l = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 866, 616, 618, 623, 624, 634, 637, 637, 638, 640, 641, 646, 648, 648, 649, ProgressIndicatorKt.SecondLineHeadDelay, ProgressIndicatorKt.SecondLineHeadDelay, 651}, m = "jobFailed", n = {JobWorker.JOB_ID_PARAM, "jobType", "error", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "jobRetryCount", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", "it", "$i$a$-let-JobService$jobFailed$2$1", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "jobRetryCount", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", "it", "$i$a$-let-JobService$jobFailed$2$1", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "jobRetryCount", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", "it", "$i$a$-let-JobService$jobFailed$2$1", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "jobRetryCount", "$this$onSuccess$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", "it", "$i$a$-let-JobService$jobFailed$2$1", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$jobFailed$2$1$1", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "jobRetryCount", "$this$onSuccess$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", "it", "$i$a$-let-JobService$jobFailed$2$1", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$jobFailed$2$1$1", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2", JobWorker.JOB_ID_PARAM, "jobType", "error", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-JobService$jobFailed$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C12841 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C12841(Continuation<? super C12841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.jobFailed(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$jobRunning$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, l = {595, 595, 596, 598, 599, 600}, m = "jobRunning", n = {JobWorker.JOB_ID_PARAM, "updateStartTime", JobWorker.JOB_ID_PARAM, "updateStartTime", JobWorker.JOB_ID_PARAM, "updateStartTime", JobWorker.JOB_ID_PARAM, "updateStartTime", JobWorker.JOB_ID_PARAM, "updateStartTime", JobWorker.JOB_ID_PARAM, "updateStartTime"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0"}, v = 1)
    static final class C12851 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C12851(Continuation<? super C12851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.jobRunning(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$jobSubmitted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 2}, l = {581, 581, 582}, m = "jobSubmitted", n = {"jobEntity", "jobEntity", "jobEntity"}, s = {"L$0", "L$0", "L$0"}, v = 1)
    static final class C12861 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12861(Continuation<? super C12861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.jobSubmitted(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$jobSucceeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12}, l = {563, 564, 565, 566, 566, 567, 567, 568, 569, 570, 571, 573, 575}, m = "jobSucceeded", n = {JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, "job", JobWorker.JOB_ID_PARAM, "job", JobWorker.JOB_ID_PARAM, "job", JobWorker.JOB_ID_PARAM, "job", JobWorker.JOB_ID_PARAM, "job"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C12871 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12871(Continuation<? super C12871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.jobSucceeded(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$logGen204Metrics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {661, 662, 665, 667}, m = "logGen204Metrics", n = {JobWorker.JOB_ID_PARAM, "jobType", "domainError", "isAutoRetrying", JobWorker.JOB_ID_PARAM, "jobType", "domainError", "jobType", "isAutoRetrying", JobWorker.JOB_ID_PARAM, "jobType", "domainError", "jobType", "logData", "isAutoRetrying", JobWorker.JOB_ID_PARAM, "jobType", "domainError", "jobType", "logData", "isAutoRetrying"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 1)
    static final class C12881 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C12881(Continuation<? super C12881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.logGen204Metrics(null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$networkTaskStarting$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 1, 1, 2, 2}, l = {681, 682, 684}, m = "networkTaskStarting", n = {JobWorker.JOB_ID_PARAM, "estimatedWork", JobWorker.JOB_ID_PARAM, "estimatedWork", JobWorker.JOB_ID_PARAM, "estimatedWork"}, s = {"L$0", "D$0", "L$0", "D$0", "L$0", "D$0"}, v = 1)
    static final class C12891 extends ContinuationImpl {
        double D$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12891(Continuation<? super C12891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.networkTaskStarting(null, 0.0d, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$notifyParent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 1, 1}, l = {175, 175}, m = "notifyParent", n = {JobWorker.JOB_ID_PARAM, BoxRepresentation.FIELD_INFO, JobWorker.JOB_ID_PARAM, BoxRepresentation.FIELD_INFO}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C12901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12901(Continuation<? super C12901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.notifyParent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$pauseAllRunningJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {Token.SETELEM_OP, Token.DOTDOT, Token.DOTDOT, Token.COLONCOLON}, m = "pauseAllRunningJobs", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-JobService$pauseAllRunningJobs$2", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-JobService$pauseAllRunningJobs$2", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-JobService$pauseAllRunningJobs$2"}, s = {"L$0", "L$2", "L$3", "I$0", "I$1", "L$0", "L$2", "L$3", "I$0", "I$1", "L$0", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C12931 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C12931(Continuation<? super C12931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.pauseAllRunningJobs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$removeFromDb$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0}, l = {437}, m = "removeFromDb", n = {JobWorker.JOB_ID_PARAM}, s = {"L$0"}, v = 1)
    static final class C12941 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12941(Continuation<? super C12941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.removeFromDb(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$reportJobFailedToAnalytics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 1, 1, 1}, l = {766, 770}, m = "reportJobFailedToAnalytics", n = {JobWorker.JOB_ID_PARAM, "domainError", JobWorker.JOB_ID_PARAM, "domainError", "cannotBeRetried"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"}, v = 1)
    static final class C12951 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12951(Continuation<? super C12951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.reportJobFailedToAnalytics(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$reportJobSuccessToAnalytics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 1, 1}, l = {757, 758}, m = "reportJobSuccessToAnalytics", n = {JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, "$this$reportJobSuccessToAnalytics_u24lambda_u240", "$i$a$-apply-JobService$reportJobSuccessToAnalytics$2"}, s = {"L$0", "L$0", "L$2", "I$0"}, v = 1)
    static final class C12961 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C12961(Continuation<? super C12961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.reportJobSuccessToAnalytics(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$retryJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {179, 179, 180, 184, TsExtractor.TS_PACKET_SIZE, 195}, m = "retryJob", n = {JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$retryJob$2", JobWorker.JOB_ID_PARAM, "$this$onSuccess$iv", "it", "errorInfo", "domainError", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$retryJob$2", "$i$a$-let-JobService$retryJob$2$1", JobWorker.JOB_ID_PARAM, "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-JobService$retryJob$2"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C12971 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12971(Continuation<? super C12971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.retryJob(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$runNextJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {1, 1, 1, 1}, l = {371, 373}, m = "runNextJob", n = {"$this$onSuccess$iv", "$i$f$onSuccess", "it", "$i$a$-onSuccess-JobService$runNextJob$2"}, s = {"L$0", "I$0", "I$1", "I$2"}, v = 1)
    static final class C12981 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12981(Continuation<? super C12981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.runNextJob(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$taskProgress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {688, 690, 693, 693}, m = "taskProgress", n = {JobWorker.JOB_ID_PARAM, "currentProgress", "estimatedWork", JobWorker.JOB_ID_PARAM, "currentProgress", "estimatedWork", JobWorker.JOB_ID_PARAM, "currentProgress", "estimatedWork", JobWorker.JOB_ID_PARAM, "currentProgress", "estimatedWork"}, s = {"L$0", "D$0", "D$1", "L$0", "D$0", "D$1", "L$0", "D$0", "D$1", "L$0", "D$0", "D$1"}, v = 1)
    static final class C12991 extends ContinuationImpl {
        double D$0;
        double D$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12991(Continuation<? super C12991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.taskProgress(null, 0.0d, 0.0d, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$updateRunningInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 0}, l = {553}, m = "updateRunningInfo", n = {"runningInfo", JobWorker.JOB_ID_PARAM}, s = {"L$0", "L$1"}, v = 1)
    static final class C13001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13001(Continuation<? super C13001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.updateRunningInfo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$waitForChildren$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService", f = "JobService.kt", i = {0, 1, 2}, l = {590, 590, 591}, m = "waitForChildren", n = {JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM, JobWorker.JOB_ID_PARAM}, s = {"L$0", "L$0", "L$0"}, v = 1)
    static final class C13011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13011(Continuation<? super C13011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobService.this.waitForChildren(null, this);
        }
    }

    public static /* synthetic */ void getAllJobInfos$annotations() {
    }

    public static /* synthetic */ void getAllJobs$annotations() {
    }

    @Inject
    public JobService(Context appContext, JobsDataSource jobsDataSource, JobFactory jobFactory, Lazy<Gen204JobServiceHelper> gen204JobServiceHelper, Lazy<RumService> rumService, Lazy<FeatureFlips> featureFlips, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jobsDataSource, "jobsDataSource");
        Intrinsics.checkNotNullParameter(jobFactory, "jobFactory");
        Intrinsics.checkNotNullParameter(gen204JobServiceHelper, "gen204JobServiceHelper");
        Intrinsics.checkNotNullParameter(rumService, "rumService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.appContext = appContext;
        this.jobsDataSource = jobsDataSource;
        this.jobFactory = jobFactory;
        this.gen204JobServiceHelper = gen204JobServiceHelper;
        this.rumService = rumService;
        this.featureFlips = featureFlips;
        this.dispatcher = dispatcher;
        this.allJobInfos = new ConcurrentHashMap<>();
        this.allJobs = new ConcurrentHashMap<>();
        this.mutexMap = new ConcurrentHashMap<>();
        MutableSharedFlow<IJobService.JobEnqueuedEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this._jobEnqueuedFlow = mutableSharedFlowMutableSharedFlow$default;
        this.jobEnqueuedFlow = mutableSharedFlowMutableSharedFlow$default;
        this.mutexMapMutex = MutexKt.Mutex$default(false, 1, null);
    }

    public final ConcurrentHashMap<JobId, JobInfo> getAllJobInfos() {
        return this.allJobInfos;
    }

    public final ConcurrentHashMap<JobId, Job> getAllJobs() {
        return this.allJobs;
    }

    @Override // com.box.android.domain.services.IJobService
    public SharedFlow<IJobService.JobEnqueuedEvent> getJobEnqueuedFlow() {
        return this.jobEnqueuedFlow;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x006a A[PHI: r1 r2 r4 r5 r8 r9 r10 r11
      0x006a: PHI (r1v11 java.lang.Object) = (r1v10 java.lang.Object), (r1v1 java.lang.Object) binds: [B:33:0x0167, B:13:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r2v19 int) = (r2v17 int), (r2v21 int) binds: [B:33:0x0167, B:13:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r4v12 int) = (r4v10 int), (r4v15 int) binds: [B:33:0x0167, B:13:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r5v13 kotlin.Unit) = (r5v10 kotlin.Unit), (r5v16 kotlin.Unit) binds: [B:33:0x0167, B:13:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r8v8 com.box.android.domain.utils.result.Result) = (r8v5 com.box.android.domain.utils.result.Result), (r8v12 com.box.android.domain.utils.result.Result) binds: [B:33:0x0167, B:13:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r9v10 com.box.android.data.persistence.jobs.JobEntity) = (r9v7 com.box.android.data.persistence.jobs.JobEntity), (r9v14 com.box.android.data.persistence.jobs.JobEntity) binds: [B:33:0x0167, B:13:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r10v9 java.util.Set<com.box.android.domain.jobs.JobId>) = (r10v6 java.util.Set<com.box.android.domain.jobs.JobId>), (r10v12 java.util.Set<com.box.android.domain.jobs.JobId>) binds: [B:33:0x0167, B:13:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r11v6 com.box.android.domain.jobs.JobRequest) = (r11v3 com.box.android.domain.jobs.JobRequest), (r11v11 com.box.android.domain.jobs.JobRequest) binds: [B:33:0x0167, B:13:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:28:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:31:0x013d  */
    /* JADX WARN: Code duplicated, block: B:37:0x016f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0199  */
    /* JADX WARN: Code duplicated, block: B:44:0x01db  */
    /* JADX WARN: Code duplicated, block: B:48:0x020e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0216 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0217  */
    /* JADX WARN: Code duplicated, block: B:55:0x021b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0258  */
    /* JADX WARN: Code duplicated, block: B:59:0x025e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01d6, code lost:
    
        if (r1.run(r10, r3) == r6) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0200, code lost:
    
        if (runNextJob(r3) == r6) goto L46;
     */
    @Override // com.box.android.domain.services.IJobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object enqueue(com.box.android.domain.jobs.JobRequest r18, java.util.Set<com.box.android.domain.jobs.JobId> r19, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r20) {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.enqueue(com.box.android.domain.jobs.JobRequest, java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:35:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:38:0x0102  */
    /* JADX WARN: Code duplicated, block: B:41:0x0123 A[PHI: r2 r3 r4 r5 r12 r13 r14
      0x0123: PHI (r2v3 com.box.android.data.jobs.JobService$pauseAllRunningJobs$1) = 
      (r2v5 com.box.android.data.jobs.JobService$pauseAllRunningJobs$1)
      (r2v5 com.box.android.data.jobs.JobService$pauseAllRunningJobs$1)
      (r2v2 com.box.android.data.jobs.JobService$pauseAllRunningJobs$1)
     binds: [B:37:0x0100, B:39:0x0120, B:17:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r3v3 int) = (r3v5 int), (r3v5 int), (r3v12 int) binds: [B:37:0x0100, B:39:0x0120, B:17:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r4v0 int) = (r4v2 int), (r4v2 int), (r4v11 int) binds: [B:37:0x0100, B:39:0x0120, B:17:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r5v0 com.box.android.data.persistence.jobs.JobEntity) = 
      (r5v2 com.box.android.data.persistence.jobs.JobEntity)
      (r5v2 com.box.android.data.persistence.jobs.JobEntity)
      (r5v10 com.box.android.data.persistence.jobs.JobEntity)
     binds: [B:37:0x0100, B:39:0x0120, B:17:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r12v1 java.lang.Object) = (r12v3 java.lang.Object), (r12v3 java.lang.Object), (r12v9 java.lang.Object) binds: [B:37:0x0100, B:39:0x0120, B:17:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r13v1 java.util.Iterator) = (r13v3 java.util.Iterator), (r13v3 java.util.Iterator), (r13v10 java.util.Iterator) binds: [B:37:0x0100, B:39:0x0120, B:17:0x0053] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r14v1 java.lang.Iterable) = (r14v2 java.lang.Iterable), (r14v2 java.lang.Iterable), (r14v10 java.lang.Iterable) binds: [B:37:0x0100, B:39:0x0120, B:17:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x0156  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00c3 -> B:46:0x0162). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0156 -> B:45:0x0158). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object pauseAllRunningJobs(kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.pauseAllRunningJobs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
    
        if (runNextJob(r5) == r0) goto L24;
     */
    @Override // com.box.android.domain.services.IJobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object enqueue(com.box.android.domain.jobs.JobId r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.box.android.data.jobs.JobService.AnonymousClass4
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.data.jobs.JobService$enqueue$4 r0 = (com.box.android.data.jobs.JobService.AnonymousClass4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.data.jobs.JobService$enqueue$4 r0 = new com.box.android.data.jobs.JobService$enqueue$4
            r0.<init>(r11)
        L19:
            r5 = r0
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L4e
            if (r1 == r2) goto L46
            if (r1 != r8) goto L3e
            int r9 = r5.I$1
            int r9 = r5.I$0
            java.lang.Object r9 = r5.L$2
            kotlin.Unit r9 = (kotlin.Unit) r9
            java.lang.Object r9 = r5.L$1
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            java.lang.Object r9 = r5.L$0
            com.box.android.domain.jobs.JobId r9 = (com.box.android.domain.jobs.JobId) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L98
        L3e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L46:
            java.lang.Object r10 = r5.L$0
            com.box.android.domain.jobs.JobId r10 = (com.box.android.domain.jobs.JobId) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L69
        L4e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.box.android.data.datasource.jobs.JobsDataSource r1 = r9.jobsDataSource
            com.box.android.data.persistence.jobs.JobStatus r3 = com.box.android.data.persistence.jobs.JobStatus.ENQUEUED
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r5.L$0 = r11
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r10
            java.lang.Object r11 = com.box.android.data.datasource.jobs.JobsDataSource.updateStatusOfJob$default(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L68
            goto L93
        L68:
            r10 = r2
        L69:
            com.box.android.domain.utils.result.Result r11 = (com.box.android.domain.utils.result.Result) r11
            boolean r1 = r11 instanceof com.box.android.domain.utils.result.Result.Success
            if (r1 == 0) goto L94
            r1 = r11
            com.box.android.domain.utils.result.Result$Success r1 = (com.box.android.domain.utils.result.Result.Success) r1
            java.lang.Object r1 = r1.getValue()
            kotlin.Unit r1 = (kotlin.Unit) r1
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r5.L$0 = r10
            r5.L$1 = r11
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r5.L$2 = r10
            r10 = 0
            r5.I$0 = r10
            r5.I$1 = r10
            r5.label = r8
            java.lang.Object r9 = r9.runNextJob(r5)
            if (r9 != r0) goto L98
        L93:
            return r0
        L94:
            boolean r9 = r11 instanceof com.box.android.domain.utils.result.Result.Error
            if (r9 == 0) goto L9b
        L98:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L9b:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.enqueue(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00be  */
    /* JADX WARN: Code duplicated, block: B:32:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:36:0x0102 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x0103  */
    /* JADX WARN: Code duplicated, block: B:39:0x0107  */
    /* JADX WARN: Code duplicated, block: B:41:0x0143  */
    /* JADX WARN: Code duplicated, block: B:43:0x0149  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ec, code lost:
    
        if (runNextJob(r0) == r1) goto L30;
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object enqueueChildJob(com.box.android.domain.jobs.JobRequest r10, com.box.android.domain.jobs.JobId r11, java.util.Set<com.box.android.domain.jobs.JobId> r12, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r13) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.enqueueChildJob(com.box.android.domain.jobs.JobRequest, com.box.android.domain.jobs.JobId, java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        if (r5.receiveFromChild(r6, r7, r0) == r1) goto L23;
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object notifyParent(com.box.android.domain.jobs.JobId r6, byte[] r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.box.android.data.jobs.JobService.C12901
            if (r0 == 0) goto L14
            r0 = r8
            com.box.android.data.jobs.JobService$notifyParent$1 r0 = (com.box.android.data.jobs.JobService.C12901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.box.android.data.jobs.JobService$notifyParent$1 r0 = new com.box.android.data.jobs.JobService$notifyParent$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$1
            byte[] r5 = (byte[]) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.jobs.JobId r5 = (com.box.android.domain.jobs.JobId) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7a
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            java.lang.Object r5 = r0.L$1
            r7 = r5
            byte[] r7 = (byte[]) r7
            java.lang.Object r5 = r0.L$0
            r6 = r5
            com.box.android.domain.jobs.JobId r6 = (com.box.android.domain.jobs.JobId) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5b
        L4b:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r5.getParentJob(r6, r0)
            if (r8 != r1) goto L5b
            goto L79
        L5b:
            com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
            java.lang.Object r5 = com.box.android.domain.utils.result.ResultKt.getOrNull(r8)
            com.box.android.data.jobs.ParentJob r5 = (com.box.android.data.jobs.ParentJob) r5
            if (r5 == 0) goto L7d
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r5 = r5.receiveFromChild(r6, r7, r0)
            if (r5 != r1) goto L7a
        L79:
            return r1
        L7a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L7d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.notifyParent(com.box.android.domain.jobs.JobId, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d1 A[PHI: r2
      0x00d1: PHI (r2v9 com.box.android.domain.jobs.JobId) = 
      (r2v6 com.box.android.domain.jobs.JobId)
      (r2v6 com.box.android.domain.jobs.JobId)
      (r2v11 com.box.android.domain.jobs.JobId)
     binds: [B:31:0x00bf, B:33:0x00cd, B:24:0x0090] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00e0 A[PHI: r0 r2
      0x00e0: PHI (r0v11 java.lang.Object) = (r0v10 java.lang.Object), (r0v1 java.lang.Object) binds: [B:36:0x00dc, B:23:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x00e0: PHI (r2v12 com.box.android.domain.jobs.JobId) = (r2v9 com.box.android.domain.jobs.JobId), (r2v16 com.box.android.domain.jobs.JobId) binds: [B:36:0x00dc, B:23:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:45:0x011e  */
    /* JADX WARN: Code duplicated, block: B:48:0x012b A[Catch: Exception -> 0x0083, TryCatch #2 {Exception -> 0x0083, blocks: (B:19:0x007e, B:46:0x0121, B:48:0x012b, B:51:0x0133, B:53:0x0159), top: B:87:0x007e }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0130  */
    /* JADX WARN: Code duplicated, block: B:51:0x0133 A[Catch: Exception -> 0x0083, TryCatch #2 {Exception -> 0x0083, blocks: (B:19:0x007e, B:46:0x0121, B:48:0x012b, B:51:0x0133, B:53:0x0159), top: B:87:0x007e }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0159 A[Catch: Exception -> 0x0083, TRY_LEAVE, TryCatch #2 {Exception -> 0x0083, blocks: (B:19:0x007e, B:46:0x0121, B:48:0x012b, B:51:0x0133, B:53:0x0159), top: B:87:0x007e }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0181  */
    /* JADX WARN: Code duplicated, block: B:59:0x0186  */
    /* JADX WARN: Code duplicated, block: B:60:0x0189  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:70:0x01db  */
    /* JADX WARN: Code duplicated, block: B:75:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:79:0x0201  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0207  */
    /* JADX WARN: Code duplicated, block: B:83:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    @Override // com.box.android.domain.services.IJobService
    public Object retryJob(JobId jobId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C12971 c12971;
        JobId jobId2;
        JobInfo jobInfo;
        JobInfo.Status status;
        Result result;
        Unit unit;
        JobId jobId3;
        int i;
        JobId jobId4;
        int i2;
        int i3;
        JobEntity jobEntity;
        DomainError errorInfo;
        JobsDataSource jobsDataSource;
        Result result2;
        if (continuation instanceof C12971) {
            c12971 = (C12971) continuation;
            if ((c12971.label & Integer.MIN_VALUE) != 0) {
                c12971.label -= Integer.MIN_VALUE;
            } else {
                c12971 = new C12971(continuation);
            }
        } else {
            c12971 = new C12971(continuation);
        }
        C12971 c12972 = c12971;
        Object jobInfo$default = c12972.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = 0;
        switch (c12972.label) {
            case 0:
                ResultKt.throwOnFailure(jobInfo$default);
                c12972.L$0 = jobId;
                c12972.label = 1;
                jobInfo$default = getJobInfo$default(this, jobId, null, c12972, 2, null);
                if (jobInfo$default != coroutine_suspended) {
                    jobId2 = jobId;
                    jobInfo = (JobInfo) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                    if (jobInfo != null) {
                        status = JobInfo.Status.Waiting.INSTANCE;
                        c12972.L$0 = jobId2;
                        c12972.label = 2;
                        if (updateStatus(jobInfo, status, c12972) != coroutine_suspended) {
                            JobsDataSource jobsDataSource2 = this.jobsDataSource;
                            c12972.L$0 = jobId2;
                            c12972.label = 3;
                            jobInfo$default = jobsDataSource2.manualRetry(jobId2, c12972);
                            if (jobInfo$default != coroutine_suspended) {
                                result = (Result) jobInfo$default;
                                if (result instanceof Result.Success) {
                                    unit = (Unit) ((Result.Success) result).getValue();
                                    if (this.featureFlips.get().getResetJobRunningInfo().getEnabled()) {
                                        try {
                                            JobsDataSource jobsDataSource3 = this.jobsDataSource;
                                            c12972.L$0 = jobId2;
                                            c12972.L$1 = result;
                                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                            c12972.I$0 = 0;
                                            c12972.I$1 = 0;
                                            c12972.label = 4;
                                            jobInfo$default = jobsDataSource3.getJob(jobId2, c12972);
                                            if (jobInfo$default != coroutine_suspended) {
                                                jobId4 = jobId2;
                                                i = 0;
                                                i2 = 0;
                                                jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                                                if (jobEntity != null) {
                                                    errorInfo = jobEntity.getErrorInfo();
                                                } else {
                                                    errorInfo = null;
                                                }
                                                if (errorInfo != null) {
                                                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Resetting failed job with error " + errorInfo.getSimpleClassName() + " on manual retry");
                                                    if (errorInfo.getErrorType() == ErrorRecoveryType.UNRECOVERABLE) {
                                                        jobsDataSource = this.jobsDataSource;
                                                        c12972.L$0 = jobId4;
                                                        c12972.L$1 = result;
                                                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                        c12972.L$3 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                                        c12972.L$4 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                                        c12972.I$0 = i2;
                                                        c12972.I$1 = i;
                                                        c12972.I$2 = 0;
                                                        c12972.label = 5;
                                                        if (jobsDataSource.updateRunningInfo(jobId4, null, c12972) != coroutine_suspended) {
                                                            jobId3 = jobId4;
                                                            i3 = i;
                                                            jobId2 = jobId3;
                                                            i4 = i2;
                                                            c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                                            c12972.L$1 = result;
                                                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                            c12972.L$3 = null;
                                                            c12972.L$4 = null;
                                                            c12972.I$0 = i4;
                                                            c12972.I$1 = i3;
                                                            c12972.label = 6;
                                                            if (runNextJob(c12972) != coroutine_suspended) {
                                                                result2 = result;
                                                                result = result2;
                                                            }
                                                        }
                                                    } else {
                                                        i3 = i;
                                                        jobId2 = jobId4;
                                                        i4 = i2;
                                                        c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                                        c12972.L$1 = result;
                                                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                        c12972.L$3 = null;
                                                        c12972.L$4 = null;
                                                        c12972.I$0 = i4;
                                                        c12972.I$1 = i3;
                                                        c12972.label = 6;
                                                        if (runNextJob(c12972) != coroutine_suspended) {
                                                            result2 = result;
                                                            result = result2;
                                                        }
                                                    }
                                                } else {
                                                    i3 = i;
                                                    i4 = i2;
                                                    jobId2 = jobId4;
                                                    c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                                    c12972.L$1 = result;
                                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                    c12972.L$3 = null;
                                                    c12972.L$4 = null;
                                                    c12972.I$0 = i4;
                                                    c12972.I$1 = i3;
                                                    c12972.label = 6;
                                                    if (runNextJob(c12972) != coroutine_suspended) {
                                                        result2 = result;
                                                        result = result2;
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            jobId3 = jobId2;
                                            i = 0;
                                            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while resetting runningInfo " + jobId3 + " " + e.getMessage());
                                            i3 = i;
                                            jobId2 = jobId3;
                                        }
                                    } else {
                                        i3 = 0;
                                        c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                        c12972.L$1 = result;
                                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                        c12972.L$3 = null;
                                        c12972.L$4 = null;
                                        c12972.I$0 = i4;
                                        c12972.I$1 = i3;
                                        c12972.label = 6;
                                        if (runNextJob(c12972) != coroutine_suspended) {
                                            result2 = result;
                                            result = result2;
                                        }
                                    }
                                } else if (!(result instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                if (result instanceof Result.Success) {
                                    return result;
                                }
                                if (!(result instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                            }
                        }
                    } else {
                        JobsDataSource jobsDataSource4 = this.jobsDataSource;
                        c12972.L$0 = jobId2;
                        c12972.label = 3;
                        jobInfo$default = jobsDataSource4.manualRetry(jobId2, c12972);
                        if (jobInfo$default != coroutine_suspended) {
                            result = (Result) jobInfo$default;
                            if (result instanceof Result.Success) {
                                unit = (Unit) ((Result.Success) result).getValue();
                                if (this.featureFlips.get().getResetJobRunningInfo().getEnabled()) {
                                    JobsDataSource jobsDataSource5 = this.jobsDataSource;
                                    c12972.L$0 = jobId2;
                                    c12972.L$1 = result;
                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                    c12972.I$0 = 0;
                                    c12972.I$1 = 0;
                                    c12972.label = 4;
                                    jobInfo$default = jobsDataSource5.getJob(jobId2, c12972);
                                    if (jobInfo$default != coroutine_suspended) {
                                        jobId4 = jobId2;
                                        i = 0;
                                        i2 = 0;
                                        jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                                        if (jobEntity != null) {
                                            errorInfo = jobEntity.getErrorInfo();
                                        } else {
                                            errorInfo = null;
                                        }
                                        if (errorInfo != null) {
                                            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Resetting failed job with error " + errorInfo.getSimpleClassName() + " on manual retry");
                                            if (errorInfo.getErrorType() == ErrorRecoveryType.UNRECOVERABLE) {
                                                jobsDataSource = this.jobsDataSource;
                                                c12972.L$0 = jobId4;
                                                c12972.L$1 = result;
                                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                c12972.L$3 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                                c12972.L$4 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                                c12972.I$0 = i2;
                                                c12972.I$1 = i;
                                                c12972.I$2 = 0;
                                                c12972.label = 5;
                                                if (jobsDataSource.updateRunningInfo(jobId4, null, c12972) != coroutine_suspended) {
                                                    jobId3 = jobId4;
                                                    i3 = i;
                                                    jobId2 = jobId3;
                                                    i4 = i2;
                                                    c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                                    c12972.L$1 = result;
                                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                    c12972.L$3 = null;
                                                    c12972.L$4 = null;
                                                    c12972.I$0 = i4;
                                                    c12972.I$1 = i3;
                                                    c12972.label = 6;
                                                    if (runNextJob(c12972) != coroutine_suspended) {
                                                        result2 = result;
                                                        result = result2;
                                                    }
                                                }
                                            } else {
                                                i3 = i;
                                                jobId2 = jobId4;
                                                i4 = i2;
                                                c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                                c12972.L$1 = result;
                                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                c12972.L$3 = null;
                                                c12972.L$4 = null;
                                                c12972.I$0 = i4;
                                                c12972.I$1 = i3;
                                                c12972.label = 6;
                                                if (runNextJob(c12972) != coroutine_suspended) {
                                                    result2 = result;
                                                    result = result2;
                                                }
                                            }
                                        } else {
                                            i3 = i;
                                            i4 = i2;
                                            jobId2 = jobId4;
                                            c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                            c12972.L$1 = result;
                                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                            c12972.L$3 = null;
                                            c12972.L$4 = null;
                                            c12972.I$0 = i4;
                                            c12972.I$1 = i3;
                                            c12972.label = 6;
                                            if (runNextJob(c12972) != coroutine_suspended) {
                                                result2 = result;
                                                result = result2;
                                            }
                                        }
                                    }
                                } else {
                                    i3 = 0;
                                    c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                    c12972.L$1 = result;
                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                    c12972.L$3 = null;
                                    c12972.L$4 = null;
                                    c12972.I$0 = i4;
                                    c12972.I$1 = i3;
                                    c12972.label = 6;
                                    if (runNextJob(c12972) != coroutine_suspended) {
                                        result2 = result;
                                        result = result2;
                                    }
                                }
                            } else if (!(result instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (result instanceof Result.Success) {
                                return result;
                            }
                            if (!(result instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                jobId2 = (JobId) c12972.L$0;
                ResultKt.throwOnFailure(jobInfo$default);
                jobInfo = (JobInfo) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                if (jobInfo != null) {
                    status = JobInfo.Status.Waiting.INSTANCE;
                    c12972.L$0 = jobId2;
                    c12972.label = 2;
                    if (updateStatus(jobInfo, status, c12972) != coroutine_suspended) {
                        JobsDataSource jobsDataSource6 = this.jobsDataSource;
                        c12972.L$0 = jobId2;
                        c12972.label = 3;
                        jobInfo$default = jobsDataSource6.manualRetry(jobId2, c12972);
                        if (jobInfo$default != coroutine_suspended) {
                            result = (Result) jobInfo$default;
                            if (result instanceof Result.Success) {
                                unit = (Unit) ((Result.Success) result).getValue();
                                if (this.featureFlips.get().getResetJobRunningInfo().getEnabled()) {
                                    JobsDataSource jobsDataSource7 = this.jobsDataSource;
                                    c12972.L$0 = jobId2;
                                    c12972.L$1 = result;
                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                    c12972.I$0 = 0;
                                    c12972.I$1 = 0;
                                    c12972.label = 4;
                                    jobInfo$default = jobsDataSource7.getJob(jobId2, c12972);
                                    if (jobInfo$default != coroutine_suspended) {
                                        jobId4 = jobId2;
                                        i = 0;
                                        i2 = 0;
                                        jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                                        if (jobEntity != null) {
                                            errorInfo = jobEntity.getErrorInfo();
                                        } else {
                                            errorInfo = null;
                                        }
                                        if (errorInfo != null) {
                                            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Resetting failed job with error " + errorInfo.getSimpleClassName() + " on manual retry");
                                            if (errorInfo.getErrorType() == ErrorRecoveryType.UNRECOVERABLE) {
                                                jobsDataSource = this.jobsDataSource;
                                                c12972.L$0 = jobId4;
                                                c12972.L$1 = result;
                                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                c12972.L$3 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                                c12972.L$4 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                                c12972.I$0 = i2;
                                                c12972.I$1 = i;
                                                c12972.I$2 = 0;
                                                c12972.label = 5;
                                                if (jobsDataSource.updateRunningInfo(jobId4, null, c12972) != coroutine_suspended) {
                                                    jobId3 = jobId4;
                                                    i3 = i;
                                                    jobId2 = jobId3;
                                                    i4 = i2;
                                                    c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                                    c12972.L$1 = result;
                                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                    c12972.L$3 = null;
                                                    c12972.L$4 = null;
                                                    c12972.I$0 = i4;
                                                    c12972.I$1 = i3;
                                                    c12972.label = 6;
                                                    if (runNextJob(c12972) != coroutine_suspended) {
                                                        result2 = result;
                                                        result = result2;
                                                    }
                                                }
                                            } else {
                                                i3 = i;
                                                jobId2 = jobId4;
                                                i4 = i2;
                                                c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                                c12972.L$1 = result;
                                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                c12972.L$3 = null;
                                                c12972.L$4 = null;
                                                c12972.I$0 = i4;
                                                c12972.I$1 = i3;
                                                c12972.label = 6;
                                                if (runNextJob(c12972) != coroutine_suspended) {
                                                    result2 = result;
                                                    result = result2;
                                                }
                                            }
                                        } else {
                                            i3 = i;
                                            i4 = i2;
                                            jobId2 = jobId4;
                                            c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                            c12972.L$1 = result;
                                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                            c12972.L$3 = null;
                                            c12972.L$4 = null;
                                            c12972.I$0 = i4;
                                            c12972.I$1 = i3;
                                            c12972.label = 6;
                                            if (runNextJob(c12972) != coroutine_suspended) {
                                                result2 = result;
                                                result = result2;
                                            }
                                        }
                                    }
                                } else {
                                    i3 = 0;
                                    c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                    c12972.L$1 = result;
                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                    c12972.L$3 = null;
                                    c12972.L$4 = null;
                                    c12972.I$0 = i4;
                                    c12972.I$1 = i3;
                                    c12972.label = 6;
                                    if (runNextJob(c12972) != coroutine_suspended) {
                                        result2 = result;
                                        result = result2;
                                    }
                                }
                            } else if (!(result instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (result instanceof Result.Success) {
                                return result;
                            }
                            if (!(result instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                        }
                    }
                } else {
                    JobsDataSource jobsDataSource8 = this.jobsDataSource;
                    c12972.L$0 = jobId2;
                    c12972.label = 3;
                    jobInfo$default = jobsDataSource8.manualRetry(jobId2, c12972);
                    if (jobInfo$default != coroutine_suspended) {
                        result = (Result) jobInfo$default;
                        if (result instanceof Result.Success) {
                            unit = (Unit) ((Result.Success) result).getValue();
                            if (this.featureFlips.get().getResetJobRunningInfo().getEnabled()) {
                                JobsDataSource jobsDataSource9 = this.jobsDataSource;
                                c12972.L$0 = jobId2;
                                c12972.L$1 = result;
                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                c12972.I$0 = 0;
                                c12972.I$1 = 0;
                                c12972.label = 4;
                                jobInfo$default = jobsDataSource9.getJob(jobId2, c12972);
                                if (jobInfo$default != coroutine_suspended) {
                                    jobId4 = jobId2;
                                    i = 0;
                                    i2 = 0;
                                    jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                                    if (jobEntity != null) {
                                        errorInfo = jobEntity.getErrorInfo();
                                    } else {
                                        errorInfo = null;
                                    }
                                    if (errorInfo != null) {
                                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Resetting failed job with error " + errorInfo.getSimpleClassName() + " on manual retry");
                                        if (errorInfo.getErrorType() == ErrorRecoveryType.UNRECOVERABLE) {
                                            jobsDataSource = this.jobsDataSource;
                                            c12972.L$0 = jobId4;
                                            c12972.L$1 = result;
                                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                            c12972.L$3 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                            c12972.L$4 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                            c12972.I$0 = i2;
                                            c12972.I$1 = i;
                                            c12972.I$2 = 0;
                                            c12972.label = 5;
                                            if (jobsDataSource.updateRunningInfo(jobId4, null, c12972) != coroutine_suspended) {
                                                jobId3 = jobId4;
                                                i3 = i;
                                                jobId2 = jobId3;
                                                i4 = i2;
                                                c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                                c12972.L$1 = result;
                                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                                c12972.L$3 = null;
                                                c12972.L$4 = null;
                                                c12972.I$0 = i4;
                                                c12972.I$1 = i3;
                                                c12972.label = 6;
                                                if (runNextJob(c12972) != coroutine_suspended) {
                                                    result2 = result;
                                                    result = result2;
                                                }
                                            }
                                        } else {
                                            i3 = i;
                                            jobId2 = jobId4;
                                            i4 = i2;
                                            c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                            c12972.L$1 = result;
                                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                            c12972.L$3 = null;
                                            c12972.L$4 = null;
                                            c12972.I$0 = i4;
                                            c12972.I$1 = i3;
                                            c12972.label = 6;
                                            if (runNextJob(c12972) != coroutine_suspended) {
                                                result2 = result;
                                                result = result2;
                                            }
                                        }
                                    } else {
                                        i3 = i;
                                        i4 = i2;
                                        jobId2 = jobId4;
                                        c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                        c12972.L$1 = result;
                                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                        c12972.L$3 = null;
                                        c12972.L$4 = null;
                                        c12972.I$0 = i4;
                                        c12972.I$1 = i3;
                                        c12972.label = 6;
                                        if (runNextJob(c12972) != coroutine_suspended) {
                                            result2 = result;
                                            result = result2;
                                        }
                                    }
                                }
                            } else {
                                i3 = 0;
                                c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                c12972.L$1 = result;
                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                c12972.L$3 = null;
                                c12972.L$4 = null;
                                c12972.I$0 = i4;
                                c12972.I$1 = i3;
                                c12972.label = 6;
                                if (runNextJob(c12972) != coroutine_suspended) {
                                    result2 = result;
                                    result = result2;
                                }
                            }
                        } else if (!(result instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (result instanceof Result.Success) {
                            return result;
                        }
                        if (!(result instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                    }
                }
                return coroutine_suspended;
            case 2:
                jobId2 = (JobId) c12972.L$0;
                ResultKt.throwOnFailure(jobInfo$default);
                JobsDataSource jobsDataSource10 = this.jobsDataSource;
                c12972.L$0 = jobId2;
                c12972.label = 3;
                jobInfo$default = jobsDataSource10.manualRetry(jobId2, c12972);
                if (jobInfo$default != coroutine_suspended) {
                    result = (Result) jobInfo$default;
                    if (result instanceof Result.Success) {
                        unit = (Unit) ((Result.Success) result).getValue();
                        if (this.featureFlips.get().getResetJobRunningInfo().getEnabled()) {
                            JobsDataSource jobsDataSource11 = this.jobsDataSource;
                            c12972.L$0 = jobId2;
                            c12972.L$1 = result;
                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                            c12972.I$0 = 0;
                            c12972.I$1 = 0;
                            c12972.label = 4;
                            jobInfo$default = jobsDataSource11.getJob(jobId2, c12972);
                            if (jobInfo$default != coroutine_suspended) {
                                jobId4 = jobId2;
                                i = 0;
                                i2 = 0;
                                jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                                if (jobEntity != null) {
                                    errorInfo = jobEntity.getErrorInfo();
                                } else {
                                    errorInfo = null;
                                }
                                if (errorInfo != null) {
                                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Resetting failed job with error " + errorInfo.getSimpleClassName() + " on manual retry");
                                    if (errorInfo.getErrorType() == ErrorRecoveryType.UNRECOVERABLE) {
                                        jobsDataSource = this.jobsDataSource;
                                        c12972.L$0 = jobId4;
                                        c12972.L$1 = result;
                                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                        c12972.L$3 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                        c12972.L$4 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                        c12972.I$0 = i2;
                                        c12972.I$1 = i;
                                        c12972.I$2 = 0;
                                        c12972.label = 5;
                                        if (jobsDataSource.updateRunningInfo(jobId4, null, c12972) != coroutine_suspended) {
                                            jobId3 = jobId4;
                                            i3 = i;
                                            jobId2 = jobId3;
                                            i4 = i2;
                                            c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                            c12972.L$1 = result;
                                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                            c12972.L$3 = null;
                                            c12972.L$4 = null;
                                            c12972.I$0 = i4;
                                            c12972.I$1 = i3;
                                            c12972.label = 6;
                                            if (runNextJob(c12972) != coroutine_suspended) {
                                                result2 = result;
                                                result = result2;
                                            }
                                        }
                                    } else {
                                        i3 = i;
                                        jobId2 = jobId4;
                                        i4 = i2;
                                        c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                        c12972.L$1 = result;
                                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                        c12972.L$3 = null;
                                        c12972.L$4 = null;
                                        c12972.I$0 = i4;
                                        c12972.I$1 = i3;
                                        c12972.label = 6;
                                        if (runNextJob(c12972) != coroutine_suspended) {
                                            result2 = result;
                                            result = result2;
                                        }
                                    }
                                } else {
                                    i3 = i;
                                    i4 = i2;
                                    jobId2 = jobId4;
                                    c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                    c12972.L$1 = result;
                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                    c12972.L$3 = null;
                                    c12972.L$4 = null;
                                    c12972.I$0 = i4;
                                    c12972.I$1 = i3;
                                    c12972.label = 6;
                                    if (runNextJob(c12972) != coroutine_suspended) {
                                        result2 = result;
                                        result = result2;
                                    }
                                }
                            }
                        } else {
                            i3 = 0;
                            c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                            c12972.L$1 = result;
                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                            c12972.L$3 = null;
                            c12972.L$4 = null;
                            c12972.I$0 = i4;
                            c12972.I$1 = i3;
                            c12972.label = 6;
                            if (runNextJob(c12972) != coroutine_suspended) {
                                result2 = result;
                                result = result2;
                            }
                        }
                    } else if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (result instanceof Result.Success) {
                        return result;
                    }
                    if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                }
                return coroutine_suspended;
            case 3:
                jobId2 = (JobId) c12972.L$0;
                ResultKt.throwOnFailure(jobInfo$default);
                result = (Result) jobInfo$default;
                if (result instanceof Result.Success) {
                    unit = (Unit) ((Result.Success) result).getValue();
                    if (this.featureFlips.get().getResetJobRunningInfo().getEnabled()) {
                        JobsDataSource jobsDataSource12 = this.jobsDataSource;
                        c12972.L$0 = jobId2;
                        c12972.L$1 = result;
                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                        c12972.I$0 = 0;
                        c12972.I$1 = 0;
                        c12972.label = 4;
                        jobInfo$default = jobsDataSource12.getJob(jobId2, c12972);
                        if (jobInfo$default != coroutine_suspended) {
                            jobId4 = jobId2;
                            i = 0;
                            i2 = 0;
                            jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                            if (jobEntity != null) {
                                errorInfo = jobEntity.getErrorInfo();
                            } else {
                                errorInfo = null;
                            }
                            if (errorInfo != null) {
                                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Resetting failed job with error " + errorInfo.getSimpleClassName() + " on manual retry");
                                if (errorInfo.getErrorType() == ErrorRecoveryType.UNRECOVERABLE) {
                                    jobsDataSource = this.jobsDataSource;
                                    c12972.L$0 = jobId4;
                                    c12972.L$1 = result;
                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                    c12972.L$3 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                    c12972.L$4 = SpillingKt.nullOutSpilledVariable(errorInfo);
                                    c12972.I$0 = i2;
                                    c12972.I$1 = i;
                                    c12972.I$2 = 0;
                                    c12972.label = 5;
                                    if (jobsDataSource.updateRunningInfo(jobId4, null, c12972) != coroutine_suspended) {
                                        jobId3 = jobId4;
                                        i3 = i;
                                        jobId2 = jobId3;
                                        i4 = i2;
                                        c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                        c12972.L$1 = result;
                                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                        c12972.L$3 = null;
                                        c12972.L$4 = null;
                                        c12972.I$0 = i4;
                                        c12972.I$1 = i3;
                                        c12972.label = 6;
                                        if (runNextJob(c12972) != coroutine_suspended) {
                                            result2 = result;
                                            result = result2;
                                        }
                                    }
                                } else {
                                    i3 = i;
                                    jobId2 = jobId4;
                                    i4 = i2;
                                    c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                    c12972.L$1 = result;
                                    c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                    c12972.L$3 = null;
                                    c12972.L$4 = null;
                                    c12972.I$0 = i4;
                                    c12972.I$1 = i3;
                                    c12972.label = 6;
                                    if (runNextJob(c12972) != coroutine_suspended) {
                                        result2 = result;
                                        result = result2;
                                    }
                                }
                            } else {
                                i3 = i;
                                i4 = i2;
                                jobId2 = jobId4;
                                c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                c12972.L$1 = result;
                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                c12972.L$3 = null;
                                c12972.L$4 = null;
                                c12972.I$0 = i4;
                                c12972.I$1 = i3;
                                c12972.label = 6;
                                if (runNextJob(c12972) != coroutine_suspended) {
                                    result2 = result;
                                    result = result2;
                                }
                            }
                        }
                    } else {
                        i3 = 0;
                        c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                        c12972.L$1 = result;
                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                        c12972.L$3 = null;
                        c12972.L$4 = null;
                        c12972.I$0 = i4;
                        c12972.I$1 = i3;
                        c12972.label = 6;
                        if (runNextJob(c12972) != coroutine_suspended) {
                            result2 = result;
                            result = result2;
                        }
                    }
                    return coroutine_suspended;
                }
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (result instanceof Result.Success) {
                    return result;
                }
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
            case 4:
                i = c12972.I$1;
                i2 = c12972.I$0;
                unit = (Unit) c12972.L$2;
                result = (Result) c12972.L$1;
                jobId4 = (JobId) c12972.L$0;
                try {
                    ResultKt.throwOnFailure(jobInfo$default);
                    jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobInfo$default);
                    if (jobEntity != null) {
                        errorInfo = jobEntity.getErrorInfo();
                    } else {
                        errorInfo = null;
                    }
                    if (errorInfo != null) {
                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Resetting failed job with error " + errorInfo.getSimpleClassName() + " on manual retry");
                        if (errorInfo.getErrorType() == ErrorRecoveryType.UNRECOVERABLE) {
                            jobsDataSource = this.jobsDataSource;
                            c12972.L$0 = jobId4;
                            c12972.L$1 = result;
                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                            c12972.L$3 = SpillingKt.nullOutSpilledVariable(errorInfo);
                            c12972.L$4 = SpillingKt.nullOutSpilledVariable(errorInfo);
                            c12972.I$0 = i2;
                            c12972.I$1 = i;
                            c12972.I$2 = 0;
                            c12972.label = 5;
                            if (jobsDataSource.updateRunningInfo(jobId4, null, c12972) != coroutine_suspended) {
                                jobId3 = jobId4;
                                i3 = i;
                                jobId2 = jobId3;
                                i4 = i2;
                                c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                c12972.L$1 = result;
                                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                                c12972.L$3 = null;
                                c12972.L$4 = null;
                                c12972.I$0 = i4;
                                c12972.I$1 = i3;
                                c12972.label = 6;
                                if (runNextJob(c12972) != coroutine_suspended) {
                                    result2 = result;
                                    result = result2;
                                    if (result instanceof Result.Success) {
                                        return result;
                                    }
                                    if (!(result instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                                }
                            }
                        } else {
                            i3 = i;
                            jobId2 = jobId4;
                            i4 = i2;
                            c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                            c12972.L$1 = result;
                            c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                            c12972.L$3 = null;
                            c12972.L$4 = null;
                            c12972.I$0 = i4;
                            c12972.I$1 = i3;
                            c12972.label = 6;
                            if (runNextJob(c12972) != coroutine_suspended) {
                                result2 = result;
                                result = result2;
                                if (result instanceof Result.Success) {
                                    return result;
                                }
                                if (!(result instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                            }
                        }
                    } else {
                        i3 = i;
                        i4 = i2;
                        jobId2 = jobId4;
                        c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                        c12972.L$1 = result;
                        c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                        c12972.L$3 = null;
                        c12972.L$4 = null;
                        c12972.I$0 = i4;
                        c12972.I$1 = i3;
                        c12972.label = 6;
                        if (runNextJob(c12972) != coroutine_suspended) {
                            result2 = result;
                            result = result2;
                            if (result instanceof Result.Success) {
                                return result;
                            }
                            if (!(result instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    i4 = i2;
                    jobId3 = jobId4;
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while resetting runningInfo " + jobId3 + " " + e.getMessage());
                    i3 = i;
                    jobId2 = jobId3;
                }
                return coroutine_suspended;
            case 5:
                int i5 = c12972.I$2;
                i = c12972.I$1;
                i2 = c12972.I$0;
                unit = (Unit) c12972.L$2;
                result = (Result) c12972.L$1;
                jobId3 = (JobId) c12972.L$0;
                try {
                    ResultKt.throwOnFailure(jobInfo$default);
                    i3 = i;
                    jobId2 = jobId3;
                    i4 = i2;
                } catch (Exception e3) {
                    e = e3;
                    i4 = i2;
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while resetting runningInfo " + jobId3 + " " + e.getMessage());
                    i3 = i;
                    jobId2 = jobId3;
                }
                c12972.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                c12972.L$1 = result;
                c12972.L$2 = SpillingKt.nullOutSpilledVariable(unit);
                c12972.L$3 = null;
                c12972.L$4 = null;
                c12972.I$0 = i4;
                c12972.I$1 = i3;
                c12972.label = 6;
                if (runNextJob(c12972) != coroutine_suspended) {
                    result2 = result;
                    result = result2;
                    if (result instanceof Result.Success) {
                        return result;
                    }
                    if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                }
                return coroutine_suspended;
            case 6:
                int i6 = c12972.I$1;
                int i7 = c12972.I$0;
                result2 = (Result) c12972.L$1;
                ResultKt.throwOnFailure(jobInfo$default);
                result = result2;
                if (result instanceof Result.Success) {
                    return result;
                }
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0094 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x009e A[Catch: all -> 0x0041, TRY_ENTER, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b8 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00e1 A[Catch: all -> 0x0041, TRY_ENTER, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00e5 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00e9 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ed A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x011d A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0127 A[Catch: all -> 0x0041, TRY_ENTER, TryCatch #0 {all -> 0x0041, blocks: (B:14:0x003c, B:38:0x00b2, B:40:0x00b8, B:43:0x00e1, B:45:0x00e5, B:47:0x00e9, B:49:0x00ed, B:50:0x011d, B:51:0x0122, B:54:0x0127, B:55:0x012c, B:29:0x008c, B:31:0x0094, B:34:0x009e), top: B:58:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.box.android.data.jobs.JobFactory] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.box.android.domain.jobs.JobId, java.lang.Object, kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.box.android.data.datasource.jobs.JobsDataSource] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.box.android.data.jobs.JobService, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object getJob(JobId jobId, Continuation<? super Job> continuation) {
        C12731 c12731;
        ?? r10;
        ?? r6;
        Mutex mutex;
        int i;
        ?? r1;
        Result result;
        if (continuation instanceof C12731) {
            c12731 = (C12731) continuation;
            if ((c12731.label & Integer.MIN_VALUE) != 0) {
                c12731.label -= Integer.MIN_VALUE;
            } else {
                c12731 = new C12731(continuation);
            }
        } else {
            c12731 = new C12731(continuation);
        }
        Object mutex2 = c12731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c12731.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(mutex2);
                String mutexMapKey = getMutexMapKey(jobId, "Job");
                c12731.L$0 = jobId;
                c12731.label = 1;
                mutex2 = getMutex(mutexMapKey, c12731);
                if (mutex2 != coroutine_suspended) {
                }
                r10 = jobId;
                return coroutine_suspended;
            }
            if (i2 == 1) {
                JobId jobId2 = (JobId) c12731.L$0;
                ResultKt.throwOnFailure(mutex2);
                r10 = jobId2;
            } else {
                if (i2 == 2) {
                    int i3 = c12731.I$0;
                    Mutex mutex3 = (Mutex) c12731.L$1;
                    JobId jobId3 = (JobId) c12731.L$0;
                    ResultKt.throwOnFailure(mutex2);
                    i = i3;
                    mutex = mutex3;
                    r6 = jobId3;
                    if (this.allJobs.containsKey(r6)) {
                        Job job = this.allJobs.get(r6);
                        mutex.unlock(null);
                        return job;
                    }
                    ?? r3 = this.jobsDataSource;
                    c12731.L$0 = r6;
                    c12731.L$1 = mutex;
                    c12731.I$0 = i;
                    c12731.I$1 = 0;
                    c12731.label = 3;
                    mutex2 = r3.getJob(r6, c12731);
                    if (mutex2 != coroutine_suspended) {
                        r1 = r6;
                    }
                    r10 = jobId;
                    return coroutine_suspended;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = c12731.I$1;
                int i5 = c12731.I$0;
                mutex = (Mutex) c12731.L$1;
                JobId jobId4 = (JobId) c12731.L$0;
                ResultKt.throwOnFailure(mutex2);
                r1 = jobId4;
            }
            result = (Result) mutex2;
            if (result instanceof Result.Success) {
                JobEntity jobEntity = (JobEntity) ((Result.Success) result).getValue();
                Job jobCreateJob = this.jobFactory.createJob(jobEntity.getType(), r1, Data.INSTANCE.fromByteArray(jobEntity.getInputData()));
                this.allJobs.put(r1, jobCreateJob);
                mutex.unlock(null);
                return jobCreateJob;
            }
            if (result instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(result instanceof Result.Success)) {
                if (result instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while creating the job: " + r1 + ": " + ((CacheError) ((Result.Error) result).getValue()));
                new Result.Error(Unit.INSTANCE);
            }
            mutex.unlock(null);
            return null;
            r10 = jobId;
            Mutex mutex4 = (Mutex) mutex2;
            c12731.L$0 = r10;
            c12731.L$1 = mutex4;
            c12731.I$0 = 0;
            c12731.label = 2;
            if (mutex4.lock(null, c12731) != coroutine_suspended) {
                r6 = r10;
                mutex = mutex4;
                i = 0;
                if (this.allJobs.containsKey(r6)) {
                    Job job2 = this.allJobs.get(r6);
                    mutex.unlock(null);
                    return job2;
                }
                ?? r4 = this.jobsDataSource;
                c12731.L$0 = r6;
                c12731.L$1 = mutex;
                c12731.I$0 = i;
                c12731.I$1 = 0;
                c12731.label = 3;
                mutex2 = r4.getJob(r6, c12731);
                if (mutex2 != coroutine_suspended) {
                    r1 = r6;
                    result = (Result) mutex2;
                    if (result instanceof Result.Success) {
                        JobEntity jobEntity2 = (JobEntity) ((Result.Success) result).getValue();
                        Job jobCreateJob2 = this.jobFactory.createJob(jobEntity2.getType(), r1, Data.INSTANCE.fromByteArray(jobEntity2.getInputData()));
                        this.allJobs.put(r1, jobCreateJob2);
                        mutex.unlock(null);
                        return jobCreateJob2;
                    }
                    if (result instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (!(result instanceof Result.Success)) {
                        if (result instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error while creating the job: " + r1 + ": " + ((CacheError) ((Result.Error) result).getValue()));
                        new Result.Error(Unit.INSTANCE);
                    }
                    mutex.unlock(null);
                    return null;
                }
            }
            r10 = jobId;
            return coroutine_suspended;
        } catch (Throwable th) {
            jobId.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
    
        if (r8 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getParentJob(com.box.android.domain.jobs.JobId r7, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.data.jobs.ParentJob, ? extends com.box.android.domain.models.DomainError>> r8) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.getParentJob(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getParentJobID(JobId jobId, Continuation<? super Result<JobId, ? extends DomainError>> continuation) {
        C12801 c12801;
        if (continuation instanceof C12801) {
            c12801 = (C12801) continuation;
            if ((c12801.label & Integer.MIN_VALUE) != 0) {
                c12801.label -= Integer.MIN_VALUE;
            } else {
                c12801 = new C12801(continuation);
            }
        } else {
            c12801 = new C12801(continuation);
        }
        Object job = c12801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12801.label;
        if (i == 0) {
            ResultKt.throwOnFailure(job);
            JobsDataSource jobsDataSource = this.jobsDataSource;
            c12801.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
            c12801.label = 1;
            job = jobsDataSource.getJob(jobId, c12801);
            if (job == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(job);
        }
        Result error = (Result) job;
        if (error instanceof Result.Success) {
            JobEntity jobEntity = (JobEntity) ((Result.Success) error).getValue();
            if (jobEntity.getParentID() != null) {
                error = new Result.Success(jobEntity.getParentID());
            } else {
                error = new Result.Error(CacheError.NoResultFound.INSTANCE);
            }
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error).getValue(), null, 2, null));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object getJobInfo$default(JobService jobService, JobId jobId, JobEntity jobEntity, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            jobEntity = null;
        }
        return jobService.getJobInfo(jobId, jobEntity, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00fc A[Catch: all -> 0x01e1, TRY_LEAVE, TryCatch #0 {all -> 0x01e1, blocks: (B:55:0x0160, B:57:0x0166, B:63:0x01aa, B:77:0x01db, B:78:0x01e0, B:39:0x00f2, B:41:0x00fc, B:45:0x0107, B:51:0x0137), top: B:83:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0107 A[Catch: all -> 0x01e1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01e1, blocks: (B:55:0x0160, B:57:0x0166, B:63:0x01aa, B:77:0x01db, B:78:0x01e0, B:39:0x00f2, B:41:0x00fc, B:45:0x0107, B:51:0x0137), top: B:83:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x012d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0137 A[Catch: all -> 0x01e1, TRY_ENTER, TryCatch #0 {all -> 0x01e1, blocks: (B:55:0x0160, B:57:0x0166, B:63:0x01aa, B:77:0x01db, B:78:0x01e0, B:39:0x00f2, B:41:0x00fc, B:45:0x0107, B:51:0x0137), top: B:83:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x015b  */
    /* JADX WARN: Code duplicated, block: B:54:0x015c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0166 A[Catch: all -> 0x01e1, TRY_LEAVE, TryCatch #0 {all -> 0x01e1, blocks: (B:55:0x0160, B:57:0x0166, B:63:0x01aa, B:77:0x01db, B:78:0x01e0, B:39:0x00f2, B:41:0x00fc, B:45:0x0107, B:51:0x0137), top: B:83:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x01aa A[Catch: all -> 0x01e1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01e1, blocks: (B:55:0x0160, B:57:0x0166, B:63:0x01aa, B:77:0x01db, B:78:0x01e0, B:39:0x00f2, B:41:0x00fc, B:45:0x0107, B:51:0x0137), top: B:83:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:68:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x01b5 A[Catch: all -> 0x00a1, TryCatch #1 {all -> 0x00a1, blocks: (B:16:0x0054, B:61:0x01a1, B:66:0x01af, B:69:0x01b5, B:71:0x01b9, B:75:0x01d5, B:76:0x01da, B:26:0x009c, B:49:0x012e), top: B:84:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01b9 A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #1 {all -> 0x00a1, blocks: (B:16:0x0054, B:61:0x01a1, B:66:0x01af, B:69:0x01b5, B:71:0x01b9, B:75:0x01d5, B:76:0x01da, B:26:0x009c, B:49:0x012e), top: B:84:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01d5 A[Catch: all -> 0x00a1, TRY_ENTER, TryCatch #1 {all -> 0x00a1, blocks: (B:16:0x0054, B:61:0x01a1, B:66:0x01af, B:69:0x01b5, B:71:0x01b9, B:75:0x01d5, B:76:0x01da, B:26:0x009c, B:49:0x012e), top: B:84:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01db A[Catch: all -> 0x01e1, TRY_ENTER, TryCatch #0 {all -> 0x01e1, blocks: (B:55:0x0160, B:57:0x0166, B:63:0x01aa, B:77:0x01db, B:78:0x01e0, B:39:0x00f2, B:41:0x00fc, B:45:0x0107, B:51:0x0137), top: B:83:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.box.android.data.jobs.JobService] */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v22 */
    public final Object getJobInfo(JobId jobId, JobEntity jobEntity, Continuation<? super Result<JobInfo, ? extends DomainError>> continuation) throws Throwable {
        C12761 c12761;
        JobId jobId2;
        JobEntity jobEntity2;
        Mutex mutex;
        int i;
        JobInfo jobInfo;
        Object job;
        JobEntity jobEntity3;
        JobInfo jobInfo2;
        int i2;
        int i3;
        Mutex mutex2;
        Result.Success success;
        Result.Success success2;
        if (continuation instanceof C12761) {
            c12761 = (C12761) continuation;
            if ((c12761.label & Integer.MIN_VALUE) != 0) {
                c12761.label -= Integer.MIN_VALUE;
            } else {
                c12761 = new C12761(continuation);
            }
        } else {
            c12761 = new C12761(continuation);
        }
        Object mutex3 = c12761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c12761.label;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(mutex3);
                String mutexMapKey = getMutexMapKey(jobId, "JobInfo");
                c12761.L$0 = jobId;
                c12761.L$1 = jobEntity;
                c12761.label = 1;
                mutex3 = getMutex(mutexMapKey, c12761);
                if (mutex3 != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i4 != 1) {
                if (i4 == 2) {
                    i = c12761.I$0;
                    mutex = (Mutex) c12761.L$2;
                    jobEntity2 = (JobEntity) c12761.L$1;
                    jobId2 = (JobId) c12761.L$0;
                    ResultKt.throwOnFailure(mutex3);
                    try {
                        jobInfo = this.allJobInfos.get(jobId2);
                        if (jobInfo != null) {
                            Result.Success success3 = new Result.Success(jobInfo);
                            mutex.unlock(null);
                            return success3;
                        }
                        if (jobEntity2 != null) {
                            c12761.L$0 = jobId2;
                            c12761.L$1 = SpillingKt.nullOutSpilledVariable(jobEntity2);
                            c12761.L$2 = mutex;
                            c12761.L$3 = SpillingKt.nullOutSpilledVariable(jobInfo);
                            c12761.L$4 = SpillingKt.nullOutSpilledVariable(jobEntity2);
                            c12761.I$0 = i;
                            c12761.I$1 = 0;
                            c12761.I$2 = 0;
                            c12761.label = 3;
                            mutex3 = createJobInfo(jobEntity2, c12761);
                            if (mutex3 != coroutine_suspended) {
                                mutex2 = mutex;
                                success = new Result.Success(mutex3);
                                mutex2.unlock(null);
                                return success;
                            }
                        } else {
                            JobsDataSource jobsDataSource = this.jobsDataSource;
                            c12761.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                            c12761.L$1 = SpillingKt.nullOutSpilledVariable(jobEntity2);
                            c12761.L$2 = mutex;
                            c12761.L$3 = SpillingKt.nullOutSpilledVariable(jobInfo);
                            c12761.L$4 = null;
                            c12761.I$0 = i;
                            c12761.I$1 = 0;
                            c12761.label = 4;
                            job = jobsDataSource.getJob(jobId2, c12761);
                            if (job == coroutine_suspended) {
                                jobEntity3 = jobEntity2;
                                jobInfo2 = jobInfo;
                                i2 = i;
                                i3 = 0;
                                success2 = (Result) job;
                                if (success2 instanceof Result.Success) {
                                    JobEntity jobEntity4 = (JobEntity) ((Result.Success) success2).getValue();
                                    c12761.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                                    c12761.L$1 = SpillingKt.nullOutSpilledVariable(jobEntity3);
                                    c12761.L$2 = mutex;
                                    c12761.L$3 = SpillingKt.nullOutSpilledVariable(jobInfo2);
                                    c12761.L$4 = SpillingKt.nullOutSpilledVariable(success2);
                                    c12761.L$5 = SpillingKt.nullOutSpilledVariable(jobEntity4);
                                    c12761.I$0 = i2;
                                    c12761.I$1 = i3;
                                    c12761.I$2 = 0;
                                    c12761.I$3 = 0;
                                    c12761.label = 5;
                                    mutex3 = createJobInfo(jobEntity4, c12761);
                                    if (mutex3 != coroutine_suspended) {
                                        mutex2 = mutex;
                                        success2 = new Result.Success(mutex3);
                                    }
                                } else {
                                    if (!(success2 instanceof Result.Error)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    mutex2 = mutex;
                                }
                                if (success2 instanceof Result.Success) {
                                    success = success2;
                                } else if (success2 instanceof Result.Error) {
                                    success = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success2).getValue(), null, 2, null));
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                                mutex2.unlock(null);
                                return success;
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th) {
                        th = th;
                        this = mutex;
                        this.unlock(null);
                        throw th;
                    }
                }
                if (i4 == 3) {
                    int i5 = c12761.I$2;
                    int i6 = c12761.I$1;
                    int i7 = c12761.I$0;
                    mutex2 = (Mutex) c12761.L$2;
                    ResultKt.throwOnFailure(mutex3);
                    success = new Result.Success(mutex3);
                    mutex2.unlock(null);
                    return success;
                }
                if (i4 == 4) {
                    i3 = c12761.I$1;
                    int i8 = c12761.I$0;
                    jobInfo2 = (JobInfo) c12761.L$3;
                    Mutex mutex4 = (Mutex) c12761.L$2;
                    jobEntity3 = (JobEntity) c12761.L$1;
                    jobId2 = (JobId) c12761.L$0;
                    try {
                        ResultKt.throwOnFailure(mutex3);
                        i2 = i8;
                        mutex = mutex4;
                        job = mutex3;
                        success2 = (Result) job;
                        if (success2 instanceof Result.Success) {
                            JobEntity jobEntity5 = (JobEntity) ((Result.Success) success2).getValue();
                            c12761.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                            c12761.L$1 = SpillingKt.nullOutSpilledVariable(jobEntity3);
                            c12761.L$2 = mutex;
                            c12761.L$3 = SpillingKt.nullOutSpilledVariable(jobInfo2);
                            c12761.L$4 = SpillingKt.nullOutSpilledVariable(success2);
                            c12761.L$5 = SpillingKt.nullOutSpilledVariable(jobEntity5);
                            c12761.I$0 = i2;
                            c12761.I$1 = i3;
                            c12761.I$2 = 0;
                            c12761.I$3 = 0;
                            c12761.label = 5;
                            mutex3 = createJobInfo(jobEntity5, c12761);
                            if (mutex3 != coroutine_suspended) {
                                mutex2 = mutex;
                            }
                            return coroutine_suspended;
                        }
                        if (!(success2 instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        mutex2 = mutex;
                        if (success2 instanceof Result.Success) {
                            success = success2;
                        } else if (success2 instanceof Result.Error) {
                            success = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success2).getValue(), null, 2, null));
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        mutex2.unlock(null);
                        return success;
                    } catch (Throwable th2) {
                        th = th2;
                        this = mutex4;
                        this.unlock(null);
                        throw th;
                    }
                }
                if (i4 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i9 = c12761.I$3;
                int i10 = c12761.I$2;
                int i11 = c12761.I$1;
                int i12 = c12761.I$0;
                mutex2 = (Mutex) c12761.L$2;
                ResultKt.throwOnFailure(mutex3);
                success2 = new Result.Success(mutex3);
                if (success2 instanceof Result.Success) {
                    success = success2;
                } else if (success2 instanceof Result.Error) {
                    success = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success2).getValue(), null, 2, null));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                mutex2.unlock(null);
                return success;
            }
            jobEntity = (JobEntity) c12761.L$1;
            jobId = (JobId) c12761.L$0;
            ResultKt.throwOnFailure(mutex3);
            Mutex mutex5 = (Mutex) mutex3;
            c12761.L$0 = jobId;
            c12761.L$1 = jobEntity;
            c12761.L$2 = mutex5;
            c12761.I$0 = 0;
            c12761.label = 2;
            if (mutex5.lock(null, c12761) != coroutine_suspended) {
                jobId2 = jobId;
                jobEntity2 = jobEntity;
                mutex = mutex5;
                i = 0;
                jobInfo = this.allJobInfos.get(jobId2);
                if (jobInfo != null) {
                    Result.Success success4 = new Result.Success(jobInfo);
                    mutex.unlock(null);
                    return success4;
                }
                if (jobEntity2 != null) {
                    c12761.L$0 = jobId2;
                    c12761.L$1 = SpillingKt.nullOutSpilledVariable(jobEntity2);
                    c12761.L$2 = mutex;
                    c12761.L$3 = SpillingKt.nullOutSpilledVariable(jobInfo);
                    c12761.L$4 = SpillingKt.nullOutSpilledVariable(jobEntity2);
                    c12761.I$0 = i;
                    c12761.I$1 = 0;
                    c12761.I$2 = 0;
                    c12761.label = 3;
                    mutex3 = createJobInfo(jobEntity2, c12761);
                    if (mutex3 != coroutine_suspended) {
                        mutex2 = mutex;
                        success = new Result.Success(mutex3);
                        mutex2.unlock(null);
                        return success;
                    }
                } else {
                    JobsDataSource jobsDataSource2 = this.jobsDataSource;
                    c12761.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                    c12761.L$1 = SpillingKt.nullOutSpilledVariable(jobEntity2);
                    c12761.L$2 = mutex;
                    c12761.L$3 = SpillingKt.nullOutSpilledVariable(jobInfo);
                    c12761.L$4 = null;
                    c12761.I$0 = i;
                    c12761.I$1 = 0;
                    c12761.label = 4;
                    job = jobsDataSource2.getJob(jobId2, c12761);
                    if (job == coroutine_suspended) {
                        jobEntity3 = jobEntity2;
                        jobInfo2 = jobInfo;
                        i2 = i;
                        i3 = 0;
                        success2 = (Result) job;
                        if (success2 instanceof Result.Success) {
                            JobEntity jobEntity6 = (JobEntity) ((Result.Success) success2).getValue();
                            c12761.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                            c12761.L$1 = SpillingKt.nullOutSpilledVariable(jobEntity3);
                            c12761.L$2 = mutex;
                            c12761.L$3 = SpillingKt.nullOutSpilledVariable(jobInfo2);
                            c12761.L$4 = SpillingKt.nullOutSpilledVariable(success2);
                            c12761.L$5 = SpillingKt.nullOutSpilledVariable(jobEntity6);
                            c12761.I$0 = i2;
                            c12761.I$1 = i3;
                            c12761.I$2 = 0;
                            c12761.I$3 = 0;
                            c12761.label = 5;
                            mutex3 = createJobInfo(jobEntity6, c12761);
                            if (mutex3 != coroutine_suspended) {
                                mutex2 = mutex;
                                success2 = new Result.Success(mutex3);
                            }
                        } else {
                            if (!(success2 instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            mutex2 = mutex;
                        }
                        if (success2 instanceof Result.Success) {
                            success = success2;
                        } else if (success2 instanceof Result.Error) {
                            success = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success2).getValue(), null, 2, null));
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        mutex2.unlock(null);
                        return success;
                    }
                }
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isCancellableAutoUploadJob(JobInfo jobInfo, Continuation<? super Boolean> continuation) {
        C12831 c12831;
        if (continuation instanceof C12831) {
            c12831 = (C12831) continuation;
            if ((c12831.label & Integer.MIN_VALUE) != 0) {
                c12831.label -= Integer.MIN_VALUE;
            } else {
                c12831 = new C12831(continuation);
            }
        } else {
            c12831 = new C12831(continuation);
        }
        Object objFirstOrNull = c12831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12831.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            Flow<JobInfo.Status> status = jobInfo.getStatus();
            c12831.L$0 = jobInfo;
            c12831.label = 1;
            objFirstOrNull = FlowKt.firstOrNull(status, c12831);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jobInfo = (JobInfo) c12831.L$0;
            ResultKt.throwOnFailure(objFirstOrNull);
        }
        if (!Intrinsics.areEqual(objFirstOrNull, JobInfo.Status.Waiting.INSTANCE) && !Intrinsics.areEqual(jobInfo.getJobType(), JobType.AUTO_UPLOAD)) {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:31:0x0113  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0092, code lost:
    
        if (r1 == r3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0102, code lost:
    
        if (r1 == r3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0104, code lost:
    
        return r3;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0102 -> B:27:0x0105). Please report as a decompilation issue!!! */
    @Override // com.box.android.domain.services.IJobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getEnqueuedAutoUploadJobs(kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends java.util.List<com.box.android.domain.models.JobInfo>, ? extends com.box.android.domain.models.DomainError>> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.getEnqueuedAutoUploadJobs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:32:0x0104  */
    /* JADX WARN: Code duplicated, block: B:35:0x0136  */
    /* JADX WARN: Code duplicated, block: B:37:0x013e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0136 -> B:36:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x013e -> B:38:0x0143). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.services.IJobService
    public java.lang.Object cancelEnqueuedAutoUploadJobs(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.cancelEnqueuedAutoUploadJobs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00df  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008b, code lost:
    
        if (r1 == r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x011c, code lost:
    
        if (dequeue(r6, true, r2) == r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x011e, code lost:
    
        return r3;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x011c -> B:33:0x011f). Please report as a decompilation issue!!! */
    @Override // com.box.android.domain.services.IJobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object cancelMarkForOfflineJob(com.box.android.domain.models.ItemId.Remote r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.cancelMarkForOfflineJob(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:35:0x011d A[LOOP:0: B:30:0x00cd->B:35:0x011d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (r1 == r3) goto L34;
     */
    @Override // com.box.android.domain.services.IJobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object cancelAllMarkForOfflineJobs(kotlin.coroutines.Continuation<? super kotlin.Unit> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.cancelAllMarkForOfflineJobs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:27:0x0111  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0111 -> B:28:0x0114). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.services.IJobService
    public java.lang.Object getJobInfos(java.util.List<java.lang.String> r18, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends java.util.List<com.box.android.domain.models.JobInfo>, ? extends com.box.android.domain.models.DomainError>> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.getJobInfos(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00f8 -> B:28:0x00f9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.services.IJobService
    public java.lang.Object getAllJobInfos(kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends java.util.List<com.box.android.domain.models.JobInfo>, ? extends com.box.android.domain.models.DomainError>> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.getAllJobInfos(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object addWorkIdToJob(JobId jobId, UUID uuid, Continuation<? super Unit> continuation) {
        JobsDataSource jobsDataSource = this.jobsDataSource;
        String string = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objInsertJobIdToWorkIdRelation = jobsDataSource.insertJobIdToWorkIdRelation(new JobIdToWorkIdRelation(jobId, string), continuation);
        return objInsertJobIdToWorkIdRelation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInsertJobIdToWorkIdRelation : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object runNextJob(Continuation<? super Unit> continuation) {
        C12981 c12981;
        Result result;
        Result result2;
        if (continuation instanceof C12981) {
            c12981 = (C12981) continuation;
            if ((c12981.label & Integer.MIN_VALUE) != 0) {
                c12981.label -= Integer.MIN_VALUE;
            } else {
                c12981 = new C12981(continuation);
            }
        } else {
            c12981 = new C12981(continuation);
        }
        Object numberOfExecutingJobs = c12981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12981.label;
        if (i == 0) {
            ResultKt.throwOnFailure(numberOfExecutingJobs);
            JobsDataSource jobsDataSource = this.jobsDataSource;
            c12981.label = 1;
            numberOfExecutingJobs = jobsDataSource.getNumberOfExecutingJobs(c12981);
            if (numberOfExecutingJobs != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(numberOfExecutingJobs);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12981.I$2;
            int i3 = c12981.I$1;
            int i4 = c12981.I$0;
            result2 = (Result) c12981.L$0;
            ResultKt.throwOnFailure(numberOfExecutingJobs);
        }
        result = result2;
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "error while running next job due to error fetching number of running jobs: " + ((CacheError) ((Result.Error) result).getValue()));
        }
        return Unit.INSTANCE;
        result = (Result) numberOfExecutingJobs;
        if (result instanceof Result.Success) {
            int iIntValue = ((Number) ((Result.Success) result).getValue()).intValue();
            if (iIntValue < 5) {
                c12981.L$0 = result;
                c12981.I$0 = 0;
                c12981.I$1 = iIntValue;
                c12981.I$2 = 0;
                c12981.label = 2;
                if (runNextJob$doRunNextJob(this, c12981) != coroutine_suspended) {
                    result2 = result;
                    result = result2;
                }
                return coroutine_suspended;
            }
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "maximum jobs allowed limit reached");
        } else if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "error while running next job due to error fetching number of running jobs: " + ((CacheError) ((Result.Error) result).getValue()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:54:0x0199  */
    /* JADX WARN: Code duplicated, block: B:56:0x019d  */
    /* JADX WARN: Code duplicated, block: B:57:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b2, code lost:
    
        if (r13 == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010d, code lost:
    
        if (r4.run(r2, r0) == r1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0183, code lost:
    
        if (r12.jobFailed(r5, r7, r8, r0) == r1) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object runNextJob$doRunNextJob(com.box.android.data.jobs.JobService r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.runNextJob$doRunNextJob(com.box.android.data.jobs.JobService, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object withTransaction(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        return this.jobsDataSource.withTransaction(function1, continuation);
    }

    public final void addJobTriggerWork(Date earliestStartDate) {
        Intrinsics.checkNotNullParameter(earliestStartDate, "earliestStartDate");
        WorkManager.INSTANCE.getInstance(this.appContext).enqueueUniqueWork(JOB_TRIGGER_WORK, ExistingWorkPolicy.REPLACE, new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) JobTriggerWorker.class).setInitialDelay(earliestStartDate.getTime() - new Date().getTime(), TimeUnit.MILLISECONDS).build());
    }

    public final void cancelWorker(JobId jobId) {
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        WorkManager.INSTANCE.getInstance(this.appContext).cancelUniqueWork(jobId.getIdentifier());
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ed A[PHI: r2
      0x00ed: PHI (r2v11 com.box.android.domain.jobs.JobId) = 
      (r2v8 com.box.android.domain.jobs.JobId)
      (r2v8 com.box.android.domain.jobs.JobId)
      (r2v13 com.box.android.domain.jobs.JobId)
     binds: [B:24:0x00da, B:26:0x00e9, B:17:0x00a9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x0111  */
    /* JADX WARN: Code duplicated, block: B:37:0x013f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0153  */
    /* JADX WARN: Code duplicated, block: B:43:0x017a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x017a -> B:44:0x017e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0186 -> B:45:0x0184). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object cleanupJobAndChildren(com.box.android.domain.jobs.JobId r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.cleanupJobAndChildren(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object removeFromDb(JobId jobId, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C12941 c12941;
        if (continuation instanceof C12941) {
            c12941 = (C12941) continuation;
            if ((c12941.label & Integer.MIN_VALUE) != 0) {
                c12941.label -= Integer.MIN_VALUE;
            } else {
                c12941 = new C12941(continuation);
            }
        } else {
            c12941 = new C12941(continuation);
        }
        Object objDeleteJob = c12941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12941.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteJob);
            JobsDataSource jobsDataSource = this.jobsDataSource;
            c12941.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
            c12941.label = 1;
            objDeleteJob = jobsDataSource.deleteJob(jobId, c12941);
            if (objDeleteJob == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objDeleteJob);
        }
        Result result = (Result) objDeleteJob;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        BoxLogUtils.e(ExtensionsKt.getTAG(this), "error deleting job while removing from db: " + ((CacheError) ((Result.Error) result).getValue()));
        return result;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getChildJobs(JobId jobId, Continuation<? super Result<? extends List<JobId>, ? extends DomainError>> continuation) {
        C12711 c12711;
        if (continuation instanceof C12711) {
            c12711 = (C12711) continuation;
            if ((c12711.label & Integer.MIN_VALUE) != 0) {
                c12711.label -= Integer.MIN_VALUE;
            } else {
                c12711 = new C12711(continuation);
            }
        } else {
            c12711 = new C12711(continuation);
        }
        Object childJobs = c12711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(childJobs);
            JobsDataSource jobsDataSource = this.jobsDataSource;
            c12711.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
            c12711.label = 1;
            childJobs = jobsDataSource.getChildJobs(jobId, c12711);
            if (childJobs == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(childJobs);
        }
        Result result = (Result) childJobs;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0062  */
    /* JADX WARN: Code duplicated, block: B:19:0x0080 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0081  */
    /* JADX WARN: Code duplicated, block: B:23:0x008e  */
    /* JADX WARN: Code duplicated, block: B:27:0x009e  */
    /* JADX WARN: Code duplicated, block: B:33:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0081 -> B:21:0x0084). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getAllNestedChildJobs(com.box.android.domain.jobs.JobId r10, kotlin.coroutines.Continuation<? super java.util.Set<com.box.android.domain.jobs.JobId>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.box.android.data.jobs.JobService.C12701
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.data.jobs.JobService$getAllNestedChildJobs$1 r0 = (com.box.android.data.jobs.JobService.C12701) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.data.jobs.JobService$getAllNestedChildJobs$1 r0 = new com.box.android.data.jobs.JobService$getAllNestedChildJobs$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 != r4) goto L3b
            java.lang.Object r10 = r0.L$3
            com.box.android.domain.jobs.JobId r10 = (com.box.android.domain.jobs.JobId) r10
            java.lang.Object r10 = r0.L$2
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r2 = r0.L$1
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.jobs.JobId r5 = (com.box.android.domain.jobs.JobId) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L84
        L3b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L43:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.LinkedHashSet r11 = new java.util.LinkedHashSet
            r11.<init>()
            java.util.Set r11 = (java.util.Set) r11
            com.box.android.domain.jobs.JobId[] r2 = new com.box.android.domain.jobs.JobId[r4]
            r2[r3] = r10
            java.util.List r2 = kotlin.collections.CollectionsKt.mutableListOf(r2)
            r8 = r11
            r11 = r10
            r10 = r2
            r2 = r8
        L59:
            r5 = r10
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto Lb0
            java.lang.Object r5 = r10.remove(r3)
            com.box.android.domain.jobs.JobId r5 = (com.box.android.domain.jobs.JobId) r5
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$3 = r6
            r0.label = r4
            java.lang.Object r5 = r9.getChildJobs(r5, r0)
            if (r5 != r1) goto L81
            return r1
        L81:
            r8 = r5
            r5 = r11
            r11 = r8
        L84:
            com.box.android.domain.utils.result.Result r11 = (com.box.android.domain.utils.result.Result) r11
            java.lang.Object r11 = com.box.android.domain.utils.result.ResultKt.getOrNull(r11)
            java.util.List r11 = (java.util.List) r11
            if (r11 != 0) goto L92
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
        L92:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L98:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto Lae
            java.lang.Object r6 = r11.next()
            com.box.android.domain.jobs.JobId r6 = (com.box.android.domain.jobs.JobId) r6
            boolean r7 = r2.add(r6)
            if (r7 == 0) goto L98
            r10.add(r6)
            goto L98
        Lae:
            r11 = r5
            goto L59
        Lb0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.getAllNestedChildJobs(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 3841. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.box.android.domain.services.IJobService
    public java.lang.Object dequeue(com.box.android.domain.jobs.JobId r12, boolean r13, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r14) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.dequeue(com.box.android.domain.jobs.JobId, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$dequeue$2, reason: invalid class name */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService$dequeue$2", f = "JobService.kt", i = {1, 1, 2, 2, 3, 3}, l = {483, 490, 498, 506}, m = "invokeSuspend", n = {"toProcess", "currJobId", "toProcess", "currJobId", "toProcess", "currJobId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $deleteDependents;
        final /* synthetic */ JobId $jobId;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(JobId jobId, boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$jobId = jobId;
            this.$deleteDependents = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return JobService.this.new AnonymousClass2(this.$jobId, this.$deleteDependents, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x006e  */
        /* JADX WARN: Code duplicated, block: B:23:0x008e  */
        /* JADX WARN: Code duplicated, block: B:26:0x009b  */
        /* JADX WARN: Code duplicated, block: B:28:0x009f  */
        /* JADX WARN: Code duplicated, block: B:46:0x0103 A[PHI: r1 r7
          0x0103: PHI (r1v3 com.box.android.domain.jobs.JobId) = (r1v5 com.box.android.domain.jobs.JobId), (r1v6 com.box.android.domain.jobs.JobId) binds: [B:37:0x00d3, B:27:0x009d] A[DONT_GENERATE, DONT_INLINE]
          0x0103: PHI (r7v2 java.util.LinkedList) = (r7v3 java.util.LinkedList), (r7v4 java.util.LinkedList) binds: [B:37:0x00d3, B:27:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:49:0x011c  */
        /* JADX WARN: Code duplicated, block: B:52:0x0123  */
        /* JADX WARN: Code duplicated, block: B:54:0x0127  */
        /* JADX WARN: Code duplicated, block: B:56:0x013c  */
        /* JADX WARN: Code duplicated, block: B:58:0x0142  */
        /* JADX WARN: Code duplicated, block: B:59:0x0145  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x011c -> B:50:0x011d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 354
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ Object getJobEntity$default(JobService jobService, JobRequest jobRequest, JobId jobId, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            jobId = null;
        }
        return jobService.getJobEntity(jobRequest, jobId, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009b  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object getJobEntity(JobRequest jobRequest, JobId jobId, Continuation<? super JobEntity> continuation) {
        C12751 c12751;
        JobId jobId2;
        JobRequest jobRequest2;
        JobEntity jobEntity;
        JobId jobId3;
        JobId jobId4;
        String sortKey;
        if (continuation instanceof C12751) {
            c12751 = (C12751) continuation;
            if ((c12751.label & Integer.MIN_VALUE) != 0) {
                c12751.label -= Integer.MIN_VALUE;
            } else {
                c12751 = new C12751(continuation);
            }
        } else {
            c12751 = new C12751(continuation);
        }
        Object obj = c12751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (jobId != null) {
                JobsDataSource jobsDataSource = this.jobsDataSource;
                c12751.L$0 = jobRequest;
                c12751.L$1 = jobId;
                c12751.L$2 = SpillingKt.nullOutSpilledVariable(jobId);
                c12751.I$0 = 0;
                c12751.label = 1;
                Object job = jobsDataSource.getJob(jobId, c12751);
                if (job == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = job;
                jobId3 = jobId;
                jobRequest2 = jobRequest;
            } else {
                jobId2 = jobId;
                jobRequest2 = jobRequest;
                jobEntity = null;
            }
            JobId jobId5 = jobRequest2.getJobId();
            String jobType = jobRequest2.getJobType();
            byte[] byteArray = jobRequest2.getInputData().toByteArray();
            JobStatus jobStatus = JobStatus.ENQUEUED;
            Date earliestJobStartTime = jobRequest2.getEarliestJobStartTime();
            if (jobEntity != null || (jobId4 = jobEntity.getRootID()) == null) {
                jobId4 = jobRequest2.getJobId();
            }
            JobId jobId6 = jobId4;
            if (jobEntity != null || (sortKey = jobEntity.getSortKey()) == null) {
                sortKey = "";
            }
            return new JobEntity(jobId5, jobType, byteArray, jobStatus, null, null, earliestJobStartTime, 0, 0, null, null, jobId2, jobId6, sortKey + new Date().getTime() + "_" + jobRequest2.getJobId(), Data.EMPTY.toByteArray(), 1968, null);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c12751.I$0;
        jobId3 = (JobId) c12751.L$1;
        jobRequest2 = (JobRequest) c12751.L$0;
        ResultKt.throwOnFailure(obj);
        jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
        jobId2 = jobId3;
        JobId jobId7 = jobRequest2.getJobId();
        String jobType2 = jobRequest2.getJobType();
        byte[] byteArray2 = jobRequest2.getInputData().toByteArray();
        JobStatus jobStatus2 = JobStatus.ENQUEUED;
        Date earliestJobStartTime2 = jobRequest2.getEarliestJobStartTime();
        if (jobEntity != null) {
            jobId4 = jobRequest2.getJobId();
        } else {
            jobId4 = jobRequest2.getJobId();
        }
        JobId jobId8 = jobId4;
        if (jobEntity != null) {
            sortKey = "";
        } else {
            sortKey = "";
        }
        return new JobEntity(jobId7, jobType2, byteArray2, jobStatus2, null, null, earliestJobStartTime2, 0, 0, null, null, jobId2, jobId8, sortKey + new Date().getTime() + "_" + jobRequest2.getJobId(), Data.EMPTY.toByteArray(), 1968, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getTags(JobId jobId, Continuation<? super Result<? extends List<String>, ? extends DomainError>> continuation) {
        C12821 c12821;
        if (continuation instanceof C12821) {
            c12821 = (C12821) continuation;
            if ((c12821.label & Integer.MIN_VALUE) != 0) {
                c12821.label -= Integer.MIN_VALUE;
            } else {
                c12821 = new C12821(continuation);
            }
        } else {
            c12821 = new C12821(continuation);
        }
        Object tags = c12821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(tags);
            JobsDataSource jobsDataSource = this.jobsDataSource;
            c12821.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
            c12821.label = 1;
            tags = jobsDataSource.getTags(jobId, c12821);
            if (tags == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(tags);
        }
        Result result = (Result) tags;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRunningInfo(JobId jobId, Continuation<? super Result<byte[], ? extends DomainError>> continuation) {
        C12811 c12811;
        if (continuation instanceof C12811) {
            c12811 = (C12811) continuation;
            if ((c12811.label & Integer.MIN_VALUE) != 0) {
                c12811.label -= Integer.MIN_VALUE;
            } else {
                c12811 = new C12811(continuation);
            }
        } else {
            c12811 = new C12811(continuation);
        }
        Object runningInfo = c12811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12811.label;
        if (i == 0) {
            ResultKt.throwOnFailure(runningInfo);
            JobsDataSource jobsDataSource = this.jobsDataSource;
            c12811.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
            c12811.label = 1;
            runningInfo = jobsDataSource.getRunningInfo(jobId, c12811);
            if (runningInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(runningInfo);
        }
        Result result = (Result) runningInfo;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateRunningInfo(byte[] bArr, JobId jobId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C13001 c13001;
        if (continuation instanceof C13001) {
            c13001 = (C13001) continuation;
            if ((c13001.label & Integer.MIN_VALUE) != 0) {
                c13001.label -= Integer.MIN_VALUE;
            } else {
                c13001 = new C13001(continuation);
            }
        } else {
            c13001 = new C13001(continuation);
        }
        Object objUpdateRunningInfo = c13001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13001.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateRunningInfo);
            JobsDataSource jobsDataSource = this.jobsDataSource;
            c13001.L$0 = SpillingKt.nullOutSpilledVariable(bArr);
            c13001.L$1 = SpillingKt.nullOutSpilledVariable(jobId);
            c13001.label = 1;
            objUpdateRunningInfo = jobsDataSource.updateRunningInfo(jobId, bArr, c13001);
            if (objUpdateRunningInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateRunningInfo);
        }
        Result result = (Result) objUpdateRunningInfo;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009b  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:? A[LOOP:0: B:28:0x0095->B:38:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        if (r11 == r1) goto L32;
     */
    @Override // com.box.android.domain.services.IJobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object cleanup(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.cleanup(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:18:0x007c A[PHI: r5 r11 r12 r13
      0x007c: PHI (r5v15 com.box.android.data.jobs.JobService$jobSucceeded$1) = 
      (r5v13 com.box.android.data.jobs.JobService$jobSucceeded$1)
      (r5v16 com.box.android.data.jobs.JobService$jobSucceeded$1)
     binds: [B:54:0x0160, B:17:0x0074] A[DONT_GENERATE, DONT_INLINE]
      0x007c: PHI (r11v8 'this' com.box.android.data.jobs.JobService) = 
      (r11v7 'this' com.box.android.data.jobs.JobService)
      (r11v0 'this' com.box.android.data.jobs.JobService A[IMMUTABLE_TYPE, THIS])
     binds: [B:54:0x0160, B:17:0x0074] A[DONT_GENERATE, DONT_INLINE]
      0x007c: PHI (r12v23 com.box.android.domain.jobs.JobId) = (r12v20 com.box.android.domain.jobs.JobId), (r12v27 com.box.android.domain.jobs.JobId) binds: [B:54:0x0160, B:17:0x0074] A[DONT_GENERATE, DONT_INLINE]
      0x007c: PHI (r13v22 java.lang.Object) = (r13v21 java.lang.Object), (r13v1 java.lang.Object) binds: [B:54:0x0160, B:17:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x00b9 A[PHI: r12
      0x00b9: PHI (r12v4 com.box.android.domain.jobs.JobId) = (r12v1 com.box.android.domain.jobs.JobId), (r12v7 com.box.android.domain.jobs.JobId) binds: [B:31:0x00e7, B:24:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x0102 A[PHI: r1 r2 r5
      0x0102: PHI (r1v3 com.box.android.data.jobs.JobService) = (r1v2 com.box.android.data.jobs.JobService), (r1v4 com.box.android.data.jobs.JobService) binds: [B:34:0x00fe, B:23:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0102: PHI (r2v2 com.box.android.domain.jobs.JobId) = (r2v1 com.box.android.domain.jobs.JobId), (r2v3 com.box.android.domain.jobs.JobId) binds: [B:34:0x00fe, B:23:0x00a7] A[DONT_GENERATE, DONT_INLINE]
      0x0102: PHI (r5v3 com.box.android.data.jobs.JobService$jobSucceeded$1) = (r5v2 com.box.android.data.jobs.JobService$jobSucceeded$1), (r5v6 com.box.android.data.jobs.JobService$jobSucceeded$1) binds: [B:34:0x00fe, B:23:0x00a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x0116  */
    /* JADX WARN: Code duplicated, block: B:42:0x0121  */
    /* JADX WARN: Code duplicated, block: B:45:0x0132 A[PHI: r5 r11 r12
      0x0132: PHI (r5v9 com.box.android.data.jobs.JobService$jobSucceeded$1) = 
      (r5v7 com.box.android.data.jobs.JobService$jobSucceeded$1)
      (r5v7 com.box.android.data.jobs.JobService$jobSucceeded$1)
      (r5v10 com.box.android.data.jobs.JobService$jobSucceeded$1)
     binds: [B:41:0x011f, B:43:0x012e, B:21:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r11v5 'this' com.box.android.data.jobs.JobService) = 
      (r11v4 'this' com.box.android.data.jobs.JobService)
      (r11v4 'this' com.box.android.data.jobs.JobService)
      (r11v0 'this' com.box.android.data.jobs.JobService A[IMMUTABLE_TYPE, THIS])
     binds: [B:41:0x011f, B:43:0x012e, B:21:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x0132: PHI (r12v14 com.box.android.domain.jobs.JobId) = 
      (r12v11 com.box.android.domain.jobs.JobId)
      (r12v11 com.box.android.domain.jobs.JobId)
      (r12v16 com.box.android.domain.jobs.JobId)
     binds: [B:41:0x011f, B:43:0x012e, B:21:0x0093] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x013f A[PHI: r5 r11 r12 r13
      0x013f: PHI (r5v11 com.box.android.data.jobs.JobService$jobSucceeded$1) = (r5v9 com.box.android.data.jobs.JobService$jobSucceeded$1), (r5v12 com.box.android.data.jobs.JobService$jobSucceeded$1) binds: [B:46:0x013b, B:20:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x013f: PHI (r11v6 'this' com.box.android.data.jobs.JobService) = 
      (r11v5 'this' com.box.android.data.jobs.JobService)
      (r11v0 'this' com.box.android.data.jobs.JobService A[IMMUTABLE_TYPE, THIS])
     binds: [B:46:0x013b, B:20:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x013f: PHI (r12v17 com.box.android.domain.jobs.JobId) = (r12v14 com.box.android.domain.jobs.JobId), (r12v19 com.box.android.domain.jobs.JobId) binds: [B:46:0x013b, B:20:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x013f: PHI (r13v15 java.lang.Object) = (r13v14 java.lang.Object), (r13v1 java.lang.Object) binds: [B:46:0x013b, B:20:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x0149  */
    /* JADX WARN: Code duplicated, block: B:53:0x0156 A[PHI: r5 r11 r12
      0x0156: PHI (r5v13 com.box.android.data.jobs.JobService$jobSucceeded$1) = 
      (r5v11 com.box.android.data.jobs.JobService$jobSucceeded$1)
      (r5v11 com.box.android.data.jobs.JobService$jobSucceeded$1)
      (r5v14 com.box.android.data.jobs.JobService$jobSucceeded$1)
     binds: [B:49:0x0147, B:51:0x0152, B:19:0x007f] A[DONT_GENERATE, DONT_INLINE]
      0x0156: PHI (r11v7 'this' com.box.android.data.jobs.JobService) = 
      (r11v6 'this' com.box.android.data.jobs.JobService)
      (r11v6 'this' com.box.android.data.jobs.JobService)
      (r11v0 'this' com.box.android.data.jobs.JobService A[IMMUTABLE_TYPE, THIS])
     binds: [B:49:0x0147, B:51:0x0152, B:19:0x007f] A[DONT_GENERATE, DONT_INLINE]
      0x0156: PHI (r12v20 com.box.android.domain.jobs.JobId) = 
      (r12v17 com.box.android.domain.jobs.JobId)
      (r12v17 com.box.android.domain.jobs.JobId)
      (r12v22 com.box.android.domain.jobs.JobId)
     binds: [B:49:0x0147, B:51:0x0152, B:19:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x0169  */
    /* JADX WARN: Code duplicated, block: B:61:0x0179 A[DONT_INVERT, PHI: r1 r5 r11 r12
      0x0179: PHI (r1v9 com.box.android.domain.jobs.JobId) = 
      (r1v8 com.box.android.domain.jobs.JobId)
      (r1v8 com.box.android.domain.jobs.JobId)
      (r1v11 com.box.android.domain.jobs.JobId)
     binds: [B:57:0x0167, B:59:0x0175, B:16:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r5v17 com.box.android.data.jobs.JobService$jobSucceeded$1) = 
      (r5v15 com.box.android.data.jobs.JobService$jobSucceeded$1)
      (r5v15 com.box.android.data.jobs.JobService$jobSucceeded$1)
      (r5v18 com.box.android.data.jobs.JobService$jobSucceeded$1)
     binds: [B:57:0x0167, B:59:0x0175, B:16:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r11v9 'this' com.box.android.data.jobs.JobService) = 
      (r11v8 'this' com.box.android.data.jobs.JobService)
      (r11v8 'this' com.box.android.data.jobs.JobService)
      (r11v0 'this' com.box.android.data.jobs.JobService A[IMMUTABLE_TYPE, THIS])
     binds: [B:57:0x0167, B:59:0x0175, B:16:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r12v28 com.box.android.data.jobs.Job) = (r12v25 com.box.android.data.jobs.Job), (r12v25 com.box.android.data.jobs.Job), (r12v30 com.box.android.data.jobs.Job) binds: [B:57:0x0167, B:59:0x0175, B:16:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x017b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0199 A[PHI: r1 r5 r11 r12
      0x0199: PHI (r1v12 com.box.android.domain.jobs.JobId) = (r1v9 com.box.android.domain.jobs.JobId), (r1v16 com.box.android.domain.jobs.JobId) binds: [B:61:0x0179, B:66:0x0194] A[DONT_GENERATE, DONT_INLINE]
      0x0199: PHI (r5v19 com.box.android.data.jobs.JobService$jobSucceeded$1) = 
      (r5v17 com.box.android.data.jobs.JobService$jobSucceeded$1)
      (r5v21 com.box.android.data.jobs.JobService$jobSucceeded$1)
     binds: [B:61:0x0179, B:66:0x0194] A[DONT_GENERATE, DONT_INLINE]
      0x0199: PHI (r11v10 'this' com.box.android.data.jobs.JobService) = (r11v9 'this' com.box.android.data.jobs.JobService), (r11v12 'this' com.box.android.data.jobs.JobService) binds: [B:61:0x0179, B:66:0x0194] A[DONT_GENERATE, DONT_INLINE]
      0x0199: PHI (r12v31 com.box.android.data.jobs.Job) = (r12v28 com.box.android.data.jobs.Job), (r12v33 com.box.android.data.jobs.Job) binds: [B:61:0x0179, B:66:0x0194] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x019c  */
    /* JADX WARN: Code duplicated, block: B:73:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x018b, code lost:
    
        if (r13 == r0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ec, code lost:
    
        if (r11.runNextJob(r5) == r0) goto L82;
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object jobSucceeded(com.box.android.domain.jobs.JobId r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.jobSucceeded(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getValue(String tag) {
        return (String) StringsKt.split$default((CharSequence) tag, new String[]{":"}, false, 0, 6, (Object) null).get(1);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007d A[PHI: r10
      0x007d: PHI (r10v2 com.box.android.data.persistence.jobs.JobEntity) = 
      (r10v1 com.box.android.data.persistence.jobs.JobEntity)
      (r10v1 com.box.android.data.persistence.jobs.JobEntity)
      (r10v15 com.box.android.data.persistence.jobs.JobEntity)
     binds: [B:22:0x006c, B:24:0x007a, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
    
        if (com.box.android.data.datasource.jobs.JobsDataSource.updateStatusOfJob$default(r1, r2, r3, null, r4, 4, null) == r0) goto L28;
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object jobSubmitted(com.box.android.data.persistence.jobs.JobEntity r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.jobSubmitted(com.box.android.data.persistence.jobs.JobEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0081 A[PHI: r1 r11
      0x0081: PHI (r1v3 com.box.android.data.jobs.JobService) = 
      (r1v2 com.box.android.data.jobs.JobService)
      (r1v2 com.box.android.data.jobs.JobService)
      (r1v6 com.box.android.data.jobs.JobService)
     binds: [B:23:0x006c, B:25:0x007e, B:16:0x003e] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r11v3 com.box.android.domain.jobs.JobId) = 
      (r11v2 com.box.android.domain.jobs.JobId)
      (r11v2 com.box.android.domain.jobs.JobId)
      (r11v7 com.box.android.domain.jobs.JobId)
     binds: [B:23:0x006c, B:25:0x007e, B:16:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0096, code lost:
    
        if (com.box.android.data.datasource.jobs.JobsDataSource.updateStatusOfJob$default(r1, r2, r3, null, r4, 4, null) == r0) goto L29;
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object waitForChildren(com.box.android.domain.jobs.JobId r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.box.android.data.jobs.JobService.C13011
            if (r0 == 0) goto L14
            r0 = r12
            com.box.android.data.jobs.JobService$waitForChildren$1 r0 = (com.box.android.data.jobs.JobService.C13011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.box.android.data.jobs.JobService$waitForChildren$1 r0 = new com.box.android.data.jobs.JobService$waitForChildren$1
            r0.<init>(r12)
        L19:
            r4 = r0
            java.lang.Object r12 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 3
            r8 = 2
            r9 = 1
            if (r1 == 0) goto L50
            if (r1 == r9) goto L47
            if (r1 == r8) goto L3e
            if (r1 != r7) goto L36
            java.lang.Object r10 = r4.L$0
            com.box.android.domain.jobs.JobId r10 = (com.box.android.domain.jobs.JobId) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L99
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            java.lang.Object r11 = r4.L$0
            com.box.android.domain.jobs.JobId r11 = (com.box.android.domain.jobs.JobId) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r10
            goto L81
        L47:
            java.lang.Object r11 = r4.L$0
            com.box.android.domain.jobs.JobId r11 = (com.box.android.domain.jobs.JobId) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r1 = r10
            goto L64
        L50:
            kotlin.ResultKt.throwOnFailure(r12)
            r4.L$0 = r11
            r4.label = r9
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r10
            r2 = r11
            java.lang.Object r12 = getJobInfo$default(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto L63
            goto L98
        L63:
            r11 = r2
        L64:
            com.box.android.domain.utils.result.Result r12 = (com.box.android.domain.utils.result.Result) r12
            java.lang.Object r10 = com.box.android.domain.utils.result.ResultKt.getOrNull(r12)
            com.box.android.domain.models.JobInfo r10 = (com.box.android.domain.models.JobInfo) r10
            if (r10 == 0) goto L81
            com.box.android.domain.models.JobInfo$Status$Running r12 = new com.box.android.domain.models.JobInfo$Status$Running
            r2 = 0
            r12.<init>(r2, r9, r2)
            com.box.android.domain.models.JobInfo$Status r12 = (com.box.android.domain.models.JobInfo.Status) r12
            r4.L$0 = r11
            r4.label = r8
            java.lang.Object r10 = r1.updateStatus(r10, r12, r4)
            if (r10 != r0) goto L81
            goto L98
        L81:
            r2 = r11
            com.box.android.data.datasource.jobs.JobsDataSource r1 = r1.jobsDataSource
            com.box.android.data.persistence.jobs.JobStatus r3 = com.box.android.data.persistence.jobs.JobStatus.WAITING_FOR_CHILDREN
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r4.L$0 = r10
            r4.label = r7
            r5 = r4
            r4 = 0
            r6 = 4
            r7 = 0
            java.lang.Object r10 = com.box.android.data.datasource.jobs.JobsDataSource.updateStatusOfJob$default(r1, r2, r3, r4, r5, r6, r7)
            if (r10 != r0) goto L99
        L98:
            return r0
        L99:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.waitForChildren(com.box.android.domain.jobs.JobId, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0042 A[PHI: r4 r10 r11 r12
      0x0042: PHI (r4v5 com.box.android.data.jobs.JobService$jobRunning$1) = (r4v4 com.box.android.data.jobs.JobService$jobRunning$1), (r4v0 com.box.android.data.jobs.JobService$jobRunning$1) binds: [B:40:0x00fa, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0042: PHI (r10v14 boolean) = (r10v12 boolean), (r10v16 boolean) binds: [B:40:0x00fa, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0042: PHI (r11v16 com.box.android.domain.jobs.JobId) = (r11v13 com.box.android.domain.jobs.JobId), (r11v20 com.box.android.domain.jobs.JobId) binds: [B:40:0x00fa, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0042: PHI (r12v15 java.lang.Object) = (r12v14 java.lang.Object), (r12v1 java.lang.Object) binds: [B:40:0x00fa, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0092  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ef A[PHI: r4 r10 r11
      0x00ef: PHI (r4v4 com.box.android.data.jobs.JobService$jobRunning$1) = (r4v3 com.box.android.data.jobs.JobService$jobRunning$1), (r4v0 com.box.android.data.jobs.JobService$jobRunning$1) binds: [B:37:0x00ec, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r10v12 boolean) = (r10v10 boolean), (r10v13 boolean) binds: [B:37:0x00ec, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r11v13 com.box.android.domain.jobs.JobId) = (r11v10 com.box.android.domain.jobs.JobId), (r11v15 com.box.android.domain.jobs.JobId) binds: [B:37:0x00ec, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x0101  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0111, code lost:
    
        if (r12 == r0) goto L47;
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object jobRunning(com.box.android.domain.jobs.JobId r10, boolean r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.jobRunning(com.box.android.domain.jobs.JobId, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:101:0x037d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0398  */
    /* JADX WARN: Code duplicated, block: B:105:0x039a A[Catch: all -> 0x0133, PHI: r1 r2 r3 r8 r9 r10 r11
      0x039a: PHI (r1v21 kotlinx.coroutines.sync.Mutex) = (r1v16 kotlinx.coroutines.sync.Mutex), (r1v23 kotlinx.coroutines.sync.Mutex) binds: [B:103:0x0396, B:62:0x023c] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r2v21 int) = (r2v17 int), (r2v22 int) binds: [B:103:0x0396, B:62:0x023c] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r3v14 com.box.android.data.jobs.JobService$jobFailed$1) = (r3v9 com.box.android.data.jobs.JobService$jobFailed$1), (r3v16 com.box.android.data.jobs.JobService$jobFailed$1) binds: [B:103:0x0396, B:62:0x023c] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r8v20 com.box.android.domain.models.DomainError) = (r8v15 com.box.android.domain.models.DomainError), (r8v22 com.box.android.domain.models.DomainError) binds: [B:103:0x0396, B:62:0x023c] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r9v20 int) = (r9v13 int), (r9v23 int) binds: [B:103:0x0396, B:62:0x023c] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r10v17 ??) = (r10v87 ??), (r10v88 ??) binds: [B:103:0x0396, B:62:0x023c] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r11v11 java.lang.String) = (r11v6 java.lang.String), (r11v12 java.lang.String) binds: [B:103:0x0396, B:62:0x023c] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:107:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:108:0x03bd A[Catch: all -> 0x0133, PHI: r1 r2 r3 r8 r9 r10 r11
      0x03bd: PHI (r1v24 kotlinx.coroutines.sync.Mutex) = (r1v21 kotlinx.coroutines.sync.Mutex), (r1v27 kotlinx.coroutines.sync.Mutex) binds: [B:106:0x03b9, B:59:0x021e] A[DONT_GENERATE, DONT_INLINE]
      0x03bd: PHI (r2v23 int) = (r2v21 int), (r2v25 int) binds: [B:106:0x03b9, B:59:0x021e] A[DONT_GENERATE, DONT_INLINE]
      0x03bd: PHI (r3v17 com.box.android.data.jobs.JobService$jobFailed$1) = (r3v14 com.box.android.data.jobs.JobService$jobFailed$1), (r3v20 com.box.android.data.jobs.JobService$jobFailed$1) binds: [B:106:0x03b9, B:59:0x021e] A[DONT_GENERATE, DONT_INLINE]
      0x03bd: PHI (r8v23 com.box.android.domain.models.DomainError) = (r8v20 com.box.android.domain.models.DomainError), (r8v27 com.box.android.domain.models.DomainError) binds: [B:106:0x03b9, B:59:0x021e] A[DONT_GENERATE, DONT_INLINE]
      0x03bd: PHI (r9v24 int) = (r9v20 int), (r9v29 int) binds: [B:106:0x03b9, B:59:0x021e] A[DONT_GENERATE, DONT_INLINE]
      0x03bd: PHI (r10v20 ??) = (r10v85 ??), (r10v86 ??) binds: [B:106:0x03b9, B:59:0x021e] A[DONT_GENERATE, DONT_INLINE]
      0x03bd: PHI (r11v13 java.lang.String) = (r11v11 java.lang.String), (r11v15 java.lang.String) binds: [B:106:0x03b9, B:59:0x021e] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:110:0x03c1 A[Catch: all -> 0x0133, TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:113:0x03cc A[Catch: all -> 0x0133, TRY_LEAVE, TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:116:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:119:0x03f7 A[Catch: all -> 0x0674, TryCatch #4 {all -> 0x0674, blocks: (B:157:0x0551, B:117:0x03ec, B:119:0x03f7, B:121:0x0406, B:81:0x02f2, B:83:0x0326), top: B:204:0x02f2 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0406 A[Catch: all -> 0x0674, TRY_LEAVE, TryCatch #4 {all -> 0x0674, blocks: (B:157:0x0551, B:117:0x03ec, B:119:0x03f7, B:121:0x0406, B:81:0x02f2, B:83:0x0326), top: B:204:0x02f2 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0429  */
    /* JADX WARN: Code duplicated, block: B:127:0x0438 A[Catch: all -> 0x0133, TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:129:0x045c  */
    /* JADX WARN: Code duplicated, block: B:130:0x045e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0469  */
    /* JADX WARN: Code duplicated, block: B:136:0x048f  */
    /* JADX WARN: Code duplicated, block: B:139:0x049b A[Catch: all -> 0x01e3, TRY_LEAVE, TryCatch #1 {all -> 0x01e3, blocks: (B:44:0x0188, B:137:0x0495, B:139:0x049b, B:151:0x0541, B:154:0x054a, B:155:0x054f, B:47:0x01b1, B:50:0x01d6), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:142:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:146:0x0533  */
    /* JADX WARN: Code duplicated, block: B:150:0x053b  */
    /* JADX WARN: Code duplicated, block: B:153:0x0545  */
    /* JADX WARN: Code duplicated, block: B:154:0x054a A[Catch: all -> 0x01e3, TryCatch #1 {all -> 0x01e3, blocks: (B:44:0x0188, B:137:0x0495, B:139:0x049b, B:151:0x0541, B:154:0x054a, B:155:0x054f, B:47:0x01b1, B:50:0x01d6), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0550  */
    /* JADX WARN: Code duplicated, block: B:159:0x0554  */
    /* JADX WARN: Code duplicated, block: B:161:0x055d  */
    /* JADX WARN: Code duplicated, block: B:165:0x0582  */
    /* JADX WARN: Code duplicated, block: B:166:0x0584  */
    /* JADX WARN: Code duplicated, block: B:170:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:173:0x05b8 A[Catch: all -> 0x0133, TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:175:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:176:0x05db A[Catch: all -> 0x0133, PHI: r0 r1 r3 r7 r8 r9 r10 r11
      0x05db: PHI (r0v36 ??) = (r0v61 ??), (r0v62 ??) binds: [B:174:0x05d7, B:26:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x05db: PHI (r1v76 kotlinx.coroutines.sync.Mutex) = (r1v72 kotlinx.coroutines.sync.Mutex), (r1v78 kotlinx.coroutines.sync.Mutex) binds: [B:174:0x05d7, B:26:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x05db: PHI (r3v47 com.box.android.data.jobs.JobService$jobFailed$1) = (r3v43 com.box.android.data.jobs.JobService$jobFailed$1), (r3v49 com.box.android.data.jobs.JobService$jobFailed$1) binds: [B:174:0x05d7, B:26:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x05db: PHI (r7v15 com.box.android.domain.models.DomainError) = (r7v11 com.box.android.domain.models.DomainError), (r7v17 com.box.android.domain.models.DomainError) binds: [B:174:0x05d7, B:26:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x05db: PHI (r8v58 int) = (r8v55 int), (r8v59 int) binds: [B:174:0x05d7, B:26:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x05db: PHI (r9v63 int) = (r9v58 int), (r9v66 int) binds: [B:174:0x05d7, B:26:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x05db: PHI (r10v58 ??) = (r10v79 ??), (r10v80 ??) binds: [B:174:0x05d7, B:26:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x05db: PHI (r11v45 java.lang.String) = (r11v42 java.lang.String), (r11v46 java.lang.String) binds: [B:174:0x05d7, B:26:0x00c1] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:177:0x05dd A[Catch: all -> 0x0133, PHI: r0 r1 r3 r7 r8 r9 r10 r11
      0x05dd: PHI (r0v35 ??) = (r0v63 ??), (r0v64 ??) binds: [B:172:0x05b6, B:176:0x05db] A[DONT_GENERATE, DONT_INLINE]
      0x05dd: PHI (r1v75 kotlinx.coroutines.sync.Mutex) = (r1v72 kotlinx.coroutines.sync.Mutex), (r1v76 kotlinx.coroutines.sync.Mutex) binds: [B:172:0x05b6, B:176:0x05db] A[DONT_GENERATE, DONT_INLINE]
      0x05dd: PHI (r3v46 com.box.android.data.jobs.JobService$jobFailed$1) = (r3v43 com.box.android.data.jobs.JobService$jobFailed$1), (r3v47 com.box.android.data.jobs.JobService$jobFailed$1) binds: [B:172:0x05b6, B:176:0x05db] A[DONT_GENERATE, DONT_INLINE]
      0x05dd: PHI (r7v14 com.box.android.domain.models.DomainError) = (r7v11 com.box.android.domain.models.DomainError), (r7v15 com.box.android.domain.models.DomainError) binds: [B:172:0x05b6, B:176:0x05db] A[DONT_GENERATE, DONT_INLINE]
      0x05dd: PHI (r8v57 int) = (r8v55 int), (r8v58 int) binds: [B:172:0x05b6, B:176:0x05db] A[DONT_GENERATE, DONT_INLINE]
      0x05dd: PHI (r9v62 int) = (r9v58 int), (r9v63 int) binds: [B:172:0x05b6, B:176:0x05db] A[DONT_GENERATE, DONT_INLINE]
      0x05dd: PHI (r10v57 ??) = (r10v81 ??), (r10v82 ??) binds: [B:172:0x05b6, B:176:0x05db] A[DONT_GENERATE, DONT_INLINE]
      0x05dd: PHI (r11v44 java.lang.String) = (r11v42 java.lang.String), (r11v45 java.lang.String) binds: [B:172:0x05b6, B:176:0x05db] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:179:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:180:0x05fc A[Catch: all -> 0x0133, PHI: r0 r1 r3 r7 r8 r9 r10 r11
      0x05fc: PHI (r0v37 ??) = (r0v59 ??), (r0v60 ??) binds: [B:178:0x05f9, B:23:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x05fc: PHI (r1v79 kotlinx.coroutines.sync.Mutex) = (r1v75 kotlinx.coroutines.sync.Mutex), (r1v81 kotlinx.coroutines.sync.Mutex) binds: [B:178:0x05f9, B:23:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x05fc: PHI (r3v50 com.box.android.data.jobs.JobService$jobFailed$1) = (r3v46 com.box.android.data.jobs.JobService$jobFailed$1), (r3v52 com.box.android.data.jobs.JobService$jobFailed$1) binds: [B:178:0x05f9, B:23:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x05fc: PHI (r7v18 com.box.android.domain.models.DomainError) = (r7v14 com.box.android.domain.models.DomainError), (r7v20 com.box.android.domain.models.DomainError) binds: [B:178:0x05f9, B:23:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x05fc: PHI (r8v60 int) = (r8v57 int), (r8v61 int) binds: [B:178:0x05f9, B:23:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x05fc: PHI (r9v67 int) = (r9v62 int), (r9v70 int) binds: [B:178:0x05f9, B:23:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x05fc: PHI (r10v61 ??) = (r10v77 ??), (r10v78 ??) binds: [B:178:0x05f9, B:23:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x05fc: PHI (r11v47 java.lang.String) = (r11v44 java.lang.String), (r11v48 java.lang.String) binds: [B:178:0x05f9, B:23:0x00a3] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:182:0x0616  */
    /* JADX WARN: Code duplicated, block: B:183:0x0617 A[Catch: all -> 0x0133, PHI: r0 r1 r2 r3 r7 r8 r9 r10 r11
      0x0617: PHI (r0v38 ??) = (r0v57 ??), (r0v58 ??) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x0617: PHI (r1v82 kotlinx.coroutines.sync.Mutex) = (r1v79 kotlinx.coroutines.sync.Mutex), (r1v84 kotlinx.coroutines.sync.Mutex) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x0617: PHI (r2v65 java.lang.Object) = (r2v64 java.lang.Object), (r2v1 java.lang.Object) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x0617: PHI (r3v53 com.box.android.data.jobs.JobService$jobFailed$1) = (r3v50 com.box.android.data.jobs.JobService$jobFailed$1), (r3v55 com.box.android.data.jobs.JobService$jobFailed$1) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x0617: PHI (r7v21 com.box.android.domain.models.DomainError) = (r7v18 com.box.android.domain.models.DomainError), (r7v23 com.box.android.domain.models.DomainError) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x0617: PHI (r8v62 int) = (r8v60 int), (r8v63 int) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x0617: PHI (r9v71 int) = (r9v67 int), (r9v74 int) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x0617: PHI (r10v64 ??) = (r10v75 ??), (r10v76 ??) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]
      0x0617: PHI (r11v49 java.lang.String) = (r11v47 java.lang.String), (r11v50 java.lang.String) binds: [B:181:0x0614, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0621 A[Catch: all -> 0x0133, TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0643  */
    /* JADX WARN: Code duplicated, block: B:188:0x0644 A[Catch: all -> 0x0133, PHI: r0 r1 r3 r7 r8 r9 r10 r11
      0x0644: PHI (r0v41 ??) = (r0v53 ??), (r0v54 ??) binds: [B:186:0x0641, B:17:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0644: PHI (r1v86 kotlinx.coroutines.sync.Mutex) = (r1v82 kotlinx.coroutines.sync.Mutex), (r1v88 kotlinx.coroutines.sync.Mutex) binds: [B:186:0x0641, B:17:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0644: PHI (r3v57 com.box.android.data.jobs.JobService$jobFailed$1) = (r3v53 com.box.android.data.jobs.JobService$jobFailed$1), (r3v59 com.box.android.data.jobs.JobService$jobFailed$1) binds: [B:186:0x0641, B:17:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0644: PHI (r7v25 com.box.android.domain.models.DomainError) = (r7v21 com.box.android.domain.models.DomainError), (r7v27 com.box.android.domain.models.DomainError) binds: [B:186:0x0641, B:17:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0644: PHI (r8v65 int) = (r8v62 int), (r8v66 int) binds: [B:186:0x0641, B:17:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0644: PHI (r9v76 int) = (r9v71 int), (r9v79 int) binds: [B:186:0x0641, B:17:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0644: PHI (r10v68 ??) = (r10v71 ??), (r10v72 ??) binds: [B:186:0x0641, B:17:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x0644: PHI (r11v52 java.lang.String) = (r11v49 java.lang.String), (r11v53 java.lang.String) binds: [B:186:0x0641, B:17:0x0067] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0646 A[Catch: all -> 0x0133, PHI: r0 r1 r3 r7 r8 r9 r10 r11
      0x0646: PHI (r0v39 ??) = (r0v55 ??), (r0v56 ??) binds: [B:184:0x061f, B:188:0x0644] A[DONT_GENERATE, DONT_INLINE]
      0x0646: PHI (r1v85 kotlinx.coroutines.sync.Mutex) = (r1v82 kotlinx.coroutines.sync.Mutex), (r1v86 kotlinx.coroutines.sync.Mutex) binds: [B:184:0x061f, B:188:0x0644] A[DONT_GENERATE, DONT_INLINE]
      0x0646: PHI (r3v56 com.box.android.data.jobs.JobService$jobFailed$1) = (r3v53 com.box.android.data.jobs.JobService$jobFailed$1), (r3v57 com.box.android.data.jobs.JobService$jobFailed$1) binds: [B:184:0x061f, B:188:0x0644] A[DONT_GENERATE, DONT_INLINE]
      0x0646: PHI (r7v24 com.box.android.domain.models.DomainError) = (r7v21 com.box.android.domain.models.DomainError), (r7v25 com.box.android.domain.models.DomainError) binds: [B:184:0x061f, B:188:0x0644] A[DONT_GENERATE, DONT_INLINE]
      0x0646: PHI (r8v64 int) = (r8v62 int), (r8v65 int) binds: [B:184:0x061f, B:188:0x0644] A[DONT_GENERATE, DONT_INLINE]
      0x0646: PHI (r9v75 int) = (r9v71 int), (r9v76 int) binds: [B:184:0x061f, B:188:0x0644] A[DONT_GENERATE, DONT_INLINE]
      0x0646: PHI (r10v67 ??) = (r10v73 ??), (r10v74 ??) binds: [B:184:0x061f, B:188:0x0644] A[DONT_GENERATE, DONT_INLINE]
      0x0646: PHI (r11v51 java.lang.String) = (r11v49 java.lang.String), (r11v52 java.lang.String) binds: [B:184:0x061f, B:188:0x0644] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:80:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:83:0x0326 A[Catch: all -> 0x0674, TRY_LEAVE, TryCatch #4 {all -> 0x0674, blocks: (B:157:0x0551, B:117:0x03ec, B:119:0x03f7, B:121:0x0406, B:81:0x02f2, B:83:0x0326), top: B:204:0x02f2 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0341  */
    /* JADX WARN: Code duplicated, block: B:89:0x0351 A[Catch: all -> 0x0133, TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0376 A[Catch: all -> 0x0133, TRY_LEAVE, TryCatch #3 {all -> 0x0133, blocks: (B:13:0x004b, B:192:0x0669, B:188:0x0644, B:189:0x0646, B:183:0x0617, B:185:0x0621, B:180:0x05fc, B:176:0x05db, B:177:0x05dd, B:171:0x05ae, B:173:0x05b8, B:34:0x012e, B:147:0x0534, B:131:0x0461, B:133:0x046b, B:125:0x042e, B:127:0x0438, B:108:0x03bd, B:110:0x03c1, B:111:0x03c4, B:113:0x03cc, B:105:0x039a, B:94:0x036e, B:96:0x0372, B:98:0x0376, B:102:0x0383, B:87:0x0347, B:89:0x0351, B:91:0x0357), top: B:203:0x002b }] */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0666, code lost:
    
        if (r0.runNextJob(r3) == r6) goto L191;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x01e4: MOVE (r1 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:53:0x01e4 */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.data.jobs.JobService, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v34, types: [com.box.android.data.jobs.JobService] */
    /* JADX WARN: Type inference failed for: r0v35, types: [com.box.android.data.jobs.JobService] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37, types: [com.box.android.data.jobs.JobService] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39, types: [com.box.android.data.jobs.JobService] */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r10v12, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v17, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v20, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v54, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v57, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v58 */
    /* JADX WARN: Type inference failed for: r10v61, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v64, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v67, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v68 */
    /* JADX WARN: Type inference failed for: r10v71 */
    /* JADX WARN: Type inference failed for: r10v72 */
    /* JADX WARN: Type inference failed for: r10v73 */
    /* JADX WARN: Type inference failed for: r10v74 */
    /* JADX WARN: Type inference failed for: r10v75 */
    /* JADX WARN: Type inference failed for: r10v76 */
    /* JADX WARN: Type inference failed for: r10v77 */
    /* JADX WARN: Type inference failed for: r10v78 */
    /* JADX WARN: Type inference failed for: r10v79 */
    /* JADX WARN: Type inference failed for: r10v80 */
    /* JADX WARN: Type inference failed for: r10v81 */
    /* JADX WARN: Type inference failed for: r10v82 */
    /* JADX WARN: Type inference failed for: r10v83 */
    /* JADX WARN: Type inference failed for: r10v84 */
    /* JADX WARN: Type inference failed for: r10v85 */
    /* JADX WARN: Type inference failed for: r10v86 */
    /* JADX WARN: Type inference failed for: r10v87 */
    /* JADX WARN: Type inference failed for: r10v88 */
    /* JADX WARN: Type inference failed for: r10v89 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v90 */
    /* JADX WARN: Type inference failed for: r10v91 */
    /* JADX WARN: Type inference failed for: r10v92 */
    /* JADX WARN: Type inference failed for: r10v93 */
    /* JADX WARN: Type inference failed for: r10v94 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v8, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v28, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v42, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48, types: [com.box.android.domain.jobs.JobId] */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v68, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.box.android.domain.jobs.JobId, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v94 */
    /* JADX WARN: Type inference failed for: r1v95 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r1v97 */
    /* JADX WARN: Type inference failed for: r1v98 */
    /* JADX WARN: Type inference failed for: r1v99 */
    /* JADX WARN: Type inference failed for: r2v59, types: [com.box.android.data.datasource.jobs.JobsDataSource] */
    /* JADX WARN: Type inference failed for: r2v68, types: [com.box.android.data.jobs.ParentJob] */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v41, types: [com.box.android.data.datasource.jobs.JobsDataSource] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [com.box.android.data.datasource.jobs.JobsDataSource] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object jobFailed(com.box.android.domain.jobs.JobId r19, java.lang.String r20, com.box.android.domain.models.DomainError r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.jobFailed(com.box.android.domain.jobs.JobId, java.lang.String, com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object logGen204Metrics$default(JobService jobService, JobId jobId, String str, DomainError domainError, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            domainError = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return jobService.logGen204Metrics(jobId, str, domainError, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x011f  */
    /* JADX WARN: Code duplicated, block: B:41:0x012e  */
    /* JADX WARN: Code duplicated, block: B:45:0x015b  */
    /* JADX WARN: Code duplicated, block: B:48:0x016a  */
    /* JADX WARN: Code duplicated, block: B:49:0x016f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0199  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object logGen204Metrics(JobId jobId, String str, DomainError domainError, boolean z, Continuation<? super Unit> continuation) {
        C12881 c12881;
        DomainError domainError2;
        JobId jobId2;
        boolean z2;
        String type;
        String str2;
        Object logData;
        String str3;
        String str4;
        DomainError domainError3;
        JobId jobId3;
        Data data;
        Gen204JobServiceHelper gen204JobServiceHelper;
        Object autoRetryCountOfJob;
        Data data2;
        DomainError domainError4;
        String str5;
        Integer num;
        int iIntValue;
        Object manualRetryCountOfJob;
        int i;
        Data data3;
        String str6;
        if (continuation instanceof C12881) {
            c12881 = (C12881) continuation;
            if ((c12881.label & Integer.MIN_VALUE) != 0) {
                c12881.label -= Integer.MIN_VALUE;
            } else {
                c12881 = new C12881(continuation);
            }
        } else {
            c12881 = new C12881(continuation);
        }
        Object job = c12881.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c12881.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(job);
            if (str == null) {
                JobsDataSource jobsDataSource = this.jobsDataSource;
                c12881.L$0 = jobId;
                c12881.L$1 = SpillingKt.nullOutSpilledVariable(str);
                domainError2 = domainError;
                c12881.L$2 = domainError2;
                c12881.Z$0 = z;
                c12881.label = 1;
                job = jobsDataSource.getJob(jobId, c12881);
                if (job != coroutine_suspended) {
                    jobId2 = jobId;
                    z2 = z;
                    str2 = str;
                }
            } else {
                domainError2 = domainError;
                jobId2 = jobId;
                z2 = z;
                type = str;
                str2 = type;
                c12881.L$0 = jobId2;
                c12881.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c12881.L$2 = domainError2;
                c12881.L$3 = type;
                c12881.Z$0 = z2;
                c12881.label = 2;
                logData = getLogData(jobId2, c12881);
                if (logData != coroutine_suspended) {
                    str3 = str2;
                    str4 = type;
                    job = logData;
                    domainError3 = domainError2;
                    jobId3 = jobId2;
                    data = (Data) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                    if (data == null) {
                        data = Data.EMPTY;
                    }
                    gen204JobServiceHelper = this.gen204JobServiceHelper.get();
                    JobsDataSource jobsDataSource2 = this.jobsDataSource;
                    c12881.L$0 = jobId3;
                    c12881.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                    c12881.L$2 = domainError3;
                    c12881.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                    c12881.L$4 = data;
                    c12881.L$5 = gen204JobServiceHelper;
                    c12881.L$6 = str4;
                    c12881.Z$0 = z2;
                    c12881.label = 3;
                    autoRetryCountOfJob = jobsDataSource2.getAutoRetryCountOfJob(jobId3, c12881);
                    if (autoRetryCountOfJob != coroutine_suspended) {
                        DomainError domainError5 = domainError3;
                        data2 = data;
                        job = autoRetryCountOfJob;
                        domainError4 = domainError5;
                        str5 = str4;
                        num = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                        if (num != null) {
                            iIntValue = num.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        JobsDataSource jobsDataSource3 = this.jobsDataSource;
                        c12881.L$0 = SpillingKt.nullOutSpilledVariable(jobId3);
                        c12881.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                        c12881.L$2 = domainError4;
                        c12881.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                        c12881.L$4 = data2;
                        c12881.L$5 = gen204JobServiceHelper;
                        c12881.L$6 = str4;
                        c12881.Z$0 = z2;
                        c12881.I$0 = iIntValue;
                        c12881.label = 4;
                        manualRetryCountOfJob = jobsDataSource3.getManualRetryCountOfJob(jobId3, c12881);
                        if (manualRetryCountOfJob != coroutine_suspended) {
                            i = iIntValue;
                            data3 = data2;
                            str6 = str4;
                            job = manualRetryCountOfJob;
                            boolean z3 = z2;
                            Gen204JobServiceHelper gen204JobServiceHelper2 = gen204JobServiceHelper;
                            DomainError domainError6 = domainError4;
                            Integer num2 = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                            gen204JobServiceHelper2.log(str6, i, num2 != null ? num2.intValue() : 0, data3, z3, domainError6);
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            z2 = c12881.Z$0;
            domainError2 = (DomainError) c12881.L$2;
            str2 = (String) c12881.L$1;
            jobId2 = (JobId) c12881.L$0;
            ResultKt.throwOnFailure(job);
        } else {
            if (i2 == 2) {
                z2 = c12881.Z$0;
                String str7 = (String) c12881.L$3;
                domainError3 = (DomainError) c12881.L$2;
                String str8 = (String) c12881.L$1;
                jobId2 = (JobId) c12881.L$0;
                ResultKt.throwOnFailure(job);
                str3 = str8;
                str4 = str7;
                jobId3 = jobId2;
                data = (Data) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                if (data == null) {
                    data = Data.EMPTY;
                }
                gen204JobServiceHelper = this.gen204JobServiceHelper.get();
                JobsDataSource jobsDataSource4 = this.jobsDataSource;
                c12881.L$0 = jobId3;
                c12881.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                c12881.L$2 = domainError3;
                c12881.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                c12881.L$4 = data;
                c12881.L$5 = gen204JobServiceHelper;
                c12881.L$6 = str4;
                c12881.Z$0 = z2;
                c12881.label = 3;
                autoRetryCountOfJob = jobsDataSource4.getAutoRetryCountOfJob(jobId3, c12881);
                if (autoRetryCountOfJob != coroutine_suspended) {
                    DomainError domainError7 = domainError3;
                    data2 = data;
                    job = autoRetryCountOfJob;
                    domainError4 = domainError7;
                    str5 = str4;
                    num = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                    if (num != null) {
                        iIntValue = num.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    JobsDataSource jobsDataSource5 = this.jobsDataSource;
                    c12881.L$0 = SpillingKt.nullOutSpilledVariable(jobId3);
                    c12881.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                    c12881.L$2 = domainError4;
                    c12881.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                    c12881.L$4 = data2;
                    c12881.L$5 = gen204JobServiceHelper;
                    c12881.L$6 = str4;
                    c12881.Z$0 = z2;
                    c12881.I$0 = iIntValue;
                    c12881.label = 4;
                    manualRetryCountOfJob = jobsDataSource5.getManualRetryCountOfJob(jobId3, c12881);
                    if (manualRetryCountOfJob != coroutine_suspended) {
                        i = iIntValue;
                        data3 = data2;
                        str6 = str4;
                        job = manualRetryCountOfJob;
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 3) {
                z2 = c12881.Z$0;
                String str9 = (String) c12881.L$6;
                Gen204JobServiceHelper gen204JobServiceHelper3 = (Gen204JobServiceHelper) c12881.L$5;
                data2 = (Data) c12881.L$4;
                String str10 = (String) c12881.L$3;
                DomainError domainError8 = (DomainError) c12881.L$2;
                str3 = (String) c12881.L$1;
                jobId3 = (JobId) c12881.L$0;
                ResultKt.throwOnFailure(job);
                str4 = str9;
                gen204JobServiceHelper = gen204JobServiceHelper3;
                domainError4 = domainError8;
                str5 = str10;
                num = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    iIntValue = 0;
                }
                JobsDataSource jobsDataSource6 = this.jobsDataSource;
                c12881.L$0 = SpillingKt.nullOutSpilledVariable(jobId3);
                c12881.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                c12881.L$2 = domainError4;
                c12881.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                c12881.L$4 = data2;
                c12881.L$5 = gen204JobServiceHelper;
                c12881.L$6 = str4;
                c12881.Z$0 = z2;
                c12881.I$0 = iIntValue;
                c12881.label = 4;
                manualRetryCountOfJob = jobsDataSource6.getManualRetryCountOfJob(jobId3, c12881);
                if (manualRetryCountOfJob != coroutine_suspended) {
                    i = iIntValue;
                    data3 = data2;
                    str6 = str4;
                    job = manualRetryCountOfJob;
                }
                return coroutine_suspended;
            }
            if (i2 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c12881.I$0;
            z2 = c12881.Z$0;
            String str11 = (String) c12881.L$6;
            gen204JobServiceHelper = (Gen204JobServiceHelper) c12881.L$5;
            Data data4 = (Data) c12881.L$4;
            domainError4 = (DomainError) c12881.L$2;
            ResultKt.throwOnFailure(job);
            i = i3;
            str6 = str11;
            data3 = data4;
        }
        boolean z4 = z2;
        Gen204JobServiceHelper gen204JobServiceHelper4 = gen204JobServiceHelper;
        DomainError domainError9 = domainError4;
        Integer num3 = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
        gen204JobServiceHelper4.log(str6, i, num3 != null ? num3.intValue() : 0, data3, z4, domainError9);
        return Unit.INSTANCE;
        JobEntity jobEntity = (JobEntity) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
        type = jobEntity != null ? jobEntity.getType() : null;
        if (type == null) {
            type = "unknown";
        }
        c12881.L$0 = jobId2;
        c12881.L$1 = SpillingKt.nullOutSpilledVariable(str2);
        c12881.L$2 = domainError2;
        c12881.L$3 = type;
        c12881.Z$0 = z2;
        c12881.label = 2;
        logData = getLogData(jobId2, c12881);
        if (logData != coroutine_suspended) {
            str3 = str2;
            str4 = type;
            job = logData;
            domainError3 = domainError2;
            jobId3 = jobId2;
            data = (Data) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
            if (data == null) {
                data = Data.EMPTY;
            }
            gen204JobServiceHelper = this.gen204JobServiceHelper.get();
            JobsDataSource jobsDataSource7 = this.jobsDataSource;
            c12881.L$0 = jobId3;
            c12881.L$1 = SpillingKt.nullOutSpilledVariable(str3);
            c12881.L$2 = domainError3;
            c12881.L$3 = SpillingKt.nullOutSpilledVariable(str4);
            c12881.L$4 = data;
            c12881.L$5 = gen204JobServiceHelper;
            c12881.L$6 = str4;
            c12881.Z$0 = z2;
            c12881.label = 3;
            autoRetryCountOfJob = jobsDataSource7.getAutoRetryCountOfJob(jobId3, c12881);
            if (autoRetryCountOfJob != coroutine_suspended) {
                DomainError domainError10 = domainError3;
                data2 = data;
                job = autoRetryCountOfJob;
                domainError4 = domainError10;
                str5 = str4;
                num = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    iIntValue = 0;
                }
                JobsDataSource jobsDataSource8 = this.jobsDataSource;
                c12881.L$0 = SpillingKt.nullOutSpilledVariable(jobId3);
                c12881.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                c12881.L$2 = domainError4;
                c12881.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                c12881.L$4 = data2;
                c12881.L$5 = gen204JobServiceHelper;
                c12881.L$6 = str4;
                c12881.Z$0 = z2;
                c12881.I$0 = iIntValue;
                c12881.label = 4;
                manualRetryCountOfJob = jobsDataSource8.getManualRetryCountOfJob(jobId3, c12881);
                if (manualRetryCountOfJob != coroutine_suspended) {
                    i = iIntValue;
                    data3 = data2;
                    str6 = str4;
                    job = manualRetryCountOfJob;
                    boolean z5 = z2;
                    Gen204JobServiceHelper gen204JobServiceHelper5 = gen204JobServiceHelper;
                    DomainError domainError11 = domainError4;
                    Integer num4 = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                    gen204JobServiceHelper5.log(str6, i, num4 != null ? num4.intValue() : 0, data3, z5, domainError11);
                    return Unit.INSTANCE;
                }
            }
        }
        return coroutine_suspended;
    }

    public final Object updateLogData(JobId jobId, Map<String, ? extends Object> map, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        return this.jobsDataSource.updateLogData(jobId, map, continuation);
    }

    public final Object getLogData(JobId jobId, Continuation<? super Result<Data, ? extends CacheError>> continuation) {
        return this.jobsDataSource.getLogData(jobId, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0094  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b0, code lost:
    
        if (r1.updateStatus(r10, r14, r5) == r0) goto L29;
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object networkTaskStarting(com.box.android.domain.jobs.JobId r11, double r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.box.android.data.jobs.JobService.C12891
            if (r0 == 0) goto L14
            r0 = r14
            com.box.android.data.jobs.JobService$networkTaskStarting$1 r0 = (com.box.android.data.jobs.JobService.C12891) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.box.android.data.jobs.JobService$networkTaskStarting$1 r0 = new com.box.android.data.jobs.JobService$networkTaskStarting$1
            r0.<init>(r14)
        L19:
            r4 = r0
            java.lang.Object r14 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r8 = 3
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L58
            if (r1 == r2) goto L4c
            if (r1 == r9) goto L40
            if (r1 != r8) goto L38
            double r10 = r4.D$0
            java.lang.Object r10 = r4.L$0
            com.box.android.domain.jobs.JobId r10 = (com.box.android.domain.jobs.JobId) r10
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lb3
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            double r11 = r4.D$0
            java.lang.Object r13 = r4.L$0
            com.box.android.domain.jobs.JobId r13 = (com.box.android.domain.jobs.JobId) r13
            kotlin.ResultKt.throwOnFailure(r14)
            r1 = r10
            r5 = r4
            goto L8a
        L4c:
            double r12 = r4.D$0
            java.lang.Object r11 = r4.L$0
            com.box.android.domain.jobs.JobId r11 = (com.box.android.domain.jobs.JobId) r11
            kotlin.ResultKt.throwOnFailure(r14)
            r2 = r11
            r5 = r4
            goto L71
        L58:
            kotlin.ResultKt.throwOnFailure(r14)
            com.box.android.data.datasource.jobs.JobsDataSource r1 = r10.jobsDataSource
            com.box.android.data.persistence.jobs.JobStatus r3 = com.box.android.data.persistence.jobs.JobStatus.RUNNING
            r4.L$0 = r11
            r4.D$0 = r12
            r4.label = r2
            r5 = r4
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r11
            java.lang.Object r11 = com.box.android.data.datasource.jobs.JobsDataSource.updateStatusOfJob$default(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L71
            goto Lb2
        L71:
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r5.L$0 = r11
            r5.D$0 = r12
            r5.label = r9
            r3 = 0
            r4 = r5
            r5 = 2
            r6 = 0
            r1 = r10
            java.lang.Object r14 = getJobInfo$default(r1, r2, r3, r4, r5, r6)
            r5 = r4
            if (r14 != r0) goto L88
            goto Lb2
        L88:
            r11 = r12
            r13 = r2
        L8a:
            com.box.android.domain.utils.result.Result r14 = (com.box.android.domain.utils.result.Result) r14
            java.lang.Object r10 = com.box.android.domain.utils.result.ResultKt.getOrNull(r14)
            com.box.android.domain.models.JobInfo r10 = (com.box.android.domain.models.JobInfo) r10
            if (r10 == 0) goto Lb6
            com.box.android.domain.models.JobInfo$Status$Running r14 = new com.box.android.domain.models.JobInfo$Status$Running
            com.box.android.domain.models.JobInfo$Progress r2 = new com.box.android.domain.models.JobInfo$Progress
            r3 = 0
            r2.<init>(r3, r11)
            r14.<init>(r2)
            com.box.android.domain.models.JobInfo$Status r14 = (com.box.android.domain.models.JobInfo.Status) r14
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r5.L$0 = r13
            r5.D$0 = r11
            r5.label = r8
            java.lang.Object r10 = r1.updateStatus(r10, r14, r5)
            if (r10 != r0) goto Lb3
        Lb2:
            return r0
        Lb3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        Lb6:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.networkTaskStarting(com.box.android.domain.jobs.JobId, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ac, code lost:
    
        if (updateStatus(r1, r4, r3) == r6) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e4, code lost:
    
        if (r1.childProgressed(r0, r8, r4, r3) == r6) goto L38;
     */
    @Override // com.box.android.data.jobs.IJobEventObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object taskProgress(com.box.android.domain.jobs.JobId r15, double r16, double r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.taskProgress(com.box.android.domain.jobs.JobId, double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createJobInfo(JobEntity jobEntity, Continuation<? super JobInfo> continuation) {
        C12651 c12651;
        MutableStateFlow MutableStateFlow;
        if (continuation instanceof C12651) {
            c12651 = (C12651) continuation;
            if ((c12651.label & Integer.MIN_VALUE) != 0) {
                c12651.label -= Integer.MIN_VALUE;
            } else {
                c12651 = new C12651(continuation);
            }
        } else {
            c12651 = new C12651(continuation);
        }
        Object objWithContext = c12651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12651.label;
        IJobDisplayInfoProvider jobDisplayInfoProvider = null;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            NonCancellable nonCancellable = NonCancellable.INSTANCE;
            JobService$createJobInfo$job$1 jobService$createJobInfo$job$1 = new JobService$createJobInfo$job$1(this, jobEntity, null);
            c12651.L$0 = jobEntity;
            c12651.label = 1;
            objWithContext = BuildersKt.withContext(nonCancellable, jobService$createJobInfo$job$1, c12651);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jobEntity = (JobEntity) c12651.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        Job job = (Job) objWithContext;
        JobId id = jobEntity.getId();
        String type = jobEntity.getType();
        switch (WhenMappings.$EnumSwitchMapping$0[jobEntity.getStatus().ordinal()]) {
            case 1:
            case 3:
                MutableStateFlow = StateFlowKt.MutableStateFlow(JobInfo.Status.Waiting.INSTANCE);
                break;
            case 2:
            case 4:
                MutableStateFlow = StateFlowKt.MutableStateFlow(new JobInfo.Status.Running(null, 1, null));
                break;
            case 5:
                MutableStateFlow = StateFlowKt.MutableStateFlow(JobInfo.Status.Cancelled.INSTANCE);
                break;
            case 6:
                DomainError.UnknownError errorInfo = jobEntity.getErrorInfo();
                if (errorInfo == null) {
                    errorInfo = new DomainError.UnknownError("");
                }
                MutableStateFlow = StateFlowKt.MutableStateFlow(new JobInfo.Status.Failed(errorInfo));
                break;
            case 7:
                MutableStateFlow = StateFlowKt.MutableStateFlow(JobInfo.Status.Succeeded.INSTANCE);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        DisplayableJob displayableJob = job instanceof DisplayableJob ? (DisplayableJob) job : null;
        if (displayableJob != null && displayableJob.shouldDisplay()) {
            jobDisplayInfoProvider = displayableJob.getJobDisplayInfoProvider();
        }
        JobInfo jobInfo = new JobInfo(id, type, jobDisplayInfoProvider, MutableStateFlow);
        this.allJobInfos.put(jobInfo.getId(), jobInfo);
        return jobInfo;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:41:0x0100  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getJobAmplitudeLogger(JobId jobId, Continuation<? super BoxAmplitudeAnalytics.JobEventPropertyBuilder> continuation) {
        C12741 c12741;
        MetricsInfoProvider metricsInfoProvider;
        String amplitudeJobType;
        JobId jobId2;
        int i;
        List<String> list;
        BoxAmplitudeAnalytics.JobEventPropertyBuilder jobEventPropertyBuilderCreateJobEventBuilder;
        BoxAmplitudeAnalytics.JobEventPropertyBuilder jobEventPropertyBuilder;
        if (continuation instanceof C12741) {
            c12741 = (C12741) continuation;
            if ((c12741.label & Integer.MIN_VALUE) != 0) {
                c12741.label -= Integer.MIN_VALUE;
            } else {
                c12741 = new C12741(continuation);
            }
        } else {
            c12741 = new C12741(continuation);
        }
        Object job = c12741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c12741.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(job);
            c12741.L$0 = jobId;
            c12741.label = 1;
            job = getJob(jobId, c12741);
            if (job != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            jobId = (JobId) c12741.L$0;
            ResultKt.throwOnFailure(job);
        } else {
            if (i2 == 2) {
                i = c12741.I$0;
                amplitudeJobType = (String) c12741.L$2;
                metricsInfoProvider = (MetricsInfoProvider) c12741.L$1;
                jobId2 = (JobId) c12741.L$0;
                ResultKt.throwOnFailure(job);
                list = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
                jobEventPropertyBuilderCreateJobEventBuilder = BoxAmplitudeAnalytics.createJobEventBuilder(amplitudeJobType, false);
                if (list != null) {
                    for (String str : list) {
                        if (StringsKt.startsWith$default(str, JobTags.JOB_SOURCE, false, 2, (Object) null)) {
                            jobEventPropertyBuilderCreateJobEventBuilder.setSource(getValue(str));
                        }
                    }
                }
                c12741.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
                c12741.L$1 = SpillingKt.nullOutSpilledVariable(metricsInfoProvider);
                c12741.L$2 = SpillingKt.nullOutSpilledVariable(amplitudeJobType);
                c12741.L$3 = SpillingKt.nullOutSpilledVariable(list);
                c12741.L$4 = SpillingKt.nullOutSpilledVariable(jobEventPropertyBuilderCreateJobEventBuilder);
                c12741.L$5 = jobEventPropertyBuilderCreateJobEventBuilder;
                c12741.I$0 = i;
                c12741.label = 3;
                job = metricsInfoProvider.getAmplitudeInfos(c12741);
                if (job != coroutine_suspended) {
                    jobEventPropertyBuilder = jobEventPropertyBuilderCreateJobEventBuilder;
                }
                return coroutine_suspended;
            }
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c12741.I$0;
            jobEventPropertyBuilder = (BoxAmplitudeAnalytics.JobEventPropertyBuilder) c12741.L$5;
            ResultKt.throwOnFailure(job);
        }
        return jobEventPropertyBuilder.setAdditionalInfos((Map) job);
        metricsInfoProvider = job instanceof MetricsInfoProvider ? (MetricsInfoProvider) job : null;
        if (metricsInfoProvider == null) {
            return null;
        }
        amplitudeJobType = metricsInfoProvider.getAmplitudeJobType();
        c12741.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
        c12741.L$1 = metricsInfoProvider;
        c12741.L$2 = amplitudeJobType;
        c12741.I$0 = 0;
        c12741.label = 2;
        job = getTags(jobId, c12741);
        if (job != coroutine_suspended) {
            jobId2 = jobId;
            i = 0;
            list = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) job);
            jobEventPropertyBuilderCreateJobEventBuilder = BoxAmplitudeAnalytics.createJobEventBuilder(amplitudeJobType, false);
            if (list != null) {
                while (r10.hasNext()) {
                    if (StringsKt.startsWith$default(str, JobTags.JOB_SOURCE, false, 2, (Object) null)) {
                        jobEventPropertyBuilderCreateJobEventBuilder.setSource(getValue(str));
                    }
                }
            }
            c12741.L$0 = SpillingKt.nullOutSpilledVariable(jobId2);
            c12741.L$1 = SpillingKt.nullOutSpilledVariable(metricsInfoProvider);
            c12741.L$2 = SpillingKt.nullOutSpilledVariable(amplitudeJobType);
            c12741.L$3 = SpillingKt.nullOutSpilledVariable(list);
            c12741.L$4 = SpillingKt.nullOutSpilledVariable(jobEventPropertyBuilderCreateJobEventBuilder);
            c12741.L$5 = jobEventPropertyBuilderCreateJobEventBuilder;
            c12741.I$0 = i;
            c12741.label = 3;
            job = metricsInfoProvider.getAmplitudeInfos(c12741);
            if (job != coroutine_suspended) {
                jobEventPropertyBuilder = jobEventPropertyBuilderCreateJobEventBuilder;
                return jobEventPropertyBuilder.setAdditionalInfos((Map) job);
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object reportJobSuccessToAnalytics(JobId jobId, Continuation<? super Unit> continuation) {
        C12961 c12961;
        BoxAmplitudeAnalytics.JobEventPropertyBuilder jobEventPropertyBuilder;
        BoxAmplitudeAnalytics.JobEventPropertyBuilder jobEventPropertyBuilder2;
        if (continuation instanceof C12961) {
            c12961 = (C12961) continuation;
            if ((c12961.label & Integer.MIN_VALUE) != 0) {
                c12961.label -= Integer.MIN_VALUE;
            } else {
                c12961 = new C12961(continuation);
            }
        } else {
            c12961 = new C12961(continuation);
        }
        Object jobAmplitudeLogger = c12961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12961.label;
        if (i == 0) {
            ResultKt.throwOnFailure(jobAmplitudeLogger);
            c12961.L$0 = jobId;
            c12961.label = 1;
            jobAmplitudeLogger = getJobAmplitudeLogger(jobId, c12961);
            if (jobAmplitudeLogger != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            jobId = (JobId) c12961.L$0;
            ResultKt.throwOnFailure(jobAmplitudeLogger);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12961.I$0;
            jobEventPropertyBuilder2 = (BoxAmplitudeAnalytics.JobEventPropertyBuilder) c12961.L$3;
            jobEventPropertyBuilder = (BoxAmplitudeAnalytics.JobEventPropertyBuilder) c12961.L$2;
            ResultKt.throwOnFailure(jobAmplitudeLogger);
        }
        Integer num = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobAmplitudeLogger);
        jobEventPropertyBuilder2.setAutoRetries(num != null ? num.intValue() : 0);
        jobEventPropertyBuilder.logJobSuccess();
        return Unit.INSTANCE;
        BoxAmplitudeAnalytics.JobEventPropertyBuilder jobEventPropertyBuilder3 = (BoxAmplitudeAnalytics.JobEventPropertyBuilder) jobAmplitudeLogger;
        if (jobEventPropertyBuilder3 != null) {
            JobsDataSource jobsDataSource = this.jobsDataSource;
            c12961.L$0 = SpillingKt.nullOutSpilledVariable(jobId);
            c12961.L$1 = jobEventPropertyBuilder3;
            c12961.L$2 = jobEventPropertyBuilder3;
            c12961.L$3 = jobEventPropertyBuilder3;
            c12961.I$0 = 0;
            c12961.label = 2;
            Object autoRetryCountOfJob = jobsDataSource.getAutoRetryCountOfJob(jobId, c12961);
            if (autoRetryCountOfJob != coroutine_suspended) {
                jobEventPropertyBuilder = jobEventPropertyBuilder3;
                jobAmplitudeLogger = autoRetryCountOfJob;
                jobEventPropertyBuilder2 = jobEventPropertyBuilder;
                Integer num2 = (Integer) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) jobAmplitudeLogger);
                jobEventPropertyBuilder2.setAutoRetries(num2 != null ? num2.intValue() : 0);
                jobEventPropertyBuilder.logJobSuccess();
            }
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x008f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0095 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (r8 == r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reportJobFailedToAnalytics(com.box.android.domain.jobs.JobId r6, com.box.android.domain.models.DomainError r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.box.android.data.jobs.JobService.C12951
            if (r0 == 0) goto L14
            r0 = r8
            com.box.android.data.jobs.JobService$reportJobFailedToAnalytics$1 r0 = (com.box.android.data.jobs.JobService.C12951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.box.android.data.jobs.JobService$reportJobFailedToAnalytics$1 r0 = new com.box.android.data.jobs.JobService$reportJobFailedToAnalytics$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$1
            com.box.android.domain.models.DomainError r6 = (com.box.android.domain.models.DomainError) r6
            java.lang.Object r7 = r0.L$0
            com.box.android.domain.jobs.JobId r7 = (com.box.android.domain.jobs.JobId) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L91
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            com.box.android.domain.models.DomainError r7 = (com.box.android.domain.models.DomainError) r7
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.jobs.JobId r6 = (com.box.android.domain.jobs.JobId) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L66
        L4c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.domain.models.ErrorRecoveryType r8 = r7.getErrorType()
            com.box.android.domain.models.ErrorRecoveryType r2 = com.box.android.domain.models.ErrorRecoveryType.AUTOMATIC
            if (r8 != r2) goto L7c
            com.box.android.data.datasource.jobs.JobsDataSource r8 = r5.jobsDataSource
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.getAutoRetryCountOfJob(r6, r0)
            if (r8 != r1) goto L66
            goto L8e
        L66:
            com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
            java.lang.Object r8 = com.box.android.domain.utils.result.ResultKt.getOrNull(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            r2 = 8
            if (r8 == 0) goto L77
            int r8 = r8.intValue()
            goto L78
        L77:
            r8 = r2
        L78:
            if (r8 < r2) goto L7b
            goto L7c
        L7b:
            r4 = 0
        L7c:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r8
            r0.L$1 = r7
            r0.I$0 = r4
            r0.label = r3
            java.lang.Object r8 = r5.getJobAmplitudeLogger(r6, r0)
            if (r8 != r1) goto L8f
        L8e:
            return r1
        L8f:
            r6 = r7
            r5 = r4
        L91:
            com.box.android.domain.analytics.BoxAmplitudeAnalytics$JobEventPropertyBuilder r8 = (com.box.android.domain.analytics.BoxAmplitudeAnalytics.JobEventPropertyBuilder) r8
            if (r8 == 0) goto L9e
            if (r5 == 0) goto L9e
            java.lang.String r5 = r6.getSimpleClassName()
            r8.logJobFailed(r5)
        L9e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobService.reportJobFailedToAnalytics(com.box.android.domain.jobs.JobId, com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getMutexMapKey(JobId jobId, String tag) {
        return tag + " " + jobId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getMutex(String str, Continuation<? super Mutex> continuation) {
        C12781 c12781;
        Mutex mutex;
        if (continuation instanceof C12781) {
            c12781 = (C12781) continuation;
            if ((c12781.label & Integer.MIN_VALUE) != 0) {
                c12781.label -= Integer.MIN_VALUE;
            } else {
                c12781 = new C12781(continuation);
            }
        } else {
            c12781 = new C12781(continuation);
        }
        Object obj = c12781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12781.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutexMapMutex;
            c12781.L$0 = str;
            c12781.L$1 = mutex;
            c12781.I$0 = 0;
            c12781.label = 1;
            if (mutex.lock(null, c12781) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c12781.I$0;
            Mutex mutex2 = (Mutex) c12781.L$1;
            String str2 = (String) c12781.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            str = str2;
        }
        try {
            ConcurrentHashMap<String, Mutex> concurrentHashMap = this.mutexMap;
            final Function1 function1 = new Function1() { // from class: com.box.android.data.jobs.JobService$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return JobService.getMutex$lambda$0$0((String) obj2);
                }
            };
            Mutex mutexComputeIfAbsent = concurrentHashMap.computeIfAbsent(str, new Function() { // from class: com.box.android.data.jobs.JobService$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return JobService.getMutex$lambda$0$1(function1, obj2);
                }
            });
            mutex.unlock(null);
            Intrinsics.checkNotNull(mutexComputeIfAbsent);
            return mutexComputeIfAbsent;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex getMutex$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex getMutex$lambda$0$1(Function1 function1, Object obj) {
        return (Mutex) function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateStatus(JobInfo jobInfo, JobInfo.Status status, Continuation<? super Unit> continuation) {
        Flow<JobInfo.Status> status2 = jobInfo.getStatus();
        Intrinsics.checkNotNull(status2, "null cannot be cast to non-null type kotlinx.coroutines.flow.MutableStateFlow<com.box.android.domain.models.JobInfo.Status>");
        Object objEmit = ((MutableStateFlow) status2).emit(status, continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    public final String getLastKnowContextId() {
        return this.lastKnowContextId;
    }

    public final void setLastKnowContextId(String str) {
        this.lastKnowContextId = str;
    }

    @Override // com.box.android.domain.identity.IUserContextComponent
    /* JADX INFO: renamed from: getContextId, reason: from getter */
    public String getLastKnowContextId() {
        return this.lastKnowContextId;
    }

    @Override // com.box.android.domain.identity.IUserContextComponent
    public void onCreate(String contextId) {
        if (contextId != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatcher), null, null, new JobService$onCreate$1$1(this, null), 3, null);
        }
        this.lastKnowContextId = contextId;
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$onSoftDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService$onSoftDestroy$1", f = "JobService.kt", i = {}, l = {HubAssetRemoteDataSource.HUB_BANNER_SCALED_SIZE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C12921(Continuation<? super C12921> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JobService.this.new C12921(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (JobService.this.pauseAllRunningJobs(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.domain.identity.IUserContextComponent
    public void onSoftDestroy() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new C12921(null), 1, null);
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobService$onHardDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobService$onHardDestroy$1", f = "JobService.kt", i = {}, l = {804}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C12911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C12911(Continuation<? super C12911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JobService.this.new C12911(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (JobService.this.pauseAllRunningJobs(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new C12911(null), 1, null);
    }
}
