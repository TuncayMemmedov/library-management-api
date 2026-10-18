package task.gpt123.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.gpt123.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{


}
