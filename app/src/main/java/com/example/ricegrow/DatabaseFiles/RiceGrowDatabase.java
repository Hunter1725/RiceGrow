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
import com.example.ricegrow.DatabaseFiles.Dao.CropDiseaseDao;
import com.example.ricegrow.DatabaseFiles.Dao.CropPestDao;
import com.example.ricegrow.DatabaseFiles.Dao.DiseaseDao;
import com.example.ricegrow.DatabaseFiles.Dao.DiseasePesticideDao;
import com.example.ricegrow.DatabaseFiles.Dao.DiseaseStageDao;
import com.example.ricegrow.DatabaseFiles.Dao.FertilizerDao;
import com.example.ricegrow.DatabaseFiles.Dao.PestDao;
import com.example.ricegrow.DatabaseFiles.Dao.PestPesticideDao;
import com.example.ricegrow.DatabaseFiles.Dao.PestStageDao;
import com.example.ricegrow.DatabaseFiles.Dao.PesticideDao;
import com.example.ricegrow.DatabaseFiles.Dao.PlanActivityDao;
import com.example.ricegrow.DatabaseFiles.Dao.PlanFertilizerDao;
import com.example.ricegrow.DatabaseFiles.Dao.PlanStageDao;
import com.example.ricegrow.DatabaseFiles.Dao.StageDao;
import com.example.ricegrow.DatabaseFiles.Dao.UserCropDao;
import com.example.ricegrow.DatabaseFiles.Dao.UserDao;
import com.example.ricegrow.DatabaseFiles.Model.Activities;
import com.example.ricegrow.DatabaseFiles.Model.ActivityFertilizers;
import com.example.ricegrow.DatabaseFiles.Model.ActivityPesticides;
import com.example.ricegrow.DatabaseFiles.Model.CropDiseases;
import com.example.ricegrow.DatabaseFiles.Model.CropPests;
import com.example.ricegrow.DatabaseFiles.Model.Crops;
import com.example.ricegrow.DatabaseFiles.Model.Diseases;
import com.example.ricegrow.DatabaseFiles.Model.DiseasesPesticides;
import com.example.ricegrow.DatabaseFiles.Model.DiseasesStages;
import com.example.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.example.ricegrow.DatabaseFiles.Model.Pesticides;
import com.example.ricegrow.DatabaseFiles.Model.Pests;
import com.example.ricegrow.DatabaseFiles.Model.PestsPesticides;
import com.example.ricegrow.DatabaseFiles.Model.PestsStages;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanFertilizers;
import com.example.ricegrow.DatabaseFiles.Model.PlanPesticides;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.Stages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.Model.Users;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Activities.class, ActivityFertilizers.class, ActivityPesticides.class, CropDiseases.class,
                    CropPests.class, Crops.class, Diseases.class, DiseasesPesticides.class, DiseasesStages.class,
                    Fertilizers.class, Pesticides.class, Pests.class, PestsPesticides.class, PestsStages.class,
                    PlanActivities.class, PlanFertilizers.class, PlanPesticides.class, PlanStages.class, Stages.class,
                    UserCrops.class, Users.class}, version = 1)
public abstract class RiceGrowDatabase extends RoomDatabase {
    public abstract ActivityDao activityDao();
    public abstract ActivityFertilizerDao activityFertilizerDao();
    public abstract ActivityPesticideDao activityPesticideDao();
    public abstract CropDao cropDao();
    public abstract CropDiseaseDao cropDiseaseDao();
    public abstract CropPestDao cropPestDao();
    public abstract DiseaseDao diseaseDao();
    public abstract DiseasePesticideDao diseasePesticideDao();
    public abstract DiseaseStageDao diseaseStageDao();
    public abstract FertilizerDao fertilizerDao();
    public abstract PestDao pestDao();
    public abstract PesticideDao pesticideDao();
    public abstract PestPesticideDao pestPesticideDao();
    public abstract PestStageDao pestStageDao();
    public abstract PlanActivityDao planActivityDao();
    public abstract PlanFertilizerDao planFertilizerDao();
    public abstract PlanStageDao planStageDao();
    public abstract StageDao stageDao();
    public abstract UserCropDao userCropDao();
    public abstract UserDao userDao();


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

            //****Crops****
            CropDao cropDao = db.cropDao();
            ArrayList<Crops> crops = new ArrayList<>();
            Crops crop1 = new Crops("OM18", "OM18 rice was selected from OM 8017/ OM 5166 hybrid combination, this is an aromatic rice variety with outstanding advantages such as high salt tolerance at 3-4 levels, pest resistance, especially high resistance and stability. with blast, high yield and short growth duration.",
                                    97, 6700, 3.6, "https://loctroi.vn/UploadFiles/ImgUpload/OM%2018%201.png");
            crops.add(crop1);
            Crops crop2 = new Crops("DT08", "DT08 (Dai Thom 08) is a high-quality type of Vietnam fragrant rice grown in Viet Nam. DT08 rice has medium grains, with an evenly bright-white color. DT08 rice has a short growth period; therfore, there are 3 crops of DT08 rice per year, which are harvested in the spring, autumn and winter. When cooked, the texture of DT08 rice is soft and remains sticky after cooling.",
                    100, 7000, 3.9, "https://danviet.mediacdn.vn/2020/10/16/dai-thom-8-3-16028306562021544130115-crop-1602830669005866812402.jpg");
            crops.add(crop2);
            for (Crops c : crops){
                cropDao.insert(c);
            }

            //****Pests****
            PestDao pestDao = db.pestDao();
            ArrayList<Pests> pests = new ArrayList<>();
            Pests pests1 = new Pests("Rice leaffolder", "The life cycle of Rice leaffolder is about 1.5 months. The egg stage lasts for 5 days, the larval stage lasts for 25 days, the pupal stage lasts for 7 days, and the adult moth stage lasts for 10 days. During the larval stage, the leaffolder caterpillars fold the rice leaves around themselves and attach the leaf margins together with silk strands. Rice leaffolders occur in all rice environments and are more abundant during the rainy seasons. They are commonly found in shady areas and areas where rice is heavily fertilized. In tropical rice areas, they are active year-round, whereas, in temperate countries, they are active from May to October.",
                                    "Check the plant for the following symptoms:\n" +
                                            "\n" +
                                            "longitudinal and transparent whitish streaks on damaged leaves\n" +
                                            "tubular folded leaves\n" +
                                            "leaf tips sometimes fastened to the basal part of leaf\n" +
                                            "heavily infested fields appear scorched with many folded leaves\n" +
                                            "Also check for presence of insects, particularly during tillering to flowering. Signs include:\n" +
                                            "\n" +
                                            "disc-shaped ovoid eggs laid singly,\n" +
                                            "young larvae feeding on the base of the youngest unopened leaves,\n" +
                                            "folded leaves enclosing the feeding larvae, and present fecal matter.",
                                    "Leaffolder caterpillars fold a rice leaf around themselves and attach the leaf margins together with silk strands. They feed inside the folded leaf creating longitudinal white and transparent streaks on the blade.",
                                    "To prevent leaffolder outbreaks:\n" +
                                            "\n" +
                                            "Use resistant varieties.\n" +
                                            "Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                                            "Follow rice with a different crop, or fallow period.\n" +
                                            "Avoid ratooning.\n" +
                                            "Flood and plow field after harvesting if possible.\n" +
                                            "Remove grassy weeds from fields and borders.\n" +
                                            "Reduce density of planting.\n" +
                                            "Use balanced fertilizer rates.", "http://www.knowledgebank.irri.org/images/stories/factsheet-leaffolder-1.jpg");
            pests.add(pests1);
            Pests pests2 = new Pests("Planthopper", "The life cycle of planthoppers is usually about 40 days, depending on the species and the environment. The eggs usually hatch between 6 to 8 days, planthoppers stay in the nymph phase for about 16-18 days and adult planthoppers live for about 15-20 days. Different species of planthoppers have different life cycles. For example, the brown planthopper completes its lifecycle in 18 to 24 days between June and October, 38 to 44 days between November and January, and 18 to 35 days between February and April1.",
                    "Check for the presence of insect:\n" +
                            "\n" +
                            "crescent-shaped white eggs inserted into the midrib or leaf sheath\n" +
                            "white to brown nymphs\n" +
                            "brown or white adults feeding near the base of tillers\n" +
                            "\n" +
                            "Check the field for:\n" +
                            "\n" +
                            "hopperburn or yellowing, browning and drying of plant\n" +
                            "ovipositional marks exposing the plant to fungal and bacterial infections\n" +
                            "presence of honeydew and sooty molds in the bases of areas infected\n" +
                            "plants with ragged stunt or grassy stunt virus disease\n" +
                            "Hopperburn is similar to the feeding damage or \"bugburn\" caused by the rice black bug. To confirm hopperburn caused by planthoppers, check for the presence of sooty molds at the base of the plant.",
                    "The high population of planthoppers cause leaves to initially turn orange-yellow before becoming brown and dry and this is a condition called hopperburn that kills the plant. BPH can also transmit Rice Ragged Stunt and Rice Grassy Stunt diseases. Neither disease can be cured.",
                    "To control planthoppers:\n" +
                            "\n" +
                            "Mechanical & physical measures\n" +
                            "\n" +
                            "Flood the seedbed, for a day, so that only the tips of seedlings are exposed will control BPH.\n" +
                            "Sweep small seedbeds with a net to remove some BPH (but not eggs), particularly from dry seed beds. At high BPH densities, sweeping will not remove sufficient numbers of BPH from the base of the plant.\n" +
                            "Biological control\n" +
                            "\n" +
                            "If natural enemies out-number BPH the risk of hopperburn is low. Even rice already damaged by hopperburn should not be treated with insecticides if natural enemies out-number BPH. Natural enemies of BPH include water striders, mirid bugs, spiders, and various egg parasitoids.\n" +
                            "Chemical control\n" +
                            "\n" +
                            "Only apply insecticides to the seedbed, for BPH or WBPH, if all of these conditions are met: an average of more than one planthopper per stem, on average, more planthoppers than natural enemies,flooding the seedbed is not an option.",
                            "http://www.knowledgebank.irri.org/images/stories/factsheet-planthopper-1.jpg");
            pests.add(pests2);
            Pests pests3 = new Pests("Stem borer", "The life cycle of stem borers consists of four stages: egg, larva, pupa and adult. After sunset, the male and female moths come together and after sexual union the eggs are fertilized internally. The eggs are laid in batches of 10-80 on the upperside and underside of leaf surfaces, usually close to the midrib. They hatch after 4-10 days. Younger larvae (caterpillars) feed on the leaf whorl. Older larvae tunnel into the stems, and it is within these tunnels that they feed and grow for about 2-3 weeks.",
                            "Check the field for the following damage symptoms:\n" +
                                    "Deadhearts or dead tillers that can be easily pulled from the base during the vegetative stages\n" +
                                    "Whiteheads during reproductive stage where the emerging panicles are whitish and unfilled or empty\n" +
                                    "Tiny holes on the stems and tillers\n" +
                                    "Frass or fecal matters inside the damaged stems\n" +
                                    "\n" +
                                    "To confirm stem borer damage, visually inspect rice crop for deadhearts in the vegetative stages and whiteheads in reproductive stages. Stems can be pulled and dissected for larvae and pupae for confirmation of stem borer damage.",
                            "Stem borers can destroy rice at any stage of the plant from seedling to maturity. They feed upon tillers and cause deadhearts or drying of the central tiller, during the vegetative stage; and cause whiteheads at reproductive stage.",
                            "To manage the Stem borer:\n" +
                                    "Use resistant varieties\n" +
                                    "At seedbed and transplanting, handpick and destroy egg masses\n" +
                                    "Raise level of irrigation water periodically to submerge the eggs deposited on the lower parts of the plant\n" +
                                    "Before transplanting, cut the leaf-top to reduce carry-over of eggs from the seedbed to the field\n" +
                                    "Ensure proper timing of planting and synchronous planting, harvest crops at ground level to remove the larvae in stubble, remove stubble and volunteer rice, plow and flood the field\n" +
                                    "Encourage biological control agents: braconid, eulophid, mymarid, scelionid, chalcid, pteromalid and trichogrammatid wasps, ants, lady beetles, staphylinid beetles, gryllid, green meadow grasshopper, and mirid, phorid and platystomatid flies, bethylid, braconid, elasmid, eulophid, eurytomid and ichneumonid wasps, carabid and lady bird beetles, chloropid fly, gerrid and pentatomid bugs, ants, and mites,  earwigs, bird, asilid fly, vespid wasp, dragonflies, damselflies, and spiders\n" +
                                    "Bacteria and fungi also infect the larvae: mermithid nematode, chalcid, elasmid and eulophid\n" +
                                    "Apply nitrogen fertilizer in split following the recommended rate and time of application.",
                                "http://www.knowledgebank.irri.org/images/stories/stem-borer-larvae.jpg");
            pests.add(pests3);
            for (Pests p : pests){
                pestDao.insert(p);
            }

            //****Crops-Pests****
            CropPestDao cropPestDao = db.cropPestDao();
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Rice leaffolder")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Planthopper")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("OM18"), pestDao.getIdByName("Stem borer")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Rice leaffolder")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Planthopper")));
            cropPestDao.insert(new CropPests(cropDao.getIdByName("DT08"), pestDao.getIdByName("Stem borer")));

            //****Diseases****
            DiseaseDao diseaseDao = db.diseaseDao();
            ArrayList<Diseases> diseases = new ArrayList<>();
            Diseases diseases1 = new Diseases("Blast", "Check the leaf and collar for lesions:\n" +
                    "\n" +
                    "Initial symptoms appear as white to gray-green lesions or spots, with dark green borders.\n" +
                    "Older lesions on the leaves are elliptical or spindle-shaped and whitish to gray centers with red to brownish or necrotic border.\n" +
                    "Check for other symptoms:\n" +
                    "Some resemble diamond shape, wide in the center and pointed toward either ends.\n" +
                    "Lesions can enlarge and coalesce, growing together, to kill the entire leaves.",
                    "Blast is caused by the fungus Magnaporthe oryzae. It can affect all above ground parts of a rice plant: leaf, collar, node, neck, parts of panicle, and sometimes leaf sheath.",
                    "Crop management measures can also be done, such as:\n" +
                            "Adjust planting time. Sow seeds early, when possible, after the onset of the rainy season.\n" +
                            "Split nitrogen fertilizer application in two or more treatments. Excessive use of fertilizer can increase blast intensity.\n" +
                            "Flood the field as often as possible.\n" +
                            "Silicon fertilizers (e.g., calcium silicate) can be applied to soils that are silicon deficient to reduce blast. However, because of its high cost, silicon should be applied efficiently. Cheap sources of silicon, such as straws of rice genotypes with high silicon content, can be an alternative. Care should be taken to ensure that the straw is free from blast as the fungus can survive on rice straw and the use of infected straw as a silicon source can spread the disease further.\n" +
                            "Systemic fungicides like triazoles and strobilurins can be used judiciously for control to control blast. A fungicide application at heading can be effective in controlling the disease.",
                    "http://www.knowledgebank.irri.org/images/stories/blast-leaf-4.jpg");
            diseases.add(diseases1);
            Diseases diseases2 = new Diseases("Leaf Scald", "Check the plant for the following symptoms:\n" +
                    "\n" +
                    "zonate lesions of alternating light tan and dark brown starting from leaf tips or edges\n" +
                    "oblong lesions with light brown halos in mature leaves\n" +
                    "translucent leaf tips and margins\n" +
                    "Individual lesions are 1−5 cm long and 0.5−1 cm wide or may almost cover the entire leaf. The continuous enlargement and coalescing of lesions result in blighting of a large part of the leaf blade. The affected areas dry out giving the leaf a scalded appearance.",
                    "Leaf scald is a fungal disease caused by Microdochium oryzae, which causes the scalded appearance of leaves.",
                    "To manage leaf scald\n" +
                            "Use resistant varieties.\n" +
                            "Contact your local agriculture office for an up-to-date list of available varieties.\n" +
                            "Avoid high use of fertilizer. Apply Nitrogen in split.\n" +
                            "Use benomyl, carbendazim, quitozene, and thiophanate-methyl to treat seeds.\n" +
                            "In the field, spraying of benomyl, fentin acetate, edifenphos, and validamycin significantly reduce the incidence of leaf scald. Foliar application of captafol, mancozeb, and copper oxychloride also reduces the incidence and severity of the fungal disease.\n" +
                            "\n" +
                            "To prevent pathogen survival across cropping seasons:\n" +
                            "Remove weeds.\n" +
                            "Plow under of rice stubbles.\n" +
                            "Remove infected rice ratoons.", "http://www.knowledgebank.irri.org/images/stories/leaf-scald.jpg");
            diseases.add(diseases2);
            Diseases diseases3 = new Diseases("Sheath rot", "Although sheath rot can be observed in the field as a single disease on rice sheath, more often, it has become part of a complex of grain and leaf sheath discolouration commonly observed on wet-season rice.\n" +
                    "Check for lesions: The typical sheath rot lesion starts at the uppermost leaf sheath enclosing the young panicles. It appears oblong or as irregular spot with dark reddish, brown margins, and gray center or brownish gray throughout.\n" +
                    "Check for spots:Usually several spots are observed and these spots enlarge and combine or grow together and can cover most of the leaf sheath. Panicles remain within the sheath or may partially emerge. Affected leaf sheaths may have abundant whitish powdery fungal growth (mycelium) visible on the outer surface. Panicles that have not emerged rot and the florets turn red-brown to dark brown.\n",
                    "Sheath rot is caused by Sarocladium oryzae. The disease reduces grain yield by retarding or aborting panicle emergence and producing unfilled seeds and sterile panicles. Sheath rot also reduces grain quality by causing panicles to rot and grains to become discoloured.",
                    "To manage sheath rot:\n" +
                            "Sheath rot is a seed-borne disease, use healthy seeds.\n" +
                            "Minimize insect infestation in rice fields. Insects cause injuries to the plants that allow the fungi to enter the plant and cause infection.\n" +
                            "The fungi survive on rice crop residue after harvest and can cause infection in the following seasons. Remove infected stubbles after harvest.\n" +
                            "Use optimum plant spacing. Sow three plants per hill at 20 cm row spacing.\n" +
                            "Apply potash at tillering stage.\n" +
                            "Apply foliar spray of calcium sulfate and zinc sulfate.\n" +
                            "Apply a seed treatment fungicide like carbendazim, edifenphos, or mancozeb as seed treatment and foliar spraying at the heading stage.\n" +
                            "Apply a foliar fungicide like benomyl and copper oxychloride as foliar sprays.", "http://www.knowledgebank.irri.org/images/stories/sheath-rot-1.jpg");
            diseases.add(diseases3);
            Diseases diseases4 = new Diseases("Brown spot", "Check for lesions:\n" +
                    "Infected seedlings have small, circular, yellow brown or brown lesions that may girdle the coleoptile and distort primary and secondary leaves.\n" +
                    "Starting at tillering stage, lesions can be observed on the leaves. They are initially small, circular, and dark brown to purple-brown.\n" +
                    "Fully developed lesions are circular to oval with a light brown to gray center, surrounded by a reddish brown margin caused by the toxin produced by the fungi.",
                    "Brown spot has been historically largely ignored as one of the most common and most damaging rice diseases.",
                    "Improving soil fertility is the first step in managing brown spot. To do this:\n" +
                            "monitor soil nutrients regularly\n" +
                            "apply required fertilizers\n" +
                            "for soils that are low in silicon, apply calcium silicate slag before planting\n" +
                            "Fertilizers, however, can be costly and may take many cropping seasons before becoming effective. More economical management options include:\n" +
                            "\n" +
                            "Use resistant varieties. \n" +
                            "Contact your local agriculture office for up-to-date lists of varieties available.\n" +
                            "Use fungicides (e.g., iprodione, propiconazole, azoxystrobin, trifloxystrobin, and carbendazim) as seed treatments.\n" +
                            "Treat seeds with hot water (53−54°C) for 10−12 minutes before planting, to control primary infection at the seedling stage. To increase the effectiveness of treatment, pre-soak seeds in cold water for eight hours.",
                    "http://www.knowledgebank.irri.org/images/stories/brown-spot-3.jpg");
            diseases.add(diseases4);
            for (Diseases d : diseases){
                diseaseDao.insert(d);
            }

            //****Crops-Diseases****
            CropDiseaseDao cropDiseaseDao = db.cropDiseaseDao();
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Blast")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Leaf Scald")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Sheath rot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("OM18"), diseaseDao.getIdByName("Brown spot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Blast")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Leaf Scald")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Sheath rot")));
            cropDiseaseDao.insert(new CropDiseases(cropDao.getIdByName("DT08"), diseaseDao.getIdByName("Brown spot")));

            //****Pesticides****
            PesticideDao pesticideDao = db.pesticideDao();
            ArrayList<Pesticides> pesticides = new ArrayList<>();
            Pesticides pesticides1 = new Pesticides("Padan 95SP", "Sumitomo Chemical", "Cartap (min 97%) : 950 g/kg", "Dosage: 0.5 – 0.7 kg/ha\n" +
                    "PreHarvest Interval- PHI: 7 days (Time interval in days from last handling to harvest)\n" +
                    "How to use: The amount of water sprayed from 400 to 600 liters/ha." +
                    "It is not recommended to use alum water to mix with Padan 95SP insecticide.", 30, 400,
                    "https://vietnong.vn/wp-content/uploads/2022/04/PANDAN-95-01-768x768.jpg");
            pesticides.add(pesticides1);

            Pesticides pesticides2 = new Pesticides("Regent 800WG", "Bayer", "Fipronil (min 95 %): 800g/kg",
                    "Dosage: 32 g/ha\n" +
                            "Quarantine period (PreHarvest Interval- PHI): 15 days (Duration in days from last handling to harvest)\n" +
                            "Usage: The amount of water sprayed is 210 - 600 liters/ha. Spray when pests appear", 32, 600,"https://vuonsaigon.vn/wp-content/uploads/2019/12/regent-1g-599x599.jpg");
            pesticides.add(pesticides2);

            Pesticides pesticides3 = new Pesticides("ANTRACOL 70WP", "Bayer", "Propineb (min 80%) : 700 g/kg",
                    "Dosage: 1.5 kg/ha\n" +
                            "PreHarvest Interval- PHI: 7 days (Time interval in days from last handling to harvest)\n" +
                            "Usage: The amount of water sprayed is 320 - 800 liters/ha. Spray when the disease appears", 64, 800, "https://www.cropscience.bayer.com.vn/-/media/Bayer%20CropScience/Country-Vietnam-Internet/2019/07/antracol_package.jpg");
            pesticides.add(pesticides3);

            Pesticides pesticides4 = new Pesticides("Xantocin 40WP", "VFC", "Bronopol (min 99%) : 40% w/w", "Dosage: 0.2 – 0.25 kg/ha\n" +
                    "PreHarvest Interval- PHI: 1 day (Time interval in days from last handling to harvest)\n" +
                    "Usage: The amount of water sprayed 400 - 500 liters/ha. Spray when the disease rate is about 5-10%",
                    10, 600, "https://vietnong.vn/wp-content/uploads/2022/12/thuoc-bvtv-xantocin-40wp-768x672.jpg");
            pesticides.add(pesticides4);
            for (Pesticides p : pesticides){
                pesticideDao.insert(p);
            }
            //****Pests-Pesticides****
            PestPesticideDao pestPesticideDao = db.pestPesticideDao();
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Padan 95SP"), pestDao.getIdByName("Rice leaffolder")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Padan 95SP"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Planthopper")));
            pestPesticideDao.insert(new PestsPesticides(pesticideDao.getIdByName("Regent 800WG"), pestDao.getIdByName("Rice leaffolder")));

            //****Diseases-Pesticides****
            DiseasePesticideDao diseasePesticideDao = db.diseasePesticideDao();
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("ANTRACOL 70WP"), diseaseDao.getIdByName("Blast")));
            diseasePesticideDao.insert(new DiseasesPesticides(pesticideDao.getIdByName("Xantocin 40WP"), diseaseDao.getIdByName("Leaf Scald")));

            //****Stages****
            StageDao stageDao = db.stageDao();
            ArrayList<Stages> stages = new ArrayList<>();
            Stages stages1_OM18 = new Stages(cropDao.getIdByName("OM18"), "Land preparation", 24, 1, false, "1st", "24th", "http://www.knowledgebank.irri.org/images/stories/landprep-wetpreparation-1.jpg");
            stages.add(stages1_OM18);
            Stages stages2_OM18 = new Stages(cropDao.getIdByName("OM18"), "Seeding", 1, 2, false, "25th", "25th", "http://www.knowledgebank.irri.org/images/stories/planting-broadcasting.jpg");
            stages.add(stages2_OM18);
            Stages stages3_OM18 = new Stages(cropDao.getIdByName("OM18"), "Seed germination", 10, 3, false, "26th", "35th", "http://www.knowledgebank.irri.org/images/stories/factsheet-seed_germination.jpg");
            stages.add(stages3_OM18);
            Stages stages4_OM18 = new Stages(cropDao.getIdByName("OM18"), "Tillering", 40, 4, false, "36th", "75th", "https://th.bing.com/th/id/OIP.s-LJu8ILykos3__FpU2T2QHaFj?pid=ImgDet&rs=1");
            stages.add(stages4_OM18);
            Stages stages5_OM18 = new Stages(cropDao.getIdByName("OM18"), "Panicle initiation", 18, 5, false, "76th", "93th", "https://assets.corteva.com/is/image/Corteva/IMG_0672_close-up_of_rice_plants");
            stages.add(stages5_OM18);
            Stages stages6_OM18 = new Stages(cropDao.getIdByName("OM18"), "Heading", 10, 6, false, "94th", "103th", "https://oba-shima.mito-city.com/wp/wp-content/uploads/2013/08/inenohana-8.jpg");
            stages.add(stages6_OM18);
            Stages stages7_OM18 = new Stages(cropDao.getIdByName("OM18"), "Flowering", 10, 7, false, "104th", "113th", "https://th.bing.com/th/id/R.624deda3b79e82c7eb20310bfadae590?rik=zUVfOL9WWyayWg&riu=http%3a%2f%2fimg.zhiwushuo.com%2fuploads%2fallimg%2f202149%2f20210609024642741.jpg&ehk=Xn4Q9nFs7rqVqTe29NZWmrlfcWVxDIuz84Si5FVwYIk%3d&risl=&pid=ImgRaw&r=0");
            stages.add(stages7_OM18);
            Stages stages8_OM18 = new Stages(cropDao.getIdByName("OM18"), "Milk", 10, 8, false, "114th", "123th", "https://th.bing.com/th/id/R.fa825926cfaa783b838e1c3298471843?rik=7ecRRwkUYy1Mlg&riu=http%3a%2f%2fagritech.tnau.ac.in%2fagriculture%2fphoto_bank%2frice%2fimages%2f033.+Paddy+field+%40+milking+stage.jpg&ehk=FXHMFODGyU4M%2bGZ2CLYLkYW%2fyFCMTvWXIXwEofY9d%2bs%3d&risl=&pid=ImgRaw&r=0");
            stages.add(stages8_OM18);
            Stages stages9_OM18 = new Stages(cropDao.getIdByName("OM18"), "Dough", 10, 9, false, "124th", "133th", "https://www.en.krishakjagat.org/wp-content/uploads/2020/12/trieu-tan-lua.jpg");
            stages.add(stages9_OM18);
            Stages stage10_OM18 = new Stages(cropDao.getIdByName("OM18"), "Mature", 10, 10, false, "134th", "143th", "https://qph.fs.quoracdn.net/main-qimg-e430ecabafc3856bb49038f999d57186");
            stages.add(stage10_OM18);
            Stages stages11_OM18 = new Stages(cropDao.getIdByName("OM18"), "Harvest", 1, 11, false, "144th", "144th", "https://th.bing.com/th/id/OIP.jK8a-oRAOY1A3uYJ1qm7MgAAAA?pid=ImgDet&rs=1");
            stages.add(stages11_OM18);
            for (Stages s : stages){
                stageDao.insert(s);
            }

            //*****Stages-Pests****
            PestStageDao pestStageDao = db.pestStageDao();
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Tillering"), pestDao.getIdByName("Stem borer")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Tillering"), pestDao.getIdByName("Rice leaffolder")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Panicle initiation"), pestDao.getIdByName("Rice leaffolder")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Heading"), pestDao.getIdByName("Rice leaffolder")));
            pestStageDao.insert(new PestsStages(stageDao.getIdByName("Heading"), pestDao.getIdByName("Planthopper")));

            //****Stages-Diseases****
            DiseaseStageDao diseaseStageDao = db.diseaseStageDao();
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Tillering"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Tillering"), diseaseDao.getIdByName("Leaf Scald")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Brown spot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Panicle initiation"), diseaseDao.getIdByName("Leaf Scald")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Leaf Scald")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Heading"), diseaseDao.getIdByName("Sheath rot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Blast")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Flowering"), diseaseDao.getIdByName("Sheath rot")));
            diseaseStageDao.insert(new DiseasesStages(stageDao.getIdByName("Milk"), diseaseDao.getIdByName("Sheath rot")));

            //****Activities****
            ActivityDao activityDao = db.activityDao();
            ArrayList<Activities> activities = new ArrayList<>();
            Activities activities1 = new Activities(stageDao.getIdByName("Land preparation"), "Bunds or dikes", "Bunds or dikes enable the field to hold water. This is important especially in areas where water supply is not reliable.",1);
            activities.add(activities1);
            Activities activities2 = new Activities(stageDao.getIdByName("Land preparation"), "Irrigate the field", "Irrigate the field with 2−3 cm of water for about 3−7 days or until it is soft enough and suitable for an equipment to be used.", 7);
            activities.add(activities2);
            Activities activities3 = new Activities(stageDao.getIdByName("Land preparation"), "Perform primary tillage operations", "Primary tillage is normally undertaken when the soil is wet enough to allow the field to be plowed and strong enough to give reasonable levels of traction. This can be immediately after harvest or at the beginning of the next season, depending on soil moisture and water availability.", 2);
            activities.add(activities3);
            Activities activities4 = new Activities(stageDao.getIdByName("Land preparation"), "Flood the field", "Keep the field submerged for 10−14 days after plowing to soften clods and to decompose organic materials.", 10);
            activities.add(activities4);
            Activities activities5 = new Activities(stageDao.getIdByName("Land preparation"), "Perform secondary tillage operations", "Depending on climate and soil type, this should be done 10−14 days after primary workings.", 2);
            activities.add(activities5);
            Activities activities6 = new Activities(stageDao.getIdByName("Land preparation"), "Level the field", "Levelling should be done two (2) days before planting. A levelled and smooth soil surface provides for uniform germination and growth of the crops. A well-levelled field improves water coverage and is also proven to increase crop yield and quality.", 2);
            activities.add(activities6);
            Activities activities7 = new Activities();
    });
    }
}
