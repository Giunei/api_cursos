package br.com.giunei.api_cursos.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String category;

    @Enumerated(EnumType.STRING)
    private Status active;

    @CurrentTimestamp
    private OffsetDateTime created_at;

    @UpdateTimestamp
    private OffsetDateTime updated_at;
}
