package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.AdminInfo;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Category;
import com.fpt.t1708e.photoplatform.entity.Comment;
import com.fpt.t1708e.photoplatform.entity.CustomerInfo;
import com.fpt.t1708e.photoplatform.entity.Level;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.Picture;
import com.fpt.t1708e.photoplatform.entity.Product;
import com.fpt.t1708e.photoplatform.entity.Rank;
import com.fpt.t1708e.photoplatform.entity.Rating;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.repository.AccountRepository;
import com.fpt.t1708e.photoplatform.repository.AdminInfoRepository;
import com.fpt.t1708e.photoplatform.repository.AlbumRepository;
import com.fpt.t1708e.photoplatform.repository.CategoryRepository;
import com.fpt.t1708e.photoplatform.repository.CommentRepository;
import com.fpt.t1708e.photoplatform.repository.LevelRepository;
import com.fpt.t1708e.photoplatform.repository.PhotographerInfoRepository;
import com.fpt.t1708e.photoplatform.repository.PictureRepository;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import com.fpt.t1708e.photoplatform.repository.RankRepository;
import com.fpt.t1708e.photoplatform.repository.RatingRepository;
import com.fpt.t1708e.photoplatform.repository.StudioInfoRepository;
import com.fpt.t1708e.photoplatform.repository.CustomerInfoRepository;
import com.fpt.t1708e.photoplatform.util.ProvinceStringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping({"/home",""})
public class HomeController {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerInfoRepository customerInfoRepository;
	@Autowired
	AdminInfoRepository adminInfoRepository;
	@Autowired
	StudioInfoRepository studioInfoRepository;
	@Autowired
	PhotographerInfoRepository photographerInfoRepository;
	@Autowired
	RankRepository rankRepository;
	@Autowired
	LevelRepository levelRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	PictureRepository pictureRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "customer/home";
//		return "admin-layout/admin-layout";
	}
	@RequestMapping(value = "/detail")
	public String detail(){
		return "manager/studio/studio-photographer/detail";
	}

	@RequestMapping(value = "/checkout")
	public String checkout(){
		return "customer/checkout";
	}
	@RequestMapping(method = RequestMethod.GET, value = "seeder")
	public String seed() {
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			Rank rank = new Rank();
			rank.setName("Level " + i);
			rank.setDescription("nothing");
			rank.setDiscount(Float.parseFloat(String.valueOf(i)) * Float.parseFloat("0.5"));
			rankRepository.save(rank);
		}
		for (int i = 0; i < 3; i++) {
			Level level = new Level();
			level.setName("Level " + i);
			level.setDescription("nothing");
			level.setPrice(100000 * i);
			level.setDurationInDay(TimeUnit.DAYS.toMillis(30));
			levelRepository.save(level);
		}
		List<String> FirstName = Arrays.asList("Hoang", "Duong", "Phong", "Minh", "Hoa", "Ahh", "Tra", "Thu", "Mai",
				"Lan", "Chi", "Luyen");
		List<String> MiddleName = Arrays.asList("Thi", "Van", "Huu", "Duc", "Quynh", "", "Kim", "Anh", "Hong");
		List<String> LastName = Arrays.asList("Nguyen", "Tran", "Pham", "Do", "Le", "Ung", "Vu", "Ly", "Mai", "Ngo",
				"Dao");
		List<Integer> role = Arrays.asList(1, 2, 3);
		List<Rank> rankList = rankRepository.findAll();
		List<Level> levelList = levelRepository.findAll();
		for (int i = 0; i < 100; i++) {
			Account account = new Account();
			account.setRole(role.get(rand.nextInt(role.size())));

			account.setPassword(passwordEncoder.encode("123456"));
			if (i == 0) {
				account.setRole(5);
				AdminInfo userInfo = new AdminInfo();
				userInfo.setAvatar("https://www.w3schools.com/w3images/avatar2.png");
				String fullName = FirstName.get(rand.nextInt(FirstName.size())) + " "
						+ MiddleName.get(rand.nextInt(MiddleName.size())) + " "
						+ LastName.get(rand.nextInt(LastName.size()));
				userInfo.setFullName(fullName);
				String username = FirstName.get(rand.nextInt(FirstName.size()))
						+ LastName.get(rand.nextInt(LastName.size())) + String.valueOf(i + 1);
				System.out.println(username);
				account.setUsername(username);
				userInfo.setAccount(account);
				accountRepository.save(account);
				adminInfoRepository.save(userInfo);
			}
			//
			if (account.getRole() == 1) {
				CustomerInfo userInfo = new CustomerInfo();
				userInfo.setAddress("Khong co");
				userInfo.setAvatar("https://www.w3schools.com/w3images/avatar2.png");
				userInfo.setBirthday(Calendar.getInstance().getTimeInMillis());
				userInfo.setDescription("Nothing");
				userInfo.setGender(i % 2);
				userInfo.setPhone("098902020" + i);
				String fullName = FirstName.get(rand.nextInt(FirstName.size())) + " "
						+ MiddleName.get(rand.nextInt(MiddleName.size())) + " "
						+ LastName.get(rand.nextInt(LastName.size()));
				userInfo.setFullName(fullName);

				String username = FirstName.get(rand.nextInt(FirstName.size()))
						+ LastName.get(rand.nextInt(LastName.size())) + String.valueOf(i + 1);
				System.out.println(username);
				userInfo.setEmail(username + "@gmail.com");
				userInfo.setRank(rankList.get(rand.nextInt(rankList.size())));
				account.setUsername(username);
				userInfo.setAccount(account);
				accountRepository.save(account);
				customerInfoRepository.save(userInfo);
			}
			//
			if (account.getRole() == 2) {
				Level level = levelList.get(rand.nextInt(levelList.size()));
				StudioInfo userInfo = new StudioInfo();
				userInfo.setAddress("Khong co");
				userInfo.setAvatar("https://www.w3schools.com/w3images/avatar2.png");
				userInfo.setDescription("Nothing");
				userInfo.setPhone("098902020" + i);
				String fullName = FirstName.get(rand.nextInt(FirstName.size())) + " "
						+ MiddleName.get(rand.nextInt(MiddleName.size())) + " "
						+ LastName.get(rand.nextInt(LastName.size()));
				userInfo.setFullName(fullName);

				String username = FirstName.get(rand.nextInt(FirstName.size()))
						+ LastName.get(rand.nextInt(LastName.size())) + String.valueOf(i + 1);
				System.out.println(username);
				userInfo.setEmail(username + "@gmail.com");
				userInfo.setLevel(level);
				userInfo.setLevelExpiredAt(Calendar.getInstance().getTimeInMillis() + level.getDurationInDay());
				account.setUsername(username);
				userInfo.setAccount(account);
				accountRepository.save(account);
				studioInfoRepository.save(userInfo);
			}
			//
			if (account.getRole() == 3) {
				Level level = levelList.get(rand.nextInt(levelList.size()));
				PhotographerInfo userInfo = new PhotographerInfo();
				userInfo.setAddress("Khong co");
				userInfo.setAvatar("https://www.w3schools.com/w3images/avatar2.png");
				userInfo.setDescription("Nothing");
				userInfo.setPhone("098902020" + i);
				userInfo.setBirthday(Calendar.getInstance().getTimeInMillis());
				userInfo.setGender(i % 2);
				String fullName = FirstName.get(rand.nextInt(FirstName.size())) + " "
						+ MiddleName.get(rand.nextInt(MiddleName.size())) + " "
						+ LastName.get(rand.nextInt(LastName.size()));
				userInfo.setFullName(fullName);

				String username = FirstName.get(rand.nextInt(FirstName.size()))
						+ LastName.get(rand.nextInt(LastName.size())) + String.valueOf(i + 1);
				System.out.println(username);
				userInfo.setEmail(username + "@gmail.com");
				userInfo.setLevel(level);
				userInfo.setLevelExpiredAt(Calendar.getInstance().getTimeInMillis() + level.getDurationInDay());
				account.setUsername(username);
				userInfo.setAccount(account);
				accountRepository.save(account);
				photographerInfoRepository.save(userInfo);
			}

		}
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "seed/category")
	public String categorySeed() {
//    	
		for (int i = 0; i < 10; i++) {
			Category category = new Category();
			category.setName("Category " + i + 1);
			category.setDescription("Category Description " + i + 1);
			category.setThumbnail("https://www.logolynx.com/images/logolynx/5b/5b2d36284eb6b1147247ec3f1fc60a2f.jpeg");
			categoryRepository.save(category);
		}

		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "seed/album")
	@ResponseBody
	public String albumSeeder() {
		List<Account> studioAccounts = accountRepository.findAllAccountByRole(2).get();
		List<Account> ptgAccounts = accountRepository.findAllAccountByRole(3).get();
		for (Account account : studioAccounts) {
			Album album = new Album();
			album.setName("Album " + account.getId());
			album.setDescription("Album description " + account.getId());
			album.setThumbnail(
					"https://previews.123rf.com/images/bestvectorstock/bestvectorstock1811/bestvectorstock181101812/111988091-wedding-album-icon-trendy-wedding-album-logo-concept-on-white-background-from-birthday-party-and-wed.jpg");
			album.setStudioInfo(account.getStudioInfo());
			albumRepository.save(album);
		}
		for (Account account : ptgAccounts) {
			Album album = new Album();
			album.setName("Album " + account.getId());
			album.setDescription("Album description " + account.getId());
			album.setThumbnail(
					"https://previews.123rf.com/images/bestvectorstock/bestvectorstock1811/bestvectorstock181101812/111988091-wedding-album-icon-trendy-wedding-album-logo-concept-on-white-background-from-birthday-party-and-wed.jpg");
			album.setPhotographerInfo(account.getPhotographerInfo());
			albumRepository.save(album);
		}
		return String.valueOf(studioAccounts.size() + ptgAccounts.size());
	}

	@RequestMapping(method = RequestMethod.GET, value = "seed/picture")
	@ResponseBody
	public String pictureSeeder() {
		List<Album> albums = albumRepository.findAll();
		for (Album album : albums) {
			for (int i = 0; i < 10; i++) {
				Picture picture = new Picture();
				picture.setUrl(
						"https://cdn2.vectorstock.com/i/1000x1000/58/71/wedding-logo-with-silhouettes-bride-and-groom-vector-15055871.jpg");
				picture.setAlbum(album);
				pictureRepository.save(picture);
			}
		}
		return String.valueOf(albums.size());
	}

	@RequestMapping(method = RequestMethod.GET, value = "seed/product")
	@ResponseBody
	public String productSeeder() {
		Random rand = new Random();
		List<Album> albums = albumRepository.findAll();
		List<Category> categories = categoryRepository.findAll();
		for (Album album : albums) {
			for (int i = 0; i < 5; i++) {
				Product product = new Product();
				if (album.getStudioInfo() != null) {
					product.setStudioInfo(album.getStudioInfo());
				} else {
					product.setPhotographerInfo(album.getPhotographerInfo());
				}
				product.setCategory(categories.get(rand.nextInt(categories.size())));
				product.setAlbum(album);
				product.setName("Product " + album.getName() + " No " + (i + 1));
				product.setDescription("Description Product " + album.getName() + " No " + (i + 1));
				product.setContent(
						"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
				product.setPrice((rand.nextInt(9) + 1) * 1000000);
				product.setPriceDiscount(product.getPrice() * (rand.nextInt(3) + 6) / 10);
				product.setThumbnail("https://i.ebayimg.com/images/g/dUIAAOSwVKRaH8ga/s-l1600.jpg");
				String province = ProvinceStringUtil.name().get(rand.nextInt(ProvinceStringUtil.name().size()));
				product.setArea(province);
				product.setDestination(province + " " + (i + 1));
				productRepository.save(product);
			}
		}
		return String.valueOf(albums.size());
	}

	@RequestMapping(method = RequestMethod.GET, value = "seed/rnc")
	@ResponseBody
	public String ratingAndCommentSeeder() {
		Random rand = new Random();
		List<CustomerInfo> customerInfos = customerInfoRepository.findAll();
		//
		List<StudioInfo> studioInfos = studioInfoRepository.findAll();
		List<PhotographerInfo> photographerInfos = photographerInfoRepository.findAll();
		for (StudioInfo studioInfo : studioInfos) {
			CustomerInfo rdCus = customerInfos.get(rand.nextInt(customerInfos.size()));
			Comment comment = new Comment();
			comment.setContent("Comment " + rdCus.getId());
			comment.setStudioInfo(studioInfo);
			comment.setCustomerInfo(rdCus);
			commentRepository.save(comment);
			Rating rating = new Rating();
			rating.setValue(rand.nextInt(9) + 1);
			rating.setStudioInfo(studioInfo);
			rating.setCustomerInfo(rdCus);
			ratingRepository.save(rating);
		}
		for (PhotographerInfo photographerInfo : photographerInfos) {
			CustomerInfo rdCus = customerInfos.get(rand.nextInt(customerInfos.size()));
			Comment comment = new Comment();
			comment.setContent("Comment " + rdCus.getId());
			comment.setPhotographerInfo(photographerInfo);
			comment.setCustomerInfo(rdCus);
			commentRepository.save(comment);
			Rating rating = new Rating();
			rating.setValue(rand.nextInt(9) + 1);
			rating.setPhotographerInfo(photographerInfo);
			rating.setCustomerInfo(rdCus);
			ratingRepository.save(rating);
		}
		List<Album> albums = albumRepository.findAll();
		for (Album album : albums) {
			CustomerInfo rdCus = customerInfos.get(rand.nextInt(customerInfos.size()));
			Comment comment = new Comment();
			comment.setContent("Comment " + album.getId());
			comment.setAlbum(album);
			comment.setCustomerInfo(rdCus);
			commentRepository.save(comment);
			Rating rating = new Rating();
			rating.setValue(rand.nextInt(9) + 1);
			rating.setAlbum(album);
			rating.setCustomerInfo(rdCus);
			ratingRepository.save(rating);
		}
		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			CustomerInfo rdCus = customerInfos.get(rand.nextInt(customerInfos.size()));
			Comment comment = new Comment();
			comment.setContent("Comment " + product.getId());
			comment.setProduct(product);
			comment.setCustomerInfo(rdCus);
			commentRepository.save(comment);
			Rating rating = new Rating();
			rating.setValue(rand.nextInt(9) + 1);
			rating.setProduct(product);
			rating.setCustomerInfo(rdCus);
			ratingRepository.save(rating);
		}

		return "1";
	}
}
