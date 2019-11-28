package com.fpt.t1708e.photoplatform.config;

import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.repository.*;
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

@Component
public class Seed implements ApplicationListener<ApplicationReadyEvent> {
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
    Random rand = new Random();
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

    }
    private void seedRankAndLevel(){

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
    }
    private void
}
