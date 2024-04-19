package com.example.pair5lms.services.dtos.responses.booklocation;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListBookLocationResponse {

    public ListBookLocationResponse(int id, String bookName, boolean isAvailable) {
        this.id = id;
        this.bookName = bookName;
        this.isAvailable = isAvailable;
    }

    private int id;

    private String bookName;

    private boolean isAvailable;

    private LocalDateTime addedDate;
}
