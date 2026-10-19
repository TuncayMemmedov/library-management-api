package task.gpt123.mapper;

import task.gpt123.dto.BookRequestDto;
import task.gpt123.dto.BookResponseDto;
import task.gpt123.entity.Book;

public final class BookMapper {

    public static Book toEntity(BookRequestDto dto){

        return Book.builder().
                title(dto.getTitle()).
                author(dto.getAuthor()).
                price(dto.getPrice()).
                build();
    }

    public static BookResponseDto toResponse(Book book){

        return BookResponseDto.builder().
                title(book.getTitle()).
                author(book.getAuthor()).
                price(book.getPrice()).
                build();
    }
}
