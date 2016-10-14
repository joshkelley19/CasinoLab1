package io.zipcode.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.property.adapter.ReadOnlyJavaBeanPropertyBuilderHelper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.zipcode.Model.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by adam on 10/14/16.
 */
public class JSONHandler {

    // To save players
    public static void savePlayers(List<Player> players) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("players.json"), players);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Retrieve players
    public static List<Player> retrievePlayers() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Player> players = mapper.readValue(new File("players.json"), new TypeReference<List<Player>>(){});
            return players;
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
