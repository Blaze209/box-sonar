package com.microsoft.identity.common.internal.fido;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FidoChallengeField.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0018B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\t\u0010\n\u001a\u00020\u0004HÂ\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00018\u0000HÂ\u0003¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u00000\u0007HÂ\u0003JH\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u00000\u0007HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;", "K", "", "field", "Lcom/microsoft/identity/common/internal/fido/FidoRequestField;", "value", "throwIfInvalid", "Lkotlin/Function2;", "(Lcom/microsoft/identity/common/internal/fido/FidoRequestField;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Ljava/lang/Object;", "component1", "component2", "()Ljava/lang/Object;", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/microsoft/identity/common/internal/fido/FidoRequestField;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lcom/microsoft/identity/common/internal/fido/FidoChallengeField;", "equals", "", "other", "getOrThrow", "hashCode", "", "toString", "", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FidoChallengeField<K> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final FidoRequestField field;
    private final Function2<FidoRequestField, K, K> throwIfInvalid;
    private final K value;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final FidoRequestField getField() {
        return this.field;
    }

    private final K component2() {
        return this.value;
    }

    private final Function2<FidoRequestField, K, K> component3() {
        return this.throwIfInvalid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FidoChallengeField copy$default(FidoChallengeField fidoChallengeField, FidoRequestField fidoRequestField, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 1) != 0) {
            fidoRequestField = fidoChallengeField.field;
        }
        if ((i & 2) != 0) {
            obj = fidoChallengeField.value;
        }
        if ((i & 4) != 0) {
            function2 = fidoChallengeField.throwIfInvalid;
        }
        return fidoChallengeField.copy(fidoRequestField, obj, function2);
    }

    @JvmStatic
    public static final List<String> throwIfInvalidOptionalListParameter(FidoRequestField fidoRequestField, List<String> list) throws ClientException {
        return INSTANCE.throwIfInvalidOptionalListParameter(fidoRequestField, list);
    }

    @JvmStatic
    public static final String throwIfInvalidProtocolVersion(FidoRequestField fidoRequestField, String str) throws ClientException {
        return INSTANCE.throwIfInvalidProtocolVersion(fidoRequestField, str);
    }

    @JvmStatic
    public static final String throwIfInvalidRelyingPartyIdentifier(FidoRequestField fidoRequestField, String str) throws ClientException {
        return INSTANCE.throwIfInvalidRelyingPartyIdentifier(fidoRequestField, str);
    }

    @JvmStatic
    public static final String throwIfInvalidRequiredParameter(FidoRequestField fidoRequestField, String str) throws ClientException {
        return INSTANCE.throwIfInvalidRequiredParameter(fidoRequestField, str);
    }

    @JvmStatic
    public static final String throwIfInvalidSubmitUrl(FidoRequestField fidoRequestField, String str) throws ClientException {
        return INSTANCE.throwIfInvalidSubmitUrl(fidoRequestField, str);
    }

    public final FidoChallengeField<K> copy(FidoRequestField field, K value, Function2<? super FidoRequestField, ? super K, ? extends K> throwIfInvalid) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(throwIfInvalid, "throwIfInvalid");
        return new FidoChallengeField<>(field, value, throwIfInvalid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FidoChallengeField)) {
            return false;
        }
        FidoChallengeField fidoChallengeField = (FidoChallengeField) other;
        return this.field == fidoChallengeField.field && Intrinsics.areEqual(this.value, fidoChallengeField.value) && Intrinsics.areEqual(this.throwIfInvalid, fidoChallengeField.throwIfInvalid);
    }

    public int hashCode() {
        int iHashCode = this.field.hashCode() * 31;
        K k = this.value;
        return ((iHashCode + (k == null ? 0 : k.hashCode())) * 31) + this.throwIfInvalid.hashCode();
    }

    public String toString() {
        return "FidoChallengeField(field=" + this.field + ", value=" + this.value + ", throwIfInvalid=" + this.throwIfInvalid + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FidoChallengeField(FidoRequestField field, K k, Function2<? super FidoRequestField, ? super K, ? extends K> throwIfInvalid) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(throwIfInvalid, "throwIfInvalid");
        this.field = field;
        this.value = k;
        this.throwIfInvalid = throwIfInvalid;
    }

    public final K getOrThrow() throws ClientException {
        return this.throwIfInvalid.invoke(this.field, this.value);
    }

    /* JADX INFO: compiled from: FidoChallengeField.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/FidoChallengeField$Companion;", "", "()V", "throwIfInvalidOptionalListParameter", "", "", "field", "Lcom/microsoft/identity/common/internal/fido/FidoRequestField;", "value", "throwIfInvalidProtocolVersion", "throwIfInvalidRelyingPartyIdentifier", "throwIfInvalidRequiredParameter", "throwIfInvalidSubmitUrl", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String throwIfInvalidRequiredParameter(FidoRequestField field, String value) throws ClientException {
            Intrinsics.checkNotNullParameter(field, "field");
            if (value == null) {
                throw new ClientException(ClientException.PASSKEY_PROTOCOL_REQUEST_PARSING_ERROR, field.getFieldName() + " not provided");
            }
            if (StringsKt.isBlank(value)) {
                throw new ClientException(ClientException.PASSKEY_PROTOCOL_REQUEST_PARSING_ERROR, field.getFieldName() + " is empty");
            }
            return value;
        }

        @JvmStatic
        public final String throwIfInvalidSubmitUrl(FidoRequestField field, String value) throws ClientException {
            Intrinsics.checkNotNullParameter(field, "field");
            String strThrowIfInvalidRequiredParameter = throwIfInvalidRequiredParameter(field, value);
            try {
                new URL(strThrowIfInvalidRequiredParameter);
                return strThrowIfInvalidRequiredParameter;
            } catch (MalformedURLException unused) {
                throw new ClientException(ClientException.PASSKEY_PROTOCOL_REQUEST_PARSING_ERROR, "submitUrl value is malformed.");
            }
        }

        @JvmStatic
        public final String throwIfInvalidRelyingPartyIdentifier(FidoRequestField field, String value) throws ClientException {
            Intrinsics.checkNotNullParameter(field, "field");
            return StringsKt.removePrefix(throwIfInvalidRequiredParameter(field, value), (CharSequence) AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX);
        }

        @JvmStatic
        public final String throwIfInvalidProtocolVersion(FidoRequestField field, String value) throws ClientException {
            Intrinsics.checkNotNullParameter(field, "field");
            String strThrowIfInvalidRequiredParameter = throwIfInvalidRequiredParameter(field, value);
            if (FidoConstants.INSTANCE.getSupportedPasskeyProtocolVersions().contains(strThrowIfInvalidRequiredParameter)) {
                return strThrowIfInvalidRequiredParameter;
            }
            throw new ClientException(ClientException.PASSKEY_PROTOCOL_REQUEST_PARSING_ERROR, "Passkey protocol version '" + strThrowIfInvalidRequiredParameter + "' is not supported. Supported versions: " + CollectionsKt.joinToString$default(FidoConstants.INSTANCE.getSupportedPasskeyProtocolVersions(), null, null, null, 0, null, null, 63, null));
        }

        @JvmStatic
        public final List<String> throwIfInvalidOptionalListParameter(FidoRequestField field, List<String> value) throws ClientException {
            Intrinsics.checkNotNullParameter(field, "field");
            if (value == null || !(value.isEmpty() || Intrinsics.areEqual(CollectionsKt.first((List) value), ""))) {
                return value;
            }
            throw new ClientException(ClientException.PASSKEY_PROTOCOL_REQUEST_PARSING_ERROR, field.getFieldName() + " is empty");
        }
    }
}
