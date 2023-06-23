package com.example.todonotes

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.todonotes.ui.theme.NotesActivity
import com.example.todonotes.ui.theme.TodoNotesTheme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoNotesTheme {
                RecyclerView()
            }
        }
    }
}

@Composable
fun ListItem(name: String) {


    Surface(
        color = colorResource(R.color.black_shade_2),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {

            Row {

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "First Note", style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold, color = colorResource(R.color.white)
                        )
                    )
                    Text(
                        text = name, color = colorResource(R.color.white)
                    )
                }

                IconButton(
                    onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete notes", tint =Color.White)

                }
            }


        }
    }

}


@Composable
fun RecyclerView(names: List<String> = List(1000) { "$it" }) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            val sdf = SimpleDateFormat("dd MMM,yyyy - HH:mm")
            val currentDate: String = sdf.format(Date())
            items(items = names) { name ->

                ListItem(name = currentDate)

            }
        }
        val mContext = LocalContext.current
        FloatingActionButton(
            onClick = { mContext.startActivity(Intent(mContext, NotesActivity::class.java)) },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add notes")

        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoNotesTheme() {
        RecyclerView()
    }
}