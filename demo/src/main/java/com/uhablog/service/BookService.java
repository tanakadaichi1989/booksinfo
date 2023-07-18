package com.uhablog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhablog.form.BookForm;
import com.uhablog.form.EditBookForm;
import com.uhablog.model.Book;
import com.uhablog.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {
	@Autowired
	BookRepository repository;
	
	public List<Book> findAll(){
		return repository.findAll();
	}
	
	public void intsert(BookForm bookForm) {
		Book book = new Book();
		
		book.setTitle(bookForm.getTitle());
		book.setPrice(bookForm.getPrice());
		repository.save(book);
	}
	
	public EditBookForm getOneBook(Integer id) {
		Book book = repository.findById(id).orElseThrow();
		EditBookForm editBook = new EditBookForm();
		editBook.setId(book.getId());
		editBook.setTitle(book.getTitle());
		editBook.setPrice(book.getPrice());
		return editBook;
	}
	
	public void update(EditBookForm editBook) {
		Book book = new Book();
		book.setId(editBook.getId());
		book.setTitle(editBook.getTitle());
		book.setPrice(editBook.getPrice());
		repository.save(book);
	}

	public void delete(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteById(id);
	}
}
