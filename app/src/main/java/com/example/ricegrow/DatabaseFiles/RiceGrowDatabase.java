package com.example.ricegrow.DatabaseFiles;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.ricegrow.DatabaseFiles.Dao.ActivityDao;
import com.example.ricegrow.DatabaseFiles.Dao.ActivityFertilizerDao;
import com.example.ricegrow.DatabaseFiles.Dao.ActivityPesticideDao;
import com.example.ricegrow.DatabaseFiles.Dao.CropDao;
import com.example.ricegrow.DatabaseFiles.Dao.CropDeftoxDao;
import com.example.ricegrow.DatabaseFiles.Dao.CropDiseaseDao;
import com.example.ricegrow.DatabaseFiles.Dao.CropPestDao;
import com.example.ricegrow.DatabaseFiles.Dao.CropStageDao;
import com.example.ricegrow.DatabaseFiles.Dao.CropWeedDao;
import com.example.ricegrow.DatabaseFiles.Dao.DeficienciesToxicitiesDao;
import com.example.ricegrow.DatabaseFiles.Dao.DeftoxFertilizerDao;
import com.example.ricegrow.DatabaseFiles.Dao.DeftoxStageDao;
import com.example.ricegrow.DatabaseFiles.Dao.DiseaseDao;
import com.example.ricegrow.DatabaseFiles.Dao.DiseasePesticideDao;
import com.example.ricegrow.DatabaseFiles.Dao.DiseaseStageDao;
import com.example.ricegrow.DatabaseFiles.Dao.FertilizerCalculatingDao;
import com.example.ricegrow.DatabaseFiles.Dao.FertilizerDao;
import com.example.ricegrow.DatabaseFiles.Dao.NoteDao;
import com.example.ricegrow.DatabaseFiles.Dao.PestDao;
import com.example.ricegrow.DatabaseFiles.Dao.PestPesticideDao;
import com.example.ricegrow.DatabaseFiles.Dao.PestStageDao;
import com.example.ricegrow.DatabaseFiles.Dao.PesticideDao;
import com.example.ricegrow.DatabaseFiles.Dao.PlanActivityDao;
import com.example.ricegrow.DatabaseFiles.Dao.PlanStageDao;
import com.example.ricegrow.DatabaseFiles.Dao.SettingDao;
import com.example.ricegrow.DatabaseFiles.Dao.StageDao;
import com.example.ricegrow.DatabaseFiles.Dao.UserCropDao;
import com.example.ricegrow.DatabaseFiles.Dao.UserDao;
import com.example.ricegrow.DatabaseFiles.Dao.WeatherDao;
import com.example.ricegrow.DatabaseFiles.Dao.WeedDao;
import com.example.ricegrow.DatabaseFiles.Dao.WeedPesticideDao;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.ActivityFertilizers;
import com.example.ricegrow.DatabaseFiles.Model.ActivityPesticides;
import com.example.ricegrow.DatabaseFiles.Model.CropDeftox;
import com.example.ricegrow.DatabaseFiles.Model.CropDiseases;
import com.example.ricegrow.DatabaseFiles.Model.CropPests;
import com.example.ricegrow.DatabaseFiles.Model.CropStage;
import com.example.ricegrow.DatabaseFiles.Model.CropWeeds;
import com.example.ricegrow.DatabaseFiles.Model.Crops;
import com.example.ricegrow.DatabaseFiles.Model.DeficienciesToxicities;
import com.example.ricegrow.DatabaseFiles.Model.DeftoxFertilizer;
import com.example.ricegrow.DatabaseFiles.Model.DeftoxStage;
import com.example.ricegrow.DatabaseFiles.Model.Diseases;
import com.example.ricegrow.DatabaseFiles.Model.DiseasesPesticides;
import com.example.ricegrow.DatabaseFiles.Model.DiseasesStages;
import com.example.ricegrow.DatabaseFiles.Model.FertilizerCalculating;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Notes;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.DatabaseFiles.Model.PestsPesticides;
import com.example.ricegrow.DatabaseFiles.Model.PestsStages;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Setting;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.Model.Users;
import com.example.ricegrow.DatabaseFiles.Model.Weather;
import com.example.ricegrow.DatabaseFiles.Model.Weeds;
import com.example.ricegrow.DatabaseFiles.Model.WeedsPesticides;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Activities.class, ActivityFertilizers.class, ActivityPesticides.class, CropDiseases.class,
        CropPests.class, Crops.class, CropWeeds.class, CropStage.class, Diseases.class, DiseasesPesticides.class, DiseasesStages.class,
        Fertilizers.class, Pesticides.class, Pests.class, PestsPesticides.class, PestsStages.class,
        PlanActivities.class, PlanStages.class, Stages.class,
        UserCrops.class, Users.class, Weeds.class, WeedsPesticides.class, FertilizerCalculating.class, DeficienciesToxicities.class, CropDeftox.class,
        DeftoxFertilizer.class, DeftoxStage.class, Weather.class, Setting.class, Notes.class}, version = 1)
public abstract class RiceGrowDatabase extends RoomDatabase {
    public abstract ActivityDao activityDao();

    public abstract ActivityFertilizerDao activityFertilizerDao();

    public abstract ActivityPesticideDao activityPesticideDao();

    public abstract CropDao cropDao();

    public abstract CropDiseaseDao cropDiseaseDao();

    public abstract CropPestDao cropPestDao();

    public abstract CropWeedDao cropWeedDao();

    public abstract CropStageDao cropStageDao();

    public abstract DiseaseDao diseaseDao();

    public abstract DiseasePesticideDao diseasePesticideDao();

    public abstract DiseaseStageDao diseaseStageDao();

    public abstract FertilizerDao fertilizerDao();

    public abstract PestDao pestDao();

    public abstract PesticideDao pesticideDao();

    public abstract PestPesticideDao pestPesticideDao();

    public abstract PestStageDao pestStageDao();

    public abstract PlanActivityDao planActivityDao();

    public abstract PlanStageDao planStageDao();

    public abstract StageDao stageDao();

    public abstract UserCropDao userCropDao();

    public abstract UserDao userDao();

    public abstract WeedDao weedDao();

    public abstract WeedPesticideDao weedPesticideDao();

    public abstract FertilizerCalculatingDao fertilizerCalculatingDao();

    public abstract DeficienciesToxicitiesDao deficienciesToxicitiesDao();

    public abstract CropDeftoxDao cropDeftoxDao();

    public abstract DeftoxFertilizerDao deftoxFertilizerDao();

    public abstract DeftoxStageDao deftoxStageDao();

    public abstract WeatherDao weatherDao();

    public abstract SettingDao settingDao();

    public abstract NoteDao noteDao();


    private static RiceGrowDatabase instance;

    private static Context appContext;

    public static synchronized RiceGrowDatabase getInstance(Context context) {
        if (instance == null) {
            appContext = context.getApplicationContext();
            instance = Room.databaseBuilder(context, RiceGrowDatabase.class, "shop_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(initialCallback)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback initialCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            populateInitialData();
        }
    };

    private static void populateInitialData() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            RiceGrowDatabase db = RiceGrowDatabase.getInstance(appContext);

            //****Guest User****
            UserDao userDao = db.userDao();
            userDao.insert(new Users("qoF4h2xcXfOwFbCZPypG1hmwKPb2", "Guest", "1234567", "ricegrowguest@gmail.com", "The Earth", "guest", "123456789", "default_avatar"));

            //****Crops****
            CropDao cropDao = db.cropDao();
            ArrayList<Crops> crops = new ArrayList<>();
            Crops crop1 = new Crops("OM 18", "OM 18 rice was selected from OM 8017/ OM 5166 hybrid combination, this is an aromatic rice variety with outstanding advantages such as high salt tolerance at 3-4 levels, pest resistance, especially high resistance and stability. with blast, high yield and short growth duration.",
                    "Lúa OM 18 được chọn tạo từ tổ hợp lai OM 8017/OM 5166; Đây là giống lúa thơm có những ưu điểm vượt trội như chịu mặn cao cấp 3-4, kháng sâu bệnh, đặc biệt kháng cao và ổn định với bệnh đạo ôn, năng suất cao, thời gian sinh trưởng ngắn.",
                    105, 8000, 3.6, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/rice_varieties%2FOM18.png?alt=media&token=d3719c12-c8c1-4429-9543-a087576577b8");
            crops.add(crop1);
            Crops crop2 = new Crops("DT 08", "DT 08 (Dai Thom 08) is a high-quality type of Vietnam fragrant rice grown in Viet Nam. DT 08 rice has medium grains, with an evenly bright-white color. DT 08 rice has a short growth period; therfore, there are 3 crops of DT 08 rice per year, which are harvested in the spring, autumn and winter. When cooked, the texture of DT 08 rice is soft and remains sticky after cooling.",
                    "DT 08 (Đài thơm 08) là giống lúa thơm Việt Nam chất lượng cao được trồng tại Việt Nam. Gạo DT 08 có hạt vừa, màu trắng sáng đều. lúa DT 08 có thời gian sinh trưởng ngắn; nên lúa DT 08 mỗi năm thu hoạch được 3 vụ xuân, thu, đông. Cơm gạo DT 08 khi nấu chín dẻo, để nguội vẫn giữ được độ dẻo.",
                    110, 7500, 3.9, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/rice_varieties%2FDT08.jpg?alt=media&token=5cdf8bde-756b-489a-94e5-106dbe669d5e");
            crops.add(crop2);
            Crops crop3 = new Crops("OM 5451", "The rice variety OM 5451 is a rice variety selected from the Jasmine 85/OM2490 hybrid, created by the Mekong Delta Rice Institute. This rice variety is popularly grown in the Mekong Delta region for its high yield and export-standard rice quality.\n" +
                    "\n" +
                    "The rice grain from the OM 5451 rice variety has an elongated shape (about 6.6 mm), little white belly, slightly cloudy milk color. The rice is medium and soft, but when it cools down, it won't harden the rice. This type of rice is also selected by the canteens of factories and industrial parks with a large number of employees, sold in the domestic market and exported to foreign countries.",
                    "Giống lúa OM 5451 là giống lúa được chọn từ tổ hợp lai Jasmine 85/OM2490, do Viện lúa Đồng bằng Sông Cửu Long chọn tạo. Giống lúa này được trồng phổ biến ở khu vực đồng bằng sông Cửu Long cho năng suất cao, phẩm chất gạo đạt tiêu chuẩn xuất khẩu. \n" +
                            "\n" +
                            "Hạt gạo từ giống lúa OM 5451 có hình dáng thon dài (khoảng 6.6 mm), ít bạc bụng, hơi đục màu sữa. Cơm dẻo vừa và mềm, để nguội vẫn không bị cứng cơm. Loại gạo này còn được các nhà ăn xí nghiệp, khu công nghiệp với số lượng nhân viên lớn lựa chọn, được bán ở thị trường trong nước và xuất khẩu ra nước ngoài.",
                    100, 7800, 3.8, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/rice_varieties%2FOM5451.jpg?alt=media&token=a69576ef-a647-4716-901a-78a2a02dd2a4");
            crops.add(crop3);
            Crops crop4 = new Crops("IR 50404", "The green leaf IR50404 rice variety is sourced from the International Rice Research Institute. IR50404 was imported into Vietnam in early 1990. The rice variety IR50404 was selected and developed by the Department of Food Crops - Vietnam Academy of Agricultural Science and Technology. The green leaf IR50404 rice variety was officially recognized in 1992.",
                    "Giống lúa IR50404 lá xanh có nguồn gốc từ viện nghiên cứu lúa quốc tế.  IR50404 được nhập vào Việt Nam đầu năm 1990. Giống lúa IR50404 do Bộ môn cây lương thực – viện khoa học kỹ thuật Nông Nghiệp Việt Nam chọn lọc và phát triển. Giống lúa IR50404 lá xanh được công nhận chính thức vào năm 1992.",
                    95, 7600, 3.7, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/rice_varieties%2FIR50404.jpg?alt=media&token=45679827-3ac7-4ea9-a25e-e18ec731c619");
            crops.add(crop4);
            for (Crops c : crops) {
                cropDao.insert(c);
            }

            //****Pests****
            PestDao pestDao = db.pestDao();
            ArrayList<Pests> pests = new ArrayList<>();
            Pests pests1 = new Pests("Rice leaffolder", "Sâu cuốn lá", "Cnaphalocrocis medinalis", "Cnaphalocrocis medinalis",
                    "The life cycle of Rice leaffolder is about 1.5 months. The egg stage lasts for 5 days, the larval stage lasts for 25 days, the pupal stage lasts for 7 days, and the adult moth stage lasts for 10 days. During the larval stage, the leaffolder caterpillars fold the rice leaves around themselves and attach the leaf margins together with silk strands." +
                            "\n" + " Rice leaffolders occur in all rice environments and are more abundant during the rainy seasons. They are commonly found in shady areas and areas where rice is heavily fertilized. In tropical rice areas, they are active year-round, whereas, in temperate countries, they are active from May to October.",
                    "Vòng đời của sâu cuốn lá lúa kéo dài khoảng 1.5 tháng. Giai đoạn trứng kéo dài 5 ngày, giai đoạn ấu trùng kéo dài 25 ngày, giai đoạn nhộng kéo dài 7 ngày và giai đoạn bướm trưởng thành kéo dài 10 ngày. Trong giai đoạn ấu trùng, sâu cuốn lá lúa sẽ gập lá lúa lại quanh cơ thể của chúng và dùng sợi tơ nhện buộc mép lá lại với nhau." +
                            "\n" + " Sâu cuốn lá lúa xuất hiện trong mọi môi trường lúa và thường nhiều hơn trong mùa mưa. Chúng thường được tìm thấy ở những nơi có bóng mát và nơi lúa được bón phân nhiều. Ở khu vực lúa nhiệt đới, chúng hoạt động quanh năm, trong khi ở các nước ôn đới, chúng hoạt động từ tháng 5 đến tháng 10.",
                    "Check the plant for the following symptoms:\n" +
                            "- Longitudinal and transparent whitish streaks on damaged leaves\n" +
                            "tubular folded leaves\n" +
                            "- Leaf tips sometimes fastened to the basal part of leaf\n" +
                            "- Heavily infested fields appear scorched with many folded leaves\n" +
                            "\n" + "Also check for presence of insects, particularly during tillering to flowering. Signs include:\n" +
                            "- Disc-shaped ovoid eggs laid singly\n" +
                            "- Young larvae feeding on the base of the youngest unopened leaves\n" +
                            "- Folded leaves enclosing the feeding larvae, and present fecal matter.",
                    "Kiểm tra cây lúa cho các triệu chứng sau:\n" +
                            "- Vết đường sọc trắng trong suốt dọc lá bị hư hại\n" +
                            "lá bị gập trở lại thành ống\n" +
                            "- Đỉnh lá đôi khi bị buộc vào phần gốc của lá\n" +
                            "- Các cánh đồng bị nhiễm nặng xuất hiện như bị cháy sạch với nhiều lá bị gập lại\n" +
                            "\n" + "Cũng kiểm tra sự hiện diện của côn trùng, đặc biệt là từ giai đoạn đẻ nhánh đến giai đoạn đẻ hoa. Dấu hiệu bao gồm:\n" +
                            "- Trứng hình đĩa được đặt riêng lẻ\n" +
                            "- Ấu trùng non ăn ở phần gốc của lá còn non mới mọc\n" +
                            "- Lá gấp lại bao bọc ấu trùng đang ăn, và phân kèm theo.",
                    "Leaffolder caterpillars fold a rice leaf around themselves and attach the leaf margins together with silk strands. They feed inside the folded leaf creating longitudinal white and transparent streaks on the blade.",
                    "Những con sâu cuốn lá gập một chiếc lá lúa lại quanh cơ thể của chúng và buộc mép lá lại với nhau bằng sợi tơ nhện. Chúng ăn bên trong lá gập tạo ra những vệt dọc trắng trong suốt trên lá.",
                    "To prevent leaffolder outbreaks:\n" +
                            "- Use resistant varieties.\n" +
                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Follow rice with a different crop, or fallow period.\n" +
                            "- Avoid ratooning.\n" +
                            "- Flood and plow field after harvesting if possible.\n" +
                            "- Remove grassy weeds from fields and borders.\n" +
                            "- Reduce density of planting.\n" +
                            "- Use balanced fertilizer rates.",
                    "Để ngăn chặn sự bùng phát của sâu ăn lá:\n" +
                            "- Sử dụng giống kháng.\n" +
                            "- Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Theo dõi cây lúa với một vụ mùa khác, hoặc thời kỳ bỏ hoang.\n" +
                            "- Tránh phân chia lại.\n" +
                            "- Làm ngập và cày ruộng sau khi thu hoạch nếu có thể.\n" +
                            "- Loại bỏ cỏ dại khỏi các cánh đồng và biên giới.\n" +
                            "- Giảm mật độ trồng.\n" +
                            "- Sử dụng tỷ lệ phân bón cân đối.", "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pests%2Frice_leafholder.jpg?alt=media&token=1aeea10a-ee33-449b-a275-6179961df0b4");
            pests.add(pests1);
            Pests pests2 = new Pests("Planthopper", "Rầy", "Two species of planthopper infest rice. These are the brown planthopper (BPH), Nilaparvata lugens (Stal); and the whitebacked planthopper (WBPH), Sogatella furcifera (Horvath).",
                    "Hai loài rầy hại lúa. Đó là rầy nâu (BPH), Nilaparvata lugens (Stal); và rầy lưng trắng (WBPH), Sogatella furcifera (Horvath).",
                    "The life cycle of planthoppers is usually about 40 days, depending on the species and the environment. The eggs usually hatch between 6 to 8 days, planthoppers stay in the nymph phase for about 16-18 days and adult planthoppers live for about 15-20 days. \n" +
                            "Different species of planthoppers have different life cycles. For example, the brown planthopper completes its lifecycle in 18 to 24 days between June and October, 38 to 44 days between November and January, and 18 to 35 days between February and April1.",
                    "Vòng đời của rầy thường khoảng 40 ngày, tùy theo loài và môi trường. Trứng thường nở từ 6 - 8 ngày, rầy ở giai đoạn nhộng khoảng 16 - 18 ngày và rầy trưởng thành khoảng 15 - 20 ngày. \n" +
                            "Các loài rầy khác nhau có vòng đời khác nhau. Ví dụ: rầy nâu hoàn thành vòng đời của nó trong 18 đến 24 ngày từ tháng 6 đến tháng 10, 38 đến 44 ngày từ tháng 11 đến tháng 1 và 18 đến 35 ngày từ tháng 2 đến ngày 1 tháng 4.",
                    "Check for the presence of insect:\n" +
                            "- Crescent-shaped white eggs inserted into the midrib or leaf sheath\n" +
                            "- White to brown nymphs\n" +
                            "- Brown or white adults feeding near the base of tillers\n" +
                            "\n" +
                            "Check the field for:\n" +
                            "- Hopperburn or yellowing, browning and drying of plant\n" +
                            "- Ovipositional marks exposing the plant to fungal and bacterial infections\n" +
                            "- Presence of honeydew and sooty molds in the bases of areas infected\n" +
                            "- Plants with ragged stunt or grassy stunt virus disease\n" +
                            "- Hopperburn is similar to the feeding damage or \"bugburn\" caused by the rice black bug. To confirm hopperburn caused by planthoppers, check for the presence of sooty molds at the base of the plant.",
                    "Kiểm tra sự hiện diện của côn trùng:\n" +
                            "- Trứng trắng hình lưỡi liềm cắm vào gân giữa hoặc bẹ lá\n" +
                            "- Nhộng từ trắng đến nâu\n" +
                            "- Con trưởng thành màu nâu hoặc trắng kiếm ăn gần gốc của nhánh xới\n" +
                            "\n" +
                            "Kiểm tra trường cho:\n" +
                            "- Hopperburn hoặc vàng, nâu và khô của cây\n" +
                            "- Các vết rụng trứng khiến cây dễ bị nhiễm nấm và vi khuẩn\n" +
                            "- Sự hiện diện của nấm mốc mật và bồ hóng ở các khu vực bị nhiễm bệnh\n" +
                            "- Cây bị bệnh lùn sọc vằn hoặc bệnh virus còi cọc cỏ\n" +
                            "- Cháy rầy tương tự như thiệt hại khi ăn hoặc \"đốt bọ\" do bọ xít đen gây ra. Để xác nhận cháy rầy do rầy gây ra, hãy kiểm tra sự hiện diện của mốc bồ hóng ở gốc cây.",
                    "The high population of planthoppers cause leaves to initially turn orange-yellow before becoming brown and dry and this is a condition called hopperburn that kills the plant. BPH can also transmit Rice Ragged Stunt and Rice Grassy Stunt diseases. Neither disease can be cured.",
                    "Mật độ rầy cao khiến lá ban đầu chuyển sang màu vàng cam trước khi chuyển sang màu nâu và khô và đây là tình trạng gọi là cháy rầy làm chết cây. Rầy rầy cũng có thể truyền bệnh lùn sọc lá lúa và bệnh còi cọc lúa cỏ. Không phải bệnh nào cũng có thể được chữa khỏi.",
                    "To control planthoppers:\n" +
                            "- Mechanical & physical measures\n" +
                            "   + Flood the seedbed, for a day, so that only the tips of seedlings are exposed will control BPH.\n" +
                            "   + Sweep small seedbeds with a net to remove some BPH (but not eggs), particularly from dry seed beds. At high BPH densities, sweeping will not remove sufficient numbers of BPH from the base of the plant.\n" +
                            "- Biological control\n" +
                            "   + If natural enemies out-number BPH the risk of hopperburn is low. Even rice already damaged by hopperburn should not be treated with insecticides if natural enemies out-number BPH. Natural enemies of BPH include water striders, mirid bugs, spiders, and various egg parasitoids.\n" +
                            "- Chemical control\n" +
                            "   + Only apply insecticides to the seedbed, for BPH or WBPH, if all of these conditions are met: an average of more than one planthopper per stem, on average, more planthoppers than natural enemies,flooding the seedbed is not an option.",
                    "Để kiểm soát rầy:\n" +
                            "- Biện pháp cơ học & vật lý\n" +
                            " + Làm ngập luống gieo hạt trong một ngày sao cho chỉ phần ngọn của cây con lộ ra sẽ kiểm soát được rầy nâu.\n" +
                            " + Quét các luống hạt nhỏ bằng lưới để loại bỏ một số rầy nâu (nhưng không phải trứng), đặc biệt là từ các luống hạt khô. Ở mật độ rầy nâu cao, việc quét sẽ không loại bỏ đủ số lượng rầy nâu khỏi gốc cây.\n" +
                            "- Kiểm soát sinh học\n" +
                            " + Nếu số lượng thiên địch vượt trội so với rầy nâu thì nguy cơ bị cháy rầy là thấp. Ngay cả những cây lúa đã bị rầy gây hại cũng không nên xử lý bằng thuốc trừ sâu nếu số lượng thiên địch vượt trội so với rầy nâu. Thiên địch của rầy nâu bao gồm bọ nước, bọ xít, nhện và ký sinh trứng khác nhau.\n" +
                            "- Kiểm soát hóa chất\n" +
                            " + Chỉ phun thuốc trên luống mạ đối với rầy nâu hoặc rầy nâu nếu đủ các điều kiện: trung bình trên 1 gốc có trên 1 con rầy, trung bình nhiều rầy hơn thiên địch, không nên ngập úng luống mạ.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pests%2Fplant_hopper.jpg?alt=media&token=3945fca0-f467-482d-b00c-3dc4ce96327f");
            pests.add(pests2);
            Pests pests3 = new Pests("Stem borer", "Sâu đục thân", "Schoenobius incertulas", "Schoenobius incertulas",
                    "The life cycle of stem borers consists of four stages: egg, larva, pupa and adult. After sunset, the male and female moths come together and after sexual union the eggs are fertilized internally. The eggs are laid in batches of 10-80 on the upperside and underside of leaf surfaces, usually close to the midrib. They hatch after 4-10 days. Younger larvae (caterpillars) feed on the leaf whorl. Older larvae tunnel into the stems, and it is within these tunnels that they feed and grow for about 2-3 weeks.",
                    "Vòng đời của sâu đục thân gồm 4 giai đoạn: trứng, sâu non, nhộng và trưởng thành. Sau khi mặt trời lặn, sâu đực và cái kết hợp với nhau và sau khi giao phối, trứng được thụ tinh bên trong. Trứng được đẻ thành từng đợt từ 10-80 quả ở mặt trên và mặt dưới của bề mặt lá, thường gần với gân chính. Chúng nở sau 4-10 ngày. Ấu trùng non hơn (sâu bướm) ăn vòng xoắn của lá. Ấu trùng già chui vào thân cây và ăn chính trong những đường hầm này và phát triển trong khoảng 2-3 tuần.",
                    "Check the field for the following damage symptoms:\n" +
                            "- Deadhearts or dead tillers that can be easily pulled from the base during the vegetative stages\n" +
                            "- Whiteheads during reproductive stage where the emerging panicles are whitish and unfilled or empty\n" +
                            "- Tiny holes on the stems and tillers\n" +
                            "- Frass or fecal matters inside the damaged stems\n" +
                            "To confirm stem borer damage, visually inspect rice crop for deadhearts in the vegetative stages and whiteheads in reproductive stages. Stems can be pulled and dissected for larvae and pupae for confirmation of stem borer damage.",
                    "Kiểm tra trường để biết các triệu chứng hư hỏng sau:\n" +
                            "- Tim chết hoặc chồi chết có thể dễ dàng kéo ra khỏi gốc trong giai đoạn sinh dưỡng\n" +
                            "- Mụn đầu trắng trong giai đoạn sinh sản nơi các chùy mới nổi có màu trắng và không có nhân hoặc rỗng\n" +
                            "- Những lỗ nhỏ trên thân và nhánh\n" +
                            "- Frass hoặc phân bên trong thân cây bị hư hỏng\n" +
                            "Để xác định mức độ gây hại của sâu đục thân, hãy kiểm tra bằng mắt thường cây lúa để tìm sâu bệnh chết trong giai đoạn sinh dưỡng và mụn đầu trắng trong giai đoạn sinh sản. Có thể kéo và mổ thân cây để tìm sâu non và nhộng để xác nhận mức độ gây hại của sâu đục thân.",
                    "Stem borers can destroy rice at any stage of the plant from seedling to maturity. They feed upon tillers and cause deadhearts or drying of the central tiller, during the vegetative stage; and cause whiteheads at reproductive stage.",
                    "Sâu đục thân có thể phá hại lúa ở bất kỳ giai đoạn nào của cây từ mạ đến trưởng thành. Chúng ăn lúa làm đòng và làm chết lõi hoặc làm khô lá trung tâm trong giai đoạn sinh dưỡng; và gây bệnh đầu trắng ở giai đoạn sinh sản.",
                    "To manage the Stem borer:\n" +
                            "- Use resistant varieties\n" +
                            "- At seedbed and transplanting, handpick and destroy egg masses\n" +
                            "- Raise level of irrigation water periodically to submerge the eggs deposited on the lower parts of the plant\n" +
                            "- Before transplanting, cut the leaf-top to reduce carry-over of eggs from the seedbed to the field\n" +
                            "- Ensure proper timing of planting and synchronous planting, harvest crops at ground level to remove the larvae in stubble, remove stubble and volunteer rice, plow and flood the field\n" +
                            "- Encourage biological control agents: braconid, eulophid, mymarid, scelionid, chalcid, pteromalid and trichogrammatid wasps, ants, lady beetles, staphylinid beetles, gryllid, green meadow grasshopper, and mirid, phorid and platystomatid flies, bethylid, braconid, elasmid, eulophid, eurytomid and ichneumonid wasps, carabid and lady bird beetles, chloropid fly, gerrid and pentatomid bugs, ants, and mites,  earwigs, bird, asilid fly, vespid wasp, dragonflies, damselflies, and spiders\n" +
                            "- Bacteria and fungi also infect the larvae: mermithid nematode, chalcid, elasmid and eulophid\n" +
                            "- Apply nitrogen fertilizer in split following the recommended rate and time of application.",
                    "Để quản lý Sâu đục thân:\n" +
                            "- Sử dụng giống kháng\n" +
                            "- Tại luống gieo và cấy, nhặt và phá hủy khối trứng\n" +
                            "- Nâng mức nước tưới định kỳ để nhấn chìm trứng đọng ở phần dưới của cây\n" +
                            "- Trước khi cấy phải cắt ngọn lá để giảm trứng mang từ luống mạ ra ruộng\n" +
                            "- Đảm bảo đúng thời vụ và gieo cấy đồng bộ, thu hoạch sát gốc để loại bỏ ấu trùng trong gốc rạ, loại bỏ gốc rạ và tình nguyện lúa, cày úng ruộng\n" +
                            "- Khuyến khích các tác nhân kiểm soát sinh học: braconid, eulophid, mymarid, scelionid, chalcid, pteromalid và trichogrammatid wasps, kiến, bọ rùa, bọ cánh cứng staphylinid, gryllid, châu chấu xanh, và ruồi mirid, phorid và platystomatid, bethylid, braconid, elasmid, ong bắp cày eulophid, eurytomid và ichneumonid, bọ carabid và bọ cánh cứng, ruồi chloropid, bọ gerrid và pentatomid, kiến và ve, ráy tai, chim, ruồi asilid, ong vespid, chuồn chuồn, chuồn chuồn kim và nhện\n" +
                            "- Vi khuẩn và nấm cũng lây nhiễm cho ấu trùng: giun tròn, chalcid, elasmid và eulophid\n" +
                            "- Bón phân đạm chia nhỏ theo tỷ lệ và thời điểm bón khuyến cáo.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pests%2Fstem_borer.jpg?alt=media&token=6cc4a2cc-1bb7-4542-ba4c-a6165d63e2b4");
            pests.add(pests3);

            Pests pests4 = new Pests("Rice thrips", "Bọ trĩ", "Stenchaetothrips biformis (Bagnall)", "Stenchaetothrips biformis (Bagnall)",
                    "The life cycle of rice thrips is 10-20 days and most of them live on rice or corn or weeds. The adult thrips are active during the day moving to look for young rice plant and other hosts. The female inserts the eggs singly within the leaf tissues in young leaves. Egg period is 3-5 days, and the life cycle is completed in 13-19 days.",
                    "Vòng đời của bọ trĩ từ 10-20 ngày, đa số sống trên lúa, ngô hoặc cỏ dại. Bọ trĩ trưởng thành hoạt động vào ban ngày, di chuyển tìm cây lúa non và các ký chủ khác. Bọ trĩ cái đẻ trứng đơn lẻ vào bên trong. các mô lá ở lá non. Thời kỳ trứng là 3-5 ngày và vòng đời hoàn thành trong 13-19 ngày.",
                    "Check the plants for feeding damage:\n" +
                            "- Damaged leaves have silvery streaks or yellowish patches\n" +
                            "- Translucent epidermis becomes visible on the damaged area\n" +
                            "- Leaves curled from the margin to the middle\n" +
                            "- Leaf tips wither off when severely infested\n" +
                            "- Unfilled grains at the panicle stage\n" +
                            "\n" +
                            "Rolled leaves are also symptoms of drought. To confirm rice thrip damage, check for the presence of thrip inside the curled leaves.\n" +
                            "- Cream-coloured eggs on leaf tissue with the upper half of eggs exposed on the leaf surface\n" +
                            "- Yellow larvae and dark brown adults lacerate the plant tissues\n" +
                            "- Leaf shows discolouration and rolling, and extensive removal of leaf tissues causes a translucent epidermis to remain",
                    "Kiểm tra xem cây có bị hư hại khi cho ăn không:\n" +
                            "- Những chiếc lá bị hư hại có những vệt bạc hoặc những mảng hơi vàng\n" +
                            "- Lớp biểu bì mờ có thể nhìn thấy trên vùng bị tổn thương\n" +
                            "- Lá cong từ mép vào giữa\n" +
                            "- Đầu lá khô héo khi bị nhiễm nặng\n" +
                            "- Hạt chưa nở ở giai đoạn bông\n" +
                            "\n" +
                            "Lá cuộn lại cũng là triệu chứng của hạn hán. Để xác nhận thiệt hại do bọ trĩ trên lúa, hãy kiểm tra xem có bọ trĩ bên trong lá cuộn tròn hay không.\n" +
                            "- Trứng màu kem trên mô lá với nửa trên của trứng lộ ra trên bề mặt lá\n" +
                            "- Ấu trùng màu vàng và con trưởng thành màu nâu sẫm làm rách mô thực vật\n" +
                            "- Lá có biểu hiện biến màu và cuộn lại, và việc loại bỏ nhiều mô lá khiến lớp biểu bì trong mờ vẫn còn",
                    "Feeding damage caused by thrips causes leaf curling and discolouration. Rice thrips are more serious pests during the dry season. It infests the rice plant during the seedling stage or two weeks after early sowing. In direct-seeded rice fields in Vietnam, losses can reach 100% when infestation is severe in the first 20 days, after sowing.",
                    "Thiệt hại do bọ trĩ gây ra làm lá quăn và biến màu. Bọ trĩ là loài gây hại nghiêm trọng hơn trong mùa khô. Nó gây hại cho cây lúa trong giai đoạn cây con hoặc hai tuần sau khi gieo sạ sớm. Ở các ruộng gieo sạ thẳng ở Việt Nam, tổn thất có thể đạt 100% khi nhiễm nặng trong 20 ngày đầu sau sạ.",
                    "To manage the Rice thrips:\n" +
                            "- Use resistant varieties.\n" +
                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Flood to submerge the infested field for two days.\n" +
                            "- Encourage biological control agents: predatory thrips, coccinellid beetles, anthocorid bugs, and staphylinid beetles.",
                    "Để quản lý bọ trĩ:\n" +
                            "- Sử dụng giống kháng.\n" +
                            "- Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Lũ lụt nhấn chìm cánh đồng bị nhiễm khuẩn trong hai ngày.\n" +
                            "- Khuyến khích các tác nhân kiểm soát sinh học: bọ trĩ săn mồi, bọ cánh cứng coccinellid, bọ anthocorid và bọ cánh cứng staphylinid.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pests%2Frice_thrips.jpg?alt=media&token=c68ab507-a166-4ecc-8eec-96c1400141a4");
            pests.add(pests4);

            Pests pests5 = new Pests("Rice bug", "Bọ lúa (Bọ xít dài)", "The most common species of rice bug are Leptocorisa oratorius F. and Leptocorisa acuta Thunberg.", "Loài bọ gạo phổ biến nhất là Leptocorisa oratorius F. và Leptocorisa acuta Thunberg.",
                    "The life cycle of rice bugs is completed by 4 to 5 weeks. Females lay eggs in batches of 10 to 20 rows on the leaf blade's upper surface. When freshly deposited, eggs are a cream-yellow colour, turning reddish-brown after approximately one week. After 8-29 days, adults of both sexes are fully mature. Adults may live up to 69 days. \n" +
                            "On average, females live longer than males: 60 and 48 days, respectively. The bug is common on grasses, active early morning and late afternoon. High populations occur in rice fields if they have weedy areas or stands of weeds nearby.",
                    "Vòng đời của bọ xít gạo kéo dài từ 4 đến 5 tuần. Rệp cái đẻ trứng thành từng đợt từ 10 đến 20 hàng trên mặt trên phiến lá. Khi mới đẻ trứng có màu vàng kem, khoảng sau chuyển sang màu nâu đỏ. một tuần. Sau 8-29 ngày, con trưởng thành của cả hai giới đều trưởng thành hoàn toàn. Con trưởng thành có thể sống tới 69 ngày. \n" +
                            "Trung bình, con cái sống lâu hơn con đực: tương ứng là 60 và 48 ngày. Bọ này phổ biến trên cỏ, hoạt động vào sáng sớm và chiều muộn. Mật độ cao xuất hiện trên ruộng lúa nếu chúng có khu vực cỏ dại hoặc đám cỏ dại gần đó.",
                    "Check the plant for feeding damage, such as:\n" +
                            "- Small or shrivelled grains,\n" +
                            "- Deformed or spotty grains,\n" +
                            "- Empty grains and erect panicles.\n" +
                            "\n" +
                            "The symptoms can be confused with the damage caused by nutrient deficiency or flower thrips. To confirm rice bug infestation, check for the presence of insects:\n" +
                            "- Oval, shiny, and reddish brown eggs along the midrib of the leaf\n" +
                            "- Slender and brown-green nymphs and adults feeding on endosperm of rice grains\n" +
                            "- Offensive smell",
                    "Kiểm tra xem cây có bị hư hại khi cho ăn không, chẳng hạn như:\n" +
                            "- Hạt nhỏ hoặc teo lại,\n" +
                            "- Hạt bị biến dạng hoặc đốm,\n" +
                            "- Hạt rỗng và bông dựng đứng.\n" +
                            "\n" +
                            "Các triệu chứng có thể bị nhầm lẫn với thiệt hại do thiếu chất dinh dưỡng hoặc bọ trĩ hoa. Để xác nhận sự phá hoại của bọ xít, hãy kiểm tra sự hiện diện của côn trùng:\n" +
                            "- Trứng hình bầu dục, sáng bóng và màu nâu đỏ dọc theo gân lá\n" +
                            "- Nhộng và con trưởng thành mảnh khảnh và có màu xanh nâu ăn nội nhũ của hạt gạo\n" +
                            "- Mùi khó chịu",
                    "Rice bugs damage rice by sucking out the contents of developing grains from the pre-flowering spikelets to the soft dough stage, therefore causing unfilled or empty grains and discolouration. Immature and adult rice bugs both feed on rice grains.\n" +
                            "Both the adults and nymphs feed on grains at the milking stage. They can be serious rice pests and sometimes reduce yield by as much as 30%.",
                    "Rệp gạo gây hại cho lúa bằng cách hút các chất bên trong hạt đang phát triển từ bông non trước khi nở hoa đến giai đoạn bột mềm, do đó gây ra hạt lép hoặc rỗng và mất màu. Cả bọ lúa trưởng thành và non đều ăn hạt gạo.\n" +
                            "Cả con trưởng thành và con non đều ăn ngũ cốc ở giai đoạn vắt sữa. Chúng có thể là loài gây hại lúa nghiêm trọng và đôi khi làm giảm năng suất tới 30%",
                    "To manage Rice bugs:\n" +
                            "- Remove weeds from fields and surrounding areas to prevent the multiplication of rice bugs during fallow periods.\n" +
                            "- Level fields with even applications of fertilizer and water encourage rice to grow and develop at the same rate. Planting fields, within a village, at the same time (synchronous planting) also helps reduce rice bug problems.\n" +
                            "- Capturing rice bugs, in the early morning or late afternoon, by net can be effective at low rice bug densities, though labour intensive.\n" +
                            "- Encourage biological control agents: Some wasps, grasshoppers and spiders attack rice bugs or eggs. Indiscriminate insecticide use disrupts biological control, resulting in pest resurgence.\n" +
                            "\n" +
                            "For chemical control, before using a pesticide, contact a crop protection specialist for suggestions, guidance, and warnings specific to your situation:\n" +
                            "- Begin scouting the field at pre-flowering and continue daily until the stiff dough stage. Count rice bugs in the early morning or late afternoon from 20 hills while walking diagonally across a transplanted field. Adults often fly out of the way before you reach the rice plant, so counts may only reveal immature forms. Direct control may be required if there are more than 10 rice bugs/20 hills.\n" +
                            "- The choice of insecticide depends on many factors, such as the application equipment available, the insecticide's cost, the applicator's experience, or the presence of fish. The benefits of using an insecticide must be weighed against the risks to health and the environment. ",
                    "Để quản lý Bọ gạo:\n" +
                            "- Loại bỏ cỏ dại khỏi ruộng và các khu vực xung quanh để ngăn chặn sự sinh sôi nảy nở của bọ xít trong thời kỳ bỏ hoang.\n" +
                            "- Ruộng bằng phẳng với việc bón phân và nước đồng đều sẽ khuyến khích lúa sinh trưởng và phát triển với tốc độ đồng đều. Việc trồng đồng thời trên các cánh đồng, trong một làng (trồng đồng bộ) cũng giúp giảm thiểu các vấn đề về bọ xít trên lúa.\n" +
                            "- Bắt bọ xít, vào sáng sớm hoặc chiều mát, bằng lưới có thể hiệu quả với mật độ bọ xít thấp, tuy tốn nhiều công sức.\n" +
                            "- Khuyến khích các tác nhân kiểm soát sinh học: Một số loài ong bắp cày, châu chấu và nhện tấn công bọ gạo hoặc trứng. Việc sử dụng thuốc trừ sâu bừa bãi làm gián đoạn quá trình kiểm soát sinh học, dẫn đến sự bùng phát trở lại của sâu bệnh.\n" +
                            "\n" +
                            "Để kiểm soát hóa chất, trước khi sử dụng thuốc trừ sâu, hãy liên hệ với chuyên gia bảo vệ thực vật để được gợi ý, hướng dẫn và cảnh báo cụ thể cho trường hợp của bạn:\n" +
                            "- Bắt đầu dò ruộng từ trước trỗ và tiếp tục hàng ngày cho đến khi lúa trỗ cứng. Đếm bọ lúa vào sáng sớm hoặc chiều tối từ 20 ngọn đồi khi đi chéo qua ruộng cấy. Sâu trưởng thành thường bay ra khỏi đường trước khi bạn đến cây lúa, vì vậy số lượng có thể chỉ tiết lộ những dạng chưa trưởng thành. Có thể cần phải kiểm soát trực tiếp nếu có hơn 10 con bọ xít/20 ngọn đồi.\n" +
                            "- Việc lựa chọn thuốc diệt côn trùng phụ thuộc vào nhiều yếu tố, chẳng hạn như thiết bị phun thuốc diệt côn trùng có sẵn, chi phí thuốc diệt côn trùng, kinh nghiệm của người phun thuốc hoặc sự hiện diện của cá. Lợi ích của việc sử dụng thuốc diệt côn trùng phải được cân nhắc với các rủi ro đối với sức khỏe và môi trường. ",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pests%2Frice_bug.jpg?alt=media&token=54086a34-0113-485b-a548-8f4eb0c1a7af");
            pests.add(pests5);

            Pests pests6 = new Pests("Black bug", "Bọ đen (Bọ xít đen)", "Scotinophora lurida", "Scotinophora lurida",
                    "The life cycle of black rice bugs is completed in 50-60 days. After the nymph stage, black rice bugs enter the final stage of their life cycle: adulthood. Adult bugs have distinct yellowish marks on their backs. During this stage, black bugs reproduce, and they can lay eggs up to three times. Adult rice black bugs have a lifespan of about 22 days.",
                    "Vòng đời của bọ xít gạo hoàn thành trong 50-60 ngày. Sau giai đoạn nhộng, bọ xít gạo bước vào giai đoạn cuối cùng của vòng đời: trưởng thành. Bọ trưởng thành có những vết màu vàng nhạt rõ rệt trên lưng. Ở giai đoạn này, bọ xít đen có màu đen bọ sinh sản và chúng có thể đẻ trứng tới ba lần. Bọ xít đen trưởng thành có vòng đời khoảng 22 ngày.",
                    "Check the following symptoms:\n" +
                            "- Check leaves for discolouration. Black bug damage can cause reddish brown or yellowing of plants. Leaves also have chlorotic lesions.\n" +
                            "- Check for decreased tillering. Bugburn symptoms show wilting of tillers with no visible honeydew deposits or sooty moulds.\n" +
                            "- Plants are also stunted; and can develop stunted panicles, no panicles, incompletely exerted panicles, and unfilled spikelets or whiteheads at the booting stage.\n" +
                            "- Check for deadhearts. Dead hearts can also be caused by stemborer. To confirm the cause of damage, pull infected plants. In black bug damage, infected plants cannot be pulled at the bases. Heavy infestation and \"bug burn\" is usually visible after heading or maturing.",
                    "Kiểm tra các triệu chứng sau:\n" +
                            "- Kiểm tra xem lá có bị đổi màu không. Sự phá hoại của bọ đen có thể khiến cây chuyển sang màu nâu đỏ hoặc vàng. Lá cũng có các tổn thương nhiễm clo.\n" +
                            "- Kiểm tra khả năng đẻ nhánh giảm. Các triệu chứng cháy lá cho thấy các chồi bị héo mà không nhìn thấy cặn mật hoặc mốc bồ hóng.\n" +
                            "- Cây cũng còi cọc; và có thể phát triển các bông còi cọc, không có bông, các bông không phát triển đầy đủ và các bông con không đầy hoặc mụn đầu trắng ở giai đoạn khởi động.\n" +
                            "- Kiểm tra tim chết. Tim chết cũng có thể do sâu đục thân gây ra. Để xác định nguyên nhân gây hại, hãy nhổ những cây bị nhiễm bệnh. Trong trường hợp bọ xít gây hại, không thể nhổ những cây bị nhiễm bệnh ở gốc. Nhiễm nặng và \"đốt bọ\" là thường xuất hiện sau khi trưởng thành hoặc trưởng thành.",
                    "The black bug feeds on the rice plant from the seedling to the maturity growth stages. Ten black bug adults per hill can cause losses of up to 35% in some rice.\n" +
                            "Black bugs remove the sap of the plant. They can cause browning of leaves, dead hearts, and bug burn. Their damage also causes stunting in plants, reduced tiller number, and formation of whiteheads. In severe cases, black bugs weaken the plant preventing them from producing seeds.",
                    "Rệp đen ăn cây lúa từ khi mạ đến giai đoạn trưởng thành. Mười con bọ xít đen trưởng thành trên một ngọn đồi có thể gây thiệt hại lên đến 35% ở một số loại lúa.\n" +
                            "Bọ đen hút nhựa cây. Chúng có thể làm lá bị nâu, chết lõi và bọ đốt. Tác hại của chúng cũng khiến cây còi cọc, số nhánh đẻ nhánh giảm và hình thành mụn đầu trắng. Trong trường hợp nghiêm trọng, bọ đen làm cây yếu đi ngăn không cho chúng tạo hạt.",
                    "To prevent black bug infestation:\n" +
                            "- Use resistant varieties.\n" +
                            "- Contact your local agriculture office for up-to-date lists of varieties available.\n" +
                            "- Maintain a clean field by removing the weeds and drying the rice field after ploughing.\n" +
                            "- Plant rice varieties of the same maturity date to break the insect’s cycle.\n" +
                            "- Use of mercury bulbs as light traps for egg-laying adults, light trapping of insects should start 5 days before and after the full moon.\n" +
                            "- Encourage biological control agents, such as tiny wasps (parasitize the eggs), ground beetles, spiders, crickets, and red ants (attack the eggs, nymphs, and adults), coccinellid beetles, ducks, toads (feed on eggs and spirits), fungi species (attacks larvae and adults).\n" +
                            "\n" +
                            "To control black bug infestation:\n" +
                            "- During early infestation, raise the water level in the field for 2−3 days to force the insects to move upwards.\n" +
                            "- Flood the fields. This can cause higher egg mortality.\n" +
                            "- After harvest, plough fields to remove remaining insects.",
                    "Để ngăn chặn sự xâm nhập của bọ đen:\n" +
                            "- Sử dụng giống kháng.\n" +
                            "- Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Duy trì ruộng sạch bằng cách nhổ cỏ và phơi ruộng sau khi cày.\n" +
                            "- Trồng các giống lúa có cùng ngày chín để phá vỡ chu kỳ của côn trùng.\n" +
                            "- Sử dụng bóng đèn thủy ngân làm bẫy đèn cho con trưởng thành đang đẻ trứng, bẫy đèn cho côn trùng nên bắt đầu từ 5 ngày trước và sau trăng tròn.\n" +
                            "- Khuyến khích các tác nhân kiểm soát sinh học, chẳng hạn như ong bắp cày nhỏ (ký sinh trên trứng), bọ đất, nhện, dế và kiến đỏ (tấn công trứng, nhộng và trưởng thành), bọ cánh cứng, vịt, cóc (ăn trứng và rượu mạnh). ), các loài nấm (tấn công ấu trùng và con trưởng thành).\n" +
                            "\n" +
                            "Để kiểm soát sự phá hoại của bọ đen:\n" +
                            "- Trong giai đoạn đầu lây nhiễm, hãy nâng mực nước trên ruộng trong 2−3 ngày để buộc côn trùng di chuyển lên trên.\n" +
                            "- Làm ngập các cánh đồng. Điều này có thể khiến tỷ lệ trứng chết cao hơn.\n" +
                            "- Sau khi thu hoạch, cày ruộng để loại bỏ côn trùng còn sót lại.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pests%2Fblack_bug.jpg?alt=media&token=b2283a8e-4d91-4c71-a5dd-4aea9a32e40b");
            pests.add(pests6);

            Pests pests7 = new Pests("Rice gall midge", "Muỗi mật gạo (muỗi hành)", "Orseolia oryzae (Wood-Mason)", "Orseolia oryzae (Wood-Mason)",
                    "The rice gall midge (Orseolia oryzae) is an insect pest that infests rice plants and causes silver shoots. The life cycle of O. oryzae is completed within 21–36 days. The insect has three larval stages, a pre-pupal stage, and a pupal stage. Adult females have bright red abdomens and live longer than males. The females lay eggs inside the rice stems, where the larvae feed and cause damage.",
                    "Loài ruồi đục mật (Orseolia oryzae) là loài côn trùng gây hại cho cây lúa và gây bạc lá chồi. Vòng đời của O. oryzae kết thúc trong vòng 21–36 ngày. Loài côn trùng này có ba giai đoạn ấu trùng, giai đoạn tiền nhộng, và giai đoạn nhộng. Con cái trưởng thành có bụng màu đỏ tươi và sống lâu hơn con đực. Con cái đẻ trứng bên trong thân lúa, nơi ấu trùng ăn và gây hại.",
                    "Symptoms of rice gall midge damage include:\n" +
                            "- Formation of a hollow cavity or tubular gall at the base of the infested tiller. The gall formed is a silvery white hollow tube, 1 cm wide and 10−30 cm long\n" +
                            "- Affected tiller inhibits the growth of leaves and fails to produce panicles\n" +
                            "deformed, wilted, and rolled leaf\n" +
                            "- Elongation of leaf sheaths also called onion leaf or silver shoot\n" +
                            "plant stunting\n" +
                            "\n" +
                            "The rolled leaves can also be associated with the symptom caused by rice thrips. To confirm the cause of the problem, check for the presence of an insect. Particularly elongate-tubular eggs and maggot-like larvae feeding inside developing buds." +
                            "- Check for deadhearts. Dead hearts can also be caused by stemborer. To confirm the cause of damage, pull infected plants. In black bug damage, infected plants cannot be pulled at the bases. Heavy infestation and \"bug burn\" is usually visible after heading or maturing.",
                    "Các triệu chứng khi bị muỗi vằn hại lúa bao gồm:\n" +
                            "- Hình thành khoang rỗng hoặc túi mật hình ống ở gốc của nhánh bị nhiễm khuẩn. Túi mật hình thành là một ống rỗng màu trắng bạc, rộng 1 cm và dài 10−30 cm\n" +
                            "- Máy xới bị ảnh hưởng ức chế sự phát triển của lá và không thể tạo bông\n" +
                            "chiếc lá biến dạng, héo úa và cuộn lại\n" +
                            "- Bẹ lá kéo dài còn gọi là lá hành hay bẹ bạc\n" +
                            "cây còi cọc\n" +
                            "\n" +
                            "Lá cuộn lại cũng có thể liên quan đến triệu chứng do bọ trĩ gây ra. Để xác định nguyên nhân của vấn đề, hãy kiểm tra sự hiện diện của côn trùng. Đặc biệt là trứng hình ống dài và ấu trùng giống giòi ăn bên trong các chồi đang phát triển." +
                            "- Kiểm tra tim chết. Tim chết cũng có thể do sâu đục thân gây ra. Để xác định nguyên nhân gây hại, hãy nhổ những cây bị nhiễm bệnh. Trong trường hợp bọ xít gây hại, không thể nhổ những cây bị nhiễm bệnh ở gốc. Nhiễm nặng và \"đốt bọ\" là thường xuất hiện sau khi trưởng thành hoặc trưởng thành.",
                    "Rice gall midge forms a tubular gall at the base of tillers, causing elongation of leaf sheaths called onion leaf or silver shoot. The Asian gall midge can cause significant yield losses of 30−40% in some areas like Sri Lanka and parts of India.",
                    "Nấm túi mật hình thành một túi mật hình ống ở gốc nhánh, làm cho các bẹ lá kéo dài gọi là lá hành hoặc chồi bạc. Muỗi túi mật châu Á có thể gây thiệt hại năng suất đáng kể 30−40% ở một số khu vực như Sri Lanka và một số vùng của Ấn Độ .",
                    "To manage the Rice gall midge:\n" +
                            "- Use resistant varieties. Contact your local agriculture office for up-to-date lists of varieties available.\n" +
                            "- Plow the ratoon of the previous crop and remove all off-season plant hosts.\n" +
                            "- Encourage biological control agents: platygasterid, eupelmid, and pteromalid wasps (parasitize the larvae), phytoseiid mites (feed on eggs), spiders (feed on adults).",
                    "Để quản lý Muỗi mật gạo:\n" +
                            "- Sử dụng các giống kháng. Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Cày xới đất của vụ trước và loại bỏ tất cả ký chủ thực vật trái vụ.\n" +
                            "- Khuyến khích các tác nhân kiểm soát sinh học: thú mỏ vịt, eupelmid và ong bắp cày pteromalid (ký sinh ở ấu trùng), ve phytoseiid (ăn trứng), nhện (ăn người trưởng thành).",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pests%2Frice_gall_midge.jpg?alt=media&token=13a864a6-3487-47fa-91a3-b92c106709ac");
            pests.add(pests7);
            Pests pests8 = new Pests("Green leafhopper", "Rầy xanh", "Two species of green leafhoppers (GLH) can spread tungro: Nephotettix malayanus and Nephotettix virescens.", "Hai loài rầy xanh (GLH) có thể phát tán bệnh tungro: Nephotettix malayanus và Nephotettix virescens.",
                    "Green leafhoppers usually have a short life cycle of only a few weeks. There are several generations per year, with populations building up through spring, and peaking during summer and autumn. Green leafhopper adults are pale green with two black spots at the centre of the forewings and black markings on the head. They are active during both day and night, walk sideways, and when disturbed, quickly jump from the leaf blade.",
                    "Rầy xanh thường có vòng đời ngắn chỉ vài tuần. Có nhiều thế hệ mỗi năm, với quần thể phát triển qua mùa xuân và đạt đỉnh điểm vào mùa hè và mùa thu. Rầy xanh trưởng thành có màu xanh nhạt với hai đốm đen ở giữa cánh trước và mảng đen trên đầu. Chúng hoạt động cả ngày lẫn đêm, đi ngang và khi bị quấy rầy thì nhanh chóng nhảy khỏi phiến lá.",
                    "Rice fields infested by GLH can have tungro, yellow dwarf, yellow-orange leaf, and transitory yellowing diseases. Symptoms include:\n" +
                            "- Stunted plants and reduced vigour\n" +
                            "- Reduced number of productive tillers\n" +
                            "- Withering or complete plant drying",
                    "Ruộng lúa bị nhiễm GLH có thể mắc các bệnh tungro, vàng lùn, vàng cam và vàng lá tạm thời. Các triệu chứng bao gồm:\n" +
                            "- Cây còi cọc và giảm sức sống\n" +
                            "- Giảm số lượng máy xới có năng suất\n" +
                            "- Cây khô héo hoặc khô hoàn toàn",
                    "Green leafhoppers are the most common leafhoppers in rice fields and are primarily critical because they spread viral diseases such as tungro, yellow dwarf, yellow-orange leaf, transitory yellowing, and dwarf. Both nymphs and adults feed by extracting plant sap with their needle-shaped mouthparts.",
                    "Rầy xanh là loài rầy phổ biến nhất trên ruộng lúa và đặc biệt nguy hiểm vì chúng lây lan các bệnh do virus như bệnh tungro, vàng lùn, vàng lá cam, vàng lá tạm thời và lùn. Cả rầy non và rầy trưởng thành đều ăn bằng cách hút nhựa cây bằng kim của chúng -hình cái miệng.",
                    "To manage Green leafhoppers:\n" +
                            "- Use GLH-resistant and tungro-resistant varieties. Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Reduce the number of rice crops to two per year and synchronized crop establishment across farms reduces leafhoppers and other insect vectors.\n" +
                            "- Transplant older seedlings (>3 weeks) to reduce viral disease susceptibility transmitted by leafhoppers.\n" +
                            "- Plant early within a given planting period, particularly in the dry season to reduce the risk of insect-vector disease.\n" +
                            "- Avoid planting during the peak of GLH activity (shown by historical records) to avoid infestation. Light traps can be used to show GLH numbers.\n" +
                            "- Apply nitrogen as needed (e.g., using the Leaf Color Chart) to avoid contributing to population outbreaks by applying too much nitrogen, or hindering plant recovery from planthopper damage by applying insufficient nitrogen.\n" +
                            "- Control weeds in the field and on the bunds to remove the preferred grassy hosts of GLH and promotes crop vigour.\n" +
                            "- Perform crop rotation with a non-rice crop during the dry season to decrease alternate hosts for diseases.\n" +
                            "Intercrop upland rice with soybean to reduce the incidence of leafhoppers on rice.",
                    "Để quản lý Rầy xanh:\n" +
                            "- Sử dụng các giống kháng GLH và kháng bệnh tungro. Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Giảm số vụ lúa xuống còn hai vụ mỗi năm và thiết lập cây trồng đồng bộ trên khắp các trang trại giúp giảm rầy và các vật trung gian truyền bệnh côn trùng khác.\n" +
                            "- Cấy những cây con già hơn (>3 tuần) để giảm tính mẫn cảm với bệnh do virus lây truyền qua rầy.\n" +
                            "- Trồng sớm trong khoảng thời gian trồng nhất định, đặc biệt là vào mùa khô để giảm nguy cơ mắc bệnh do côn trùng truyền bệnh.\n" +
                            "- Tránh trồng cây trong thời gian cao điểm của hoạt động GLH (được hiển thị bằng hồ sơ lịch sử) để tránh bị phá hoại. Có thể sử dụng bẫy đèn để hiển thị số GLH.\n" +
                            "- Bón đạm khi cần thiết (ví dụ: sử dụng Biểu đồ màu của lá) để tránh góp phần làm bùng phát dân số do bón quá nhiều đạm hoặc cản trở quá trình phục hồi của cây do rầy gây hại do bón không đủ đạm.\n" +
                            "- Kiểm soát cỏ dại trên đồng ruộng và trên các bờ ruộng để loại bỏ các vật chủ cỏ ưa thích của GLH và thúc đẩy sức sống của cây trồng.\n" +
                            "- Thực hiện luân canh cây trồng không phải lúa trong mùa khô để giảm vật chủ luân phiên của bệnh.\n" +
                            "Xen lúa nương với đậu tương để giảm tỷ lệ rầy trên lúa.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pests%2Fgreen_planthopper.jpg?alt=media&token=ec761116-5237-4114-bb3c-2276e5e45dff");
            pests.add(pests8);
            for (Pests p : pests) {
                pestDao.insert(p);
            }

            //****Crops-Pests****
            CropPestDao cropPestDao = db.cropPestDao();
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 18"), pestDao.getIdByName("Rice leaffolder")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 18"), pestDao.getIdByName("Planthopper")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 18"), pestDao.getIdByName("Stem borer")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 18"), pestDao.getIdByName("Rice thrips")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 18"), pestDao.getIdByName("Rice bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 18"), pestDao.getIdByName("Black bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 18"), pestDao.getIdByName("Rice gall midge")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 18"), pestDao.getIdByName("Green leafhopper")));

            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT 08"), pestDao.getIdByName("Rice leaffolder")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT 08"), pestDao.getIdByName("Planthopper")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT 08"), pestDao.getIdByName("Stem borer")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT 08"), pestDao.getIdByName("Rice thrips")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT 08"), pestDao.getIdByName("Rice bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT 08"), pestDao.getIdByName("Black bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT 08"), pestDao.getIdByName("Rice gall midge")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT 08"), pestDao.getIdByName("Green leafhopper")));

            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 5451"), pestDao.getIdByName("Rice leaffolder")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 5451"), pestDao.getIdByName("Planthopper")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 5451"), pestDao.getIdByName("Stem borer")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 5451"), pestDao.getIdByName("Rice thrips")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 5451"), pestDao.getIdByName("Rice bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 5451"), pestDao.getIdByName("Black bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 5451"), pestDao.getIdByName("Rice gall midge")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM 5451"), pestDao.getIdByName("Green leafhopper")));

            cropPestDao.insert(new CropPests(cropDao.getIdByName("IR 50404"), pestDao.getIdByName("Rice leaffolder")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("IR 50404"), pestDao.getIdByName("Planthopper")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("IR 50404"), pestDao.getIdByName("Stem borer")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("IR 50404"), pestDao.getIdByName("Rice thrips")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("IR 50404"), pestDao.getIdByName("Rice bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("IR 50404"), pestDao.getIdByName("Black bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("IR 50404"), pestDao.getIdByName("Rice gall midge")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("IR 50404"), pestDao.getIdByName("Green leafhopper")));

            //****Diseases****
            DiseaseDao diseaseDao = db.diseaseDao();
            ArrayList<Diseases> diseases = new ArrayList<>();
            Diseases diseases1 = new Diseases("Blast", "Đạo ôn", "Check the leaf and collar for lesions:\n" +
                    "- Initial symptoms appear as white to gray-green lesions or spots, with dark green borders.\n" +
                    "- Older lesions on the leaves are elliptical or spindle-shaped and whitish to gray centers with red to brownish or necrotic border.\n" +
                    "\n" +
                    "Check for other symptoms:\n" +
                    "- Some resemble diamond shape, wide in the center and pointed toward either ends.\n" +
                    "- Lesions can enlarge and coalesce, growing together, to kill the entire leaves.",
                    "Kiểm tra lá và cổ áo xem có vết thương không:\n" +
                            "- Các triệu chứng ban đầu xuất hiện dưới dạng các vết hoặc đốm màu trắng đến xanh xám, có viền màu xanh đậm.\n" +
                            "- Các vết bệnh cũ hơn trên lá có hình elip hoặc hình trục chính và tâm có màu trắng đến xám với đường viền màu đỏ đến hơi nâu hoặc hoại tử.\n" +
                            "\n" +
                            "Kiểm tra các triệu chứng khác:\n" +
                            "- Một số giống hình thoi, rộng ở giữa và nhọn về hai đầu.\n" +
                            "- Vết bệnh có thể to ra và liên kết với nhau, phát triển cùng nhau, làm chết toàn bộ lá.",
                    "Blast is caused by the fungus Magnaporthe oryzae. It can affect all above ground parts of a rice plant: leaf, collar, node, neck, parts of panicle, and sometimes leaf sheath. \n" +
                            "Rice blast is one of the most destructive diseases of rice. A leaf blast infection can kill seedlings or plants until the tillering stage. At later growth stages, a severe leaf blast infection reduces leaf area for grain fill, reducing grain yield.",
                    "Bệnh đạo ôn do nấm Magnaporthe oryzae gây ra. Nó có thể ảnh hưởng đến tất cả các bộ phận trên mặt đất của cây lúa: lá, cổ, đốt, cổ, các phần của bông và đôi khi là bẹ lá. \n" +
                            "Đạo ôn là một trong những bệnh phá hoại lúa mạnh nhất. Nhiễm đạo ôn lá có thể làm chết cây con hoặc cây cho đến giai đoạn đẻ nhánh. Ở các giai đoạn sinh trưởng sau, nhiễm đạo ôn lá nặng làm giảm diện tích lá lấp hạt, làm giảm năng suất hạt.",
                    "To manage the blast:\n" +
                            "- Adjust planting time. Sow seeds early, when possible, after the onset of the rainy season.\n" +
                            "- Split nitrogen fertilizer application in two or more treatments. Excessive use of fertilizer can increase blast intensity.\n" +
                            "- Flood the field as often as possible.\n" +
                            "\n" +
                            "Systemic fungicides like triazoles and strobilurins can be used judiciously for control to control blasts. A fungicide application at heading can be effective in preventing the disease.",
                    "Để quản lý bệnh đạo ôn:\n" +
                            "- Điều chỉnh thời gian gieo trồng. Gieo hạt sớm, khi có thể, sau khi bắt đầu mùa mưa.\n" +
                            "- Chia nhỏ việc bón phân đạm thành hai hoặc nhiều lần xử lý. Sử dụng quá nhiều phân bón có thể làm tăng cường độ bệnh đạo ôn.\n" +
                            "- Làm ngập cánh đồng thường xuyên nhất có thể.\n" +
                            "\n" +
                            "Các loại thuốc diệt nấm toàn thân như triazole và strobilurin có thể được sử dụng một cách thận trọng để kiểm soát bệnh đạo ôn. Phun thuốc diệt nấm vào thời điểm có thể có hiệu quả trong việc ngăn ngừa bệnh.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Fblast.jpg?alt=media&token=36d0234f-86a6-49b5-8290-af95c1472702");
            diseases.add(diseases1);
            Diseases diseases2 = new Diseases("Leaf Scald", "Bỏng lá", "Check the plant for the following symptoms:\n" +
                    "- Zonate lesions of alternating light tan and dark brown starting from leaf tips or edges\n" +
                    "- Oblong lesions with light brown halos in mature leaves\n" +
                    "- Translucent leaf tips and margins\n" +
                    "Individual lesions are 1−5 cm long and 0.5−1 cm wide or may almost cover the entire leaf. The continuous enlargement and coalescing of lesions result in blighting of a large part of the leaf blade. The affected areas dry out giving the leaf a scalded appearance.",
                    "Kiểm tra cây xem có các triệu chứng sau không:\n" +
                            "- Vết bệnh theo vùng có màu nâu nhạt và nâu sẫm xen kẽ bắt đầu từ đầu hoặc mép lá\n" +
                            "- Vết bệnh thuôn dài có quầng nâu nhạt ở lá trưởng thành\n" +
                            "- Đầu lá và lề trong mờ\n" +
                            "Các vết bệnh riêng lẻ dài 1−5 cm và rộng 0,5−1 cm hoặc có thể gần như bao phủ toàn bộ lá. Các vết bệnh liên tục mở rộng và liên kết với nhau dẫn đến phần lớn phiến lá bị cháy lá. vẻ ngoài bị bỏng.",
                    "Leaf scald is a fungal disease caused by Microdochium oryzae, which causes the scalded appearance of leaves.\n"
                            + "Leaf scald commonly occurs in Central and South America, where it has caused significant yield losses. It also occurs in Asia, Africa, and the U.S. The disease is found in upland, rainfed, irrigated, and mangrove areas.",
                    "Bỏng lá là một bệnh nấm do Microdochium oryzae gây ra, khiến lá bị bỏng.\n"
                            + "Bỏng lá thường xảy ra ở Trung và Nam Mỹ, nơi nó đã gây thiệt hại đáng kể về năng suất. Nó cũng xảy ra ở Châu Á, Châu Phi và Hoa Kỳ. Bệnh được tìm thấy ở vùng cao, vùng có mưa, được tưới tiêu và rừng ngập mặn.",
                    "To manage leaf scald:\n" +
                            "- Use resistant varieties.\n" +
                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Avoid high use of fertilizer. Apply Nitrogen in split.\n" +
                            "- Use benomyl, carbendazim, quitozene, and thiophanate-methyl to treat seeds.\n" +
                            "- In the field, spraying of benomyl, fentin acetate, edifenphos, and validamycin significantly reduce the incidence of leaf scald. Foliar application of captafol, mancozeb, and copper oxychloride also reduces the incidence and severity of the fungal disease.\n" +
                            "\n" +
                            "To prevent pathogen survival across cropping seasons:\n" +
                            "- Remove weeds.\n" +
                            "- Plow under of rice stubbles.\n" +
                            "- Remove infected rice ratoons.",
                    "Để xử lý bỏng lá:\n" +
                            "- Sử dụng giống kháng.\n" +
                            "- Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Tránh sử dụng nhiều phân bón. Bón đạm chia nhỏ.\n" +
                            "- Sử dụng benomyl, carbendazim, quitozen và thiophanate-methyl để xử lý hạt giống.\n" +
                            "- Trên đồng ruộng, phun benomyl, fentin axetat, edifenphos và validamycin làm giảm đáng kể tỷ lệ bị bỏng lá. Việc phun captafol, mancozeb và đồng oxychloride trên lá cũng làm giảm tỷ lệ mắc và mức độ nghiêm trọng của bệnh nấm.\n" +
                            "\n" +
                            "Để ngăn chặn sự tồn tại của mầm bệnh trong các mùa vụ:\n" +
                            "- Loại bỏ cỏ dại.\n" +
                            "- Cày dưới gốc rạ.\n" +
                            "- Loại bỏ những khẩu phần gạo bị nhiễm bệnh.", "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Fleaf_scald.jpg?alt=media&token=58ca4ae1-d05c-4274-b9a9-82b9fb0febf4");
            diseases.add(diseases2);
            Diseases diseases3 = new Diseases("Sheath rot", "Thối vỏ (Thối bẹ)", "Although sheath rot can be observed in the field as a single disease on rice sheath, more often, it has become part of a complex of grain and leaf sheath discolouration commonly observed on wet-season rice.\n" +
                    "- Check for lesions: The typical sheath rot lesion starts at the uppermost leaf sheath enclosing the young panicles. It appears oblong or as irregular spot with dark reddish, brown margins, and gray center or brownish gray throughout.\n" +
                    "- Check for spots:Usually several spots are observed and these spots enlarge and combine or grow together and can cover most of the leaf sheath. Panicles remain within the sheath or may partially emerge. Affected leaf sheaths may have abundant whitish powdery fungal growth (mycelium) visible on the outer surface. Panicles that have not emerged rot and the florets turn red-brown to dark brown.\n",
                    "Mặc dù bệnh thối bẹ có thể được quan sát trên đồng ruộng như một bệnh đơn lẻ trên bẹ lúa, nhưng thường xuyên hơn, nó đã trở thành một phần của phức hợp làm mất màu hạt và bẹ lá thường thấy trên lúa mùa mưa.\n" +
                            "- Kiểm tra vết bệnh: Vết bệnh thối bẹ lá điển hình bắt đầu ở bẹ lá trên cùng bao quanh các chùy non. Nó xuất hiện dạng đốm hình thuôn dài hoặc không đều với màu đỏ sẫm, mép màu nâu và phần giữa màu xám hoặc xám nâu khắp nơi.\n" +
                            "- Kiểm tra các đốm: Thường quan sát thấy một số đốm và các đốm này mở rộng và kết hợp hoặc phát triển cùng nhau và có thể bao phủ hầu hết bẹ lá. Các chùy vẫn nằm trong bẹ hoặc có thể nổi lên một phần. Các bẹ lá bị ảnh hưởng có thể có nhiều nấm phấn trắng phát triển ( sợi nấm) có thể nhìn thấy trên bề mặt bên ngoài. Các bông không nổi lên bị thối và các hoa con chuyển sang màu nâu đỏ đến nâu sẫm.\n",
                    "Sheath rot is caused by Sarocladium oryzae. The disease reduces grain yield by retarding or aborting panicle emergence and producing unfilled seeds and sterile panicles. Sheath rot also reduces grain quality by causing panicles to rot and grains to become discoloured.\n" +
                            "Sheath rot infects the rice plant at all growth stages, but it is most destructive when infection occurs during or after the booting stage, before the emergence of the panicle.\n" +
                            "It has caused 20−85% yield loss in Taiwan and 30−80% in Vietnam, the Philippines, and India. In Japan, affected areas range from 51,000−122,000 hectares and annual losses are estimated to be 16,000−35,000 tons.\n" +
                            "Infected seeds and mycelium carried by the rice crop residue play an essential role as the source of inoculum for primary infection.",
                    "Bệnh thối bẹ do Sarocladium oryzae gây ra. Căn bệnh này làm giảm năng suất hạt bằng cách làm chậm hoặc hủy bỏ sự xuất hiện của bông và tạo ra hạt không đầy hạt và bông vô trùng. Bệnh thối bẹ cũng làm giảm chất lượng hạt bằng cách khiến bông bị thối và hạt bị đổi màu.\n" +
                            "Bệnh thối bẹ lá ảnh hưởng đến cây lúa ở tất cả các giai đoạn sinh trưởng, nhưng nó có sức tàn phá nặng nề nhất khi nhiễm trùng xảy ra trong hoặc sau giai đoạn làm đòng, trước khi bông lúa xuất hiện.\n" +
                            "Nó đã gây thiệt hại 20−85% năng suất ở Đài Loan và 30−80% ở Việt Nam, Philippines và Ấn Độ. Tại Nhật Bản, các khu vực bị ảnh hưởng nằm trong khoảng từ 51.000−122.000 ha và thiệt hại hàng năm ước tính là 16.000−35.000 tấn.\n" +
                            "Hạt bị nhiễm bệnh và sợi nấm mang theo tàn dư cây lúa đóng vai trò thiết yếu là nguồn lây nhiễm ban đầu.",
                    "To manage sheath rot:\n" +
                            "- Sheath rot is a seed-borne disease, use healthy seeds.\n" +
                            "- Minimize insect infestation in rice fields. Insects cause injuries to the plants that allow the fungi to enter the plant and cause infection.\n" +
                            "- The fungi survive on rice crop residue after harvest and can cause infection in the following seasons. Remove infected stubbles after harvest.\n" +
                            "- Use optimum plant spacing. Sow three plants per hill at 20 cm row spacing.\n" +
                            "- Apply potash at tillering stage.\n" +
                            "- Apply foliar spray of calcium sulfate and zinc sulfate.\n" +
                            "- Apply a seed treatment fungicide like carbendazim, edifenphos, or mancozeb as seed treatment and foliar spraying at the heading stage.\n" +
                            "- Apply a foliar fungicide like benomyl and copper oxychloride as foliar sprays.",
                    "Để quản lý thối vỏ:\n" +
                            "- Bệnh thối bẹ là bệnh truyền qua hạt giống, hãy sử dụng hạt giống khỏe mạnh.\n" +
                            "- Giảm thiểu sự phá hoại của côn trùng trên ruộng lúa. Côn trùng gây thương tích cho cây trồng tạo điều kiện cho nấm xâm nhập vào cây và gây nhiễm trùng.\n" +
                            "- Nấm tồn tại trên tàn dư cây lúa sau khi thu hoạch và có thể lây nhiễm sang các vụ sau. Hãy nhổ bỏ các gốc rạ bị nhiễm bệnh sau khi thu hoạch.\n" +
                            "- Sử dụng khoảng cách cây tối ưu. Gieo ba cây trên mỗi ngọn đồi với khoảng cách hàng 20 cm.\n" +
                            "- Bón phân kali ở giai đoạn đẻ nhánh.\n" +
                            "- Phun qua lá canxi sulfat và kẽm sulfat.\n" +
                            "- Áp dụng thuốc diệt nấm xử lý hạt giống như carbendazim, edifenphos hoặc mancozeb để xử lý hạt giống và phun qua lá ở giai đoạn trổ bông.\n" +
                            "- Phun thuốc diệt nấm trên lá như benomyl và đồng oxychloride dưới dạng thuốc xịt qua lá.", "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Fsheath_rot.png?alt=media&token=1fd6ec9a-0961-42b0-b1a6-2371b651b362");
            diseases.add(diseases3);
            Diseases diseases4 = new Diseases("Brown spot", "Đốm nâu", "Check for lesions:\n" +
                    "- Infected seedlings have small, circular, yellow brown or brown lesions that may girdle the coleoptile and distort primary and secondary leaves.\n" +
                    "- Starting at tillering stage, lesions can be observed on the leaves. They are initially small, circular, and dark brown to purple-brown.\n" +
                    "- Fully developed lesions are circular to oval with a light brown to gray center, surrounded by a reddish brown margin caused by the toxin produced by the fungi.",
                    "Kiểm tra vết thương:\n" +
                            "- Cây con bị nhiễm bệnh có các vết bệnh nhỏ, hình tròn, màu vàng nâu hoặc nâu có thể bao quanh lá mầm và làm biến dạng lá sơ cấp và lá thứ cấp.\n" +
                            "- Bắt đầu từ giai đoạn đẻ nhánh, có thể quan sát thấy vết bệnh trên lá. Ban đầu chúng nhỏ, hình tròn và có màu nâu sẫm đến nâu tím.\n" +
                            "- Vết bệnh đã phát triển hoàn toàn có hình tròn đến hình bầu dục với tâm màu nâu nhạt đến xám, xung quanh có viền màu nâu đỏ do độc tố của nấm tiết ra.",
                    "Brown spot has been historically largely ignored as one of the most common and most damaging rice diseases. Brown spot is caused by the fungus Bipolaris oryzae producing ellipsoidal or circular lesions on the coleoptile, leaf blade, leaf sheath, and glume." +
                            "Brown spot causes both quantity and quality losses. \n" +
                            "On average, the disease causes a 5% yield loss across all lowland rice production in South and Southeast Asia. Severely infected fields can have as high as 45% yield loss.\n" +
                            "Heavily infected seeds cause seedling blight, leading to 10−58% seedling mortality. It also affects the quality and the number of grains per panicle and reduces the kernel weight.",
                    "Đốm nâu trong lịch sử phần lớn bị bỏ qua vì là một trong những bệnh hại lúa phổ biến nhất và gây hại nhiều nhất. Đốm nâu là do nấm Bipolaris oryzae gây ra, tạo ra các vết bệnh hình elip hoặc hình tròn trên bao bao tử, phiến lá, bẹ lá và nếp nhăn." +
                            "Đốm nâu làm giảm cả số lượng và chất lượng. \n" +
                            "Trung bình, căn bệnh này làm giảm 5% năng suất trên toàn bộ sản lượng lúa ở vùng đất thấp ở Nam và Đông Nam Á. Những cánh đồng bị nhiễm bệnh nghiêm trọng có thể làm giảm năng suất tới 45%.\n" +
                            "Hạt bị nhiễm bệnh nặng gây ra bệnh cháy lá, dẫn đến tỷ lệ chết của cây con là 10−58%. Nó cũng ảnh hưởng đến chất lượng và số lượng hạt trên bông và làm giảm trọng lượng hạt.",
                    "Improving soil fertility is the first step in managing brown spot. To do this:\n" +
                            "- Monitor soil nutrients regularly\n" +
                            "- Apply required fertilizers\n" +
                            "- For soils that are low in silicon, apply calcium silicate slag before planting\n" +
                            "\n" +
                            "Fertilizers, however, can be costly and may take many cropping seasons before becoming effective. More economical management options include:\n" +
                            "- Use resistant varieties. \n" +
                            "- Contact your local agriculture office for up-to-date lists of varieties available.\n" +
                            "- Use fungicides (e.g., iprodione, propiconazole, azoxystrobin, trifloxystrobin, and carbendazim) as seed treatments.\n" +
                            "- Treat seeds with hot water (53−54°C) for 10−12 minutes before planting, to control primary infection at the seedling stage. To increase the effectiveness of treatment, pre-soak seeds in cold water for eight hours.",
                    "Cải thiện độ màu mỡ của đất là bước đầu tiên trong việc quản lý đốm nâu. Để làm điều này:\n" +
                            "- Theo dõi chất dinh dưỡng của đất thường xuyên\n" +
                            "- Bón phân cần thiết\n" +
                            "- Đối với đất ít silic, bón xỉ canxi silicat trước khi trồng\n" +
                            "\n" +
                            "Tuy nhiên, phân bón có thể tốn kém và có thể mất nhiều vụ mùa trước khi có hiệu quả. Các tùy chọn quản lý tiết kiệm hơn bao gồm:\n" +
                            "- Sử dụng giống kháng. \n" +
                            "- Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Sử dụng thuốc diệt nấm (ví dụ: iprodione, propiconazole, azoxystrobin, trifloxystrobin và carbendazim) để xử lý hạt giống.\n" +
                            "- Xử lý hạt giống bằng nước nóng (53−54°C) trong 10−12 phút trước khi trồng, để kiểm soát nhiễm trùng ban đầu ở giai đoạn cây con. Để tăng hiệu quả xử lý, ngâm hạt giống trước trong nước lạnh trong 8 giờ.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Fbrown_spot.jpg?alt=media&token=aa31defa-c079-463b-af91-babd2c0c90b5");
            diseases.add(diseases4);
            Diseases diseases5 = new Diseases("Sheath blight", "Khô vằn", "Check for lesions:\n" +
                    "Symptoms are usually observed from tillering to the milk stage in a rice crop and include the following:\n" +
                    "- Oval or ellipsoidal greenish-grey lesions, usually 1-3 cm long, on the leaf sheath, initially just above the soil or water level in the case of conventionally flooded rice.\n" +
                    "- Under favourable conditions, these initial lesions multiply and expand to the upper part of the sheaths and the leaves and then spread to neighbouring tillers belonging to different hills (transplanted rice) or plants (direct-seeded rice).\n" +
                    "- Lesions on the leaves usually have irregular lesions, often with grey-white centres and brown margins as they grow older.\n" +
                    "in subtropical environments, the disease is mainly initiated by sclerotia (up to two million of which can be produced per square meter in a diseased crop).\n" +
                    "\n" +
                    "Sheath blight has symptoms similar to stem rot and stemborer infestation. To confirm the cause of the disease, check for irregular lesions usually found on the leaf sheaths (initially water-soaked to greenish grey and later becomes greyish white with brown margin). Also, check for the presence of sclerotia.",
                    "Kiểm tra vết thương:\n" +
                            "Các triệu chứng thường được quan sát thấy từ giai đoạn đẻ nhánh đến giai đoạn sữa trong một vụ lúa và bao gồm những điều sau:\n" +
                            "- Vết bệnh màu xám xanh hình bầu dục hoặc hình elip, thường dài 1-3 cm, trên bẹ lá, ban đầu ngay trên mặt đất hoặc mực nước trong trường hợp lúa ngập nước thông thường.\n" +
                            "- Trong điều kiện thuận lợi, các vết bệnh ban đầu này nhân lên và lan rộng lên phần trên của bẹ và lá rồi lan sang các nhánh lân cận thuộc các đồi khác nhau (lúa cấy) hoặc cây (lúa sạ thẳng).\n" +
                            "- Các vết bệnh trên lá thường có các vết bệnh không đều nhau, thường có tâm màu trắng xám và viền màu nâu khi già đi.\n" +
                            "trong môi trường cận nhiệt đới, căn bệnh này chủ yếu do hạch nấm gây ra (có thể tạo ra tới hai triệu hạch nấm trên một mét vuông trên một cây trồng bị bệnh).\n" +
                            "\n" +
                            "Bệnh khô vằn có triệu chứng giống bệnh thối thân và sâu đục thân. Để xác định nguyên nhân gây bệnh, kiểm tra các vết bệnh không đều thường thấy trên bẹ lá (lúc đầu úng nước chuyển sang màu xám xanh, sau chuyển sang màu trắng xám viền nâu). Ngoài ra , hãy kiểm tra sự hiện diện của hạch nấm.",
                    "Sheath blight is a fungal disease caused by Rhizoctonia solani. Infected leaves senesce or dry out and die more rapidly; young tillers can also be destroyed.\n" +
                            "As a result, the leaf area of the canopy can be significantly reduced by the disease. This reduction in leaf area and the diseased-induced senescence of leaves and young infected tillers are the primary causes of yield reduction.\n" +
                            "\n" +
                            "Sheath blight is considered to be an important disease next to rice blasts. Rice sheath blight is an increasing concern for rice production, especially in intensified production systems.\n" +
                            "In Japan, the disease has caused a yield loss of as high as 20%, affecting about 120,000−190,000 hectares. A yield loss of 25% was reported if the flag leaves were infected. In the United States, a yield loss of 50% was reported when susceptible cultivars were planted. Sheath blight has also caused a yield loss of 6% in tropical Asia.",
                    "Bệnh khô vằn là một bệnh nấm do Rhizoctonia solani gây ra. Lá bị nhiễm bệnh già đi hoặc khô héo và chết nhanh hơn; các nhánh non cũng có thể bị tiêu diệt.\n" +
                            "Kết quả là, diện tích lá của tán cây có thể bị giảm đáng kể do bệnh. Việc giảm diện tích lá này và sự lão hóa của lá do bệnh gây ra và các chồi non bị nhiễm bệnh là nguyên nhân chính dẫn đến giảm năng suất.\n" +
                            "\n" +
                            "Bệnh khô vằn được coi là một bệnh quan trọng bên cạnh bệnh đạo ôn. Bệnh khô vằn là mối lo ngại ngày càng tăng đối với sản xuất lúa gạo, đặc biệt là trong các hệ thống sản xuất thâm canh.\n" +
                            "Tại Nhật Bản, căn bệnh này đã gây ra thiệt hại năng suất cao tới 20%, ảnh hưởng đến khoảng 120.000−190.000 ha. Mất 25% năng suất đã được báo cáo nếu lá cờ bị nhiễm bệnh. Tại Hoa Kỳ, thiệt hại về năng suất là 50% % đã được báo cáo khi trồng các giống mẫn cảm. Bệnh khô vằn cũng đã gây ra tổn thất năng suất 6% ở vùng nhiệt đới châu Á.",
                    "There is currently no resistant rice variety available for cultivation. The main management options available to minimize sheath blight include:\n" +
                            "- Use a reasonable level of fertilizer adapted to the cropping season.\n" +
                            "- Use the reasoned density of crop establishment (direct seeding or transplanting).\n" +
                            "- Carefully control weeds, especially on the levees.\n" +
                            "- Drain rice fields relatively early in the cropping season to reduce sheath blight epidemics.\n" +
                            "- Use fungicides to treat seeds.\n" +
                            "- Improve canopy architecture by reducing the seeding rate or providing wider plant spacing.",
                    "Hiện không có giống lúa kháng bệnh nào để canh tác. Các phương án quản lý chính hiện có để giảm thiểu bệnh khô vằn bao gồm:\n" +
                            "- Sử dụng lượng phân bón hợp lý phù hợp với thời vụ trồng trọt.\n" +
                            "- Sử dụng mật độ thiết lập cây trồng hợp lý (gieo hạt trực tiếp hoặc cấy).\n" +
                            "- Cẩn thận kiểm soát cỏ dại, đặc biệt là trên đê.\n" +
                            "- Rút cạn ruộng lúa tương đối sớm trong vụ mùa để giảm dịch bệnh khô vằn.\n" +
                            "- Sử dụng thuốc diệt nấm để xử lý hạt giống.\n" +
                            "- Cải thiện cấu trúc tán cây bằng cách giảm tỷ lệ gieo hạt hoặc cung cấp khoảng cách giữa các cây rộng hơn.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Fsheath_blight.jpg?alt=media&token=c17e52b3-f7d6-4295-9c57-ff087fbc3f1a");
            diseases.add(diseases5);
            Diseases diseases6 = new Diseases("Rice grassy stunt", "Lùn xoắn cỏ", "To identify hills of Rice grassy stunt virus-infected plants, check for the following symptoms:\n" +
                    "- Severely stunted plants\n" +
                    "- Excessive tillering\n" +
                    "- Very upright plant growth\n" +
                    " Grassy and rosette appearance of plants\n" +
                    "- Yellowish green leaves that are shorter and narrower than normal\n" +
                    "- Leaves that remain yellow even after the application of sufficient nitrogen fertilizers\n" +
                    "- Numerous small rusty spots or patches on leaves, which merge into blotches\n" +
                    "- Leaves have a mottled appearance\n" +
                    "- Plants that fail to produce panicles\n" +
                    "\n" +
                    "The stunting and excessive tillering symptoms of rice grassy stunt can be confused for symptoms of rice yellow dwarf and rice dwarf disease. To confirm Rice grassy stunt virus, check for plants' grassy or rosette appearance and prominent rusty spots on the leaves.",
                    "Để xác định những ngọn đồi có cây lúa bị nhiễm vi rút lùn xoắn cỏ, hãy kiểm tra các triệu chứng sau:\n" +
                            "- Cây còi cọc nặng\n" +
                            "- Đẻ nhánh quá nhiều\n" +
                            "- Cây phát triển rất thẳng đứng\n" +
                            " Hình dạng cỏ và hoa thị của thực vật\n" +
                            "- Lá màu xanh hơi vàng ngắn và hẹp hơn bình thường\n" +
                            "- Lá vẫn vàng ngay cả sau khi bón đủ phân đạm\n" +
                            "- Nhiều đốm hoặc mảng rỉ sét nhỏ trên lá, hợp lại thành đốm\n" +
                            "- Lá có hình lốm đốm\n" +
                            "- Cây không ra bông\n" +
                            "\n" +
                            "Các triệu chứng còi cọc và đẻ nhánh quá mức của bệnh còi cọc cỏ có thể bị nhầm lẫn với các triệu chứng của bệnh vàng lùn và lùn lúa. Để xác nhận vi rút lùn sọc cỏ hại lúa, hãy kiểm tra hình dạng cỏ hoặc hoa thị của cây và các đốm gỉ nổi bật trên lá.",
                    "Rice grassy stunt virus reduces yields by inhibiting panicle production. Generally, rice grassy stunt virus occurrence is not widespread. The disease can become a serious problem in limited rice-growing areas when there are brown planthopper outbreaks.",
                    "Virus lùn xoắn cỏ làm giảm năng suất do ức chế sản xuất bông. Nói chung, sự xuất hiện của virus lùn sọc cỏ lúa không phổ biến. Bệnh có thể trở thành một vấn đề nghiêm trọng ở những vùng trồng lúa hạn chế khi có sự bùng phát của rầy nâu.",
                    "To control rice grassy stunt virus the brown planthopper vectors need to be managed. This can be done either through the use of insecticides, brown plant hopper-resistant varieties, or synchronized crop establishment. Infected stubble needs to be plowed under after harvest to reduce the virus source.\n" +
                            "Rice grassy stunt disease often develops and causes severe damage after the area is heavily infected with planthoppers. There is currently no cure for this disease. The best way to prevent disease is to manage BPH well, choose the sowing time to \"avoid planthoppers\", when the field is sick, it is necessary to destroy the diseased plants, then prevent BPH and spray foliar fertilizers with high phosphorus and potassium content. to increase plant resistance.",
                    "Để kiểm soát virus lùn xoắn cỏ hại lúa, cần phải quản lý véc tơ rầy nâu. Điều này có thể được thực hiện thông qua việc sử dụng thuốc trừ sâu, giống kháng rầy nâu hoặc thiết lập cây trồng đồng bộ. Cần phải cày xới gốc rạ bị nhiễm bệnh sau khi thu hoạch để giảm thiểu nguồn vi-rút.\n" +
                            "Bệnh lùn sọc lá hại lúa thường phát sinh và gây hại nặng sau khi diện tích bị nhiễm rầy nặng. Hiện chưa có thuốc đặc trị. Cách phòng bệnh tốt nhất là quản lý tốt rầy nâu, chọn thời vụ gieo sạ để \"né rầy\" \", khi ruộng bị bệnh cần tiêu hủy cây bệnh, sau đó phòng trừ rầy nâu và phun phân bón lá có hàm lượng lân, kali cao để tăng sức đề kháng cho cây.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Frice_grassy_stunt.jpg?alt=media&token=59551ed5-fc41-4464-a159-25ea282743b3");
            diseases.add(diseases6);
            Diseases diseases7 = new Diseases("Rice ragged stunt", "Lùn xoắn lá", "To detect rice ragged stunt virus, check plants for:\n" +
                    "- Severe stunting during early crop stages\n" +
                    "- Green leaves with darker than normal colour\n" +
                    "- Leaves with serrated uneven edges\n" +
                    "- Leaves appearing yellow to yellow-brown and twisted into\n" +
                    "- Spiral shapes at the base of leaf blades\n" +
                    "- Swollen, pale yellow or white to dark brown veins developing on leaf blades and sheaths\n" +
                    "- Galls on the underside of leaf blades and the outer surface of leaf sheaths\n" +
                    "- Twisted, malformed flag leaves that are shortened at the booting stage\n" +
                    "delayed flowering\n" +
                    "- Incomplete panicle emergence\n" +
                    "- Nodal branches forming at the upper nodes\n" +
                    "- Partially exerted panicles and unfilled grains\n" +
                    "\n" +
                    "The ragged appearance and twisted leaf symptoms can be confused with the damage caused by rice whorl maggots and nematodes. To confirm rice grassy stunt, check for the presence of the brown planthopper vector, vein swelling, dark green colour of leaves, and severe stunting.",
                    "Để phát hiện vi rút lùn sọc vằn hại lúa, hãy kiểm tra thực vật để tìm:\n" +
                            "- Còi cọc nghiêm trọng trong giai đoạn đầu vụ\n" +
                            "- Lá xanh đậm hơn bình thường\n" +
                            "- Lá có răng cưa không đều cạnh\n" +
                            "- Lá xuất hiện màu vàng đến vàng nâu và xoắn vào\n" +
                            "- Hình xoắn ốc ở gốc phiến lá\n" +
                            "- Các gân sưng lên, màu vàng nhạt hoặc trắng đến nâu sẫm phát triển trên phiến lá và bẹ lá\n" +
                            "- Vết u ở mặt dưới phiến lá và mặt ngoài của bẹ lá\n" +
                            "- Lá cờ bị xoắn, không đúng định dạng bị rút ngắn ở giai đoạn khởi động\n" +
                            "chậm ra hoa\n" +
                            "- Bông hoa chưa hoàn thiện\n" +
                            "- Các nhánh nút hình thành ở các nút phía trên\n" +
                            "- Các hạt bị ép một phần và các hạt không được lấp đầy\n" +
                            "\n" +
                            "Biểu hiện xù xì và các triệu chứng xoắn lá có thể bị nhầm lẫn với thiệt hại do giòi và tuyến trùng quấn lúa. Để xác nhận lúa bị lùn cỏ, hãy kiểm tra sự hiện diện của vật trung gian truyền bệnh rầy nâu, sưng gân lá, màu xanh đậm của lá và tình trạng còi cọc nghiêm trọng .",
                    "Rice ragged stunt virus reduces yield by causing partially exerted panicles, unfilled grains and plant density loss. It is vector-transmitted from one plant to another by brown plant hoppers. Leaves of infected plants have a ragged appearance. \n" +
                            "Rice ragged stunt virus can affect up to 75% of plants in a crop. Depending on the extent of the damage infected plants will either produce partially exerted panicles and unfilled grains or produce few or no grains. Infected crops will suffer significant yield losses of up to 80%.",
                    "Vi rút lùn sọc vằn làm giảm năng suất bằng cách khiến bông lúa bị lép một phần, hạt không đầy và mất mật độ cây. Nó là vật trung gian truyền từ cây này sang cây khác bởi rầy nâu. Lá của cây bị nhiễm bệnh có hình dạng xù xì. \n" +
                            "Virus lùn sọc lá lúa có thể ảnh hưởng đến 75% số cây trong một vụ mùa. Tùy thuộc vào mức độ thiệt hại, cây bị nhiễm bệnh sẽ tạo ra một phần bông và hạt lép hoặc tạo ra ít hoặc không có hạt. Cây trồng bị nhiễm bệnh sẽ bị thiệt hại đáng kể về năng suất lên đến 80%.",
                    "Preventive measures are more efficient against rice-ragged stunt virus than direct-control measures. Once infected by the virus, a rice plant cannot be cured.\n" +
                            "- Plant varieties resistant to brown planthopper.\n" +
                            "- Using resistant varieties for ragged stunt management is probably the most important control measure. Contact your local agriculture office for up-to-date lists of varieties available.\n" +
                            "- Practice synchronized planting.\n" +
                            "- Plow infected stubbles under the field after harvest to reduce the virus source.\n" +
                            "Rice ragged stunt disease often develops and causes severe damage after the area is heavily infected with planthoppers. There is currently no cure for this disease. The best way to prevent disease is to manage BPH well, choose the sowing time to \"avoid planthoppers\", when the field is sick, it is necessary to destroy the diseased plants, then prevent BPH and spray foliar fertilizers with high phosphorus and potassium content. to increase plant resistance.",
                    "Các biện pháp phòng ngừa hiệu quả hơn đối với vi rút lùn sọc vằn hại lúa so với các biện pháp kiểm soát trực tiếp. Một khi bị nhiễm vi rút, cây lúa sẽ không thể chữa khỏi.\n" +
                            "- Giống cây kháng rầy nâu.\n" +
                            "- Sử dụng các giống kháng bệnh để quản lý còi cọc xù xì có lẽ là biện pháp kiểm soát quan trọng nhất. Hãy liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Thực hành trồng đồng bộ.\n" +
                            "- Cày gốc rạ bị nhiễm bệnh dưới ruộng sau khi thu hoạch để giảm nguồn virus.\n" +
                            "Bệnh lùn sọc vằn hại lúa thường phát sinh và gây hại nặng sau khi diện tích bị nhiễm rầy nặng. Hiện chưa có thuốc đặc trị. Cách phòng bệnh tốt nhất là quản lý tốt rầy nâu, chọn thời vụ gieo sạ để \"né rầy\". \", khi ruộng bị bệnh cần tiêu hủy cây bệnh, sau đó phòng trừ rầy nâu và phun phân bón lá có hàm lượng lân, kali cao để tăng sức đề kháng cho cây.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Frice_ragged_stunt.jpg?alt=media&token=b0bdcc38-63c0-4710-b63d-9798cbc62afb");
            diseases.add(diseases7);
            Diseases diseases8 = new Diseases("Tungro", "Vàng lùn", "The yellow or orange-yellow discolouration is noticeable in tungro-infected plants. Discolouration begins from the leaf tip and extends down to the blade or the lower leaf portion. Infected leaves may also show a mottled or striped appearance, rust-coloured spots, and inter-veinal necrosis.\n" +
                    "Tungro-infected plants also show symptoms of stunting, delayed flowering, which may delay maturity, reduced number of tillers, small and not completely exserted panicles, as well as a higher than normal percentage of sterile panicles or partially filled grains, covered with dark brown blotches.\n" +
                    "The degree of stunting and of leaf discolouration varies with rice varieties, strains of the viruses, the age of the plant when infected, and the environment. In varieties that carry some resistance to the disease, infected plants exhibit no discolouration or only a mild discolouration that may disappear as the plants mature.",
                    "Sự đổi màu vàng hoặc vàng cam dễ nhận thấy ở những cây bị nhiễm tungro. Sự đổi màu bắt đầu từ đầu lá và kéo dài xuống phiến lá hoặc phần dưới lá. Lá bị nhiễm bệnh cũng có thể có đốm hoặc sọc, đốm màu gỉ sắt, và hoại tử giữa các tĩnh mạch.\n" +
                            "Cây bị nhiễm bệnh Tungro cũng có các triệu chứng còi cọc, chậm ra hoa, có thể làm chậm quá trình trưởng thành, giảm số nhánh đẻ nhánh, bông nhỏ và không trổ hết, cũng như tỷ lệ bông vô trùng cao hơn bình thường hoặc hạt đầy một phần, bị bao phủ bởi màu tối. đốm nâu.\n" +
                            "Mức độ còi cọc và bạc màu của lá khác nhau tùy theo giống lúa, chủng vi-rút, tuổi của cây khi bị nhiễm bệnh và môi trường. Ở những giống mang một số khả năng kháng bệnh, cây bị nhiễm bệnh không có biểu hiện bạc màu hoặc chỉ bị bạc màu nhẹ. đổi màu có thể biến mất khi cây trưởng thành.",
                    "Rice tungro disease is caused by the combination of two viruses, which are transmitted by leafhoppers. It causes leaf discolouration, stunted growth, reduced tiller numbers and sterile or partly filled grains. Tungro infects cultivated rice, some wild rice relatives and other grassy weeds commonly found in rice paddies.\n" +
                            "\n" +
                            "Tungro is one of the most damaging and destructive diseases of rice in South and Southeast Asia. In severe cases, Tungro susceptible varieties infected at an early growth stage could have as high as 100% yield loss.\n" +
                            "Once tungro is present in the field, it increases rapidly in young rice plants. Leafhopper vectors prefer to feed on young rice plants. They also acquire tungro viruses more efficiently from younger infected plants.",
                    "Bệnh tungro trên lúa gây ra bởi sự kết hợp của hai loại vi-rút, lây truyền qua rầy. Bệnh này làm cho lá bị đổi màu, còi cọc, giảm số nhánh đẻ nhánh và hạt khô hoặc bị lép một phần. Bệnh tungro lây nhiễm trên lúa trồng, một số họ hàng lúa hoang và các loại cỏ dại khác thường được tìm thấy trong ruộng lúa.\n" +
                            "\n" +
                            "Tungro là một trong những bệnh hại lúa gây hại và tàn phá nghiêm trọng nhất ở Nam và Đông Nam Á. Trong trường hợp nghiêm trọng, các giống nhiễm bệnh Tungro ở giai đoạn phát triển ban đầu có thể bị mất năng suất tới 100%.\n" +
                            "Một khi bệnh tungro xuất hiện trên đồng ruộng, nó sẽ gia tăng nhanh chóng ở các cây lúa non. Các vec tơ rầy thích ăn các cây lúa non. Chúng cũng thu được vi rút tungro hiệu quả hơn từ các cây non bị nhiễm bệnh.",
                    "Once a rice plant is infected by tungro, it cannot be cured. Preventive measures are more effective for the control of tungro than direct disease control measures. Using insecticides to control leafhoppers is often not effective, because green leafhoppers continuously move to surrounding fields and spread tungro rapidly in very short feeding times.\n" +
                            "\n" +
                            "The most practical measures at present, include:\n" +
                            "- Grow tungro or leafhopper-resistant varieties.\n" +
                            "- This is the most economical means of managing the disease. There are tungro-resistant varieties available in the Philippines, Malaysia, Indonesia, India, and Bangladesh.\n" +
                            "- Contact your local agriculture office for up-to-date lists of varieties available.\n" +
                            "- Practice synchronous planting with surrounding farms.\n" +
                            "- Delayed or late planting, relative to the average date in a given area, makes the field susceptible for Tungro. Late-planted fields also pose a risk to early planting in the next season.\n" +
                            "- Adjust planting times to when green leafhoppers are not in season or abundant if known\n" +
                            "- Plow infected stubbles immediately after harvest to reduce inoculum sources and destroy the eggs and breeding sites of green leaf hopper.",
                    "Một khi cây lúa bị nhiễm bệnh tungro thì không thể chữa trị được. Các biện pháp phòng trừ bệnh tungro hiệu quả hơn các biện pháp phòng trừ bệnh trực tiếp. Sử dụng thuốc trừ sâu để kiểm soát rầy thường không hiệu quả, vì rầy xanh liên tục di chuyển sang các ruộng xung quanh và phát tán tungro nhanh chóng trong thời gian cho ăn rất ngắn.\n" +
                            "\n" +
                            "Các biện pháp thiết thực nhất hiện nay, bao gồm:\n" +
                            "- Trồng các giống kháng rầy hoặc tungro.\n" +
                            "- Đây là phương pháp tiết kiệm nhất để quản lý dịch bệnh. Hiện có các giống kháng tungro ở Philippines, Malaysia, Indonesia, Ấn Độ và Bangladesh.\n" +
                            "- Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Thực hành trồng trọt đồng bộ với các trang trại xung quanh.\n" +
                            "- Việc gieo trồng muộn hoặc muộn, so với ngày trung bình ở một khu vực nhất định, khiến cánh đồng dễ nhiễm bệnh Tungro. Những cánh đồng trồng muộn cũng có nguy cơ gieo trồng sớm trong mùa tới.\n" +
                            "- Điều chỉnh thời gian gieo trồng khi rầy xanh không vào mùa hoặc nhiều nếu biết\n" +
                            "- Cày gốc rạ nhiễm bệnh ngay sau khi thu hoạch để giảm nguồn lây và tiêu diệt ổ trứng, nơi sinh sản của rầy xanh.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Ftungro.jpg?alt=media&token=8a972af9-c79a-42b4-bcf2-868bb189bfef");
            diseases.add(diseases8);

            Diseases diseases9 = new Diseases("Bacterial leaf streak", "Cháy bìa lá", "Check for lesions:\n" +
                    "- Symptoms initially appear as small, water-soaked, linear lesions between leaf veins. These streaks are initially dark green and later become light brown to yellowish grey.\n" +
                    "- The lesions are translucent when held against the light.\n" +
                    "- Entire leaves may become brown and die when the disease is very severe.\n" +
                    "- Under humid conditions, yellow droplets of bacterial ooze, which contain masses of bacterial cells, may be observed on the surface of leaves.\n" +
                    "\n" +
                    "Bacterial leaf streak may be confused with narrow brown spot. To confirm:\n" +
                    "- Leaf streak lesions are usually thinner than those of narrow brown spot\n" +
                    "- Narrow brown spot lesions are not translucent, nor do they produce bacterial ooze\n" +
                    "- When the advancing part of the streaks is cut and placed in a glass with water, a mass of bacterial cells can usually be seen oozing out of the leaf, which makes the water turbid after five minutes.",
                    "Kiểm tra vết thương:\n" +
                            "- Các triệu chứng ban đầu xuất hiện dưới dạng các vết thương nhỏ, thấm nước, có đường thẳng giữa các gân lá. Những vệt này ban đầu có màu xanh đậm và sau đó chuyển sang màu nâu nhạt đến xám vàng.\n" +
                            "- Vết thương trong mờ khi để dưới ánh sáng.\n" +
                            "- Toàn bộ lá có thể chuyển sang màu nâu và chết khi bệnh nặng.\n" +
                            "- Trong điều kiện ẩm ướt, có thể quan sát thấy các giọt dịch vi khuẩn màu vàng chứa khối tế bào vi khuẩn trên bề mặt lá.\n" +
                            "\n" +
                            "Sọc lá do vi khuẩn có thể bị nhầm lẫn với đốm nâu hẹp. Để xác nhận:\n" +
                            "- Vết bệnh sọc lá thường mỏng hơn vết bệnh đốm nâu hẹp\n" +
                            "- Vết đốm nâu hẹp không mờ, cũng không tiết dịch khuẩn\n" +
                            "- Khi cắt phần trước của các vệt và cho vào cốc nước, thường có thể nhìn thấy một khối tế bào vi khuẩn rỉ ra từ lá, làm nước đục sau năm phút.",
                    "Bacterial leaf streak is caused by Xanthomonas oryzae pv. oryzicola. Infected plants show browning and drying of leaves. Under severe conditions, this could lead to reduced grain weight due to loss of photosynthetic area.\n" +
                            "Based on reported cases, yield loss caused by bacterial leaf streak can range from 8−17% in the wet season and 1−3 % in the dry season.",
                    "Bệnh chía bìa lá do vi khuẩn gây ra bởi Xanthomonas oryzae pv. oryzicola. Cây bị nhiễm bệnh có lá chuyển sang màu nâu và khô. Trong điều kiện khắc nghiệt, điều này có thể dẫn đến giảm trọng lượng hạt do mất diện tích quang hợp.\n" +
                            "Dựa trên các trường hợp được báo cáo, tổn thất năng suất do sọc lá vi khuẩn có thể dao động từ 8−17 % trong mùa mưa và 1−3 % trong mùa khô.",
                    "To prevent and effectively manage bacterial leaf streak: \n" +
                            "- Plant-resistant varieties.\n" +
                            "- Treat seeds with hot water.\n" +
                            "- Keep fields clean—remove weed hosts and plough under rice stubble, straw, rice ratoons, and volunteer seedlings, which the bacteria may infect.\n" +
                            "- Use balanced amounts of plant nutrients, especially nitrogen.\n" +
                            "- Ensure good drainage of fields (in conventionally flooded crops) and nurseries.\n" +
                            "- Drain the field during a severe flood.\n" +
                            "- Dry the field during the fallow period to kill the bacteria in the soil and plant residues.\n" +
                            "- In cases of severe infection, when yield may be affected, a copper-based fungicide applied at the heading can be effective in controlling the disease.",
                    "Phòng ngừa và quản lý hiệu quả bệnh cháy bìa lá: \n" +
                            "- Giống kháng thực vật.\n" +
                            "- Xử lý hạt giống bằng nước nóng.\n" +
                            "- Giữ cho đồng ruộng sạch sẽ—loại bỏ vật chủ cỏ dại và cày dưới gốc rạ, rơm, rạ và cây con tình nguyện, những thứ mà vi khuẩn có thể lây nhiễm.\n" +
                            "- Sử dụng lượng cân bằng các chất dinh dưỡng thực vật, đặc biệt là nitơ.\n" +
                            "- Đảm bảo thoát nước tốt cho các cánh đồng (trong các loại cây trồng ngập nước thông thường) và vườn ươm.\n" +
                            "- Rút cạn ruộng khi lũ lụt nghiêm trọng.\n" +
                            "- Phơi khô ruộng trong thời gian bỏ hoang để tiêu diệt vi khuẩn trong đất và tàn dư thực vật.\n" +
                            "- Trong trường hợp nhiễm bệnh nghiêm trọng, khi đó năng suất có thể bị ảnh hưởng, thuốc diệt nấm gốc đồng được áp dụng cho nhóm có thể có hiệu quả trong việc kiểm soát bệnh.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Fbacterial_leaf_streak.jpg?alt=media&token=101904fa-45ce-4fc9-a8be-3ddfd173635a");
            diseases.add(diseases9);

            Diseases diseases10 = new Diseases("Red stripe", "Sọc đỏ", "Check leaves for lesions and discolouration:\n" +
                    "- Initial lesions are pin-sized and often yellow-green to light orange in colour. Older lesions appear as orange spots with an upward stripe.\n" +
                    "- Lesions become necrotic and coalesce, forming a blight appearance on the leaves.\n" +
                    "- Lesions can also appear on the sheaths but are less common.\n" +
                    "- The disease can be confused with orange leaf blight disease. It is hardly distinguishable from bacterial leaf blight disease at severe and advanced stages of disease development.\n" +
                    "To confirm the red stripe, check the shape, size and colour of the lesions. An advanced lesion is characterized by an orange spot with a stripe, advancing towards the leaf's tip.",
                    "Kiểm tra lá xem có vết thương và biến màu không:\n" +
                            "- Các tổn thương ban đầu có kích thước bằng đầu đinh ghim và thường có màu từ xanh lục vàng đến cam nhạt. Các tổn thương cũ hơn xuất hiện dưới dạng các đốm màu cam có sọc hướng lên.\n" +
                            "- Các vết bệnh trở nên hoại tử và liên kết với nhau, tạo thành vết cháy xém trên lá.\n" +
                            "- Các vết thương cũng có thể xuất hiện trên vỏ nhưng ít phổ biến hơn.\n" +
                            "- Bệnh có thể nhầm lẫn với bệnh cháy lá cam. Khó phân biệt với bệnh cháy lá do vi khuẩn ở giai đoạn phát triển nặng và tiến triển của bệnh.\n" +
                            "Để xác nhận sọc đỏ, hãy kiểm tra hình dạng, kích thước và màu sắc của vết bệnh. Vết bệnh nặng có đặc điểm là một đốm màu cam có sọc, tiến dần về phía đầu lá.",
                    "Red stripe causes the formation of lesions on leaves. The disease usually occurs when the plants reach the reproductive stage, starting from panicle initiation. High temperature, high relative humidity, high leaf wetness, and high nitrogen supply favour disease development.\n" +
                            "Red stripe is a potential threat to rice production in Southeast Asia. The red stripe of rice is common in Indonesia, Malaysia, the Philippines, Thailand and Vietnam.",
                    "Sọc đỏ gây ra sự hình thành các vết bệnh trên lá. Bệnh thường xảy ra khi cây đến giai đoạn sinh sản, bắt đầu từ lúc bắt đầu ra bông. Nhiệt độ cao, độ ẩm tương đối cao, độ ẩm của lá cao và nguồn cung cấp đạm cao tạo điều kiện cho bệnh phát triển.\n" +
                            "Sọc đỏ là mối đe dọa tiềm ẩn đối với sản xuất lúa gạo ở Đông Nam Á. Bệnh sọc đỏ trên lúa phổ biến ở Indonesia, Malaysia, Philippines, Thái Lan và Việt Nam.",
                    "To manage Red stripe:\n" +
                            "- Use resistant varieties. \n" +
                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Apply nitrogen based on actual crop requirements.\n" +
                            "- Ensure optimum seeding rate and wider plant spacing also appear to reduce the disease.\n" +
                            "- Ensure intermittent drainage during panicle initiation.\n" +
                            "- Use benzimidazole fungicides (benomyl, carbendazim, and thiophanate methyl) to treat seeds.",
                    "Để quản lý Sọc đỏ:\n" +
                            "- Sử dụng giống kháng. \n" +
                            "- Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Bón đạm dựa trên yêu cầu thực tế của cây trồng.\n" +
                            "- Đảm bảo tỷ lệ gieo hạt tối ưu và khoảng cách giữa các cây rộng hơn cũng giúp giảm bệnh tật.\n" +
                            "- Đảm bảo thoát nước không liên tục trong quá trình bắt đầu bông.\n" +
                            "- Sử dụng thuốc diệt nấm benzimidazole (benomyl, carbendazim và thiophanate methyl) để xử lý hạt giống.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Fred_stripe.jpg?alt=media&token=49529f6b-a156-4591-92bb-3324413e0865");
            diseases.add(diseases10);

            Diseases diseases11 = new Diseases("Stem rot", "Thối thân", "Check the plant for the following symptoms:\n" +
                    "- Visible numerous tiny white and black sclerotia and mycelium inside the infected culms\n" +
                    "- Infected culm lodges and caused unfilled panicles and chalky grain\n" +
                    "Initial symptoms are small, irregular black lesions on the outer leaf sheath near the water level. Lesions expand as the disease advances. Severe infection causes tiller death.",
                    "Kiểm tra cây xem có các triệu chứng sau không:\n" +
                            "- Có thể nhìn thấy nhiều hạch nấm và sợi nấm nhỏ màu trắng và đen bên trong thân tre bị nhiễm bệnh\n" +
                            "- Muồng bị nhiễm bệnh đọng lại và gây ra bông không đầy và hạt phấn\n" +
                            "Các triệu chứng ban đầu là các vết bệnh nhỏ, màu đen không đều trên bẹ lá bên ngoài gần mực nước. Các vết bệnh lan rộng khi bệnh tiến triển. Nhiễm trùng nặng làm chết nhánh.",
                    "Stem rot leads to the formation of lesions and the production of chalky grains and unfilled panicles. The infection bodies or sclerotia are found in the upper soil layer. They survive in air-dry soil, buried moist rice soil, and tap water. They can also survive on straw, which is buried in the soil. The sclerotia float on irrigation water, infecting newly planted rice during land preparation. Infection is high in plants with wounds due to lodging or insect attack. The panicle moisture content and nitrogen fertilizer also influence disease development.\n" +
                            "\n" +
                            "The infection is seen on the rice crop during early heading and grain filling. The leaf sheaths decay and cause lodging and lower grain filling. It can cause heavy losses in many countries. For example, in Japan, 51,000−122,000 hectares are infected and estimated annual losses of 16,000−35,000 due to this disease. In Vietnam, the Philippines, and India, 30% to 80% losses were recorded.",
                    "Bệnh thối thân dẫn đến hình thành các vết bệnh và tạo ra các hạt phấn và bông không đầy. Các thể nhiễm bệnh hoặc hạch nấm được tìm thấy ở lớp đất phía trên. Chúng tồn tại trong đất khô thoáng, đất lúa ẩm bị vùi lấp và nước máy. Chúng cũng có thể tồn tại trên rơm rạ, được chôn trong đất. Hạch nấm nổi trên nước tưới, lây nhiễm cho lúa mới trồng trong quá trình làm đất. Nhiễm trùng cao ở những cây có vết thương do bị đổ hoặc côn trùng tấn công. Độ ẩm của bông và phân đạm cũng ảnh hưởng đến sự phát triển của bệnh.\n" +
                            "\n" +
                            "Bệnh nhiễm trùng được quan sát thấy trên cây lúa trong giai đoạn trỗ và làm đòng hạt. Các bẹ lá bị thối rữa và gây ra hiện tượng lép hạt và hạt lép. Bệnh có thể gây thiệt hại nặng nề ở nhiều quốc gia. Ví dụ, ở Nhật Bản, 51.000−122.000 ha bị nhiễm bệnh và ước tính thiệt hại hàng năm là 16.000−35.000 do căn bệnh này. Tại Việt Nam, Philippines và Ấn Độ, thiệt hại từ 30% đến 80% đã được ghi nhận.",
                    "To manage Stem rot:\n" +
                            "- Use resistant cultivars.\n" +
                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Burn straw and stubble or any crop residue after harvest or let the straw decompose.\n" +
                            "- Drain the field to reduce sclerotia.\n" +
                            "- Balance fertiliser use or perform split application with high potash and lime to increase soil pH.\n" +
                            "- Chemicals such as fentin hydroxide sprayed at the mid-tillering stage, thiophanate-methyl sprayed during disease initiation can reduce stem rot incidence in the rice field.\n" +
                            "- Other fungicides such as Ferimzone and validamycin A also show effectivity against the fungus.",
                    "Để quản lý bệnh thối thân:\n" +
                            "- Sử dụng giống kháng bệnh.\n" +
                            "- Liên hệ với văn phòng nông nghiệp địa phương của bạn để biết danh sách cập nhật các giống hiện có.\n" +
                            "- Đốt rơm rạ hoặc bất kỳ tàn dư cây trồng nào sau khi thu hoạch hoặc để rơm phân hủy.\n" +
                            "- Xả ruộng để giảm hạch nấm.\n" +
                            "- Sử dụng phân bón cân đối hoặc thực hiện bón phân chia với hàm lượng kali và vôi cao để tăng độ pH của đất.\n" +
                            "- Các hóa chất như fentin hydroxit được phun vào giai đoạn giữa đẻ nhánh, thiophanate-methyl được phun trong giai đoạn bắt đầu bệnh có thể làm giảm tỷ lệ thối thân trên ruộng lúa.\n" +
                            "- Các loại thuốc diệt nấm khác như Ferimzone và validamycin A cũng cho thấy hiệu quả chống lại nấm.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/diseases%2Fstem_rot.webp?alt=media&token=12f60502-eaf5-4200-9a14-2ca4a6d85d11");
            diseases.add(diseases11);

            for (Diseases d : diseases) {
                diseaseDao.insert(d);
            }

            //****Crops-Diseases****
            CropDiseaseDao cropDiseaseDao = db.cropDiseaseDao();
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Blast")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Leaf Scald")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Sheath rot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Brown spot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Sheath blight")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Rice grassy stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Rice ragged stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Tungro")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Bacterial leaf streak")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Red stripe")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 18"), diseaseDao.getIdByName("Stem rot")));

            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Blast")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Leaf Scald")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Sheath rot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Brown spot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Sheath blight")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Rice grassy stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Rice ragged stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Tungro")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Bacterial leaf streak")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Red stripe")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT 08"), diseaseDao.getIdByName("Stem rot")));

            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Blast")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Leaf Scald")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Sheath rot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Brown spot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Sheath blight")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Rice grassy stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Rice ragged stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Tungro")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Bacterial leaf streak")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Red stripe")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM 5451"), diseaseDao.getIdByName("Stem rot")));

            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Blast")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Leaf Scald")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Sheath rot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Brown spot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Sheath blight")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Rice grassy stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Rice ragged stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Tungro")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Bacterial leaf streak")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Red stripe")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("IR 50404"), diseaseDao.getIdByName("Stem rot")));


            //****Pesticides****
            PesticideDao pesticideDao = db.pesticideDao();
            ArrayList<Pesticides> pesticides = new ArrayList<>();
            Pesticides pesticides1 = new Pesticides("Padan 95SP", "Sumitomo Chemical", "Cartap (min 97%) : 950 g/kg", "Insecticide", "Thuốc trừ sâu", "Dosage: 0.5 – 0.7 kg/ha\n\n" +
                    "PreHarvest Interval- PHI: 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "How to use: The amount of water sprayed from 400 to 600 liters/ha." +
                    "It is not recommended to use alum water to mix with Padan 95SP insecticide.",
                    "Liều lượng: 0,5 – 0,7 kg/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch- PHI: 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách sử dụng: Lượng nước phun từ 400 – 600 lít/ha." +
                            "Không nên dùng nước phèn chua để pha với thuốc diệt côn trùng Padan 95SP.", 30, 400,
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fpadan.jpg?alt=media&token=d8c14044-4759-4af1-b397-0d506fc8ab8f");
            pesticides.add(pesticides1);

            Pesticides pesticides2 = new Pesticides("Regent 800WG", "Bayer", "Fipronil (min 95 %): 800g/kg", "Insecticide", "Thuốc trừ sâu",
                    "Dosage: 32 g/ha\n\n" +
                            "Quarantine period (PreHarvest Interval- PHI): 15 days (Duration in days from last handling to harvest)\n\n" +
                            "Usage: The amount of water sprayed is 210 - 600 liters/ha. Spray when pests appear", "Liều lượng: 32 g/ha\n\n" +
                    "Thời gian kiểm dịch (Khoảng thời gian trước khi thu hoạch- PHI): 15 ngày (Thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                    "Cách dùng: Lượng nước phun 210 - 600 lít/ha. Phun khi sâu bệnh xuất hiện", 1.6, 600, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fregent.jpg?alt=media&token=41e96cef-dd10-4dc3-b227-dbe4dc5eeefd");
            pesticides.add(pesticides2);

            Pesticides pesticides3 = new Pesticides("ANTRACOL 70WP", "Bayer", "Propineb (min 80%) : 700 g/kg", "Fungicide", "Thuốc trừ bệnh",
                    "Dosage: 1.5 kg/ha\n\n" +
                            "PreHarvest Interval- PHI: 7 days (Time interval in days from last handling to harvest)\n\n" +
                            "Usage: The amount of water sprayed is 320 - 800 liters/ha. Spray when the disease appears", "Liều lượng: 1,5 kg/ha\n\n" +
                    "Khoảng thời gian trước khi thu hoạch- PHI: 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                    "Cách dùng: Lượng nước phun 320 - 800 lít/ha. Phun khi bệnh xuất hiện", 64, 400, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2FAntracol.jpg?alt=media&token=ca2cdb2a-7a08-4e8d-97b4-09b0c5ebea19");
            pesticides.add(pesticides3);

            Pesticides pesticides4 = new Pesticides("Xantocin 40WP", "VFC", "Bronopol (min 99%) : 40% w/w", "Fungicide", "Thuốc trừ bệnh", "Dosage: 0.2 – 0.25 kg/ha\n\n" +
                    "PreHarvest Interval- PHI: 1 day (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed 400 - 500 liters/ha. Spray when the disease rate is about 5-10%",
                    "Liều lượng: 0,2 – 0,25 kg/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch- PHI: 1 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun 400 - 500 lít/ha. Phun khi tỷ lệ bệnh khoảng 5 - 10%",
                    10, 400, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fxantocin.jpg?alt=media&token=4ce0b990-a0de-44f5-a743-5928d4ed52fb");
            pesticides.add(pesticides4);

            Pesticides pesticides5 = new Pesticides("Hilton USA 320 EC", "HopTri Co", "Pretilachlor 300g/l + Pyribenzoxim 20g/l + Fenclorim 100g/l", "Herbicide", "Thuốc diệt cỏ",
                    "Dosage: 1.0 – 1.25 liters/ha\n\n" +
                            "PreHarvest Interval- PHI: Unknown (Duration in days from last handling to harvest)\n\n" +
                            "Usage: The amount of water sprayed 400 liters/ha. Spraying after sowing 6-10 days",
                    "Liều lượng: 1,0 – 1,25 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch- PHI: Không xác định (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun 400 lít/ha. Phun sau sạ 6-10 ngày",
                    40, 400, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fhilton.jpg?alt=media&token=09c8a329-8889-494c-912f-089ca5bcc77e");
            pesticides.add(pesticides5);

            Pesticides pesticides6 = new Pesticides("Elano 20EC", "HopTri Co", "Cyhalofop-butyl (min 97 %) : 200 g/l", "Herbicide", "Thuốc diệt cỏ", "Dosage: 0.4 liters/ha\n\n" +
                    "PreHarvest Interval (PHI): Unknown date (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 320-400 liters/ha. Spraying after sowing 3-15 days",
                    "Liều lượng: 0,4 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): Ngày không xác định (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun 320-400 lít/ha. Phun sau sạ 3-15 ngày",
                    20, 320, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Felano.jpg?alt=media&token=26c467b2-7a9b-4cba-a883-50bf41d78bcf");
            pesticides.add(pesticides6);

            Pesticides pesticides7 = new Pesticides("Tilt Super 300EC", "Syngenta", "Difenoconazole 150g/l + Propiconazole 150g/l: 300g/l", "Fungicide", "Thuốc trừ bệnh", "Dosage: 0.25 – 0.3 liters/ha\n\n" +
                    "Quarantine period (PreHarvest Interval- PHI): 14 days (Duration in days from last handling to harvest)\n\n" +
                    "Usage: Spray with 500-600 liters of water per hectare. Spray when the disease rate is about 8%",
                    "Liều lượng: 0,25 – 0,3 lít/ha\n\n" +
                            "Thời gian kiểm dịch (Khoảng thời gian trước khi thu hoạch- PHI): 14 ngày (Thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Phun với lượng 500-600 lít nước/ha. Phun khi tỷ lệ bệnh khoảng 8%",
                    10, 500, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Ftilt_super.png?alt=media&token=e72795b8-d044-4c9b-bda3-55168961e504");
            pesticides.add(pesticides7);

            Pesticides pesticides8 = new Pesticides("Bassa 50EC", "PSC.1", "Fenobucarb (BPMC) (min 96 %) : 50% w/w", "Insecticide", "Thuốc trừ sâu", "Dosage: 1.0 – 1.5 litres/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Spray, mix with 600 litres of water /ha",
                    "Liều lượng: 1,0 – 1,5 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Phun, pha với 600 lít nước/ha",
                    51, 600, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fbassa.jpg?alt=media&token=9362bc4c-8f79-4c7b-8970-8afa7a76c5c6");
            pesticides.add(pesticides8);

            Pesticides pesticides9 = new Pesticides("Dupont™ Pexena™ 106SC", "Syngenta", "Triflumezopyrim (min 94%) : 106 g/l", "Insecticide", "Thuốc trừ sâu", "Dosage: 300 ml/ha\n\n" +
                    "Quarantine period (PreHarvest Interval- PHI): 21 days (Duration in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 400-500 L/ha. Spray once when 1-2 year old planthoppers appear on the rice field.",
                    "Liều lượng: 300 ml/ha\n\n" +
                            "Thời gian kiểm dịch (Khoảng thời gian trước khi thu hoạch- PHI): 21 ngày (Thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun 400-500 L/ha. Phun 1 lần khi rầy tuổi 1-2 xuất hiện trên ruộng.",
                    10, 450, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fpexena.jpg?alt=media&token=19be8599-52d5-413e-90ad-b9e5226a0141");
            pesticides.add(pesticides9);

            Pesticides pesticides10 = new Pesticides("Sulfaron 250EC", "Golden Rice Co., Ltd", "Carbosulfan 200 g/l + Chlorfluazuron 50g/l : 250 g/l", "Insecticide", "Thuốc trừ sâu", "Dosage: 0.3-0.4 litres/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 400 -500 litres/ha.",
                    "Liều lượng: 0,3-0,4 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách sử dụng: Lượng nước phun 400 -500 lít/ha.",
                    15, 400, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fsulfaron.jpg?alt=media&token=3d3444b8-b794-45e5-ac57-6f256ad402d8");
            pesticides.add(pesticides10);

            Pesticides pesticides11 = new Pesticides("Virtako 40WG", "Syngenta", "Chlorantraniliprole 20% + Thiamethoxam 20% : 40% w/w", "Insecticide", "Thuốc trừ sâu", "Dosage: 37.5 – 75 g/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed 400 - 500 litres/ha. Spray after butterflies are in full bloom, spray a second time after 15 days if necessary.",
                    "Liều lượng: 37,5 – 75 g/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun 400 - 500 lít/ha. Phun sau khi bướm nở rộ, sau 15 ngày phun lần 2 nếu cần.",
                    2.9, 500, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2FVirtako.jpg?alt=media&token=e4c2100c-414e-4f50-9dba-a9a9f63f8833");
            pesticides.add(pesticides11);

            Pesticides pesticides12 = new Pesticides("Fanmax 350SC", "Phu Nong Co., Ltd", "Chlorfenapyr 250 g/l + Spirodiclofen 100 g/l : 350 g/l", "Insecticide", "Thuốc trừ sâu", "Dosage: 0.25 litres/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 400-500 litres/ha. Spray when the density is about 10-20 individual/m2",
                    "Liều lượng: 0,25 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun 400-500 lít/ha. Phun khi mật độ khoảng 10-20 con/m2",
                    9.5, 450, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Ffanmax.jpg?alt=media&token=29f7f23f-35e5-4f88-aa85-afeddb691429");
            pesticides.add(pesticides12);

            Pesticides pesticides13 = new Pesticides("Reasgant 5EC", "Shijiazhuang Xingbai Bioengineering Co., Ltd", "Abamectin: 50g/l", "Insecticide", "Thuốc trừ sâu", "Dosage: 100 – 200 ml/ha\n\n" +
                    "PreHarvest Interval- PHI: 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed from 500 to 600 litres/ha. Spray when new pests appear",
                    "Liều lượng: 100 – 200 ml/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch- PHI: 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun từ 500 - 600 lít/ha. Phun khi sâu mới xuất hiện",
                    6.5, 550, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2FREASGANT.jpg?alt=media&token=62681bab-041f-4bc6-92f0-c2a4356b2a3d");
            pesticides.add(pesticides13);

            Pesticides pesticides14 = new Pesticides("Chess 50WG", "Syngenta", "500g/kg Pymetrozine", "Insecticide", "Thuốc trừ sâu", "Dosage: 0.5 – 1.0 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed 400 liters/ha. Spray when new worms appear",
                    "Liều lượng: 0,5 – 1,0 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun 400 lít/ha. Phun khi sâu mới xuất hiện",
                    13, 400, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fchess_50wg.jpg?alt=media&token=66e31fa4-44e7-4b8e-a56e-d1a55519422e");
            pesticides.add(pesticides14);

            Pesticides pesticides15 = new Pesticides("Tasieu 5WG", "Viet Thang Co., Ltd", "Emamectin benzoate (Avermectin B1a 90 % + Avermectin B1b 10%) : 5% w/w", "Insecticide", "Thuốc trừ sâu", "Dosage: 150 – 250 g/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed from 500 to 600 litres/ha. Spraying when the caterpillars are young",
                    "Liều lượng: 150 – 250 g/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun từ 500 - 600 lít/ha. Phun khi sâu tơ còn nhỏ",
                    6.5, 550, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Ftasieu.jpg?alt=media&token=f279d28a-ddf5-4396-9dc0-f0ca848c35dd");
            pesticides.add(pesticides15);

            Pesticides pesticides16 = new Pesticides("Sporekill 120SL", "VFC", "Didecyldimethylammonium chloride (min 76.6%) : 120 g/l", "Fungicide", "Thuốc trừ bệnh", "Dosage: 0.5 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Amount of water sprayed: 320-400 l/ha. Spray twice, once before flowering and the second time after flowering. Spray in the early morning or late afternoon.",
                    "Liều lượng: 0,5 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): 7 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun: 320-400 l/ha. Phun 2 lần, lần 1 trước khi ra hoa và lần 2 sau khi ra hoa. Phun vào sáng sớm hoặc chiều mát.",
                    25, 350, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fsporekill.jpg?alt=media&token=c7240ae3-e430-4ebc-80e9-7ce9d8549fdc");
            pesticides.add(pesticides16);

            Pesticides pesticides17 = new Pesticides("Carban 50SC", "Loc Troi Group Joint Stock Company", "Carbendazim (min 98%): 500g/l", "Fungicide", "Thuốc trừ bệnh", "Dosage: 1.0 – 2.5 litres/ha\n\n" +
                    "Quarantine period (PreHarvest Interval- PHI): 14 days (Duration in days from last handling to harvest)\n\n" +
                    "Usage: Spray with 320-400 litres of water /ha. Spray when the disease appears",
                    "Liều lượng: 1,0 – 2,5 lít/ha\n\n" +
                            "Thời gian kiểm dịch (Khoảng thời gian trước khi thu hoạch- PHI): 14 ngày (Thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Phun với lượng 320-400 lít nước/ha. Phun khi bệnh xuất hiện",
                    80, 400, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fcarban.png?alt=media&token=8a1a3267-7b43-47d1-93ac-672bda616ff0");
            pesticides.add(pesticides17);

            Pesticides pesticides18 = new Pesticides("Amistar Top 325SC", "Syngenta", "200g/L Azoxystrobin + 125g/L Difenoconazole", "Fungicide", "Thuốc trừ bệnh", "Dosage: 0.25 - 0.3 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): 10 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 400 - 500 litres/ha. Spray when the disease rate is about 5-10%",
                    "Liều lượng: 0,25 - 0,3 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): 10 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước phun 400 - 500 lít/ha. Phun khi tỷ lệ bệnh khoảng 5 - 10%",
                    12, 450, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Famistar.jpg?alt=media&token=c1df97ab-d5ef-47df-911d-6c938e2483ed");
            pesticides.add(pesticides18);

            Pesticides pesticides19 = new Pesticides("Sofit 300EC", "Syngenta", "300g/L Pretilachlor + 100g/L Fenclorim", "Herbicide", "Thuốc diệt cỏ", "Dosage: 1.2 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): Unknown date (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 300-400 litres/ha.",
                    "Liều lượng: 1,2 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): Ngày không xác định (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách sử dụng: Lượng nước phun 300-400 lít/ha.",
                    50, 400, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2FSOFIT.jpg?alt=media&token=3add14fb-5690-4f42-906b-5df17d3b03c5");
            pesticides.add(pesticides19);

            Pesticides pesticides20 = new Pesticides("Dual Gold 96EC", "Syngenta", "960g/L S-Metolachlor", "Herbicide", "Thuốc diệt cỏ", "Dosage: 0,75-1 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): Unknown date (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Spray, mix with 320-400 litres of water/ha.",
                    "Liều lượng: 0,75-1 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch (PHI): Ngày không xác định (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Phun, pha với 320-400 lít nước/ha.",
                    50, 320, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fdual_gold.jpg?alt=media&token=fb3ee557-9e10-43eb-804c-fc937faf4c81");
            pesticides.add(pesticides20);

            Pesticides pesticides21 = new Pesticides("Anvil 5SC", "Syngenta", "Hexaconazole 50 g/l : 50 g/l", "Fungicide", "Thuốc trừ bệnh", "Dosage: 1 litre/ha\n\n" +
                    "PreHarvest Interval- PHI: 14 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Amount of water 320-600 litres/ha. Spray when the disease rate is about 5%",
                    "Liều lượng: 1 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch- PHI: 14 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước 320-600 lít/ha. Phun khi tỷ lệ bệnh khoảng 5%",
                    40, 500, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2FANVIL.jpg?alt=media&token=1bb5b115-a995-4824-b7f8-b00864309940");
            pesticides.add(pesticides21);

            Pesticides pesticides22 = new Pesticides("Nevo 330EC", "Syngenta", "80g/L Cyproconazole + 250g/L Propiconazole", "Fungicide", "Thuốc trừ bệnh", "Dosage: 0.3 litre/ha\n\n" +
                    "PreHarvest Interval- PHI: 15 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Amount of water 400-500 litres/ha. Spray when the weather is favorable for disease development",
                    "Liều lượng: 0,3 lít/ha\n\n" +
                            "Khoảng thời gian trước khi thu hoạch- PHI: 15 ngày (Khoảng thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                            "Cách dùng: Lượng nước 400-500 lít/ha. Phun khi thời tiết thuận lợi cho bệnh phát triển",
                    14, 500, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fnevo.jpg?alt=media&token=15102b1f-1923-4b37-ae24-65e2aaefc9c1");
            pesticides.add(pesticides22);


            for (Pesticides p : pesticides) {
                pesticideDao.insert(p);
            }
            //****Pests-Pesticides****
            PestPesticideDao pestPesticideDao = db.pestPesticideDao();
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Padan 95SP"), pestDao.getIdByName("Rice leaffolder")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Padan 95SP"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Padan 95SP"), pestDao.getIdByName("Stem borer")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Padan 95SP"), pestDao.getIdByName("Green leafhopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Padan 95SP"), pestDao.getIdByName("Rice gall midge")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Rice leaffolder")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Stem borer")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Green leafhopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Rice thrips")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Black bug")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Rice bug")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Bassa 50EC"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Bassa 50EC"), pestDao.getIdByName("Green leafhopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Bassa 50EC"), pestDao.getIdByName("Rice thrips")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Dupont™ Pexena™ 106SC"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Dupont™ Pexena™ 106SC"), pestDao.getIdByName("Green leafhopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Sulfaron 250EC"), pestDao.getIdByName("Stem borer")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Sulfaron 250EC"), pestDao.getIdByName("Rice leaffolder")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Sulfaron 250EC"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Virtako 40WG"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Virtako 40WG"), pestDao.getIdByName("Stem borer")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Virtako 40WG"), pestDao.getIdByName("Rice leaffolder")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Fanmax 350SC"), pestDao.getIdByName("Stem borer")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Fanmax 350SC"), pestDao.getIdByName("Rice leaffolder")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Reasgant 5EC"), pestDao.getIdByName("Rice leaffolder")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Reasgant 5EC"), pestDao.getIdByName("Stem borer")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Reasgant 5EC"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Reasgant 5EC"), pestDao.getIdByName("Rice thrips")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Reasgant 5EC"), pestDao.getIdByName("Black bug")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Reasgant 5EC"), pestDao.getIdByName("Rice bug")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Chess 50WG"), pestDao.getIdByName("Rice thrips")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Chess 50WG"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Chess 50WG"), pestDao.getIdByName("Green leafhopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Tasieu 5WG"), pestDao.getIdByName("Stem borer")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Tasieu 5WG"), pestDao.getIdByName("Rice leaffolder")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Tasieu 5WG"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Tasieu 5WG"), pestDao.getIdByName("Rice thrips")));

            //****Diseases-Pesticides****
            DiseasePesticideDao diseasePesticideDao = db.diseasePesticideDao();
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("ANTRACOL 70WP"), diseaseDao.getIdByName("Blast")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("ANTRACOL 70WP"), diseaseDao.getIdByName("Sheath blight")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Xantocin 40WP"), diseaseDao.getIdByName("Bacterial leaf streak")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Xantocin 40WP"), diseaseDao.getIdByName("Tungro")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Tilt Super 300EC"), diseaseDao.getIdByName("Sheath blight")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Tilt Super 300EC"), diseaseDao.getIdByName("Sheath rot")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Tilt Super 300EC"), diseaseDao.getIdByName("Leaf Scald")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Tilt Super 300EC"), diseaseDao.getIdByName("Brown spot")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Carban 50SC"), diseaseDao.getIdByName("Red stripe")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Amistar Top 325SC"), diseaseDao.getIdByName("Red stripe")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Amistar Top 325SC"), diseaseDao.getIdByName("Sheath blight")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Amistar Top 325SC"), diseaseDao.getIdByName("Blast")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Amistar Top 325SC"), diseaseDao.getIdByName("Sheath rot")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Anvil 5SC"), diseaseDao.getIdByName("Sheath rot")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Anvil 5SC"), diseaseDao.getIdByName("Sheath blight")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Nevo 330EC"), diseaseDao.getIdByName("Sheath blight")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Nevo 330EC"), diseaseDao.getIdByName("Red stripe")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Nevo 330EC"), diseaseDao.getIdByName("Stem rot")));

            //****Stages****
            StageDao stageDao = db.stageDao();
            ArrayList<Stages> stages = new ArrayList<>();
            Stages stages1 = new Stages("Land preparation", "Chuẩn bị đất", 1, "Land preparation is an essential stage in rice planting that involves preparing the field before sowing or transplanting the rice seedlings. During this stage, the soil is carefully cultivated to create a favourable environment for the rice plants to grow. \n" +
                    "The land is levelled, weeds and crop residues are removed, and the soil is loosened to facilitate root penetration. Proper land preparation helps improve water drainage, nutrient availability, and weed control, ensuring optimal conditions for the subsequent stages of rice growth.",
                    "Làm đất là một công đoạn thiết yếu trong quá trình trồng lúa, bao gồm việc chuẩn bị đồng ruộng trước khi gieo hoặc cấy mạ. Trong giai đoạn này, đất được xới xáo cẩn thận để tạo môi trường thuận lợi cho cây lúa phát triển. \n" +
                            "Đất được san phẳng, loại bỏ cỏ dại và tàn dư cây trồng, đồng thời xới đất để tạo điều kiện cho rễ cây xâm nhập. Làm đất đúng cách giúp cải thiện khả năng thoát nước, cung cấp dinh dưỡng và kiểm soát cỏ dại, đảm bảo điều kiện tối ưu cho các giai đoạn sinh trưởng tiếp theo của cây lúa.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fland.jpg?alt=media&token=a24a11dd-900b-4cbc-b796-84f660575465");
            stages.add(stages1);
            Stages stages2 = new Stages("Planting", "Gieo xạ", 2, "Planting is a crucial stage in rice cultivation, where the prepared seedlings are transplanted into the rice field. It involves carefully placing the young rice plants in evenly spaced rows or broadcasting the seeds directly into the soil. \n" +
                    "Proper planting ensures good establishment of the crop, allowing the roots to anchor in the soil and the shoots to emerge for further growth. This stage sets the foundation for the rice plants to develop and progress through subsequent growth stages.",
                    "Gieo xạ là một giai đoạn quan trọng trong canh tác lúa, trong đó cây con đã chuẩn bị được cấy vào ruộng lúa. Nó liên quan đến việc cẩn thận đặt các cây lúa non thành hàng cách đều nhau hoặc gieo hạt trực tiếp vào đất. \n" +
                            "Trồng đúng cách đảm bảo cây lúa hình thành tốt, cho phép rễ bám chặt vào đất và các chồi nhô lên để phát triển hơn nữa. Giai đoạn này tạo nền tảng cho cây lúa phát triển và tiến bộ qua các giai đoạn sinh trưởng tiếp theo.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fplanting.jpg?alt=media&token=b987a412-a1a1-443a-8d53-1a926af22308");
            stages.add(stages2);
            Stages stages3 = new Stages("Seeding", "Cây con", 3, "The seeding stage of the rice crop is when the seeds are planted in the field. They undergo germination, where the seed coat breaks open, and a root and shoot emerge. Seedlings rely on stored nutrients until they can photosynthesize. This stage is crucial for establishing a healthy crop stand and requires proper seedbed preparation, spacing, and weed control. Water supply and weed management are important factors for successful seedling growth.",
                    "Giai đoạn cây con của cây lúa là khi hạt giống được trồng trên ruộng. Chúng trải qua giai đoạn nảy mầm, khi lớp vỏ hạt mở ra, rễ và chồi xuất hiện. Cây con dựa vào chất dinh dưỡng dự trữ cho đến khi chúng có thể quang hợp. Giai đoạn này rất quan trọng để thiết lập một cây trồng khỏe mạnh và yêu cầu chuẩn bị luống gieo hạt, khoảng cách và kiểm soát cỏ dại thích hợp. Cung cấp nước và quản lý cỏ dại là những yếu tố quan trọng để cây con phát triển thành công.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fseeding.jpg?alt=media&token=2a2f04dc-9b46-44a0-80f0-42239090c724");
            stages.add(stages3);
            Stages stages4 = new Stages("Tillering", "Đẻ nhánh", 4, "During the tillering stage of the rice crop, the seedlings grow and develop additional shoots called tillers. These tillers emerge from the base of the main plant and contribute to the overall plant density. Tillering is an important stage as it determines the potential number of panicles that the rice plant can produce.\n" +
                    "Adequate spacing, nutrient availability, and water management during this stage are crucial for promoting tiller development and ensuring healthy plant growth. It is also a critical period for weed control and the application of fertilizers to support optimal tiller production and crop yield.",
                    "Trong giai đoạn đẻ nhánh của cây lúa, cây con sinh trưởng và phát triển thêm các chồi gọi là chồi nhánh. Những chồi nhánh này xuất hiện từ gốc của cây chính và đóng góp vào mật độ tổng thể của cây. Đẻ nhánh là một giai đoạn quan trọng vì nó quyết định số lượng chồi có thể bông mà cây lúa có thể tạo ra.\n" +
                            "Khoảng cách thích hợp, lượng dinh dưỡng sẵn có và quản lý nước trong giai đoạn này là rất quan trọng để thúc đẩy sự phát triển của nhánh và đảm bảo cây phát triển khỏe mạnh. Đây cũng là giai đoạn quan trọng để kiểm soát cỏ dại và sử dụng phân bón để hỗ trợ quá trình tạo nhánh và năng suất cây trồng tối ưu.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Ftillering.jpg?alt=media&token=0fed0041-6aa5-4a06-a083-6ebf57de87e7");
            stages.add(stages4);
            Stages stages5 = new Stages("Panicle initiation", "Làm đòng", 5, "During the panicle initiation stage of the rice crop, the plant transition from the vegetative phase to the reproductive phase. This stage is characterized by the formation of panicles, which are the reproductive structures that contain the rice flowers. Panicle initiation marks an important milestone in the rice crop's growth cycle as it signifies the beginning of flower development. \n" +
                    "The plants allocate more energy towards the panicles, and they start to grow and elongate. Adequate water supply and nutrient availability, particularly nitrogen, are crucial during this stage to support panicle development and ensure the formation of healthy and productive flowers. Proper management practices, such as weed control and pest management, are also important to minimize potential stressors that could affect panicle initiation and subsequent grain formation.",
                    "Trong giai đoạn bắt đầu trổ đòng của cây lúa, cây chuyển từ giai đoạn sinh dưỡng sang giai đoạn sinh sản. Giai đoạn này được đặc trưng bởi sự hình thành các bông lúa, là cấu trúc sinh sản chứa các bông lúa. Sự khởi đầu bông lúa đánh dấu một mốc quan trọng trong chu kỳ sinh trưởng của cây lúa vì nó báo hiệu sự bắt đầu phát triển của hoa. \n" +
                            "Thực vật phân bổ nhiều năng lượng hơn cho các bông, và chúng bắt đầu phát triển và dài ra. Cung cấp đầy đủ nước và chất dinh dưỡng, đặc biệt là nitơ, rất quan trọng trong giai đoạn này để hỗ trợ sự phát triển của bông và đảm bảo hình thành những bông hoa khỏe mạnh và năng suất. Thực hành quản lý đúng cách , chẳng hạn như kiểm soát cỏ dại và quản lý sâu bệnh, cũng rất quan trọng để giảm thiểu các yếu tố gây căng thẳng tiềm ẩn có thể ảnh hưởng đến sự khởi đầu của bông và quá trình hình thành hạt sau đó.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fpanicle.jpg?alt=media&token=12e8fe24-83cc-4b1d-aa15-0926f75684a6");
            stages.add(stages5);
            Stages stages6 = new Stages("Heading", "Trổ bông", 6, "The heading stage of the rice crop marks the transition from vegetative to reproductive growth. During this stage, the panicle, which bears the flowers and grains, emerges. Florets develop within the panicle, and their synchronized growth is crucial for optimal yield. \n" +
                    "Proper management practices, including irrigation, nutrient supply, and pest control, are essential during this stage. Farmers monitor indicators like panicle emergence and floret development to make informed decisions. The heading stage sets the foundation for flowering, grain development, and eventual harvest, impacting overall crop yield and quality.",
                    "Giai đoạn trổ bông của cây lúa đánh dấu sự chuyển đổi từ sinh trưởng sinh dưỡng sang sinh trưởng. Trong giai đoạn này, bông lúa, nơi mang hoa và hạt, xuất hiện. Hoa con phát triển trong bông và sự phát triển đồng bộ của chúng là rất quan trọng để đạt năng suất tối ưu. \n" +
                            "Các biện pháp quản lý phù hợp, bao gồm tưới tiêu, cung cấp chất dinh dưỡng và kiểm soát sâu bệnh, là rất cần thiết trong giai đoạn này. Nông dân theo dõi các chỉ số như sự xuất hiện của bông và sự phát triển của bông hoa để đưa ra quyết định sáng suốt. Giai đoạn trổ bông tạo nền tảng cho sự ra hoa, phát triển hạt và thu hoạch cuối cùng , ảnh hưởng đến năng suất và chất lượng cây trồng tổng thể.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fheading.jpg?alt=media&token=a8abe7fd-0294-407c-9524-50a800d975eb");
            stages.add(stages6);
            Stages stages7 = new Stages("Flowering", "Nở hoa thụ phấn", 7, "The flowering stage of the rice crop is a crucial phase where the plant produces flowers containing male and female reproductive structures. Optimal environmental conditions and pollination are essential for successful fertilization. Monitoring and managing this stage ensures the production of viable grains. Factors such as timing, abundance of flowers, and proper management practices influence the outcome.\n" +
                    "The flowering stage typically lasts around a week before the flowers transform into developing grains, leading to grain filling and maturation. Effective management during this stage enhances yield potential and contributes to food security and agricultural sustainability.",
                    "Giai đoạn nở hoa thụ phấn của cây lúa là giai đoạn quan trọng khi cây tạo ra hoa chứa cấu trúc sinh sản đực và cái. Điều kiện môi trường tối ưu và quá trình thụ phấn là điều cần thiết để quá trình thụ tinh thành công. Theo dõi và quản lý giai đoạn này đảm bảo sản xuất các loại ngũ cốc có thể sống được. Các yếu tố như thời gian, sự phong phú của hoa và các biện pháp quản lý phù hợp sẽ ảnh hưởng đến kết quả.\n" +
                            "Giai đoạn nở hoa thường kéo dài khoảng một tuần trước khi hoa biến thành hạt đang phát triển, dẫn đến hạt chắc và chín. Việc quản lý hiệu quả trong giai đoạn này giúp nâng cao tiềm năng năng suất và góp phần đảm bảo an ninh lương thực cũng như tính bền vững của nông nghiệp.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fflowering.jpg?alt=media&token=7a0950a9-fd5a-42fd-8645-1f0d5cb0185c");
            stages.add(stages7);
            Stages stages8 = new Stages("Milk", "Hạt chín sữa", 8, "The milk stage is a crucial phase in the growth of rice crops. It refers to the stage when the rice grains are in a soft dough state and appear milky due to the presence of a translucent liquid. During this stage, the grains accumulate starch and undergo significant physiological changes. It is a critical period for determining the optimal time for harvest, as the grains gradually harden and prepare for final ripening. \n" +
                    "Proper management practices, such as irrigation, nutrient supply, and pest control, are essential during this stage to support grain development and quality formation. Overall, the milk stage is vital for achieving high-quality rice grains with optimal yield and nutritional value.",
                    "Giai đoạn sữa là giai đoạn quan trọng trong quá trình sinh trưởng của cây lúa. Nó đề cập đến giai đoạn hạt gạo ở trạng thái nhão mềm và có màu trắng đục do có chứa chất lỏng trong suốt. Trong giai đoạn này, hạt gạo tích tụ tinh bột và trải qua những thay đổi sinh lý quan trọng. Đây là giai đoạn quan trọng để xác định thời điểm thu hoạch tối ưu, khi các loại ngũ cốc dần cứng lại và chuẩn bị cho quá trình chín cuối cùng. \n" +
                            "Các biện pháp quản lý phù hợp, chẳng hạn như tưới tiêu, cung cấp dinh dưỡng và kiểm soát sâu bệnh, là rất cần thiết trong giai đoạn này để hỗ trợ quá trình phát triển và hình thành chất lượng hạt. Nhìn chung, giai đoạn sữa là rất quan trọng để đạt được hạt gạo chất lượng cao với năng suất và giá trị dinh dưỡng tối ưu. ",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fmilk.jpg?alt=media&token=70ab2bdd-876f-4a3d-b82f-f9d63baa933f");
            stages.add(stages8);
            Stages stages9 = new Stages("Dough", "Hạt chín sáp", 9, "The dough stage is a significant phase in the growth of rice crops. It refers to the stage when the rice grains become firm and undergo a transition from a milky texture to a dough-like consistency. During this stage, the grains continue to accumulate starch, and their moisture content decreases. The grains become denser and more compact, and their color may change from translucent to a light yellowish hue. \n" +
                    "The dough stage is critical for determining the optimal time for harvest, as the grains reach their maximum size and develop their characteristic texture. It is important to closely monitor the crop during this stage to ensure that the grains mature properly and attain the desired quality. Adequate irrigation, nutrient management, and pest control are essential for supporting grain development and maximizing yield. Overall, the dough stage marks a crucial milestone in the rice crop's growth, indicating that the grains are nearing maturity and approaching harvest readiness.",
                    "Giai đoạn nhão là một giai đoạn quan trọng trong quá trình sinh trưởng của cây lúa. Nó đề cập đến giai đoạn hạt gạo trở nên rắn chắc và trải qua quá trình chuyển đổi từ kết cấu màu trắng đục sang dạng sệt như bột nhão. Trong giai đoạn này, các hạt tiếp tục tích tụ tinh bột, và độ ẩm của chúng giảm. Các hạt trở nên đặc hơn và nhỏ gọn hơn, đồng thời màu sắc của chúng có thể thay đổi từ trong mờ sang màu vàng nhạt. \n" +
                            "Giai đoạn nhào bột rất quan trọng để xác định thời điểm thu hoạch tối ưu, vì hạt đạt kích thước tối đa và phát triển cấu trúc đặc trưng của chúng. Điều quan trọng là phải theo dõi chặt chẽ cây trồng trong giai đoạn này để đảm bảo rằng hạt chín đúng cách và đạt được chất lượng mong muốn . Tưới tiêu đầy đủ, quản lý chất dinh dưỡng và kiểm soát sâu bệnh là điều cần thiết để hỗ trợ sự phát triển của hạt và tối đa hóa năng suất. Nhìn chung, giai đoạn trỗ đánh dấu một cột mốc quan trọng trong quá trình sinh trưởng của cây lúa, cho thấy rằng các hạt sắp chín và sắp sẵn sàng cho thu hoạch.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fdough.webp?alt=media&token=e4d5e180-91c7-4c12-af8b-c2cb0de9b6c7");
            stages.add(stages9);
            Stages stage10 = new Stages("Mature", "Hạt chín hoàn toàn", 10, "The mature stage is the final phase in the growth cycle of rice crops. It represents the culmination of the plant's development, where the rice grains reach their full maturity and are ready for harvest. During this stage, the rice plant undergoes physiological changes, such as the drying and yellowing of the leaves, indicating the completion of its life cycle. The rice grains attain their maximum size, weight, and colour, typically turning golden or brown, depending on the variety. \n" +
                    "The plant's energy is primarily directed towards grain filling and maturation, as the nutrients and sugars produced by photosynthesis are allocated to the developing grains. It is crucial to harvest the rice crop at the right time during the mature stage to ensure optimal grain quality and yield. Delaying the harvest may result in grain shattering or susceptibility to pests and diseases. The mature stage is a critical period that signifies the readiness of the rice crop for harvest, marking the successful completion of the growth process and the transition to the next phase of processing and utilization.",
                    "Giai đoạn chín là giai đoạn cuối cùng trong chu kỳ sinh trưởng của cây lúa. Nó thể hiện đỉnh cao quá trình phát triển của cây lúa, khi hạt lúa chín hoàn toàn và sẵn sàng cho thu hoạch. Trong giai đoạn này, cây lúa trải qua những thay đổi về sinh lý, chẳng hạn như lá khô và vàng, cho thấy vòng đời của nó đã hoàn thành. Hạt gạo đạt kích thước, trọng lượng và màu sắc tối đa, thường chuyển sang màu vàng hoặc nâu, tùy thuộc vào giống. \n" +
                            "Năng lượng của cây trồng chủ yếu hướng vào việc làm đầy và chín hạt, vì các chất dinh dưỡng và đường do quá trình quang hợp tạo ra được phân bổ cho các hạt đang phát triển. Điều quan trọng là phải thu hoạch lúa đúng thời điểm trong giai đoạn chín để đảm bảo chất lượng hạt tối ưu và giai đoạn chín là giai đoạn quan trọng báo hiệu cây lúa đã sẵn sàng cho thu hoạch, đánh dấu sự kết thúc thành công của quá trình sinh trưởng và chuyển sang giai đoạn tiếp theo chế biến và sử dụng.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fmature.jpg?alt=media&token=bac50374-b0ef-4949-acd7-c026adec502e");
            stages.add(stage10);
            Stages stages11 = new Stages("Harvesting", "Thu hoạch", 11, "Harvesting is the final stage of rice planting where the mature rice crop is collected. It involves removing the mature panicles from the rice plants. The timing of the harvest is crucial for optimal grain quality. Harvesting methods include manual or mechanical techniques. Once harvested, the rice crop is dried, threshed, and processed to obtain the final polished rice product. Harvesting concludes the rice planting process, providing a plentiful yield of nutritious grains.",
                    "Thu hoạch là giai đoạn cuối cùng của quá trình trồng lúa khi lúa trưởng thành được thu hoạch. Nó liên quan đến việc loại bỏ các bông lúa trưởng thành khỏi cây lúa. Thời điểm thu hoạch là rất quan trọng để có chất lượng hạt tối ưu. Phương pháp thu hoạch bao gồm các kỹ thuật thủ công hoặc cơ giới. Sau khi thu hoạch , lúa được sấy khô, tuốt lúa và chế biến để thu được sản phẩm gạo được đánh bóng cuối cùng. Việc thu hoạch kết thúc quá trình trồng lúa, mang lại năng suất dồi dào các loại hạt dinh dưỡng.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/stages%2Fharvesting.jpg?alt=media&token=d73481b5-f591-4293-b8b2-16e916e37e2a");
            stages.add(stages11);
            for (Stages s : stages) {
                stageDao.insert(s);
            }

            //*****Crops-Stages*****
            CropStageDao cropStageDao = db.cropStageDao();
            //***OM 18***
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Land preparation"), 24, false, "1st", "24th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Planting"), 1, false, "25th", "25th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Seeding"), 10, false, "26th", "35th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Tillering"), 35, false, "36th", "75th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Panicle initiation"), 15, false, "76th", "93th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Heading"), 8, false, "94th", "103th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Flowering"), 8, false, "104th", "113th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Milk"), 10, false, "114th", "123th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Dough"), 10, false, "124th", "133th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Mature"), 10, false, "134th", "143th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 18"), stageDao.getIdByName("Harvesting"), 1, false, "144th", "144th"));
            //***DT 08***
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Land preparation"), 24, false, "1st", "24th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Planting"), 1, false, "25th", "25th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Seeding"), 10, false, "26th", "35th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Tillering"), 35, false, "36th", "75th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Panicle initiation"), 15, false, "76th", "93th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Heading"), 10, false, "94th", "103th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Flowering"), 10, false, "104th", "114th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Milk"), 10, false, "115th", "125th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Dough"), 11, false, "126th", "137th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Mature"), 10, false, "138th", "147th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT 08"), stageDao.getIdByName("Harvesting"), 1, false, "148th", "148th"));
            //***OM 5451***
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Land preparation"), 24, false, "1st", "24th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Planting"), 1, false, "25th", "25th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Seeding"), 9, false, "26th", "34th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Tillering"), 35, false, "35th", "74th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Panicle initiation"), 14, false, "75th", "88th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Heading"), 8, false, "89th", "96th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Flowering"), 8, false, "97th", "104th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Milk"), 9, false, "105th", "113th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Dough"), 9, false, "114th", "122th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Mature"), 9, false, "123th", "132th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM 5451"), stageDao.getIdByName("Harvesting"), 1, false, "133th", "133th"));

            //***IR 50404***
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Land preparation"), 24, false, "1st", "24th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Planting"), 1, false, "25th", "25th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Seeding"), 8, false, "26th", "33th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Tillering"), 34, false, "34th", "72th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Panicle initiation"), 13, false, "73th", "85th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Heading"), 8, false, "86th", "93th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Flowering"), 8, false, "94th", "101th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Milk"), 8, false, "102th", "109th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Dough"), 8, false, "110th", "117th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Mature"), 9, false, "118th", "126th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("IR 50404"), stageDao.getIdByName("Harvesting"), 1, false, "127th", "127th"));

            //*****Stages-Pests****
            PestStageDao pestStageDao = db.pestStageDao();
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Seeding"), pestDao.getIdByName("Rice thrips")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Seeding"), pestDao.getIdByName("Stem borer")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Seeding"), pestDao.getIdByName("Rice gall midge")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Tillering"), pestDao.getIdByName("Stem borer")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Tillering"), pestDao.getIdByName("Rice leaffolder")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Tillering"), pestDao.getIdByName("Rice gall midge")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Panicle initiation"), pestDao.getIdByName("Rice leaffolder")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Panicle initiation"), pestDao.getIdByName("Planthopper")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Panicle initiation"), pestDao.getIdByName("Stem borer")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Heading"), pestDao.getIdByName("Rice leaffolder")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Heading"), pestDao.getIdByName("Planthopper")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Flowering"), pestDao.getIdByName("Rice leaffolder")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Flowering"), pestDao.getIdByName("Planthopper")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Flowering"), pestDao.getIdByName("Rice bug")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Flowering"), pestDao.getIdByName("Black bug")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Milk"), pestDao.getIdByName("Planthopper")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Milk"), pestDao.getIdByName("Rice bug")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Milk"), pestDao.getIdByName("Black bug")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Dough"), pestDao.getIdByName("Planthopper")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Dough"), pestDao.getIdByName("Rice bug")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Dough"), pestDao.getIdByName("Black bug")));

            //****Stages-Diseases****
            DiseaseStageDao diseaseStageDao = db.diseaseStageDao();
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Seeding"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Tillering"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Tillering"), diseaseDao.getIdByName("Leaf Scald")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Tillering"), diseaseDao.getIdByName("Brown spot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Tillering"), diseaseDao.getIdByName("Sheath blight")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Tillering"), diseaseDao.getIdByName("Bacterial leaf streak")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Tillering"), diseaseDao.getIdByName("Stem rot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Brown spot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Leaf Scald")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Sheath blight")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Rice grassy stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Rice ragged stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Tungro")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Bacterial leaf streak")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Red stripe")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Stem rot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Leaf Scald")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Sheath rot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Brown spot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Sheath blight")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Rice grassy stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Rice ragged stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Tungro")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Bacterial leaf streak")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Red stripe")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Stem rot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Sheath rot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Brown spot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Sheath blight")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Rice grassy stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Rice ragged stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Red stripe")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Tungro")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Stem rot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Milk"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Milk"), diseaseDao.getIdByName("Brown spot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Milk"), diseaseDao.getIdByName("Sheath blight")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Milk"), diseaseDao.getIdByName("Rice grassy stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Milk"), diseaseDao.getIdByName("Rice ragged stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Milk"), diseaseDao.getIdByName("Tungro")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Milk"), diseaseDao.getIdByName("Red stripe")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Dough"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Dough"), diseaseDao.getIdByName("Brown spot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Dough"), diseaseDao.getIdByName("Sheath blight")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Dough"), diseaseDao.getIdByName("Rice grassy stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Dough"), diseaseDao.getIdByName("Rice ragged stunt")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Dough"), diseaseDao.getIdByName("Tungro")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Dough"), diseaseDao.getIdByName("Red stripe")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Mature"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Mature"), diseaseDao.getIdByName("Brown spot")));

            //****Activities****
            ActivityDao activityDao = db.activityDao();
            ArrayList<Activities> activities = new ArrayList<>();
            Activities activities1 = new Activities(stageDao.getIdByName("Land preparation"), "Bunds or dikes", "Đắp bờ hoặc đê ", "Bunds or dikes enable the field to hold water. This is important especially in areas where water supply is not reliable.",
                    "Bờ hoặc đê giúp giữ nước cho ruộng. Điều này đặc biệt quan trọng ở những khu vực nguồn cung cấp nước không đáng tin cậy.", 1, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fbund.jpg?alt=media&token=beb80c5a-7002-4a2e-ba54-51453b7ef933");
            activities.add(activities1);
            Activities activities2 = new Activities(stageDao.getIdByName("Land preparation"), "Irrigate the field", "Tưới ruộng", "Irrigate the field with 2−3 cm of water for about 3−7 days or until it is soft enough and suitable for an equipment to be used.",
                    "Tưới ruộng với lượng nước 2−3 cm trong khoảng 3−7 ngày hoặc cho đến khi đất đủ mềm và phù hợp để sử dụng thiết bị.", 7, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Firrigate_the_field.jpg?alt=media&token=8e15a7cd-07fe-41ee-81b9-2f7ecbf941b7");
            activities.add(activities2);
            Activities activities3 = new Activities(stageDao.getIdByName("Land preparation"), "Perform primary tillage operations", "Xới đất lần đầu", "Primary tillage is normally undertaken when the soil is wet enough to allow the field to be plowed and strong enough to give reasonable levels of traction. This can be immediately after harvest or at the beginning of the next season, depending on soil moisture and water availability.",
                    "Xới đất lần đầu thường được thực hiện khi đất đủ ẩm để cho phép cày ruộng và đủ mạnh để tạo ra lực kéo hợp lý. Việc này có thể được thực hiện ngay sau khi thu hoạch hoặc vào đầu mùa tiếp theo, tùy thuộc vào độ ẩm và nước của đất khả dụng.", 2, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fperform_primary_tillage_operations.jpg?alt=media&token=4f5f1876-220f-4de1-bdf9-d11bd4c290b7");
            activities.add(activities3);
            Activities activities4 = new Activities(stageDao.getIdByName("Land preparation"), "Flood the field", "Làm ngập ruộng", "Keep the field submerged for 10−14 days after plowing to soften clods and to decompose organic materials.",
                    "Giữ cho ruộng ngập nước trong 10−14 ngày sau khi cày xới để làm mềm cục đất và phân hủy các chất hữu cơ.", 10, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fflood.jpg?alt=media&token=74a749db-46c8-46d6-8ad1-e23cf55f9d38");
            activities.add(activities4);
            Activities activities5 = new Activities(stageDao.getIdByName("Land preparation"), "Perform secondary tillage operations", "Xới đất lần 2", "Depending on climate and soil type, this should be done 10−14 days after primary workings.",
                    "Tùy thuộc vào khí hậu và loại đất, việc này nên được thực hiện sau 10−14 ngày kể từ khi xới đất lần đầu.", 2, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fperform_secondary_tillage_operations.jpg?alt=media&token=8d9ae2a8-f3cf-45f0-a582-eb17a3360256");
            activities.add(activities5);
            Activities activities6 = new Activities(stageDao.getIdByName("Land preparation"), "Level the field", "Trạc đất", "Levelling should be done two (2) days before planting. A levelled and smooth soil surface provides for uniform germination and growth of the crops. A well-levelled field improves water coverage and is also proven to increase crop yield and quality.",
                    "Việc san lấp mặt bằng nên được thực hiện hai (2) ngày trước khi trồng. Bề mặt đất bằng phẳng và bằng phẳng giúp cây trồng nảy mầm và phát triển đồng đều. Ruộng được san bằng tốt giúp cải thiện độ che phủ của nước và cũng được chứng minh là làm tăng năng suất và chất lượng cây trồng.", 2, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Flevel_the_field.jpg?alt=media&token=5e0e0bdd-bb69-47e0-bb18-66cbc30d8a4a");
            activities.add(activities6);
            Activities activities7 = new Activities(stageDao.getIdByName("Planting"), "Transplanting", "Cấy lúa", "Transplanting is commonly practiced as a method of weed control for wet or puddled fields. It requires less seed but much more labor compared to direct seeding. Also, transplanted crops take longer to mature due to transplanting shock.",
                    "Cấy thường được thực hiện như một phương pháp kiểm soát cỏ dại trên những cánh đồng ẩm ướt hoặc vũng nước. Nó cần ít hạt giống hơn nhưng tốn nhiều công sức hơn so với gieo hạt trực tiếp. Ngoài ra, cây cấy mất nhiều thời gian hơn để trưởng thành do sốc khi cấy.", 1, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Ftransplanting.jpg?alt=media&token=ab52eecd-9eb4-4e61-82d2-24e339b22966");
            activities.add(activities7);
            Activities activities8 = new Activities(stageDao.getIdByName("Planting"), "Direct seeding", "Xạ lúa", "Direct-seeded crops require less labour and tend to mature faster than transplanted crops. In this method, plants are not subjected to stresses such as being pulled from the soil and re-establishing fine rootlets. However, they have more competition from weeds.",
                    "Xạ lúa đòi hỏi ít lao động hơn và có xu hướng trưởng thành nhanh hơn so với cây trồng cấy ghép. Theo phương pháp này, cây trồng không phải chịu áp lực như bị kéo khỏi đất và tái lập rễ con. Tuy nhiên, chúng phải chịu nhiều sự cạnh tranh hơn từ cỏ dại. ", 1, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fdirect_seeding.jpg?alt=media&token=d552f963-c5c8-4289-ae70-348961b9d4d4");
            activities.add(activities8);
            Activities activities9 = new Activities(stageDao.getIdByName("Seeding"), "Spraying herbicide", "Phun thuốc diệt cỏ", "Spraying herbicides during the seeding stage of rice growth is beneficial for effective weed control and promoting healthy crop establishment. The key points are:\n" +
                    "\n" +
                    "- Weed management: Herbicide application at this stage helps control weeds that compete with rice plants for resources and hinder their growth and productivity.\n" +
                    "\n" +
                    "- Early intervention: Targeting weeds early during seeding prevents them from becoming established and competing with rice plants throughout the growth cycle.\n" +
                    "\n" +
                    "- Resource utilization: Effective weed control ensures that rice plants have optimal access to water, nutrients, and sunlight, promoting their healthy growth and development.\n" +
                    "\n" +
                    "- Labor efficiency: Herbicide use reduces the need for manual weeding, saving time and labor during weed management.\n" +
                    "\n" +
                    "- Uniform crop establishment: Weed-free fields during seeding promote uniform crop establishment, leading to consistent growth and better overall crop performance.",
                    "Phun thuốc diệt cỏ trong giai đoạn gieo hạt của quá trình sinh trưởng của lúa có lợi cho việc kiểm soát cỏ dại hiệu quả và thúc đẩy cây trồng phát triển khỏe mạnh. Các điểm chính là:\n" +
                            "\n" +
                            "- Quản lý cỏ dại: Sử dụng thuốc diệt cỏ ở giai đoạn này giúp kiểm soát cỏ dại cạnh tranh với cây lúa để lấy tài nguyên và cản trở sự phát triển cũng như năng suất của chúng.\n" +
                            "\n" +
                            "- Can thiệp sớm: Nhắm mục tiêu sớm vào cỏ dại trong quá trình gieo hạt để ngăn chúng hình thành và cạnh tranh với cây lúa trong suốt chu kỳ sinh trưởng.\n" +
                            "\n" +
                            "- Sử dụng tài nguyên: Kiểm soát cỏ dại hiệu quả đảm bảo rằng cây lúa được tiếp cận tối ưu với nước, chất dinh dưỡng và ánh sáng mặt trời, thúc đẩy quá trình sinh trưởng và phát triển khỏe mạnh của chúng.\n" +
                            "\n" +
                            "- Hiệu quả lao động: Việc sử dụng thuốc diệt cỏ giúp giảm nhu cầu làm cỏ thủ công, tiết kiệm thời gian và công sức trong quá trình quản lý cỏ dại.\n" +
                            "\n" +
                            "- Hình thành cây trồng đồng đều: Những cánh đồng không có cỏ dại trong quá trình gieo hạt thúc đẩy sự hình thành cây trồng đồng đều, dẫn đến tăng trưởng ổn định và năng suất cây trồng tổng thể tốt hơn.", 10, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fspraying_herbicide.jpg?alt=media&token=89ef581c-0d16-4446-b253-5cae7d9aa5e5");
            activities.add(activities9);
            Activities activities10 = new Activities(stageDao.getIdByName("Tillering"), "Irrigate the field", "Tưới ruộng", "The reason why water is pumped into the field about 1 - 3 cm before applying fertilizer is to prevent light from decomposing and evaporating manure. When fertilizer is applied to dry soil, it can cause a chemical reaction that releases ammonia gas. This gas can be harmful to plants and can cause root damage. By watering the soil before applying fertilizer, you can help prevent this reaction from occurring.",
                    "Sở dĩ bơm nước vào ruộng khoảng 1 - 3 cm trước khi bón phân là để ánh sáng không làm phân phân hủy và bốc hơi. Khi bón phân cho đất khô có thể gây ra phản ứng hóa học giải phóng khí amoniac. Khí này có thể có hại cho cây trồng và có thể gây tổn thương rễ. Bằng cách tưới nước vào đất trước khi bón phân, bạn có thể giúp ngăn chặn phản ứng này xảy ra.", 1, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Firrigate_the_field_2.webp?alt=media&token=32ae2ee0-66a3-4e4e-8ee0-84caa3e29633");
            activities.add(activities10);
            Activities activities11 = new Activities(stageDao.getIdByName("Tillering"), "Primary fertilizing", "Bón lót", "Primary fertilizing tillering rice is the most critical step in the process of planting and caring for rice. Fertilizing to help tiller rice is the period of fertilizing after 15 to 20 days after transplanting rice. For the rice to grow well, and for high yield, in addition to applying fertilizer with the right technique, choosing the right fertilizer is also one of the decisive factors. Should spend 1/2 -2/3 of the remaining nitrogen to fertilize the tillering stage to help the rice to branch quickly, concentrate and also to reduce the amount of fertilizer and avoid loss of nitrogen.",
                    "Bón thúc thúc lúa đẻ nhánh là khâu quan trọng nhất trong quá trình gieo trồng và chăm sóc lúa. Bón lót giúp lúa đẻ nhánh là thời kỳ bón sau khi cấy lúa từ 15 đến 20 ngày. Để cây lúa sinh trưởng phát triển tốt, cho năng suất cao , ngoài việc bón phân đúng kỹ thuật thì việc chọn loại phân bón phù hợp cũng là một trong những yếu tố quyết định, nên dành 1/2 -2/3 lượng đạm còn lại để bón giai đoạn đẻ nhánh giúp lúa đẻ nhánh nhanh, tập trung, đồng thời cũng để giảm lượng phân bón, tránh thất thoát đạm", 18, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fprimary_fertilizing.jpg?alt=media&token=89b07a1c-8f43-46ba-acb5-8ef1f43ce9a1");
            activities.add(activities11);
            Activities activities12 = new Activities(stageDao.getIdByName("Tillering"), "Secondary fertilizing", "Bón thúc đẻ nhánh", "Secondary fertilizing plays a very important role. It determines the yield as well as the efficiency of the entire rice crop. If we fertilize correctly, the rice yield will increase from 1 to 2 tons/ha. In contrast, the wrong fertilization will reduce rice yield from 1 to 2 tons/ha.",
                    "Bón thúc đẻ nhánh có vai trò rất quan trọng, quyết định đến năng suất cũng như hiệu quả của cả vụ lúa, nếu bón phân đúng thì năng suất lúa tăng từ 1 đến 2 tấn/ha, ngược lại bón sai thì năng suất lúa giảm năng suất lúa từ 1 đến 2 tấn/ha.", 18, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fsecondary_fertilizing.jpg?alt=media&token=d7ed48d7-8f4f-41fa-86b3-f7467c544a8c");
            activities.add(activities12);
            Activities activities13 = new Activities(stageDao.getIdByName("Panicle initiation"), "Thirdly fertilizing", "Bón thúc đòng", "Thirdly fertilizing is also one of the crucial stages contributing to determining rice yield. After the rice has fully bloomed, it is possible to fertilize the seeds by applying three types of Nitrogen (N), Phosphorus (P), and Potassium (K). This is the period when fertilizing is effective when planting rice, helping to limit falling and flattening seeds. Farmers should fertilize seedlings 25 days before harvest to reduce the amount of pesticide left on the seeds.",
                    "Bón thúc đòng cũng là một trong những khâu quan trọng góp phần quyết định năng suất lúa. Sau khi lúa trổ đòng, có thể bón lót cho hạt bằng cách bón 3 loại đạm (N), Lân (P), Kali (K) Đây là thời kỳ bón phân phát huy tác dụng khi gieo cấy lúa, giúp hạn chế tình trạng hạt bị đổ, lép, bà con nên bón thúc trước khi thu hoạch 25 ngày để giảm lượng thuốc bảo vệ thực vật còn sót lại trên hạt.", 3, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fthirdly_fertilizing.jpg?alt=media&token=03228f3a-1cb7-4b66-959b-5124ec878890");
            activities.add(activities13);
            Activities activities14 = new Activities(stageDao.getIdByName("Panicle initiation"), "First spraying pesticide", "Xịt thuốc sâu lần đầu", "Spraying pesticides during the panicle initiation stage of rice growth is crucial for effective pest management and promoting healthy crop development. By targeting this stage, the following benefits can be achieved:\n" +
                    "\n" +
                    "- Pest control: Pesticide application at this stage helps control insects, diseases, and weeds that can damage the crop.\n" +
                    "\n" +
                    "- Targeting specific pests: It addresses pests that are most active and damaging during the panicle initiation stage, such as rice stem borers, leaf folders, or panicle mites.\n" +
                    "\n" +
                    "- Protection for reproductive structures: Pesticides safeguard the developing panicles and ensure proper grain formation.\n" +
                    "\n" +
                    "- Preventing pest buildup: Timely application prevents pest populations from reaching damaging levels and reduces the risk of infestations in later stages.\n" +
                    "\n" +
                    "- Overall crop health: Managing pests during this stage promotes the overall health, vigor, and productivity of the rice crop.",
                    "Phun thuốc trừ sâu trong giai đoạn bắt đầu trổ đòng của lúa là rất quan trọng để quản lý dịch hại hiệu quả và thúc đẩy cây trồng phát triển khỏe mạnh. Bằng cách nhắm mục tiêu vào giai đoạn này, có thể đạt được những lợi ích sau:\n" +
                            "\n" +
                            "- Kiểm soát dịch hại: Sử dụng thuốc trừ sâu ở giai đoạn này giúp kiểm soát côn trùng, dịch bệnh và cỏ dại có thể gây hại cho mùa màng.\n" +
                            "\n" +
                            "- Nhắm mục tiêu các loài gây hại cụ thể: Nó giải quyết các loài gây hại hoạt động mạnh nhất và gây hại trong giai đoạn bắt đầu bông, chẳng hạn như sâu đục thân lúa, sâu cuốn lá hoặc bọ ve trên bông.\n" +
                            "\n" +
                            "- Bảo vệ cấu trúc sinh sản: Thuốc trừ sâu bảo vệ bông lúa đang phát triển và đảm bảo hình thành hạt thích hợp.\n" +
                            "\n" +
                            "- Ngăn chặn sự tích tụ của dịch hại: Ứng dụng kịp thời sẽ ngăn quần thể dịch hại đạt đến mức gây hại và giảm nguy cơ bị phá hoại trong các giai đoạn sau.\n" +
                            "\n" +
                            "- Sức khỏe tổng thể của cây trồng: Quản lý sâu bệnh trong giai đoạn này sẽ thúc đẩy sức khỏe tổng thể, sức sống và năng suất của cây lúa.", 12, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Ffirst_spraying_pesticide.jpg?alt=media&token=385036ff-6f12-41b8-8b5c-be8fd3e126d4");
            activities.add(activities14);
            Activities activities15 = new Activities(stageDao.getIdByName("Heading"), "Second spraying pesticide", "Xịt thuốc sâu lần 2", "Spraying pesticides during the heading stage of rice growth is important for effective pest control and optimizing crop yield. Key points to consider include:\n" +
                    "\n" +
                    "- Pest management: Pesticide application at this stage helps control pests like rice blast, sheath blight, and planthoppers that are active during the heading stage.\n" +
                    "\n" +
                    "- Disease prevention: Spraying pesticides during this stage helps prevent and manage diseases that can damage the panicles and reduce crop yield.\n" +
                    "\n" +
                    "- Protecting panicles: Pesticides protect the developing panicles, ensuring healthy grain formation and minimizing damage caused by pests.\n" +
                    "\n" +
                    "- Optimizing yield: Effective pest control during the heading stage helps maximize rice yield by minimizing yield losses caused by pests and diseases.\n" +
                    "\n" +
                    "- Timing for pest life cycle: Spraying pesticides at the heading stage disrupts the life cycle of pests, preventing them from reproducing and causing further damage in later stages.",
                    "Việc phun thuốc trừ sâu trong giai đoạn làm đòng của cây lúa là rất quan trọng để kiểm soát sâu bệnh hiệu quả và tối ưu hóa năng suất cây trồng. Những điểm chính cần xem xét bao gồm:\n" +
                            "\n" +
                            "- Quản lý dịch hại: Sử dụng thuốc trừ sâu ở giai đoạn này giúp kiểm soát các loại sâu bệnh như đạo ôn, khô vằn và rầy đang hoạt động trong giai đoạn làm đòng.\n" +
                            "\n" +
                            "- Phòng trừ dịch bệnh: Phun thuốc trừ sâu trong giai đoạn này giúp ngăn ngừa và quản lý các loại bệnh có thể gây hại cho bông và làm giảm năng suất cây trồng.\n" +
                            "\n" +
                            "- Bảo vệ bông: Thuốc trừ sâu bảo vệ bông đang phát triển, đảm bảo hình thành hạt khỏe mạnh và giảm thiểu thiệt hại do sâu bệnh gây ra.\n" +
                            "\n" +
                            "- Tối ưu hóa năng suất: Kiểm soát sâu bệnh hiệu quả trong giai đoạn làm đòng giúp tối đa hóa năng suất lúa bằng cách giảm thiểu tổn thất năng suất do sâu bệnh gây ra.\n" +
                            "\n" +
                            "- Thời điểm vòng đời sinh vật gây hại: Phun thuốc trừ sâu ở giai đoạn đầu làm gián đoạn vòng đời sinh vật gây hại, không cho chúng sinh sản và gây hại ở giai đoạn sau.", 9, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fsecond_spraying_pesticide.jpg?alt=media&token=b4d37634-4ebb-480c-bb3c-45509393a1f5");
            activities.add(activities15);
            Activities activities16 = new Activities(stageDao.getIdByName("Flowering"), "Third spraying pesticide", "Xịt thuốc sâu lần 3", "Spraying pesticides during the flowering stage of rice growth offers several advantages:\n" +
                    "\n" +
                    "- Pest control: It helps manage pests like rice bugs, thrips, and leafhoppers that are active during this stage.\n" +
                    "\n" +
                    "- Disease management: Pesticides prevent the spread of diseases such as sheath blight and bacterial blight.\n" +
                    "\n" +
                    "- Pollination and fertilization: Pesticides protect flowers, ensuring successful pollination and fertilization for proper grain development.\n" +
                    "\n" +
                    "- Weather protection: Pesticides guard against adverse weather conditions that promote fungal diseases.\n" +
                    "\n" +
                    "- Yield optimization: By safeguarding the reproductive structures, pesticides contribute to higher grain yield and quality.",
                    "Việc phun thuốc trừ sâu trong giai đoạn lúa trổ bông mang lại một số lợi ích:\n" +
                            "\n" +
                            "- Kiểm soát dịch hại: Nó giúp quản lý các loại dịch hại như bọ xít, bọ trĩ và rầy đang hoạt động trong giai đoạn này.\n" +
                            "\n" +
                            "- Quản lý dịch bệnh: Thuốc trừ sâu ngăn chặn sự lây lan của các bệnh như bệnh khô vằn và bệnh bạc lá do vi khuẩn.\n" +
                            "\n" +
                            "- Thụ phấn và thụ tinh: Thuốc trừ sâu bảo vệ hoa, đảm bảo quá trình thụ phấn và thụ tinh thành công để hạt phát triển tốt.\n" +
                            "\n" +
                            "- Bảo vệ thời tiết: Thuốc trừ sâu bảo vệ chống lại các điều kiện thời tiết bất lợi thúc đẩy bệnh nấm.\n" +
                            "\n" +
                            "- Tối ưu hóa năng suất: Bằng cách bảo vệ các cấu trúc sinh sản, thuốc trừ sâu góp phần mang lại năng suất và chất lượng hạt cao hơn.", 9, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Fthird_spraying_pesticide.webp?alt=media&token=f6df64f8-6c2b-43e8-9eff-e8a490899a99");
            activities.add(activities16);
            Activities activities17 = new Activities(stageDao.getIdByName("Dough"), "Fourth spraying pesticide", "Xịt thuốc sâu lần 4", "Spraying pesticides during the dough stage of rice growth provides several benefits:\n" +
                    "\n" +
                    "- Pest control: Pesticide application at this stage helps manage pests like rice stink bugs, stem borers, and leaf folders, which can cause significant damage to the crop.\n" +
                    "\n" +
                    "- Disease prevention: Pesticides protect the rice plants from diseases such as sheath blight and blast, which are common during the dough stage.\n" +
                    "\n" +
                    "- Grain protection: By controlling pests and diseases, pesticides safeguard the developing grains, preventing yield loss and preserving grain quality.\n" +
                    "\n" +
                    "- Harvest preparation: Spraying pesticides at the dough stage helps prepare the crop for harvest by reducing pest infestations and ensuring healthy grain formation.\n" +
                    "\n" +
                    "- Crop longevity: Effective pest and disease control during this stage contribute to the overall health and longevity of the rice crop.",
                    "Việc phun thuốc trừ sâu trong giai đoạn lúa chín sẽ mang lại một số lợi ích:\n" +
                            "\n" +
                            "- Kiểm soát dịch hại: Sử dụng thuốc trừ sâu ở giai đoạn này giúp kiểm soát các loại dịch hại như bọ xít hại lúa, sâu đục thân và sâu cuốn lá, những loại có thể gây thiệt hại đáng kể cho mùa màng.\n" +
                            "\n" +
                            "- Phòng trừ dịch bệnh: Thuốc trừ sâu bảo vệ cây lúa khỏi các bệnh như khô vằn và đạo ôn thường gặp ở giai đoạn đòng trỗ.\n" +
                            "\n" +
                            "- Bảo vệ ngũ cốc: Bằng cách kiểm soát sâu bệnh, thuốc trừ sâu bảo vệ các loại ngũ cốc đang phát triển, ngăn ngừa giảm năng suất và bảo toàn chất lượng hạt.\n" +
                            "\n" +
                            "- Chuẩn bị thu hoạch: Phun thuốc trừ sâu ở giai đoạn nhào bột giúp chuẩn bị cho vụ thu hoạch bằng cách giảm sự phá hoại của sâu bệnh và đảm bảo hình thành hạt khỏe mạnh.\n" +
                            "\n" +
                            "- Tuổi thọ cây trồng: Kiểm soát sâu bệnh hiệu quả trong giai đoạn này góp phần vào sức khỏe tổng thể và tuổi thọ của cây lúa.", 20, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/activities%2Ffourth_spraying_pesticide.jpg?alt=media&token=d12a631a-256f-4647-87db-f2ccd063c380");
            activities.add(activities17);
            for (Activities a : activities) {
                activityDao.insert(a);
            }

            //****Activities-Pesticides****
            ActivityPesticideDao activityPesticideDao = db.activityPesticideDao();
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Spraying herbicide"), pesticideDao.getIdByName("Hilton USA 320 EC"), 1, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Spraying herbicide"), pesticideDao.getIdByName("Elano 20EC"), 0.4, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("First spraying pesticide"), pesticideDao.getIdByName("Amistar Top 325SC"), 1.5, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("First spraying pesticide"), pesticideDao.getIdByName("Dupont™ Pexena™ 106SC"), 0.032, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Second spraying pesticide"), pesticideDao.getIdByName("Dupont™ Pexena™ 106SC"), 0.032, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Second spraying pesticide"), pesticideDao.getIdByName("ANTRACOL 70WP"), 1.5, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Second spraying pesticide"), pesticideDao.getIdByName("Padan 95SP"), 0.6, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Second spraying pesticide"), pesticideDao.getIdByName("Tilt Super 300EC"), 0.3, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Third spraying pesticide"), pesticideDao.getIdByName("ANTRACOL 70WP"), 1.5, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Third spraying pesticide"), pesticideDao.getIdByName("Tilt Super 300EC"), 0.3, "Once time"));
            activityPesticideDao.insert(new ActivityPesticides(activityDao.getIdByName("Fourth spraying pesticide"), pesticideDao.getIdByName("Amistar Top 325SC"), 0.3, "Once time"));

            //****Fertilizers****
            FertilizerDao fertilizerDao = db.fertilizerDao();
            ArrayList<Fertilizers> fertilizers = new ArrayList<>();
            Fertilizers fertilizers1 = new Fertilizers("DAP", "Ha Tay Fertilizer Import Export One Member Company Limited", "Công ty TNHH MTV XNK Phân đạm Hà Tây", "Ingredients %: Nts: 18%; P2O5hh: 46%; K2Ohh:0%", "Thành phần %: Nts: 18%; P2O5hh: 46%; K2Ohh:0%", "Long-term industrial plants, fruit trees: apply 3-4 kg/tree/year.\n" +
                    "Vegetable crops: 150 - 200kg/ha/time\n" +
                    "Food crops: 120 - 200kg/ha/time\n" +
                    "Short-term crops: 150 - 200kg/ha/time\n" +
                    "Other crops: 200 - 300kg/ha/time\n" +
                    "* The above guidelines are for reference only and should be adjusted depending on the region and cultivar.",
                    "Cây công nghiệp dài ngày, cây ăn trái: bón 3-4 kg/cây/năm.\n" +
                            "Rau màu: 150 - 200kg/ha/lần\n" +
                            "Cây lương thực: 120 - 200kg/ha/lần\n" +
                            "Cây ngắn ngày: 150 - 200kg/ha/lần\n" +
                            "Các loại cây khác: 200 - 300kg/ha/lần\n" +
                            "* Các hướng dẫn trên chỉ mang tính chất tham khảo và cần được điều chỉnh tùy theo khu vực và giống cây trồng.", 60, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/fertilizers%2Fdap.jpg?alt=media&token=bbf58e38-531d-43f1-9b6e-746aa7605c15");
            fertilizers.add(fertilizers1);
            Fertilizers fertilizers2 = new Fertilizers("Urea", "Petrovietnam Camau Fertilizer Joint stock company", "Công ty Cổ phần Phân bón Dầu khí Cà Mau", "Ingredients %: N:46.3%; Biuret: 0.99%; Humidity: 0.5%", "Thành phần %: N:46,3%; Biuret: 0,99%; Độ ẩm: 0,5%",
                    "Rice: 50-60 kg/ha/time (3 times/crop: 7-10 days after sowing/18-22 days after sowing/ 38-42 days after sowing)\n" +
                            "Corn: 80-100 kg/ha/time (3 times/crop: 7-10 days after planting/20-30 days after planting/40-50 days after planting)\n" +
                            "Sugarcane: 120-150 kg/ha/time (3 times/crop: 15-20 days after planting/2-3 months after planting/4-5 months after planting)",
                    "Lúa: 50-60 kg/ha/lần (3 lần/vụ: 7-10 ngày sau sạ/18-22 ngày sau sạ/ 38-42 ngày sau sạ)\n" +
                            "Bắp: 80-100 kg/ha/lần (3 lần/vụ: 7-10 ngày sau trồng/20-30 ngày sau trồng/40-50 ngày sau trồng)\n" +
                            "Mía: 120-150 kg/ha/lần (3 lần/vụ: 15-20 ngày sau trồng/2-3 tháng sau trồng/4-5 tháng sau trồng)", 60, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/fertilizers%2Furea.jpg?alt=media&token=c18fc7e4-ddf6-49db-bd8f-b671bae5c5a5");
            fertilizers.add(fertilizers2);
            Fertilizers fertilizers3 = new Fertilizers("MOP", "Petrovietnam Camau Fertilizer Joint stock company", "Công ty Cổ phần Phân bón Dầu khí Cà Mau", "Ingredients %: Kali (K2O): 61%;Humidity: 0.5%", "Thành phần %: Kali (K2O): 61%; Độ ẩm: 0,5%",
                    "Use potassium fertilizer to best fertilize rice in 2 stages: 1st time, 12-15 days after transplanting rice, depending on long or short-term rice varieties. At this time, it is necessary to fertilize on average each pole (500 m2) from 2-3 kg to make the rice plant healthy, hardy transplant, high effective branch. \n" +
                            "The second fertilizer application is very important when the rice plant is standing female, preparing to make a spike.",
                    "Dùng phân kali bón cho lúa tốt nhất vào 2 đợt: Lần 1, sau cấy 12-15 ngày tùy theo giống lúa dài ngày hay ngắn ngày, thời điểm này cần bón bình quân cho mỗi sào (500 m2) từ 2-3 kg để cây lúa khỏe, cứng cấy, đẻ nhánh hiệu quả cao. \n" +
                            "Bón phân lần 2 rất quan trọng khi cây lúa đang làm đòng cái, chuẩn bị làm đòng.", 40, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/fertilizers%2Fkali.jpg?alt=media&token=6b31aa1b-f6b6-4a43-8c29-7426b7b0b185");
            fertilizers.add(fertilizers3);
            for (Fertilizers f : fertilizers) {
                fertilizerDao.insert(f);
            }

            //****Activities-Fertilizers****
            ActivityFertilizerDao activityFertilizerDao = db.activityFertilizerDao();
            activityFertilizerDao.insert(new ActivityFertilizers(activityDao.getIdByName("Primary fertilizing"), fertilizerDao.getIdByName("Urea"), 70, "Once time"));
            activityFertilizerDao.insert(new ActivityFertilizers(activityDao.getIdByName("Secondary fertilizing"), fertilizerDao.getIdByName("DAP"), 60, "Once time"));
            activityFertilizerDao.insert(new ActivityFertilizers(activityDao.getIdByName("Secondary fertilizing"), fertilizerDao.getIdByName("Urea"), 60, "Once time"));
            activityFertilizerDao.insert(new ActivityFertilizers(activityDao.getIdByName("Secondary fertilizing"), fertilizerDao.getIdByName("MOP"), 30, "Once time"));
            activityFertilizerDao.insert(new ActivityFertilizers(activityDao.getIdByName("Thirdly fertilizing"), fertilizerDao.getIdByName("Urea"), 50, "Once time"));
            activityFertilizerDao.insert(new ActivityFertilizers(activityDao.getIdByName("Thirdly fertilizing"), fertilizerDao.getIdByName("MOP"), 50, "Once time"));

            //****Weeds****
            WeedDao weedDao = db.weedDao();
            ArrayList<Weeds> weeds = new ArrayList<>();
            Weeds weeds1 = new Weeds("Echinochloa crus-galli", "Cỏ lồng vực", "- Asia: China, Japan, and Korea.\n" +
                    "- South and Southeast Asia: India, Indonesia, Cambodia, Lao PDR, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: widespread in Africa, Europe, and America.",
                    "- Châu Á: Trung Quốc, Nhật Bản và Hàn Quốc.\n" +
                            "- Nam và Đông Nam Á: Ấn Độ, Indonesia, Campuchia, CHDCND Lào, Pakistan, Philippines, Sri Lanka, Thái Lan và Việt Nam.\n" +
                            "- Phần còn lại của thế giới: phổ biến ở Châu Phi, Châu Âu và Châu Mỹ.",
                    "Annual, erect, tufted or reclining at base; up to 200 cm tall.\n" +
                            "- Stem: culms rooting at lower nodes, cylindrical, without hairs, and filled with white spongy pith.\n" +
                            "- Leaf: linear with a broad round base and narrow top; blade 10−40 cm long; ligule absent.\n" +
                            "- Inflorescence: loose green to purplish, 10−25 cm long comprising compound racemes; spikelets more or less elliptical and pointed, usually slightly hairy; awns, if present, green to purplish, 2−5 mm long.",
                    "Hàng năm, mọc thẳng, chần hoặc ngả ở gốc; cao tới 200 cm.\n" +
                            "- Thân cây: thân có rễ ở các mấu bên dưới, hình trụ, không có lông và chứa đầy cùi xốp màu trắng.\n" +
                            "- Lá: tuyến tính với gốc tròn rộng và đỉnh hẹp; phiến dài 10−40 cm; không có dây chằng.\n" +
                            "- Cụm hoa: dạng rời, màu lục đến tía, dài 10−25 cm bao gồm các cụm hoa kép; các bông hoa ít nhiều có hình elip và nhọn, thường hơi có lông; các lá nếu có, màu lục đến tía, dài 2−5 mm.",
                    "The common barnyard gas ropagates by seed. It flowers throughout the year and can produce seeds within 60 days.\n" +
                            "Echinochloa crus-galli prefers moist to wet land; easily grows in direct-seeded rice fields and wastelands. It is a common weed in swamps and aquatic places. ",
                    "Khí phổ biến trong chuồng lan truyền bằng hạt. Nó ra hoa quanh năm và có thể tạo hạt trong vòng 60 ngày.\n" +
                            "Lồng vực ưa đất ẩm ướt; dễ mọc trên ruộng gieo thẳng và đất hoang. Nó là một loại cỏ dại phổ biến ở đầm lầy và những nơi có nước.",
                    "It is a serious serious weed of lowland rice due to its rapid growth, competitive ability, and capacity to multiply rapidly. The young shoots are eaten in Java and it is used for reclaiming saline lands in Egypt. The weed serves as feed for animals in grasslands and wastelands.",
                    "Đây là một loại cỏ dại nghiêm trọng đối với lúa nước do tốc độ phát triển nhanh, khả năng cạnh tranh và khả năng nhân lên nhanh chóng. Chồi non được ăn ở Java và được sử dụng để khai hoang vùng đất nhiễm mặn ở Ai Cập. Cỏ dại dùng làm thức ăn cho động vật ở đồng cỏ và vùng đất hoang.",
                    "- Cultural control: Thorough land preparation for rice under wet or dry conditions can reduce infestations.It is difficult to distinguish the weed seedlings from rice at early stages, which makes hand weeding difficult.\n" +
                            "- Biological control: the fungal pathogen Exserohilum monoceras shown to control this weed.\n" +
                            "- Chemical control: Oxadiazon, pretilachlor, pendimethalin or cyhalofop, thiobencarb, butachlor, and propanil mixtures with quinclorac or fenoxaprop.",
                    "- Kiểm soát truyền thống: Chuẩn bị đất kỹ lưỡng cho lúa trong điều kiện ẩm ướt hoặc khô ráo có thể làm giảm sự phá hoại. Rất khó để phân biệt cỏ dại với lúa ở giai đoạn đầu, điều này gây khó khăn cho việc làm cỏ bằng tay.\n" +
                            "- Kiểm soát sinh học: mầm bệnh nấm Exserohilum monoceras có thể kiểm soát loại cỏ dại này.\n" +
                            "- Kiểm soát hóa học: Hỗn hợp oxadiazon, pretilachlor, pendimethalin hoặc cyhalofop, thiobencarb, butachlor và propanil với quinclorac hoặc fenoxaprop.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/weeds%2Fechinochloa_crus_galli.jpg?alt=media&token=f9650dc3-6cec-42ae-9949-5ee8effd3a46");
            weeds.add(weeds1);
            Weeds weeds2 = new Weeds("Leptochloa chinensis", "Cỏ đuôi phụng", "- Asia: Japan and Korea.\n" +
                    "- South and Southeast Asia: Bangladesh, Cambodia, India, Indonesia, Lao PDR, Malaysia, Myanmar, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Australia, Papua New Guinea, Swaziland, and West Africa.",
                    "- Châu Á: Nhật Bản và Hàn Quốc.\n" +
                            "- Nam và Đông Nam Á: Bangladesh, Campuchia, Ấn Độ, Indonesia, CHDCND Lào, Malaysia, Myanmar, Pakistan, Philippines, Sri Lanka, Thái Lan và Việt Nam.\n" +
                            "- Phần còn lại của thế giới: Úc, Papua New Guinea, Swaziland và Tây Phi.",
                    "A tufted and smooth annual or perennial; up to 120 cm tall.\n" +
                            "- Stem: slender, hollow, erect or ascending from a branching base, rooting at lower nodes, smooth and without hair, typically 10−20 nodes, and can reach as high as 50−100 cm.\n" +
                            "- Leaf: smooth, linear, 10−30 cm long; ligule an inconspicuous membrane 1−2 mm long and deeply divided into hairlike segments.\n" +
                            "- Inflorescence: narrowly ovate, loose panicle, main axis 10−40 cm long, and with many spike-like slender branches; racemes slender, each with two rows of spikelets, spikelets 2−3.2 mm long, purplish or green and 4−6 flowered.",
                    "Một loại cây hàng năm hoặc lâu năm có búi và nhẵn; cao tới 120 cm.\n" +
                            "- Thân cây: mảnh khảnh, rỗng, mọc thẳng hoặc tăng dần từ gốc phân nhánh, mọc rễ ở các đốt bên dưới, nhẵn và không có lông, thường có 10−20 đốt và có thể cao tới 50−100 cm.\n" +
                            "- Lá: nhẵn, thẳng, dài 10−30 cm; có dây chằng là một màng không rõ ràng dài 1−2 mm và được chia sâu thành các đoạn giống như lông.\n" +
                            "- Cụm hoa: hình trứng hẹp, chùy rời, trục chính dài 10−40 cm, có nhiều cành mảnh giống như cành; cụm hoa mảnh, mỗi cụm có hai hàng hoa con, hoa con dài 2−3,2 mm, màu tía hoặc xanh lục và 4− 6 bông hoa.",
                    "Red sprangletop propagates by seeds or vegetatively by rootstocks. Germination does not occur when seeds are submerged in water.",
                    "Cỏ đuôi phụng nhân giống bằng hạt hoặc sinh dưỡng bằng gốc ghép. Sự nảy mầm không xảy ra khi hạt bị ngập trong nước.",
                    "Leptochola chinensis is a serious weed of rice. Its ability to withstand waterlogged conditions as well as drained, moist conditions makes it a problem weed in rice.",
                    "Đuôi phụng là một loại cỏ dại nghiêm trọng trên lúa. Khả năng chịu được các điều kiện ngập úng cũng như thoát nước, ẩm ướt khiến nó trở thành một vấn đề cỏ dại trên lúa.",
                    "- Cultural control: rotovating and puddling of rice fields during land preparation; hand weeding can be effective during the early growth stages of the weed.\n" +
                            "- Chemical control: Quinclorac, propanil, pendimethalin, fenoxaprop, pretilachlor, or benthiocarb.",
                    "- Kiểm soát truyền thống: luân canh và xới xáo ruộng lúa trong quá trình làm đất; làm cỏ bằng tay có thể có hiệu quả trong giai đoạn phát triển ban đầu của cỏ dại.\n" +
                            "- Kiểm soát bằng hóa chất: Quinclorac, propanil, pendimethalin, fenoxaprop, pretilachlor hoặc benthiocarb.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/weeds%2Fleptochloa_chinensis.jpg?alt=media&token=16ee025f-6629-438b-8d7b-ffb187fccb3e");
            weeds.add(weeds2);
            Weeds weeds3 = new Weeds("Echinochloa colona", "Cỏ lồng vực cạn", "- Asia: China and Japan.\n" +
                    "- South and Southeast Asia: Bangladesh, Cambodia, India, Indonesia, Lao PDR, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Australia, Bolivia, Botswana, Costa Rica, Ecuador, El Salvador, France, Fiji, Guatemala, Honduras, Iraq, Italy, Kenya, Mexico, Nicaragua, Paraguay, Peru, Portugal, Senegal, Spain, Tanzania, Uganda, United States, Venezuela, West Africa, and Zambia.",
                    "- Châu Á: Trung Quốc và Nhật Bản.\n" +
                            "- Nam và Đông Nam Á: Bangladesh, Campuchia, Ấn Độ, Indonesia, CHDCND Lào, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thái Lan và Việt Nam.\n" +
                            "- Phần còn lại của thế giới: Úc, Bolivia, Botswana, Costa Rica, Ecuador, El Salvador, Pháp, Fiji, Guatemala, Honduras, Iraq, Ý, Kenya, Mexico, Nicaragua, Paraguay, Peru, Bồ Đào Nha, Senegal, Tây Ban Nha, Tanzania , Uganda, Hoa Kỳ, Venezuela, Tây Phi và Zambia.",
                    "A tufted annual grass, up to 60 cm tall.\n" +
                            "- Stem: reddish purple or green, ascending to erect, without hairs.\n" +
                            "- Leaf: linear, 10−15 cm long, basal portion often tinged with red; ligule absent.\n" +
                            "- Inflorescence: simple, ascending racemes, green to purple, about 5−15 cm long; spikelets subsessile 1−3 mm long.",
                    "Một loại cỏ hàng năm mọc thành búi, cao tới 60 cm.\n" +
                            "- Thân: màu tím đỏ hoặc xanh lục, mọc thẳng đứng, không có lông.\n" +
                            "- Lá: tuyến tính, dài 10−15 cm, phần gốc thường nhuốm màu đỏ; không có dây chằng.\n" +
                            "- Cụm hoa: đơn giản, mọc thành chùm tăng dần, màu lục đến tím, dài khoảng 5−15 cm; các bông hoa con không cuống dài 1−3 mm.",
                    "Echinochloa colona flowers throughout the year and is propagated by seeds. Seeds have a short dormancy period.\n" +
                            "It can be present in large numbers and responsive to nutrients. Prefers moist but unflooded conditions and is a problem mainly in upland and rainfed lowland rice fields rather than in flooded fields. ",
                    "Lồng vực cạn ra hoa quanh năm và được nhân giống bằng hạt. Hạt có thời gian ngủ đông ngắn.\n" +
                            "Nó có thể hiện diện với số lượng lớn và phản ứng nhanh với các chất dinh dưỡng. Thích điều kiện ẩm ướt nhưng không bị ngập úng và là vấn đề chủ yếu ở vùng cao và ruộng lúa vùng trũng được tưới nước mưa hơn là ở ruộng ngập nước.",
                    "It closely \"mimics\" rice in the vegetative growth stage and is a severe competitor of rice. It is a host of diseases such as tungro and rice yellow dwarf. It can be used as a palatable fodder for milking animals and water buffalo. ",
                    "Nó gần \"bắt chước\" cây lúa trong giai đoạn sinh trưởng sinh dưỡng và là đối thủ nặng ký của cây lúa. Nó là ký chủ của các bệnh như bệnh tungro và vàng lùn. Nó có thể được sử dụng làm thức ăn ngon cho động vật vắt sữa và trâu nước .",
                    "- Cultural control: flooding; hand weeding or use of a hoe during early growth stages.\n" +
                            "- Chemical control: preemergence application of oxadiazon or pendimethalin or postemergence application of cyhalofop, butachlor, and fenoxaprop can be effective. ",
                    "- Kiểm soát truyền thống: lũ lụt; làm cỏ bằng tay hoặc sử dụng cuốc trong giai đoạn tăng trưởng ban đầu.\n" +
                            "- Kiểm soát hóa học: phun trước chồi oxadiazon hoặc pendimethalin hoặc phun sau chồi mầm cyhalofop, butachlor và fenoxaprop có thể có hiệu quả.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/weeds%2Fechinochloa_colona.jpg?alt=media&token=34c62ca8-cebc-4995-a454-93a0bc914df1");
            weeds.add(weeds3);
            Weeds weeds4 = new Weeds("Fimbristylis miliacea", "Cỏ chác", "- South and Southeast Asia: Bangladesh, Bhutan, Cambodia, India, Indonesia Lao PDR, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Ecuador, Madagascar, Nicaragua, Peru, and Suriname. ",
                    "- Nam và Đông Nam Á: Bangladesh, Bhutan, Campuchia, Ấn Độ, Indonesia, CHDCND Lào, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thái Lan và Việt Nam.\n" +
                            "- Phần còn lại của thế giới: Ecuador, Madagascar, Nicaragua, Peru và Suriname.",
                    "Annual or perennial, without hairs, strongly tillering, with fibrous roots and up to 80−90 cm high.\n" +
                            "- Stem: slender, erect, densely tufted, compressed, and smooth; strongly angled at the top and flattened at the base; 20−70 cm tall.\n" +
                            "- Leaf: stiff and thread-like; on flowerless stems: in 2 rows and with flattened sheaths; no prominent midribs; on flowering stems: only linear leaf sheaths; basal leaves have overlapping leaf sheaths; ligule absent.\n" +
                            "- Inflorescence: 6−10 cm long, compound umbel with 6−50 spikelets; spikelets reddish brown, 2−4 mm long and either round or acute at apex.\n" +
                            "- Fruit: straw-coloured or pale ivory nut, 0.2−0.3 mm long.",
                    "Hàng năm hoặc lâu năm, không có lông, đẻ nhánh mạnh, có rễ xơ và cao tới 80−90 cm.\n" +
                            "- Thân cây: mảnh khảnh, mọc thẳng, có nhiều búi, nén và nhẵn; góc cạnh mạnh ở đỉnh và dẹt ở gốc; cao 20−70 cm.\n" +
                            "- Lá: cứng và giống như sợi chỉ; trên thân không có hoa: xếp thành 2 hàng và có bẹ dẹt; không có gân giữa nổi rõ; trên thân có hoa: chỉ có bẹ lá thẳng; các lá ở gốc có các bẹ lá chồng lên nhau; không có dây chằng.\n" +
                            "- Cụm hoa: Dài 6−10 cm, hình tán kép với 6−50 bông hoa; bông hoa màu nâu đỏ, dài 2−4 mm và tròn hoặc nhọn ở đỉnh.\n" +
                            "- Quả: màu rơm hoặc màu ngà nhạt, dài 0,2−0,3 mm.",
                    "Propagates by seeds; flowers year-round and produces 10,000 seeds per plant; seeds can germinate immediately after reaching maturity.\n" +
                            "In rice fields, seedlings appear soon after the rice is sown; flower in about one month and are capable of producing a second generation in the same season. Germinates where flood water is shallow or absent and seedlings may emerge throughout the entire growing period of rice. ",
                    "Nhân giống bằng hạt; ra hoa quanh năm và tạo ra 10.000 hạt trên mỗi cây; hạt có thể nảy mầm ngay sau khi trưởng thành.\n" +
                            "Trên ruộng lúa, mạ xuất hiện ngay sau khi lúa gieo, trổ bông sau khoảng một tháng và có khả năng ra lứa thứ hai trong cùng một vụ. Nảy mầm nơi nước cạn hoặc không có nước lũ và có thể trổ bông trong suốt thời gian sinh trưởng của lúa.",
                    "It is a serious and widespread weed of rice. An alternate host of diseases Rhizoctonia solani, Thanatephorus cucumeris, and Xanthomonas campestris pv. oryzae, insects Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), and Mythimna separata (Walker), and nematodes Hirschmanniella sp. and Meloidogyne spp. ",
                    "Đây là một loại cỏ dại nghiêm trọng và phổ biến trên lúa. Là vật chủ luân phiên của các bệnh Rhizoctonia solani, Thanatephorus cucumeris, và Xanthomonas campestris pv. oryzae, côn trùng Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), và Mythimna separata (Walker) và tuyến trùng Hirschmanniella sp. và Meloidogyne spp.",
                    "- Cultural control: hand cultivation.\n" +
                            "- Chemical control: postemergence application of MCPA and 2,4-D reported to be effective in rice. ",
                    "- Kiểm soát văn hóa: canh tác thủ công.\n" +
                            "- Kiểm soát hóa học: ứng dụng MCPA và 2,4-D sau khi nảy mầm được báo cáo là có hiệu quả trên lúa.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/weeds%2Ffimbristylis_miliacea.jpg?alt=media&token=38592891-39db-44c1-8c60-e384cc19db66");
            weeds.add(weeds4);
            Weeds weeds5 = new Weeds("Cyperus iria", "Cỏ lác rận", "- Asia: China (including Taiwan), Japan, and Korea.\n" +
                    "- South and Southeast Asia: Bangladesh, Cambodia, India, Indonesia, Lao PDR, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Australia, Fiji, Swaziland, West Africa.",
                    "- Châu Á: Trung Quốc (bao gồm cả Đài Loan), Nhật Bản và Hàn Quốc.\n" +
                            "- Nam và Đông Nam Á: Bangladesh, Campuchia, Ấn Độ, Indonesia, CHDCND Lào, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thái Lan và Việt Nam.\n" +
                            "- Phần còn lại của thế giới: Úc, Fiji, Swaziland, Tây Phi.",
                    "It is a tufted annual herb, or occasionally perennial, with fibrous roots, 15−75 yellowish red roots, 10−70 cm tall.\n" +
                            "- Stem: sharply 3-angled, tufted, smooth, 5−80 cm high.\n" +
                            "- Leaf: basal, rough to touch in the upper part, linear, flaccid, with gradual tapering point and 3−8 mm wide; sheath reddish or purplish brown, enveloping the stem at the base.\n" +
                            "- Inflorescence: simple or compound umbel composed of numerous erect-spreading 3−10 mm long flattened spikelets.\n" +
                            "- Fruit: three-angled, 1.0−1.5 mm nut with slightly concave sides and shiny dark brown to black.",
                    "Đó là một loại thảo mộc hàng năm mọc thành búi, hoặc đôi khi là lâu năm, có rễ dạng sợi, 15−75 rễ màu đỏ hơi vàng, cao 10−70 cm.\n" +
                            "- Thân: nhọn 3 góc, có chần, nhẵn, cao 5−80 cm.\n" +
                            "- Lá: gốc, thô khi chạm vào ở phần trên, tuyến tính, mềm, có điểm thuôn nhọn dần và rộng 3−8 mm; vỏ bọc màu nâu đỏ hoặc nâu tía, bao bọc thân ở gốc.\n" +
                            "- Cụm hoa: hình tán đơn hoặc phức hợp bao gồm nhiều bông con dẹt dài 3−10 mm mọc thẳng đứng.\n" +
                            "- Quả: hạt có ba góc, đường kính 1,0−1,5 mm với các cạnh hơi lõm và có màu nâu sẫm đến đen bóng.",
                    "The weed thrives in wetland rice, annual dryland crops, and plantation crops.\n" +
                            "Rice flatsedge or umbrella sedge multiplies rapidly: can produce 3,000−5,000 seeds per plant, seedlings emerge immediately after rice is sown, flowers month later and can establish second generation in the same season. It flowers throughout the year.",
                    "Cỏ dại phát triển mạnh trên lúa nước, cây trồng hàng năm trên đất khô hạn và cây trồng.\n" +
                            "Cói lúa hoặc cói ô nhân giống nhanh: có thể cho 3.000−5.000 hạt trên mỗi cây, cây con xuất hiện ngay sau khi lúa được gieo, ra hoa sau đó một tháng và có thể tạo thế hệ thứ hai trong cùng một mùa. Nó ra hoa quanh năm.",
                    "An important and widespread weed in South and Southeast Asia. Ovipositional host of the insects Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), Marasmia exigua (Butler), Mythimna separata (Walker), Nilaparvata lugens (Stål), Nisia carolinensis Fennah, Pseudococcus saccharicola Takahashi, Recilia dorsalis (Motschulsky), Spodoptera mauritia acronyctoides (Guenee), and Stenchaetothrips biformis (Bagnall), diseases Pyricularia oryzae, Rhizoctonia solani, and Sarocladium oryzae, and nematodes Circonemella onoensis, Hirschmanniella oryzae, and Pratylenchus indicus.",
                    "Một loại cỏ dại quan trọng và phổ biến ở Nam và Đông Nam Á. Vật chủ đẻ trứng của côn trùng Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), Marasmia exigua (Butler), Mythimna separata (Walker), Nilaparvata lugens (Stål), Nisia carolinensis Fennah, Pseudococcus saccharicola Takahashi, Recilia dorsalis (Motschulsky), Spodoptera mauritia acronyctoides (Guenee), và Stenchaetothrips biformis (Bagnall), các bệnh Pyricularia oryzae, Rhizoctonia solani, và Sarocladium oryzae, và tuyến trùng Circonemella onoensis, Hirschmanniella oryzae, và Pratylenchus indicus.",
                    "- Cultural control: hand weeding at an earlier stage of growth to prevent flowering and seed production; rotary weeding in transplanted rice during the seedling stage.\n" +
                            "- Chemical control: Butachlor or oxadiazon after harrowing and sowing of rice and chlorimuron, propanil, or MCPA after emergence.",
                    "- Kiểm soát văn hóa: làm cỏ bằng tay ở giai đoạn đầu của quá trình sinh trưởng để ngăn chặn quá trình ra hoa và tạo hạt; làm cỏ quay vòng trên lúa cấy trong giai đoạn cây con.\n" +
                            "- Kiểm soát bằng hóa chất: Butachlor hoặc oxadiazon sau khi bừa và gieo lúa và chlorimuron, propanil hoặc MCPA sau khi trổ.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/weeds%2Fcyperus_iria.jpg?alt=media&token=77832e52-ae94-414d-8e07-f3a6d991e87b");
            weeds.add(weeds5);
            Weeds weeds6 = new Weeds("Eclipta prostrata", "Cỏ mực", "- Asia: China (including Taiwan), Japan, and Korea.\n" +
                    "- South and Southeast Asia: Bangladesh, India, Indonesia, Cambodia, Lao PDR, Malaysia, Nepal, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Angola, Arabian Peninsula, Argentina, Australia, Brazil, Colombia, Costa Rica, Cote d'Ivoire, Cuba, Egypt, Fiji, Ghana, Iraq, Mexico, Peru, Portugal, Puerto Rico, Rhodesia, Sudan, Surinam, Trinidad, United States of America (including Hawaii), Zambia, and Zimbabwe.",
                    "- Châu Á: Trung Quốc (bao gồm cả Đài Loan), Nhật Bản và Hàn Quốc.\n" +
                            "- Nam và Đông Nam Á: Bangladesh, Ấn Độ, Indonesia, Campuchia, CHDCND Lào, Malaysia, Nepal, Pakistan, Philippines, Sri Lanka, Thái Lan và Việt Nam.\n" +
                            "- Phần còn lại của thế giới: Angola, Bán đảo Ả Rập, Argentina, Úc, Brazil, Colombia, Costa Rica, Côte d'Ivoire, Cuba, Ai Cập, Fiji, Ghana, Iraq, Mexico, Peru, Bồ Đào Nha, Puerto Rico, Rhodesia, Sudan , Surinam, Trinidad, Hợp chủng quốc Hoa Kỳ (bao gồm Hawaii), Zambia và Zimbabwe.",
                    "A prostrate or reclining to erect, often branched, annual or perennial herb, 30−100 cm tall.\n" +
                            "- Stem: cylindrical, green or purplish, rooting at basal nodes, and often covered with long white hairs.\n" +
                            "- Leaf: oblong to lance-shaped, opposite, sessile or short-stalked, with more or less coarse hairs; margins entire or slightly toothed, up to 2−16 cm long.\n" +
                            "- Inflorescence: terminal and axillary, about 1 cm across, white or cream, on peduncles to 7 cm long.\n" +
                            "- Fruit: achene, densely warted, either brown or black, 2−3 mm long.",
                    "Một loại thảo mộc mọc nghiêng hoặc ngả để mọc thẳng, thường phân nhánh, hàng năm hoặc lâu năm, cao 30−100 cm.\n" +
                            "- Thân cây: hình trụ, màu xanh lục hoặc tía, có rễ ở các đốt ở gốc và thường được bao phủ bởi lớp lông dài màu trắng.\n" +
                            "- Lá: thuôn dài đến hình mác, mọc đối, không cuống hoặc có cuống ngắn, ít nhiều có lông thô; mép nguyên hoặc hơi có răng, dài tới 2−16 cm.\n" +
                            "- Cụm hoa: ở đầu và nách lá, đường kính khoảng 1 cm, màu trắng hoặc kem, trên các chùm hoa dài tới 7 cm.\n" +
                            "- Quả: achene, có nhiều mụn cóc, màu nâu hoặc đen, dài 2−3 mm.",
                    "It is widespread and has adapted to a range of environments. It is found in poorly drained wet areas, saline conditions, along streams, in drains and canals of irrigated lowland rice paddies, in waste areas, and in upland fields.\n" +
                            "A single plant can produce as many as 17,000 seeds; germination is affected by light, moisture level, pH, and temperature, but seeds have no dormancy.",
                    "Nó phổ biến rộng rãi và đã thích nghi với nhiều loại môi trường. Nó được tìm thấy ở những vùng ẩm ướt thoát nước kém, điều kiện nhiễm mặn, dọc theo suối, trong cống rãnh và kênh rạch của những cánh đồng lúa ở vùng đất thấp được tưới tiêu, ở những vùng đất hoang và trên nương rẫy.\n" +
                            "Một cây duy nhất có thể tạo ra tới 17.000 hạt; sự nảy mầm bị ảnh hưởng bởi ánh sáng, độ ẩm, độ pH và nhiệt độ, nhưng hạt không có trạng thái ngủ.",
                    "An important and widespread weed in South and Southeast Asia. Ovipositional host of the insects Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), Marasmia exigua (Butler), Mythimna separata (Walker), Nilaparvata lugens (Stål), Nisia carolinensis Fennah, Pseudococcus saccharicola Takahashi, Recilia dorsalis (Motschulsky), Spodoptera mauritia acronyctoides (Guenee), and Stenchaetothrips biformis (Bagnall), diseases Pyricularia oryzae, Rhizoctonia solani, and Sarocladium oryzae, and nematodes Circonemella onoensis, Hirschmanniella oryzae, and Pratylenchus indicus.",
                    "Một loại cỏ dại quan trọng và phổ biến ở Nam và Đông Nam Á. Vật chủ đẻ trứng của côn trùng Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), Marasmia exigua (Butler), Mythimna separata (Walker), Nilaparvata lugens (Stål), Nisia carolinensis Fennah, Pseudococcus saccharicola Takahashi, Recilia dorsalis (Motschulsky), Spodoptera mauritia acronyctoides (Guenee), và Stenchaetothrips biformis (Bagnall), các bệnh Pyricularia oryzae, Rhizoctonia solani, và Sarocladium oryzae, và tuyến trùng Circonemella onoensis, Hirschmanniella oryzae, và Pratylenchus indicus.",
                    "- Cultural control: cultivation and hand weeding.\n" +
                            "- Chemical control: preemergence application of oxadiazon or postemergence spraying of either 2,4-D or MCPA reported to be effective. ",
                    "- Kiểm soát văn hóa: canh tác và làm cỏ bằng tay.\n" +
                            "- Kiểm soát hóa học: phun oxadiazon trước khi mọc hoặc phun sau khi mọc của 2,4-D hoặc MCPA được báo cáo là có hiệu quả.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/weeds%2Feclipta_prostrata.jpg?alt=media&token=fe60cc81-541a-43b7-9cdf-4a4dc4f92423");
            weeds.add(weeds6);
            for (Weeds w : weeds) {
                weedDao.insert(w);
            }

            //****Crops-Weeds****
            CropWeedDao cropWeedDao = db.cropWeedDao();
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 18"), weedDao.getIdByName("Echinochloa crus-galli")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 18"), weedDao.getIdByName("Leptochloa chinensis")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 18"), weedDao.getIdByName("Echinochloa colona")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 18"), weedDao.getIdByName("Fimbristylis miliacea")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 18"), weedDao.getIdByName("Cyperus iria")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 18"), weedDao.getIdByName("Eclipta prostrata")));

            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT 08"), weedDao.getIdByName("Echinochloa crus-galli")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT 08"), weedDao.getIdByName("Leptochloa chinensis")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT 08"), weedDao.getIdByName("Echinochloa colona")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT 08"), weedDao.getIdByName("Fimbristylis miliacea")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT 08"), weedDao.getIdByName("Cyperus iria")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT 08"), weedDao.getIdByName("Eclipta prostrata")));

            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 5451"), weedDao.getIdByName("Echinochloa crus-galli")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 5451"), weedDao.getIdByName("Leptochloa chinensis")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 5451"), weedDao.getIdByName("Echinochloa colona")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 5451"), weedDao.getIdByName("Fimbristylis miliacea")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 5451"), weedDao.getIdByName("Cyperus iria")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM 5451"), weedDao.getIdByName("Eclipta prostrata")));

            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("IR 50404"), weedDao.getIdByName("Echinochloa crus-galli")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("IR 50404"), weedDao.getIdByName("Leptochloa chinensis")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("IR 50404"), weedDao.getIdByName("Echinochloa colona")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("IR 50404"), weedDao.getIdByName("Fimbristylis miliacea")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("IR 50404"), weedDao.getIdByName("Cyperus iria")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("IR 50404"), weedDao.getIdByName("Eclipta prostrata")));

            //****Weeds-Pesticides****
            WeedPesticideDao weedPesticideDao = db.weedPesticideDao();
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Elano 20EC"), weedDao.getIdByName("Echinochloa crus-galli")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Elano 20EC"), weedDao.getIdByName("Leptochloa chinensis")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Elano 20EC"), weedDao.getIdByName("Echinochloa colona")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Sofit 300EC"), weedDao.getIdByName("Echinochloa colona")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Sofit 300EC"), weedDao.getIdByName("Leptochloa chinensis")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Sofit 300EC"), weedDao.getIdByName("Echinochloa crus-galli")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Sofit 300EC"), weedDao.getIdByName("Fimbristylis miliacea")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Sofit 300EC"), weedDao.getIdByName("Cyperus iria")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Sofit 300EC"), weedDao.getIdByName("Eclipta prostrata")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Dual Gold 96EC"), weedDao.getIdByName("Echinochloa colona")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Dual Gold 96EC"), weedDao.getIdByName("Leptochloa chinensis")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Dual Gold 96EC"), weedDao.getIdByName("Echinochloa crus-galli")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Dual Gold 96EC"), weedDao.getIdByName("Fimbristylis miliacea")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Dual Gold 96EC"), weedDao.getIdByName("Cyperus iria")));
            weedPesticideDao.insert(new WeedsPesticides(pesticideDao.getIdByName("Dual Gold 96EC"), weedDao.getIdByName("Eclipta prostrata")));

            //*****Deficiencies and toxicities*****
            DeficienciesToxicitiesDao deficienciesToxicitiesDao = db.deficienciesToxicitiesDao();
            ArrayList<DeficienciesToxicities> deficienciesToxicities = new ArrayList<>();
            DeficienciesToxicities deficienciesToxicities1 = new DeficienciesToxicities("Nitrogen (N) deficiency", "Thiếu đạm (N)", "Check the field for abnormalities. N deficient crops are stunted and discoloured. Specifically:\n" +
                    "- Older leaves or whole plants are yellowish green.\n" +
                    "- Old leaves and sometimes all leaves become light green and chlorotic at the tip.\n" +
                    "-  Entire field may appear yellowish.\n" +
                    "\n" +
                    "Check the leaves for the following symptoms:\n" +
                    "- Leaves can die under severe N stress. Except for young leaves, which are greener, leaves of nitrogen-deficient plants are narrow, small, short, erect, and lemon-yellowish green.\n" +
                    "- Other symptoms are reduced tillering and reduced grain number.",
                    "Kiểm tra đồng ruộng xem có bất thường không. Cây trồng thiếu N bị còi cọc và đổi màu. Cụ thể:\n" +
                            "- Lá già hoặc toàn bộ cây có màu xanh vàng.\n" +
                            "- Lá già và đôi khi tất cả các lá chuyển sang màu xanh nhạt và nhiễm clo ở đầu.\n" +
                            "- Toàn bộ trường có thể hơi vàng.\n" +
                            "\n" +
                            "Kiểm tra lá để tìm các triệu chứng sau:\n" +
                            "- Lá có thể chết dưới áp lực N nghiêm trọng. Ngoại trừ lá non xanh hơn, lá của cây thiếu đạm hẹp, nhỏ, ngắn, mọc thẳng và có màu xanh vàng chanh.\n" +
                            "- Các triệu chứng khác là giảm đẻ nhánh và giảm số hạt.",
                    "Nitrogen deficiency is one of the most common problems in rice in Asia. It is common in all rice-growing soils where modern varieties are grown without sufficient mineral N fertilizer. Nitrogen-deficient crops have low yields.\n" +
                            "It often occurs at critical growth stages of the plant, such as tillering and panicle initiation, when the demand for nitrogen is large.\n" +
                            "Nitrogen deficiency may also occur when a large amount of N fertilizer has been applied but at the wrong time or in the wrong way. Soils particularly prone to N deficiency include the following types:\n" +
                            "- Soils with very low soil organic matter content.\n" +
                            "- Soils with particular constraints to indigenous N supply (e.g., acid sulfate soils, saline soils, Phosphorus (P)-deficient soils, poorly drained wetland soils).\n" +
                            "- Alkaline and calcareous soils with low soil organic matter status and a high potential for ammonia (NH3) volatilization losses.",
                    "Thiếu đạm là một trong những vấn đề phổ biến nhất đối với cây lúa ở châu Á. Tình trạng này phổ biến ở tất cả các loại đất trồng lúa nơi các giống hiện đại được trồng mà không có đủ phân khoáng N. Cây trồng thiếu đạm có năng suất thấp.\n" +
                            "Nó thường xảy ra ở các giai đoạn tăng trưởng quan trọng của cây trồng, chẳng hạn như đẻ nhánh và bắt đầu tạo bông, khi nhu cầu về nitơ lớn.\n" +
                            "Thiếu đạm cũng có thể xảy ra khi bón một lượng lớn phân N nhưng không đúng lúc hoặc sai cách. Các loại đất đặc biệt dễ bị thiếu N bao gồm các loại sau:\n" +
                            "- Đất có hàm lượng chất hữu cơ rất thấp.\n" +
                            "- Các loại đất có hạn chế đặc biệt đối với nguồn cung cấp N bản địa (ví dụ: đất phèn, đất mặn, đất thiếu phốt pho (P), đất ngập nước thoát nước kém).\n" +
                            "- Đất kiềm và đất đá vôi với tình trạng chất hữu cơ trong đất thấp và khả năng thất thoát amoniac (NH3) cao.",
                    "To manage nitrogen deficiency:\n" +
                            "- Apply N fertilizer efficiently.\n" +
                            "- Do not apply large amounts of N to less responsive varieties.\n" +
                            "- Hybrid rice absorbs mineral N more efficiently than inbred rice varieties.\n" +
                            "- Choose a suitable plant spacing for each cultivar. Crops with suboptimal plant densities do not use fertilizer N efficiently.\n" +
                            "- Adjust the number of splits and timing of N applications according to the crop establishment method. Transplanted and direct-seeded rice require different N management strategies.\n" +
                            "- Maintain proper water control, i.e., keep the field flooded to prevent denitrification but avoid N losses from water runoff over bunds immediately following fertilizer application.\n" +
                            "- Establish a dense, healthy rice crop by using high-quality seeds of a high-yielding variety with multiple pest resistance and a suitable plant density.\n" +
                            "- Control weeds that compete with rice for N.",
                    "Để kiểm soát tình trạng thiếu nitơ:\n" +
                            "- Bón phân N hiệu quả.\n" +
                            "- Không bón lượng lớn N cho các giống kém phản ứng.\n" +
                            "- Lúa lai hấp thụ khoáng N hiệu quả hơn lúa lai.\n" +
                            "- Chọn khoảng cách cây phù hợp cho từng giống. Cây trồng có mật độ cây dưới mức tối ưu sẽ không sử dụng phân N hiệu quả.\n" +
                            "- Điều chỉnh số lần phân chia và thời gian bón N theo phương pháp thiết lập cây trồng. Lúa cấy và gieo thẳng yêu cầu các chiến lược quản lý N khác nhau.\n" +
                            "- Duy trì kiểm soát nước hợp lý, tức là giữ cho ruộng ngập nước để ngăn chặn quá trình khử nitrat nhưng tránh thất thoát N do nước chảy tràn qua bờ ngay sau khi bón phân.\n" +
                            "- Thiết lập một vụ lúa dày đặc, khỏe mạnh bằng cách sử dụng hạt giống chất lượng cao của giống năng suất cao, kháng nhiều loại sâu bệnh và mật độ cây trồng phù hợp.\n" +
                            "- Kiểm soát cỏ dại cạnh tranh N với lúa.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/deficiencies_toxicities%2Fnitrogen_(N)_deficiency.jpg?alt=media&token=2d31be96-34bf-4f7b-a654-71237b2d3fa0");
            deficienciesToxicities.add(deficienciesToxicities1);

            DeficienciesToxicities deficienciesToxicities2 = new DeficienciesToxicities("Nitrogen (N) excess", "Thừa đạm (N)", "Fields with excessive nitrogen have plants that:\n" +
                    "- Look overly green\n" +
                    "- May be healthy, but also may be lodged at maturity (especially in direct-seeded rice)\n" +
                    "- May have thin stems\n" +
                    "- May be prone to disease (e.g., bacterial leaf blight, sheath blight, blast) or insects (leaffolder)\n" +
                    "There can also be patchy patterns resulting from uneven application across the field.",
                    "Những cánh đồng có quá nhiều nitơ có những loại cây:\n" +
                            "- Nhìn xanh quá\n" +
                            "- Có thể khoẻ, nhưng cũng có thể bị lép khi chín (nhất là lúa sạ thẳng)\n" +
                            "- Có thể có thân mỏng\n" +
                            "- Có thể dễ bị bệnh (ví dụ: bệnh bạc lá do vi khuẩn, bệnh khô vằn, đạo ôn) hoặc côn trùng (sâu cuốn lá)\n" +
                            "Cũng có thể có các mẫu chắp vá do ứng dụng không đồng đều trên toàn trường.",
                    "Problems in excess N happen when fertilizers are relatively cheap, and farmers do not understand the correct amount of nitrogen required relative to their yield goals and the right time of N application.\n" +
                            "Excessive N causes \"luxuriant\" growth, resulting in the plant being attractive to insects and/or diseases/pathogens. The excessive growth can also reduce stem strength resulting in lodging during flowering and grain filling.\n" +
                            "Excessive use of N also has negative implications for the environment and lowers farm profits.",
                    "Các vấn đề về dư thừa N xảy ra khi phân bón tương đối rẻ và nông dân không hiểu chính xác lượng nitơ cần thiết so với mục tiêu năng suất của họ và thời điểm bón N thích hợp.\n" +
                            "Quá nhiều N gây ra sự phát triển \"tươi tốt\", khiến cây trở nên hấp dẫn đối với côn trùng và/hoặc bệnh/mầm bệnh. Sự phát triển quá mức cũng có thể làm giảm sức mạnh của thân dẫn đến hiện tượng đổ rạp trong quá trình ra hoa và làm đầy hạt.\n" +
                            "Việc sử dụng quá nhiều N cũng có tác động tiêu cực đến môi trường và làm giảm lợi nhuận của trang trại.",
                    "To manage nitrogen excess:\n" +
                            "- Apply sufficient N to meet the plants' needs (20 kg N for each t of grain produced).\n" +
                            "- Identify how much N is coming from the soil and other sources (e.g., water or bacteria in the soil or water) and then apply the additional N to meet the yield goal.",
                    "Để quản lý lượng nitơ dư thừa:\n" +
                            "- Bón đủ N để đáp ứng nhu cầu của cây trồng (20 kg N cho mỗi tấn hạt được tạo ra).\n" +
                            "- Xác định lượng N đến từ đất và các nguồn khác (ví dụ: nước hoặc vi khuẩn trong đất hoặc nước) và sau đó bón thêm N để đáp ứng mục tiêu năng suất.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/deficiencies_toxicities%2Fnitrogen_(N)_excess.jpg?alt=media&token=f5c7b578-425f-411e-aa3b-182e7e4237ba");
            deficienciesToxicities.add(deficienciesToxicities2);

            DeficienciesToxicities deficienciesToxicities3 = new DeficienciesToxicities("Phosphorus (P) deficiency", "Thiếu phốt pho (P)", "Check the field for the following symptoms:\n" +
                    "- Stunted plants\n" +
                    "- Reduced tillering\n" +
                    "- Older leaves are narrow, short, very erect, and have a \"dirty\" dark green colour\n" +
                    "- Stems are thin and spindly, and plant development is retarded\n" +
                    "- The number of leaves, panicles, and grains per panicle is also reduced. Young leaves may appear to be healthy, but older leaves turn brown and die.\n" +
                    "\n" +
                    "Also, check for discolouration:\n" +
                    "- Leaves appear pale green when P and Nitrogen (N) deficiency occur simultaneously\n" +
                    "- Red and purple colours may develop in leaves if the variety has a tendency to produce anthocyanin",
                    "Kiểm tra trường để biết các triệu chứng sau:\n" +
                            "- Cây còi cọc\n" +
                            "- Giảm đẻ nhánh\n" +
                            "- Lá già hẹp, ngắn, mọc rất thẳng và có màu xanh đậm \"bẩn\"\n" +
                            "- Thân cây mỏng và khẳng khiu, cây chậm phát triển\n" +
                            "- Số lá, bông và số hạt trên bông cũng giảm đi. Các lá non có thể trông khỏe mạnh nhưng các lá già chuyển sang màu nâu và chết.\n" +
                            "\n" +
                            "Ngoài ra, hãy kiểm tra sự đổi màu:\n" +
                            "- Lá có màu xanh nhạt khi xảy ra đồng thời tình trạng thiếu P và Nitơ (N)\n" +
                            "- Màu đỏ và tím có thể phát triển trên lá nếu giống có xu hướng sản xuất anthocyanin",
                    "Phosphorus deficiency is widespread in all major rice ecosystems and is the major growth-limiting factor in acid upland soils where soil P-fixation capacity is often large.\n" +
                            "\n" +
                            "Soils particularly prone to P deficiency include the following types:\n" +
                            "- Coarse-textured soils containing small amounts of organic matter and small P reserves (e.g., sandy soils in northeast Thailand, and Cambodia)\n" +
                            "- Highly weathered, clayey, acid upland soils with high P-fixation capacity (e.g., Ultisols and Oxisols in many countries\n" +
                            "- Degraded lowland soils (e.g., North Vietnam)\n" +
                            "- Calcareous, saline, and sodic soils\n" +
                            "- Volcanic soils with high P-sorption capacity (e.g., Andisols in Japan and parts of Sumatra and Java)\n" +
                            "- Peat soils (Histosols)\n" +
                            "- Acid sulfate soils in which large amounts of active Al and Fe result in the formation of insoluble P compounds at low pH",
                    "Sự thiếu hụt phốt pho phổ biến trong tất cả các hệ sinh thái lúa chính và là yếu tố hạn chế tăng trưởng chính ở đất vùng cao chua, nơi khả năng cố định phốt pho của đất thường lớn.\n" +
                            "\n" +
                            "Đất đặc biệt dễ bị thiếu P bao gồm các loại sau:\n" +
                            "- Đất có kết cấu thô chứa một lượng nhỏ chất hữu cơ và trữ lượng P nhỏ (ví dụ: đất cát ở đông bắc Thái Lan và Campuchia)\n" +
                            "- Đất vùng cao bị phong hóa, nhiều sét, chua với khả năng cố định P cao (ví dụ: Ultisols và Oxisols ở nhiều quốc gia\n" +
                            "- Đất thấp bị thoái hóa (ví dụ: Bắc Việt Nam)\n" +
                            "- Đất đá vôi, đất mặn và sodic\n" +
                            "- Đất núi lửa có khả năng hấp thụ P cao (ví dụ: Andisols ở Nhật Bản và một phần của Sumatra và Java)\n" +
                            "- Đất than bùn (Histosols)\n" +
                            "- Đất phèn trong đó một lượng lớn Al và Fe hoạt động dẫn đến sự hình thành các hợp chất P không hòa tan ở pH thấp",
                    "To manage phosphorus deficiency:\n" +
                            "- Use high-quality seeds of a high-yielding variety.\n" +
                            "- Use rice cultivars that use P efficiently, particularly on acid upland soils.\n" +
                            "- In rice-rice systems, carry out dry, shallow tillage (10 cm) within two weeks after harvest. On acid, low-fertility rainfed lowland and upland soils, all existing soil fertility problems (acidity, Al toxicity, and deficiencies of Magnesium, Potassium, and other nutrients) must be corrected before a response to P is obtained.\n" +
                            "- Incorporate rice straw. Although the total amount of P recycled with the straw is small (1 kg P t-1 straw), it will contribute to maintaining a positive P balance in the long term.\n" +
                            "- Apply optimum doses of N and K and correct micronutrient deficiencies.\n" +
                            "- Replenish P removed in crop products by applying P fertilizers, farmyard manure, or other materials (night soil, compost).\n" +
                            "- Apply fertilizers efficiently.",
                    "Để kiểm soát tình trạng thiếu phốt pho:\n" +
                            "- Sử dụng hạt giống chất lượng cao của giống năng suất cao.\n" +
                            "- Sử dụng giống lúa sử dụng P hiệu quả, đặc biệt trên đất chua.\n" +
                            "- Trong hệ thống lúa-lúa, tiến hành làm đất khô, cạn (10 cm) trong vòng hai tuần sau khi thu hoạch. Trên đất trũng và đất nương bị chua, có độ phì nhiêu thấp, tất cả các vấn đề về độ phì nhiêu của đất hiện có (độ chua, độc tính của Al, và sự thiếu hụt của Magiê, Kali và các chất dinh dưỡng khác) phải được điều chỉnh trước khi thu được phản ứng với P.\n" +
                            "- Kết hợp rơm rạ. Mặc dù tổng lượng P được tái chế bằng rơm là nhỏ (1 kg P trên 1 ống hút), nhưng nó sẽ góp phần duy trì cân bằng P dương trong thời gian dài.\n" +
                            "- Áp dụng liều lượng N và K tối ưu và khắc phục tình trạng thiếu vi chất dinh dưỡng.\n" +
                            "- Bổ sung P bị loại bỏ trong các sản phẩm cây trồng bằng cách bón phân P, phân chuồng hoặc các vật liệu khác (đất ủ, phân hữu cơ).\n" +
                            "- Bón phân hiệu quả.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/deficiencies_toxicities%2Fphosphorus_(P)_deficiency.jpg?alt=media&token=3af41f35-1823-405c-8e6c-c657a257389f");
            deficienciesToxicities.add(deficienciesToxicities3);

            DeficienciesToxicities deficienciesToxicities4 = new DeficienciesToxicities("Potassium (K) deficiency", "Thiếu kali (K)", "Check the plants for discolouration:\n" +
                    "- Dark green plants with yellowish brown leaf margins or dark brown necrotic spots appearing first on the tip of older leaves\n" +
                    "- Yellowish brown leaf tips, when under severe K deficiency\n" +
                    "- Older leaves change from yellow to brown\n" +
                    "- Yellow stripes may appear along leaf intervein's and lower leaves may bend downward\n" +
                    "- Discoloration gradually appears on younger leaves if deficiency is not corrected.\n" +
                    "\n" +
                    "Other signs and symptoms of K deficiency include:\n" +
                    "- Rusty brown spots on the tips of older leaves that later spread over the whole leaf causing it to turn brown and dry if K deficiency is severe\n" +
                    "- Irregular necrotic spots may also occur on panicles\n" +
                    "- Stunted plants with smaller leaves, short and thin stems\n" +
                    "- Reduced tillering under very severe deficiency\n" +
                    "- Greater incidence of lodging\n" +
                    "- Early leaf senescence, leaf wilting, and leaf rolling when the temperature is high, and humidity is low\n" +
                    "- A large percentage of sterile or unfilled spikelets\n" +
                    "- Unhealthy root system (many black roots, reduced root length and density), causing a reduction in the uptake of other nutrients\n" +
                    "- Poor root oxidation power, causing decreased resistance to toxic substances produced under anaerobic soil conditions\n" +
                    "- Increased incidence of diseases, where inappropriate amounts of fertilizers are used",
                    "Kiểm tra sự đổi màu của cây:\n" +
                            "- Cây màu xanh đậm với mép lá màu nâu vàng hoặc đốm hoại tử màu nâu sẫm xuất hiện đầu tiên trên đầu lá già\n" +
                            "- Đầu lá màu nâu vàng, khi thiếu K trầm trọng\n" +
                            "- Lá già chuyển từ vàng sang nâu\n" +
                            "- Các sọc vàng có thể xuất hiện dọc theo gân lá và các lá phía dưới có thể cong xuống\n" +
                            "- Sự đổi màu dần dần xuất hiện trên các lá non nếu sự thiếu hụt không được khắc phục.\n" +
                            "\n" +
                            "Các dấu hiệu và triệu chứng thiếu K khác bao gồm:\n" +
                            "- Đốm nâu gỉ sắt ở đầu lá già, sau lan ra toàn bộ lá khiến lá chuyển sang màu nâu và khô nếu thiếu K trầm trọng\n" +
                            "- Những đốm hoại tử bất thường cũng có thể xuất hiện trên chùy\n" +
                            "- Cây còi cọc với lá nhỏ hơn, thân ngắn và mảnh\n" +
                            "- Giảm đẻ nhánh khi thiếu rất nặng\n" +
                            "- Tỷ lệ chỗ ở cao hơn\n" +
                            "- Lá già sớm, héo lá, cuốn lá khi nhiệt độ cao, độ ẩm thấp\n" +
                            "- Một tỷ lệ lớn các bông con vô trùng hoặc không được lấp đầy\n" +
                            "- Bộ rễ không khỏe mạnh (nhiều rễ đen, giảm chiều dài và mật độ rễ), làm giảm khả năng hấp thu các chất dinh dưỡng khác\n" +
                            "- Khả năng oxy hóa của rễ kém, làm giảm khả năng chống lại các chất độc hại được tạo ra trong điều kiện đất yếm khí\n" +
                            "- Tăng tỷ lệ mắc bệnh do sử dụng lượng phân bón không phù hợp",
                    "Potassium deficiency in rice is more common under the following crop management practices:\n" +
                            "- Excessive use of Nitrogen (N) or N and P fertilizers with insufficient K application\n" +
                            "- Direct-seeded rice during early growth stages, when the plant population is large and the root system is shallow\n" +
                            "- Cultivar differences in susceptibility to K deficiency and response to K fertilizer.\n" +
                            "\n" +
                            "Soils, which are particularly prone to K deficiency include:\n" +
                            "- Soils inherently low in K\n" +
                            "- Coarse-textured soils with low cation exchange capacity and small K reserves (e.g., sandy soils in northeast Thailand, and Cambodia)\n" +
                            "- Highly weathered acid soils with low CEC and low K reserves, e.g., acid upland soils (Ultisols or Oxisols) and degraded lowland soils (e.g., North Vietnam, northeast Thailand, Cambodia, Lao PDR).\n" +
                            "\n" +
                            "Soils on which K uptake is inhibited:\n" +
                            "- Lowland clay soils with high K fixation\n" +
                            "- Soils with a large K content but a very wide (Calcium + Magnesium)/K ratio\n" +
                            "- Leached, \"old\" acid sulfate soils with a small base cation content\n" +
                            "K deficiency may occur on acid sulfate soils even when the soil K content is large (Thailand, South Vietnam).",
                    "Tình trạng thiếu kali ở lúa phổ biến hơn theo các biện pháp quản lý cây trồng sau:\n" +
                            "- Sử dụng quá nhiều phân Đạm (N) hoặc phân N và P mà bón không đủ K\n" +
                            "- Lúa sạ thẳng trong giai đoạn sinh trưởng sớm, khi quần thể cây lớn và bộ rễ nông\n" +
                            "- Sự khác biệt giữa các giống cây trồng về tính mẫn cảm với tình trạng thiếu K và phản ứng với phân bón K.\n" +
                            "\n" +
                            "Các loại đất đặc biệt dễ bị thiếu K bao gồm:\n" +
                            "- Đất vốn có hàm lượng K\n thấp" +
                            "- Đất có kết cấu thô với khả năng trao đổi cation thấp và trữ lượng K nhỏ (ví dụ: đất cát ở đông bắc Thái Lan và Campuchia)\n" +
                            "- Đất chua bị phong hóa mạnh với CEC thấp và trữ lượng K thấp, ví dụ: đất vùng cao chua (Ultisols hoặc Oxisols) và đất trũng bị thoái hóa (ví dụ: Bắc Việt Nam, đông bắc Thái Lan, Campuchia, CHDCND Lào).\n" +
                            "\n" +
                            "Đất mà sự hấp thụ K bị ức chế:\n" +
                            "- Đất sét trũng có độ cố định K cao\n" +
                            "- Đất có hàm lượng K lớn nhưng tỷ lệ (Canxi + Magie)/K rất rộng\n" +
                            "- Đất phèn \"cũ\" bị rửa trôi, có hàm lượng cation bazơ nhỏ\n" +
                            "Thiếu K có thể xảy ra trên đất phèn ngay cả khi hàm lượng K trong đất lớn (Thái Lan, Nam Việt Nam).",
                    "To manage potassium deficiency\n" +
                            "- Estimate K input from indigenous sources to assess site-specific K requirements.\n" +
                            "- Increase K uptake by improving soil management practices on root health (e.g., deep tillage to improve percolation to at least 3-5 mm d-1 and to avoid excessively reducing conditions in soil).\n" +
                            "- Establish an adequate population of healthy rice plants by using high-quality seeds of a modern variety with multiple pest resistance, and optimum crop maintenance (water and pest management).\n" +
                            "- Incorporate rice straw. If straw burning is the only option for crop residue management, spread the straw evenly over the field (e.g., as it is left after combine harvest) before burning. Ash from burnt straw heaps should also be spread over the field.\n" +
                            "- Apply optimum doses of N and P fertilizers and correct micronutrient deficiencies. Apply K fertilizers, farmyard manure, or other materials (rice husk, ash, night soil, compost) to replenish K removed in harvested crop products.",
                    "Để kiểm soát tình trạng thiếu kali\n" +
                            "- Ước tính đầu vào K từ các nguồn bản địa để đánh giá các yêu cầu K cụ thể của trang web.\n" +
                            "- Tăng khả năng hấp thụ K bằng cách cải thiện các biện pháp quản lý đất đối với sức khỏe của rễ (ví dụ: làm đất sâu để cải thiện quá trình thẩm thấu lên ít nhất 3-5 mm d-1 và để tránh làm giảm quá mức các điều kiện trong đất).\n" +
                            "- Thiết lập đủ số lượng cây lúa khỏe mạnh bằng cách sử dụng hạt giống chất lượng cao của giống hiện đại với khả năng kháng nhiều loại sâu bệnh và duy trì mùa màng tối ưu (quản lý nước và sâu bệnh).\n" +
                            "- Kết hợp rơm rạ. Nếu đốt rơm rạ là lựa chọn duy nhất để quản lý tàn dư cây trồng, hãy rải đều rơm rạ trên ruộng (ví dụ như rơm rạ còn lại sau khi thu hoạch) trước khi đốt. Tro từ đống rơm cháy cũng nên được rải trên mặt đất. trường.\n" +
                            "- Bón phân N và P với liều lượng tối ưu và khắc phục tình trạng thiếu vi lượng. Bón phân K, phân chuồng hoặc các vật liệu khác (trấu, tro, đất ủ, phân hữu cơ) để bổ sung lượng K đã lấy đi trong sản phẩm cây trồng đã thu hoạch.",
                    "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/deficiencies_toxicities%2Fpotassium_(K)_deficiency.jpg?alt=media&token=52ad0117-6b15-4ea4-9613-92b6828e2e5f");
            deficienciesToxicities.add(deficienciesToxicities4);

            for (DeficienciesToxicities d : deficienciesToxicities) {
                deficienciesToxicitiesDao.insert(d);
            }

            //*****Crop-Deftox*****
            CropDeftoxDao cropDeftoxDao = db.cropDeftoxDao();
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM 18"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM 18"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) excess")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM 18"), deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM 18"), deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency")));

            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("DT 08"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("DT 08"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) excess")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("DT 08"), deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("DT 08"), deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency")));

            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM 5451"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM 5451"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) excess")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM 5451"), deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM 5451"), deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency")));

            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("IR 50404"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("IR 50404"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) excess")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("IR 50404"), deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("IR 50404"), deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency")));

            //*****Deftox-Fertilizer*****
            DeftoxFertilizerDao deftoxFertilizerDao = db.deftoxFertilizerDao();
            deftoxFertilizerDao.insert(new DeftoxFertilizer(deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency"), fertilizerDao.getIdByName("Urea")));
            deftoxFertilizerDao.insert(new DeftoxFertilizer(deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency"), fertilizerDao.getIdByName("DAP")));
            deftoxFertilizerDao.insert(new DeftoxFertilizer(deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency"), fertilizerDao.getIdByName("MOP")));

            //****Deftox-Stage*****
            DeftoxStageDao deftoxStageDao = db.deftoxStageDao();
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency"), stageDao.getIdByName("Tillering")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency"), stageDao.getIdByName("Panicle initiation")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Nitrogen (N) excess"), stageDao.getIdByName("Tillering")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Nitrogen (N) excess"), stageDao.getIdByName("Panicle initiation")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency"), stageDao.getIdByName("Tillering")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency"), stageDao.getIdByName("Panicle initiation")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency"), stageDao.getIdByName("Flowering")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency"), stageDao.getIdByName("Flowering")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency"), stageDao.getIdByName("Tillering")));
            deftoxStageDao.insert(new DeftoxStage(deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency"), stageDao.getIdByName("Panicle initiation")));

        });
    }
}
