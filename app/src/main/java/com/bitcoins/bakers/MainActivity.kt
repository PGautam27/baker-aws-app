package com.bitcoins.bakers

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bitcoins.bakers.presentation.itemScreen.itemViewModelFactory
import com.bitcoins.bakers.presentation.itemScreen.itemViewmodel
import com.bitcoins.bakers.presentation.screen.Screens
import com.bitcoins.bakers.ui.theme.BakersTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    
    private lateinit var itemViewmodel: itemViewmodel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        itemViewmodel = ViewModelProvider(
            this,
            itemViewModelFactory(application)
        )[itemViewmodel::class.java]
        
        setContent {
            BakersTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screens.FirstScreen.route){
                    composable(Screens.FirstScreen.route){
                        FirstScreen(itemViewmodel = itemViewmodel, onClick = {}) {
                            
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun FirstScreen(itemViewmodel: itemViewmodel,onClick : () -> Unit) {
    
    val coroutineScope = rememberCoroutineScope()
    val ok = itemViewmodel.works.observeAsState()
    if (ok.value!!){
        coroutineScope.launch { 
            onClick.invoke()
        }
    }
    
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { itemViewmodel.getItems() }) {
            Text(text = "Get Items")
        }
    }
}

@Composable
fun secondScreen(itemViewmodel: itemViewmodel) {
    val items = itemViewmodel.items.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
    }
}