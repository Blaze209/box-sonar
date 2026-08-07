package com.box.android.hubs.hubDetails.presentation;

import android.net.Uri;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.android.hubs.hubDetails.domain.HubSpecificUrlHandler;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.HubDetailsInitialContext;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u001d\u001e\u001f !B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0002J\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "environment", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsEnvironment;", "<init>", "(Lcom/box/android/hubs/hubDetails/presentation/HubDetailsEnvironment;)V", "getEnvironment", "()Lcom/box/android/hubs/hubDetails/presentation/HubDetailsEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceHubDetails", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "handleHubPageLoaded", "handleLinkNavigation", "url", "", "fetchHubDetails", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnHubDetailsReady;", "handleHubSpecificUrl", "uri", "Landroid/net/Uri;", "(Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleBoxWebLink", "ScreenState", "ViewEffect", "HubDetailsError", "State", "Action", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubDetailsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final HubDetailsEnvironment environment;

    /* JADX INFO: compiled from: HubDetailsReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$HubDetailsError;", "", "<init>", "(Ljava/lang/String;I)V", "WEB_LINK_LAUNCH_ERROR", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum HubDetailsError {
        WEB_LINK_LAUNCH_ERROR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<HubDetailsError> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: com.box.android.hubs.hubDetails.presentation.HubDetailsReducer$handleBoxWebLink$1, reason: invalid class name */
    /* JADX INFO: compiled from: HubDetailsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.hubDetails.presentation.HubDetailsReducer", f = "HubDetailsReducer.kt", i = {0, 0}, l = {Token.TO_DOUBLE}, m = "handleBoxWebLink", n = {"state", "uri"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HubDetailsReducer.this.handleBoxWebLink(null, null, this);
        }
    }

    public HubDetailsReducer(HubDetailsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new HubDetailsReducer$build$1(this));
    }

    public final HubDetailsEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: HubDetailsReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState;", "", "<init>", "()V", "Initializing", "Error", "Loaded", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState$Error;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState$Initializing;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState$Loaded;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ScreenState {
        public static final int $stable = 0;

        public /* synthetic */ ScreenState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState$Initializing;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initializing extends ScreenState {
            public static final int $stable = 0;
            public static final Initializing INSTANCE = new Initializing();

            private Initializing() {
                super(null);
            }
        }

        private ScreenState() {
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState$Error;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState;", "domainError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getDomainError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends ScreenState {
            public static final int $stable = 8;
            private final DomainError domainError;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.domainError;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getDomainError() {
                return this.domainError;
            }

            public final Error copy(DomainError domainError) {
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                return new Error(domainError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.domainError, ((Error) other).domainError);
            }

            public int hashCode() {
                return this.domainError.hashCode();
            }

            public String toString() {
                return "Error(domainError=" + this.domainError + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError domainError) {
                super(null);
                Intrinsics.checkNotNullParameter(domainError, "domainError");
                this.domainError = domainError;
            }

            public final DomainError getDomainError() {
                return this.domainError;
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState$Loaded;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState;", "hubUrl", "", "isWebPageProcessing", "", "<init>", "(Ljava/lang/String;Z)V", "getHubUrl", "()Ljava/lang/String;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loaded extends ScreenState {
            public static final int $stable = 0;
            private final String hubUrl;
            private final boolean isWebPageProcessing;

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.hubUrl;
                }
                if ((i & 2) != 0) {
                    z = loaded.isWebPageProcessing;
                }
                return loaded.copy(str, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHubUrl() {
                return this.hubUrl;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsWebPageProcessing() {
                return this.isWebPageProcessing;
            }

            public final Loaded copy(String hubUrl, boolean isWebPageProcessing) {
                Intrinsics.checkNotNullParameter(hubUrl, "hubUrl");
                return new Loaded(hubUrl, isWebPageProcessing);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics.areEqual(this.hubUrl, loaded.hubUrl) && this.isWebPageProcessing == loaded.isWebPageProcessing;
            }

            public int hashCode() {
                return (this.hubUrl.hashCode() * 31) + Boolean.hashCode(this.isWebPageProcessing);
            }

            public String toString() {
                return "Loaded(hubUrl=" + this.hubUrl + ", isWebPageProcessing=" + this.isWebPageProcessing + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(String hubUrl, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(hubUrl, "hubUrl");
                this.hubUrl = hubUrl;
                this.isWebPageProcessing = z;
            }

            public /* synthetic */ Loaded(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? true : z);
            }

            public final String getHubUrl() {
                return this.hubUrl;
            }

            public final boolean isWebPageProcessing() {
                return this.isWebPageProcessing;
            }
        }
    }

    /* JADX INFO: compiled from: HubDetailsReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "", "<init>", "()V", "OpenInExternalApp", "OpenInBoxApp", "DisplayErrorMessage", "GoBack", "None", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$DisplayErrorMessage;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$GoBack;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$None;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$OpenInBoxApp;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$OpenInExternalApp;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ViewEffect {
        public static final int $stable = 0;

        public /* synthetic */ ViewEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$OpenInExternalApp;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenInExternalApp extends ViewEffect {
            public static final int $stable = 0;
            private final String url;

            public static /* synthetic */ OpenInExternalApp copy$default(OpenInExternalApp openInExternalApp, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = openInExternalApp.url;
                }
                return openInExternalApp.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final OpenInExternalApp copy(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new OpenInExternalApp(url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenInExternalApp) && Intrinsics.areEqual(this.url, ((OpenInExternalApp) other).url);
            }

            public int hashCode() {
                return this.url.hashCode();
            }

            public String toString() {
                return "OpenInExternalApp(url=" + this.url + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenInExternalApp(String url) {
                super(null);
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        private ViewEffect() {
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$OpenInBoxApp;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenInBoxApp extends ViewEffect {
            public static final int $stable = 0;
            private final String url;

            public static /* synthetic */ OpenInBoxApp copy$default(OpenInBoxApp openInBoxApp, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = openInBoxApp.url;
                }
                return openInBoxApp.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final OpenInBoxApp copy(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new OpenInBoxApp(url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenInBoxApp) && Intrinsics.areEqual(this.url, ((OpenInBoxApp) other).url);
            }

            public int hashCode() {
                return this.url.hashCode();
            }

            public String toString() {
                return "OpenInBoxApp(url=" + this.url + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenInBoxApp(String url) {
                super(null);
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$DisplayErrorMessage;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "error", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$HubDetailsError;", "<init>", "(Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$HubDetailsError;)V", "getError", "()Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$HubDetailsError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DisplayErrorMessage extends ViewEffect {
            public static final int $stable = 0;
            private final HubDetailsError error;

            public static /* synthetic */ DisplayErrorMessage copy$default(DisplayErrorMessage displayErrorMessage, HubDetailsError hubDetailsError, int i, Object obj) {
                if ((i & 1) != 0) {
                    hubDetailsError = displayErrorMessage.error;
                }
                return displayErrorMessage.copy(hubDetailsError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final HubDetailsError getError() {
                return this.error;
            }

            public final DisplayErrorMessage copy(HubDetailsError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new DisplayErrorMessage(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DisplayErrorMessage) && this.error == ((DisplayErrorMessage) other).error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "DisplayErrorMessage(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DisplayErrorMessage(HubDetailsError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final HubDetailsError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$GoBack;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class GoBack extends ViewEffect {
            public static final int $stable = 0;
            public static final GoBack INSTANCE = new GoBack();

            private GoBack() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect$None;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "<init>", "()V", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class None extends ViewEffect {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: HubDetailsReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;", "", HubDetailsInitialContext.HUB_ID_KEY, "", "screenState", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState;", "viewEffect", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "<init>", "(Ljava/lang/String;Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState;Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;)V", "getHubId", "()Ljava/lang/String;", "getScreenState", "()Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ScreenState;", "getViewEffect", "()Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final String hubId;
        private final ScreenState screenState;
        private final ViewEffect viewEffect;

        public static /* synthetic */ State copy$default(State state, String str, ScreenState screenState, ViewEffect viewEffect, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.hubId;
            }
            if ((i & 2) != 0) {
                screenState = state.screenState;
            }
            if ((i & 4) != 0) {
                viewEffect = state.viewEffect;
            }
            return state.copy(str, screenState, viewEffect);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHubId() {
            return this.hubId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ScreenState getScreenState() {
            return this.screenState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final State copy(String hubId, ScreenState screenState, ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(hubId, "hubId");
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            return new State(hubId, screenState, viewEffect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.hubId, state.hubId) && Intrinsics.areEqual(this.screenState, state.screenState) && Intrinsics.areEqual(this.viewEffect, state.viewEffect);
        }

        public int hashCode() {
            return (((this.hubId.hashCode() * 31) + this.screenState.hashCode()) * 31) + this.viewEffect.hashCode();
        }

        public String toString() {
            return "State(hubId=" + this.hubId + ", screenState=" + this.screenState + ", viewEffect=" + this.viewEffect + ")";
        }

        public State(String hubId, ScreenState screenState, ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(hubId, "hubId");
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            this.hubId = hubId;
            this.screenState = screenState;
            this.viewEffect = viewEffect;
        }

        public /* synthetic */ State(String str, ScreenState screenState, ViewEffect.None none, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, screenState, (i & 4) != 0 ? ViewEffect.None.INSTANCE : none);
        }

        public final String getHubId() {
            return this.hubId;
        }

        public final ScreenState getScreenState() {
            return this.screenState;
        }

        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }
    }

    /* JADX INFO: compiled from: HubDetailsReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "", "<init>", "()V", "Initialize", "InitializeError", "OnHubDetailsReady", "Reload", "OnBack", "NavigateToUrl", "OnHubPageLoaded", "OnViewEffectProcessed", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$Initialize;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$InitializeError;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$NavigateToUrl;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnBack;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnHubDetailsReady;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnHubPageLoaded;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$Reload;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$Initialize;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialize)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -935444283;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$InitializeError;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InitializeError extends Action {
            public static final int $stable = 0;
            public static final InitializeError INSTANCE = new InitializeError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InitializeError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 953570371;
            }

            public String toString() {
                return "InitializeError";
            }

            private InitializeError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnHubDetailsReady;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "readyState", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;", "<init>", "(Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;)V", "getReadyState", "()Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnHubDetailsReady extends Action {
            public static final int $stable = 0;
            private final State readyState;

            public static /* synthetic */ OnHubDetailsReady copy$default(OnHubDetailsReady onHubDetailsReady, State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = onHubDetailsReady.readyState;
                }
                return onHubDetailsReady.copy(state);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final State getReadyState() {
                return this.readyState;
            }

            public final OnHubDetailsReady copy(State readyState) {
                Intrinsics.checkNotNullParameter(readyState, "readyState");
                return new OnHubDetailsReady(readyState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OnHubDetailsReady) && Intrinsics.areEqual(this.readyState, ((OnHubDetailsReady) other).readyState);
            }

            public int hashCode() {
                return this.readyState.hashCode();
            }

            public String toString() {
                return "OnHubDetailsReady(readyState=" + this.readyState + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnHubDetailsReady(State readyState) {
                super(null);
                Intrinsics.checkNotNullParameter(readyState, "readyState");
                this.readyState = readyState;
            }

            public final State getReadyState() {
                return this.readyState;
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$Reload;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Reload extends Action {
            public static final int $stable = 0;
            public static final Reload INSTANCE = new Reload();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Reload)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1876305586;
            }

            public String toString() {
                return "Reload";
            }

            private Reload() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnBack;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnBack extends Action {
            public static final int $stable = 0;
            public static final OnBack INSTANCE = new OnBack();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnBack)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1955145957;
            }

            public String toString() {
                return "OnBack";
            }

            private OnBack() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$NavigateToUrl;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateToUrl extends Action {
            public static final int $stable = 0;
            private final String url;

            public static /* synthetic */ NavigateToUrl copy$default(NavigateToUrl navigateToUrl, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = navigateToUrl.url;
                }
                return navigateToUrl.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final NavigateToUrl copy(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new NavigateToUrl(url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToUrl) && Intrinsics.areEqual(this.url, ((NavigateToUrl) other).url);
            }

            public int hashCode() {
                return this.url.hashCode();
            }

            public String toString() {
                return "NavigateToUrl(url=" + this.url + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToUrl(String url) {
                super(null);
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnHubPageLoaded;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnHubPageLoaded extends Action {
            public static final int $stable = 0;
            public static final OnHubPageLoaded INSTANCE = new OnHubPageLoaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnHubPageLoaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1548746091;
            }

            public String toString() {
                return "OnHubPageLoaded";
            }

            private OnHubPageLoaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: HubDetailsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnViewEffectProcessed extends Action {
            public static final int $stable = 0;
            public static final OnViewEffectProcessed INSTANCE = new OnViewEffectProcessed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnViewEffectProcessed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -750640476;
            }

            public String toString() {
                return "OnViewEffectProcessed";
            }

            private OnViewEffectProcessed() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    public final ReducerResult<State, Action> reduceHubDetails(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.OnViewEffectProcessed) {
            return new ReducerResult<>(State.copy$default(state, null, null, ViewEffect.None.INSTANCE, 3, null), null, 2, null);
        }
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(state, new Effect((Function1) new C16471(state, null)));
        }
        if (action instanceof Action.OnHubDetailsReady) {
            return new ReducerResult<>(((Action.OnHubDetailsReady) action).getReadyState(), null, 2, null);
        }
        if (action instanceof Action.Reload) {
            return new ReducerResult<>(state, new Effect(Action.Initialize.INSTANCE));
        }
        if (action instanceof Action.OnHubPageLoaded) {
            return handleHubPageLoaded(state);
        }
        if (action instanceof Action.OnBack) {
            return new ReducerResult<>(State.copy$default(state, null, null, ViewEffect.GoBack.INSTANCE, 3, null), null, 2, null);
        }
        if (action instanceof Action.NavigateToUrl) {
            return handleLinkNavigation(state, ((Action.NavigateToUrl) action).getUrl());
        }
        if (!(action instanceof Action.InitializeError)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, new ScreenState.Error(new DomainError.UnknownError("Error loading hubs")), null, 5, null), null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.hubs.hubDetails.presentation.HubDetailsReducer$reduceHubDetails$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HubDetailsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.hubDetails.presentation.HubDetailsReducer$reduceHubDetails$1", f = "HubDetailsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16471 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16471(State state, Continuation<? super C16471> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HubDetailsReducer.this.new C16471(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C16471) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return HubDetailsReducer.this.fetchHubDetails(this.$state);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    private final ReducerResult<State, Action> handleHubPageLoaded(State state) {
        State stateCopy$default;
        ScreenState screenState = state.getScreenState();
        if (screenState instanceof ScreenState.Loaded) {
            ScreenState.Loaded loaded = (ScreenState.Loaded) screenState;
            if (loaded.isWebPageProcessing()) {
                stateCopy$default = State.copy$default(state, null, ScreenState.Loaded.copy$default(loaded, null, false, 1, null), null, 5, null);
            } else {
                stateCopy$default = state;
            }
        } else {
            stateCopy$default = state;
        }
        return new ReducerResult<>(stateCopy$default, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.hubs.hubDetails.presentation.HubDetailsReducer$handleLinkNavigation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HubDetailsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.hubs.hubDetails.presentation.HubDetailsReducer$handleLinkNavigation$1", f = "HubDetailsReducer.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16461 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16461(State state, Uri uri, Continuation<? super C16461> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return HubDetailsReducer.this.new C16461(this.$state, this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C16461) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objHandleHubSpecificUrl = HubDetailsReducer.this.handleHubSpecificUrl(this.$state, this.$uri, this);
            return objHandleHubSpecificUrl == coroutine_suspended ? coroutine_suspended : objHandleHubSpecificUrl;
        }
    }

    public final Action.OnHubDetailsReady fetchHubDetails(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new Action.OnHubDetailsReady(new State(state.getHubId(), new ScreenState.Loaded(this.environment.getBveManager().getBaseUri() + "hubs/" + state.getHubId() + "?box_app_context=webview", true), null, 4, null));
    }

    public final Object handleHubSpecificUrl(State state, Uri uri, Continuation<? super Action> continuation) {
        return this.environment.getHubsSpecificUrlHandler().isWebLink(uri) ? handleBoxWebLink(state, uri, continuation) : new Action.OnHubDetailsReady(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleBoxWebLink(State state, Uri uri, Continuation<? super Action> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objHandleBoxWebLink = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objHandleBoxWebLink);
            HubSpecificUrlHandler hubsSpecificUrlHandler = this.environment.getHubsSpecificUrlHandler();
            anonymousClass1.L$0 = state;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(uri);
            anonymousClass1.label = 1;
            objHandleBoxWebLink = hubsSpecificUrlHandler.handleBoxWebLink(uri, anonymousClass1);
            if (objHandleBoxWebLink == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            state = (State) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objHandleBoxWebLink);
        }
        State state2 = state;
        Result.Error error = (Result) objHandleBoxWebLink;
        if (error instanceof Result.Success) {
            error = new Result.Success(new Action.NavigateToUrl((String) ((Result.Success) error).getValue()));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                BoxLogUtils.e("Error while handling web link: " + ((DomainError) ((Result.Error) error).getValue()).getMessage());
                error = new Result.Error(new Action.OnHubDetailsReady(State.copy$default(state2, null, null, new ViewEffect.DisplayErrorMessage(HubDetailsError.WEB_LINK_LAUNCH_ERROR), 3, null)));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        Object obj = com.box.android.domain.utils.result.ResultKt.get(error);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.android.hubs.hubDetails.presentation.HubDetailsReducer.Action");
        return (Action) obj;
    }

    private final ReducerResult<State, Action> handleLinkNavigation(State state, String url) {
        Uri uri = Uri.parse(url);
        if (this.environment.getBoxUriSupportChecker().isLinkSupportedByBoxApp(uri)) {
            return new ReducerResult<>(State.copy$default(state, null, null, new ViewEffect.OpenInBoxApp(url), 3, null), null, 2, null);
        }
        if (this.environment.getHubsSpecificUrlHandler().isHubSpecificUrl(uri)) {
            return new ReducerResult<>(state, new Effect((Function1) new C16461(state, uri, null)));
        }
        return new ReducerResult<>(State.copy$default(state, null, null, new ViewEffect.OpenInExternalApp(url), 3, null), null, 2, null);
    }
}
