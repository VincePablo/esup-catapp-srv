package org.esupportail.catappsrvs.model;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static fj.Bottom.error;

@SuppressWarnings("Lombok")
public final class CommonTypes {
    private CommonTypes() { throw error("Unsupported"); }

    @Embeddable @EqualsAndHashCode @ToString
    @RequiredArgsConstructor(staticName = "code")
    public static final class Code {
        @Column(name = "code") private final String value;
        private Code() { value = null; } // for hibernate
        public String value() { return value; }
    }

    @Embeddable @EqualsAndHashCode @ToString
    @RequiredArgsConstructor(staticName = "caption")
    public static final class Caption {
        @Column(name = "caption") private final String value;
        private Caption() { value = null; }
        public String value() { return value; }
    }

    @Embeddable @EqualsAndHashCode @ToString
    @RequiredArgsConstructor(staticName = "title")
    public static final class Title {
        @Column(name = "title") private final String value;
        private Title() { value = null; }
        public String value() { return value; }
    }

    @Embeddable @EqualsAndHashCode @ToString
    @RequiredArgsConstructor(staticName = "description")
    public static final class Description {
        @Column(name = "description") private final String value;
        private Description() { value = null; }
        public String value() { return value; }
    }

    @Embeddable @EqualsAndHashCode @ToString
    @RequiredArgsConstructor(staticName = "ldapGroup")
    public static final class LdapGroup {
        @Column(name = "ldapgroup") private final String value;
        private LdapGroup() { value = null; }
        public String value() { return value; }
    }
}
