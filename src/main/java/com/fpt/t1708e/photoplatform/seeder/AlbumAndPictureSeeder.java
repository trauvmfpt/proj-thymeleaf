package com.fpt.t1708e.photoplatform.seeder;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Picture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlbumAndPictureSeeder {
    public static List<Album> albumList = new ArrayList<>();

    public static void addAlbum(){
        Album album = new Album();
        album.setName("Wedding photo album");
        album.setDescription("Photo on beach. Beautiful and peaceful");
        Set<Picture> pictureSet = new HashSet<>();
        Picture picture = new Picture();
        picture.setUrl("https://www.marry.vn/wp-content/uploads/users/440119/2015/12/04/169.jpg");
        pictureSet.add(picture);
        
        picture = new Picture();
        picture.setUrl("https://hongkongwedding.com.vn/wp-content/uploads/2019/01/%C4%90%E1%BB%8Ba-%C4%91i%E1%BB%83m-ch%E1%BB%A5p-%E1%BA%A3nh-c%C6%B0%E1%BB%9Bi-ngo%E1%BA%A1i-c%E1%BA%A3nh-si%C3%AAu-%C4%91%E1%BA%B9p-n%C4%83m-2019-5-820x420.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://sansan.vn/wp-content/uploads/2018/07/chup-anh-cuoi-nha-trang-gia-re-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://hongkongwedding.com.vn/wp-content/uploads/2018/07/HKON3319-820x420.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://cdn.cungcap.net/media/img/2019/04/28/ZtJMS-1556436310.jpeg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://ngochuyphoto.com/multidata/luu-y-de-co-bo-anh-cuoi-bien-dep-tu-nhien-2.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://dinhthaistudio.vn/wp-content/uploads/2017/07/879-11-2.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://images.kienthuc.net.vn/zoom/800/uploaded/nguyenanhson/2015_11_13/e/anh-cuoi-tren-bien-dep-long-lanh-hut-hon-cac-cap-doi-hinh-4.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://kitovilla.com/wp-content/uploads/2018/09/dia-diem-chup-anh-cuoi-vung-tau-cho-thue-biet-thu-vung-tau-3.png");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://alenvina.com/rfilemanager/source/tintuc/da-nang-hoi-an-2018/da-nang-hoi-an-2018-IS0A0535.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);

        // 3 
        album = new Album();
        album.setName("Biệt thự hoa hồng");
        album.setDescription("");
        pictureSet = new HashSet<>();
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/1U6A1642.jpg");
        pictureSet.add(picture);
        
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/1U6A1864.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/1U6A1828.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/1U6A1777.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/1U6A1315.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/1U6A1217.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/1U6A1874.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/1U6A1960.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/1U6A2013.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/1U6A2088.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);

        // 4 
        album = new Album();
        album.setName("Ảnh cưới Trung Quốc");
        album.setDescription("");
        pictureSet = new HashSet<>();
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/41.jpg");
        pictureSet.add(picture);
        
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/35.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/47.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/29.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/31.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/36.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/34.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/30.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/44.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/39.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);

        // 5
        album = new Album();
        album.setName("Ảnh cưới Hàn Quốc");
        album.setDescription("");
        pictureSet = new HashSet<>();
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/23.jpg");
        pictureSet.add(picture);
        
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/12.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/10-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/28-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/24-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/21.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/16-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/7-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/0.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/09/6.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);

        // 6
        album = new Album();
        album.setName("Ảnh cưới Hoàng Anh");
        album.setDescription("");
        pictureSet = new HashSet<>();
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/1U8A4853.jpg");
        pictureSet.add(picture);
        
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/07/1U8A4796.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/07/1U8A4937.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/07/1U8A4409.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/07/1U8A5125coppy.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/1U8A5139.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/1U8A5087.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/07/1U8A4996.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/1U8A4598.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/07/b%C3%ACa-h%E1%BB%99p-tr%C6%B0%E1%BB%9Bc.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);

        // 7
        album = new Album();
        album.setName("Ảnh cưới Phố cổ");
        album.setDescription("");
        pictureSet = new HashSet<>();
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8434.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/C2A7080.png");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/C2A7026.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8614.png");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8480.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/C2A7107.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8644.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8461.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8577.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8508.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);

        // 8
        album = new Album();
        album.setName("Ảnh cưới Rosa - Trill");
        album.setDescription("");
        pictureSet = new HashSet<>();
        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8940.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8942-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8924-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8954coppy.png");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A9317.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A9323.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A9299-1.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2018/12/1U8A9189.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/001.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("https://salomonstudio.com/wp-content/uploads/2019/05/1U8A8968coppy-1.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);

        // 9
        album = new Album();
        album.setName("Áo dài truyền thống");
        album.setDescription("");
        pictureSet = new HashSet<>();
        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/t/930/_tub0131__20300_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/m/202/_tub0268__11714_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/w/501/_tub0309__28380_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/f/544/img_7017__77693_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/r/589/_mg_0527__20554_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/c/056/_tub0027__74029_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/r/744/16113927847_52ce18e07e_o__53630_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/w/790/dsc_4994__30535_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/s/813/img_8080__19935_zoom.jpg");
        pictureSet.add(picture);

        picture = new Picture();
        picture.setUrl("http://roses.vn/product_images/c/015/img_2548__62156_zoom.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);
    }
}