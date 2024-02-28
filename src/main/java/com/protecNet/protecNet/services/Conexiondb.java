
package com.protecNet.protecNet.services;


import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import com.mongodb.ConnectionString;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class Conexiondb {
    public static void main(String[] args) {
        
        String connectionString = "mongodb://localhost:27017"; 
        String nombreBaseDatos = "nombre_basedatos"; // 
        String usuario = "usuario"; // 
        String contraseña = "contraseña"; 

        
        ConnectionString connString = new ConnectionString(connectionString);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .credential(MongoCredential.createCredential(usuario, nombreBaseDatos, contraseña.toCharArray()))
                .build();

       
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            // Conectarse a la base de datos
            MongoDatabase database = mongoClient.getDatabase(nombreBaseDatos);
            System.out.println("Conexión exitosa a la base de datos MongoDB");

            // Trabajar con la base de datos...

        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos MongoDB: " + e.getMessage());
        }
    }
}

