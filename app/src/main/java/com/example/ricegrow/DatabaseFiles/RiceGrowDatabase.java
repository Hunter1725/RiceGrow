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
                    CropPests.class, Crops.class, CropWeeds.class, CropStage.class,Diseases.class, DiseasesPesticides.class, DiseasesStages.class,
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

    private static final RoomDatabase.Callback initialCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            populateInitialData();
        }
    };

    private static void populateInitialData() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            RiceGrowDatabase db =RiceGrowDatabase.getInstance(appContext);

            //****Guest User****
            UserDao userDao = db.userDao();
            userDao.insert(new Users("qoF4h2xcXfOwFbCZPypG1hmwKPb2", "Guest", "1234567", "ricegrowguest@gmail.com", "The Earth", "guest", "123456789", "default_avatar"));

            //****Crops****
            CropDao cropDao = db.cropDao();
            ArrayList<Crops> crops = new ArrayList<>();
            Crops crop1 = new Crops("OM18", "OM18 rice was selected from OM 8017/ OM 5166 hybrid combination, this is an aromatic rice variety with outstanding advantages such as high salt tolerance at 3-4 levels, pest resistance, especially high resistance and stability. with blast, high yield and short growth duration.",
                                    105, 6700, 3.6, "https://loctroi.vn/UploadFiles/ImgUpload/OM%2018%201.png");
            crops.add(crop1);
            Crops crop2 = new Crops("DT08", "DT08 (Dai Thom 08) is a high-quality type of Vietnam fragrant rice grown in Viet Nam. DT08 rice has medium grains, with an evenly bright-white color. DT08 rice has a short growth period; therfore, there are 3 crops of DT08 rice per year, which are harvested in the spring, autumn and winter. When cooked, the texture of DT08 rice is soft and remains sticky after cooling.",
                    110, 7000, 3.9, "https://danviet.mediacdn.vn/2020/10/16/dai-thom-8-3-16028306562021544130115-crop-1602830669005866812402.jpg");
            crops.add(crop2);
            for (Crops c : crops){
                cropDao.insert(c);
            }

            //****Pests****
            PestDao pestDao = db.pestDao();
            ArrayList<Pests> pests = new ArrayList<>();
            Pests pests1 = new Pests("Rice leaffolder", "Cnaphalocrocis medinalis",
                    "The life cycle of Rice leaffolder is about 1.5 months. The egg stage lasts for 5 days, the larval stage lasts for 25 days, the pupal stage lasts for 7 days, and the adult moth stage lasts for 10 days. During the larval stage, the leaffolder caterpillars fold the rice leaves around themselves and attach the leaf margins together with silk strands." +
                    "\n" + " Rice leaffolders occur in all rice environments and are more abundant during the rainy seasons. They are commonly found in shady areas and areas where rice is heavily fertilized. In tropical rice areas, they are active year-round, whereas, in temperate countries, they are active from May to October.",
                                    "Check the plant for the following symptoms:\n" +
                                            "- Longitudinal and transparent whitish streaks on damaged leaves\n" +
                                            "tubular folded leaves\n" +
                                            "- Leaf tips sometimes fastened to the basal part of leaf\n" +
                                            "- Heavily infested fields appear scorched with many folded leaves\n" +
                                            "\n" + "Also check for presence of insects, particularly during tillering to flowering. Signs include:\n" +
                                            "- Disc-shaped ovoid eggs laid singly\n" +
                                            "- Young larvae feeding on the base of the youngest unopened leaves\n" +
                                            "- Folded leaves enclosing the feeding larvae, and present fecal matter.",
                                    "Leaffolder caterpillars fold a rice leaf around themselves and attach the leaf margins together with silk strands. They feed inside the folded leaf creating longitudinal white and transparent streaks on the blade.",
                                    "To prevent leaffolder outbreaks:\n" +
                                            "- Use resistant varieties.\n" +
                                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                                            "- Follow rice with a different crop, or fallow period.\n" +
                                            "- Avoid ratooning.\n" +
                                            "- Flood and plow field after harvesting if possible.\n" +
                                            "- Remove grassy weeds from fields and borders.\n" +
                                            "- Reduce density of planting.\n" +
                                            "- Use balanced fertilizer rates.", "https://th.bing.com/th/id/OIP.wkplL9vtl_OwP-X2tVUCPAHaKF?pid=ImgDet&rs=1");
            pests.add(pests1);
            Pests pests2 = new Pests("Planthopper", "Two species of planthopper infest rice. These are the brown planthopper (BPH), Nilaparvata lugens (Stal); and the whitebacked planthopper (WBPH), Sogatella furcifera (Horvath).",
                    "The life cycle of planthoppers is usually about 40 days, depending on the species and the environment. The eggs usually hatch between 6 to 8 days, planthoppers stay in the nymph phase for about 16-18 days and adult planthoppers live for about 15-20 days. \n" +
                    "Different species of planthoppers have different life cycles. For example, the brown planthopper completes its lifecycle in 18 to 24 days between June and October, 38 to 44 days between November and January, and 18 to 35 days between February and April1.",
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
                    "The high population of planthoppers cause leaves to initially turn orange-yellow before becoming brown and dry and this is a condition called hopperburn that kills the plant. BPH can also transmit Rice Ragged Stunt and Rice Grassy Stunt diseases. Neither disease can be cured.",
                    "To control planthoppers:\n" +
                            "- Mechanical & physical measures\n" +
                            "   + Flood the seedbed, for a day, so that only the tips of seedlings are exposed will control BPH.\n" +
                            "   + Sweep small seedbeds with a net to remove some BPH (but not eggs), particularly from dry seed beds. At high BPH densities, sweeping will not remove sufficient numbers of BPH from the base of the plant.\n" +
                            "- Biological control\n" +
                            "   + If natural enemies out-number BPH the risk of hopperburn is low. Even rice already damaged by hopperburn should not be treated with insecticides if natural enemies out-number BPH. Natural enemies of BPH include water striders, mirid bugs, spiders, and various egg parasitoids.\n" +
                            "- Chemical control\n" +
                            "   + Only apply insecticides to the seedbed, for BPH or WBPH, if all of these conditions are met: an average of more than one planthopper per stem, on average, more planthoppers than natural enemies,flooding the seedbed is not an option.",
                            "https://assets.irinnews.org/s3fs-public/images/201008240806390234.jpg");
            pests.add(pests2);
            Pests pests3 = new Pests("Stem borer", "Schoenobius incertulas",
                    "The life cycle of stem borers consists of four stages: egg, larva, pupa and adult. After sunset, the male and female moths come together and after sexual union the eggs are fertilized internally. The eggs are laid in batches of 10-80 on the upperside and underside of leaf surfaces, usually close to the midrib. They hatch after 4-10 days. Younger larvae (caterpillars) feed on the leaf whorl. Older larvae tunnel into the stems, and it is within these tunnels that they feed and grow for about 2-3 weeks.",
                            "Check the field for the following damage symptoms:\n" +
                                    "- Deadhearts or dead tillers that can be easily pulled from the base during the vegetative stages\n" +
                                    "- Whiteheads during reproductive stage where the emerging panicles are whitish and unfilled or empty\n" +
                                    "- Tiny holes on the stems and tillers\n" +
                                    "- Frass or fecal matters inside the damaged stems\n" +
                                    "To confirm stem borer damage, visually inspect rice crop for deadhearts in the vegetative stages and whiteheads in reproductive stages. Stems can be pulled and dissected for larvae and pupae for confirmation of stem borer damage.",
                            "Stem borers can destroy rice at any stage of the plant from seedling to maturity. They feed upon tillers and cause deadhearts or drying of the central tiller, during the vegetative stage; and cause whiteheads at reproductive stage.",
                            "To manage the Stem borer:\n" +
                                    "- Use resistant varieties\n" +
                                    "- At seedbed and transplanting, handpick and destroy egg masses\n" +
                                    "- Raise level of irrigation water periodically to submerge the eggs deposited on the lower parts of the plant\n" +
                                    "- Before transplanting, cut the leaf-top to reduce carry-over of eggs from the seedbed to the field\n" +
                                    "- Ensure proper timing of planting and synchronous planting, harvest crops at ground level to remove the larvae in stubble, remove stubble and volunteer rice, plow and flood the field\n" +
                                    "- Encourage biological control agents: braconid, eulophid, mymarid, scelionid, chalcid, pteromalid and trichogrammatid wasps, ants, lady beetles, staphylinid beetles, gryllid, green meadow grasshopper, and mirid, phorid and platystomatid flies, bethylid, braconid, elasmid, eulophid, eurytomid and ichneumonid wasps, carabid and lady bird beetles, chloropid fly, gerrid and pentatomid bugs, ants, and mites,  earwigs, bird, asilid fly, vespid wasp, dragonflies, damselflies, and spiders\n" +
                                    "- Bacteria and fungi also infect the larvae: mermithid nematode, chalcid, elasmid and eulophid\n" +
                                    "- Apply nitrogen fertilizer in split following the recommended rate and time of application.",
                                "https://th.bing.com/th/id/R.c756d12510c53bfca915af923be95f60?rik=0V4mw1iKHhcfRw&riu=http%3a%2f%2fwww.pyrgus.de%2fbilder1%2fnoctuidae%2fnonagrioides_rpe2013.jpg&ehk=fLTeIFo3z8Iy%2f4HWvi1orII29L%2fTNgw4l%2fdN7mwlk68%3d&risl=&pid=ImgRaw&r=0");
            pests.add(pests3);

            Pests pests4 = new Pests("Rice thrips", "Stenchaetothrips biformis (Bagnall)",
                    "The life cycle of rice thrips is 10-20 days and most of them live on rice or corn or weeds. The adult thrips are active during the day moving to look for young rice plant and other hosts. The female inserts the eggs singly within the leaf tissues in young leaves. Egg period is 3-5 days, and the life cycle is completed in 13-19 days.",
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
                    "Feeding damage caused by thrips causes leaf curling and discolouration. Rice thrips are more serious pests during the dry season. It infests the rice plant during the seedling stage or two weeks after early sowing. In direct-seeded rice fields in Vietnam, losses can reach 100% when infestation is severe in the first 20 days, after sowing.",
                    "To manage the Rice thrips:\n" +
                            "- Use resistant varieties.\n" +
                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Flood to submerge the infested field for two days.\n" +
                            "- Encourage biological control agents: predatory thrips, coccinellid beetles, anthocorid bugs, and staphylinid beetles.",
                    "https://th.bing.com/th/id/R.ee0245c113c556e604a7ed4a972b6d0e?rik=Oo7Llr3Ao8oecg&riu=http%3a%2f%2flouisianariceinsects.files.wordpress.com%2f2011%2f05%2f6-thrip-on-leaf-2.jpg&ehk=WwrcpbJ5EaCIHlE%2bbamNibajb0f4ey5UjzrrFoijKtk%3d&risl=&pid=ImgRaw&r=0");
            pests.add(pests4);

            Pests pests5 = new Pests("Rice bug", "The most common species of rice bug are Leptocorisa oratorius F. and Leptocorisa acuta Thunberg.",
                    "The life cycle of rice bugs is completed by 4 to 5 weeks. Females lay eggs in batches of 10 to 20 rows on the leaf blade's upper surface. When freshly deposited, eggs are a cream-yellow colour, turning reddish-brown after approximately one week. After 8-29 days, adults of both sexes are fully mature. Adults may live up to 69 days. \n" +
                            "On average, females live longer than males: 60 and 48 days, respectively. The bug is common on grasses, active early morning and late afternoon. High populations occur in rice fields if they have weedy areas or stands of weeds nearby.",
                    "Check the plant for feeding damage, such as:\n" +
                            "- Small or shrivelled grains,\n" +
                            "- Deformed or spotty grains,\n" +
                            "- Empty grains and erect panicles.\n" +
                            "\n" +
                            "The symptoms can be confused with the damage caused by nutrient deficiency or flower thrips. To confirm rice bug infestation, check for the presence of insects:\n" +
                            "- Oval, shiny, and reddish brown eggs along the midrib of the leaf\n" +
                            "- Slender and brown-green nymphs and adults feeding on endosperm of rice grains\n" +
                            "- Offensive smell",
                    "Rice bugs damage rice by sucking out the contents of developing grains from the pre-flowering spikelets to the soft dough stage, therefore causing unfilled or empty grains and discolouration. Immature and adult rice bugs both feed on rice grains.\n" +
                            "Both the adults and nymphs feed on grains at the milking stage. They can be serious rice pests and sometimes reduce yield by as much as 30%.",
                    "To manage Rice bugs:\n" +
                            "- Remove weeds from fields and surrounding areas to prevent the multiplication of rice bugs during fallow periods.\n" +
                            "- Level fields with even applications of fertilizer and water encourage rice to grow and develop at the same rate. Planting fields, within a village, at the same time (synchronous planting) also helps reduce rice bug problems.\n" +
                            "- Capturing rice bugs, in the early morning or late afternoon, by net can be effective at low rice bug densities, though labour intensive.\n" +
                            "- Encourage biological control agents: Some wasps, grasshoppers and spiders attack rice bugs or eggs. Indiscriminate insecticide use disrupts biological control, resulting in pest resurgence.\n" +
                            "\n" +
                            "For chemical control, before using a pesticide, contact a crop protection specialist for suggestions, guidance, and warnings specific to your situation:\n" +
                            "- Begin scouting the field at pre-flowering and continue daily until the stiff dough stage. Count rice bugs in the early morning or late afternoon from 20 hills while walking diagonally across a transplanted field. Adults often fly out of the way before you reach the rice plant, so counts may only reveal immature forms. Direct control may be required if there are more than 10 rice bugs/20 hills.\n" +
                            "- The choice of insecticide depends on many factors, such as the application equipment available, the insecticide's cost, the applicator's experience, or the presence of fish. The benefits of using an insecticide must be weighed against the risks to health and the environment. ",
                    "https://th.bing.com/th/id/R.82a9a86b8a48b5388b79b6ab62bb7418?rik=ilkWzMGP5eLXbA&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2ffactsheet-ricebug-2.jpg&ehk=AURainKybmYn1vGqH5oDHzVeaqin8KCkkfwC%2bA87O%2bs%3d&risl=&pid=ImgRaw&r=0");
            pests.add(pests5);

            Pests pests6 = new Pests("Black bug", "Scotinophora lurida",
                    "The life cycle of black rice bugs is completed in 50-60 days. After the nymph stage, black rice bugs enter the final stage of their life cycle: adulthood. Adult bugs have distinct yellowish marks on their backs. During this stage, black bugs reproduce, and they can lay eggs up to three times. Adult rice black bugs have a lifespan of about 22 days.",
                    "Check the following symptoms:\n" +
                            "- Check leaves for discolouration. Black bug damage can cause reddish brown or yellowing of plants. Leaves also have chlorotic lesions.\n" +
                            "- Check for decreased tillering. Bugburn symptoms show wilting of tillers with no visible honeydew deposits or sooty moulds.\n" +
                            "- Plants are also stunted; and can develop stunted panicles, no panicles, incompletely exerted panicles, and unfilled spikelets or whiteheads at the booting stage.\n" +
                            "- Check for deadhearts. Dead hearts can also be caused by stemborer. To confirm the cause of damage, pull infected plants. In black bug damage, infected plants cannot be pulled at the bases. Heavy infestation and \"bug burn\" is usually visible after heading or maturing.",
                    "The black bug feeds on the rice plant from the seedling to the maturity growth stages. Ten black bug adults per hill can cause losses of up to 35% in some rice.\n" +
                            "Black bugs remove the sap of the plant. They can cause browning of leaves, dead hearts, and bug burn. Their damage also causes stunting in plants, reduced tiller number, and formation of whiteheads. In severe cases, black bugs weaken the plant preventing them from producing seeds.",
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
                    "https://th.bing.com/th/id/R.a2fbf8e512c22f96f65ae09aaee47daf?rik=Ne%2b6Qiim3a1HIQ&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2ffactsheet-black-bug.jpg&ehk=zTLsoA4tYkAGDJMVrNW%2boLvn8j2FBfVtCG6awJpNvjk%3d&risl=&pid=ImgRaw&r=0");
            pests.add(pests6);

            Pests pests7 = new Pests("Rice gall midge", "Orseolia oryzae (Wood-Mason)",
                    "The rice gall midge (Orseolia oryzae) is an insect pest that infests rice plants and causes silver shoots. The life cycle of O. oryzae is completed within 21–36 days. The insect has three larval stages, a pre-pupal stage, and a pupal stage. Adult females have bright red abdomens and live longer than males. The females lay eggs inside the rice stems, where the larvae feed and cause damage.",
                    "Symptoms of rice gall midge damage include:\n" +
                            "- Formation of a hollow cavity or tubular gall at the base of the infested tiller. The gall formed is a silvery white hollow tube, 1 cm wide and 10−30 cm long\n" +
                            "- Affected tiller inhibits the growth of leaves and fails to produce panicles\n" +
                            "deformed, wilted, and rolled leaf\n" +
                            "- Elongation of leaf sheaths also called onion leaf or silver shoot\n" +
                            "plant stunting\n" +
                            "\n" +
                            "The rolled leaves can also be associated with the symptom caused by rice thrips. To confirm the cause of the problem, check for the presence of an insect. Particularly elongate-tubular eggs and maggot-like larvae feeding inside developing buds." +
                            "- Check for deadhearts. Dead hearts can also be caused by stemborer. To confirm the cause of damage, pull infected plants. In black bug damage, infected plants cannot be pulled at the bases. Heavy infestation and \"bug burn\" is usually visible after heading or maturing.",
                    "Rice gall midge forms a tubular gall at the base of tillers, causing elongation of leaf sheaths called onion leaf or silver shoot. The Asian gall midge can cause significant yield losses of 30−40% in some areas like Sri Lanka and parts of India.",
                    "To manage the Rice gall midge:\n" +
                            "- Use resistant varieties. Contact your local agriculture office for up-to-date lists of varieties available.\n" +
                            "- Plow the ratoon of the previous crop and remove all off-season plant hosts.\n" +
                            "- Encourage biological control agents: platygasterid, eupelmid, and pteromalid wasps (parasitize the larvae), phytoseiid mites (feed on eggs), spiders (feed on adults).",
                    "https://content.peat-cloud.com/w600/asian-rice-gall-midge-1.jpg");
            pests.add(pests7);
            Pests pests8 = new Pests("Green leafhopper", "Two species of green leafhoppers (GLH) can spread tungro: Nephotettix malayanus and Nephotettix virescens.",
                    "Green leafhoppers usually have a short life cycle of only a few weeks. There are several generations per year, with populations building up through spring, and peaking during summer and autumn. Green leafhopper adults are pale green with two black spots at the centre of the forewings and black markings on the head. They are active during both day and night, walk sideways, and when disturbed, quickly jump from the leaf blade.",
                    "Rice fields infested by GLH can have tungro, yellow dwarf, yellow-orange leaf, and transitory yellowing diseases. Symptoms include:\n" +
                            "- Stunted plants and reduced vigour\n" +
                            "- Reduced number of productive tillers\n" +
                            "- Withering or complete plant drying",
                    "Green leafhoppers are the most common leafhoppers in rice fields and are primarily critical because they spread viral diseases such as tungro, yellow dwarf, yellow-orange leaf, transitory yellowing, and dwarf. Both nymphs and adults feed by extracting plant sap with their needle-shaped mouthparts.",
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
                    "https://th.bing.com/th/id/R.32974c870ee19077055ac2ae2e6a86dd?rik=6sl6SE4oHV%2f3Tw&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2fgreen-leafhopper.jpg&ehk=HuuiMQqn13qTEVPvAxlGskVoZ8yfLdqBFtxd5LUXJCg%3d&risl=&pid=ImgRaw&r=0");
            pests.add(pests8);
            for (Pests p : pests){
                pestDao.insert(p);
            }

            //****Crops-Pests****
            CropPestDao cropPestDao = db.cropPestDao();
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Rice leaffolder")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Planthopper")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Stem borer")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Rice thrips")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Rice bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Black bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Rice gall midge")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Green leafhopper")));

            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Rice leaffolder")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Planthopper")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Stem borer")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Rice thrips")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Rice bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Black bug")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Rice gall midge")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Green leafhopper")));

            //****Diseases****
            DiseaseDao diseaseDao = db.diseaseDao();
            ArrayList<Diseases> diseases = new ArrayList<>();
            Diseases diseases1 = new Diseases("Blast", "Check the leaf and collar for lesions:\n" +
                    "- Initial symptoms appear as white to gray-green lesions or spots, with dark green borders.\n" +
                    "- Older lesions on the leaves are elliptical or spindle-shaped and whitish to gray centers with red to brownish or necrotic border.\n" +
                    "\n" +
                    "Check for other symptoms:\n" +
                    "- Some resemble diamond shape, wide in the center and pointed toward either ends.\n" +
                    "- Lesions can enlarge and coalesce, growing together, to kill the entire leaves.",
                    "Blast is caused by the fungus Magnaporthe oryzae. It can affect all above ground parts of a rice plant: leaf, collar, node, neck, parts of panicle, and sometimes leaf sheath. \n" +
                    "Rice blast is one of the most destructive diseases of rice. A leaf blast infection can kill seedlings or plants until the tillering stage. At later growth stages, a severe leaf blast infection reduces leaf area for grain fill, reducing grain yield.",
                    "To manage the blast:\n" +
                            "- Adjust planting time. Sow seeds early, when possible, after the onset of the rainy season.\n" +
                            "- Split nitrogen fertilizer application in two or more treatments. Excessive use of fertilizer can increase blast intensity.\n" +
                            "- Flood the field as often as possible.\n" +
                            "\n" +
                            "Systemic fungicides like triazoles and strobilurins can be used judiciously for control to control blasts. A fungicide application at heading can be effective in preventing the disease.",
                    "https://youngerusa.com/images/easyblog_articles/75/b2ap3_thumbnail_rice-blast-01.jpg");
            diseases.add(diseases1);
            Diseases diseases2 = new Diseases("Leaf Scald", "Check the plant for the following symptoms:\n" +
                    "- Zonate lesions of alternating light tan and dark brown starting from leaf tips or edges\n" +
                    "- Oblong lesions with light brown halos in mature leaves\n" +
                    "- Translucent leaf tips and margins\n" +
                    "Individual lesions are 1−5 cm long and 0.5−1 cm wide or may almost cover the entire leaf. The continuous enlargement and coalescing of lesions result in blighting of a large part of the leaf blade. The affected areas dry out giving the leaf a scalded appearance.",
                    "Leaf scald is a fungal disease caused by Microdochium oryzae, which causes the scalded appearance of leaves.\n"
                    + "Leaf scald commonly occurs in Central and South America, where it has caused significant yield losses. It also occurs in Asia, Africa, and the U.S. The disease is found in upland, rainfed, irrigated, and mangrove areas.",
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
                            "- Remove infected rice ratoons.", "https://th.bing.com/th/id/R.9432878d674c9e4bb83358870c17bbf2?rik=Os6x6dGwsF4uvA&pid=ImgRaw&r=0");
            diseases.add(diseases2);
            Diseases diseases3 = new Diseases("Sheath rot", "Although sheath rot can be observed in the field as a single disease on rice sheath, more often, it has become part of a complex of grain and leaf sheath discolouration commonly observed on wet-season rice.\n" +
                    "- Check for lesions: The typical sheath rot lesion starts at the uppermost leaf sheath enclosing the young panicles. It appears oblong or as irregular spot with dark reddish, brown margins, and gray center or brownish gray throughout.\n" +
                    "- Check for spots:Usually several spots are observed and these spots enlarge and combine or grow together and can cover most of the leaf sheath. Panicles remain within the sheath or may partially emerge. Affected leaf sheaths may have abundant whitish powdery fungal growth (mycelium) visible on the outer surface. Panicles that have not emerged rot and the florets turn red-brown to dark brown.\n",
                    "Sheath rot is caused by Sarocladium oryzae. The disease reduces grain yield by retarding or aborting panicle emergence and producing unfilled seeds and sterile panicles. Sheath rot also reduces grain quality by causing panicles to rot and grains to become discoloured.\n" +
                    "Sheath rot infects the rice plant at all growth stages, but it is most destructive when infection occurs during or after the booting stage, before the emergence of the panicle.\n" +
                            "It has caused 20−85% yield loss in Taiwan and 30−80% in Vietnam, the Philippines, and India. In Japan, affected areas range from 51,000−122,000 hectares and annual losses are estimated to be 16,000−35,000 tons.\n" +
                            "Infected seeds and mycelium carried by the rice crop residue play an essential role as the source of inoculum for primary infection.",
                    "To manage sheath rot:\n" +
                            "- Sheath rot is a seed-borne disease, use healthy seeds.\n" +
                            "- Minimize insect infestation in rice fields. Insects cause injuries to the plants that allow the fungi to enter the plant and cause infection.\n" +
                            "- The fungi survive on rice crop residue after harvest and can cause infection in the following seasons. Remove infected stubbles after harvest.\n" +
                            "- Use optimum plant spacing. Sow three plants per hill at 20 cm row spacing.\n" +
                            "- Apply potash at tillering stage.\n" +
                            "- Apply foliar spray of calcium sulfate and zinc sulfate.\n" +
                            "- Apply a seed treatment fungicide like carbendazim, edifenphos, or mancozeb as seed treatment and foliar spraying at the heading stage.\n" +
                            "- Apply a foliar fungicide like benomyl and copper oxychloride as foliar sprays.", "https://th.bing.com/th/id/R.8d68160a38d65319e7e62544445b4124?rik=eOT%2fmI%2b2QVKQgw&pid=ImgRaw&r=0");
            diseases.add(diseases3);
            Diseases diseases4 = new Diseases("Brown spot", "Check for lesions:\n" +
                    "- Infected seedlings have small, circular, yellow brown or brown lesions that may girdle the coleoptile and distort primary and secondary leaves.\n" +
                    "- Starting at tillering stage, lesions can be observed on the leaves. They are initially small, circular, and dark brown to purple-brown.\n" +
                    "- Fully developed lesions are circular to oval with a light brown to gray center, surrounded by a reddish brown margin caused by the toxin produced by the fungi.",
                    "Brown spot has been historically largely ignored as one of the most common and most damaging rice diseases. Brown spot is caused by the fungus Bipolaris oryzae producing ellipsoidal or circular lesions on the coleoptile, leaf blade, leaf sheath, and glume." +
                    "Brown spot causes both quantity and quality losses. \n" +
                            "On average, the disease causes a 5% yield loss across all lowland rice production in South and Southeast Asia. Severely infected fields can have as high as 45% yield loss.\n" +
                            "Heavily infected seeds cause seedling blight, leading to 10−58% seedling mortality. It also affects the quality and the number of grains per panicle and reduces the kernel weight.",
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
                    "https://th.bing.com/th/id/OIP.hjf0k_QD7VYPbDd_9wGzogHaE9?pid=ImgDet&rs=1");
            diseases.add(diseases4);
            Diseases diseases5 = new Diseases("Sheath blight", "Check for lesions:\n" +
                    "Symptoms are usually observed from tillering to the milk stage in a rice crop and include the following:\n" +
                    "- Oval or ellipsoidal greenish-grey lesions, usually 1-3 cm long, on the leaf sheath, initially just above the soil or water level in the case of conventionally flooded rice.\n" +
                    "- Under favourable conditions, these initial lesions multiply and expand to the upper part of the sheaths and the leaves and then spread to neighbouring tillers belonging to different hills (transplanted rice) or plants (direct-seeded rice).\n" +
                    "- Lesions on the leaves usually have irregular lesions, often with grey-white centres and brown margins as they grow older.\n" +
                    "in subtropical environments, the disease is mainly initiated by sclerotia (up to two million of which can be produced per square meter in a diseased crop).\n" +
                    "\n" +
                    "Sheath blight has symptoms similar to stem rot and stemborer infestation. To confirm the cause of the disease, check for irregular lesions usually found on the leaf sheaths (initially water-soaked to greenish grey and later becomes greyish white with brown margin). Also, check for the presence of sclerotia.",
                    "Sheath blight is a fungal disease caused by Rhizoctonia solani. Infected leaves senesce or dry out and die more rapidly; young tillers can also be destroyed.\n" +
                            "As a result, the leaf area of the canopy can be significantly reduced by the disease. This reduction in leaf area and the diseased-induced senescence of leaves and young infected tillers are the primary causes of yield reduction.\n" +
                            "\n" +
                            "Sheath blight is considered to be an important disease next to rice blasts. Rice sheath blight is an increasing concern for rice production, especially in intensified production systems.\n" +
                            "In Japan, the disease has caused a yield loss of as high as 20%, affecting about 120,000−190,000 hectares. A yield loss of 25% was reported if the flag leaves were infected. In the United States, a yield loss of 50% was reported when susceptible cultivars were planted. Sheath blight has also caused a yield loss of 6% in tropical Asia.",
                    "There is currently no resistant rice variety available for cultivation. The main management options available to minimize sheath blight include:\n" +
                            "- Use a reasonable level of fertilizer adapted to the cropping season.\n" +
                            "- Use the reasoned density of crop establishment (direct seeding or transplanting).\n" +
                            "- Carefully control weeds, especially on the levees.\n" +
                            "- Drain rice fields relatively early in the cropping season to reduce sheath blight epidemics.\n" +
                            "- Use fungicides to treat seeds.\n" +
                            "- Improve canopy architecture by reducing the seeding rate or providing wider plant spacing.",
                    "https://th.bing.com/th/id/R.b0a881668e48971c15bb9b3d812bf1d0?rik=1vQdiZN0WefPzA&pid=ImgRaw&r=0");
            diseases.add(diseases5);
            Diseases diseases6 = new Diseases("Rice grassy stunt", "To identify hills of Rice grassy stunt virus-infected plants, check for the following symptoms:\n" +
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
                    "Rice grassy stunt virus reduces yields by inhibiting panicle production. Generally, rice grassy stunt virus occurrence is not widespread. The disease can become a serious problem in limited rice-growing areas when there are brown planthopper outbreaks.",
                    "To control rice grassy stunt virus the brown planthopper vectors need to be managed. This can be done either through the use of insecticides, brown plant hopper-resistant varieties, or synchronized crop establishment. Infected stubble needs to be plowed under after harvest to reduce the virus source.\n" +
                    "Rice grassy stunt disease often develops and causes severe damage after the area is heavily infected with planthoppers. There is currently no cure for this disease. The best way to prevent disease is to manage BPH well, choose the sowing time to \"avoid planthoppers\", when the field is sick, it is necessary to destroy the diseased plants, then prevent BPH and spray foliar fertilizers with high phosphorus and potassium content. to increase plant resistance.",
                    "https://th.bing.com/th/id/R.d144c7ca3ebfbc40372b8642e26a3e90?rik=CCnkAsmvE71OZQ&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2frice-grassy-stunt.jpg&ehk=D2kWKLkLFvMo0zPbsrdSyiaqEPWh0HIZKAbY8R0JKds%3d&risl=&pid=ImgRaw&r=0");
            diseases.add(diseases6);
            Diseases diseases7 = new Diseases("Rice ragged stunt", "To detect rice ragged stunt virus, check plants for:\n" +
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
                    "Rice ragged stunt virus reduces yield by causing partially exerted panicles, unfilled grains and plant density loss. It is vector-transmitted from one plant to another by brown plant hoppers. Leaves of infected plants have a ragged appearance. \n" +
                            "Rice ragged stunt virus can affect up to 75% of plants in a crop. Depending on the extent of the damage infected plants will either produce partially exerted panicles and unfilled grains or produce few or no grains. Infected crops will suffer significant yield losses of up to 80%.",
                    "Preventive measures are more efficient against rice-ragged stunt virus than direct-control measures. Once infected by the virus, a rice plant cannot be cured.\n" +
                            "- Plant varieties resistant to brown planthopper.\n" +
                            "- Using resistant varieties for ragged stunt management is probably the most important control measure. Contact your local agriculture office for up-to-date lists of varieties available.\n" +
                            "- Practice synchronized planting.\n" +
                            "- Plow infected stubbles under the field after harvest to reduce the virus source.\n" +
                            "Rice ragged stunt disease often develops and causes severe damage after the area is heavily infected with planthoppers. There is currently no cure for this disease. The best way to prevent disease is to manage BPH well, choose the sowing time to \"avoid planthoppers\", when the field is sick, it is necessary to destroy the diseased plants, then prevent BPH and spray foliar fertilizers with high phosphorus and potassium content. to increase plant resistance.",
                    "https://th.bing.com/th/id/R.f5a2fa886ff852a1b15db472f2c0ce50?rik=0hyAHpnHbzaf%2bg&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2fragged-stunt.jpg&ehk=iwf2VGTlPDWMfYmRUd3eBqR1V6Qzip%2bgKBCkQizEYdE%3d&risl=&pid=ImgRaw&r=0");
            diseases.add(diseases7);
            Diseases diseases8 = new Diseases("Tungro", "The yellow or orange-yellow discolouration is noticeable in tungro-infected plants. Discolouration begins from the leaf tip and extends down to the blade or the lower leaf portion. Infected leaves may also show a mottled or striped appearance, rust-coloured spots, and inter-veinal necrosis.\n" +
                    "Tungro-infected plants also show symptoms of stunting, delayed flowering, which may delay maturity, reduced number of tillers, small and not completely exserted panicles, as well as a higher than normal percentage of sterile panicles or partially filled grains, covered with dark brown blotches.\n" +
                    "The degree of stunting and of leaf discolouration varies with rice varieties, strains of the viruses, the age of the plant when infected, and the environment. In varieties that carry some resistance to the disease, infected plants exhibit no discolouration or only a mild discolouration that may disappear as the plants mature.",
                    "Rice tungro disease is caused by the combination of two viruses, which are transmitted by leafhoppers. It causes leaf discolouration, stunted growth, reduced tiller numbers and sterile or partly filled grains. Tungro infects cultivated rice, some wild rice relatives and other grassy weeds commonly found in rice paddies.\n" +
                            "\n" +
                            "Tungro is one of the most damaging and destructive diseases of rice in South and Southeast Asia. In severe cases, Tungro susceptible varieties infected at an early growth stage could have as high as 100% yield loss.\n" +
                            "Once tungro is present in the field, it increases rapidly in young rice plants. Leafhopper vectors prefer to feed on young rice plants. They also acquire tungro viruses more efficiently from younger infected plants.",
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
                    "https://th.bing.com/th/id/R.beae016d4bb5c5f00a4664e9c143b192?rik=E0gzsw7jMRWSNw&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2ftungro-1.jpg&ehk=XnMTeKKXMzaJML7uO%2bxU2aWQazaPzjoSg1sVZ85eACw%3d&risl=&pid=ImgRaw&r=0");
            diseases.add(diseases8);

            Diseases diseases9 = new Diseases("Bacterial leaf streak", "Check for lesions:\n" +
                    "- Symptoms initially appear as small, water-soaked, linear lesions between leaf veins. These streaks are initially dark green and later become light brown to yellowish grey.\n" +
                    "- The lesions are translucent when held against the light.\n" +
                    "- Entire leaves may become brown and die when the disease is very severe.\n" +
                    "- Under humid conditions, yellow droplets of bacterial ooze, which contain masses of bacterial cells, may be observed on the surface of leaves.\n" +
                    "\n" +
                    "Bacterial leaf streak may be confused with narrow brown spot. To confirm:\n" +
                    "- Leaf streak lesions are usually thinner than those of narrow brown spot\n" +
                    "- Narrow brown spot lesions are not translucent, nor do they produce bacterial ooze\n" +
                    "- When the advancing part of the streaks is cut and placed in a glass with water, a mass of bacterial cells can usually be seen oozing out of the leaf, which makes the water turbid after five minutes.",
                    "Bacterial leaf streak is caused by Xanthomonas oryzae pv. oryzicola. Infected plants show browning and drying of leaves. Under severe conditions, this could lead to reduced grain weight due to loss of photosynthetic area.\n" +
                            "Based on reported cases, yield loss caused by bacterial leaf streak can range from 8−17% in the wet season and 1−3 % in the dry season.",
                    "To prevent and effectively manage bacterial leaf streak: \n" +
                            "- Plant-resistant varieties.\n" +
                            "- Treat seeds with hot water.\n" +
                            "- Keep fields clean—remove weed hosts and plough under rice stubble, straw, rice ratoons, and volunteer seedlings, which the bacteria may infect.\n" +
                            "- Use balanced amounts of plant nutrients, especially nitrogen.\n" +
                            "- Ensure good drainage of fields (in conventionally flooded crops) and nurseries.\n" +
                            "- Drain the field during a severe flood.\n" +
                            "- Dry the field during the fallow period to kill the bacteria in the soil and plant residues.\n" +
                            "- In cases of severe infection, when yield may be affected, a copper-based fungicide applied at the heading can be effective in controlling the disease.",
                    "https://th.bing.com/th/id/R.efc604d42f1cd730459a6f6b9e2bfa86?rik=b1q9xQKZAyRlnw&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2fbacterial-leaf-streak-1.jpg&ehk=OOUYUFe0%2bJQdWhnkdKdefuiTErw83ii086ICxgXC90c%3d&risl=&pid=ImgRaw&r=0");
            diseases.add(diseases9);

            Diseases diseases10 = new Diseases("Red stripe", "Check leaves for lesions and discolouration:\n" +
                    "- Initial lesions are pin-sized and often yellow-green to light orange in colour. Older lesions appear as orange spots with an upward stripe.\n" +
                    "- Lesions become necrotic and coalesce, forming a blight appearance on the leaves.\n" +
                    "- Lesions can also appear on the sheaths but are less common.\n" +
                    "- The disease can be confused with orange leaf blight disease. It is hardly distinguishable from bacterial leaf blight disease at severe and advanced stages of disease development.\n" +
                    "To confirm the red stripe, check the shape, size and colour of the lesions. An advanced lesion is characterized by an orange spot with a stripe, advancing towards the leaf's tip.",
                    "Red stripe causes the formation of lesions on leaves. The disease usually occurs when the plants reach the reproductive stage, starting from panicle initiation. High temperature, high relative humidity, high leaf wetness, and high nitrogen supply favour disease development.\n" +
                            "Red stripe is a potential threat to rice production in Southeast Asia. The red stripe of rice is common in Indonesia, Malaysia, the Philippines, Thailand and Vietnam.",
                    "To manage Red stripe:\n" +
                            "- Use resistant varieties. \n" +
                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Apply nitrogen based on actual crop requirements.\n" +
                            "- Ensure optimum seeding rate and wider plant spacing also appear to reduce the disease.\n" +
                            "- Ensure intermittent drainage during panicle initiation.\n" +
                            "- Use benzimidazole fungicides (benomyl, carbendazim, and thiophanate methyl) to treat seeds.",
                    "https://th.bing.com/th/id/R.ed396f3128da9b4f0d8d62edc08535a5?rik=IJL49wvb2%2bGCCw&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2fred-stripe.jpg&ehk=GoPefIkPQBXtpxFYX%2bnyWzWLJvK7eqj6FkOB%2fTp2u3w%3d&risl=&pid=ImgRaw&r=0");
            diseases.add(diseases10);

            Diseases diseases11 = new Diseases("Stem rot", "Check the plant for the following symptoms:\n" +
                    "- Visible numerous tiny white and black sclerotia and mycelium inside the infected culms\n" +
                    "- Infected culm lodges and caused unfilled panicles and chalky grain\n" +
                    "Initial symptoms are small, irregular black lesions on the outer leaf sheath near the water level. Lesions expand as the disease advances. Severe infection causes tiller death.",
                    "Stem rot leads to the formation of lesions and the production of chalky grains and unfilled panicles. The infection bodies or sclerotia are found in the upper soil layer. They survive in air-dry soil, buried moist rice soil, and tap water. They can also survive on straw, which is buried in the soil. The sclerotia float on irrigation water, infecting newly planted rice during land preparation. Infection is high in plants with wounds due to lodging or insect attack. The panicle moisture content and nitrogen fertilizer also influence disease development.\n" +
                            "\n" +
                            "The infection is seen on the rice crop during early heading and grain filling. The leaf sheaths decay and cause lodging and lower grain filling. It can cause heavy losses in many countries. For example, in Japan, 51,000−122,000 hectares are infected and estimated annual losses of 16,000−35,000 due to this disease. In Vietnam, the Philippines, and India, 30% to 80% losses were recorded.",
                    "To manage Stem rot:\n" +
                            "- Use resistant cultivars.\n" +
                            "- Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "- Burn straw and stubble or any crop residue after harvest or let the straw decompose.\n" +
                            "- Drain the field to reduce sclerotia.\n" +
                            "- Balance fertiliser use or perform split application with high potash and lime to increase soil pH.\n" +
                            "- Chemicals such as fentin hydroxide sprayed at the mid-tillering stage, thiophanate-methyl sprayed during disease initiation can reduce stem rot incidence in the rice field.\n" +
                            "- Other fungicides such as Ferimzone and validamycin A also show effectivity against the fungus.",
                    "https://agriculturistmusa.com/wp-content/uploads/2018/05/Stem-rot-of-rice-management.jpg");
            diseases.add(diseases11);

            for (Diseases d : diseases){
                diseaseDao.insert(d);
            }

            //****Crops-Diseases****
            CropDiseaseDao cropDiseaseDao = db.cropDiseaseDao();
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Blast")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Leaf Scald")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Sheath rot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Brown spot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Sheath blight")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Rice grassy stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Rice ragged stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Tungro")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Bacterial leaf streak")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Red stripe")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Stem rot")));

            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Blast")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Leaf Scald")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Sheath rot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Brown spot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Sheath blight")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Rice grassy stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Rice ragged stunt")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Tungro")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Bacterial leaf streak")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Red stripe")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Stem rot")));

            //****Pesticides****
            PesticideDao pesticideDao = db.pesticideDao();
            ArrayList<Pesticides> pesticides = new ArrayList<>();
            Pesticides pesticides1 = new Pesticides("Padan 95SP", "Sumitomo Chemical", "Cartap (min 97%) : 950 g/kg", "Insecticide", "Dosage: 0.5 – 0.7 kg/ha\n\n" +
                    "PreHarvest Interval- PHI: 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "How to use: The amount of water sprayed from 400 to 600 liters/ha." +
                    "It is not recommended to use alum water to mix with Padan 95SP insecticide.", 30, 400,
                    "https://vietnong.vn/wp-content/uploads/2022/04/PANDAN-95-01-768x768.jpg");
            pesticides.add(pesticides1);

            Pesticides pesticides2 = new Pesticides("Regent 800WG", "Bayer", "Fipronil (min 95 %): 800g/kg", "Insecticide",
                    "Dosage: 32 g/ha\n\n" +
                            "Quarantine period (PreHarvest Interval- PHI): 15 days (Duration in days from last handling to harvest)\n\n" +
                            "Usage: The amount of water sprayed is 210 - 600 liters/ha. Spray when pests appear", 1.6, 600,"https://vuonsaigon.vn/wp-content/uploads/2019/12/regent-1g-599x599.jpg");
            pesticides.add(pesticides2);

            Pesticides pesticides3 = new Pesticides("ANTRACOL 70WP", "Bayer", "Propineb (min 80%) : 700 g/kg", "Fungicide",
                    "Dosage: 1.5 kg/ha\n\n" +
                            "PreHarvest Interval- PHI: 7 days (Time interval in days from last handling to harvest)\n\n" +
                            "Usage: The amount of water sprayed is 320 - 800 liters/ha. Spray when the disease appears", 64, 400, "https://www.phandoiso1.com/wp-content/uploads/2020/11/Antracol-70WP-1kg-1-610x610.jpg");
            pesticides.add(pesticides3);

            Pesticides pesticides4 = new Pesticides("Xantocin 40WP", "VFC", "Bronopol (min 99%) : 40% w/w", "Fungicide", "Dosage: 0.2 – 0.25 kg/ha\n\n" +
                    "PreHarvest Interval- PHI: 1 day (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed 400 - 500 liters/ha. Spray when the disease rate is about 5-10%",
                    10, 400, "https://vietnong.vn/wp-content/uploads/2022/12/thuoc-bvtv-xantocin-40wp-768x672.jpg");
            pesticides.add(pesticides4);

            Pesticides pesticides5 = new Pesticides("Hilton USA 320 EC", "HopTri Co", "Pretilachlor 300g/l + Pyribenzoxim 20g/l + Fenclorim 100g/l", "Herbicide",
                                "Dosage: 1.0 – 1.25 liters/ha\n\n" +
                                        "PreHarvest Interval- PHI: Unknown (Duration in days from last handling to harvest)\n\n" +
                                        "Usage: The amount of water sprayed 400 liters/ha. Spraying after sowing 6-10 days",
                                40, 400, "https://www.hoptri.com/media/k2/items/cache/08f61c52357dcc6d2503bfea790efe4d_M.jpg");
            pesticides.add(pesticides5);

            Pesticides pesticides6 = new Pesticides("Elano 20EC", "HopTri Co", "Cyhalofop-butyl (min 97 %) : 200 g/l", "Herbicide", "Dosage: 0.4 liters/ha\n\n" +
                    "PreHarvest Interval (PHI): Unknown date (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 320-400 liters/ha. Spraying after sowing 3-15 days",
                        20, 320, "https://www.hoptri.com/media/k2/items/cache/0ef95987526970d668cbb7995fe36b10_M.jpg");
            pesticides.add(pesticides6);

            Pesticides pesticides7 = new Pesticides("Tilt Super 300EC", "Syngenta", "Difenoconazole 150g/l + Propiconazole 150g/l: 300g/l", "Fungicide","Dosage: 0.25 – 0.3 liters/ha\n\n" +
                    "Quarantine period (PreHarvest Interval- PHI): 14 days (Duration in days from last handling to harvest)\n\n" +
                    "Usage: Spray with 500-600 liters of water per hectare. Spray when the disease rate is about 8%",
                        10, 500, "https://th.bing.com/th/id/R.71e6bb0376104ac186b5086f027a22dc?rik=3N3Ex%2bedKUCvDw&pid=ImgRaw&r=0");
            pesticides.add(pesticides7);

            Pesticides pesticides8 = new Pesticides("Bassa 50EC", "PSC.1", "Fenobucarb (BPMC) (min 96 %) : 50% w/w", "Insecticide","Dosage: 1.0 – 1.5 litres/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Spray, mix with 600 litres of water /ha",
                    51, 600, "https://vietnong.vn/wp-content/uploads/2022/04/bassa-50ec_1620538912.jpg");
            pesticides.add(pesticides8);

            Pesticides pesticides9 = new Pesticides("Dupont™ Pexena™ 106SC", "Syngenta", "Triflumezopyrim (min 94%) : 106 g/l", "Insecticide","Dosage: 300 ml/ha\n\n" +
                    "Quarantine period (PreHarvest Interval- PHI): 21 days (Duration in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 400-500 L/ha. Spray once when 1-2 year old planthoppers appear on the rice field.",
                    10, 450, "https://vietnong.vn/wp-content/uploads/2022/12/thuoc-tru-ray-dupont-pexena-106sc.jpg");
            pesticides.add(pesticides9);

            Pesticides pesticides10 = new Pesticides("Sulfaron 250EC", "Golden Rice Co., Ltd", "Carbosulfan 200 g/l + Chlorfluazuron 50g/l : 250 g/l", "Insecticide","Dosage: 0.3-0.4 litres/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 400 -500 litres/ha.",
                    15, 400, "https://product.hstatic.net/1000220686/product/sulfaron-250ec-100ml_00d45c876f384c779ca5e91a86fc99e8_master.jpg");
            pesticides.add(pesticides10);

            Pesticides pesticides11 = new Pesticides("Virtako 40WG", "Syngenta", "Chlorantraniliprole 20% + Thiamethoxam 20% : 40% w/w", "Insecticide","Dosage: 37.5 – 75 g/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed 400 - 500 litres/ha. Spray after butterflies are in full bloom, spray a second time after 15 days if necessary.",
                    2.9, 500, "https://www.phandoiso1.com/wp-content/uploads/2021/03/Virtako-40WG-4.5g-1-768x768.jpg");
            pesticides.add(pesticides11);

            Pesticides pesticides12 = new Pesticides("Fanmax 350SC", "Phu Nong Co., Ltd", "Chlorfenapyr 250 g/l + Spirodiclofen 100 g/l : 350 g/l", "Insecticide","Dosage: 0.25 litres/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 400-500 litres/ha. Spray when the density is about 10-20 individual/m2",
                    9.5, 450, "https://th.bing.com/th/id/R.ff7aae5264b604079aa30cca77d5285c?rik=zSWBwLhA7Hxggg&pid=ImgRaw&r=0");
            pesticides.add(pesticides12);

            Pesticides pesticides13 = new Pesticides("Reasgant 5EC", "Shijiazhuang Xingbai Bioengineering Co., Ltd", "Abamectin: 50g/l", "Insecticide","Dosage: 100 – 200 ml/ha\n\n" +
                    "PreHarvest Interval- PHI: 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed from 500 to 600 litres/ha. Spray when new pests appear",
                    6.5, 550, "https://sieuthinhanong.com/wp-content/uploads/2021/03/REASGANT-5EC-1-768x768-1.jpg");
            pesticides.add(pesticides13);

            Pesticides pesticides14 = new Pesticides("Chess 50WG", "Syngenta", "500g/kg Pymetrozine", "Insecticide","Dosage: 0.5 – 1.0 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed 400 liters/ha. Spray when new worms appear",
                    13, 400, "https://azfarming.vn/wp-content/uploads/2021/09/thuoc-tru-sau-chess-50wg.jpg");
            pesticides.add(pesticides14);

            Pesticides pesticides15 = new Pesticides("Tasieu 5WG", "Viet Thang Co., Ltd", "Emamectin benzoate (Avermectin B1a 90 % + Avermectin B1b 10%) : 5% w/w", "Insecticide","Dosage: 150 – 250 g/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed from 500 to 600 litres/ha. Spraying when the caterpillars are young",
                    6.5, 550, "https://th.bing.com/th/id/OIP.iF3q8FYfdBw_xnWXhWtW_QHaHa?pid=ImgDet&rs=1");
            pesticides.add(pesticides15);

            Pesticides pesticides16 = new Pesticides("Sporekill 120SL", "VFC", "Didecyldimethylammonium chloride (min 76.6%) : 120 g/l", "Fungicide","Dosage: 0.5 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): 7 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Amount of water sprayed: 320-400 l/ha. Spray twice, once before flowering and the second time after flowering. Spray in the early morning or late afternoon.",
                    25, 350, "https://th.bing.com/th/id/R.c2001b1f257a8949fb6cabec0b91b24e?rik=jPyZ2iWcYwCqLQ&riu=http%3a%2f%2fproduct.hstatic.net%2f1000220686%2fproduct%2fsporekill_120sl_35b6f237723d4d43aec2635fa4387054_grande.jpg&ehk=KZEC5eJz%2fO8G95kX%2bPnFd19X8KqtBh1thIMxHBatJgE%3d&risl=&pid=ImgRaw&r=0");
            pesticides.add(pesticides16);

            Pesticides pesticides17 = new Pesticides("Carban 50SC", "Loc Troi Group Joint Stock Company", "Carbendazim (min 98%): 500g/l", "Fungicide","Dosage: 1.0 – 2.5 litres/ha\n\n" +
                    "Quarantine period (PreHarvest Interval- PHI): 14 days (Duration in days from last handling to harvest)\n\n" +
                    "Usage: Spray with 320-400 litres of water /ha. Spray when the disease appears",
                    80, 400, "https://dangnhanh.com.vn/upload/images/watermark/2021-06-18-20-21-11/13-10.png?v=1");
            pesticides.add(pesticides17);

            Pesticides pesticides18 = new Pesticides("Amistar Top 325SC", "Syngenta", "200g/L Azoxystrobin + 125g/L Difenoconazole", "Fungicide","Dosage: 0.25 - 0.3 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): 10 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 400 - 500 litres/ha. Spray when the disease rate is about 5-10%",
                    12, 450, "https://th.bing.com/th/id/OIP.Q-kOXJmHrB-x-xgZi_O0SAHaHa?pid=ImgDet&rs=1");
            pesticides.add(pesticides18);

            Pesticides pesticides19 = new Pesticides("Sofit 300EC", "Syngenta", "300g/L Pretilachlor + 100g/L Fenclorim", "Herbicide","Dosage: 1.2 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): Unknown date (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: The amount of water sprayed is 300-400 litres/ha.",
                    50, 400, "https://vietnamnongnghiepsach.com.vn/wp-content/uploads/2016/09/SOFIT-300EC.jpg");
            pesticides.add(pesticides19);

            Pesticides pesticides20 = new Pesticides("Dual Gold 96EC", "Syngenta", "960g/L S-Metolachlor", "Herbicide","Dosage: 0,75-1 litre/ha\n\n" +
                    "PreHarvest Interval (PHI): Unknown date (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Spray, mix with 320-400 litres of water/ha.",
                    50, 320, "https://th.bing.com/th/id/R.07870815d5998072abc052019186d95d?rik=7UH4%2bor73dOGiw&pid=ImgRaw&r=0");
            pesticides.add(pesticides20);

            Pesticides pesticides21 = new Pesticides("Anvil 5SC", "Syngenta", "Hexaconazole 50 g/l : 50 g/l", "Fungicide","Dosage: 1 litre/ha\n\n" +
                    "PreHarvest Interval- PHI: 14 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Amount of water 320-600 litres/ha. Spray when the disease rate is about 5%",
                    40, 500, "https://tapdoanvinasa.com/wp-content/uploads/2019/09/ANVIL-5SC-01.jpg");
            pesticides.add(pesticides21);

            Pesticides pesticides22 = new Pesticides("Nevo 330EC", "Syngenta", "80g/L Cyproconazole + 250g/L Propiconazole", "Fungicide","Dosage: 0.3 litre/ha\n\n" +
                    "PreHarvest Interval- PHI: 15 days (Time interval in days from last handling to harvest)\n\n" +
                    "Usage: Amount of water 400-500 litres/ha. Spray when the weather is favorable for disease development",
                    14, 500, "https://product.hstatic.net/1000220686/product/nevo_330ec_250ml_fix_master.jpg");
            pesticides.add(pesticides22);


            for (Pesticides p : pesticides){
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
            Stages stages1 = new Stages("Land preparation", 1,"Land preparation is an essential stage in rice planting that involves preparing the field before sowing or transplanting the rice seedlings. During this stage, the soil is carefully cultivated to create a favourable environment for the rice plants to grow. \n" +
                    "The land is levelled, weeds and crop residues are removed, and the soil is loosened to facilitate root penetration. Proper land preparation helps improve water drainage, nutrient availability, and weed control, ensuring optimal conditions for the subsequent stages of rice growth.",
                    "https://th.bing.com/th/id/R.b928873958a4df004db23adba653e97b?rik=kGnyVrBQTTIF1g&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2flandprep-wetpreparation-1.jpg&ehk=oXMrExLT09ZhnuJpyqJQ72ty7ZOVtOYFu2druY5AFk0%3d&risl=&pid=ImgRaw&r=0");
            stages.add(stages1);
            Stages stages2 = new Stages("Planting", 2,"Planting is a crucial stage in rice cultivation, where the prepared seedlings are transplanted into the rice field. It involves carefully placing the young rice plants in evenly spaced rows or broadcasting the seeds directly into the soil. \n" +
                    "Proper planting ensures good establishment of the crop, allowing the roots to anchor in the soil and the shoots to emerge for further growth. This stage sets the foundation for the rice plants to develop and progress through subsequent growth stages.",
                    "https://th.bing.com/th/id/R.dfe2c1f4e31c156afbb2b8adc54549a5?rik=zw0az2vZVZdtYA&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2fplanting-broadcasting.jpg&ehk=JU43RWaUyWxI%2f2VHzdv2zMExTYtfoqXpKGykMM6%2fJQQ%3d&risl=&pid=ImgRaw&r=0");
            stages.add(stages2);
            Stages stages3 = new Stages("Seeding", 3,"The seeding stage of the rice crop is when the seeds are planted in the field. They undergo germination, where the seed coat breaks open, and a root and shoot emerge. Seedlings rely on stored nutrients until they can photosynthesize. This stage is crucial for establishing a healthy crop stand and requires proper seedbed preparation, spacing, and weed control. Water supply and weed management are important factors for successful seedling growth.",
                    "https://th.bing.com/th/id/OIP.wNQXrTe-2YypjCvbzoq9owAAAA?pid=ImgDet&rs=1");
            stages.add(stages3);
            Stages stages4 = new Stages("Tillering", 4,"During the tillering stage of the rice crop, the seedlings grow and develop additional shoots called tillers. These tillers emerge from the base of the main plant and contribute to the overall plant density. Tillering is an important stage as it determines the potential number of panicles that the rice plant can produce.\n" +
                    "Adequate spacing, nutrient availability, and water management during this stage are crucial for promoting tiller development and ensuring healthy plant growth. It is also a critical period for weed control and the application of fertilizers to support optimal tiller production and crop yield.",
                    "https://th.bing.com/th/id/R.2cc0f6bb6f01303f70e68df00c0995bd?rik=8y%2bBaemk26xERg&riu=http%3a%2f%2fwww.dronefromchina.com%2facademy%2fwp-content%2fuploads%2f2018%2f10%2fu21042416133353258809fm173app25fJPEG.jpg&ehk=Sb4eldaxliOHQqoxJ6D7CgCgCjc0ZOZ0XdMGd5kTDZ0%3d&risl=&pid=ImgRaw&r=0");
            stages.add(stages4);
            Stages stages5 = new Stages("Panicle initiation", 5,"During the panicle initiation stage of the rice crop, the plant transition from the vegetative phase to the reproductive phase. This stage is characterized by the formation of panicles, which are the reproductive structures that contain the rice flowers. Panicle initiation marks an important milestone in the rice crop's growth cycle as it signifies the beginning of flower development. \n" +
                    "The plants allocate more energy towards the panicles, and they start to grow and elongate. Adequate water supply and nutrient availability, particularly nitrogen, are crucial during this stage to support panicle development and ensure the formation of healthy and productive flowers. Proper management practices, such as weed control and pest management, are also important to minimize potential stressors that could affect panicle initiation and subsequent grain formation.",
                    "https://i.ytimg.com/vi/c3d9MzvcTTo/maxresdefault.jpg");
            stages.add(stages5);
            Stages stages6 = new Stages("Heading", 6,"The heading stage of the rice crop marks the transition from vegetative to reproductive growth. During this stage, the panicle, which bears the flowers and grains, emerges. Florets develop within the panicle, and their synchronized growth is crucial for optimal yield. \n" +
                    "Proper management practices, including irrigation, nutrient supply, and pest control, are essential during this stage. Farmers monitor indicators like panicle emergence and floret development to make informed decisions. The heading stage sets the foundation for flowering, grain development, and eventual harvest, impacting overall crop yield and quality.",
                    "https://oba-shima.mito-city.com/wp/wp-content/uploads/2013/08/inenohana-8.jpg");
            stages.add(stages6);
            Stages stages7 = new Stages("Flowering", 7,"The flowering stage of the rice crop is a crucial phase where the plant produces flowers containing male and female reproductive structures. Optimal environmental conditions and pollination are essential for successful fertilization. Monitoring and managing this stage ensures the production of viable grains. Factors such as timing, abundance of flowers, and proper management practices influence the outcome.\n" +
                    "The flowering stage typically lasts around a week before the flowers transform into developing grains, leading to grain filling and maturation. Effective management during this stage enhances yield potential and contributes to food security and agricultural sustainability.",
                    "https://th.bing.com/th/id/R.624deda3b79e82c7eb20310bfadae590?rik=zUVfOL9WWyayWg&riu=http%3a%2f%2fimg.zhiwushuo.com%2fuploads%2fallimg%2f202149%2f20210609024642741.jpg&ehk=Xn4Q9nFs7rqVqTe29NZWmrlfcWVxDIuz84Si5FVwYIk%3d&risl=&pid=ImgRaw&r=0");
            stages.add(stages7);
            Stages stages8 = new Stages("Milk", 8,"The milk stage is a crucial phase in the growth of rice crops. It refers to the stage when the rice grains are in a soft dough state and appear milky due to the presence of a translucent liquid. During this stage, the grains accumulate starch and undergo significant physiological changes. It is a critical period for determining the optimal time for harvest, as the grains gradually harden and prepare for final ripening. \n" +
                    "Proper management practices, such as irrigation, nutrient supply, and pest control, are essential during this stage to support grain development and quality formation. Overall, the milk stage is vital for achieving high-quality rice grains with optimal yield and nutritional value.",
                    "https://th.bing.com/th/id/R.fa825926cfaa783b838e1c3298471843?rik=7ecRRwkUYy1Mlg&riu=http%3a%2f%2fagritech.tnau.ac.in%2fagriculture%2fphoto_bank%2frice%2fimages%2f033.+Paddy+field+%40+milking+stage.jpg&ehk=FXHMFODGyU4M%2bGZ2CLYLkYW%2fyFCMTvWXIXwEofY9d%2bs%3d&risl=&pid=ImgRaw&r=0");
            stages.add(stages8);
            Stages stages9 = new Stages("Dough", 9,"The dough stage is a significant phase in the growth of rice crops. It refers to the stage when the rice grains become firm and undergo a transition from a milky texture to a dough-like consistency. During this stage, the grains continue to accumulate starch, and their moisture content decreases. The grains become denser and more compact, and their color may change from translucent to a light yellowish hue. \n" +
                    "The dough stage is critical for determining the optimal time for harvest, as the grains reach their maximum size and develop their characteristic texture. It is important to closely monitor the crop during this stage to ensure that the grains mature properly and attain the desired quality. Adequate irrigation, nutrient management, and pest control are essential for supporting grain development and maximizing yield. Overall, the dough stage marks a crucial milestone in the rice crop's growth, indicating that the grains are nearing maturity and approaching harvest readiness.",
                    "https://www.en.krishakjagat.org/wp-content/uploads/2020/12/trieu-tan-lua.jpg");
            stages.add(stages9);
            Stages stage10 = new Stages("Mature", 10,"The mature stage is the final phase in the growth cycle of rice crops. It represents the culmination of the plant's development, where the rice grains reach their full maturity and are ready for harvest. During this stage, the rice plant undergoes physiological changes, such as the drying and yellowing of the leaves, indicating the completion of its life cycle. The rice grains attain their maximum size, weight, and colour, typically turning golden or brown, depending on the variety. \n" +
                    "The plant's energy is primarily directed towards grain filling and maturation, as the nutrients and sugars produced by photosynthesis are allocated to the developing grains. It is crucial to harvest the rice crop at the right time during the mature stage to ensure optimal grain quality and yield. Delaying the harvest may result in grain shattering or susceptibility to pests and diseases. The mature stage is a critical period that signifies the readiness of the rice crop for harvest, marking the successful completion of the growth process and the transition to the next phase of processing and utilization.",
                    "https://qph.fs.quoracdn.net/main-qimg-e430ecabafc3856bb49038f999d57186");
            stages.add(stage10);
            Stages stages11 = new Stages("Harvesting", 11,"Harvesting is the final stage of rice planting where the mature rice crop is collected. It involves removing the mature panicles from the rice plants. The timing of the harvest is crucial for optimal grain quality. Harvesting methods include manual or mechanical techniques. Once harvested, the rice crop is dried, threshed, and processed to obtain the final polished rice product. Harvesting concludes the rice planting process, providing a plentiful yield of nutritious grains.",
                    "https://th.bing.com/th/id/OIP.jK8a-oRAOY1A3uYJ1qm7MgAAAA?pid=ImgDet&rs=1");
            stages.add(stages11);
            for (Stages s : stages){
                stageDao.insert(s);
            }

            //*****Crops-Stages*****
            CropStageDao cropStageDao = db.cropStageDao();
            //***OM18***
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Land preparation"), 24, false, "1st", "24th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Planting"), 1, false, "25th", "25th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Seeding"), 10, false, "26th", "35th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Tillering"), 35, false, "36th", "75th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Panicle initiation"), 15, false, "76th", "93th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Heading"), 8,false, "94th", "103th" ));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Flowering"), 8, false, "104th", "113th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Milk"), 10, false, "114th", "123th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Dough"), 10, false, "124th", "133th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Mature"), 10,false, "134th", "143th" ));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("OM18"), stageDao.getIdByName("Harvesting"), 1, false, "144th", "144th"));
            //***DT08***
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Land preparation"), 24, false, "1st", "24th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Planting"), 1, false, "25th", "25th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Seeding"), 10, false, "26th", "35th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Tillering"), 35, false, "36th", "75th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Panicle initiation"), 15, false, "76th", "93th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Heading"), 10,false, "94th", "103th" ));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Flowering"), 10, false, "104th", "114th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Milk"), 10, false, "115th", "125th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Dough"), 11, false, "126th", "137th"));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Mature"), 10,false, "138th", "147th" ));
            cropStageDao.insert(new CropStage(cropDao.getIdByName("DT08"), stageDao.getIdByName("Harvesting"), 1, false, "148th", "148th"));

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
            Activities activities1 = new Activities(stageDao.getIdByName("Land preparation"), "Bunds or dikes", "Bunds or dikes enable the field to hold water. This is important especially in areas where water supply is not reliable.",1, "https://th.bing.com/th/id/R.1bd80a029cffc86c8835b7f40398508e?rik=7j%2b42WSNhGYfZw&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2flandprep-bunds.jpg&ehk=1W7eDsYxjgFR8zYo2jkBMJHIQygVwGwUon%2b%2f6REeJsc%3d&risl=&pid=ImgRaw&r=0");
            activities.add(activities1);
            Activities activities2 = new Activities(stageDao.getIdByName("Land preparation"), "Irrigate the field", "Irrigate the field with 2−3 cm of water for about 3−7 days or until it is soft enough and suitable for an equipment to be used.", 7, "https://th.bing.com/th/id/R.fa0b048dceec885f0aec00cb097c429c?rik=ejInn0L4%2b5COMg&riu=http%3a%2f%2f2.bp.blogspot.com%2f-qhduk5WJAgU%2fTeAr1RjuMQI%2fAAAAAAAAATw%2f5m-sUHJGvBk%2fs1600%2frice%2bpaddies.jpg&ehk=jm1Ck2QQP%2f92%2fTVTJ5jugRztEjKAlT%2bNsvrk6xdux%2bg%3d&risl=&pid=ImgRaw&r=0");
            activities.add(activities2);
            Activities activities3 = new Activities(stageDao.getIdByName("Land preparation"), "Perform primary tillage operations", "Primary tillage is normally undertaken when the soil is wet enough to allow the field to be plowed and strong enough to give reasonable levels of traction. This can be immediately after harvest or at the beginning of the next season, depending on soil moisture and water availability.", 2, "https://i.ytimg.com/vi/hh3lh1VzFgk/maxresdefault.jpg");
            activities.add(activities3);
            Activities activities4 = new Activities(stageDao.getIdByName("Land preparation"), "Flood the field", "Keep the field submerged for 10−14 days after plowing to soften clods and to decompose organic materials.", 10, "https://th.bing.com/th/id/R.7704876989fec876a5c1d08efc3c20e3?rik=3qjXuDm%2bRhfFCg&riu=http%3a%2f%2fwww.duplisea.ca%2fphotos%2f2006-7.JPG&ehk=X9rEkkdop382JG4tUj6fhxHB%2bwwNOhznofbs48mx4CA%3d&risl=&pid=ImgRaw&r=0");
            activities.add(activities4);
            Activities activities5 = new Activities(stageDao.getIdByName("Land preparation"), "Perform secondary tillage operations", "Depending on climate and soil type, this should be done 10−14 days after primary workings.", 2, "https://i.ytimg.com/vi/IkUAaJ7f3t0/maxresdefault.jpg");
            activities.add(activities5);
            Activities activities6 = new Activities(stageDao.getIdByName("Land preparation"), "Level the field", "Levelling should be done two (2) days before planting. A levelled and smooth soil surface provides for uniform germination and growth of the crops. A well-levelled field improves water coverage and is also proven to increase crop yield and quality.", 2, "https://mientaycogi.com/wp-content/uploads/2020/03/l%C3%A0m-ru%E1%BB%99ng-mi%E1%BB%81n-t%C3%A2y.jpg");
            activities.add(activities6);
            Activities activities7 = new Activities(stageDao.getIdByName("Planting"), "Transplanting", "Transplanting is commonly practiced as a method of weed control for wet or puddled fields. It requires less seed but much more labor compared to direct seeding. Also, transplanted crops take longer to mature due to transplanting shock.", 1, "https://th.bing.com/th/id/R.49c3f04a3549cc5d5737ac488ee690ce?rik=jajTyg%2fmNGodew&riu=http%3a%2f%2fcamnangcaytrong.com%2fUploads%2fNews%2fcay-lua.jpg&ehk=iPHX2jQ1yd4mBn8bt8QTNgWdAa%2fbFCDR7IItuLC%2bbbg%3d&risl=&pid=ImgRaw&r=0");
            activities.add(activities7);
            Activities activities8 = new Activities(stageDao.getIdByName("Planting"), "Direct seeding", "Direct-seeded crops require less labour and tend to mature faster than transplanted crops. In this method, plants are not subjected to stresses such as being pulled from the soil and re-establishing fine rootlets. However, they have more competition from weeds.", 1, "https://i.ytimg.com/vi/qwyQQqG8DbI/maxresdefault.jpg");
            activities.add(activities8);
            Activities activities9 = new Activities(stageDao.getIdByName("Seeding"), "Spraying herbicide", "Spraying herbicides during the seeding stage of rice growth is beneficial for effective weed control and promoting healthy crop establishment. The key points are:\n" +
                    "\n" +
                    "- Weed management: Herbicide application at this stage helps control weeds that compete with rice plants for resources and hinder their growth and productivity.\n" +
                    "\n" +
                    "- Early intervention: Targeting weeds early during seeding prevents them from becoming established and competing with rice plants throughout the growth cycle.\n" +
                    "\n" +
                    "- Resource utilization: Effective weed control ensures that rice plants have optimal access to water, nutrients, and sunlight, promoting their healthy growth and development.\n" +
                    "\n" +
                    "- Labor efficiency: Herbicide use reduces the need for manual weeding, saving time and labor during weed management.\n" +
                    "\n" +
                    "- Uniform crop establishment: Weed-free fields during seeding promote uniform crop establishment, leading to consistent growth and better overall crop performance.", 10, "https://th.bing.com/th/id/OIP.J3O4uhyxBFYpHO_9LTttwAHaE8?pid=ImgDet&rs=1");
            activities.add(activities9);
            Activities activities10 = new Activities(stageDao.getIdByName("Tillering"), "Irrigate the field", "The reason why water is pumped into the field about 1 - 3 cm before applying fertilizer is to prevent light from decomposing and evaporating manure. When fertilizer is applied to dry soil, it can cause a chemical reaction that releases ammonia gas. This gas can be harmful to plants and can cause root damage. By watering the soil before applying fertilizer, you can help prevent this reaction from occurring.", 1,"https://bomnuocdandung.vn/library/module_new/tim-hieu-may-bom-nuoc-dong-ruong-ntp_s1527.jpg");
            activities.add(activities10);
            Activities activities11 = new Activities(stageDao.getIdByName("Tillering"), "Primary fertilizing","Primary fertilizing tillering rice is the most critical step in the process of planting and caring for rice. Fertilizing to help tiller rice is the period of fertilizing after 15 to 20 days after transplanting rice. For the rice to grow well, and for high yield, in addition to applying fertilizer with the right technique, choosing the right fertilizer is also one of the decisive factors. Should spend 1/2 -2/3 of the remaining nitrogen to fertilize the tillering stage to help the rice to branch quickly, concentrate and also to reduce the amount of fertilizer and avoid loss of nitrogen.", 18, "https://th.bing.com/th/id/OIP.MgwfDZUYoWI6diQcdRL6DAHaEM?pid=ImgDet&rs=1");
            activities.add(activities11);
            Activities activities12 = new Activities(stageDao.getIdByName("Tillering"), "Secondary fertilizing", "Secondary fertilizing plays a very important role. It determines the yield as well as the efficiency of the entire rice crop. If we fertilize correctly, the rice yield will increase from 1 to 2 tons/ha. In contrast, the wrong fertilization will reduce rice yield from 1 to 2 tons/ha.", 18, "https://qph.fs.quoracdn.net/main-qimg-cdc47fc61921862a471f59807acb88e3");
            activities.add(activities12);
            Activities activities13 = new Activities(stageDao.getIdByName("Panicle initiation"), "Thirdly fertilizing", "Thirdly fertilizing is also one of the crucial stages contributing to determining rice yield. After the rice has fully bloomed, it is possible to fertilize the seeds by applying three types of Nitrogen (N), Phosphorus (P), and Potassium (K). This is the period when fertilizing is effective when planting rice, helping to limit falling and flattening seeds. Farmers should fertilize seedlings 25 days before harvest to reduce the amount of pesticide left on the seeds.", 3, "https://agri.vn/wp-content/uploads/2021/02/bon-phan-cho-lua-2-560x420.jpg");
            activities.add(activities13);
            Activities activities14 = new Activities(stageDao.getIdByName("Panicle initiation"), "First spraying pesticide", "Spraying pesticides during the panicle initiation stage of rice growth is crucial for effective pest management and promoting healthy crop development. By targeting this stage, the following benefits can be achieved:\n" +
                    "\n" +
                    "- Pest control: Pesticide application at this stage helps control insects, diseases, and weeds that can damage the crop.\n" +
                    "\n" +
                    "- Targeting specific pests: It addresses pests that are most active and damaging during the panicle initiation stage, such as rice stem borers, leaf folders, or panicle mites.\n" +
                    "\n" +
                    "- Protection for reproductive structures: Pesticides safeguard the developing panicles and ensure proper grain formation.\n" +
                    "\n" +
                    "- Preventing pest buildup: Timely application prevents pest populations from reaching damaging levels and reduces the risk of infestations in later stages.\n" +
                    "\n" +
                    "- Overall crop health: Managing pests during this stage promotes the overall health, vigor, and productivity of the rice crop.", 12, "https://www.in2greatkc.com/wp-content/uploads/2020/02/farmers-are-spraying-crops-in-a-green-field_t20_yX1joL-1200x686.jpg");
            activities.add(activities14);
            Activities activities15 = new Activities(stageDao.getIdByName("Heading"), "Second spraying pesticide", "Spraying pesticides during the heading stage of rice growth is important for effective pest control and optimizing crop yield. Key points to consider include:\n" +
                    "\n" +
                    "- Pest management: Pesticide application at this stage helps control pests like rice blast, sheath blight, and planthoppers that are active during the heading stage.\n" +
                    "\n" +
                    "- Disease prevention: Spraying pesticides during this stage helps prevent and manage diseases that can damage the panicles and reduce crop yield.\n" +
                    "\n" +
                    "- Protecting panicles: Pesticides protect the developing panicles, ensuring healthy grain formation and minimizing damage caused by pests.\n" +
                    "\n" +
                    "- Optimizing yield: Effective pest control during the heading stage helps maximize rice yield by minimizing yield losses caused by pests and diseases.\n" +
                    "\n" +
                    "- Timing for pest life cycle: Spraying pesticides at the heading stage disrupts the life cycle of pests, preventing them from reproducing and causing further damage in later stages.", 9, "https://th.bing.com/th/id/OIP.e-nbR5xBZVBkx5jhdIjZ8wHaE7?pid=ImgDet&rs=1");
            activities.add(activities15);
            Activities activities16 = new Activities(stageDao.getIdByName("Flowering"), "Third spraying pesticide", "Spraying pesticides during the flowering stage of rice growth offers several advantages:\n" +
                    "\n" +
                    "- Pest control: It helps manage pests like rice bugs, thrips, and leafhoppers that are active during this stage.\n" +
                    "\n" +
                    "- Disease management: Pesticides prevent the spread of diseases such as sheath blight and bacterial blight.\n" +
                    "\n" +
                    "- Pollination and fertilization: Pesticides protect flowers, ensuring successful pollination and fertilization for proper grain development.\n" +
                    "\n" +
                    "- Weather protection: Pesticides guard against adverse weather conditions that promote fungal diseases.\n" +
                    "\n" +
                    "- Yield optimization: By safeguarding the reproductive structures, pesticides contribute to higher grain yield and quality.", 9, "https://thumbs.dreamstime.com/b/asian-farmers-using-pesticides-nebulizer-countryside-spray-his-green-farms-morning-181892511.jpg");
            activities.add(activities16);
            Activities activities17 = new Activities(stageDao.getIdByName("Dough"), "Fourth spraying pesticide", "Spraying pesticides during the dough stage of rice growth provides several benefits:\n" +
                    "\n" +
                    "- Pest control: Pesticide application at this stage helps manage pests like rice stink bugs, stem borers, and leaf folders, which can cause significant damage to the crop.\n" +
                    "\n" +
                    "- Disease prevention: Pesticides protect the rice plants from diseases such as sheath blight and blast, which are common during the dough stage.\n" +
                    "\n" +
                    "- Grain protection: By controlling pests and diseases, pesticides safeguard the developing grains, preventing yield loss and preserving grain quality.\n" +
                    "\n" +
                    "- Harvest preparation: Spraying pesticides at the dough stage helps prepare the crop for harvest by reducing pest infestations and ensuring healthy grain formation.\n" +
                    "\n" +
                    "- Crop longevity: Effective pest and disease control during this stage contribute to the overall health and longevity of the rice crop.", 20, "https://www.dudegrows.com/wp-content/uploads/2020/02/gmo-spray-scaled.jpg");
            activities.add(activities17);
            for (Activities a : activities){
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
            Fertilizers fertilizers1 = new Fertilizers("DAP", "Ha Tay Fertilizer Import Export One Member Company Limited", "Ingredients %: Nts: 18%; P2O5hh: 46%; K2Ohh:0%", "Long-term industrial plants, fruit trees: apply 3-4 kg/tree/year.\n" +
                    "Vegetable crops: 150 - 200kg/ha/time\n" +
                    "Food crops: 120 - 200kg/ha/time\n" +
                    "Short-term crops: 150 - 200kg/ha/time\n" +
                    "Other crops: 200 - 300kg/ha/time\n" +
                    "* The above guidelines are for reference only and should be adjusted depending on the region and cultivar.", 60, "https://th.bing.com/th/id/R.e20502f8dbb9df0485c7e3762ff3cb5c?rik=sQWCyJm3AGwm%2fg&riu=http%3a%2f%2fphanbonminhphat.vn%2fupload%2fhinhthem%2fdap-korea-18-7721.jpg&ehk=EcBDlefYdqq7%2fKQwbCJodyv1%2fp9xzp1usGceyhu6Gaw%3d&risl=&pid=ImgRaw&r=0");
            fertilizers.add(fertilizers1);
            Fertilizers fertilizers2 = new Fertilizers("Urea", "Petrovietnam Camau Fertilizer Joint stock company", "Ingredients %: N:46.3%; Biuret: 0.99%; Humidity: 0.5%",
                    "Rice: 50-60 kg/ha/time (3 times/crop: 7-10 days after sowing/18-22 days after sowing/ 38-42 days after sowing)\n" +
                    "Corn: 80-100 kg/ha/time (3 times/crop: 7-10 days after planting/20-30 days after planting/40-50 days after planting)\n" +
                    "Sugarcane: 120-150 kg/ha/time (3 times/crop: 15-20 days after planting/2-3 months after planting/4-5 months after planting)", 60, "https://tapdoanvinasa.com/wp-content/uploads/2020/03/phan-ure-ca-mau-tapdoanvinasa-02.jpg");
            fertilizers.add(fertilizers2);
            Fertilizers fertilizers3 = new Fertilizers("MOP", "Petrovietnam Camau Fertilizer Joint stock company", "Ingredients %: Kali (K2O): 61%;Humidity: 0.5%",
                    "Use potassium fertilizer to best fertilize rice in 2 stages: 1st time, 12-15 days after transplanting rice, depending on long or short-term rice varieties. At this time, it is necessary to fertilize on average each pole (500 m2) from 2-3 kg to make the rice plant healthy, hardy transplant, high effective branch. \n" +
                            "The second fertilizer application is very important when the rice plant is standing female, preparing to make a spike.", 40, "https://th.bing.com/th/id/OIP.uh5Z9Uqifb46kRsiMH-xeQHaLA?pid=ImgDet&rs=1");
            fertilizers.add(fertilizers3);
            for (Fertilizers f : fertilizers){
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
            Weeds weeds1 = new Weeds("Echinochloa crus-galli", "- Asia: China, Japan, and Korea.\n" +
                    "- South and Southeast Asia: India, Indonesia, Cambodia, Lao PDR, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: widespread in Africa, Europe, and America.",
                    "Annual, erect, tufted or reclining at base; up to 200 cm tall.\n" +
                    "- Stem: culms rooting at lower nodes, cylindrical, without hairs, and filled with white spongy pith.\n" +
                    "- Leaf: linear with a broad round base and narrow top; blade 10−40 cm long; ligule absent.\n" +
                    "- Inflorescence: loose green to purplish, 10−25 cm long comprising compound racemes; spikelets more or less elliptical and pointed, usually slightly hairy; awns, if present, green to purplish, 2−5 mm long.",
                    "The common barnyard gas ropagates by seed. It flowers throughout the year and can produce seeds within 60 days.\n" +
                            "Echinochloa crus-galli prefers moist to wet land; easily grows in direct-seeded rice fields and wastelands. It is a common weed in swamps and aquatic places. ",
                    "It is a serious serious weed of lowland rice due to its rapid growth, competitive ability, and capacity to multiply rapidly. The young shoots are eaten in Java and it is used for reclaiming saline lands in Egypt. The weed serves as feed for animals in grasslands and wastelands.",
                    "- Cultural control: Thorough land preparation for rice under wet or dry conditions can reduce infestations.It is difficult to distinguish the weed seedlings from rice at early stages, which makes hand weeding difficult.\n" +
                            "- Biological control: the fungal pathogen Exserohilum monoceras shown to control this weed.\n" +
                            "- Chemical control: Oxadiazon, pretilachlor, pendimethalin or cyhalofop, thiobencarb, butachlor, and propanil mixtures with quinclorac or fenoxaprop.",
                    "https://th.bing.com/th/id/R.b63f6a54017e74b40ef1610f0a5b77d3?rik=0nrhgwsltfWG0Q&pid=ImgRaw&r=0");
            weeds.add(weeds1);
            Weeds weeds2 = new Weeds("Leptochloa chinensis", "- Asia: Japan and Korea.\n" +
                    "- South and Southeast Asia: Bangladesh, Cambodia, India, Indonesia, Lao PDR, Malaysia, Myanmar, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Australia, Papua New Guinea, Swaziland, and West Africa.",
                    "A tufted and smooth annual or perennial; up to 120 cm tall.\n" +
                            "- Stem: slender, hollow, erect or ascending from a branching base, rooting at lower nodes, smooth and without hair, typically 10−20 nodes, and can reach as high as 50−100 cm.\n" +
                            "- Leaf: smooth, linear, 10−30 cm long; ligule an inconspicuous membrane 1−2 mm long and deeply divided into hairlike segments.\n" +
                            "- Inflorescence: narrowly ovate, loose panicle, main axis 10−40 cm long, and with many spike-like slender branches; racemes slender, each with two rows of spikelets, spikelets 2−3.2 mm long, purplish or green and 4−6 flowered.",
                    "Red sprangletop propagates by seeds or vegetatively by rootstocks. Germination does not occur when seeds are submerged in water.",
                    "Leptochola chinensis is a serious weed of rice. Its ability to withstand waterlogged conditions as well as drained, moist conditions makes it a problem weed in rice.",
                    "- Cultural control: rotovating and puddling of rice fields during land preparation; hand weeding can be effective during the early growth stages of the weed.\n" +
                            "- Chemical control: Quinclorac, propanil, pendimethalin, fenoxaprop, pretilachlor, or benthiocarb.",
                    "https://th.bing.com/th/id/R.4da97a4c232ef70fd2ff3800c0d539d6?rik=xc%2bL9LvQhR6zNA&pid=ImgRaw&r=0");
            weeds.add(weeds2);
            Weeds weeds3 = new Weeds("Echinochloa colona", "- Asia: China and Japan.\n" +
                    "- South and Southeast Asia: Bangladesh, Cambodia, India, Indonesia, Lao PDR, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Australia, Bolivia, Botswana, Costa Rica, Ecuador, El Salvador, France, Fiji, Guatemala, Honduras, Iraq, Italy, Kenya, Mexico, Nicaragua, Paraguay, Peru, Portugal, Senegal, Spain, Tanzania, Uganda, United States, Venezuela, West Africa, and Zambia.",
                    "A tufted annual grass, up to 60 cm tall.\n" +
                            "- Stem: reddish purple or green, ascending to erect, without hairs.\n" +
                            "- Leaf: linear, 10−15 cm long, basal portion often tinged with red; ligule absent.\n" +
                            "- Inflorescence: simple, ascending racemes, green to purple, about 5−15 cm long; spikelets subsessile 1−3 mm long.",
                    "Echinochloa colona flowers throughout the year and is propagated by seeds. Seeds have a short dormancy period.\n" +
                            "It can be present in large numbers and responsive to nutrients. Prefers moist but unflooded conditions and is a problem mainly in upland and rainfed lowland rice fields rather than in flooded fields. ",
                    "It closely \"mimics\" rice in the vegetative growth stage and is a severe competitor of rice. It is a host of diseases such as tungro and rice yellow dwarf. It can be used as a palatable fodder for milking animals and water buffalo. ",
                    "- Cultural control: flooding; hand weeding or use of a hoe during early growth stages.\n" +
                            "- Chemical control: preemergence application of oxadiazon or pendimethalin or postemergence application of cyhalofop, butachlor, and fenoxaprop can be effective. ",
                    "https://th.bing.com/th/id/R.3bf335162dd6132bfdb76839de4ac9ab?rik=IxLkP%2bVx3L8YgQ&riu=http%3a%2f%2fasergeev.com%2fpictures%2farchives%2f2020%2f2741%2fjpeg%2f31.jpg&ehk=K4AUZ22vPuIqdn3NVvLawsV7yb56L6UQ1ljY3WVYxoQ%3d&risl=&pid=ImgRaw&r=0");
            weeds.add(weeds3);
            Weeds weeds4 = new Weeds("Fimbristylis miliacea", "- South and Southeast Asia: Bangladesh, Bhutan, Cambodia, India, Indonesia Lao PDR, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Ecuador, Madagascar, Nicaragua, Peru, and Suriname. ",
                    "Annual or perennial, without hairs, strongly tillering, with fibrous roots and up to 80−90 cm high.\n" +
                            "- Stem: slender, erect, densely tufted, compressed, and smooth; strongly angled at the top and flattened at the base; 20−70 cm tall.\n" +
                            "- Leaf: stiff and thread-like; on flowerless stems: in 2 rows and with flattened sheaths; no prominent midribs; on flowering stems: only linear leaf sheaths; basal leaves have overlapping leaf sheaths; ligule absent.\n" +
                            "- Inflorescence: 6−10 cm long, compound umbel with 6−50 spikelets; spikelets reddish brown, 2−4 mm long and either round or acute at apex.\n" +
                            "- Fruit: straw-coloured or pale ivory nut, 0.2−0.3 mm long.",
                    "Propagates by seeds; flowers year-round and produces 10,000 seeds per plant; seeds can germinate immediately after reaching maturity.\n" +
                            "In rice fields, seedlings appear soon after the rice is sown; flower in about one month and are capable of producing a second generation in the same season. Germinates where flood water is shallow or absent and seedlings may emerge throughout the entire growing period of rice. ",
                    "It is a serious and widespread weed of rice. An alternate host of diseases Rhizoctonia solani, Thanatephorus cucumeris, and Xanthomonas campestris pv. oryzae, insects Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), and Mythimna separata (Walker), and nematodes Hirschmanniella sp. and Meloidogyne spp. ",
                    "- Cultural control: hand cultivation.\n" +
                            "- Chemical control: postemergence application of MCPA and 2,4-D reported to be effective in rice. ",
                    "https://th.bing.com/th/id/R.d93b3a2a18e9332195003e9d610f8009?rik=GiNmpdDkRckQEA&pid=ImgRaw&r=0");
            weeds.add(weeds4);
            Weeds weeds5 = new Weeds("Cyperus iria", "- Asia: China (including Taiwan), Japan, and Korea.\n" +
                    "- South and Southeast Asia: Bangladesh, Cambodia, India, Indonesia, Lao PDR, Malaysia, Myanmar, Nepal, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Australia, Fiji, Swaziland, West Africa.",
                    "It is a tufted annual herb, or occasionally perennial, with fibrous roots, 15−75 yellowish red roots, 10−70 cm tall.\n" +
                            "- Stem: sharply 3-angled, tufted, smooth, 5−80 cm high.\n" +
                            "- Leaf: basal, rough to touch in the upper part, linear, flaccid, with gradual tapering point and 3−8 mm wide; sheath reddish or purplish brown, enveloping the stem at the base.\n" +
                            "- Inflorescence: simple or compound umbel composed of numerous erect-spreading 3−10 mm long flattened spikelets.\n" +
                            "- Fruit: three-angled, 1.0−1.5 mm nut with slightly concave sides and shiny dark brown to black.",
                    "The weed thrives in wetland rice, annual dryland crops, and plantation crops.\n" +
                            "Rice flatsedge or umbrella sedge multiplies rapidly: can produce 3,000−5,000 seeds per plant, seedlings emerge immediately after rice is sown, flowers month later and can establish second generation in the same season. It flowers throughout the year.",
                    "An important and widespread weed in South and Southeast Asia. Ovipositional host of the insects Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), Marasmia exigua (Butler), Mythimna separata (Walker), Nilaparvata lugens (Stål), Nisia carolinensis Fennah, Pseudococcus saccharicola Takahashi, Recilia dorsalis (Motschulsky), Spodoptera mauritia acronyctoides (Guenee), and Stenchaetothrips biformis (Bagnall), diseases Pyricularia oryzae, Rhizoctonia solani, and Sarocladium oryzae, and nematodes Circonemella onoensis, Hirschmanniella oryzae, and Pratylenchus indicus.",
                    "- Cultural control: hand weeding at an earlier stage of growth to prevent flowering and seed production; rotary weeding in transplanted rice during the seedling stage.\n" +
                            "- Chemical control: Butachlor or oxadiazon after harrowing and sowing of rice and chlorimuron, propanil, or MCPA after emergence.",
                    "https://th.bing.com/th/id/R.3da1294c64f0c1aa59d494c62c4f6fff?rik=rjTPSNSD0Gb6VA&riu=http%3a%2f%2fflowers.la.coocan.jp%2fCyperaceae%2fCyperus+iria%2fDSC03569.JPG&ehk=pT%2bx9k8EPYMVWX7BNd0dhKwyiejtDRgLH4BbutM1rcA%3d&risl=&pid=ImgRaw&r=0");
            weeds.add(weeds5);
            Weeds weeds6 = new Weeds("Eclipta prostrata", "- Asia: China (including Taiwan), Japan, and Korea.\n" +
                    "- South and Southeast Asia: Bangladesh, India, Indonesia, Cambodia, Lao PDR, Malaysia, Nepal, Pakistan, Philippines, Sri Lanka, Thailand, and Vietnam.\n" +
                    "- Rest of the world: Angola, Arabian Peninsula, Argentina, Australia, Brazil, Colombia, Costa Rica, Cote d'Ivoire, Cuba, Egypt, Fiji, Ghana, Iraq, Mexico, Peru, Portugal, Puerto Rico, Rhodesia, Sudan, Surinam, Trinidad, United States of America (including Hawaii), Zambia, and Zimbabwe.",
                    "A prostrate or reclining to erect, often branched, annual or perennial herb, 30−100 cm tall.\n" +
                            "- Stem: cylindrical, green or purplish, rooting at basal nodes, and often covered with long white hairs.\n" +
                            "- Leaf: oblong to lance-shaped, opposite, sessile or short-stalked, with more or less coarse hairs; margins entire or slightly toothed, up to 2−16 cm long.\n" +
                            "- Inflorescence: terminal and axillary, about 1 cm across, white or cream, on peduncles to 7 cm long.\n" +
                            "- Fruit: achene, densely warted, either brown or black, 2−3 mm long.",
                    "It is widespread and has adapted to a range of environments. It is found in poorly drained wet areas, saline conditions, along streams, in drains and canals of irrigated lowland rice paddies, in waste areas, and in upland fields.\n" +
                            "A single plant can produce as many as 17,000 seeds; germination is affected by light, moisture level, pH, and temperature, but seeds have no dormancy.",
                    "An important and widespread weed in South and Southeast Asia. Ovipositional host of the insects Creatonotus gangis Linnaeus, Leptocorisa acuta (Thunberg), Marasmia exigua (Butler), Mythimna separata (Walker), Nilaparvata lugens (Stål), Nisia carolinensis Fennah, Pseudococcus saccharicola Takahashi, Recilia dorsalis (Motschulsky), Spodoptera mauritia acronyctoides (Guenee), and Stenchaetothrips biformis (Bagnall), diseases Pyricularia oryzae, Rhizoctonia solani, and Sarocladium oryzae, and nematodes Circonemella onoensis, Hirschmanniella oryzae, and Pratylenchus indicus.",
                    "- Cultural control: cultivation and hand weeding.\n" +
                            "- Chemical control: preemergence application of oxadiazon or postemergence spraying of either 2,4-D or MCPA reported to be effective. ",
                    "https://th.bing.com/th/id/R.b8ee3f7782439ef18e9d90e8cd1da81e?rik=GjmKzZF%2bbtzgdg&pid=ImgRaw&r=0");
            weeds.add(weeds6);
            for (Weeds w : weeds){
                weedDao.insert(w);
            }

            //****Crops-Weeds****
            CropWeedDao cropWeedDao = db.cropWeedDao();
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM18"), weedDao.getIdByName("Echinochloa crus-galli")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM18"), weedDao.getIdByName("Leptochloa chinensis")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM18"), weedDao.getIdByName("Echinochloa colona")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM18"), weedDao.getIdByName("Fimbristylis miliacea")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM18"), weedDao.getIdByName("Cyperus iria")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("OM18"), weedDao.getIdByName("Eclipta prostrata")));

            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT08"), weedDao.getIdByName("Echinochloa crus-galli")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT08"), weedDao.getIdByName("Leptochloa chinensis")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT08"), weedDao.getIdByName("Echinochloa colona")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT08"), weedDao.getIdByName("Fimbristylis miliacea")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT08"), weedDao.getIdByName("Cyperus iria")));
            cropWeedDao.insert(new CropWeeds(cropDao.getIdByName("DT08"), weedDao.getIdByName("Eclipta prostrata")));

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
            DeficienciesToxicities deficienciesToxicities1 = new DeficienciesToxicities("Nitrogen (N) deficiency", "Check the field for abnormalities. N deficient crops are stunted and discoloured. Specifically:\n" +
                    "- Older leaves or whole plants are yellowish green.\n" +
                    "- Old leaves and sometimes all leaves become light green and chlorotic at the tip.\n" +
                    "-  Entire field may appear yellowish.\n" +
                    "\n" +
                    "Check the leaves for the following symptoms:\n" +
                    "- Leaves can die under severe N stress. Except for young leaves, which are greener, leaves of nitrogen-deficient plants are narrow, small, short, erect, and lemon-yellowish green.\n" +
                    "- Other symptoms are reduced tillering and reduced grain number.",
                    "Nitrogen deficiency is one of the most common problems in rice in Asia. It is common in all rice-growing soils where modern varieties are grown without sufficient mineral N fertilizer. Nitrogen-deficient crops have low yields.\n" +
                            "It often occurs at critical growth stages of the plant, such as tillering and panicle initiation, when the demand for nitrogen is large.\n" +
                            "Nitrogen deficiency may also occur when a large amount of N fertilizer has been applied but at the wrong time or in the wrong way. Soils particularly prone to N deficiency include the following types:\n" +
                            "- Soils with very low soil organic matter content.\n" +
                            "- Soils with particular constraints to indigenous N supply (e.g., acid sulfate soils, saline soils, Phosphorus (P)-deficient soils, poorly drained wetland soils).\n" +
                            "- Alkaline and calcareous soils with low soil organic matter status and a high potential for ammonia (NH3) volatilization losses.",
                    "To manage nitrogen deficiency:\n" +
                            "- Apply N fertilizer efficiently.\n" +
                            "- Do not apply large amounts of N to less responsive varieties.\n" +
                            "- Hybrid rice absorbs mineral N more efficiently than inbred rice varieties.\n" +
                            "- Choose a suitable plant spacing for each cultivar. Crops with suboptimal plant densities do not use fertilizer N efficiently.\n" +
                            "- Adjust the number of splits and timing of N applications according to the crop establishment method. Transplanted and direct-seeded rice require different N management strategies.\n" +
                            "- Maintain proper water control, i.e., keep the field flooded to prevent denitrification but avoid N losses from water runoff over bunds immediately following fertilizer application.\n" +
                            "- Establish a dense, healthy rice crop by using high-quality seeds of a high-yielding variety with multiple pest resistance and a suitable plant density.\n" +
                            "- Control weeds that compete with rice for N.",
                    "https://th.bing.com/th/id/R.3eba97b47555a5f1b760e86280278628?rik=fRHAPARi7jqvwg&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2fnutrients-nitrogen-deficiency.jpg&ehk=V%2bfi4aMhyG3dK2h8x6UnnWyh37QT86iTz5dElir7KOo%3d&risl=&pid=ImgRaw&r=0");
            deficienciesToxicities.add(deficienciesToxicities1);

            DeficienciesToxicities deficienciesToxicities2 = new DeficienciesToxicities("Nitrogen (N) excess", "Fields with excessive nitrogen have plants that:\n" +
                    "- Look overly green\n" +
                    "- May be healthy, but also may be lodged at maturity (especially in direct-seeded rice)\n" +
                    "- May have thin stems\n" +
                    "- May be prone to disease (e.g., bacterial leaf blight, sheath blight, blast) or insects (leaffolder)\n" +
                    "There can also be patchy patterns resulting from uneven application across the field.",
                    "Problems in excess N happen when fertilizers are relatively cheap, and farmers do not understand the correct amount of nitrogen required relative to their yield goals and the right time of N application.\n" +
                            "Excessive N causes \"luxuriant\" growth, resulting in the plant being attractive to insects and/or diseases/pathogens. The excessive growth can also reduce stem strength resulting in lodging during flowering and grain filling.\n" +
                            "Excessive use of N also has negative implications for the environment and lowers farm profits.",
                    "To manage nitrogen excess:\n" +
                            "- Apply sufficient N to meet the plants' needs (20 kg N for each t of grain produced).\n" +
                            "- Identify how much N is coming from the soil and other sources (e.g., water or bacteria in the soil or water) and then apply the additional N to meet the yield goal.",
                    "https://th.bing.com/th/id/R.4d1e2820f95ea25aa2917192855592f1?rik=dVo3N5SO4MRG4w&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2fnitrogen-excess-leaf-color-chart.jpg&ehk=JOde6MY80Ruc6lGi%2fzb0IncOsawSQDpDQDmBTh3RAFw%3d&risl=&pid=ImgRaw&r=0");
            deficienciesToxicities.add(deficienciesToxicities2);

            DeficienciesToxicities deficienciesToxicities3 = new DeficienciesToxicities("Phosphorus (P) deficiency", "Check the field for the following symptoms:\n" +
                    "- Stunted plants\n" +
                    "- Reduced tillering\n" +
                    "- Older leaves are narrow, short, very erect, and have a \"dirty\" dark green colour\n" +
                    "- Stems are thin and spindly, and plant development is retarded\n" +
                    "- The number of leaves, panicles, and grains per panicle is also reduced. Young leaves may appear to be healthy, but older leaves turn brown and die.\n" +
                    "\n" +
                    "Also, check for discolouration:\n" +
                    "- Leaves appear pale green when P and Nitrogen (N) deficiency occur simultaneously\n" +
                    "- Red and purple colours may develop in leaves if the variety has a tendency to produce anthocyanin",
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
                    "To manage phosphorus deficiency:\n" +
                            "- Use high-quality seeds of a high-yielding variety.\n" +
                            "- Use rice cultivars that use P efficiently, particularly on acid upland soils.\n" +
                            "- In rice-rice systems, carry out dry, shallow tillage (10 cm) within two weeks after harvest. On acid, low-fertility rainfed lowland and upland soils, all existing soil fertility problems (acidity, Al toxicity, and deficiencies of Magnesium, Potassium, and other nutrients) must be corrected before a response to P is obtained.\n" +
                            "- Incorporate rice straw. Although the total amount of P recycled with the straw is small (1 kg P t-1 straw), it will contribute to maintaining a positive P balance in the long term.\n" +
                            "- Apply optimum doses of N and K and correct micronutrient deficiencies.\n" +
                            "- Replenish P removed in crop products by applying P fertilizers, farmyard manure, or other materials (night soil, compost).\n" +
                            "- Apply fertilizers efficiently.",
                    "https://th.bing.com/th/id/R.dcf9a0264e1b5ca7f4e92b75692af0df?rik=3iFbw1ChTOhaog&riu=http%3a%2f%2fwww.knowledgebank.irri.org%2fimages%2fstories%2fnutrients-phosphorus-deficiency.jpg&ehk=eWkGvEch7HySY5bUqJ8Epv%2fOYYHGdsWtB32GbvXEzD8%3d&risl=&pid=ImgRaw&r=0");
            deficienciesToxicities.add(deficienciesToxicities3);

            DeficienciesToxicities deficienciesToxicities4 = new DeficienciesToxicities("Potassium (K) deficiency", "Check the plants for discolouration:\n" +
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
                    "To manage potassium deficiency\n" +
                            "- Estimate K input from indigenous sources to assess site-specific K requirements.\n" +
                            "- Increase K uptake by improving soil management practices on root health (e.g., deep tillage to improve percolation to at least 3-5 mm d-1 and to avoid excessively reducing conditions in soil).\n" +
                            "- Establish an adequate population of healthy rice plants by using high-quality seeds of a modern variety with multiple pest resistance, and optimum crop maintenance (water and pest management).\n" +
                            "- Incorporate rice straw. If straw burning is the only option for crop residue management, spread the straw evenly over the field (e.g., as it is left after combine harvest) before burning. Ash from burnt straw heaps should also be spread over the field.\n" +
                            "- Apply optimum doses of N and P fertilizers and correct micronutrient deficiencies. Apply K fertilizers, farmyard manure, or other materials (rice husk, ash, night soil, compost) to replenish K removed in harvested crop products.",
                    "https://www.pinoyrice.com/wp-content/uploads/potassium-deficient.jpg");
            deficienciesToxicities.add(deficienciesToxicities4);

            for (DeficienciesToxicities d : deficienciesToxicities){
                deficienciesToxicitiesDao.insert(d);
            }

            //*****Crop-Deftox*****
            CropDeftoxDao cropDeftoxDao = db.cropDeftoxDao();
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM18"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM18"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) excess")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM18"), deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("OM18"), deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency")));

            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("DT08"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("DT08"), deficienciesToxicitiesDao.getIdByName("Nitrogen (N) excess")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("DT08"), deficienciesToxicitiesDao.getIdByName("Phosphorus (P) deficiency")));
            cropDeftoxDao.insert(new CropDeftox(cropDao.getIdByName("DT08"), deficienciesToxicitiesDao.getIdByName("Potassium (K) deficiency")));

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
