package com.hunter.ricegrow.PesticideCalculating;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static com.hunter.ricegrow.Activity.Calculating.PesticideCalculating.PesticideCalculate.PESTICIDE_CALCULATE_KEY;

import android.content.Context;
import android.content.Intent;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import com.hunter.ricegrow.Activity.Calculating.PesticideCalculating.PesticideCalculate;
import com.hunter.ricegrow.DatabaseFiles.Model.Pesticides;
import com.hunter.ricegrow.R;

import org.junit.Before;
import org.junit.Test;

public class PesticideCalculateTest {
    @Before
    public void launchActivity() {
        // Launch the activity with an intent
        Context context = ApplicationProvider.getApplicationContext();
        Pesticides pesticide = new Pesticides("Dupont™ Pexena™ 106SC", "Syngenta", "Triflumezopyrim (min 94%) : 106 g/l", "Insecticide", "Thuốc trừ sâu", "Dosage: 300 ml/ha\n\n" +
                "Quarantine period (PreHarvest Interval- PHI): 21 days (Duration in days from last handling to harvest)\n\n" +
                "Usage: The amount of water sprayed is 400-500 L/ha. Spray once when 1-2 year old planthoppers appear on the rice field.",
                "Liều lượng: 300 ml/ha\n\n" +
                        "Thời gian kiểm dịch (Khoảng thời gian trước khi thu hoạch- PHI): 21 ngày (Thời gian tính bằng ngày từ lần xử lý cuối cùng đến khi thu hoạch)\n\n" +
                        "Cách dùng: Lượng nước phun 400-500 L/ha. Phun 1 lần khi rầy tuổi 1-2 xuất hiện trên ruộng.",
                10, 450, "https://firebasestorage.googleapis.com/v0/b/ricegrow-a469b.appspot.com/o/pesticides%2Fpexena.jpg?alt=media&token=19be8599-52d5-413e-90ad-b9e5226a0141");
        Intent intent = new Intent(context, PesticideCalculate.class);
        intent.putExtra(PESTICIDE_CALCULATE_KEY, pesticide);
        // Add any necessary extras to the intent
        ActivityScenario.launch(intent);
    }

    @Test
    public void testCalculatePesticide() {
        // Perform actions and assertions here to test the activity
        // For example, entering text and clicking buttons
        Espresso.onView(ViewMatchers.withId(R.id.fieldAreaEditText))
                .perform(ViewActions.typeText("2"), closeSoftKeyboard()); // Enter a value for field area
        Espresso.onView(ViewMatchers.withId(R.id.btnCalculating)).perform(scrollTo()).perform(ViewActions.click()); // Click the calculate button

        // Add assertions to verify the results
        Espresso.onView(ViewMatchers.withId(R.id.txtTotalAmount))
                .check(ViewAssertions.matches(ViewMatchers.withText("0.56 liters (or kg)")));
    }
}
