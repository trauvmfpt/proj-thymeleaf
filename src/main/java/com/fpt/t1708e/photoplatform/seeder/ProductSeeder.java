package com.fpt.t1708e.photoplatform.seeder;

import com.fpt.t1708e.photoplatform.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductSeeder {
    public static List<Product> productList = new ArrayList<>();

    public static void addProduct() {
        Product product = new Product();
        // 1. https://tuarts.net/ - https://tuarts.net/chup-anh-cuoi/ - https://tuarts.net/chup-anh-cho-be/
        // 2. http://anhgiadinh.com.vn/

        // 1. - Tuarts
        product.setName("Chụp ảnh cưới");
        product.setDescription("Tour chụp ảnh cưới hot nhất năm 2019 – 2020");
        product.setContent("Các cặp đôi đăng kí hợp đồng đặt lịch chụp trong khoảng từ 25.12 – 31.12.2019 sẽ nhận đồng thời các ƯU ĐÃI ĐẶC BIỆT:\n" +
                "                ✔ TẶNG ngay 1.000.000 VND\n" +
                "                ✔ MƯỢN MIỄN PHÍ váy cưới trị giá 4.000.000 thương hiệu váy cưới Bella Bridal.\n" +
                "                ✔ TẶNG tiếp#Voucher trị giá 3.000.000 VND khi mua nhẫn cưới tại thương hiệu trang sức cao cấp Cửu Long Jewelry.\n" +
                "                ✔ TẶNG tiếp #Voucher giảm 20% khi mua Vest cưới đến từ Thương hiệu Adam Store.\n" +
                "                ✔ TẶNG tiếp #Voucher giảm 15% khi mua nhẫn cưới đến từ Thương hiệu Huy Thanh Jewelry.\n" +
                "                ✔ TẶNG tiếp 500,000 VND khi đặt cổng hoa, thuê bàn ghế, hoa để bàn trị giá 1.000.000 VND đến từ thương hiệu Viet Anh Design Wedding Planer.");
        product.setDestination("");
        product.setArea("Vũng Tàu");
        product.setPrice(25000000);
        product.setPriceDiscount(22000000);
        product.setThumbnail("https://vcdn-ngoisao.vnecdn.net/2019/10/16/DN-OCT-2-9412-1571194639.jpg");
        product.setStatus(2);
        productList.add(product);

        // 2. - Tuarts
        product = new Product();
        product.setName("Chụp ảnh cưới");
        product.setDescription("Tour chụp ảnh cưới hot nhất năm 2019 – 2020");
        product.setContent("Từ 13.01.2020 – 20.01.2020. TuArt Team sẽ có mặt tại Mộc Châu với các gói chụp ưu đãi như sau:\n" +
                "                ️✔ KHUYẾN MẠI Tour chụp ảnh cưới tại Mộc Châu. Chi phí còn lại: 15.500.000 VND/ ngày\n" +
                "                ✔ Chi phí này Đã bao gồm chi phí đi lại từ Hà Nội – Mộc Châu, ăn ở của Ekip chụp, Quý khách hàng không phải lo chi phí này cho Ekip chụp hình nữa.");
        product.setDestination("");
        product.setArea("Mộc Châu");
        product.setPrice(15500000);
        product.setPriceDiscount(15500000);
        product.setThumbnail("http://namnguyenwedding.com/product_images/uploaded_images/y_3_1wtxi.jpg");
        productList.add(product);

        // 3. - Tuarts
        product = new Product();
        product.setName("Chụp ảnh cưới");
        product.setDescription("Tour chụp ảnh cưới hot nhất năm 2019 – 2020");
        product.setContent("Các cặp đôi đăng kí trong khoảng từ 24.12 – 31.12.2019 sẽ nhận đồng thời các ƯU ĐÃI ĐẶC BIỆT:\n" +
                "                ✔ TẶNG ngay 1.000.000 VND\n" +
                "                ✔ MƯỢN MIỄN PHÍ váy cưới trị giá 4.000.000 thương hiệu váy cưới Bella Bridal.\n" +
                "                ✔ TẶNG tiếp#Voucher trị giá 3.000.000 VND khi mua nhẫn cưới tại thương hiệu trang sức cao cấp Cửu Long Jewelry.\n" +
                "                ✔ TẶNG tiếp #Voucher giảm 20% khi mua Vest cưới đến từ Thương hiệu Adam Store.\n" +
                "                ✔ TẶNG tiếp #Voucher giảm 20% khi mua nhẫn cưới đến từ Thương hiệu Huy Thanh Jewelry.\n" +
                "                ✔ TẶNG tiếp 500,000 VND khi đặt cổng hoa, thuê bàn ghế, hoa để bàn trị giá 1.000.000 VND đến từ thương hiệu Viet Anh Design Wedding Planer.");
        product.setDestination("Tuart Tam Dao");
        product.setArea("Tam Đảo");
        product.setPrice(17000000);
        product.setPriceDiscount(1500000);
        product.setThumbnail("http://phimtruongalibaba.vn/photos/1/DICH_VU/DV_CHUP_ANH_CUOI/phim-truong-alibaba.jpg");
        productList.add(product);

        // 4. - Tuarts
        product = new Product();
        product.setName("Thuê váy cưới");
        product.setDescription("Xu hướng váy cưới đẹp mùa cưới 2019 - 2020");
        product.setContent("Từ 13.01.2020 – 20.01.2020. TuArt Team sẽ có mặt tại Mộc Châu với các gói chụp ưu đãi như sau:\n" +
                "                ️✔ KHUYẾN MẠI Tour chụp ảnh cưới tại Mộc Châu. Chi phí còn lại: 15.500.000 VND/ ngày\n" +
                "                ✔ Chi phí này Đã bao gồm chi phí đi lại từ Hà Nội – Mộc Châu, ăn ở của Ekip chụp, Quý khách hàng không phải lo chi phí này cho Ekip chụp hình nữa.");
        product.setDestination("");
        product.setArea("Tuart");
        product.setPrice(1500000);
        product.setPriceDiscount(1200000);
        product.setThumbnail("https://top10tphcm.com/wp-content/uploads/2019/06/top-dia-chi-cho-thue-vay-cuoi-dep-nhat-hcm-696x464.jpg");
        productList.add(product);

        // 5. - Tuarts
        product = new Product();
        product.setName("Dịch vụ trang điểm");
        product.setDescription("Makeup chuyên nghiệp");
        product.setContent("Lựa chọn - tư vấn phong cách, tone makup phù hợp với từng khách hàng\n" +
                "            Mỗi khách hàng, mỗi gương mặt đều có những điểm đặc biệt riêng và phù hợp với từng phong cách trang điểm khác nhau. Cũng tương tự, mỗi hoàn cảnh, sự kiện đều có sự lựa chọn riêng để phù hợp với bữu tiệc tiệc, chuyến đi chơi hay sự kiện...");
        product.setDestination("");
        product.setArea("Tại nhà");
        product.setPrice(700000);
        product.setPriceDiscount(700000);
        product.setThumbnail("https://image-us.eva.vn/upload/1-2019/images/2019-03-11/trang-diem-co-dau-va-nhung-xu-huong-duoc-yeu-thich-nhat-nam-2019-4-1552272028-826-width640height467.png");
        productList.add(product);

        // 6. - Tuarts
        product = new Product();
        product.setName("Chụp ảnh cho bé");
        product.setDescription("Lưu giữ những khoảnh khắc con yêu");
        product.setContent("Những ngày đầu tiên sau khi bé ra đời là quãng thời gian đầy háo hức và hy vọng – bắt đầu làm bố mẹ của một thiên thần còn nhỏ xíu. Bất cứ ông bố bà mẹ nào cũng muốn lưu giữ lại khoảnh khắc đáng yêu của bé.\n" +
                "                Vậy hãy đến Tuart để lưu giữ những khoảnh khắc dễ thương, ngộ nghĩnh của bé yêu nhà bạn nhé.\n" +
                "                Kinh nghiệm nhiều năm nên tuyệt đối an toàn cho bé\n" +
                "                Có thể để tận nhà để chụp.\n" +
                "                Chụp baby nhiều lứa tuổi.");
        product.setDestination("");
        product.setArea("Tuart");
        product.setPrice(3000000);
        product.setPriceDiscount(2500000);
        product.setThumbnail("http://emmykids.com/wp-content/uploads/2018/12/39047163_515010718955240_281535986721095680_o.jpg");
        product.setStatus(2);
        productList.add(product);

        // 7. - vivan
        product = new Product();
        product.setName("Trang Trí Sinh Nhật");
        product.setDescription("Khi sinh nhật của con bạn đang đến, chắc chắn bạn lo lắng về việc làm thế nào để gây bất ngờ con cái của họ.");
        product.setContent("Trẻ em chờ đợi cả năm để chào mừng cô ngày trọng đại. Vì vậy, nó sẽ là tuyệt vời nếu các bên sinh nhật chủ đề và bé thích ý nghĩa.\n" +
                "            Có rất nhiều chủ đề tiệc sinh nhật tuyệt vời cho các bậc cha mẹ lựa chọn. Tuy nhiên, cha mẹ nên chia độ tuổi của trẻ em và các con được đề nghị các ý tưởng của mình.\n" +
                "            sinh nhật tốt nhất theo chủ đề:\n" +
                "            - Thích hợp cho nhân cách của trẻ. Nếu bé của bạn nhút nhát và dè dặt, chọn một chủ đề bao gồm các hoạt động bình tĩnh. Nếu em bé của bạn là rất tích cực, chọn một chủ đề bao gồm các hoạt động ngoài trời.\n" +
                "            - Phổ biến với độ tuổi của trẻ em\n" +
                "            - Thích hợp cho ngân sách của các bậc cha mẹ.");
        product.setDestination("Home");
        product.setArea("Your Home");
        product.setPrice(3500000);
        product.setPriceDiscount(3200000);
        product.setThumbnail("https://picture.vn/wp-content/uploads/2018/01/dich-vu-chup-anh-gia-dinh-tai-nha-3.jpg");
        productList.add(product);

        // 8. - vivan
        product = new Product();
        product.setName("Chụp ảnh cưới và du lịch biển");
        product.setDescription("Tuần trăng mật là thời điểm quan trọng và đáng mong đợi nhất sau ngày cưới.");
        product.setContent("Đăng ký tour chụp ảnh cưới biển ngay trong tháng này để nhận những ưu đãi cực lớn mà chỉ Vivian mới có này nhé!\n" +
                "            ♛ Tặng ngay 3 triệu - 7,5 triệu/gói khi đăng ký dịch vụ tại 2 cơ sở của Vivian - Vivian 282 và Vivian Luxury 101\n" +
                "            ♚ Tặng thêm 1,500,000đ tiền mặt trực tiếp khi đăng ký sớm các gói chụp biển hè và ngoại thành Hà Nội\n" +
                "            ♜ Tặng miễn phí di chuyển và đi lại các tour ngoại thành miền Bắc\n" +
                "            ♟ Miễn Phí trang điểm cô dâu tại nhà hoặc nơi tổ chức tiệc cưới\n" +
                "            ♟ Sử dụng ÁO DÀI VIP miễn phí\n" +
                "            ♟ Được tư vấn và sử dụng váy cưới VIP miễn phí\n" +
                "            ❣ Đặc biệt hơn nữa, VIVIAN tặng bạn 01 buổi trang điểm và làm tóc nháp trước buổi chụp");
        product.setDestination("Halo ha");
        product.setArea("Vivian");
        product.setPrice(20000000);
        product.setPriceDiscount(12500000);
        product.setThumbnail("https://daminhtan.com/images/anh-cuoi-tai-ly-son-34.jpg");
        productList.add(product);

        // 9. - vivan
        product = new Product();
        product.setName("Quay Và Chụp Ảnh Sự Kiện");
        product.setDescription("Chụp ảnh sự kiện hội nghị, sinh nhật");
        product.setContent("Chuyên nghiệp - uy tín chụp ảnh sự kiện tại Vivian Studio đang là sự lựa chọn của nhiều cá nhân - công ty, nhãn hàng lớn không chỉ Hà Nội mà còn khắp miền Bắc.\n" +
                "            Chính bởi sự uy tín - chuyên nghiệp của Vivian Studio đã cho thấy khách hàng tin tưởng và sử dụng dịch vụ bên chúng tôi.");
        product.setDestination("");
        product.setArea("Vivian");
        product.setPrice(2500000);
        product.setPriceDiscount(2000000);
        product.setThumbnail("http://nguyenvinhdigital.com/profiles/nguyenvinhdigitalcom/uploads/attach/post/images/chu%CC%A3p-a%CC%89nh-su%CC%9B%CC%A3-kie%CC%A3%CC%82n-4-1024x683.jpg");
        product.setStatus(2);
        productList.add(product);

        // 10. - vivan
        product = new Product();
        product.setName("Sản xuất và cho thuê áo cưới");
        product.setDescription("Mơ ước mình sẽ thật xinh đẹp trong bộ váy cưới đẹp ");
        product.setContent("Trước ngày cưới ai cũng mơ ước mình sẽ thật xinh đẹp trong bộ váy cưới đẹp và lộng lẫy trắng tinh sánh vai cùng chú rể ra mắt bạn bè và quan khách hai họ trong ngày trọng đại. Để có váy cưới đẹp ở Hà Nội thì khách hàng có thể mua, may hoặc thuê.\n" +
                "            Thấu hiểu được điều ấy, Vivian chúng tôi luôn cố gắng giúp cô dâu có cơ hội tiếp cận và lựa chọn những chiếc áo cưới phù hợp nhất, thời trang nhất thông qua các dịch vụ cho thuê váy cưới giá rẻ Hà Nội và tối đa lợi ích của khách hàng");
        product.setDestination("");
        product.setArea("Vivian");
        product.setPrice(2500000);
        product.setPriceDiscount(1500000);
        product.setThumbnail("https://toplist.vn/images/800px/ao-dai-ciao-232261.jpg");
        productList.add(product);

        // 11. - Hailecao
        product = new Product();
        product.setName("Dạy học trang điểm cá nhân");
        product.setDescription("Phụ nữ đẹp thì có quà");
        product.setContent("Ai cũng muốn xuất hiện trước mặt mọi người với hình ảnh đẹp nhất. Chính vì vậy, phong trào học trang điểm hiện nay được rất nhiều chị em quan tâm và dành thời gian tìm hiểu những xu hướng làm đẹp mới.\n" +
                "            Bạn yêu thích trang điểm tự nhiên với 1 làn da phủ sương đầy sức sống?\n" +
                "            Bạn chưa biết gì về make up nhưng luôn muốn xuất hiện xinh đẹp trước mặt mọi người?\n" +
                "            Phong cách trang điểm Thái Lan, đánh khối giúp khuôn mặt thon gọn V-line làm bạn ao ước?\n" +
                "            Mỗi khi có dịp đặc biệt bạn phải nhờ người thân trang điểm hoặc thuê người trang điểm với chi phí không nhỏ?\n" +
                "            Đã đôi lần bạn tự trang điểm theo phong cách mình thích nhưng kết quả là mặt dày phấn, đánh màu mắt như “bị ai đấm”, màu môi nhợt nhạt không ăn nhập với tổng thể khuôn mặt?");
        product.setDestination("");
        product.setArea("Hailecao");
        product.setPrice(1700000);
        product.setPriceDiscount(1000000);
        product.setThumbnail("https://hocvienthammyp2h.edu.vn/wp-content/uploads/2017/10/L%E1%BB%9Bp-h%E1%BB%8Dc-trang-%C4%91i%E1%BB%83m-c%C3%A1-nh%C3%A2n-t%E1%BA%A1i-tphcm.jpg");
        productList.add(product);

        // 12. - Hailecao
        product = new Product();
        product.setName("Đào tạo nghề nhiếp ảnh");
        product.setDescription("Nhiếp ảnh là môn nghệ thuật cần sự sáng tạo");
        product.setContent("Nhiếp ảnh là môn nghệ thuật cần sự sáng tạo, với mỗi chủ đề người cầm máy luôn tạo ra cảm xúc thật nhất cho từng bức ảnh, đó là sự đam mê quên mình vì nghệ thuật. Với hơn 10 năm theo nghề ảnh, lúc đầu là vì THÍCH, sau đó là TRẢI NGHIỆM cùng những nghệ sĩ nhiếp ảnh đạt nhiều giải thưởng cao trong nước và quốc tế, dần dần giúp cho tôi có nhiều kinh nghiệm và đam mê nghề hơn. Với mong muốn chia sẻ những kinh nghiệm mình đã học được tới các bạn trẻ đang, đã và sẽ theo đuổi nghề ảnh, tôi cam kết sẽ mang đến cho các bạn những kinh nghiệm quý giá nhất mà tôi có kỳ vọng rằng: các bạn chính là những người trẻ mang đến cho đời những hình ảnh đẹp” – Phùng Anh Sơn\n" +
                "           Học viện Hailecao có hệ thống chương trình đào tạo nghề nhiếp ảnh cho những bạn yêu thích và đam mê môn học này");
        product.setDestination("123 Luong Van Bang");
        product.setArea("Hailecao");
        product.setPrice(8000000);
        product.setPriceDiscount(5000000);
        product.setThumbnail("https://i.ytimg.com/vi/sY7QpHMs_pA/hqdefault.jpg");
        productList.add(product);

        // 13. - Hailecao
        product = new Product();
        product.setName("Chụp ảnh gia đình");
        product.setDescription("Chụp ảnh gia đình lưu lại những khoảnh khắc đáng nhớ");
        product.setContent("Gia đình là mái ấm hạnh phúc nhất mà mỗi con người có trong cuộc đời của mình, nơi đó ta nhận được sự yêu thương, chăm sóc từ ông bà, bố mẹ bởi những tình cảm thân thương nhất. Gia đình còn là nơi che chở, bảo vệ ta, giúp ta trong những thời điểm khó khăn, đồng thời cũng cùng ta chia sẻ những niềm vui, nỗi buồn. Tuy nhiên trong cuộc sống hiện đại ngày nay vẫn đang ngày càng phát triển, mỗi thành viên trong gia đình đều bận rộn với công việc của mình, tất bật trong cuộc đời vì việc làm, có khi nào chúng ta nhớ về gia đình của mình, muốn có những phút giây cả gia đình quây quần bên nhau, chuyện trò vui vẻ.\n" +
                "            Vì vậy dịch vụ chụp ảnh gia đình của Hailecao với sứ mệnh lưu giữ lại những phút giây vui vẻ, hạnh phúc của gia đình trong những cuốn album.");
        product.setDestination("");
        product.setArea("Hailecao");
        product.setPrice(1500000);
        product.setPriceDiscount(1000000);
        product.setThumbnail("https://cdn.dealtoday.vn/img/s630x420/6f10bd1ca8e64f4ba1ffb82eff68b2bf.jpg?sign=Y-p5SVVEnKG8pajNVrsmAQ");
        productList.add(product);

        // 14. - Hailecao
        product = new Product();
        product.setName("Chụp ảnh bầu");
        product.setDescription("Chụp ảnh bầu đẹp");
        product.setContent("Lưu giữ lại khoảng thời gian người mẹ mang trong mình một sinh linh bé nhỏ, một thiên thần đáng yêu sắp đến với thế giới này\n" +
                "            Cảm nhận những giây phút bé yêu đang lớn dần trong bụng, hẳn bà mẹ nào cũng càm thấy hạnh phúc và tuyệt vời, sự yêu thương dành cho một thiên thần bé nhỏ sắp chào đời.\n" +
                "            Giây phút thiêng liêng ấy sẽ được Hailecao lưu giữ lại cho bạn với dịch vụ chụp ảnh bầu đẹp tại Hailecao.");
        product.setDestination("");
        product.setArea("Hailecao");
        product.setPrice(1500000);
        product.setPriceDiscount(1000000);
        product.setThumbnail("http://www.lavender.com.vn/wp-content/uploads/khi-nao-nen-chup-anh-bau-01.jpg");
        productList.add(product);

        // 15. - Hailecao
        product = new Product();
        product.setName("Chụp ảnh sản phẩm quảng cáo");
        product.setDescription("Chụp ảnh sản phẩm đẹp, chuyên nghiệp, chất lượng cao");
        product.setContent("Hình ảnh của sản phẩm là một trong những những yếu tố quan trọng bởi chúng là đại diện cho sản phẩm được quảng bá trên phương tiện thông tin đại chúng nhằm thu hút sự chú ý của khách hàng. Do đó, chụp ảnh sản phẩm là công việc quan trọng góp phần làm cho hình ảnh sản phẩm chân thực để có được lòng tin của khách đối với sản phẩm.");
        product.setDestination("");
        product.setArea("Hailecao");
        product.setPrice(1700000);
        product.setPriceDiscount(1500000);
        product.setThumbnail("https://chupanh.vn/wp-content/uploads/2017/11/14317363_1552279478131599_2305766279489871771_n.jpg");
        productList.add(product);


        // 16
        product = new Product();
        product.setName("Thuê trang phục kỷ yếu");
        product.setDescription("Thuê trang phục kỷ yếu rẻ, đẹp");
        product.setContent("Thuê trang phục  kỷ yếu rẻ, đẹp để cùng bạn bè ghi lại những khoảnh khắc kỷ niệm độc nhất của thời học sinh.");
        product.setDestination("");
        product.setArea("Tại nhà");
        product.setPrice(100000);
        product.setPriceDiscount(70000);
        product.setThumbnail("https://chupanh.vn/wp-content/uploads/2017/12/y-tuong-chup-anh-ky-yeu-nhom-nhieu-cam-xuc-cho-ban-ky0031.jpg");
        productList.add(product);

        // 18
        product = new Product();
        product.setName("Chụp ảnh kỷ yếu");
        product.setDescription("Lưu giữ khoảnh khắc kỷ niệm độc nhất của thời học sinh");
        product.setContent("Đội ngũ nhiếp ảnh gia trẻ - khỏe - nhiệt tình, luôn sẵn sàng “lăn lộn” mọi chiến trường cùng các bạn mà không \n" +
                "             quản ngại mưa nắng không từ chối mọi cơ hội quẩy cùng các bạn \n" +
                "             Ekip luôn tìm tòi, sáng tạo những góc chụp mới lạ để cho ra những bức ảnh kỷ yếu độc đáo và tinh tế nhất  \n" +
                "             Trang thiết bị đầy đủ, hiện đại cho nước ảnh đẹp, xóa phông nổi bật gương mặt, fisheye góc rộng\n" +
                "             Thoải mái chụp ảnh mà không cần lo lắng về việc bị giới hạn số ảnh chụp\n" +
                "             Ưu đãi với hàng loạt phụ kiện như: áo cử nhân, bằng tốt nghiệp, áo dài, áo vest, loa thùng, flycam…\n" +
                "             Mức giá vô cùng hấp dẫn, phù hợp với túi tiền của tất cả các bạn học sinh, sinh viên");
        product.setDestination("");
        product.setArea("Tại trường");
        product.setPrice(5000000);
        product.setPriceDiscount(3800000);
        product.setThumbnail("https://vietnam-blogger.com/wp-content/uploads/2019/01/4th_std9k.jpg");
        product.setStatus(2);
        productList.add(product);

        // 19
        product = new Product();
        product.setName("Dịch vụ quay phim");
        product.setDescription("Quay phim sự kiện");
        product.setContent("Quay phim sự kiện giá rẻ");
        product.setDestination("");
        product.setArea("Tại khu vực");
        product.setPrice(1200000);
        product.setPriceDiscount(800000);
        product.setThumbnail("https://flypro.vn/photos/lam-phim/catalog/cong-ty-quay-phim.jpg");
        productList.add(product);

        // 20
        product = new Product();
        product.setName("Ảnh cưới phong cách Trung Quốc");
        product.setDescription("Chụp ảnh cưới cổ trang Trung Quốc ");
        product.setContent("Chụp ảnh cưới cổ trang Trung Quốc mới xuất hiện tại Việt Nam cách đây một vài năm nhưng đã khiến giới trẻ bị mê hoặc và trở nên hot hơn bao giờ hết. Chắc hẳn đối với những mọt phim Hoa ngữ, các bạn đều sẽ ấn tượng với những bộ trang phục cô dâu, làm tóc, kiểu make up cầu kỳ, bắt mắt trong từng thước phim. Và giờ đây, không khó để bạn có thể sở hữu một bộ ảnh cưới với phong cách cổ trang Trung Quốc với những dịch vụ chuyên nghiệp của các studio chụp ảnh cưới chuyên nghiệp tại Hà Nội.");
        product.setDestination("");
        product.setArea("Tại Studio");
        product.setPrice(6000000);
        product.setPriceDiscount(5000000);
        product.setThumbnail("https://cdn.wehelp.vn/image/2019/10/19/800x534xchup,P20anh,P20cuoi,P20kieu,P20trung,P20quoc.jpg.pagespeed.ic.YJLCeJ4CH0.jpg");
        productList.add(product);

        // 21
        product = new Product();
        product.setName("Ảnh cưới phong cách Hàn Quốc");
        product.setDescription("Chụp ảnh cưới phong cách Hàn Quốc ");
        product.setContent("Chụp ảnh cưới theo phong cách Hàn Quốc đang là xu hướng được nhiều cặp đôi lựa chọn hiện nay. Những style chụp lãng mạn cùng những concept độc đáo, lãng mạn sẽ giúp các cặp đôi có được những khoảnh khắc ngọt ngào trong ngày quan trọng này.");
        product.setDestination("");
        product.setArea("Tại Studio");
        product.setPrice(9000000);
        product.setPriceDiscount(7500000);
        product.setThumbnail("https://www.marry.vn/wp-content/uploads/users/410590/2016/01/08/1-4-7163-1398680063.jpg");
        product.setStatus(2);
        productList.add(product);

         // 22
         product = new Product();
         product.setName("Dịch vụ cưới hỏi trọn gói");
         product.setDescription("Lễ ăn hỏi 9 tráp đặc biệt");
         product.setContent("Lễ ăn hỏi 9 tráp đặc biệt của chúng tôi gồm có các tráp sau:\n" +
                 "                 Tráp cau\n" +
                 "                 Tráp rượu thuốc ( 3 vang chile + 3 vina )\n" +
                 "                 Tráp Rồng\n" +
                 "                 Tráp Phượng\n" +
                 "                 Tráp xôi đỗ + lợn sữa(12kg)\n" +
                 "                 Tráp bánh cốm Nguyên Ninh 100h\n" +
                 "                 Tráp bánh phu thê Nguyên Ninh 100h\n" +
                 "                 Tráp sen Hàng Điếu 100h (11 hạt)\n" +
                 "                 Tráp chè Thái Nguyên 100h");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(8600000);
         product.setPriceDiscount(7500000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/06/9-TRAP-RP1-Copy.jpg");
         productList.add(product);

         // 23
         product = new Product();
         product.setName("Dịch vụ cho thuê bàn ghế");
         product.setDescription("Cho thuê bàn ghế vào dịp cưới, hội nghị");
         product.setContent("Bàn ghế đám cưới sử dụng ghế nhựa bọc váy và thắt nơ, Mốt thời thượng cho những nhà chật hẹp trong thành phố.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(500000);
         product.setPriceDiscount(350000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/03/nha-bat-ban-ghe-trang-hong-e1573832760570.jpg");
         productList.add(product);

         // 24
         product = new Product();
         product.setName("Dịch vụ cho thuê phông bạt ngày cưới");
         product.setDescription("Cho thuê bàn ghế vào dịp cưới, hội nghị");
         product.setContent("Bàn ghế đám cưới sử dụng ghế nhựa bọc váy và thắt nơ, Mốt thời thượng cho những nhà chật hẹp trong thành phố.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(1200000);
         product.setPriceDiscount(1000000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/03/cho-thuê-bàn-ghế-4-e1573111250106.jpg");
         productList.add(product);

         // 25
         product = new Product();
         product.setName("Dịch vụ cho thuê phông bạt ngày cưới");
         product.setDescription("Nhà bạt cưới hỏi cao cấp");
         product.setContent("Nhà bạt cưới hỏi cao cấp trang trí pha lê, hàng rào trắng, nhà bạt buộc nơ đẹp và bàn ghế cưới theo tông màu hiện đại  để tổ chức lễ cưới tại gia, lễ ăn hỏi, trang trí đám cưới tại nhà.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(1200000);
         product.setPriceDiscount(1000000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/03/cho-thuê-bàn-ghế-4-e1573111250106.jpg");
         productList.add(product);

         // 26
         product = new Product();
         product.setName("Dịch vụ thiên thần đám cưới");
         product.setDescription("Thiên thần đám cưới đẹp, gồm các bé xinh xắn độ tuổi từ 6-10 tuổi.");
         product.setContent("Nhà bạt cưới hỏi cao cấp trang trí pha lê, hàng rào trắng, nhà bạt buộc nơ đẹp và bàn ghế cưới theo tông màu hiện đại  để tổ chức lễ cưới tại gia, lễ ăn hỏi, trang trí đám cưới tại nhà.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(700000);
         product.setPriceDiscount(500000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/04/020111-lequyen5.jpg");
         productList.add(product);

         // 27
         product = new Product();
         product.setName("Cho thuê cổng hoa cưới");
         product.setDescription("Cổng hoa đám cưới");
         product.setContent("Cổng hoa đám cưới đẹp sử dụng toàn bộ bằng hoa lụa cao cấp.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(1200000);
         product.setPriceDiscount(1000000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/04/020111-lequyen5.jpg");
         productList.add(product);

         // 28
         product = new Product();
         product.setName("Dịch vụ bê tráp");
         product.setDescription("Dịch vụ bê tráp đám cưới");
         product.setContent("Thuê người bê tráp, dịch vụ cho thuê người bê tráp giá rẻ, chuyên nghiệp. Đội hình đồng đều, đúng giờ. Có mặt trước 1 tiếng đồng hồ.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(1500000);
         product.setPriceDiscount(1200000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/04/020111-lequyen5.jpg");
         productList.add(product);

         // 29
         product = new Product();
         product.setName("Thuê xe hoa đám cưới");
         product.setDescription("Xe hoa đám cưới");
         product.setContent("Những bức hình phong cảnh, tĩnh vật hay chân dung thường được sử dụng làm chất liệu trong loại hình chụp ảnh nghệ thuật. Tuy nhiên, không phải ai cũng có thể chụp được bức hình nghệ thuật ấn tượng và thực sự “chất” bởi điều đó đòi hỏi không chỉ là kỹ thuật chụp mà còn là khả năng nắm bắt cái hồn của nhân vật trong bức ảnh.\n" +
                 "                 Áo dài là trang phục truyền thống của dân tộc Việt Nam bởi thế các chị em rất ưa thích áo dài.Với kinh nghiêm lâu năm trong lĩnh vực chụp ảnh về áo dài tại Hà Nội luôn cung cấp cho các chị em những bức Ảnh nghệ thuật về chụp áo dài.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(100000);
         product.setPriceDiscount(800000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/05/20-2000.jpg");
         productList.add(product);

         // 30
         product = new Product();
         product.setName("Hoa xe cưới");
         product.setDescription("Xe hoa đám cưới");
         product.setContent("Những bức hình phong cảnh, tĩnh vật hay chân dung thường được sử dụng làm chất liệu trong loại hình chụp ảnh nghệ thuật. Tuy nhiên, không phải ai cũng có thể chụp được bức hình nghệ thuật ấn tượng và thực sự “chất” bởi điều đó đòi hỏi không chỉ là kỹ thuật chụp mà còn là khả năng nắm bắt cái hồn của nhân vật trong bức ảnh.\n" +
                 "                 Áo dài là trang phục truyền thống của dân tộc Việt Nam bởi thế các chị em rất ưa thích áo dài.Với kinh nghiêm lâu năm trong lĩnh vực chụp ảnh về áo dài tại Hà Nội luôn cung cấp cho các chị em những bức Ảnh nghệ thuật về chụp áo dài.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(2400000);
         product.setPriceDiscount(2000000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/05/19-1.900.jpg");
         productList.add(product);

         // 31
         product = new Product();
         product.setName("Hoa cô dâu");
         product.setDescription("Hoa cô dâu");
         product.setContent("Những bức hình phong cảnh, tĩnh vật hay chân dung thường được sử dụng làm chất liệu trong loại hình chụp ảnh nghệ thuật. Tuy nhiên, không phải ai cũng có thể chụp được bức hình nghệ thuật ấn tượng và thực sự “chất” bởi điều đó đòi hỏi không chỉ là kỹ thuật chụp mà còn là khả năng nắm bắt cái hồn của nhân vật trong bức ảnh.\n" +
                 "                 Áo dài là trang phục truyền thống của dân tộc Việt Nam bởi thế các chị em rất ưa thích áo dài.Với kinh nghiêm lâu năm trong lĩnh vực chụp ảnh về áo dài tại Hà Nội luôn cung cấp cho các chị em những bức Ảnh nghệ thuật về chụp áo dài.");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(900000);
         product.setPriceDiscount(900000);
         product.setThumbnail("http://cuoihoihoangvu.com.vn/wp-content/uploads/2014/05/21.jpg");
         productList.add(product);

         // 32
         product = new Product();
         product.setName("Phụ kiện cưới hỏi");
         product.setDescription("Phụ kiện cưới hỏi");
         product.setContent("Phụ kiện cưới hỏi bao gồm:\n" +
                 "                 Ấm chén\n" +
                 "                 Thảm đỏ \n" +
                 "                 Pháo giấy\n" +
                 "                 Quạt công nghiệp \n" +
                 "                 Bóng bay");
         product.setDestination("");
         product.setArea("Tại gia");
         product.setPrice(1200000);
         product.setPriceDiscount(900000);
         product.setThumbnail("https://i2.wp.com/fptnamdinh.com.vn/wp-content/uploads/2018/10/41784498_337533986993352_9178188963720986624_n.jpg?resize=640%2C640&ssl=1");
         productList.add(product);

         // 33
         product = new Product();
         product.setName("Dịch vụ chụp ảnh áo dài");
         product.setDescription("Chụp ảnh áo dài");
         product.setContent("Những bức hình phong cảnh, tĩnh vật hay chân dung thường được sử dụng làm chất liệu trong loại hình chụp ảnh nghệ thuật. Tuy nhiên, không phải ai cũng có thể chụp được bức hình nghệ thuật ấn tượng và thực sự “chất” bởi điều đó đòi hỏi không chỉ là kỹ thuật chụp mà còn là khả năng nắm bắt cái hồn của nhân vật trong bức ảnh.\n" +
                 "                 Áo dài là trang phục truyền thống của dân tộc Việt Nam bởi thế các chị em rất ưa thích áo dài.Với kinh nghiêm lâu năm trong lĩnh vực chụp ảnh về áo dài tại Hà Nội luôn cung cấp cho các chị em những bức Ảnh nghệ thuật về chụp áo dài.");
         product.setDestination("");
         product.setArea("Studio");
         product.setPrice(690000);
         product.setPriceDiscount(690000);
         product.setThumbnail("http://roses.vn/product_images/uploaded_images/12_rx4bd.jpg");
         productList.add(product);

         // 34
         product = new Product();
         product.setName("Dịch vụ chụp ảnh dã ngoại");
         product.setDescription("Chụp ảnh dã ngoại");
         product.setContent("Bạn đang muốn chụp ảnh dã ngoại để lưu lại những khoảnh khắc đáng nhớ trong cuộc đời như một kỷ niệm đẹp, nhưng bạn lại không biết địa chỉ nào ở Hà Nội Chụp ảnh dã ngoại giá rẻ mà chất lượng tốt. Bạn hãy yên tâm, sau đây chúng tôi sẽ Giới thiệu với bạn ảnh viện chuyên cung cấp dịch vụ chụp ảnh dã ngoại không chỉ chất lượng tốt, giá rẻ mà thái độ phục vụ cũng rất tuyệt vời nữa.");
         product.setDestination("");
         product.setArea("Studio");
         product.setPrice(1500000);
         product.setPriceDiscount(1400000);
         product.setThumbnail("http://roses.vn/product_images/d/431/img_2478__02997_zoom__14057_std.jpg");
         productList.add(product);

         // 35
         product = new Product();
         product.setName("Dịch vụ chụp ảnh nghệ thuật");
         product.setDescription("Chụp ảnh nghệ thuật");
         product.setContent("Những bức hình phong cảnh, tĩnh vật hay chân dung thường được sử dụng làm chất liệu trong loại hình chụp ảnh nghệ thuật. Tuy nhiên, không phải ai cũng có thể chụp được bức hình nghệ thuật ấn tượng và thực sự “chất” bởi điều đó đòi hỏi không chỉ là kỹ thuật chụp mà còn là khả năng nắm bắt cái hồn của nhân vật trong bức ảnh.\n" +
                 "                 Áo dài là trang phục truyền thống của dân tộc Việt Nam bởi thế các chị em rất ưa thích áo dài.Với kinh nghiêm lâu năm trong lĩnh vực chụp ảnh về áo dài tại Hà Nội luôn cung cấp cho các chị em những bức Ảnh nghệ thuật về chụp áo dài.");
         product.setDestination("");
         product.setArea("Studio");
         product.setPrice(7800000);
         product.setPriceDiscount(7800000);
         product.setThumbnail("http://roses.vn/product_images/uploaded_images/1111__99373_zoom_1wtxi.jpg");
         productList.add(product);
    }
}
