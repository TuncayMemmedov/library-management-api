package task.gpt123.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String copyCode;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private BigDecimal book;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookies;
}
