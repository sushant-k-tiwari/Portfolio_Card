package `in`.sushant.jetbizzcard

import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.sushant.jetbizzcard.ui.theme.JetBizzCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizzCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun createBizCard(){
    val buttonState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {

        }
        Column(modifier = Modifier.height(150.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            createProfileImage()

            Divider(modifier = Modifier.width(370.dp))

            createUserInfo()
            Button(
                onClick = {
                          buttonState.value = !buttonState.value
            }, modifier = Modifier
                    .padding(30.dp)
                    .size(150.dp, 50.dp)) {
                Text(text = "Portfolio",
                    style = MaterialTheme.typography.titleMedium)
            }
            if(buttonState.value){
                Content()
            }
            else{
                Box{}
            }
        }

    }
}

@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(15.dp),){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, Color.LightGray)) {

            Portfolio(data = listOf("Project 1", "Project 2", "Project 3", "Project 4", "Project 5"))
        }
    }
}


@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(7.dp))
                {
                    //createProfileImage(modifier = Modifier.size(10.dp))
                    Surface(
                        modifier = Modifier
                            .size(80.dp),
                        shape = CircleShape,
                        color = Color.White
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.profile_picutre),
                            contentDescription = "Profile Image",
                            modifier = Modifier.size(150.dp)
                        )
                    }

                    Column(modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)) {

                    Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Project to be added in the Portfolio",
                            style = MaterialTheme.typography.bodySmall)
                    }
                }

            }
        }
    }
}

@Composable
private fun createUserInfo() {
    Column(modifier = Modifier.padding(5.dp)) {

        Text(
            text = "Sushant Kumar Tiwari",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Android App Developer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = "@IIIT Manipur",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
private fun createProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(175.dp)
            .padding(15.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop,
        )

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizzCardTheme {
        createBizCard()
    }
}