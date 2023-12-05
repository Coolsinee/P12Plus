package com.example.p12plus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.serpro69.kfaker.Faker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}

//@Composable
//fun CityItem(text: String) {
//    Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth().border(1.dp,color= Color.Black).padding(5.dp))
//}
//@Composable
//fun MyScreen() {
//    val faker = Faker()
//    val citiz = remember {
//        (1..100).map{ faker.address.city() }.toMutableStateList() //все прекрасно работает
//    }
//
//    LazyColumn(verticalArrangement = Arrangement.spacedBy(3.dp), contentPadding = PaddingValues(16.dp),modifier = Modifier.border(3.dp, Color.Gray).padding(10.dp)) {
//
//        items(citiz) { item ->
//            CityItem(text = item)
//        }
//    }
//}

//@Composable
//fun CityItem(text: String) {
//    Text(
//        text = text,
//        fontSize = 20.sp,
//        fontWeight = FontWeight.Bold,
//        modifier = Modifier
//            .fillMaxWidth()
//            .border(1.dp, Color.Black)
//            .padding(5.dp)
//    )
//}
//
//@Composable
//fun MyScreen() {
//    val faker = Faker()
//    val citiz = remember {
//        (1..100).map { faker.address.city() }.toMutableStateList()
//    }
//
//    LazyColumn(
//        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
//        verticalArrangement = Arrangement.spacedBy(3.dp),
//        modifier = Modifier
//            .border(3.dp, Color.Gray)
//            .padding(10.dp)
//    ) {
//        items(citiz) { item ->
//            CityItem(text = item)
//        }
//    }
//}

@Composable
fun CityItem(text: String, color: Color) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, color)
            .padding(5.dp)
    )
}

@Composable
fun MyScreen() {
    val faker = Faker()
    val citiz = remember {
        (1..100).map { faker.address.city() }.toMutableStateList()
    }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp),
        modifier = Modifier
            .border(3.dp, Color.Gray)
            .padding(10.dp)
    ) {
        itemsIndexed(citiz) { index, item ->
            val color = if (index % 2 == 0) Color.Red else Color.Blue
            CityItem(text = item, color = color)
        }
    }
}


