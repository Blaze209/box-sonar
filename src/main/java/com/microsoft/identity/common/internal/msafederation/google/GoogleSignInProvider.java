package com.microsoft.identity.common.internal.msafederation.google;

import android.app.Activity;
import android.content.Context;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.GetCustomCredentialOption;
import androidx.credentials.exceptions.GetCredentialCustomException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.NoCredentialException;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import com.microsoft.identity.common.internal.msafederation.IMsaFederatedSignInProvider;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.identity.common.java.base64.Base64Util;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.logging.Logger;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GoogleSignInProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u0011\u0010\u0019\u001a\u00020\u001aH\u0096@ø\u0001\u0002¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/google/GoogleSignInProvider;", "Lcom/microsoft/identity/common/internal/msafederation/IMsaFederatedSignInProvider;", "credentialManager", "Landroidx/credentials/CredentialManager;", "signInWithGoogleParameters", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleParameters;", "(Landroidx/credentials/CredentialManager;Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleParameters;)V", "generateNonce", "", "size", "", "getCredential", "Lkotlin/Result;", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleCredential;", "option", "Landroidx/credentials/GetCustomCredentialOption;", "getCredential-gIAlu-s", "(Landroidx/credentials/GetCustomCredentialOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "signIn-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithGoogle", "signInWithGoogle-IoAF18A", "signInWithGoogleBottomSheet", "signInWithGoogleBottomSheet-IoAF18A", "signOut", "", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoogleSignInProvider implements IMsaFederatedSignInProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "GoogleSignInProvider";
    private final CredentialManager credentialManager;
    private final SignInWithGoogleParameters signInWithGoogleParameters;

    @JvmStatic
    public static final GoogleSignInProvider create(SignInWithGoogleParameters signInWithGoogleParameters) {
        return INSTANCE.create(signInWithGoogleParameters);
    }

    public GoogleSignInProvider(CredentialManager credentialManager, SignInWithGoogleParameters signInWithGoogleParameters) {
        Intrinsics.checkNotNullParameter(credentialManager, "credentialManager");
        Intrinsics.checkNotNullParameter(signInWithGoogleParameters, "signInWithGoogleParameters");
        this.credentialManager = credentialManager;
        this.signInWithGoogleParameters = signInWithGoogleParameters;
    }

    /* JADX INFO: compiled from: GoogleSignInProvider.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/google/GoogleSignInProvider$Companion;", "", "()V", "TAG", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/internal/msafederation/google/GoogleSignInProvider;", "parameters", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleParameters;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GoogleSignInProvider create(SignInWithGoogleParameters parameters) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            CredentialManager.Companion companion = CredentialManager.INSTANCE;
            Context applicationContext = parameters.getActivity$common_distRelease().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "parameters.activity.applicationContext");
            return new GoogleSignInProvider(companion.create(applicationContext), parameters);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.microsoft.identity.common.internal.msafederation.IMsaFederatedSignInProvider
    /* JADX INFO: renamed from: signIn-IoAF18A */
    public Object mo13844signInIoAF18A(Continuation<? super Result<SignInWithGoogleCredential>> continuation) {
        GoogleSignInProvider$signIn$1 googleSignInProvider$signIn$1;
        if (continuation instanceof GoogleSignInProvider$signIn$1) {
            googleSignInProvider$signIn$1 = (GoogleSignInProvider$signIn$1) continuation;
            if ((googleSignInProvider$signIn$1.label & Integer.MIN_VALUE) != 0) {
                googleSignInProvider$signIn$1.label -= Integer.MIN_VALUE;
            } else {
                googleSignInProvider$signIn$1 = new GoogleSignInProvider$signIn$1(this, continuation);
            }
        } else {
            googleSignInProvider$signIn$1 = new GoogleSignInProvider$signIn$1(this, continuation);
        }
        Object obj = googleSignInProvider$signIn$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleSignInProvider$signIn$1.label;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        if (this.signInWithGoogleParameters.getUseBottomSheet$common_distRelease()) {
            googleSignInProvider$signIn$1.label = 1;
            Object objM13850signInWithGoogleBottomSheetIoAF18A = m13850signInWithGoogleBottomSheetIoAF18A(googleSignInProvider$signIn$1);
            if (objM13850signInWithGoogleBottomSheetIoAF18A != coroutine_suspended) {
                return objM13850signInWithGoogleBottomSheetIoAF18A;
            }
        } else {
            googleSignInProvider$signIn$1.label = 2;
            Object objM13849signInWithGoogleIoAF18A = m13849signInWithGoogleIoAF18A(googleSignInProvider$signIn$1);
            if (objM13849signInWithGoogleIoAF18A != coroutine_suspended) {
                return objM13849signInWithGoogleIoAF18A;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: signInWithGoogleBottomSheet-IoAF18A, reason: not valid java name */
    public final Object m13850signInWithGoogleBottomSheetIoAF18A(Continuation<? super Result<SignInWithGoogleCredential>> continuation) {
        GoogleSignInProvider$signInWithGoogleBottomSheet$1 googleSignInProvider$signInWithGoogleBottomSheet$1;
        if (continuation instanceof GoogleSignInProvider$signInWithGoogleBottomSheet$1) {
            googleSignInProvider$signInWithGoogleBottomSheet$1 = (GoogleSignInProvider$signInWithGoogleBottomSheet$1) continuation;
            if ((googleSignInProvider$signInWithGoogleBottomSheet$1.label & Integer.MIN_VALUE) != 0) {
                googleSignInProvider$signInWithGoogleBottomSheet$1.label -= Integer.MIN_VALUE;
            } else {
                googleSignInProvider$signInWithGoogleBottomSheet$1 = new GoogleSignInProvider$signInWithGoogleBottomSheet$1(this, continuation);
            }
        } else {
            googleSignInProvider$signInWithGoogleBottomSheet$1 = new GoogleSignInProvider$signInWithGoogleBottomSheet$1(this, continuation);
        }
        Object obj = googleSignInProvider$signInWithGoogleBottomSheet$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleSignInProvider$signInWithGoogleBottomSheet$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        GetCustomCredentialOption getCustomCredentialOptionBuild = new GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(false).setServerClientId(this.signInWithGoogleParameters.getServerClientId$common_distRelease()).setAutoSelectEnabled(false).setNonce(generateNonce$default(this, 0, 1, null)).build();
        googleSignInProvider$signInWithGoogleBottomSheet$1.label = 1;
        Object objM13848getCredentialgIAlus = m13848getCredentialgIAlus(getCustomCredentialOptionBuild, googleSignInProvider$signInWithGoogleBottomSheet$1);
        return objM13848getCredentialgIAlus == coroutine_suspended ? coroutine_suspended : objM13848getCredentialgIAlus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: signInWithGoogle-IoAF18A, reason: not valid java name */
    public final Object m13849signInWithGoogleIoAF18A(Continuation<? super Result<SignInWithGoogleCredential>> continuation) {
        GoogleSignInProvider$signInWithGoogle$1 googleSignInProvider$signInWithGoogle$1;
        if (continuation instanceof GoogleSignInProvider$signInWithGoogle$1) {
            googleSignInProvider$signInWithGoogle$1 = (GoogleSignInProvider$signInWithGoogle$1) continuation;
            if ((googleSignInProvider$signInWithGoogle$1.label & Integer.MIN_VALUE) != 0) {
                googleSignInProvider$signInWithGoogle$1.label -= Integer.MIN_VALUE;
            } else {
                googleSignInProvider$signInWithGoogle$1 = new GoogleSignInProvider$signInWithGoogle$1(this, continuation);
            }
        } else {
            googleSignInProvider$signInWithGoogle$1 = new GoogleSignInProvider$signInWithGoogle$1(this, continuation);
        }
        Object obj = googleSignInProvider$signInWithGoogle$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleSignInProvider$signInWithGoogle$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        GetCustomCredentialOption getCustomCredentialOptionBuild = new GetSignInWithGoogleOption.Builder(this.signInWithGoogleParameters.getServerClientId$common_distRelease()).setNonce(generateNonce$default(this, 0, 1, null)).build();
        googleSignInProvider$signInWithGoogle$1.label = 1;
        Object objM13848getCredentialgIAlus = m13848getCredentialgIAlus(getCustomCredentialOptionBuild, googleSignInProvider$signInWithGoogle$1);
        return objM13848getCredentialgIAlus == coroutine_suspended ? coroutine_suspended : objM13848getCredentialgIAlus;
    }

    @Override // com.microsoft.identity.common.internal.msafederation.IMsaFederatedSignInProvider
    public Object signOut(Continuation<? super Unit> continuation) {
        Object objClearCredentialState = this.credentialManager.clearCredentialState(new ClearCredentialStateRequest(), continuation);
        return objClearCredentialState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objClearCredentialState : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x00a7 A[Catch: GetCredentialException -> 0x0157, GetCredentialCustomException -> 0x01bd, TryCatch #5 {GetCredentialCustomException -> 0x01bd, GetCredentialException -> 0x0157, blocks: (B:27:0x009d, B:29:0x00a7, B:31:0x00b3, B:34:0x00c0, B:36:0x00e6, B:39:0x0101, B:41:0x012d, B:24:0x0083), top: B:60:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x012d A[Catch: GetCredentialException -> 0x0157, GetCredentialCustomException -> 0x01bd, TRY_LEAVE, TryCatch #5 {GetCredentialCustomException -> 0x01bd, GetCredentialException -> 0x0157, blocks: (B:27:0x009d, B:29:0x00a7, B:31:0x00b3, B:34:0x00c0, B:36:0x00e6, B:39:0x0101, B:41:0x012d, B:24:0x0083), top: B:60:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX INFO: renamed from: getCredential-gIAlu-s, reason: not valid java name */
    public final Object m13848getCredentialgIAlus(GetCustomCredentialOption getCustomCredentialOption, Continuation<? super Result<SignInWithGoogleCredential>> continuation) {
        GoogleSignInProvider$getCredential$1 googleSignInProvider$getCredential$1;
        String str;
        String str2;
        Credential credential;
        GoogleSignInProvider googleSignInProvider = this;
        GetCustomCredentialOption getCustomCredentialOption2 = getCustomCredentialOption;
        if (continuation instanceof GoogleSignInProvider$getCredential$1) {
            googleSignInProvider$getCredential$1 = (GoogleSignInProvider$getCredential$1) continuation;
            if ((googleSignInProvider$getCredential$1.label & Integer.MIN_VALUE) != 0) {
                googleSignInProvider$getCredential$1.label -= Integer.MIN_VALUE;
            } else {
                googleSignInProvider$getCredential$1 = new GoogleSignInProvider$getCredential$1(googleSignInProvider, continuation);
            }
        } else {
            googleSignInProvider$getCredential$1 = new GoogleSignInProvider$getCredential$1(googleSignInProvider, continuation);
        }
        Object credential2 = googleSignInProvider$getCredential$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleSignInProvider$getCredential$1.label;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(credential2);
                return ((Result) credential2).getValue();
            }
            str2 = (String) googleSignInProvider$getCredential$1.L$2;
            getCustomCredentialOption2 = (GetCustomCredentialOption) googleSignInProvider$getCredential$1.L$1;
            GoogleSignInProvider googleSignInProvider2 = (GoogleSignInProvider) googleSignInProvider$getCredential$1.L$0;
            try {
                ResultKt.throwOnFailure(credential2);
                str = str2;
                credential = ((GetCredentialResponse) credential2).getCredential();
                if (credential instanceof CustomCredential) {
                    if (!Intrinsics.areEqual(credential.getType(), GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) && !Intrinsics.areEqual(credential.getType(), GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_SIWG_CREDENTIAL)) {
                        String str3 = "Unsupported credential type, " + credential.getType();
                        Logger.warn(str, str3);
                        ClientException clientException = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, str3);
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m14780constructorimpl(ResultKt.createFailure(clientException));
                    }
                    try {
                        GoogleIdTokenCredential googleIdTokenCredentialCreateFrom = GoogleIdTokenCredential.INSTANCE.createFrom(credential.getData());
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m14780constructorimpl(new SignInWithGoogleCredential(googleIdTokenCredentialCreateFrom.getZzb()));
                    } catch (GoogleIdTokenParsingException e) {
                        Logger.warn(str, "Error parsing Google ID Token, " + e + ".message");
                        ClientException clientException2 = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, e.getMessage(), e);
                        Result.Companion companion3 = Result.INSTANCE;
                        return Result.m14780constructorimpl(ResultKt.createFailure(clientException2));
                    }
                }
                String str4 = "Unexpected credential type" + credential.getClass().getSimpleName();
                Logger.warn(str, str4);
                ClientException clientException3 = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, str4);
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m14780constructorimpl(ResultKt.createFailure(clientException3));
            } catch (GetCredentialCustomException e2) {
                e = e2;
                Logger.warn(str2, "Error getting google id token credential, " + e + ".type, " + e + ".message");
                ClientException clientException4 = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, e.getMessage(), e);
                clientException4.setSubErrorCode(e.getType());
                Result.Companion companion5 = Result.INSTANCE;
                return Result.m14780constructorimpl(ResultKt.createFailure(clientException4));
            } catch (GetCredentialException e3) {
                e = e3;
                str = str2;
                googleSignInProvider = googleSignInProvider2;
                if (!(e instanceof NoCredentialException)) {
                }
                Logger.warn(str, "Error getting google id token credential, " + e + ".javaClass.simpleName, " + e + ".message");
                ClientException clientException5 = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, e.getMessage(), e);
                Result.Companion companion6 = Result.INSTANCE;
                return Result.m14780constructorimpl(ResultKt.createFailure(clientException5));
            }
        }
        ResultKt.throwOnFailure(credential2);
        str = "GoogleSignInProvider:getCredential";
        GetCredentialRequest getCredentialRequestBuild = new GetCredentialRequest.Builder().addCredentialOption(getCustomCredentialOption2).build();
        try {
            CredentialManager credentialManager = googleSignInProvider.credentialManager;
            Activity activity$common_distRelease = googleSignInProvider.signInWithGoogleParameters.getActivity$common_distRelease();
            googleSignInProvider$getCredential$1.L$0 = googleSignInProvider;
            googleSignInProvider$getCredential$1.L$1 = getCustomCredentialOption2;
            googleSignInProvider$getCredential$1.L$2 = "GoogleSignInProvider:getCredential";
            googleSignInProvider$getCredential$1.label = 1;
            credential2 = credentialManager.getCredential(activity$common_distRelease, getCredentialRequestBuild, googleSignInProvider$getCredential$1);
            if (credential2 == coroutine_suspended) {
            }
            credential = ((GetCredentialResponse) credential2).getCredential();
            if (credential instanceof CustomCredential) {
                if (!Intrinsics.areEqual(credential.getType(), GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
                    String str5 = "Unsupported credential type, " + credential.getType();
                    Logger.warn(str, str5);
                    ClientException clientException6 = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, str5);
                    Result.Companion companion7 = Result.INSTANCE;
                    return Result.m14780constructorimpl(ResultKt.createFailure(clientException6));
                }
                GoogleIdTokenCredential googleIdTokenCredentialCreateFrom2 = GoogleIdTokenCredential.INSTANCE.createFrom(credential.getData());
                Result.Companion companion8 = Result.INSTANCE;
                return Result.m14780constructorimpl(new SignInWithGoogleCredential(googleIdTokenCredentialCreateFrom2.getZzb()));
            }
            String str6 = "Unexpected credential type" + credential.getClass().getSimpleName();
            Logger.warn(str, str6);
            ClientException clientException7 = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, str6);
            Result.Companion companion9 = Result.INSTANCE;
            return Result.m14780constructorimpl(ResultKt.createFailure(clientException7));
        } catch (GetCredentialCustomException e4) {
            e = e4;
            str2 = "GoogleSignInProvider:getCredential";
            Logger.warn(str2, "Error getting google id token credential, " + e + ".type, " + e + ".message");
            ClientException clientException8 = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, e.getMessage(), e);
            clientException8.setSubErrorCode(e.getType());
            Result.Companion companion10 = Result.INSTANCE;
            return Result.m14780constructorimpl(ResultKt.createFailure(clientException8));
        } catch (GetCredentialException e5) {
            e = e5;
            if (!(e instanceof NoCredentialException) && (getCustomCredentialOption2 instanceof GetGoogleIdOption)) {
                Logger.info(str, "Not credentials found.. allow adding new account, " + e + ".message");
                googleSignInProvider$getCredential$1.L$0 = null;
                googleSignInProvider$getCredential$1.L$1 = null;
                googleSignInProvider$getCredential$1.L$2 = null;
                googleSignInProvider$getCredential$1.label = 2;
                Object objM13849signInWithGoogleIoAF18A = googleSignInProvider.m13849signInWithGoogleIoAF18A(googleSignInProvider$getCredential$1);
                if (objM13849signInWithGoogleIoAF18A != coroutine_suspended) {
                    return objM13849signInWithGoogleIoAF18A;
                }
            } else {
                Logger.warn(str, "Error getting google id token credential, " + e + ".javaClass.simpleName, " + e + ".message");
                ClientException clientException9 = new ClientException(ClientException.SIGN_IN_WITH_GOOGLE_FAILED, e.getMessage(), e);
                Result.Companion companion11 = Result.INSTANCE;
                return Result.m14780constructorimpl(ResultKt.createFailure(clientException9));
            }
        }
        return coroutine_suspended;
    }

    static /* synthetic */ String generateNonce$default(GoogleSignInProvider googleSignInProvider, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 16;
        }
        return googleSignInProvider.generateNonce(i);
    }

    private final String generateNonce(int size) {
        byte[] bArr = new byte[size];
        new SecureRandom().nextBytes(bArr);
        return Base64Util.INSTANCE.encodeUrlSafeString(bArr);
    }
}
