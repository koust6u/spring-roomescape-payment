package roomescape.reservation.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

import roomescape.member.domain.Member;
import roomescape.reservation.domain.Reservation;
import roomescape.reservation.domain.ReservationTime;
import roomescape.reservation.domain.Status;
import roomescape.reservation.domain.Theme;

public record ReservationCreateRequest(
        @NotNull LocalDate date,
        @NotNull Long themeId,
        @NotNull Long timeId,
        @NotNull String paymentKey,
        @NotNull String orderId,
        @NotNull Long amount,
        @NotNull String paymentType
) {

    public Reservation toReservation(Member member, Theme theme, ReservationTime reservationTime, Status status) {
        return new Reservation(member, date, theme, reservationTime, status);
    }
}
