package bank.services;

import bank.person.Owner;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class JsonSerializationService {
    @Inject
    private Gson gson;

    public String serializeOwner(Owner owner) {
        return this.gson.toJson(owner);
    }

    public Owner deserializeOwner(String json) {
        return this.gson.fromJson(json, Owner.class);
    }
}
