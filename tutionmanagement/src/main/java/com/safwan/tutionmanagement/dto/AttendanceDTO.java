package com.safwan.tutionmanagement.dto;

import java.time.LocalDate;

public record AttendanceDTO(
        LocalDate date,
        Integer isPresent
) {}
