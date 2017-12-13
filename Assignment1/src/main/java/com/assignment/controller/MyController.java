package com.assignment.controller;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assigment.entity.ObjectDTO;
import com.assignment.dao.DataDAO;
import com.assignment.model.Addresses;
import com.assignment.model.AmazonBooks;
import com.assignment.model.Authors;
import com.assignment.model.Books;
import com.assignment.model.Categories;
import com.assignment.model.Libraries;
import com.assignment.model.MemberRequests;
import com.assignment.model.Members;

@Component
public class MyController implements ApplicationListener<ContextRefreshedEvent> {
// sử dụng ApplicationListener để tapk 1 sự keein trong spring
	//onApplicationEvent sẽ đc tạp khi spring context start hoặc refresh
	@Autowired
	DataDAO dao;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		MyController controller = new MyController();
		try {

			// insert table amazon_books
			System.out.println(
					"===================================================================================================");
			System.out.println("insert table amazon_books");
			addAmazonBooks();
			// insert table Addresses
			System.out.println(
					"===================================================================================================");
			System.out.println("insert table Addresses");
			addAddresses();
			// insert table Members
			System.out.println(
					"===================================================================================================");
			System.out.println("insert table Members");
			addMembers();
			// insert table Category
			System.out.println(
					"===================================================================================================");
			System.out.println("insert table Category");
			addCategory();
			// insert table Authors
			System.out.println(
					"===================================================================================================");
			System.out.println("insert table Authors");
			addAuthor();
			// insert table Books
			System.out.println(
					"===================================================================================================");
			System.out.println("insert table Books");
			addBook();
			// insert table Members Request
			System.out.println(
					"===================================================================================================");
			System.out.println("insert table Members Request");
			addMemberRequest();
			// insert table Libraries
			System.out.println(
					"===================================================================================================");
			System.out.println("insert table Libraries");
			addLibrary();
			// get all table amazon_books
			System.out.println(
					"===================================================================================================");
			System.out.println("get all table amazon_books");
			getAllAmazonBook();
			// select memeber by dateOfOublication(Books)
			System.out.println(
					"===================================================================================================");
			System.out.println("select memeber by dateOfOublication(Books)");
			getMemberByDatePublication();

			// Delete All table Amazon_Books
			System.out.println(
					"===================================================================================================");
			System.out.println("Delete All table Amazon_Books");
			 deleteAllAmazonBook();
			// Update table Address
			System.out.println(
					"===================================================================================================");
			System.out.println("Update table Address");
			updateAddress();
		} catch (Exception e) {
			System.out.println("Error :" + e.toString());
		}

	}

	private void getMemberByDatePublication() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2017-10-01");
		List<Object> list = dao.getMemberByDatePublication(date);

		for (int i = 0; i < list.size(); i++) {
			System.out.println("Result search size:  " + list.size());
		}

		

	}

	private void updateAddress() {
		Addresses a = dao.getAddressByID(2);

		System.out.println("Hien thi Address chua update");
		System.out.println("Address ID:" + a.getAddressID());
		System.out.println("Line 1 number building:" + a.getLine1NumberBuilding());
		System.out.println("Line 2 number Street:" + a.getLine2NunberStreet());
		System.out.println("Line 3 area local:" + a.getLine3AreaLocality());
		System.out.println("City:" + a.getCity());
		System.out.println("Zip post Code:" + a.getZipPostCode());
		System.out.println("State province country :" + a.getStateProvinceCountry());
		System.out.println("Country :" + a.getCountry());
		System.out.println("Other Address Details:" + a.getOtherAddressDetails());

		a.setZipPostCode("111111");
		a.setCountry("Korea");
		a.setCity("Seoul");
		dao.updateAddressById(a);

		System.out.println("Hien thi Address da update");
		System.out.println("Address ID:" + a.getAddressID());
		System.out.println("Line 1 number building:" + a.getLine1NumberBuilding());
		System.out.println("Line 2 number Street:" + a.getLine2NunberStreet());
		System.out.println("Line 3 area local:" + a.getLine3AreaLocality());
		System.out.println("City:" + a.getCity());
		System.out.println("Zip post Code:" + a.getZipPostCode());
		System.out.println("State province country :" + a.getStateProvinceCountry());
		System.out.println("Country :" + a.getCountry());
		System.out.println("Other Address Details:" + a.getOtherAddressDetails());

	}

	private void addAmazonBooks() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		AmazonBooks ab = new AmazonBooks();
		Date date = null;

		ab.setTitle("Java");
		ab.setAuthors("lam");

		date = dateFormat.parse("2017-10-21");

		ab.setDateOfPublication(date);
		ab.setAmazonStartRating("5*");
		ab.setPublisher("lam");
		ab.setListPrice("100,200");
		ab.setAmazonPrice("300,500");
		ab.setYourSaving("1000");

		dao.addAmazonBook(ab);
		// ===================================================
		ab.setTitle("C#");
		ab.setAuthors("Nam");
		date = dateFormat.parse("2017-10-01");
		ab.setDateOfPublication(date);
		ab.setAmazonStartRating("4*");
		ab.setPublisher("Nam");
		ab.setListPrice("1300,200");
		ab.setAmazonPrice("3200,2500");
		ab.setYourSaving("1050");

		dao.addAmazonBook(ab);

		// ===================================================
		ab.setTitle("C");
		ab.setAuthors("Linh");
		date = dateFormat.parse("2017-02-01");
		ab.setDateOfPublication(date);
		ab.setAmazonStartRating("6*");
		ab.setPublisher("Linh");
		ab.setListPrice("1300,400");
		ab.setAmazonPrice("3200,2500");
		ab.setYourSaving("1050");

		dao.addAmazonBook(ab);
		// ===================================================
		ab.setTitle("Java Web");
		ab.setAuthors("Long");
		date = dateFormat.parse("2017-06-25");
		ab.setDateOfPublication(date);
		ab.setAmazonStartRating("2*");
		ab.setPublisher("Long");
		ab.setListPrice("1300,200");
		ab.setAmazonPrice("3200,2500");
		ab.setYourSaving("1050");
		dao.addAmazonBook(ab);

	}

	private void getAllAmazonBook() {

		List<AmazonBooks> list = dao.getAllAmazonBooks();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Isbn:" + list.get(i).getIsbn());
			System.out.println("Titile:" + list.get(i).getTitle());
			System.out.println("Author:" + list.get(i).getAuthors());
			System.out.println("Date Of Publication:" + list.get(i).getDateOfPublication());
			System.out.println("Amazon Start Rating:" + list.get(i).getAmazonStartRating());
			System.out.println("Publisher:" + list.get(i).getPublisher());
			System.out.println("List Price:" + list.get(i).getListPrice());
			System.out.println("Amazon Price :" + list.get(i).getAmazonPrice());
			System.out.println("Your Saving:" + list.get(i).getYourSaving());
			System.out.println("-------------------------------------------");
		}

	}

	private void deleteAllAmazonBook() {

		List<Integer> list = null;
		list = dao.getAllIdAmazonBook();
		int sizeList = list.size();
		int rs = dao.deleteAllAmazonBook(list);
		if (rs == sizeList) {
			list = dao.getAllIdAmazonBook();
			System.out.println("Delete All Amazon Book is seccessfull , size :" + list.size());

		} else {
			System.out.println("Delete All Amazon Book is Faile");
		}
	}

	private void addCategory() {

		List<Categories> list = new ArrayList<>();
		Categories c = new Categories();

		c.setCategoryID(1);
		c.setCategoryName("Java");
		dao.addCategory(c);
		// ------------------------------
		c.setCategoryID(2);
		c.setCategoryName("C#");
		dao.addCategory(c);
		// ------------------------------
		c.setCategoryID(3);
		c.setCategoryName("C");
		dao.addCategory(c);
		// ------------------------------
		c.setCategoryID(4);
		c.setCategoryName("Java Web");
		dao.addCategory(c);

	}

	private void addAuthor() {

		Authors a = new Authors();

		a.setAuthorID(1);
		a.setAuthorFirstName("Lam");
		a.setAuthorLastName("Nguyen");
		dao.addAuthors(a);
		// ------------------------------
		a.setAuthorID(2);
		a.setAuthorFirstName("Lan");
		a.setAuthorLastName("Tran");
		dao.addAuthors(a);
		// ------------------------------
		a.setAuthorID(3);
		a.setAuthorFirstName("Nam");
		a.setAuthorLastName("Nguyen");
		dao.addAuthors(a);
		// ------------------------------
		a.setAuthorID(4);
		a.setAuthorFirstName("Linh");
		a.setAuthorLastName("Nguyen");
		dao.addAuthors(a);

	}

	private void addBook() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Books b = new Books();
		Date date = null;
		Categories c = null;
		Authors a = null;
		HashSet<Categories> categotyHash = new HashSet<>();
		HashSet<Authors> authorHash = new HashSet<>();

		b.setIsbn(1);
		a = dao.getAuthorByID(1);
		c = dao.getCategoryByID(1);
		categotyHash.add(c);
		authorHash.add(a);
		b.setAuthors(authorHash);
		b.setCategories(categotyHash);
		b.setBookTitle("Java");
		date = dateFormat.parse("2017-10-21");
		b.setDateOfPublication(date);
		dao.addBook(b);

		// ------------------------------
		b.setIsbn(2);
		a = dao.getAuthorByID(2);
		c = dao.getCategoryByID(2);
		categotyHash.add(c);
		authorHash.add(a);
		b.setAuthors(authorHash);
		b.setCategories(categotyHash);
		b.setBookTitle("C#");
		date = dateFormat.parse("2017-10-01");
		b.setDateOfPublication(date);
		dao.addBook(b);
		// ------------------------------
		b.setIsbn(3);
		a = dao.getAuthorByID(3);
		c = dao.getCategoryByID(3);
		categotyHash.add(c);
		authorHash.add(a);
		b.setAuthors(authorHash);
		b.setCategories(categotyHash);
		b.setBookTitle("C");
		date = dateFormat.parse("2017-02-01");
		b.setDateOfPublication(date);
		dao.addBook(b);
		// ------------------------------
		b.setIsbn(4);
		a = dao.getAuthorByID(4);
		c = dao.getCategoryByID(4);
		categotyHash.add(c);
		authorHash.add(a);
		b.setAuthors(authorHash);
		b.setCategories(categotyHash);
		b.setBookTitle("Java web");
		date = dateFormat.parse("2017-06-25");
		b.setDateOfPublication(date);
		dao.addBook(b);

	}

	public void addAddresses() {

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

		dao.addAddresses(a);
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

		dao.addAddresses(a);

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

		dao.addAddresses(a);

	}

	public void addMembers() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Members m = new Members();
		Addresses a = null;

		a = dao.getAddressByID(1);
		m.setAddresses(a);
		m.setMemberID(1);
		m.setGender("Male");
		m.setMemberFirstName("Lam");
		m.setMemberLastName("Ngoc");
		m.setPhoneNumber("0123456");
		m.setEmailAddress("lamnn@gmail.com");
		m.setOtherMemberDetails("lam");
		dao.addMember(m);
		// -----------------------------
		a = dao.getAddressByID(2);
		m.setAddresses(a);
		m.setMemberID(2);
		m.setGender("Female");
		m.setMemberFirstName("Linh");
		m.setMemberLastName("Nguyen");
		m.setPhoneNumber("0123456");
		m.setEmailAddress("linhnn@gmail.com");
		m.setOtherMemberDetails("linh");
		dao.addMember(m);

		// -----------------------------
		a = dao.getAddressByID(3);
		m.setAddresses(a);
		m.setMemberID(3);
		m.setGender("Male");
		m.setMemberFirstName("Nam");
		m.setMemberLastName("Ngoc");
		m.setPhoneNumber("0123456");
		m.setEmailAddress("namnn@gmail.com");
		m.setOtherMemberDetails("nam");
		dao.addMember(m);

	}

	public void addMemberRequest() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<MemberRequests> list = new ArrayList<>();
		MemberRequests mr = new MemberRequests();
		Books b = null;
		Members m = null;
		Date date = null;
		Date date1 = null;

		b = dao.getBookByID(1);
		m = dao.getMemberID(2);
		mr.setMembers(m);
		mr.setBooks(b);
		mr.setRequestID(1);
		date = dateFormat.parse("2017-06-10");
		mr.setDateRequested(date);
		date1 = dateFormat.parse("2017-07-10");
		mr.setDateLocated(date1);
		mr.setOtherRequestDetails("abc");
		dao.addMemberRequest(mr);

		// ------------------------------------------
		b = dao.getBookByID(2);
		m = dao.getMemberID(3);
		mr.setMembers(m);
		mr.setBooks(b);
		mr.setRequestID(2);
		date = dateFormat.parse("2017-01-10");
		mr.setDateRequested(date);
		date1 = dateFormat.parse("2017-07-18");
		mr.setDateLocated(date1);
		mr.setOtherRequestDetails("abc");
		dao.addMemberRequest(mr);

		// ------------------------------------------
		b = dao.getBookByID(3);
		m = dao.getMemberID(1);
		mr.setMembers(m);
		mr.setBooks(b);
		mr.setRequestID(3);
		date = dateFormat.parse("2017-05-10");
		mr.setDateRequested(date);
		date1 = dateFormat.parse("2017-02-16");
		mr.setDateLocated(date1);
		mr.setOtherRequestDetails("abc");
		dao.addMemberRequest(mr);

	}

	public void addLibrary() {
		List<Libraries> list = new ArrayList<>();
		Libraries l = new Libraries();
		Addresses a = null;

		a = dao.getAddressByID(1);
		l.setAddresses(a);
		l.setLibraryID(1);
		l.setLibraryName("Good");
		l.setLibraryDetails("abc");

		dao.addLibrary(l);
		// ---------------------------
		a = dao.getAddressByID(2);
		l.setAddresses(a);
		l.setLibraryID(2);
		l.setLibraryName("CountrySide");
		l.setLibraryDetails("abc");

		dao.addLibrary(l);
		// ---------------------------
		a = dao.getAddressByID(3);
		l.setAddresses(a);
		l.setLibraryID(3);
		l.setLibraryName("Save It");
		l.setLibraryDetails("abc");

		dao.addLibrary(l);

	}

}
