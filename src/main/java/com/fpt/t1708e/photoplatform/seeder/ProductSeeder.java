package com.fpt.t1708e.photoplatform.seeder;

import com.fpt.t1708e.photoplatform.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductSeeder {
    public static List<Product> productList = new ArrayList<>();
    public void addProduct(){
       Product product = new Product();
        // 1. https://tuarts.net/ - https://tuarts.net/chup-anh-cuoi/ - https://tuarts.net/chup-anh-cho-be/
        // 2. http://anhgiadinh.com.vn/

        // 1. - Tuarts
        // product.setName("Chụp ảnh cưới");
        // product.setDescription("Tour chụp ảnh cưới hot nhất năm 2019 – 2020");
        // product.setContent("
        //     Các cặp đôi đăng kí hợp đồng đặt lịch chụp trong khoảng từ 25.12 – 31.12.2019 sẽ nhận đồng thời các ƯU ĐÃI ĐẶC BIỆT:
        //         ✔ TẶNG ngay 1.000.000 VND
        //         ✔ MƯỢN MIỄN PHÍ váy cưới trị giá 4.000.000 thương hiệu váy cưới Bella Bridal.
        //         ✔ TẶNG tiếp#Voucher trị giá 3.000.000 VND khi mua nhẫn cưới tại thương hiệu trang sức cao cấp Cửu Long Jewelry.
        //         ✔ TẶNG tiếp #Voucher giảm 20% khi mua Vest cưới đến từ Thương hiệu Adam Store.
        //         ✔ TẶNG tiếp #Voucher giảm 15% khi mua nhẫn cưới đến từ Thương hiệu Huy Thanh Jewelry.
        //         ✔ TẶNG tiếp 500,000 VND khi đặt cổng hoa, thuê bàn ghế, hoa để bàn trị giá 1.000.000 VND đến từ thương hiệu Viet Anh Design Wedding Planer.
        // ");
        // product.setDestination("");
        // product.setArea("Vũng Tàu");
        // product.setPrice("25000000");
        // product.setPriceDiscount("22000000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 2. - Tuarts
        // product.setName("Chụp ảnh cưới");
        // product.setDescription("Tour chụp ảnh cưới hot nhất năm 2019 – 2020");
        // product.setContent("
        //     Từ 13.01.2020 – 20.01.2020. TuArt Team sẽ có mặt tại Mộc Châu với các gói chụp ưu đãi như sau:
        //         ✔ KHUYẾN MẠI Tour chụp ảnh cưới tại Mộc Châu. Chi phí còn lại: 15.500.000 VND/ ngày
        //         ✔ Chi phí này Đã bao gồm chi phí đi lại từ Hà Nội – Mộc Châu, ăn ở của Ekip chụp, Quý khách hàng không phải lo chi phí này cho Ekip chụp hình nữa.
        // ");
        // product.setDestination("");
        // product.setArea("Mộc Châu");
        // product.setPrice("15500000");
        // product.setPriceDiscount("15500000");
        // product.setThumbnail("");
        // productList.add(product);

        //     // 3. - Tuarts
        // product.setName("Chụp ảnh cưới");
        // product.setDescription("Tour chụp ảnh cưới hot nhất năm 2019 – 2020");
        // product.setContent("
        //     Các cặp đôi đăng kí trong khoảng từ 24.12 – 31.12.2019 sẽ nhận đồng thời các ƯU ĐÃI ĐẶC BIỆT:
        //         ✔ TẶNG ngay 1.000.000 VND
        //         ✔ MƯỢN MIỄN PHÍ váy cưới trị giá 4.000.000 thương hiệu váy cưới Bella Bridal.
        //         ✔ TẶNG tiếp#Voucher trị giá 3.000.000 VND khi mua nhẫn cưới tại thương hiệu trang sức cao cấp Cửu Long Jewelry.
        //         ✔ TẶNG tiếp #Voucher giảm 20% khi mua Vest cưới đến từ Thương hiệu Adam Store.
        //         ✔ TẶNG tiếp #Voucher giảm 20% khi mua nhẫn cưới đến từ Thương hiệu Huy Thanh Jewelry.
        //         ✔ TẶNG tiếp 500,000 VND khi đặt cổng hoa, thuê bàn ghế, hoa để bàn trị giá 1.000.000 VND đến từ thương hiệu Viet Anh Design Wedding Planer.
        // ");
        // product.setDestination("");
        // product.setArea("Tam Đảo");
        // product.setPrice("17000000");
        // product.setPriceDiscount("1500000");
        // product.setThumbnail("");
        // productList.add(product);

        //     // 4. - Tuarts
        // product.setName("Thuê váy cưới");
        // product.setDescription("Xu hướng váy cưới đẹp mùa cưới 2019 - 2020");
        // product.setContent("
        //     Từ 13.01.2020 – 20.01.2020. TuArt Team sẽ có mặt tại Mộc Châu với các gói chụp ưu đãi như sau:
        //         ✔ KHUYẾN MẠI Tour chụp ảnh cưới tại Mộc Châu. Chi phí còn lại: 15.500.000 VND/ ngày
        //         ✔ Chi phí này Đã bao gồm chi phí đi lại từ Hà Nội – Mộc Châu, ăn ở của Ekip chụp, Quý khách hàng không phải lo chi phí này cho Ekip chụp hình nữa.
        // ");
        // product.setDestination("");
        // product.setArea("Tuart");
        // product.setPrice("1500000");
        // product.setPriceDiscount("1200000");
        // product.setThumbnail("");
        // productList.add(product);

        //     // 5. - Tuarts
        // product.setName("Dịch vụ trang điểm");
        // product.setDescription("Makeup chuyên nghiệp");
        // product.setContent("
        //     Lựa chọn - tư vấn phong cách, tone makup phù hợp với từng khách hàng
        //     Mỗi khách hàng, mỗi gương mặt đều có những điểm đặc biệt riêng và phù hợp với từng phong cách trang điểm khác nhau. Cũng tương tự, mỗi hoàn cảnh, sự kiện đều có sự lựa chọn riêng để phù hợp với bữu tiệc tiệc, chuyến đi chơi hay sự kiện...
        // ");
        // product.setDestination("");
        // product.setArea("Tại nhà");
        // product.setPrice("700000");
        // product.setPriceDiscount("700000");
        // product.setThumbnail("");
        // productList.add(product);

        //     // 6. - Tuarts
        // product.setName("Chụp ảnh cho bé");
        // product.setDescription("Lưu giữ những khoảnh khắc con yêu");
        // product.setContent("
        //     Những ngày đầu tiên sau khi bé ra đời là quãng thời gian đầy háo hức và hy vọng – bắt đầu làm bố mẹ của một thiên thần còn nhỏ xíu. Bất cứ ông bố bà mẹ nào cũng muốn lưu giữ lại khoảnh khắc đáng yêu của bé.
        //         Vậy hãy đến Tuart để lưu giữ những khoảnh khắc dễ thương, ngộ nghĩnh của bé yêu nhà bạn nhé.
        //         Kinh nghiệm nhiều năm nên tuyệt đối an toàn cho bé
        //         Có thể để tận nhà để chụp.
        //         Chụp baby nhiều lứa tuổi.
        // ");
        // product.setDestination("");
        // product.setArea("Tuart");
        // product.setPrice("3000000");
        // product.setPriceDiscount("2500000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 7. - vivan
        // product.setName("Trang Trí Sinh Nhật");
        // product.setDescription("Khi sinh nhật của con bạn đang đến, chắc chắn bạn lo lắng về việc làm thế nào để gây bất ngờ con cái của họ.");
        // product.setContent("
        //     Trẻ em chờ đợi cả năm để chào mừng cô ngày trọng đại. Vì vậy, nó sẽ là tuyệt vời nếu các bên sinh nhật chủ đề và bé thích ý nghĩa.
        //     Có rất nhiều chủ đề tiệc sinh nhật tuyệt vời cho các bậc cha mẹ lựa chọn. Tuy nhiên, cha mẹ nên chia độ tuổi của trẻ em và các con được đề nghị các ý tưởng của mình.
        //     sinh nhật tốt nhất theo chủ đề:
        //     - Thích hợp cho nhân cách của trẻ. Nếu bé của bạn nhút nhát và dè dặt, chọn một chủ đề bao gồm các hoạt động bình tĩnh. Nếu em bé của bạn là rất tích cực, chọn một chủ đề bao gồm các hoạt động ngoài trời.
        //     - Phổ biến với độ tuổi của trẻ em
        //     - Thích hợp cho ngân sách của các bậc cha mẹ.
        // ");
        // product.setDestination("");
        // product.setArea("");
        // product.setPrice("3500000");
        // product.setPriceDiscount("3200000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 8. - vivan
        // product.setName("Chụp ảnh cưới và du lịch biển");
        // product.setDescription("Tuần trăng mật là thời điểm quan trọng và đáng mong đợi nhất sau ngày cưới.");
        // product.setContent("
        //     Đăng ký tour chụp ảnh cưới biển ngay trong tháng này để nhận những ưu đãi cực lớn mà chỉ Vivian mới có này nhé!
        //     ♛ Tặng ngay 3 triệu - 7,5 triệu/gói khi đăng ký dịch vụ tại 2 cơ sở của Vivian - Vivian 282 và Vivian Luxury 101
        //     ♚ Tặng thêm 1,500,000đ tiền mặt trực tiếp khi đăng ký sớm các gói chụp biển hè và ngoại thành Hà Nội
        //     ♜ Tặng miễn phí di chuyển và đi lại các tour ngoại thành miền Bắc
        //     ♟ Miễn Phí trang điểm cô dâu tại nhà hoặc nơi tổ chức tiệc cưới
        //     ♟ Sử dụng ÁO DÀI VIP miễn phí
        //     ♟ Được tư vấn và sử dụng váy cưới VIP miễn phí
        //     ❣ Đặc biệt hơn nữa, VIVIAN tặng bạn 01 buổi trang điểm và làm tóc nháp trước buổi chụp
        // ");
        // product.setDestination("");
        // product.setArea("Vivian");
        // product.setPrice("20000000");
        // product.setPriceDiscount("12500000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 9. - vivan
        // product.setName("Quay Và Chụp Ảnh Sự Kiện");
        // product.setDescription("Chụp ảnh sự kiện hội nghị, sinh nhật");
        // product.setContent("
        //     Chuyên nghiệp - uy tín chụp ảnh sự kiện tại Vivian Studio đang là sự lựa chọn của nhiều cá nhân - công ty, nhãn hàng lớn không chỉ Hà Nội mà còn khắp miền Bắc.
        //     Chính bởi sự uy tín - chuyên nghiệp của Vivian Studio đã cho thấy khách hàng tin tưởng và sử dụng dịch vụ bên chúng tôi.
        // ");
        // product.setDestination("");
        // product.setArea("Vivian");
        // product.setPrice("2500000");
        // product.setPriceDiscount("2000000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 10. - vivan
        // product.setName("Sản xuất và cho thuê áo cưới");
        // product.setDescription("Mơ ước mình sẽ thật xinh đẹp trong bộ váy cưới đẹp ");
        // product.setContent("
        //     Trước ngày cưới ai cũng mơ ước mình sẽ thật xinh đẹp trong bộ váy cưới đẹp và lộng lẫy trắng tinh sánh vai cùng chú rể ra mắt bạn bè và quan khách hai họ trong ngày trọng đại. Để có váy cưới đẹp ở Hà Nội thì khách hàng có thể mua, may hoặc thuê.
        //     Thấu hiểu được điều ấy, Vivian chúng tôi luôn cố gắng giúp cô dâu có cơ hội tiếp cận và lựa chọn những chiếc áo cưới phù hợp nhất, thời trang nhất thông qua các dịch vụ cho thuê váy cưới giá rẻ Hà Nội và tối đa lợi ích của khách hàng
        // ");
        // product.setDestination("");
        // product.setArea("Vivian");
        // product.setPrice("2500000");
        // product.setPriceDiscount("1500000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 11. - Hailecao
        // product.setName("Dạy học trang điểm cá nhân");
        // product.setDescription("Phụ nữ đẹp thì có quà");
        // product.setContent("
        //     Ai cũng muốn xuất hiện trước mặt mọi người với hình ảnh đẹp nhất. Chính vì vậy, phong trào học trang điểm hiện nay được rất nhiều chị em quan tâm và dành thời gian tìm hiểu những xu hướng làm đẹp mới.
        //     Bạn yêu thích trang điểm tự nhiên với 1 làn da phủ sương đầy sức sống?
        //     Bạn chưa biết gì về make up nhưng luôn muốn xuất hiện xinh đẹp trước mặt mọi người?
        //     Phong cách trang điểm Thái Lan, đánh khối giúp khuôn mặt thon gọn V-line làm bạn ao ước?
        //     Mỗi khi có dịp đặc biệt bạn phải nhờ người thân trang điểm hoặc thuê người trang điểm với chi phí không nhỏ?
        //     Đã đôi lần bạn tự trang điểm theo phong cách mình thích nhưng kết quả là mặt dày phấn, đánh màu mắt như “bị ai đấm”, màu môi nhợt nhạt không ăn nhập với tổng thể khuôn mặt?
        // ");
        // product.setDestination("");
        // product.setArea("Hailecao");
        // product.setPrice("1700000");
        // product.setPriceDiscount("1000000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 12. - Hailecao
        // product.setName("Đào tạo nghề nhiếp ảnh");
        // product.setDescription("Nhiếp ảnh là môn nghệ thuật cần sự sáng tạo");
        // product.setContent("
        //     Nhiếp ảnh là môn nghệ thuật cần sự sáng tạo, với mỗi chủ đề người cầm máy luôn tạo ra cảm xúc thật nhất cho từng bức ảnh, đó là sự đam mê quên mình vì nghệ thuật. Với hơn 10 năm theo nghề ảnh, lúc đầu là vì THÍCH, sau đó là TRẢI NGHIỆM cùng những nghệ sĩ nhiếp ảnh đạt nhiều giải thưởng cao trong nước và quốc tế, dần dần giúp cho tôi có nhiều kinh nghiệm và đam mê nghề hơn. Với mong muốn chia sẻ những kinh nghiệm mình đã học được tới các bạn trẻ đang, đã và sẽ theo đuổi nghề ảnh, tôi cam kết sẽ mang đến cho các bạn những kinh nghiệm quý giá nhất mà tôi có kỳ vọng rằng: các bạn chính là những người trẻ mang đến cho đời những hình ảnh đẹp” – Phùng Anh Sơn
        //     Học viện Hailecao có hệ thống chương trình đào tạo nghề nhiếp ảnh cho những bạn yêu thích và đam mê môn học này
        // ");
        // product.setDestination("");
        // product.setArea("Hailecao");
        // product.setPrice("8000000");
        // product.setPriceDiscount("5000000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 13. - Hailecao
        // product.setName("Chụp ảnh gia đình");
        // product.setDescription("Chụp ảnh gia đình lưu lại những khoảnh khắc đáng nhớ");
        // product.setContent("
        //     Gia đình là mái ấm hạnh phúc nhất mà mỗi con người có trong cuộc đời của mình, nơi đó ta nhận được sự yêu thương, chăm sóc từ ông bà, bố mẹ bởi những tình cảm thân thương nhất. Gia đình còn là nơi che chở, bảo vệ ta, giúp ta trong những thời điểm khó khăn, đồng thời cũng cùng ta chia sẻ những niềm vui, nỗi buồn. Tuy nhiên trong cuộc sống hiện đại ngày nay vẫn đang ngày càng phát triển, mỗi thành viên trong gia đình đều bận rộn với công việc của mình, tất bật trong cuộc đời vì việc làm, có khi nào chúng ta nhớ về gia đình của mình, muốn có những phút giây cả gia đình quây quần bên nhau, chuyện trò vui vẻ.
        //     Vì vậy dịch vụ chụp ảnh gia đình của Hailecao với sứ mệnh lưu giữ lại những phút giây vui vẻ, hạnh phúc của gia đình trong những cuốn album.
        // ");
        // product.setDestination("");
        // product.setArea("Hailecao");
        // product.setPrice("1500000");
        // product.setPriceDiscount("1000000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 14. - Hailecao
        // product.setName("Chụp ảnh bầu");
        // product.setDescription("Chụp ảnh bầu đẹp");
        // product.setContent("
        //     Lưu giữ lại khoảng thời gian người mẹ mang trong mình một sinh linh bé nhỏ, một thiên thần đáng yêu sắp đến với thế giới này
        //     Cảm nhận những giây phút bé yêu đang lớn dần trong bụng, hẳn bà mẹ nào cũng càm thấy hạnh phúc và tuyệt vời, sự yêu thương dành cho một thiên thần bé nhỏ sắp chào đời.
        //     Giây phút thiêng liêng ấy sẽ được Hailecao lưu giữ lại cho bạn với dịch vụ chụp ảnh bầu đẹp tại Hailecao.
        // ");
        // product.setDestination("");
        // product.setArea("Hailecao");
        // product.setPrice("1500000");
        // product.setPriceDiscount("1000000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 15. - Hailecao
        // product.setName("Chụp ảnh sản phẩm quảng cáo");
        // product.setDescription("Chụp ảnh sản phẩm đẹp, chuyên nghiệp, chất lượng cao");
        // product.setContent("
        //     Hình ảnh của sản phẩm là một trong những những yếu tố quan trọng bởi chúng là đại diện cho sản phẩm được quảng bá trên phương tiện thông tin đại chúng nhằm thu hút sự chú ý của khách hàng. Do đó, chụp ảnh sản phẩm là công việc quan trọng góp phần làm cho hình ảnh sản phẩm chân thực để có được lòng tin của khách đối với sản phẩm.
        // ");
        // product.setDestination("");
        // product.setArea("Hailecao");
        // product.setPrice("1700000");
        // product.setPriceDiscount("1500000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 16
        // product.setName("Thuê trang phục kỷ yếu");
        // product.setDescription("Thuê trang phục kỷ yếu rẻ, đẹp");
        // product.setContent("
        //     Thuê trang phục  kỷ yếu rẻ, đẹp để cùng bạn bè ghi lại những khoảnh khắc kỷ niệm độc nhất của thời học sinh. 
        // ");
        // product.setDestination("");
        // product.setArea("Tại nhà");
        // product.setPrice("100000");
        // product.setPriceDiscount("70000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 18
        // product.setName("Chụp ảnh kỷ yếu");
        // product.setDescription("Lưu giữ khoảnh khắc kỷ niệm độc nhất của thời học sinh");
        // product.setContent("
        //     Đội ngũ nhiếp ảnh gia trẻ - khỏe - nhiệt tình, luôn sẵn sàng “lăn lộn” mọi chiến trường cùng các bạn mà không 
        //     quản ngại mưa nắng không từ chối mọi cơ hội quẩy cùng các bạn 
        //     Ekip luôn tìm tòi, sáng tạo những góc chụp mới lạ để cho ra những bức ảnh kỷ yếu độc đáo và tinh tế nhất  
        //     Trang thiết bị đầy đủ, hiện đại cho nước ảnh đẹp, xóa phông nổi bật gương mặt, fisheye góc rộng
        //     Thoải mái chụp ảnh mà không cần lo lắng về việc bị giới hạn số ảnh chụp
        //     Ưu đãi với hàng loạt phụ kiện như: áo cử nhân, bằng tốt nghiệp, áo dài, áo vest, loa thùng, flycam…
        //     Mức giá vô cùng hấp dẫn, phù hợp với túi tiền của tất cả các bạn học sinh, sinh viên
        // ");
        // product.setDestination("");
        // product.setArea("Tại trường");
        // product.setPrice("5000000");
        // product.setPriceDiscount("3800000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 19
        // product.setName("Dịch vụ quay phim");
        // product.setDescription("Quay phim sự kiện");
        // product.setContent("
        //     Quay phim sự kiện giá rẻ
        // ");
        // product.setDestination("");
        // product.setArea("Tại khu vực");
        // product.setPrice("1200000");
        // product.setPriceDiscount("800000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 20
        // product.setName("Ảnh cưới phong cách Trung Quốc");
        // product.setDescription("Chụp ảnh cưới cổ trang Trung Quốc ");
        // product.setContent("
        //     Chụp ảnh cưới cổ trang Trung Quốc mới xuất hiện tại Việt Nam cách đây một vài năm nhưng đã khiến giới trẻ bị mê hoặc và trở nên hot hơn bao giờ hết. Chắc hẳn đối với những mọt phim Hoa ngữ, các bạn đều sẽ ấn tượng với những bộ trang phục cô dâu, làm tóc, kiểu make up cầu kỳ, bắt mắt trong từng thước phim. Và giờ đây, không khó để bạn có thể sở hữu một bộ ảnh cưới với phong cách cổ trang Trung Quốc với những dịch vụ chuyên nghiệp của các studio chụp ảnh cưới chuyên nghiệp tại Hà Nội.
        // ");
        // product.setDestination("");
        // product.setArea("Tại Studio");
        // product.setPrice("6000000");
        // product.setPriceDiscount("5000000");
        // product.setThumbnail("");
        // productList.add(product);

        // // 21
        // product.setName("Ảnh cưới phong cách Hàn Quốc");
        // product.setDescription("Chụp ảnh cưới phong cách Hàn Quốc ");
        // product.setContent("
        //     Chụp ảnh cưới theo phong cách Hàn Quốc đang là xu hướng được nhiều cặp đôi lựa chọn hiện nay. Những style chụp lãng mạn cùng những concept độc đáo, lãng mạn sẽ giúp các cặp đôi có được những khoảnh khắc ngọt ngào trong ngày quan trọng này.
        // ");
        // product.setDestination("");
        // product.setArea("Tại Studio");
        // product.setPrice("9000000");
        // product.setPriceDiscount("7500000");
        // product.setThumbnail("");
        // productList.add(product);
    }
}
