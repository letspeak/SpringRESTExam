package com.san.util;

import java.net.UnknownHostException;

import org.junit.AssumptionViolatedException;
import org.junit.rules.ExternalResource;
import org.springframework.data.util.Version;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBTestUtil extends ExternalResource{
	
	private String host = "localhost";
	private int port = 27017;

	private final Version minVersion;
	private final Version maxVersion;
	
	private Version currentVersion;
	
	public MongoDBTestUtil(Version min, Version max) {
		this.minVersion = min;
		this.maxVersion = max;
	}
	
	public static MongoDBTestUtil anyVersion() {
		return new MongoDBTestUtil(new Version(0, 0, 0), new Version(9999, 9999, 9999));
	}
	
	public MongoDBTestUtil serverRunningAt(String host, int port) {
		this.host = host;
		this.port = port;

		return this;
	}

	@Override
	protected void before() throws Throwable {

		initCurrentVersion();
	}

	private void initCurrentVersion() {

		if (currentVersion == null) {
			try {
				DB db = new MongoClient(host, port).getDB("test");
				CommandResult result = db.command(new BasicDBObjectBuilder().add("buildInfo", 1).get());
				this.currentVersion = Version.parse(result.get("version").toString());
			} catch (com.mongodb.MongoTimeoutException | UnknownHostException e) {
				throw new AssumptionViolatedException("Mongodb server is not running or not reachable.", e);
			}
		}
	}
}
