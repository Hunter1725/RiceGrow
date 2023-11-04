package com.hunter.ricegrow.DatabaseFiles;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.os.Parcel;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.hunter.ricegrow.DatabaseFiles.Model.Activities;
import com.hunter.ricegrow.DatabaseFiles.Model.Crops;
import com.hunter.ricegrow.DatabaseFiles.Model.Fertilizers;
import com.hunter.ricegrow.DatabaseFiles.Model.Pests;
import com.hunter.ricegrow.DatabaseFiles.Model.Stages;
import com.hunter.ricegrow.DatabaseFiles.Model.UserCrops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RiceGrowDatabaseTest {
    private RiceGrowDatabase database;

    @Before
    public void createDatabase() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, RiceGrowDatabase.class).build();
    }

    @After
    public void closeDatabase() throws IOException {
        database.close();
    }

    @Test
    public void insertAndRetrieveCrops() throws Exception {
        // Create a sample crop
        Crops crop = new Crops("SampleCrop", "DescriptionEn", "DescriptionVi", 100, 200.0, 3.0, "https://sample-url.com");

        // Insert the crop into the database
        database.cropDao().insert(crop);

        // Retrieve the crop by ID
        Crops retrievedCrop = database.cropDao().getCropById(1); // Assuming you have a method to get crops by ID

        // Assert that the retrieved crop matches the inserted crop
        assertEquals("SampleCrop", retrievedCrop.getName());
        assertEquals("DescriptionEn", retrievedCrop.getDescriptionEn());
        assertEquals("DescriptionVi", retrievedCrop.getDescriptionVi());
        assertEquals(100, retrievedCrop.getGrowthPeriod());
        assertEquals(200.0, retrievedCrop.getSellingPrice(),0.001);
        assertEquals(3.0, retrievedCrop.getSaltTolerance(), 0.001); // Use delta for double comparison
        assertEquals("https://sample-url.com", retrievedCrop.getCropImage());
    }

    @Test
    public void retrieveAllCrops() throws Exception {
        // Create and insert multiple crops
        Crops crop1 = new Crops("Crop1", "DescriptionEn1", "DescriptionVn1", 100, 200.0, 3.0, "https://url1.com");
        Crops crop2 = new Crops("Crop2", "DescriptionEn2","DescriptionVi2", 150, 250.0, 2.5, "https://url2.com");
        database.cropDao().insert(crop1);
        database.cropDao().insert(crop2);

        // Retrieve all crops from the database
        List<Crops> crops = database.cropDao().getAllCrops();

        // Assert that the list contains the inserted crops
        assertEquals(2, crops.size());
        assertEquals("Crop1", crops.get(0).getName());
        assertEquals("Crop2", crops.get(1).getName());
    }

    @Test
    public void insertAndRetrieveCropPlan() throws Exception {
        //Create a  crop
        Crops crop1 = new Crops("Crop1", "DescriptionEn1", "DescriptionVn1", 100, 200.0, 3.0, "https://url1.com");
        database.cropDao().insert(crop1);


        // Create a sample crop plan
        int cropId = database.cropDao().getAllCrops().get(0).getId();
        String name = "Sample Crop";
        int color = 0xFF00FF; // Purple color
        double sowingAmount = 100.0;
        LocalDate startingDate = LocalDate.of(2023, 1, 1);
        double sowedArea = 200.0;
        LocalDate expectedHarvestDate = LocalDate.of(2023, 6, 30);
        int growthPeriod = 180;
        List<Integer> planStages = new ArrayList<>();
        planStages.add(1);
        planStages.add(2);

        UserCrops userCrops = new UserCrops(cropId, name, color, sowingAmount, startingDate, sowedArea, expectedHarvestDate, growthPeriod, planStages);
        // Insert the crop plan into the database
        database.userCropDao().insert(userCrops);

        // Retrieve the crop plan by ID
        UserCrops retrievedCropPlan = database.userCropDao().getUserCropsById(1); // Assuming you have a method to get crop plans by ID

        // Assert that the retrieved crop plan matches the inserted crop plan
        assertEquals(cropId, userCrops.getCropId());
        assertEquals(name, userCrops.getName());
        assertEquals(color, userCrops.getColor());
        assertEquals(sowingAmount, userCrops.getSowingAmount(), 0.01); // Use delta for double comparison
        assertEquals(startingDate, userCrops.getStartingDate());
        assertEquals(sowedArea, userCrops.getSowedArea(), 0.01); // Use delta for double comparison
        assertEquals(expectedHarvestDate, userCrops.getExpectedHarvestDate());
        assertEquals(growthPeriod, userCrops.getGrowthPeriod());
        assertEquals(planStages, userCrops.getPlanStages());
    }

    @Test
    public void testParcelableCropPlan() {
        int cropId = 1;
        String name = "Sample Crop";
        int color = 0xFF00FF; // Purple color
        double sowingAmount = 100.0;
        LocalDate startingDate = LocalDate.of(2023, 1, 1);
        double sowedArea = 200.0;
        LocalDate expectedHarvestDate = LocalDate.of(2023, 6, 30);
        int growthPeriod = 180;
        List<Integer> planStages = new ArrayList<>();
        planStages.add(1);
        planStages.add(2);

        UserCrops originalUserCrops = new UserCrops(cropId, name, color, sowingAmount, startingDate, sowedArea, expectedHarvestDate, growthPeriod, planStages);

        // Write the UserCrops to a Parcel
        Parcel parcel = Parcel.obtain();
        originalUserCrops.writeToParcel(parcel, originalUserCrops.describeContents());

        // Reset the parcel for reading
        parcel.setDataPosition(0);

        // Create a new UserCrops from the Parcel
        UserCrops createdUserCrops = UserCrops.CREATOR.createFromParcel(parcel);

        // Assert that the original and created UserCrops are equal
        assertEquals(originalUserCrops.getCropId(), createdUserCrops.getCropId());
        assertEquals(originalUserCrops.getName(), createdUserCrops.getName());
        assertEquals(originalUserCrops.getColor(), createdUserCrops.getColor());
        assertEquals(originalUserCrops.getSowingAmount(), createdUserCrops.getSowingAmount(), 0.01); // Use delta for double comparison
        assertEquals(originalUserCrops.getStartingDate(), createdUserCrops.getStartingDate());
        assertEquals(originalUserCrops.getSowedArea(), createdUserCrops.getSowedArea(), 0.01); // Use delta for double comparison
        assertEquals(originalUserCrops.getExpectedHarvestDate(), createdUserCrops.getExpectedHarvestDate());
        assertEquals(originalUserCrops.getGrowthPeriod(), createdUserCrops.getGrowthPeriod());
        assertEquals(originalUserCrops.getPlanStages(), createdUserCrops.getPlanStages());
    }

    @Test
    public void insertAndRetrievePests() throws Exception {
        // Create a sample pest
        Pests pest = new Pests(
                "Sample Pest",
                "Pest Name Vi",
                "Science Name En",
                "Science Name Vi",
                "Life Cycle En",
                "Life Cycle Vi",
                "Symptoms En",
                "Symptoms Vi",
                "Description En",
                "Description Vi",
                "Control Methods En",
                "Control Methods Vi",
                "https://sample-pest-url.com"
        );

        // Insert the pest into the database
        database.pestDao().insert(pest);

        // Retrieve the pest by ID
        Pests retrievedPest = database.pestDao().getAllPests().get(0); // Assuming you have a method to get pests by ID

        // Assert that the retrieved pest matches the inserted pest
        assertEquals("Sample Pest", retrievedPest.getNameEn());
        assertEquals("Pest Name Vi", retrievedPest.getNameVi());
        assertEquals("Science Name En", retrievedPest.getScienceNameEn());
        assertEquals("Science Name Vi", retrievedPest.getScienceNameVi());
        assertEquals("Life Cycle En", retrievedPest.getLifecycleEn());
        assertEquals("Life Cycle Vi", retrievedPest.getLifecycleVi());
        assertEquals("Symptoms En", retrievedPest.getSymptomsEn());
        assertEquals("Symptoms Vi", retrievedPest.getSymptomsVi());
        assertEquals("Description En", retrievedPest.getDescriptionEn());
        assertEquals("Description Vi", retrievedPest.getDescriptionVi());
        assertEquals("Control Methods En", retrievedPest.getControlMethodsEn());
        assertEquals("Control Methods Vi", retrievedPest.getControlMethodsVi());
        assertEquals("https://sample-pest-url.com", retrievedPest.getPestImage());
    }

    @Test
    public void insertAndRetrieveFertilizers() throws Exception {
        // Create a sample fertilizer
        Fertilizers fertilizer = new Fertilizers(
                "Sample Fertilizer",
                "Manufacturer En",
                "Manufacturer Vi",
                "Composition En",
                "Composition Vi",
                "Usage Instructions En",
                "Usage Instructions Vi",
                250.0, // Recommended Usage
                "https://sample-fertilizer-url.com"
        );

        // Insert the fertilizer into the database
        database.fertilizerDao().insert(fertilizer);

        // Retrieve the fertilizer by ID
        Fertilizers retrievedFertilizer = database.fertilizerDao().getAllFertilizers().get(0); // Assuming you have a method to get fertilizers by ID

        // Assert that the retrieved fertilizer matches the inserted fertilizer
        assertEquals("Sample Fertilizer", retrievedFertilizer.getName());
        assertEquals("Manufacturer En", retrievedFertilizer.getManufacturerEn());
        assertEquals("Manufacturer Vi", retrievedFertilizer.getManufacturerVi());
        assertEquals("Composition En", retrievedFertilizer.getCompositionEn());
        assertEquals("Composition Vi", retrievedFertilizer.getCompositionVi());
        assertEquals("Usage Instructions En", retrievedFertilizer.getUsageInstructionsEn());
        assertEquals("Usage Instructions Vi", retrievedFertilizer.getUsageInstructionsVi());
        assertEquals(250.0, retrievedFertilizer.getRecommendedUsage(), 0.001); // Use delta for double comparison
        assertEquals("https://sample-fertilizer-url.com", retrievedFertilizer.getFertImage());
    }

    @Test
    public void insertAndRetrieveStages() throws Exception {
        // Create a sample stage
        Stages stage = new Stages(
                "Sample Stage",
                "Stage Name Vi",
                1, // Order
                "Description En",
                "Description Vi",
                "https://sample-stage-url.com"
        );

        // Insert the stage into the database
        database.stageDao().insert(stage);

        // Retrieve the stage by ID
        Stages retrievedStage = database.stageDao().getStageById(1); // Assuming you have a method to get stages by ID

        // Assert that the retrieved stage matches the inserted stage
        assertEquals("Sample Stage", retrievedStage.getNameEn());
        assertEquals("Stage Name Vi", retrievedStage.getNameVi());
        assertEquals(1, retrievedStage.getOrder());
        assertEquals("Description En", retrievedStage.getDescriptionEn());
        assertEquals("Description Vi", retrievedStage.getDescriptionVi());
        assertEquals("https://sample-stage-url.com", retrievedStage.getStageImage());
    }

    @Test
    public void insertAndRetrieveActivities() throws Exception {
        // Create a sample stage
        Stages stage = new Stages(
                "Sample Stage",
                "Stage Name Vi",
                1, // Order
                "Description En",
                "Description Vi",
                "https://sample-stage-url.com"
        );

        // Insert the stage into the database
        database.stageDao().insert(stage);

        // Create a sample activity
        Activities activity = new Activities(
                1, // Assuming a valid stage ID
                "Sample Activity",
                "Activity Name Vi",
                "Description En",
                "Description Vi",
                3, // Duration
                "https://sample-activity-url.com"
        );

        // Insert the activity into the database
        database.activityDao().insert(activity);

        // Retrieve the activity by ID
        Activities retrievedActivity = database.activityDao().getActivityById(1); // Assuming you have a method to get activities by ID

        // Assert that the retrieved activity matches the inserted activity
        assertEquals("Sample Activity", retrievedActivity.getNameEn());
        assertEquals("Activity Name Vi", retrievedActivity.getNameVi());
        assertEquals("Description En", retrievedActivity.getDescriptionEn());
        assertEquals("Description Vi", retrievedActivity.getDescriptionVi());
        assertEquals(3, retrievedActivity.getDuration());
        assertEquals("https://sample-activity-url.com", retrievedActivity.getActivityImage());
    }

}
