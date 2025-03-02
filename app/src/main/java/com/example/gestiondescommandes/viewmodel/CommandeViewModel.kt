package com.example.gestiondescommandes.viewmodel

import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.gestiondescommandes.data.Commande
import com.example.gestiondescommandes.data.CommandeDatabase
import kotlinx.coroutines.launch

class CommandeViewModel(application: Context) : AndroidViewModel(application) {
    private val commandeDao = CommandeDatabase.getDatabase(application).commandeDao()

    // Ajouter une commande
    fun ajouterCommande(commande: Commande) {
        viewModelScope.launch {
            commandeDao.ajouterCommande(commande)
        }
    }

    // Rechercher des commandes par client ou date
    suspend fun rechercherCommandes(search: String) = commandeDao.rechercherCommandes(search)

    // Obtenir toutes les commandes
    suspend fun obtenirToutesCommandes() = commandeDao.obtenirToutesCommandes()

    // Mettre à jour le statut d'une commande
    fun mettreAJourStatut(id: Long, statut: String) {
        viewModelScope.launch {
            commandeDao.mettreAJourStatut(id, statut)
        }
    }
}
