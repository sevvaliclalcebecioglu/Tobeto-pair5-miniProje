package com.example.pair5lms.services.dtos.responses.booklocation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddBookLocationResponse {
    private int id;

    private boolean isAvailable;

    private LocalDateTime addedDate;
}
