package com.example.gestiondescommandes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gestiondescommandes.data.Commande
import com.example.gestiondescommandes.viewmodel.CommandeViewModel
import java.util.Date

@Composable
fun AjouterCommandePage(navController: NavController) {
    // Définition de l'état des champs de saisie
    var client by remember { mutableStateOf("") }
    var typeVetement by remember { mutableStateOf("") }
    var dateLivraison by remember { mutableStateOf("") }
    var montant by remember { mutableStateOf("") }
    var paiementEffectue by remember { mutableStateOf(false) }

    // Obtenir une instance du ViewModel
    val commandeViewModel: CommandeViewModel = viewModel()

    Column(modifier = Modifier.padding(16.dp)) {
        // Champ de saisie pour le client
        TextField(value = client, onValueChange = { client = it }, label = { Text("Client") })
        Spacer(modifier = Modifier.height(8.dp))

        // Champ de saisie pour le type de vêtement
        TextField(value = typeVetement, onValueChange = { typeVetement = it }, label = { Text("Type de vêtement") })
        Spacer(modifier = Modifier.height(8.dp))

        // Champ de saisie pour la date de livraison
        TextField(value = dateLivraison, onValueChange = { dateLivraison = it }, label = { Text("Date de livraison") })
        Spacer(modifier = Modifier.height(8.dp))

        // Champ de saisie pour le montant
        TextField(value = montant, onValueChange = { montant = it }, label = { Text("Montant") })
        Spacer(modifier = Modifier.height(8.dp))

        // Checkbox pour indiquer si le paiement a été effectué
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = paiementEffectue, onCheckedChange = { paiementEffectue = it })
            Spacer(modifier = Modifier.width(8.dp))
            Text("Paiement effectué")
        }

        // Bouton pour ajouter la commande
        Button(
            onClick = {
                // Crée une instance de commande avec les données
                val commande = Commande(
                    client = client,
                    typeVetement = typeVetement,
                    photoModele = null, // À gérer selon votre logique d'image
                    dateLivraison = Date(), // Utilise la date actuelle pour la livraison
                    statut = "en cours", // Par défaut, commande en cours
                    montant = montant.toDoubleOrNull() ?: 0.0, // Sécuriser la conversion du montant
                    paiementEffectue = paiementEffectue
                )

                // Ajouter la commande via le ViewModel
                commandeViewModel.ajouterCommande(commande)

                // Naviguer vers la page d'accueil après l'ajout
                navController.navigate("accueil")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Ajouter la commande")
        }
    }
}
