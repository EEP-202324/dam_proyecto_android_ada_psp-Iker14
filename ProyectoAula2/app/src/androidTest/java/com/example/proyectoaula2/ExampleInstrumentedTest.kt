//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import androidx.compose.ui.test.onNodeWithTag
//import androidx.compose.ui.test.performClick
//import androidx.navigation.compose.test.ExperimentalTestApi
//import androidx.navigation.compose.test.assert
//import androidx.navigation.compose.test.currentBackStackEntryAsState
//import androidx.navigation.compose.test.hasDestination
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.example.proyectoaula2.MainActivity
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class NavigationTest {
//
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<MainActivity>()
//
//    @OptIn(ExperimentalTestApi::class)
//    @Test
//    fun navigateToHome() {
//        composeTestRule.onNodeWithTag("miBoton").performClick()
//
//        // Verifica que la vista superior es "home"
//        composeTestRule.navigationActions.currentBackStackEntryAsState().assert {
//            hasDestination("home")
//        }
//    }
//}