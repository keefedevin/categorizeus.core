package us.categorize.model;

import java.util.UUID;

/*
 From Late Latin ēns (“thing”), from esse (“to be”). See entity. 
 Entity creates a bunch of confusion with already defined classes, especially in JPA
 sounds kind of pretentious but whatever
 * */
public class Ens {
	private final UUID uuid;
	private final long ts;
	public UUID getUuid() {
		return uuid;
	}
	public long getTs() {
		return ts;
	}
	public Ens() {
		uuid = UUID.randomUUID();
		ts = System.currentTimeMillis();
	}
	public Ens(UUID uuid, long ts) {
		this.ts = ts;
		this.uuid = uuid;
	}
}
