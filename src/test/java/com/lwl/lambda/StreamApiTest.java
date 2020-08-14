package com.lwl.lambda;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwl.ipl.domain.Player;
import com.lwl.ipl.domain.Team;

public class StreamApiTest {

	private List<Team> teams;

	@BeforeEach
	void loadDataFromJSON() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			teams = mapper.readValue(StreamApiTest.class.getResourceAsStream("/ipl2020.json"),
					new TypeReference<List<Team>>() {
					});

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Test
	void showTeamNames() {
		List<String> teamNames = teams.stream().map(t -> t.getName()).collect(Collectors.toList());
		System.out.println(teamNames);

		// Get all the players

		List<Player> playersList = teams.stream().flatMap(t -> t.getPlayers().stream()).collect(Collectors.toList());
		System.out.println(playersList.size());

		// Get count of players in each team

		Map<String, Integer> playerCountMap = new HashMap<>();
	
		teams.stream().forEach(t->{
			playerCountMap.put(t.getLabel(),t.getPlayers().size());
		});

		playerCountMap.entrySet().forEach(e -> {
			System.out.println(e.getKey() + " " + e.getValue());
		});
		
		
		//
		
		double price = 2000000;
		
		
		long count= teams.stream().flatMap(t->t.getPlayers().stream()).filter(p->p.getPrice() == price).count();
		
		System.out.println(count);
		
		
		// List, Set, Map
		// Comparator, Comparable
		// Stream, map,filter,stream, flatMap, groupby, collect Lambda

	}

}
