package com.fpt.t1708e.photoplatform.seeder;

import com.fpt.t1708e.photoplatform.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategorySeeder {
    public static List<Category> categoryList = new ArrayList<>();

    public static void addCate() {
        Category category = new Category();
        category.setName("LookBook Photo");
        category.setDescription("The key to good lookbook photography is simplicity, styling and brand alignment. We make sure all of our lookbook images match up to the expectations of the ..thing");
        category.setThumbnail("http://www.lafrankieagency.com/wp-content/uploads/2017/10/Vow_Studio_7060.jpg");
        categoryList.add(category);
        //
        category = new Category();
        category.setName("Wedding Photo");
        category.setDescription("Matrimony photography must be able to recount more than just a day: it has to reflect the colors and emotions of a union which is made of steps already taken there!");
        category.setThumbnail("https://www.marry.vn/wp-content/uploads/users/571865/2018/07/18/Aura-3.jpg");
        categoryList.add(category);
        //
        category = new Category();
        category.setName("Student Photo");
        category.setDescription("Photography School, the emphasis is not just on educating students on the fundamentals of photography, but helping them to discover their own voice.");
        category.setThumbnail("https://www.savethestudent.org/uploads/Girl-taking-a-photograph.jpg");
        categoryList.add(category);
        //
        category = new Category();
        category.setName("Portrait Photo");
        category.setDescription("Portrait photography or portraiture in photography is a photograph of a person or group of people that captures the personality of the subject by using effective lighting, backdrops, and poses.");
        category.setThumbnail("https://agc.creativelive.com/agc/201508-ADLERBOOTCAMP/Lindsay_Adler_Portrait_Photography_Bootcamp_WEB_1600x900.jpg");
        categoryList.add(category);
        //
        category = new Category();
        category.setName("Family Photo");
        category.setDescription("Family photography inspiration for your outdoor family photography and Christmas family photography photoshoots.");
        category.setThumbnail("http://www.mesmemosphotoblog.com/wp-content/uploads/2019/11/jamiedenholmphotography-flowermoundtx-familyphotography-116-1.jpg");
        categoryList.add(category);

    }
}
