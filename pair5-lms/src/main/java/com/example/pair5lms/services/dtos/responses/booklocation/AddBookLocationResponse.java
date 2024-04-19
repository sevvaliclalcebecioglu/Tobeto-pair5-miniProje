package com.example.pair5lms.services.dtos.responses.booklocation;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookLocationResponse {
    private int id;

    private String bookName;

    private boolean isAvailable;

    private LocalDateTime addedDate;
}
