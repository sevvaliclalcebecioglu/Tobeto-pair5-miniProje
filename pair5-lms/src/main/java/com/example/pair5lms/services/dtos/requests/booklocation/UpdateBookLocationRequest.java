package com.example.pair5lms.services.dtos.requests.booklocation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateBookLocationRequest {
    private int id;

    private boolean isAvailable;

    private LocalDateTime addedDate;
}
