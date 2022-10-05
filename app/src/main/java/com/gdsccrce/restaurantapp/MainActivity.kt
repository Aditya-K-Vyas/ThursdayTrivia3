package com.gdsccrce.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdsccrce.restaurantapp.data.Datasource
import com.gdsccrce.restaurantapp.model.Restaurant
import com.gdsccrce.restaurantapp.ui.theme.RestaurantAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantApp()
        }
    }
}

@Composable
fun RestaurantApp() {
    RestaurantAppTheme {
        MyScreen()
    }
}

@Composable
fun MyScreen() {
    Column(modifier = Modifier.padding(10.dp)) {
        Spacer(modifier = Modifier.height(16.dp))

        SearchBar(modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(6.dp))
        RestaurantList(restaurantList = Datasource().loadRestaurants())
    }
}

@Composable
fun RestaurantList(modifier: Modifier = Modifier, restaurantList: List<Restaurant>) {
    LazyColumn(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
        items(restaurantList) { restaurant ->
            RestaurantCard(
                restaurant = Restaurant(
                    restaurant.stringResourceId,
                    restaurant.imageResourceId
                )
            )
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier, hint: String = "") {
    var text by remember {
        mutableStateOf("          Restaurant name or a dish ")
    }
    Box(modifier = Modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.padding(start = 8.dp)
            ) {

                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    maxLines = 1,
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(5.dp, CircleShape)
                        .background(
                            Color.White,
                            CircleShape
                        )
                        .padding(20.dp)
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.padding(
                        16.dp
                    )
                )
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .shadow(16.dp), elevation = 4.dp
    ) {
        Column() {
            Image(
                painter = painterResource(id = restaurant.imageResourceId),
                contentDescription = stringResource(id = restaurant.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = stringResource(id = restaurant.stringResourceId),
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "Tea, Beverages , Shakes",

                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.width(64.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(32.dp))
                    RatingDisplay(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .align(Alignment.End)
                    )
                    Text(
                        text = "$200 for one",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.End)
                    )
                }
            }
        }
    }
}

@Composable
fun RatingDisplay(modifier: Modifier = Modifier) {
    Surface(color = colorResource(id = R.color.rating_green), shape = RoundedCornerShape(8.dp)) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = "4.2", color = Color.White, fontWeight = FontWeight.Bold)
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "ratings",
                tint = Color.Yellow,
                )
        }
    }
}

//@Preview
@Composable
fun RestaurantCardPreview() {
    RestaurantCard(restaurant = Restaurant(R.string.imag_name1, R.drawable.rimage1))
}

//@Preview
@Composable
fun RatingDisplayPreview() {
    RatingDisplay()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RestaurantAppTheme {
        RestaurantApp()
    }
}