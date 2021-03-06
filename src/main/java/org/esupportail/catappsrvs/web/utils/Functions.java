package org.esupportail.catappsrvs.web.utils;

import fj.F;
import fj.data.List;
import fj.data.NonEmptyList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;

import static fj.Monoid.stringMonoid;
import static fj.data.Array.array;
import static java.lang.String.format;
import static javax.ws.rs.core.Response.Status;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Functions {

    public static final F<String[],List<String>> arrayToList = new F<String[], List<String>>() {
        public List<String> f(String[] strings) {
            return array(strings).toList();
        }
    };

    public static final F<NonEmptyList<String>, Exception> fieldsException = new F<NonEmptyList<String>, Exception>() {
        public Exception f(NonEmptyList<String> errors) {
            return new ValidationError("Les champs suivants ont des valeurs incorrectes :\n- " + stringMonoid.join(errors, "\n- "));
        }
    };

    public static F<NonEmptyList<Exception>, Response> errorResponse(final String msg) {
        return new F<NonEmptyList<Exception>, Response>() {
            public Response f(NonEmptyList<Exception> exceptions) {
                for (Exception e : exceptions)
                      log.error(msg, e);
                final Status status = exceptions.head instanceof ValidationError
                        ? Status.BAD_REQUEST
                        : Status.INTERNAL_SERVER_ERROR;
                return Response.status(status).entity(format("{\"erreur\": \"%s\"}", msg)).build();
            }
        };
    }
}
