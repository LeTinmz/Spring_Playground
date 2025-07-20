package org.example.playground.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.example.playground.utils.LogType;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.UUID;

@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Log {
    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    private LogType type;
    private UUID userId;

    private LocalDateTime timestamp;


}
