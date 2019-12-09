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
        //
        picture = new Picture();
        picture.setUrl("https://hongkongwedding.com.vn/wp-content/uploads/2019/01/%C4%90%E1%BB%8Ba-%C4%91i%E1%BB%83m-ch%E1%BB%A5p-%E1%BA%A3nh-c%C6%B0%E1%BB%9Bi-ngo%E1%BA%A1i-c%E1%BA%A3nh-si%C3%AAu-%C4%91%E1%BA%B9p-n%C4%83m-2019-5-820x420.jpg");
        pictureSet.add(picture);
//
        picture = new Picture();
        picture.setUrl("https://sansan.vn/wp-content/uploads/2018/07/chup-anh-cuoi-nha-trang-gia-re-1.jpg");
        pictureSet.add(picture);

        //
        picture = new Picture();
        picture.setUrl("https://hongkongwedding.com.vn/wp-content/uploads/2018/07/HKON3319-820x420.jpg");
        pictureSet.add(picture);

        //
        picture = new Picture();
        picture.setUrl("https://cdn.cungcap.net/media/img/2019/04/28/ZtJMS-1556436310.jpeg");
        pictureSet.add(picture);

        //
        picture = new Picture();
        picture.setUrl("http://ngochuyphoto.com/multidata/luu-y-de-co-bo-anh-cuoi-bien-dep-tu-nhien-2.jpg");
        pictureSet.add(picture);

        //
        picture = new Picture();
        picture.setUrl("http://dinhthaistudio.vn/wp-content/uploads/2017/07/879-11-2.jpg");
        pictureSet.add(picture);

        //
        picture = new Picture();
        picture.setUrl("https://images.kienthuc.net.vn/zoom/800/uploaded/nguyenanhson/2015_11_13/e/anh-cuoi-tren-bien-dep-long-lanh-hut-hon-cac-cap-doi-hinh-4.jpg");
        pictureSet.add(picture);

        //
        picture = new Picture();
        picture.setUrl("https://kitovilla.com/wp-content/uploads/2018/09/dia-diem-chup-anh-cuoi-vung-tau-cho-thue-biet-thu-vung-tau-3.png");
        pictureSet.add(picture);

        //
        picture = new Picture();
        picture.setUrl("https://alenvina.com/rfilemanager/source/tintuc/da-nang-hoi-an-2018/da-nang-hoi-an-2018-IS0A0535.jpg");
        pictureSet.add(picture);

        album.setThumbnail(picture.getUrl());
        album.setPictureSet(pictureSet);
        albumList.add(album);

    }
}
