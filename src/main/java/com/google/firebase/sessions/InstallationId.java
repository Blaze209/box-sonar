package com.google.firebase.sessions;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InstallationId.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/InstallationId;", "", "fid", "", "authToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthToken", "()Ljava/lang/String;", "getFid", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InstallationId {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "InstallationId";
    private final String authToken;
    private final String fid;

    public /* synthetic */ InstallationId(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    /* JADX INFO: compiled from: InstallationId.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/InstallationId$Companion;", "", "()V", "TAG", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/google/firebase/sessions/InstallationId;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "(Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
        
            if (r7 == r9) goto L32;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7, types: [com.google.firebase.installations.FirebaseInstallationsApi] */
        /* JADX WARN: Type inference failed for: r8v0, types: [com.google.firebase.installations.FirebaseInstallationsApi, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v19 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object create(com.google.firebase.installations.FirebaseInstallationsApi r8, kotlin.coroutines.Continuation<? super com.google.firebase.sessions.InstallationId> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof com.google.firebase.sessions.InstallationId$Companion$create$1
                if (r0 == 0) goto L14
                r0 = r9
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = (com.google.firebase.sessions.InstallationId$Companion$create$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L19
            L14:
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = new com.google.firebase.sessions.InstallationId$Companion$create$1
                r0.<init>(r7, r9)
            L19:
                java.lang.Object r7 = r0.result
                java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r0.label
                java.lang.String r2 = ""
                java.lang.String r3 = "InstallationId"
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L47
                if (r1 == r5) goto L3f
                if (r1 != r4) goto L37
                java.lang.Object r8 = r0.L$0
                java.lang.String r8 = (java.lang.String) r8
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L35
                goto L8c
            L35:
                r7 = move-exception
                goto L95
            L37:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3f:
                java.lang.Object r8 = r0.L$0
                com.google.firebase.installations.FirebaseInstallationsApi r8 = (com.google.firebase.installations.FirebaseInstallationsApi) r8
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L6e
                goto L5f
            L47:
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = 0
                com.google.android.gms.tasks.Task r7 = r8.getToken(r7)     // Catch: java.lang.Exception -> L6e
                java.lang.String r1 = "firebaseInstallations.getToken(false)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch: java.lang.Exception -> L6e
                r0.L$0 = r8     // Catch: java.lang.Exception -> L6e
                r0.label = r5     // Catch: java.lang.Exception -> L6e
                java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.await(r7, r0)     // Catch: java.lang.Exception -> L6e
                if (r7 != r9) goto L5f
                goto L8b
            L5f:
                com.google.firebase.installations.InstallationTokenResult r7 = (com.google.firebase.installations.InstallationTokenResult) r7     // Catch: java.lang.Exception -> L6e
                java.lang.String r7 = r7.getToken()     // Catch: java.lang.Exception -> L6e
                java.lang.String r1 = "{\n          firebaseInst…).await().token\n        }"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch: java.lang.Exception -> L6e
                r6 = r8
                r8 = r7
                r7 = r6
                goto L78
            L6e:
                r7 = move-exception
                java.lang.String r1 = "Error getting authentication token."
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                android.util.Log.w(r3, r1, r7)
                r7 = r8
                r8 = r2
            L78:
                com.google.android.gms.tasks.Task r7 = r7.getId()     // Catch: java.lang.Exception -> L35
                java.lang.String r1 = "firebaseInstallations.id"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch: java.lang.Exception -> L35
                r0.L$0 = r8     // Catch: java.lang.Exception -> L35
                r0.label = r4     // Catch: java.lang.Exception -> L35
                java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.await(r7, r0)     // Catch: java.lang.Exception -> L35
                if (r7 != r9) goto L8c
            L8b:
                return r9
            L8c:
                java.lang.String r9 = "{\n          firebaseInst…ions.id.await()\n        }"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)     // Catch: java.lang.Exception -> L35
                java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L35
                r2 = r7
                goto L9c
            L95:
                java.lang.String r9 = "Error getting Firebase installation id ."
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                android.util.Log.w(r3, r9, r7)
            L9c:
                com.google.firebase.sessions.InstallationId r7 = new com.google.firebase.sessions.InstallationId
                r9 = 0
                r7.<init>(r2, r8, r9)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.InstallationId.Companion.create(com.google.firebase.installations.FirebaseInstallationsApi, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    private InstallationId(String str, String str2) {
        this.fid = str;
        this.authToken = str2;
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getFid() {
        return this.fid;
    }
}
