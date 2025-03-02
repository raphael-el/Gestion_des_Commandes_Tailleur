package com.example.gestiondescommandes

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.gestiondescommandes.data.Commande
import com.example.gestiondescommandes.viewmodel.CommandeViewModel

@Composable
fun SuiviCommandesPage(navController: NavController) {
    val commandes = remember { mutableStateListOf<Commande>() }
    val viewModel = CommandeViewModel(navController.context.applicationContext)

    LaunchedEffect(true) {
        commandes.addAll(viewModel.obtenirToutesCommandes())
    }

    LazyColumn {
        items(commandes) { commande ->
            Text(text = "Client: ${commande.client}, Statut: ${commande.statut}")
        }
    }
}
