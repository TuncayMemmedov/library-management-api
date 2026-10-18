package task.gpt123.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.gpt123.entity.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
}
