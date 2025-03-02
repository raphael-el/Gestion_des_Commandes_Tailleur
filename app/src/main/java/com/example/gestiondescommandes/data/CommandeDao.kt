package com.example.gestiondescommandes.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CommandeDao {
    // Ajouter une commande
    @Insert
    suspend fun ajouterCommande(commande: Commande)

    // Rechercher des commandes par client ou par date de livraison
    @Query("SELECT * FROM commande_table WHERE client LIKE :search OR dateLivraison LIKE :search")
    suspend fun rechercherCommandes(search: String): List<Commande>

    // Obtenir toutes les commandes
    @Query("SELECT * FROM commande_table")
    suspend fun obtenirToutesCommandes(): List<Commande>

    // Mettre à jour le statut d'une commande
    @Query("UPDATE commande_table SET statut = :statut WHERE id = :id")
    suspend fun mettreAJourStatut(id: Long, statut: String)
}
