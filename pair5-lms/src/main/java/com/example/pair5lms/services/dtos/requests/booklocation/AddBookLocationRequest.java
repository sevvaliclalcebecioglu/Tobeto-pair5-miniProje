package com.example.pair5lms.services.dtos.requests.booklocation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddBookLocationRequest {
    private boolean isAvailable;

    private LocalDateTime addedDate;
}
