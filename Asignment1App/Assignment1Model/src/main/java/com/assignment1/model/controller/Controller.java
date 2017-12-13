package com.assignment1.model.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment1.model.service.AddressService;
import com.assignment1.model.service.AmazonBooksService;
import com.assignment1.model.service.AuthorService;
import com.assignment1.model.service.BookService;
import com.assignment1.model.service.CategoryService;
import com.assignment1.model.service.LibraryService;
import com.assignment1.model.service.MemberRequestService;
import com.assignment1.model.service.MemberService;
import com.assignment1common.model.Addresses;
import com.assignment1common.model.AmazonBooks;
import com.assignment1common.model.Authors;
import com.assignment1common.model.Books;
import com.assignment1common.model.Categories;
import com.assignment1common.model.Libraries;
import com.assignment1common.model.MemberRequests;
import com.assignment1common.model.Members;


//@RestController
public class Controller {

	@Autowired
	AddressService addressService;

	@Autowired
	AmazonBooksService amazonBookService;

	@Autowired
	MemberService memberService;

	@Autowired
	MemberRequestService memberRequestService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	AuthorService authorService;

	@Autowired
	LibraryService libraryService;

	@Autowired
	BookService bookService;

	@PostMapping("/saveAmazonBook")
	public ResponseEntity<Void> saveAmazonBook(@RequestBody AmazonBooks ab) {

		amazonBookService.saveAmazonBook(ab);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/saveAddress")
	public ResponseEntity<Void> saveAmazonBook(@RequestBody Addresses a) {

		addressService.saveAddress(a);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/saveMember")
	public ResponseEntity<Void> saveAmazonBook(@RequestBody Members m) {

		memberService.saveMember(m);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/saveMemberRequest")
	public ResponseEntity<Void> saveMemberRequest(@RequestBody MemberRequests mr) {

		memberRequestService.saveMemberRequest(mr);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/saveCategory")
	public ResponseEntity<Void> saveCategory(@RequestBody Categories c) {

		categoryService.saveCategory(c);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/saveAuthor")
	public ResponseEntity<Void> saveAuthor(@RequestBody Authors a) {

		authorService.saveAuthor(a);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/saveBook")
	public ResponseEntity<Void> saveBook(@RequestBody Books b) {

		bookService.saveBook(b);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/saveLibary")
	public ResponseEntity<Void> saveLibary(@RequestBody Libraries l) {

		libraryService.saveLibrary(l);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/getAddressByID")
	public ResponseEntity<Addresses> getAddressByID(@RequestParam("id") int id) {
		Addresses a = addressService.getAdressById(id);
		if (a == null) {

			return new ResponseEntity<Addresses>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Addresses>(a, HttpStatus.OK);

	}

	@GetMapping("/getMemberByID")
	public ResponseEntity<Members> getMemberByID(@RequestParam("id") int id) {
		Members m = memberService.getMemberByID(id);
		if (m == null) {

			return new ResponseEntity<Members>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Members>(m, HttpStatus.OK);

	}

	@GetMapping("/getAllAuthor")
	public ResponseEntity<List<Authors>> getAllAuthor() {
		List<Authors> authorList = authorService.getAllAuthors();
		if (authorList.size() == 0) {

			return new ResponseEntity<List<Authors>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Authors>>(authorList, HttpStatus.OK);

	}
	
	@GetMapping("/getCategoryByID")
	public ResponseEntity<Categories> getCategoryByID(@RequestParam("id") int id) {
		Categories c = categoryService.getCategoryById(id);
		if (c == null) {

			return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Categories>(c, HttpStatus.OK);

	}

	@GetMapping("/getAuthorByID")
	public ResponseEntity<Authors> getAuthorByID(@RequestParam("id") int id) {
		Authors a = authorService.getAuthorByID(id);
		if (a == null) {

			return new ResponseEntity<Authors>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Authors>(a, HttpStatus.OK);

	}

	@PutMapping("/updateAddress")
	public ResponseEntity<Void> updateAddress(@RequestBody Addresses a) {

		addressService.saveAddress(a);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/deleteMember")
	public ResponseEntity<Void> deleteMember(@RequestParam("id") int id) {

		memberService.deleteMember(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
