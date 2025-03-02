package com.example.gestiondescommandes.data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "commande_table")
data class Commande(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val client: String,
    val typeVetement: String,
    val photoModele: String?, // Facultatif, peut être null si aucune photo
    val dateLivraison: Date,
    val statut: String, // "en cours" ou "terminé"
    val montant: Double,
    val paiementEffectue: Boolean
)
