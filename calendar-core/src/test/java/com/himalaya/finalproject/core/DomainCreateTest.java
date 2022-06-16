package com.himalaya.finalproject.core;

import com.himalaya.finalproject.core.domain.Engagement;
import com.himalaya.finalproject.core.domain.Event;
import com.himalaya.finalproject.core.domain.RequestStatus;
import com.himalaya.finalproject.core.domain.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class DomainCreateTest {

    @Test
    public void eventCreated() throws Exception {
        //given
        final User writer = new User("writer", "email@email", "pw", LocalDate.now(), LocalDateTime.now());
        final User attendee = new User("attendee", "email@email", "pw", LocalDate.now(), LocalDateTime.now());
        final Event event = new Event(
                LocalDateTime.now(),
                LocalDateTime.now(),
                "title",
                "description",
                writer,
                LocalDateTime.now()
        );
        event.addEngagement(new Engagement(event, attendee, LocalDateTime.now(), RequestStatus.REQUESTED));
        //when

        //then
        then(event.getEngagements().get(0).getEvent().getWriter().getName()).isEqualTo("writer");
    }
}
