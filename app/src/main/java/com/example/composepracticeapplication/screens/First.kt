package com.example.composepracticeapplication.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.composepracticeapplication.MainActivity
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun First(navController: NavHostController, mainActivity: MainActivity) {


    //Dialog
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = true },//if Click OutSide Of Dialog
            title = {
                Text(text = "Dialog Title")
            },
            text = {
                Text("This is a dialog message.")
            },

            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Dismiss")
                }
            }
        )
    }



    //BottomSheetDialog
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            // Sheet content
            Column {
                Text(text = "Your Content")
            }

        }
    }

    var showFullScreenDialog by remember { mutableStateOf(false) }
    if (showFullScreenDialog) {
        Dialog(onDismissRequest = { showFullScreenDialog = false }) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(16.dp),
                color = Color.LightGray
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(modifier = Modifier.align(Alignment.TopCenter),
                        text = "top")
                    Text("center")
                    Text(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        text = "bottom")
                }
            }
        }
    }

   Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier
       .fillMaxSize()
       .padding(10.dp)) {
     OutlinedButton(onClick = { showDialog=true


     }) {
         Text(text = "Dialog", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
     }


       OutlinedButton(onClick = { showBottomSheet=true }) {
           Text(text = "BottomSheetDialog", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
       }

       OutlinedButton(onClick = {showFullScreenDialog=true }) {
           Text(text = "FullScreenDialog", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
       }



   }


}