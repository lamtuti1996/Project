package com.assignment1controller.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment1.model.service.AddressService;
import com.assignment1.model.service.AmazonBooksService;
import com.assignment1.model.service.AuthorService;
import com.assignment1.model.service.BookService;
import com.assignment1.model.service.CategoryService;
import com.assignment1.model.service.LibraryService;
import com.assignment1.model.service.MemberRequestService;
import com.assignment1.model.service.MemberService;
import com.assignment1common.entity.MemberMemberRequestBook;
import com.assignment1common.model.Addresses;
import com.assignment1common.model.AmazonBooks;
import com.assignment1common.model.Authors;
import com.assignment1common.model.Categories;
import com.assignment1common.model.MemberRequests;
import com.assignment1common.model.Members;

@RestController
public class MyController {

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

	
	@GetMapping("/getMemberByPublication")
	public ResponseEntity<List<MemberMemberRequestBook>> getMemberByPublication(@RequestParam("date") String xDate)
			throws ParseException {
		//2017-10-01
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(xDate);
		List<MemberMemberRequestBook> memberList = memberService.getAllMemberByPublication(date);
		if (memberList.size() == 0 || memberList == null) {

			return new ResponseEntity<List<MemberMemberRequestBook>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<MemberMemberRequestBook>>(memberList, HttpStatus.OK);

	}
	
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<Categories>> getCategoryByID() {
		List<Categories> categoryList = categoryService.getAllCategory();
		if (categoryList.size() == 0) {

			return new ResponseEntity<List<Categories>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Categories>>(categoryList, HttpStatus.OK);

	}

	@GetMapping("/getAllAuthor")
	public ResponseEntity<List<Authors>> getAllAuthor() {
		List<Authors> authorList = authorService.getAllAuthors();
		if (authorList.size() == 0) {

			return new ResponseEntity<List<Authors>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Authors>>(authorList, HttpStatus.OK);

	}

	@GetMapping("/getAllAmazonBook")
	public ResponseEntity<List<AmazonBooks>> getAllAmazonBook() {
		List<AmazonBooks> amazonBooksList = amazonBookService.getAllAmazonBook();
		if (amazonBooksList.size() == 0) {

			return new ResponseEntity<List<AmazonBooks>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<AmazonBooks>>(amazonBooksList, HttpStatus.OK);

	}

	@GetMapping("/getAllAddress")
	public ResponseEntity<List<Addresses>> getAllAddress() {
		List<Addresses> addressesList = addressService.getAllAddress();
		if (addressesList.size() == 0 || addressesList == null) {

			return new ResponseEntity<List<Addresses>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Addresses>>(addressesList, HttpStatus.OK);

	}

	@GetMapping("/getAllMember")
	public ResponseEntity<List<Members>> getAllMember() {
		List<Members> memberList = memberService.getAllMember();
		if (memberList.size() == 0) {

			return new ResponseEntity<List<Members>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Members>>(memberList, HttpStatus.OK);

	}

	@GetMapping("/getMemberReqestByID")
	public ResponseEntity<List<MemberRequests>> getMemberReqestByID(@RequestParam("id") int id) {
		Members m = memberService.getMemberByID(id);
		List<MemberRequests> mrList = m.getMemberRequestList();
		if (mrList.size() == 0) {

			return new ResponseEntity<List<MemberRequests>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<MemberRequests>>(mrList, HttpStatus.OK);

	}

	@DeleteMapping("/deleteAllAmazonBook")
	public ResponseEntity<Void> deleteAllAmazonBook() {
		List<Integer> list = amazonBookService.getAllIdAmazonBook();
		int check = amazonBookService.deleteAllAmazonBook(list);

		if (check != list.size()) {

			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@DeleteMapping("/deleteMember")
	public ResponseEntity<Void> deleteMember(@RequestParam("id") int id) {
		memberService.deleteMember(id);

		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@DeleteMapping("/deleteAddress")
	public ResponseEntity<Void> deleteAddress(@RequestParam("id") int id) {
		addressService.deleteAdress(id);

		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@PostMapping("/saveCategory")
	public ResponseEntity<Void> saveCategory(@RequestBody Categories c) {
	 categoryService.saveCategory(c);
			
		
		return new ResponseEntity<Void>( HttpStatus.OK);

	}
	
	
	@GetMapping("/saveAddress")
	public ResponseEntity<Void> saveAddress() {
		Addresses a = new Addresses();

		a.setAddressID(1);
		a.setLine1NumberBuilding("123");
		a.setLine2NunberStreet("456");
		a.setLine3AreaLocality("789");
		a.setCity("Ha Noi");
		a.setZipPostCode("741");
		a.setStateProvinceCountry("HaNoi");
		a.setCountry("Viet Nam");
		a.setOtherAddressDetails("Ha Noi");

		addressService.saveAddress(a);
		// -------------------------------
		a.setAddressID(2);
		a.setLine1NumberBuilding("123");
		a.setLine2NunberStreet("456");
		a.setLine3AreaLocality("789");
		a.setCity("HCM");
		a.setZipPostCode("741");
		a.setStateProvinceCountry("HCM");
		a.setCountry("Viet Nam");
		a.setOtherAddressDetails("HCM");

		addressService.saveAddress(a);

		// -------------------------------
		a.setAddressID(3);
		a.setLine1NumberBuilding("123");
		a.setLine2NunberStreet("456");
		a.setLine3AreaLocality("789");
		a.setCity("HongKong");
		a.setZipPostCode("741");
		a.setStateProvinceCountry("HongKong");
		a.setCountry("China");
		a.setOtherAddressDetails("HongKong");

		addressService.saveAddress(a);

		return new ResponseEntity<Void>( HttpStatus.OK);

	}
}
