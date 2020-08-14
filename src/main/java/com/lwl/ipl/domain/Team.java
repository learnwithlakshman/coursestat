package com.lwl.ipl.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {

		private String city;
		private String coach;
		private String home;
		private String label;
		private String name;
		private List<Player> players;
}
