package com.fpt.t1708e.photoplatform.config;

import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.repository.*;
import com.fpt.t1708e.photoplatform.seeder.PhotographerInfoSeeder;
import com.fpt.t1708e.photoplatform.seeder.ProductSeeder;
import com.fpt.t1708e.photoplatform.seeder.StudioInfoSeeder;
import com.fpt.t1708e.photoplatform.service.CustomerInfoService;
import com.fpt.t1708e.photoplatform.util.ProvinceStringUtil;
import com.fpt.t1708e.photoplatform.util.VNCharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class Seed implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOGGER = Logger.getLogger(Seed.class.getSimpleName());
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
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    Random rand = new Random();

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
        if (!isDebug) {
            LOGGER.log(java.util.logging.Level.INFO, String.format("Start seeding..."));
            rankRepository.disableForeignKeyCheck();
            seedRankAndLevel();
            seedAccount();
            categorySeed();
            albumSeeder();
            pictureSeeder();
            productSeeder();
            ratingAndCommentSeeder();
            orderDetail();
            rankRepository.enableForeignKeyCheck();
            LOGGER.log(java.util.logging.Level.INFO, String.format("Success in seeding..."));
        }

    }

    private void seedRankAndLevel() {
        rankRepository.deleteAll();
        rankRepository.resetIncrement();
        levelRepository.deleteAll();
        levelRepository.resetIncrement();
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
    }

    private void seedAccount() {
        accountRepository.deleteAll();
        accountRepository.resetIncrement();
//        adminInfoRepository.deleteAll();
        adminInfoRepository.resetIncrement();
        customerInfoRepository.resetIncrement();
        photographerInfoRepository.resetIncrement();
        studioInfoRepository.resetIncrement();
        List<String> FirstName = Arrays.asList("Hoang", "Duong", "Phong", "Minh", "Hoa", "Anh", "Tra", "Thu", "Mai",
                "Lan", "Chi", "Luyen");
        List<String> MiddleName = Arrays.asList("Thi", "Van", "Huu", "Duc", "Quynh", "", "Kim", "Anh", "Hong");
        List<String> LastName = Arrays.asList("Nguyen", "Tran", "Pham", "Do", "Le", "Ung", "Vu", "Ly", "Mai", "Ngo",
                "Dao");
        List<Integer> role = Arrays.asList(1, 2, 3);
        List<Rank> rankList = rankRepository.findAll();
        List<Level> levelList = levelRepository.findAll();
        for (int i = 0; i < 5; i++) {
            Account account = new Account();
            account.setRole(1);

            account.setPassword(passwordEncoder.encode("123456"));
            String currentFirstName = FirstName.get(rand.nextInt(FirstName.size()));
            String currentMiddleName = MiddleName.get(rand.nextInt(MiddleName.size()));
            String currentLastName = LastName.get(rand.nextInt(LastName.size()));
            String fullName = currentFirstName + " "
                    + currentMiddleName + " "
                    + currentLastName;
            String username = currentFirstName
                    + currentLastName + String.valueOf(i + 1);
            if (i == 0) {
                account.setRole(5);
                AdminInfo userInfo = new AdminInfo();
                userInfo.setAvatar("https://www.w3schools.com/w3images/avatar2.png");
                userInfo.setFullName(fullName);
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
                userInfo.setFullName(fullName);
                userInfo.setBirthday(Calendar.getInstance().getTimeInMillis());
                userInfo.setDescription("Nothing");
                userInfo.setGender(i % 2);
                userInfo.setPhone("098902020" + i);
                System.out.println(username);
                userInfo.setEmail(username + "@gmail.com");
                userInfo.setRank(rankList.get(rand.nextInt(rankList.size())));
                account.setUsername(username);
                userInfo.setAccount(account);
                accountRepository.save(account);
                customerInfoRepository.save(userInfo);
            }

        }
        //Photographer Seeder
        PhotographerInfoSeeder.addPtg();
        for (int i = 0; i < PhotographerInfoSeeder.photographerInfos.size(); i++) {
            Account account = new Account();
            account.setRole(3);
            account.setPassword(passwordEncoder.encode("123456"));
            Level level = levelList.get(rand.nextInt(levelList.size()));
            PhotographerInfo userInfo = new PhotographerInfo();
            userInfo.setAddress(PhotographerInfoSeeder.photographerInfos.get(i).getAddress());
            userInfo.setAvatar(PhotographerInfoSeeder.photographerInfos.get(i).getAvatar());
            userInfo.setFullName(PhotographerInfoSeeder.photographerInfos.get(i).getFullName());
            userInfo.setDescription(PhotographerInfoSeeder.photographerInfos.get(i).getDescription());
            userInfo.setPhone(PhotographerInfoSeeder.photographerInfos.get(i).getPhone());
            userInfo.setBirthday(Calendar.getInstance().getTimeInMillis());
            userInfo.setGender(i % 2);
            System.out.println(VNCharUtil.removeAccent(PhotographerInfoSeeder.photographerInfos.get(i).getFullName()));
            userInfo.setEmail(PhotographerInfoSeeder.photographerInfos.get(i).getEmail());
            userInfo.setLevel(level);
            userInfo.setLevelExpiredAt(Calendar.getInstance().getTimeInMillis() + level.getDurationInDay());
            account.setUsername(VNCharUtil.removeAccent(PhotographerInfoSeeder.photographerInfos.get(i).getFullName()));
            userInfo.setAccount(account);
            accountRepository.save(account);
            photographerInfoRepository.save(userInfo);
        }
        //Photographer Seeder
        StudioInfoSeeder.addStudio();
        for (int i = 0; i < StudioInfoSeeder.studioInfos.size(); i++) {
            Account account = new Account();
            account.setRole(2);
            account.setPassword(passwordEncoder.encode("123456"));
            Level level = levelList.get(rand.nextInt(levelList.size()));
            StudioInfo userInfo = new StudioInfo();
            userInfo.setAddress(StudioInfoSeeder.studioInfos.get(i).getAddress());
            userInfo.setAvatar(StudioInfoSeeder.studioInfos.get(i).getAvatar());
            userInfo.setFullName(StudioInfoSeeder.studioInfos.get(i).getFullName());
            userInfo.setDescription(StudioInfoSeeder.studioInfos.get(i).getDescription());
            userInfo.setPhone(StudioInfoSeeder.studioInfos.get(i).getPhone());
            System.out.println(VNCharUtil.removeAccent(StudioInfoSeeder.studioInfos.get(i).getFullName()));
            userInfo.setEmail(StudioInfoSeeder.studioInfos.get(i).getEmail());
            userInfo.setLevel(level);
            userInfo.setLevelExpiredAt(Calendar.getInstance().getTimeInMillis() + level.getDurationInDay());
            account.setUsername(VNCharUtil.removeAccent(StudioInfoSeeder.studioInfos.get(i).getFullName()));
            userInfo.setAccount(account);
            accountRepository.save(account);
            studioInfoRepository.save(userInfo);
        }
    }

    public void categorySeed() {
        categoryRepository.deleteAll();
        categoryRepository.resetIncrement();
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setName("Category " + i + 1);
            category.setDescription("Category Description " + i + 1);
            category.setThumbnail("https://www.logolynx.com/images/logolynx/5b/5b2d36284eb6b1147247ec3f1fc60a2f.jpeg");
            categoryRepository.save(category);
        }
    }

    public void albumSeeder() {
        albumRepository.deleteAll();
        albumRepository.resetIncrement();
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
    }

    public void pictureSeeder() {
        pictureRepository.deleteAll();
        pictureRepository.resetIncrement();
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
    }

    public void productSeeder() {
        productRepository.deleteAll();
        productRepository.resetIncrement();
        Random rand = new Random();
        List<Album> albums = albumRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
//        for (Album album : albums) {
//            for (int i = 0; i < 5; i++) {
//                Product product = new Product();
//                if (album.getStudioInfo() != null) {
//                    product.setStudioInfo(album.getStudioInfo());
//                } else {
//                    product.setPhotographerInfo(album.getPhotographerInfo());
//                }
//                product.setCategory(categories.get(rand.nextInt(categories.size())));
//                product.setAlbum(album);
//                product.setName("Product " + album.getName() + " No " + (i + 1));
//                product.setDescription("Description Product " + album.getName() + " No " + (i + 1));
//                product.setContent(
//                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
//                product.setPrice((rand.nextInt(9) + 1) * 1000000);
//                product.setPriceDiscount(product.getPrice() * (rand.nextInt(3) + 6) / 10);
//                product.setThumbnail("https://i.ebayimg.com/images/g/dUIAAOSwVKRaH8ga/s-l1600.jpg");
//                String province = ProvinceStringUtil.name().get(rand.nextInt(ProvinceStringUtil.name().size()));
//                product.setArea(province);
//                product.setDestination(province + " " + (i + 1));
//                productRepository.save(product);
//            }
//        }
        // Product Seeder
        ProductSeeder.addProduct();
        for (int i = 0; i < ProductSeeder.productList.size(); i++) {
            Product product = new Product();
            Album album = albums.get(rand.nextInt(albums.size()));
            if (album.getStudioInfo() != null) {
                product.setStudioInfo(album.getStudioInfo());
            } else {
                product.setPhotographerInfo(album.getPhotographerInfo());
            }
            product.setCategory(categories.get(rand.nextInt(categories.size())));
            product.setAlbum(album);
            product.setName(ProductSeeder.productList.get(i).getName());
            product.setDescription(ProductSeeder.productList.get(i).getDescription());
            product.setContent(ProductSeeder.productList.get(i).getContent());
            product.setPrice(ProductSeeder.productList.get(i).getPrice());
            product.setPriceDiscount(ProductSeeder.productList.get(i).getPriceDiscount());
            product.setThumbnail(ProductSeeder.productList.get(i).getThumbnail());
            product.setArea(ProductSeeder.productList.get(i).getArea());
            product.setDestination(ProductSeeder.productList.get(i).getDestination());
            productRepository.save(product);
        }
    }

    public void ratingAndCommentSeeder() {
        ratingRepository.deleteAll();
        ratingRepository.resetIncrement();
        commentRepository.deleteAll();
        commentRepository.resetIncrement();
        Random rand = new Random();
        List<CustomerInfo> customerInfos = customerInfoRepository.findAll();
        //
        List<StudioInfo> studioInfos = studioInfoRepository.findAll();
        List<PhotographerInfo> photographerInfos = photographerInfoRepository.findAll();
        for (StudioInfo studioInfo : studioInfos) {
            CustomerInfo rdCus = customerInfos.get(rand.nextInt(customerInfos.size()));
            Comment comment = new Comment();
            comment.setContent("Wow, Perfect experience " + rdCus.getId());
            comment.setStudioInfo(studioInfo);
            comment.setCustomerInfo(rdCus);
            commentRepository.save(comment);
            Rating rating = new Rating();
            rating.setValue(rand.nextInt(9) + 1);
            rating.setStudioInfo(studioInfo);
            rating.setCustomerInfo(rdCus);
            ratingRepository.save(rating);
            studioInfo.setAverageRate(rating.getValue());
            studioInfoRepository.save(studioInfo);
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
            photographerInfo.setAverageRate(rating.getValue());
            photographerInfoRepository.save(photographerInfo);
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
            product.setAverageRate(rating.getValue());
            productRepository.save(product);
        }
    }

    public void orderDetail() {

        // Order pending
        Account account = new Account();
        account.setRole(1);
        account.setPassword(passwordEncoder.encode("123456"));
        CustomerInfo userInfo = new CustomerInfo();
        userInfo.setAddress("Khong co");
        userInfo.setAvatar("https://www.w3schools.com/w3images/avatar2.png");
        userInfo.setFullName("User Pending");
        userInfo.setBirthday(Calendar.getInstance().getTimeInMillis());
        userInfo.setDescription("Nothing");
        userInfo.setGender(1);
        userInfo.setPhone("0979020863");
//        System.out.println(username);
        userInfo.setEmail("napa.nguyenhoang@gmail.com");
        userInfo.setRank(null);
        account.setUsername("nguyenhoang24695");
        userInfo.setAccount(account);
        accountRepository.save(account);
        customerInfoRepository.save(userInfo);

        orderProductRepository.deleteAll();
        orderProductRepository.resetIncrement();
        orderDetailRepository.deleteAll();
        orderDetailRepository.resetIncrement();

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setCustomerEmail(userInfo.getEmail());
        orderProduct.setCustomerName(userInfo.getFullName());
        orderProduct.setCustomerPhone(userInfo.getPhone());
        orderProduct.setStatus(1);
        orderProduct.setCustomerInfo(userInfo);
        orderProduct.setNote("Nothing Node here");
        orderProduct.setPaymentType(1);


        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderProduct(orderProduct);
        orderDetail.setStatus(1);
        //
        Product product = productRepository.getTop10Rating().get(0);
        orderDetail.setProduct(product);
        orderDetail.setCurrentPrice(product.getPriceDiscount());
        orderProduct.setTotalPrice(orderDetail.getCurrentPrice());

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setOrderProduct(orderProduct);
        orderDetail1.setStatus(1);
        //
        product = productRepository.getTop10Rating().get(1);
        orderDetail1.setProduct(product);
        orderDetail1.setCurrentPrice(product.getPriceDiscount());
        orderProduct.setTotalPrice(orderProduct.getTotalPrice() + orderDetail1.getCurrentPrice());
        orderProductRepository.save(orderProduct);
        orderDetailRepository.save(orderDetail);
        orderDetailRepository.save(orderDetail1);


    }
}
