package com.example.pair5lms.services.dtos.responses.booklocation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeleteBookLocationResponse {
    private int id;

    private int bookId;

    private boolean isAvailable;

    private LocalDateTime addedDate;
}
