
package task.gpt123.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import task.gpt123.dto.BookRequestDto;
import task.gpt123.dto.BookResponseDto;
import task.gpt123.entity.Book;
import task.gpt123.exception.BookNotFoundException;
import task.gpt123.mapper.BookMapper;
import task.gpt123.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public BookResponseDto create(BookRequestDto dto) {
        Book book = BookMapper.toEntity(dto);

        Book savedBook = bookRepository.save(book);

        return BookMapper.toResponse(savedBook);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException("book not found"));
    }

    public BookResponseDto update(Long id, BookRequestDto dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException("book not found"));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());

        Book savedBook = bookRepository.save(book);

        return BookMapper.toResponse(savedBook);
    }

    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException("book not found"));

        bookRepository.delete(book);
    }
}
