package com.example.todonotes.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todonotes.ui.theme.ui.theme.TodoNotesTheme

class NotesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   Note()
                }
            }
        }
    }
}
@Composable
fun Note() {
    var text1 by remember { mutableStateOf(value = "") }
    var text2 by remember { mutableStateOf(value = "") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(2.dp),
        horizontalAlignment = Alignment.Start
    ) {
        TextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            Modifier.fillMaxWidth(),
            textStyle = TextStyle(color = Color.Blue),
            placeholder = {
                Text(text = "Title")
            },
            singleLine = true
        )
        TextField(
            value = text2,
            onValueChange = {
                text2 = it
            },
            Modifier.fillMaxWidth(),
            textStyle = TextStyle(color = Color.Blue),
            placeholder = {
                Text(text = "Discription")
            },
            maxLines = 20

        )
        Column(
            modifier = Modifier
                .fillMaxSize().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

        ) {
            Button(onClick = { /*TODO*/ },
                Modifier.fillMaxWidth()) {
                Text(text = "Save")
            }
        }
    }
}
@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TodoNotesTheme {
        Greeting2("Android")
    }
}