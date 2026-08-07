package com.microsoft.identity.nativeauth;

import androidx.media3.common.MimeTypes;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.nativeauth.parameters.NativeAuthResetPasswordParameters;
import com.microsoft.identity.nativeauth.parameters.NativeAuthSignInParameters;
import com.microsoft.identity.nativeauth.parameters.NativeAuthSignUpParameters;
import com.microsoft.identity.nativeauth.statemachine.results.GetAccountResult;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordStartResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpResult;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: INativeAuthPublicClientApplication.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001#J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\rH&J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\rH'J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0013H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0015H&J7\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ6\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u0015H'J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u001dH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001fH&J1\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H§@ø\u0001\u0000¢\u0006\u0002\u0010\"J0\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0006\u001a\u00020\u001fH'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/microsoft/identity/nativeauth/INativeAuthPublicClientApplication;", "Lcom/microsoft/identity/client/IPublicClientApplication;", "getCurrentAccount", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$GetCurrentAccountCallback;", "resetPassword", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "parameters", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthResetPasswordParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthResetPasswordParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$ResetPasswordCallback;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignInParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignInParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignInCallback;", "password", "", "scopes", "", "(Ljava/lang/String;[CLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignUpParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignUpParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignUpCallback;", NativeAuthConstants.GrantType.ATTRIBUTES, "Lcom/microsoft/identity/nativeauth/UserAttributes;", "(Ljava/lang/String;[CLcom/microsoft/identity/nativeauth/UserAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "INativeAuthApplicationCreatedListener", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface INativeAuthPublicClientApplication extends IPublicClientApplication {

    /* JADX INFO: compiled from: INativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/nativeauth/INativeAuthPublicClientApplication$INativeAuthApplicationCreatedListener;", "", "onCreated", "", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/microsoft/identity/nativeauth/INativeAuthPublicClientApplication;", "onError", "exception", "Lcom/microsoft/identity/client/exception/MsalException;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface INativeAuthApplicationCreatedListener {
        void onCreated(INativeAuthPublicClientApplication application);

        void onError(MsalException exception);
    }

    Object getCurrentAccount(Continuation<? super GetAccountResult> continuation);

    void getCurrentAccount(NativeAuthPublicClientApplication.GetCurrentAccountCallback callback);

    Object resetPassword(NativeAuthResetPasswordParameters nativeAuthResetPasswordParameters, Continuation<? super ResetPasswordStartResult> continuation);

    @Deprecated(message = "This method is now deprecated. Use the method 'resetPassword(parameters:)' instead.")
    Object resetPassword(String str, Continuation<? super ResetPasswordStartResult> continuation);

    void resetPassword(NativeAuthResetPasswordParameters parameters, NativeAuthPublicClientApplication.ResetPasswordCallback callback);

    @Deprecated(message = "This method is now deprecated. Use the method 'resetPassword(parameters:, callback:)' instead.")
    void resetPassword(String username, NativeAuthPublicClientApplication.ResetPasswordCallback callback);

    Object signIn(NativeAuthSignInParameters nativeAuthSignInParameters, Continuation<? super SignInResult> continuation);

    @Deprecated(message = "This method is now deprecated. Use the method 'signIn(parameters:)' instead.")
    Object signIn(String str, char[] cArr, List<String> list, Continuation<? super SignInResult> continuation);

    void signIn(NativeAuthSignInParameters parameters, NativeAuthPublicClientApplication.SignInCallback callback);

    @Deprecated(message = "This method is now deprecated. Use the method 'signIn(parameters:, callback:)' instead.")
    void signIn(String username, char[] password, List<String> scopes, NativeAuthPublicClientApplication.SignInCallback callback);

    Object signUp(NativeAuthSignUpParameters nativeAuthSignUpParameters, Continuation<? super SignUpResult> continuation);

    @Deprecated(message = "This method is now deprecated. Use the method 'signUp(parameters:)' instead.")
    Object signUp(String str, char[] cArr, UserAttributes userAttributes, Continuation<? super SignUpResult> continuation);

    void signUp(NativeAuthSignUpParameters parameters, NativeAuthPublicClientApplication.SignUpCallback callback);

    @Deprecated(message = "This method is now deprecated. Use the method 'signUp(parameters:, callback:)' instead.")
    void signUp(String username, char[] password, UserAttributes attributes, NativeAuthPublicClientApplication.SignUpCallback callback);

    /* JADX INFO: compiled from: INativeAuthPublicClientApplication.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object signIn$default(INativeAuthPublicClientApplication iNativeAuthPublicClientApplication, String str, char[] cArr, List list, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signIn");
            }
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                list = null;
            }
            return iNativeAuthPublicClientApplication.signIn(str, cArr, (List<String>) list, (Continuation<? super SignInResult>) continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void signIn$default(INativeAuthPublicClientApplication iNativeAuthPublicClientApplication, String str, char[] cArr, List list, NativeAuthPublicClientApplication.SignInCallback signInCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signIn");
            }
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                list = null;
            }
            iNativeAuthPublicClientApplication.signIn(str, cArr, (List<String>) list, signInCallback);
        }

        public static /* synthetic */ Object signUp$default(INativeAuthPublicClientApplication iNativeAuthPublicClientApplication, String str, char[] cArr, UserAttributes userAttributes, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signUp");
            }
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                userAttributes = null;
            }
            return iNativeAuthPublicClientApplication.signUp(str, cArr, userAttributes, (Continuation<? super SignUpResult>) continuation);
        }

        public static /* synthetic */ void signUp$default(INativeAuthPublicClientApplication iNativeAuthPublicClientApplication, String str, char[] cArr, UserAttributes userAttributes, NativeAuthPublicClientApplication.SignUpCallback signUpCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signUp");
            }
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                userAttributes = null;
            }
            iNativeAuthPublicClientApplication.signUp(str, cArr, userAttributes, signUpCallback);
        }
    }
}
