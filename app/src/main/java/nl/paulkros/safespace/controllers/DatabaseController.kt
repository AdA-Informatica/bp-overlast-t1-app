package nl.paulkros.safespace.controllers

import android.util.Log
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.bson.Document

class DatabaseController {
    private val uri = ConnectionString("mongodb://bpoverlast_01:G1jy9s9%253F@mongo.adainforma.tk:27017/?authSource=bpoverlast_01")

    private val client: MongoClient

    init {
        val settings = MongoClientSettings.builder().applyConnectionString(uri).build()
        client = MongoClients.create(settings)
        Log.d("kut", client.toString());
    }

    fun getGemeentes(): MongoCollection<Document> {
        val database = client.getDatabase("bpoverlast_01")
        val collection = database.getCollection("gemeentes");
        return collection;
    }

    fun insertUserInput(databaseController: DatabaseController, document: Document) {
        val collection = databaseController.client.getDatabase("bpoverlast_01").getCollection("UserInput")
        collection.insertOne(document)
    }

    fun close(){
        client.close();
    }

}