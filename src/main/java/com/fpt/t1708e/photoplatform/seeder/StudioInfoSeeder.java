package com.fpt.t1708e.photoplatform.seeder;

import com.fpt.t1708e.photoplatform.entity.StudioInfo;

import java.util.ArrayList;
import java.util.List;

public class StudioInfoSeeder {
    public static List<StudioInfo> studioInfos = new ArrayList<>();
    public void addStudio(){
       StudioInfo studioInfo = new StudioInfo();
        // https://toplist.vn/top-list/studio-chup-anh-cuoi-dep-noi-tieng-o-ha-noi-3901.htm

        // 1. 
    //    studioInfo.setFullName("Tuarts");
    //    studioInfo.setDescription("
    //        Thế mạnh của TuArts là những bộ ảnh mang đậm màu sắc và phong cách lãng mạn kiểu Hàn Quốc, châu Âu. Phong cách ảnh của TuArts rất rõ ràng, luôn tìm hiểu mong muốn của khách hàng để có thể tạo ra được những bố cục ấn tượng thể hiện được nét tự nhiên và mà vẫn chất lừ. Từng bức ảnh sẽ lưu lại vẻ đẹp đậm chất tình và và không kém phần độc đáo của các cặp đôi uyên ương.
    //        TuArts có đầy đủ các dịch vụ: chụp ảnh cưới, ảnh ăn hỏi, sử dụng váy cưới và nhân viên make up đi theo từng ngày. Các gói chụp ảnh cưới ở TuArts có giá dao động từ 8 – 25 triệu đồng, tùy địa điểm và yêu cầu của khách hàng. Giá khá cao so với mặt bằng chung nhưng bạn sẽ hoàn toàn thỏa mãn với bộ ảnh đẹp lung linh. TuArts chính là sự lựa chọn cho những cặp đôi dư dả về tài chính và yêu thích sự chuyên nghiệp.
    //    ");
    //    studioInfo.setEmail("info.tuarts@gmail.com");
    //    studioInfo.setPhone("02423483999");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469440/lxkuapxgove6srltyhhb.jpg");
    //    studioInfo.setAddress("17 Đại Cồ Việt, Hai Bà Trưng, Hà Nội.");
    //    studioInfos.add(studioInfo);

    //    // 2.
    //    studioInfo.setFullName("Yêu Media");
    //    studioInfo.setDescription("
    //            Yêu Media là ảnh viện áo cưới đẳng cấp được thành lập từ năm 2010. Trải qua hơn 8 năm hoạt động trong lĩnh vực studio ảnh viện áo cưới, Yêu Media đã khẳng định thương hiệu và chất lượng dịch vụ qua hàng ngàn bộ album ảnh cưới tuyệt đẹp của các cặp cô dâu chú rể đến từ Việt Nam và thế giới. Được biết, Yêu Media hiện đang sở hữu 2 chi nhánh được đặt tại Hà Nội và Huế. Chính vì thế, cũng không quá hiểu khi Yêu Media lại được góp mặt vào danh sách các studio chụp ảnh cưới đẹp nổi tiếng tại Hà Nội của Toplist ngày hôm nay.
    //        Đội ngũ chụp ảnh cưới chuyên nghiệp, cùng stylits đẳng cấp sẽ đề xuất, lắng nghe và thực hiện ý tưởng về bộ ảnh trong mơ của bạn
    //        Trang phục, váy cưới cao cấp, phụ kiện đúng gout chuẩn trend
    //        Phục vụ chu đáo. Đề xuất phù hợp với bạn, lắng nghe ý tưởng của bạn.
    //        Với sứ mệnh: 'LUÔN HƯỚNG TỚI PHONG CÁCH CAO CẤP VÀ SÁNG TẠO ĐỈNH CAO', Yêu Media vẫn đã và đang không ngừng nỗ lực để có thể mang đến những sản phẩm thật ý nghĩa cho ngày hạnh phúc lứa đôi cũng như chưa bao giờ khiến các "vị thượng đế" thân yêu của mình phải thất vọng, đảm bảo "luôn đẹp, luôn cao cấp, luôn sáng tạo".
    //        Là những người trẻ tuổi, năng động, đã có kinh nghiệm trong lĩnh vực chụp ảnh cưới ngoại cảnh, trang điểm cô dâu, các thành viên của Yêu Media sẽ dễ dàng thống nhất với nhau về thời gian cũng như địa điểm, đảm bảo sự phối hợp công việc được thuận tiện và mang đến hiệu quả cao nhất cho buổi chụp hình cưới của bạn.
    //   ");
    //    studioInfo.setEmail("hotline@yeumedia.vn");
    //    studioInfo.setPhone("0928975888");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469440/hvscymxnwqozkcbdout0.jpg");
    //    studioInfo.setAddress("430 Tây Sơn, Đống Đa, Hà Nội");
    //    studioInfos.add(studioInfo);

    //   // 3.
    //    studioInfo.setFullName("Ảnh viện Vivian");
    //    studioInfo.setDescription("
    //        Ảnh viện Vivian là một trong những thương hiệu nổi tiếng trong lĩnh vực ảnh cưới, ảnh gia đình, ảnh em bé, ảnh thời trang, ảnh nghệ thuật tại Hà Nội. Và trong danh sách của Toplist ngày hôm nay, đây cũng là một cái tên không thể không nhắc đến.
    //        Với đội ngũ nhiếp ảnh gia dày dạn kinh nghiệm, tận tình và sáng tạo cùng công nghệ xử lý ảnh hiện đại tại Vivian Studio sẽ giúp các cặp đôi có được những khung hình đẹp như ý theo nhiều phong cách khác nhau, từ cổ điển truyền thống cho tới hiện đại, phá cách.
    //        Ảnh viện Vivian luôn tìm kiếm những điều lạ nhất, hay nhất, lãng mạng nhất dành tặng cho các cặp đôi. Cùng 1 bối cảnh nhưng khi đến với Ảnh viện Vivian sẽ mang đến cho bạn 1 cái nhìn khác trong cách chụp, cách xử lý hậu kỳ nhằm mang đến cho bạn 1 bộ ảnh ưng ý nhất. Với việc chăm chút từng khoảnh khắc ánh sáng, trang phục, trang điểm tới cử chỉ, tạo dáng của cô dâu chú rể, phong cách chụp của Ảnh viện Vivian toát lên sự chỉnh chu và hoàn hảo, ghi dấu ngày trọng đại một cách đặc biệt.
    //        Được biết, Vivian hiện nay đang sở hữu 02 cơ sở trên tuyến phố Xã Đàn sầm uất và một cơ sở tại Trần Thái Tông vừa mới ra mắt trong thời gian gần đây. Với sự đầu tư bài bản về cơ sở vật chất, phim trường và trang thiết bị hiện đại có quy mô phục vụ các tổ chức/gia đình/cá nhân nên rất thuận lợi cho việc đáp ứng đầy đủ nhu cầu của khách hàng, đảm bảo tính sáng tạo nghệ thuật và sự thành công của sự kiện lớn nhỏ.
    //        Vivian cũng là ảnh viện duy nhất của cả nước nhận được bình chọn và chứng nhận "Dịch vụ hoàn hảo" do các cơ quan, báo chí và người tiêu dùng bình chọn trong cuộc điều tra và lựa chọn top 100 "Sản phẩm tốt - Dịch vụ hoàn hảo ".
    //    ");
    //    studioInfo.setEmail("cskh.anhembe.vn@gmail.com");
    //    studioInfo.setPhone("02435773148");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469439/ayfl8ot3b9eb84dpbnit.jpg");
    //    studioInfo.setAddress("72-74 Xã Đàn, Đống Đa, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 4.
    //    studioInfo.setFullName("Hailecao");
    //    studioInfo.setDescription("
    //        Hailecao nổi tiếng với phong cách ảnh rất riêng biệt. Các bộ ảnh của Hailecao hướng tới sự bay bổng, tự nhiên, lãng mạn và hơn hết là làm nổi bật được phong cách và cá tính của từng cô dâu chú rể.
    //        Studio này đem đến cho các cặp đôi nhiều sự lựa chọn về địa điểm chụp ảnh từ nội thành cho đến ngoại thành Hà Nội hay là các tỉnh lân cận và các điểm du lịch nổi tiếng…Trước khi chụp, Hailecao sẽ tìm hiểu mong muốn của các cặp đôi từ đó sẽ tư vấn để các cặp đôi có được bộ ảnh đúng như ý tưởng và mong muốn của mình.
    //    ");
    //    studioInfo.setEmail("https://www.facebook.com/Hailecao.Studio/");
    //    studioInfo.setPhone("0948845005");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469439/dbdwfwhxv0yvfilzcihd.jpg");
    //    studioInfo.setAddress("Số 7, ngõ 9 Hoàng Cầu, Đống Đa, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 5.
    //    studioInfo.setFullName("Phiêu Media");
    //    studioInfo.setDescription("
    //        Đúng như cái tên, Phiêu Media sẽ mang đến cho các cặp đôi những bộ ảnh siêu chất. Thế mạnh của studio này là những góc chụp ở biển đảo như Nha Trang, Cô Tô, Lý Sơn… với những góc chụp đẹp đến khó tin sẽ khiến các cặp đôi khó tính nhất cũng phải hài lòng.
    //        Tuy nhiên, nếu bạn chỉ muốn chụp ở nội thành cũng không vấn đề, nhờ cách bắt được các góc chụp tốt mà dù chụp ở những địa điểm quen thuộc bạn vẫn sẽ có được bộ ảnh đẹp, ưng ý với phong cách lãng mạn và rất tình.
    //    ");
    //    studioInfo.setEmail("Support@phieumedia.vn");
    //    studioInfo.setPhone("02439445135");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469440/qwom1hciz1l5b7bav2s5.jpg");
    //    studioInfo.setAddress("238 Xã Đàn, Đống Đa, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 6.
    //    studioInfo.setFullName("Green Wedding Studio");
    //    studioInfo.setDescription("
    //            Nếu là người thích chất ảnh vintage, lãng mạn đầy chất thơ thì các đôi uyên ương không nên bỏ qua studio này. Với phong cách khá Tây, Green Wedding Studio sẽ giúp các cặp đôi ghi lại được những khoảnh khắc tự nhiên, độc đáo nhờ các góc chụp mới lạ tại những địa điểm tưởng chừng như đã rất quen thuộc ở Hà Nội hay các vùng lân cận.
    //        Từng album hình đều có một câu chuyện riêng nhờ vậy mà mỗi bức ảnh như đi sâu vào lòng người xem. Trước buổi chụp hình, studio sẽ cùng các cô dâu chú rể lên ý tưởng cho buổi chụp hình tùy theo phong cách và cá tính, lãng mạn hay bay bổng của các cặp đôi để đảm bảo mỗi cặp đôi sẽ có một ekip phù hợp đi theo suốt quá trình chụp ảnh. Green Wedding cung cấp nhiều gói chụp từ các địa điểm hot trong nước như Đà Nẵng, Hội An, Nha Trang… cho đến các tour chụp ở nước ngoài.
    //    ");
    //    studioInfo.setEmail("https://www.facebook.com/GreenWedding.Studio/");
    //    studioInfo.setPhone("0399999089");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469439/q5qyvalgtfhfzpzxnxph.jpg");
    //    studioInfo.setAddress("Số 116 Đại Cồ Việt, Hai Bà Trưng, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 7.
    //    studioInfo.setFullName("Nupakachi Studio");
    //    studioInfo.setDescription("
    //        Nupakachi Studio là thương hiệu chụp ảnh cưới được nhiều bạn trẻ lựa chọn. Với kinh nghiệm và 6 năm được sự tin tưởng từ khách hàng, mỗi năm thực hiện hàng trăm bộ ảnh cưới trong nước, thường xuyên chụp ảnh cưới tại các quốc gia Châu Á, Châu Âu...
    //        Nupakachi Studio ngày càng khẳng định được vị thế của một đơn vị chụp ảnh hàng đầu trong ngành cưới. Điểm khác biệt lớn nhất khi bạn tới Nupakachi là nước ảnh trong veo, cùng những khoảnh khắc tự nhiên nhất của các cặp đôi. Trước buổi chụp ảnh Nupakachi luôn dành ra một buổi tư vấn cho cô dâu chú rể vừa làm quen vừa để hiểu hơn về tính cách, nghề nghiệp cũng như kỷ niệm đáng nhớ của hai người để có những ý tưởng kịch bản chụp ảnh, định hình phong cách cho album ảnh cưới. Nỗi sợ hãi nhất của hầu hết cô dâu chú rể khi chụp ảnh cưới là phải diễn quá nhiều, khi đó bộ ảnh sẽ không được tự nhiên và mất đi cảm xúc riêng.
    //    ");
    //    studioInfo.setEmail("media@nupakachi.com");
    //    studioInfo.setPhone("0385279999");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469440/sjtueppybcwx2wxozip0.jpg");
    //    studioInfo.setAddress("Số 8, Ngõ 9, Hoàng Cầu, phường Ô Chợ Dừa, quận Đống Đa, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 8.
    //    studioInfo.setFullName("Aube studio");
    //    studioInfo.setDescription("
    //        Phong cách chủ đạo nhất của studio này là lãng mạn, nhẹ nhàng. Bởi vậy, dù đa dạng trong cách tạo cảnh, tạo dáng theo các xu hướng teen, cổ điển hay sang trọng thì những bức hình của Aube vẫn toát lên một cảm xúc nhẹ nhàng, ngọt ngào và lãng mạn. Aube studio cung cấp nhiều gói chụp ảnh với phong phú các địa điểm từ trong nước đến các nước như Thái Lan, Malaysia, Singapore…
    //        Trước buổi chụp hình, các cặp đôi sẽ được gặp trực tiếp nhiếp ảnh chụp cho mình để làm quen cũng như trao đổi những ý tưởng chụp, địa điểm chụp… để mang lại sự chủ động, thoải mái trong quá trình chụp ảnh và cũng để nhiếp ảnh gia hiểu được mong muốn của các cặp đôi để tạo ra những bức hình như ý muốn. Studio này cũng thành công trong việc lựa chọn được những góc chụp mang thương hiệu của chính mình – đây cũng chính là nguyên tắc làm việc của studio này: hạn chế tối đa sự giống nhau giữa các album để tạo ra sự độc đáo, khác lạ của mỗi album ảnh.
    //    ");
    //    studioInfo.setEmail("https://www.facebook.com/AubeStudio");
    //    studioInfo.setPhone("0366768585");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469439/bf1ibpugqnxxjfdzz8ng.jpg");
    //    studioInfo.setAddress("Số 9, ngõ 9 Nguyễn Tri Phương, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 9.
    //    studioInfo.setFullName("Uyên Lee Bridal");
    //    studioInfo.setDescription("
    //        Tình yêu của bạn sắp đến ngày đơm hoa kết trái, hai nửa trái tim sắp hòa chung một nhịp thở vì thế bạn muốn lưu lại khoảnh khắc tuyệt vời đó để làm kỉ niệm đẹp, mỗi album ảnh cưới đẹp sẽ là một hành trang đẹp trong cuộc sống hôn nhân của bạn.
    //        Uyên Lee Studio với tiêu chí chất lượng hàng đầu, chúc các đôi bạn trẻ  luôn hạnh phúc và mỉm cười với con đường mà bạn đã lựa chọn. Phía trước của các bạn là cả một đoạn đường dài sẽ có những cung bậc cảm xúc, sắc màu trong cuộc sống, nhưng vẫn sẽ luôn luôn tràn ngập hạnh phúc nhé và album cưới đẹp sẽ là người bạn đồng hành tốt nhất trong cuộc sống hôn nhân của hai bạn.
    //    ");
    //    studioInfo.setEmail("https://www.facebook.com/anhvienaocuoiuyenlee/");
    //    studioInfo.setPhone("02462917184");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469440/gtirugjwbunjnhgbzsqi.jpg");
    //    studioInfo.setAddress("588 Minh Khai, Quận Hai Bà Trưng, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 10.
    //    studioInfo.setFullName("Mju Studio");
    //    studioInfo.setDescription("
    //        Đây là sự lựa chọn dành cho những cặp đôi yêu thích phong cách trẻ trung, sáng tạo mà vẫn rất tình trong từng thước ảnh. Với tiêu chí là nắm bắt từng khoảnh khắc tuyệt vời và hạnh phúc của các đôi một cách tự nhiên nhất, vì thế buổi chụp ảnh của cô dâu, chú rể như một buổi dạo chơi thoải mái với những cung bậc cảm xúc, hay như là một cuộc hẹn hò đầy tình tứ của những chàng trai cô gái đang chìm đắm trong tình yêu.
    //        Cùng những không gian lãng mạn, độc đáo, Mju studio sẽ góp phần tô vẽ cho câu chuyện tình yêu của bạn trở nên ngọt ngào và đặc biệt khó quên. Đặc biệt, đây còn là nơi hiện thực hóa những ý tưởng trong mơ tuyệt vời của bạn. Ưu thế của studio là đội ngũ trẻ, năng động nên bắt kịp rất nhanh với các xu hướng để tạo ra được những ý tưởng độc đáo cho những album cưới.
    //        Ngoài ra, đây cũng là địa chỉ hiếm hoi sở hữu riêng một nhãn hiệu váy cưới được thiết kế độc quyền: Fairytale Bridal – phù hợp với từng kiểu dáng của cô dâu. Đến với Mju Studio không chỉ giúp các cặp đôi có những khung hình cưới đẹp mà studio còn giúp các bạn có được trải nghiệm những dịch vụ cưới tốt nhất.
    //    ");
    //    studioInfo.setEmail("https://www.facebook.com/Mju.Studio/");
    //    studioInfo.setPhone("0848686678");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469439/htcl95ybqgxsxcoziz56.jpg");
    //    studioInfo.setAddress("Số 7 Đại Cồ Việt, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 11.
    //    studioInfo.setFullName("L'amant");
    //    studioInfo.setDescription("
    //        Đây cũng là một trong những studio được giới trẻ Hà thành yêu thích. Với sự chuyên nghiệp, nhiệt tình và am hiểu các giá trị thẩm mỹ, L'amant sẽ mang đến cho bạn những khung hình thật sự như ý muốn.
    //        Ngoài việc chụp hình, các nhân viên tư vấn của L'amant sẽ tư vấn cho các cặp đôi ý tưởng chụp hình độc đáo với hàng trăm kiểu váy cưới đẹp để bạn lựa chọn.L'amant cũng cung cấp các dịch vụ trọn gói như trang điểm cho cô dâu và quay phim ngày cưới.
    //    ");
    //    studioInfo.setEmail("lamantweddingstudio01@gmail.com ");
    //    studioInfo.setPhone("0788812222");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469439/wlw3losbvv42kchpht0b.jpg");
    //    studioInfo.setAddress("L3, T3, Tầng 3, số 3 Lương Yên, Hà Nội");
    //    studioInfos.add(studioInfo);

    //    // 12.
    //    studioInfo.setFullName("Mr.Lee Studio");
    //    studioInfo.setDescription("
    //        Kết hôn là một dấu mốc quan trọng trong cuộc đời của mỗi chúng ta. Đó là những ngày thuộc quãng thời gian thanh xuân đẹp nhất, là nét đẹp tuổi trẻ chưa hề bị tàn phai bởi thời gian. Để một lúc nào đó, ta nhìn lại từng ánh mắt, từng nụ cười, từng cái chạm tay, cảm xúc đong đầy và mọi khoảnh khắc chân thực nhất hiện về còn nguyên vẹn. Với Mr. Lee Studio mọi khoảnh khắc đều là tự nhiên nhất, Mr. Lee Studio không phải là đạo diễn của những khoảnh khắc, mà là nơi giúp bạn lưu giữ khoảnh khắc bằng những thước phim. Bằng sự chuyên nghiệp, sự tận tâm, hiểu về tâm lý khách hàng, trong 10 năm qua, cảm ơn vì đã được hàng nghìn cặp đôi tin tưởng lựa chọn là nơi ghi lại những khoảnh khắc đẹp trong dấu mốc quan trọng của cuộc đời.
    //        Ở Mr.Lee Stdudio, mọi điều dành cho khách hàng đều là số 1, Make-up Artist hiểu gương mặt, thần thái khách hàng, bắt kịp các trend make up. Hợp tác với những nhà thiết kế váy cưới hàng đầu Việt Nam cùng một ekip chụp ảnh, quay, dựng và hậu kì hùng hậu và có tâm nhất. Mr.Lee Stdudio mong rằng , Mr.Lee Studio đã đang và tiếp tục là nơi các bạn đặt niềm tin số 1 để lưu giữ lại thời khắc quan trọng của cuộc đời.
    //    ");
    //    studioInfo.setEmail("mrlee@mrlee.vn");
    //    studioInfo.setPhone("0357766666");
    //    studioInfo.setAvatar("https://res.cloudinary.com/phucvu/image/upload/v1575469440/pvjyf63ipnqtgpdsbbzb.jpg");
    //    studioInfo.setAddress("Số 24 Lê Quý Đôn, Quận Hai Bà Trưng, Hà Nội");
    //    studioInfos.add(studioInfo);
    }
}
