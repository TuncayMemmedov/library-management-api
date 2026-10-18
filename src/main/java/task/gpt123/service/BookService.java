package task.gpt123.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import task.gpt123.dto.BookRequestDto;
import task.gpt123.dto.BookResponseDto;
import task.gpt123.entity.Book;
import task.gpt123.exception.BookNotFoundException;
import task.gpt123.repository.BookRepository;

@Service("/api/books")
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book createFindById(Long id){
        return bookRepository.findById(id).
                orElseThrow(() -> new BookNotFoundException("book not found"));
    }

}
