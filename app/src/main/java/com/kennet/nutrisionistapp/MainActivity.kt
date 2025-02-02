package com.kennet.nutrisionistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kennet.nutrisionistapp.presentation.theme.NutrisionistappTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutrisionistappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DashboardScreen(
                        innerPadding
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardScreen(innerPadding: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
        Card(modifier= Modifier.fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(text = "Panel de inicio", style = MaterialTheme.typography.titleLarge)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth() ,horizontalArrangement = Arrangement.SpaceBetween,) {
            AnimatedDashboardCard(title = "Próximas Citas", value = "5", icon = Icons.Default.DateRange)
            AnimatedDashboardCard(title = "Pacientes", value = "12", icon = Icons.Default.Person)
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Aquí iría el gráfico, usando una librería de gráficos
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.primary)) {
            // Placeholder del gráfico
            Text("Gráfico de Citas", modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedDashboardCard(title = "Inventario Crítico", value = "3 Productos", icon=Icons.Default.Warning,
            MaterialTheme.colorScheme.error)
    }
}

@Composable
fun DashboardCard(title: String, value: String, icon: ImageVector, colorIcon:Color ) {
    Card(
        modifier = Modifier.size(160.dp, 100.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = icon, contentDescription = title, tint = colorIcon)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, style = MaterialTheme.typography.titleSmall)
            Text(text = value, style = MaterialTheme.typography.titleMedium)
        }
    }
}
@Composable
fun AnimatedDashboardCard(title: String, value: String, icon: ImageVector, colorIcon: Color= MaterialTheme.colorScheme.primary) {
    val enterTransition = remember { fadeIn() + slideInHorizontally() }
    AnimatedVisibility(
        visible = true,
        enter = enterTransition
    ) {
        DashboardCard(title, value, icon, colorIcon)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NutrisionistappTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            DashboardScreen(
                innerPadding
            )
        }
    }
}