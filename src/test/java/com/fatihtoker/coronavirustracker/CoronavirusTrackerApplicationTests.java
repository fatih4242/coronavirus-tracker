package com.fatihtoker.coronavirustracker;

import com.fatihtoker.coronavirustracker.models.LocationStats;
import com.fatihtoker.coronavirustracker.services.CoronaVirusDataService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CoronavirusTrackerApplicationTests {

	@Test
	void contextLoads() {
		CoronaVirusDataService coronaVirusDataService = new CoronaVirusDataService();
		List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int newCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		System.out.println(totalCases +"-"+ newCases);
	}

}
