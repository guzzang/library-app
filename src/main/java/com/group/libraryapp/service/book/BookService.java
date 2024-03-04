package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }


    @Transactional
    public void loanBook(BookLoanRequest request) {

        // 1. 책 정보를 가져온다.
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalAccessError::new);

        // 2. 대출기록 확인해서 대출중인지 확인
        // 3. 확인했는데 대출중이면 에러 발생시킴

        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException();
        }

        // 4. 유저 정보를 가져온다. (1번 책 정보를 가져오는 방식과 동일)
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalAccessError::new);
        user.loanBook(book.getName());

    }

    @Transactional
    public void returnBook(BookReturnRequest request) {

        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        user.returnBook(request.getBookName());
    }


}
