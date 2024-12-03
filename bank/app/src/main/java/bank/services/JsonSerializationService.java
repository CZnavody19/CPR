package bank.services;

import bank.person.Owner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class JsonSerializationService {
    @Inject
    private Gson gson;

    @Inject
    private DatabaseService db;

    public String serializeOwner(Owner owner) {
        return this.gson.toJson(owner);
    }

    public Owner deserializeOwner(String json) {
        return this.gson.fromJson(json, Owner.class);
    }

    public void serialize() throws IOException {
        String json = this.gson.toJson(db);
        // save json to file
        Files.write(json.getBytes(), Paths.get("db.json").toFile());
    }

    public void deserialize() throws IOException {
        File file = Paths.get("db.json").toFile();
        String json = Files.toString(file, java.nio.charset.StandardCharsets.UTF_8);
        db.set(this.gson.fromJson(json, DatabaseService.class));
    }
}
