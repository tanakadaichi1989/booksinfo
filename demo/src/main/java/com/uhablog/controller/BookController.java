// https://uha-blog.com/java/spring-boot-postgresql/#st-toc-h-6


package com.uhablog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uhablog.form.BookForm;
import com.uhablog.form.EditBookForm;
import com.uhablog.model.Book;
import com.uhablog.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/book-list")
	public String bookList(Model model) {
		List<Book> bookList = service.findAll();
		model.addAttribute("bookList",bookList);
		return "bookList";
	}
	
	@GetMapping("/book-create")
	public String createBook(Model model) {
		model.addAttribute("bookForm",new BookForm());
		return "add";
	}
	
	@PostMapping("/book-create")
	public String saveBook(@ModelAttribute @Validated BookForm bookForm,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			return "add";
		}
		
		service.intsert(bookForm);
		return "redirect:/book-list";
	}
	
	@GetMapping("/book-edit")
	public String editBook(Model model, EditBookForm editBook) {
		editBook = service.getOneBook(editBook.getId());
		model.addAttribute(editBook);
		return "edit";
	}
	
	@PostMapping("/book-edit")
	public String update(@ModelAttribute @Validated EditBookForm editBook,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "edit";
		}
		service.update(editBook);
		return "redirect:/book-list";
	}
	
	@GetMapping("/book-delete")
	public String deleteBook(Model model,Book book) {
		service.delete(book.getId());
		return "redirect:book-list";
	}
}
