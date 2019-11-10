package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Level;
import com.fpt.t1708e.photoplatform.entity.Rank;
import com.fpt.t1708e.photoplatform.entity.UserInfo;
import com.fpt.t1708e.photoplatform.repository.AccountRepository;
import com.fpt.t1708e.photoplatform.repository.LevelRepository;
import com.fpt.t1708e.photoplatform.repository.RankRepository;
import com.fpt.t1708e.photoplatform.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    RankRepository rankRepository;
    @Autowired
    LevelRepository levelRepository;
    @RequestMapping(method = RequestMethod.GET,value = "seeder")
    public String index(){
        Random rand = new Random();
        for (int i = 0; i< 3;i++ ){
            Rank rank = new Rank();
            rank.setName("Level " + i);
            rank.setDescription("nothing");
            rank.setDiscount(Float.parseFloat(String.valueOf(i))*Float.parseFloat("0.5"));
            rankRepository.save(rank);
        }
        for (int i = 0; i< 3;i++ ){
            Level level = new Level();
            level.setName("Level " + i);
            level.setDescription("nothing");
            level.setPrice(100000 * i);
            level.setDurationInDay(TimeUnit.DAYS.toMillis(30));
            levelRepository.save(level);
        }
        List<String> FirstName = Arrays.asList("Hoang","Duong","Phong","Minh","Hoa","Ahh","Tra","Thu","Mai","Lan","Chi","Luyen");
        List<String> MiddleName = Arrays.asList("Thi","Van","Huu","Duc","Quynh","","Kim","Anh","Hong");
        List<String> LastName = Arrays.asList("Nguyen","Tran","Pham","Do","Le","Ung","Vu","Ly","Mai","Ngo","Dao");
        List<Integer> role = Arrays.asList(1,2,3);
        List<Rank> rankList = rankRepository.findAll();
        List<Level> levelList = levelRepository.findAll();
        for (int i = 0;i<100;i++) {
            Account account = new Account();
            UserInfo userInfo = new UserInfo();
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

            String username = FirstName.get(rand.nextInt(FirstName.size())) +
                    LastName.get(rand.nextInt(LastName.size())) +
                    String.valueOf(i + 1);
            System.out.println(username);
            userInfo.setEmail(username + "@gmail.com");
            account.setUsername(username);
            account.setPassword("123456");
            account.setRole(role.get(rand.nextInt(role.size())));
            if (account.getRole() == 1){
                userInfo.setRank(rankList.get(rand.nextInt(rankList.size())));
            }else if (account.getRole() == 2){
                Level level = levelList.get(rand.nextInt(levelList.size()));
                userInfo.setLevel(level);
                userInfo.setLevelExpiredAt(Calendar.getInstance().getTimeInMillis() + level.getDurationInDay());
            }
            userInfo.setAccount(account);
            accountRepository.save(account);
            userInfoRepository.save(userInfo);

        }
        return "home";
    }
}
