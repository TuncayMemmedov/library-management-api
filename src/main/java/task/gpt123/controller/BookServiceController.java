
package task.gpt123.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task.gpt123.dto.BookRequestDto;
import task.gpt123.dto.BookResponseDto;
import task.gpt123.entity.Book;
import task.gpt123.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookServiceController {

    private final BookService bookService;

    @PostMapping
    public BookResponseDto create(@RequestBody BookRequestDto dto) {
        return bookService.create(dto);
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public BookResponseDto update(
            @PathVariable Long id,
            @RequestBody BookRequestDto dto) {
        return bookService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
