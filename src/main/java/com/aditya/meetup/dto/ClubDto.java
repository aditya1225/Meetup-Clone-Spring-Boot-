package com.aditya.meetup.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubDto {


        private int Id;
        @NotEmpty(message = "Title should not be empty")
        private String title;
        @NotEmpty(message = "PhotoUrl should not be empty")
        private String photoUrl;
        @NotEmpty(message = "Content should not be empty")
        private String content;

        private LocalDateTime createdOn;

        private LocalDateTime updatedOn;

        private List<EventDto> events;


}
