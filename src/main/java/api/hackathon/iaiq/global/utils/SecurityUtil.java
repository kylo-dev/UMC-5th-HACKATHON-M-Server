package api.hackathon.iaiq.global.utils;

import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import org.hibernate.Hibernate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static Member getCurrentMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new ApiException(ErrorType._UNAUTHORIZED);
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof Member) {
            return (Member) principal;
        }

        throw new ApiException(ErrorType._USER_NOT_FOUND_DB);
    }
}
