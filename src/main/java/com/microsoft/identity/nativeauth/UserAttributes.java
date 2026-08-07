package com.microsoft.identity.nativeauth;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAttributes.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/nativeauth/UserAttributes;", "", "userAttributes", "", "", "(Ljava/util/Map;)V", "getUserAttributes$msal_distRelease", "()Ljava/util/Map;", "Builder", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserAttributes {
    private final Map<String, String> userAttributes;

    public UserAttributes(Map<String, String> userAttributes) {
        Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
        this.userAttributes = userAttributes;
    }

    public final Map<String, String> getUserAttributes$msal_distRelease() {
        return this.userAttributes;
    }

    /* JADX INFO: compiled from: UserAttributes.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/nativeauth/UserAttributes$Builder;", "", "()V", "userAttributes", "", "", "build", "Lcom/microsoft/identity/nativeauth/UserAttributes;", "city", "country", "customAttribute", "key", "value", Builder.DISPLAY_NAME, Builder.GIVEN_NAME, Builder.JOB_TITLE, "postalCode", "state", "streetAddress", Builder.SURNAME, "Companion", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private static final String CITY = "city";
        private static final String COUNTRY = "country";
        private static final String DISPLAY_NAME = "displayName";
        private static final String GIVEN_NAME = "givenName";
        private static final String JOB_TITLE = "jobTitle";
        private static final String POSTAL_CODE = "postalCode";
        private static final String STATE = "state";
        private static final String STREET_ADDRESS = "streetAddress";
        private static final String SURNAME = "surname";
        private final Map<String, String> userAttributes = new LinkedHashMap();

        public final Builder city(String city) {
            Intrinsics.checkNotNullParameter(city, "city");
            this.userAttributes.put("city", city);
            return this;
        }

        public final Builder country(String country) {
            Intrinsics.checkNotNullParameter(country, "country");
            this.userAttributes.put("country", country);
            return this;
        }

        public final Builder displayName(String displayName) {
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            this.userAttributes.put(DISPLAY_NAME, displayName);
            return this;
        }

        public final Builder givenName(String givenName) {
            Intrinsics.checkNotNullParameter(givenName, "givenName");
            this.userAttributes.put(GIVEN_NAME, givenName);
            return this;
        }

        public final Builder jobTitle(String jobTitle) {
            Intrinsics.checkNotNullParameter(jobTitle, "jobTitle");
            this.userAttributes.put(JOB_TITLE, jobTitle);
            return this;
        }

        public final Builder postalCode(String postalCode) {
            Intrinsics.checkNotNullParameter(postalCode, "postalCode");
            this.userAttributes.put("postalCode", postalCode);
            return this;
        }

        public final Builder state(String state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.userAttributes.put("state", state);
            return this;
        }

        public final Builder streetAddress(String streetAddress) {
            Intrinsics.checkNotNullParameter(streetAddress, "streetAddress");
            this.userAttributes.put("streetAddress", streetAddress);
            return this;
        }

        public final Builder surname(String surname) {
            Intrinsics.checkNotNullParameter(surname, "surname");
            this.userAttributes.put(SURNAME, surname);
            return this;
        }

        public final Builder customAttribute(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.userAttributes.put(key, value);
            return this;
        }

        public final UserAttributes build() {
            return new UserAttributes(this.userAttributes);
        }
    }
}
